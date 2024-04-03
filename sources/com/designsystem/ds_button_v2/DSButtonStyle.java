package com.designsystem.ds_button_v2;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_spinner.DSSpinnerSize;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u001a\u001a\u00020\nHÆ\u0003ø\u0001\u0000ø\u0001\u0002ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u0011JH\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\t\u001a\u00020\nø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Lcom/designsystem/ds_button_v2/DSButtonStyle;", "", "hasHapticFeedback", "", "spinnerSize", "Lcom/designsystem/ds_spinner/DSSpinnerSize;", "titleStyle", "Landroidx/compose/ui/text/TextStyle;", "captionStyle", "iconSpacing", "Landroidx/compose/ui/unit/Dp;", "(ZLcom/designsystem/ds_spinner/DSSpinnerSize;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCaptionStyle", "()Landroidx/compose/ui/text/TextStyle;", "getHasHapticFeedback", "()Z", "getIconSpacing-D9Ej5fM", "()F", "F", "getSpinnerSize", "()Lcom/designsystem/ds_spinner/DSSpinnerSize;", "getTitleStyle", "component1", "component2", "component3", "component4", "component5", "component5-D9Ej5fM", "copy", "copy-M2VBTUQ", "(ZLcom/designsystem/ds_spinner/DSSpinnerSize;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;F)Lcom/designsystem/ds_button_v2/DSButtonStyle;", "equals", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSButtonStyle {
    @NotNull
    private final TextStyle captionStyle;
    private final boolean hasHapticFeedback;
    private final float iconSpacing;
    @NotNull
    private final DSSpinnerSize spinnerSize;
    @NotNull
    private final TextStyle titleStyle;

    private DSButtonStyle(boolean z11, DSSpinnerSize dSSpinnerSize, TextStyle textStyle, TextStyle textStyle2, float f11) {
        this.hasHapticFeedback = z11;
        this.spinnerSize = dSSpinnerSize;
        this.titleStyle = textStyle;
        this.captionStyle = textStyle2;
        this.iconSpacing = f11;
    }

    public /* synthetic */ DSButtonStyle(boolean z11, DSSpinnerSize dSSpinnerSize, TextStyle textStyle, TextStyle textStyle2, float f11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11, dSSpinnerSize, textStyle, textStyle2, f11);
    }

    /* renamed from: copy-M2VBTUQ$default  reason: not valid java name */
    public static /* synthetic */ DSButtonStyle m8289copyM2VBTUQ$default(DSButtonStyle dSButtonStyle, boolean z11, DSSpinnerSize dSSpinnerSize, TextStyle textStyle, TextStyle textStyle2, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = dSButtonStyle.hasHapticFeedback;
        }
        if ((i11 & 2) != 0) {
            dSSpinnerSize = dSButtonStyle.spinnerSize;
        }
        DSSpinnerSize dSSpinnerSize2 = dSSpinnerSize;
        if ((i11 & 4) != 0) {
            textStyle = dSButtonStyle.titleStyle;
        }
        TextStyle textStyle3 = textStyle;
        if ((i11 & 8) != 0) {
            textStyle2 = dSButtonStyle.captionStyle;
        }
        TextStyle textStyle4 = textStyle2;
        if ((i11 & 16) != 0) {
            f11 = dSButtonStyle.iconSpacing;
        }
        return dSButtonStyle.m8291copyM2VBTUQ(z11, dSSpinnerSize2, textStyle3, textStyle4, f11);
    }

    public final boolean component1() {
        return this.hasHapticFeedback;
    }

    @NotNull
    public final DSSpinnerSize component2() {
        return this.spinnerSize;
    }

    @NotNull
    public final TextStyle component3() {
        return this.titleStyle;
    }

    @NotNull
    public final TextStyle component4() {
        return this.captionStyle;
    }

    /* renamed from: component5-D9Ej5fM  reason: not valid java name */
    public final float m8290component5D9Ej5fM() {
        return this.iconSpacing;
    }

    @NotNull
    /* renamed from: copy-M2VBTUQ  reason: not valid java name */
    public final DSButtonStyle m8291copyM2VBTUQ(boolean z11, @NotNull DSSpinnerSize dSSpinnerSize, @NotNull TextStyle textStyle, @NotNull TextStyle textStyle2, float f11) {
        Intrinsics.checkNotNullParameter(dSSpinnerSize, "spinnerSize");
        Intrinsics.checkNotNullParameter(textStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(textStyle2, "captionStyle");
        return new DSButtonStyle(z11, dSSpinnerSize, textStyle, textStyle2, f11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSButtonStyle)) {
            return false;
        }
        DSButtonStyle dSButtonStyle = (DSButtonStyle) obj;
        return this.hasHapticFeedback == dSButtonStyle.hasHapticFeedback && this.spinnerSize == dSButtonStyle.spinnerSize && Intrinsics.areEqual((Object) this.titleStyle, (Object) dSButtonStyle.titleStyle) && Intrinsics.areEqual((Object) this.captionStyle, (Object) dSButtonStyle.captionStyle) && Dp.m5483equalsimpl0(this.iconSpacing, dSButtonStyle.iconSpacing);
    }

    @NotNull
    public final TextStyle getCaptionStyle() {
        return this.captionStyle;
    }

    public final boolean getHasHapticFeedback() {
        return this.hasHapticFeedback;
    }

    /* renamed from: getIconSpacing-D9Ej5fM  reason: not valid java name */
    public final float m8292getIconSpacingD9Ej5fM() {
        return this.iconSpacing;
    }

    @NotNull
    public final DSSpinnerSize getSpinnerSize() {
        return this.spinnerSize;
    }

    @NotNull
    public final TextStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        boolean z11 = this.hasHapticFeedback;
        if (z11) {
            z11 = true;
        }
        return ((((((((z11 ? 1 : 0) * true) + this.spinnerSize.hashCode()) * 31) + this.titleStyle.hashCode()) * 31) + this.captionStyle.hashCode()) * 31) + Dp.m5484hashCodeimpl(this.iconSpacing);
    }

    @NotNull
    public String toString() {
        return "DSButtonStyle(hasHapticFeedback=" + this.hasHapticFeedback + ", spinnerSize=" + this.spinnerSize + ", titleStyle=" + this.titleStyle + ", captionStyle=" + this.captionStyle + ", iconSpacing=" + Dp.m5489toStringimpl(this.iconSpacing) + ')';
    }
}
