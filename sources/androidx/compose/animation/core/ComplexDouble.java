package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÂ\u0003J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\nJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\nJ\u0011\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\nJ\u0011\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\nJ\u0011\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0003H\nJ\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0000H\nR\u000e\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/core/ComplexDouble;", "", "_real", "", "_imaginary", "(DD)V", "imaginary", "getImaginary", "()D", "real", "getReal", "component1", "component2", "copy", "div", "other", "equals", "", "hashCode", "", "minus", "plus", "times", "toString", "", "unaryMinus", "animation-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComplexDouble {
    /* access modifiers changed from: private */
    public double _imaginary;
    /* access modifiers changed from: private */
    public double _real;

    public ComplexDouble(double d11, double d12) {
        this._real = d11;
        this._imaginary = d12;
    }

    private final double component1() {
        return this._real;
    }

    private final double component2() {
        return this._imaginary;
    }

    public static /* synthetic */ ComplexDouble copy$default(ComplexDouble complexDouble, double d11, double d12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            d11 = complexDouble._real;
        }
        if ((i11 & 2) != 0) {
            d12 = complexDouble._imaginary;
        }
        return complexDouble.copy(d11, d12);
    }

    @NotNull
    public final ComplexDouble copy(double d11, double d12) {
        return new ComplexDouble(d11, d12);
    }

    @NotNull
    public final ComplexDouble div(double d11) {
        this._real = this._real / d11;
        this._imaginary = this._imaginary / d11;
        return this;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComplexDouble)) {
            return false;
        }
        ComplexDouble complexDouble = (ComplexDouble) obj;
        return Intrinsics.areEqual((Object) Double.valueOf(this._real), (Object) Double.valueOf(complexDouble._real)) && Intrinsics.areEqual((Object) Double.valueOf(this._imaginary), (Object) Double.valueOf(complexDouble._imaginary));
    }

    public final double getImaginary() {
        return this._imaginary;
    }

    public final double getReal() {
        return this._real;
    }

    public int hashCode() {
        return (Double.doubleToLongBits(this._real) * 31) + Double.doubleToLongBits(this._imaginary);
    }

    @NotNull
    public final ComplexDouble minus(double d11) {
        this._real = this._real + (-d11);
        return this;
    }

    @NotNull
    public final ComplexDouble plus(double d11) {
        this._real = this._real + d11;
        return this;
    }

    @NotNull
    public final ComplexDouble times(double d11) {
        this._real = this._real * d11;
        this._imaginary = this._imaginary * d11;
        return this;
    }

    @NotNull
    public String toString() {
        return "ComplexDouble(_real=" + this._real + ", _imaginary=" + this._imaginary + ')';
    }

    @NotNull
    public final ComplexDouble unaryMinus() {
        double d11 = (double) -1;
        this._real = this._real * d11;
        this._imaginary = this._imaginary * d11;
        return this;
    }

    @NotNull
    public final ComplexDouble minus(@NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        double d11 = (double) -1;
        complexDouble._real = complexDouble._real * d11;
        complexDouble._imaginary = complexDouble._imaginary * d11;
        this._real = this._real + complexDouble.getReal();
        this._imaginary = this._imaginary + complexDouble.getImaginary();
        return this;
    }

    @NotNull
    public final ComplexDouble plus(@NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        this._real = this._real + complexDouble.getReal();
        this._imaginary = this._imaginary + complexDouble.getImaginary();
        return this;
    }

    @NotNull
    public final ComplexDouble times(@NotNull ComplexDouble complexDouble) {
        Intrinsics.checkNotNullParameter(complexDouble, "other");
        this._real = (getReal() * complexDouble.getReal()) - (getImaginary() * complexDouble.getImaginary());
        this._imaginary = (getReal() * complexDouble.getImaginary()) + (complexDouble.getReal() * getImaginary());
        return this;
    }
}
