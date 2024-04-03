package com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel;

import com.talabat.talabatnavigation.tLife.TLifeNavigationActions;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0005\b\t\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "", "()V", "BNPLDeferredPlan", "BNPLDeferredPlanError", "BNPLHidden", "BNPLInstallmentPlan", "BNPLInstallmentPlanError", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLHidden;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLDeferredPlanError;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLInstallmentPlanError;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLDeferredPlan;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLInstallmentPlan;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BNPLPlanEligibilityState {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLDeferredPlan;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "plan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;)V", "getPlan", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLDeferredPlan extends BNPLPlanEligibilityState {
        @NotNull
        private final BNPLPlan plan;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLDeferredPlan(@NotNull BNPLPlan bNPLPlan) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLPlan, TLifeNavigationActions.EXTRA_PLAN);
            this.plan = bNPLPlan;
        }

        @NotNull
        public final BNPLPlan getPlan() {
            return this.plan;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLDeferredPlanError;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "plan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;)V", "getBNPLValidationError", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "getPlan", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLDeferredPlanError extends BNPLPlanEligibilityState {
        @NotNull
        private final BNPLValidationError bNPLValidationError;
        @NotNull
        private final BNPLPlan plan;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLDeferredPlanError(@NotNull BNPLValidationError bNPLValidationError2, @NotNull BNPLPlan bNPLPlan) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLValidationError2, "bNPLValidationError");
            Intrinsics.checkNotNullParameter(bNPLPlan, TLifeNavigationActions.EXTRA_PLAN);
            this.bNPLValidationError = bNPLValidationError2;
            this.plan = bNPLPlan;
        }

        @NotNull
        public final BNPLValidationError getBNPLValidationError() {
            return this.bNPLValidationError;
        }

        @NotNull
        public final BNPLPlan getPlan() {
            return this.plan;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLHidden;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "()V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLHidden extends BNPLPlanEligibilityState {
        @NotNull
        public static final BNPLHidden INSTANCE = new BNPLHidden();

        private BNPLHidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLInstallmentPlan;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "plan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "installmentAmount", "", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;Ljava/lang/String;)V", "getInstallmentAmount", "()Ljava/lang/String;", "getPlan", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLInstallmentPlan extends BNPLPlanEligibilityState {
        @NotNull
        private final String installmentAmount;
        @NotNull
        private final BNPLPlan plan;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLInstallmentPlan(@NotNull BNPLPlan bNPLPlan, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLPlan, TLifeNavigationActions.EXTRA_PLAN);
            Intrinsics.checkNotNullParameter(str, "installmentAmount");
            this.plan = bNPLPlan;
            this.installmentAmount = str;
        }

        @NotNull
        public final String getInstallmentAmount() {
            return this.installmentAmount;
        }

        @NotNull
        public final BNPLPlan getPlan() {
            return this.plan;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState$BNPLInstallmentPlanError;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "plan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "installmentAmount", "", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;Ljava/lang/String;)V", "getBNPLValidationError", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "getInstallmentAmount", "()Ljava/lang/String;", "getPlan", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BNPLInstallmentPlanError extends BNPLPlanEligibilityState {
        @NotNull
        private final BNPLValidationError bNPLValidationError;
        @NotNull
        private final String installmentAmount;
        @NotNull
        private final BNPLPlan plan;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BNPLInstallmentPlanError(@NotNull BNPLValidationError bNPLValidationError2, @NotNull BNPLPlan bNPLPlan, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(bNPLValidationError2, "bNPLValidationError");
            Intrinsics.checkNotNullParameter(bNPLPlan, TLifeNavigationActions.EXTRA_PLAN);
            Intrinsics.checkNotNullParameter(str, "installmentAmount");
            this.bNPLValidationError = bNPLValidationError2;
            this.plan = bNPLPlan;
            this.installmentAmount = str;
        }

        @NotNull
        public final BNPLValidationError getBNPLValidationError() {
            return this.bNPLValidationError;
        }

        @NotNull
        public final String getInstallmentAmount() {
            return this.installmentAmount;
        }

        @NotNull
        public final BNPLPlan getPlan() {
            return this.plan;
        }
    }

    private BNPLPlanEligibilityState() {
    }

    public /* synthetic */ BNPLPlanEligibilityState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
