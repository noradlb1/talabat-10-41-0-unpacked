package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import t7.e;

public final class TsExtractor implements Extractor {
    private static final long AC3_FORMAT_IDENTIFIER = 1094921523;
    private static final long AC4_FORMAT_IDENTIFIER = 1094921524;
    private static final int BUFFER_SIZE = 9400;
    public static final int DEFAULT_TIMESTAMP_SEARCH_BYTES = 112800;
    private static final long E_AC3_FORMAT_IDENTIFIER = 1161904947;
    public static final ExtractorsFactory FACTORY = new e();
    private static final long HEVC_FORMAT_IDENTIFIER = 1212503619;
    private static final int MAX_PID_PLUS_ONE = 8192;
    public static final int MODE_HLS = 2;
    public static final int MODE_MULTI_PMT = 0;
    public static final int MODE_SINGLE_PMT = 1;
    private static final int SNIFF_TS_PACKET_COUNT = 5;
    public static final int TS_PACKET_SIZE = 188;
    private static final int TS_PAT_PID = 0;
    public static final int TS_STREAM_TYPE_AAC_ADTS = 15;
    public static final int TS_STREAM_TYPE_AAC_LATM = 17;
    public static final int TS_STREAM_TYPE_AC3 = 129;
    public static final int TS_STREAM_TYPE_AC4 = 172;
    public static final int TS_STREAM_TYPE_AIT = 257;
    public static final int TS_STREAM_TYPE_DC2_H262 = 128;
    public static final int TS_STREAM_TYPE_DTS = 138;
    public static final int TS_STREAM_TYPE_DVBSUBS = 89;
    public static final int TS_STREAM_TYPE_E_AC3 = 135;
    public static final int TS_STREAM_TYPE_H262 = 2;
    public static final int TS_STREAM_TYPE_H263 = 16;
    public static final int TS_STREAM_TYPE_H264 = 27;
    public static final int TS_STREAM_TYPE_H265 = 36;
    public static final int TS_STREAM_TYPE_HDMV_DTS = 130;
    public static final int TS_STREAM_TYPE_ID3 = 21;
    public static final int TS_STREAM_TYPE_MPA = 3;
    public static final int TS_STREAM_TYPE_MPA_LSF = 4;
    public static final int TS_STREAM_TYPE_SPLICE_INFO = 134;
    public static final int TS_SYNC_BYTE = 71;
    private int bytesSinceLastSync;
    private final SparseIntArray continuityCounters;
    private final TsDurationReader durationReader;
    private boolean hasOutputSeekMap;
    /* access modifiers changed from: private */
    @Nullable
    public TsPayloadReader id3Reader;
    /* access modifiers changed from: private */
    public final int mode;
    /* access modifiers changed from: private */
    public ExtractorOutput output;
    /* access modifiers changed from: private */
    public final TsPayloadReader.Factory payloadReaderFactory;
    /* access modifiers changed from: private */
    public int pcrPid;
    private boolean pendingSeekToStart;
    /* access modifiers changed from: private */
    public int remainingPmts;
    /* access modifiers changed from: private */
    public final List<TimestampAdjuster> timestampAdjusters;
    private final int timestampSearchBytes;
    /* access modifiers changed from: private */
    public final SparseBooleanArray trackIds;
    /* access modifiers changed from: private */
    public final SparseBooleanArray trackPids;
    /* access modifiers changed from: private */
    public boolean tracksEnded;
    private TsBinarySearchSeeker tsBinarySearchSeeker;
    private final ParsableByteArray tsPacketBuffer;
    /* access modifiers changed from: private */
    public final SparseArray<TsPayloadReader> tsPayloadReaders;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class PatReader implements SectionPayloadReader {
        private final ParsableBitArray patScratch = new ParsableBitArray(new byte[4]);

        public PatReader() {
        }

        public void consume(ParsableByteArray parsableByteArray) {
            if (parsableByteArray.readUnsignedByte() == 0 && (parsableByteArray.readUnsignedByte() & 128) != 0) {
                parsableByteArray.skipBytes(6);
                int bytesLeft = parsableByteArray.bytesLeft() / 4;
                for (int i11 = 0; i11 < bytesLeft; i11++) {
                    parsableByteArray.readBytes(this.patScratch, 4);
                    int readBits = this.patScratch.readBits(16);
                    this.patScratch.skipBits(3);
                    if (readBits == 0) {
                        this.patScratch.skipBits(13);
                    } else {
                        int readBits2 = this.patScratch.readBits(13);
                        if (TsExtractor.this.tsPayloadReaders.get(readBits2) == null) {
                            TsExtractor.this.tsPayloadReaders.put(readBits2, new SectionReader(new PmtReader(readBits2)));
                            TsExtractor.access$108(TsExtractor.this);
                        }
                    }
                }
                if (TsExtractor.this.mode != 2) {
                    TsExtractor.this.tsPayloadReaders.remove(0);
                }
            }
        }

        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public class PmtReader implements SectionPayloadReader {
        private static final int TS_PMT_DESC_AC3 = 106;
        private static final int TS_PMT_DESC_AIT = 111;
        private static final int TS_PMT_DESC_DTS = 123;
        private static final int TS_PMT_DESC_DVBSUBS = 89;
        private static final int TS_PMT_DESC_DVB_EXT = 127;
        private static final int TS_PMT_DESC_DVB_EXT_AC4 = 21;
        private static final int TS_PMT_DESC_EAC3 = 122;
        private static final int TS_PMT_DESC_ISO639_LANG = 10;
        private static final int TS_PMT_DESC_REGISTRATION = 5;
        private final int pid;
        private final ParsableBitArray pmtScratch = new ParsableBitArray(new byte[5]);
        private final SparseIntArray trackIdToPidScratch = new SparseIntArray();
        private final SparseArray<TsPayloadReader> trackIdToReaderScratch = new SparseArray<>();

        public PmtReader(int i11) {
            this.pid = i11;
        }

        private TsPayloadReader.EsInfo readEsInfo(ParsableByteArray parsableByteArray, int i11) {
            int position = parsableByteArray.getPosition();
            int i12 = i11 + position;
            int i13 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (parsableByteArray.getPosition() < i12) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int position2 = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
                if (position2 > i12) {
                    break;
                }
                if (readUnsignedByte == 5) {
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    if (readUnsignedInt != TsExtractor.AC3_FORMAT_IDENTIFIER) {
                        if (readUnsignedInt != TsExtractor.E_AC3_FORMAT_IDENTIFIER) {
                            if (readUnsignedInt != TsExtractor.AC4_FORMAT_IDENTIFIER) {
                                if (readUnsignedInt == TsExtractor.HEVC_FORMAT_IDENTIFIER) {
                                    i13 = 36;
                                }
                                parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                            }
                        }
                        i13 = 135;
                        parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                    }
                    i13 = 129;
                    parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                } else {
                    if (readUnsignedByte != 106) {
                        if (readUnsignedByte != 122) {
                            if (readUnsignedByte == 127) {
                                if (parsableByteArray.readUnsignedByte() != 21) {
                                }
                            } else if (readUnsignedByte == 123) {
                                i13 = 138;
                            } else if (readUnsignedByte == 10) {
                                str = parsableByteArray.readString(3).trim();
                            } else if (readUnsignedByte == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (parsableByteArray.getPosition() < position2) {
                                    String trim = parsableByteArray.readString(3).trim();
                                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                    byte[] bArr = new byte[4];
                                    parsableByteArray.readBytes(bArr, 0, 4);
                                    arrayList2.add(new TsPayloadReader.DvbSubtitleInfo(trim, readUnsignedByte2, bArr));
                                }
                                arrayList = arrayList2;
                                i13 = 89;
                            } else if (readUnsignedByte == 111) {
                                i13 = 257;
                            }
                            parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                        }
                        i13 = 135;
                        parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                    }
                    i13 = 129;
                    parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
                }
                i13 = 172;
                parsableByteArray.skipBytes(position2 - parsableByteArray.getPosition());
            }
            parsableByteArray.setPosition(i12);
            return new TsPayloadReader.EsInfo(i13, str, arrayList, Arrays.copyOfRange(parsableByteArray.getData(), position, i12));
        }

        public void consume(ParsableByteArray parsableByteArray) {
            TimestampAdjuster timestampAdjuster;
            int i11;
            int i12;
            TsPayloadReader tsPayloadReader;
            ParsableByteArray parsableByteArray2 = parsableByteArray;
            if (parsableByteArray.readUnsignedByte() == 2) {
                if (TsExtractor.this.mode == 1 || TsExtractor.this.mode == 2 || TsExtractor.this.remainingPmts == 1) {
                    timestampAdjuster = (TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0);
                } else {
                    timestampAdjuster = new TimestampAdjuster(((TimestampAdjuster) TsExtractor.this.timestampAdjusters.get(0)).getFirstSampleTimestampUs());
                    TsExtractor.this.timestampAdjusters.add(timestampAdjuster);
                }
                if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                    parsableByteArray2.skipBytes(1);
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    int i13 = 3;
                    parsableByteArray2.skipBytes(3);
                    parsableByteArray2.readBytes(this.pmtScratch, 2);
                    this.pmtScratch.skipBits(3);
                    int i14 = 13;
                    int unused = TsExtractor.this.pcrPid = this.pmtScratch.readBits(13);
                    parsableByteArray2.readBytes(this.pmtScratch, 2);
                    int i15 = 4;
                    this.pmtScratch.skipBits(4);
                    parsableByteArray2.skipBytes(this.pmtScratch.readBits(12));
                    if (TsExtractor.this.mode == 2 && TsExtractor.this.id3Reader == null) {
                        TsPayloadReader.EsInfo esInfo = new TsPayloadReader.EsInfo(21, (String) null, (List<TsPayloadReader.DvbSubtitleInfo>) null, Util.EMPTY_BYTE_ARRAY);
                        TsExtractor tsExtractor = TsExtractor.this;
                        TsPayloadReader unused2 = tsExtractor.id3Reader = tsExtractor.payloadReaderFactory.createPayloadReader(21, esInfo);
                        if (TsExtractor.this.id3Reader != null) {
                            TsExtractor.this.id3Reader.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, 21, 8192));
                        }
                    }
                    this.trackIdToReaderScratch.clear();
                    this.trackIdToPidScratch.clear();
                    int bytesLeft = parsableByteArray.bytesLeft();
                    while (bytesLeft > 0) {
                        parsableByteArray2.readBytes(this.pmtScratch, 5);
                        int readBits = this.pmtScratch.readBits(8);
                        this.pmtScratch.skipBits(i13);
                        int readBits2 = this.pmtScratch.readBits(i14);
                        this.pmtScratch.skipBits(i15);
                        int readBits3 = this.pmtScratch.readBits(12);
                        TsPayloadReader.EsInfo readEsInfo = readEsInfo(parsableByteArray2, readBits3);
                        if (readBits == 6 || readBits == 5) {
                            readBits = readEsInfo.streamType;
                        }
                        bytesLeft -= readBits3 + 5;
                        if (TsExtractor.this.mode == 2) {
                            i12 = readBits;
                        } else {
                            i12 = readBits2;
                        }
                        if (!TsExtractor.this.trackIds.get(i12)) {
                            if (TsExtractor.this.mode == 2 && readBits == 21) {
                                tsPayloadReader = TsExtractor.this.id3Reader;
                            } else {
                                tsPayloadReader = TsExtractor.this.payloadReaderFactory.createPayloadReader(readBits, readEsInfo);
                            }
                            if (TsExtractor.this.mode != 2 || readBits2 < this.trackIdToPidScratch.get(i12, 8192)) {
                                this.trackIdToPidScratch.put(i12, readBits2);
                                this.trackIdToReaderScratch.put(i12, tsPayloadReader);
                            }
                        }
                        i13 = 3;
                        i15 = 4;
                        i14 = 13;
                    }
                    int size = this.trackIdToPidScratch.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        int keyAt = this.trackIdToPidScratch.keyAt(i16);
                        int valueAt = this.trackIdToPidScratch.valueAt(i16);
                        TsExtractor.this.trackIds.put(keyAt, true);
                        TsExtractor.this.trackPids.put(valueAt, true);
                        TsPayloadReader valueAt2 = this.trackIdToReaderScratch.valueAt(i16);
                        if (valueAt2 != null) {
                            if (valueAt2 != TsExtractor.this.id3Reader) {
                                valueAt2.init(timestampAdjuster, TsExtractor.this.output, new TsPayloadReader.TrackIdGenerator(readUnsignedShort, keyAt, 8192));
                            }
                            TsExtractor.this.tsPayloadReaders.put(valueAt, valueAt2);
                        }
                    }
                    if (TsExtractor.this.mode != 2) {
                        TsExtractor.this.tsPayloadReaders.remove(this.pid);
                        TsExtractor tsExtractor2 = TsExtractor.this;
                        if (tsExtractor2.mode == 1) {
                            i11 = 0;
                        } else {
                            i11 = TsExtractor.this.remainingPmts - 1;
                        }
                        int unused3 = tsExtractor2.remainingPmts = i11;
                        if (TsExtractor.this.remainingPmts == 0) {
                            TsExtractor.this.output.endTracks();
                            boolean unused4 = TsExtractor.this.tracksEnded = true;
                        }
                    } else if (!TsExtractor.this.tracksEnded) {
                        TsExtractor.this.output.endTracks();
                        int unused5 = TsExtractor.this.remainingPmts = 0;
                        boolean unused6 = TsExtractor.this.tracksEnded = true;
                    }
                }
            }
        }

        public void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        }
    }

    public TsExtractor() {
        this(0);
    }

    public static /* synthetic */ int access$108(TsExtractor tsExtractor) {
        int i11 = tsExtractor.remainingPmts;
        tsExtractor.remainingPmts = i11 + 1;
        return i11;
    }

    private boolean fillBufferWithAtLeastOnePacket(ExtractorInput extractorInput) throws IOException {
        byte[] data = this.tsPacketBuffer.getData();
        if (9400 - this.tsPacketBuffer.getPosition() < 188) {
            int bytesLeft = this.tsPacketBuffer.bytesLeft();
            if (bytesLeft > 0) {
                System.arraycopy(data, this.tsPacketBuffer.getPosition(), data, 0, bytesLeft);
            }
            this.tsPacketBuffer.reset(data, bytesLeft);
        }
        while (this.tsPacketBuffer.bytesLeft() < 188) {
            int limit = this.tsPacketBuffer.limit();
            int read = extractorInput.read(data, limit, 9400 - limit);
            if (read == -1) {
                return false;
            }
            this.tsPacketBuffer.setLimit(limit + read);
        }
        return true;
    }

    private int findEndOfFirstTsPacketInBuffer() throws ParserException {
        int position = this.tsPacketBuffer.getPosition();
        int limit = this.tsPacketBuffer.limit();
        int findSyncBytePosition = TsUtil.findSyncBytePosition(this.tsPacketBuffer.getData(), position, limit);
        this.tsPacketBuffer.setPosition(findSyncBytePosition);
        int i11 = findSyncBytePosition + 188;
        if (i11 > limit) {
            int i12 = this.bytesSinceLastSync + (findSyncBytePosition - position);
            this.bytesSinceLastSync = i12;
            if (this.mode == 2 && i12 > 376) {
                throw ParserException.createForMalformedContainer("Cannot find sync byte. Most likely not a Transport Stream.", (Throwable) null);
            }
        } else {
            this.bytesSinceLastSync = 0;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new TsExtractor()};
    }

    private void maybeOutputSeekMap(long j11) {
        if (!this.hasOutputSeekMap) {
            this.hasOutputSeekMap = true;
            if (this.durationReader.getDurationUs() != C.TIME_UNSET) {
                TsBinarySearchSeeker tsBinarySearchSeeker2 = new TsBinarySearchSeeker(this.durationReader.getPcrTimestampAdjuster(), this.durationReader.getDurationUs(), j11, this.pcrPid, this.timestampSearchBytes);
                this.tsBinarySearchSeeker = tsBinarySearchSeeker2;
                this.output.seekMap(tsBinarySearchSeeker2.getSeekMap());
                return;
            }
            this.output.seekMap(new SeekMap.Unseekable(this.durationReader.getDurationUs()));
        }
    }

    private void resetPayloadReaders() {
        this.trackIds.clear();
        this.tsPayloadReaders.clear();
        SparseArray<TsPayloadReader> createInitialPayloadReaders = this.payloadReaderFactory.createInitialPayloadReaders();
        int size = createInitialPayloadReaders.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.tsPayloadReaders.put(createInitialPayloadReaders.keyAt(i11), createInitialPayloadReaders.valueAt(i11));
        }
        this.tsPayloadReaders.put(0, new SectionReader(new PatReader()));
        this.id3Reader = null;
    }

    private boolean shouldConsumePacketPayload(int i11) {
        if (this.mode == 2 || this.tracksEnded || !this.trackPids.get(i11, false)) {
            return true;
        }
        return false;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i11;
        boolean z11;
        boolean z12;
        TsPayloadReader tsPayloadReader;
        int i12;
        boolean z13;
        ExtractorInput extractorInput2 = extractorInput;
        PositionHolder positionHolder2 = positionHolder;
        long length = extractorInput.getLength();
        if (this.tracksEnded) {
            if (length == -1 || this.mode == 2) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z13 && !this.durationReader.isDurationReadFinished()) {
                return this.durationReader.readDuration(extractorInput2, positionHolder2, this.pcrPid);
            }
            maybeOutputSeekMap(length);
            if (this.pendingSeekToStart) {
                this.pendingSeekToStart = false;
                seek(0, 0);
                if (extractorInput.getPosition() != 0) {
                    positionHolder2.position = 0;
                    return 1;
                }
            }
            TsBinarySearchSeeker tsBinarySearchSeeker2 = this.tsBinarySearchSeeker;
            if (tsBinarySearchSeeker2 != null && tsBinarySearchSeeker2.isSeeking()) {
                return this.tsBinarySearchSeeker.handlePendingSeek(extractorInput2, positionHolder2);
            }
        }
        if (!fillBufferWithAtLeastOnePacket(extractorInput)) {
            return -1;
        }
        int findEndOfFirstTsPacketInBuffer = findEndOfFirstTsPacketInBuffer();
        int limit = this.tsPacketBuffer.limit();
        if (findEndOfFirstTsPacketInBuffer > limit) {
            return 0;
        }
        int readInt = this.tsPacketBuffer.readInt();
        if ((8388608 & readInt) != 0) {
            this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
            return 0;
        }
        if ((4194304 & readInt) != 0) {
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = i11 | 0;
        int i14 = (2096896 & readInt) >> 8;
        if ((readInt & 32) != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if ((readInt & 16) != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            tsPayloadReader = this.tsPayloadReaders.get(i14);
        } else {
            tsPayloadReader = null;
        }
        if (tsPayloadReader == null) {
            this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
            return 0;
        }
        if (this.mode != 2) {
            int i15 = readInt & 15;
            int i16 = this.continuityCounters.get(i14, i15 - 1);
            this.continuityCounters.put(i14, i15);
            if (i16 == i15) {
                this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
                return 0;
            } else if (i15 != ((i16 + 1) & 15)) {
                tsPayloadReader.seek();
            }
        }
        if (z11) {
            int readUnsignedByte = this.tsPacketBuffer.readUnsignedByte();
            if ((this.tsPacketBuffer.readUnsignedByte() & 64) != 0) {
                i12 = 2;
            } else {
                i12 = 0;
            }
            i13 |= i12;
            this.tsPacketBuffer.skipBytes(readUnsignedByte - 1);
        }
        boolean z14 = this.tracksEnded;
        if (shouldConsumePacketPayload(i14)) {
            this.tsPacketBuffer.setLimit(findEndOfFirstTsPacketInBuffer);
            tsPayloadReader.consume(this.tsPacketBuffer, i13);
            this.tsPacketBuffer.setLimit(limit);
        }
        if (this.mode != 2 && !z14 && this.tracksEnded && length != -1) {
            this.pendingSeekToStart = true;
        }
        this.tsPacketBuffer.setPosition(findEndOfFirstTsPacketInBuffer);
        return 0;
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        boolean z11;
        TsBinarySearchSeeker tsBinarySearchSeeker2;
        boolean z12;
        if (this.mode != 2) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkState(z11);
        int size = this.timestampAdjusters.size();
        for (int i11 = 0; i11 < size; i11++) {
            TimestampAdjuster timestampAdjuster = this.timestampAdjusters.get(i11);
            if (timestampAdjuster.getTimestampOffsetUs() == C.TIME_UNSET) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                long firstSampleTimestampUs = timestampAdjuster.getFirstSampleTimestampUs();
                if (firstSampleTimestampUs == C.TIME_UNSET || firstSampleTimestampUs == 0 || firstSampleTimestampUs == j12) {
                    z12 = false;
                } else {
                    z12 = true;
                }
            }
            if (z12) {
                timestampAdjuster.reset(j12);
            }
        }
        if (!(j12 == 0 || (tsBinarySearchSeeker2 = this.tsBinarySearchSeeker) == null)) {
            tsBinarySearchSeeker2.setSeekTargetUs(j12);
        }
        this.tsPacketBuffer.reset(0);
        this.continuityCounters.clear();
        for (int i12 = 0; i12 < this.tsPayloadReaders.size(); i12++) {
            this.tsPayloadReaders.valueAt(i12).seek();
        }
        this.bytesSinceLastSync = 0;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        boolean z11;
        byte[] data = this.tsPacketBuffer.getData();
        extractorInput.peekFully(data, 0, 940);
        for (int i11 = 0; i11 < 188; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 >= 5) {
                    z11 = true;
                    break;
                } else if (data[(i12 * 188) + i11] != 71) {
                    z11 = false;
                    break;
                } else {
                    i12++;
                }
            }
            if (z11) {
                extractorInput.skipFully(i11);
                return true;
            }
        }
        return false;
    }

    public TsExtractor(int i11) {
        this(1, i11, (int) DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i11, int i12, int i13) {
        this(i11, new TimestampAdjuster(0), new DefaultTsPayloadReaderFactory(i12), i13);
    }

    public TsExtractor(int i11, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory) {
        this(i11, timestampAdjuster, factory, DEFAULT_TIMESTAMP_SEARCH_BYTES);
    }

    public TsExtractor(int i11, TimestampAdjuster timestampAdjuster, TsPayloadReader.Factory factory, int i12) {
        this.payloadReaderFactory = (TsPayloadReader.Factory) Assertions.checkNotNull(factory);
        this.timestampSearchBytes = i12;
        this.mode = i11;
        if (i11 == 1 || i11 == 2) {
            this.timestampAdjusters = Collections.singletonList(timestampAdjuster);
        } else {
            ArrayList arrayList = new ArrayList();
            this.timestampAdjusters = arrayList;
            arrayList.add(timestampAdjuster);
        }
        this.tsPacketBuffer = new ParsableByteArray(new byte[BUFFER_SIZE], 0);
        this.trackIds = new SparseBooleanArray();
        this.trackPids = new SparseBooleanArray();
        this.tsPayloadReaders = new SparseArray<>();
        this.continuityCounters = new SparseIntArray();
        this.durationReader = new TsDurationReader(i12);
        this.output = ExtractorOutput.PLACEHOLDER;
        this.pcrPid = -1;
        resetPayloadReaders();
    }
}
