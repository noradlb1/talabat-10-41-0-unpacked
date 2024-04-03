package com.google.android.exoplayer2.extractor.ts;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H265Reader implements ElementaryStreamReader {
    private static final int AUD_NUT = 35;
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs = C.TIME_UNSET;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(34, 128);
    private final boolean[] prefixFlags = new boolean[3];
    private final NalUnitTargetBuffer prefixSei = new NalUnitTargetBuffer(39, 128);
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer suffixSei = new NalUnitTargetBuffer(40, 128);
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps = new NalUnitTargetBuffer(32, 128);

    public static final class SampleReader {
        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean isFirstPrefixNalUnit;
        private boolean isFirstSlice;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitPosition;
        private long nalUnitTimeUs;
        private final TrackOutput output;
        private boolean readingPrefix;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;

        public SampleReader(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        private static boolean isPrefixNalUnit(int i11) {
            return (32 <= i11 && i11 <= 35) || i11 == 39;
        }

        private static boolean isVclBodyNalUnit(int i11) {
            return i11 < 32 || i11 == 40;
        }

        private void outputSample(int i11) {
            long j11 = this.sampleTimeUs;
            if (j11 != C.TIME_UNSET) {
                boolean z11 = this.sampleIsKeyframe;
                this.output.sampleMetadata(j11, z11 ? 1 : 0, (int) (this.nalUnitPosition - this.samplePosition), i11, (TrackOutput.CryptoData) null);
            }
        }

        public void endNalUnit(long j11, int i11, boolean z11) {
            if (this.readingPrefix && this.isFirstSlice) {
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.readingPrefix = false;
            } else if (this.isFirstPrefixNalUnit || this.isFirstSlice) {
                if (z11 && this.readingSample) {
                    outputSample(i11 + ((int) (j11 - this.nalUnitPosition)));
                }
                this.samplePosition = this.nalUnitPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.readingSample = true;
            }
        }

        public void readNalUnitData(byte[] bArr, int i11, int i12) {
            boolean z11;
            if (this.lookingForFirstSliceFlag) {
                int i13 = this.nalUnitBytesRead;
                int i14 = (i11 + 2) - i13;
                if (i14 < i12) {
                    if ((bArr[i14] & 128) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.isFirstSlice = z11;
                    this.lookingForFirstSliceFlag = false;
                    return;
                }
                this.nalUnitBytesRead = i13 + (i12 - i11);
            }
        }

        public void reset() {
            this.lookingForFirstSliceFlag = false;
            this.isFirstSlice = false;
            this.isFirstPrefixNalUnit = false;
            this.readingSample = false;
            this.readingPrefix = false;
        }

        public void startNalUnit(long j11, int i11, int i12, long j12, boolean z11) {
            boolean z12;
            boolean z13 = false;
            this.isFirstSlice = false;
            this.isFirstPrefixNalUnit = false;
            this.nalUnitTimeUs = j12;
            this.nalUnitBytesRead = 0;
            this.nalUnitPosition = j11;
            if (!isVclBodyNalUnit(i12)) {
                if (this.readingSample && !this.readingPrefix) {
                    if (z11) {
                        outputSample(i11);
                    }
                    this.readingSample = false;
                }
                if (isPrefixNalUnit(i12)) {
                    this.isFirstPrefixNalUnit = !this.readingPrefix;
                    this.readingPrefix = true;
                }
            }
            if (i12 < 16 || i12 > 21) {
                z12 = false;
            } else {
                z12 = true;
            }
            this.nalUnitHasKeyframeData = z12;
            if (z12 || i12 <= 9) {
                z13 = true;
            }
            this.lookingForFirstSliceFlag = z13;
        }
    }

    public H265Reader(SeiReader seiReader2) {
        this.seiReader = seiReader2;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void assertTracksCreated() {
        Assertions.checkStateNotNull(this.output);
        Util.castNonNull(this.sampleReader);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void endNalUnit(long j11, int i11, int i12, long j12) {
        this.sampleReader.endNalUnit(j11, i11, this.hasOutputFormat);
        if (!this.hasOutputFormat) {
            this.vps.endNalUnit(i12);
            this.sps.endNalUnit(i12);
            this.pps.endNalUnit(i12);
            if (this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                this.hasOutputFormat = true;
            }
        }
        if (this.prefixSei.endNalUnit(i12)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.prefixSei;
            this.seiWrapper.reset(this.prefixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j12, this.seiWrapper);
        }
        if (this.suffixSei.endNalUnit(i12)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.suffixSei;
            this.seiWrapper.reset(this.suffixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j12, this.seiWrapper);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void nalUnitData(byte[] bArr, int i11, int i12) {
        this.sampleReader.readNalUnitData(bArr, i11, i12);
        if (!this.hasOutputFormat) {
            this.vps.appendToNalUnit(bArr, i11, i12);
            this.sps.appendToNalUnit(bArr, i11, i12);
            this.pps.appendToNalUnit(bArr, i11, i12);
        }
        this.prefixSei.appendToNalUnit(bArr, i11, i12);
        this.suffixSei.appendToNalUnit(bArr, i11, i12);
    }

    private static Format parseMediaFormat(@Nullable String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        int i11 = nalUnitTargetBuffer.nalLength;
        byte[] bArr = new byte[(nalUnitTargetBuffer2.nalLength + i11 + nalUnitTargetBuffer3.nalLength)];
        System.arraycopy(nalUnitTargetBuffer.nalData, 0, bArr, 0, i11);
        System.arraycopy(nalUnitTargetBuffer2.nalData, 0, bArr, nalUnitTargetBuffer.nalLength, nalUnitTargetBuffer2.nalLength);
        System.arraycopy(nalUnitTargetBuffer3.nalData, 0, bArr, nalUnitTargetBuffer.nalLength + nalUnitTargetBuffer2.nalLength, nalUnitTargetBuffer3.nalLength);
        NalUnitUtil.H265SpsData parseH265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(nalUnitTargetBuffer2.nalData, 3, nalUnitTargetBuffer2.nalLength);
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.VIDEO_H265).setCodecs(CodecSpecificDataUtil.buildHevcCodecString(parseH265SpsNalUnit.generalProfileSpace, parseH265SpsNalUnit.generalTierFlag, parseH265SpsNalUnit.generalProfileIdc, parseH265SpsNalUnit.generalProfileCompatibilityFlags, parseH265SpsNalUnit.constraintBytes, parseH265SpsNalUnit.generalLevelIdc)).setWidth(parseH265SpsNalUnit.width).setHeight(parseH265SpsNalUnit.height).setPixelWidthHeightRatio(parseH265SpsNalUnit.pixelWidthHeightRatio).setInitializationData(Collections.singletonList(bArr)).build();
    }

    @RequiresNonNull({"sampleReader"})
    private void startNalUnit(long j11, int i11, int i12, long j12) {
        this.sampleReader.startNalUnit(j11, i11, i12, j12, this.hasOutputFormat);
        if (!this.hasOutputFormat) {
            this.vps.startNalUnit(i12);
            this.sps.startNalUnit(i12);
            this.pps.startNalUnit(i12);
        }
        this.prefixSei.startNalUnit(i12);
        this.suffixSei.startNalUnit(i12);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        int i11;
        assertTracksCreated();
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] data = parsableByteArray.getData();
            this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (true) {
                if (position < limit) {
                    int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.prefixFlags);
                    if (findNalUnit == limit) {
                        nalUnitData(data, position, limit);
                        return;
                    }
                    int h265NalUnitType = NalUnitUtil.getH265NalUnitType(data, findNalUnit);
                    int i12 = findNalUnit - position;
                    if (i12 > 0) {
                        nalUnitData(data, position, findNalUnit);
                    }
                    int i13 = limit - findNalUnit;
                    long j11 = this.totalBytesWritten - ((long) i13);
                    if (i12 < 0) {
                        i11 = -i12;
                    } else {
                        i11 = 0;
                    }
                    long j12 = j11;
                    int i14 = i13;
                    endNalUnit(j12, i14, i11, this.pesTimeUs);
                    startNalUnit(j12, i14, h265NalUnitType, this.pesTimeUs);
                    position = findNalUnit + 3;
                }
            }
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = track;
        this.sampleReader = new SampleReader(track);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    public void packetFinished() {
    }

    public void packetStarted(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.pesTimeUs = j11;
        }
    }

    public void seek() {
        this.totalBytesWritten = 0;
        this.pesTimeUs = C.TIME_UNSET;
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        SampleReader sampleReader2 = this.sampleReader;
        if (sampleReader2 != null) {
            sampleReader2.reset();
        }
    }
}
