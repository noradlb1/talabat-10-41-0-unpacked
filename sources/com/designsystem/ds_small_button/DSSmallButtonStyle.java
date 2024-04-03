package com.designsystem.ds_small_button;

import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/designsystem/ds_small_button/DSSmallButtonStyle;", "", "hasHapticFeedback", "", "titleStyle", "Landroidx/compose/ui/text/TextStyle;", "(ZLandroidx/compose/ui/text/TextStyle;)V", "getHasHapticFeedback", "()Z", "getTitleStyle", "()Landroidx/compose/ui/text/TextStyle;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DSSmallButtonStyle {
    private final boolean hasHapticFeedback;
    @NotNull
    private final TextStyle titleStyle;

    public DSSmallButtonStyle(boolean z11, @NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "titleStyle");
        this.hasHapticFeedback = z11;
        this.titleStyle = textStyle;
    }

    public static /* synthetic */ DSSmallButtonStyle copy$default(DSSmallButtonStyle dSSmallButtonStyle, boolean z11, TextStyle textStyle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = dSSmallButtonStyle.hasHapticFeedback;
        }
        if ((i11 & 2) != 0) {
            textStyle = dSSmallButtonStyle.titleStyle;
        }
        return dSSmallButtonStyle.copy(z11, textStyle);
    }

    public final boolean component1() {
        return this.hasHapticFeedback;
    }

    @NotNull
    public final TextStyle component2() {
        return this.titleStyle;
    }

    @NotNull
    public final DSSmallButtonStyle copy(boolean z11, @NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "titleStyle");
        return new DSSmallButtonStyle(z11, textStyle);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DSSmallButtonStyle)) {
            return false;
        }
        DSSmallButtonStyle dSSmallButtonStyle = (DSSmallButtonStyle) obj;
        return this.hasHapticFeedback == dSSmallButtonStyle.hasHapticFeedback && Intrinsics.areEqual((Object) this.titleStyle, (Object) dSSmallButtonStyle.titleStyle);
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
        return ((z11 ? 1 : 0) * true) + this.titleStyle.hashCode();
    }

    @NotNull
    public String toString() {
        return "DSSmallButtonStyle(hasHapticFeedback=" + this.hasHapticFeedback + ", titleStyle=" + this.titleStyle + ')';
    }
}
