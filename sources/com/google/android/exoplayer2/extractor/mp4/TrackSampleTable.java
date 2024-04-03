package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

final class TrackSampleTable {
    public final long durationUs;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;
    public final Track track;

    public TrackSampleTable(Track track2, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (iArr.length == jArr2.length) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        if (jArr.length == jArr2.length) {
            z12 = true;
        } else {
            z12 = false;
        }
        Assertions.checkArgument(z12);
        Assertions.checkArgument(iArr2.length == jArr2.length ? true : z13);
        this.track = track2;
        this.offsets = jArr;
        this.sizes = iArr;
        this.maximumSize = i11;
        this.timestampsUs = jArr2;
        this.flags = iArr2;
        this.durationUs = j11;
        this.sampleCount = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int getIndexOfEarlierOrEqualSynchronizationSample(long j11) {
        for (int binarySearchFloor = Util.binarySearchFloor(this.timestampsUs, j11, true, false); binarySearchFloor >= 0; binarySearchFloor--) {
            if ((this.flags[binarySearchFloor] & 1) != 0) {
                return binarySearchFloor;
            }
        }
        return -1;
    }

    public int getIndexOfLaterOrEqualSynchronizationSample(long j11) {
        for (int binarySearchCeil = Util.binarySearchCeil(this.timestampsUs, j11, true, false); binarySearchCeil < this.timestampsUs.length; binarySearchCeil++) {
            if ((this.flags[binarySearchCeil] & 1) != 0) {
                return binarySearchCeil;
            }
        }
        return -1;
    }
}
