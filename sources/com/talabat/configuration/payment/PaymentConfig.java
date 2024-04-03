package com.talabat.configuration.payment;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/talabat/configuration/payment/PaymentConfig;", "", "checkoutBaseUrl", "", "checkoutPayUrl", "checkoutRecurringUrl", "isBinCampAvailable", "", "publicKey", "visaCheckoutPublicKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getCheckoutBaseUrl", "()Ljava/lang/String;", "getCheckoutPayUrl", "getCheckoutRecurringUrl", "()Z", "getPublicKey", "getVisaCheckoutPublicKey", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PaymentConfig {
    @NotNull
    private static final String CHECKOUT_PAY_URL = "checkoutapi/v1/purchase/pay";
    @NotNull
    private static final String CHECKOUT_RECURRING_URL = "checkoutapi/v1/purchase/recur";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final PaymentConfig DEFAULT = new PaymentConfig("https://api.talabat.com/", CHECKOUT_PAY_URL, CHECKOUT_RECURRING_URL, false, "", "");
    @NotNull
    private final String checkoutBaseUrl;
    @NotNull
    private final String checkoutPayUrl;
    @NotNull
    private final String checkoutRecurringUrl;
    private final boolean isBinCampAvailable;
    @NotNull
    private final String publicKey;
    @NotNull
    private final String visaCheckoutPublicKey;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/talabat/configuration/payment/PaymentConfig$Companion;", "", "()V", "CHECKOUT_PAY_URL", "", "CHECKOUT_RECURRING_URL", "DEFAULT", "Lcom/talabat/configuration/payment/PaymentConfig;", "getDEFAULT", "()Lcom/talabat/configuration/payment/PaymentConfig;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PaymentConfig getDEFAULT() {
            return PaymentConfig.DEFAULT;
        }
    }

    public PaymentConfig(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "checkoutBaseUrl");
        Intrinsics.checkNotNullParameter(str2, "checkoutPayUrl");
        Intrinsics.checkNotNullParameter(str3, "checkoutRecurringUrl");
        Intrinsics.checkNotNullParameter(str4, "publicKey");
        Intrinsics.checkNotNullParameter(str5, "visaCheckoutPublicKey");
        this.checkoutBaseUrl = str;
        this.checkoutPayUrl = str2;
        this.checkoutRecurringUrl = str3;
        this.isBinCampAvailable = z11;
        this.publicKey = str4;
        this.visaCheckoutPublicKey = str5;
    }

    public static /* synthetic */ PaymentConfig copy$default(PaymentConfig paymentConfig, String str, String str2, String str3, boolean z11, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = paymentConfig.checkoutBaseUrl;
        }
        if ((i11 & 2) != 0) {
            str2 = paymentConfig.checkoutPayUrl;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = paymentConfig.checkoutRecurringUrl;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            z11 = paymentConfig.isBinCampAvailable;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            str4 = paymentConfig.publicKey;
        }
        String str8 = str4;
        if ((i11 & 32) != 0) {
            str5 = paymentConfig.visaCheckoutPublicKey;
        }
        return paymentConfig.copy(str, str6, str7, z12, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.checkoutBaseUrl;
    }

    @NotNull
    public final String component2() {
        return this.checkoutPayUrl;
    }

    @NotNull
    public final String component3() {
        return this.checkoutRecurringUrl;
    }

    public final boolean component4() {
        return this.isBinCampAvailable;
    }

    @NotNull
    public final String component5() {
        return this.publicKey;
    }

    @NotNull
    public final String component6() {
        return this.visaCheckoutPublicKey;
    }

    @NotNull
    public final PaymentConfig copy(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z11, @NotNull String str4, @NotNull String str5) {
        Intrinsics.checkNotNullParameter(str, "checkoutBaseUrl");
        Intrinsics.checkNotNullParameter(str2, "checkoutPayUrl");
        Intrinsics.checkNotNullParameter(str3, "checkoutRecurringUrl");
        Intrinsics.checkNotNullParameter(str4, "publicKey");
        Intrinsics.checkNotNullParameter(str5, "visaCheckoutPublicKey");
        return new PaymentConfig(str, str2, str3, z11, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentConfig)) {
            return false;
        }
        PaymentConfig paymentConfig = (PaymentConfig) obj;
        return Intrinsics.areEqual((Object) this.checkoutBaseUrl, (Object) paymentConfig.checkoutBaseUrl) && Intrinsics.areEqual((Object) this.checkoutPayUrl, (Object) paymentConfig.checkoutPayUrl) && Intrinsics.areEqual((Object) this.checkoutRecurringUrl, (Object) paymentConfig.checkoutRecurringUrl) && this.isBinCampAvailable == paymentConfig.isBinCampAvailable && Intrinsics.areEqual((Object) this.publicKey, (Object) paymentConfig.publicKey) && Intrinsics.areEqual((Object) this.visaCheckoutPublicKey, (Object) paymentConfig.visaCheckoutPublicKey);
    }

    @NotNull
    public final String getCheckoutBaseUrl() {
        return this.checkoutBaseUrl;
    }

    @NotNull
    public final String getCheckoutPayUrl() {
        return this.checkoutPayUrl;
    }

    @NotNull
    public final String getCheckoutRecurringUrl() {
        return this.checkoutRecurringUrl;
    }

    @NotNull
    public final String getPublicKey() {
        return this.publicKey;
    }

    @NotNull
    public final String getVisaCheckoutPublicKey() {
        return this.visaCheckoutPublicKey;
    }

    public int hashCode() {
        int hashCode = ((((this.checkoutBaseUrl.hashCode() * 31) + this.checkoutPayUrl.hashCode()) * 31) + this.checkoutRecurringUrl.hashCode()) * 31;
        boolean z11 = this.isBinCampAvailable;
        if (z11) {
            z11 = true;
        }
        return ((((hashCode + (z11 ? 1 : 0)) * 31) + this.publicKey.hashCode()) * 31) + this.visaCheckoutPublicKey.hashCode();
    }

    public final boolean isBinCampAvailable() {
        return this.isBinCampAvailable;
    }

    @NotNull
    public String toString() {
        String str = this.checkoutBaseUrl;
        String str2 = this.checkoutPayUrl;
        String str3 = this.checkoutRecurringUrl;
        boolean z11 = this.isBinCampAvailable;
        String str4 = this.publicKey;
        String str5 = this.visaCheckoutPublicKey;
        return "PaymentConfig(checkoutBaseUrl=" + str + ", checkoutPayUrl=" + str2 + ", checkoutRecurringUrl=" + str3 + ", isBinCampAvailable=" + z11 + ", publicKey=" + str4 + ", visaCheckoutPublicKey=" + str5 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentConfig(String str, String str2, String str3, boolean z11, String str4, String str5, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? CHECKOUT_PAY_URL : str2, (i11 & 4) != 0 ? CHECKOUT_RECURRING_URL : str3, z11, str4, str5);
    }
}
