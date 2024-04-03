package com.talabat.talabatcommon.feature.vouchers.loyalty.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0002\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictedVoucherResponse;", "", "isApplied", "", "customerVoucherId", "", "binRestriction", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictionResponse;", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictionResponse;)V", "getBinRestriction", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictionResponse;", "getCustomerVoucherId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictionResponse;)Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/BinRestrictedVoucherResponse;", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BinRestrictedVoucherResponse {
    @SerializedName("binRestriction")
    @Nullable
    private final BinRestrictionResponse binRestriction;
    @SerializedName("customerVoucherId")
    @Nullable
    private final String customerVoucherId;
    @SerializedName("isApplied")
    @Nullable
    private final Boolean isApplied;

    public BinRestrictedVoucherResponse() {
        this((Boolean) null, (String) null, (BinRestrictionResponse) null, 7, (DefaultConstructorMarker) null);
    }

    public BinRestrictedVoucherResponse(@Nullable Boolean bool, @Nullable String str, @Nullable BinRestrictionResponse binRestrictionResponse) {
        this.isApplied = bool;
        this.customerVoucherId = str;
        this.binRestriction = binRestrictionResponse;
    }

    public static /* synthetic */ BinRestrictedVoucherResponse copy$default(BinRestrictedVoucherResponse binRestrictedVoucherResponse, Boolean bool, String str, BinRestrictionResponse binRestrictionResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = binRestrictedVoucherResponse.isApplied;
        }
        if ((i11 & 2) != 0) {
            str = binRestrictedVoucherResponse.customerVoucherId;
        }
        if ((i11 & 4) != 0) {
            binRestrictionResponse = binRestrictedVoucherResponse.binRestriction;
        }
        return binRestrictedVoucherResponse.copy(bool, str, binRestrictionResponse);
    }

    @Nullable
    public final Boolean component1() {
        return this.isApplied;
    }

    @Nullable
    public final String component2() {
        return this.customerVoucherId;
    }

    @Nullable
    public final BinRestrictionResponse component3() {
        return this.binRestriction;
    }

    @NotNull
    public final BinRestrictedVoucherResponse copy(@Nullable Boolean bool, @Nullable String str, @Nullable BinRestrictionResponse binRestrictionResponse) {
        return new BinRestrictedVoucherResponse(bool, str, binRestrictionResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BinRestrictedVoucherResponse)) {
            return false;
        }
        BinRestrictedVoucherResponse binRestrictedVoucherResponse = (BinRestrictedVoucherResponse) obj;
        return Intrinsics.areEqual((Object) this.isApplied, (Object) binRestrictedVoucherResponse.isApplied) && Intrinsics.areEqual((Object) this.customerVoucherId, (Object) binRestrictedVoucherResponse.customerVoucherId) && Intrinsics.areEqual((Object) this.binRestriction, (Object) binRestrictedVoucherResponse.binRestriction);
    }

    @Nullable
    public final BinRestrictionResponse getBinRestriction() {
        return this.binRestriction;
    }

    @Nullable
    public final String getCustomerVoucherId() {
        return this.customerVoucherId;
    }

    public int hashCode() {
        Boolean bool = this.isApplied;
        int i11 = 0;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        String str = this.customerVoucherId;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        BinRestrictionResponse binRestrictionResponse = this.binRestriction;
        if (binRestrictionResponse != null) {
            i11 = binRestrictionResponse.hashCode();
        }
        return hashCode2 + i11;
    }

    @Nullable
    public final Boolean isApplied() {
        return this.isApplied;
    }

    @NotNull
    public String toString() {
        Boolean bool = this.isApplied;
        String str = this.customerVoucherId;
        BinRestrictionResponse binRestrictionResponse = this.binRestriction;
        return "BinRestrictedVoucherResponse(isApplied=" + bool + ", customerVoucherId=" + str + ", binRestriction=" + binRestrictionResponse + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BinRestrictedVoucherResponse(Boolean bool, String str, BinRestrictionResponse binRestrictionResponse, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Boolean.FALSE : bool, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : binRestrictionResponse);
    }
}
