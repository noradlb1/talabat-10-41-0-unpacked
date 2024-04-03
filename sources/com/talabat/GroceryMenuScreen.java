package com.talabat;

import JsonModels.Response.BinTokenRM;
import JsonModels.Response.PreviousOrderList.PreviousOrder;
import JsonModels.Response.SplitRestaurantApiResponse.SplitChoiceItemModel;
import JsonModels.ReviewWithRatingModel;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import b20.b;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.platform.PlatformFeatureFlagsKeys;
import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.common.helpers.EventDataHelper;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.designhelpers.CustomSquareProgree.Utils.CalculationUtil;
import com.talabat.designhelpers.Grocery.GravitySnapHelper;
import com.talabat.designhelpers.Grocery.HorizontalLinearLayoutManager;
import com.talabat.designhelpers.Grocery.VerticalLinearLayoutManager;
import com.talabat.designhelpers.LoadingHelper.LoadingIndicatorView;
import com.talabat.designhelpers.Utils;
import com.talabat.di.grocery.DaggerGroceryMenuScreenComponent;
import com.talabat.dialogs.ParallelBinDialog;
import com.talabat.dialogs.SpecialOffersDialog;
import com.talabat.feature.subscriptions.domain.ISubscriptionsFeatureFlagsRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.tpro.presentation.helperview.mov.TProVendorMovView;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.geminterfaces.OnGemFooterCallBacks;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.MiniCartLayout;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.GroceryHorizontalMenuListModel;
import datamodels.GroceryHorizontalRowDataModel;
import datamodels.MenuItem;
import datamodels.MenuListModel;
import datamodels.MenuSection;
import datamodels.RatingSection;
import datamodels.Restaurant;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;
import io.flutter.plugin.platform.PlatformPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.restaurantmenu.IRestaurantMenuScreenPresenterR;
import library.talabat.mvp.restaurantmenu.RestaurantMenuScreenView;
import library.talabat.mvp.restaurantmenu.RestaurantMeuScreenPresenterR;
import library.talabat.mvp.restaurantreview.IRestaurantReviewPresenter;
import library.talabat.mvp.restaurantreview.RestaurantReviewPresenter;
import library.talabat.mvp.restaurantreview.RestaurantReviewView;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.IAppTracker;
import tracking.ScreenNames;
import tracking.gtm.TalabatGTM;
import ue.a8;
import ue.b8;
import ue.k7;
import ue.l7;
import ue.m7;
import ue.n7;
import ue.o7;
import ue.p7;
import ue.q7;
import ue.r7;
import ue.s7;
import ue.t7;
import ue.u7;
import ue.v7;
import ue.w7;
import ue.x7;
import ue.y7;
import ue.z7;
import yq.a;

public class GroceryMenuScreen extends TalabatBase implements RestaurantScreenInterator, RestaurantReviewView, RestaurantMenuScreenView, MiniCartLayout.OnCartClickListener, View.OnClickListener, OnGemFooterCallBacks, GemView, OnGemAlertDialogClickListener {
    private static final String CHECKOUT_FOOTER = "CHECKOUT_FOOTER";
    private static final String LAND_PAGE_FOOTER = "LANDPAGE_FOOTER";
    private static final int MAX_ITEM_SECTION = 5;
    /* access modifiers changed from: private */
    public static boolean notRequired = false;
    @Inject
    public ITalabatFeatureFlag A;
    @Inject
    public CustomerRepository B;
    @Inject
    public ISubscriptionsFeatureFlagsRepository C;
    public IAppTracker D = new AppTracker(new TalabatGTM());
    public TalabatTracker E;
    public boolean F = false;
    /* access modifiers changed from: private */
    public boolean adjusting = false;
    private View americanExpressView;
    private boolean binViewClosed = false;
    private int calculatedHeightForContentView;
    private ImageView cashIc;
    private View categoriesView;
    private ImageView closeCategoriesIcon;
    private View closeCategoriesView;
    /* access modifiers changed from: private */
    public View contentView;
    private TextView deliveryTime;
    /* access modifiers changed from: private */
    public ImageView disclaimerArrow;
    private float factor = 1.0f;
    private boolean fromGlobalSearch = false;
    private int fullScreenHeight;
    private RelativeLayout gemHolderLayout;
    private MenuItem globalMenuItem;
    private FrameLayout groceryHeader;
    private GroceryHorizontalAdapter groceryHorizontalAdapter;
    /* access modifiers changed from: private */
    public GroceryHorizontalMenuListModel groceryHorizontalMenuListModel;

    /* renamed from: i  reason: collision with root package name */
    public View f54113i;
    private View infoRow;
    private boolean isAreaChoosen;
    private boolean isBrandMapFlow = false;
    private RecyclerView itemsRecyclerView;

    /* renamed from: j  reason: collision with root package name */
    public MenuListModel f54114j;

    /* renamed from: k  reason: collision with root package name */
    public int f54115k;
    private ImageView knetIc;

    /* renamed from: l  reason: collision with root package name */
    public int f54116l;
    /* access modifiers changed from: private */
    public LinearLayoutManager linearLayoutManager;

    /* renamed from: m  reason: collision with root package name */
    public MenuItem f54117m = new MenuItem();
    private AppBarLayout mAppBar;
    /* access modifiers changed from: private */
    public CollapsingToolbarLayout mCollapsingToolBar;
    private GemDialogSwitcher mGemDialogSwitcher;
    private LinearLayout mLinearLayoutCenterData;
    /* access modifiers changed from: private */
    public LinearLayout mLinearLayoutRestaurantInfo;
    private Menu mMenu;
    private RestaurantReview mRestaurantReview;
    private IRestaurantReviewPresenter mReviewPresenter;
    /* access modifiers changed from: private */
    public TextView mTextViewRestaurantWarning;
    private View magnifyingGlass;
    private ImageView masterCardIc;
    private ImageView menuCategoriesIcon;
    private MenuCategoryAdapter menuCategoryAdapter;
    private RecyclerView menuRecyclerView;
    /* access modifiers changed from: private */
    public IRestaurantMenuScreenPresenterR menuScreenPresenter;
    private MiniCartLayout miniCartLayout;
    private boolean moved = false;

    /* renamed from: n  reason: collision with root package name */
    public GroceryRowAdapter f54118n;
    private ImageView newInfoButton;

    /* renamed from: o  reason: collision with root package name */
    public int f54119o = -1;
    /* access modifiers changed from: private */
    public TextView offersCount;
    private View offersView;
    /* access modifiers changed from: private */
    public int oldSize = -1;

    /* renamed from: p  reason: collision with root package name */
    public boolean f54120p = false;
    private boolean parallelBinDataReceived = false;
    private ImageView parallelBinImage;
    private View parallelBinImageView;
    private TextView parallelBinMore;
    private ProgressBar parallelBinProgressBar;
    private View parallelBinView;
    private TextView parallelText;
    private LinearLayout paymentOptionsSection;
    private int positionForSpeed = 0;

    /* renamed from: q  reason: collision with root package name */
    public TalabatTextView f54121q;

    /* renamed from: r  reason: collision with root package name */
    public TalabatTextView f54122r;
    private boolean reloadmenuCalled = false;
    private int requiredHeight;
    /* access modifiers changed from: private */
    public ImageView restaurantImg;
    private TextView restaurantName;

    /* renamed from: s  reason: collision with root package name */
    public TalabatTextView f54123s;
    private View searchBar;
    /* access modifiers changed from: private */
    public RelativeLayout searchContainer;
    private View searchText;
    private View showMenuCategories;

    /* renamed from: t  reason: collision with root package name */
    public TalabatTextView f54124t;
    private TProVendorMovView tProVendorMovView;
    /* access modifiers changed from: private */
    public TabLayout tabLayout;
    private TextView talabatGoTextView;
    public Toast toast = null;
    private Toolbar toolbar;
    private TextView toolbarTitle;
    private View toolbarView;
    private ConstraintLayout tproSubscriptionHeader;
    private ImageView transitionImageView;

    /* renamed from: u  reason: collision with root package name */
    public TalabatTextView f54125u;

    /* renamed from: v  reason: collision with root package name */
    public TalabatTextView f54126v;
    private ImageView visaIc;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public AppVersionProvider f54127w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public ConfigurationLocalRepository f54128x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public LocationConfigurationRepository f54129y;
    @Inject

    /* renamed from: z  reason: collision with root package name */
    public PaymentConfigurationRepository f54130z;

    public class GroceryHorizontalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: i  reason: collision with root package name */
        public GroceryHorizontalMenuListModel f54151i;

        /* renamed from: j  reason: collision with root package name */
        public SnapHelper f54152j;
        private RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

        public class GroceryHorizontalViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public TextView f54154h;

            /* renamed from: i  reason: collision with root package name */
            public RecyclerView f54155i;

            /* renamed from: j  reason: collision with root package name */
            public View f54156j;

            /* renamed from: k  reason: collision with root package name */
            public ImageButton f54157k;

            public GroceryHorizontalViewHolder(View view) {
                super(view);
                this.f54154h = (TextView) view.findViewById(R.id.section_title);
                this.f54155i = (RecyclerView) view.findViewById(R.id.menu_items_list);
                this.f54157k = (ImageButton) view.findViewById(R.id.show_more);
                this.f54156j = view.findViewById(R.id.content_view);
            }
        }

        public GroceryHorizontalAdapter(GroceryHorizontalMenuListModel groceryHorizontalMenuListModel) {
            this.f54151i = groceryHorizontalMenuListModel;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(MenuSection menuSection, View view) {
            try {
                if (GlobalDataModel.JSON.groceryMenuLoaded.getValue().booleanValue() || menuSection.firstPageLoaded) {
                    GlobalDataModel.JSON.groceryMenuItemsLoadedForSection.setValue(Boolean.TRUE);
                } else {
                    GlobalDataModel.JSON.groceryMenuItemsLoadedForSection.setValue(Boolean.FALSE);
                    GroceryMenuScreen.this.menuScreenPresenter.getGroceryItemsForSection(menuSection.f13863id);
                }
            } catch (Exception unused) {
                GlobalDataModel.JSON.groceryMenuItemsLoadedForSection.setValue(Boolean.FALSE);
                GroceryMenuScreen.this.menuScreenPresenter.getGroceryItemsForSection(menuSection.f13863id);
            }
            GroceryMenuScreen.this.startActivity(new Intent(GroceryMenuScreen.this, GroceryDetailsViewScreen.class).putExtra("menuSectionId", menuSection.f13863id));
        }

        public int getItemCount() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f54151i.getMenuListItemCount());
            sb2.append("");
            return this.f54151i.getMenuListItemCount();
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            GroceryHorizontalViewHolder groceryHorizontalViewHolder = (GroceryHorizontalViewHolder) viewHolder;
            GroceryHorizontalRowDataModel itemAtIndex = this.f54151i.getItemAtIndex(i11);
            MenuSection menuSection = itemAtIndex.getMenuSection();
            groceryHorizontalViewHolder.f54154h.setText(menuSection.f13864name);
            if (itemAtIndex.hasShowMore()) {
                groceryHorizontalViewHolder.f54157k.setVisibility(0);
            } else {
                groceryHorizontalViewHolder.f54157k.setVisibility(8);
            }
            GroceryMenuScreen groceryMenuScreen = GroceryMenuScreen.this;
            groceryMenuScreen.f54118n = new GroceryRowAdapter(itemAtIndex.getAllMenuItems());
            groceryHorizontalViewHolder.f54155i.setHasFixedSize(false);
            groceryHorizontalViewHolder.f54155i.setNestedScrollingEnabled(false);
            groceryHorizontalViewHolder.f54155i.setLayoutManager(new HorizontalLinearLayoutManager(GroceryMenuScreen.this, 0, false));
            groceryHorizontalViewHolder.f54155i.setAdapter(GroceryMenuScreen.this.f54118n);
            int i12 = GroceryMenuScreen.this.f54119o;
            if (i12 > -1) {
                groceryHorizontalViewHolder.f54155i.scrollToPosition(i12);
                GroceryMenuScreen.this.f54119o = -1;
            }
            groceryHorizontalViewHolder.f54157k.setOnClickListener(new a8(this, menuSection));
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            GroceryHorizontalViewHolder groceryHorizontalViewHolder = new GroceryHorizontalViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grocery_section_horizontal_row, viewGroup, false));
            this.f54152j = new GravitySnapHelper(GravityCompat.START, false);
            groceryHorizontalViewHolder.f54155i.setRecycledViewPool(this.recycledViewPool);
            return groceryHorizontalViewHolder;
        }
    }

    public class GroceryRowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        /* renamed from: i  reason: collision with root package name */
        public ArrayList<MenuItem> f54159i;

        public class GroceryRowListViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public LoadingIndicatorView f54163h;

            /* renamed from: i  reason: collision with root package name */
            public TextView f54164i;

            /* renamed from: j  reason: collision with root package name */
            public TextView f54165j;

            /* renamed from: k  reason: collision with root package name */
            public TextView f54166k;

            /* renamed from: l  reason: collision with root package name */
            public TextView f54167l;

            /* renamed from: m  reason: collision with root package name */
            public TextView f54168m;

            /* renamed from: n  reason: collision with root package name */
            public TextView f54169n;

            /* renamed from: o  reason: collision with root package name */
            public ImageView f54170o;

            /* renamed from: p  reason: collision with root package name */
            public ProgressBar f54171p;

            /* renamed from: q  reason: collision with root package name */
            public Button f54172q;

            /* renamed from: r  reason: collision with root package name */
            public View f54173r;

            /* renamed from: s  reason: collision with root package name */
            public View f54174s;

            /* renamed from: t  reason: collision with root package name */
            public View f54175t;

            /* renamed from: u  reason: collision with root package name */
            public View f54176u;

            /* renamed from: v  reason: collision with root package name */
            public View f54177v;

            /* renamed from: w  reason: collision with root package name */
            public View f54178w;

            public GroceryRowListViewHolder(View view) {
                super(view);
                this.f54164i = (TextView) view.findViewById(R.id.itemName);
                this.f54165j = (TextView) view.findViewById(R.id.itemDescription);
                this.f54166k = (TextView) view.findViewById(R.id.itemPrice);
                this.f54170o = (ImageView) view.findViewById(R.id.itemImg);
                this.f54171p = (ProgressBar) view.findViewById(R.id.progress);
                this.f54178w = view.findViewById(R.id.discountIc);
                this.f54167l = (TextView) view.findViewById(R.id.priceExtraInfo);
                this.f54168m = (TextView) view.findViewById(R.id.priceBefore);
                this.f54163h = (LoadingIndicatorView) view.findViewById(R.id.loading_price);
                this.f54172q = (Button) view.findViewById(R.id.add_item);
                this.f54173r = view.findViewById(R.id.price_section);
                this.f54174s = view.findViewById(R.id.rootView);
                this.f54175t = view.findViewById(R.id.quantity_section);
                this.f54176u = view.findViewById(R.id.decrease_qty);
                this.f54177v = view.findViewById(R.id.increase_qty);
                this.f54169n = (TextView) view.findViewById(R.id.quantity_text);
            }
        }

        public GroceryRowAdapter(ArrayList<MenuItem> arrayList) {
            this.f54159i = arrayList;
        }

        private void decreaseQuantity(MenuItem menuItem, View view, Button button, TextView textView) {
            Cart instance = Cart.getInstance();
            CartMenuItem cartMenuItem = new CartMenuItem();
            Iterator<CartMenuItem> it = instance.getCartItems().iterator();
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (menuItem.f13861id == next.f13861id) {
                    next.setQuantity(next.getQuantity() - 1);
                    int quantity = next.getQuantity();
                    if (quantity < 1) {
                        view.setVisibility(8);
                        button.setVisibility(0);
                    } else {
                        textView.setText(quantity + "");
                    }
                    cartMenuItem = next;
                }
            }
            if (cartMenuItem.f13861id > 0) {
                AppTracker.onItemRemovedFromCart(GroceryMenuScreen.this, Cart.getInstance().getRestaurant(), cartMenuItem, "menu_decrease", ScreenNames.getScreenType(GroceryMenuScreen.this.getScreenName()), GroceryMenuScreen.this.getScreenName());
                instance.decreaseItemQuantity(cartMenuItem, GroceryMenuScreen.this);
                GroceryMenuScreen.this.modifyCartFooter();
            }
        }

        private void increaseQuantity(MenuItem menuItem, View view, Button button, TextView textView) {
            String str;
            Cart instance = Cart.getInstance();
            CartMenuItem cartMenuItem = new CartMenuItem();
            Iterator<CartMenuItem> it = instance.getCartItems().iterator();
            CartMenuItem cartMenuItem2 = cartMenuItem;
            boolean z11 = false;
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (menuItem.f13861id == next.f13861id) {
                    int quantity = next.getQuantity();
                    if (instance.getCartItemQuantity(next) < 100) {
                        next.setQuantity(quantity + 1);
                        textView.setText(next.getQuantity() + "");
                        z11 = false;
                        cartMenuItem2 = next;
                    } else {
                        TextView textView2 = textView;
                        cartMenuItem2 = next;
                        z11 = true;
                    }
                } else {
                    TextView textView3 = textView;
                }
            }
            if (z11) {
                GroceryMenuScreen.this.onMaxCartItemsReached();
            } else if (cartMenuItem2.f13861id > 0) {
                instance.increaseItemQuantity(cartMenuItem2, GroceryMenuScreen.this);
                ArrayList<ChoiceSection> arrayList = cartMenuItem2.selectedChoices;
                if (arrayList != null) {
                    str = GroceryMenuScreen.this.getChoicesString(arrayList);
                } else {
                    str = "";
                }
                AppTracker.onItemAddedToCart(GroceryMenuScreen.this, Cart.getInstance().getRestaurant(), cartMenuItem2, AppTracker.getRestaurantId(GlobalDataModel.SELECTED.restaurant), AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant), "menu_increase", str, cartMenuItem2.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], cartMenuItem2.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(GroceryMenuScreen.this.getScreenName()), GroceryMenuScreen.this.getScreenName());
                GroceryMenuScreen.this.modifyCartFooter();
                GroceryMenuScreen.this.showSingleToast();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(GroceryRowListViewHolder groceryRowListViewHolder, MenuItem menuItem, View view) {
            try {
                if (groceryRowListViewHolder.f54170o.getDrawable().getConstantState() != ContextCompat.getDrawable(GroceryMenuScreen.this, R.drawable.bg_m_grocery_placeholder).getConstantState()) {
                    GroceryMenuScreen.this.onMenuImageClicked(menuItem, groceryRowListViewHolder.f54170o);
                }
            } catch (Exception unused) {
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(GroceryRowListViewHolder groceryRowListViewHolder, MenuItem menuItem, View view) {
            if (groceryRowListViewHolder.f54166k.getText().toString().equals(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.price, true))) {
                GlobalDataModel.MENU.priceOnSelectionItemAvailable = true;
            }
            GroceryMenuScreen.this.onMenuItemClicked(menuItem, groceryRowListViewHolder.f54170o);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(MenuItem menuItem, GroceryRowListViewHolder groceryRowListViewHolder, View view) {
            GroceryMenuScreen.this.onCartIconClicked(menuItem, groceryRowListViewHolder.f54170o, "menu_normal");
            GroceryMenuScreen.this.f54119o = groceryRowListViewHolder.getAdapterPosition();
            if (GlobalDataModel.MENU.isQuickAddEnabled) {
                setCount(menuItem, groceryRowListViewHolder.f54175t, groceryRowListViewHolder.f54172q, groceryRowListViewHolder.f54169n);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$3(MenuItem menuItem, GroceryRowListViewHolder groceryRowListViewHolder, View view) {
            if (menuItem.choiceSections.length > 0 || menuItem.willHaveChoices()) {
                GroceryMenuScreen.this.goToCart();
            } else {
                decreaseQuantity(menuItem, groceryRowListViewHolder.f54175t, groceryRowListViewHolder.f54172q, groceryRowListViewHolder.f54169n);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$4(MenuItem menuItem, GroceryRowListViewHolder groceryRowListViewHolder, View view) {
            if (menuItem.choiceSections.length > 0 || menuItem.willHaveChoices()) {
                GroceryMenuScreen.this.onCartIconClicked(menuItem, groceryRowListViewHolder.f54170o, "menu_increase");
            } else {
                increaseQuantity(menuItem, groceryRowListViewHolder.f54175t, groceryRowListViewHolder.f54172q, groceryRowListViewHolder.f54169n);
            }
        }

        private void setCount(MenuItem menuItem, View view, Button button, TextView textView) {
            if (!Cart.getInstance().hasItems()) {
                view.setVisibility(8);
                button.setVisibility(0);
                return;
            }
            Iterator<CartMenuItem> it = Cart.getInstance().getCartItems().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                if (menuItem.f13862name.equals(next.f13862name) && menuItem.f13861id == next.f13861id) {
                    i11 += next.getQuantity();
                }
            }
            if (i11 > 0) {
                view.setVisibility(0);
                button.setVisibility(8);
                textView.setText(i11 + "");
                return;
            }
            view.setVisibility(8);
            button.setVisibility(0);
        }

        public int getItemCount() {
            return this.f54159i.size();
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            final GroceryRowListViewHolder groceryRowListViewHolder = (GroceryRowListViewHolder) viewHolder;
            MenuItem menuItem = this.f54159i.get(i11);
            groceryRowListViewHolder.f54174s.setTag(Integer.valueOf(i11));
            groceryRowListViewHolder.f54173r.setTag(Integer.valueOf(i11));
            groceryRowListViewHolder.f54164i.setText(menuItem.f13862name);
            if (menuItem.isPromotional) {
                groceryRowListViewHolder.f54178w.setVisibility(0);
            } else {
                groceryRowListViewHolder.f54178w.setVisibility(8);
            }
            if (menuItem.getDisplayPrice().equals("0")) {
                groceryRowListViewHolder.f54167l.setVisibility(0);
                groceryRowListViewHolder.f54167l.setText(GroceryMenuScreen.this.getString(R.string.price_based_on_selection));
                groceryRowListViewHolder.f54166k.setVisibility(8);
                groceryRowListViewHolder.f54168m.setVisibility(8);
            } else {
                groceryRowListViewHolder.f54167l.setVisibility(8);
                groceryRowListViewHolder.f54166k.setVisibility(0);
                groceryRowListViewHolder.f54166k.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.price, true));
                if (menuItem.isDiscounted()) {
                    if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                        groceryRowListViewHolder.f54168m.setVisibility(8);
                        groceryRowListViewHolder.f54166k.setText(TalabatFormatter.getInstance().getFormattedCurrency(menuItem.oldPrice, true));
                    } else {
                        groceryRowListViewHolder.f54168m.setVisibility(0);
                        groceryRowListViewHolder.f54168m.setText(menuItem.getDisplayOldPriceNonFormatted());
                        groceryRowListViewHolder.f54168m.setPaintFlags(groceryRowListViewHolder.f54167l.getPaintFlags() | 16);
                    }
                }
            }
            if (menuItem.hasThumbnail) {
                groceryRowListViewHolder.f54170o.setOnClickListener(new i(this, groceryRowListViewHolder, menuItem));
                GroceryMenuScreen groceryMenuScreen = GroceryMenuScreen.this;
                if (groceryMenuScreen.isValidContextForGlide(groceryMenuScreen)) {
                    GlideApp.with((FragmentActivity) GroceryMenuScreen.this).clear((View) groceryRowListViewHolder.f54170o);
                    GlideApp.with((FragmentActivity) GroceryMenuScreen.this).load(menuItem.getThumbnailWithSize(200)).centerInside().error((int) R.drawable.bg_m_grocery_placeholder).fallback((int) R.drawable.bg_m_grocery_placeholder).placeholder((int) R.drawable.bg_m_grocery_placeholder).listener((RequestListener) new RequestListener<Drawable>() {
                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                            groceryRowListViewHolder.f54170o.setImageResource(R.drawable.bg_m_grocery_placeholder);
                            groceryRowListViewHolder.f54171p.setVisibility(8);
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                            groceryRowListViewHolder.f54171p.setVisibility(8);
                            return false;
                        }
                    }).into(groceryRowListViewHolder.f54170o);
                }
            } else {
                groceryRowListViewHolder.f54170o.setImageResource(R.drawable.bg_m_grocery_placeholder);
                groceryRowListViewHolder.f54171p.setVisibility(8);
                groceryRowListViewHolder.f54170o.setVisibility(0);
            }
            groceryRowListViewHolder.f54174s.setOnClickListener(new j(this, groceryRowListViewHolder, menuItem));
            if (GlobalDataModel.MENU.isQuickAddEnabled) {
                setCount(menuItem, groceryRowListViewHolder.f54175t, groceryRowListViewHolder.f54172q, groceryRowListViewHolder.f54169n);
            }
            groceryRowListViewHolder.f54172q.setOnClickListener(new k(this, menuItem, groceryRowListViewHolder));
            groceryRowListViewHolder.f54176u.setOnClickListener(new l(this, menuItem, groceryRowListViewHolder));
            groceryRowListViewHolder.f54177v.setOnClickListener(new m(this, menuItem, groceryRowListViewHolder));
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new GroceryRowListViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grocery_menu_grid_view_item, viewGroup, false));
        }
    }

    public class MenuCategoryAdapter extends RecyclerView.Adapter<MenuCategoryViewHolderViewHolder> {
        private Context mContext;
        private ArrayList<Pair<String, Integer>> restaurantMenuSections;

        public class MenuCategoryViewHolderViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public View f54181h;

            /* renamed from: i  reason: collision with root package name */
            public TextView f54182i;

            /* renamed from: j  reason: collision with root package name */
            public TextView f54183j;

            public MenuCategoryViewHolderViewHolder(View view) {
                super(view);
                this.f54181h = view.findViewById(R.id.parent_row_view);
                this.f54182i = (TextView) view.findViewById(R.id.category_title);
                this.f54183j = (TextView) view.findViewById(R.id.items_count);
            }
        }

        public MenuCategoryAdapter(Context context, ArrayList<Pair<String, Integer>> arrayList) {
            this.mContext = context;
            this.restaurantMenuSections = arrayList;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i11, View view) {
            GroceryMenuScreen.this.onItemSelected(i11);
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
            menuCategoryViewHolderViewHolder.f54182i.setText((CharSequence) pair.first);
            menuCategoryViewHolderViewHolder.f54183j.setVisibility(4);
            TextView textView = menuCategoryViewHolderViewHolder.f54183j;
            textView.setText(pair.second + "");
            menuCategoryViewHolderViewHolder.f54181h.setOnClickListener(new b8(this, i11));
        }

        public MenuCategoryViewHolderViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new MenuCategoryViewHolderViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.menu_category_row, viewGroup, false));
        }
    }

    private void adjustStatusIconsTint(boolean z11) {
        View decorView = getWindow().getDecorView();
        if (z11) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        } else {
            decorView.setSystemUiVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public String getChoicesString(ArrayList<ChoiceSection> arrayList) {
        StringBuilder sb2 = new StringBuilder();
        if (arrayList.size() == 0) {
            return "";
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
            while (it2.hasNext()) {
                ChoiceItem next = it2.next();
                if (sb2.length() > 0) {
                    sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                }
                sb2.append(next.f13840name);
            }
        }
        return sb2.toString();
    }

    private Fragment getFooterFragmentView(String str) {
        return getSupportFragmentManager().findFragmentByTag(str);
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

    private void goToBackScreen() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            if (this.mGemDialogSwitcher == null) {
                this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
            }
            this.mGemDialogSwitcher.showGemDialog(1, false);
            return;
        }
        if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            startActivity(new Intent(this, HomeScreenActivity.class));
        } else {
            GlobalDataModel.backFromMenuToList = true;
            finish();
        }
        exitAnimation();
    }

    /* access modifiers changed from: private */
    public void goToCart() {
        startActivity(new Intent(this, CartScreen.class));
    }

    private void goToItemDetailsScreen() {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.f54117m);
        createWithMenuItem.setQuantity(1);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant));
        GlobalDataModel.MENU.AddToCartClicked = false;
        GlobalDataModel.SELECTED.cartMenuItem = createWithMenuItem;
        startActivity(new Intent(this, ItemDetailsActivity.class));
        stopLodingPopup();
    }

    private void hideGemItemAddedView(GemFooterMenuLevelView gemFooterMenuLevelView) {
        if (gemFooterMenuLevelView != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(gemFooterMenuLevelView);
            beginTransaction.commit();
        }
    }

    private void hideGemLandPageView(GemFooterViewManager gemFooterViewManager) {
        if (gemFooterViewManager != null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.remove(gemFooterViewManager);
            beginTransaction.commit();
        }
    }

    /* access modifiers changed from: private */
    public void increaseCollapsingToolbarSize() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.mCollapsingToolBar.getMeasuredHeight(), this.mCollapsingToolBar.getMeasuredHeight() + this.parallelBinView.getMeasuredHeight()});
        ofInt.setDuration(600);
        ofInt.addUpdateListener(new q7(this));
        ofInt.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (GroceryMenuScreen.this.oldSize != GroceryMenuScreen.this.mCollapsingToolBar.getHeight()) {
                    GroceryMenuScreen.this.adjusting = false;
                }
                GroceryMenuScreen.this.mCollapsingToolBar.requestLayout();
            }
        });
        ofInt.setDuration(250);
        ofInt.start();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initContinuousScrollingView() {
        ArrayList<MenuSection> restaurantMenuSections = this.menuScreenPresenter.getRestaurantMenuSections();
        for (int i11 = 0; i11 < restaurantMenuSections.size(); i11++) {
            View inflate = LayoutInflater.from(this).inflate(R.layout.continuous_scroll_tab_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.section_name);
            String str = restaurantMenuSections.get(i11).f13864name;
            if (restaurantMenuSections.get(i11).isDiscounted || restaurantMenuSections.get(i11).showPercentage()) {
                str = str + "  %";
            }
            textView.setText(str);
            TabLayout tabLayout2 = this.tabLayout;
            tabLayout2.addTab(tabLayout2.newTab().setCustomView(inflate), i11);
        }
        ArrayList<MenuItem> restaurantMenuItems = this.menuScreenPresenter.getRestaurantMenuItems(restaurantMenuSections);
        this.menuRecyclerView.setHasFixedSize(false);
        VerticalLinearLayoutManager verticalLinearLayoutManager = new VerticalLinearLayoutManager(this, 1, false);
        this.linearLayoutManager = verticalLinearLayoutManager;
        verticalLinearLayoutManager.setOrientation(1);
        this.menuRecyclerView.setLayoutManager(this.linearLayoutManager);
        this.menuRecyclerView.setBackgroundColor(ContextCompat.getColor(this, R.color.app_background));
        this.groceryHorizontalMenuListModel = new GroceryHorizontalMenuListModel();
        if (restaurantMenuSections.size() > 0 && restaurantMenuItems != null && restaurantMenuItems.size() > 0) {
            this.groceryHorizontalMenuListModel.createMenuDisplayModel(restaurantMenuSections, restaurantMenuItems, 5);
            GroceryHorizontalAdapter groceryHorizontalAdapter2 = new GroceryHorizontalAdapter(this.groceryHorizontalMenuListModel);
            this.groceryHorizontalAdapter = groceryHorizontalAdapter2;
            this.menuRecyclerView.setAdapter(groceryHorizontalAdapter2);
            this.menuRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                    super.onScrolled(recyclerView, i11, i12);
                    GroceryMenuScreen.notRequired = true;
                    GroceryMenuScreen groceryMenuScreen = GroceryMenuScreen.this;
                    groceryMenuScreen.scrollTabToPosition(groceryMenuScreen.linearLayoutManager.findFirstVisibleItemPosition());
                    GroceryMenuScreen.notRequired = false;
                    if (GroceryMenuScreen.this.linearLayoutManager.findLastCompletelyVisibleItemPosition() == GroceryMenuScreen.this.groceryHorizontalMenuListModel.getLastItemPosition()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(GroceryMenuScreen.this.linearLayoutManager.findLastCompletelyVisibleItemPosition());
                        sb2.append(" ");
                        if (GroceryMenuScreen.this.tabLayout.getSelectedTabPosition() != GroceryMenuScreen.this.linearLayoutManager.findLastCompletelyVisibleItemPosition()) {
                            GroceryMenuScreen.this.scrollTabToPosition(GroceryMenuScreen.this.menuScreenPresenter.getRestaurantMenuSections().size() - 1);
                        }
                    }
                }
            });
            this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
                public void onTabReselected(TabLayout.Tab tab) {
                }

                public void onTabSelected(TabLayout.Tab tab) {
                    if (!GroceryMenuScreen.notRequired) {
                        GroceryMenuScreen.this.scrollRecyclerviewToPosition(tab.getPosition());
                    } else if (GroceryMenuScreen.notRequired) {
                        GroceryMenuScreen.notRequired = false;
                    }
                }

                public void onTabUnselected(TabLayout.Tab tab) {
                }
            });
        }
    }

    private void initVariables() {
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        if (TalabatUtils.isArabic()) {
            this.tabLayout.setLayoutDirection(1);
        }
        this.mLinearLayoutRestaurantInfo = (LinearLayout) findViewById(R.id.linearLayout_restaurantInfo);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbarTitle = (TextView) findViewById(R.id.title);
        this.toolbarView = findViewById(R.id.toolbar_view);
        this.magnifyingGlass = findViewById(R.id.hidden_search_image);
        this.paymentOptionsSection = (LinearLayout) findViewById(R.id.payment_section);
        this.americanExpressView = findViewById(R.id.amexImg);
        this.restaurantName = (TextView) findViewById(R.id.restaurant_name);
        this.restaurantImg = (ImageView) findViewById(R.id.restaurant_logo);
        this.visaIc = (ImageView) findViewById(R.id.visaImg);
        this.masterCardIc = (ImageView) findViewById(R.id.masterCardImg);
        this.knetIc = (ImageView) findViewById(R.id.knetImg);
        this.cashIc = (ImageView) findViewById(R.id.cashImg);
        this.deliveryTime = (TextView) findViewById(R.id.delivery_time);
        this.talabatGoTextView = (TextView) findViewById(R.id.tv_to_go);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.gem_holder_view);
        this.gemHolderLayout = relativeLayout;
        relativeLayout.setVisibility(0);
        MiniCartLayout miniCartLayout2 = (MiniCartLayout) findViewById(R.id.miniCart);
        this.miniCartLayout = miniCartLayout2;
        miniCartLayout2.setClickListener(this);
        this.mTextViewRestaurantWarning = (TextView) findViewById(R.id.tv_restaurant_warning);
        this.mCollapsingToolBar = (CollapsingToolbarLayout) findViewById(R.id.collapseToolBar);
        this.mLinearLayoutCenterData = (LinearLayout) findViewById(R.id.linearLayout_headerCenterData);
        this.mAppBar = (AppBarLayout) findViewById(R.id.appbar);
        this.mCollapsingToolBar.setTitleEnabled(false);
        this.isAreaChoosen = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.AREA_CHOOSED, true);
        this.f54113i = findViewById(R.id.ll_header);
        this.searchBar = findViewById(R.id.search_bar);
        this.searchText = findViewById(R.id.ed_search);
        this.searchContainer = (RelativeLayout) findViewById(R.id.grocery_search_container);
        this.groceryHeader = (FrameLayout) findViewById(R.id.grocery_header);
        this.f54121q = (TalabatTextView) findViewById(R.id.info_section_delivery_time);
        this.f54122r = (TalabatTextView) findViewById(R.id.info_section_delivery_fee);
        this.f54123s = (TalabatTextView) findViewById(R.id.info_section_min_order);
        this.infoRow = findViewById(R.id.info_row);
        this.newInfoButton = (ImageView) findViewById(R.id.btn_m_info);
        this.disclaimerArrow = (ImageView) findViewById(R.id.disclaimer_arrow);
        this.f54124t = (TalabatTextView) findViewById(R.id.new_grocery_offers_more);
        this.f54125u = (TalabatTextView) findViewById(R.id.grocery_name);
        this.f54126v = (TalabatTextView) findViewById(R.id.grocery_status);
        this.tproSubscriptionHeader = (ConstraintLayout) findViewById(R.id.subscription_header);
        if (!this.C.isTProEnabledForNFV() || !this.menuScreenPresenter.isRestaurantTPro()) {
            this.tproSubscriptionHeader.setVisibility(8);
        } else {
            this.tproSubscriptionHeader.setVisibility(0);
        }
        TProVendorMovView tProVendorMovView2 = (TProVendorMovView) findViewById(R.id.tpro_mov);
        this.tProVendorMovView = tProVendorMovView2;
        tProVendorMovView2.showTProMovIfApplicable(this.menuScreenPresenter.isRestaurantTPro(), this.menuScreenPresenter.getBranchId());
        this.magnifyingGlass.setOnClickListener(new u7(this));
        this.searchBar.setOnClickListener(new v7(this));
        this.searchText.setOnClickListener(new w7(this));
        int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.f54115k = i11;
        this.f54116l = (i11 * 77) / 100;
        this.toolbar.setTitle((CharSequence) " ");
        this.toolbarTitle.setText(this.menuScreenPresenter.getRestuarantName());
        this.f54125u.setText(this.menuScreenPresenter.getRestuarantName());
        if (this.menuScreenPresenter.getRestaurantStatus() == 2 || this.menuScreenPresenter.getRestaurantStatus() == 1 || this.menuScreenPresenter.getRestaurantStatus() == 4) {
            if (this.menuScreenPresenter.getRestaurantStatus() == 1 || this.menuScreenPresenter.getRestaurantStatus() == 4) {
                this.f54126v.setText(R.string.closed_grocery);
            } else if (this.menuScreenPresenter.getRestaurantStatus() == 2) {
                this.f54126v.setText(R.string.busy);
            }
            this.f54126v.setVisibility(0);
        } else if (this.menuScreenPresenter.getRestaurantStatus() == 5) {
            this.f54126v.setText(R.string.open_for_preorder);
            this.f54126v.setVisibility(0);
        } else {
            this.f54126v.setVisibility(8);
        }
        this.mAppBar.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new x7(this));
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        this.toolbar.setNavigationIcon((int) R.drawable.ic_m_back_white_bg);
        this.toolbar.setPadding(0, getStatusBarHeight(), 0, 0);
        this.toolbar.setNavigationOnClickListener(new y7(this));
        this.menuScreenPresenter.getBinTokens();
        if (this.menuScreenPresenter.isRestaurantHasWarning()) {
            this.mTextViewRestaurantWarning.setVisibility(0);
            this.mTextViewRestaurantWarning.setText(this.menuScreenPresenter.getRestaurantWarning().trim().replaceAll("(\\s){2,}", " ").replaceAll("(\\n){2,}", StringUtils.LF));
            this.mTextViewRestaurantWarning.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* access modifiers changed from: private */
                public /* synthetic */ void lambda$onGlobalLayout$0(View view) {
                    if (GroceryMenuScreen.this.mLinearLayoutRestaurantInfo.getAlpha() == 1.0f) {
                        GroceryMenuScreen.this.showRestaurantSummaryPopup();
                    }
                }

                public void onGlobalLayout() {
                    if (GroceryMenuScreen.this.mTextViewRestaurantWarning.getLineCount() > 1) {
                        GroceryMenuScreen.this.disclaimerArrow.setVisibility(0);
                        GroceryMenuScreen.this.mTextViewRestaurantWarning.setOnClickListener(new h(this));
                        GroceryMenuScreen.this.mTextViewRestaurantWarning.setMaxLines(1);
                        GroceryMenuScreen.this.mTextViewRestaurantWarning.setEllipsize(TextUtils.TruncateAt.END);
                    }
                    if (TalabatUtils.isArabic()) {
                        GroceryMenuScreen.this.restaurantImg.getLayoutParams().height = Utils.dpToPixel(350, GroceryMenuScreen.this.getContext());
                    } else {
                        GroceryMenuScreen.this.restaurantImg.getLayoutParams().height = Utils.dpToPixel(325, GroceryMenuScreen.this.getContext());
                    }
                    GroceryMenuScreen.this.restaurantImg.requestLayout();
                    GroceryMenuScreen.this.mTextViewRestaurantWarning.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    GroceryMenuScreen groceryMenuScreen = GroceryMenuScreen.this;
                    groceryMenuScreen.increaseCollapsingToolbarSize(groceryMenuScreen.mTextViewRestaurantWarning);
                }
            });
        } else {
            this.mTextViewRestaurantWarning.setVisibility(8);
            this.restaurantImg.getLayoutParams().height = Utils.dpToPixel(250, getContext());
            this.restaurantImg.requestLayout();
        }
        GlobalDataModel.MENU.isQuickAddEnabled = true;
        this.categoriesView = findViewById(R.id.menu_categories_bottom_sheet);
        this.menuCategoriesIcon = (ImageView) findViewById(R.id.menu_categories_icon);
        this.contentView = findViewById(R.id.content_view);
        this.closeCategoriesIcon = (ImageView) findViewById(R.id.close_categories);
        this.closeCategoriesView = findViewById(R.id.close_categories_view);
        this.offersView = findViewById(R.id.offers_view);
        this.offersCount = (TextView) findViewById(R.id.restaurant_offers_count);
        this.itemsRecyclerView = (RecyclerView) findViewById(R.id.items_recyclerView);
        View findViewById = findViewById(R.id.menu_categories);
        this.showMenuCategories = findViewById;
        findViewById.setOnClickListener(new z7(this));
        this.menuCategoriesIcon.setOnClickListener(new l7(this));
        this.menuRecyclerView = (RecyclerView) findViewById(R.id.menu_list);
        this.parallelBinView = findViewById(R.id.parallel_bin_view);
        this.parallelBinImageView = findViewById(R.id.parallel_bin_image_view);
        this.parallelBinImage = (ImageView) findViewById(R.id.parallel_bin_image);
        this.parallelBinProgressBar = (ProgressBar) findViewById(R.id.parallel_bin_image_progressBar);
        this.parallelText = (TextView) findViewById(R.id.parallel_bin_content);
        this.parallelBinMore = (TextView) findViewById(R.id.parallel_bin_more);
        this.menuScreenPresenter.getParallelBinData();
        populateInfoRaw();
        this.newInfoButton.setOnClickListener(new m7(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$increaseCollapsingToolbarSize$13(ValueAnimator valueAnimator) {
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        ViewGroup.LayoutParams layoutParams = this.mCollapsingToolBar.getLayoutParams();
        layoutParams.height = intValue;
        this.mCollapsingToolBar.setLayoutParams(layoutParams);
        this.mCollapsingToolBar.requestLayout();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$0(View view) {
        AppTracker.onSearchBarClicked(this, ScreenNames.getScreenType(getScreenName()), getScreenName(), "N/A", "search");
        startActivity(new Intent(this, GroceryMenuSearchActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$1(View view) {
        AppTracker.onSearchBarClicked(this, ScreenNames.getScreenType(getScreenName()), getScreenName(), "N/A", "search");
        startActivity(new Intent(this, GroceryMenuSearchActivity.class));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$2(View view) {
        this.searchBar.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$3(AppBarLayout appBarLayout, int i11) {
        float abs = ((float) Math.abs(i11)) / ((float) appBarLayout.getTotalScrollRange());
        float f11 = 1.0f - abs;
        this.mLinearLayoutRestaurantInfo.setAlpha(f11);
        this.searchContainer.setAlpha(f11);
        this.groceryHeader.setAlpha(f11);
        this.magnifyingGlass.setAlpha(abs);
        this.toolbarTitle.setAlpha(abs);
        if (f11 == 0.0f) {
            this.mLinearLayoutRestaurantInfo.setVisibility(8);
            this.searchContainer.setVisibility(8);
            this.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            this.mCollapsingToolBar.setContentScrimColor(getResources().getColor(R.color.white));
            adjustStatusIconsTint(true);
        } else {
            this.mLinearLayoutRestaurantInfo.setVisibility(0);
            this.searchContainer.setVisibility(0);
            this.groceryHeader.setVisibility(0);
            this.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white_full_transparent));
            transparentStatusAndNavigation();
        }
        this.mLinearLayoutCenterData.setAlpha(f11);
        if (((float) (Math.abs(i11) - appBarLayout.getTotalScrollRange())) == 0.0f) {
            this.f54113i.setBackgroundResource(17170445);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$4(View view) {
        goToBackScreen();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$5(View view) {
        showMenuCategoriesPopup();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$6(View view) {
        this.showMenuCategories.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$initVariables$7(View view) {
        AppTracker.onTabInfoClicked(this, GlobalDataModel.SELECTED.restaurant);
        Intent intent = new Intent(this, RestaurantInfoActivity.class);
        intent.putExtra(GlobalConstants.ExtraNames.INFO_HERO_IMG, this.menuScreenPresenter.getHeroImage());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onParallelBinAvailable$12(View view) {
        new ParallelBinDialog().show(getSupportFragmentManager(), "Parallel Bin Dialog");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollRecyclerviewToPosition$15(int i11) {
        this.linearLayoutManager.scrollToPositionWithOffset(i11, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$scrollTabToPosition$14(int i11) {
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
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        GlobalDataModel.OFFERS.offersList = this.menuScreenPresenter.getRestaurantOffers();
        new SpecialOffersDialog().show(supportFragmentManager, "Dialog Fragment");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setUpValues$9(View view) {
        if (this.contentView.getVisibility() == 0) {
            slideDown(this.contentView, this.categoriesView);
        }
        this.categoriesView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void modifyCartFooter() {
        Cart instance = Cart.getInstance();
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            if (!instance.hasItems()) {
                showGemLandingPage();
            } else if (instance.hasItems()) {
                showSnackBar();
            }
        } else {
            if (Cart.getInstance() == null || Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().getId() != GlobalDataModel.SELECTED.restaurant.getId()) {
                this.miniCartLayout.showMiniCart(0, GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
                if (getFooterFragmentView(LAND_PAGE_FOOTER) != null) {
                    hideGemLandPageView((GemFooterViewManager) getFooterFragmentView(LAND_PAGE_FOOTER));
                }
                if (getFooterFragmentView(CHECKOUT_FOOTER) != null) {
                    hideGemItemAddedView((GemFooterMenuLevelView) getFooterFragmentView(CHECKOUT_FOOTER));
                }
            } else {
                this.miniCartLayout.showMiniCart(Cart.getInstance().getCartCount(), GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), Cart.getInstance().getCartSubTotalDisplayPrice(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
            }
            if (GlobalDataModel.GEMCONSTANTS.menuCouponSupressed) {
                GlobalDataModel.GEMCONSTANTS.menuCouponSupressed = false;
                if (!this.reloadmenuCalled) {
                    this.reloadmenuCalled = true;
                    refreshMenuAfterGem();
                }
            }
        }
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
    public void onMenuImageClicked(MenuItem menuItem, ImageView imageView) {
        GlobalDataModel.MENU.menuItem = menuItem;
        onMenuItemClicked(menuItem, imageView);
    }

    private void populateInfoRaw() {
        increaseCollapsingToolbarSize(this.infoRow);
        this.f54121q.setText(String.format(getString(R.string.grocery_info_delivery_time), new Object[]{this.menuScreenPresenter.getRestaurantDeliveryTime()}));
        this.f54122r.setText(this.menuScreenPresenter.getRestaurantDeliveryFee());
        this.f54123s.setText(this.menuScreenPresenter.getRestaurantMinOrder());
    }

    private void refreshMenuAfterGem() {
        initContinuousScrollingView();
    }

    /* access modifiers changed from: private */
    public void scrollRecyclerviewToPosition(int i11) {
        runOnUiThread(new p7(this, i11));
    }

    /* access modifiers changed from: private */
    public void scrollTabToPosition(int i11) {
        runOnUiThread(new n7(this, i11));
    }

    private void setGemFooterView() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(LAND_PAGE_FOOTER);
        if (findFragmentByTag != null) {
            getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commit();
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("isMinOrderPassed", Cart.getInstance().isMinimumOrderAmountPassed());
        bundle.putString("balance", Cart.getInstance().getQualifyAmount());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        GemFooterMenuLevelView gemFooterMenuLevelView = new GemFooterMenuLevelView();
        gemFooterMenuLevelView.setArguments(bundle);
        beginTransaction.replace((int) R.id.gem_holder_view, (Fragment) gemFooterMenuLevelView, CHECKOUT_FOOTER);
        beginTransaction.commit();
    }

    private void setGemHolderView() {
        if (Cart.getInstance().isMinimumOrderAmountPassed()) {
            ((GemFooterMenuLevelView) getFooterFragmentView(CHECKOUT_FOOTER)).setMinimumOrderPassedView(Cart.getInstance().getCartSubTotal());
        } else {
            ((GemFooterMenuLevelView) getFooterFragmentView(CHECKOUT_FOOTER)).setUnderMinimumOrder(Cart.getInstance().getCartSubTotal(), Cart.getInstance().getQualifyAmount());
        }
    }

    private void setGemLandPageView() {
        Fragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(CHECKOUT_FOOTER);
        if (findFragmentByTag != null) {
            getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commit();
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace((int) R.id.gem_holder_view, (Fragment) new GemFooterViewManager(), LAND_PAGE_FOOTER);
        beginTransaction.commit();
    }

    private void setUpValues() {
        this.restaurantName.setText(this.menuScreenPresenter.getRestuarantName());
        if (isValidContextForGlide(this)) {
            GlideApp.with((FragmentActivity) this).clear((View) this.restaurantImg);
            GlideApp.with((FragmentActivity) this).load(this.menuScreenPresenter.getHeroImage()).centerInside().into(this.restaurantImg);
        }
        this.deliveryTime.setText(this.menuScreenPresenter.getRestaurantDeliveryTime());
        this.mAppBar.setTranslationZ(20.0f);
        this.talabatGoTextView.setVisibility(8);
        if (this.menuScreenPresenter.isRestaurantAcceptDebitCard()) {
            this.knetIc.setVisibility(0);
            if (this.menuScreenPresenter.isSelectedCountryBahrain()) {
                this.knetIc.setImageResource(R.drawable.ic_bw_bahrainbenefit);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(CalculationUtil.convertDpToPx(14.0f, getContext()), CalculationUtil.convertDpToPx(18.0f, getContext()));
                layoutParams.setMargins(CalculationUtil.convertDpToPx(16.0f, getContext()), 0, 0, 0);
                this.knetIc.setLayoutParams(layoutParams);
            } else if (this.menuScreenPresenter.isSelectedCountryKuwait()) {
                this.knetIc.setImageResource(R.drawable.ic_bw_knet);
            }
        } else {
            this.knetIc.setVisibility(8);
        }
        if (this.menuScreenPresenter.isRestaurantAcceptCreditCard()) {
            this.visaIc.setVisibility(0);
            this.masterCardIc.setVisibility(0);
            if (this.f54130z.walletConfig().isAmexAvailable()) {
                this.americanExpressView.setVisibility(0);
            } else {
                this.americanExpressView.setVisibility(8);
            }
        } else {
            this.visaIc.setVisibility(8);
            this.masterCardIc.setVisibility(8);
            this.americanExpressView.setVisibility(8);
        }
        if (this.menuScreenPresenter.isRestaurantAcceptCash()) {
            this.cashIc.setVisibility(0);
        } else {
            this.cashIc.setVisibility(8);
        }
        Cart instance = Cart.getInstance();
        if (!instance.hasItems() || !instance.isRestaurantCart(GlobalDataModel.SELECTED.restaurant)) {
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                this.miniCartLayout.setVisibility(8);
                this.gemHolderLayout.setVisibility(0);
            } else {
                this.miniCartLayout.setVisibility(0);
                this.gemHolderLayout.setVisibility(8);
            }
        } else if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.miniCartLayout.setVisibility(8);
            this.gemHolderLayout.setVisibility(0);
        } else {
            this.miniCartLayout.setVisibility(0);
            this.gemHolderLayout.setVisibility(8);
        }
        if (this.menuScreenPresenter.getRestaurantOffers().size() > 0) {
            this.offersView.setVisibility(0);
            ((LinearLayout.LayoutParams) this.paymentOptionsSection.getLayoutParams()).rightMargin = (int) getResources().getDimension(R.dimen.menu_payment_icons_margin_12);
            this.paymentOptionsSection.setGravity(8388629);
            final String str = this.menuScreenPresenter.getRestaurantOffers().get(0).title;
            this.offersCount.setText(str);
            this.offersCount.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    GroceryMenuScreen.this.offersCount.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    boolean z11 = !GroceryMenuScreen.this.offersCount.getLayout().getText().toString().equalsIgnoreCase(str);
                    if (GroceryMenuScreen.this.menuScreenPresenter.getRestaurantOffers().size() > 1 || z11) {
                        GroceryMenuScreen.this.f54124t.setVisibility(0);
                    } else {
                        GroceryMenuScreen.this.f54124t.setVisibility(8);
                    }
                }
            });
        } else {
            ((LinearLayout.LayoutParams) this.paymentOptionsSection.getLayoutParams()).rightMargin = (int) getResources().getDimension(R.dimen.Margin_16);
            this.paymentOptionsSection.setGravity(8388629);
            this.offersView.setVisibility(8);
        }
        this.f54124t.setOnClickListener(new k7(this));
        this.menuRecyclerView.setVisibility(0);
        this.tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorSecondary));
        this.tabLayout.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.tab_layout_height));
        this.tabLayout.setSelectedTabIndicatorHeight((int) getResources().getDimension(R.dimen.tab_layout_height));
        this.categoriesView.setElevation(4.0f);
        this.categoriesView.setTranslationZ(4.0f);
        this.categoriesView.animate().translationZ(4.0f);
        this.itemsRecyclerView.setNestedScrollingEnabled(false);
        this.menuCategoryAdapter = new MenuCategoryAdapter(this, this.menuScreenPresenter.getRestaurantMenuSectionsAndItemCount());
        this.itemsRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.itemsRecyclerView.setAdapter(this.menuCategoryAdapter);
        this.closeCategoriesIcon.setOnClickListener(new r7(this));
        this.closeCategoriesView.setOnClickListener(new s7(this));
        if (this.menuScreenPresenter.getRestaurantMenuSectionsAndItemCount() != null && this.menuScreenPresenter.getRestaurantMenuSectionsAndItemCount().size() > 9) {
            int i11 = Resources.getSystem().getDisplayMetrics().heightPixels;
            this.fullScreenHeight = i11;
            int i12 = (i11 * 30) / 100;
            this.requiredHeight = i12;
            this.calculatedHeightForContentView = i11 - i12;
            this.contentView.getLayoutParams().height = this.calculatedHeightForContentView;
        }
        this.contentView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                GroceryMenuScreen.this.contentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                GroceryMenuScreen.this.contentView.animate().translationY(0.0f);
            }
        });
        this.categoriesView.setOnClickListener(new t7(this));
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

    private void showMenuCategoriesPopup() {
        if (this.categoriesView.getVisibility() != 0) {
            this.categoriesView.setVisibility(0);
            slideUp(this.categoriesView, this.contentView);
        }
    }

    /* access modifiers changed from: private */
    public void showRestaurantSummaryPopup() {
        new AlertDialog.Builder(this, R.style.AlertDialogTheme).setTitle((CharSequence) getResources().getString(R.string.disclaimer)).setMessage((CharSequence) this.menuScreenPresenter.getRestaurantWarning().trim().replaceAll("(\\s){2,}", " ").replaceAll("(\\n){2,}", StringUtils.LF)).setCancelable(true).create().show();
    }

    private void transparentStatusAndNavigation() {
        getWindow().getDecorView().setSystemUiVisibility(PlatformPlugin.DEFAULT_SYSTEM_UI);
        setWindowFlag(67108864, false);
        getWindow().setStatusBarColor(0);
    }

    public void cartButtonClicked() {
        goToCart();
    }

    public void cartCountChanged() {
        Cart.getInstance();
        showSnackBar();
    }

    public void configureTheView() {
        String str;
        String str2;
        ArrayList<MenuSection> restaurantMenuSections = this.menuScreenPresenter.getRestaurantMenuSections();
        if (getIntent().hasExtra(OPNavigatorActions.ARG_SEARCH_TERM)) {
            str = getIntent().getStringExtra(OPNavigatorActions.ARG_SEARCH_TERM);
        } else {
            str = "N/A";
        }
        String str3 = str;
        if (!this.F) {
            IAppTracker iAppTracker = this.D;
            Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
            boolean hasIconForAllItems = this.menuScreenPresenter.hasIconForAllItems();
            String menuSectionNamesForGA = getMenuSectionNamesForGA(restaurantMenuSections);
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
            iAppTracker.onRestaurantInfoLoaded(this, restaurant, hasIconForAllItems, menuSectionNamesForGA, restaurantMenuSections, iRestaurantMenuScreenPresenterR.getCountOfItemsWithImages(iRestaurantMenuScreenPresenterR.getMenuItemsResponseModel()), this.menuScreenPresenter.getRestaurantMenuItems((ArrayList<MenuSection>) null).size(), str3);
        } else if (GlobalDataModel.SELECTED.restaurant != null) {
            TalabatTracker talabatTracker = this.E;
            Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
            String screenName = getScreenName();
            boolean hasIconForAllItems2 = this.menuScreenPresenter.hasIconForAllItems();
            String menuSectionNamesForGA2 = getMenuSectionNamesForGA(restaurantMenuSections);
            IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR2 = this.menuScreenPresenter;
            talabatTracker.track(new ShopDetailsLoadedEvent(false, restaurant2, (String) null, screenName, false, hasIconForAllItems2, menuSectionNamesForGA2, restaurantMenuSections, iRestaurantMenuScreenPresenterR2.getCountOfItemsWithImages(iRestaurantMenuScreenPresenterR2.getMenuItemsResponseModel()), this.menuScreenPresenter.getRestaurantMenuItems((ArrayList<MenuSection>) null).size(), str3, new EventDataHelper()));
        }
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            if (GEMEngine.getInstance() != null) {
                str2 = GEMEngine.getInstance().getTimeInSeconds();
            } else {
                str2 = "";
            }
            AppTracker.onJokerShopLoaded(this, str2, GlobalDataModel.SELECTED.restaurant);
        }
        initVariables();
        setUpValues();
        initContinuousScrollingView();
    }

    public void destroyPresenter() {
    }

    public String getDisplayAmountForEmptyCart() {
        return TalabatFormatter.getInstance().getFormattedCurrency(0.0f);
    }

    public Context getGemContext() {
        return this;
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public IGlobalPresenter getPresenter() {
        return this.menuScreenPresenter;
    }

    public String getScreenName() {
        return ScreenNames.GROCERYMENUSCREEN;
    }

    public int getStatusBarHeight() {
        int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void hidePreviousOrderList() {
    }

    public boolean isAreaChoosen() {
        return this.isAreaChoosen;
    }

    public /* synthetic */ void navigateToMenuWithChoiceNativeScreen() {
        b.a(this);
    }

    public /* synthetic */ void navigateToMenuWithoutChoiceNativeScreen() {
        b.b(this);
    }

    public /* synthetic */ void navigateToVendorInfoNativeScreen() {
        b.c(this);
    }

    public /* synthetic */ void navigateToVendorReviewsNativeScreen() {
        b.d(this);
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAreaChoosed() {
        startActivity(new Intent(this, GroceryMenuScreen.class));
        this.isAreaChoosen = true;
        finish();
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            if (this.mGemDialogSwitcher == null) {
                this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
            }
            this.mGemDialogSwitcher.showGemDialog(1, false);
        } else if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            startActivity(new Intent(this, HomeScreenActivity.class));
        } else {
            GlobalDataModel.backFromMenuToList = true;
            finish();
        }
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().rejectGem(false);
        }
        GlobalDataModel.backFromMenuToList = true;
        finish();
    }

    public void onBinResponseReceived(BinTokenRM binTokenRM, String str) {
    }

    public void onCartIconClicked(MenuItem menuItem, ImageView imageView, String str) {
        if (!GlobalDataModel.MENU.AddToCartClicked) {
            startLodingPopup();
            GlobalDataModel.MENU.AddToCartClicked = true;
            this.transitionImageView = imageView;
            this.globalMenuItem = menuItem;
            if (!menuItem.willHaveChoices()) {
                onReadyToAddItem(str);
            } else if (!this.globalMenuItem.isChoicesLoaded()) {
                IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
                if (iRestaurantMenuScreenPresenterR != null) {
                    iRestaurantMenuScreenPresenterR.getChoiceSection(this.globalMenuItem.f13861id);
                }
            } else {
                onReadyToAddItem(str);
            }
        }
    }

    public void onChoiceReceived(SplitChoiceItemModel splitChoiceItemModel) {
        if (!this.fromGlobalSearch) {
            this.globalMenuItem.choiceSections = splitChoiceItemModel.choiceSections;
            onReadyToNavigatetoItemDetails();
            return;
        }
        this.fromGlobalSearch = false;
        this.f54117m.choiceSections = splitChoiceItemModel.choiceSections;
        goToItemDetailsScreen();
    }

    public void onClick(View view) {
    }

    public void onCloseButtonClicked(Dialog dialog) {
        Dialog dialog2;
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().rejectGem(false);
        }
        dialog.dismiss();
        GlobalDataModel.GEMCONSTANTS.isGemFlow = false;
        GlobalDataModel.GEMCONSTANTS.isGemForthankyou = false;
        GlobalDataModel.GEMCONSTANTS.isAdDisableGem = false;
        GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice = 0.0f;
        GemDialogSwitcher gemDialogSwitcher = this.mGemDialogSwitcher;
        if (!(gemDialogSwitcher == null || (dialog2 = gemDialogSwitcher.dialog) == null)) {
            dialog2.dismiss();
        }
        if (Cart.getInstance().hasItems()) {
            showSnackBar();
        } else if (getFooterFragmentView(LAND_PAGE_FOOTER) != null) {
            hideGemLandPageView((GemFooterViewManager) getFooterFragmentView(LAND_PAGE_FOOTER));
        }
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    @SuppressLint({"WrongViewCast"})
    public void onCreate(Bundle bundle) {
        int intExtra;
        int intExtra2;
        ApiContainer apiContainer = (ApiContainer) getApplication();
        this.E = ((TrackingCoreLibApi) ((ApiContainer) getApplication()).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
        DaggerGroceryMenuScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class)).inject(this);
        super.onCreate(bundle);
        this.F = this.A.getFeatureFlag(PlatformFeatureFlagsKeys.TRACKING_LIBRARY_MIGRATION, false);
        try {
            setContentView((int) R.layout.grocery_menu_screen);
            this.menuScreenPresenter = new RestaurantMeuScreenPresenterR(this.f54127w, this, this.A, TalabatExperiment.INSTANCE, this.f54128x, this.f54129y, this.f54130z, this.B);
            this.mReviewPresenter = new RestaurantReviewPresenter(this.f54127w, this);
            this.f54114j = new MenuListModel();
            this.mReviewPresenter.loadRestaurantReview(this.menuScreenPresenter.getBranchId(), 1);
            configureTheView();
            AppTracker.onNewMenuOpened(this, true);
            this.isBrandMapFlow = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.IS_FROM_BRAND_REORDER_MAP_FLOW, false);
            Class<GroceryMenuSearchActivity> cls = GroceryMenuSearchActivity.class;
            if (getIntent().getStringExtra("from").equals("SEARCH_SCREEN")) {
                if (getIntent().hasExtra("itemId") && (intExtra2 = getIntent().getIntExtra("itemId", -1)) > -1) {
                    MenuItem restaurantMenuItem = this.menuScreenPresenter.getRestaurantMenuItem(intExtra2);
                    this.f54117m = restaurantMenuItem;
                    if (restaurantMenuItem.f13861id != intExtra2) {
                        String stringExtra = getIntent().getStringExtra("searchTerm");
                        if (!TalabatUtils.isNullOrEmpty(stringExtra)) {
                            startActivity(new Intent(this, cls).putExtra("searchTerm", stringExtra));
                        }
                    } else if (!restaurantMenuItem.willHaveChoices()) {
                        goToItemDetailsScreen();
                    } else if (!this.f54117m.isChoicesLoaded()) {
                        startLodingPopup();
                        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
                        if (iRestaurantMenuScreenPresenterR != null) {
                            this.fromGlobalSearch = true;
                            iRestaurantMenuScreenPresenterR.getChoiceSection(this.f54117m.f13861id);
                        }
                    } else {
                        goToItemDetailsScreen();
                    }
                }
            } else if (getIntent() == null || !getIntent().hasExtra(NavigationMethodChannel.TOSCREEN)) {
                if (getIntent().hasExtra("itemId") && (intExtra = getIntent().getIntExtra("itemId", -1)) > -1) {
                    MenuItem restaurantMenuItem2 = this.menuScreenPresenter.getRestaurantMenuItem(intExtra);
                    this.f54117m = restaurantMenuItem2;
                    if (restaurantMenuItem2.f13861id != intExtra) {
                        String stringExtra2 = getIntent().getStringExtra("searchTerm");
                        if (!TalabatUtils.isNullOrEmpty(stringExtra2)) {
                            startActivity(new Intent(this, cls).putExtra("searchTerm", stringExtra2));
                        }
                    } else if (!restaurantMenuItem2.willHaveChoices()) {
                        goToItemDetailsScreen();
                    } else if (!this.f54117m.isChoicesLoaded()) {
                        startLodingPopup();
                        IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR2 = this.menuScreenPresenter;
                        if (iRestaurantMenuScreenPresenterR2 != null) {
                            this.fromGlobalSearch = true;
                            iRestaurantMenuScreenPresenterR2.getChoiceSection(this.f54117m.f13861id);
                        }
                    } else {
                        goToItemDetailsScreen();
                    }
                }
            } else if (getIntent().getStringExtra(NavigationMethodChannel.TOSCREEN).equals("search")) {
                String stringExtra3 = getIntent().getStringExtra("searchTerm");
                if (!TalabatUtils.isNullOrEmpty(stringExtra3)) {
                    startActivity(new Intent(this, cls).putExtra("searchTerm", stringExtra3));
                }
            }
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(e11.getLocalizedMessage());
        }
    }

    public void onError() {
    }

    public void onFragmentHeightObtained(int i11) {
    }

    public void onFragmentLoaded(boolean z11, String str) {
        ((GemFooterMenuLevelView) getFooterFragmentView(CHECKOUT_FOOTER)).setGemOfferArray();
        setGemHolderView();
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onItemAdded(CartMenuItem cartMenuItem) {
        cartCountChanged();
        showSingleToast();
        if (this.f54120p) {
            this.f54120p = false;
            GroceryHorizontalAdapter groceryHorizontalAdapter2 = this.groceryHorizontalAdapter;
            if (groceryHorizontalAdapter2 != null) {
                groceryHorizontalAdapter2.notifyDataSetChanged();
            }
        }
    }

    public void onLandedFragmentLoaded() {
    }

    public void onLeaveOfferClicked(boolean z11) {
        String str;
        Dialog dialog;
        if (GEMEngine.getInstance() != null) {
            str = GEMEngine.getInstance().getTimeInSeconds();
        } else {
            str = "";
        }
        AppTracker.onJokerShopAbandonStarted(this, str, GlobalDataModel.SELECTED.restaurant);
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().rejectGem(true);
        }
        GlobalDataModel.GEMCONSTANTS.isGemFlow = false;
        GlobalDataModel.GEMCONSTANTS.isGemForthankyou = false;
        GlobalDataModel.GEMCONSTANTS.isAdDisableGem = false;
        GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice = 0.0f;
        if (!this.reloadmenuCalled) {
            this.reloadmenuCalled = true;
            GlobalDataModel.GEMCONSTANTS.menuCouponSupressed = false;
            refreshMenuAfterGem();
        }
        GemDialogSwitcher gemDialogSwitcher = this.mGemDialogSwitcher;
        if (!(gemDialogSwitcher == null || (dialog = gemDialogSwitcher.dialog) == null)) {
            dialog.dismiss();
        }
        if (Cart.getInstance().hasItems()) {
            showSnackBar();
        } else if (getFooterFragmentView(LAND_PAGE_FOOTER) != null) {
            hideGemLandPageView((GemFooterViewManager) getFooterFragmentView(LAND_PAGE_FOOTER));
        }
        if (!z11) {
            goToBackScreen();
        }
    }

    public void onMaxCartItemsReached() {
        Toast.makeText(this, getString(R.string.max_cart_items), 0).show();
    }

    public void onMenuItemClicked(MenuItem menuItem, ImageView imageView) {
        if (!GlobalDataModel.MENU.ChoiceClicked) {
            startLodingPopup();
            GlobalDataModel.MENU.ChoiceClicked = true;
            this.transitionImageView = imageView;
            this.globalMenuItem = menuItem;
            if (!menuItem.willHaveChoices()) {
                onReadyToNavigatetoItemDetails();
            } else if (!menuItem.isChoicesLoaded()) {
                IRestaurantMenuScreenPresenterR iRestaurantMenuScreenPresenterR = this.menuScreenPresenter;
                if (iRestaurantMenuScreenPresenterR != null) {
                    iRestaurantMenuScreenPresenterR.getChoiceSection(menuItem.f13861id);
                }
            } else {
                onReadyToNavigatetoItemDetails();
            }
        }
    }

    public void onNavigateToItemDetails(CartMenuItem cartMenuItem, ImageView imageView) {
        GlobalDataModel.SELECTED.cartMenuItem = cartMenuItem;
        startActivity(new Intent(this, ItemDetailsActivity.class));
        stopLodingPopup();
    }

    public void onNoChoiceAvailable() {
        if (this.fromGlobalSearch) {
            stopLodingPopup();
        }
    }

    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.info) {
            AppTracker.onTabInfoClicked(this, GlobalDataModel.SELECTED.restaurant);
            Intent intent = new Intent(this, RestaurantInfoActivity.class);
            intent.putExtra(GlobalConstants.ExtraNames.INFO_HERO_IMG, this.menuScreenPresenter.getHeroImage());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onParallelBinAvailable() {
        int i11;
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.adjusting = true;
            this.mCollapsingToolBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    GroceryMenuScreen.this.mCollapsingToolBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    GroceryMenuScreen groceryMenuScreen = GroceryMenuScreen.this;
                    groceryMenuScreen.oldSize = groceryMenuScreen.mCollapsingToolBar.getHeight();
                }
            });
            TextView textView = this.parallelBinMore;
            if (GlobalDataModel.PARALLELBIN.moreBinModels.size() > 0) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            textView.setVisibility(i11);
            this.parallelBinMore.setOnClickListener(new o7(this));
            if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.PARALLELBIN.commonMessage)) {
                this.parallelText.setVisibility(0);
                this.parallelText.setText(GlobalDataModel.PARALLELBIN.commonMessage);
            } else {
                this.parallelText.setVisibility(4);
            }
            this.parallelBinImageView.setVisibility(0);
            this.parallelBinDataReceived = true;
            this.parallelBinView.setAlpha(0.0f);
            this.parallelBinView.setVisibility(0);
            this.parallelBinView.animate().alpha(1.0f).setDuration(600).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    GroceryMenuScreen.this.increaseCollapsingToolbarSize();
                }
            });
        }
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onReadyToAddItem(String str) {
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.globalMenuItem);
        createWithMenuItem.setQuantity(1);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant));
        stopLodingPopup();
        this.menuScreenPresenter.addItem(GlobalDataModel.SELECTED.restaurant, createWithMenuItem, str);
        GlobalDataModel.MENU.AddToCartClicked = false;
    }

    public void onReadyToNavigatetoItemDetails() {
        if (GlobalDataModel.MENU.AddToCartClicked) {
            GlobalDataModel.MENU.AddToCartClicked = false;
        }
        CartMenuItem createWithMenuItem = CartMenuItem.createWithMenuItem(this.globalMenuItem);
        onNavigateToItemDetails(createWithMenuItem, this.transitionImageView);
        AppTracker.onProductClicked(this, createWithMenuItem, AppTracker.getRestaurantName(GlobalDataModel.SELECTED.restaurant));
        GlobalDataModel.MENU.ChoiceClicked = false;
    }

    public void onResume() {
        super.onResume();
        GlobalDataModel.MENU.AddToCartClicked = false;
        GlobalDataModel.MENU.ChoiceClicked = false;
        modifyCartFooter();
        GroceryHorizontalAdapter groceryHorizontalAdapter2 = this.groceryHorizontalAdapter;
        if (groceryHorizontalAdapter2 != null) {
            groceryHorizontalAdapter2.notifyDataSetChanged();
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

    public void onStart() {
        super.onStart();
        if (Cart.getInstance() == null || Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().getId() != GlobalDataModel.SELECTED.restaurant.getId()) {
            this.miniCartLayout.showMiniCart(0, GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        } else {
            this.miniCartLayout.showMiniCart(Cart.getInstance().getCartCount(), GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), Cart.getInstance().getCartSubTotalDisplayPrice(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        }
    }

    public void onStop() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        super.onStop();
    }

    public void onViewCartClicked() {
        goToCart();
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showGemLandingPage() {
        this.miniCartLayout.setVisibility(8);
        setGemLandPageView();
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showRestaurantChangePopup(Restaurant restaurant, PreviousOrder previousOrder) {
    }

    public void showRestaurantChangePopup(final Restaurant restaurant, final CartMenuItem cartMenuItem) {
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        String replace = getString(R.string.cart_will_be_cleared).replace("#", "\"" + instance.getRestaurant().f13873name + "\"");
        builder.setTitle((CharSequence) getString(R.string.start_new_cart));
        builder.setMessage((CharSequence) replace);
        builder.setPositiveButton((CharSequence) getString(R.string.start), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                GroceryMenuScreen groceryMenuScreen = GroceryMenuScreen.this;
                groceryMenuScreen.f54120p = true;
                groceryMenuScreen.menuScreenPresenter.changeRestaurantAndAddItem(GroceryMenuScreen.this, restaurant, cartMenuItem);
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
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            if (((GemFooterMenuLevelView) getFooterFragmentView(CHECKOUT_FOOTER)) == null) {
                setGemFooterView();
            } else {
                setGemHolderView();
            }
            this.gemHolderLayout.setVisibility(0);
            this.miniCartLayout.setVisibility(8);
            return;
        }
        this.gemHolderLayout.setVisibility(8);
        this.miniCartLayout.setVisibility(0);
        if (Cart.getInstance() == null || Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().getId() != GlobalDataModel.SELECTED.restaurant.getId()) {
            this.miniCartLayout.showMiniCart(0, GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), getDisplayAmountForEmptyCart(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        } else {
            this.miniCartLayout.showMiniCart(Cart.getInstance().getCartCount(), GlobalDataModel.SELECTED.restaurant.getDisplayDeliveryCharges(), GlobalDataModel.SELECTED.restaurant.getDisplayMinimumAmount(), Cart.getInstance().getCartSubTotalDisplayPrice(), GlobalDataModel.SELECTED.restaurant.isSubscriptionAvailable());
        }
    }

    public void showTimeOutDialog() {
        Dialog dialog;
        GemDialogSwitcher gemDialogSwitcher = this.mGemDialogSwitcher;
        if (!(gemDialogSwitcher == null || (dialog = gemDialogSwitcher.dialog) == null)) {
            dialog.hide();
        }
        showGemTimeOutDialog(this.mGemDialogSwitcher, (GemFooterCartView) null, this, this);
        if (Cart.getInstance().hasItems()) {
            showSnackBar();
        } else if (getFooterFragmentView(LAND_PAGE_FOOTER) != null) {
            hideGemLandPageView((GemFooterViewManager) getFooterFragmentView(LAND_PAGE_FOOTER));
        }
    }

    public void showTimerView(boolean z11, String str) {
        if (getFooterFragmentView(LAND_PAGE_FOOTER) != null) {
            ((GemFooterViewManager) getFooterFragmentView(LAND_PAGE_FOOTER)).refreshTimer(str);
        } else if (getFooterFragmentView(CHECKOUT_FOOTER) != null) {
            ((GemFooterMenuLevelView) getFooterFragmentView(CHECKOUT_FOOTER)).setTimerText(str);
        }
    }

    public void slideDown(View view, final View view2) {
        AppTracker.onCategorySelectorClosed(this);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) view.getHeight());
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                view2.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        view.startAnimation(translateAnimation);
    }

    public void slideUp(final View view, View view2) {
        AppTracker.onCategorySelectorOpened(this);
        view2.setVisibility(0);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) view2.getHeight(), 0.0f);
        translateAnimation.setDuration(500);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
            }
        });
        view2.startAnimation(translateAnimation);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }

    public void onNavigateToItemDetails(CartMenuItem cartMenuItem) {
        GlobalDataModel.SELECTED.cartMenuItem = cartMenuItem;
        startActivity(new Intent(this, ItemDetailsActivity.class));
        stopLodingPopup();
    }

    /* access modifiers changed from: private */
    public synchronized void increaseCollapsingToolbarSize(final View view) {
        if (view != null) {
            this.mCollapsingToolBar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    GroceryMenuScreen.this.mCollapsingToolBar.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                        /* access modifiers changed from: private */
                        public /* synthetic */ void lambda$onGlobalLayout$0(ValueAnimator valueAnimator) {
                            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                            GroceryMenuScreen.this.mLinearLayoutRestaurantInfo.getMeasuredHeight();
                            ViewGroup.LayoutParams layoutParams = GroceryMenuScreen.this.mCollapsingToolBar.getLayoutParams();
                            layoutParams.height = intValue;
                            GroceryMenuScreen.this.mCollapsingToolBar.setLayoutParams(layoutParams);
                            GroceryMenuScreen.this.mCollapsingToolBar.requestLayout();
                        }

                        public void onGlobalLayout() {
                            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            GroceryMenuScreen.this.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{GroceryMenuScreen.this.mCollapsingToolBar.getMeasuredHeight(), ((int) (((float) displayMetrics.widthPixels) / 2.0f)) + GroceryMenuScreen.this.searchContainer.getMeasuredHeight() + GroceryMenuScreen.this.mLinearLayoutRestaurantInfo.getMeasuredHeight()});
                            ofInt.addUpdateListener(new g(this));
                            ofInt.addListener(new AnimatorListenerAdapter() {
                                public void onAnimationEnd(Animator animator) {
                                    GroceryMenuScreen.this.mCollapsingToolBar.requestLayout();
                                }
                            });
                            ofInt.setDuration(250);
                            ofInt.start();
                        }
                    });
                }
            });
        }
    }
}
