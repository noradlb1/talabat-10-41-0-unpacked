package com.google.android.exoplayer2.extractor.wav;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.WavUtil;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import java.io.IOException;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.jar.asm.Opcodes;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import u7.a;

public final class WavExtractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new a();
    private static final int STATE_READING_FILE_TYPE = 0;
    private static final int STATE_READING_FORMAT = 2;
    private static final int STATE_READING_RF64_SAMPLE_DATA_SIZE = 1;
    private static final int STATE_READING_SAMPLE_DATA = 4;
    private static final int STATE_SKIPPING_TO_SAMPLE_DATA = 3;
    private static final String TAG = "WavExtractor";
    private static final int TARGET_SAMPLES_PER_SECOND = 10;
    private long dataEndPosition = -1;
    private int dataStartPosition = -1;
    private ExtractorOutput extractorOutput;
    private OutputWriter outputWriter;
    private long rf64SampleDataSize = -1;
    private int state = 0;
    private TrackOutput trackOutput;

    public static final class ImaAdPcmOutputWriter implements OutputWriter {
        private static final int[] INDEX_TABLE = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] STEP_TABLE = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, Opcodes.D2L, Opcodes.IFGT, Opcodes.LRETURN, 190, 209, 230, 253, 279, 307, 337, 371, ErrorCode.HTTP_CLIENT_TIMEOUT, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, Advice.MethodSizeHandler.UNDEFINED_SIZE};
        private final ParsableByteArray decodedData;
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private final int framesPerBlock;
        private final byte[] inputData;
        private long outputFrameCount;
        private int pendingInputBytes;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeFrames;
        private final TrackOutput trackOutput;
        private final WavFormat wavFormat;

        public ImaAdPcmOutputWriter(ExtractorOutput extractorOutput2, TrackOutput trackOutput2, WavFormat wavFormat2) throws ParserException {
            this.extractorOutput = extractorOutput2;
            this.trackOutput = trackOutput2;
            this.wavFormat = wavFormat2;
            int max = Math.max(1, wavFormat2.frameRateHz / 10);
            this.targetSampleSizeFrames = max;
            ParsableByteArray parsableByteArray = new ParsableByteArray(wavFormat2.extraData);
            parsableByteArray.readLittleEndianUnsignedShort();
            int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
            this.framesPerBlock = readLittleEndianUnsignedShort;
            int i11 = wavFormat2.numChannels;
            int i12 = (((wavFormat2.blockSize - (i11 * 4)) * 8) / (wavFormat2.bitsPerSample * i11)) + 1;
            if (readLittleEndianUnsignedShort == i12) {
                int ceilDivide = Util.ceilDivide(max, readLittleEndianUnsignedShort);
                this.inputData = new byte[(wavFormat2.blockSize * ceilDivide)];
                this.decodedData = new ParsableByteArray(ceilDivide * numOutputFramesToBytes(readLittleEndianUnsignedShort, i11));
                int i13 = ((wavFormat2.frameRateHz * wavFormat2.blockSize) * 8) / readLittleEndianUnsignedShort;
                this.format = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setAverageBitrate(i13).setPeakBitrate(i13).setMaxInputSize(numOutputFramesToBytes(max, i11)).setChannelCount(wavFormat2.numChannels).setSampleRate(wavFormat2.frameRateHz).setPcmEncoding(2).build();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected frames per block: " + i12 + "; got: " + readLittleEndianUnsignedShort, (Throwable) null);
        }

        private void decode(byte[] bArr, int i11, ParsableByteArray parsableByteArray) {
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < this.wavFormat.numChannels; i13++) {
                    decodeBlockForChannel(bArr, i12, i13, parsableByteArray.getData());
                }
            }
            int numOutputFramesToBytes = numOutputFramesToBytes(this.framesPerBlock * i11);
            parsableByteArray.setPosition(0);
            parsableByteArray.setLimit(numOutputFramesToBytes);
        }

        private void decodeBlockForChannel(byte[] bArr, int i11, int i12, byte[] bArr2) {
            int i13;
            WavFormat wavFormat2 = this.wavFormat;
            int i14 = wavFormat2.blockSize;
            int i15 = wavFormat2.numChannels;
            int i16 = (i11 * i14) + (i12 * 4);
            int i17 = (i15 * 4) + i16;
            int i18 = (i14 / i15) - 4;
            int i19 = (short) (((bArr[i16 + 1] & 255) << 8) | (bArr[i16] & 255));
            int min = Math.min(bArr[i16 + 2] & 255, 88);
            int i21 = STEP_TABLE[min];
            int i22 = ((i11 * this.framesPerBlock * i15) + i12) * 2;
            bArr2[i22] = (byte) (i19 & 255);
            bArr2[i22 + 1] = (byte) (i19 >> 8);
            for (int i23 = 0; i23 < i18 * 2; i23++) {
                byte b11 = bArr[((i23 / 8) * i15 * 4) + i17 + ((i23 / 2) % 4)] & 255;
                if (i23 % 2 == 0) {
                    i13 = b11 & Ascii.SI;
                } else {
                    i13 = b11 >> 4;
                }
                int i24 = ((((i13 & 7) * 2) + 1) * i21) >> 3;
                if ((i13 & 8) != 0) {
                    i24 = -i24;
                }
                i19 = Util.constrainValue(i19 + i24, -32768, (int) Advice.MethodSizeHandler.UNDEFINED_SIZE);
                i22 += i15 * 2;
                bArr2[i22] = (byte) (i19 & 255);
                bArr2[i22 + 1] = (byte) (i19 >> 8);
                int i25 = min + INDEX_TABLE[i13];
                int[] iArr = STEP_TABLE;
                min = Util.constrainValue(i25, 0, iArr.length - 1);
                i21 = iArr[min];
            }
        }

        private int numOutputBytesToFrames(int i11) {
            return i11 / (this.wavFormat.numChannels * 2);
        }

        private int numOutputFramesToBytes(int i11) {
            return numOutputFramesToBytes(i11, this.wavFormat.numChannels);
        }

        private static int numOutputFramesToBytes(int i11, int i12) {
            return i11 * 2 * i12;
        }

        private void writeSampleMetadata(int i11) {
            long scaleLargeTimestamp = this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000, (long) this.wavFormat.frameRateHz);
            int numOutputFramesToBytes = numOutputFramesToBytes(i11);
            this.trackOutput.sampleMetadata(scaleLargeTimestamp, 1, numOutputFramesToBytes, this.pendingOutputBytes - numOutputFramesToBytes, (TrackOutput.CryptoData) null);
            this.outputFrameCount += (long) i11;
            this.pendingOutputBytes -= numOutputFramesToBytes;
        }

        public void init(int i11, long j11) {
            this.extractorOutput.seekMap(new WavSeekMap(this.wavFormat, this.framesPerBlock, (long) i11, j11));
            this.trackOutput.format(this.format);
        }

        public void reset(long j11) {
            this.pendingInputBytes = 0;
            this.startTimeUs = j11;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0047  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003e A[EDGE_INSN: B:22:0x003e->B:10:0x003e ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0020  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean sampleData(com.google.android.exoplayer2.extractor.ExtractorInput r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.targetSampleSizeFrames
                int r1 = r6.pendingOutputBytes
                int r1 = r6.numOutputBytesToFrames(r1)
                int r0 = r0 - r1
                int r1 = r6.framesPerBlock
                int r0 = com.google.android.exoplayer2.util.Util.ceilDivide((int) r0, (int) r1)
                com.google.android.exoplayer2.extractor.wav.WavFormat r1 = r6.wavFormat
                int r1 = r1.blockSize
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L_0x001d
            L_0x001b:
                r1 = r2
                goto L_0x001e
            L_0x001d:
                r1 = 0
            L_0x001e:
                if (r1 != 0) goto L_0x003e
                int r3 = r6.pendingInputBytes
                if (r3 >= r0) goto L_0x003e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.inputData
                int r5 = r6.pendingInputBytes
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L_0x0038
                goto L_0x001b
            L_0x0038:
                int r4 = r6.pendingInputBytes
                int r4 = r4 + r3
                r6.pendingInputBytes = r4
                goto L_0x001e
            L_0x003e:
                int r7 = r6.pendingInputBytes
                com.google.android.exoplayer2.extractor.wav.WavFormat r8 = r6.wavFormat
                int r8 = r8.blockSize
                int r7 = r7 / r8
                if (r7 <= 0) goto L_0x0075
                byte[] r8 = r6.inputData
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.decodedData
                r6.decode(r8, r7, r9)
                int r8 = r6.pendingInputBytes
                com.google.android.exoplayer2.extractor.wav.WavFormat r9 = r6.wavFormat
                int r9 = r9.blockSize
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.pendingInputBytes = r8
                com.google.android.exoplayer2.util.ParsableByteArray r7 = r6.decodedData
                int r7 = r7.limit()
                com.google.android.exoplayer2.extractor.TrackOutput r8 = r6.trackOutput
                com.google.android.exoplayer2.util.ParsableByteArray r9 = r6.decodedData
                r8.sampleData(r9, r7)
                int r8 = r6.pendingOutputBytes
                int r8 = r8 + r7
                r6.pendingOutputBytes = r8
                int r7 = r6.numOutputBytesToFrames(r8)
                int r8 = r6.targetSampleSizeFrames
                if (r7 < r8) goto L_0x0075
                r6.writeSampleMetadata(r8)
            L_0x0075:
                if (r1 == 0) goto L_0x0082
                int r7 = r6.pendingOutputBytes
                int r7 = r6.numOutputBytesToFrames(r7)
                if (r7 <= 0) goto L_0x0082
                r6.writeSampleMetadata(r7)
            L_0x0082:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.wav.WavExtractor.ImaAdPcmOutputWriter.sampleData(com.google.android.exoplayer2.extractor.ExtractorInput, long):boolean");
        }
    }

    public interface OutputWriter {
        void init(int i11, long j11) throws ParserException;

        void reset(long j11);

        boolean sampleData(ExtractorInput extractorInput, long j11) throws IOException;
    }

    public static final class PassthroughOutputWriter implements OutputWriter {
        private final ExtractorOutput extractorOutput;
        private final Format format;
        private long outputFrameCount;
        private int pendingOutputBytes;
        private long startTimeUs;
        private final int targetSampleSizeBytes;
        private final TrackOutput trackOutput;
        private final WavFormat wavFormat;

        public PassthroughOutputWriter(ExtractorOutput extractorOutput2, TrackOutput trackOutput2, WavFormat wavFormat2, String str, int i11) throws ParserException {
            this.extractorOutput = extractorOutput2;
            this.trackOutput = trackOutput2;
            this.wavFormat = wavFormat2;
            int i12 = (wavFormat2.numChannels * wavFormat2.bitsPerSample) / 8;
            if (wavFormat2.blockSize == i12) {
                int i13 = wavFormat2.frameRateHz;
                int i14 = i13 * i12 * 8;
                int max = Math.max(i12, (i13 * i12) / 10);
                this.targetSampleSizeBytes = max;
                this.format = new Format.Builder().setSampleMimeType(str).setAverageBitrate(i14).setPeakBitrate(i14).setMaxInputSize(max).setChannelCount(wavFormat2.numChannels).setSampleRate(wavFormat2.frameRateHz).setPcmEncoding(i11).build();
                return;
            }
            throw ParserException.createForMalformedContainer("Expected block size: " + i12 + "; got: " + wavFormat2.blockSize, (Throwable) null);
        }

        public void init(int i11, long j11) {
            this.extractorOutput.seekMap(new WavSeekMap(this.wavFormat, 1, (long) i11, j11));
            this.trackOutput.format(this.format);
        }

        public void reset(long j11) {
            this.startTimeUs = j11;
            this.pendingOutputBytes = 0;
            this.outputFrameCount = 0;
        }

        public boolean sampleData(ExtractorInput extractorInput, long j11) throws IOException {
            int i11;
            int i12;
            int i13;
            long j12 = j11;
            while (true) {
                i11 = (j12 > 0 ? 1 : (j12 == 0 ? 0 : -1));
                if (i11 <= 0 || (i12 = this.pendingOutputBytes) >= (i13 = this.targetSampleSizeBytes)) {
                    WavFormat wavFormat2 = this.wavFormat;
                    int i14 = wavFormat2.blockSize;
                    int i15 = this.pendingOutputBytes / i14;
                } else {
                    int sampleData = this.trackOutput.sampleData((DataReader) extractorInput, (int) Math.min((long) (i13 - i12), j12), true);
                    if (sampleData == -1) {
                        j12 = 0;
                    } else {
                        this.pendingOutputBytes += sampleData;
                        j12 -= (long) sampleData;
                    }
                }
            }
            WavFormat wavFormat22 = this.wavFormat;
            int i142 = wavFormat22.blockSize;
            int i152 = this.pendingOutputBytes / i142;
            if (i152 > 0) {
                int i16 = i152 * i142;
                int i17 = this.pendingOutputBytes - i16;
                this.trackOutput.sampleMetadata(this.startTimeUs + Util.scaleLargeTimestamp(this.outputFrameCount, 1000000, (long) wavFormat22.frameRateHz), 1, i16, i17, (TrackOutput.CryptoData) null);
                this.outputFrameCount += (long) i152;
                this.pendingOutputBytes = i17;
            }
            if (i11 <= 0) {
                return true;
            }
            return false;
        }
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.trackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new WavExtractor()};
    }

    private void readFileType(ExtractorInput extractorInput) throws IOException {
        boolean z11;
        if (extractorInput.getPosition() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        int i11 = this.dataStartPosition;
        if (i11 != -1) {
            extractorInput.skipFully(i11);
            this.state = 4;
        } else if (WavHeaderReader.checkFileType(extractorInput)) {
            extractorInput.skipFully((int) (extractorInput.getPeekPosition() - extractorInput.getPosition()));
            this.state = 1;
        } else {
            throw ParserException.createForMalformedContainer("Unsupported or unrecognized wav file type.", (Throwable) null);
        }
    }

    @RequiresNonNull({"extractorOutput", "trackOutput"})
    private void readFormat(ExtractorInput extractorInput) throws IOException {
        WavFormat readFormat = WavHeaderReader.readFormat(extractorInput);
        int i11 = readFormat.formatType;
        if (i11 == 17) {
            this.outputWriter = new ImaAdPcmOutputWriter(this.extractorOutput, this.trackOutput, readFormat);
        } else if (i11 == 6) {
            this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, readFormat, MimeTypes.AUDIO_ALAW, -1);
        } else if (i11 == 7) {
            this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, readFormat, MimeTypes.AUDIO_MLAW, -1);
        } else {
            int pcmEncodingForType = WavUtil.getPcmEncodingForType(i11, readFormat.bitsPerSample);
            if (pcmEncodingForType != 0) {
                this.outputWriter = new PassthroughOutputWriter(this.extractorOutput, this.trackOutput, readFormat, MimeTypes.AUDIO_RAW, pcmEncodingForType);
            } else {
                throw ParserException.createForUnsupportedContainerFeature("Unsupported WAV format type: " + readFormat.formatType);
            }
        }
        this.state = 3;
    }

    private void readRf64SampleDataSize(ExtractorInput extractorInput) throws IOException {
        this.rf64SampleDataSize = WavHeaderReader.readRf64SampleDataSize(extractorInput);
        this.state = 2;
    }

    private int readSampleData(ExtractorInput extractorInput) throws IOException {
        boolean z11;
        if (this.dataEndPosition != -1) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        if (((OutputWriter) Assertions.checkNotNull(this.outputWriter)).sampleData(extractorInput, this.dataEndPosition - extractorInput.getPosition())) {
            return -1;
        }
        return 0;
    }

    private void skipToSampleData(ExtractorInput extractorInput) throws IOException {
        Pair<Long, Long> skipToSampleData = WavHeaderReader.skipToSampleData(extractorInput);
        this.dataStartPosition = ((Long) skipToSampleData.first).intValue();
        long longValue = ((Long) skipToSampleData.second).longValue();
        long j11 = this.rf64SampleDataSize;
        if (j11 != -1 && longValue == 4294967295L) {
            longValue = j11;
        }
        this.dataEndPosition = ((long) this.dataStartPosition) + longValue;
        long length = extractorInput.getLength();
        if (length != -1 && this.dataEndPosition > length) {
            Log.w(TAG, "Data exceeds input length: " + this.dataEndPosition + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + length);
            this.dataEndPosition = length;
        }
        ((OutputWriter) Assertions.checkNotNull(this.outputWriter)).init(this.dataStartPosition, this.dataEndPosition);
        this.state = 4;
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        this.trackOutput = extractorOutput2.track(0, 1);
        extractorOutput2.endTracks();
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        int i11 = this.state;
        if (i11 == 0) {
            readFileType(extractorInput);
            return 0;
        } else if (i11 == 1) {
            readRf64SampleDataSize(extractorInput);
            return 0;
        } else if (i11 == 2) {
            readFormat(extractorInput);
            return 0;
        } else if (i11 == 3) {
            skipToSampleData(extractorInput);
            return 0;
        } else if (i11 == 4) {
            return readSampleData(extractorInput);
        } else {
            throw new IllegalStateException();
        }
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        int i11;
        if (j11 == 0) {
            i11 = 0;
        } else {
            i11 = 4;
        }
        this.state = i11;
        OutputWriter outputWriter2 = this.outputWriter;
        if (outputWriter2 != null) {
            outputWriter2.reset(j12);
        }
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return WavHeaderReader.checkFileType(extractorInput);
    }
}
