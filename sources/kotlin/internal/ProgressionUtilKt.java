package kotlin.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002\u001a \u0010\u0000\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a \u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0001\u001a \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0001\u001a\u0018\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"differenceModulo", "", "a", "b", "c", "", "getProgressionLastElement", "start", "end", "step", "mod", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ProgressionUtilKt {
    private static final int differenceModulo(int i11, int i12, int i13) {
        return mod(mod(i11, i13) - mod(i12, i13), i13);
    }

    @PublishedApi
    public static final int getProgressionLastElement(int i11, int i12, int i13) {
        if (i13 > 0) {
            if (i11 >= i12) {
                return i12;
            }
            return i12 - differenceModulo(i12, i11, i13);
        } else if (i13 < 0) {
            return i11 <= i12 ? i12 : i12 + differenceModulo(i11, i12, -i13);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int mod(int i11, int i12) {
        int i13 = i11 % i12;
        return i13 >= 0 ? i13 : i13 + i12;
    }

    private static final long differenceModulo(long j11, long j12, long j13) {
        return mod(mod(j11, j13) - mod(j12, j13), j13);
    }

    private static final long mod(long j11, long j12) {
        long j13 = j11 % j12;
        return j13 >= 0 ? j13 : j13 + j12;
    }

    @PublishedApi
    public static final long getProgressionLastElement(long j11, long j12, long j13) {
        int i11 = (j13 > 0 ? 1 : (j13 == 0 ? 0 : -1));
        if (i11 > 0) {
            if (j11 >= j12) {
                return j12;
            }
            return j12 - differenceModulo(j12, j11, j13);
        } else if (i11 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (j11 <= j12) {
            return j12;
        } else {
            return j12 + differenceModulo(j11, j12, -j13);
        }
    }
}
