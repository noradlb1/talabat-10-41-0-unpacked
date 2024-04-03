package com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel;

import JsonModels.PlaceOrderResponse;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.Cart;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.SetTipRiderStatusUseCase;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.domain.business.usecase.GetBNPLEligiblePlanUseCase;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLEligiblePlanDetail;
import com.talabat.wallet.checkoutpaymentmanager.domain.application.usecase.GetWalletBalanceApiEnabledUseCase;
import com.talabat.wallet.checkoutpaymentmanager.domain.business.usecase.GetPaymentMethodUpdate;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPlanEligibilityState;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPopUpViewState;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.CheckoutPaymentUpdateDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.QPayRedirectUrlDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.WalletBalanceDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel.mapper.CheckoutPaymentUpdateMapper;
import com.talabat.wallet.walletbalance.domain.business.usecase.WalletBalanceUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010=\u001a\u00020>2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020@J0\u0010B\u001a\u00020>2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020 2\u000e\u0010F\u001a\n\u0012\u0004\u0012\u00020H\u0018\u00010G2\u0006\u0010I\u001a\u00020JJ\u000e\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020 J\u0006\u0010M\u001a\u00020>R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0016¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0016¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0019R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\"\"\u0004\b3\u0010$R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0016¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0019¨\u0006N"}, d2 = {"Lcom/talabat/wallet/checkoutpaymentmanager/presentation/viewmodel/CheckoutPaymentUpdateViewModel;", "Landroidx/lifecycle/ViewModel;", "getPaymentMethodUpdate", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/GetPaymentMethodUpdate;", "getWalletBalanceUseCase", "Lcom/talabat/wallet/walletbalance/domain/business/usecase/WalletBalanceUseCase;", "getWalletBalanceApiEnabledUseCase", "Lcom/talabat/wallet/checkoutpaymentmanager/domain/application/usecase/GetWalletBalanceApiEnabledUseCase;", "getBNPLEligiblePlanUseCase", "Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligiblePlanUseCase;", "setTipRiderStatusUseCase", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/wallet/checkoutpaymentmanager/domain/business/usecase/GetPaymentMethodUpdate;Lcom/talabat/wallet/walletbalance/domain/business/usecase/WalletBalanceUseCase;Lcom/talabat/wallet/checkoutpaymentmanager/domain/application/usecase/GetWalletBalanceApiEnabledUseCase;Lcom/talabat/wallet/bnplmanager/domain/business/usecase/GetBNPLEligiblePlanUseCase;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "bNPLEligiblePlanDetail", "Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligiblePlanDetail;", "getBNPLEligiblePlanDetail", "()Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligiblePlanDetail;", "setBNPLEligiblePlanDetail", "(Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLEligiblePlanDetail;)V", "bNPLPlanEligibilityDisplayModel", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPlanEligibilityState;", "getBNPLPlanEligibilityDisplayModel", "()Landroidx/lifecycle/MutableLiveData;", "bNPLPopViewDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/BNPLPopUpViewState;", "getBNPLPopViewDisplayModel", "setBNPLPopViewDisplayModel", "(Landroidx/lifecycle/MutableLiveData;)V", "benefitBinDeflectionExpiryDate", "", "getBenefitBinDeflectionExpiryDate", "()Ljava/lang/String;", "setBenefitBinDeflectionExpiryDate", "(Ljava/lang/String;)V", "checkoutPaymentUpdateDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/CheckoutPaymentUpdateDisplayModel;", "getCheckoutPaymentUpdateDisplayModel", "checkoutQPayRedirectDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/QPayRedirectUrlDisplayModel;", "getCheckoutQPayRedirectDisplayModel", "placeOrderResponse", "LJsonModels/PlaceOrderResponse;", "getPlaceOrderResponse", "()LJsonModels/PlaceOrderResponse;", "setPlaceOrderResponse", "(LJsonModels/PlaceOrderResponse;)V", "qPayBinDeflectionExpiryDate", "getQPayBinDeflectionExpiryDate", "setQPayBinDeflectionExpiryDate", "selectedPaymentMethod", "", "getSelectedPaymentMethod", "()I", "setSelectedPaymentMethod", "(I)V", "walletBalanceDisplayModel", "Lcom/talabat/wallet/checkoutpaymentmanager/presentation/displaymodel/WalletBalanceDisplayModel;", "getWalletBalanceDisplayModel", "onBNPLWidgetClicked", "", "isChangeCardClicked", "", "isPaymentFallbackFlow", "onPaymentMethodUpdated", "cart", "Lbuisnessmodels/Cart;", "defaultPaymentMethod", "cardList", "", "Lbuisnessmodels/tokenisation/TokenisationCreditCard;", "bNPLEligibilityRequestDto", "Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLEligibilityRequestDto;", "onRiderTipGiven", "encryptedOrderId", "onWalletBalanceLoaded", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CheckoutPaymentUpdateViewModel extends ViewModel {
    @NotNull
    private BNPLEligiblePlanDetail bNPLEligiblePlanDetail;
    @NotNull
    private final MutableLiveData<BNPLPlanEligibilityState> bNPLPlanEligibilityDisplayModel = new MutableLiveData<>();
    @NotNull
    private MutableLiveData<BNPLPopUpViewState> bNPLPopViewDisplayModel = new MutableLiveData<>();
    @NotNull
    private String benefitBinDeflectionExpiryDate;
    @NotNull
    private final MutableLiveData<CheckoutPaymentUpdateDisplayModel> checkoutPaymentUpdateDisplayModel = new MutableLiveData<>();
    @NotNull
    private final MutableLiveData<QPayRedirectUrlDisplayModel> checkoutQPayRedirectDisplayModel = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final GetBNPLEligiblePlanUseCase getBNPLEligiblePlanUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final GetPaymentMethodUpdate getPaymentMethodUpdate;
    /* access modifiers changed from: private */
    @NotNull
    public final GetWalletBalanceApiEnabledUseCase getWalletBalanceApiEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final WalletBalanceUseCase getWalletBalanceUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private PlaceOrderResponse placeOrderResponse = new PlaceOrderResponse();
    @NotNull
    private String qPayBinDeflectionExpiryDate;
    private int selectedPaymentMethod;
    @NotNull
    private final SetTipRiderStatusUseCase setTipRiderStatusUseCase;
    @NotNull
    private final MutableLiveData<WalletBalanceDisplayModel> walletBalanceDisplayModel = new MutableLiveData<>();

    public CheckoutPaymentUpdateViewModel(@NotNull GetPaymentMethodUpdate getPaymentMethodUpdate2, @NotNull WalletBalanceUseCase walletBalanceUseCase, @NotNull GetWalletBalanceApiEnabledUseCase getWalletBalanceApiEnabledUseCase2, @NotNull GetBNPLEligiblePlanUseCase getBNPLEligiblePlanUseCase2, @NotNull SetTipRiderStatusUseCase setTipRiderStatusUseCase2, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(getPaymentMethodUpdate2, "getPaymentMethodUpdate");
        Intrinsics.checkNotNullParameter(walletBalanceUseCase, "getWalletBalanceUseCase");
        Intrinsics.checkNotNullParameter(getWalletBalanceApiEnabledUseCase2, "getWalletBalanceApiEnabledUseCase");
        Intrinsics.checkNotNullParameter(getBNPLEligiblePlanUseCase2, "getBNPLEligiblePlanUseCase");
        Intrinsics.checkNotNullParameter(setTipRiderStatusUseCase2, "setTipRiderStatusUseCase");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.getPaymentMethodUpdate = getPaymentMethodUpdate2;
        this.getWalletBalanceUseCase = walletBalanceUseCase;
        this.getWalletBalanceApiEnabledUseCase = getWalletBalanceApiEnabledUseCase2;
        this.getBNPLEligiblePlanUseCase = getBNPLEligiblePlanUseCase2;
        this.setTipRiderStatusUseCase = setTipRiderStatusUseCase2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.benefitBinDeflectionExpiryDate = StringUtils.empty(stringCompanionObject);
        this.qPayBinDeflectionExpiryDate = StringUtils.empty(stringCompanionObject);
        this.bNPLEligiblePlanDetail = new BNPLEligiblePlanDetail();
    }

    public static /* synthetic */ void onBNPLWidgetClicked$default(CheckoutPaymentUpdateViewModel checkoutPaymentUpdateViewModel, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        if ((i11 & 2) != 0) {
            z12 = false;
        }
        checkoutPaymentUpdateViewModel.onBNPLWidgetClicked(z11, z12);
    }

    @NotNull
    public final BNPLEligiblePlanDetail getBNPLEligiblePlanDetail() {
        return this.bNPLEligiblePlanDetail;
    }

    @NotNull
    public final MutableLiveData<BNPLPlanEligibilityState> getBNPLPlanEligibilityDisplayModel() {
        return this.bNPLPlanEligibilityDisplayModel;
    }

    @NotNull
    public final MutableLiveData<BNPLPopUpViewState> getBNPLPopViewDisplayModel() {
        return this.bNPLPopViewDisplayModel;
    }

    @NotNull
    public final String getBenefitBinDeflectionExpiryDate() {
        return this.benefitBinDeflectionExpiryDate;
    }

    @NotNull
    public final MutableLiveData<CheckoutPaymentUpdateDisplayModel> getCheckoutPaymentUpdateDisplayModel() {
        return this.checkoutPaymentUpdateDisplayModel;
    }

    @NotNull
    public final MutableLiveData<QPayRedirectUrlDisplayModel> getCheckoutQPayRedirectDisplayModel() {
        return this.checkoutQPayRedirectDisplayModel;
    }

    @NotNull
    public final PlaceOrderResponse getPlaceOrderResponse() {
        return this.placeOrderResponse;
    }

    @NotNull
    public final String getQPayBinDeflectionExpiryDate() {
        return this.qPayBinDeflectionExpiryDate;
    }

    public final int getSelectedPaymentMethod() {
        return this.selectedPaymentMethod;
    }

    @NotNull
    public final MutableLiveData<WalletBalanceDisplayModel> getWalletBalanceDisplayModel() {
        return this.walletBalanceDisplayModel;
    }

    public final void onBNPLWidgetClicked(boolean z11, boolean z12) {
        this.bNPLPopViewDisplayModel.postValue(CheckoutPaymentUpdateMapper.INSTANCE.mapToBNPLPopViewDisplayModel(this.bNPLEligiblePlanDetail, z11, z12));
    }

    public final void onPaymentMethodUpdated(@Nullable Cart cart, @NotNull String str, @Nullable List<? extends TokenisationCreditCard> list, @NotNull BNPLEligibilityRequestDto bNPLEligibilityRequestDto) {
        Intrinsics.checkNotNullParameter(str, "defaultPaymentMethod");
        Intrinsics.checkNotNullParameter(bNPLEligibilityRequestDto, "bNPLEligibilityRequestDto");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1(this, bNPLEligibilityRequestDto, cart, str, list, (Continuation<? super CheckoutPaymentUpdateViewModel$onPaymentMethodUpdated$1>) null), 3, (Object) null);
    }

    public final void onRiderTipGiven(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        this.setTipRiderStatusUseCase.invoke(str);
    }

    public final void onWalletBalanceLoaded() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1(this, (Continuation<? super CheckoutPaymentUpdateViewModel$onWalletBalanceLoaded$1>) null), 3, (Object) null);
    }

    public final void setBNPLEligiblePlanDetail(@NotNull BNPLEligiblePlanDetail bNPLEligiblePlanDetail2) {
        Intrinsics.checkNotNullParameter(bNPLEligiblePlanDetail2, "<set-?>");
        this.bNPLEligiblePlanDetail = bNPLEligiblePlanDetail2;
    }

    public final void setBNPLPopViewDisplayModel(@NotNull MutableLiveData<BNPLPopUpViewState> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.bNPLPopViewDisplayModel = mutableLiveData;
    }

    public final void setBenefitBinDeflectionExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.benefitBinDeflectionExpiryDate = str;
    }

    public final void setPlaceOrderResponse(@NotNull PlaceOrderResponse placeOrderResponse2) {
        Intrinsics.checkNotNullParameter(placeOrderResponse2, "<set-?>");
        this.placeOrderResponse = placeOrderResponse2;
    }

    public final void setQPayBinDeflectionExpiryDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.qPayBinDeflectionExpiryDate = str;
    }

    public final void setSelectedPaymentMethod(int i11) {
        this.selectedPaymentMethod = i11;
    }
}
