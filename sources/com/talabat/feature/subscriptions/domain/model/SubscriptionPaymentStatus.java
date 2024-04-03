package com.talabat.feature.subscriptions.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001\u0014B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus;", "", "result", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus$PaymentResult;", "error", "", "(Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus$PaymentResult;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getResult", "()Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus$PaymentResult;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "PaymentResult", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPaymentStatus {
    @NotNull
    private final String error;
    @NotNull
    private final PaymentResult result;

    public SubscriptionPaymentStatus() {
        this((PaymentResult) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public SubscriptionPaymentStatus(@NotNull PaymentResult paymentResult, @NotNull String str) {
        Intrinsics.checkNotNullParameter(paymentResult, "result");
        Intrinsics.checkNotNullParameter(str, "error");
        this.result = paymentResult;
        this.error = str;
    }

    public static /* synthetic */ SubscriptionPaymentStatus copy$default(SubscriptionPaymentStatus subscriptionPaymentStatus, PaymentResult paymentResult, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            paymentResult = subscriptionPaymentStatus.result;
        }
        if ((i11 & 2) != 0) {
            str = subscriptionPaymentStatus.error;
        }
        return subscriptionPaymentStatus.copy(paymentResult, str);
    }

    @NotNull
    public final PaymentResult component1() {
        return this.result;
    }

    @NotNull
    public final String component2() {
        return this.error;
    }

    @NotNull
    public final SubscriptionPaymentStatus copy(@NotNull PaymentResult paymentResult, @NotNull String str) {
        Intrinsics.checkNotNullParameter(paymentResult, "result");
        Intrinsics.checkNotNullParameter(str, "error");
        return new SubscriptionPaymentStatus(paymentResult, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionPaymentStatus)) {
            return false;
        }
        SubscriptionPaymentStatus subscriptionPaymentStatus = (SubscriptionPaymentStatus) obj;
        return Intrinsics.areEqual((Object) this.result, (Object) subscriptionPaymentStatus.result) && Intrinsics.areEqual((Object) this.error, (Object) subscriptionPaymentStatus.error);
    }

    @NotNull
    public final String getError() {
        return this.error;
    }

    @NotNull
    public final PaymentResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return (this.result.hashCode() * 31) + this.error.hashCode();
    }

    @NotNull
    public String toString() {
        PaymentResult paymentResult = this.result;
        String str = this.error;
        return "SubscriptionPaymentStatus(result=" + paymentResult + ", error=" + str + ")";
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/SubscriptionPaymentStatus$PaymentResult;", "", "redirectURL", "", "isSubscribed", "", "(Ljava/lang/String;Z)V", "()Z", "getRedirectURL", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PaymentResult {
        private final boolean isSubscribed;
        @NotNull
        private final String redirectURL;

        public PaymentResult() {
            this((String) null, false, 3, (DefaultConstructorMarker) null);
        }

        public PaymentResult(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "redirectURL");
            this.redirectURL = str;
            this.isSubscribed = z11;
        }

        public static /* synthetic */ PaymentResult copy$default(PaymentResult paymentResult, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = paymentResult.redirectURL;
            }
            if ((i11 & 2) != 0) {
                z11 = paymentResult.isSubscribed;
            }
            return paymentResult.copy(str, z11);
        }

        @NotNull
        public final String component1() {
            return this.redirectURL;
        }

        public final boolean component2() {
            return this.isSubscribed;
        }

        @NotNull
        public final PaymentResult copy(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "redirectURL");
            return new PaymentResult(str, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaymentResult)) {
                return false;
            }
            PaymentResult paymentResult = (PaymentResult) obj;
            return Intrinsics.areEqual((Object) this.redirectURL, (Object) paymentResult.redirectURL) && this.isSubscribed == paymentResult.isSubscribed;
        }

        @NotNull
        public final String getRedirectURL() {
            return this.redirectURL;
        }

        public int hashCode() {
            int hashCode = this.redirectURL.hashCode() * 31;
            boolean z11 = this.isSubscribed;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        public final boolean isSubscribed() {
            return this.isSubscribed;
        }

        @NotNull
        public String toString() {
            String str = this.redirectURL;
            boolean z11 = this.isSubscribed;
            return "PaymentResult(redirectURL=" + str + ", isSubscribed=" + z11 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PaymentResult(String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? false : z11);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionPaymentStatus(PaymentResult paymentResult, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new PaymentResult((String) null, false, 3, (DefaultConstructorMarker) null) : paymentResult, (i11 & 2) != 0 ? "" : str);
    }
}
