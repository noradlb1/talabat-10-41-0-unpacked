package com.talabat.wallet.bnplmanager.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentStatus;", "", "isOrderPaymentSuccessful", "", "orderPaymentError", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;", "isServerError", "(ZLcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;Z)V", "()Z", "getOrderPaymentError", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLOrderPaymentStatus {
    private final boolean isOrderPaymentSuccessful;
    private final boolean isServerError;
    @NotNull
    private final BNPLOrderPaymentError orderPaymentError;

    public BNPLOrderPaymentStatus() {
        this(false, (BNPLOrderPaymentError) null, false, 7, (DefaultConstructorMarker) null);
    }

    public BNPLOrderPaymentStatus(boolean z11, @NotNull BNPLOrderPaymentError bNPLOrderPaymentError, boolean z12) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentError, "orderPaymentError");
        this.isOrderPaymentSuccessful = z11;
        this.orderPaymentError = bNPLOrderPaymentError;
        this.isServerError = z12;
    }

    public static /* synthetic */ BNPLOrderPaymentStatus copy$default(BNPLOrderPaymentStatus bNPLOrderPaymentStatus, boolean z11, BNPLOrderPaymentError bNPLOrderPaymentError, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = bNPLOrderPaymentStatus.isOrderPaymentSuccessful;
        }
        if ((i11 & 2) != 0) {
            bNPLOrderPaymentError = bNPLOrderPaymentStatus.orderPaymentError;
        }
        if ((i11 & 4) != 0) {
            z12 = bNPLOrderPaymentStatus.isServerError;
        }
        return bNPLOrderPaymentStatus.copy(z11, bNPLOrderPaymentError, z12);
    }

    public final boolean component1() {
        return this.isOrderPaymentSuccessful;
    }

    @NotNull
    public final BNPLOrderPaymentError component2() {
        return this.orderPaymentError;
    }

    public final boolean component3() {
        return this.isServerError;
    }

    @NotNull
    public final BNPLOrderPaymentStatus copy(boolean z11, @NotNull BNPLOrderPaymentError bNPLOrderPaymentError, boolean z12) {
        Intrinsics.checkNotNullParameter(bNPLOrderPaymentError, "orderPaymentError");
        return new BNPLOrderPaymentStatus(z11, bNPLOrderPaymentError, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLOrderPaymentStatus)) {
            return false;
        }
        BNPLOrderPaymentStatus bNPLOrderPaymentStatus = (BNPLOrderPaymentStatus) obj;
        return this.isOrderPaymentSuccessful == bNPLOrderPaymentStatus.isOrderPaymentSuccessful && Intrinsics.areEqual((Object) this.orderPaymentError, (Object) bNPLOrderPaymentStatus.orderPaymentError) && this.isServerError == bNPLOrderPaymentStatus.isServerError;
    }

    @NotNull
    public final BNPLOrderPaymentError getOrderPaymentError() {
        return this.orderPaymentError;
    }

    public int hashCode() {
        boolean z11 = this.isOrderPaymentSuccessful;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int hashCode = (((z11 ? 1 : 0) * true) + this.orderPaymentError.hashCode()) * 31;
        boolean z13 = this.isServerError;
        if (!z13) {
            z12 = z13;
        }
        return hashCode + (z12 ? 1 : 0);
    }

    public final boolean isOrderPaymentSuccessful() {
        return this.isOrderPaymentSuccessful;
    }

    public final boolean isServerError() {
        return this.isServerError;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isOrderPaymentSuccessful;
        BNPLOrderPaymentError bNPLOrderPaymentError = this.orderPaymentError;
        boolean z12 = this.isServerError;
        return "BNPLOrderPaymentStatus(isOrderPaymentSuccessful=" + z11 + ", orderPaymentError=" + bNPLOrderPaymentError + ", isServerError=" + z12 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLOrderPaymentStatus(boolean z11, BNPLOrderPaymentError bNPLOrderPaymentError, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? new BNPLOrderPaymentError((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null) : bNPLOrderPaymentError, (i11 & 4) != 0 ? false : z12);
    }
}
