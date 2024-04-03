package com.talabat.wallet.payproxymanager.preesentation.displaymodel;

import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel;", "", "()V", "CVVSentFailure", "CVVToProxyLoading", "ContinueWithAdyenPayment", "ContinueWithCheckoutPayment", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$ContinueWithCheckoutPayment;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$ContinueWithAdyenPayment;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$CVVSentFailure;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$CVVToProxyLoading;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SendCVVToProxyDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$CVVSentFailure;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CVVSentFailure extends SendCVVToProxyDisplayModel {
        @NotNull
        public static final CVVSentFailure INSTANCE = new CVVSentFailure();

        private CVVSentFailure() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$CVVToProxyLoading;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CVVToProxyLoading extends SendCVVToProxyDisplayModel {
        @NotNull
        public static final CVVToProxyLoading INSTANCE = new CVVToProxyLoading();

        private CVVToProxyLoading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$ContinueWithAdyenPayment;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel;", "recurringPurchaseRequest", "LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "(LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;)V", "getRecurringPurchaseRequest", "()LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContinueWithAdyenPayment extends SendCVVToProxyDisplayModel {
        @NotNull
        private final RecurringPurchaseRequest recurringPurchaseRequest;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ContinueWithAdyenPayment(@NotNull RecurringPurchaseRequest recurringPurchaseRequest2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(recurringPurchaseRequest2, "recurringPurchaseRequest");
            this.recurringPurchaseRequest = recurringPurchaseRequest2;
        }

        public static /* synthetic */ ContinueWithAdyenPayment copy$default(ContinueWithAdyenPayment continueWithAdyenPayment, RecurringPurchaseRequest recurringPurchaseRequest2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                recurringPurchaseRequest2 = continueWithAdyenPayment.recurringPurchaseRequest;
            }
            return continueWithAdyenPayment.copy(recurringPurchaseRequest2);
        }

        @NotNull
        public final RecurringPurchaseRequest component1() {
            return this.recurringPurchaseRequest;
        }

        @NotNull
        public final ContinueWithAdyenPayment copy(@NotNull RecurringPurchaseRequest recurringPurchaseRequest2) {
            Intrinsics.checkNotNullParameter(recurringPurchaseRequest2, "recurringPurchaseRequest");
            return new ContinueWithAdyenPayment(recurringPurchaseRequest2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContinueWithAdyenPayment) && Intrinsics.areEqual((Object) this.recurringPurchaseRequest, (Object) ((ContinueWithAdyenPayment) obj).recurringPurchaseRequest);
        }

        @NotNull
        public final RecurringPurchaseRequest getRecurringPurchaseRequest() {
            return this.recurringPurchaseRequest;
        }

        public int hashCode() {
            return this.recurringPurchaseRequest.hashCode();
        }

        @NotNull
        public String toString() {
            RecurringPurchaseRequest recurringPurchaseRequest2 = this.recurringPurchaseRequest;
            return "ContinueWithAdyenPayment(recurringPurchaseRequest=" + recurringPurchaseRequest2 + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel$ContinueWithCheckoutPayment;", "Lcom/talabat/wallet/payproxymanager/preesentation/displaymodel/SendCVVToProxyDisplayModel;", "recurringPurchaseRequest", "LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "(LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;)V", "getRecurringPurchaseRequest", "()LJsonModels/Request/CheckoutDotComRequest/RecurringPurchaseRequest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ContinueWithCheckoutPayment extends SendCVVToProxyDisplayModel {
        @NotNull
        private final RecurringPurchaseRequest recurringPurchaseRequest;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ContinueWithCheckoutPayment(@NotNull RecurringPurchaseRequest recurringPurchaseRequest2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(recurringPurchaseRequest2, "recurringPurchaseRequest");
            this.recurringPurchaseRequest = recurringPurchaseRequest2;
        }

        public static /* synthetic */ ContinueWithCheckoutPayment copy$default(ContinueWithCheckoutPayment continueWithCheckoutPayment, RecurringPurchaseRequest recurringPurchaseRequest2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                recurringPurchaseRequest2 = continueWithCheckoutPayment.recurringPurchaseRequest;
            }
            return continueWithCheckoutPayment.copy(recurringPurchaseRequest2);
        }

        @NotNull
        public final RecurringPurchaseRequest component1() {
            return this.recurringPurchaseRequest;
        }

        @NotNull
        public final ContinueWithCheckoutPayment copy(@NotNull RecurringPurchaseRequest recurringPurchaseRequest2) {
            Intrinsics.checkNotNullParameter(recurringPurchaseRequest2, "recurringPurchaseRequest");
            return new ContinueWithCheckoutPayment(recurringPurchaseRequest2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ContinueWithCheckoutPayment) && Intrinsics.areEqual((Object) this.recurringPurchaseRequest, (Object) ((ContinueWithCheckoutPayment) obj).recurringPurchaseRequest);
        }

        @NotNull
        public final RecurringPurchaseRequest getRecurringPurchaseRequest() {
            return this.recurringPurchaseRequest;
        }

        public int hashCode() {
            return this.recurringPurchaseRequest.hashCode();
        }

        @NotNull
        public String toString() {
            RecurringPurchaseRequest recurringPurchaseRequest2 = this.recurringPurchaseRequest;
            return "ContinueWithCheckoutPayment(recurringPurchaseRequest=" + recurringPurchaseRequest2 + ")";
        }
    }

    private SendCVVToProxyDisplayModel() {
    }

    public /* synthetic */ SendCVVToProxyDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
