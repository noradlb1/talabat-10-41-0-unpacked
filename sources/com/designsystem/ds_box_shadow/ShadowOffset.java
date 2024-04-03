package com.designsystem.ds_box_shadow;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001c\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0019\u0010\n\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\u0007J\u0019\u0010\f\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\r\u0010\u0007J*\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0018"}, d2 = {"Lcom/designsystem/ds_box_shadow/ShadowOffset;", "", "x", "Landroidx/compose/ui/unit/Dp;", "y", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getX-D9Ej5fM", "()F", "F", "getY-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component2-D9Ej5fM", "copy", "copy-YgX7TsA", "(FF)Lcom/designsystem/ds_box_shadow/ShadowOffset;", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ShadowOffset {
    public static final int $stable = 0;

    /* renamed from: x  reason: collision with root package name */
    private final float f30607x;

    /* renamed from: y  reason: collision with root package name */
    private final float f30608y;

    private ShadowOffset(float f11, float f12) {
        this.f30607x = f11;
        this.f30608y = f12;
    }

    public /* synthetic */ ShadowOffset(float f11, float f12, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12);
    }

    /* renamed from: copy-YgX7TsA$default  reason: not valid java name */
    public static /* synthetic */ ShadowOffset m8275copyYgX7TsA$default(ShadowOffset shadowOffset, float f11, float f12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = shadowOffset.f30607x;
        }
        if ((i11 & 2) != 0) {
            f12 = shadowOffset.f30608y;
        }
        return shadowOffset.m8278copyYgX7TsA(f11, f12);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m8276component1D9Ej5fM() {
        return this.f30607x;
    }

    /* renamed from: component2-D9Ej5fM  reason: not valid java name */
    public final float m8277component2D9Ej5fM() {
        return this.f30608y;
    }

    @NotNull
    /* renamed from: copy-YgX7TsA  reason: not valid java name */
    public final ShadowOffset m8278copyYgX7TsA(float f11, float f12) {
        return new ShadowOffset(f11, f12, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShadowOffset)) {
            return false;
        }
        ShadowOffset shadowOffset = (ShadowOffset) obj;
        return Dp.m5483equalsimpl0(this.f30607x, shadowOffset.f30607x) && Dp.m5483equalsimpl0(this.f30608y, shadowOffset.f30608y);
    }

    /* renamed from: getX-D9Ej5fM  reason: not valid java name */
    public final float m8279getXD9Ej5fM() {
        return this.f30607x;
    }

    /* renamed from: getY-D9Ej5fM  reason: not valid java name */
    public final float m8280getYD9Ej5fM() {
        return this.f30608y;
    }

    public int hashCode() {
        return (Dp.m5484hashCodeimpl(this.f30607x) * 31) + Dp.m5484hashCodeimpl(this.f30608y);
    }

    @NotNull
    public String toString() {
        return "ShadowOffset(x=" + Dp.m5489toStringimpl(this.f30607x) + ", y=" + Dp.m5489toStringimpl(this.f30608y) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ShadowOffset(float f11, float f12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dp.m5478constructorimpl((float) 0) : f11, (i11 & 2) != 0 ? Dp.m5478constructorimpl((float) 0) : f12, (DefaultConstructorMarker) null);
    }
}
