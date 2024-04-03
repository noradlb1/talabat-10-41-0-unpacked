package kotlin.time;

import kotlin.Metadata;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"checkInfiniteSumDefined", "", "longNs", "duration", "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class LongSaturatedMathKt {
    /* renamed from: checkInfiniteSumDefined-PjuGub4  reason: not valid java name */
    private static final long m7744checkInfiniteSumDefinedPjuGub4(long j11, long j12, long j13) {
        if (!Duration.m7649isInfiniteimpl(j12) || (j11 ^ j13) >= 0) {
            return j11;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* renamed from: saturatingAdd-pTJri5U  reason: not valid java name */
    public static final long m7745saturatingAddpTJri5U(long j11, long j12) {
        long r42 = Duration.m7637getInWholeNanosecondsimpl(j12);
        if (((j11 - 1) | 1) == Long.MAX_VALUE) {
            return m7744checkInfiniteSumDefinedPjuGub4(j11, j12, r42);
        }
        if ((1 | (r42 - 1)) == Long.MAX_VALUE) {
            return m7746saturatingAddInHalvespTJri5U(j11, j12);
        }
        long j13 = j11 + r42;
        if (((j11 ^ j13) & (r42 ^ j13)) >= 0) {
            return j13;
        }
        if (j11 < 0) {
            return Long.MIN_VALUE;
        }
        return Long.MAX_VALUE;
    }

    /* renamed from: saturatingAddInHalves-pTJri5U  reason: not valid java name */
    private static final long m7746saturatingAddInHalvespTJri5U(long j11, long j12) {
        long r02 = Duration.m7620divUwyO8pc(j12, 2);
        if (((Duration.m7637getInWholeNanosecondsimpl(r02) - 1) | 1) == Long.MAX_VALUE) {
            return (long) (((double) j11) + Duration.m7660toDoubleimpl(j12, DurationUnit.NANOSECONDS));
        }
        return m7745saturatingAddpTJri5U(m7745saturatingAddpTJri5U(j11, r02), r02);
    }

    public static final long saturatingDiff(long j11, long j12) {
        if ((1 | (j12 - 1)) == Long.MAX_VALUE) {
            return Duration.m7669unaryMinusUwyO8pc(DurationKt.toDuration(j12, DurationUnit.DAYS));
        }
        long j13 = j11 - j12;
        if (((j13 ^ j11) & (~(j13 ^ j12))) < 0) {
            long j14 = (long) 1000000;
            long j15 = (j11 % j14) - (j12 % j14);
            Duration.Companion companion = Duration.Companion;
            return Duration.m7653plusLRDsOJo(DurationKt.toDuration((j11 / j14) - (j12 / j14), DurationUnit.MILLISECONDS), DurationKt.toDuration(j15, DurationUnit.NANOSECONDS));
        }
        Duration.Companion companion2 = Duration.Companion;
        return DurationKt.toDuration(j13, DurationUnit.NANOSECONDS);
    }
}
