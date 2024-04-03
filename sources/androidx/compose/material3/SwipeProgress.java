package androidx.compose.material3;

import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@ExperimentalMaterial3Api
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/SwipeProgress;", "T", "", "from", "to", "fraction", "", "(Ljava/lang/Object;Ljava/lang/Object;F)V", "getFraction", "()F", "getFrom", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTo", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SwipeProgress<T> {
    private final float fraction;
    private final T from;

    /* renamed from: to  reason: collision with root package name */
    private final T f8377to;

    public SwipeProgress(T t11, T t12, float f11) {
        this.from = t11;
        this.f8377to = t12;
        this.fraction = f11;
    }

    public boolean equals(@Nullable Object obj) {
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwipeProgress)) {
            return false;
        }
        SwipeProgress swipeProgress = (SwipeProgress) obj;
        if (!Intrinsics.areEqual((Object) this.from, (Object) swipeProgress.from) || !Intrinsics.areEqual((Object) this.f8377to, (Object) swipeProgress.f8377to)) {
            return false;
        }
        if (this.fraction == swipeProgress.fraction) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return false;
        }
        return true;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final T getFrom() {
        return this.from;
    }

    public final T getTo() {
        return this.f8377to;
    }

    public int hashCode() {
        int i11;
        T t11 = this.from;
        int i12 = 0;
        if (t11 != null) {
            i11 = t11.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = i11 * 31;
        T t12 = this.f8377to;
        if (t12 != null) {
            i12 = t12.hashCode();
        }
        return ((i13 + i12) * 31) + Float.floatToIntBits(this.fraction);
    }

    @NotNull
    public String toString() {
        return "SwipeProgress(from=" + this.from + ", to=" + this.f8377to + ", fraction=" + this.fraction + ')';
    }
}
