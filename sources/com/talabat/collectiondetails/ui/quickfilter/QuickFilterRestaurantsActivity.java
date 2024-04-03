package com.talabat.collectiondetails.ui.quickfilter;

import JsonModels.PolygonEvents;
import JsonModels.parser.UniversalGson;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.instabug.library.model.NetworkLog;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.collectiondetails.R;
import com.talabat.collectiondetails.components.CollectionsCuisineBinder;
import com.talabat.collectiondetails.components.CollectionsFiltersBinder;
import com.talabat.collectiondetails.helpers.DarkstoresDelegate;
import com.talabat.collectiondetails.integration.CollectionsDetailsIntegrator;
import com.talabat.collectiondetails.ui.quickfilter.di.DaggerQuickFilterRestaurantsActivityComponent;
import com.talabat.collectiondetails.ui.restaurantlist.RestaurantsCollectionsAdapter;
import com.talabat.collectiondetails.ui.restaurantlist.RestaurantsListAdapter;
import com.talabat.collectiondetails.utils.FreshVerticalSpaceItemDecoration;
import com.talabat.collectiondetails.utils.ImpresionTrackingMapperKt;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.cuisines.navigation.CollectionsCuisineView;
import com.talabat.feature.rating.presentation.ui.RatingReasonFragmentKt;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.impressions.BatchImpressionTracker;
import com.talabat.impressions.ImpressionsIntegrationKt;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.LookingGlassView;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import datamodels.filters.SelectablePopularFilter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.supercharge.shimmerlayout.ShimmerLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Unit;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.ShopClickedEvent;
import tracking.gtm.TalabatGTM;
import wf.f;
import wf.g;
import wf.h;
import xq.b;

@Instrumented
public abstract class QuickFilterRestaurantsActivity extends AppCompatActivity implements View.OnClickListener, RestaurantsCollectionsAdapter.OnRestaurantCLickListener, IQuickFilterRestaurantsView, LookingGlassView.LookingGlassListener, TraceFieldInterface {
    public static final String ARG_FROM_ACTIVITY = "ARG_FROM_ACTIVITY";
    public static final String ARG_IS_DIRECTLY_FROM_HOME = "ARG_IS_DIRECTLY_FROM_HOME";
    public static final String ARG_POLYGON_EVENT = "ARG_POLYGON_EVENT";
    public static final String ARG_QUICK_FILTER = "ARG_QUICK_FILTER";
    public static final String ARG_VERTICAL_ID = "ARG_VERTICAL_ID";
    private static final String COLLECTION_ID = "collectionId";
    private static final String CUISINE_ID = "cuisineId";
    public static final String TAG = "COLLECTIONS";
    private static final String VERTICAL_ID = "verticalId";
    public TextView A;
    public CoordinatorLayout B;
    @Inject
    public ConfigurationLocalCoreLibApi C;
    @Inject
    public ITalabatFeatureFlag D;
    public int E = 0;
    public Trace _nr_trace;
    public CollectionsCuisineView cuisineView;
    public QuickFilter filter;

    /* renamed from: i  reason: collision with root package name */
    public RecyclerView f55647i;
    private Boolean isNavigatedFromHomeCollection;

    /* renamed from: j  reason: collision with root package name */
    public LinearLayout f55648j;

    /* renamed from: k  reason: collision with root package name */
    public FrameLayout f55649k;

    /* renamed from: l  reason: collision with root package name */
    public NestedScrollView f55650l;

    /* renamed from: m  reason: collision with root package name */
    public LinearLayout f55651m;

    /* renamed from: n  reason: collision with root package name */
    public RestaurantsCollectionsAdapter f55652n;

    /* renamed from: o  reason: collision with root package name */
    public RestaurantsListAdapter f55653o;

    /* renamed from: p  reason: collision with root package name */
    public IQuickFilterRestaurantsPresenter f55654p;

    /* renamed from: q  reason: collision with root package name */
    public PolygonEvents f55655q;

    /* renamed from: r  reason: collision with root package name */
    public ShimmerLayout f55656r;

    /* renamed from: s  reason: collision with root package name */
    public CardView f55657s;
    public final ShopClickedEvent.EventOriginSource shopClickedOriginSource = new ShopClickedEvent.EventOriginSourceDelegate();

    /* renamed from: t  reason: collision with root package name */
    public CardView f55658t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f55659u;

    /* renamed from: v  reason: collision with root package name */
    public ImageView f55660v;
    private String verticalType = RatingReasonFragmentKt.ARGUMENT_NAME_FOOD;

    /* renamed from: w  reason: collision with root package name */
    public TextView f55661w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f55662x;

    /* renamed from: y  reason: collision with root package name */
    public RelativeLayout f55663y;

    /* renamed from: z  reason: collision with root package name */
    public com.talabat.talabatcommon.views.ShimmerLayout f55664z;

    private int getRecommendedQuantity(RestaurantListModel restaurantListModel) {
        if (restaurantListModel == null || restaurantListModel.getOpenNowRestaurants() == null) {
            return 0;
        }
        return restaurantListModel.getOpenNowRestaurants().size();
    }

    private Restaurant getRestaurantFromString(String str) {
        Object obj;
        try {
            Gson gson = UniversalGson.INSTANCE.gson;
            Class cls = Restaurant.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str, cls);
            }
            return (Restaurant) obj;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private StringBuilder getShopIds(RestaurantListModel restaurantListModel) {
        StringBuilder sb2 = new StringBuilder();
        if (!(restaurantListModel == null || restaurantListModel.getOpenNowRestaurants() == null)) {
            if (restaurantListModel.getOpenNowRestaurants().size() >= 20) {
                for (int i11 = 0; i11 < 20; i11++) {
                    if (sb2.length() == 0) {
                        sb2.append(restaurantListModel.getOpenNowRestaurants().get(i11).getId());
                    } else {
                        sb2.append(",");
                        sb2.append(restaurantListModel.getOpenNowRestaurants().get(i11).getId());
                    }
                }
            } else {
                Iterator<Restaurant> it = restaurantListModel.getOpenNowRestaurants().iterator();
                while (it.hasNext()) {
                    Restaurant next = it.next();
                    if (sb2.length() == 0) {
                        sb2.append(next.getId());
                    } else {
                        sb2.append(",");
                        sb2.append(next.getId());
                    }
                }
            }
        }
        return sb2;
    }

    @NonNull
    private String getShopListTrigger() {
        return getIntent().getBooleanExtra(ARG_IS_DIRECTLY_FROM_HOME, false) ? "home_channel" : "channel";
    }

    private void initUI() {
        this.B = (CoordinatorLayout) findViewById(R.id.coordinatorLayout_content);
        this.f55664z = (com.talabat.talabatcommon.views.ShimmerLayout) findViewById(R.id.loadingLayout);
        this.f55650l = (NestedScrollView) findViewById(R.id.scrollView_noRestaurant);
        this.f55649k = (FrameLayout) findViewById(R.id.frameLayout_divider);
        this.cuisineView = (CollectionsCuisineView) findViewById(R.id.collectionsCuisineViewLayout);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linearLayout_search);
        this.f55648j = linearLayout;
        linearLayout.setOnClickListener(this);
        this.f55651m = (LinearLayout) findViewById(R.id.linearLayout_filterCuisineContainer);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView_restaurants);
        this.f55647i = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (isTgoStyle().booleanValue()) {
            RestaurantsCollectionsAdapter restaurantsCollectionsAdapter = new RestaurantsCollectionsAdapter(this);
            this.f55652n = restaurantsCollectionsAdapter;
            restaurantsCollectionsAdapter.setOnRestaurantClickListener(this);
            this.f55647i.setAdapter(this.f55652n);
        } else {
            RestaurantsListAdapter restaurantsListAdapter = new RestaurantsListAdapter(this, this.D);
            this.f55653o = restaurantsListAdapter;
            restaurantsListAdapter.setOnRestaurantClickListener(this);
            this.f55647i.setBackgroundColor(getResources().getColor(com.talabat.talabatcommon.R.color.white));
            this.f55647i.setAdapter(this.f55653o);
        }
        this.f55647i.addItemDecoration(new FreshVerticalSpaceItemDecoration(getResources(), true));
    }

    private void inject() {
        ApiContainer apiContainer = AndroidComponentsKt.apiContainer((Activity) this);
        DaggerQuickFilterRestaurantsActivityComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class)).inject(this);
    }

    private Boolean isTgoStyle() {
        return Boolean.valueOf(SharedPreferencesManager.getInstance(this).isCardViewFavStyle(Boolean.FALSE));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$darkstoreSuccess$2(Restaurant restaurant, View view) {
        navigateToDarkstores(restaurant);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$sendImpressionTrack$0(List list) {
        TalabatGTM.Companion.onShopListExpanded(this, this.filter.getSlug(), ImpresionTrackingMapperKt.incrementPosition(list));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$termsResponseSuccess$1(Dialog dialog, View view) {
        dialog.dismiss();
        AppTracker.termsAndConditionsClosed(this, this.filter.getSlug());
    }

    private void moveToMenu(int i11, int i12, boolean z11, boolean z12, boolean z13) {
        Navigator.Companion.navigate((Context) this, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity(i11, i12, z11, z12, z13));
    }

    private void navigateToDarkstores(Restaurant restaurant) {
        this.f55654p.updateSelectedRestaurant(restaurant);
        moveToMenu(restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated);
    }

    private void sendAppTrack(RestaurantListModel restaurantListModel) {
        sendAppTrack(restaurantListModel, "");
    }

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public abstract void buildHeader(QuickFilter quickFilter);

    public void darkstoreFailure() {
        this.f55658t.setVisibility(8);
    }

    public void darkstoreSuccess(Restaurant restaurant) {
        this.f55658t.setVisibility(0);
        this.f55658t.setOnClickListener(new f(this, restaurant));
        Glide.with((FragmentActivity) this).load(restaurant.getTalabatCoverLogo()).into(this.f55659u);
        Glide.with((FragmentActivity) this).load(restaurant.getLogo()).into(this.f55660v);
        this.f55661w.setText(restaurant.deliveryTime);
        this.f55662x.setText(restaurant.f13873name);
        int i11 = restaurant.statusType;
        if (i11 == 2 || i11 == 1 || i11 == 5) {
            this.f55663y.setVisibility(0);
            int i12 = restaurant.statusType;
            if (i12 == 1) {
                this.A.setText(getResources().getText(com.talabat.localization.R.string.closed_tgo));
            } else if (i12 == 2) {
                this.A.setText(getResources().getText(com.talabat.localization.R.string.busy_tgo));
            } else if (i12 == 5) {
                this.A.setText(getResources().getText(com.talabat.localization.R.string.open_for_preorder));
            }
        } else {
            this.f55663y.setVisibility(8);
        }
        AppTracker.onDarkStoresShown(this, this.filter.getWidgetName(), restaurant);
    }

    public void gaOnRestaurantsClicked(Restaurant restaurant) {
        String str;
        String slug = this.filter.getSlug();
        PolygonEvents polygonEvents = this.f55655q;
        if (SharedPreferencesManager.getInstance(this).isCardViewFavStyle(Boolean.FALSE)) {
            str = "card_view";
        } else {
            str = "list_view";
        }
        AppTracker.onRestaurantsClicked(this, restaurant, "", "", "", slug, "", "", polygonEvents, str, (HashMap<String, String>) null, this.shopClickedOriginSource, b.l(GlobalDataModel.SELECTED.restaurant.f13872id).booleanValue(), "shop_list:channel");
    }

    public abstract int getLayout();

    public void handleCollectionsFilterCancelled() {
        this.f55654p.handleFilterCancel();
    }

    public void handleCollectionsFilterSelection(List<SelectablePopularFilter> list) {
        this.f55654p.handleFilterSelection(list);
    }

    public void handleCuisineSelection() {
        this.f55654p.handleCuisineSelection();
    }

    public void hideDailyTalabatLoading() {
        CardView cardView = this.f55657s;
        if (cardView != null) {
            cardView.setVisibility(8);
            this.f55656r.stopShimmerAnimation();
        }
    }

    public void hideVendorsLoading() {
        this.B.setVisibility(0);
        this.f55664z.setVisibility(8);
    }

    public abstract void initHeader();

    public void navigateToRestaurantsSearchActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("ARG_FROM_ACTIVITY", "collections");
        bundle.putParcelable("ARG_QUICK_FILTER", this.filter);
        bundle.putParcelable("ARG_POLYGON_EVENT", this.f55655q);
        Navigator.Companion.navigate((Context) this, new NavigatorModel(SdSquadActions.ACTION_SEARCH_ACTIVITY, bundle));
    }

    public void navigateToVendorSeachActivity(@Nullable Integer num) {
        int lastFavVerticalId = SharedPreferencesManager.getInstance(this).getLastFavVerticalId();
        Bundle bundle = new Bundle();
        bundle.putInt("verticalId", lastFavVerticalId);
        bundle.putInt("collectionId", this.filter.getId().intValue());
        if (num != null) {
            bundle.putInt("cuisineId", num.intValue());
        }
        Navigator.Companion.navigate((Context) this, new NavigatorModel("com.talabat.VendorListSearchFlutterActivity", bundle));
    }

    public void onBackPressed() {
        sendAppTrack(this.f55654p.getCurrentCollectionRestaurants());
        if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(GlobalConstants.ExtraNames.ISFROMDEEPLINK, true);
            Navigator.Companion.navigate((Context) this, new NavigatorModel(SdSquadActions.ACTION_SDSQUAD_LISTING_SCREEN, bundle));
        }
        finish();
    }

    public void onClick(View view) {
        QuickFilter quickFilter;
        int id2 = view.getId();
        if (this.f55654p != null && (quickFilter = this.filter) != null && quickFilter.getId() != null) {
            if (id2 == R.id.linearLayout_search) {
                AppTracker.onSearchClicked(this, ScreenNames.QUICK_FILTER_RESTAURANTS_SCREEN, "search");
                this.f55654p.onSearchClick();
            } else if (id2 == R.id.button_termsAndCondition) {
                this.f55654p.getTerms(this.filter.getId().intValue());
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("QuickFilterRestaurantsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "QuickFilterRestaurantsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "QuickFilterRestaurantsActivity#onCreate", (ArrayList<String>) null);
        }
        inject();
        super.onCreate(bundle);
        try {
            if (getIntent() != null && getIntent().hasExtra(ARG_VERTICAL_ID)) {
                this.E = getIntent().getIntExtra(ARG_VERTICAL_ID, 0);
            }
            if (getIntent().getExtras() != null && getIntent().getExtras().containsKey("verticalType")) {
                this.verticalType = getIntent().getExtras().getString("verticalType");
            }
            if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(ARG_IS_DIRECTLY_FROM_HOME)) {
                this.isNavigatedFromHomeCollection = Boolean.valueOf(getIntent().getExtras().getBoolean(ARG_IS_DIRECTLY_FROM_HOME));
            }
            setContentView(getLayout());
            this.filter = (QuickFilter) getIntent().getParcelableExtra("ARG_QUICK_FILTER");
            this.f55655q = (PolygonEvents) getIntent().getParcelableExtra("ARG_POLYGON_EVENT");
            this.f55654p = new QuickFilterRestaurantsPresenter(QuickFilterInteractorFactory.INSTANCE.makeInteractor(this.filter, Schedulers.io(), AndroidSchedulers.mainThread(), this.C, this.E, this.isNavigatedFromHomeCollection.booleanValue()), this, new QuickFilterRestaurantsListenerImpl(this));
            initHeader();
            buildHeader(this.filter);
            initUI();
            this.f55651m.setVisibility(0);
            new CollectionsCuisineBinder().accept(this);
            if (this.filter != null) {
                new CollectionsFiltersBinder().accept(this, this.filter.getId().intValue());
            }
            this.f55654p.onStart(this.filter);
        } catch (Exception e11) {
            LogManager.error(e11, Log.getStackTraceString(e11));
            finish();
        }
        QuickFilter quickFilter = this.filter;
        if (quickFilter == null) {
            finish();
            TraceMachine.exitMethod();
            return;
        }
        if (quickFilter.getDeepLink() != null && this.filter.getDeepLink().equalsIgnoreCase("grocery")) {
            AppTracker.groceryCollectionLoaded(this);
        }
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        IQuickFilterRestaurantsPresenter iQuickFilterRestaurantsPresenter = this.f55654p;
        if (iQuickFilterRestaurantsPresenter != null) {
            iQuickFilterRestaurantsPresenter.onDestroy();
        }
    }

    public void onFallback() {
        this.f55654p.getDarkStoresInfo();
    }

    public void onProductClicked(@NotNull String str, String str2) {
        Restaurant restaurantFromString;
        if (!str2.isEmpty() && (restaurantFromString = getRestaurantFromString(str2)) != null) {
            DarkstoresDelegate.Companion.onDarkstoresClicked(this, restaurantFromString, 1, str, false, false);
        }
    }

    public void onRestaurantClick(Restaurant restaurant, int i11) {
        restaurant.itemPosition = i11 + 1;
        this.f55654p.updateSelectedRestaurant(restaurant);
        moveToMenu(restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated);
        CollectionsDetailsIntegrator.INSTANCE.updateTrackingChannel().invoke(getShopListTrigger());
        gaOnRestaurantsClicked(restaurant);
    }

    public void onResume() {
        String str;
        super.onResume();
        if (this.f55654p.isComingFromMenu()) {
            ArrayList<Restaurant> allCollectionRestaurants = this.f55654p.getAllCollectionRestaurants();
            String slug = this.filter.getSlug();
            String slug2 = this.filter.getSlug();
            int recommendedQuantity = getRecommendedQuantity(this.f55654p.getCurrentCollectionRestaurants());
            String sb2 = getShopIds(this.f55654p.getCurrentCollectionRestaurants()).toString();
            PolygonEvents polygonEvents = this.f55655q;
            SharedPreferencesManager instance = SharedPreferencesManager.getInstance(this);
            Boolean bool = Boolean.FALSE;
            if (instance.isCardViewFavStyle(bool)) {
                str = "card_view";
            } else {
                str = "list_view";
            }
            AppTracker.onRestaurantListLoaded(this, allCollectionRestaurants, slug, "", slug2, "", false, recommendedQuantity, 0, sb2, polygonEvents, str, (HashMap<String, String>) null, "", bool);
        }
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void onViewAllClicked(String str) {
        Restaurant restaurantFromString;
        if (!str.isEmpty() && (restaurantFromString = getRestaurantFromString(str)) != null) {
            navigateToDarkstores(restaurantFromString);
        }
    }

    public void sendImpressionTrack(RestaurantListModel restaurantListModel) {
        if (restaurantListModel != null && restaurantListModel.getAllRestaurants() != null) {
            RecyclerView recyclerView = this.f55647i;
            ImpressionsIntegrationKt.trackImpressionsExclusively(recyclerView, new BatchImpressionTracker(recyclerView, ImpresionTrackingMapperKt.mapToImpressionTracking(restaurantListModel.getAllRestaurants()), new g(this)));
        }
    }

    public void setIsSearchEnabled(boolean z11) {
        this.f55648j.setEnabled(z11);
        this.f55648j.setClickable(z11);
        if (z11) {
            this.f55648j.setAlpha(1.0f);
        } else {
            this.f55648j.setAlpha(0.25f);
        }
    }

    public void showDailyTalabatLoading() {
        CardView cardView = this.f55657s;
        if (cardView != null) {
            cardView.setVisibility(0);
            this.f55656r.startShimmerAnimation();
        }
    }

    public void showNoRestaurantsFound() {
        this.f55647i.setVisibility(8);
        this.f55650l.setVisibility(0);
    }

    public void showRestaurantsFound() {
        this.f55647i.setVisibility(0);
        this.f55650l.setVisibility(8);
    }

    public void showVendorsLoading() {
        this.B.setVisibility(8);
        this.f55664z.setVisibility(0);
    }

    public void termsResponseSuccess(String str) {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.collections_dialog_terms_and_conditions);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i11 = (int) (((double) displayMetrics.heightPixels) * 0.5d);
        dialog.getWindow().setLayout((int) (((double) displayMetrics.widthPixels) * 0.98d), i11);
        dialog.getWindow().setBackgroundDrawableResource(17170445);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(false);
        WebView webView = (WebView) dialog.findViewById(R.id.webview_terms);
        webView.loadDataWithBaseURL((String) null, str, NetworkLog.HTML, "utf-8", (String) null);
        webView.setWebViewClient(new WebViewClient() {
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                dialog.show();
            }
        });
        ((ImageButton) dialog.findViewById(R.id.imageButton_close)).setOnClickListener(new h(this, dialog));
        AppTracker.termsAndConditionsClicked(this, this.filter.getSlug());
    }

    public void updateCollectionsCuisinesFromRestaurants() {
        this.f55654p.updateCuisines();
    }

    public void updateRestaurantList(RestaurantListModel restaurantListModel) {
        this.f55647i.setLayoutManager(new LinearLayoutManager(this));
        if (isTgoStyle().booleanValue()) {
            this.f55652n.setRestaurantListModel(restaurantListModel);
        } else {
            this.f55653o.setRestaurantListModel(restaurantListModel, this.E);
        }
        sendImpressionTrack(restaurantListModel);
        sendAppTrack(restaurantListModel);
    }

    private void sendAppTrack(RestaurantListModel restaurantListModel, String str) {
        StringBuilder shopIds = getShopIds(restaurantListModel);
        AppTracker.onRestaurantListUpdated(this, this.f55654p.getAllCollectionRestaurants(), this.verticalType, this.f55654p.getChannelIndex(this.filter), this.filter.getSlug(), getShopListTrigger(), false, 0, getRecommendedQuantity(restaurantListModel), true, shopIds.toString(), this.f55655q, SharedPreferencesManager.getInstance(this).isCardViewFavStyle(Boolean.FALSE) ? "card_view" : "list_view", (HashMap<String, String>) null, this.shopClickedOriginSource, str);
    }
}
