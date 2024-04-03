package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public DensityImpl(float f11, float f12) {
        this.density = f11;
        this.fontScale = f12;
    }

    public static /* synthetic */ DensityImpl copy$default(DensityImpl densityImpl, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = densityImpl.getDensity();
        }
        if ((i11 & 2) != 0) {
            f12 = densityImpl.getFontScale();
        }
        return densityImpl.copy(f11, f12);
    }

    public final float component1() {
        return getDensity();
    }

    public final float component2() {
        return getFontScale();
    }

    @NotNull
    public final DensityImpl copy(float f11, float f12) {
        return new DensityImpl(f11, f12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DensityImpl)) {
            return false;
        }
        DensityImpl densityImpl = (DensityImpl) obj;
        return Intrinsics.areEqual((Object) Float.valueOf(getDensity()), (Object) Float.valueOf(densityImpl.getDensity())) && Intrinsics.areEqual((Object) Float.valueOf(getFontScale()), (Object) Float.valueOf(densityImpl.getFontScale()));
    }

    public float getDensity() {
        return this.density;
    }

    public float getFontScale() {
        return this.fontScale;
    }

    public int hashCode() {
        return (Float.floatToIntBits(getDensity()) * 31) + Float.floatToIntBits(getFontScale());
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ int m5464roundToPxR2X_6o(long j11) {
        return a.a(this, j11);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public /* synthetic */ int m5465roundToPx0680j_4(float f11) {
        return a.b(this, f11);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public /* synthetic */ float m5466toDpGaN1DYA(long j11) {
        return a.c(this, j11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m5467toDpu2uoSUM(float f11) {
        return a.d(this, f11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m5468toDpu2uoSUM(int i11) {
        return a.e(this, i11);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public /* synthetic */ long m5469toDpSizekrfVVM(long j11) {
        return a.f(this, j11);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ float m5470toPxR2X_6o(long j11) {
        return a.g(this, j11);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public /* synthetic */ float m5471toPx0680j_4(float f11) {
        return a.h(this, f11);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return a.i(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public /* synthetic */ long m5472toSizeXkaWNTQ(long j11) {
        return a.j(this, j11);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public /* synthetic */ long m5473toSp0xMU5do(float f11) {
        return a.k(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m5474toSpkPz2Gy4(float f11) {
        return a.l(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m5475toSpkPz2Gy4(int i11) {
        return a.m(this, i11);
    }

    @NotNull
    public String toString() {
        return "DensityImpl(density=" + getDensity() + ", fontScale=" + getFontScale() + ')';
    }
}
