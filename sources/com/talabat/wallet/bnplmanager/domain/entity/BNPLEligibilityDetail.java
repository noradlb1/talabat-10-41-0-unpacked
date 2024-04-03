package com.talabat.wallet.bnplmanager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\f\"\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligibilityDetail;", "", "bNPLValidationError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "isHideBNPLPaymentMethod", "", "isBNPLEligible", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;ZZ)V", "getBNPLValidationError", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;", "setBNPLValidationError", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLValidationError;)V", "()Z", "setBNPLEligible", "(Z)V", "setHideBNPLPaymentMethod", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLEligibilityDetail {
    @NotNull
    private BNPLValidationError bNPLValidationError;
    private boolean isBNPLEligible;
    private boolean isHideBNPLPaymentMethod;

    public BNPLEligibilityDetail() {
        this((BNPLValidationError) null, false, false, 7, (DefaultConstructorMarker) null);
    }

    public BNPLEligibilityDetail(@NotNull BNPLValidationError bNPLValidationError2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(bNPLValidationError2, "bNPLValidationError");
        this.bNPLValidationError = bNPLValidationError2;
        this.isHideBNPLPaymentMethod = z11;
        this.isBNPLEligible = z12;
    }

    public static /* synthetic */ BNPLEligibilityDetail copy$default(BNPLEligibilityDetail bNPLEligibilityDetail, BNPLValidationError bNPLValidationError2, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bNPLValidationError2 = bNPLEligibilityDetail.bNPLValidationError;
        }
        if ((i11 & 2) != 0) {
            z11 = bNPLEligibilityDetail.isHideBNPLPaymentMethod;
        }
        if ((i11 & 4) != 0) {
            z12 = bNPLEligibilityDetail.isBNPLEligible;
        }
        return bNPLEligibilityDetail.copy(bNPLValidationError2, z11, z12);
    }

    @NotNull
    public final BNPLValidationError component1() {
        return this.bNPLValidationError;
    }

    public final boolean component2() {
        return this.isHideBNPLPaymentMethod;
    }

    public final boolean component3() {
        return this.isBNPLEligible;
    }

    @NotNull
    public final BNPLEligibilityDetail copy(@NotNull BNPLValidationError bNPLValidationError2, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(bNPLValidationError2, "bNPLValidationError");
        return new BNPLEligibilityDetail(bNPLValidationError2, z11, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLEligibilityDetail)) {
            return false;
        }
        BNPLEligibilityDetail bNPLEligibilityDetail = (BNPLEligibilityDetail) obj;
        return Intrinsics.areEqual((Object) this.bNPLValidationError, (Object) bNPLEligibilityDetail.bNPLValidationError) && this.isHideBNPLPaymentMethod == bNPLEligibilityDetail.isHideBNPLPaymentMethod && this.isBNPLEligible == bNPLEligibilityDetail.isBNPLEligible;
    }

    @NotNull
    public final BNPLValidationError getBNPLValidationError() {
        return this.bNPLValidationError;
    }

    public int hashCode() {
        int hashCode = this.bNPLValidationError.hashCode() * 31;
        boolean z11 = this.isHideBNPLPaymentMethod;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.isBNPLEligible;
        if (!z13) {
            z12 = z13;
        }
        return i11 + (z12 ? 1 : 0);
    }

    public final boolean isBNPLEligible() {
        return this.isBNPLEligible;
    }

    public final boolean isHideBNPLPaymentMethod() {
        return this.isHideBNPLPaymentMethod;
    }

    public final void setBNPLEligible(boolean z11) {
        this.isBNPLEligible = z11;
    }

    public final void setBNPLValidationError(@NotNull BNPLValidationError bNPLValidationError2) {
        Intrinsics.checkNotNullParameter(bNPLValidationError2, "<set-?>");
        this.bNPLValidationError = bNPLValidationError2;
    }

    public final void setHideBNPLPaymentMethod(boolean z11) {
        this.isHideBNPLPaymentMethod = z11;
    }

    @NotNull
    public String toString() {
        BNPLValidationError bNPLValidationError2 = this.bNPLValidationError;
        boolean z11 = this.isHideBNPLPaymentMethod;
        boolean z12 = this.isBNPLEligible;
        return "BNPLEligibilityDetail(bNPLValidationError=" + bNPLValidationError2 + ", isHideBNPLPaymentMethod=" + z11 + ", isBNPLEligible=" + z12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLEligibilityDetail(BNPLValidationError bNPLValidationError2, boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new BNPLValidationError((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : bNPLValidationError2, (i11 & 2) != 0 ? true : z11, (i11 & 4) != 0 ? false : z12);
    }
}
