package com.checkout.frames.style.theme;

import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.ButtonElevation;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputComponentStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/style/theme/RequestThemeStyles;", "", "inputComponentStyle", "Lcom/checkout/frames/style/component/base/InputComponentStyle;", "addressSummaryComponentStyle", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "buttonStyle", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "(Lcom/checkout/frames/style/component/base/InputComponentStyle;Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;Lcom/checkout/frames/style/component/base/ButtonStyle;)V", "getAddressSummaryComponentStyle", "()Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "getButtonStyle", "()Lcom/checkout/frames/style/component/base/ButtonStyle;", "getInputComponentStyle", "()Lcom/checkout/frames/style/component/base/InputComponentStyle;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RequestThemeStyles {
    @NotNull
    private final AddressSummaryComponentStyle addressSummaryComponentStyle;
    @NotNull
    private final ButtonStyle buttonStyle;
    @Nullable
    private final InputComponentStyle inputComponentStyle;

    public RequestThemeStyles() {
        this((InputComponentStyle) null, (AddressSummaryComponentStyle) null, (ButtonStyle) null, 7, (DefaultConstructorMarker) null);
    }

    public RequestThemeStyles(@Nullable InputComponentStyle inputComponentStyle2, @NotNull AddressSummaryComponentStyle addressSummaryComponentStyle2, @NotNull ButtonStyle buttonStyle2) {
        Intrinsics.checkNotNullParameter(addressSummaryComponentStyle2, "addressSummaryComponentStyle");
        Intrinsics.checkNotNullParameter(buttonStyle2, "buttonStyle");
        this.inputComponentStyle = inputComponentStyle2;
        this.addressSummaryComponentStyle = addressSummaryComponentStyle2;
        this.buttonStyle = buttonStyle2;
    }

    public static /* synthetic */ RequestThemeStyles copy$default(RequestThemeStyles requestThemeStyles, InputComponentStyle inputComponentStyle2, AddressSummaryComponentStyle addressSummaryComponentStyle2, ButtonStyle buttonStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            inputComponentStyle2 = requestThemeStyles.inputComponentStyle;
        }
        if ((i11 & 2) != 0) {
            addressSummaryComponentStyle2 = requestThemeStyles.addressSummaryComponentStyle;
        }
        if ((i11 & 4) != 0) {
            buttonStyle2 = requestThemeStyles.buttonStyle;
        }
        return requestThemeStyles.copy(inputComponentStyle2, addressSummaryComponentStyle2, buttonStyle2);
    }

    @Nullable
    public final InputComponentStyle component1() {
        return this.inputComponentStyle;
    }

    @NotNull
    public final AddressSummaryComponentStyle component2() {
        return this.addressSummaryComponentStyle;
    }

    @NotNull
    public final ButtonStyle component3() {
        return this.buttonStyle;
    }

    @NotNull
    public final RequestThemeStyles copy(@Nullable InputComponentStyle inputComponentStyle2, @NotNull AddressSummaryComponentStyle addressSummaryComponentStyle2, @NotNull ButtonStyle buttonStyle2) {
        Intrinsics.checkNotNullParameter(addressSummaryComponentStyle2, "addressSummaryComponentStyle");
        Intrinsics.checkNotNullParameter(buttonStyle2, "buttonStyle");
        return new RequestThemeStyles(inputComponentStyle2, addressSummaryComponentStyle2, buttonStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RequestThemeStyles)) {
            return false;
        }
        RequestThemeStyles requestThemeStyles = (RequestThemeStyles) obj;
        return Intrinsics.areEqual((Object) this.inputComponentStyle, (Object) requestThemeStyles.inputComponentStyle) && Intrinsics.areEqual((Object) this.addressSummaryComponentStyle, (Object) requestThemeStyles.addressSummaryComponentStyle) && Intrinsics.areEqual((Object) this.buttonStyle, (Object) requestThemeStyles.buttonStyle);
    }

    @NotNull
    public final AddressSummaryComponentStyle getAddressSummaryComponentStyle() {
        return this.addressSummaryComponentStyle;
    }

    @NotNull
    public final ButtonStyle getButtonStyle() {
        return this.buttonStyle;
    }

    @Nullable
    public final InputComponentStyle getInputComponentStyle() {
        return this.inputComponentStyle;
    }

    public int hashCode() {
        InputComponentStyle inputComponentStyle2 = this.inputComponentStyle;
        return ((((inputComponentStyle2 == null ? 0 : inputComponentStyle2.hashCode()) * 31) + this.addressSummaryComponentStyle.hashCode()) * 31) + this.buttonStyle.hashCode();
    }

    @NotNull
    public String toString() {
        InputComponentStyle inputComponentStyle2 = this.inputComponentStyle;
        AddressSummaryComponentStyle addressSummaryComponentStyle2 = this.addressSummaryComponentStyle;
        ButtonStyle buttonStyle2 = this.buttonStyle;
        return "RequestThemeStyles(inputComponentStyle=" + inputComponentStyle2 + ", addressSummaryComponentStyle=" + addressSummaryComponentStyle2 + ", buttonStyle=" + buttonStyle2 + ")";
    }

    public /* synthetic */ RequestThemeStyles(InputComponentStyle inputComponentStyle2, AddressSummaryComponentStyle addressSummaryComponentStyle2, ButtonStyle buttonStyle2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        RequestThemeStyles requestThemeStyles;
        ButtonStyle buttonStyle3;
        InputComponentStyle inputComponentStyle3 = (i11 & 1) != 0 ? null : inputComponentStyle2;
        AddressSummaryComponentStyle addressSummaryComponentStyle3 = (i11 & 2) != 0 ? new AddressSummaryComponentStyle((TextLabelStyle) null, (TextLabelStyle) null, (ButtonStyle) null, (AddressSummarySectionStyle) null, (ContainerStyle) null, false, 63, (DefaultConstructorMarker) null) : addressSummaryComponentStyle2;
        if ((i11 & 4) != 0) {
            buttonStyle3 = new ButtonStyle(0, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2047, (DefaultConstructorMarker) null);
            requestThemeStyles = this;
        } else {
            requestThemeStyles = this;
            buttonStyle3 = buttonStyle2;
        }
        new RequestThemeStyles(inputComponentStyle3, addressSummaryComponentStyle3, buttonStyle3);
    }
}
