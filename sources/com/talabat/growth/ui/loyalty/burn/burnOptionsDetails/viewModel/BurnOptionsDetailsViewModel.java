package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH&J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0002H&J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0019\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u00028\u0004XD¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001a\u001a\u0004\b$\u0010\u001c\"\u0004\b%\u0010&R(\u0010)\u001a\b\u0012\u0004\u0012\u00020(0'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110'8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u00064"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "", "optionId", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/RedeemSourceType;", "source", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "voucherOptionType", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/RedeemTrackData;", "redeemTrackData", "", "redeemBurnOption", "", "pointsCost", "getRemainingPoints", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "burnItemDisplayModel", "setBurnOptionItemDetails", "formattedTotalRemainingPoints", "formattedNeededPointsToRedeem", "points", "formattedPoints", "(Ljava/lang/Integer;)Ljava/lang/String;", "emptyPointsPlaceHolderDisplayModel", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "totalPoints", "I", "getTotalPoints", "()I", "setTotalPoints", "(I)V", "redeemOptionTitle", "getRedeemOptionTitle", "setRedeemOptionTitle", "(Ljava/lang/String;)V", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "redeemData", "Landroidx/lifecycle/MutableLiveData;", "getRedeemData", "()Landroidx/lifecycle/MutableLiveData;", "setRedeemData", "(Landroidx/lifecycle/MutableLiveData;)V", "burnItemDisplayModelLiveData", "getBurnItemDisplayModelLiveData", "setBurnItemDisplayModelLiveData", "<init>", "()V", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0})
public abstract class BurnOptionsDetailsViewModel extends BaseViewModel {
    @NotNull
    private MutableLiveData<BurnItemDisplayModel> burnItemDisplayModelLiveData = new MutableLiveData<>();
    @NotNull
    private final String emptyPointsPlaceHolderDisplayModel = "";
    @NotNull
    private MutableLiveData<ConfirmationDisplayModel> redeemData = new MutableLiveData<>();
    @NotNull
    private String redeemOptionTitle = "";
    private int totalPoints;

    @NotNull
    public final String a() {
        return this.emptyPointsPlaceHolderDisplayModel;
    }

    @NotNull
    public abstract String formattedNeededPointsToRedeem(@NotNull BurnItemDisplayModel burnItemDisplayModel);

    @NotNull
    public abstract String formattedPoints(@Nullable Integer num);

    @NotNull
    public abstract String formattedTotalRemainingPoints();

    @NotNull
    public final MutableLiveData<BurnItemDisplayModel> getBurnItemDisplayModelLiveData() {
        return this.burnItemDisplayModelLiveData;
    }

    @NotNull
    public final MutableLiveData<ConfirmationDisplayModel> getRedeemData() {
        return this.redeemData;
    }

    @NotNull
    public final String getRedeemOptionTitle() {
        return this.redeemOptionTitle;
    }

    public abstract int getRemainingPoints(int i11);

    public final int getTotalPoints() {
        return this.totalPoints;
    }

    public abstract void redeemBurnOption(@NotNull String str, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull RedeemSourceType redeemSourceType, @NotNull VoucherOptionType voucherOptionType, @NotNull RedeemTrackData redeemTrackData);

    public final void setBurnItemDisplayModelLiveData(@NotNull MutableLiveData<BurnItemDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.burnItemDisplayModelLiveData = mutableLiveData;
    }

    public abstract void setBurnOptionItemDetails(@NotNull BurnItemDisplayModel burnItemDisplayModel);

    public final void setRedeemData(@NotNull MutableLiveData<ConfirmationDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.redeemData = mutableLiveData;
    }

    public final void setRedeemOptionTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.redeemOptionTitle = str;
    }

    public final void setTotalPoints(int i11) {
        this.totalPoints = i11;
    }
}
