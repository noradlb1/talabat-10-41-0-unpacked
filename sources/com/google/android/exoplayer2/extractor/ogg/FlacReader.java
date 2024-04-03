package com.google.android.exoplayer2.extractor.ogg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.FlacFrameReader;
import com.google.android.exoplayer2.extractor.FlacMetadataReader;
import com.google.android.exoplayer2.extractor.FlacSeekTableSeekMap;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class FlacReader extends StreamReader {
    private static final byte AUDIO_PACKET_TYPE = -1;
    private static final int FRAME_HEADER_SAMPLE_NUMBER_OFFSET = 4;
    @Nullable
    private FlacOggSeeker flacOggSeeker;
    @Nullable
    private FlacStreamMetadata streamMetadata;

    public static final class FlacOggSeeker implements OggSeeker {
        private long firstFrameOffset = -1;
        private long pendingSeekGranule = -1;
        private FlacStreamMetadata.SeekTable seekTable;
        private FlacStreamMetadata streamMetadata;

        public FlacOggSeeker(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.SeekTable seekTable2) {
            this.streamMetadata = flacStreamMetadata;
            this.seekTable = seekTable2;
        }

        public SeekMap createSeekMap() {
            boolean z11;
            if (this.firstFrameOffset != -1) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkState(z11);
            return new FlacSeekTableSeekMap(this.streamMetadata, this.firstFrameOffset);
        }

        public long read(ExtractorInput extractorInput) {
            long j11 = this.pendingSeekGranule;
            if (j11 < 0) {
                return -1;
            }
            long j12 = -(j11 + 2);
            this.pendingSeekGranule = -1;
            return j12;
        }

        public void setFirstFrameOffset(long j11) {
            this.firstFrameOffset = j11;
        }

        public void startSeek(long j11) {
            long[] jArr = this.seekTable.pointSampleNumbers;
            this.pendingSeekGranule = jArr[Util.binarySearchFloor(jArr, j11, true, true)];
        }
    }

    private int getFlacFrameBlockSize(ParsableByteArray parsableByteArray) {
        int i11 = (parsableByteArray.getData()[2] & 255) >> 4;
        if (i11 == 6 || i11 == 7) {
            parsableByteArray.skipBytes(4);
            parsableByteArray.readUtf8EncodedLong();
        }
        int readFrameBlockSizeSamplesFromKey = FlacFrameReader.readFrameBlockSizeSamplesFromKey(parsableByteArray, i11);
        parsableByteArray.setPosition(0);
        return readFrameBlockSizeSamplesFromKey;
    }

    private static boolean isAudioPacket(byte[] bArr) {
        return bArr[0] == -1;
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() >= 5 && parsableByteArray.readUnsignedByte() == 127 && parsableByteArray.readUnsignedInt() == 1179402563) {
            return true;
        }
        return false;
    }

    public long preparePayload(ParsableByteArray parsableByteArray) {
        if (!isAudioPacket(parsableByteArray.getData())) {
            return -1;
        }
        return (long) getFlacFrameBlockSize(parsableByteArray);
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j11, StreamReader.SetupData setupData) {
        byte[] data = parsableByteArray.getData();
        FlacStreamMetadata flacStreamMetadata = this.streamMetadata;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(data, 17);
            this.streamMetadata = flacStreamMetadata2;
            setupData.format = flacStreamMetadata2.getFormat(Arrays.copyOfRange(data, 9, parsableByteArray.limit()), (Metadata) null);
            return true;
        } else if ((data[0] & Byte.MAX_VALUE) == 3) {
            FlacStreamMetadata.SeekTable readSeekTableMetadataBlock = FlacMetadataReader.readSeekTableMetadataBlock(parsableByteArray);
            FlacStreamMetadata copyWithSeekTable = flacStreamMetadata.copyWithSeekTable(readSeekTableMetadataBlock);
            this.streamMetadata = copyWithSeekTable;
            this.flacOggSeeker = new FlacOggSeeker(copyWithSeekTable, readSeekTableMetadataBlock);
            return true;
        } else if (!isAudioPacket(data)) {
            return true;
        } else {
            FlacOggSeeker flacOggSeeker2 = this.flacOggSeeker;
            if (flacOggSeeker2 != null) {
                flacOggSeeker2.setFirstFrameOffset(j11);
                setupData.oggSeeker = this.flacOggSeeker;
            }
            Assertions.checkNotNull(setupData.format);
            return false;
        }
    }

    public void reset(boolean z11) {
        super.reset(z11);
        if (z11) {
            this.streamMetadata = null;
            this.flacOggSeeker = null;
        }
    }
}
