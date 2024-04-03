package com.designsystem.ds_branded_button;

import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/designsystem/ds_branded_button/DSBrandedButtonStyle;", "", "hasHapticFeedback", "", "titleStyle", "Landroidx/compose/ui/text/TextStyle;", "disabledIconAlpha", "", "(ZLandroidx/compose/ui/text/TextStyle;F)V", "getDisabledIconAlpha", "()F", "getHasHapticFeedback", "()Z", "getTitleStyle", "()Landroidx/compose/ui/text/TextStyle;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSBrandedButtonStyle {
    private final float disabledIconAlpha;
    private final boolean hasHapticFeedback;
    @NotNull
    private final TextStyle titleStyle;

    public DSBrandedButtonStyle(boolean z11, @NotNull TextStyle textStyle, float f11) {
        Intrinsics.checkNotNullParameter(textStyle, "titleStyle");
        this.hasHapticFeedback = z11;
        this.titleStyle = textStyle;
        this.disabledIconAlpha = f11;
    }

    public static /* synthetic */ DSBrandedButtonStyle copy$default(DSBrandedButtonStyle dSBrandedButtonStyle, boolean z11, TextStyle textStyle, float f11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = dSBrandedButtonStyle.hasHapticFeedback;
        }
        if ((i11 & 2) != 0) {
            textStyle = dSBrandedButtonStyle.titleStyle;
        }
        if ((i11 & 4) != 0) {
            f11 = dSBrandedButtonStyle.disabledIconAlpha;
        }
        return dSBrandedButtonStyle.copy(z11, textStyle, f11);
    }

    public final boolean component1() {
        return this.hasHapticFeedback;
    }

    @NotNull
    public final TextStyle component2() {
        return this.titleStyle;
    }

    public final float component3() {
        return this.disabledIconAlpha;
    }

    @NotNull
    public final DSBrandedButtonStyle copy(boolean z11, @NotNull TextStyle textStyle, float f11) {
        Intrinsics.checkNotNullParameter(textStyle, "titleStyle");
        return new DSBrandedButtonStyle(z11, textStyle, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSBrandedButtonStyle)) {
            return false;
        }
        DSBrandedButtonStyle dSBrandedButtonStyle = (DSBrandedButtonStyle) obj;
        return this.hasHapticFeedback == dSBrandedButtonStyle.hasHapticFeedback && Intrinsics.areEqual((Object) this.titleStyle, (Object) dSBrandedButtonStyle.titleStyle) && Intrinsics.areEqual((Object) Float.valueOf(this.disabledIconAlpha), (Object) Float.valueOf(dSBrandedButtonStyle.disabledIconAlpha));
    }

    public final float getDisabledIconAlpha() {
        return this.disabledIconAlpha;
    }

    public final boolean getHasHapticFeedback() {
        return this.hasHapticFeedback;
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
        return ((((z11 ? 1 : 0) * true) + this.titleStyle.hashCode()) * 31) + Float.floatToIntBits(this.disabledIconAlpha);
    }

    @NotNull
    public String toString() {
        return "DSBrandedButtonStyle(hasHapticFeedback=" + this.hasHapticFeedback + ", titleStyle=" + this.titleStyle + ", disabledIconAlpha=" + this.disabledIconAlpha + ')';
    }
}
