package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap;

public class ConstantBitrateSeekMap implements SeekMap {
    private final boolean allowSeeksIfLengthUnknown;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFrameBytePosition;
    private final int frameSize;
    private final long inputLength;

    public ConstantBitrateSeekMap(long j11, long j12, int i11, int i12) {
        this(j11, j12, i11, i12, false);
    }

    private long getFramePositionForTimeUs(long j11) {
        int i11 = this.frameSize;
        long j12 = (((j11 * ((long) this.bitrate)) / 8000000) / ((long) i11)) * ((long) i11);
        long j13 = this.dataSize;
        if (j13 != -1) {
            j12 = Math.min(j12, j13 - ((long) i11));
        }
        return this.firstFrameBytePosition + Math.max(j12, 0);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        if (this.dataSize == -1 && !this.allowSeeksIfLengthUnknown) {
            return new SeekMap.SeekPoints(new SeekPoint(0, this.firstFrameBytePosition));
        }
        long framePositionForTimeUs = getFramePositionForTimeUs(j11);
        long timeUsAtPosition = getTimeUsAtPosition(framePositionForTimeUs);
        SeekPoint seekPoint = new SeekPoint(timeUsAtPosition, framePositionForTimeUs);
        if (this.dataSize != -1 && timeUsAtPosition < j11) {
            int i11 = this.frameSize;
            if (((long) i11) + framePositionForTimeUs < this.inputLength) {
                long j12 = framePositionForTimeUs + ((long) i11);
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUsAtPosition(j12), j12));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUsAtPosition(long j11) {
        return getTimeUsAtPosition(j11, this.firstFrameBytePosition, this.bitrate);
    }

    public boolean isSeekable() {
        return this.dataSize != -1 || this.allowSeeksIfLengthUnknown;
    }

    public ConstantBitrateSeekMap(long j11, long j12, int i11, int i12, boolean z11) {
        this.inputLength = j11;
        this.firstFrameBytePosition = j12;
        this.frameSize = i12 == -1 ? 1 : i12;
        this.bitrate = i11;
        this.allowSeeksIfLengthUnknown = z11;
        if (j11 == -1) {
            this.dataSize = -1;
            this.durationUs = C.TIME_UNSET;
            return;
        }
        this.dataSize = j11 - j12;
        this.durationUs = getTimeUsAtPosition(j11, j12, i11);
    }

    private static long getTimeUsAtPosition(long j11, long j12, int i11) {
        return ((Math.max(0, j11 - j12) * 8) * 1000000) / ((long) i11);
    }
}
