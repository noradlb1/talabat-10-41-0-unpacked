package com.google.android.exoplayer2.util;

import androidx.annotation.GuardedBy;
import com.google.android.exoplayer2.C;

public final class TimestampAdjuster {
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    public static final long MODE_NO_OFFSET = Long.MAX_VALUE;
    public static final long MODE_SHARED = 9223372036854775806L;
    @GuardedBy("this")
    private long firstSampleTimestampUs;
    @GuardedBy("this")
    private long lastUnadjustedTimestampUs;
    private final ThreadLocal<Long> nextSampleTimestampUs = new ThreadLocal<>();
    @GuardedBy("this")
    private long timestampOffsetUs;

    public TimestampAdjuster(long j11) {
        reset(j11);
    }

    public static long ptsToUs(long j11) {
        return (j11 * 1000000) / 90000;
    }

    public static long usToNonWrappedPts(long j11) {
        return (j11 * 90000) / 1000000;
    }

    public static long usToWrappedPts(long j11) {
        return usToNonWrappedPts(j11) % MAX_PTS_PLUS_ONE;
    }

    public synchronized long adjustSampleTimestamp(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        if (this.timestampOffsetUs == C.TIME_UNSET) {
            long j12 = this.firstSampleTimestampUs;
            if (j12 == MODE_SHARED) {
                j12 = ((Long) Assertions.checkNotNull(this.nextSampleTimestampUs.get())).longValue();
            }
            this.timestampOffsetUs = j12 - j11;
            notifyAll();
        }
        this.lastUnadjustedTimestampUs = j11;
        return j11 + this.timestampOffsetUs;
    }

    public synchronized long adjustTsTimestamp(long j11) {
        if (j11 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        long j12 = this.lastUnadjustedTimestampUs;
        if (j12 != C.TIME_UNSET) {
            long usToNonWrappedPts = usToNonWrappedPts(j12);
            long j13 = (4294967296L + usToNonWrappedPts) / MAX_PTS_PLUS_ONE;
            long j14 = ((j13 - 1) * MAX_PTS_PLUS_ONE) + j11;
            j11 += j13 * MAX_PTS_PLUS_ONE;
            if (Math.abs(j14 - usToNonWrappedPts) < Math.abs(j11 - usToNonWrappedPts)) {
                j11 = j14;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j11));
    }

    public synchronized long getFirstSampleTimestampUs() {
        long j11;
        j11 = this.firstSampleTimestampUs;
        if (j11 == Long.MAX_VALUE || j11 == MODE_SHARED) {
            j11 = C.TIME_UNSET;
        }
        return j11;
    }

    public synchronized long getLastAdjustedTimestampUs() {
        long j11;
        long j12 = this.lastUnadjustedTimestampUs;
        if (j12 != C.TIME_UNSET) {
            j11 = j12 + this.timestampOffsetUs;
        } else {
            j11 = getFirstSampleTimestampUs();
        }
        return j11;
    }

    public synchronized long getTimestampOffsetUs() {
        return this.timestampOffsetUs;
    }

    public synchronized void reset(long j11) {
        long j12;
        this.firstSampleTimestampUs = j11;
        if (j11 == Long.MAX_VALUE) {
            j12 = 0;
        } else {
            j12 = -9223372036854775807L;
        }
        this.timestampOffsetUs = j12;
        this.lastUnadjustedTimestampUs = C.TIME_UNSET;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0036, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void sharedInitializeOrWait(boolean r5, long r6) throws java.lang.InterruptedException {
        /*
            r4 = this;
            monitor-enter(r4)
            long r0 = r4.firstSampleTimestampUs     // Catch:{ all -> 0x0037 }
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x000e
            r0 = 1
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            com.google.android.exoplayer2.util.Assertions.checkState(r0)     // Catch:{ all -> 0x0037 }
            long r0 = r4.timestampOffsetUs     // Catch:{ all -> 0x0037 }
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x001f
            monitor-exit(r4)
            return
        L_0x001f:
            if (r5 == 0) goto L_0x002b
            java.lang.ThreadLocal<java.lang.Long> r5 = r4.nextSampleTimestampUs     // Catch:{ all -> 0x0037 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0037 }
            r5.set(r6)     // Catch:{ all -> 0x0037 }
            goto L_0x0035
        L_0x002b:
            long r5 = r4.timestampOffsetUs     // Catch:{ all -> 0x0037 }
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x0035
            r4.wait()     // Catch:{ all -> 0x0037 }
            goto L_0x002b
        L_0x0035:
            monitor-exit(r4)
            return
        L_0x0037:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.TimestampAdjuster.sharedInitializeOrWait(boolean, long):void");
    }
}
