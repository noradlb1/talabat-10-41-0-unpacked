package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class SeekParameters {
    public static final SeekParameters CLOSEST_SYNC = new SeekParameters(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final SeekParameters DEFAULT;
    public static final SeekParameters EXACT;
    public static final SeekParameters NEXT_SYNC = new SeekParameters(0, Long.MAX_VALUE);
    public static final SeekParameters PREVIOUS_SYNC = new SeekParameters(Long.MAX_VALUE, 0);
    public final long toleranceAfterUs;
    public final long toleranceBeforeUs;

    static {
        SeekParameters seekParameters = new SeekParameters(0, 0);
        EXACT = seekParameters;
        DEFAULT = seekParameters;
    }

    public SeekParameters(long j11, long j12) {
        boolean z11;
        boolean z12 = true;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        Assertions.checkArgument(j12 < 0 ? false : z12);
        this.toleranceBeforeUs = j11;
        this.toleranceAfterUs = j12;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || SeekParameters.class != obj.getClass()) {
            return false;
        }
        SeekParameters seekParameters = (SeekParameters) obj;
        if (this.toleranceBeforeUs == seekParameters.toleranceBeforeUs && this.toleranceAfterUs == seekParameters.toleranceAfterUs) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.toleranceBeforeUs) * 31) + ((int) this.toleranceAfterUs);
    }

    public long resolveSeekPositionUs(long j11, long j12, long j13) {
        boolean z11;
        long j14 = this.toleranceBeforeUs;
        if (j14 == 0 && this.toleranceAfterUs == 0) {
            return j11;
        }
        long subtractWithOverflowDefault = Util.subtractWithOverflowDefault(j11, j14, Long.MIN_VALUE);
        long addWithOverflowDefault = Util.addWithOverflowDefault(j11, this.toleranceAfterUs, Long.MAX_VALUE);
        boolean z12 = true;
        if (subtractWithOverflowDefault > j12 || j12 > addWithOverflowDefault) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (subtractWithOverflowDefault > j13 || j13 > addWithOverflowDefault) {
            z12 = false;
        }
        if (!z11 || !z12) {
            if (z11) {
                return j12;
            }
            if (z12) {
                return j13;
            }
            return subtractWithOverflowDefault;
        } else if (Math.abs(j12 - j11) <= Math.abs(j13 - j11)) {
            return j12;
        } else {
            return j13;
        }
    }
}
