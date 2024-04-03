package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class IndexSeekMap implements SeekMap {
    private final long durationUs;
    private final boolean isSeekable;
    private final long[] positions;
    private final long[] timesUs;

    public IndexSeekMap(long[] jArr, long[] jArr2, long j11) {
        boolean z11;
        boolean z12;
        if (jArr.length == jArr2.length) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        int length = jArr2.length;
        if (length > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        this.isSeekable = z12;
        if (!z12 || jArr2[0] <= 0) {
            this.positions = jArr;
            this.timesUs = jArr2;
        } else {
            int i11 = length + 1;
            long[] jArr3 = new long[i11];
            this.positions = jArr3;
            long[] jArr4 = new long[i11];
            this.timesUs = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length);
            System.arraycopy(jArr2, 0, jArr4, 1, length);
        }
        this.durationUs = j11;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        if (!this.isSeekable) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j11, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs == j11 || binarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i11 = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i11], this.positions[i11]));
    }

    public boolean isSeekable() {
        return this.isSeekable;
    }
}
