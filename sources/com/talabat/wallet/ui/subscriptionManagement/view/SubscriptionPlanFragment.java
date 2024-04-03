package com.talabat.wallet.ui.subscriptionManagement.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.usecase.GetSavingsInfoUseCase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionItemDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionPlanDisplayModel;
import com.talabat.talabatcommon.views.wallet.subscription.model.SubscriptionVertical;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapper;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModel;
import com.talabat.talabatcommon.views.wallet.subscription.viewModel.SubscriptionManagementViewModelBuilder;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.wallet.R;
import com.talabat.wallet.ui.subscriptionManagement.view.SubscriptionManagementAdapter;
import com.talabat.wallet.ui.subscriptionManagement.view.di.DaggerSubscriptionComponent;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import py.f;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u000e\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020*H\u0016J\b\u0010+\u001a\u00020&H\u0002J\b\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u00020&2\u0006\u0010/\u001a\u000200H\u0016J\b\u00102\u001a\u00020&H\u0002J\b\u00103\u001a\u00020&H\u0016J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u000206H\u0016J\u001a\u00107\u001a\u00020&2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010<\u001a\u00020&2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\b\u0010?\u001a\u00020&H\u0002J\b\u0010@\u001a\u00020\u0002H\u0016R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006A"}, d2 = {"Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionPlanFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcommon/views/wallet/subscription/viewModel/SubscriptionManagementViewModel;", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter$SubscriptionManagementAdapterInterface;", "()V", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "featureFlagRepo", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepo", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepo", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "getSavingsInfoUseCase", "Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "getGetSavingsInfoUseCase", "()Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;", "setGetSavingsInfoUseCase", "(Lcom/talabat/feature/subscriptions/domain/usecase/GetSavingsInfoUseCase;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "subscriptionManagementAdapter", "Lcom/talabat/wallet/ui/subscriptionManagement/view/SubscriptionManagementAdapter;", "subscriptionsFeatureFlag", "Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "getSubscriptionsFeatureFlag", "()Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;", "setSubscriptionsFeatureFlag", "(Lcom/talabat/feature/subscriptions/domain/ISubscriptionsFeatureFlagsRepository;)V", "failureHere", "", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "getViewModelClass", "Ljava/lang/Class;", "initializeRecyclerView", "layoutId", "", "navigateToPlanOnBoarding", "subscriptionItemDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionItemDisplayModel;", "navigateToSubscriptionDetail", "navigateToTDineOnBoardingScreen", "observatory", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateAdapterWithPlans", "subscriptionPlanDisplayModel", "Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionPlanDisplayModel;", "setBackButtonListener", "viewModelBuilder", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionPlanFragment extends BaseFragment implements SubscriptionManagementAdapter.SubscriptionManagementAdapterInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public ITalabatFeatureFlag featureFlagRepo;
    @Inject
    public GetSavingsInfoUseCase getSavingsInfoUseCase;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    private SubscriptionManagementAdapter subscriptionManagementAdapter;
    @Inject
    public ISubscriptionsFeatureFlagsRepository subscriptionsFeatureFlag;

    private final void initializeRecyclerView() {
        Context context = getContext();
        if (context != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            this.subscriptionManagementAdapter = new SubscriptionManagementAdapter(context, this, getConfigurationLocalRepository(), getLocationConfigurationRepository());
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.subscription_plan_list);
            recyclerView.setLayoutManager(linearLayoutManager);
            SubscriptionManagementAdapter subscriptionManagementAdapter2 = this.subscriptionManagementAdapter;
            if (subscriptionManagementAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionManagementAdapter");
                subscriptionManagementAdapter2 = null;
            }
            recyclerView.setAdapter(subscriptionManagementAdapter2);
        }
    }

    private final void navigateToTDineOnBoardingScreen() {
        Context context = getContext();
        if (context != null) {
            Navigator.Companion.navigate(context, new NavigatorModel("talabat.action.talabat.life.on.boarding", (Bundle) null, (Function1) null, 6, (DefaultConstructorMarker) null));
        }
    }

    /* access modifiers changed from: private */
    public final void populateAdapterWithPlans(SubscriptionPlanDisplayModel subscriptionPlanDisplayModel) {
        hideProgress();
        if (subscriptionPlanDisplayModel != null) {
            SubscriptionManagementAdapter subscriptionManagementAdapter2 = this.subscriptionManagementAdapter;
            if (subscriptionManagementAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("subscriptionManagementAdapter");
                subscriptionManagementAdapter2 = null;
            }
            subscriptionManagementAdapter2.addItems(subscriptionPlanDisplayModel.getSubscriptionPlans());
        }
    }

    private final void setBackButtonListener() {
        ((ImageButton) _$_findCachedViewById(R.id.back_button)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setBackButtonListener$lambda-3  reason: not valid java name */
    public static final void m6023setBackButtonListener$lambda3(SubscriptionPlanFragment subscriptionPlanFragment, View view) {
        Intrinsics.checkNotNullParameter(subscriptionPlanFragment, "this$0");
        FragmentActivity activity = subscriptionPlanFragment.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        View findViewById;
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i11)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void failureHere(@Nullable Failure failure) {
        hideProgress();
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(com.talabat.localization.R.string.something_went_wrong);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…ing.something_went_wrong)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, (String) null, (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 58, (Object) null);
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        ConfigurationLocalRepository configurationLocalRepository2 = this.configurationLocalRepository;
        if (configurationLocalRepository2 != null) {
            return configurationLocalRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("configurationLocalRepository");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepo() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepo;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepo");
        return null;
    }

    @NotNull
    public final GetSavingsInfoUseCase getGetSavingsInfoUseCase() {
        GetSavingsInfoUseCase getSavingsInfoUseCase2 = this.getSavingsInfoUseCase;
        if (getSavingsInfoUseCase2 != null) {
            return getSavingsInfoUseCase2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("getSavingsInfoUseCase");
        return null;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigurationRepository() {
        LocationConfigurationRepository locationConfigurationRepository2 = this.locationConfigurationRepository;
        if (locationConfigurationRepository2 != null) {
            return locationConfigurationRepository2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("locationConfigurationRepository");
        return null;
    }

    @NotNull
    public final ISubscriptionsFeatureFlagsRepository getSubscriptionsFeatureFlag() {
        ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository = this.subscriptionsFeatureFlag;
        if (iSubscriptionsFeatureFlagsRepository != null) {
            return iSubscriptionsFeatureFlagsRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("subscriptionsFeatureFlag");
        return null;
    }

    @NotNull
    public Class<SubscriptionManagementViewModel> getViewModelClass() {
        return SubscriptionManagementViewModel.class;
    }

    public int layoutId() {
        return R.layout.fragment_wallet_subscription_plan;
    }

    public void navigateToPlanOnBoarding(@NotNull SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionItemDisplayModel, "subscriptionItemDisplayModel");
        if (Intrinsics.areEqual((Object) SubscriptionVertical.T_DINE.getValue(), (Object) subscriptionItemDisplayModel.getSubscriptionPlanItem().getOnBoardingLink())) {
            navigateToTDineOnBoardingScreen();
        }
    }

    public void navigateToSubscriptionDetail(@NotNull SubscriptionItemDisplayModel subscriptionItemDisplayModel) {
        Intrinsics.checkNotNullParameter(subscriptionItemDisplayModel, "subscriptionItemDisplayModel");
    }

    public void observatory() {
        LifecycleKt.observe(this, ((SubscriptionManagementViewModel) getViewModel()).getUnSubscribedPlansData(), new SubscriptionPlanFragment$observatory$1(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerSubscriptionComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (SubscriptionsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(SubscriptionsFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        initializeRecyclerView();
        showProgress();
        WalletSubscriptionMapper.Companion companion = WalletSubscriptionMapper.Companion;
        ((SubscriptionManagementViewModel) getViewModel()).getSubscriptionPlans(companion.mapCountryToISOValue(TalabatUtils.getSelectedCountry(getConfigurationLocalRepository(), getLocationConfigurationRepository()).f13845id));
        ((SubscriptionManagementViewModel) getViewModel()).getSubscriptions(companion.mapCountryToISOValue(TalabatUtils.getSelectedCountry(getConfigurationLocalRepository(), getLocationConfigurationRepository()).f13845id), true);
        setBackButtonListener();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setFeatureFlagRepo(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepo = iTalabatFeatureFlag;
    }

    public final void setGetSavingsInfoUseCase(@NotNull GetSavingsInfoUseCase getSavingsInfoUseCase2) {
        Intrinsics.checkNotNullParameter(getSavingsInfoUseCase2, "<set-?>");
        this.getSavingsInfoUseCase = getSavingsInfoUseCase2;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setSubscriptionsFeatureFlag(@NotNull ISubscriptionsFeatureFlagsRepository iSubscriptionsFeatureFlagsRepository) {
        Intrinsics.checkNotNullParameter(iSubscriptionsFeatureFlagsRepository, "<set-?>");
        this.subscriptionsFeatureFlag = iSubscriptionsFeatureFlagsRepository;
    }

    @NotNull
    public SubscriptionManagementViewModel viewModelBuilder() {
        SubscriptionManagementViewModelBuilder.Companion companion = SubscriptionManagementViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getSubscriptionManagementViewModel(requireContext, getCoroutineScope(), getFeatureFlagRepo(), getGetSavingsInfoUseCase(), getSubscriptionsFeatureFlag());
    }
}
