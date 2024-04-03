package com.talabat.wallet.bnplmanager.presentation.displaymodel;

import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentDetailsDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState;", "", "()V", "BNPLPaymentDetailsSuccess", "ServerError", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState$ServerError;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState$BNPLPaymentDetailsSuccess;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BNPLPaymentDetailsState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState$BNPLPaymentDetailsSuccess;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState;", "bNPLPaymentDetailsDisplayModel", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentDetailsDisplayModel;", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentDetailsDisplayModel;)V", "getBNPLPaymentDetailsDisplayModel", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentDetailsDisplayModel;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLPaymentDetailsSuccess extends BNPLPaymentDetailsState {
        @NotNull
        private final BNPLPaymentDetailsDisplayModel bNPLPaymentDetailsDisplayModel;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLPaymentDetailsSuccess(@NotNull BNPLPaymentDetailsDisplayModel bNPLPaymentDetailsDisplayModel2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLPaymentDetailsDisplayModel2, "bNPLPaymentDetailsDisplayModel");
            this.bNPLPaymentDetailsDisplayModel = bNPLPaymentDetailsDisplayModel2;
        }

        @NotNull
        public final BNPLPaymentDetailsDisplayModel getBNPLPaymentDetailsDisplayModel() {
            return this.bNPLPaymentDetailsDisplayModel;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState$ServerError;", "Lcom/talabat/wallet/bnplmanager/presentation/displaymodel/BNPLPaymentDetailsState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ServerError extends BNPLPaymentDetailsState {
        @NotNull
        public static final ServerError INSTANCE = new ServerError();

        private ServerError() {
            super((DefaultConstructorMarker) null);
        }
    }

    private BNPLPaymentDetailsState() {
    }

    public /* synthetic */ BNPLPaymentDetailsState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
