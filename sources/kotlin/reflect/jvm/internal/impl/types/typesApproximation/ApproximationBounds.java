package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ApproximationBounds<T> {
    private final T lower;
    private final T upper;

    public ApproximationBounds(T t11, T t12) {
        this.lower = t11;
        this.upper = t12;
    }

    public final T component1() {
        return this.lower;
    }

    public final T component2() {
        return this.upper;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApproximationBounds)) {
            return false;
        }
        ApproximationBounds approximationBounds = (ApproximationBounds) obj;
        return Intrinsics.areEqual((Object) this.lower, (Object) approximationBounds.lower) && Intrinsics.areEqual((Object) this.upper, (Object) approximationBounds.upper);
    }

    public final T getLower() {
        return this.lower;
    }

    public final T getUpper() {
        return this.upper;
    }

    public int hashCode() {
        T t11 = this.lower;
        int i11 = 0;
        int hashCode = (t11 == null ? 0 : t11.hashCode()) * 31;
        T t12 = this.upper;
        if (t12 != null) {
            i11 = t12.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        return "ApproximationBounds(lower=" + this.lower + ", upper=" + this.upper + ')';
    }
}
