package com.checkout.frames.style.view;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B$\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\u0011\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u0005HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\nJ\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J4\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001c\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Lcom/checkout/frames/style/view/DividerViewStyle;", "", "thickness", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "(FJLandroidx/compose/ui/Modifier;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getModifier", "()Landroidx/compose/ui/Modifier;", "getThickness-D9Ej5fM", "()F", "F", "component1", "component1-D9Ej5fM", "component2", "component2-0d7_KjU", "component3", "copy", "copy-j79YCno", "(FJLandroidx/compose/ui/Modifier;)Lcom/checkout/frames/style/view/DividerViewStyle;", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DividerViewStyle {
    private final long color;
    @NotNull
    private final Modifier modifier;
    private final float thickness;

    private DividerViewStyle(float f11, long j11, Modifier modifier2) {
        this.thickness = f11;
        this.color = j11;
        this.modifier = modifier2;
    }

    public /* synthetic */ DividerViewStyle(float f11, long j11, Modifier modifier2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, j11, modifier2);
    }

    /* renamed from: copy-j79YCno$default  reason: not valid java name */
    public static /* synthetic */ DividerViewStyle m9262copyj79YCno$default(DividerViewStyle dividerViewStyle, float f11, long j11, Modifier modifier2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = dividerViewStyle.thickness;
        }
        if ((i11 & 2) != 0) {
            j11 = dividerViewStyle.color;
        }
        if ((i11 & 4) != 0) {
            modifier2 = dividerViewStyle.modifier;
        }
        return dividerViewStyle.m9265copyj79YCno(f11, j11, modifier2);
    }

    /* renamed from: component1-D9Ej5fM  reason: not valid java name */
    public final float m9263component1D9Ej5fM() {
        return this.thickness;
    }

    /* renamed from: component2-0d7_KjU  reason: not valid java name */
    public final long m9264component20d7_KjU() {
        return this.color;
    }

    @NotNull
    public final Modifier component3() {
        return this.modifier;
    }

    @NotNull
    /* renamed from: copy-j79YCno  reason: not valid java name */
    public final DividerViewStyle m9265copyj79YCno(float f11, long j11, @NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        return new DividerViewStyle(f11, j11, modifier2, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DividerViewStyle)) {
            return false;
        }
        DividerViewStyle dividerViewStyle = (DividerViewStyle) obj;
        return Dp.m5483equalsimpl0(this.thickness, dividerViewStyle.thickness) && Color.m2920equalsimpl0(this.color, dividerViewStyle.color) && Intrinsics.areEqual((Object) this.modifier, (Object) dividerViewStyle.modifier);
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m9266getColor0d7_KjU() {
        return this.color;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    /* renamed from: getThickness-D9Ej5fM  reason: not valid java name */
    public final float m9267getThicknessD9Ej5fM() {
        return this.thickness;
    }

    public int hashCode() {
        return (((Dp.m5484hashCodeimpl(this.thickness) * 31) + Color.m2926hashCodeimpl(this.color)) * 31) + this.modifier.hashCode();
    }

    @NotNull
    public String toString() {
        String r02 = Dp.m5489toStringimpl(this.thickness);
        String r12 = Color.m2927toStringimpl(this.color);
        Modifier modifier2 = this.modifier;
        return "DividerViewStyle(thickness=" + r02 + ", color=" + r12 + ", modifier=" + modifier2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DividerViewStyle(float f11, long j11, Modifier modifier2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, (i11 & 2) != 0 ? Color.Companion.m2951getLightGray0d7_KjU() : j11, (i11 & 4) != 0 ? Modifier.Companion : modifier2, (DefaultConstructorMarker) null);
    }
}
