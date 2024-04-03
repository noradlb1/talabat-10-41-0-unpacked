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
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B[\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\tHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\rHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J]\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020BHÖ\u0001R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102¨\u0006C"}, d2 = {"Lcom/checkout/frames/style/screen/PaymentDetailsStyle;", "", "paymentDetailsHeaderStyle", "Lcom/checkout/frames/style/component/ScreenHeaderStyle;", "cardSchemeStyle", "Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "cardNumberStyle", "Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "expiryDateStyle", "Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "cvvStyle", "Lcom/checkout/frames/style/component/CvvComponentStyle;", "addressSummaryStyle", "Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "payButtonStyle", "Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "fieldsContainerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "(Lcom/checkout/frames/style/component/ScreenHeaderStyle;Lcom/checkout/frames/style/component/CardSchemeComponentStyle;Lcom/checkout/frames/style/component/CardNumberComponentStyle;Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;Lcom/checkout/frames/style/component/CvvComponentStyle;Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;Lcom/checkout/frames/style/component/PayButtonComponentStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getAddressSummaryStyle", "()Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "setAddressSummaryStyle", "(Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;)V", "getCardNumberStyle", "()Lcom/checkout/frames/style/component/CardNumberComponentStyle;", "setCardNumberStyle", "(Lcom/checkout/frames/style/component/CardNumberComponentStyle;)V", "getCardSchemeStyle", "()Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "setCardSchemeStyle", "(Lcom/checkout/frames/style/component/CardSchemeComponentStyle;)V", "getCvvStyle", "()Lcom/checkout/frames/style/component/CvvComponentStyle;", "setCvvStyle", "(Lcom/checkout/frames/style/component/CvvComponentStyle;)V", "getExpiryDateStyle", "()Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;", "setExpiryDateStyle", "(Lcom/checkout/frames/style/component/ExpiryDateComponentStyle;)V", "getFieldsContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "setFieldsContainerStyle", "(Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getPayButtonStyle", "()Lcom/checkout/frames/style/component/PayButtonComponentStyle;", "setPayButtonStyle", "(Lcom/checkout/frames/style/component/PayButtonComponentStyle;)V", "getPaymentDetailsHeaderStyle", "()Lcom/checkout/frames/style/component/ScreenHeaderStyle;", "setPaymentDetailsHeaderStyle", "(Lcom/checkout/frames/style/component/ScreenHeaderStyle;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentDetailsStyle {
    public static final int $stable = 8;
    @Nullable
    private AddressSummaryComponentStyle addressSummaryStyle;
    @NotNull
    private CardNumberComponentStyle cardNumberStyle;
    @NotNull
    private CardSchemeComponentStyle cardSchemeStyle;
    @Nullable
    private CvvComponentStyle cvvStyle;
    @NotNull
    private ExpiryDateComponentStyle expiryDateStyle;
    @NotNull
    private ContainerStyle fieldsContainerStyle;
    @NotNull
    private PayButtonComponentStyle payButtonStyle;
    @NotNull
    private ScreenHeaderStyle paymentDetailsHeaderStyle;

    @JvmOverloads
    public PaymentDetailsStyle() {
        this((ScreenHeaderStyle) null, (CardSchemeComponentStyle) null, (CardNumberComponentStyle) null, (ExpiryDateComponentStyle) null, (CvvComponentStyle) null, (AddressSummaryComponentStyle) null, (PayButtonComponentStyle) null, (ContainerStyle) null, 255, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentDetailsStyle(@NotNull ScreenHeaderStyle screenHeaderStyle) {
        this(screenHeaderStyle, (CardSchemeComponentStyle) null, (CardNumberComponentStyle) null, (ExpiryDateComponentStyle) null, (CvvComponentStyle) null, (AddressSummaryComponentStyle) null, (PayButtonComponentStyle) null, (ContainerStyle) null, 254, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(screenHeaderStyle, "paymentDetailsHeaderStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentDetailsStyle(@NotNull ScreenHeaderStyle screenHeaderStyle, @NotNull CardSchemeComponentStyle cardSchemeComponentStyle) {
        this(screenHeaderStyle, cardSchemeComponentStyle, (CardNumberComponentStyle) null, (ExpiryDateComponentStyle) null, (CvvComponentStyle) null, (AddressSummaryComponentStyle) null, (PayButtonComponentStyle) null, (ContainerStyle) null, 252, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(screenHeaderStyle, "paymentDetailsHeaderStyle");
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "cardSchemeStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentDetailsStyle(@NotNull ScreenHeaderStyle screenHeaderStyle, @NotNull CardSchemeComponentStyle cardSchemeComponentStyle, @NotNull CardNumberComponentStyle cardNumberComponentStyle) {
        this(screenHeaderStyle, cardSchemeComponentStyle, cardNumberComponentStyle, (ExpiryDateComponentStyle) null, (CvvComponentStyle) null, (AddressSummaryComponentStyle) null, (PayButtonComponentStyle) null, (ContainerStyle) null, 248, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(screenHeaderStyle, "paymentDetailsHeaderStyle");
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "cardSchemeStyle");
        Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "cardNumberStyle");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentDetailsStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ScreenHeaderStyle r13, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardSchemeComponentStyle r14, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardNumberComponentStyle r15, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ExpiryDateComponentStyle r16) {
        /*
            r12 = this;
            java.lang.String r0 = "paymentDetailsHeaderStyle"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "cardSchemeStyle"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "cardNumberStyle"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "expiryDateStyle"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 240(0xf0, float:3.36E-43)
            r11 = 0
            r1 = r12
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.screen.PaymentDetailsStyle.<init>(com.checkout.frames.style.component.ScreenHeaderStyle, com.checkout.frames.style.component.CardSchemeComponentStyle, com.checkout.frames.style.component.CardNumberComponentStyle, com.checkout.frames.style.component.ExpiryDateComponentStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentDetailsStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ScreenHeaderStyle r13, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardSchemeComponentStyle r14, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardNumberComponentStyle r15, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ExpiryDateComponentStyle r16, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.CvvComponentStyle r17) {
        /*
            r12 = this;
            java.lang.String r0 = "paymentDetailsHeaderStyle"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "cardSchemeStyle"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "cardNumberStyle"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "expiryDateStyle"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 224(0xe0, float:3.14E-43)
            r11 = 0
            r1 = r12
            r6 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.screen.PaymentDetailsStyle.<init>(com.checkout.frames.style.component.ScreenHeaderStyle, com.checkout.frames.style.component.CardSchemeComponentStyle, com.checkout.frames.style.component.CardNumberComponentStyle, com.checkout.frames.style.component.ExpiryDateComponentStyle, com.checkout.frames.style.component.CvvComponentStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentDetailsStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ScreenHeaderStyle r13, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardSchemeComponentStyle r14, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardNumberComponentStyle r15, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ExpiryDateComponentStyle r16, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.CvvComponentStyle r17, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle r18) {
        /*
            r12 = this;
            java.lang.String r0 = "paymentDetailsHeaderStyle"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "cardSchemeStyle"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "cardNumberStyle"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "expiryDateStyle"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r8 = 0
            r9 = 0
            r10 = 192(0xc0, float:2.69E-43)
            r11 = 0
            r1 = r12
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.screen.PaymentDetailsStyle.<init>(com.checkout.frames.style.component.ScreenHeaderStyle, com.checkout.frames.style.component.CardSchemeComponentStyle, com.checkout.frames.style.component.CardNumberComponentStyle, com.checkout.frames.style.component.ExpiryDateComponentStyle, com.checkout.frames.style.component.CvvComponentStyle, com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PaymentDetailsStyle(@org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ScreenHeaderStyle r13, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardSchemeComponentStyle r14, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.CardNumberComponentStyle r15, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.ExpiryDateComponentStyle r16, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.CvvComponentStyle r17, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle r18, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.PayButtonComponentStyle r19) {
        /*
            r12 = this;
            java.lang.String r0 = "paymentDetailsHeaderStyle"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "cardSchemeStyle"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "cardNumberStyle"
            r4 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "expiryDateStyle"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "payButtonStyle"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r9 = 0
            r10 = 128(0x80, float:1.794E-43)
            r11 = 0
            r1 = r12
            r6 = r17
            r7 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.screen.PaymentDetailsStyle.<init>(com.checkout.frames.style.component.ScreenHeaderStyle, com.checkout.frames.style.component.CardSchemeComponentStyle, com.checkout.frames.style.component.CardNumberComponentStyle, com.checkout.frames.style.component.ExpiryDateComponentStyle, com.checkout.frames.style.component.CvvComponentStyle, com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle, com.checkout.frames.style.component.PayButtonComponentStyle):void");
    }

    @JvmOverloads
    public PaymentDetailsStyle(@NotNull ScreenHeaderStyle screenHeaderStyle, @NotNull CardSchemeComponentStyle cardSchemeComponentStyle, @NotNull CardNumberComponentStyle cardNumberComponentStyle, @NotNull ExpiryDateComponentStyle expiryDateComponentStyle, @Nullable CvvComponentStyle cvvComponentStyle, @Nullable AddressSummaryComponentStyle addressSummaryComponentStyle, @NotNull PayButtonComponentStyle payButtonComponentStyle, @NotNull ContainerStyle containerStyle) {
        Intrinsics.checkNotNullParameter(screenHeaderStyle, "paymentDetailsHeaderStyle");
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "cardSchemeStyle");
        Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "cardNumberStyle");
        Intrinsics.checkNotNullParameter(expiryDateComponentStyle, "expiryDateStyle");
        Intrinsics.checkNotNullParameter(payButtonComponentStyle, "payButtonStyle");
        Intrinsics.checkNotNullParameter(containerStyle, "fieldsContainerStyle");
        this.paymentDetailsHeaderStyle = screenHeaderStyle;
        this.cardSchemeStyle = cardSchemeComponentStyle;
        this.cardNumberStyle = cardNumberComponentStyle;
        this.expiryDateStyle = expiryDateComponentStyle;
        this.cvvStyle = cvvComponentStyle;
        this.addressSummaryStyle = addressSummaryComponentStyle;
        this.payButtonStyle = payButtonComponentStyle;
        this.fieldsContainerStyle = containerStyle;
    }

    public static /* synthetic */ PaymentDetailsStyle copy$default(PaymentDetailsStyle paymentDetailsStyle, ScreenHeaderStyle screenHeaderStyle, CardSchemeComponentStyle cardSchemeComponentStyle, CardNumberComponentStyle cardNumberComponentStyle, ExpiryDateComponentStyle expiryDateComponentStyle, CvvComponentStyle cvvComponentStyle, AddressSummaryComponentStyle addressSummaryComponentStyle, PayButtonComponentStyle payButtonComponentStyle, ContainerStyle containerStyle, int i11, Object obj) {
        PaymentDetailsStyle paymentDetailsStyle2 = paymentDetailsStyle;
        int i12 = i11;
        return paymentDetailsStyle.copy((i12 & 1) != 0 ? paymentDetailsStyle2.paymentDetailsHeaderStyle : screenHeaderStyle, (i12 & 2) != 0 ? paymentDetailsStyle2.cardSchemeStyle : cardSchemeComponentStyle, (i12 & 4) != 0 ? paymentDetailsStyle2.cardNumberStyle : cardNumberComponentStyle, (i12 & 8) != 0 ? paymentDetailsStyle2.expiryDateStyle : expiryDateComponentStyle, (i12 & 16) != 0 ? paymentDetailsStyle2.cvvStyle : cvvComponentStyle, (i12 & 32) != 0 ? paymentDetailsStyle2.addressSummaryStyle : addressSummaryComponentStyle, (i12 & 64) != 0 ? paymentDetailsStyle2.payButtonStyle : payButtonComponentStyle, (i12 & 128) != 0 ? paymentDetailsStyle2.fieldsContainerStyle : containerStyle);
    }

    @NotNull
    public final ScreenHeaderStyle component1() {
        return this.paymentDetailsHeaderStyle;
    }

    @NotNull
    public final CardSchemeComponentStyle component2() {
        return this.cardSchemeStyle;
    }

    @NotNull
    public final CardNumberComponentStyle component3() {
        return this.cardNumberStyle;
    }

    @NotNull
    public final ExpiryDateComponentStyle component4() {
        return this.expiryDateStyle;
    }

    @Nullable
    public final CvvComponentStyle component5() {
        return this.cvvStyle;
    }

    @Nullable
    public final AddressSummaryComponentStyle component6() {
        return this.addressSummaryStyle;
    }

    @NotNull
    public final PayButtonComponentStyle component7() {
        return this.payButtonStyle;
    }

    @NotNull
    public final ContainerStyle component8() {
        return this.fieldsContainerStyle;
    }

    @NotNull
    public final PaymentDetailsStyle copy(@NotNull ScreenHeaderStyle screenHeaderStyle, @NotNull CardSchemeComponentStyle cardSchemeComponentStyle, @NotNull CardNumberComponentStyle cardNumberComponentStyle, @NotNull ExpiryDateComponentStyle expiryDateComponentStyle, @Nullable CvvComponentStyle cvvComponentStyle, @Nullable AddressSummaryComponentStyle addressSummaryComponentStyle, @NotNull PayButtonComponentStyle payButtonComponentStyle, @NotNull ContainerStyle containerStyle) {
        Intrinsics.checkNotNullParameter(screenHeaderStyle, "paymentDetailsHeaderStyle");
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "cardSchemeStyle");
        Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "cardNumberStyle");
        Intrinsics.checkNotNullParameter(expiryDateComponentStyle, "expiryDateStyle");
        PayButtonComponentStyle payButtonComponentStyle2 = payButtonComponentStyle;
        Intrinsics.checkNotNullParameter(payButtonComponentStyle2, "payButtonStyle");
        ContainerStyle containerStyle2 = containerStyle;
        Intrinsics.checkNotNullParameter(containerStyle2, "fieldsContainerStyle");
        return new PaymentDetailsStyle(screenHeaderStyle, cardSchemeComponentStyle, cardNumberComponentStyle, expiryDateComponentStyle, cvvComponentStyle, addressSummaryComponentStyle, payButtonComponentStyle2, containerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentDetailsStyle)) {
            return false;
        }
        PaymentDetailsStyle paymentDetailsStyle = (PaymentDetailsStyle) obj;
        return Intrinsics.areEqual((Object) this.paymentDetailsHeaderStyle, (Object) paymentDetailsStyle.paymentDetailsHeaderStyle) && Intrinsics.areEqual((Object) this.cardSchemeStyle, (Object) paymentDetailsStyle.cardSchemeStyle) && Intrinsics.areEqual((Object) this.cardNumberStyle, (Object) paymentDetailsStyle.cardNumberStyle) && Intrinsics.areEqual((Object) this.expiryDateStyle, (Object) paymentDetailsStyle.expiryDateStyle) && Intrinsics.areEqual((Object) this.cvvStyle, (Object) paymentDetailsStyle.cvvStyle) && Intrinsics.areEqual((Object) this.addressSummaryStyle, (Object) paymentDetailsStyle.addressSummaryStyle) && Intrinsics.areEqual((Object) this.payButtonStyle, (Object) paymentDetailsStyle.payButtonStyle) && Intrinsics.areEqual((Object) this.fieldsContainerStyle, (Object) paymentDetailsStyle.fieldsContainerStyle);
    }

    @Nullable
    public final AddressSummaryComponentStyle getAddressSummaryStyle() {
        return this.addressSummaryStyle;
    }

    @NotNull
    public final CardNumberComponentStyle getCardNumberStyle() {
        return this.cardNumberStyle;
    }

    @NotNull
    public final CardSchemeComponentStyle getCardSchemeStyle() {
        return this.cardSchemeStyle;
    }

    @Nullable
    public final CvvComponentStyle getCvvStyle() {
        return this.cvvStyle;
    }

    @NotNull
    public final ExpiryDateComponentStyle getExpiryDateStyle() {
        return this.expiryDateStyle;
    }

    @NotNull
    public final ContainerStyle getFieldsContainerStyle() {
        return this.fieldsContainerStyle;
    }

    @NotNull
    public final PayButtonComponentStyle getPayButtonStyle() {
        return this.payButtonStyle;
    }

    @NotNull
    public final ScreenHeaderStyle getPaymentDetailsHeaderStyle() {
        return this.paymentDetailsHeaderStyle;
    }

    public int hashCode() {
        int hashCode = ((((((this.paymentDetailsHeaderStyle.hashCode() * 31) + this.cardSchemeStyle.hashCode()) * 31) + this.cardNumberStyle.hashCode()) * 31) + this.expiryDateStyle.hashCode()) * 31;
        CvvComponentStyle cvvComponentStyle = this.cvvStyle;
        int i11 = 0;
        int hashCode2 = (hashCode + (cvvComponentStyle == null ? 0 : cvvComponentStyle.hashCode())) * 31;
        AddressSummaryComponentStyle addressSummaryComponentStyle = this.addressSummaryStyle;
        if (addressSummaryComponentStyle != null) {
            i11 = addressSummaryComponentStyle.hashCode();
        }
        return ((((hashCode2 + i11) * 31) + this.payButtonStyle.hashCode()) * 31) + this.fieldsContainerStyle.hashCode();
    }

    public final void setAddressSummaryStyle(@Nullable AddressSummaryComponentStyle addressSummaryComponentStyle) {
        this.addressSummaryStyle = addressSummaryComponentStyle;
    }

    public final void setCardNumberStyle(@NotNull CardNumberComponentStyle cardNumberComponentStyle) {
        Intrinsics.checkNotNullParameter(cardNumberComponentStyle, "<set-?>");
        this.cardNumberStyle = cardNumberComponentStyle;
    }

    public final void setCardSchemeStyle(@NotNull CardSchemeComponentStyle cardSchemeComponentStyle) {
        Intrinsics.checkNotNullParameter(cardSchemeComponentStyle, "<set-?>");
        this.cardSchemeStyle = cardSchemeComponentStyle;
    }

    public final void setCvvStyle(@Nullable CvvComponentStyle cvvComponentStyle) {
        this.cvvStyle = cvvComponentStyle;
    }

    public final void setExpiryDateStyle(@NotNull ExpiryDateComponentStyle expiryDateComponentStyle) {
        Intrinsics.checkNotNullParameter(expiryDateComponentStyle, "<set-?>");
        this.expiryDateStyle = expiryDateComponentStyle;
    }

    public final void setFieldsContainerStyle(@NotNull ContainerStyle containerStyle) {
        Intrinsics.checkNotNullParameter(containerStyle, "<set-?>");
        this.fieldsContainerStyle = containerStyle;
    }

    public final void setPayButtonStyle(@NotNull PayButtonComponentStyle payButtonComponentStyle) {
        Intrinsics.checkNotNullParameter(payButtonComponentStyle, "<set-?>");
        this.payButtonStyle = payButtonComponentStyle;
    }

    public final void setPaymentDetailsHeaderStyle(@NotNull ScreenHeaderStyle screenHeaderStyle) {
        Intrinsics.checkNotNullParameter(screenHeaderStyle, "<set-?>");
        this.paymentDetailsHeaderStyle = screenHeaderStyle;
    }

    @NotNull
    public String toString() {
        ScreenHeaderStyle screenHeaderStyle = this.paymentDetailsHeaderStyle;
        CardSchemeComponentStyle cardSchemeComponentStyle = this.cardSchemeStyle;
        CardNumberComponentStyle cardNumberComponentStyle = this.cardNumberStyle;
        ExpiryDateComponentStyle expiryDateComponentStyle = this.expiryDateStyle;
        CvvComponentStyle cvvComponentStyle = this.cvvStyle;
        AddressSummaryComponentStyle addressSummaryComponentStyle = this.addressSummaryStyle;
        PayButtonComponentStyle payButtonComponentStyle = this.payButtonStyle;
        ContainerStyle containerStyle = this.fieldsContainerStyle;
        return "PaymentDetailsStyle(paymentDetailsHeaderStyle=" + screenHeaderStyle + ", cardSchemeStyle=" + cardSchemeComponentStyle + ", cardNumberStyle=" + cardNumberComponentStyle + ", expiryDateStyle=" + expiryDateComponentStyle + ", cvvStyle=" + cvvComponentStyle + ", addressSummaryStyle=" + addressSummaryComponentStyle + ", payButtonStyle=" + payButtonComponentStyle + ", fieldsContainerStyle=" + containerStyle + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentDetailsStyle(com.checkout.frames.style.component.ScreenHeaderStyle r23, com.checkout.frames.style.component.CardSchemeComponentStyle r24, com.checkout.frames.style.component.CardNumberComponentStyle r25, com.checkout.frames.style.component.ExpiryDateComponentStyle r26, com.checkout.frames.style.component.CvvComponentStyle r27, com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle r28, com.checkout.frames.style.component.PayButtonComponentStyle r29, com.checkout.frames.style.component.base.ContainerStyle r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r22 = this;
            r0 = r31
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0028
            com.checkout.frames.style.component.default.DefaultLightStyle r2 = com.checkout.frames.style.component.p003default.DefaultLightStyle.INSTANCE
            r3 = 0
            int r1 = com.checkout.frames.R.string.cko_payment_details_title
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            int r1 = com.checkout.frames.R.drawable.cko_ic_arrow_back
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 4089(0xff9, float:5.73E-42)
            r17 = 0
            com.checkout.frames.style.component.ScreenHeaderStyle r1 = com.checkout.frames.style.component.p003default.DefaultLightStyle.screenHeader$default(r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x002a
        L_0x0028:
            r1 = r23
        L_0x002a:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0037
            com.checkout.frames.style.component.default.DefaultLightStyle r2 = com.checkout.frames.style.component.p003default.DefaultLightStyle.INSTANCE
            r4 = 3
            com.checkout.frames.style.component.CardSchemeComponentStyle r2 = com.checkout.frames.style.component.p003default.DefaultLightStyle.cardSchemeComponentStyle$default(r2, r3, r3, r4, r3)
            goto L_0x0039
        L_0x0037:
            r2 = r24
        L_0x0039:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0044
            com.checkout.frames.style.component.default.DefaultCardNumberComponentStyle r4 = com.checkout.frames.style.component.p003default.DefaultCardNumberComponentStyle.INSTANCE
            com.checkout.frames.style.component.CardNumberComponentStyle r4 = r4.light()
            goto L_0x0046
        L_0x0044:
            r4 = r25
        L_0x0046:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0051
            com.checkout.frames.style.component.default.DefaultExpiryDateComponentStyle r5 = com.checkout.frames.style.component.p003default.DefaultExpiryDateComponentStyle.INSTANCE
            com.checkout.frames.style.component.ExpiryDateComponentStyle r5 = r5.light()
            goto L_0x0053
        L_0x0051:
            r5 = r26
        L_0x0053:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x005e
            com.checkout.frames.style.component.default.DefaultCvvComponentStyle r6 = com.checkout.frames.style.component.p003default.DefaultCvvComponentStyle.INSTANCE
            com.checkout.frames.style.component.CvvComponentStyle r6 = r6.light()
            goto L_0x0060
        L_0x005e:
            r6 = r27
        L_0x0060:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x006d
            com.checkout.frames.style.component.default.DefaultAddressSummaryComponentStyle r7 = com.checkout.frames.style.component.p003default.DefaultAddressSummaryComponentStyle.INSTANCE
            r8 = 0
            r9 = 1
            com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle r3 = com.checkout.frames.style.component.p003default.DefaultAddressSummaryComponentStyle.light$default(r7, r8, r9, r3)
            goto L_0x006f
        L_0x006d:
            r3 = r28
        L_0x006f:
            r7 = r0 & 64
            if (r7 == 0) goto L_0x007a
            com.checkout.frames.style.component.default.DefaultPayButtonComponentStyle r7 = com.checkout.frames.style.component.p003default.DefaultPayButtonComponentStyle.INSTANCE
            com.checkout.frames.style.component.PayButtonComponentStyle r7 = r7.light()
            goto L_0x007c
        L_0x007a:
            r7 = r29
        L_0x007c:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00b2
            com.checkout.frames.style.component.base.ContainerStyle r0 = new com.checkout.frames.style.component.base.ContainerStyle
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            com.checkout.frames.model.Padding r16 = new com.checkout.frames.model.Padding
            r8 = 0
            r17 = 0
            r18 = 16
            r19 = 16
            r20 = 3
            r21 = 0
            r23 = r16
            r24 = r8
            r25 = r17
            r26 = r18
            r27 = r19
            r28 = r20
            r29 = r21
            r23.<init>(r24, r25, r26, r27, r28, r29)
            r17 = 0
            r18 = 191(0xbf, float:2.68E-43)
            r19 = 0
            r8 = r0
            r8.<init>(r9, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x00b4
        L_0x00b2:
            r0 = r30
        L_0x00b4:
            r23 = r22
            r24 = r1
            r25 = r2
            r26 = r4
            r27 = r5
            r28 = r6
            r29 = r3
            r30 = r7
            r31 = r0
            r23.<init>(r24, r25, r26, r27, r28, r29, r30, r31)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.screen.PaymentDetailsStyle.<init>(com.checkout.frames.style.component.ScreenHeaderStyle, com.checkout.frames.style.component.CardSchemeComponentStyle, com.checkout.frames.style.component.CardNumberComponentStyle, com.checkout.frames.style.component.ExpiryDateComponentStyle, com.checkout.frames.style.component.CvvComponentStyle, com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle, com.checkout.frames.style.component.PayButtonComponentStyle, com.checkout.frames.style.component.base.ContainerStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
