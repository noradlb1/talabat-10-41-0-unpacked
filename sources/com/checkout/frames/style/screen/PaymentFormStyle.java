package com.checkout.frames.style.screen;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.CardNumberComponentStyle;
import com.checkout.frames.style.component.CardSchemeComponentStyle;
import com.checkout.frames.style.component.CvvComponentStyle;
import com.checkout.frames.style.component.ExpiryDateComponentStyle;
import com.checkout.frames.style.component.PayButtonComponentStyle;
import com.checkout.frames.style.component.ScreenHeaderStyle;
import com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/checkout/frames/style/screen/PaymentFormStyle;", "", "paymentDetailsStyle", "Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "billingFormStyle", "Lcom/checkout/frames/style/screen/BillingFormStyle;", "(Lcom/checkout/frames/style/screen/PaymentDetailsStyle;Lcom/checkout/frames/style/screen/BillingFormStyle;)V", "getBillingFormStyle", "()Lcom/checkout/frames/style/screen/BillingFormStyle;", "setBillingFormStyle", "(Lcom/checkout/frames/style/screen/BillingFormStyle;)V", "getPaymentDetailsStyle", "()Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "setPaymentDetailsStyle", "(Lcom/checkout/frames/style/screen/PaymentDetailsStyle;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormStyle {
    public static final int $stable = 8;
    @NotNull
    private BillingFormStyle billingFormStyle;
    @NotNull
    private PaymentDetailsStyle paymentDetailsStyle;

    @JvmOverloads
    public PaymentFormStyle() {
        this((PaymentDetailsStyle) null, (BillingFormStyle) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormStyle(@NotNull PaymentDetailsStyle paymentDetailsStyle2) {
        this(paymentDetailsStyle2, (BillingFormStyle) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(paymentDetailsStyle2, "paymentDetailsStyle");
    }

    @JvmOverloads
    public PaymentFormStyle(@NotNull PaymentDetailsStyle paymentDetailsStyle2, @NotNull BillingFormStyle billingFormStyle2) {
        Intrinsics.checkNotNullParameter(paymentDetailsStyle2, "paymentDetailsStyle");
        Intrinsics.checkNotNullParameter(billingFormStyle2, "billingFormStyle");
        this.paymentDetailsStyle = paymentDetailsStyle2;
        this.billingFormStyle = billingFormStyle2;
    }

    public static /* synthetic */ PaymentFormStyle copy$default(PaymentFormStyle paymentFormStyle, PaymentDetailsStyle paymentDetailsStyle2, BillingFormStyle billingFormStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            paymentDetailsStyle2 = paymentFormStyle.paymentDetailsStyle;
        }
        if ((i11 & 2) != 0) {
            billingFormStyle2 = paymentFormStyle.billingFormStyle;
        }
        return paymentFormStyle.copy(paymentDetailsStyle2, billingFormStyle2);
    }

    @NotNull
    public final PaymentDetailsStyle component1() {
        return this.paymentDetailsStyle;
    }

    @NotNull
    public final BillingFormStyle component2() {
        return this.billingFormStyle;
    }

    @NotNull
    public final PaymentFormStyle copy(@NotNull PaymentDetailsStyle paymentDetailsStyle2, @NotNull BillingFormStyle billingFormStyle2) {
        Intrinsics.checkNotNullParameter(paymentDetailsStyle2, "paymentDetailsStyle");
        Intrinsics.checkNotNullParameter(billingFormStyle2, "billingFormStyle");
        return new PaymentFormStyle(paymentDetailsStyle2, billingFormStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormStyle)) {
            return false;
        }
        PaymentFormStyle paymentFormStyle = (PaymentFormStyle) obj;
        return Intrinsics.areEqual((Object) this.paymentDetailsStyle, (Object) paymentFormStyle.paymentDetailsStyle) && Intrinsics.areEqual((Object) this.billingFormStyle, (Object) paymentFormStyle.billingFormStyle);
    }

    @NotNull
    public final BillingFormStyle getBillingFormStyle() {
        return this.billingFormStyle;
    }

    @NotNull
    public final PaymentDetailsStyle getPaymentDetailsStyle() {
        return this.paymentDetailsStyle;
    }

    public int hashCode() {
        return (this.paymentDetailsStyle.hashCode() * 31) + this.billingFormStyle.hashCode();
    }

    public final void setBillingFormStyle(@NotNull BillingFormStyle billingFormStyle2) {
        Intrinsics.checkNotNullParameter(billingFormStyle2, "<set-?>");
        this.billingFormStyle = billingFormStyle2;
    }

    public final void setPaymentDetailsStyle(@NotNull PaymentDetailsStyle paymentDetailsStyle2) {
        Intrinsics.checkNotNullParameter(paymentDetailsStyle2, "<set-?>");
        this.paymentDetailsStyle = paymentDetailsStyle2;
    }

    @NotNull
    public String toString() {
        PaymentDetailsStyle paymentDetailsStyle2 = this.paymentDetailsStyle;
        BillingFormStyle billingFormStyle2 = this.billingFormStyle;
        return "PaymentFormStyle(paymentDetailsStyle=" + paymentDetailsStyle2 + ", billingFormStyle=" + billingFormStyle2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentFormStyle(PaymentDetailsStyle paymentDetailsStyle2, BillingFormStyle billingFormStyle2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new PaymentDetailsStyle((ScreenHeaderStyle) null, (CardSchemeComponentStyle) null, (CardNumberComponentStyle) null, (ExpiryDateComponentStyle) null, (CvvComponentStyle) null, (AddressSummaryComponentStyle) null, (PayButtonComponentStyle) null, (ContainerStyle) null, 255, (DefaultConstructorMarker) null) : paymentDetailsStyle2, (i11 & 2) != 0 ? new BillingFormStyle((BillingAddressDetailsStyle) null, (CountryPickerStyle) null, 3, (DefaultConstructorMarker) null) : billingFormStyle2);
    }
}
