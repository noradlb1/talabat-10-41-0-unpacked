package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.binRestriction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/binRestriction/PossibleBinRestrictedVoucher;", "", "isApplied", "", "customerVoucherId", "", "binRestriction", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/binRestriction/BinRestriction;", "(ZLjava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/binRestriction/BinRestriction;)V", "getBinRestriction", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/binRestriction/BinRestriction;", "getCustomerVoucherId", "()Ljava/lang/String;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PossibleBinRestrictedVoucher {
    @Nullable
    private final BinRestriction binRestriction;
    @Nullable
    private final String customerVoucherId;
    private final boolean isApplied;

    public PossibleBinRestrictedVoucher() {
        this(false, (String) null, (BinRestriction) null, 7, (DefaultConstructorMarker) null);
    }

    public PossibleBinRestrictedVoucher(boolean z11, @Nullable String str, @Nullable BinRestriction binRestriction2) {
        this.isApplied = z11;
        this.customerVoucherId = str;
        this.binRestriction = binRestriction2;
    }

    public static /* synthetic */ PossibleBinRestrictedVoucher copy$default(PossibleBinRestrictedVoucher possibleBinRestrictedVoucher, boolean z11, String str, BinRestriction binRestriction2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = possibleBinRestrictedVoucher.isApplied;
        }
        if ((i11 & 2) != 0) {
            str = possibleBinRestrictedVoucher.customerVoucherId;
        }
        if ((i11 & 4) != 0) {
            binRestriction2 = possibleBinRestrictedVoucher.binRestriction;
        }
        return possibleBinRestrictedVoucher.copy(z11, str, binRestriction2);
    }

    public final boolean component1() {
        return this.isApplied;
    }

    @Nullable
    public final String component2() {
        return this.customerVoucherId;
    }

    @Nullable
    public final BinRestriction component3() {
        return this.binRestriction;
    }

    @NotNull
    public final PossibleBinRestrictedVoucher copy(boolean z11, @Nullable String str, @Nullable BinRestriction binRestriction2) {
        return new PossibleBinRestrictedVoucher(z11, str, binRestriction2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PossibleBinRestrictedVoucher)) {
            return false;
        }
        PossibleBinRestrictedVoucher possibleBinRestrictedVoucher = (PossibleBinRestrictedVoucher) obj;
        return this.isApplied == possibleBinRestrictedVoucher.isApplied && Intrinsics.areEqual((Object) this.customerVoucherId, (Object) possibleBinRestrictedVoucher.customerVoucherId) && Intrinsics.areEqual((Object) this.binRestriction, (Object) possibleBinRestrictedVoucher.binRestriction);
    }

    @Nullable
    public final BinRestriction getBinRestriction() {
        return this.binRestriction;
    }

    @Nullable
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    public int hashCode() {
        boolean z11 = this.isApplied;
        if (z11) {
            z11 = true;
        }
        int i11 = (z11 ? 1 : 0) * true;
        String str = this.customerVoucherId;
        int i12 = 0;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        BinRestriction binRestriction2 = this.binRestriction;
        if (binRestriction2 != null) {
            i12 = binRestriction2.hashCode();
        }
        return hashCode + i12;
    }

    public final boolean isApplied() {
        return this.isApplied;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isApplied;
        String str = this.customerVoucherId;
        BinRestriction binRestriction2 = this.binRestriction;
        return "PossibleBinRestrictedVoucher(isApplied=" + z11 + ", customerVoucherId=" + str + ", binRestriction=" + binRestriction2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PossibleBinRestrictedVoucher(boolean z11, String str, BinRestriction binRestriction2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : binRestriction2);
    }
}
