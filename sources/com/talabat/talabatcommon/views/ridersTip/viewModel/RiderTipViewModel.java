package com.talabat.talabatcommon.views.ridersTip.viewModel;

import JsonModels.Response.WalletTransactionTypes;
import androidx.lifecycle.MutableLiveData;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.talabatcommon.enums.OrderStatus;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderPaymentRequestModel;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.TipRiderSource;
import com.talabat.talabatcommon.views.ridersTip.model.RiderTipPaymentDisplayModel;
import com.talabat.talabatcommon.views.ridersTip.model.RidersTipSuggestionsDisplayModel;
import com.talabat.talabatcore.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001FB\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010.\u001a\u0004\u0018\u00010/2\b\u00100\u001a\u0004\u0018\u00010!H&¢\u0006\u0002\u00101J\b\u00102\u001a\u000203H&J\u0012\u00104\u001a\u0002032\b\b\u0002\u00105\u001a\u00020!H&J \u00106\u001a\u0002032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u00107\u001a\u00020\nH&J2\u00108\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020>H&J2\u0010?\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\n2\u0006\u0010=\u001a\u00020>H&J*\u0010@\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010A\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH&J\"\u0010B\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010=\u001a\u00020>H&J\u0010\u0010C\u001a\u0002032\u0006\u0010D\u001a\u00020EH&R\u0018\u0010\u0003\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010\u000eR\u001e\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R \u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001e\u0010+\u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%¨\u0006G"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "()V", "buttonAction", "Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel$ButtonActionViewType;", "getButtonAction", "()Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel$ButtonActionViewType;", "setButtonAction", "(Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel$ButtonActionViewType;)V", "encryptedOrderId", "", "getEncryptedOrderId", "()Ljava/lang/String;", "setEncryptedOrderId", "(Ljava/lang/String;)V", "orderId", "getOrderId", "setOrderId", "riderTipPaymentData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/talabatcommon/views/ridersTip/model/RiderTipPaymentDisplayModel;", "getRiderTipPaymentData", "()Landroidx/lifecycle/MutableLiveData;", "setRiderTipPaymentData", "(Landroidx/lifecycle/MutableLiveData;)V", "riderTipSuggestedAmountData", "Lcom/talabat/talabatcommon/views/ridersTip/model/RidersTipSuggestionsDisplayModel;", "getRiderTipSuggestedAmountData", "setRiderTipSuggestedAmountData", "screenSource", "getScreenSource", "setScreenSource", "selectedTipIndex", "", "getSelectedTipIndex", "()Ljava/lang/Integer;", "setSelectedTipIndex", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "shouldShowTipsAsChips", "", "getShouldShowTipsAsChips", "setShouldShowTipsAsChips", "transactionType", "getTransactionType", "setTransactionType", "getAmount", "", "index", "(Ljava/lang/Integer;)Ljava/lang/Float;", "getChipsFeatureFlag", "", "getRiderTipSuggestedAmount", "country", "onSetTippingData", "screenName", "onTipRiderClicked", "orderStatus", "Lcom/talabat/talabatcommon/enums/OrderStatus;", "tipValue", "paymentMethod", "source", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/TipRiderSource;", "onTipRiderCompleted", "onTipRiderFailure", "errorMessage", "onTipRiderOpen", "payRiderTip", "riderPaymentRequestModel", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderPaymentRequestModel;", "ButtonActionViewType", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class RiderTipViewModel extends BaseViewModel {
    @NotNull
    private String encryptedOrderId;
    @NotNull
    private String orderId;
    @NotNull
    private MutableLiveData<RiderTipPaymentDisplayModel> riderTipPaymentData = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<RidersTipSuggestionsDisplayModel> riderTipSuggestedAmountData = new MutableLiveData<>();
    @NotNull
    private String screenSource;
    @Nullable
    private Integer selectedTipIndex;
    @NotNull
    private MutableLiveData<Boolean> shouldShowTipsAsChips = new MutableLiveData<>();
    @Nullable
    private Integer transactionType = WalletTransactionTypes.RIDERTIP.getValue();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/views/ridersTip/viewModel/RiderTipViewModel$ButtonActionViewType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "ADDCARD", "PAYRIDERTIP", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ButtonActionViewType {
        ADDCARD(0),
        PAYRIDERTIP(1);
        
        private final int value;

        private ButtonActionViewType(int i11) {
            this.value = i11;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public RiderTipViewModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.encryptedOrderId = StringUtils.empty(stringCompanionObject);
        this.orderId = StringUtils.empty(stringCompanionObject);
        this.screenSource = StringUtils.empty(stringCompanionObject);
    }

    public static /* synthetic */ void getRiderTipSuggestedAmount$default(RiderTipViewModel riderTipViewModel, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
            }
            riderTipViewModel.getRiderTipSuggestedAmount(i11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getRiderTipSuggestedAmount");
    }

    @Nullable
    public abstract Float getAmount(@Nullable Integer num);

    @NotNull
    public abstract ButtonActionViewType getButtonAction();

    public abstract void getChipsFeatureFlag();

    @NotNull
    public final String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    @NotNull
    public final MutableLiveData<RiderTipPaymentDisplayModel> getRiderTipPaymentData() {
        return this.riderTipPaymentData;
    }

    public abstract void getRiderTipSuggestedAmount(int i11);

    @NotNull
    public final MutableLiveData<RidersTipSuggestionsDisplayModel> getRiderTipSuggestedAmountData() {
        return this.riderTipSuggestedAmountData;
    }

    @NotNull
    public final String getScreenSource() {
        return this.screenSource;
    }

    @Nullable
    public final Integer getSelectedTipIndex() {
        return this.selectedTipIndex;
    }

    @NotNull
    public final MutableLiveData<Boolean> getShouldShowTipsAsChips() {
        return this.shouldShowTipsAsChips;
    }

    @Nullable
    public final Integer getTransactionType() {
        return this.transactionType;
    }

    public abstract void onSetTippingData(@NotNull String str, @NotNull String str2, @NotNull String str3);

    public abstract void onTipRiderClicked(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull TipRiderSource tipRiderSource);

    public abstract void onTipRiderCompleted(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull TipRiderSource tipRiderSource);

    public abstract void onTipRiderFailure(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull String str2, @NotNull String str3);

    public abstract void onTipRiderOpen(@Nullable OrderStatus orderStatus, @NotNull String str, @NotNull TipRiderSource tipRiderSource);

    public abstract void payRiderTip(@NotNull RiderPaymentRequestModel riderPaymentRequestModel);

    public abstract void setButtonAction(@NotNull ButtonActionViewType buttonActionViewType);

    public final void setEncryptedOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.encryptedOrderId = str;
    }

    public final void setOrderId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderId = str;
    }

    public final void setRiderTipPaymentData(@NotNull MutableLiveData<RiderTipPaymentDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.riderTipPaymentData = mutableLiveData;
    }

    public final void setRiderTipSuggestedAmountData(@NotNull MutableLiveData<RidersTipSuggestionsDisplayModel> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.riderTipSuggestedAmountData = mutableLiveData;
    }

    public final void setScreenSource(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.screenSource = str;
    }

    public final void setSelectedTipIndex(@Nullable Integer num) {
        this.selectedTipIndex = num;
    }

    public final void setShouldShowTipsAsChips(@NotNull MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.shouldShowTipsAsChips = mutableLiveData;
    }

    public final void setTransactionType(@Nullable Integer num) {
        this.transactionType = num;
    }
}
