package com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel;

import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState;", "", "()V", "BNPLErrorPopUp", "BNPLHiddenPop", "BNPLPlanPopUp", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState$BNPLHiddenPop;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState$BNPLErrorPopUp;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState$BNPLPlanPopUp;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BNPLPopUpViewState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState$BNPLErrorPopUp;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState;", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;)V", "getBNPLValidationError", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLErrorPopUp extends BNPLPopUpViewState {
        @NotNull
        private final BNPLValidationError bNPLValidationError;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLErrorPopUp(@NotNull BNPLValidationError bNPLValidationError2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLValidationError2, "bNPLValidationError");
            this.bNPLValidationError = bNPLValidationError2;
        }

        @NotNull
        public final BNPLValidationError getBNPLValidationError() {
            return this.bNPLValidationError;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState$BNPLHiddenPop;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLHiddenPop extends BNPLPopUpViewState {
        @NotNull
        public static final BNPLHiddenPop INSTANCE = new BNPLHiddenPop();

        private BNPLHiddenPop() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState$BNPLPlanPopUp;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState;", "plan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "isChangeCardClicked", "", "isPaymentFallbackFlow", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;ZZ)V", "()Z", "getPlan", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLPlanPopUp extends BNPLPopUpViewState {
        private final boolean isChangeCardClicked;
        private final boolean isPaymentFallbackFlow;
        @NotNull
        private final BNPLPlan plan;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ BNPLPlanPopUp(BNPLPlan bNPLPlan, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(bNPLPlan, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? false : z12);
        }

        @NotNull
        public final BNPLPlan getPlan() {
            return this.plan;
        }

        public final boolean isChangeCardClicked() {
            return this.isChangeCardClicked;
        }

        public final boolean isPaymentFallbackFlow() {
            return this.isPaymentFallbackFlow;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLPlanPopUp(@NotNull BNPLPlan bNPLPlan, boolean z11, boolean z12) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLPlan, TLifeNavigationActions.EXTRA_PLAN);
            this.plan = bNPLPlan;
            this.isChangeCardClicked = z11;
            this.isPaymentFallbackFlow = z12;
        }
    }

    private BNPLPopUpViewState() {
    }

    public /* synthetic */ BNPLPopUpViewState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
