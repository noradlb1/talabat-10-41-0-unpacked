package com.talabat.growth.ui.vouchers.entrypoint.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import buisnessmodels.Customer;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.home.HomePageFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.common.UserAction;
import com.talabat.core.observabilityNew.domain.common.ViewStatus;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.ActiveVouchersUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.domain.VoucherCountTextUseCase;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import library.talabat.mvp.home.VoucherStateDomainModel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u001c\u0018\u0000 22\u00020\u0001:\u00012BA\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010*\u001a\u00020+J\u0006\u0010\u0016\u001a\u00020+J\u000e\u0010)\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0013J\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0015J\u000e\u0010/\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0015J\u000e\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0013R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0\u0012¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u001f\u0010#\u001a\u0010\u0012\f\u0012\n %*\u0004\u0018\u00010\u00130\u00130$8F¢\u0006\u0006\u001a\u0004\b&\u0010'R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0$¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'¨\u00063"}, d2 = {"Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel;", "Landroidx/lifecycle/ViewModel;", "activeVouchersUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ActiveVouchersUseCase;", "voucherCountTextUseCase", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/VoucherCountTextUseCase;", "configurationLocalCoreLibApi", "Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "growthTracker", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/ActiveVouchersUseCase;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/domain/VoucherCountTextUseCase;Lcom/talabat/configuration/di/ConfigurationLocalCoreLibApi;Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/talabatcommon/feature/vouchers/loyalty/tracking/GrowthTracker;)V", "_rewardsUserEligibility", "Landroidx/lifecycle/MutableLiveData;", "", "activeVouchers", "", "getActiveVouchers", "()Landroidx/lifecycle/MutableLiveData;", "activeVouchersCount", "", "getActiveVouchersCount", "coroutineScope", "com/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel$coroutineScope$1", "Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel$coroutineScope$1;", "hideActiveVouchers", "getHideActiveVouchers", "internalVouchersState", "Llibrary/talabat/mvp/home/VoucherStateDomainModel;", "getInternalVouchersState", "rewardsUserEligibility", "Landroidx/lifecycle/LiveData;", "kotlin.jvm.PlatformType", "getRewardsUserEligibility", "()Landroidx/lifecycle/LiveData;", "vouchersState", "getVouchersState", "clearVouchersState", "", "isUserLoggedIn", "trackViewClicked", "screenName", "trackViewShown", "updateRewardsUserEligibility", "isEnabled", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherEntryPointViewModel extends ViewModel {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String SCREEN_TYPE = "home";
    @NotNull
    private static final String VIEW_NAME = "VoucherEntryPoint";
    @NotNull
    private static final String VOUCHERS_NAVIGATION_OPTION = "Vouchers";
    @NotNull
    private static final String VOUCHER_COUNT = "voucherCount";
    @NotNull
    private final MutableLiveData<Boolean> _rewardsUserEligibility;
    @NotNull
    private final MutableLiveData<String> activeVouchers;
    @NotNull
    private final MutableLiveData<Integer> activeVouchersCount;
    /* access modifiers changed from: private */
    @NotNull
    public final ActiveVouchersUseCase activeVouchersUseCase;
    /* access modifiers changed from: private */
    @NotNull
    public final ConfigurationLocalCoreLibApi configurationLocalCoreLibApi;
    /* access modifiers changed from: private */
    @NotNull
    public final CoroutineDispatchersFactory coroutineDispatchersFactory;
    @NotNull
    private final VoucherEntryPointViewModel$coroutineScope$1 coroutineScope;
    @NotNull
    private final GrowthTracker growthTracker;
    @NotNull
    private final MutableLiveData<Boolean> hideActiveVouchers;
    @NotNull
    private final MutableLiveData<VoucherStateDomainModel> internalVouchersState;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;
    /* access modifiers changed from: private */
    @NotNull
    public final VoucherCountTextUseCase voucherCountTextUseCase;
    @NotNull
    private final LiveData<VoucherStateDomainModel> vouchersState;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/growth/ui/vouchers/entrypoint/viewmodel/VoucherEntryPointViewModel$Companion;", "", "()V", "SCREEN_TYPE", "", "VIEW_NAME", "VOUCHERS_NAVIGATION_OPTION", "VOUCHER_COUNT", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VoucherEntryPointViewModel(ActiveVouchersUseCase activeVouchersUseCase2, VoucherCountTextUseCase voucherCountTextUseCase2, ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, CoroutineDispatchersFactory coroutineDispatchersFactory2, ITalabatFeatureFlag iTalabatFeatureFlag, IObservabilityManager iObservabilityManager, GrowthTracker growthTracker2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(activeVouchersUseCase2, voucherCountTextUseCase2, configurationLocalCoreLibApi2, coroutineDispatchersFactory2, iTalabatFeatureFlag, iObservabilityManager, (i11 & 64) != 0 ? GrowthTracker.INSTANCE : growthTracker2);
    }

    public final void clearVouchersState() {
        this.internalVouchersState.postValue(null);
    }

    @NotNull
    public final MutableLiveData<String> getActiveVouchers() {
        return this.activeVouchers;
    }

    @NotNull
    public final MutableLiveData<Integer> getActiveVouchersCount() {
        return this.activeVouchersCount;
    }

    @NotNull
    public final MutableLiveData<Boolean> getHideActiveVouchers() {
        return this.hideActiveVouchers;
    }

    @NotNull
    public final MutableLiveData<VoucherStateDomainModel> getInternalVouchersState() {
        return this.internalVouchersState;
    }

    @NotNull
    public final LiveData<Boolean> getRewardsUserEligibility() {
        LiveData<Boolean> distinctUntilChanged = Transformations.distinctUntilChanged(this._rewardsUserEligibility);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged;
    }

    @NotNull
    public final LiveData<VoucherStateDomainModel> getVouchersState() {
        return this.vouchersState;
    }

    public final void trackViewClicked(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.growthTracker.voucherEntryPointClicked(str, "home", "Vouchers");
        this.observabilityManager.trackEvent(str, VIEW_NAME, UserAction.TAP, (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to(VOUCHER_COUNT, String.valueOf(this.activeVouchersCount.getValue()))));
    }

    public final void trackViewShown(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "screenName");
        this.growthTracker.voucherEntryPointLoaded(str, "home", "Vouchers");
        this.observabilityManager.trackEvent(str, VIEW_NAME, ViewStatus.VISIBLE, (Map<String, String>) MapsKt__MapsJVMKt.mapOf(TuplesKt.to(VOUCHER_COUNT, String.valueOf(this.activeVouchersCount.getValue()))));
    }

    public final void updateRewardsUserEligibility(boolean z11) {
        this._rewardsUserEligibility.postValue(Boolean.valueOf(z11));
    }

    /* renamed from: getActiveVouchers  reason: collision with other method in class */
    public final void m10615getActiveVouchers() {
        if (!this.talabatFeatureFlag.getFeatureFlag(HomePageFeatureFlagsKeys.VOUCHER_ENTRY_POINT, false) || !Customer.getInstance().isLoggedIn()) {
            this.hideActiveVouchers.postValue(Boolean.TRUE);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.coroutineScope.getCoroutineContext(), (CoroutineStart) null, new VoucherEntryPointViewModel$getActiveVouchers$1(this, (Continuation<? super VoucherEntryPointViewModel$getActiveVouchers$1>) null), 2, (Object) null);
        }
    }

    public final void getVouchersState(boolean z11) {
        if (this.internalVouchersState.getValue() != null) {
            MutableLiveData<VoucherStateDomainModel> mutableLiveData = this.internalVouchersState;
            mutableLiveData.postValue(mutableLiveData.getValue());
        } else if (this.configurationLocalCoreLibApi.getRepository().selectedCountry().getCountryId() == Country.KSA.getCountryId() || !z11) {
            this.internalVouchersState.postValue(null);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.coroutineScope.getCoroutineContext(), (CoroutineStart) null, new VoucherEntryPointViewModel$getVouchersState$1(this, (Continuation<? super VoucherEntryPointViewModel$getVouchersState$1>) null), 2, (Object) null);
        }
    }

    @Inject
    public VoucherEntryPointViewModel(@NotNull ActiveVouchersUseCase activeVouchersUseCase2, @NotNull VoucherCountTextUseCase voucherCountTextUseCase2, @NotNull ConfigurationLocalCoreLibApi configurationLocalCoreLibApi2, @NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2, @NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull IObservabilityManager iObservabilityManager, @NotNull GrowthTracker growthTracker2) {
        Intrinsics.checkNotNullParameter(activeVouchersUseCase2, "activeVouchersUseCase");
        Intrinsics.checkNotNullParameter(voucherCountTextUseCase2, "voucherCountTextUseCase");
        Intrinsics.checkNotNullParameter(configurationLocalCoreLibApi2, "configurationLocalCoreLibApi");
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "coroutineDispatchersFactory");
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(growthTracker2, "growthTracker");
        this.activeVouchersUseCase = activeVouchersUseCase2;
        this.voucherCountTextUseCase = voucherCountTextUseCase2;
        this.configurationLocalCoreLibApi = configurationLocalCoreLibApi2;
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.observabilityManager = iObservabilityManager;
        this.growthTracker = growthTracker2;
        this.coroutineScope = new VoucherEntryPointViewModel$coroutineScope$1(this);
        this.activeVouchers = new MutableLiveData<>();
        this.activeVouchersCount = new MutableLiveData<>();
        this.hideActiveVouchers = new MutableLiveData<>(Boolean.TRUE);
        MutableLiveData<VoucherStateDomainModel> mutableLiveData = new MutableLiveData<>(null);
        this.internalVouchersState = mutableLiveData;
        LiveData<VoucherStateDomainModel> distinctUntilChanged = Transformations.distinctUntilChanged(mutableLiveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        this.vouchersState = distinctUntilChanged;
        this._rewardsUserEligibility = new MutableLiveData<>();
    }
}
