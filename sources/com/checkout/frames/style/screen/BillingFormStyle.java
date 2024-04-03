package com.checkout.frames.style.screen;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.CountryComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.billingformdetails.HeaderComponentStyle;
import com.checkout.frames.style.component.billingformdetails.InputComponentsContainerStyle;
import com.checkout.frames.style.screen.p004default.DefaultCountryPickerStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/screen/BillingFormStyle;", "", "billingAddressDetailsStyle", "Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "countryPickerStyle", "Lcom/checkout/frames/style/screen/CountryPickerStyle;", "(Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;Lcom/checkout/frames/style/screen/CountryPickerStyle;)V", "getBillingAddressDetailsStyle", "()Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;", "setBillingAddressDetailsStyle", "(Lcom/checkout/frames/style/screen/BillingAddressDetailsStyle;)V", "getCountryPickerStyle", "()Lcom/checkout/frames/style/screen/CountryPickerStyle;", "setCountryPickerStyle", "(Lcom/checkout/frames/style/screen/CountryPickerStyle;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BillingFormStyle {
    public static final int $stable = 8;
    @NotNull
    private BillingAddressDetailsStyle billingAddressDetailsStyle;
    @NotNull
    private CountryPickerStyle countryPickerStyle;

    @JvmOverloads
    public BillingFormStyle() {
        this((BillingAddressDetailsStyle) null, (CountryPickerStyle) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BillingFormStyle(@NotNull BillingAddressDetailsStyle billingAddressDetailsStyle2) {
        this(billingAddressDetailsStyle2, (CountryPickerStyle) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(billingAddressDetailsStyle2, "billingAddressDetailsStyle");
    }

    @JvmOverloads
    public BillingFormStyle(@NotNull BillingAddressDetailsStyle billingAddressDetailsStyle2, @NotNull CountryPickerStyle countryPickerStyle2) {
        Intrinsics.checkNotNullParameter(billingAddressDetailsStyle2, "billingAddressDetailsStyle");
        Intrinsics.checkNotNullParameter(countryPickerStyle2, "countryPickerStyle");
        this.billingAddressDetailsStyle = billingAddressDetailsStyle2;
        this.countryPickerStyle = countryPickerStyle2;
    }

    public static /* synthetic */ BillingFormStyle copy$default(BillingFormStyle billingFormStyle, BillingAddressDetailsStyle billingAddressDetailsStyle2, CountryPickerStyle countryPickerStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            billingAddressDetailsStyle2 = billingFormStyle.billingAddressDetailsStyle;
        }
        if ((i11 & 2) != 0) {
            countryPickerStyle2 = billingFormStyle.countryPickerStyle;
        }
        return billingFormStyle.copy(billingAddressDetailsStyle2, countryPickerStyle2);
    }

    @NotNull
    public final BillingAddressDetailsStyle component1() {
        return this.billingAddressDetailsStyle;
    }

    @NotNull
    public final CountryPickerStyle component2() {
        return this.countryPickerStyle;
    }

    @NotNull
    public final BillingFormStyle copy(@NotNull BillingAddressDetailsStyle billingAddressDetailsStyle2, @NotNull CountryPickerStyle countryPickerStyle2) {
        Intrinsics.checkNotNullParameter(billingAddressDetailsStyle2, "billingAddressDetailsStyle");
        Intrinsics.checkNotNullParameter(countryPickerStyle2, "countryPickerStyle");
        return new BillingFormStyle(billingAddressDetailsStyle2, countryPickerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BillingFormStyle)) {
            return false;
        }
        BillingFormStyle billingFormStyle = (BillingFormStyle) obj;
        return Intrinsics.areEqual((Object) this.billingAddressDetailsStyle, (Object) billingFormStyle.billingAddressDetailsStyle) && Intrinsics.areEqual((Object) this.countryPickerStyle, (Object) billingFormStyle.countryPickerStyle);
    }

    @NotNull
    public final BillingAddressDetailsStyle getBillingAddressDetailsStyle() {
        return this.billingAddressDetailsStyle;
    }

    @NotNull
    public final CountryPickerStyle getCountryPickerStyle() {
        return this.countryPickerStyle;
    }

    public int hashCode() {
        return (this.billingAddressDetailsStyle.hashCode() * 31) + this.countryPickerStyle.hashCode();
    }

    public final void setBillingAddressDetailsStyle(@NotNull BillingAddressDetailsStyle billingAddressDetailsStyle2) {
        Intrinsics.checkNotNullParameter(billingAddressDetailsStyle2, "<set-?>");
        this.billingAddressDetailsStyle = billingAddressDetailsStyle2;
    }

    public final void setCountryPickerStyle(@NotNull CountryPickerStyle countryPickerStyle2) {
        Intrinsics.checkNotNullParameter(countryPickerStyle2, "<set-?>");
        this.countryPickerStyle = countryPickerStyle2;
    }

    @NotNull
    public String toString() {
        BillingAddressDetailsStyle billingAddressDetailsStyle2 = this.billingAddressDetailsStyle;
        CountryPickerStyle countryPickerStyle2 = this.countryPickerStyle;
        return "BillingFormStyle(billingAddressDetailsStyle=" + billingAddressDetailsStyle2 + ", countryPickerStyle=" + countryPickerStyle2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BillingFormStyle(BillingAddressDetailsStyle billingAddressDetailsStyle2, CountryPickerStyle countryPickerStyle2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new BillingAddressDetailsStyle((HeaderComponentStyle) null, (InputComponentsContainerStyle) null, (CountryComponentStyle) null, (ContainerStyle) null, 15, (DefaultConstructorMarker) null) : billingAddressDetailsStyle2, (i11 & 2) != 0 ? DefaultCountryPickerStyle.INSTANCE.light() : countryPickerStyle2);
    }
}
