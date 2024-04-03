package com.talabat.talabatcommon.feature.vouchers.loyalty.model.request;

import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003J=\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/RedeemBurnItemRequestModel;", "", "itemId", "", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "source", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/RedeemSourceType;", "redeemTrackData", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/RedeemTrackData;", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "(Ljava/lang/String;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/RedeemSourceType;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/RedeemTrackData;Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;)V", "getBurnOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "getItemId", "()Ljava/lang/String;", "getRedeemTrackData", "()Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/RedeemTrackData;", "getSource", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/RedeemSourceType;", "getVoucherOptionType", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RedeemBurnItemRequestModel {
    @NotNull
    private final LoyaltyBurnOptionType burnOptionType;
    @NotNull
    private final String itemId;
    @NotNull
    private final RedeemTrackData redeemTrackData;
    @NotNull
    private final RedeemSourceType source;
    @Nullable
    private final VoucherOptionType voucherOptionType;

    public RedeemBurnItemRequestModel(@NotNull String str, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull RedeemSourceType redeemSourceType, @NotNull RedeemTrackData redeemTrackData2, @Nullable VoucherOptionType voucherOptionType2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(loyaltyBurnOptionType, "burnOptionType");
        Intrinsics.checkNotNullParameter(redeemSourceType, "source");
        Intrinsics.checkNotNullParameter(redeemTrackData2, "redeemTrackData");
        this.itemId = str;
        this.burnOptionType = loyaltyBurnOptionType;
        this.source = redeemSourceType;
        this.redeemTrackData = redeemTrackData2;
        this.voucherOptionType = voucherOptionType2;
    }

    public static /* synthetic */ RedeemBurnItemRequestModel copy$default(RedeemBurnItemRequestModel redeemBurnItemRequestModel, String str, LoyaltyBurnOptionType loyaltyBurnOptionType, RedeemSourceType redeemSourceType, RedeemTrackData redeemTrackData2, VoucherOptionType voucherOptionType2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = redeemBurnItemRequestModel.itemId;
        }
        if ((i11 & 2) != 0) {
            loyaltyBurnOptionType = redeemBurnItemRequestModel.burnOptionType;
        }
        LoyaltyBurnOptionType loyaltyBurnOptionType2 = loyaltyBurnOptionType;
        if ((i11 & 4) != 0) {
            redeemSourceType = redeemBurnItemRequestModel.source;
        }
        RedeemSourceType redeemSourceType2 = redeemSourceType;
        if ((i11 & 8) != 0) {
            redeemTrackData2 = redeemBurnItemRequestModel.redeemTrackData;
        }
        RedeemTrackData redeemTrackData3 = redeemTrackData2;
        if ((i11 & 16) != 0) {
            voucherOptionType2 = redeemBurnItemRequestModel.voucherOptionType;
        }
        return redeemBurnItemRequestModel.copy(str, loyaltyBurnOptionType2, redeemSourceType2, redeemTrackData3, voucherOptionType2);
    }

    @NotNull
    public final String component1() {
        return this.itemId;
    }

    @NotNull
    public final LoyaltyBurnOptionType component2() {
        return this.burnOptionType;
    }

    @NotNull
    public final RedeemSourceType component3() {
        return this.source;
    }

    @NotNull
    public final RedeemTrackData component4() {
        return this.redeemTrackData;
    }

    @Nullable
    public final VoucherOptionType component5() {
        return this.voucherOptionType;
    }

    @NotNull
    public final RedeemBurnItemRequestModel copy(@NotNull String str, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull RedeemSourceType redeemSourceType, @NotNull RedeemTrackData redeemTrackData2, @Nullable VoucherOptionType voucherOptionType2) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(loyaltyBurnOptionType, "burnOptionType");
        Intrinsics.checkNotNullParameter(redeemSourceType, "source");
        Intrinsics.checkNotNullParameter(redeemTrackData2, "redeemTrackData");
        return new RedeemBurnItemRequestModel(str, loyaltyBurnOptionType, redeemSourceType, redeemTrackData2, voucherOptionType2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemBurnItemRequestModel)) {
            return false;
        }
        RedeemBurnItemRequestModel redeemBurnItemRequestModel = (RedeemBurnItemRequestModel) obj;
        return Intrinsics.areEqual((Object) this.itemId, (Object) redeemBurnItemRequestModel.itemId) && this.burnOptionType == redeemBurnItemRequestModel.burnOptionType && this.source == redeemBurnItemRequestModel.source && Intrinsics.areEqual((Object) this.redeemTrackData, (Object) redeemBurnItemRequestModel.redeemTrackData) && this.voucherOptionType == redeemBurnItemRequestModel.voucherOptionType;
    }

    @NotNull
    public final LoyaltyBurnOptionType getBurnOptionType() {
        return this.burnOptionType;
    }

    @NotNull
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    public final RedeemTrackData getRedeemTrackData() {
        return this.redeemTrackData;
    }

    @NotNull
    public final RedeemSourceType getSource() {
        return this.source;
    }

    @Nullable
    public final VoucherOptionType getVoucherOptionType() {
        return this.voucherOptionType;
    }

    public int hashCode() {
        int hashCode = ((((((this.itemId.hashCode() * 31) + this.burnOptionType.hashCode()) * 31) + this.source.hashCode()) * 31) + this.redeemTrackData.hashCode()) * 31;
        VoucherOptionType voucherOptionType2 = this.voucherOptionType;
        return hashCode + (voucherOptionType2 == null ? 0 : voucherOptionType2.hashCode());
    }

    @NotNull
    public String toString() {
        String str = this.itemId;
        LoyaltyBurnOptionType loyaltyBurnOptionType = this.burnOptionType;
        RedeemSourceType redeemSourceType = this.source;
        RedeemTrackData redeemTrackData2 = this.redeemTrackData;
        VoucherOptionType voucherOptionType2 = this.voucherOptionType;
        return "RedeemBurnItemRequestModel(itemId=" + str + ", burnOptionType=" + loyaltyBurnOptionType + ", source=" + redeemSourceType + ", redeemTrackData=" + redeemTrackData2 + ", voucherOptionType=" + voucherOptionType2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemBurnItemRequestModel(String str, LoyaltyBurnOptionType loyaltyBurnOptionType, RedeemSourceType redeemSourceType, RedeemTrackData redeemTrackData2, VoucherOptionType voucherOptionType2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, loyaltyBurnOptionType, redeemSourceType, redeemTrackData2, (i11 & 16) != 0 ? null : voucherOptionType2);
    }
}
