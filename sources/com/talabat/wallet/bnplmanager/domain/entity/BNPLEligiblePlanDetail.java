package com.talabat.wallet.bnplmanager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligiblePlanDetail;", "", "()V", "bNPLEligibilityDetail", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligibilityDetail;", "getBNPLEligibilityDetail", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligibilityDetail;", "setBNPLEligibilityDetail", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligibilityDetail;)V", "bNPLPlan", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "getBNPLPlan", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "setBNPLPlan", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;)V", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLEligiblePlanDetail {
    @NotNull
    private BNPLEligibilityDetail bNPLEligibilityDetail = new BNPLEligibilityDetail((BNPLValidationError) null, false, false, 7, (DefaultConstructorMarker) null);
    @NotNull
    private BNPLPlan bNPLPlan = new BNPLPlan((String) null, (String) null, (String) null, (String) null, 0, 0, 0, 127, (DefaultConstructorMarker) null);

    public BNPLEligiblePlanDetail() {
    }

    @NotNull
    public final BNPLEligibilityDetail getBNPLEligibilityDetail() {
        return this.bNPLEligibilityDetail;
    }

    @NotNull
    public final BNPLPlan getBNPLPlan() {
        return this.bNPLPlan;
    }

    public final void setBNPLEligibilityDetail(@NotNull BNPLEligibilityDetail bNPLEligibilityDetail2) {
        Intrinsics.checkNotNullParameter(bNPLEligibilityDetail2, "<set-?>");
        this.bNPLEligibilityDetail = bNPLEligibilityDetail2;
    }

    public final void setBNPLPlan(@NotNull BNPLPlan bNPLPlan2) {
        Intrinsics.checkNotNullParameter(bNPLPlan2, "<set-?>");
        this.bNPLPlan = bNPLPlan2;
    }
}
