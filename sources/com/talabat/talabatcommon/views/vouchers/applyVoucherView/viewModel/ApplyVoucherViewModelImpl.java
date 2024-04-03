package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import androidx.lifecycle.ViewModelKt;
import buisnessmodels.Cart;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt;
import com.talabat.helpers.GlobalConstants;
import com.talabat.talabatcommon.feature.vouchers.loyalty.data.RedeemTrackData;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.AddVoucherCodeUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ApplyVoucherUseCaseOutput;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetMyPossibleVouchersUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.GetPossibleBinRestrictedVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsBasketVouchersFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsTmartVouchersFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.IsVoucherCodesFeatureEnabledUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.RedeemVoucherUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.UnApplyAllVoucherUseCase;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.LoyaltyBurnOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.RedeemSourceType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersActions;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.ApplyVouchersViewStates;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CartMenuItem;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Q2\u00020\u0001:\u0001QB{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJP\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00162\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020 2\u0006\u00102\u001a\u000203H\u0016J,\u00104\u001a\u00020 2\b\b\u0002\u00105\u001a\u00020\u00162\u0006\u00106\u001a\u00020$2\b\b\u0002\u0010(\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u0016H\u0002J \u00107\u001a\u00020 2\u0006\u00108\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010-\u001a\u00020\u0016H\u0002JX\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020'2\u0006\u0010;\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020$2\u0006\u0010,\u001a\u00020$2\u0006\u00105\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00162\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\u0006\u0010-\u001a\u00020\u0016H\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0002J0\u0010?\u001a\u00020 2\u0006\u0010/\u001a\u0002002\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J(\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020=2\u0006\u0010I\u001a\u00020'2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0002J\u0010\u0010J\u001a\u00020 2\u0006\u0010K\u001a\u00020LH\u0002J\u001e\u0010M\u001a\b\u0012\u0004\u0012\u0002HO0N\"\u0004\b\u0000\u0010O*\b\u0012\u0004\u0012\u0002HO0NH\u0002J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0N\"\u0004\b\u0000\u0010O*\b\u0012\u0004\u0012\u0002HO0NH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModelImpl;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModel;", "getMyPossibleVouchers", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetMyPossibleVouchersUseCase;", "applyVoucherUseCaseOutput", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ApplyVoucherUseCaseOutput;", "unApplyAllVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/UnApplyAllVoucherUseCase;", "redeemBurnItem", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherUseCase;", "isBasketVouchersFeatureEnabledUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsBasketVouchersFeatureEnabledUseCase;", "isTmartVouchersFeatureEnabledUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsTmartVouchersFeatureEnabledUseCase;", "isVoucherCodesFeatureEnabledUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsVoucherCodesFeatureEnabledUseCase;", "addVoucherCodeUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/AddVoucherCodeUseCase;", "getPossibleBinRestrictedVoucherUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetPossibleBinRestrictedVoucherUseCase;", "selectedCountryCode", "Lkotlin/Function0;", "", "selectedAreaId", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetMyPossibleVouchersUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ApplyVoucherUseCaseOutput;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/UnApplyAllVoucherUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/RedeemVoucherUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsBasketVouchersFeatureEnabledUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsTmartVouchersFeatureEnabledUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/IsVoucherCodesFeatureEnabledUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/AddVoucherCodeUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/GetPossibleBinRestrictedVoucherUseCase;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "currentAppliedVoucher", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherData;", "applyVoucherAction", "", "voucherDisplayModel", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherDisplayModel;", "branchId", "", "brandId", "cartSubtotal", "", "areaId", "cartItems", "", "Ldatamodels/CartMenuItem;", "groceryVendorId", "verticalId", "checkApplyVoucherFeaturesEnabled", "applyVoucherOwner", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/ApplyVoucherOwner;", "dispatchAction", "applyVouchersActions", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersActions;", "getAllMyPossibleVouchers", "countryCode", "restaurantId", "getPossibleBinRestrictedVoucher", "customerVoucherId", "handleAddVoucherCodeAction", "orderTotalAmount", "voucherCode", "isBinRestrictionForAppliedVoucherEnabled", "", "isDarkStore", "redeemBurnAction", "voucherModel", "burnOptionType", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/LoyaltyBurnOptionType;", "source", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/RedeemSourceType;", "redeemTrackData", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/data/RedeemTrackData;", "unApplyAllVouchersAction", "shouldUpdateApplyVoucherOwner", "cartSubTotal", "updateViewState", "applyVouchersViewStates", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVouchersViewStates;", "onFlowActionCompleted", "Lkotlinx/coroutines/flow/Flow;", "T", "onFlowActionStarted", "Companion", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ApplyVoucherViewModelImpl extends ApplyVoucherViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EMPTY_POINTS = "";
    /* access modifiers changed from: private */
    @NotNull
    public final AddVoucherCodeUseCase addVoucherCodeUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final ApplyVoucherUseCaseOutput applyVoucherUseCaseOutput;
    /* access modifiers changed from: private */
    @Nullable
    public VoucherData currentAppliedVoucher;
    @NotNull
    private final ITalabatFeatureFlag featureFlagRepo;
    /* access modifiers changed from: private */
    @NotNull
    public final GetMyPossibleVouchersUseCase getMyPossibleVouchers;
    /* access modifiers changed from: private */
    @NotNull
    public final GetPossibleBinRestrictedVoucherUseCase getPossibleBinRestrictedVoucherUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatcher ioDispatcher;
    /* access modifiers changed from: private */
    @NotNull
    public final IsBasketVouchersFeatureEnabledUseCase isBasketVouchersFeatureEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final IsTmartVouchersFeatureEnabledUseCase isTmartVouchersFeatureEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final IsVoucherCodesFeatureEnabledUseCase isVoucherCodesFeatureEnabledUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final RedeemVoucherUseCase redeemBurnItem;
    /* access modifiers changed from: private */
    @NotNull
    public final Function0<Integer> selectedAreaId;
    @NotNull
    private final Function0<Integer> selectedCountryCode;
    /* access modifiers changed from: private */
    @NotNull
    public final UnApplyAllVoucherUseCase unApplyAllVoucherUseCase;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/ApplyVoucherViewModelImpl$Companion;", "", "()V", "EMPTY_POINTS", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApplyVoucherViewModelImpl(GetMyPossibleVouchersUseCase getMyPossibleVouchersUseCase, ApplyVoucherUseCaseOutput applyVoucherUseCaseOutput2, UnApplyAllVoucherUseCase unApplyAllVoucherUseCase2, RedeemVoucherUseCase redeemVoucherUseCase, IsBasketVouchersFeatureEnabledUseCase isBasketVouchersFeatureEnabledUseCase2, IsTmartVouchersFeatureEnabledUseCase isTmartVouchersFeatureEnabledUseCase2, IsVoucherCodesFeatureEnabledUseCase isVoucherCodesFeatureEnabledUseCase2, AddVoucherCodeUseCase addVoucherCodeUseCase2, GetPossibleBinRestrictedVoucherUseCase getPossibleBinRestrictedVoucherUseCase2, Function0 function0, Function0 function02, CoroutineDispatcher coroutineDispatcher, ITalabatFeatureFlag iTalabatFeatureFlag, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(getMyPossibleVouchersUseCase, applyVoucherUseCaseOutput2, unApplyAllVoucherUseCase2, redeemVoucherUseCase, isBasketVouchersFeatureEnabledUseCase2, isTmartVouchersFeatureEnabledUseCase2, isVoucherCodesFeatureEnabledUseCase2, addVoucherCodeUseCase2, getPossibleBinRestrictedVoucherUseCase2, function0, function02, (i11 & 2048) != 0 ? Dispatchers.getIO() : coroutineDispatcher, iTalabatFeatureFlag);
    }

    public static /* synthetic */ void a(ApplyVoucherViewModelImpl applyVoucherViewModelImpl, int i11, String str, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i11 = IntegrationGlobalDataModel.Companion.selectedCountryCode();
        }
        if ((i14 & 4) != 0) {
            i12 = applyVoucherViewModelImpl.selectedAreaId.invoke().intValue();
        }
        applyVoucherViewModelImpl.getAllMyPossibleVouchers(i11, str, i12, i13);
    }

    private final void applyVoucherAction(VoucherDisplayModel voucherDisplayModel, String str, String str2, float f11, int i11, List<? extends CartMenuItem> list, String str3, int i12) {
        updateViewState(ApplyVouchersViewStates.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ApplyVoucherViewModelImpl$applyVoucherAction$1(this, voucherDisplayModel, f11, str2, str, str3, i11, list, i12, (Continuation<? super ApplyVoucherViewModelImpl$applyVoucherAction$1>) null), 3, (Object) null);
    }

    private final void checkApplyVoucherFeaturesEnabled(ApplyVoucherOwner applyVoucherOwner) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1(this, applyVoucherOwner, (Continuation<? super ApplyVoucherViewModelImpl$checkApplyVoucherFeaturesEnabled$1>) null), 3, (Object) null);
    }

    private final void getAllMyPossibleVouchers(int i11, String str, int i12, int i13) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1(this, i11, str, i12, i13, (Continuation<? super ApplyVoucherViewModelImpl$getAllMyPossibleVouchers$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void getPossibleBinRestrictedVoucher(String str, String str2, int i11) {
        updateViewState(ApplyVouchersViewStates.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1(this, str, str2, i11, (Continuation<? super ApplyVoucherViewModelImpl$getPossibleBinRestrictedVoucher$1>) null), 3, (Object) null);
    }

    private final void handleAddVoucherCodeAction(float f11, String str, String str2, String str3, String str4, int i11, int i12, List<? extends CartMenuItem> list, int i13) {
        updateViewState(ApplyVouchersViewStates.Loading.INSTANCE);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1(this, f11, str, str2, i11, i12, str3, str4, list, i13, (Continuation<? super ApplyVoucherViewModelImpl$handleAddVoucherCodeAction$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final boolean isBinRestrictionForAppliedVoucherEnabled() {
        return this.featureFlagRepo.getFeatureFlag(GrowthFeatureFlagConstantKt.FunWithFlagsEnableBinRestrictionForAppliedVoucher, false);
    }

    /* access modifiers changed from: private */
    public final boolean isDarkStore() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return false;
        }
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final <T> Flow<T> onFlowActionCompleted(Flow<? extends T> flow) {
        return FlowKt.onCompletion(flow, new ApplyVoucherViewModelImpl$onFlowActionCompleted$1(this, (Continuation<? super ApplyVoucherViewModelImpl$onFlowActionCompleted$1>) null));
    }

    /* access modifiers changed from: private */
    public final <T> Flow<T> onFlowActionStarted(Flow<? extends T> flow) {
        return FlowKt.onStart(flow, new ApplyVoucherViewModelImpl$onFlowActionStarted$1(this, (Continuation<? super ApplyVoucherViewModelImpl$onFlowActionStarted$1>) null));
    }

    private final void redeemBurnAction(ApplyVoucherOwner applyVoucherOwner, VoucherDisplayModel voucherDisplayModel, LoyaltyBurnOptionType loyaltyBurnOptionType, RedeemSourceType redeemSourceType, RedeemTrackData redeemTrackData) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ApplyVoucherViewModelImpl$redeemBurnAction$1(redeemSourceType, this, voucherDisplayModel, loyaltyBurnOptionType, redeemTrackData, applyVoucherOwner, (Continuation<? super ApplyVoucherViewModelImpl$redeemBurnAction$1>) null), 3, (Object) null);
    }

    private final void unApplyAllVouchersAction(boolean z11, float f11, List<? extends CartMenuItem> list) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1(this, z11, f11, list, (Continuation<? super ApplyVoucherViewModelImpl$unApplyAllVouchersAction$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void updateViewState(ApplyVouchersViewStates applyVouchersViewStates) {
        getViewStateLiveData().setValue(applyVouchersViewStates);
    }

    public void dispatchAction(@NotNull ApplyVouchersActions applyVouchersActions) {
        Intrinsics.checkNotNullParameter(applyVouchersActions, "applyVouchersActions");
        String simpleName = applyVouchersActions.getClass().getSimpleName();
        LogManager.debug("ApplyVoucherView >> ApplyVouchersActions >> " + simpleName);
        if (applyVouchersActions instanceof ApplyVouchersActions.CheckApplyVouchersFeaturesEnabled) {
            checkApplyVoucherFeaturesEnabled(((ApplyVouchersActions.CheckApplyVouchersFeaturesEnabled) applyVouchersActions).getApplyVoucherOwner());
        } else if (applyVouchersActions instanceof ApplyVouchersActions.LoadPossibleVouchersAction) {
            ApplyVouchersActions.LoadPossibleVouchersAction loadPossibleVouchersAction = (ApplyVouchersActions.LoadPossibleVouchersAction) applyVouchersActions;
            a(this, 0, loadPossibleVouchersAction.getRestaurantId(), 0, loadPossibleVouchersAction.getVerticalId(), 5, (Object) null);
        } else if (applyVouchersActions instanceof ApplyVouchersActions.ApplyVoucherAction) {
            ApplyVouchersActions.ApplyVoucherAction applyVoucherAction = (ApplyVouchersActions.ApplyVoucherAction) applyVouchersActions;
            applyVoucherAction(applyVoucherAction.getMyPossibleVoucherDisplayModel(), applyVoucherAction.getBranchId(), applyVoucherAction.getBrandId(), applyVoucherAction.getCartSubTotal(), this.selectedAreaId.invoke().intValue(), applyVoucherAction.getCartItems(), applyVoucherAction.getGroceryVendorId(), applyVoucherAction.getVerticalId());
        } else if (applyVouchersActions instanceof ApplyVouchersActions.UnApplyVoucherAction) {
            ApplyVouchersActions.UnApplyVoucherAction unApplyVoucherAction = (ApplyVouchersActions.UnApplyVoucherAction) applyVouchersActions;
            unApplyAllVouchersAction(unApplyVoucherAction.getShouldUpdateApplyVoucherOwner(), unApplyVoucherAction.getCartSubTotal(), unApplyVoucherAction.getCartItems());
        } else if (applyVouchersActions instanceof ApplyVouchersActions.RedeemVoucherAction) {
            ApplyVouchersActions.RedeemVoucherAction redeemVoucherAction = (ApplyVouchersActions.RedeemVoucherAction) applyVouchersActions;
            VoucherDisplayModel voucherDisplayModel = redeemVoucherAction.getVoucherDisplayModel();
            redeemBurnAction(redeemVoucherAction.getApplyVoucherOwner(), voucherDisplayModel, LoyaltyBurnOptionType.VOUCHER, RedeemSourceType.BASKET, new RedeemTrackData(voucherDisplayModel.getVoucherData().getId(), redeemVoucherAction.getUserId()));
        } else if (applyVouchersActions instanceof ApplyVouchersActions.AddVoucherCodeAction) {
            ApplyVouchersActions.AddVoucherCodeAction addVoucherCodeAction = (ApplyVouchersActions.AddVoucherCodeAction) applyVouchersActions;
            handleAddVoucherCodeAction(addVoucherCodeAction.getOrderTotalAmount(), addVoucherCodeAction.getVoucherCode(), addVoucherCodeAction.getBrandId(), addVoucherCodeAction.getBranchId(), addVoucherCodeAction.getGroceryVendorId(), this.selectedCountryCode.invoke().intValue(), this.selectedAreaId.invoke().intValue(), addVoucherCodeAction.getCartItems(), addVoucherCodeAction.getVerticalId());
        }
    }

    public ApplyVoucherViewModelImpl(@NotNull GetMyPossibleVouchersUseCase getMyPossibleVouchersUseCase, @NotNull ApplyVoucherUseCaseOutput applyVoucherUseCaseOutput2, @NotNull UnApplyAllVoucherUseCase unApplyAllVoucherUseCase2, @NotNull RedeemVoucherUseCase redeemVoucherUseCase, @NotNull IsBasketVouchersFeatureEnabledUseCase isBasketVouchersFeatureEnabledUseCase2, @NotNull IsTmartVouchersFeatureEnabledUseCase isTmartVouchersFeatureEnabledUseCase2, @NotNull IsVoucherCodesFeatureEnabledUseCase isVoucherCodesFeatureEnabledUseCase2, @NotNull AddVoucherCodeUseCase addVoucherCodeUseCase2, @NotNull GetPossibleBinRestrictedVoucherUseCase getPossibleBinRestrictedVoucherUseCase2, @NotNull Function0<Integer> function0, @NotNull Function0<Integer> function02, @NotNull CoroutineDispatcher coroutineDispatcher, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(getMyPossibleVouchersUseCase, "getMyPossibleVouchers");
        Intrinsics.checkNotNullParameter(applyVoucherUseCaseOutput2, "applyVoucherUseCaseOutput");
        Intrinsics.checkNotNullParameter(unApplyAllVoucherUseCase2, "unApplyAllVoucherUseCase");
        Intrinsics.checkNotNullParameter(redeemVoucherUseCase, "redeemBurnItem");
        Intrinsics.checkNotNullParameter(isBasketVouchersFeatureEnabledUseCase2, "isBasketVouchersFeatureEnabledUseCase");
        Intrinsics.checkNotNullParameter(isTmartVouchersFeatureEnabledUseCase2, "isTmartVouchersFeatureEnabledUseCase");
        Intrinsics.checkNotNullParameter(isVoucherCodesFeatureEnabledUseCase2, "isVoucherCodesFeatureEnabledUseCase");
        Intrinsics.checkNotNullParameter(addVoucherCodeUseCase2, "addVoucherCodeUseCase");
        Intrinsics.checkNotNullParameter(getPossibleBinRestrictedVoucherUseCase2, "getPossibleBinRestrictedVoucherUseCase");
        Intrinsics.checkNotNullParameter(function0, "selectedCountryCode");
        Intrinsics.checkNotNullParameter(function02, GlobalConstants.ExtraNames.SELECTED_AREA_ID);
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "ioDispatcher");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "featureFlagRepo");
        this.getMyPossibleVouchers = getMyPossibleVouchersUseCase;
        this.applyVoucherUseCaseOutput = applyVoucherUseCaseOutput2;
        this.unApplyAllVoucherUseCase = unApplyAllVoucherUseCase2;
        this.redeemBurnItem = redeemVoucherUseCase;
        this.isBasketVouchersFeatureEnabledUseCase = isBasketVouchersFeatureEnabledUseCase2;
        this.isTmartVouchersFeatureEnabledUseCase = isTmartVouchersFeatureEnabledUseCase2;
        this.isVoucherCodesFeatureEnabledUseCase = isVoucherCodesFeatureEnabledUseCase2;
        this.addVoucherCodeUseCase = addVoucherCodeUseCase2;
        this.getPossibleBinRestrictedVoucherUseCase = getPossibleBinRestrictedVoucherUseCase2;
        this.selectedCountryCode = function0;
        this.selectedAreaId = function02;
        this.ioDispatcher = coroutineDispatcher;
        this.featureFlagRepo = iTalabatFeatureFlag;
    }
}
