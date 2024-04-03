package com.checkout.frames.style.component;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.ButtonStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "", "buttonStyle", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "(Lcom/checkout/frames/style/component/base/ButtonStyle;)V", "getButtonStyle", "()Lcom/checkout/frames/style/component/base/ButtonStyle;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PayButtonComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private final ButtonStyle buttonStyle;

    public PayButtonComponentStyle(@NotNull ButtonStyle buttonStyle2) {
        Intrinsics.checkNotNullParameter(buttonStyle2, "buttonStyle");
        this.buttonStyle = buttonStyle2;
    }

    public static /* synthetic */ PayButtonComponentStyle copy$default(PayButtonComponentStyle payButtonComponentStyle, ButtonStyle buttonStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            buttonStyle2 = payButtonComponentStyle.buttonStyle;
        }
        return payButtonComponentStyle.copy(buttonStyle2);
    }

    @NotNull
    public final ButtonStyle component1() {
        return this.buttonStyle;
    }

    @NotNull
    public final PayButtonComponentStyle copy(@NotNull ButtonStyle buttonStyle2) {
        Intrinsics.checkNotNullParameter(buttonStyle2, "buttonStyle");
        return new PayButtonComponentStyle(buttonStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PayButtonComponentStyle) && Intrinsics.areEqual((Object) this.buttonStyle, (Object) ((PayButtonComponentStyle) obj).buttonStyle);
    }

    @NotNull
    public final ButtonStyle getButtonStyle() {
        return this.buttonStyle;
    }

    public int hashCode() {
        return this.buttonStyle.hashCode();
    }

    @NotNull
    public String toString() {
        ButtonStyle buttonStyle2 = this.buttonStyle;
        return "PayButtonComponentStyle(buttonStyle=" + buttonStyle2 + ")";
    }
}
