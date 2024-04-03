package androidx.compose.foundation.lazy;

import androidx.compose.runtime.collection.MutableVector;
import com.instabug.library.model.session.config.SessionsConfigParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "", "()V", "beyondBoundsItems", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "end", "", "getEnd", "()I", "start", "getStart", "addInterval", "hasIntervals", "", "removeInterval", "", "interval", "Interval", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyListBeyondBoundsInfo {
    @NotNull
    private final MutableVector<Interval> beyondBoundsItems = new MutableVector<>(new Interval[16], 0);

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo$Interval;", "", "start", "", "end", "(II)V", "getEnd", "()I", "getStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Interval {
        private final int end;
        private final int start;

        public Interval(int i11, int i12) {
            boolean z11;
            this.start = i11;
            this.end = i12;
            boolean z12 = true;
            if (i11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (!(i12 < i11 ? false : z12)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public static /* synthetic */ Interval copy$default(Interval interval, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = interval.start;
            }
            if ((i13 & 2) != 0) {
                i12 = interval.end;
            }
            return interval.copy(i11, i12);
        }

        public final int component1() {
            return this.start;
        }

        public final int component2() {
            return this.end;
        }

        @NotNull
        public final Interval copy(int i11, int i12) {
            return new Interval(i11, i12);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Interval)) {
                return false;
            }
            Interval interval = (Interval) obj;
            return this.start == interval.start && this.end == interval.end;
        }

        public final int getEnd() {
            return this.end;
        }

        public final int getStart() {
            return this.start;
        }

        public int hashCode() {
            return (this.start * 31) + this.end;
        }

        @NotNull
        public String toString() {
            return "Interval(start=" + this.start + ", end=" + this.end + ')';
        }
    }

    @NotNull
    public final Interval addInterval(int i11, int i12) {
        Interval interval = new Interval(i11, i12);
        this.beyondBoundsItems.add(interval);
        return interval;
    }

    public final int getEnd() {
        int end = this.beyondBoundsItems.first().getEnd();
        MutableVector<Interval> mutableVector = this.beyondBoundsItems;
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                Interval interval = (Interval) content[i11];
                if (interval.getEnd() > end) {
                    end = interval.getEnd();
                }
                i11++;
            } while (i11 < size);
        }
        return end;
    }

    public final int getStart() {
        int start = this.beyondBoundsItems.first().getStart();
        MutableVector<Interval> mutableVector = this.beyondBoundsItems;
        int size = mutableVector.getSize();
        boolean z11 = false;
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                Interval interval = (Interval) content[i11];
                if (interval.getStart() < start) {
                    start = interval.getStart();
                }
                i11++;
            } while (i11 < size);
        }
        if (start >= 0) {
            z11 = true;
        }
        if (z11) {
            return start;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final boolean hasIntervals() {
        return this.beyondBoundsItems.isNotEmpty();
    }

    public final void removeInterval(@NotNull Interval interval) {
        Intrinsics.checkNotNullParameter(interval, SessionsConfigParameter.SYNC_INTERVAL);
        this.beyondBoundsItems.remove(interval);
    }
}
