package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u001a,\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0000\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n\u001a\u0015\u0010\u000b\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n\u001a\u0015\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\n¨\u0006\r"}, d2 = {"complexQuadraticFormula", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "a", "", "b", "c", "complexSqrt", "num", "minus", "other", "plus", "times", "animation-core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ComplexDoubleKt {
    @NotNull
    public static final Pair<ComplexDouble, ComplexDouble> complexQuadraticFormula(double d11, double d12, double d13) {
        double d14 = -d12;
        double d15 = (d12 * d12) - ((4.0d * d11) * d13);
        ComplexDouble complexSqrt = complexSqrt(d15);
        complexSqrt._real = complexSqrt._real + d14;
        double d16 = d11 * 2.0d;
        complexSqrt._real = complexSqrt._real / d16;
        complexSqrt._imaginary = complexSqrt._imaginary / d16;
        ComplexDouble complexSqrt2 = complexSqrt(d15);
        double d17 = (double) -1;
        complexSqrt2._real = complexSqrt2._real * d17;
        complexSqrt2._imaginary = complexSqrt2._imaginary * d17;
        complexSqrt2._real = complexSqrt2._real + d14;
        complexSqrt2._real = complexSqrt2._real / d16;
        complexSqrt2._imaginary = complexSqrt2._imaginary / d16;
        return TuplesKt.to(complexSqrt, complexSqrt2);
    }

    @NotNull
    public static final ComplexDouble complexSqrt(double d11) {
        if (d11 < 0.0d) {
            return new ComplexDouble(0.0d, Math.sqrt(Math.abs(d11)));
        }
        return new ComplexDouble(Math.sqrt(d11), 0.0d);
    }

    @NotNull
    public static final ComplexDouble minus(double d11, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        double d12 = (double) -1;
        complexDouble._real = complexDouble._real * d12;
        complexDouble._imaginary = complexDouble._imaginary * d12;
        complexDouble._real = complexDouble._real + d11;
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble plus(double d11, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        complexDouble._real = complexDouble._real + d11;
        return complexDouble;
    }

    @NotNull
    public static final ComplexDouble times(double d11, @NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        complexDouble._real = complexDouble._real * d11;
        complexDouble._imaginary = complexDouble._imaginary * d11;
        return complexDouble;
    }
}
