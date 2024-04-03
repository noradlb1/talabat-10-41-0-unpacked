package com.google.android.exoplayer2.extractor.avi;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Arrays;

final class ChunkReader {
    private static final int CHUNK_TYPE_AUDIO = 1651965952;
    private static final int CHUNK_TYPE_VIDEO_COMPRESSED = 1667497984;
    private static final int CHUNK_TYPE_VIDEO_UNCOMPRESSED = 1650720768;
    private static final int INITIAL_INDEX_SIZE = 512;
    private final int alternativeChunkId;
    private int bytesRemainingInCurrentChunk;
    private final int chunkId;
    private int currentChunkIndex;
    private int currentChunkSize;
    private final long durationUs;
    private int indexChunkCount;
    private int indexSize;
    private int[] keyFrameIndices;
    private long[] keyFrameOffsets;
    private final int streamHeaderChunkCount;
    protected final TrackOutput trackOutput;

    public ChunkReader(int i11, int i12, long j11, int i13, TrackOutput trackOutput2) {
        int i14;
        int i15;
        boolean z11 = true;
        if (!(i12 == 1 || i12 == 2)) {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        this.durationUs = j11;
        this.streamHeaderChunkCount = i13;
        this.trackOutput = trackOutput2;
        if (i12 == 2) {
            i14 = CHUNK_TYPE_VIDEO_COMPRESSED;
        } else {
            i14 = CHUNK_TYPE_AUDIO;
        }
        this.chunkId = getChunkIdFourCc(i11, i14);
        if (i12 == 2) {
            i15 = getChunkIdFourCc(i11, CHUNK_TYPE_VIDEO_UNCOMPRESSED);
        } else {
            i15 = -1;
        }
        this.alternativeChunkId = i15;
        this.keyFrameOffsets = new long[512];
        this.keyFrameIndices = new int[512];
    }

    private static int getChunkIdFourCc(int i11, int i12) {
        return (((i11 % 10) + 48) << 8) | ((i11 / 10) + 48) | i12;
    }

    private long getChunkTimestampUs(int i11) {
        return (this.durationUs * ((long) i11)) / ((long) this.streamHeaderChunkCount);
    }

    private SeekPoint getSeekPoint(int i11) {
        return new SeekPoint(((long) this.keyFrameIndices[i11]) * getFrameDurationUs(), this.keyFrameOffsets[i11]);
    }

    public void advanceCurrentChunk() {
        this.currentChunkIndex++;
    }

    public void appendKeyFrameToIndex(long j11) {
        if (this.indexSize == this.keyFrameIndices.length) {
            long[] jArr = this.keyFrameOffsets;
            this.keyFrameOffsets = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.keyFrameIndices;
            this.keyFrameIndices = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.keyFrameOffsets;
        int i11 = this.indexSize;
        jArr2[i11] = j11;
        this.keyFrameIndices[i11] = this.indexChunkCount;
        this.indexSize = i11 + 1;
    }

    public void compactIndex() {
        this.keyFrameOffsets = Arrays.copyOf(this.keyFrameOffsets, this.indexSize);
        this.keyFrameIndices = Arrays.copyOf(this.keyFrameIndices, this.indexSize);
    }

    public long getCurrentChunkTimestampUs() {
        return getChunkTimestampUs(this.currentChunkIndex);
    }

    public long getFrameDurationUs() {
        return getChunkTimestampUs(1);
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        int frameDurationUs = (int) (j11 / getFrameDurationUs());
        int binarySearchFloor = Util.binarySearchFloor(this.keyFrameIndices, frameDurationUs, true, true);
        if (this.keyFrameIndices[binarySearchFloor] == frameDurationUs) {
            return new SeekMap.SeekPoints(getSeekPoint(binarySearchFloor));
        }
        SeekPoint seekPoint = getSeekPoint(binarySearchFloor);
        int i11 = binarySearchFloor + 1;
        if (i11 < this.keyFrameOffsets.length) {
            return new SeekMap.SeekPoints(seekPoint, getSeekPoint(i11));
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public boolean handlesChunkId(int i11) {
        return this.chunkId == i11 || this.alternativeChunkId == i11;
    }

    public void incrementIndexChunkCount() {
        this.indexChunkCount++;
    }

    public boolean isAudio() {
        return (this.chunkId & CHUNK_TYPE_AUDIO) == CHUNK_TYPE_AUDIO;
    }

    public boolean isCurrentFrameAKeyFrame() {
        return Arrays.binarySearch(this.keyFrameIndices, this.currentChunkIndex) >= 0;
    }

    public boolean isVideo() {
        return (this.chunkId & CHUNK_TYPE_VIDEO_COMPRESSED) == CHUNK_TYPE_VIDEO_COMPRESSED;
    }

    public boolean onChunkData(ExtractorInput extractorInput) throws IOException {
        int i11 = this.bytesRemainingInCurrentChunk;
        boolean z11 = false;
        int sampleData = i11 - this.trackOutput.sampleData((DataReader) extractorInput, i11, false);
        this.bytesRemainingInCurrentChunk = sampleData;
        if (sampleData == 0) {
            z11 = true;
        }
        if (z11) {
            if (this.currentChunkSize > 0) {
                TrackOutput trackOutput2 = this.trackOutput;
                long currentChunkTimestampUs = getCurrentChunkTimestampUs();
                boolean isCurrentFrameAKeyFrame = isCurrentFrameAKeyFrame();
                trackOutput2.sampleMetadata(currentChunkTimestampUs, isCurrentFrameAKeyFrame ? 1 : 0, this.currentChunkSize, 0, (TrackOutput.CryptoData) null);
            }
            advanceCurrentChunk();
        }
        return z11;
    }

    public void onChunkStart(int i11) {
        this.currentChunkSize = i11;
        this.bytesRemainingInCurrentChunk = i11;
    }

    public void seekToPosition(long j11) {
        if (this.indexSize == 0) {
            this.currentChunkIndex = 0;
            return;
        }
        this.currentChunkIndex = this.keyFrameIndices[Util.binarySearchFloor(this.keyFrameOffsets, j11, true, true)];
    }
}
