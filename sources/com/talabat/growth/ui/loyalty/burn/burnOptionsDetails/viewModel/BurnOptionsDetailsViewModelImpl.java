package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel;

import androidx.lifecycle.ViewModelKt;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.ui.loyalty.burn.burnConfirmation.viewModel.GetRestaurantUseCase;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherUseCase;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.models.ConfirmationDisplayModel;
import com.talabat.talabatcommon.views.vouchers.models.OrderNowDirection;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0017\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0002\u0010\u0012J\b\u0010\u0013\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0011H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J0\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010+\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModelImpl;", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/viewModel/BurnOptionsDetailsViewModel;", "redeemBurnItem", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherUseCase;", "getRestaurantUseCase", "Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/GetRestaurantUseCase;", "dispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherUseCase;Lcom/talabat/growth/ui/loyalty/burn/burnConfirmation/viewModel/GetRestaurantUseCase;Lkotlin/coroutines/CoroutineContext;)V", "getDispatcher", "()Lkotlin/coroutines/CoroutineContext;", "formattedNeededPointsToRedeem", "", "burnItemDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "formattedPoints", "points", "", "(Ljava/lang/Integer;)Ljava/lang/String;", "formattedTotalRemainingPoints", "getRemainingPoints", "pointsCost", "getRestaurantDetails", "", "restaurantId", "confirmationDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/models/ConfirmationDisplayModel;", "onRequestError", "Lcom/talabat/talabatcommon/views/vouchers/models/OrderNowDirection;", "onRestaurantInfoReceived", "restaurant", "Ldatamodels/Restaurant;", "redeemBurnOption", "optionId", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "source", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/RedeemSourceType;", "voucherOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherOptionType;", "redeemTrackData", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/RedeemTrackData;", "setBurnOptionItemDetails", "setupOrderNowDirection", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsViewModelImpl extends BurnOptionsDetailsViewModel {
    @NotNull
    private final CoroutineContext dispatcher;
    @NotNull
    private final GetRestaurantUseCase getRestaurantUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final RedeemVoucherUseCase redeemBurnItem;

    public BurnOptionsDetailsViewModelImpl(@NotNull RedeemVoucherUseCase redeemVoucherUseCase, @NotNull GetRestaurantUseCase getRestaurantUseCase2, @NotNull CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(redeemVoucherUseCase, "redeemBurnItem");
        Intrinsics.checkNotNullParameter(getRestaurantUseCase2, "getRestaurantUseCase");
        Intrinsics.checkNotNullParameter(coroutineContext, "dispatcher");
        this.redeemBurnItem = redeemVoucherUseCase;
        this.getRestaurantUseCase = getRestaurantUseCase2;
        this.dispatcher = coroutineContext;
    }

    private final void getRestaurantDetails(int i11, ConfirmationDisplayModel confirmationDisplayModel) {
        this.getRestaurantUseCase.invoke(Integer.valueOf(i11), new BurnOptionsDetailsViewModelImpl$getRestaurantDetails$1(confirmationDisplayModel, this));
    }

    /* access modifiers changed from: private */
    public final OrderNowDirection onRequestError() {
        return OrderNowDirection.Undefined.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final OrderNowDirection onRestaurantInfoReceived(Restaurant restaurant) {
        return new OrderNowDirection.OneRestaurant(restaurant);
    }

    /* access modifiers changed from: private */
    public final void setupOrderNowDirection(ConfirmationDisplayModel confirmationDisplayModel) {
        Integer brandId = confirmationDisplayModel.getBrandId();
        if (brandId == null) {
            getRedeemData().setValue(confirmationDisplayModel);
        } else {
            getRestaurantDetails(brandId.intValue(), confirmationDisplayModel);
        }
    }

    @NotNull
    public String formattedNeededPointsToRedeem(@NotNull BurnItemDisplayModel burnItemDisplayModel) {
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, "burnItemDisplayModel");
        return formattedPoints(Integer.valueOf(burnItemDisplayModel.getPointsCost() - getTotalPoints()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r1 = com.talabat.growth.ui.util.ExtentionsKt.decimalFormat(r1.intValue());
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String formattedPoints(@org.jetbrains.annotations.Nullable java.lang.Integer r1) {
        /*
            r0 = this;
            if (r1 == 0) goto L_0x000c
            int r1 = r1.intValue()
            java.lang.String r1 = com.talabat.growth.ui.util.ExtentionsKt.decimalFormat(r1)
            if (r1 != 0) goto L_0x0010
        L_0x000c:
            java.lang.String r1 = r0.a()
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.viewModel.BurnOptionsDetailsViewModelImpl.formattedPoints(java.lang.Integer):java.lang.String");
    }

    @NotNull
    public String formattedTotalRemainingPoints() {
        int i11;
        boolean z11;
        Integer valueOf = Integer.valueOf(getTotalPoints());
        int intValue = valueOf.intValue();
        BurnItemDisplayModel value = getBurnItemDisplayModelLiveData().getValue();
        int i12 = 0;
        if (value != null) {
            i11 = value.getPointsCost();
        } else {
            i11 = 0;
        }
        if (intValue >= i11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            valueOf = null;
        }
        if (valueOf != null) {
            valueOf.intValue();
            int totalPoints = getTotalPoints();
            BurnItemDisplayModel value2 = getBurnItemDisplayModelLiveData().getValue();
            if (value2 != null) {
                i12 = value2.getPointsCost();
            }
            i12 = totalPoints - i12;
        }
        return formattedPoints(Integer.valueOf(i12));
    }

    @NotNull
    public final CoroutineContext getDispatcher() {
        return this.dispatcher;
    }

    public int getRemainingPoints(int i11) {
        return getTotalPoints() - i11;
    }

    public void redeemBurnOption(@NotNull String str, @NotNull LoyaltyBurnOptionType loyaltyBurnOptionType, @NotNull RedeemSourceType redeemSourceType, @NotNull VoucherOptionType voucherOptionType, @NotNull RedeemTrackData redeemTrackData) {
        Intrinsics.checkNotNullParameter(str, "optionId");
        Intrinsics.checkNotNullParameter(loyaltyBurnOptionType, "burnOptionType");
        Intrinsics.checkNotNullParameter(redeemSourceType, "source");
        VoucherOptionType voucherOptionType2 = voucherOptionType;
        Intrinsics.checkNotNullParameter(voucherOptionType2, BurnOptionDetailsNavigator.VOUCHER_OPTION_TYPE);
        RedeemTrackData redeemTrackData2 = redeemTrackData;
        Intrinsics.checkNotNullParameter(redeemTrackData2, "redeemTrackData");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new BurnOptionsDetailsViewModelImpl$redeemBurnOption$1(this, str, loyaltyBurnOptionType, redeemSourceType, redeemTrackData2, voucherOptionType2, (Continuation<? super BurnOptionsDetailsViewModelImpl$redeemBurnOption$1>) null), 3, (Object) null);
    }

    public void setBurnOptionItemDetails(@NotNull BurnItemDisplayModel burnItemDisplayModel) {
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, "burnItemDisplayModel");
        getBurnItemDisplayModelLiveData().postValue(burnItemDisplayModel);
    }
}
