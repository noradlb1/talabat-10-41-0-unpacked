package com.google.android.exoplayer2.text.subrip;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    public List<Cue> getCues(long j11) {
        Cue cue;
        int binarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j11, true, false);
        if (binarySearchFloor == -1 || (cue = this.cues[binarySearchFloor]) == Cue.EMPTY) {
            return Collections.emptyList();
        }
        return Collections.singletonList(cue);
    }

    public long getEventTime(int i11) {
        boolean z11;
        boolean z12 = true;
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        if (i11 >= this.cueTimesUs.length) {
            z12 = false;
        }
        Assertions.checkArgument(z12);
        return this.cueTimesUs[i11];
    }

    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    public int getNextEventTimeIndex(long j11) {
        int binarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j11, false, false);
        if (binarySearchCeil < this.cueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
