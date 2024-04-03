package com.designsystem.ds_button_v2.composables;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B \u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0010\u001a\u00020\u0006HÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ4\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lcom/designsystem/ds_button_v2/composables/DSButtonWithPriceStyle;", "", "titleStyle", "Landroidx/compose/ui/text/TextStyle;", "counterStyle", "startPadding", "Landroidx/compose/ui/unit/Dp;", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCounterStyle", "()Landroidx/compose/ui/text/TextStyle;", "getStartPadding-D9Ej5fM", "()F", "F", "getTitleStyle", "component1", "component2", "component3", "component3-D9Ej5fM", "copy", "copy-wH6b6FI", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;F)Lcom/designsystem/ds_button_v2/composables/DSButtonWithPriceStyle;", "equals", "", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSButtonWithPriceStyle {
    @NotNull
    private final TextStyle counterStyle;
    private final float startPadding;
    @NotNull
    private final TextStyle titleStyle;

    private DSButtonWithPriceStyle(TextStyle textStyle, TextStyle textStyle2, float f11) {
        this.titleStyle = textStyle;
        this.counterStyle = textStyle2;
        this.startPadding = f11;
    }

    public /* synthetic */ DSButtonWithPriceStyle(TextStyle textStyle, TextStyle textStyle2, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(textStyle, textStyle2, f11);
    }

    /* renamed from: copy-wH6b6FI$default  reason: not valid java name */
    public static /* synthetic */ DSButtonWithPriceStyle m8304copywH6b6FI$default(DSButtonWithPriceStyle dSButtonWithPriceStyle, TextStyle textStyle, TextStyle textStyle2, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textStyle = dSButtonWithPriceStyle.titleStyle;
        }
        if ((i11 & 2) != 0) {
            textStyle2 = dSButtonWithPriceStyle.counterStyle;
        }
        if ((i11 & 4) != 0) {
            f11 = dSButtonWithPriceStyle.startPadding;
        }
        return dSButtonWithPriceStyle.m8306copywH6b6FI(textStyle, textStyle2, f11);
    }

    @NotNull
    public final TextStyle component1() {
        return this.titleStyle;
    }

    @NotNull
    public final TextStyle component2() {
        return this.counterStyle;
    }

    /* renamed from: component3-D9Ej5fM  reason: not valid java name */
    public final float m8305component3D9Ej5fM() {
        return this.startPadding;
    }

    @NotNull
    /* renamed from: copy-wH6b6FI  reason: not valid java name */
    public final DSButtonWithPriceStyle m8306copywH6b6FI(@NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, float f11) {
        Intrinsics.checkNotNullParameter(textStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(textStyle2, "counterStyle");
        return new DSButtonWithPriceStyle(textStyle, textStyle2, f11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSButtonWithPriceStyle)) {
            return false;
        }
        DSButtonWithPriceStyle dSButtonWithPriceStyle = (DSButtonWithPriceStyle) obj;
        return Intrinsics.areEqual((Object) this.titleStyle, (Object) dSButtonWithPriceStyle.titleStyle) && Intrinsics.areEqual((Object) this.counterStyle, (Object) dSButtonWithPriceStyle.counterStyle) && Dp.m5483equalsimpl0(this.startPadding, dSButtonWithPriceStyle.startPadding);
    }

    @NotNull
    public final TextStyle getCounterStyle() {
        return this.counterStyle;
    }

    /* renamed from: getStartPadding-D9Ej5fM  reason: not valid java name */
    public final float m8307getStartPaddingD9Ej5fM() {
        return this.startPadding;
    }

    @NotNull
    public final TextStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        return (((this.titleStyle.hashCode() * 31) + this.counterStyle.hashCode()) * 31) + Dp.m5484hashCodeimpl(this.startPadding);
    }

    @NotNull
    public String toString() {
        return "DSButtonWithPriceStyle(titleStyle=" + this.titleStyle + ", counterStyle=" + this.counterStyle + ", startPadding=" + Dp.m5489toStringimpl(this.startPadding) + ')';
    }
}
