package com.talabat;

import JsonModels.Response.BinTokenRM;
import JsonModels.Response.PreviousOrderList.PreviousOrder;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.ReviewWithRatingModel;
import JsonModels.parser.UniversalGson;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.TransitionManager;
import buisnessmodels.Cart;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.adapters.previousorders.PreviousOrderAdapter;
import com.talabat.adapters.previousorders.PreviousOrderListener;
import com.talabat.busypopup.BusyPopupBottomSheet;
import com.talabat.busypopup.BusyPopupDialogFragmentCallbacks;
import com.talabat.components.gem.menu.GemMenuFooterViewBinder;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.squads.menu.MenuScreenPerformanceParams;
import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.common.helpers.EventDataHelper;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.designhelpers.LoadingHelper.BallPulseIndicator;
import com.talabat.designhelpers.LoadingHelper.Indicator;
import com.talabat.designhelpers.LoadingHelper.LoadingIndicatorView;
import com.talabat.di.restaurant.DaggerRestaurantMenuScreenRComponent;
import com.talabat.dialogs.ParallelBinDialog;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.fragments.OffersListDialogFragment;
import com.talabat.gem.adapters.analytics.GemPageType;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.helpers.BaseRatingBar;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.helpers.SliderAnimationEffect;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.homescreen.widget.BaseHomeHorizontalRecyclerViewLayout;
import com.talabat.itemdetailsbottomsheet.ItemDetailsBottomSheet;
import com.talabat.itemdetailsbottomsheet.ItemDetailsCallbacks;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.ViewStatus;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.helpers.RatingDataMapperV2;
import com.talabat.talabatcommon.helpers.TalabatGlideModule;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import datamodels.CartMenuItem;
import datamodels.ChoiceSection;
import datamodels.ContinuousMenuListModel;
import datamodels.MenuItem;
import datamodels.MenuListModel;
import datamodels.MenuSection;
import datamodels.OffersItem;
import datamodels.RatingSection;
import datamodels.Restaurant;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.restaurantmenu.IRestaurantMenuScreenPresenterR;
import library.talabat.mvp.restaurantmenu.RestaurantMenuScreenView;
import library.talabat.mvp.restaurantmenu.RestaurantMeuScreenPresenterR;
import library.talabat.mvp.restaurantreview.IRestaurantReviewPresenter;
import library.talabat.mvp.restaurantreview.RestaurantReviewPresenter;
import library.talabat.mvp.restaurantreview.RestaurantReviewView;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.ScreenNames;
import tracking.gtm.TalabatGTM;
import ue.ad;
import ue.bd;
import ue.cd;
import ue.dd;
import ue.ed;
import ue.fd;
import ue.gd;
import ue.hd;
import ue.id;
import ue.jd;
import ue.kd;
import ue.ld;
import ue.md;
import ue.nd;
import ue.od;
import ue.pd;
import ue.qd;
import ue.rd;
import ue.td;
import ue.ud;
import ue.vd;
import xq.b;

@Instrumented
@GemPageType("shop_details")
public class RestaurantMenuScreenR extends TalabatBase implements RestaurantScreenInterator, RestaurantReviewView, RestaurantMenuScreenView, MiniCartLayout.OnCartClickListener, View.OnClickListener, PreviousOrderListener, BusyPopupDialogFragmentCallbacks, ItemDetailsCallbacks, GemAccessor {
    private static boolean ANIMATION_REQUIRED = true;
    private static int CART_COUNT = -1;
    private static int ITEM_POSITION = -1;
    private static final int RESULT_COUNT = 5;
    /* access modifiers changed from: private */
    public static boolean notRequired = false;
    @Inject
    public ISubscriptionsFeatureFlagsRepository A;
    private ImageView back;
    private boolean binViewClosed = false;
    private int calculatedHeightForContentView;
    private View categoriesView;
    private final BroadcastReceiver closeActivityReceiver = new CloseMenuBroadcastReceiver();
    private ImageView closeBinNotificationView;
    private ImageView closeCategoriesIcon;
    private View closeCategoriesView;
    private View contentView;
    /* access modifiers changed from: private */
    public ContinuousMenuListModel continuousMenuListModel;
    private ImageView deliverImageView;
    /* access modifiers changed from: private */
    public ImageView extraTextWarning;
    private boolean fromGlobalSearch = false;
    private int fullScreenHeight;
    private MenuItem globalMenuItem;

    /* renamed from: i  reason: collision with root package name */
    public View f54951i;
    private boolean isAreaChoosen;
    private RecyclerView itemsRecyclerView;

    /* renamed from: j  reason: collision with root package name */
    public MenuListModel f54952j;

    /* renamed from: k  reason: collision with root package name */
    public Handler f54953k;

    /* renamed from: l  reason: collision with root package name */
    public Runnable f54954l;
    /* access modifiers changed from: private */
    public LinearLayoutManager linearLayoutManager;

    /* renamed from: m  reason: collision with root package name */
    public int f54955m;
    private AppBarLayout mAppBar;
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayoutRestaurantInfo;
    private RestaurantReview mRestaurantReview;
    private IRestaurantReviewPresenter mReviewPresenter;
    private ImageView menuCategoriesIcon;
    private MenuCategoryAdapter menuCategoryAdapter;
    /* access modifiers changed from: private */
    public RecyclerView menuRecyclerView;
    private MenuRecyclerViewAdapter menuRecyclerViewAdapter;
    /* access modifiers changed from: private */
    public IRestaurantMenuScreenPresenterR menuScreenPresenter;
    private MiniCartLayout miniCartLayout;

    /* renamed from: n  reason: collision with root package name */
    public int f54956n;
    private TextView newDeliveryTime;
    private TextView newDescription;
    private View newInfoView;
    /* access modifiers changed from: private */
    public TextView newOffersContent;
    /* access modifiers changed from: private */
    public View newOffersMore;
    private View newOffersView;
    private ImageView newRatingImage;
    private View newRestaurantInfoSection;
    private TextView newRestaurantName;
    private TextView newReviewsContent;
    private View newReviewsMore;
    private TextView newWarning;

    /* renamed from: o  reason: collision with root package name */
    public ParallelBinDialog f54957o = null;

    /* renamed from: p  reason: collision with root package name */
    public PreviousOrderAdapter f54958p;
    private View parallelBInSeparator;
    private boolean parallelBinDataReceived = false;
    /* access modifiers changed from: private */
    public ImageView parallelBinImage;
    private View parallelBinImageView;
    private TextView parallelBinMore;
    /* access modifiers changed from: private */
    public ProgressBar parallelBinProgressBar;
    private View parallelBinView;
    private TextView parallelText;
    private View parentView;
    private RecyclerView previousOrderList;
    private BaseHomeHorizontalRecyclerViewLayout previousOrderView;

    /* renamed from: q  reason: collision with root package name */
    public ViewGroup f54959q;

    /* renamed from: r  reason: collision with root package name */
    public ActivityResultLauncher<Intent> f54960r;
    private int requiredHeight;
    /* access modifiers changed from: private */
    public ImageView restaurantImg;

    /* renamed from: s  reason: collision with root package name */
    public ActivityResultLauncher<Intent> f54961s;
    private ImageView searchIcon;
    private View showMenuCategories;
    private BaseRatingBar starRating;
    private TextView statusText;
    /* access modifiers changed from: private */
    public View statusView;

    /* renamed from: t  reason: collision with root package name */
    public TalabatTracker f54962t;
    private ConstraintLayout tProSubscriptionHeaderView;
    private TProVendorMovView tProVendorMovView;
    /* access modifiers changed from: private */
    public TabLayout tabLayout;
    private TextView talabatGoTextView;
    public Toast toast = null;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    public AppVersionProvider f54963u;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public ConfigurationLocalRepository f54964v;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public LocationConfigurationRepository f54965w;
    private View warningSection;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public PaymentConfigurationRepository f54966x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public ITalabatFeatureFlag f54967y;
    @Inject

    /* renamed from: z  reason: collision with root package name */
    public CustomerRepository f54968z;

    public class CloseMenuBroadcastReceiver extends BroadcastReceiver {
        private CloseMenuBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(GlobalConstants.BROADCAST_KILL_MENU)) {
                RestaurantMenuScreenR.this.finish();
            }
        }
    }

    public class MenuCategoryAdapter extends RecyclerView.Adapter<MenuCategoryViewHolderViewHolder> {
        private Context mContext;
        private ArrayList<Pair<String, Integer>> restaurantMenuSections;

        public class MenuCategoryViewHolderViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public View f54997h;

            /* renamed from: i  reason: collision with root package name */
            public TextView f54998i;

            /* renamed from: j  reason: collision with root package name */
            public TextView f54999j;

            public MenuCategoryViewHolderViewHolder(View view) {
                super(view);
                this.f54997h = view.findViewById(R.id.parent_row_view);
                this.f54998i = (TextView) view.findViewById(R.id.category_title);
                this.f54999j = (TextView) view.findViewById(R.id.items_count);
            }
        }

        public MenuCategoryAdapter(Context context, ArrayList<Pair<String, Integer>> arrayList) {
            this.mContext = context;
            this.restaurantMenuSections = arrayList;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i11, View view) {
            RestaurantMenuScreenR.this.onItemSelected(i11);
        }

        public int getItemCount() {
            ArrayList<Pair<String, Integer>> arrayList = this.restaurantMenuSections;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        public void onBindViewHolder(MenuCategoryViewHolderViewHolder menuCategoryViewHolderViewHolder, int i11) {
            Pair pair = this.restaurantMenuSections.get(i11);
            menuCategoryViewHolderViewHolder.f54998i.setText((CharSequence) pair.first);
            TextView textView = menuCategoryViewHolderViewHolder.f54999j;
            textView.setText(pair.second + "");
            menuCategoryViewHolderViewHolder.f54997h.setOnClickListener(new td(this, i11));
        }

        public MenuCategoryViewHolderViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new MenuCategoryViewHolderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_category_row, viewGroup, false));
        }
    }

    private boolean adjustStatusIconsTint(boolean z11) {
        View decorView = getWindow().getDecorView();
        if (z11) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
            return true;
        }
        decorView.setSystemUiVisibility(0);
        return false;
    }

    @NotNull
    private ViewTreeObserver.OnGlobalLayoutListener bottomViewChangeListener(final View view) {
        return new ViewTreeObserver.OnGlobalLayoutListener() {
            @NotNull
            private ViewTreeObserver.OnGlobalLayoutListener menuRecyclerViewChangeListener() {
                return new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        if (RestaurantMenuScreenR.this.menuRecyclerView != null) {
                            RestaurantMenuScreenR.this.menuRecyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            RestaurantMenuScreenR.this.menuRecyclerView.setPadding(0, 0, 0, view.getMeasuredHeight());
                        }
                    }
                };
            }

            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (RestaurantMenuScreenR.this.menuRecyclerView != null) {
                    RestaurantMenuScreenR.this.menuRecyclerView.getViewTreeObserver().addOnGlobalLayoutListener(menuRecyclerViewChangeListener());
                }
            }
        };
    }

    private void configureTheView() {
        String str;
        try {
            if (this.menuScreenPresenter != null) {
                initVariables();
                ArrayList<MenuSection> restaurantMenuSections = this.menuScreenPresenter.getRestaurantMenuSections();
                if (this.menuScreenPresenter.getmRestaurant() == null || restaurantMenuSections == null || restaurantMenuSections.isEmpty()) {
                    if (this.menuScreenPresenter.getmRestaurant() == null) {
                        ObservabilityManager.trackUnExpectedScenario("menuScreenPresenter.restaurant is null. isGemActive = " + isGemActive(), this.menuScreenPresenter.getAttributes());
                    }
                    if (restaurantMenuSections == null) {
                        ObservabilityManager.trackUnExpectedScenario("menuScreenPresenter.getRestaurantMenuSections returned null. isGemActive = " + isGemActive(), this.menuScreenPresenter.getAttributes());
                    }
                    if (restaurantMenuSections != null && restaurantMenuSections.isEmpty()) {
                        ObservabilityManager.trackUnExpectedScenario("menuScreenPresenter.getRestaurantMenuSections is empty. isGemActive = " + isGemActive(), this.menuScreenPresenter.getAttributes());
                    }
                } else if (!this.f54967y.getFeatureFlag(PlatformFeatureFlagsKeys.TRACKING_LIBRARY_MIGRATION, false)) {
                    AppTracker appTracker = new AppTracker(new TalabatGTM());
                    Restaurant restaurant = this.menuScreenPresenter.getmRestaurant();
                    boolean hasIconForAllItems = this.menuScreenPresenter.hasIconForAllItems();
                    String menuSectionNamesForGA = getMenuSectionNamesForGA(restaurantMenuSections);
                    IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
                    appTracker.onRestaurantInfoLoaded(this, restaurant, hasIconForAllItems, menuSectionNamesForGA, restaurantMenuSections, iRestaurantMenuScreenPresenterR.getCountOfItemsWithImages(iRestaurantMenuScreenPresenterR.getMenuItemsResponseModel()), this.menuScreenPresenter.getRestaurantMenuItems((ArrayList<MenuSection>) null).size(), "N/A");
                } else if (GlobalDataModel.SELECTED.restaurant != null) {
                    TalabatTracker talabatTracker = this.f54962t;
                    Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                    String screenName = getScreenName();
                    boolean hasIconForAllItems2 = this.menuScreenPresenter.hasIconForAllItems();
                    String menuSectionNamesForGA2 = getMenuSectionNamesForGA(restaurantMenuSections);
                    IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR2 = this.menuScreenPresenter;
                    talabatTracker.track(new ShopDetailsLoadedEvent(false, restaurant2, (String) null, screenName, false, hasIconForAllItems2, menuSectionNamesForGA2, restaurantMenuSections, iRestaurantMenuScreenPresenterR2.getCountOfItemsWithImages(iRestaurantMenuScreenPresenterR2.getMenuItemsResponseModel()), this.menuScreenPresenter.getRestaurantMenuItems((ArrayList<MenuSection>) null).size(), "N/A", new EventDataHelper()));
                }
                if (isGemActive()) {
                    withGemAnalytics().onMenuLoaded();
                }
                setUpValues();
                initContinuousScrollingView();
                return;
            }
            ObservabilityManager.trackUnExpectedScenario("menuScreenPresenter is null. isGemActive = " + isGemActive(), new HashMap());
        } catch (Exception e11) {
            if (TalabatUtils.isNullOrEmpty(e11.getMessage())) {
                str = "configureTheView() exception, cause not available. isGemActive = " + isGemActive();
            } else {
                str = "configureTheView() exception. isGemActive = " + isGemActive() + " " + e11.getMessage();
            }
            ObservabilityManager.trackUnExpectedScenario(str, this.menuScreenPresenter.getAttributes());
        }
    }

    private String getImageUrl() {
        String replaceAll = GlobalDataModel.PARALLELBIN.commonIconUrl.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "VoucherCampaign/" + replaceAll;
    }

    private String getMenuSectionNamesForGA(ArrayList<MenuSection> arrayList) {
        if (arrayList == null || arrayList.size() == 0 || arrayList.size() <= 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<MenuSection> it = arrayList.iterator();
        while (it.hasNext()) {
            MenuSection next = it.next();
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(next.f13864name);
        }
        return sb2.toString().trim();
    }

    private boolean getParallelBinNotificationShown() {
        return getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getBoolean("ParallelBinCampaignStatus", false);
    }

    private int getReviews() {
        try {
            return Integer.parseInt(this.menuScreenPresenter.getmRestaurant().getTotalRating());
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private void goToBackScreen() {
        if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            startActivity(new Intent(this, HomeScreenActivity.class));
        } else {
            GlobalDataModel.backFromMenuToList = true;
        }
        GlobalDataModel.PARALLELBIN.reset();
        finish();
    }

    private void goToCart() {
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_BUSY_BOTTOM_SHEET, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.menuScreenPresenter.getShopStatus();
        } else {
            openCartScreen();
        }
    }

    private void handleMenuFooter() {
        Map map;
        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
        if (iRestaurantMenuScreenPresenterR == null || iRestaurantMenuScreenPresenterR.getmRestaurant() == null) {
            ViewStatus viewStatus = ViewStatus.HIDDEN;
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR2 = this.menuScreenPresenter;
            if (iRestaurantMenuScreenPresenterR2 != null) {
                map = iRestaurantMenuScreenPresenterR2.getAttributes();
            } else {
                map = new HashMap();
            }
            ObservabilityManager.trackEvent("RestaurantMenuScreenR", "RestaurantMenuMiniCart", viewStatus, (Map<String, String>) map);
            return;
        }
        Restaurant restaurant = this.menuScreenPresenter.getmRestaurant();
        if (Cart.getInstance() == null || Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().getId() != restaurant.getId()) {
            this.miniCartLayout.showMiniCart(0, restaurant.getDisplayDeliveryCharges(), restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), restaurant.isSubscriptionAvailable());
        } else {
            this.miniCartLayout.showMiniCart(Cart.getInstance().getCartCount(), restaurant.getDisplayDeliveryCharges(), restaurant.getDisplayMinimumAmount(), Cart.getInstance().getCartSubTotalDisplayPrice(), restaurant.isSubscriptionAvailable());
        }
    }

    private void handleWithChoiceActivityResult(Intent intent) {
        String str;
        String stringExtra = intent.getStringExtra("specialRequest");
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.QUANTITY, 1);
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.globalMenuItem);
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("selectedChoices");
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                createWithMenuItem.setSelectedChoicesForSection((ChoiceSection) it.next());
            }
            createWithMenuItem.allChoices = arrayList;
        }
        createWithMenuItem.specialRequest = stringExtra;
        createWithMenuItem.setQuantity(intExtra);
        Cart.getInstance().setRestaurant(GlobalDataModel.SELECTED.getRestaurant(), this);
        Cart.getInstance().addItem(createWithMenuItem, this);
        ArrayList<ChoiceSection> arrayList2 = createWithMenuItem.selectedChoices;
        if (arrayList2 != null) {
            str = TalabatUtils.getChoicesString(arrayList2);
        } else {
            str = "";
        }
        String str2 = str;
        if (GlobalDataModel.SELECTED.getRestaurant() != null) {
            AppTracker.onItemAddedToCart(this, Cart.getInstance().getRestaurant(), createWithMenuItem, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.getRestaurant()), "product_choice", str2, createWithMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], createWithMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(getScreenName()), getScreenName());
        }
    }

    private void handleWithoutChoiceActivityResult(Intent intent) {
        String stringExtra = intent.getStringExtra("specialRequest");
        int intExtra = intent.getIntExtra(FirebaseAnalytics.Param.QUANTITY, 1);
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.globalMenuItem);
        createWithMenuItem.specialRequest = stringExtra;
        createWithMenuItem.setQuantity(intExtra);
        onAddToBasketClicked(createWithMenuItem);
    }

    private void initContinuousScrollingView() {
        ArrayList<MenuSection> restaurantMenuSections = this.menuScreenPresenter.getRestaurantMenuSections();
        this.tabLayout.removeAllTabs();
        this.tabLayout.setSmoothScrollingEnabled(true);
        for (int i11 = 0; i11 < restaurantMenuSections.size(); i11++) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.continuous_scroll_tab_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.section_name);
            String str = restaurantMenuSections.get(i11).f13864name;
            if (!isGemActive() && (restaurantMenuSections.get(i11).isDiscounted || restaurantMenuSections.get(i11).showPercentage())) {
                str = str + "  %";
            }
            textView.setText(str);
            TabLayout tabLayout2 = this.tabLayout;
            tabLayout2.addTab(tabLayout2.newTab().setCustomView(inflate), i11);
        }
        ArrayList<MenuItem> restaurantMenuItems = this.menuScreenPresenter.getRestaurantMenuItems(restaurantMenuSections);
        this.continuousMenuListModel = new ContinuousMenuListModel();
        if (restaurantMenuSections.size() > 0 && restaurantMenuItems != null && restaurantMenuItems.size() > 0) {
            this.menuRecyclerView.setHasFixedSize(false);
            this.menuRecyclerView.setNestedScrollingEnabled(true);
            LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
            this.linearLayoutManager = linearLayoutManager2;
            linearLayoutManager2.setOrientation(1);
            this.menuRecyclerView.setLayoutManager(this.linearLayoutManager);
            this.continuousMenuListModel.createMenuDisplayModel(restaurantMenuSections, restaurantMenuItems);
            MenuRecyclerViewAdapter menuRecyclerViewAdapter2 = new MenuRecyclerViewAdapter(this.continuousMenuListModel);
            this.menuRecyclerViewAdapter = menuRecyclerViewAdapter2;
            this.menuRecyclerView.setAdapter(menuRecyclerViewAdapter2);
            this.menuRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                    int i13;
                    super.onScrolled(recyclerView, i11, i12);
                    int findFirstVisibleItemPosition = RestaurantMenuScreenR.this.linearLayoutManager.findFirstVisibleItemPosition();
                    View findViewByPosition = RestaurantMenuScreenR.this.linearLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
                    if (RestaurantMenuScreenR.this.linearLayoutManager.getItemViewType(findViewByPosition) == 1) {
                        i13 = RestaurantMenuScreenR.this.menuScreenPresenter.getPositionForMenuSection((MenuSection) RestaurantMenuScreenR.this.continuousMenuListModel.getMenuItemModelItemAtIndex(findFirstVisibleItemPosition).data);
                    } else {
                        i13 = -1;
                    }
                    if (RestaurantMenuScreenR.this.linearLayoutManager.getItemViewType(findViewByPosition) == 2) {
                        i13 = RestaurantMenuScreenR.this.menuScreenPresenter.getPositionForMenuSection(RestaurantMenuScreenR.this.menuScreenPresenter.getMenuSectionForItem(((MenuItem) RestaurantMenuScreenR.this.continuousMenuListModel.getMenuItemModelItemAtIndex(findFirstVisibleItemPosition).data).menuSectionId));
                    }
                    RestaurantMenuScreenR.notRequired = true;
                    RestaurantMenuScreenR.this.scrollTabToPosition(i13);
                    RestaurantMenuScreenR.notRequired = false;
                    if (RestaurantMenuScreenR.this.linearLayoutManager.findLastCompletelyVisibleItemPosition() == RestaurantMenuScreenR.this.continuousMenuListModel.getLastItemPosition() && RestaurantMenuScreenR.this.tabLayout.getSelectedTabPosition() != RestaurantMenuScreenR.this.menuScreenPresenter.getRestaurantMenuSections().size() - 1) {
                        i13 = RestaurantMenuScreenR.this.menuScreenPresenter.getRestaurantMenuSections().size() - 1;
                        RestaurantMenuScreenR.notRequired = true;
                        RestaurantMenuScreenR.this.scrollTabToPosition(i13);
                        RestaurantMenuScreenR.notRequired = false;
                    }
                    if (i13 > -1 && i13 != RestaurantMenuScreenR.this.tabLayout.getSelectedTabPosition()) {
                        ObservabilityManager.trackUnExpectedScenario("POTENTIAL SCROLL ISSUE -> requiredTabPosition = " + i13 + " and selectedTabPosition is " + RestaurantMenuScreenR.this.tabLayout.getSelectedTabPosition(), new HashMap());
                    }
                }
            });
            this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
                public void onTabReselected(TabLayout.Tab tab) {
                }

                public void onTabSelected(TabLayout.Tab tab) {
                    int positionOfMenuSection = RestaurantMenuScreenR.this.continuousMenuListModel.getPositionOfMenuSection(RestaurantMenuScreenR.this.menuScreenPresenter.getMenuSectionForPosition(tab.getPosition()));
                    if (!RestaurantMenuScreenR.notRequired) {
                        RestaurantMenuScreenR.this.scrollRecyclerviewToPosition(positionOfMenuSection);
                    } else if (RestaurantMenuScreenR.notRequired) {
                        RestaurantMenuScreenR.notRequired = false;
                    }
                }

                public void onTabUnselected(TabLayout.Tab tab) {
                }
            });
        }
    }

    private void initItemDetailsRevampTest(boolean z11) {
        GlobalDataModel.Apptimize.itemDetailsHeaderVariant = TalabatExperiment.INSTANCE.getIntVariant(com.talabat.core.experiment.data.TalabatExperimentConstants.ITEM_DETAILS_REVAMP_VERSION, 1, TalabatExperimentDataSourceStrategy.APPTIMIZE);
        if (z11) {
            GlobalDataModel.Apptimize.itemDetailsHeaderVariant = GlobalConstants.ITEMDETAILS.staticHeaderWithChoicesAndProgressBar;
        }
    }

    private void initializeMenuScreen() {
        int intExtra;
        this.menuScreenPresenter = new RestaurantMeuScreenPresenterR(this.f54963u, this, this.f54967y, TalabatExperiment.INSTANCE, this.f54964v, this.f54965w, this.f54966x, this.f54968z);
        this.mReviewPresenter = new RestaurantReviewPresenter(this.f54963u, this);
        this.f54952j = new MenuListModel();
        this.mReviewPresenter.loadRestaurantReview(this.menuScreenPresenter.getBranchId(), 1);
        b.m(this.menuScreenPresenter.getmRestaurant().getId());
        configureTheView();
        observeApiResponses();
        AppTracker.onNewMenuOpened(this, true);
        if (getIntent() != null && getIntent().hasExtra(NavigationMethodChannel.TOSCREEN)) {
            if (getIntent().getStringExtra(NavigationMethodChannel.TOSCREEN).equals("search")) {
                String stringExtra = getIntent().getStringExtra("searchTerm");
                if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                    startActivity(new Intent(this, MenuSearchActivity.class).putExtra("searchTerm", stringExtra));
                }
            } else if (getIntent().hasExtra("itemId") && (intExtra = getIntent().getIntExtra("itemId", -1)) > -1) {
                MenuItem restaurantMenuItem = this.menuScreenPresenter.getRestaurantMenuItem(intExtra);
                if (restaurantMenuItem.f13861id == intExtra) {
                    this.globalMenuItem = restaurantMenuItem;
                    onMenuItemClick(restaurantMenuItem, -1, false);
                }
            }
        }
    }

    private void killCart() {
        sendBroadcast(new Intent(GlobalConstants.BROADCAST_KILL_CART));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$2(CollapsingToolbarLayout collapsingToolbarLayout, AppBarLayout appBarLayout, int i11) {
        float abs = ((float) Math.abs(i11)) / ((float) appBarLayout.getTotalScrollRange());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        float f11 = 1.0f - abs;
        sb2.append(f11);
        if (f11 == 0.0f) {
            this.mLinearLayoutRestaurantInfo.setAlpha(f11);
            collapsingToolbarLayout.setContentScrimColor(getResources().getColor(R.color.white));
            if (adjustStatusIconsTint(true)) {
                this.mLinearLayoutRestaurantInfo.setVisibility(4);
            }
        } else {
            this.mLinearLayoutRestaurantInfo.setAlpha(1.0f);
            this.mLinearLayoutRestaurantInfo.setVisibility(0);
            transparentStatusAndNavigation();
        }
        this.newRestaurantInfoSection.setVisibility(0);
        this.toolbarTitle.setAlpha(abs);
        if (((float) (Math.abs(i11) - appBarLayout.getTotalScrollRange())) == 0.0f) {
            this.f54951i.setBackgroundResource(17170445);
        }
        if (abs == 0.0f && this.parallelBinDataReceived && !getParallelBinNotificationShown()) {
            AppTracker.onBinNotificationShown(this, getScreenName());
            setParallelBinNotificationShown();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$3(View view) {
        goToBackScreen();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$4(View view) {
        AppTracker.onSearchButtonClicked(this, this.menuScreenPresenter.getmRestaurant().areaName, ScreenNames.getScreenType(getScreenName()));
        startActivity(new Intent(this, MenuSearchActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$5(View view, View view2) {
        this.binViewClosed = true;
        animateView(view, true);
        stopBinTimer();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$6(View view) {
        showMenuCategoriesPopup();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$7(View view) {
        this.showMenuCategories.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$observeApiResponses$15(ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            this.previousOrderView.setVisibility(0);
            this.previousOrderView.handleListSubmit(arrayList.isEmpty(), true);
            this.f54958p.submitList(arrayList);
        } else if (this.previousOrderView != null) {
            hidePreviousOrderList();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$observeApiResponses$16(Pair pair) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        if (pair != null) {
            String str7 = (String) pair.first;
            String str8 = (String) pair.second;
            if (!TalabatUtils.isNullOrEmpty(str7) && !TalabatUtils.isNullOrEmpty(str8)) {
                str2 = getString(R.string.some_items_unavailable);
                if (str7.contains("###")) {
                    str5 = getString(R.string.are);
                } else {
                    str5 = getString(R.string.f54879is);
                }
                if (str8.contains("###")) {
                    str6 = getString(R.string.are);
                } else {
                    str6 = getString(R.string.f54879is);
                }
                String replace = str7.replace("###", getResources().getString(R.string.and));
                str = getString(R.string.items_with_without_choices).replace("#1#", replace).replace("#2#", str5).replace("#3#", str8.replace("###", getResources().getString(R.string.and))).replace("#4#", str6);
            } else if (!TalabatUtils.isNullOrEmpty(str7)) {
                str2 = getString(R.string.unavailable_items);
                if (str7.contains("###")) {
                    str4 = getString(R.string.are);
                } else {
                    str4 = getString(R.string.f54879is);
                }
                str = getString(R.string.previous_items_not_available).replace("#1#", str7.replace("###", getResources().getString(R.string.and))).replace("#2#", str4);
            } else if (!TalabatUtils.isNullOrEmpty(str8)) {
                str2 = getString(R.string.unable_to_add_items);
                if (str8.contains("###")) {
                    str3 = getString(R.string.are);
                } else {
                    str3 = getString(R.string.f54879is);
                }
                str = getString(R.string.previous_items_with_choices).replace("#1#", str8.replace("###", getResources().getString(R.string.and))).replace("#2#", str3);
            } else {
                str2 = "";
                str = str2;
            }
            if (!TalabatUtils.isNullOrEmpty(str)) {
                showAlert(str2, str);
            }
            this.menuScreenPresenter.clearErrorData();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$observeApiResponses$17(Boolean bool) {
        String str;
        String str2;
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            this.menuScreenPresenter.clearShowBusyPopup();
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
            if (iRestaurantMenuScreenPresenterR != null) {
                if (iRestaurantMenuScreenPresenterR.isRestaurantTGO()) {
                    str = getResources().getString(R.string.shop_busy_main_text_tgo);
                } else {
                    str = getResources().getString(R.string.shop_busy_main_text_tmp).replace(RichContentLoadTimeRecorder.DELIMETER, this.menuScreenPresenter.getRestuarantName());
                }
                String str3 = str;
                if (this.menuScreenPresenter.isRestaurantTGO()) {
                    str2 = getResources().getString(R.string.shop_busy_second_text_tgo);
                } else {
                    str2 = getResources().getString(R.string.shop_busy_second_text_tmp);
                }
                AppTracker.onBusyBottomSheetOpened(this, this.menuScreenPresenter.getmRestaurant(), ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
                BusyPopupBottomSheet.Companion.newInstance(this.menuScreenPresenter.getCuisine(), 0, this.menuScreenPresenter.canCallApi(), 5, str3, str2, getResources().getString(R.string.view_similar_restaurants), this).showDialog(getSupportFragmentManager(), "busy popup bottom sheet dialog");
                return;
            }
            return;
        }
        openCartScreen();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(ActivityResult activityResult) {
        Intent data;
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
            handleWithoutChoiceActivityResult(data);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(ActivityResult activityResult) {
        Intent data;
        if (activityResult.getResultCode() == -1 && (data = activityResult.getData()) != null) {
            handleWithChoiceActivityResult(data);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onParallelBinAvailable$12(View view) {
        if (this.f54957o == null) {
            this.f54957o = new ParallelBinDialog();
        }
        if (!this.f54957o.isVisible()) {
            this.f54957o.showDialog(getSupportFragmentManager(), "Parallel Bin Dialog");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollRecyclerviewToPosition$14(int i11) {
        this.linearLayoutManager.scrollToPositionWithOffset(i11, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollTabToPosition$13(int i11) {
        TabLayout.Tab tabAt = this.tabLayout.getTabAt(i11);
        if (tabAt != null) {
            tabAt.select();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpValues$10(View view) {
        this.closeCategoriesIcon.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpValues$11(View view) {
        this.closeCategoriesIcon.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpValues$8(View view) {
        String str;
        GlobalDataModel.OFFERS.offersList = this.menuScreenPresenter.getRestaurantOffers();
        Gson gson = UniversalGson.INSTANCE.gson;
        ArrayList<OffersItem> restaurantOffers = this.menuScreenPresenter.getRestaurantOffers();
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) restaurantOffers);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) restaurantOffers);
        }
        OffersListDialogFragment.Companion.newInstance(str, getString(R.string.available_offers)).show(getSupportFragmentManager(), "offerslistdialog");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpValues$9(View view) {
        if (this.contentView.getVisibility() == 0) {
            slideDown();
        }
    }

    private void navigateToItemDetailsScreen(CartMenuItem cartMenuItem) {
        GlobalDataModel.SELECTED.cartMenuItem = cartMenuItem;
        if (GlobalDataModel.Apptimize.itemDetailsHeaderVariant == GlobalConstants.ITEMDETAILS.noRevamp || !cartMenuItem.hasChoices()) {
            startActivity(new Intent(this, ItemDetailsActivity.class));
        } else {
            startActivity(new Intent(this, ItemDetailsRevampedActivity.class));
            overridePendingTransition(R.anim.activity_slide_from_bottom, R.anim.nothing);
        }
        stopLodingPopup();
    }

    private void observeApiResponses() {
        this.menuScreenPresenter.getPreviousOrderList().observe(this, new dd(this));
        this.menuScreenPresenter.getErrorData().observe(this, new ed(this));
        this.menuScreenPresenter.getShowBusyPopup().observe(this, new fd(this));
    }

    /* access modifiers changed from: private */
    public void onItemSelected(int i11) {
        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
        if (iRestaurantMenuScreenPresenterR != null) {
            AppTracker.onCategorySelected(this, iRestaurantMenuScreenPresenterR.getRestaurantMenuSections().get(i11).f13864name);
        }
        notRequired = false;
        this.closeCategoriesIcon.performClick();
        scrollTabToPosition(i11);
    }

    /* access modifiers changed from: private */
    public void onMenuImageClicked(MenuItem menuItem, ImageView imageView, int i11) {
        GlobalDataModel.MENU.menuItem = menuItem;
        onMenuItemClick(menuItem, -1, false);
    }

    private void openItemDetailsBottomSheet() {
        ItemDetailsBottomSheet.Companion.newInstance(CartMenuItem.createWithMenuItem(this.globalMenuItem), GlobalDataModel.SELECTED.restaurant.shouldDisableSpecialRequest(), this).showDialog(getSupportFragmentManager(), "busy popup bottom sheet dialog");
    }

    private void removeObservers() {
        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
        if (iRestaurantMenuScreenPresenterR != null) {
            iRestaurantMenuScreenPresenterR.getErrorData().removeObservers(this);
            this.menuScreenPresenter.getPreviousOrderList().removeObservers(this);
            this.menuScreenPresenter.getShowBusyPopup().removeObservers(this);
            return;
        }
        ObservabilityManager.trackUnExpectedScenario("menuScreenPresenter is null. isGemActive = " + isGemActive(), new HashMap());
    }

    /* access modifiers changed from: private */
    public void scrollRecyclerviewToPosition(int i11) {
        runOnUiThread(new jd(this, i11));
    }

    /* access modifiers changed from: private */
    public void scrollTabToPosition(int i11) {
        runOnUiThread(new ad(this, i11));
    }

    private void setBroadcastReceiver() {
        registerReceiver(this.closeActivityReceiver, new IntentFilter(GlobalConstants.BROADCAST_KILL_MENU));
    }

    private void setColor(TextView textView, String str, String str2, int i11) {
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.indexOf(str2);
        spannableString.setSpan(new ForegroundColorSpan(i11), indexOf, str2.length() + indexOf, 33);
        textView.setText(spannableString);
    }

    private void setDeliveryInfo() {
        String str;
        String str2 = " (" + this.menuScreenPresenter.getmRestaurant().getDisplayDeliveryCharges() + " " + getResources().getString(R.string.delivery).toLowerCase() + ")";
        if (this.menuScreenPresenter == null) {
            this.menuScreenPresenter = new RestaurantMeuScreenPresenterR(this.f54963u, this, this.f54967y, TalabatExperiment.INSTANCE, this.f54964v, this.f54965w, this.f54966x, this.f54968z);
        }
        if (!this.menuScreenPresenter.isRestaurantOpenForPreorder()) {
            str = getResources().getString(R.string.within) + " " + this.menuScreenPresenter.getRestaurantDeliveryTime() + str2;
        } else if (TalabatUtils.isNullOrEmpty(this.menuScreenPresenter.getRestaurantOpeningTime())) {
            str = getResources().getString(R.string.within) + " " + this.menuScreenPresenter.getRestaurantDeliveryTime() + str2;
        } else {
            String restaurantOpeningTime = this.menuScreenPresenter.getRestaurantOpeningTime();
            if (restaurantOpeningTime.contains("and")) {
                restaurantOpeningTime = this.menuScreenPresenter.getRestaurantOpeningTime().replace("and", getResources().getString(R.string.and));
            }
            str = getResources().getString(R.string.opens_at) + " " + restaurantOpeningTime + str2;
        }
        TextView textView = this.newDeliveryTime;
        if (textView != null) {
            setColor(textView, str, str2, getResources().getColor(R.color.neutral_grey));
        }
    }

    private void setUpValues() {
        TextView textView;
        this.newRestaurantName.setText(this.menuScreenPresenter.getRestuarantName());
        if (this.menuScreenPresenter.isRestaurantOpen()) {
            this.statusView.setVisibility(8);
        } else if (this.menuScreenPresenter.isRestaurantClosed()) {
            this.statusView.setVisibility(0);
            this.statusText.setText(getResources().getText(R.string.closed_tgo));
        } else if (this.menuScreenPresenter.isRestaurantBusy()) {
            this.statusView.setVisibility(0);
            this.statusText.setText(getResources().getText(R.string.busy_tgo));
        } else if (this.menuScreenPresenter.isRestaurantOpenForPreorder()) {
            this.statusView.setVisibility(0);
            this.statusText.setText(getResources().getText(R.string.open_for_preorder));
        }
        if (isValidContextForGlide(this)) {
            GlideApp.with((FragmentActivity) this).clear((View) this.restaurantImg);
            GlideApp.with((FragmentActivity) this).load(this.menuScreenPresenter.getHeroImage()).centerInside().addListener((RequestListener) new RequestListener<Drawable>() {
                public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                    return false;
                }

                public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                    RestaurantMenuScreenR restaurantMenuScreenR = RestaurantMenuScreenR.this;
                    restaurantMenuScreenR.showViewWithAnimation(restaurantMenuScreenR.restaurantImg);
                    return false;
                }
            }).into(this.restaurantImg);
        }
        this.newDescription.setText(this.menuScreenPresenter.getRestaurantCuisines());
        setRate(this.menuScreenPresenter.getRestaurantRating(), this.menuScreenPresenter.getRestaurantTotalRating());
        setDeliveryInfo();
        if (this.menuScreenPresenter.getDeliveryTImeInteger() > 30 || this.menuScreenPresenter.getDeliveryTImeInteger() <= 0) {
            this.deliverImageView.setImageResource(R.drawable.ic_m_delivery_bike);
        } else {
            this.deliverImageView.setImageResource(R.drawable.ic_rocket_filled);
        }
        if (!(GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId() || (textView = this.talabatGoTextView) == null)) {
            textView.setVisibility(8);
        }
        if (this.menuScreenPresenter.getRestaurantOffers().size() > 0 && !isGemActive()) {
            this.newOffersView.setVisibility(0);
            final String str = this.menuScreenPresenter.getRestaurantOffers().get(0).title;
            this.newOffersContent.setText(str);
            this.newOffersContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    RestaurantMenuScreenR.this.newOffersContent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    boolean z11 = !RestaurantMenuScreenR.this.newOffersContent.getLayout().getText().toString().equalsIgnoreCase(str);
                    if (RestaurantMenuScreenR.this.menuScreenPresenter.getRestaurantOffers().size() > 1 || z11) {
                        RestaurantMenuScreenR.this.newOffersMore.setVisibility(0);
                    } else {
                        RestaurantMenuScreenR.this.newOffersMore.setVisibility(8);
                    }
                }
            });
        }
        this.newOffersMore.setOnClickListener(new qd(this));
        this.menuRecyclerView.setVisibility(0);
        this.tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorSecondary));
        this.tabLayout.setTabGravity(0);
        this.tabLayout.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.tab_layout_height));
        this.itemsRecyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        linearLayoutManager2.setOrientation(1);
        this.itemsRecyclerView.setLayoutManager(linearLayoutManager2);
        this.menuCategoryAdapter = new MenuCategoryAdapter(this, this.menuScreenPresenter.getRestaurantMenuSectionsAndItemCount());
        this.itemsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.itemsRecyclerView.setAdapter(this.menuCategoryAdapter);
        this.closeCategoriesIcon.setOnClickListener(new rd(this));
        this.closeCategoriesView.setOnClickListener(new bd(this));
        if (this.menuScreenPresenter.getRestaurantMenuSectionsAndItemCount() != null && this.menuScreenPresenter.getRestaurantMenuSectionsAndItemCount().size() > 9) {
            int i11 = Resources.getSystem().getDisplayMetrics().heightPixels;
            this.fullScreenHeight = i11;
            int i12 = (i11 * 30) / 100;
            this.requiredHeight = i12;
            this.calculatedHeightForContentView = i11 - i12;
            this.contentView.getLayoutParams().height = this.calculatedHeightForContentView;
        }
        this.categoriesView.setOnClickListener(new cd(this));
    }

    private void setWindowFlag(int i11, boolean z11) {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (z11) {
            attributes.flags = i11 | attributes.flags;
        } else {
            attributes.flags = (~i11) & attributes.flags;
        }
        window.setAttributes(attributes);
    }

    private void showAlert(String str, String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        if (!TalabatUtils.isNullOrEmpty(str)) {
            builder.setTitle((CharSequence) str);
        }
        builder.setMessage((CharSequence) str2);
        builder.setPositiveButton((int) R.string.ok_btn, (DialogInterface.OnClickListener) null);
        builder.setCancelable(false);
        builder.show();
    }

    private void showItemAddedIndicatorAndUpdateQuantityCount() {
        MenuRecyclerViewAdapter menuRecyclerViewAdapter2 = this.menuRecyclerViewAdapter;
        if (menuRecyclerViewAdapter2 != null) {
            int i11 = ITEM_POSITION;
            if (i11 > -1) {
                menuRecyclerViewAdapter2.notifyItemChanged(i11, ProductAction.ACTION_ADD);
            } else {
                menuRecyclerViewAdapter2.notifyDataSetChanged();
            }
        }
    }

    private void showMenuCategoriesPopup() {
        if (this.categoriesView.getVisibility() != 0) {
            slideUp();
        }
    }

    /* access modifiers changed from: private */
    public void showRestaurantSummaryPopup() {
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setTitle((CharSequence) getResources().getString(R.string.disclaimer)).setMessage((CharSequence) this.menuScreenPresenter.getRestaurantWarning().trim().replaceAll("(\\s){2,}", " ").replaceAll("(\\n){2,}", StringUtils.LF)).setCancelable(true).create().show();
    }

    private void showStarRate(float f11) {
        if (TalabatExperiment.INSTANCE.getBooleanVariant(com.talabat.core.experiment.data.TalabatExperimentConstants.CAN_SHOW_STAR_RATING, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.newRatingImage.setVisibility(8);
            this.starRating.setVisibility(0);
            this.starRating.setRating(f11);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.newReviewsContent.getLayoutParams();
            layoutParams.addRule(17, R.id.rate_stars);
            this.newReviewsContent.setLayoutParams(layoutParams);
            int reviews = getReviews();
            if (reviews <= 0) {
                setColor(this.newReviewsContent, getString(R.string.not_rated), getString(R.string.not_rated), ContextCompat.getColor(this, R.color.neutral_grey));
                this.newReviewsMore.setVisibility(8);
                return;
            }
            String quantityString = getResources().getQuantityString(R.plurals.numberOfRatings, reviews, new Object[]{Integer.valueOf(reviews)});
            setColor(this.newReviewsContent, f11 + " " + quantityString, quantityString, ContextCompat.getColor(this, R.color.neutral_grey));
        }
    }

    /* access modifiers changed from: private */
    public void showViewWithAnimation(View view) {
        if (ANIMATION_REQUIRED && view != null) {
            view.setAlpha(0.2f);
            view.setVisibility(0);
            view.animate().alpha(1.0f).setDuration(950).setListener((Animator.AnimatorListener) null);
        }
    }

    /* access modifiers changed from: private */
    public void showWebView(String str) {
        Intent intent = new Intent(this, TWebViewScreen.class);
        intent.putExtra("url", str);
        intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, "");
        startActivity(intent);
    }

    private void transparentStatusAndNavigation() {
        getWindow().getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        setWindowFlag(67108864, false);
        getWindow().setStatusBarColor(0);
    }

    public ViewTreeObserver.OnGlobalLayoutListener adjustMenuListPadding(View view) {
        ViewTreeObserver.OnGlobalLayoutListener bottomViewChangeListener = bottomViewChangeListener(view);
        view.getViewTreeObserver().addOnGlobalLayoutListener(bottomViewChangeListener);
        return bottomViewChangeListener;
    }

    public void animateView(final View view, boolean z11) {
        if (z11) {
            SliderAnimationEffect sliderAnimationEffect = new SliderAnimationEffect(view, 500, 1);
            sliderAnimationEffect.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationEnd(Animation animation) {
                    view.setVisibility(8);
                }

                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                    view.setVisibility(0);
                }
            });
            view.startAnimation(sliderAnimationEffect);
            return;
        }
        SliderAnimationEffect sliderAnimationEffect2 = new SliderAnimationEffect(view, 1000, 0);
        sliderAnimationEffect2.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view.startAnimation(sliderAnimationEffect2);
    }

    public void cartButtonClicked() {
        goToCart();
    }

    public void cartCountChanged() {
        showSnackBar();
    }

    public void destroyPresenter() {
    }

    public String getDisplayAmountForEmptyCart() {
        return TalabatFormatter.getInstance().getFormattedCurrency(0.0f);
    }

    public /* synthetic */ Map getGemComponentState() {
        return b.a(this);
    }

    public /* synthetic */ String getGemRemainingSecondsText() {
        return b.b(this);
    }

    public /* synthetic */ String getGemSelectedRestaurantPositionText() {
        return b.c(this);
    }

    public /* synthetic */ String getGemSelectedTierIndexText() {
        return b.d(this);
    }

    public IGlobalPresenter getPresenter() {
        return this.menuScreenPresenter;
    }

    public String getScreenName() {
        return ScreenNames.RESTAURANTMENU;
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void hidePreviousOrderList() {
        this.previousOrderView.setVisibility(8);
    }

    @VisibleForTesting
    public void initVariables() {
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        if (TalabatUtils.isRTL()) {
            this.tabLayout.setLayoutDirection(1);
        }
        this.mLinearLayoutRestaurantInfo = (LinearLayout) findViewById(R.id.linearLayout_restaurantInfo);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbarTitle = (TextView) findViewById(R.id.title);
        this.restaurantImg = (ImageView) findViewById(R.id.restaurant_logo);
        this.talabatGoTextView = (TextView) findViewById(R.id.tv_to_go);
        View findViewById = findViewById(R.id.new_reviews_more);
        this.newReviewsMore = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.new_info_text);
        this.newInfoView = findViewById2;
        findViewById2.setOnClickListener(this);
        MiniCartLayout miniCartLayout2 = (MiniCartLayout) findViewById(R.id.miniCart);
        this.miniCartLayout = miniCartLayout2;
        miniCartLayout2.setClickListener(this);
        this.newWarning = (TextView) findViewById(R.id.new_restaurant_warning);
        this.warningSection = findViewById(R.id.linearLayout_restaurant_warning);
        this.newReviewsContent = (TextView) findViewById(R.id.new_reviews_content);
        this.newRatingImage = (ImageView) findViewById(R.id.new_reviews_image);
        this.extraTextWarning = (ImageView) findViewById(R.id.extra_text_warning);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapseToolBar);
        this.mAppBar = (AppBarLayout) findViewById(R.id.appbar);
        View findViewById3 = findViewById(R.id.bin_view);
        this.closeBinNotificationView = (ImageView) findViewById(R.id.close_bin_view);
        this.back = (ImageView) findViewById(R.id.back);
        this.searchIcon = (ImageView) findViewById(R.id.search_icon);
        this.deliverImageView = (ImageView) findViewById(R.id.new_delivery_time_image);
        this.statusView = findViewById(R.id.status_view);
        this.statusText = (TextView) findViewById(R.id.new_status_text);
        collapsingToolbarLayout.setTitleEnabled(false);
        this.isAreaChoosen = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.AREA_CHOOSED, true);
        this.f54951i = findViewById(R.id.ll_header);
        int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.f54955m = i11;
        this.f54956n = (i11 * 77) / 100;
        this.parentView = findViewById(R.id.rl_container);
        this.toolbar.setTitle((CharSequence) " ");
        this.toolbarTitle.setText(this.menuScreenPresenter.getRestuarantName());
        this.newRestaurantInfoSection = findViewById(R.id.new_restaurant_info_section);
        this.newRestaurantName = (TextView) findViewById(R.id.new_restaurant_name);
        this.newDescription = (TextView) findViewById(R.id.new_restaurant_description);
        this.newDeliveryTime = (TextView) findViewById(R.id.delivery_time_text);
        this.parallelBInSeparator = findViewById(R.id.parallel_bin_separator);
        BaseHomeHorizontalRecyclerViewLayout baseHomeHorizontalRecyclerViewLayout = (BaseHomeHorizontalRecyclerViewLayout) findViewById(R.id.previous_order_view);
        this.previousOrderView = baseHomeHorizontalRecyclerViewLayout;
        this.previousOrderList = (RecyclerView) baseHomeHorizontalRecyclerViewLayout.findViewById(R.id.rvHomeBaseHorizontal);
        PreviousOrderAdapter previousOrderAdapter = new PreviousOrderAdapter(this);
        this.f54958p = previousOrderAdapter;
        this.previousOrderList.setAdapter(previousOrderAdapter);
        this.starRating = (BaseRatingBar) findViewById(R.id.rate_stars);
        this.f54959q = (ViewGroup) findViewById(R.id.rl_container);
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new kd(this, collapsingToolbarLayout));
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        this.back.setOnClickListener(new ld(this));
        this.searchIcon.setOnClickListener(new md(this));
        findViewById3.setVisibility(8);
        this.closeBinNotificationView.setOnClickListener(new nd(this, findViewById3));
        this.menuScreenPresenter.getBinTokens();
        final TextView textView = this.newWarning;
        if (this.menuScreenPresenter.isRestaurantHasWarning()) {
            this.parallelBInSeparator.setVisibility(0);
            this.warningSection.setVisibility(0);
            textView.setText(this.menuScreenPresenter.getRestaurantWarning().trim().replaceAll("(\\s){2,}", " ").replaceAll("(\\n){2,}", StringUtils.LF));
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* access modifiers changed from: private */
                public /* synthetic */ void lambda$onGlobalLayout$0(String str, View view) {
                    if (RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.getAlpha() == 1.0f) {
                        RestaurantMenuScreenR.this.showWebView(str);
                    }
                }

                /* access modifiers changed from: private */
                public /* synthetic */ void lambda$onGlobalLayout$1(View view) {
                    if (RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.getAlpha() == 1.0f) {
                        RestaurantMenuScreenR.this.showRestaurantSummaryPopup();
                    }
                }

                public void onGlobalLayout() {
                    if (!TalabatUtils.isNullOrEmpty(RestaurantMenuScreenR.this.menuScreenPresenter.getRestaurantWarningURL().trim())) {
                        String trim = RestaurantMenuScreenR.this.menuScreenPresenter.getRestaurantWarningURL().trim();
                        RestaurantMenuScreenR.this.extraTextWarning.setVisibility(0);
                        textView.setMaxLines(1);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        textView.setFocusable(true);
                        textView.setOnClickListener(new q(this, trim));
                    } else if (textView.getLineCount() >= 2) {
                        textView.setOnClickListener(new s(this));
                        RestaurantMenuScreenR.this.extraTextWarning.setVisibility(0);
                        textView.setMaxLines(1);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                    } else {
                        RestaurantMenuScreenR.this.extraTextWarning.setVisibility(8);
                    }
                    final int i11 = (int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) / 2.5d);
                    RestaurantMenuScreenR.this.restaurantImg.getLayoutParams().height = i11;
                    RestaurantMenuScreenR.this.restaurantImg.requestLayout();
                    RestaurantMenuScreenR.this.statusView.getLayoutParams().height = i11;
                    RestaurantMenuScreenR.this.statusView.requestLayout();
                    RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        public void onGlobalLayout() {
                            RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.getLayoutParams();
                            layoutParams.setMargins(0, i11, 0, 0);
                            RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.setLayoutParams(layoutParams);
                            RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.requestLayout();
                        }
                    });
                    textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
            });
        } else {
            this.parallelBInSeparator.setVisibility(8);
            this.warningSection.setVisibility(8);
            final int i12 = (int) (((double) Resources.getSystem().getDisplayMetrics().widthPixels) / 2.5d);
            this.restaurantImg.getLayoutParams().height = i12;
            this.restaurantImg.requestLayout();
            this.statusView.getLayoutParams().height = i12;
            this.statusView.requestLayout();
            this.mLinearLayoutRestaurantInfo.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.getLayoutParams();
                    layoutParams.setMargins(0, i12, 0, 0);
                    RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.setLayoutParams(layoutParams);
                    RestaurantMenuScreenR.this.mLinearLayoutRestaurantInfo.requestLayout();
                }
            });
        }
        this.tProSubscriptionHeaderView = (ConstraintLayout) findViewById(R.id.subscription_header);
        if (!this.A.isTProEnabledForNFV() || !this.menuScreenPresenter.isRestaurantTPro()) {
            this.tProSubscriptionHeaderView.setVisibility(8);
        } else {
            this.tProSubscriptionHeaderView.setVisibility(0);
        }
        TProVendorMovView tProVendorMovView2 = (TProVendorMovView) findViewById(R.id.tpro_mov);
        this.tProVendorMovView = tProVendorMovView2;
        tProVendorMovView2.showTProMovIfApplicable(this.menuScreenPresenter.isRestaurantTPro(), this.menuScreenPresenter.getBranchId());
        this.categoriesView = findViewById(R.id.menu_categories_bottom_sheet);
        this.menuCategoriesIcon = (ImageView) findViewById(R.id.menu_categories_icon);
        this.contentView = findViewById(R.id.content_view);
        this.closeCategoriesIcon = (ImageView) findViewById(R.id.close_categories);
        this.closeCategoriesView = findViewById(R.id.close_categories_view);
        this.newOffersView = findViewById(R.id.new_offers_view);
        this.newOffersContent = (TextView) findViewById(R.id.new_offers_content);
        this.newOffersMore = findViewById(R.id.new_offers_more);
        this.itemsRecyclerView = (RecyclerView) findViewById(R.id.items_recyclerView);
        View findViewById4 = findViewById(R.id.menu_categories);
        this.showMenuCategories = findViewById4;
        findViewById4.setOnClickListener(new od(this));
        this.menuCategoriesIcon.setOnClickListener(new pd(this));
        this.menuRecyclerView = (RecyclerView) findViewById(R.id.menu_list);
        this.parallelBinView = findViewById(R.id.parallel_bin_view);
        this.parallelBinImageView = findViewById(R.id.parallel_bin_image_view);
        this.parallelBinImage = (ImageView) findViewById(R.id.parallel_bin_image);
        this.parallelBinProgressBar = (ProgressBar) findViewById(R.id.parallel_bin_image_progressBar);
        this.parallelText = (TextView) findViewById(R.id.parallel_bin_content);
        this.parallelBinMore = (TextView) findViewById(R.id.parallel_bin_more);
        this.menuScreenPresenter.getParallelBinData();
        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
        iRestaurantMenuScreenPresenterR.getPreviousOrderList(iRestaurantMenuScreenPresenterR.getBranchId());
    }

    public boolean isAreaChoosen() {
        return this.isAreaChoosen;
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public void navigateToMenuWithChoiceNativeScreen() {
        startLodingPopup();
        if (!this.globalMenuItem.isChoicesLoaded()) {
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
            if (iRestaurantMenuScreenPresenterR != null) {
                iRestaurantMenuScreenPresenterR.getChoiceSection(this.globalMenuItem.f13861id);
                return;
            }
            return;
        }
        onReadyToAddItem(this.globalMenuItem, false);
    }

    public void navigateToMenuWithoutChoiceNativeScreen() {
        openItemDetailsBottomSheet();
    }

    public void navigateToVendorInfoNativeScreen() {
        Intent intent = new Intent(this, RestaurantInfoActivity.class);
        intent.putExtra(GlobalConstants.ExtraNames.INFO_HERO_IMG, this.menuScreenPresenter.getHeroImage());
        startActivity(intent);
    }

    public void navigateToVendorReviewsNativeScreen() {
        startActivity(new Intent(this, RestaurantReviewActivity.class));
    }

    public void onAddToBasketClicked(@NotNull CartMenuItem cartMenuItem) {
        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
        iRestaurantMenuScreenPresenterR.addItem(iRestaurantMenuScreenPresenterR.getmRestaurant(), cartMenuItem, MenuScreenPerformanceParams.SCREEN_TYPE);
    }

    public void onAreaChoosed() {
        startActivity(new Intent(this, RestaurantMenuScreenR.class));
        this.isAreaChoosen = true;
        finish();
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        goToBackScreen();
    }

    public void onBinResponseReceived(BinTokenRM binTokenRM, String str) {
    }

    public void onBusyPopupClosed() {
        AppTracker.onBusyBottomSheetClosed(this, this.menuScreenPresenter.getmRestaurant(), ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
    }

    public void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel) {
        MenuItem menuItem = this.globalMenuItem;
        menuItem.choiceSections = splitChoiceItemModel.choiceSections;
        onReadyToAddItem(menuItem, true);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.new_info_text) {
            AppTracker.onTabInfoClicked(this, this.menuScreenPresenter.getmRestaurant());
            this.menuScreenPresenter.handleVendorInfoClick();
        } else if (id2 == R.id.new_reviews_more) {
            AppTracker.onTabReviewsClicked(this, this.menuScreenPresenter.getmRestaurant());
            this.menuScreenPresenter.handleVendorReviewsClick();
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        ApiContainer apiContainer = (ApiContainer) getApplication();
        this.f54962t = ((TrackingCoreLibApi) ((ApiContainer) getApplication()).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
        DaggerRestaurantMenuScreenRComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class)).inject(this);
        super.onCreate(bundle);
        try {
            setContentView((int) R.layout.resturant_menu_screen_r);
            initItemDetailsRevampTest(BuildConfig.IS_ALPHA.booleanValue());
            initializeMenuScreen();
            setBroadcastReceiver();
            new GemMenuFooterViewBinder().accept(this);
        } catch (Exception e11) {
            if (TalabatUtils.isNullOrEmpty(e11.getMessage())) {
                str = "Menu Screen Exception, cause not available";
            } else {
                str = "Menu Screen Exception, cause -> " + e11.getMessage();
            }
            ObservabilityManager.trackUnExpectedScenario(str, new HashMap());
            finish();
        }
        this.f54960r = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new gd(this));
        this.f54961s = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new hd(this));
    }

    public void onDestroy() {
        String str;
        removeObservers();
        super.onDestroy();
        try {
            unregisterReceiver(this.closeActivityReceiver);
        } catch (Exception e11) {
            if (TalabatUtils.isNullOrEmpty(e11.getMessage())) {
                str = "Menu Screen exception while unregistering broadcast receiver, cause not available";
            } else {
                str = "Menu Screen unregistering broadcast receiver issue, cause -> " + e11.getMessage();
            }
            ObservabilityManager.trackUnExpectedScenario(str, new HashMap());
        }
    }

    public void onError() {
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public void onItemAdded(CartMenuItem cartMenuItem) {
        showSingleToast();
        showItemAddedIndicatorAndUpdateQuantityCount();
        showSnackBar();
    }

    public void onMaxCartItemsReached() {
        Toast.makeText(this, getString(R.string.max_cart_items), 0).show();
    }

    public void onMenuItemClick(MenuItem menuItem, int i11, boolean z11) {
        ITEM_POSITION = i11;
        GlobalDataModel.MENU.AddToCartClicked = true;
        this.globalMenuItem = menuItem;
        if (menuItem.willHaveChoices()) {
            this.menuScreenPresenter.handleWithChoiceClick();
        } else if (!z11) {
            if (GlobalDataModel.MENU.AddToCartClicked) {
                GlobalDataModel.MENU.AddToCartClicked = false;
            }
            AppTracker.onProductClicked(this, CartMenuItem.createWithMenuItem(this.globalMenuItem), AppTracker.getRestaurantName(this.menuScreenPresenter.getmRestaurant()));
            GlobalDataModel.MENU.ChoiceClicked = false;
            this.menuScreenPresenter.handleMenuWithoutChoiceClick();
        } else {
            onReadyToAddItem(menuItem, z11);
        }
    }

    public void onNavigateToItemDetails(CartMenuItem cartMenuItem) {
        navigateToItemDetailsScreen(cartMenuItem);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        initializeMenuScreen();
        ANIMATION_REQUIRED = true;
        showViewWithAnimation(this.parentView);
    }

    public void onNoChoiceAvailable() {
        if (this.fromGlobalSearch) {
            stopLodingPopup();
        }
    }

    public void onParallelBinAvailable() {
        int i11;
        if (!isGemActive()) {
            TextView textView = this.parallelBinMore;
            if (GlobalDataModel.PARALLELBIN.moreBinModels.size() > 0) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            textView.setVisibility(i11);
            this.parallelBinMore.setOnClickListener(new id(this));
            if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.PARALLELBIN.commonMessage)) {
                this.parallelText.setVisibility(0);
                this.parallelText.setText(GlobalDataModel.PARALLELBIN.commonMessage);
            } else {
                this.parallelText.setVisibility(4);
            }
            if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.PARALLELBIN.commonIconUrl)) {
                this.parallelBinImageView.setVisibility(0);
                this.parallelBinProgressBar.setVisibility(0);
                String imageUrl = getImageUrl();
                if (isValidContextForGlide(this)) {
                    GlideApp.with((FragmentActivity) this).clear((View) this.parallelBinImage);
                    GlideApp.with((FragmentActivity) this).load(imageUrl).centerInside().listener((RequestListener) new RequestListener<Drawable>() {
                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                            RestaurantMenuScreenR.this.parallelBinImage.setImageResource(R.drawable.ic_promo);
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                            RestaurantMenuScreenR.this.parallelBinProgressBar.setVisibility(8);
                            return false;
                        }
                    }).into(this.parallelBinImage);
                }
            } else {
                this.parallelBinImageView.setVisibility(0);
                this.parallelBinImage.setImageResource(R.drawable.ic_promo);
                this.parallelBInSeparator.setVisibility(8);
            }
            this.parallelBinDataReceived = true;
            this.parallelBinView.setAlpha(0.0f);
            this.parallelBinView.setBackgroundColor(getResources().getColor(R.color.white));
            this.parallelText.setTextColor(getResources().getColor(R.color.promo));
            this.parallelBinView.setVisibility(0);
            this.parallelBinView.animate().alpha(1.0f).setDuration(600).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                }
            });
        }
    }

    public void onPause() {
        CART_COUNT = Cart.getInstance().getCartCount();
        super.onPause();
    }

    public void onReadyToAddItem(MenuItem menuItem, boolean z11) {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(menuItem);
        createWithMenuItem.setQuantity(1);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(this.menuScreenPresenter.getmRestaurant()));
        stopLodingPopup();
        if (z11) {
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
            iRestaurantMenuScreenPresenterR.addItem(iRestaurantMenuScreenPresenterR.getmRestaurant(), createWithMenuItem, MenuScreenPerformanceParams.SCREEN_TYPE);
        } else {
            navigateToItemDetailsScreen(createWithMenuItem);
        }
        GlobalDataModel.MENU.AddToCartClicked = false;
    }

    public void onReorderClicked(@NotNull PreviousOrder previousOrder) {
        showNonCancelableProgress();
        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
        iRestaurantMenuScreenPresenterR.addPreviousOrderItemsToCart(this, iRestaurantMenuScreenPresenterR.getmRestaurant(), previousOrder);
    }

    public void onResume() {
        String str;
        Map map;
        super.onResume();
        try {
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
            if (iRestaurantMenuScreenPresenterR != null && iRestaurantMenuScreenPresenterR.resetRequired()) {
                ANIMATION_REQUIRED = false;
                initializeMenuScreen();
            }
            if (Cart.getInstance().hasItems()) {
                showItemAddedIndicatorAndUpdateQuantityCount();
            }
            showSnackBar();
            adjustMenuListPadding(this.miniCartLayout);
            if (CART_COUNT != Cart.getInstance().getCartCount()) {
                showItemAddedIndicatorAndUpdateQuantityCount();
            }
            setDeliveryInfo();
            killCart();
        } catch (Exception e11) {
            if (TalabatUtils.isNullOrEmpty(e11.getMessage())) {
                str = "Menu Screen Exception in onResume, cause not available";
            } else {
                str = "Menu Screen Exception in onResume, cause -> " + e11.getMessage();
            }
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR2 = this.menuScreenPresenter;
            if (iRestaurantMenuScreenPresenterR2 != null) {
                map = iRestaurantMenuScreenPresenterR2.getAttributes();
            } else {
                map = new HashMap();
            }
            ObservabilityManager.trackUnExpectedScenario(str, map);
        }
    }

    public void onReviewLoadingCompleted(RestaurantReviewPaging[] restaurantReviewPagingArr, int i11, int i12, RatingSection ratingSection, ReviewWithRatingModel reviewWithRatingModel) {
        RestaurantReview restaurantReview = new RestaurantReview();
        this.mRestaurantReview = restaurantReview;
        restaurantReview.rev = restaurantReviewPagingArr;
        restaurantReview.ratingSection = ratingSection;
        restaurantReview.totalPages = i11;
        restaurantReview.totalReviews = i12;
        GlobalDataModel.REVIEWS.mRestaurantReviews = restaurantReview;
    }

    public void onShopClicked(Restaurant restaurant, int i11) {
        if (restaurant != null) {
            AppTracker.onBusyBottomSheetRecommendedRestaurantClicked(this, this.menuScreenPresenter.getmRestaurant(), ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            Navigator.Companion.navigate((Context) this, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity(restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated));
            return;
        }
        ObservabilityManager.trackUnExpectedScenario("Restaurant busy from busy popup", this.menuScreenPresenter.getAttributes());
    }

    public void onStart() {
        super.onStart();
        handleMenuFooter();
    }

    public void onStop() {
        ITEM_POSITION = -1;
        CART_COUNT = -1;
        super.onStop();
    }

    public void openCartScreen() {
        startActivity(new Intent(this, CartScreen.class));
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public void setParallelBinNotificationShown() {
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putBoolean("ParallelBinCampaignStatus", true);
        edit.apply();
    }

    public void setRate(float f11, String str) {
        String str2;
        String str3;
        ImageView imageView = this.newRatingImage;
        RatingDataMapperV2 ratingDataMapperV2 = RatingDataMapperV2.INSTANCE;
        imageView.setImageResource(ratingDataMapperV2.drawableResourceFromRating(f11));
        String string = getResources().getString(ratingDataMapperV2.textFromRating(f11));
        if (((double) f11) == 0.0d) {
            str2 = getResources().getString(R.string.not_rated);
            str3 = str2;
        } else {
            String replace = getResources().getString(R.string.info_rating_text).replace(RichContentLoadTimeRecorder.DELIMETER, "" + str);
            str3 = replace;
            str2 = string + " " + replace;
        }
        setColor(this.newReviewsContent, str2, str3, getResources().getColor(R.color.neutral_grey));
        showStarRate(f11);
    }

    public /* synthetic */ void showGemLandingPage() {
        vd.a(this);
    }

    public void showRestaurantChangePopup(final Restaurant restaurant, final CartMenuItem cartMenuItem) {
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.cart_will_be_cleared).replace("#", "\"" + instance.getRestaurant().f13873name + "\"");
        builder.setTitle((CharSequence) getString(R.string.start_new_cart));
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((CharSequence) getString(R.string.start), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                RestaurantMenuScreenR.this.menuScreenPresenter.changeRestaurantAndAddItem(RestaurantMenuScreenR.this, restaurant, cartMenuItem);
            }
        });
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showSingleToast() {
        try {
            if (!this.toast.getView().isShown()) {
                this.toast.show();
            }
        } catch (Exception unused) {
            Toast makeText = Toast.makeText(this, getResources().getString(R.string.items_successfully_added), 0);
            this.toast = makeText;
            makeText.show();
        }
    }

    public void showSnackBar() {
        handleMenuFooter();
    }

    public void slideDown() {
        AppTracker.onCategorySelectorClosed(this);
        this.categoriesView.setVisibility(4);
    }

    public void slideUp() {
        AppTracker.onCategorySelectorOpened(this);
        Slide slide = new Slide(80);
        slide.setDuration(600);
        slide.addTarget(this.categoriesView);
        TransitionManager.beginDelayedTransition(this.f54959q, slide);
        this.categoriesView.setVisibility(0);
    }

    public void stopBinTimer() {
        Handler handler;
        Runnable runnable = this.f54954l;
        if (runnable != null && (handler = this.f54953k) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void viewAllRestaurantsClicked() {
        AppTracker.onBusyBottomSheetViewAllClicked(this, this.menuScreenPresenter.getmRestaurant(), ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
        Navigator.Companion companion = Navigator.Companion;
        SdSquadActions.Companion companion2 = SdSquadActions.Companion;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(GlobalDataModel.RECENT_LATLONG.latitude);
        String str = "";
        sb2.append(str);
        String sb3 = sb2.toString();
        String str2 = GlobalDataModel.RECENT_LATLONG.longitude + str;
        int i11 = GlobalDataModel.SelectedAreaId;
        int i12 = GlobalDataModel.SelectedCityId;
        int i13 = GlobalDataModel.SelectedCountryId;
        if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName)) {
            str = GlobalDataModel.SelectedAreaName;
        }
        companion.navigate((Context) this, companion2.createNavigatorModelForListingScreen(sb3, str2, i11, i12, i13, str));
        finish();
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }

    public void showRestaurantChangePopup(final Restaurant restaurant, final PreviousOrder previousOrder) {
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.cart_will_be_cleared).replace("#", "\"" + instance.getRestaurant().f13873name + "\"");
        builder.setTitle((CharSequence) getString(R.string.start_new_cart));
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((CharSequence) getString(R.string.start), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                RestaurantMenuScreenR.this.menuScreenPresenter.changeRestaurantAndAddPreviousOrder(RestaurantMenuScreenR.this, restaurant, previousOrder);
            }
        });
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: i  reason: collision with root package name */
        public BallPulseIndicator f55001i;

        /* renamed from: j  reason: collision with root package name */
        public ContinuousMenuListModel f55002j;

        /* renamed from: k  reason: collision with root package name */
        public int f55003k = 0;

        public class MenuItemViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public TextView f55007h;

            /* renamed from: i  reason: collision with root package name */
            public TextView f55008i;

            /* renamed from: j  reason: collision with root package name */
            public TextView f55009j;

            /* renamed from: k  reason: collision with root package name */
            public TextView f55010k;

            /* renamed from: l  reason: collision with root package name */
            public TextView f55011l;

            /* renamed from: m  reason: collision with root package name */
            public TextView f55012m;

            /* renamed from: n  reason: collision with root package name */
            public ImageView f55013n;

            /* renamed from: o  reason: collision with root package name */
            public ImageView f55014o;

            /* renamed from: p  reason: collision with root package name */
            public View f55015p;

            /* renamed from: q  reason: collision with root package name */
            public View f55016q;

            /* renamed from: r  reason: collision with root package name */
            public View f55017r;

            /* renamed from: s  reason: collision with root package name */
            public View f55018s;

            /* renamed from: t  reason: collision with root package name */
            public View f55019t;

            /* renamed from: u  reason: collision with root package name */
            public ProgressBar f55020u;

            /* renamed from: v  reason: collision with root package name */
            public RelativeLayout f55021v;

            /* renamed from: w  reason: collision with root package name */
            public LoadingIndicatorView f55022w;

            public MenuItemViewHolder(View view) {
                super(view);
                this.f55017r = view.findViewById(R.id.view_separator);
                this.f55018s = view.findViewById(R.id.view_separator_shadowed);
                this.f55007h = (TextView) view.findViewById(R.id.itemName);
                this.f55008i = (TextView) view.findViewById(R.id.itemDescription);
                this.f55009j = (TextView) view.findViewById(R.id.itemPrice);
                this.f55013n = (ImageView) view.findViewById(R.id.itemImg);
                this.f55020u = (ProgressBar) view.findViewById(R.id.progress);
                this.f55014o = (ImageView) view.findViewById(R.id.discountIc);
                this.f55011l = (TextView) view.findViewById(R.id.priceExtraInfo);
                this.f55016q = view.findViewById(R.id.price_view);
                this.f55012m = (TextView) view.findViewById(R.id.priceBefore);
                this.f55021v = (RelativeLayout) view.findViewById(R.id.rootView);
                this.f55022w = (LoadingIndicatorView) view.findViewById(R.id.loading_price);
                this.f55015p = view.findViewById(R.id.image_holder);
                this.f55019t = view.findViewById(R.id.item_added_indicator);
                this.f55010k = (TextView) view.findViewById(R.id.item_quantity);
            }
        }

        public class SectionHeaderViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public TextView f55024h;

            /* renamed from: i  reason: collision with root package name */
            public View f55025i;

            public SectionHeaderViewHolder(View view) {
                super(view);
                this.f55024h = (TextView) view.findViewById(R.id.section_name);
                this.f55025i = view.findViewById(R.id.section_header_view);
            }
        }

        public MenuRecyclerViewAdapter(ContinuousMenuListModel continuousMenuListModel) {
            this.f55002j = continuousMenuListModel;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(MenuItem menuItem, MenuItemViewHolder menuItemViewHolder, int i11, View view) {
            RestaurantMenuScreenR.this.onMenuImageClicked(menuItem, menuItemViewHolder.f55013n, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(MenuItem menuItem, int i11, View view) {
            if (!GlobalDataModel.MENU.AddToCartClicked) {
                RestaurantMenuScreenR.this.onMenuItemClick(menuItem, i11, true);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(MenuItemViewHolder menuItemViewHolder, MenuItem menuItem, int i11, View view) {
            if (menuItemViewHolder.f55009j.getText().toString().equals(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.price, true))) {
                GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
            }
            if (!GlobalDataModel.MENU.ChoiceClicked) {
                RestaurantMenuScreenR.this.onMenuItemClick(menuItem, i11, false);
            }
        }

        public int getItemCount() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f55002j.getMenuListItemCount());
            sb2.append("");
            return this.f55002j.getMenuListItemCount();
        }

        public int getItemViewType(int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Position - ");
            sb2.append(i11);
            sb2.append(" Type - ");
            sb2.append(this.f55002j.getMenuItemModelItemAtIndex(i11).type);
            sb2.append("");
            return this.f55002j.getMenuItemModelItemAtIndex(i11).type;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11, List<Object> list) {
            if (list.isEmpty()) {
                super.onBindViewHolder(viewHolder, i11, list);
            } else if (RestaurantMenuScreenR.this.menuScreenPresenter != null && (viewHolder instanceof MenuItemViewHolder)) {
                MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) viewHolder;
                int isItemAddedToCart = RestaurantMenuScreenR.this.menuScreenPresenter.isItemAddedToCart((MenuItem) this.f55002j.getMenuItemModelItemAtIndex(i11).data);
                if (isItemAddedToCart > 0) {
                    menuItemViewHolder.f55019t.setVisibility(0);
                    menuItemViewHolder.f55010k.setVisibility(0);
                    menuItemViewHolder.f55010k.setText(String.format(Locale.US, RestaurantMenuScreenR.this.getString(R.string.quantity_text), new Object[]{Integer.valueOf(isItemAddedToCart)}));
                    return;
                }
                menuItemViewHolder.f55019t.setVisibility(8);
                menuItemViewHolder.f55010k.setVisibility(8);
            }
        }

        @NotNull
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            this.f55001i = new BallPulseIndicator();
            if (i11 == 1) {
                return new SectionHeaderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.countinuous_section_header, viewGroup, false));
            }
            if (i11 == 2) {
                return new MenuItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.countinuous_section_item_right_image_relative, viewGroup, false));
            }
            return null;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder instanceof SectionHeaderViewHolder) {
                ((SectionHeaderViewHolder) viewHolder).f55024h.setText(((MenuSection) this.f55002j.getMenuItemModelItemAtIndex(i11).data).f13864name);
                this.f55003k = i11 + 1;
            } else if (viewHolder instanceof MenuItemViewHolder) {
                final MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) viewHolder;
                MenuItem menuItem = (MenuItem) this.f55002j.getMenuItemModelItemAtIndex(i11).data;
                menuItemViewHolder.f55022w.setIndicator((Indicator) this.f55001i);
                menuItemViewHolder.f55022w.show();
                if (i11 == this.f55003k || (this.f55002j.getMenuItemModelItemAtIndex(i11 - 1).data instanceof MenuSection)) {
                    menuItemViewHolder.f55017r.setVisibility(8);
                } else {
                    menuItemViewHolder.f55017r.setVisibility(0);
                }
                menuItemViewHolder.f55007h.setText(menuItem.f13862name.trim());
                if (menuItem.desc.trim().equals("")) {
                    menuItemViewHolder.f55008i.setVisibility(8);
                } else {
                    menuItemViewHolder.f55008i.setText(menuItem.desc.trim());
                    menuItemViewHolder.f55008i.setVisibility(0);
                }
                if (!menuItem.isPromotional || RestaurantMenuScreenR.this.isGemActive()) {
                    menuItemViewHolder.f55014o.setVisibility(8);
                } else {
                    menuItemViewHolder.f55014o.setVisibility(0);
                }
                if (RestaurantMenuScreenR.this.menuScreenPresenter != null) {
                    int isItemAddedToCart = RestaurantMenuScreenR.this.menuScreenPresenter.isItemAddedToCart(menuItem);
                    if (isItemAddedToCart > 0) {
                        menuItemViewHolder.f55019t.setVisibility(0);
                        menuItemViewHolder.f55010k.setVisibility(0);
                        menuItemViewHolder.f55010k.setText(String.format(Locale.US, RestaurantMenuScreenR.this.getString(R.string.quantity_text), new Object[]{Integer.valueOf(isItemAddedToCart)}));
                    } else {
                        menuItemViewHolder.f55019t.setVisibility(8);
                        menuItemViewHolder.f55010k.setVisibility(8);
                    }
                }
                if (menuItem.getDisplayPrice().equals("0")) {
                    menuItemViewHolder.f55011l.setVisibility(0);
                    menuItemViewHolder.f55011l.setText(RestaurantMenuScreenR.this.getString(R.string.price_based_on_selection));
                    menuItemViewHolder.f55016q.setVisibility(8);
                    menuItemViewHolder.f55012m.setVisibility(8);
                } else {
                    menuItemViewHolder.f55011l.setVisibility(8);
                    menuItemViewHolder.f55016q.setVisibility(0);
                    menuItemViewHolder.f55012m.setVisibility(8);
                    menuItemViewHolder.f55009j.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.price, true));
                    if (menuItem.isDiscounted()) {
                        if (RestaurantMenuScreenR.this.isGemActive()) {
                            menuItemViewHolder.f55012m.setVisibility(8);
                            menuItemViewHolder.f55009j.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.oldPrice, true));
                        } else {
                            menuItemViewHolder.f55012m.setVisibility(0);
                            menuItemViewHolder.f55012m.setText(menuItem.getDisplayOldPriceFormatted());
                            TextView textView = menuItemViewHolder.f55012m;
                            textView.setPaintFlags(textView.getPaintFlags() | 16);
                        }
                    }
                }
                if (menuItem.hasThumbnail) {
                    menuItemViewHolder.f55015p.setVisibility(0);
                    menuItemViewHolder.f55013n.setOnClickListener(new t(this, menuItem, menuItemViewHolder, i11));
                    RestaurantMenuScreenR restaurantMenuScreenR = RestaurantMenuScreenR.this;
                    if (restaurantMenuScreenR.isValidContextForGlide(restaurantMenuScreenR)) {
                        GlideApp.with((FragmentActivity) RestaurantMenuScreenR.this).clear((View) menuItemViewHolder.f55013n);
                        GlideApp.with((FragmentActivity) RestaurantMenuScreenR.this).load(menuItem.getThumbnailWithSize(200)).listener((RequestListener) new RequestListener<Drawable>() {
                            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                                menuItemViewHolder.f55015p.setVisibility(8);
                                return false;
                            }

                            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                                menuItemViewHolder.f55020u.setVisibility(8);
                                menuItemViewHolder.f55013n.setVisibility(0);
                                return false;
                            }
                        }).apply(TalabatGlideModule.requestOptions().transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(RestaurantMenuScreenR.this.getResources().getDimensionPixelSize(R.dimen.card_corner_radius))})).into(menuItemViewHolder.f55013n);
                    }
                } else {
                    menuItemViewHolder.f55015p.setVisibility(8);
                }
                menuItemViewHolder.f55009j.setTag(Integer.valueOf(i11));
                menuItemViewHolder.f55009j.setOnClickListener(new ud(this, menuItem, i11));
                menuItemViewHolder.f55021v.setTag(Integer.valueOf(i11));
                menuItemViewHolder.f55021v.setOnClickListener(new u(this, menuItemViewHolder, menuItem, i11));
            }
        }
    }
}
