package com.checkout.frames.style.component.addresssummary;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.DividerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/checkout/frames/style/component/addresssummary/AddressSummarySectionStyle;", "", "addressTextStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "dividerStyle", "Lcom/checkout/frames/style/component/base/DividerStyle;", "editAddressButtonStyle", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "(Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/DividerStyle;Lcom/checkout/frames/style/component/base/ButtonStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getAddressTextStyle", "()Lcom/checkout/frames/style/component/base/TextLabelStyle;", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getDividerStyle", "()Lcom/checkout/frames/style/component/base/DividerStyle;", "getEditAddressButtonStyle", "()Lcom/checkout/frames/style/component/base/ButtonStyle;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummarySectionStyle {
    public static final int $stable = 8;
    @NotNull
    private final TextLabelStyle addressTextStyle;
    @NotNull
    private final ContainerStyle containerStyle;
    @Nullable
    private final DividerStyle dividerStyle;
    @NotNull
    private final ButtonStyle editAddressButtonStyle;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddressSummarySectionStyle(@NotNull TextLabelStyle textLabelStyle, @NotNull ButtonStyle buttonStyle, @NotNull ContainerStyle containerStyle2) {
        this(textLabelStyle, (DividerStyle) null, buttonStyle, containerStyle2, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "addressTextStyle");
        Intrinsics.checkNotNullParameter(buttonStyle, "editAddressButtonStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
    }

    @JvmOverloads
    public AddressSummarySectionStyle(@NotNull TextLabelStyle textLabelStyle, @Nullable DividerStyle dividerStyle2, @NotNull ButtonStyle buttonStyle, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "addressTextStyle");
        Intrinsics.checkNotNullParameter(buttonStyle, "editAddressButtonStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        this.addressTextStyle = textLabelStyle;
        this.dividerStyle = dividerStyle2;
        this.editAddressButtonStyle = buttonStyle;
        this.containerStyle = containerStyle2;
    }

    public static /* synthetic */ AddressSummarySectionStyle copy$default(AddressSummarySectionStyle addressSummarySectionStyle, TextLabelStyle textLabelStyle, DividerStyle dividerStyle2, ButtonStyle buttonStyle, ContainerStyle containerStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelStyle = addressSummarySectionStyle.addressTextStyle;
        }
        if ((i11 & 2) != 0) {
            dividerStyle2 = addressSummarySectionStyle.dividerStyle;
        }
        if ((i11 & 4) != 0) {
            buttonStyle = addressSummarySectionStyle.editAddressButtonStyle;
        }
        if ((i11 & 8) != 0) {
            containerStyle2 = addressSummarySectionStyle.containerStyle;
        }
        return addressSummarySectionStyle.copy(textLabelStyle, dividerStyle2, buttonStyle, containerStyle2);
    }

    @NotNull
    public final TextLabelStyle component1() {
        return this.addressTextStyle;
    }

    @Nullable
    public final DividerStyle component2() {
        return this.dividerStyle;
    }

    @NotNull
    public final ButtonStyle component3() {
        return this.editAddressButtonStyle;
    }

    @NotNull
    public final ContainerStyle component4() {
        return this.containerStyle;
    }

    @NotNull
    public final AddressSummarySectionStyle copy(@NotNull TextLabelStyle textLabelStyle, @Nullable DividerStyle dividerStyle2, @NotNull ButtonStyle buttonStyle, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "addressTextStyle");
        Intrinsics.checkNotNullParameter(buttonStyle, "editAddressButtonStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new AddressSummarySectionStyle(textLabelStyle, dividerStyle2, buttonStyle, containerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressSummarySectionStyle)) {
            return false;
        }
        AddressSummarySectionStyle addressSummarySectionStyle = (AddressSummarySectionStyle) obj;
        return Intrinsics.areEqual((Object) this.addressTextStyle, (Object) addressSummarySectionStyle.addressTextStyle) && Intrinsics.areEqual((Object) this.dividerStyle, (Object) addressSummarySectionStyle.dividerStyle) && Intrinsics.areEqual((Object) this.editAddressButtonStyle, (Object) addressSummarySectionStyle.editAddressButtonStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) addressSummarySectionStyle.containerStyle);
    }

    @NotNull
    public final TextLabelStyle getAddressTextStyle() {
        return this.addressTextStyle;
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @Nullable
    public final DividerStyle getDividerStyle() {
        return this.dividerStyle;
    }

    @NotNull
    public final ButtonStyle getEditAddressButtonStyle() {
        return this.editAddressButtonStyle;
    }

    public int hashCode() {
        int hashCode = this.addressTextStyle.hashCode() * 31;
        DividerStyle dividerStyle2 = this.dividerStyle;
        return ((((hashCode + (dividerStyle2 == null ? 0 : dividerStyle2.hashCode())) * 31) + this.editAddressButtonStyle.hashCode()) * 31) + this.containerStyle.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelStyle textLabelStyle = this.addressTextStyle;
        DividerStyle dividerStyle2 = this.dividerStyle;
        ButtonStyle buttonStyle = this.editAddressButtonStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        return "AddressSummarySectionStyle(addressTextStyle=" + textLabelStyle + ", dividerStyle=" + dividerStyle2 + ", editAddressButtonStyle=" + buttonStyle + ", containerStyle=" + containerStyle2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressSummarySectionStyle(TextLabelStyle textLabelStyle, DividerStyle dividerStyle2, ButtonStyle buttonStyle, ContainerStyle containerStyle2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLabelStyle, (i11 & 2) != 0 ? null : dividerStyle2, buttonStyle, containerStyle2);
    }
}
