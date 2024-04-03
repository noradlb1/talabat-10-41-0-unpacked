package com.checkout.frames.style.screen;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.style.component.CountryComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle;
import com.checkout.frames.style.component.billingformdetails.InputComponentsContainerStyle;
import com.checkout.frames.style.component.p003default.DefaultCountryComponentStyle;
import com.checkout.frames.style.screen.p004default.DefaultBillingAddressDetailsStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B/\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "", "headerComponentStyle", "Lcom/checkout/frames/style/component/billingformdetails/HeaderComponentStyle;", "inputComponentsContainerStyle", "Lcom/checkout/frames/style/component/billingformdetails/InputComponentsContainerStyle;", "countryComponentStyle", "Lcom/checkout/frames/style/component/CountryComponentStyle;", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "(Lcom/checkout/frames/style/component/billingformdetails/HeaderComponentStyle;Lcom/checkout/frames/style/component/billingformdetails/InputComponentsContainerStyle;Lcom/checkout/frames/style/component/CountryComponentStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "setContainerStyle", "(Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getCountryComponentStyle", "()Lcom/checkout/frames/style/component/CountryComponentStyle;", "setCountryComponentStyle", "(Lcom/checkout/frames/style/component/CountryComponentStyle;)V", "getHeaderComponentStyle", "()Lcom/checkout/frames/style/component/billingformdetails/HeaderComponentStyle;", "setHeaderComponentStyle", "(Lcom/checkout/frames/style/component/billingformdetails/HeaderComponentStyle;)V", "getInputComponentsContainerStyle", "()Lcom/checkout/frames/style/component/billingformdetails/InputComponentsContainerStyle;", "setInputComponentsContainerStyle", "(Lcom/checkout/frames/style/component/billingformdetails/InputComponentsContainerStyle;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingAddressDetailsStyle {
    public static final int $stable = 8;
    @NotNull
    private ContainerStyle containerStyle;
    @NotNull
    private CountryComponentStyle countryComponentStyle;
    @NotNull
    private HeaderComponentStyle headerComponentStyle;
    @NotNull
    private InputComponentsContainerStyle inputComponentsContainerStyle;

    @JvmOverloads
    public BillingAddressDetailsStyle() {
        this((HeaderComponentStyle) null, (InputComponentsContainerStyle) null, (CountryComponentStyle) null, (ContainerStyle) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BillingAddressDetailsStyle(@NotNull HeaderComponentStyle headerComponentStyle2) {
        this(headerComponentStyle2, (InputComponentsContainerStyle) null, (CountryComponentStyle) null, (ContainerStyle) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(headerComponentStyle2, "headerComponentStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BillingAddressDetailsStyle(@NotNull HeaderComponentStyle headerComponentStyle2, @NotNull InputComponentsContainerStyle inputComponentsContainerStyle2) {
        this(headerComponentStyle2, inputComponentsContainerStyle2, (CountryComponentStyle) null, (ContainerStyle) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(headerComponentStyle2, "headerComponentStyle");
        Intrinsics.checkNotNullParameter(inputComponentsContainerStyle2, "inputComponentsContainerStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BillingAddressDetailsStyle(@NotNull HeaderComponentStyle headerComponentStyle2, @NotNull InputComponentsContainerStyle inputComponentsContainerStyle2, @NotNull CountryComponentStyle countryComponentStyle2) {
        this(headerComponentStyle2, inputComponentsContainerStyle2, countryComponentStyle2, (ContainerStyle) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(headerComponentStyle2, "headerComponentStyle");
        Intrinsics.checkNotNullParameter(inputComponentsContainerStyle2, "inputComponentsContainerStyle");
        Intrinsics.checkNotNullParameter(countryComponentStyle2, "countryComponentStyle");
    }

    @JvmOverloads
    public BillingAddressDetailsStyle(@NotNull HeaderComponentStyle headerComponentStyle2, @NotNull InputComponentsContainerStyle inputComponentsContainerStyle2, @NotNull CountryComponentStyle countryComponentStyle2, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(headerComponentStyle2, "headerComponentStyle");
        Intrinsics.checkNotNullParameter(inputComponentsContainerStyle2, "inputComponentsContainerStyle");
        Intrinsics.checkNotNullParameter(countryComponentStyle2, "countryComponentStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        this.headerComponentStyle = headerComponentStyle2;
        this.inputComponentsContainerStyle = inputComponentsContainerStyle2;
        this.countryComponentStyle = countryComponentStyle2;
        this.containerStyle = containerStyle2;
    }

    public static /* synthetic */ BillingAddressDetailsStyle copy$default(BillingAddressDetailsStyle billingAddressDetailsStyle, HeaderComponentStyle headerComponentStyle2, InputComponentsContainerStyle inputComponentsContainerStyle2, CountryComponentStyle countryComponentStyle2, ContainerStyle containerStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            headerComponentStyle2 = billingAddressDetailsStyle.headerComponentStyle;
        }
        if ((i11 & 2) != 0) {
            inputComponentsContainerStyle2 = billingAddressDetailsStyle.inputComponentsContainerStyle;
        }
        if ((i11 & 4) != 0) {
            countryComponentStyle2 = billingAddressDetailsStyle.countryComponentStyle;
        }
        if ((i11 & 8) != 0) {
            containerStyle2 = billingAddressDetailsStyle.containerStyle;
        }
        return billingAddressDetailsStyle.copy(headerComponentStyle2, inputComponentsContainerStyle2, countryComponentStyle2, containerStyle2);
    }

    @NotNull
    public final HeaderComponentStyle component1() {
        return this.headerComponentStyle;
    }

    @NotNull
    public final InputComponentsContainerStyle component2() {
        return this.inputComponentsContainerStyle;
    }

    @NotNull
    public final CountryComponentStyle component3() {
        return this.countryComponentStyle;
    }

    @NotNull
    public final ContainerStyle component4() {
        return this.containerStyle;
    }

    @NotNull
    public final BillingAddressDetailsStyle copy(@NotNull HeaderComponentStyle headerComponentStyle2, @NotNull InputComponentsContainerStyle inputComponentsContainerStyle2, @NotNull CountryComponentStyle countryComponentStyle2, @NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(headerComponentStyle2, "headerComponentStyle");
        Intrinsics.checkNotNullParameter(inputComponentsContainerStyle2, "inputComponentsContainerStyle");
        Intrinsics.checkNotNullParameter(countryComponentStyle2, "countryComponentStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new BillingAddressDetailsStyle(headerComponentStyle2, inputComponentsContainerStyle2, countryComponentStyle2, containerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillingAddressDetailsStyle)) {
            return false;
        }
        BillingAddressDetailsStyle billingAddressDetailsStyle = (BillingAddressDetailsStyle) obj;
        return Intrinsics.areEqual((Object) this.headerComponentStyle, (Object) billingAddressDetailsStyle.headerComponentStyle) && Intrinsics.areEqual((Object) this.inputComponentsContainerStyle, (Object) billingAddressDetailsStyle.inputComponentsContainerStyle) && Intrinsics.areEqual((Object) this.countryComponentStyle, (Object) billingAddressDetailsStyle.countryComponentStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) billingAddressDetailsStyle.containerStyle);
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @NotNull
    public final CountryComponentStyle getCountryComponentStyle() {
        return this.countryComponentStyle;
    }

    @NotNull
    public final HeaderComponentStyle getHeaderComponentStyle() {
        return this.headerComponentStyle;
    }

    @NotNull
    public final InputComponentsContainerStyle getInputComponentsContainerStyle() {
        return this.inputComponentsContainerStyle;
    }

    public int hashCode() {
        return (((((this.headerComponentStyle.hashCode() * 31) + this.inputComponentsContainerStyle.hashCode()) * 31) + this.countryComponentStyle.hashCode()) * 31) + this.containerStyle.hashCode();
    }

    public final void setContainerStyle(@NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(containerStyle2, "<set-?>");
        this.containerStyle = containerStyle2;
    }

    public final void setCountryComponentStyle(@NotNull CountryComponentStyle countryComponentStyle2) {
        Intrinsics.checkNotNullParameter(countryComponentStyle2, "<set-?>");
        this.countryComponentStyle = countryComponentStyle2;
    }

    public final void setHeaderComponentStyle(@NotNull HeaderComponentStyle headerComponentStyle2) {
        Intrinsics.checkNotNullParameter(headerComponentStyle2, "<set-?>");
        this.headerComponentStyle = headerComponentStyle2;
    }

    public final void setInputComponentsContainerStyle(@NotNull InputComponentsContainerStyle inputComponentsContainerStyle2) {
        Intrinsics.checkNotNullParameter(inputComponentsContainerStyle2, "<set-?>");
        this.inputComponentsContainerStyle = inputComponentsContainerStyle2;
    }

    @NotNull
    public String toString() {
        HeaderComponentStyle headerComponentStyle2 = this.headerComponentStyle;
        InputComponentsContainerStyle inputComponentsContainerStyle2 = this.inputComponentsContainerStyle;
        CountryComponentStyle countryComponentStyle2 = this.countryComponentStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        return "BillingAddressDetailsStyle(headerComponentStyle=" + headerComponentStyle2 + ", inputComponentsContainerStyle=" + inputComponentsContainerStyle2 + ", countryComponentStyle=" + countryComponentStyle2 + ", containerStyle=" + containerStyle2 + ")";
    }

    public /* synthetic */ BillingAddressDetailsStyle(HeaderComponentStyle headerComponentStyle2, InputComponentsContainerStyle inputComponentsContainerStyle2, CountryComponentStyle countryComponentStyle2, ContainerStyle containerStyle2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        BillingAddressDetailsStyle billingAddressDetailsStyle;
        ContainerStyle containerStyle3;
        HeaderComponentStyle headerComponentStyle3 = (i11 & 1) != 0 ? DefaultBillingAddressDetailsStyle.INSTANCE.headerComponentStyle() : headerComponentStyle2;
        InputComponentsContainerStyle inputComponentsContainerStyle3 = (i11 & 2) != 0 ? DefaultBillingAddressDetailsStyle.INSTANCE.inputComponentsContainerStyle() : inputComponentsContainerStyle2;
        CountryComponentStyle light = (i11 & 4) != 0 ? DefaultCountryComponentStyle.INSTANCE.light() : countryComponentStyle2;
        if ((i11 & 8) != 0) {
            containerStyle3 = new ContainerStyle(4294967295L, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, (Margin) null, 254, (DefaultConstructorMarker) null);
            billingAddressDetailsStyle = this;
        } else {
            billingAddressDetailsStyle = this;
            containerStyle3 = containerStyle2;
        }
        new BillingAddressDetailsStyle(headerComponentStyle3, inputComponentsContainerStyle3, light, containerStyle3);
    }
}
