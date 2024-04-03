package com.talabat.restaurants;

import JsonModels.PolygonEvents;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.appbar.AppBarLayout;
import com.talabat.AddressList;
import com.talabat.CartScreen;
import com.talabat.ChooseSavedAddressScreen;
import com.talabat.HomeScreenMap;
import com.talabat.R;
import com.talabat.RestaurantsSearchActivity;
import com.talabat.adapters.RestaurantListQuicklyFilterAdapter;
import com.talabat.components.gem.GemComponentRestaurantsListStrategy;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.FWFAttributes;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListRemoteConfigurationsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.network.testutils.TalabatIdlingResource;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.observabilityNew.domain.squads.vendorlist.VendorListScreenPerformanceParams;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import com.talabat.darkstores.helper.DarkstoresDelegate;
import com.talabat.domain.address.Address;
import com.talabat.feature.pickup.presentation.PickupTooltipViewAnimations;
import com.talabat.feature.pickup.presentation.entity.PickupConfig;
import com.talabat.flutter.CollectionFlutterActivity;
import com.talabat.flutter.VendorListSearchFlutterActivity;
import com.talabat.fragments.SkeletonFragment;
import com.talabat.gem.adapters.analytics.GemPageType;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.geminterfaces.OnGemMinimize;
import com.talabat.helpers.CustomDialog;
import com.talabat.helpers.GARestaurantsListEvents;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.homemaphelper.CurrentLocationFetch;
import com.talabat.homemaphelper.CurrentLocationListener;
import com.talabat.maputils.CurrentLocHelper;
import com.talabat.observability.tracker.TimeTrackerImplementation;
import com.talabat.observability.tracker.TimeTrackerKt;
import com.talabat.restaurants.di.DaggerRestaurantsListScreenRefactorComponent;
import com.talabat.restaurants.domain.ShowTooltipUseCase;
import com.talabat.restaurants.inlineads.tracking.InlineAdsShownEvent;
import com.talabat.restaurants.tmart.DarkstoreEntryView;
import com.talabat.restaurants.v1.IRestaurantsListPresenterRefactor;
import com.talabat.restaurants.v1.RestaurantListViewRefactor;
import com.talabat.restaurants.v2.ShopClickOriginUpdater;
import com.talabat.restaurants.v2.domain.utils.GetMoreTileVerticalsIdUseCase;
import com.talabat.restaurants.v2.tracking.FavouriteListClickedEvent;
import com.talabat.restaurants.v2.ui.activities.FavouriteRestaurantsActivity;
import com.talabat.restaurants.v2.ui.fragments.VendorsListFragment;
import com.talabat.talabatcommon.feature.pickupToggle.domain.ShowTabBarUseCase;
import com.talabat.talabatcommon.feature.pickupToggle.presentation.OrderModeTabBar;
import com.talabat.talabatcommon.tracking.UserSettingsTracker;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.LookingGlassView;
import com.talabat.talabatcommon.views.tabBarWithTag.TabBarWithTagView;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.common.TalabatCommonNavigationActions;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import ct.c;
import ct.d;
import ct.e;
import ct.f;
import ct.g;
import datamodels.Cuisine;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Unit;
import library.talabat.SharedPreferencesManager;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.homemap.HomeMapUtils;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.ShopClickedEvent;
import tracking.gtm.GTMCart;
import tracking.gtm.RestaurantsEventsKt;
import tracking.gtm.TalabatGTM;
import xq.b;
import yq.a;

@GemPageType("shop_list")
public class RestaurantsListScreenRefactor extends TalabatBase implements RestaurantListViewRefactor, RestaurantListQuicklyFilterAdapter.OnQuickFilterClick, GemView, OnGemAlertDialogClickListener, GARestaurantsListEvents, View.OnClickListener, OnGemMinimize, LookingGlassView.LookingGlassListener {
    private static final String COLLECTION_CHANNEL = "channel";
    public static final String EXTRA_IS_FROM_HOME_COLLECTION = "isFromHomeCollection";
    public static final String RESTAURANT_LIST = "shop_list";
    private static final String RESTAURANT_LIST_TAG = "Restaurant List";
    public static final String TIME_EVENT_RESTAURANT_LIST = "TIME_EVENT_RESTAURANT_LIST";
    public VendorsListFragment A;
    public RestaurantListQuicklyFilterAdapter B;
    @Nullable
    public GemComponentRestaurantsListStrategy C;
    public boolean D;
    public CustomDialog E;
    public boolean F;
    public PolygonEvents G;
    @Nullable
    public String H;
    public int I = 0;
    public TalabatTracker J;
    public UserSettingsTracker K;
    public ShowTooltipUseCase L;
    @Inject
    public ConfigurationLocalRepository configurationLocalRepository;
    @Inject
    public DeepLinkNavigator deepLinkNavigator;
    private String eventOrigin = "";

    /* renamed from: i  reason: collision with root package name */
    public ImageButton f61203i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f61204j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f61205k;

    /* renamed from: l  reason: collision with root package name */
    public ImageButton f61206l;
    @Inject
    public LocationConfigurationRepository locationConfigurationRepository;

    /* renamed from: m  reason: collision with root package name */
    public Toolbar f61207m;
    private CompositeDisposable mDisposables = new CompositeDisposable();
    public IRestaurantsListPresenterRefactor mPresenter;

    /* renamed from: n  reason: collision with root package name */
    public LinearLayout f61208n;
    @Inject
    public NavigationCoreLibApi navigatorCoreLibApi;

    /* renamed from: o  reason: collision with root package name */
    public View f61209o;
    private ShowTabBarUseCase orderTabUseCase;

    /* renamed from: p  reason: collision with root package name */
    public LinearLayout f61210p;

    /* renamed from: q  reason: collision with root package name */
    public LinearLayout f61211q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f61212r;

    /* renamed from: s  reason: collision with root package name */
    public LinearLayout f61213s;
    @Inject
    public IScreenTracker screenTracker;
    public final ShopClickedEvent.EventOriginSource shopClickedOriginSource = new ShopClickedEvent.EventOriginSourceDelegate();

    /* renamed from: t  reason: collision with root package name */
    public RecyclerView f61214t;
    @Inject
    public ITalabatExperiment talabatExperiment;
    @Inject
    public ITalabatFeatureFlag talabatFeatureFlag;

    /* renamed from: u  reason: collision with root package name */
    public TextView f61215u;

    /* renamed from: v  reason: collision with root package name */
    public LinearLayout f61216v;

    /* renamed from: w  reason: collision with root package name */
    public AppBarLayout f61217w;

    /* renamed from: x  reason: collision with root package name */
    public DarkstoreEntryView f61218x;

    /* renamed from: y  reason: collision with root package name */
    public LookingGlassView f61219y;

    /* renamed from: z  reason: collision with root package name */
    public TabBarWithTagView f61220z;

    private PickupConfig getPickupConfig() {
        return (PickupConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(VendorListRemoteConfigurationsKeys.PICKUP_VL_CONFIG, new PickupConfig(), PickupConfig.class);
    }

    private Boolean getVendorListAAExperimentValue() {
        return Boolean.valueOf(TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.ENABLE_VL_AA_EXPERIMENT, false, TalabatExperimentDataSourceStrategy.APPTIMIZE));
    }

    private void inject() {
        DaggerRestaurantsListScreenRefactorComponent.factory().create((ConfigurationLocalCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ConfigurationRemoteCoreLibApi.class), (ExperimentCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ExperimentCoreLibApi.class), (FeatureFlagCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(FeatureFlagCoreLibApi.class), (ObservabilityCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(ObservabilityCoreLibApi.class), (NavigationCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(DeepLinkCoreLibApi.class)).inject(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$GaOnRestaurantsClicked$0(Restaurant restaurant, String str, HashMap hashMap) throws Exception {
        String str2;
        PolygonEvents polygonEvents = this.G;
        if (SharedPreferencesManager.getInstance(this).isCardViewFavStyle(Boolean.FALSE)) {
            str2 = "card_view";
        } else {
            str2 = "list_view";
        }
        Restaurant restaurant2 = restaurant;
        AppTracker.onRestaurantsClicked(this, restaurant2, "", "", str, "", "shop_list", "", polygonEvents, str2, hashMap, this.shopClickedOriginSource, b.l(restaurant2.f13872id).booleanValue(), "shop_list:list");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Restaurant lambda$onInlineAdsAppeard$1(String str) throws Exception {
        int restaurantIdFromDeepLink = this.mPresenter.getRestaurantIdFromDeepLink(str);
        if (restaurantIdFromDeepLink != -1) {
            int i11 = 0;
            while (true) {
                Restaurant[] restaurantArr = GlobalDataModel.restaurants;
                if (i11 >= restaurantArr.length) {
                    break;
                } else if (restaurantArr[i11].getId() == restaurantIdFromDeepLink) {
                    return GlobalDataModel.restaurants[i11];
                } else {
                    i11++;
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onInlineAdsAppeard$2(int i11, Restaurant restaurant) throws Exception {
        UserSettingsTracker userSettingsTracker;
        TalabatTracker talabatTracker = this.J;
        if (talabatTracker != null && restaurant != null && (userSettingsTracker = this.K) != null) {
            talabatTracker.track(new InlineAdsShownEvent(userSettingsTracker.addUserSettings(), restaurant, i11));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$onInlineAdsAppeard$3(Throwable th2) throws Exception {
    }

    private void navigateToRestaurantsSearchActivity() {
        Intent intent = new Intent(this, RestaurantsSearchActivity.class);
        intent.putExtra("ARG_FROM_ACTIVITY", DefaultCardView.CARD_LIST);
        intent.putExtra("ARG_POLYGON_EVENT", this.G);
        startActivity(intent);
    }

    private void navigateToVendorListSearchFlutterActivity() {
        String str;
        Cuisine valueAt;
        Intent intent = new Intent(this, VendorListSearchFlutterActivity.class);
        intent.putExtra("verticalId", this.I);
        String str2 = this.H;
        if (str2 == null) {
            str = StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT;
        } else {
            str = str2.replace("home_", "");
        }
        intent.putExtra("verticalName", str);
        intent.putIntegerArrayListExtra("verticalIds", new ArrayList(new GetMoreTileVerticalsIdUseCase(SharedPreferencesManager.getInstance()).invoke()));
        FilterEngine filterEngine = GlobalDataModel.filterEngine;
        if (!(filterEngine == null || filterEngine.getSelectedCuisines() == null || filterEngine.getSelectedCuisines().size() <= 0 || (valueAt = filterEngine.getSelectedCuisines().valueAt(0)) == null)) {
            intent.putExtra(VendorListSearchFlutterActivity.CUISINE_ID_KEY, valueAt.f13848id);
        }
        startActivity(intent);
    }

    private void setCollectionsIfNotEmpty() {
        ArrayList<QuickFilter> arrayList = GlobalDataModel.collections;
        if (arrayList == null || arrayList.size() <= 0) {
            this.f61211q.setVisibility(8);
            return;
        }
        showCollectionTitle();
        this.B.setQuickFilterList();
    }

    private void setEventOrigin() {
        if (getIntent().hasExtra("eventOrigin")) {
            this.eventOrigin = getIntent().getStringExtra("eventOrigin");
        } else if (TalabatCommonNavigationActions.EXTRA_FROM_TOGGLE.equals(getIntent().getStringExtra("source"))) {
            this.eventOrigin = "pickup_vendor_list";
        }
    }

    private void showCollectionTitle() {
        if (this.mPresenter.canShowCollectionsTitle()) {
            this.f61212r.setVisibility(0);
        }
    }

    private void showOrderModeTabBar() {
        int i11;
        Integer togglePercentage = getPickupConfig().getTogglePercentage();
        ShowTabBarUseCase showTabBarUseCase = this.orderTabUseCase;
        TalabatTracker talabatTracker = this.J;
        if (togglePercentage == null) {
            i11 = 15;
        } else {
            i11 = togglePercentage.intValue();
        }
        new OrderModeTabBar(showTabBarUseCase, 0, talabatTracker, i11, this.talabatExperiment, this.navigatorCoreLibApi.getNavigator(), this.configurationLocalRepository.selectedCountry().getCountryId(), this.deepLinkNavigator, this.talabatFeatureFlag).accept((TabBarWithTagView) findViewById(R.id.orderModeTabBar), (Context) this);
    }

    private void showPickupTooltip() {
        if (this.orderTabUseCase.shouldShowTabBar()) {
            new PickupTooltipViewInitializer(new ShowTooltipUseCase(this.talabatExperiment)).accept(this, this.mPresenter);
        }
    }

    private void startGem(boolean z11) {
        if (this.I == 0 && Customer.getInstance().isLoggedIn() && this.C != null) {
            this.C.startGemFlow(z11);
        }
    }

    public void GaOnChangeArea() {
        AppTracker.onChangeArea(this);
    }

    public void GaOnChannelClicked(String str) {
        AppTracker.onChannelClicked(this, str);
    }

    public void GaOnCuisineChanged(String str) {
        AppTracker.onCuisineChanged(this, str);
    }

    public void GaOnRestaurantLisLoaded() {
        IRestaurantsListPresenterRefactor iRestaurantsListPresenterRefactor = this.mPresenter;
        if (iRestaurantsListPresenterRefactor != null) {
            iRestaurantsListPresenterRefactor.sendGaOnRestaurantListLoaded(this.H, Boolean.FALSE, "", this.eventOrigin, this.shopClickedOriginSource);
        }
    }

    public void GaOnRestaurantListUpdated(String str) {
        this.mPresenter.sendGaOnRestaurantListLoaded(this.H, Boolean.TRUE, str, this.eventOrigin, this.shopClickedOriginSource);
    }

    public Unit GaOnRestaurantsClicked() {
        GaOnRestaurantsClicked(GlobalDataModel.SELECTED.restaurant);
        return Unit.INSTANCE;
    }

    public void GaOnSearchClicked() {
        AppTracker.onSearchBarClicked(this, "shop_list", getScreenName(), this.mPresenter.getVerticalTypeForAnalytics(this.H), "search");
    }

    public void destroyPresenter() {
    }

    public void disableSerchView() {
        this.f61208n.setEnabled(false);
        this.f61208n.setClickable(false);
        this.f61208n.setAlpha(0.25f);
    }

    public void enableSerchView() {
        this.f61208n.setEnabled(true);
        this.f61208n.setClickable(true);
        this.f61208n.setAlpha(1.0f);
    }

    public void gaOnCartClicked() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            GTMCart.INSTANCE.cartClicked(getScreenName(), ScreenNames.getScreenType(getScreenName()), String.valueOf(restaurant.f13872id), restaurant.f13873name, GlobalDataModel.ShopClickOrigin, restaurant.getShopType());
        }
    }

    @Nullable
    public Restaurant getDarkStore() {
        DarkstoreEntryView darkstoreEntryView = this.f61218x;
        if (darkstoreEntryView != null) {
            return darkstoreEntryView.getDarkStoreVendor();
        }
        return null;
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public String getListingPage() {
        return this.mPresenter.getVerticalTypeForAnalytics(this.H);
    }

    public IGlobalPresenter getPresenter() {
        return this.mPresenter;
    }

    public String getScreenName() {
        return "Restaurant List Screen";
    }

    public void hideDarkStore() {
        this.f61213s.setVisibility(8);
    }

    public void logNetworkError(String str) {
        try {
            LogManager.logException(new Exception(str));
        } catch (Throwable unused) {
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        new OnActivityResultImplementer().accept(new ActivityResult(this, i11, i12, intent), this.mPresenter);
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        new ExitNavigation().accept((Activity) this);
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.onBackToRestaurantPage(dialog);
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.favouriteImageButton:
                this.J.track(new FavouriteListClickedEvent(this.K.addUserSettings()));
                startActivity(new Intent(this, FavouriteRestaurantsActivity.class));
                return;
            case R.id.frameLayout_cartContainer:
                gaOnCartClicked();
                startActivity(new Intent(this, CartScreen.class));
                return;
            case R.id.linearLayout_deliveringAtContainer:
                GaOnChangeArea();
                this.F = true;
                this.mPresenter.selectedAreaDropDown();
                return;
            case R.id.linearLayout_gemFloating:
                GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
                if (gemComponentRestaurantsListStrategy != null) {
                    gemComponentRestaurantsListStrategy.openGemOffer();
                    return;
                }
                return;
            case R.id.linearLayout_searchButton:
                GaOnSearchClicked();
                this.A.cancelInlineAdSubscription();
                navigateToVendorListSearchFlutterActivity();
                GlobalDataModel.backFromMenuToList = true;
                return;
            default:
                return;
        }
    }

    public void onCloseButtonClicked(Dialog dialog) {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.onCloseButtonClicked(dialog);
        }
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(@Nullable Bundle bundle) {
        LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #0");
        inject();
        super.onCreate(bundle);
        LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #1");
        this.screenTracker.startTrace(new ScreenTrackerParams(VendorListScreenPerformanceParams.TRACE, VendorListScreenPerformanceParams.SCREEN_NAME, "vendor"));
        LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #2");
        this.orderTabUseCase = new ShowTabBarUseCase(getPickupConfig().getShouldShowToggle(), this.talabatExperiment, Customer.getInstance());
        LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #3");
        this.C = new GemComponentRestaurantsListStrategy(this);
        LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #4");
        try {
            this.I = SharedPreferencesManager.getInstance(this).getLastFavVerticalId();
            TimeTrackerImplementation timeTracker = TimeTrackerKt.getTimeTracker();
            timeTracker.startTracking(TIME_EVENT_RESTAURANT_LIST + this.I);
            TalabatExperiment.INSTANCE.setAttribute(FWFAttributes.VERTICAL_ID, String.valueOf(this.I));
            LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #5");
            new ShopClickOriginUpdater().accept(this.shopClickedOriginSource, FilterEngine.getInstance(0));
            LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #6");
            new OnCreateImplementer(this.talabatFeatureFlag, this.configurationLocalRepository, this.locationConfigurationRepository).accept(this);
            LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #7");
            new EventTrackerInitializer().accept(this);
            LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #8");
            setEventOrigin();
            updateDarkStores();
            Boolean vendorListAAExperimentValue = getVendorListAAExperimentValue();
            LogManager.info("Vendor List A/A Experiment: " + vendorListAAExperimentValue);
            LogManager.debug("[ALOVvl]: RestaurantsListScreenRefactor #9");
        } catch (Exception e11) {
            LogManager.error(e11, "[ALOVvl]: onCreate RestaurantListScreenREfactor went wrong :: " + e11);
        }
        this.L = new ShowTooltipUseCase(this.talabatExperiment);
    }

    public void onDestroy() {
        this.mDisposables.dispose();
        super.onDestroy();
    }

    public void onError() {
    }

    public void onFallback() {
        this.f61218x.getDarkStore(this, new d(this));
        this.f61218x.setVisibility(0);
    }

    public void onInlineAdsAppeard(String str, int i11) {
        this.mDisposables.add(Observable.fromCallable(new e(this, str)).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new f(this, i11), new g()));
    }

    public void onInlineAdsClick(String str, int i11) {
        boolean z11;
        int restaurantIdFromDeepLink = this.mPresenter.getRestaurantIdFromDeepLink(str);
        if (restaurantIdFromDeepLink != -1) {
            int i12 = 0;
            while (true) {
                Restaurant[] restaurantArr = GlobalDataModel.restaurants;
                if (i12 >= restaurantArr.length) {
                    z11 = false;
                    break;
                }
                Restaurant restaurant = restaurantArr[i12];
                if (restaurant.getId() == restaurantIdFromDeepLink) {
                    restaurant.itemPosition = i11;
                    RestaurantsEventsKt.clearSponsoringData(restaurant);
                    selectRestaurant(restaurant);
                    z11 = true;
                    break;
                }
                i12++;
            }
            if (!z11) {
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
                builder.setTitle((int) R.string.out_of_coverage_area);
                builder.setMessage((CharSequence) getString(R.string.doesnt_deliver_to) + " " + GlobalDataModel.SelectedAreaName + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                builder.setNegativeButton((int) R.string.Close, (DialogInterface.OnClickListener) null);
                builder.setCancelable(false);
                builder.show();
            }
        }
    }

    public void onInterestClicked(Restaurant restaurant) {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.onInterestClicked(restaurant);
        }
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onListScrolled(boolean z11, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(z11);
        ViewCompat.setElevation(this.f61217w, 14.0f);
        if (this.orderTabUseCase.shouldShowTabBar() && this.I == 0) {
            if (this.L.shouldShowPickupTooltip(z11, SharedPreferencesManager.getInstance())) {
                ShowTooltipUseCase.Companion companion = ShowTooltipUseCase.Companion;
                if (!companion.getSeenInSession()) {
                    this.f61209o.setVisibility(0);
                    companion.setSeenInSession(true);
                    return;
                }
            }
            if (i11 > 0) {
                PickupTooltipViewAnimations.Companion.animateToHide(this.f61209o);
            }
        }
    }

    public void onMinimizeButtonClicked(Dialog dialog) {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.onMinimizeButtonClicked(dialog);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = com.talabat.darkstores.helper.DarkstoresDelegate.Companion;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onProductClicked(@org.jetbrains.annotations.NotNull java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x0017
            com.talabat.darkstores.helper.DarkstoresDelegate$Companion r1 = com.talabat.darkstores.helper.DarkstoresDelegate.Companion
            datamodels.Restaurant r3 = r1.getRestaurantFromString(r11)
            if (r3 == 0) goto L_0x0017
            r4 = 1
            r6 = 0
            r7 = 0
            r8 = 0
            r2 = r9
            r5 = r10
            r1.onDarkstoresClicked(r2, r3, r4, r5, r6, r7, r8)
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.restaurants.RestaurantsListScreenRefactor.onProductClicked(java.lang.String, java.lang.String):void");
    }

    public void onRequestError() {
        stopLodingPopup();
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void onResume() {
        super.onResume();
        new OnResumeImplementer().accept(this);
    }

    public void onServerError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onViewAllClicked(String str) {
        Restaurant restaurantFromString;
        if (!str.isEmpty() && (restaurantFromString = DarkstoresDelegate.Companion.getRestaurantFromString(str)) != null) {
            selectRestaurant(restaurantFromString);
        }
    }

    public void quickFilterClick(String str) {
        GaOnChannelClicked(str);
        Intent intent = new Intent(this, CollectionFlutterActivity.class);
        intent.putExtra("deeplink", str);
        intent.putExtra("channel", "channel");
        startActivity(intent);
    }

    public void redirectoChooseSavedAddressScreen(Address address) {
        Intent intent = new Intent(this, ChooseSavedAddressScreen.class);
        CurrentLocationFetch currentLocationFetch = new CurrentLocationFetch((CurrentLocationListener) null, this);
        if (currentLocationFetch.userAllowedAllLocationPermissions(this)) {
            currentLocationFetch.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_INIT_CL_BG());
            currentLocationFetch.fetchCurrentLocation();
            intent.putExtra(GlobalConstants.ExtraNames.IS_FETCHING_CL, true);
        }
        intent.putExtra("isFromRL", true);
        startActivityForResult(intent, 44);
        overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
    }

    public void redirectoHomeMapScreen(boolean z11, String str) {
        LatLng areaCenterLatLg;
        CurrentLocationFetch currentLocationFetch = new CurrentLocationFetch((CurrentLocationListener) null, this);
        if (currentLocationFetch.userAllowedAllLocationPermissions(this)) {
            currentLocationFetch.initLocationRequest(this, CurrentLocHelper.INSTANCE.getIS_FROM_SAVED_LOC());
            currentLocationFetch.fetchCurrentLocation();
        } else {
            GlobalDataModel.HOME_SCREEN_MAP.FUSED_LOCATION_FROM_HOME = null;
            GlobalDataModel.HOME_SCREEN_MAP.ADDRESS_FUSED_LOCATON = null;
        }
        String str2 = "";
        if (z11 && (areaCenterLatLg = HomeMapUtils.INSTANCE.areaCenterLatLg(GlobalDataModel.SelectedAreaId, this.locationConfigurationRepository)) != null) {
            str2 = str2 + areaCenterLatLg.latitude + "," + areaCenterLatLg.longitude;
        }
        Intent intent = new Intent(this, HomeScreenMap.class);
        intent.putExtra("areaLatLng", str2);
        intent.putExtra("isIgnoreCurrentLocation", z11);
        intent.putExtra("UserSelectedAddress", str);
        intent.putExtra("fromRL", true);
        startActivityForResult(intent, 44);
    }

    public void refreshCartCount() {
        super.refreshCartCount();
        new OnRefreshCart().accept(this);
    }

    public void refreshScreen() {
        this.mPresenter.getRestuarnts();
    }

    public void selectRestaurant(Restaurant restaurant) {
        GlobalDataModel.SELECTED.updateRestaurant(restaurant);
        if (!Objects.equals(GlobalDataModel.ShopClickOrigin, "feature_product") && !Objects.equals(GlobalDataModel.ShopClickOrigin, "feature_cpc_product")) {
            GaOnRestaurantsClicked(restaurant);
        }
        Navigator.Companion.navigate((Context) this, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity(restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated));
    }

    public void sendEvent(String str, Map<String, String> map) {
        TalabatGTM.Companion.trackEvent(this, str, map);
    }

    public void setAreaName(String str, boolean z11) {
        this.f61215u.setText(str);
    }

    public void setFloatingGemTimer(String str) {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.setFloatingGemTimer(str);
        }
    }

    public void showAreaSplitAlert() {
        String str;
        int i11;
        if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().getSelectedCustomerAddress() == null) {
            str = getString(R.string.f54881ok);
        } else {
            str = getString(R.string.view_saved_addresses);
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((CharSequence) getString(R.string.update_area));
        if (Customer.getInstance().isLoggedIn()) {
            i11 = R.string.area_split_message;
        } else {
            i11 = R.string.area_split_message_guest;
        }
        builder.setMessage((CharSequence) getString(i11).replace(RichContentLoadTimeRecorder.DELIMETER, GlobalDataModel.SelectedAreaName));
        builder.setPositiveButton((CharSequence) str, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().getSelectedCustomerAddress() == null) {
                    RestaurantsListScreenRefactor.this.finish();
                    AppTracker.onAreaModificationShown(RestaurantsListScreenRefactor.this);
                    dialogInterface.dismiss();
                } else {
                    RestaurantsListScreenRefactor.this.startActivity(new Intent(RestaurantsListScreenRefactor.this, AddressList.class));
                    RestaurantsListScreenRefactor.this.finish();
                }
                AppTracker.onAddressModificationShown(RestaurantsListScreenRefactor.this);
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    @VisibleForTesting
    public void showCollection() {
        boolean z11;
        boolean z12 = true;
        if (!this.D || this.I != 0 || TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_FLUTTER_VL_COLLECTION, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!this.D || this.I == 0 || !TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.GROCERY_COLLECTION, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            z12 = false;
        }
        if (z11) {
            setCollectionsIfNotEmpty();
        } else if (z12) {
            setCollectionsIfNotEmpty();
        } else {
            this.f61211q.setVisibility(8);
        }
    }

    public void showCoordinationsError() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setTitle((int) R.string.error_wrong_address);
        builder.setMessage((int) R.string.error_wrong_address_msg);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                RestaurantsListScreenRefactor.this.finish();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void showDarkStore() {
        this.f61213s.setVisibility(0);
    }

    public void showGemDialog() {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.showGemDialog();
        }
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showLoadingFragment() {
        this.f61213s.setVisibility(8);
        this.f61210p.setVisibility(8);
        TalabatIdlingResource.busy(RESTAURANT_LIST_TAG);
        getSupportFragmentManager().beginTransaction().replace((int) R.id.frameLayout_fragmentContainer, (Fragment) SkeletonFragment.getInstance(), "Skeleton").commit();
    }

    public void showRestaurantsFragment(PolygonEvents polygonEvents, boolean z11) {
        int i11;
        this.G = polygonEvents;
        if (!isDestroyed()) {
            startGem(z11);
            this.f61213s.setVisibility(0);
            boolean booleanVariant = TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.ENABLE_FAVORITES_ON_VENDOR_LIST, false, TalabatExperimentDataSourceStrategy.APPTIMIZE);
            ImageButton imageButton = this.f61206l;
            if (booleanVariant) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            imageButton.setVisibility(i11);
            showCollection();
            this.A = VendorsListFragment.getInstance(this.I);
            getSupportFragmentManager().beginTransaction().replace((int) R.id.frameLayout_fragmentContainer, (Fragment) this.A, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT).commit();
            TalabatIdlingResource.idle(RESTAURANT_LIST_TAG);
            this.f61210p.setVisibility(0);
            this.screenTracker.stopTrace(new ScreenTrackerParams(VendorListScreenPerformanceParams.TRACE, VendorListScreenPerformanceParams.SCREEN_NAME, "vendor"));
            if (this.I != 0) {
                String lastFavVertical = SharedPreferencesManager.getInstance(this).getLastFavVertical();
                SharedPreferencesManager.getInstance(this).saveFavVerical(GlobalConstants.VerticalTypes.RESTAURANT, 0);
                this.H = "home_" + lastFavVertical;
            } else if (SharedPreferencesManager.getInstance(this).getLastFavVertical().equals(GlobalConstants.VerticalTypes.GROCERY)) {
                this.H = "home_groceries";
                SharedPreferencesManager.getInstance(this).saveFavVerical(GlobalConstants.VerticalTypes.RESTAURANT, 0);
            } else if (this.H == null) {
                if (getIntent().getBooleanExtra(EXTRA_IS_FROM_HOME_COLLECTION, false)) {
                    this.H = "home_channel";
                } else {
                    this.H = "home_food";
                    showOrderModeTabBar();
                    showPickupTooltip();
                }
            }
            String str = GlobalDataModel.collectionDeeplink;
            if (str != null && !str.equalsIgnoreCase("")) {
                quickFilterClick(GlobalDataModel.collectionDeeplink);
                GlobalDataModel.collectionDeeplink = null;
            }
        }
    }

    public void showTimeOutDialog() {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.showTimeOutDialog();
        }
    }

    public void showTimerView(boolean z11, String str) {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.showTimerView(z11, str);
        }
    }

    public void startLodingPopup() {
        new PopupLoader().accept(this);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }

    public void stopLodingPopup() {
        new PopupLoadingStopper().accept(this);
    }

    public void timeOut() {
        GemComponentRestaurantsListStrategy gemComponentRestaurantsListStrategy = this.C;
        if (gemComponentRestaurantsListStrategy != null) {
            gemComponentRestaurantsListStrategy.timeOut();
        }
    }

    public void updateDarkStores() {
        try {
            if (this.mPresenter.showTmartBanner(Build.VERSION.SDK_INT)) {
                this.f61218x.getDarkStore(this, new d(this));
                this.f61218x.setVisibility(0);
                return;
            }
            this.f61218x.setVisibility(8);
        } catch (Exception e11) {
            LogManager.error(e11, "updateDarkStores went wrong");
        }
    }

    private void GaOnRestaurantsClicked(Restaurant restaurant) {
        this.mDisposables.add(this.mPresenter.getSwimlanesGa().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this, restaurant, this.D ? this.mPresenter.getChannelIndex() : "")));
    }

    public void GaOnRestaurantListUpdated(String str, String str2) {
        this.mPresenter.sendGaOnRestaurantListLoaded(this.H, Boolean.TRUE, str, str2, this.shopClickedOriginSource);
    }
}
