package com.talabat.growth.ui.loyalty.history;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_empty_state_v2.DSEmptyState;
import com.designsystem.ds_navigation_bar.DSNavigationBar;
import com.designsystem.ds_tabs.DSTabBar;
import com.designsystem.ds_tabs.DSTabItemModel;
import com.integration.IntegrationAppTracker;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.growth.R;
import com.talabat.growth.features.loyalty.network.PointsHistoryFilterType;
import com.talabat.growth.ui.loyalty.history.viewModel.LoyaltyHistoryViewModel;
import com.talabat.growth.ui.loyalty.history.viewModel.LoyaltyHistoryViewModelBuilder;
import com.talabat.growth.ui.loyalty.models.LoyaltyHistoryDisplayModel;
import com.talabat.growth.ui.loyalty.views.LoyaltyPointsSummaryView;
import com.talabat.talabatcore.BaseFragment;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.extensions.LifecycleKt;
import com.talabat.talabatnavigation.growthSquad.GrowthNavigatorActions;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001d\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u0002J\u0012\u0010\u0016\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0014H\u0002J\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00020#H\u0016J\b\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\u0014H\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002J\b\u00100\u001a\u00020\u0014H\u0002J\b\u00101\u001a\u00020\u0014H\u0002J\u0010\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u000fH\u0002J\u0012\u00104\u001a\u00020\u00142\b\u00105\u001a\u0004\u0018\u000106H\u0002J\b\u00107\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/talabat/growth/ui/loyalty/history/LoyaltyHistoryFragment;", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/growth/ui/loyalty/history/viewModel/LoyaltyHistoryViewModel;", "()V", "calledFilterId", "Lcom/talabat/growth/features/loyalty/network/PointsHistoryFilterType;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "currentPage", "", "isLastPage", "", "isLoading", "listAdaptor", "Lcom/talabat/growth/ui/loyalty/history/LoyaltyHistoryListAdaptor;", "callApiForFilter", "", "filterId", "failureHere", "failure", "Lcom/talabat/talabatcore/exception/Failure;", "fireAppTrackingEvent", "it", "getMoreItems", "getPaginationListener", "com/talabat/growth/ui/loyalty/history/LoyaltyHistoryFragment$getPaginationListener$1", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "(Landroidx/recyclerview/widget/LinearLayoutManager;)Lcom/talabat/growth/ui/loyalty/history/LoyaltyHistoryFragment$getPaginationListener$1;", "getPointsListFromViewModel", "getViewModelClass", "Ljava/lang/Class;", "layoutId", "observatory", "onAttach", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "populateUi", "setNoSpentPointsTextIfNeeded", "setupPointsHistoryTabs", "setupUi", "showPointsListOrEmptyView", "showList", "updateUI", "displayModel", "Lcom/talabat/growth/ui/loyalty/models/LoyaltyHistoryDisplayModel;", "viewModelBuilder", "Companion", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyHistoryFragment extends BaseFragment {
    private static final int ALL_POINTS_HISTORY_TAB_INDEX = 1;
    private static final int BURNT_POINTS_HISTORY_TAB_INDEX = 3;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int EARNED_POINTS_HISTORY_TAB_INDEX = 2;
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    @NotNull
    private PointsHistoryFilterType calledFilterId = PointsHistoryFilterType.ALL;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    private int currentPage = 1;
    /* access modifiers changed from: private */
    public boolean isLastPage;
    /* access modifiers changed from: private */
    public boolean isLoading;
    @NotNull
    private final LoyaltyHistoryListAdaptor listAdaptor = new LoyaltyHistoryListAdaptor((List) null, 1, (DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/talabat/growth/ui/loyalty/history/LoyaltyHistoryFragment$Companion;", "", "()V", "ALL_POINTS_HISTORY_TAB_INDEX", "", "BURNT_POINTS_HISTORY_TAB_INDEX", "EARNED_POINTS_HISTORY_TAB_INDEX", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void a(LoyaltyHistoryFragment loyaltyHistoryFragment, PointsHistoryFilterType pointsHistoryFilterType, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            pointsHistoryFilterType = PointsHistoryFilterType.ALL;
        }
        loyaltyHistoryFragment.callApiForFilter(pointsHistoryFilterType);
    }

    /* access modifiers changed from: private */
    public final void callApiForFilter(PointsHistoryFilterType pointsHistoryFilterType) {
        this.calledFilterId = pointsHistoryFilterType;
        this.currentPage = 1;
        getPointsListFromViewModel();
    }

    private final void fireAppTrackingEvent(int i11) {
        Context context = getContext();
        if (context != null) {
            IntegrationAppTracker.Companion.onRedeemPageOpen(context, "Points History Screen", String.valueOf(i11));
        }
    }

    /* access modifiers changed from: private */
    public final void getMoreItems() {
        this.currentPage++;
        getPointsListFromViewModel();
    }

    private final LoyaltyHistoryFragment$getPaginationListener$1 getPaginationListener(LinearLayoutManager linearLayoutManager) {
        return new LoyaltyHistoryFragment$getPaginationListener$1(linearLayoutManager, this);
    }

    private final void getPointsListFromViewModel() {
        showProgress();
        LoyaltyHistoryViewModel.getPointsList$default((LoyaltyHistoryViewModel) getViewModel(), (String) null, this.currentPage, 20, this.calledFilterId, (String) null, 17, (Object) null);
    }

    private final void populateUi() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("TotalPoints", 0);
            int i12 = R.id.loyaltyHistorySummaryView;
            ((LoyaltyPointsSummaryView) _$_findCachedViewById(i12)).setPoints(i11);
            fireAppTrackingEvent(i11);
            String string = arguments.getString(GrowthNavigatorActions.EXTRA_LOYALTY_HISTORY_POINTS_EXPIRY_TEXT, "");
            Intrinsics.checkNotNullExpressionValue(string, "it.getString(EXTRA_LOYAL…Y_POINTS_EXPIRY_TEXT, \"\")");
            ((LoyaltyPointsSummaryView) _$_findCachedViewById(i12)).setPointsExpirationText(string);
        }
        a(this, (PointsHistoryFilterType) null, 1, (Object) null);
    }

    private final void setNoSpentPointsTextIfNeeded() {
        if (this.calledFilterId == PointsHistoryFilterType.BURN) {
            int i11 = R.id.loyaltyHistoryEmptyView;
            String string = getString(com.talabat.localization.R.string.loyalty_no_points_spent);
            Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo….loyalty_no_points_spent)");
            ((DSEmptyState) _$_findCachedViewById(i11)).setTitle(string);
            ((DSEmptyState) _$_findCachedViewById(i11)).setDetails(getString(com.talabat.localization.R.string.loyalty_no_points_spent_des));
            return;
        }
        int i12 = R.id.loyaltyHistoryEmptyView;
        String string2 = getString(com.talabat.localization.R.string.loyalty_no_points);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…string.loyalty_no_points)");
        ((DSEmptyState) _$_findCachedViewById(i12)).setTitle(string2);
        ((DSEmptyState) _$_findCachedViewById(i12)).setDetails(getString(com.talabat.localization.R.string.loyalty_no_points_des));
    }

    private final void setupPointsHistoryTabs() {
        int i11 = R.id.pointsHistoryTabs;
        String string = getString(com.talabat.localization.R.string.loyalty_all);
        Intrinsics.checkNotNullExpressionValue(string, "getString(com.talabat.lo…ion.R.string.loyalty_all)");
        String string2 = getString(com.talabat.localization.R.string.loyalty_earn);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(com.talabat.lo…on.R.string.loyalty_earn)");
        String string3 = getString(com.talabat.localization.R.string.loyalty_spend);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(com.talabat.lo…n.R.string.loyalty_spend)");
        ((DSTabBar) _$_findCachedViewById(i11)).setTabs(CollectionsKt__CollectionsKt.listOf(new DSTabItemModel(1, string, (String) null, 4, (DefaultConstructorMarker) null), new DSTabItemModel(2, string2, (String) null, 4, (DefaultConstructorMarker) null), new DSTabItemModel(3, string3, (String) null, 4, (DefaultConstructorMarker) null)));
        ((DSTabBar) _$_findCachedViewById(i11)).setOnTabSelected(new LoyaltyHistoryFragment$setupPointsHistoryTabs$1(this));
        DSTabBar dSTabBar = (DSTabBar) _$_findCachedViewById(i11);
        Intrinsics.checkNotNullExpressionValue(dSTabBar, "pointsHistoryTabs");
        DSTabBar.selectTab$default(dSTabBar, 0, false, 2, (Object) null);
    }

    private final void setupUi() {
        DSNavigationBar dSNavigationBar = (DSNavigationBar) _$_findCachedViewById(R.id.loyaltyPointsHistoryNavigationBar);
        Intrinsics.checkNotNullExpressionValue(dSNavigationBar, "loyaltyPointsHistoryNavigationBar");
        LoyaltyHistoryFragmentKt.setBackButtonWithAction(dSNavigationBar, new LoyaltyHistoryFragment$setupUi$1(this));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.loyaltyHistoryRecyclerView);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(this.listAdaptor);
            recyclerView.addOnScrollListener(getPaginationListener(linearLayoutManager));
        }
        setupPointsHistoryTabs();
    }

    private final void showPointsListOrEmptyView(boolean z11) {
        if (z11) {
            ((DSEmptyState) _$_findCachedViewById(R.id.loyaltyHistoryEmptyView)).setVisibility(4);
            ((RecyclerView) _$_findCachedViewById(R.id.loyaltyHistoryRecyclerView)).setVisibility(0);
            return;
        }
        ((DSEmptyState) _$_findCachedViewById(R.id.loyaltyHistoryEmptyView)).setVisibility(0);
        ((RecyclerView) _$_findCachedViewById(R.id.loyaltyHistoryRecyclerView)).setVisibility(4);
        setNoSpentPointsTextIfNeeded();
    }

    /* access modifiers changed from: private */
    public final void updateUI(LoyaltyHistoryDisplayModel loyaltyHistoryDisplayModel) {
        if (loyaltyHistoryDisplayModel != null) {
            boolean z11 = false;
            if (loyaltyHistoryDisplayModel.getTotalCount() == 0) {
                showPointsListOrEmptyView(false);
            } else {
                showPointsListOrEmptyView(true);
                if (this.isLoading) {
                    this.isLoading = false;
                    this.listAdaptor.addToPointHistoryItems(loyaltyHistoryDisplayModel.getRecords());
                } else {
                    this.listAdaptor.updatePointHistory(loyaltyHistoryDisplayModel.getRecords());
                }
                if (((double) this.currentPage) >= ((double) loyaltyHistoryDisplayModel.getTotalCount()) / ((double) loyaltyHistoryDisplayModel.getPageSize())) {
                    z11 = true;
                }
                this.isLastPage = z11;
            }
        }
        hideProgress();
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
    public Class<LoyaltyHistoryViewModel> getViewModelClass() {
        return LoyaltyHistoryViewModel.class;
    }

    public int layoutId() {
        return R.layout.frag_loyalty_history;
    }

    public void observatory() {
        LifecycleKt.observe(this, ((LoyaltyHistoryViewModel) getViewModel()).getSuccessData(), new LoyaltyHistoryFragment$observatory$1(this));
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DaggerLoyaltyHistoryFragmentComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Fragment) this).getFeature(ConfigurationLocalCoreLibApi.class)).inject(this);
        super.onAttach(context);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        setupUi();
        populateUi();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    @NotNull
    public LoyaltyHistoryViewModel viewModelBuilder() {
        LoyaltyHistoryViewModelBuilder.Companion companion = LoyaltyHistoryViewModelBuilder.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        return companion.getLoyaltyHistoryViewModel(requireContext, getCoroutineScope(), getConfigurationLocalRepository());
    }
}
