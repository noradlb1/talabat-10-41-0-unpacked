package com.talabat.growth.ui.loyalty.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_icon_button.DSIconButtonModel;
import com.designsystem.ds_navigation_bar.DSNavigationBarWithActionButton;
import com.designsystem.ds_navigation_bar.models.DSNavigationBarActionButtonModel;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.integration.IntegrationAppTracker;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.dispatcher.domain.CoroutineDispatchersFactory;
import com.talabat.core.dispatcher.domain.DispatcherCoreLibApi;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.rewards.BurnOptionsScreen;
import com.talabat.core.navigation.domain.screen.rewards.LoyaltyDashboardScreen;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.IHelpCenterDeeplinkBuilder;
import com.talabat.feature.rewards.domain.RewardsFeatureApi;
import com.talabat.feature.rewards.domain.RewardsTracker;
import com.talabat.feature.rewards.domain.model.Mission;
import com.talabat.feature.rewards.domain.model.MissionOrigin;
import com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding;
import com.talabat.growth.databinding.FragLoyaltyDashboardBinding;
import com.talabat.growth.features.loyalty.BurnOptionDetailsNavigator;
import com.talabat.growth.ui.loyalty.burn.burnOptions.BurnOptionClickListener;
import com.talabat.growth.ui.loyalty.burn.burnOptions.LoyaltyBurnOptionsAdapter;
import com.talabat.growth.ui.loyalty.burn.burnOptionsDetails.BurnOptionsDetailsActivity;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemCategoryViewType;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import com.talabat.growth.ui.loyalty.burn.models.BurnListDisplayModel;
import com.talabat.growth.ui.loyalty.dashboard.di.DaggerLoyaltyDashboardFragmentComponent;
import com.talabat.growth.ui.loyalty.dashboard.viewModel.FeaturedListData;
import com.talabat.growth.ui.loyalty.dashboard.viewModel.LoyaltyDashboardViewModel;
import com.talabat.growth.ui.loyalty.models.LoyaltyPointsDisplayModel;
import com.talabat.growth.ui.loyalty.views.HeroCategoryView;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.views.statusViews.ActionStatus;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.titleViewMoreHorizontalListView.TitleViewMoreHorizontalListView;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lr.a;
import lr.b;
import lr.c;
import lr.d;
import lr.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000ÿ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0014\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0002J\u0018\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020JH\u0002J \u0010K\u001a\u00020L2\u0006\u0010M\u001a\u0002052\u0006\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020JH\u0002J \u0010N\u001a\u00020O2\u0006\u0010M\u001a\u0002052\u0006\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020JH\u0002J\u0018\u0010P\u001a\u00020Q2\u0006\u0010M\u001a\u0002052\u0006\u0010H\u001a\u00020EH\u0002J\u0010\u0010R\u001a\u00020C2\u0006\u0010S\u001a\u00020TH\u0002J\u0012\u0010U\u001a\u00020C2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\b\u0010X\u001a\u00020CH\u0002J\u0010\u0010Y\u001a\u00020C2\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u00020C2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J$\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\b\u0010c\u001a\u0004\u0018\u00010d2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u001a\u0010e\u001a\u00020C2\u0006\u0010f\u001a\u00020`2\b\u0010]\u001a\u0004\u0018\u00010^H\u0016J\u0017\u0010g\u001a\u00020C2\b\u0010h\u001a\u0004\u0018\u00010iH\u0002¢\u0006\u0002\u0010jJ\b\u0010k\u001a\u00020CH\u0002J\b\u0010l\u001a\u00020CH\u0002J\b\u0010m\u001a\u00020CH\u0002J\b\u0010n\u001a\u00020CH\u0002J\b\u0010o\u001a\u00020CH\u0002J\b\u0010p\u001a\u00020CH\u0002J\b\u0010q\u001a\u00020CH\u0002J\b\u0010r\u001a\u00020CH\u0002J\u0010\u0010s\u001a\u00020C2\u0006\u0010S\u001a\u00020TH\u0002J\u0012\u0010t\u001a\u00020C2\b\u0010u\u001a\u0004\u0018\u00010vH\u0002J\u0012\u0010w\u001a\u00020C2\b\u0010x\u001a\u0004\u0018\u00010yH\u0002J\u0012\u0010z\u001a\u00020C2\b\u0010{\u001a\u0004\u0018\u00010|H\u0002J\u0017\u0010}\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u0002¢\u0006\u0002\u0010~J\u0011\u0010\u001a\u00020C2\u0007\u0010\u0001\u001a\u00020EH\u0002J\u0017\u0010\u0001\u001a\u00020C2\f\b\u0002\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0015\u0010\u0001\u001a\u00020C2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0002J\u0014\u0010\u0001\u001a\u00020C2\t\u0010\u0001\u001a\u0004\u0018\u00010|H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001b\u0010<\u001a\u00020=8BX\u0002¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\b>\u0010?¨\u0006\u0001"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/talabat/growth/databinding/FragLoyaltyDashboardBinding;", "bottomSheet", "Lcom/talabat/feature/rewards/presentation/DSBottomSheetFragmentWithoutPadding;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "coroutineDispatchersFactory", "Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "getCoroutineDispatchersFactory", "()Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;", "setCoroutineDispatchersFactory", "(Lcom/talabat/core/dispatcher/domain/CoroutineDispatchersFactory;)V", "coroutineScope", "com/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment$coroutineScope$1", "Lcom/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment$coroutineScope$1;", "deepLinkNavigator", "Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "getDeepLinkNavigator", "()Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;", "setDeepLinkNavigator", "(Lcom/talabat/core/deeplink/domain/DeepLinkNavigator;)V", "featureFlagRepository", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlagRepository", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlagRepository", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "helpDeeplinkBuilder", "Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "getHelpDeeplinkBuilder", "()Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;", "setHelpDeeplinkBuilder", "(Lcom/talabat/feature/cancellationpolicy/domain/IHelpCenterDeeplinkBuilder;)V", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "getLocationConfigurationRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "setLocationConfigurationRepository", "(Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "navigator", "Lcom/talabat/core/navigation/domain/Navigator;", "getNavigator", "()Lcom/talabat/core/navigation/domain/Navigator;", "setNavigator", "(Lcom/talabat/core/navigation/domain/Navigator;)V", "rewardsCatalogueOrigin", "", "rewardsTracker", "Lcom/talabat/feature/rewards/domain/RewardsTracker;", "getRewardsTracker", "()Lcom/talabat/feature/rewards/domain/RewardsTracker;", "setRewardsTracker", "(Lcom/talabat/feature/rewards/domain/RewardsTracker;)V", "viewModel", "Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModel;", "getViewModel", "()Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/LoyaltyDashboardViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "fireAppTrackingEvents", "", "totalPoints", "", "getCategoryView", "Landroid/widget/LinearLayout;", "channelPosition", "burnCategoryDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemCategoryDisplayModel;", "getHeroCard", "Lcom/talabat/growth/ui/loyalty/views/HeroCategoryView;", "channelName", "getHorizontalListView", "Lcom/talabat/talabatcommon/views/titleViewMoreHorizontalListView/TitleViewMoreHorizontalListView;", "getOnBurnOptionClickListener", "Lcom/talabat/growth/ui/loyalty/burn/burnOptions/BurnOptionClickListener;", "navigateToActivity", "burnOptionDetails", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetails;", "navigateToFeaturedList", "featuredListData", "Lcom/talabat/growth/ui/loyalty/dashboard/viewModel/FeaturedListData;", "navigateToHelpCenter", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setLoadingStatus", "isRefreshing", "", "(Ljava/lang/Boolean;)V", "setupHistoryButton", "setupLoyaltyPointsSummary", "setupMissionWidget", "setupNavigationBar", "setupObservers", "setupRewardsCatalogueOrigin", "setupSwipeRefresh", "setupUI", "showBottomSheet", "showBurnOptionDetails", "burnOptionDetailsTarget", "Lcom/talabat/growth/features/loyalty/BurnOptionDetailsNavigator$BurnOptionDetailsTarget;", "showFailure", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "showHistory", "pointsData", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyPointsDisplayModel;", "showHowItWorks", "(Ljava/lang/Integer;)V", "showNotEnoughPointsWarning", "points", "trackPointsCatalogueLoaded", "mission", "Lcom/talabat/feature/rewards/domain/model/Mission;", "updateBurnOptions", "burnListDisplayModel", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnListDisplayModel;", "updateSummary", "displayModel", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardFragment extends Fragment implements TraceFieldInterface {
    public static final int BURN_OPTIONS_CATEGORIES_PAGE_SIZE = 20;
    private static final int BURN_OPTIONS_ITEMS_COUNT = 3;
    public static final int BURN_OPTIONS_PAGE = 1;
    @NotNull
    private static final Function2<String, String, String> CHANNEL_NAME = LoyaltyDashboardFragment$Companion$CHANNEL_NAME$1.INSTANCE;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String EMPTY_STRING = " ";
    @NotNull
    public static final String GA_SCREEN_NAME = "Rewards Screen";
    @NotNull
    private static final String NO_LAST_TRANSACTION_POINTS = "-";
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public FragLoyaltyDashboardBinding binding;
    @Nullable
    private DSBottomSheetFragmentWithoutPadding bottomSheet;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public CoroutineDispatchersFactory coroutineDispatchersFactory;
    /* access modifiers changed from: private */
    @NotNull
    public LoyaltyDashboardFragment$coroutineScope$1 coroutineScope = new LoyaltyDashboardFragment$coroutineScope$1(this);
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    @Inject
    public ITalabatFeatureFlag featureFlagRepository;
    @Inject
    public IHelpCenterDeeplinkBuilder helpDeeplinkBuilder;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;
    @Inject
    public Navigator navigator;
    @Nullable
    private String rewardsCatalogueOrigin;
    @Inject
    public RewardsTracker rewardsTracker;
    @NotNull
    private final Lazy viewModel$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new LoyaltyDashboardFragment$viewModel$2(this));

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R>\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/ui/loyalty/dashboard/LoyaltyDashboardFragment$Companion;", "", "()V", "BURN_OPTIONS_CATEGORIES_PAGE_SIZE", "", "BURN_OPTIONS_ITEMS_COUNT", "BURN_OPTIONS_PAGE", "CHANNEL_NAME", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "categoryName", "categoryId", "EMPTY_STRING", "GA_SCREEN_NAME", "NO_LAST_TRANSACTION_POINTS", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void f(LoyaltyDashboardFragment loyaltyDashboardFragment, Mission mission, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mission = null;
        }
        loyaltyDashboardFragment.trackPointsCatalogueLoaded(mission);
    }

    private final void fireAppTrackingEvents(int i11) {
        Context context = getContext();
        if (context != null) {
            IntegrationAppTracker.Companion.onRedeemPageOpen(context, GA_SCREEN_NAME, String.valueOf(i11));
        }
    }

    private final LinearLayout getCategoryView(int i11, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        String invoke = CHANNEL_NAME.invoke(burnItemCategoryDisplayModel.getCategoryName(), burnItemCategoryDisplayModel.getCategoryId());
        if (burnItemCategoryDisplayModel.getMeta().getViewMode() == BurnItemCategoryViewType.HERO_CARD) {
            return getHeroCard(invoke, i11, burnItemCategoryDisplayModel);
        }
        return getHorizontalListView(invoke, i11, burnItemCategoryDisplayModel);
    }

    private final HeroCategoryView getHeroCard(String str, int i11, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        HeroCategoryView heroCategoryView = new HeroCategoryView(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        heroCategoryView.populate(burnItemCategoryDisplayModel);
        heroCategoryView.setViewAllOnClickListener(new d(this, str, i11, burnItemCategoryDisplayModel));
        return heroCategoryView;
    }

    /* access modifiers changed from: private */
    /* renamed from: getHeroCard$lambda-12$lambda-11  reason: not valid java name */
    public static final void m10604getHeroCard$lambda12$lambda11(LoyaltyDashboardFragment loyaltyDashboardFragment, String str, int i11, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(loyaltyDashboardFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$channelName");
        Intrinsics.checkNotNullParameter(burnItemCategoryDisplayModel, "$burnCategoryDisplayModel");
        loyaltyDashboardFragment.getViewModel().showFeaturedList(str, i11, burnItemCategoryDisplayModel);
    }

    private final TitleViewMoreHorizontalListView getHorizontalListView(String str, int i11, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel) {
        boolean z11;
        List<BurnItemDisplayModel> list;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        TitleViewMoreHorizontalListView titleViewMoreHorizontalListView = new TitleViewMoreHorizontalListView(requireContext);
        titleViewMoreHorizontalListView.setTitle(burnItemCategoryDisplayModel.getCategoryName());
        if (burnItemCategoryDisplayModel.getBurnItemsDisplayModel().size() > 3) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            titleViewMoreHorizontalListView.setViewAllOnClickListener(new c(this, str, i11, burnItemCategoryDisplayModel));
        }
        if (z11) {
            list = burnItemCategoryDisplayModel.getBurnItemsDisplayModel().subList(0, 3);
        } else {
            list = burnItemCategoryDisplayModel.getBurnItemsDisplayModel();
        }
        BurnOptionClickListener onBurnOptionClickListener = getOnBurnOptionClickListener(str, i11);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        titleViewMoreHorizontalListView.setViewAdapter(new LoyaltyBurnOptionsAdapter(requireContext2, list, burnItemCategoryDisplayModel.getMeta().getViewMode(), onBurnOptionClickListener));
        return titleViewMoreHorizontalListView;
    }

    /* access modifiers changed from: private */
    /* renamed from: getHorizontalListView$lambda-14$lambda-13  reason: not valid java name */
    public static final void m10605getHorizontalListView$lambda14$lambda13(LoyaltyDashboardFragment loyaltyDashboardFragment, String str, int i11, BurnItemCategoryDisplayModel burnItemCategoryDisplayModel, View view) {
        Intrinsics.checkNotNullParameter(loyaltyDashboardFragment, "this$0");
        Intrinsics.checkNotNullParameter(str, "$channelName");
        Intrinsics.checkNotNullParameter(burnItemCategoryDisplayModel, "$burnCategoryDisplayModel");
        loyaltyDashboardFragment.getViewModel().showFeaturedList(str, i11, burnItemCategoryDisplayModel);
    }

    private final BurnOptionClickListener getOnBurnOptionClickListener(String str, int i11) {
        return new LoyaltyDashboardFragment$getOnBurnOptionClickListener$1(str, i11, this);
    }

    /* access modifiers changed from: private */
    public final LoyaltyDashboardViewModel getViewModel() {
        return (LoyaltyDashboardViewModel) this.viewModel$delegate.getValue();
    }

    private final void navigateToActivity(BurnOptionDetailsNavigator.BurnOptionDetails burnOptionDetails) {
        Context context = getContext();
        if (context != null) {
            BurnOptionsDetailsActivity.Companion.navigateToActivity(context, burnOptionDetails.getBurnItemDisplayModel(), burnOptionDetails.getTotalPoints(), burnOptionDetails.getPosition());
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToFeaturedList(FeaturedListData featuredListData) {
        Context context;
        if (featuredListData != null && (context = getContext()) != null) {
            Navigator.DefaultImpls.navigateTo$default(getNavigator(), context, new BurnOptionsScreen(new BurnOptionsScreen.Data(featuredListData.getBurnCategoryDisplayModel().getCategoryId(), featuredListData.getBurnCategoryDisplayModel().getCategoryName(), featuredListData.getBurnCategoryDisplayModel().getCategoryType(), featuredListData.getTotalPoints(), featuredListData.getChannelName(), featuredListData.getChannelPosition(), featuredListData.getBurnCategoryDisplayModel().getBurnItemsDisplayModel())), (Function1) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToHelpCenter() {
        DeepLinkNavigator deepLinkNavigator2 = getDeepLinkNavigator();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        DeepLinkNavigator.DefaultImpls.navigateTo$default(deepLinkNavigator2, requireActivity, IHelpCenterDeeplinkBuilder.DefaultImpls.build$default(getHelpDeeplinkBuilder(), (String) null, (String) null, 3, (Object) null), (Function0) null, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void setLoadingStatus(Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
            if (fragLoyaltyDashboardBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragLoyaltyDashboardBinding = null;
            }
            fragLoyaltyDashboardBinding.loyaltyDashboardSwipeRefreshLayout.setRefreshing(bool.booleanValue());
        }
    }

    private final void setupHistoryButton() {
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
        if (fragLoyaltyDashboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragLoyaltyDashboardBinding = null;
        }
        fragLoyaltyDashboardBinding.loyaltyDashViewHistoryTextView.setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupHistoryButton$lambda-2  reason: not valid java name */
    public static final void m10606setupHistoryButton$lambda2(LoyaltyDashboardFragment loyaltyDashboardFragment, View view) {
        Intrinsics.checkNotNullParameter(loyaltyDashboardFragment, "this$0");
        loyaltyDashboardFragment.getViewModel().showHistory();
    }

    private final void setupLoyaltyPointsSummary() {
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
        if (fragLoyaltyDashboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragLoyaltyDashboardBinding = null;
        }
        fragLoyaltyDashboardBinding.loyaltyDashboardSummaryView.enableHowItWorks(new a(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupLoyaltyPointsSummary$lambda-1  reason: not valid java name */
    public static final void m10607setupLoyaltyPointsSummary$lambda1(LoyaltyDashboardFragment loyaltyDashboardFragment, View view) {
        Intrinsics.checkNotNullParameter(loyaltyDashboardFragment, "this$0");
        loyaltyDashboardFragment.getViewModel().showHowItWorks();
    }

    private final void setupMissionWidget() {
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding2 = null;
        if (fragLoyaltyDashboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragLoyaltyDashboardBinding = null;
        }
        fragLoyaltyDashboardBinding.missionWidget.setListener(new LoyaltyDashboardFragment$setupMissionWidget$1(this));
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding3 = this.binding;
        if (fragLoyaltyDashboardBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragLoyaltyDashboardBinding2 = fragLoyaltyDashboardBinding3;
        }
        fragLoyaltyDashboardBinding2.missionWidget.setClaimedListener(new LoyaltyDashboardFragment$setupMissionWidget$2(this));
    }

    private final void setupNavigationBar() {
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
        if (fragLoyaltyDashboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragLoyaltyDashboardBinding = null;
        }
        DSNavigationBarWithActionButton dSNavigationBarWithActionButton = fragLoyaltyDashboardBinding.marketPlaceNavigationBar;
        dSNavigationBarWithActionButton.setTitle(getString(R.string.loyalty_rewards));
        dSNavigationBarWithActionButton.setLeadingIconButton(new DSIconButtonModel(com.designsystem.marshmallow.R.drawable.ds_arrow_back, new LoyaltyDashboardFragment$setupNavigationBar$1$1(this)));
        String string = getString(R.string.loyalty_get_help);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….string.loyalty_get_help)");
        dSNavigationBarWithActionButton.setActionButton(new DSNavigationBarActionButtonModel(string, new LoyaltyDashboardFragment$setupNavigationBar$1$2(this)));
    }

    private final void setupObservers() {
        LifecycleKt.failure(this, getViewModel().getFailureData(), new LoyaltyDashboardFragment$setupObservers$1(this));
        LifecycleKt.observe(this, getViewModel().getPointsData(), new LoyaltyDashboardFragment$setupObservers$2(this));
        LifecycleKt.observe(this, getViewModel().getBurnOptionsData(), new LoyaltyDashboardFragment$setupObservers$3(this));
        LifecycleKt.observe(this, getViewModel().getShowBurnOptionDetailsEvent(), new LoyaltyDashboardFragment$setupObservers$4(this));
        LifecycleKt.observe(this, getViewModel().getShowHowItWorksEvent(), new LoyaltyDashboardFragment$setupObservers$5(this));
        LifecycleKt.observe(this, getViewModel().getShowHistoryEvent(), new LoyaltyDashboardFragment$setupObservers$6(this));
        LifecycleKt.observe(this, getViewModel().getShowFeaturedListEvent(), new LoyaltyDashboardFragment$setupObservers$7(this));
        LifecycleKt.observe(this, getViewModel().getLoadingIndicator(), new LoyaltyDashboardFragment$setupObservers$8(this));
    }

    private final void setupRewardsCatalogueOrigin() {
        LoyaltyDashboardScreen.LoyaltyDashboardData loyaltyDashboardData;
        Bundle arguments = getArguments();
        String str = null;
        if (arguments != null) {
            loyaltyDashboardData = (LoyaltyDashboardScreen.LoyaltyDashboardData) arguments.getParcelable("navigatorData");
        } else {
            loyaltyDashboardData = null;
        }
        if (loyaltyDashboardData != null) {
            str = loyaltyDashboardData.getRewardsCatalogueOrigin();
        }
        this.rewardsCatalogueOrigin = str;
    }

    private final void setupSwipeRefresh() {
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
        if (fragLoyaltyDashboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragLoyaltyDashboardBinding = null;
        }
        fragLoyaltyDashboardBinding.loyaltyDashboardSwipeRefreshLayout.setOnRefreshListener(new b(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: setupSwipeRefresh$lambda-3  reason: not valid java name */
    public static final void m10608setupSwipeRefresh$lambda3(LoyaltyDashboardFragment loyaltyDashboardFragment) {
        Intrinsics.checkNotNullParameter(loyaltyDashboardFragment, "this$0");
        loyaltyDashboardFragment.getViewModel().loadAll(String.valueOf(loyaltyDashboardFragment.getConfigurationLocalRepository().selectedCountry().getCountryId()));
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = loyaltyDashboardFragment.binding;
        if (fragLoyaltyDashboardBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            fragLoyaltyDashboardBinding = null;
        }
        fragLoyaltyDashboardBinding.missionWidget.loadMission();
    }

    private final void setupUI() {
        setupNavigationBar();
        setupLoyaltyPointsSummary();
        setupHistoryButton();
        setupSwipeRefresh();
        setupMissionWidget();
    }

    private final void showBottomSheet(BurnOptionDetailsNavigator.BurnOptionDetails burnOptionDetails) {
        DSBottomSheetFragmentWithoutPadding dSBottomSheetFragmentWithoutPadding = this.bottomSheet;
        if (dSBottomSheetFragmentWithoutPadding != null) {
            dSBottomSheetFragmentWithoutPadding.setOnDismiss(new LoyaltyDashboardFragment$showBottomSheet$1(this));
            BurnOptionsDetailsActivity.Companion companion = BurnOptionsDetailsActivity.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showBottomSheet(parentFragmentManager, dSBottomSheetFragmentWithoutPadding, burnOptionDetails.getBurnItemDisplayModel(), burnOptionDetails.getTotalPoints(), burnOptionDetails.getPosition());
        }
    }

    /* access modifiers changed from: private */
    public final void showBurnOptionDetails(BurnOptionDetailsNavigator.BurnOptionDetailsTarget burnOptionDetailsTarget) {
        if (burnOptionDetailsTarget instanceof BurnOptionDetailsNavigator.BurnOptionDetailsTarget.BottomSheet) {
            showBottomSheet(((BurnOptionDetailsNavigator.BurnOptionDetailsTarget.BottomSheet) burnOptionDetailsTarget).getDetails());
        } else if (burnOptionDetailsTarget instanceof BurnOptionDetailsNavigator.BurnOptionDetailsTarget.View) {
            navigateToActivity(((BurnOptionDetailsNavigator.BurnOptionDetailsTarget.View) burnOptionDetailsTarget).getDetails());
        } else if (burnOptionDetailsTarget instanceof BurnOptionDetailsNavigator.BurnOptionDetailsTarget.WarningNotEnoughPoints) {
            showNotEnoughPointsWarning(((BurnOptionDetailsNavigator.BurnOptionDetailsTarget.WarningNotEnoughPoints) burnOptionDetailsTarget).getPoints());
        }
    }

    /* access modifiers changed from: private */
    public final void showFailure(Failure failure) {
        Status.Companion companion = Status.Companion;
        FragmentActivity activity = getActivity();
        String string = getResources().getString(R.string.could_not_load_try_again);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(com.…could_not_load_try_again)");
        Status.Companion.notify$default(companion, activity, (ViewGroup) null, string, getResources().getString(R.string.something_went_wrong), (BaseTransientBottomBar.BaseCallback) null, (ActionStatus) null, 50, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void showHistory(LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
        Integer num;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            GrowthNavigatorActions.Companion companion = GrowthNavigatorActions.Companion;
            String str = null;
            if (loyaltyPointsDisplayModel != null) {
                num = Integer.valueOf(loyaltyPointsDisplayModel.getTotalPoints());
            } else {
                num = null;
            }
            int orZero = IntKt.orZero(num);
            if (loyaltyPointsDisplayModel != null) {
                str = loyaltyPointsDisplayModel.getExpirationText();
            }
            if (str == null) {
                str = "";
            }
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) activity, companion.createNavigatorModelForLoyaltyHistory(orZero, str));
        }
    }

    /* access modifiers changed from: private */
    public final void showHowItWorks(Integer num) {
        if (num != null) {
            num.intValue();
            FragmentActivity activity = getActivity();
            if (activity != null) {
                com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) activity, GrowthNavigatorActions.Companion.createNavigatorModelForLoyaltyHowItWorks(num.intValue()));
            }
        }
    }

    private final void showNotEnoughPointsWarning(int i11) {
        Context context = getContext();
        if (context != null) {
            BurnOptionsDetailsActivity.Companion companion = BurnOptionsDetailsActivity.Companion;
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
            if (fragLoyaltyDashboardBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragLoyaltyDashboardBinding = null;
            }
            DSAlert dSAlert = fragLoyaltyDashboardBinding.dsAlert;
            Intrinsics.checkNotNullExpressionValue(dSAlert, "binding.dsAlert");
            companion.showNotEnoughPointsWarning(context, dSAlert, i11);
        }
    }

    /* access modifiers changed from: private */
    public final void trackPointsCatalogueLoaded(Mission mission) {
        List list;
        RewardsTracker rewardsTracker2 = getRewardsTracker();
        MissionOrigin missionOrigin = MissionOrigin.REWARDS;
        if (mission == null || (list = CollectionsKt__CollectionsJVMKt.listOf(mission)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        rewardsTracker2.onPointsCatalogueLoaded(missionOrigin, list, this.rewardsCatalogueOrigin);
    }

    /* access modifiers changed from: private */
    public final void updateBurnOptions(BurnListDisplayModel burnListDisplayModel) {
        if (burnListDisplayModel != null) {
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
            if (fragLoyaltyDashboardBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragLoyaltyDashboardBinding = null;
            }
            fragLoyaltyDashboardBinding.loyaltyDashViewBurnOptionsLinearLayout.removeAllViews();
            int i11 = 0;
            for (Object next : burnListDisplayModel.getData()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                BurnItemCategoryDisplayModel burnItemCategoryDisplayModel = (BurnItemCategoryDisplayModel) next;
                FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding2 = this.binding;
                if (fragLoyaltyDashboardBinding2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragLoyaltyDashboardBinding2 = null;
                }
                fragLoyaltyDashboardBinding2.loyaltyDashViewBurnOptionsLinearLayout.addView(getCategoryView(i11, burnItemCategoryDisplayModel));
                i11 = i12;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateSummary(LoyaltyPointsDisplayModel loyaltyPointsDisplayModel) {
        boolean z11;
        if (loyaltyPointsDisplayModel != null) {
            fireAppTrackingEvents(loyaltyPointsDisplayModel.getTotalPoints());
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = this.binding;
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding2 = null;
            if (fragLoyaltyDashboardBinding == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragLoyaltyDashboardBinding = null;
            }
            fragLoyaltyDashboardBinding.loyaltyDashboardSummaryView.setPoints(loyaltyPointsDisplayModel.getTotalPoints());
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding3 = this.binding;
            if (fragLoyaltyDashboardBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragLoyaltyDashboardBinding3 = null;
            }
            fragLoyaltyDashboardBinding3.loyaltyDashboardSummaryView.setPointsExpirationText(loyaltyPointsDisplayModel.getExpirationText());
            if (loyaltyPointsDisplayModel.getPoints().length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding4 = this.binding;
                if (fragLoyaltyDashboardBinding4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    fragLoyaltyDashboardBinding4 = null;
                }
                fragLoyaltyDashboardBinding4.loyaltyDashLastProcessedPointsTextView.setText("-");
                FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding5 = this.binding;
                if (fragLoyaltyDashboardBinding5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                } else {
                    fragLoyaltyDashboardBinding2 = fragLoyaltyDashboardBinding5;
                }
                fragLoyaltyDashboardBinding2.loyaltyDashLastProcessedDateTextView.setText(getString(R.string.loyaty_no_points_earned));
                return;
            }
            String str = loyaltyPointsDisplayModel.getUnSignedPoints() + " " + getString(loyaltyPointsDisplayModel.getPointsTransactionString());
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding6 = this.binding;
            if (fragLoyaltyDashboardBinding6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                fragLoyaltyDashboardBinding6 = null;
            }
            fragLoyaltyDashboardBinding6.loyaltyDashLastProcessedPointsTextView.setText(str);
            FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding7 = this.binding;
            if (fragLoyaltyDashboardBinding7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                fragLoyaltyDashboardBinding2 = fragLoyaltyDashboardBinding7;
            }
            fragLoyaltyDashboardBinding2.loyaltyDashLastProcessedDateTextView.setText(loyaltyPointsDisplayModel.getDate());
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
    public final CoroutineDispatchersFactory getCoroutineDispatchersFactory() {
        CoroutineDispatchersFactory coroutineDispatchersFactory2 = this.coroutineDispatchersFactory;
        if (coroutineDispatchersFactory2 != null) {
            return coroutineDispatchersFactory2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineDispatchersFactory");
        return null;
    }

    @NotNull
    public final DeepLinkNavigator getDeepLinkNavigator() {
        DeepLinkNavigator deepLinkNavigator2 = this.deepLinkNavigator;
        if (deepLinkNavigator2 != null) {
            return deepLinkNavigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkNavigator");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlagRepository() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlagRepository;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlagRepository");
        return null;
    }

    @NotNull
    public final IHelpCenterDeeplinkBuilder getHelpDeeplinkBuilder() {
        IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder = this.helpDeeplinkBuilder;
        if (iHelpCenterDeeplinkBuilder != null) {
            return iHelpCenterDeeplinkBuilder;
        }
        Intrinsics.throwUninitializedPropertyAccessException("helpDeeplinkBuilder");
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
    public final Navigator getNavigator() {
        Navigator navigator2 = this.navigator;
        if (navigator2 != null) {
            return navigator2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    @NotNull
    public final RewardsTracker getRewardsTracker() {
        RewardsTracker rewardsTracker2 = this.rewardsTracker;
        if (rewardsTracker2 != null) {
            return rewardsTracker2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("rewardsTracker");
        return null;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerLoyaltyDashboardFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(FeatureFlagCoreLibApi.class), (RewardsFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(RewardsFeatureApi.class), (DispatcherCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DispatcherCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(DeepLinkCoreLibApi.class), (HelpCenterFeatureApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(HelpCenterFeatureApi.class)).inject(this);
        super.onAttach(context);
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [androidx.fragment.app.Fragment] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(@org.jetbrains.annotations.Nullable android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.String r0 = "LoyaltyDashboardFragment#onCreate"
            java.lang.String r1 = "LoyaltyDashboardFragment"
            com.newrelic.agent.android.tracing.TraceMachine.startTracing(r1)
            r1 = 0
            com.newrelic.agent.android.tracing.Trace r2 = r3._nr_trace     // Catch:{ NoSuchFieldError -> 0x000e }
            com.newrelic.agent.android.tracing.TraceMachine.enterMethod(r2, r0, r1)     // Catch:{ NoSuchFieldError -> 0x000e }
            goto L_0x0011
        L_0x000e:
            com.newrelic.agent.android.tracing.TraceMachine.enterMethod(r1, r0, r1)     // Catch:{ NoSuchFieldError -> 0x000e }
        L_0x0011:
            super.onCreate(r4)
            androidx.fragment.app.FragmentManager r4 = r3.getParentFragmentManager()
            com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding$Companion r0 = com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding.Companion
            java.lang.String r0 = r0.getTAG()
            androidx.fragment.app.Fragment r4 = r4.findFragmentByTag(r0)
            boolean r0 = r4 instanceof com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding
            if (r0 == 0) goto L_0x0029
            r1 = r4
            com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding r1 = (com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding) r1
        L_0x0029:
            if (r1 != 0) goto L_0x0030
            com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding r1 = new com.talabat.feature.rewards.presentation.DSBottomSheetFragmentWithoutPadding
            r1.<init>()
        L_0x0030:
            r3.bottomSheet = r1
            com.newrelic.agent.android.tracing.TraceMachine.exitMethod()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.growth.ui.loyalty.dashboard.LoyaltyDashboardFragment.onCreate(android.os.Bundle):void");
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        FragLoyaltyDashboardBinding fragLoyaltyDashboardBinding = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "LoyaltyDashboardFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "LoyaltyDashboardFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragLoyaltyDashboardBinding inflate = FragLoyaltyDashboardBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater, container, false)");
        this.binding = inflate;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            fragLoyaltyDashboardBinding = inflate;
        }
        RelativeLayout root = fragLoyaltyDashboardBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        TraceMachine.exitMethod();
        return root;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupRewardsCatalogueOrigin();
        setupUI();
        setupObservers();
        getViewModel().onRewardsScreenLoaded();
        getViewModel().loadAll(String.valueOf(getConfigurationLocalRepository().selectedCountry().getCountryId()));
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setCoroutineDispatchersFactory(@NotNull CoroutineDispatchersFactory coroutineDispatchersFactory2) {
        Intrinsics.checkNotNullParameter(coroutineDispatchersFactory2, "<set-?>");
        this.coroutineDispatchersFactory = coroutineDispatchersFactory2;
    }

    public final void setDeepLinkNavigator(@NotNull DeepLinkNavigator deepLinkNavigator2) {
        Intrinsics.checkNotNullParameter(deepLinkNavigator2, "<set-?>");
        this.deepLinkNavigator = deepLinkNavigator2;
    }

    public final void setFeatureFlagRepository(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlagRepository = iTalabatFeatureFlag;
    }

    public final void setHelpDeeplinkBuilder(@NotNull IHelpCenterDeeplinkBuilder iHelpCenterDeeplinkBuilder) {
        Intrinsics.checkNotNullParameter(iHelpCenterDeeplinkBuilder, "<set-?>");
        this.helpDeeplinkBuilder = iHelpCenterDeeplinkBuilder;
    }

    public final void setLocationConfigurationRepository(@NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "<set-?>");
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    public final void setNavigator(@NotNull Navigator navigator2) {
        Intrinsics.checkNotNullParameter(navigator2, "<set-?>");
        this.navigator = navigator2;
    }

    public final void setRewardsTracker(@NotNull RewardsTracker rewardsTracker2) {
        Intrinsics.checkNotNullParameter(rewardsTracker2, "<set-?>");
        this.rewardsTracker = rewardsTracker2;
    }
}
