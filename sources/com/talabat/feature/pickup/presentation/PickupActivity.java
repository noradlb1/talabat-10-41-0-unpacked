package com.talabat.feature.pickup.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.designsystem.ds_button.DSPrimaryButton;
import com.designsystem.ds_small_button.DSSecondarySmallButton;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.screen.pickup.PickupFoodListScreen;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.cuisines.navigation.CuisineView;
import com.talabat.feature.pickup.data.events.swimlanes.SwimlanesTracking;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.pickup.presentation.adapters.SwimlanesHeaderAdapter;
import com.talabat.feature.pickup.presentation.adapters.ValuePropBannerAdapter;
import com.talabat.feature.pickup.presentation.adapters.ValuePropBannerState;
import com.talabat.feature.pickup.presentation.customview.ShimmerView;
import com.talabat.feature.pickup.presentation.di.DaggerPickupActivityComponent;
import com.talabat.feature.pickup.presentation.di.PickupViewModelFactory;
import com.talabat.feature.pickup.presentation.entity.SwimlaneHeaderView;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.feature.pickupToggle.domain.ShowTabBarUseCase;
import com.talabat.talabatcommon.feature.pickupToggle.presentation.OrderModeTabBar;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.pickup.PickupNavigatorActions;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorController;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorModel;
import datamodels.Cuisine;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rn.a;
import rn.b;
import rn.c;
import rn.d;
import rn.e;
import rn.f;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020CH\u0002J\b\u0010E\u001a\u00020CH\u0002J\b\u0010F\u001a\u00020CH\u0002J\b\u0010G\u001a\u00020CH\u0002J\b\u0010H\u001a\u00020\u0004H\u0002J\b\u0010I\u001a\u00020CH\u0002J\b\u0010J\u001a\u00020CH\u0002J\u001a\u0010K\u001a\u00020C2\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\b\u0010P\u001a\u00020CH\u0002J\b\u0010Q\u001a\u00020CH\u0016J\u0012\u0010R\u001a\u00020C2\b\u0010S\u001a\u0004\u0018\u00010TH\u0014J\b\u0010U\u001a\u00020CH\u0002J\b\u0010V\u001a\u00020CH\u0002J\u001c\u0010W\u001a\u00020C2\u0006\u0010L\u001a\u00020M2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010OH\u0002J\b\u0010X\u001a\u00020CH\u0002J\u0017\u0010Y\u001a\u00020C2\b\u0010Z\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010[J\u0010\u0010\\\u001a\u00020C2\u0006\u0010]\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\u001a8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u00020 8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010'\u001a\u00020(8BX\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001b\u00109\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b=\u0010,\u001a\u0004\b;\u0010<R\u000e\u0010>\u001a\u00020?X\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"Lcom/talabat/feature/pickup/presentation/PickupActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "canShowConfirmationPopupOnce", "", "concatAdapter", "Landroidx/recyclerview/widget/ConcatAdapter;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "setConfigurationLocalRepository", "(Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "deepLinkCoreLibApi", "Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "getDeepLinkCoreLibApi", "()Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;", "setDeepLinkCoreLibApi", "(Lcom/talabat/core/deeplink/domain/DeepLinkCoreLibApi;)V", "factory", "Lcom/talabat/feature/pickup/presentation/di/PickupViewModelFactory;", "getFactory", "()Lcom/talabat/feature/pickup/presentation/di/PickupViewModelFactory;", "setFactory", "(Lcom/talabat/feature/pickup/presentation/di/PickupViewModelFactory;)V", "featureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "getFeatureFlag", "()Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "setFeatureFlag", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;)V", "navigatorCoreLibApi", "Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "getNavigatorCoreLibApi", "()Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;", "setNavigatorCoreLibApi", "(Lcom/talabat/core/navigation/domain/NavigationCoreLibApi;)V", "pickupAdapter", "Lcom/talabat/feature/pickup/presentation/PickupAdapter;", "pickupViewModel", "Lcom/talabat/feature/pickup/presentation/PickupViewModel;", "getPickupViewModel", "()Lcom/talabat/feature/pickup/presentation/PickupViewModel;", "pickupViewModel$delegate", "Lkotlin/Lazy;", "talabatExperiment", "Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "getTalabatExperiment", "()Lcom/talabat/core/experiment/domain/ITalabatExperiment;", "setTalabatExperiment", "(Lcom/talabat/core/experiment/domain/ITalabatExperiment;)V", "tracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "getTracker", "()Lcom/talabat/core/tracking/domain/TalabatTracker;", "setTracker", "(Lcom/talabat/core/tracking/domain/TalabatTracker;)V", "valuePropBannerAdapter", "Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerAdapter;", "getValuePropBannerAdapter", "()Lcom/talabat/feature/pickup/presentation/adapters/ValuePropBannerAdapter;", "valuePropBannerAdapter$delegate", "vendorsHeaderAdapter", "Lcom/talabat/feature/pickup/presentation/VendorsHeaderAdapter;", "getEventOrigin", "", "initActionBar", "", "initDagger", "initFiltersAndCuisines", "initOrderModeTabBar", "initRecycler", "isGlobalDataClearedFromMemory", "loadPickupVendors", "navigateToVendorListSearchFlutterActivity", "navigateToVendorMenu", "restaurant", "Ldatamodels/Restaurant;", "swimlanesTracking", "Lcom/talabat/feature/pickup/data/events/swimlanes/SwimlanesTracking;", "observePagingData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNetworkError", "reopenPickupFlow", "selectRestaurant", "setLightStatusBar", "showLoading", "show", "(Ljava/lang/Boolean;)V", "showResult", "isEmpty", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PickupActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public boolean canShowConfirmationPopupOnce = true;
    @NotNull
    private final ConcatAdapter concatAdapter;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public DeepLinkCoreLibApi deepLinkCoreLibApi;
    @Inject
    public PickupViewModelFactory factory;
    @Inject
    public ITalabatFeatureFlag featureFlag;
    @Inject
    public NavigationCoreLibApi navigatorCoreLibApi;
    /* access modifiers changed from: private */
    @NotNull
    public final PickupAdapter pickupAdapter;
    @NotNull
    private final Lazy pickupViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(PickupViewModel.class), new PickupActivity$special$$inlined$viewModels$default$2(this), new PickupActivity$pickupViewModel$2(this), new PickupActivity$special$$inlined$viewModels$default$3((Function0) null, this));
    @Inject
    public ITalabatExperiment talabatExperiment;
    @Inject
    public TalabatTracker tracker;
    @NotNull
    private final Lazy valuePropBannerAdapter$delegate;
    @NotNull
    private final VendorsHeaderAdapter vendorsHeaderAdapter;

    public PickupActivity() {
        PickupAdapter pickupAdapter2 = new PickupAdapter(new PickupActivity$pickupAdapter$1(this));
        this.pickupAdapter = pickupAdapter2;
        VendorsHeaderAdapter vendorsHeaderAdapter2 = new VendorsHeaderAdapter();
        this.vendorsHeaderAdapter = vendorsHeaderAdapter2;
        this.valuePropBannerAdapter$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new PickupActivity$valuePropBannerAdapter$2(this));
        this.concatAdapter = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{vendorsHeaderAdapter2, pickupAdapter2});
    }

    /* access modifiers changed from: private */
    public final String getEventOrigin() {
        String str;
        PickupFoodListScreen.PickupFoodListData pickupFoodListData;
        Intent intent = getIntent();
        if (intent == null || (pickupFoodListData = (PickupFoodListScreen.PickupFoodListData) intent.getParcelableExtra("navigatorData")) == null) {
            str = null;
        } else {
            str = pickupFoodListData.getSource();
        }
        if (Intrinsics.areEqual((Object) getIntent().getStringExtra("source"), (Object) TalabatCommonNavigationActions.EXTRA_FROM_TOGGLE) || Intrinsics.areEqual((Object) str, (Object) TalabatCommonNavigationActions.EXTRA_FROM_TOGGLE)) {
            return "shop_list";
        }
        return "home";
    }

    /* access modifiers changed from: private */
    public final PickupViewModel getPickupViewModel() {
        return (PickupViewModel) this.pickupViewModel$delegate.getValue();
    }

    private final ValuePropBannerAdapter getValuePropBannerAdapter() {
        return (ValuePropBannerAdapter) this.valuePropBannerAdapter$delegate.getValue();
    }

    private final void initActionBar() {
        ((ImageButton) _$_findCachedViewById(R.id.backButton)).setOnClickListener(new f(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initActionBar$lambda-1  reason: not valid java name */
    public static final void m10244initActionBar$lambda1(PickupActivity pickupActivity, View view) {
        Intrinsics.checkNotNullParameter(pickupActivity, "this$0");
        pickupActivity.onBackPressed();
    }

    private final void initDagger() {
        DaggerPickupActivityComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ExperimentCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (PickupFeatureApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(PickupFeatureApi.class), (TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
    }

    private final void initFiltersAndCuisines() {
        ((CuisineView) _$_findCachedViewById(R.id.cuisineViewLayout)).invoke(new PickupActivity$initFiltersAndCuisines$1(this));
        ((LinearLayout) _$_findCachedViewById(R.id.linearLayout_searchButton)).setOnClickListener(new a(this));
        ((DSSecondarySmallButton) _$_findCachedViewById(R.id.resetFiltersBtn)).setOnTap(new PickupActivity$initFiltersAndCuisines$3(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: initFiltersAndCuisines$lambda-0  reason: not valid java name */
    public static final void m10245initFiltersAndCuisines$lambda0(PickupActivity pickupActivity, View view) {
        Intrinsics.checkNotNullParameter(pickupActivity, "this$0");
        pickupActivity.getPickupViewModel().logSearchBarClicked();
        pickupActivity.navigateToVendorListSearchFlutterActivity();
    }

    private final void initOrderModeTabBar() {
        OrderModeTabBar orderModeTabBar = new OrderModeTabBar(new ShowTabBarUseCase(getPickupViewModel().shouldShowToggle(), getTalabatExperiment(), (Customer) null, 4, (DefaultConstructorMarker) null), 1, getTracker(), getPickupViewModel().getTogglePercentage(), getTalabatExperiment(), getNavigatorCoreLibApi().getNavigator(), getConfigurationLocalRepository().selectedCountry().getCountryId(), getDeepLinkCoreLibApi().getDeepLinkNavigator(), getFeatureFlag());
        View findViewById = findViewById(R.id.orderModeTabBar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.orderModeTabBar)");
        orderModeTabBar.accept((TabBarWithTagView) findViewById, (Context) this);
    }

    private final void initRecycler() {
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.pickupRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new PickupRvItemDecorator());
        recyclerView.setAdapter(this.concatAdapter);
        this.pickupAdapter.addLoadStateListener(new PickupActivity$initRecycler$1$1(this));
    }

    private final boolean isGlobalDataClearedFromMemory() {
        return GlobalDataModel.RECENT_LATLONG.latitude == 0.0d;
    }

    /* access modifiers changed from: private */
    public final void loadPickupVendors() {
        showLoading(Boolean.TRUE);
        this.pickupAdapter.refresh();
    }

    public static /* synthetic */ void m(PickupActivity pickupActivity, Restaurant restaurant, SwimlanesTracking swimlanesTracking, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            swimlanesTracking = null;
        }
        pickupActivity.selectRestaurant(restaurant, swimlanesTracking);
    }

    private final void navigateToVendorListSearchFlutterActivity() {
        int i11;
        Cuisine valueAt;
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (filterEngine == null || filterEngine.getSelectedCuisines() == null || filterEngine.getSelectedCuisines().size() <= 0 || (valueAt = filterEngine.getSelectedCuisines().valueAt(0)) == null) {
            i11 = -1;
        } else {
            i11 = valueAt.f13848id;
        }
        Navigator.Companion.navigate((Context) this, PickupNavigatorActions.INSTANCE.createNavigatorForSearchScreen(i11, getPickupViewModel().isExistingPickupCustomer()));
    }

    /* access modifiers changed from: private */
    public final void navigateToVendorMenu(Restaurant restaurant, SwimlanesTracking swimlanesTracking) {
        Restaurant restaurant2 = restaurant;
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        Cart.getInstance().clearCartWhenChangedDeliveryMode(restaurant2, this);
        getPickupViewModel().navigatingToVendorMenu(restaurant2, swimlanesTracking);
        MenuNavigatorController menuNavigatorController = MenuNavigatorController.INSTANCE;
        ITalabatFeatureFlag featureFlag2 = getFeatureFlag();
        DeepLinkNavigator deepLinkNavigator = getDeepLinkCoreLibApi().getDeepLinkNavigator();
        com.talabat.core.navigation.domain.Navigator navigator = getNavigatorCoreLibApi().getNavigator();
        int i11 = restaurant2.branchId;
        boolean z11 = restaurant2.isProRestaurant;
        String str = GlobalDataModel.ShopClickOrigin;
        Intrinsics.checkNotNullExpressionValue(str, "ShopClickOrigin");
        menuNavigatorController.navigateToMenu(this, new MenuNavigatorModel(i11, "pickup", str, Boolean.valueOf(z11), (Integer) null, 16, (DefaultConstructorMarker) null), featureFlag2, deepLinkNavigator, navigator);
    }

    private final void observePagingData() {
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenCreated(new PickupActivity$observePagingData$1(this, (Continuation<? super PickupActivity$observePagingData$1>) null));
        getPickupViewModel().getValuePropBannerLiveData().observe(this, new b(this));
        getPickupViewModel().getScrollToTopLiveData().observe(this, new c(this));
        getPickupViewModel().getSwimlanesLiveData().observe(this, new d(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: observePagingData$lambda-4  reason: not valid java name */
    public static final void m10246observePagingData$lambda4(PickupActivity pickupActivity, ValuePropBannerState valuePropBannerState) {
        Intrinsics.checkNotNullParameter(pickupActivity, "this$0");
        Intrinsics.checkNotNullParameter(valuePropBannerState, "banner");
        if (valuePropBannerState instanceof ValuePropBannerState.Banner) {
            pickupActivity.getValuePropBannerAdapter().updateTitle(((ValuePropBannerState.Banner) valuePropBannerState).getTitle());
            pickupActivity.concatAdapter.addAdapter(0, pickupActivity.getValuePropBannerAdapter());
            pickupActivity.concatAdapter.notifyDataSetChanged();
        } else if (Intrinsics.areEqual((Object) valuePropBannerState, (Object) ValuePropBannerState.Hidden.INSTANCE) && pickupActivity.concatAdapter.removeAdapter(pickupActivity.getValuePropBannerAdapter())) {
            pickupActivity.concatAdapter.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observePagingData$lambda-5  reason: not valid java name */
    public static final void m10247observePagingData$lambda5(PickupActivity pickupActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pickupActivity, "this$0");
        if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
            ((RecyclerView) pickupActivity._$_findCachedViewById(R.id.pickupRecycler)).scrollToPosition(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: observePagingData$lambda-8  reason: not valid java name */
    public static final void m10248observePagingData$lambda8(PickupActivity pickupActivity, List list) {
        Intrinsics.checkNotNullParameter(pickupActivity, "this$0");
        List<? extends RecyclerView.Adapter<? extends RecyclerView.ViewHolder>> adapters = pickupActivity.concatAdapter.getAdapters();
        Intrinsics.checkNotNullExpressionValue(adapters, "concatAdapter.adapters");
        ArrayList<SwimlanesHeaderAdapter> arrayList = new ArrayList<>();
        for (Object next : adapters) {
            if (next instanceof SwimlanesHeaderAdapter) {
                arrayList.add(next);
            }
        }
        for (SwimlanesHeaderAdapter removeAdapter : arrayList) {
            pickupActivity.concatAdapter.removeAdapter(removeAdapter);
        }
        Intrinsics.checkNotNullExpressionValue(list, "it");
        for (SwimlaneHeaderView swimlanesHeaderAdapter : CollectionsKt___CollectionsKt.reversed(list)) {
            pickupActivity.concatAdapter.addAdapter(0, new SwimlanesHeaderAdapter(swimlanesHeaderAdapter, pickupActivity.getPickupViewModel(), new PickupActivity$observePagingData$4$2$1(pickupActivity)));
        }
        if (pickupActivity.getPickupViewModel().shouldShowValuePropBanner()) {
            pickupActivity.concatAdapter.removeAdapter(pickupActivity.getValuePropBannerAdapter());
            pickupActivity.concatAdapter.addAdapter(0, pickupActivity.getValuePropBannerAdapter());
        }
        pickupActivity.concatAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public final void onNetworkError() {
        showLoading(Boolean.FALSE);
        _$_findCachedViewById(R.id.connectionErrorView).setVisibility(0);
        ((DSPrimaryButton) _$_findCachedViewById(R.id.retry)).setOnClickListener(new e(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onNetworkError$lambda-3  reason: not valid java name */
    public static final void m10249onNetworkError$lambda3(PickupActivity pickupActivity, View view) {
        Intrinsics.checkNotNullParameter(pickupActivity, "this$0");
        pickupActivity.pickupAdapter.refresh();
        pickupActivity._$_findCachedViewById(R.id.connectionErrorView).setVisibility(8);
    }

    private final void reopenPickupFlow() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("talabat://?s=pi"));
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public final void selectRestaurant(Restaurant restaurant, SwimlanesTracking swimlanesTracking) {
        ITalabatFeatureFlag.DefaultImpls.getFeatureFlag$default(getFeatureFlag(), (FWFKey) TalabatFeatureFlagConstants.ENABLE_PICKUP_BLOCKING_MODAL, false, false, (Function1) new PickupActivity$selectRestaurant$1(this, restaurant, swimlanesTracking), 4, (Object) null);
    }

    private final void setLightStatusBar() {
        new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView()).setAppearanceLightStatusBars(true);
    }

    /* access modifiers changed from: private */
    public final void showLoading(Boolean bool) {
        boolean z11;
        int i11;
        int i12 = R.id.progressShimmer;
        ShimmerView shimmerView = (ShimmerView) _$_findCachedViewById(i12);
        Intrinsics.checkNotNullExpressionValue(shimmerView, "progressShimmer");
        boolean z12 = false;
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        shimmerView.setVisibility(i11);
        ((ShimmerView) _$_findCachedViewById(i12)).showValuePropBanner(getPickupViewModel().shouldShowValuePropBanner());
        ((ShimmerView) _$_findCachedViewById(i12)).showSwimlanesBanner(getPickupViewModel().shouldShowSwimlanes());
        ShimmerView shimmerView2 = (ShimmerView) _$_findCachedViewById(i12);
        if (bool != null) {
            z12 = bool.booleanValue();
        }
        shimmerView2.animate(z12);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.scrollView_noRestaurantsContainer);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "scrollView_noRestaurantsContainer");
        linearLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showResult(boolean z11) {
        boolean z12;
        if (z11) {
            ShimmerView shimmerView = (ShimmerView) _$_findCachedViewById(R.id.progressShimmer);
            Intrinsics.checkNotNullExpressionValue(shimmerView, "progressShimmer");
            if (shimmerView.getVisibility() == 0) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                ((LinearLayout) _$_findCachedViewById(R.id.scrollView_noRestaurantsContainer)).setVisibility(0);
                ((RecyclerView) _$_findCachedViewById(R.id.pickupRecycler)).setVisibility(8);
                return;
            }
        }
        ((LinearLayout) _$_findCachedViewById(R.id.scrollView_noRestaurantsContainer)).setVisibility(8);
        ((RecyclerView) _$_findCachedViewById(R.id.pickupRecycler)).setVisibility(0);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
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
    public final DeepLinkCoreLibApi getDeepLinkCoreLibApi() {
        DeepLinkCoreLibApi deepLinkCoreLibApi2 = this.deepLinkCoreLibApi;
        if (deepLinkCoreLibApi2 != null) {
            return deepLinkCoreLibApi2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deepLinkCoreLibApi");
        return null;
    }

    @NotNull
    public final PickupViewModelFactory getFactory() {
        PickupViewModelFactory pickupViewModelFactory = this.factory;
        if (pickupViewModelFactory != null) {
            return pickupViewModelFactory;
        }
        Intrinsics.throwUninitializedPropertyAccessException("factory");
        return null;
    }

    @NotNull
    public final ITalabatFeatureFlag getFeatureFlag() {
        ITalabatFeatureFlag iTalabatFeatureFlag = this.featureFlag;
        if (iTalabatFeatureFlag != null) {
            return iTalabatFeatureFlag;
        }
        Intrinsics.throwUninitializedPropertyAccessException("featureFlag");
        return null;
    }

    @NotNull
    public final NavigationCoreLibApi getNavigatorCoreLibApi() {
        NavigationCoreLibApi navigationCoreLibApi = this.navigatorCoreLibApi;
        if (navigationCoreLibApi != null) {
            return navigationCoreLibApi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigatorCoreLibApi");
        return null;
    }

    @NotNull
    public final ITalabatExperiment getTalabatExperiment() {
        ITalabatExperiment iTalabatExperiment = this.talabatExperiment;
        if (iTalabatExperiment != null) {
            return iTalabatExperiment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("talabatExperiment");
        return null;
    }

    @NotNull
    public final TalabatTracker getTracker() {
        TalabatTracker talabatTracker = this.tracker;
        if (talabatTracker != null) {
            return talabatTracker;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tracker");
        return null;
    }

    public void onBackPressed() {
        super.onBackPressed();
        Navigator.Companion.navigate((Context) this, PickupNavigatorActions.INSTANCE.createNavigatorForHomeScreen());
        finish();
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("PickupActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "PickupActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "PickupActivity#onCreate", (ArrayList<String>) null);
        }
        if (isGlobalDataClearedFromMemory()) {
            reopenPickupFlow();
        }
        initDagger();
        super.onCreate(bundle);
        setContentView(R.layout.activity_pickup_screen);
        ((CuisineView) _$_findCachedViewById(R.id.cuisineViewLayout)).setPickup(true);
        getPickupViewModel().screenOpened();
        initActionBar();
        initRecycler();
        initOrderModeTabBar();
        observePagingData();
        initFiltersAndCuisines();
        setLightStatusBar();
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final void setConfigurationLocalRepository(@NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "<set-?>");
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    public final void setDeepLinkCoreLibApi(@NotNull DeepLinkCoreLibApi deepLinkCoreLibApi2) {
        Intrinsics.checkNotNullParameter(deepLinkCoreLibApi2, "<set-?>");
        this.deepLinkCoreLibApi = deepLinkCoreLibApi2;
    }

    public final void setFactory(@NotNull PickupViewModelFactory pickupViewModelFactory) {
        Intrinsics.checkNotNullParameter(pickupViewModelFactory, "<set-?>");
        this.factory = pickupViewModelFactory;
    }

    public final void setFeatureFlag(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "<set-?>");
        this.featureFlag = iTalabatFeatureFlag;
    }

    public final void setNavigatorCoreLibApi(@NotNull NavigationCoreLibApi navigationCoreLibApi) {
        Intrinsics.checkNotNullParameter(navigationCoreLibApi, "<set-?>");
        this.navigatorCoreLibApi = navigationCoreLibApi;
    }

    public final void setTalabatExperiment(@NotNull ITalabatExperiment iTalabatExperiment) {
        Intrinsics.checkNotNullParameter(iTalabatExperiment, "<set-?>");
        this.talabatExperiment = iTalabatExperiment;
    }

    public final void setTracker(@NotNull TalabatTracker talabatTracker) {
        Intrinsics.checkNotNullParameter(talabatTracker, "<set-?>");
        this.tracker = talabatTracker;
    }
}
