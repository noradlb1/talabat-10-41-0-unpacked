package com.talabat.growth.ui.loyalty.dashboard.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.integration.IntegrationGlobalDataModel;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.ecosystems.EcosystemsFeatureFlagsKeys;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.features.loyalty.GetPointsSummary;
import com.talabat.growth.features.loyalty.IsUserRewardsEnabled;
import com.talabat.growth.features.loyalty.sharedpreferences.IsUserRewards;
import com.talabat.growth.features.matketPlace.FilterBurnItems;
import com.talabat.growth.features.matketPlace.GetMarketPlaceItems;
import com.talabat.growth.features.matketPlace.model.MarketPlaceItemsRequestModel;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsFragment;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnListDisplayModel;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.SingleLiveEvent;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u001cH\u0002J\b\u00104\u001a\u000202H\u0002J\u000e\u00105\u001a\u0002022\u0006\u00106\u001a\u000207J\u001f\u00108\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010;\u001a\u00020<H@ø\u0001\u0000¢\u0006\u0002\u0010=J\u0019\u0010>\u001a\u0002022\u0006\u0010?\u001a\u000207H@ø\u0001\u0000¢\u0006\u0002\u0010@J\u0010\u0010\u0002\u001a\u0002022\b\b\u0002\u0010A\u001a\u000207J\u001b\u0010B\u001a\u0002022\b\b\u0002\u0010A\u001a\u000207H@ø\u0001\u0000¢\u0006\u0002\u0010@J\u0010\u0010C\u001a\u0002022\u0006\u0010D\u001a\u00020\u0019H\u0002J\u0010\u0010E\u001a\u0002022\u0006\u0010F\u001a\u00020\u0015H\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010F\u001a\u00020\u001fH\u0002J\u0010\u0010H\u001a\u0002022\u0006\u0010I\u001a\u00020#H\u0002J\b\u0010J\u001a\u00020\u001cH\u0002J\u000e\u0010K\u001a\u0002022\u0006\u0010L\u001a\u000207J\u0016\u0010M\u001a\u0002022\u0006\u0010N\u001a\u00020:2\u0006\u0010O\u001a\u00020PJ\u0006\u0010Q\u001a\u000202J\u001e\u0010R\u001a\u0002022\u0006\u0010S\u001a\u0002072\u0006\u0010T\u001a\u00020,2\u0006\u0010U\u001a\u00020<J\u0006\u0010V\u001a\u000202J\u0006\u0010W\u001a\u000202R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\"¢\u0006\b\n\u0000\u001a\u0004\b(\u0010%R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u001f0\"¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\"¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u000e\u0010.\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006X"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModel;", "Landroidx/lifecycle/ViewModel;", "getPointsSummary", "Lcom/talabat/growth/features/loyalty/GetPointsSummary;", "getMarketPlaceItems", "Lcom/talabat/growth/features/matketPlace/GetMarketPlaceItems;", "trackRedeemOfferFeatureUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "checkIfIsUserEnabled", "Lcom/talabat/growth/features/loyalty/IsUserRewardsEnabled;", "funWithFlags", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "isUserRewardsSharedPreferences", "Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewards;", "filterItems", "Lcom/talabat/growth/features/matketPlace/FilterBurnItems;", "burnOptionDetailsNavigator", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator;", "(Lcom/talabat/growth/features/loyalty/GetPointsSummary;Lcom/talabat/growth/features/matketPlace/GetMarketPlaceItems;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;Lcom/talabat/growth/features/loyalty/IsUserRewardsEnabled;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/growth/features/loyalty/sharedpreferences/IsUserRewards;Lcom/talabat/growth/features/matketPlace/FilterBurnItems;Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator;)V", "burnOptionsData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnListDisplayModel;", "getBurnOptionsData", "()Landroidx/lifecycle/MutableLiveData;", "failureData", "Lcom/talabat/talabatcore/exception/Failure;", "getFailureData", "loadingIndicator", "", "getLoadingIndicator", "pointsData", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "getPointsData", "showBurnOptionDetailsEvent", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "getShowBurnOptionDetailsEvent", "()Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/viewModel/SingleLiveEvent;", "showFeaturedListEvent", "Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/FeaturedListData;", "getShowFeaturedListEvent", "showHistoryEvent", "getShowHistoryEvent", "showHowItWorksEvent", "", "getShowHowItWorksEvent", "totalPoints", "userEligibleForRewardsProgram", "getUserEligibleForRewardsProgram", "applyIsUserEligibleForRewardsProgram", "", "isUserEligibleForRewardsProgram", "callExperimentForAbTracking", "checkUserIsEnabled", "customerId", "", "filterBurnItems", "", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "burnItemCategoryDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "(Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBurnOptionsList", "country", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "id", "getSuspendedPointsSummary", "handleFailure", "failure", "handleLoyaltyBurnOptionsDisplayModel", "model", "handleLoyaltyPointsDisplayModel", "handleShouldShowBottomSheet", "burnOptionDetailsTarget", "isFwFLoyaltyEnabled", "loadAll", "countryId", "onBurnOptionClicked", "burnItemDisplayModel", "position", "Lcom/talabat/growth/ui/loyalty/burn/burnOptionsDetails/BurnOptionsDetailsFragment$VoucherPosition;", "onRewardsScreenLoaded", "showFeaturedList", "channelName", "channelPosition", "burnCategoryDisplayModel", "showHistory", "showHowItWorks", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardViewModel extends ViewModel {
    @NotNull
    private final BurnOptionDetailsNavigator burnOptionDetailsNavigator;
    @NotNull
    private final MutableLiveData<BurnListDisplayModel> burnOptionsData = new MutableLiveData<>();
    @NotNull
    private final IsUserRewardsEnabled checkIfIsUserEnabled;
    @NotNull
    private final MutableLiveData<Failure> failureData = new MutableLiveData<>();
    /* access modifiers changed from: private */
    @NotNull
    public final FilterBurnItems filterItems;
    @NotNull
    private final ITalabatFeatureFlag funWithFlags;
    /* access modifiers changed from: private */
    @NotNull
    public final GetMarketPlaceItems getMarketPlaceItems;
    /* access modifiers changed from: private */
    @NotNull
    public final GetPointsSummary getPointsSummary;
    @NotNull
    private final IsUserRewards isUserRewardsSharedPreferences;
    @NotNull
    private final MutableLiveData<Boolean> loadingIndicator = new MutableLiveData<>(Boolean.FALSE);
    @NotNull
    private final MutableLiveData<LoyaltyPointsDisplayModel> pointsData = new MutableLiveData<>();
    @NotNull
    private final SingleLiveEvent<BurnOptionDetailsNavigator.BurnOptionDetailsTarget> showBurnOptionDetailsEvent = new SingleLiveEvent<>();
    @NotNull
    private final SingleLiveEvent<FeaturedListData> showFeaturedListEvent = new SingleLiveEvent<>();
    @NotNull
    private final SingleLiveEvent<LoyaltyPointsDisplayModel> showHistoryEvent = new SingleLiveEvent<>();
    @NotNull
    private final SingleLiveEvent<Integer> showHowItWorksEvent = new SingleLiveEvent<>();
    private int totalPoints;
    @NotNull
    private final GrowthTracker trackRedeemOfferFeatureUseCase;
    @NotNull
    private final MutableLiveData<Boolean> userEligibleForRewardsProgram = new MutableLiveData<>();

    public LoyaltyDashboardViewModel(@NotNull GetPointsSummary getPointsSummary2, @NotNull GetMarketPlaceItems getMarketPlaceItems2, @NotNull GrowthTracker growthTracker, @NotNull IsUserRewardsEnabled isUserRewardsEnabled, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IsUserRewards isUserRewards, @NotNull FilterBurnItems filterBurnItems, @NotNull BurnOptionDetailsNavigator burnOptionDetailsNavigator2) {
        Intrinsics.checkNotNullParameter(getPointsSummary2, "getPointsSummary");
        Intrinsics.checkNotNullParameter(getMarketPlaceItems2, "getMarketPlaceItems");
        Intrinsics.checkNotNullParameter(growthTracker, "trackRedeemOfferFeatureUseCase");
        Intrinsics.checkNotNullParameter(isUserRewardsEnabled, "checkIfIsUserEnabled");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "funWithFlags");
        Intrinsics.checkNotNullParameter(isUserRewards, "isUserRewardsSharedPreferences");
        Intrinsics.checkNotNullParameter(filterBurnItems, "filterItems");
        Intrinsics.checkNotNullParameter(burnOptionDetailsNavigator2, "burnOptionDetailsNavigator");
        this.getPointsSummary = getPointsSummary2;
        this.getMarketPlaceItems = getMarketPlaceItems2;
        this.trackRedeemOfferFeatureUseCase = growthTracker;
        this.checkIfIsUserEnabled = isUserRewardsEnabled;
        this.funWithFlags = iTalabatFeatureFlag;
        this.isUserRewardsSharedPreferences = isUserRewards;
        this.filterItems = filterBurnItems;
        this.burnOptionDetailsNavigator = burnOptionDetailsNavigator2;
        callExperimentForAbTracking();
    }

    public static /* synthetic */ Object a(LoyaltyDashboardViewModel loyaltyDashboardViewModel, String str, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = IntegrationGlobalDataModel.Companion.customerID();
        }
        return loyaltyDashboardViewModel.getSuspendedPointsSummary(str, continuation);
    }

    /* access modifiers changed from: private */
    public final void applyIsUserEligibleForRewardsProgram(boolean z11) {
        this.isUserRewardsSharedPreferences.saveIsUserEligibleForRewardsProgram(z11);
        this.userEligibleForRewardsProgram.postValue(Boolean.valueOf(z11));
    }

    private final void callExperimentForAbTracking() {
        TalabatExperiment.INSTANCE.getStringVariant(TalabatExperimentConstants.NEW_REWARDS_REDEMPTION_FLOW, "", TalabatExperimentDataSourceStrategy.FWF);
    }

    /* access modifiers changed from: private */
    public final Object filterBurnItems(BurnItemCategoryDisplayModel burnItemCategoryDisplayModel, Continuation<? super List<BurnItemDisplayModel>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.filterItems.invoke(burnItemCategoryDisplayModel.getBurnItemsDisplayModel(), new LoyaltyDashboardViewModel$filterBurnItems$2$1(this, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* access modifiers changed from: private */
    public final Object getBurnOptionsList(String str, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        IntegrationGlobalDataModel.Companion companion = IntegrationGlobalDataModel.Companion;
        this.getMarketPlaceItems.invoke(new MarketPlaceItemsRequestModel(str, companion.selectedLanguage(), 1, 20, companion.selectedAreaId()), new LoyaltyDashboardViewModel$getBurnOptionsList$2$1(this, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getPointsSummary$default(LoyaltyDashboardViewModel loyaltyDashboardViewModel, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = IntegrationGlobalDataModel.Companion.customerID();
        }
        loyaltyDashboardViewModel.getPointsSummary(str);
    }

    /* access modifiers changed from: private */
    public final Object getSuspendedPointsSummary(String str, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        this.getPointsSummary.invoke(str, new LoyaltyDashboardViewModel$getSuspendedPointsSummary$2$1(this, cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        if (result == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return result;
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void handleFailure(Failure failure) {
        this.failureData.postValue(failure);
    }

    /* access modifiers changed from: private */
    public final void handleLoyaltyBurnOptionsDisplayModel(BurnListDisplayModel burnListDisplayModel) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1(burnListDisplayModel, this, (Continuation<? super LoyaltyDashboardViewModel$handleLoyaltyBurnOptionsDisplayModel$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void handleLoyaltyPointsDisplayModel(LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
        this.totalPoints = loyaltyPointsDisplayModel.getTotalPoints();
        this.pointsData.postValue(loyaltyPointsDisplayModel);
    }

    /* access modifiers changed from: private */
    public final void handleShouldShowBottomSheet(BurnOptionDetailsNavigator.BurnOptionDetailsTarget burnOptionDetailsTarget) {
        this.showBurnOptionDetailsEvent.postValue(burnOptionDetailsTarget);
    }

    /* access modifiers changed from: private */
    public final boolean isFwFLoyaltyEnabled() {
        return ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(this.funWithFlags, EcosystemsFeatureFlagsKeys.IS_REWARDS_ENABLED, false, 2, (Object) null);
    }

    public final void checkUserIsEnabled(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "customerId");
        this.userEligibleForRewardsProgram.postValue(Boolean.valueOf(this.isUserRewardsSharedPreferences.getIsUserEligibleForRewardsProgram()));
        this.checkIfIsUserEnabled.invoke(Unit.INSTANCE, new LoyaltyDashboardViewModel$checkUserIsEnabled$1(this, str));
    }

    @NotNull
    public final MutableLiveData<BurnListDisplayModel> getBurnOptionsData() {
        return this.burnOptionsData;
    }

    @NotNull
    public final MutableLiveData<Failure> getFailureData() {
        return this.failureData;
    }

    @NotNull
    public final MutableLiveData<Boolean> getLoadingIndicator() {
        return this.loadingIndicator;
    }

    @NotNull
    public final MutableLiveData<LoyaltyPointsDisplayModel> getPointsData() {
        return this.pointsData;
    }

    public final void getPointsSummary(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoyaltyDashboardViewModel$getPointsSummary$1(this, str, (Continuation<? super LoyaltyDashboardViewModel$getPointsSummary$1>) null), 3, (Object) null);
    }

    @NotNull
    public final SingleLiveEvent<BurnOptionDetailsNavigator.BurnOptionDetailsTarget> getShowBurnOptionDetailsEvent() {
        return this.showBurnOptionDetailsEvent;
    }

    @NotNull
    public final SingleLiveEvent<FeaturedListData> getShowFeaturedListEvent() {
        return this.showFeaturedListEvent;
    }

    @NotNull
    public final SingleLiveEvent<LoyaltyPointsDisplayModel> getShowHistoryEvent() {
        return this.showHistoryEvent;
    }

    @NotNull
    public final SingleLiveEvent<Integer> getShowHowItWorksEvent() {
        return this.showHowItWorksEvent;
    }

    @NotNull
    public final MutableLiveData<Boolean> getUserEligibleForRewardsProgram() {
        return this.userEligibleForRewardsProgram;
    }

    public final void loadAll(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "countryId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoyaltyDashboardViewModel$loadAll$1(this, str, (Continuation<? super LoyaltyDashboardViewModel$loadAll$1>) null), 3, (Object) null);
    }

    public final void onBurnOptionClicked(@NotNull BurnItemDisplayModel burnItemDisplayModel, @NotNull BurnOptionsDetailsFragment.VoucherPosition voucherPosition) {
        Intrinsics.checkNotNullParameter(burnItemDisplayModel, "burnItemDisplayModel");
        Intrinsics.checkNotNullParameter(voucherPosition, "position");
        this.burnOptionDetailsNavigator.invoke(new BurnOptionDetailsNavigator.BurnOptionDetails(this.totalPoints, burnItemDisplayModel, voucherPosition), new LoyaltyDashboardViewModel$onBurnOptionClicked$1(this));
    }

    public final void onRewardsScreenLoaded() {
        this.trackRedeemOfferFeatureUseCase.onRewardsScreenLoaded();
    }

    public final void showFeaturedList(@NotNull String str, int i11, @NotNull BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        Intrinsics.checkNotNullParameter(str, GrowthNavigatorActions.EXTRA_LOYALTY_FEATURED_CHANNEL_NAME);
        Intrinsics.checkNotNullParameter(burnItemCategoryDisplayModel, "burnCategoryDisplayModel");
        this.showFeaturedListEvent.postValue(new FeaturedListData(str, i11, burnItemCategoryDisplayModel, this.totalPoints));
    }

    public final void showHistory() {
        this.showHistoryEvent.postValue(this.pointsData.getValue());
    }

    public final void showHowItWorks() {
        this.showHowItWorksEvent.postValue(Integer.valueOf(this.totalPoints));
    }
}
