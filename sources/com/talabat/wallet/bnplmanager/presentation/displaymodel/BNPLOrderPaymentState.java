package com.talabat.wallet.bnplmanager.presentation.displaymodel;

import com.talabat.wallet.bnplmanager.domain.entity.BNPLOrderPaymentError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState;", "", "()V", "BNPLPaymentError", "BNPLPaymentSuccess", "ServerError", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState$ServerError;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState$BNPLPaymentError;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState$BNPLPaymentSuccess;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BNPLOrderPaymentState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState$BNPLPaymentError;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState;", "bNPLOrderPaymentError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;)V", "getBNPLOrderPaymentError", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLPaymentError extends BNPLOrderPaymentState {
        @NotNull
        private final BNPLOrderPaymentError bNPLOrderPaymentError;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLPaymentError(@NotNull BNPLOrderPaymentError bNPLOrderPaymentError2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLOrderPaymentError2, "bNPLOrderPaymentError");
            this.bNPLOrderPaymentError = bNPLOrderPaymentError2;
        }

        @NotNull
        public final BNPLOrderPaymentError getBNPLOrderPaymentError() {
            return this.bNPLOrderPaymentError;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState$BNPLPaymentSuccess;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLPaymentSuccess extends BNPLOrderPaymentState {
        @NotNull
        public static final BNPLPaymentSuccess INSTANCE = new BNPLPaymentSuccess();

        private BNPLPaymentSuccess() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState$ServerError;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLOrderPaymentState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ServerError extends BNPLOrderPaymentState {
        @NotNull
        public static final ServerError INSTANCE = new ServerError();

        private ServerError() {
            super((DefaultConstructorMarker) null);
        }
    }

    private BNPLOrderPaymentState() {
    }

    public /* synthetic */ BNPLOrderPaymentState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
