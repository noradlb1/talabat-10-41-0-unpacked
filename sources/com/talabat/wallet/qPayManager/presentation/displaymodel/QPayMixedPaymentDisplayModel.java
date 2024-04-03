package com.talabat.wallet.qPayManager.presentation.displaymodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel;", "", "()V", "ProceedWithDefaultMixedPayment", "ProceedWithQPayMixedPayment", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel$ProceedWithQPayMixedPayment;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel$ProceedWithDefaultMixedPayment;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class QPayMixedPaymentDisplayModel {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel$ProceedWithDefaultMixedPayment;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ProceedWithDefaultMixedPayment extends QPayMixedPaymentDisplayModel {
        @NotNull
        public static final ProceedWithDefaultMixedPayment INSTANCE = new ProceedWithDefaultMixedPayment();

        private ProceedWithDefaultMixedPayment() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel$ProceedWithQPayMixedPayment;", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ProceedWithQPayMixedPayment extends QPayMixedPaymentDisplayModel {
        @NotNull
        public static final ProceedWithQPayMixedPayment INSTANCE = new ProceedWithQPayMixedPayment();

        private ProceedWithQPayMixedPayment() {
            super((DefaultConstructorMarker) null);
        }
    }

    private QPayMixedPaymentDisplayModel() {
    }

    public /* synthetic */ QPayMixedPaymentDisplayModel(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
