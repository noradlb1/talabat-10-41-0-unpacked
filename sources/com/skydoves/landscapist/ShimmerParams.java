package com.skydoves.landscapist;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\rJ\u0019\u0010\u0018\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\rJ\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003JR\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\nHÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006'"}, d2 = {"Lcom/skydoves/landscapist/ShimmerParams;", "", "baseColor", "Landroidx/compose/ui/graphics/Color;", "highlightColor", "intensity", "", "dropOff", "tilt", "durationMillis", "", "(JJFFFILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBaseColor-0d7_KjU", "()J", "J", "getDropOff", "()F", "getDurationMillis", "()I", "getHighlightColor-0d7_KjU", "getIntensity", "getTilt", "component1", "component1-0d7_KjU", "component2", "component2-0d7_KjU", "component3", "component4", "component5", "component6", "copy", "copy-Klgx-Pg", "(JJFFFI)Lcom/skydoves/landscapist/ShimmerParams;", "equals", "", "other", "hashCode", "toString", "", "landscapist_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ShimmerParams {
    public static final int $stable = 0;
    private final long baseColor;
    private final float dropOff;
    private final int durationMillis;
    private final long highlightColor;
    private final float intensity;
    private final float tilt;

    private ShimmerParams(long j11, long j12, float f11, float f12, float f13, int i11) {
        this.baseColor = j11;
        this.highlightColor = j12;
        this.intensity = f11;
        this.dropOff = f12;
        this.tilt = f13;
        this.durationMillis = i11;
    }

    public /* synthetic */ ShimmerParams(long j11, long j12, float f11, float f12, float f13, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, f11, f12, f13, i11);
    }

    /* renamed from: copy-Klgx-Pg$default  reason: not valid java name */
    public static /* synthetic */ ShimmerParams m9400copyKlgxPg$default(ShimmerParams shimmerParams, long j11, long j12, float f11, float f12, float f13, int i11, int i12, Object obj) {
        ShimmerParams shimmerParams2 = shimmerParams;
        return shimmerParams.m9403copyKlgxPg((i12 & 1) != 0 ? shimmerParams2.baseColor : j11, (i12 & 2) != 0 ? shimmerParams2.highlightColor : j12, (i12 & 4) != 0 ? shimmerParams2.intensity : f11, (i12 & 8) != 0 ? shimmerParams2.dropOff : f12, (i12 & 16) != 0 ? shimmerParams2.tilt : f13, (i12 & 32) != 0 ? shimmerParams2.durationMillis : i11);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m9401component10d7_KjU() {
        return this.baseColor;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m9402component20d7_KjU() {
        return this.highlightColor;
    }

    public final float component3() {
        return this.intensity;
    }

    public final float component4() {
        return this.dropOff;
    }

    public final float component5() {
        return this.tilt;
    }

    public final int component6() {
        return this.durationMillis;
    }

    @NotNull
    /* renamed from: copy-Klgx-Pg  reason: not valid java name */
    public final ShimmerParams m9403copyKlgxPg(long j11, long j12, float f11, float f12, float f13, int i11) {
        return new ShimmerParams(j11, j12, f11, f12, f13, i11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShimmerParams)) {
            return false;
        }
        ShimmerParams shimmerParams = (ShimmerParams) obj;
        return Color.m2920equalsimpl0(this.baseColor, shimmerParams.baseColor) && Color.m2920equalsimpl0(this.highlightColor, shimmerParams.highlightColor) && Intrinsics.areEqual((Object) Float.valueOf(this.intensity), (Object) Float.valueOf(shimmerParams.intensity)) && Intrinsics.areEqual((Object) Float.valueOf(this.dropOff), (Object) Float.valueOf(shimmerParams.dropOff)) && Intrinsics.areEqual((Object) Float.valueOf(this.tilt), (Object) Float.valueOf(shimmerParams.tilt)) && this.durationMillis == shimmerParams.durationMillis;
    }

    /* renamed from: getBaseColor-0d7_KjU  reason: not valid java name */
    public final long m9404getBaseColor0d7_KjU() {
        return this.baseColor;
    }

    public final float getDropOff() {
        return this.dropOff;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: getHighlightColor-0d7_KjU  reason: not valid java name */
    public final long m9405getHighlightColor0d7_KjU() {
        return this.highlightColor;
    }

    public final float getIntensity() {
        return this.intensity;
    }

    public final float getTilt() {
        return this.tilt;
    }

    public int hashCode() {
        return (((((((((Color.m2926hashCodeimpl(this.baseColor) * 31) + Color.m2926hashCodeimpl(this.highlightColor)) * 31) + Float.floatToIntBits(this.intensity)) * 31) + Float.floatToIntBits(this.dropOff)) * 31) + Float.floatToIntBits(this.tilt)) * 31) + this.durationMillis;
    }

    @NotNull
    public String toString() {
        String r02 = Color.m2927toStringimpl(this.baseColor);
        String r12 = Color.m2927toStringimpl(this.highlightColor);
        float f11 = this.intensity;
        float f12 = this.dropOff;
        float f13 = this.tilt;
        int i11 = this.durationMillis;
        return "ShimmerParams(baseColor=" + r02 + ", highlightColor=" + r12 + ", intensity=" + f11 + ", dropOff=" + f12 + ", tilt=" + f13 + ", durationMillis=" + i11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShimmerParams(long j11, long j12, float f11, float f12, float f13, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, (i12 & 4) != 0 ? 0.0f : f11, (i12 & 8) != 0 ? 0.5f : f12, (i12 & 16) != 0 ? 20.0f : f13, (i12 & 32) != 0 ? 650 : i11, (DefaultConstructorMarker) null);
    }
}
