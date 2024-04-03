package com.talabat.talabatcommon.views.ridersTip.viewModel;

import androidx.lifecycle.MutableLiveData;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.feature.ridersTip.CheckDesignSystemChipsEnabledUseCase;
import com.talabat.talabatcommon.feature.ridersTip.GetRiderTipPaymentUseCase;
import com.talabat.talabatcommon.feature.ridersTip.GetRiderTipSuggestedAmountUseCase;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderPaymentRequestModel;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.TipRiderTracking;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.views.ridersTip.model.RiderTipPaymentDisplayModel;
import com.talabat.talabatcommon.views.ridersTip.model.RidersTipSuggestedAmountDisplayModel;
import com.talabat.talabatcommon.views.ridersTip.model.RidersTipSuggestionsDisplayModel;
import com.talabat.talabatcommon.views.ridersTip.viewModel.RiderTipViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0014H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0002J \u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0016J2\u0010)\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020&2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J2\u0010.\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020&2\u0006\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J*\u0010/\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020&2\u0006\u00100\u001a\u00020&2\u0006\u0010+\u001a\u00020&H\u0016J\"\u00101\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020&2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0016R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModelImpl;", "Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel;", "getRiderTipSuggestedAmountUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/GetRiderTipSuggestedAmountUseCase;", "getRiderTipPaymentUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/GetRiderTipPaymentUseCase;", "checkDesignSystemChipsEnabledUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/CheckDesignSystemChipsEnabledUseCase;", "tipRiderTracking", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/TipRiderTracking;", "(Lcom/talabat/talabatcommon/feature/ridersTip/GetRiderTipSuggestedAmountUseCase;Lcom/talabat/talabatcommon/feature/ridersTip/GetRiderTipPaymentUseCase;Lcom/talabat/talabatcommon/feature/ridersTip/CheckDesignSystemChipsEnabledUseCase;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/TipRiderTracking;)V", "buttonAction", "Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel$ButtonActionViewType;", "getButtonAction", "()Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel$ButtonActionViewType;", "setButtonAction", "(Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel$ButtonActionViewType;)V", "getAmount", "", "index", "", "(Ljava/lang/Integer;)Ljava/lang/Float;", "getChipsFeatureFlag", "", "getOrderStatusTrackingValue", "orderStatus", "Lcom/talabat/talabatcommon/enums/OrderStatus;", "getRiderTipSuggestedAmount", "country", "handleRiderTipPaymentSuccess", "riderTipPaymentDisplayModel", "Lcom/talabat/talabatcommon/views/ridersTip/model/RiderTipPaymentDisplayModel;", "handleRiderTipSuggestedAmount", "list", "", "Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestedAmountDisplayModel;", "onSetTippingData", "encryptedOrderId", "", "orderId", "screenName", "onTipRiderClicked", "tipValue", "paymentMethod", "source", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;", "onTipRiderCompleted", "onTipRiderFailure", "errorMessage", "onTipRiderOpen", "payRiderTip", "riderPaymentRequestModel", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderPaymentRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipViewModelImpl extends RiderTipViewModel {
    @NotNull
    private RiderTipViewModel.ButtonActionViewType buttonAction = RiderTipViewModel.ButtonActionViewType.ADDCARD;
    @NotNull
    private final CheckDesignSystemChipsEnabledUseCase checkDesignSystemChipsEnabledUseCase;
    @NotNull
    private final GetRiderTipPaymentUseCase getRiderTipPaymentUseCase;
    @NotNull
    private final GetRiderTipSuggestedAmountUseCase getRiderTipSuggestedAmountUseCase;
    @NotNull
    private final TipRiderTracking tipRiderTracking;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OrderStatus.values().length];
            iArr[OrderStatus.PREPARING.ordinal()] = 1;
            iArr[OrderStatus.DELIVERING.ordinal()] = 2;
            iArr[OrderStatus.DELIVERED.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public RiderTipViewModelImpl(@NotNull GetRiderTipSuggestedAmountUseCase getRiderTipSuggestedAmountUseCase2, @NotNull GetRiderTipPaymentUseCase getRiderTipPaymentUseCase2, @NotNull CheckDesignSystemChipsEnabledUseCase checkDesignSystemChipsEnabledUseCase2, @NotNull TipRiderTracking tipRiderTracking2) {
        Intrinsics.checkNotNullParameter(getRiderTipSuggestedAmountUseCase2, "getRiderTipSuggestedAmountUseCase");
        Intrinsics.checkNotNullParameter(getRiderTipPaymentUseCase2, "getRiderTipPaymentUseCase");
        Intrinsics.checkNotNullParameter(checkDesignSystemChipsEnabledUseCase2, "checkDesignSystemChipsEnabledUseCase");
        Intrinsics.checkNotNullParameter(tipRiderTracking2, "tipRiderTracking");
        this.getRiderTipSuggestedAmountUseCase = getRiderTipSuggestedAmountUseCase2;
        this.getRiderTipPaymentUseCase = getRiderTipPaymentUseCase2;
        this.checkDesignSystemChipsEnabledUseCase = checkDesignSystemChipsEnabledUseCase2;
        this.tipRiderTracking = tipRiderTracking2;
    }

    private final int getOrderStatusTrackingValue(OrderStatus orderStatus) {
        int i11 = orderStatus == null ? -1 : WhenMappings.$EnumSwitchMapping$0[orderStatus.ordinal()];
        if (i11 == 1) {
            return 1;
        }
        if (i11 != 2) {
            return i11 != 3 ? 0 : 3;
        }
        return 2;
    }

    /* access modifiers changed from: private */
    public final void handleRiderTipPaymentSuccess(RiderTipPaymentDisplayModel riderTipPaymentDisplayModel) {
        getRiderTipPaymentData().setValue(riderTipPaymentDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleRiderTipSuggestedAmount(List<RidersTipSuggestedAmountDisplayModel> list) {
        MutableLiveData<RidersTipSuggestionsDisplayModel> riderTipSuggestedAmountData = getRiderTipSuggestedAmountData();
        Boolean value = getShouldShowTipsAsChips().getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        riderTipSuggestedAmountData.setValue(new RidersTipSuggestionsDisplayModel(list, value.booleanValue()));
    }

    @Nullable
    public Float getAmount(@Nullable Integer num) {
        List<RidersTipSuggestedAmountDisplayModel> tipsAmountList;
        RidersTipSuggestedAmountDisplayModel ridersTipSuggestedAmountDisplayModel;
        RidersTipSuggestionsDisplayModel value = getRiderTipSuggestedAmountData().getValue();
        if (value == null || (tipsAmountList = value.getTipsAmountList()) == null || (ridersTipSuggestedAmountDisplayModel = tipsAmountList.get(IntKt.orZero(num))) == null) {
            return null;
        }
        return Float.valueOf(ridersTipSuggestedAmountDisplayModel.getAmount());
    }

    @NotNull
    public RiderTipViewModel.ButtonActionViewType getButtonAction() {
        return this.buttonAction;
    }

    public void getChipsFeatureFlag() {
        getShouldShowTipsAsChips().setValue(Boolean.valueOf(this.checkDesignSystemChipsEnabledUseCase.invoke()));
    }

    public void getRiderTipSuggestedAmount(int i11) {
        this.getRiderTipSuggestedAmountUseCase.invoke(Integer.valueOf(i11), new RiderTipViewModelImpl$getRiderTipSuggestedAmount$1(this));
    }

    public void onSetTippingData(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        Intrinsics.checkNotNullParameter(str2, "orderId");
        Intrinsics.checkNotNullParameter(str3, "screenName");
        setEncryptedOrderId(str);
        setOrderId(str2);
        setScreenSource(str3);
    }

    public void onTipRiderClicked(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull TipRiderSource tipRiderSource) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "tipValue");
        Intrinsics.checkNotNullParameter(str3, "paymentMethod");
        Intrinsics.checkNotNullParameter(tipRiderSource, "source");
        this.tipRiderTracking.tipRiderClicked(String.valueOf(getOrderStatusTrackingValue(orderStatus)), str, str2, str3, tipRiderSource.getScreenName());
    }

    public void onTipRiderCompleted(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull TipRiderSource tipRiderSource) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "tipValue");
        Intrinsics.checkNotNullParameter(str3, "paymentMethod");
        Intrinsics.checkNotNullParameter(tipRiderSource, "source");
        this.tipRiderTracking.tipRiderCompleted(String.valueOf(getOrderStatusTrackingValue(orderStatus)), str, str2, str3, tipRiderSource.getScreenName());
    }

    public void onTipRiderFailure(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        Intrinsics.checkNotNullParameter(str3, "paymentMethod");
        this.tipRiderTracking.tipRiderFailure(String.valueOf(getOrderStatusTrackingValue(orderStatus)), str, str2, str3);
    }

    public void onTipRiderOpen(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull TipRiderSource tipRiderSource) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        Intrinsics.checkNotNullParameter(tipRiderSource, "source");
        this.tipRiderTracking.tipRiderOpened(String.valueOf(getOrderStatusTrackingValue(orderStatus)), str, tipRiderSource.getScreenName());
    }

    public void payRiderTip(@NotNull RiderPaymentRequestModel riderPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(riderPaymentRequestModel, "riderPaymentRequestModel");
        this.getRiderTipPaymentUseCase.invoke(riderPaymentRequestModel, new RiderTipViewModelImpl$payRiderTip$1(this));
    }

    public void setButtonAction(@NotNull RiderTipViewModel.ButtonActionViewType buttonActionViewType) {
        Intrinsics.checkNotNullParameter(buttonActionViewType, "<set-?>");
        this.buttonAction = buttonActionViewType;
    }
}
