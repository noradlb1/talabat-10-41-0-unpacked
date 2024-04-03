package com.talabat;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import JsonModels.parser.UniversalGson;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import buisnessmodels.Cart;
import buisnessmodels.GEMEngine;
import buisnessmodels.McdMapTempAddress;
import buisnessmodels.TalabatFormatter;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.designsystem.ds_tag.DSTag;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.busypopup.BusyPopupBottomSheet;
import com.talabat.busypopup.BusyPopupDialogFragmentCallbacks;
import com.talabat.components.gem.cart.GemCartCustomizationViewHolderBinder;
import com.talabat.components.gem.cart.GemCartScreenBinder;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.ExperimentCoreLibApi;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.menu.MenuExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.search.SearchFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListRemoteConfigurationsKeys;
import com.talabat.core.navigation.domain.NavigationCoreLibApi;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.observabilityNew.domain.squads.cart.CartScreenPerformanceParams;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.designhelpers.CustomLayoutmanger;
import com.talabat.designhelpers.GravitySnapHelper;
import com.talabat.di.cart.DaggerCartScreenComponent;
import com.talabat.dialogs.ParallelBinDialog;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.fees.presentation.displaymodel.DisclaimerBannerDisplayModel;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;
import com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModel;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModelFactory;
import com.talabat.feature.foodcart2.domain.di.FoodCartFeatureApi;
import com.talabat.feature.incentiveautoapplydiscounts.domain.GetAutoApplyDiscountsUseCase;
import com.talabat.feature.incentiveautoapplydiscounts.domain.di.IncentiveAutoApplyDiscountsFeatureApi;
import com.talabat.feature.pickup.presentation.entity.PickupConfig;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import com.talabat.fees.ServiceFeeView;
import com.talabat.fees.ShowFeesDescriptionBottomSheetClickListener;
import com.talabat.fees.SmallOrderFeeView;
import com.talabat.fluttercore.channels.NavigationMethodChannel;
import com.talabat.gem.adapters.analytics.GemPageType;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.ReorderItemMissingViewHolder;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.location.LocationDependencyProvider;
import com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCase;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.talabatcommon.extentions.Flag;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.helpers.TalabatGlideModule;
import com.talabat.talabatcommon.views.banners.DisclaimerBannerView;
import com.talabat.talabatcommon.views.bottomsheet.OnReadMoreInfoClickedCallback;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersViewCallback;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModelKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModelForResult;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import com.talabat.talabatnavigation.userandlocation.ComplianceUserStatusActions;
import com.talabat.talabatnavigation.userandlocation.EmailLoginActivityResults;
import com.talabat.talabatremoteconfiguration.RemoteConfiguration;
import com.talabat.ul.addressform.FlutterAddressFormActivity;
import com.talabat.user.address.di.AddressesDependencyProvider;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.login.ui.LoginOptionsBottomSheet;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorController;
import com.talabat.vendormenu.presentation.flutter.MenuNavigatorModel;
import datamodels.BenefitItem;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.Coupon;
import datamodels.Cuisine;
import datamodels.MenuItem;
import datamodels.Promotion;
import datamodels.RatingSection;
import datamodels.Restaurant;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.cart.CartAdapterListener;
import library.talabat.mvp.cart.CartPresenter;
import library.talabat.mvp.cart.CartUtility;
import library.talabat.mvp.cart.CartView;
import library.talabat.mvp.cart.ICartPresenter;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.login.di.DependencyProvider;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import tracking.AppTracker;
import tracking.ScreenNames;
import ue.a1;
import ue.a2;
import ue.b1;
import ue.b2;
import ue.c1;
import ue.c2;
import ue.d1;
import ue.d2;
import ue.e1;
import ue.e2;
import ue.f1;
import ue.f2;
import ue.g1;
import ue.h1;
import ue.i1;
import ue.j1;
import ue.k1;
import ue.l1;
import ue.m0;
import ue.m1;
import ue.n0;
import ue.n1;
import ue.o0;
import ue.o1;
import ue.p0;
import ue.p1;
import ue.q0;
import ue.q1;
import ue.r0;
import ue.r1;
import ue.s0;
import ue.s1;
import ue.t0;
import ue.t1;
import ue.u0;
import ue.u1;
import ue.v0;
import ue.v1;
import ue.w0;
import ue.w1;
import ue.x0;
import ue.x1;
import ue.y0;
import ue.y1;
import ue.z0;
import ue.z1;
import xq.b;
import yq.a;

@Instrumented
@GemPageType("cart")
public class CartScreen extends TalabatBase implements CartView, GemView, OnGemAlertDialogClickListener, GemAccessor, BusyPopupDialogFragmentCallbacks, OnReadMoreInfoClickedCallback {
    private static final int ADDRESS_PAGE = 300;
    private static final int LOGIN_BOTTOM_SHEET = 201;
    private static final int LOGIN_PAGE = 200;
    private static final int REQUEST_CODE_VERIFY_USER_ALLOWED_TO_ORDER = 500;
    private static final int RESULT_COUNT = 5;
    private static final int SELECT_FREE_ITEM = 100;
    private static final String SERVICE_FEE_ALERT_TYPE = "serviceFees";
    private static final String TAG = "CartScreen";
    public static final int VIEWTYPE_CART = 0;
    public static final int VIEWTYPE_CART_CUSTOMIZATION_FOOTER = 5;
    public static final int VIEWTYPE_COUPONS = 1;
    public static final int VIEWTYPE_PROMOTIONS = 2;
    public static final int VIEWTYPE_REORDER = 6;
    public static final int VIEWTYPE_UPSELLING = 4;
    @Inject
    public DeepLinkNavigator A;
    @Inject
    public GetTProOrderStatusUseCase B;
    @Inject
    public GetActiveSubscriptionsRxWrapper C;
    @Inject
    public ISubscriptionStatusRepository D;
    @Inject
    public CustomerRepository E;
    @Inject
    public IScreenTracker F;
    public FeesViewModel G;
    @Inject
    public GetAutoApplyDiscountsUseCase H;
    private Button addItems;
    private Button add_moreItems;
    @VisibleForTesting
    public ApplyVouchersViewCallback applyVouchersViewCallback = new ApplyVouchersViewCallback() {
        public void applyVouchersViewFailure(@NotNull VoucherFailures voucherFailures) {
        }

        @NotNull
        public String getBranchId() {
            int i11;
            if (Cart.getInstance().getRestaurant() != null) {
                i11 = Cart.getInstance().getRestaurant().branchId;
            } else {
                i11 = 0;
            }
            return String.valueOf(i11);
        }

        @Nullable
        public List<CartMenuItem> getCartItem() {
            return Cart.getInstance().getCartItems();
        }

        public float getCartSubtotalForVoucherMov() {
            return Cart.getInstance().getCartSubTotal(true, true);
        }

        @NonNull
        public String getGroceryVendorId() {
            return Cart.getInstance().getDarkstoresDjiniVendorId();
        }

        @NotNull
        public String getRestaurantId() {
            int i11;
            if (Cart.getInstance().getRestaurant() != null) {
                i11 = Cart.getInstance().getRestaurant().f13872id;
            } else {
                i11 = 0;
            }
            return String.valueOf(i11);
        }

        public Integer getVerticalId() {
            int i11;
            if (Cart.getInstance().getRestaurant() != null) {
                i11 = Cart.getInstance().getRestaurant().shopType;
            } else {
                i11 = -1;
            }
            return Integer.valueOf(i11);
        }

        public void redirectToLogin() {
            CartScreen.this.isFromVoucherViewToLogin = new Flag(true);
            CartScreen.this.cartPresenter.redirectToLogin();
        }

        public void successApplyFreeItemVoucher(@NotNull Pair<VoucherData, VoucherItemsDisplayModel> pair) {
            if (!Cart.getInstance().isItemExistInCart(pair.getSecond().getResult().getId())) {
                Cart.getInstance().addItem(VoucherItemsDisplayModelKt.createCartMenuItem(pair.getSecond()), CartScreen.this.getApplicationContext());
                CartScreen.this.cartRecyclerviewAdapter.notifyDataSetChanged();
            }
            CartScreen.this.voucherApplied(pair.getFirst());
        }

        public void successApplyVoucher(@NotNull VoucherData voucherData) {
            CartScreen.this.voucherApplied(voucherData);
        }

        public void unAppliedAllVouchers() {
            CartScreen.this.cartPresenter.getCartFooterListener().removeVoucher();
        }
    };
    private ImageButton backButton;
    private View cartEmptyView;
    private View cartFullView;
    /* access modifiers changed from: private */
    public RecyclerView cartList;
    /* access modifiers changed from: private */
    public ICartPresenter cartPresenter;
    public CartRecyclerviewAdapter cartRecyclerviewAdapter;
    private Button clear_cart;
    private final BroadcastReceiver closeActivityReceiver = new CloseCartBroadcastReceiver();
    private Button continueButton;
    private Button delete;
    public SparseBooleanArray deleteSelectionItems;
    /* access modifiers changed from: private */
    public FeeValue deliveryFee;
    /* access modifiers changed from: private */
    public DisclaimerBannerDisplayModel disclaimerBannerDisplayModel;
    private Button edit_cart;
    /* access modifiers changed from: private */
    public FeesDescriptionsDisplayModel feesDescriptions;
    private boolean fromCardScreen = false;
    private String fromScreen = "";

    /* renamed from: i  reason: collision with root package name */
    public LinearLayoutManager f53701i;
    /* access modifiers changed from: private */
    public boolean isEditing;
    /* access modifiers changed from: private */
    @Nullable
    public Flag isFromVoucherViewToLogin = null;
    private boolean isRedirecting = false;
    private boolean ismcdKsaAddressUpdateIgnore = false;

    /* renamed from: j  reason: collision with root package name */
    public SpeedyLinearLayoutManager f53702j;

    /* renamed from: k  reason: collision with root package name */
    public UpSellingSectionDataAdapter f53703k;

    /* renamed from: l  reason: collision with root package name */
    public GemFooterCartView f53704l;
    /* access modifiers changed from: private */
    public ApplyVouchersView loyaltyDashboardApplyVouchersView = null;

    /* renamed from: m  reason: collision with root package name */
    public int f53705m;
    private GemDialogSwitcher mGemDialogSwitcher;
    /* access modifiers changed from: private */
    public Toolbar mToolbar;
    /* access modifiers changed from: private */
    public int mainListTotalCount = 0;
    private TextView minimumOrderAmount;

    /* renamed from: n  reason: collision with root package name */
    public Handler f53706n;

    /* renamed from: o  reason: collision with root package name */
    public Runnable f53707o;
    @Inject

    /* renamed from: p  reason: collision with root package name */
    public AppVersionProvider f53708p;
    /* access modifiers changed from: private */
    public ImageView parallelBinImage;
    /* access modifiers changed from: private */
    public View parallelBinImageView;
    private TextView parallelBinMore;
    /* access modifiers changed from: private */
    public ProgressBar parallelBinProgressBar;
    /* access modifiers changed from: private */
    public View parallelBinView;
    /* access modifiers changed from: private */
    public boolean parallelBinViewClosed = false;
    private TextView parallelText;
    private Dialog popupWindow;
    @Inject

    /* renamed from: q  reason: collision with root package name */
    public DiscoveryConfigurationRepository f53709q;
    @Inject

    /* renamed from: r  reason: collision with root package name */
    public ConfigurationLocalRepository f53710r;
    private TextView restaurantArea;
    private TextView restaurantName;
    @Inject

    /* renamed from: s  reason: collision with root package name */
    public LocationConfigurationRepository f53711s;
    /* access modifiers changed from: private */
    public FeeValue serviceFee;
    private boolean showLoadingForCoupons;
    /* access modifiers changed from: private */
    public FeeValue smallOrderFee;
    @Inject

    /* renamed from: t  reason: collision with root package name */
    public OrderExperienceConfigurationRepository f53712t;
    @Inject

    /* renamed from: u  reason: collision with root package name */
    public PaymentConfigurationRepository f53713u;
    /* access modifiers changed from: private */
    public int upsellingScrollPosition = 0;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public ITalabatFeatureFlag f53714v;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public ITalabatExperiment f53715w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public FeesViewModelFactory f53716x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public CartUtility f53717y;
    @Inject

    /* renamed from: z  reason: collision with root package name */
    public Navigator f53718z;

    public class CartCustomizationViewHolder extends RecyclerView.ViewHolder {
        private final View aboutFees;
        private final FrameLayout applyVoucherViewContainer;
        private final View binDiscountLayout;
        private final TextView binDiscountValue;
        private final TextView deliveryChargeAmount;
        private final TextView deliveryChargesText;
        private final View deliveryChargesView;
        private final View deliveryFeeClickableArea;
        private final View deliveryFeeInfoIcon;
        private final DSTag deliveryFirstOrder;
        private final DisclaimerBannerView disclaimerBannerView;
        private final TextView discountAmount;
        private final View discountView;
        private final TextView discountVoucherAmount;
        private final TextView discountVoucherTxt;
        private final View discountVoucherView;
        private final TextView freeDeliverTypeVoucherAmount;
        private final TextView freeDeliveryMore;
        private final TextView freeDeliveryReturnAmount;
        private final TextView freeDeliverySavingsText;
        private final TalabatTextView freeDeliveryText;
        private final View freeDeliveryTypeVoucherLayout;
        private final TextView freeDeliveryTypeVoucherText;
        private final View freeDeliveryView;
        private final View gemDeductionView;
        private final TextView gemOfferAmount;
        private final TextView gemOfferText;
        private final EditText generalRequest;
        private final View generalRequestDisabledView;
        private final View generalRequestView;
        private final CheckBox goGreenCheckbox;
        private final View goGreenView;
        private final View muncipalityChargesView;
        private final TextView municipalityTaxAmount;
        private final TextView municipalityTaxText;
        private final TextView oldDeliveryChargeAmount;
        private final TextView removeVoucher;
        private final View savingsView;
        private final ServiceFeeView serviceFeeView;
        private final SmallOrderFeeView smallOrderFeeView;
        private final TextView specialRequestTitle;
        private final TextView subTotalAmount;
        private final View subTotalView;
        private final TextView talabatDeliveryVoucherAmount;
        private final View talabatDeliveryVoucherView;
        private final TextView totalAmount;
        private final View totalView;
        private final TextView touristTaxAmount;
        private final TextView touristTaxText;
        private final View touristTaxView;

        public CartCustomizationViewHolder(View view) {
            super(view);
            this.specialRequestTitle = (TextView) view.findViewById(R.id.special_request_title);
            this.generalRequestView = view.findViewById(R.id.general_request_view);
            this.generalRequest = (EditText) view.findViewById(R.id.general_request);
            this.deliveryFirstOrder = (DSTag) view.findViewById(R.id.delivery_first_order);
            this.generalRequestDisabledView = view.findViewById(R.id.general_request_disabled_view);
            this.goGreenView = view.findViewById(R.id.go_green_view);
            this.goGreenCheckbox = (CheckBox) view.findViewById(R.id.go_green_check_box);
            this.totalView = view.findViewById(R.id.total_view);
            this.totalAmount = (TextView) view.findViewById(R.id.total_amount);
            this.subTotalView = view.findViewById(R.id.sub_total_view);
            this.subTotalAmount = (TextView) view.findViewById(R.id.sub_total);
            this.discountView = view.findViewById(R.id.discount_view);
            this.discountAmount = (TextView) view.findViewById(R.id.disconut);
            this.gemOfferAmount = (TextView) view.findViewById(R.id.gem_offer_price);
            this.gemOfferText = (TextView) view.findViewById(R.id.gem_offer_text);
            this.gemDeductionView = view.findViewById(R.id.gem_discount_view);
            this.talabatDeliveryVoucherView = view.findViewById(R.id.talabat_delivery_voucher_discount_layout);
            this.talabatDeliveryVoucherAmount = (TextView) view.findViewById(R.id.talabat_delivery_voucher_discount_value);
            this.freeDeliveryTypeVoucherLayout = view.findViewById(R.id.free_delivery_voucher_layout);
            this.freeDeliverTypeVoucherAmount = (TextView) view.findViewById(R.id.free_delivery_voucher_amount);
            this.freeDeliveryTypeVoucherText = (TextView) view.findViewById(R.id.free_delivery_voucher_name);
            this.deliveryFeeClickableArea = view.findViewById(R.id.delivery_fee_clickable_area);
            this.deliveryFeeInfoIcon = view.findViewById(R.id.delivery_fee_tooltip_icon);
            this.deliveryChargesText = (TextView) view.findViewById(R.id.delivery_charges_text);
            this.oldDeliveryChargeAmount = (TextView) view.findViewById(R.id.old_delivery_charges);
            this.deliveryChargeAmount = (TextView) view.findViewById(R.id.delivery_charges_value);
            this.freeDeliveryText = (TalabatTextView) view.findViewById(R.id.free_delivery_text);
            this.freeDeliveryReturnAmount = (TextView) view.findViewById(R.id.free_delivery_return_value);
            this.freeDeliverySavingsText = (TextView) view.findViewById(R.id.free_delivery_savings_text);
            this.freeDeliveryMore = (TextView) view.findViewById(R.id.free_delivery_more);
            this.muncipalityChargesView = view.findViewById(R.id.muncipality_charges_view);
            this.municipalityTaxText = (TextView) view.findViewById(R.id.muncipality_charges_text);
            this.municipalityTaxAmount = (TextView) view.findViewById(R.id.muncipality_charges_value);
            this.touristTaxView = view.findViewById(R.id.tourist_tax_view);
            this.touristTaxText = (TextView) view.findViewById(R.id.tourist_tax_text);
            this.touristTaxAmount = (TextView) view.findViewById(R.id.tourist_tax_value);
            this.discountVoucherView = view.findViewById(R.id.dicount_voucher_layout);
            this.discountVoucherTxt = (TextView) view.findViewById(R.id.discount_txt);
            this.discountVoucherAmount = (TextView) view.findViewById(R.id.discount_voucher_value);
            this.removeVoucher = (TextView) view.findViewById(R.id.remove_voucher);
            this.binDiscountLayout = view.findViewById(R.id.bin_discount_layout);
            this.binDiscountValue = (TextView) view.findViewById(R.id.bin_discount_value);
            this.freeDeliveryView = view.findViewById(R.id.restaurant_free_delivery_view);
            this.deliveryChargesView = view.findViewById(R.id.restaurant_delivery_charges_view);
            this.savingsView = view.findViewById(R.id.savings_view);
            this.applyVoucherViewContainer = (FrameLayout) view.findViewById(R.id.cartFooterApplyVoucherLayout);
            this.serviceFeeView = (ServiceFeeView) view.findViewById(R.id.service_fee_view);
            this.smallOrderFeeView = (SmallOrderFeeView) view.findViewById(R.id.small_order_fee_view);
            this.aboutFees = view.findViewById(R.id.about_fees);
            this.disclaimerBannerView = (DisclaimerBannerView) view.findViewById(R.id.disclaimerBanner);
            addToCartCustomizationViewHolderApplyVoucherView();
            if (CartScreen.this.cartPresenter.getCartFooterListener().isPickup()) {
                CartScreen.this.applyPickupVoucher();
            }
        }

        private void addToCartCustomizationViewHolderApplyVoucherView() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.bottomMargin = CartScreen.this.getResources().getDimensionPixelSize(R.dimen.ds_l);
            layoutParams.topMargin = CartScreen.this.getResources().getDimensionPixelSize(R.dimen.ds_s);
            CartScreen.this.loyaltyDashboardApplyVouchersView = new ApplyVouchersView(CartScreen.this.getContext());
            CartScreen.this.loyaltyDashboardApplyVouchersView.setLayoutParams(layoutParams);
            this.applyVoucherViewContainer.addView(CartScreen.this.loyaltyDashboardApplyVouchersView);
            if (!CartScreen.this.isGemActive()) {
                this.applyVoucherViewContainer.setVisibility(0);
            }
            CartScreen.this.loyaltyDashboardApplyVouchersView.init(ApplyVoucherOwner.Basket, CartScreen.this.applyVouchersViewCallback);
        }

        private void adjustGeneralRequestVisibility(CartAdapterListener cartAdapterListener) {
            if (Cart.getInstance().getRestaurant() == null || !cartAdapterListener.disableGeneralRequest(Cart.getInstance().getRestaurant())) {
                this.generalRequestDisabledView.setVisibility(8);
                this.generalRequestView.setVisibility(0);
                return;
            }
            this.generalRequestDisabledView.setVisibility(0);
            this.generalRequestView.setVisibility(8);
            if (!cartAdapterListener.shouldShowNoCutlery()) {
                this.specialRequestTitle.setVisibility(8);
            }
        }

        private void bindCouponDiscountView(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.isCouponApplied()) {
                this.discountView.setVisibility(0);
                this.discountAmount.setText(cartAdapterListener.getCouponDiscountAmount());
                return;
            }
            this.discountView.setVisibility(8);
        }

        private void bindDeliveryChargesView(CartAdapterListener cartAdapterListener) {
            updateDeliveryFeeVisibility(cartAdapterListener.isPickup(), cartAdapterListener.isFreeDeliveryDiscountFull());
            int deliveryChargesTextColor = cartAdapterListener.getDeliveryChargesTextColor();
            this.deliveryChargesText.setTextColor(deliveryChargesTextColor);
            this.deliveryChargeAmount.setTextColor(deliveryChargesTextColor);
            if (CartScreen.this.deliveryFee != null) {
                this.deliveryChargesText.setText(CartScreen.this.deliveryFee.getLabel());
                this.deliveryChargeAmount.setText(CartScreen.this.deliveryFee.getFormattedValue());
                String tagLabel = CartScreen.this.deliveryFee.getTagLabel();
                if (tagLabel != null) {
                    TextView textView = this.deliveryChargeAmount;
                    textView.setPaintFlags(textView.getPaintFlags() | 16);
                    this.deliveryChargeAmount.setText(CartScreen.this.deliveryFee.getStandardFee());
                    this.deliveryFirstOrder.setTitle(tagLabel);
                    this.deliveryFirstOrder.setVisibility(0);
                    Cart.getInstance().setRemoteDeliveryFee((float) CartScreen.this.deliveryFee.getValue());
                } else {
                    this.deliveryFirstOrder.setVisibility(8);
                }
            } else {
                this.deliveryChargesText.setText(cartAdapterListener.getDeliveryChargeText());
                this.deliveryChargeAmount.setText(cartAdapterListener.getDeliveryCharge());
            }
            if (cartAdapterListener.shouldShowOldDeliveryCharge()) {
                this.oldDeliveryChargeAmount.setVisibility(0);
                this.oldDeliveryChargeAmount.setText(cartAdapterListener.getOldDeliveryCharge());
                TextView textView2 = this.oldDeliveryChargeAmount;
                textView2.setPaintFlags(textView2.getPaintFlags() | 16);
            } else {
                this.oldDeliveryChargeAmount.setVisibility(8);
            }
            if (CartScreen.this.feesDescriptions == null || CartScreen.this.feesDescriptions.getDeliveryFee() == null) {
                this.deliveryFeeInfoIcon.setVisibility(8);
                this.deliveryFeeClickableArea.setOnClickListener((View.OnClickListener) null);
                return;
            }
            this.deliveryFeeInfoIcon.setVisibility(0);
            this.deliveryFeeClickableArea.setOnClickListener(new t1(this, new ShowFeesDescriptionBottomSheetClickListener(CartScreen.this.getSupportFragmentManager(), CartScreen.this.feesDescriptions, false)));
        }

        private void bindDisclaimerBanner() {
            int i11;
            int visibility = this.disclaimerBannerView.getVisibility();
            if (CartScreen.this.disclaimerBannerDisplayModel != null) {
                i11 = 0;
            } else {
                i11 = 8;
            }
            if (visibility == 8 && i11 == 0) {
                CartScreen cartScreen = CartScreen.this;
                AppTracker.onAlertShown(cartScreen, cartScreen.getScreenName(), CartScreen.this.getScreenName(), "serviceFees");
            }
            this.disclaimerBannerView.setVisibility(i11);
            if (CartScreen.this.disclaimerBannerDisplayModel != null) {
                this.disclaimerBannerView.setOnCloseClickListener(new r1(this));
                this.disclaimerBannerView.setOnMoreInfoClickListener(new s1(this));
                this.disclaimerBannerView.setData(CartScreen.this.disclaimerBannerDisplayModel.getTitle(), CartScreen.this.disclaimerBannerDisplayModel.getDescription(), CartScreen.this.disclaimerBannerDisplayModel.getAction());
            }
        }

        private void bindFees() {
            String str;
            String str2;
            if (CartScreen.this.serviceFee == null) {
                str = null;
            } else {
                str = CartScreen.this.serviceFee.getLabel();
            }
            if (CartScreen.this.serviceFee == null) {
                str2 = null;
            } else {
                str2 = CartScreen.this.serviceFee.getFormattedValue();
            }
            this.serviceFeeView.showServiceFee(str, str2);
            this.smallOrderFeeView.showSmallOrderFee(CartScreen.this.smallOrderFee);
            if (CartScreen.this.feesDescriptions != null) {
                if (CartScreen.this.feesDescriptions.getServiceFee() != null) {
                    this.serviceFeeView.setOnInfoClickListener(new u1(this, new ShowFeesDescriptionBottomSheetClickListener(CartScreen.this.getSupportFragmentManager(), CartScreen.this.feesDescriptions, false)));
                } else {
                    this.serviceFeeView.setOnInfoClickListener((View.OnClickListener) null);
                }
                if (CartScreen.this.feesDescriptions.getSmallOrderFee() != null) {
                    this.smallOrderFeeView.setOnInfoClickListener(new v1(this, new ShowFeesDescriptionBottomSheetClickListener(CartScreen.this.getSupportFragmentManager(), CartScreen.this.feesDescriptions, false)));
                    this.smallOrderFeeView.setDescriptionText(CartScreen.this.feesDescriptions.getSmallOrderFee().getLocalDescription());
                } else {
                    this.smallOrderFeeView.setOnInfoClickListener((View.OnClickListener) null);
                }
            } else {
                this.serviceFeeView.setOnInfoClickListener((View.OnClickListener) null);
                this.smallOrderFeeView.setOnInfoClickListener((View.OnClickListener) null);
            }
            if (CartScreen.this.feesDescriptions == null || CartScreen.this.feesDescriptions.getHowFeesWork() == null) {
                this.aboutFees.setVisibility(8);
                return;
            }
            this.aboutFees.setOnClickListener(new w1(this, new ShowFeesDescriptionBottomSheetClickListener(CartScreen.this.getSupportFragmentManager(), CartScreen.this.feesDescriptions, false)));
            this.aboutFees.setVisibility(0);
        }

        private void bindFreeDeliveryTypeVoucher(CartAdapterListener cartAdapterListener) {
            int i11;
            if (cartAdapterListener.isFreeDeliveryTypeVoucherApplied()) {
                this.binDiscountLayout.setVisibility(8);
                this.freeDeliveryTypeVoucherLayout.setVisibility(0);
                this.talabatDeliveryVoucherView.setVisibility(8);
                this.discountVoucherView.setVisibility(8);
                this.removeVoucher.setVisibility(8);
                if (cartAdapterListener.isFreeDeliveryDiscountFull()) {
                    i11 = R.string.free_delivery_type_voucher_free;
                } else {
                    i11 = R.string.free_delivery_type_voucher_discount;
                }
                this.freeDeliveryTypeVoucherText.setText(i11);
                this.freeDeliverTypeVoucherAmount.setText(cartAdapterListener.getFreeDeliveryDiscountAmount());
            }
        }

        private void bindFreeDeliveryView(CartAdapterListener cartAdapterListener) {
            int visibility = this.freeDeliveryView.getVisibility();
            if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatFeatureFlagConstants.BRAND_UPDATES, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
                this.freeDeliveryText.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, CartScreen.this.getDrawable(R.drawable.bg_vendor_pro_tag_blue), (Drawable) null);
                this.freeDeliveryText.setTextColor(CartScreen.this.getColor(R.color.new_brand_blue));
                this.freeDeliveryReturnAmount.setTextColor(CartScreen.this.getColor(R.color.new_brand_blue));
            }
            CartScreen.this.startLodingPopup();
            cartAdapterListener.shouldShowFreeDelivery(new n1(this, cartAdapterListener));
            if (visibility != this.freeDeliveryView.getVisibility() && CartScreen.this.loyaltyDashboardApplyVouchersView != null) {
                CartScreen.this.loyaltyDashboardApplyVouchersView.refreshAllVoucher();
            }
        }

        private void bindGemView(CartAdapterListener cartAdapterListener) {
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                if (GEMEngine.getInstance() != null) {
                    GEMEngine.getInstance();
                    if (GEMEngine.getEligibleOfferAmount() > 0.0f) {
                        this.gemOfferAmount.setText(cartAdapterListener.getGemOfferAmount());
                        int gemTextColor = cartAdapterListener.getGemTextColor();
                        this.gemOfferText.setTextColor(gemTextColor);
                        this.gemOfferAmount.setTextColor(gemTextColor);
                        this.gemDeductionView.setVisibility(0);
                        return;
                    }
                }
                this.gemDeductionView.setVisibility(8);
                return;
            }
            this.gemDeductionView.setVisibility(8);
        }

        private void bindGeneralRequestView(final CartAdapterListener cartAdapterListener) {
            this.generalRequest.setLines(2);
            this.generalRequest.setSingleLine(false);
            this.generalRequest.setHorizontallyScrolling(false);
            this.generalRequest.setFilters(new InputFilter[]{new InputFilter.LengthFilter(250)});
            this.generalRequest.setText(cartAdapterListener.getSavedGeneralRequest());
            EditText editText = this.generalRequest;
            editText.setSelection(editText.getText().toString().trim().length());
            this.generalRequest.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    if (!TalabatUtils.isNullOrEmpty(editable.toString().trim())) {
                        cartAdapterListener.onAdditionalRequestEdited(editable.toString().trim());
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }

                public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                }
            });
        }

        private void bindGoGreenView(CartAdapterListener cartAdapterListener) {
            this.goGreenView.setOnClickListener(new p1(this));
            this.goGreenCheckbox.setOnCheckedChangeListener(new q1(cartAdapterListener));
            if (cartAdapterListener.shouldShowNoCutlery()) {
                this.goGreenView.setVisibility(0);
                this.goGreenCheckbox.setChecked(cartAdapterListener.getNoCutlerySelection());
                return;
            }
            this.goGreenView.setVisibility(8);
            cartAdapterListener.setNoCutlerySelection(false);
        }

        private void bindLoyaltyVoucherView(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.isLoyaltyVoucherApplied()) {
                this.freeDeliveryTypeVoucherLayout.setVisibility(8);
                this.talabatDeliveryVoucherView.setVisibility(8);
                this.binDiscountLayout.setVisibility(8);
                this.discountVoucherView.setVisibility(0);
                this.removeVoucher.setVisibility(8);
                this.discountVoucherTxt.setText(cartAdapterListener.getLoyaltyVoucherText());
                this.discountVoucherAmount.setText(cartAdapterListener.getLoyaltyDiscount());
                this.discountVoucherAmount.setTextColor(cartAdapterListener.getVoucherDiscountTextColor());
            }
        }

        private void bindMinimumOrderView(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.isMinimumOrderAmountPassed()) {
                cartAdapterListener.setMinimumOrderAmountVisible(false);
                cartAdapterListener.setContinueButtonEnabled(true);
                return;
            }
            cartAdapterListener.setMinimumOrderAmountVisible(true);
            cartAdapterListener.setContinueButtonEnabled(false);
        }

        private void bindMunicipalityTaxView(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.hasMunicipalityTax()) {
                this.muncipalityChargesView.setVisibility(0);
                this.municipalityTaxText.setText(cartAdapterListener.getMunicipalityTaxLabelText());
                this.municipalityTaxAmount.setText(cartAdapterListener.getMunicipalityTaxAmount());
                return;
            }
            this.muncipalityChargesView.setVisibility(8);
        }

        private void bindNormalVoucherView(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.isNormalVoucher()) {
                this.freeDeliveryTypeVoucherLayout.setVisibility(8);
                this.talabatDeliveryVoucherView.setVisibility(8);
                this.binDiscountLayout.setVisibility(8);
                this.discountVoucherView.setVisibility(0);
                this.removeVoucher.setVisibility(0);
                this.discountVoucherTxt.setText(cartAdapterListener.getNormalVoucherText());
                this.discountVoucherAmount.setText(cartAdapterListener.getVoucherAmount());
                this.discountVoucherAmount.setTextColor(cartAdapterListener.getVoucherDiscountTextColor());
            }
        }

        private void bindSubtotalView(CartAdapterListener cartAdapterListener) {
            this.subTotalView.setVisibility(0);
            this.subTotalAmount.setText(cartAdapterListener.getSubtotalPrice());
        }

        private void bindTalabatFreeDeliveryVoucher(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.isTalabatDeliveryVoucher()) {
                this.discountVoucherView.setVisibility(8);
                this.binDiscountLayout.setVisibility(8);
                this.freeDeliveryTypeVoucherLayout.setVisibility(8);
                this.talabatDeliveryVoucherView.setVisibility(0);
                this.talabatDeliveryVoucherAmount.setText(cartAdapterListener.getVoucherAmount());
            }
        }

        private void bindTotalView(CartAdapterListener cartAdapterListener) {
            this.totalView.setVisibility(0);
            this.totalAmount.setText(cartAdapterListener.getCartTotalPrice());
        }

        private void bindTouristTaxView(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.hasTouristTax()) {
                this.touristTaxView.setVisibility(0);
                this.touristTaxText.setText(cartAdapterListener.getTouristTaxLabelText());
                this.touristTaxAmount.setText(cartAdapterListener.getTouristTaxAmount());
                return;
            }
            this.touristTaxView.setVisibility(8);
        }

        private void bindVoucherView(CartAdapterListener cartAdapterListener) {
            this.removeVoucher.setOnClickListener(new o1(cartAdapterListener));
            cartAdapterListener.removeInvalidVouchers();
            if (cartAdapterListener.isVoucherApplied() || cartAdapterListener.isLoyaltyVoucherApplied() || cartAdapterListener.isFreeDeliveryTypeVoucherApplied()) {
                bindZeroVoucherView(cartAdapterListener);
                bindNormalVoucherView(cartAdapterListener);
                bindLoyaltyVoucherView(cartAdapterListener);
                bindTalabatFreeDeliveryVoucher(cartAdapterListener);
                bindFreeDeliveryTypeVoucher(cartAdapterListener);
            } else if (cartAdapterListener.isOnlyBinApplied()) {
                this.talabatDeliveryVoucherView.setVisibility(8);
                this.binDiscountLayout.setVisibility(0);
                this.discountVoucherView.setVisibility(8);
                this.binDiscountValue.setText(cartAdapterListener.getBinDiscountAmount());
                this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            } else {
                this.talabatDeliveryVoucherView.setVisibility(8);
                this.discountVoucherView.setVisibility(8);
                this.binDiscountLayout.setVisibility(8);
                this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            }
        }

        private void bindZeroVoucherView(CartAdapterListener cartAdapterListener) {
            if (cartAdapterListener.isZeroVoucher()) {
                this.binDiscountLayout.setVisibility(8);
                this.freeDeliveryTypeVoucherLayout.setVisibility(8);
                this.talabatDeliveryVoucherView.setVisibility(8);
                this.discountVoucherView.setVisibility(0);
                this.removeVoucher.setVisibility(8);
                this.discountVoucherTxt.setText(cartAdapterListener.getZeroVoucherText());
                this.discountVoucherAmount.setText(cartAdapterListener.getVoucherAmount());
                this.discountVoucherAmount.setTextColor(cartAdapterListener.getZeroVoucherTextColor());
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$bindDeliveryChargesView$7(View.OnClickListener onClickListener, View view) {
            onClickListener.onClick(view);
            CartScreen cartScreen = CartScreen.this;
            cartScreen.G.onDeliveryFeeInfoClicked(cartScreen.getScreenName());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$bindDisclaimerBanner$3(View view) {
            CartScreen.this.G.onDismissDisclaimerClicked();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$bindDisclaimerBanner$4(View view) {
            CartScreen cartScreen = CartScreen.this;
            cartScreen.openUrl(cartScreen.disclaimerBannerDisplayModel.getActionUrl());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$bindFees$0(View.OnClickListener onClickListener, View view) {
            onClickListener.onClick(view);
            CartScreen cartScreen = CartScreen.this;
            cartScreen.G.onServiceFeeInfoClicked(cartScreen.getScreenName());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$bindFees$1(View.OnClickListener onClickListener, View view) {
            onClickListener.onClick(view);
            CartScreen cartScreen = CartScreen.this;
            cartScreen.G.onSmallOrderFeeInfoClicked(cartScreen.getScreenName());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$bindFees$2(View.OnClickListener onClickListener, View view) {
            onClickListener.onClick(view);
            CartScreen cartScreen = CartScreen.this;
            cartScreen.G.onGeneralFeesInfoClicked(cartScreen.getScreenName());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Unit lambda$bindFreeDeliveryView$8(CartAdapterListener cartAdapterListener, TProOrderStatus tProOrderStatus) {
            if (tProOrderStatus.isFreeDelivery()) {
                this.freeDeliveryView.setVisibility(0);
                this.freeDeliveryReturnAmount.setText(cartAdapterListener.getFreeDeliveryReturn());
                TextView textView = this.freeDeliveryReturnAmount;
                textView.setPaintFlags(textView.getPaintFlags() | 16);
            } else {
                this.freeDeliveryView.setVisibility(8);
            }
            updateDeliveryFeeVisibility(cartAdapterListener.isPickup(), tProOrderStatus.isFreeDelivery());
            if (tProOrderStatus.getShouldShowTProPromotion()) {
                this.savingsView.setVisibility(0);
                if (tProOrderStatus.isFreeDelivery()) {
                    this.savingsView.setBackgroundColor(CartScreen.this.getColor(R.color.savings_view_background));
                    this.freeDeliverySavingsText.setVisibility(0);
                    this.freeDeliverySavingsText.setText(CartScreen.this.getString(R.string.free_delivery_savings, new Object[]{cartAdapterListener.getFreeDeliveryReturn()}));
                    this.freeDeliveryMore.setVisibility(8);
                } else {
                    this.savingsView.setBackgroundColor(CartScreen.this.getColor(R.color.new_brand_blue));
                    this.freeDeliverySavingsText.setVisibility(8);
                    this.freeDeliveryMore.setVisibility(0);
                    this.freeDeliveryMore.setText(CartScreen.this.getString(R.string.free_delivery_savings_not_enough, new Object[]{TalabatFormatter.getInstance().getFormattedCurrency((float) Math.abs(tProOrderStatus.getMovDifference()), true)}));
                }
            } else {
                this.savingsView.setVisibility(8);
            }
            bindTotalView(cartAdapterListener);
            CartScreen.this.stopLodingPopup();
            return Unit.INSTANCE;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$bindGoGreenView$5(View view) {
            CheckBox checkBox = this.goGreenCheckbox;
            checkBox.setChecked(!checkBox.isChecked());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ void lambda$bindVoucherView$9(CartAdapterListener cartAdapterListener, View view) {
            GrowthTracker.INSTANCE.onVoucherRemoved(Cart.getInstance().getVoucherCode(), Cart.getInstance().getVoucherDiscount(), VoucherOptionType.MARKETING.name());
            cartAdapterListener.removeVoucher();
        }

        private void updateDeliveryFeeVisibility(boolean z11, boolean z12) {
            int i11 = 0;
            if (!(!z11 && !z12)) {
                i11 = 8;
            }
            this.deliveryChargesView.setVisibility(i11);
        }

        public void bind(CartAdapterListener cartAdapterListener) {
            new GemCartCustomizationViewHolderBinder().accept(CartScreen.this, (RecyclerView.ViewHolder) this);
            bindGeneralRequestView(cartAdapterListener);
            bindGoGreenView(cartAdapterListener);
            adjustGeneralRequestVisibility(cartAdapterListener);
            bindMinimumOrderView(cartAdapterListener);
            bindGemView(cartAdapterListener);
            bindSubtotalView(cartAdapterListener);
            bindTotalView(cartAdapterListener);
            bindDeliveryChargesView(cartAdapterListener);
            bindFreeDeliveryView(cartAdapterListener);
            bindMunicipalityTaxView(cartAdapterListener);
            bindTouristTaxView(cartAdapterListener);
            bindCouponDiscountView(cartAdapterListener);
            bindVoucherView(cartAdapterListener);
            bindFees();
            bindDisclaimerBanner();
        }
    }

    public class CartListViewItem {
        public boolean isFirstItem;
        public boolean isLastItem;
        public Object object;

        public CartListViewItem(Object obj, boolean z11, boolean z12) {
            this.object = obj;
            this.isFirstItem = z11;
            this.isLastItem = z12;
        }
    }

    public class CartRecyclerviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements GravitySnapHelper.SnapListener {

        /* renamed from: i  reason: collision with root package name */
        public View f53748i = null;

        /* renamed from: j  reason: collision with root package name */
        public View f53749j = null;

        /* renamed from: k  reason: collision with root package name */
        public View f53750k = null;

        /* renamed from: l  reason: collision with root package name */
        public View f53751l = null;

        /* renamed from: m  reason: collision with root package name */
        public View f53752m = null;

        /* renamed from: n  reason: collision with root package name */
        public View f53753n = null;

        /* renamed from: o  reason: collision with root package name */
        public CartAdapterListener f53754o;

        /* renamed from: p  reason: collision with root package name */
        public int f53755p = 0;

        /* renamed from: q  reason: collision with root package name */
        public Flag f53756q = new Flag(false);

        public CartRecyclerviewAdapter(CartAdapterListener cartAdapterListener) {
            this.f53754o = cartAdapterListener;
        }

        /* access modifiers changed from: private */
        public int getAllItemsCount() {
            int i11;
            int couponsAndPromotionsCount = Cart.getInstance().getCouponsAndPromotionsCount();
            int i12 = 0;
            if (Cart.getInstance().getUpsellingItemCount() > 0) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            int i13 = couponsAndPromotionsCount + i11;
            if (Cart.getInstance().hasItems()) {
                i12 = Cart.getInstance().getCartItems().size();
            }
            return i13 + i12 + (Cart.getInstance().hasReorderItemsStatus() ? 1 : 0) + this.f53755p;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(int i11, CompoundButton compoundButton, boolean z11) {
            CartScreen cartScreen = CartScreen.this;
            if (cartScreen.deleteSelectionItems == null) {
                cartScreen.deleteSelectionItems = new SparseBooleanArray();
            }
            SparseBooleanArray sparseBooleanArray = CartScreen.this.deleteSelectionItems;
            sparseBooleanArray.put(i11, !sparseBooleanArray.get(i11, false));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(CartMenuItem cartMenuItem, RecyclerView.ViewHolder viewHolder, View view) {
            if (cartMenuItem.getQuantity() > 1) {
                CartScreen.this.cartPresenter.decreaseQuantity(cartMenuItem);
                notifyDataSetChanged();
                return;
            }
            CartScreen.this.cartPresenter.removeItemAtPosition(CartScreen.this.getIndexOfMenuItem(viewHolder.getAdapterPosition()), CartScreen.this);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$2(CartMenuItem cartMenuItem, View view) {
            String str;
            CartScreen.this.cartPresenter.increaseQuantiy(cartMenuItem);
            ArrayList<ChoiceSection> arrayList = cartMenuItem.selectedChoices;
            if (arrayList != null) {
                str = CartScreen.this.getChoicesString(arrayList);
            } else {
                str = "";
            }
            CartMenuItem cartMenuItem2 = cartMenuItem;
            AppTracker.onCartQuantityIncreased(CartScreen.this, Cart.getInstance().getRestaurant(), cartMenuItem2, AppTracker.getRestaurantId(Cart.getInstance().getRestaurant()), AppTracker.getRestaurantName(Cart.getInstance().getRestaurant()), "cart_modify", str, cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[0], cartMenuItem.getSelectedQuantityOfMandatoryAndOptionalChoices()[1], ScreenNames.getScreenType(CartScreen.this.getScreenName()), CartScreen.this.getScreenName());
            notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$3(RecyclerView.ViewHolder viewHolder, View view) {
            CartScreen.this.cartPresenter.removeItemAtPosition(CartScreen.this.getIndexOfMenuItem(viewHolder.getAdapterPosition()), CartScreen.this);
            notifyItemRemoved(CartScreen.this.getIndexOfMenuItem(viewHolder.getAdapterPosition()));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$4(Coupon coupon, View view) {
            CartScreen.this.showCouponPopup(coupon);
            CartScreen.this.selectCoupon(coupon);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$5(Coupon coupon, View view) {
            CartScreen.this.showCouponPopup(coupon);
            CartScreen.this.selectCoupon(coupon);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$6(Promotion promotion, View view) {
            CartScreen.this.showPromotionPoup(promotion);
            CartScreen.this.selectPromotion(promotion);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$7(Promotion promotion, View view) {
            CartScreen.this.showPromotionPoup(promotion);
            CartScreen.this.selectPromotion(promotion);
            notifyDataSetChanged();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$8(View view) {
            Cart.getInstance().setBenefitItemDeleted();
            Cart.getInstance().recalcualteTotal();
            notifyDataSetChanged();
        }

        public int getItemCount() {
            int couponsAndPromotionsCount = Cart.getInstance().getCouponsAndPromotionsCount() + 1;
            if (Cart.getInstance().hasReorderItemsStatus()) {
                couponsAndPromotionsCount++;
            }
            if (Cart.getInstance().getCartItems() != null) {
                couponsAndPromotionsCount += Cart.getInstance().getCartItems().size();
            }
            if (Cart.getInstance().getUpsellingItemCount() > 0) {
                couponsAndPromotionsCount++;
            }
            int i11 = couponsAndPromotionsCount + this.f53755p;
            CartScreen.this.mainListTotalCount = i11;
            return i11;
        }

        public int getItemViewType(int i11) {
            int i12;
            int couponsAndPromotionsCount = Cart.getInstance().getCouponsAndPromotionsCount();
            boolean hasReorderItemsStatus = Cart.getInstance().hasReorderItemsStatus();
            boolean isUpsellingAvailable = Cart.getInstance().isUpsellingAvailable();
            int allItemsCount = getAllItemsCount();
            if (Cart.getInstance().getCoupons() != null && Cart.getInstance().getCoupons().length > i11) {
                return 1;
            }
            if (Cart.getInstance().getCouponsAndPromotionsCount() > i11) {
                return 2;
            }
            ArrayList<CartMenuItem> cartItems = Cart.getInstance().getCartItems();
            if (cartItems != null) {
                i12 = cartItems.size();
            } else {
                i12 = 0;
            }
            if (i11 == i12 + couponsAndPromotionsCount + (hasReorderItemsStatus ? 1 : 0) + this.f53755p && isUpsellingAvailable && Cart.getInstance().getUpsellingItemCount() > 0) {
                return 4;
            }
            if (i11 == allItemsCount) {
                return 5;
            }
            if (!Cart.getInstance().hasReorderItemsStatus() || i11 != couponsAndPromotionsCount) {
                return 0;
            }
            return 6;
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            int i12 = i11;
            if (viewHolder2 instanceof CartViewHolder) {
                if (Cart.getInstance().getCartItems() != null) {
                    int couponsAndPromotionsCount = i12 - (Cart.getInstance().getCouponsAndPromotionsCount() + (Cart.getInstance().hasReorderItemsStatus() ? 1 : 0));
                    if (couponsAndPromotionsCount >= Cart.getInstance().getCartItems().size() || couponsAndPromotionsCount < 0) {
                        couponsAndPromotionsCount = i12;
                    }
                    if (couponsAndPromotionsCount >= Cart.getInstance().getCartItems().size() || couponsAndPromotionsCount < 0) {
                        CartScreen.this.cartPresenter.observeInconsistencyInCartItems(i11, Cart.getInstance().getUpsellingItemCount(), Cart.getInstance().getCouponsAndPromotionsCount(), getAllItemsCount(), Boolean.valueOf(Cart.getInstance().hasReorderItemsStatus()), Cart.getInstance().getRestaurant());
                        return;
                    }
                    CartMenuItem cartMenuItem = Cart.getInstance().getCartItems().get(couponsAndPromotionsCount);
                    CartViewHolder cartViewHolder = (CartViewHolder) viewHolder2;
                    TextView textView = cartViewHolder.f53762i;
                    textView.setText("" + Cart.getInstance().getCartItems().get(couponsAndPromotionsCount).getQuantity());
                    cartViewHolder.f53761h.setText(cartMenuItem.f13862name);
                    if (TalabatUtils.isNullOrEmpty(cartMenuItem.specialRequest)) {
                        cartViewHolder.f53768o.setVisibility(8);
                    } else {
                        cartViewHolder.f53768o.setVisibility(0);
                        cartViewHolder.f53767n.setText(cartMenuItem.specialRequest);
                    }
                    if (!cartMenuItem.isDiscounted() || !CartScreen.this.isGemActive()) {
                        cartViewHolder.f53766m.setText(cartMenuItem.getTotalDisplayPriceWithCurrency());
                    } else {
                        cartViewHolder.f53766m.setText(cartMenuItem.getTotalDisplayOldPrice());
                    }
                    if (cartMenuItem.hasSelectedChoices()) {
                        cartViewHolder.f53765l.setVisibility(0);
                        cartViewHolder.f53765l.setText(cartMenuItem.getSelectedChoiceNames());
                    } else {
                        cartViewHolder.f53765l.setVisibility(8);
                    }
                    if (CartScreen.this.isEditing) {
                        cartViewHolder.f53762i.setVisibility(0);
                        cartViewHolder.f53763j.setVisibility(0);
                        cartViewHolder.f53764k.setVisibility(8);
                    } else {
                        cartViewHolder.f53763j.setVisibility(8);
                        cartViewHolder.f53764k.setVisibility(8);
                    }
                    cartViewHolder.f53764k.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                    cartViewHolder.f53764k.setOnCheckedChangeListener(new x1(this, couponsAndPromotionsCount));
                    cartViewHolder.f53770q.setOnClickListener(new y1(this, cartMenuItem, viewHolder2));
                    cartViewHolder.f53769p.setOnClickListener(new z1(this, cartMenuItem));
                    if (cartMenuItem.hasThumbnail) {
                        cartViewHolder.f53771r.setVisibility(0);
                        CartScreen cartScreen = CartScreen.this;
                        if (cartScreen.isValidContextForGlide(cartScreen)) {
                            GlideApp.with((FragmentActivity) CartScreen.this).clear((View) cartViewHolder.f53771r);
                            GlideApp.with((FragmentActivity) CartScreen.this).load(cartMenuItem.getThumbnail(200)).apply(TalabatGlideModule.requestOptions().transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(CartScreen.this.getResources().getDimensionPixelSize(R.dimen.card_corner_radius))})).into(cartViewHolder.f53771r);
                        }
                        cartViewHolder.f53772s.setVisibility(8);
                        cartViewHolder.f53773t.setVisibility(8);
                    } else {
                        cartViewHolder.f53772s.setVisibility(0);
                        cartViewHolder.f53771r.setImageResource(0);
                        cartViewHolder.f53771r.setVisibility(0);
                        cartViewHolder.f53773t.setVisibility(8);
                    }
                    cartViewHolder.f53763j.setOnClickListener(new a2(this, viewHolder2));
                }
            } else if (viewHolder2 instanceof CartCustomizationViewHolder) {
                ((CartCustomizationViewHolder) viewHolder2).bind(this.f53754o);
            } else if (viewHolder2 instanceof ReorderItemMissingViewHolder) {
                ((ReorderItemMissingViewHolder) viewHolder2).bind(this.f53754o);
            } else if (viewHolder2 instanceof UpSellingViewHolder) {
                final UpSellingViewHolder upSellingViewHolder = (UpSellingViewHolder) viewHolder2;
                RecyclerView recyclerView = upSellingViewHolder.f53806h;
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
                upSellingViewHolder.f53806h.setOnFlingListener((RecyclerView.OnFlingListener) null);
                new LinearSnapHelper().attachToRecyclerView(upSellingViewHolder.f53806h);
                if (Cart.getInstance().getRestaurant() != null && !TalabatUtils.isNullOrEmpty(Cart.getInstance().getRestaurant().upSellingText)) {
                    upSellingViewHolder.f53807i.setText(Cart.getInstance().getRestaurant().upSellingText);
                }
                if (Cart.getInstance().getRestaurant() == null || TalabatUtils.isNullOrEmpty(Cart.getInstance().getRestaurant().getUpselingHeaderIcon())) {
                    upSellingViewHolder.f53808j.setVisibility(8);
                } else {
                    upSellingViewHolder.f53808j.setVisibility(0);
                    CartScreen cartScreen2 = CartScreen.this;
                    if (cartScreen2.isValidContextForGlide(cartScreen2)) {
                        GlideApp.with((FragmentActivity) CartScreen.this).clear((View) upSellingViewHolder.f53808j);
                        GlideApp.with((FragmentActivity) CartScreen.this).load(Cart.getInstance().getRestaurant().getUpselingHeaderIcon()).centerInside().listener((RequestListener) new RequestListener<Drawable>() {
                            public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                                upSellingViewHolder.f53808j.setImageResource(0);
                                upSellingViewHolder.f53808j.setVisibility(8);
                                return false;
                            }

                            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                                upSellingViewHolder.f53808j.setVisibility(0);
                                return false;
                            }
                        }).into(upSellingViewHolder.f53808j);
                    }
                }
                if (Cart.getInstance().getRestaurantUpsellingsItmes() != null && Cart.getInstance().getRestaurantUpsellingsItmes().size() > 0) {
                    AppTracker.onUpSellingSliderShown(CartScreen.this);
                    CartScreen cartScreen3 = CartScreen.this;
                    cartScreen3.f53703k = new UpSellingSectionDataAdapter(cartScreen3, Cart.getInstance().getRestaurantUpsellingsItmes());
                    upSellingViewHolder.f53806h.setAdapter(CartScreen.this.f53703k);
                    upSellingViewHolder.f53806h.scrollToPosition(CartScreen.this.upsellingScrollPosition);
                }
                upSellingViewHolder.f53806h.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
                        if (i11 != 0 && i11 == 1) {
                            AppTracker.upsellCokeSliderNavigated(CartScreen.this);
                        }
                        super.onScrollStateChanged(recyclerView, i11);
                    }

                    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
                        super.onScrolled(recyclerView, i11, i12);
                    }
                });
            } else {
                CouponViewHolder couponViewHolder = (CouponViewHolder) viewHolder2;
                boolean isCouponApplied = Cart.getInstance().isCouponApplied();
                if (CartScreen.this.getCouponOrPromotion(i12).object instanceof Coupon) {
                    CartListViewItem couponOrPromotion = CartScreen.this.getCouponOrPromotion(i12);
                    Coupon coupon = (Coupon) couponOrPromotion.object;
                    couponViewHolder.f53775h.setText(coupon.marketingTitle);
                    couponViewHolder.f53779l.setVisibility(8);
                    if (coupon.getHintType(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), isCouponApplied) == 3) {
                        couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_disabled));
                        couponViewHolder.f53776i.setVisibility(8);
                        couponViewHolder.f53776i.setText(CartScreen.this.getString(R.string.add_more_itmes_to_cart_for_coupon).replace(RichContentLoadTimeRecorder.DELIMETER, coupon.getFormattedQualifyingAmount(Cart.getInstance().getCartSubTotal(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), false))));
                        couponViewHolder.f53777j.setImageResource(R.drawable.ds_plus);
                        couponViewHolder.f53777j.setColorFilter(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                    } else if (coupon.getHintType(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), isCouponApplied) == 2) {
                        couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_added));
                        couponViewHolder.f53776i.setVisibility(0);
                        couponViewHolder.f53776i.setText(CartScreen.this.getString(R.string.coupon_added_to_cart));
                        couponViewHolder.f53777j.setImageResource(R.drawable.ic_m_promotion_check);
                        couponViewHolder.f53777j.setColorFilter(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                    } else if (coupon.getHintType(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), isCouponApplied) == 1) {
                        couponViewHolder.f53776i.setVisibility(0);
                        couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_available));
                        couponViewHolder.f53776i.setText(CartScreen.this.getString(R.string.offer_avail));
                        couponViewHolder.f53777j.setImageResource(R.drawable.ds_plus);
                        couponViewHolder.f53777j.setColorFilter(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                    } else if (coupon.getHintType(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), isCouponApplied) == 4) {
                        couponViewHolder.f53776i.setVisibility(0);
                        couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_disabled));
                        couponViewHolder.f53776i.setText(CartScreen.this.getString(R.string.satisfy_minimum_order_amount).replace(RichContentLoadTimeRecorder.DELIMETER, coupon.getFormattedQualifyingAmount(Cart.getInstance().getCartSubTotal(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), false))));
                        couponViewHolder.f53777j.setImageResource(R.drawable.ds_plus);
                        couponViewHolder.f53777j.setColorFilter(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                    } else if (coupon.getHintType(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), isCouponApplied) == 0) {
                        couponViewHolder.f53776i.setVisibility(8);
                        couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_disabled));
                        couponViewHolder.f53776i.setText(R.string.coupon_cannot_be_combined);
                        couponViewHolder.f53777j.setImageResource(R.drawable.ds_plus);
                        couponViewHolder.f53777j.setBackgroundColor(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                    } else if (coupon.getHintType(CartScreen.this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), isCouponApplied) == 5) {
                        couponViewHolder.f53776i.setVisibility(0);
                        couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_disabled));
                        couponViewHolder.f53776i.setText(R.string.best_coupon_selected);
                        couponViewHolder.f53777j.setImageResource(R.drawable.ds_plus);
                        couponViewHolder.f53777j.setColorFilter(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                    }
                    if (couponOrPromotion.isFirstItem) {
                        couponViewHolder.f53784q.setVisibility(8);
                    } else {
                        couponViewHolder.f53784q.setVisibility(8);
                    }
                    if (couponOrPromotion.isLastItem) {
                        couponViewHolder.f53786s.setVisibility(8);
                        couponViewHolder.f53785r.setVisibility(8);
                    } else {
                        couponViewHolder.f53786s.setVisibility(8);
                        couponViewHolder.f53785r.setVisibility(8);
                    }
                    couponViewHolder.f53778k.setOnClickListener(new b2(this, coupon));
                    couponViewHolder.f53777j.setOnClickListener(new c2(this, coupon));
                    return;
                }
                CartListViewItem couponOrPromotion2 = CartScreen.this.getCouponOrPromotion(i12);
                Promotion promotion = (Promotion) couponOrPromotion2.object;
                couponViewHolder.f53775h.setText(promotion.marketingTitle);
                if (!promotion.isSelected || promotion.selectedBenefitItem == null) {
                    couponViewHolder.f53779l.setVisibility(8);
                    couponViewHolder.f53777j.setImageResource(R.drawable.ds_plus);
                    couponViewHolder.f53777j.setColorFilter(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                } else {
                    couponViewHolder.f53779l.setVisibility(0);
                    couponViewHolder.f53780m.setText(promotion.selectedBenefitItem.f13837name);
                    if (!promotion.selectedBenefitItem.getDisplayTotalPrice().equals("0")) {
                        couponViewHolder.f53781n.setText(promotion.selectedBenefitItem.getDisplayTotalPrice());
                        couponViewHolder.f53781n.setVisibility(0);
                    } else {
                        couponViewHolder.f53781n.setVisibility(8);
                    }
                    if (TalabatUtils.isNullOrEmpty(promotion.selectedBenefitItem.getSelectedChoiceNames())) {
                        couponViewHolder.f53782o.setVisibility(8);
                    } else {
                        couponViewHolder.f53782o.setVisibility(0);
                        couponViewHolder.f53782o.setText(promotion.selectedBenefitItem.getSelectedChoiceNames());
                    }
                    couponViewHolder.f53777j.setImageResource(R.drawable.ic_m_promotion_check);
                    couponViewHolder.f53777j.setColorFilter(ContextCompat.getColor(CartScreen.this.getContext(), R.color.ds_primary_100));
                }
                if (couponOrPromotion2.isFirstItem) {
                    couponViewHolder.f53784q.setVisibility(8);
                    couponViewHolder.f53784q.setText("Promotion Available");
                } else {
                    couponViewHolder.f53784q.setVisibility(8);
                }
                if (couponOrPromotion2.isLastItem) {
                    couponViewHolder.f53786s.setVisibility(8);
                    couponViewHolder.f53785r.setVisibility(8);
                } else {
                    couponViewHolder.f53786s.setVisibility(8);
                    couponViewHolder.f53785r.setVisibility(8);
                }
                couponViewHolder.f53778k.setOnClickListener(new d2(this, promotion));
                couponViewHolder.f53777j.setOnClickListener(new e2(this, promotion));
                couponViewHolder.f53783p.setVisibility(0);
                couponViewHolder.f53783p.setOnClickListener(new f2(this));
                if (promotion.getHintType() == 2) {
                    couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_added));
                    couponViewHolder.f53776i.setVisibility(8);
                    couponViewHolder.f53776i.setText(CartScreen.this.getString(R.string.promotion_added_to_cart));
                } else if (promotion.getHintType() == 1) {
                    couponViewHolder.f53776i.setVisibility(0);
                    couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_available));
                    couponViewHolder.f53776i.setText(CartScreen.this.getString(R.string.offer_avail));
                } else if (promotion.getHintType() == 3) {
                    couponViewHolder.f53776i.setTextColor(CartScreen.this.getResources().getColor(R.color.cart_offer_disabled));
                    couponViewHolder.f53776i.setVisibility(8);
                    couponViewHolder.f53776i.setText(CartScreen.this.getString(R.string.add_more_itmes_to_cart_for_offer).replace(RichContentLoadTimeRecorder.DELIMETER, promotion.getFormattedQualifyingAmount(Cart.getInstance().getCartSubTotal(false, false))));
                }
            }
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            LayoutInflater layoutInflater = (LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater");
            if (i11 == 1) {
                this.f53750k = layoutInflater.inflate(R.layout.cart_coupons_promotion, viewGroup, false);
                return new CouponViewHolder(this.f53750k);
            } else if (i11 == 2) {
                this.f53749j = layoutInflater.inflate(R.layout.cart_coupons_promotion, viewGroup, false);
                return new CouponViewHolder(this.f53749j);
            } else if (i11 == 4) {
                this.f53751l = layoutInflater.inflate(R.layout.up_selling_horizontal_container, viewGroup, false);
                return new UpSellingViewHolder(this.f53751l);
            } else if (i11 == 5) {
                this.f53752m = layoutInflater.inflate(R.layout.cart_customization_footer, viewGroup, false);
                return new CartCustomizationViewHolder(this.f53752m);
            } else if (i11 == 6) {
                this.f53753n = layoutInflater.inflate(R.layout.reorder_item_missing_view, viewGroup, false);
                return new ReorderItemMissingViewHolder(this.f53753n);
            } else {
                this.f53748i = layoutInflater.inflate(R.layout.cart_item, viewGroup, false);
                return new CartViewHolder(this.f53748i);
            }
        }

        public void onSnap(int i11) {
        }
    }

    public static class CartViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f53761h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f53762i;

        /* renamed from: j  reason: collision with root package name */
        public Button f53763j;

        /* renamed from: k  reason: collision with root package name */
        public CheckBox f53764k;

        /* renamed from: l  reason: collision with root package name */
        public TextView f53765l;

        /* renamed from: m  reason: collision with root package name */
        public TextView f53766m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f53767n;

        /* renamed from: o  reason: collision with root package name */
        public View f53768o;

        /* renamed from: p  reason: collision with root package name */
        public View f53769p;

        /* renamed from: q  reason: collision with root package name */
        public View f53770q;

        /* renamed from: r  reason: collision with root package name */
        public ImageView f53771r;

        /* renamed from: s  reason: collision with root package name */
        public ImageView f53772s;

        /* renamed from: t  reason: collision with root package name */
        public ProgressBar f53773t;

        public CartViewHolder(View view) {
            super(view);
            this.f53761h = (TextView) view.findViewById(R.id.item_name);
            this.f53762i = (TextView) view.findViewById(R.id.quantity);
            this.f53765l = (TextView) view.findViewById(R.id.choices);
            this.f53766m = (TextView) view.findViewById(R.id.total_price);
            this.f53767n = (TextView) view.findViewById(R.id.special_request);
            this.f53768o = view.findViewById(R.id.special_request_layout);
            this.f53769p = view.findViewById(R.id.increase_qty);
            this.f53770q = view.findViewById(R.id.decrease_qty);
            this.f53763j = (Button) view.findViewById(R.id.delete_cart);
            this.f53764k = (CheckBox) view.findViewById(R.id.delete_item);
            this.f53771r = (ImageView) view.findViewById(R.id.item_logo);
            this.f53772s = (ImageView) view.findViewById(R.id.image_not_available);
            this.f53773t = (ProgressBar) view.findViewById(R.id.progressBar);
        }
    }

    public class CloseCartBroadcastReceiver extends BroadcastReceiver {
        private CloseCartBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(GlobalConstants.BROADCAST_KILL_CART)) {
                CartScreen.this.finish();
            }
        }
    }

    public static class CouponViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public TextView f53775h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f53776i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f53777j;

        /* renamed from: k  reason: collision with root package name */
        public View f53778k;

        /* renamed from: l  reason: collision with root package name */
        public View f53779l;

        /* renamed from: m  reason: collision with root package name */
        public TextView f53780m;

        /* renamed from: n  reason: collision with root package name */
        public TextView f53781n;

        /* renamed from: o  reason: collision with root package name */
        public TextView f53782o;

        /* renamed from: p  reason: collision with root package name */
        public TextView f53783p;

        /* renamed from: q  reason: collision with root package name */
        public TextView f53784q;

        /* renamed from: r  reason: collision with root package name */
        public View f53785r;

        /* renamed from: s  reason: collision with root package name */
        public View f53786s;

        public CouponViewHolder(View view) {
            super(view);
            this.f53775h = (TextView) view.findViewById(R.id.coupon_title);
            this.f53776i = (TextView) view.findViewById(R.id.coupon_hint);
            this.f53777j = (ImageView) view.findViewById(R.id.coupon_add);
            this.f53778k = view.findViewById(R.id.coupon_view);
            this.f53779l = view.findViewById(R.id.benefit_item_view);
            this.f53780m = (TextView) view.findViewById(R.id.benefitItem_name);
            this.f53781n = (TextView) view.findViewById(R.id.benefitItem_pice);
            this.f53783p = (TextView) view.findViewById(R.id.benefit_item_delete);
            this.f53782o = (TextView) view.findViewById(R.id.benefitItem_name_choice_names);
            this.f53784q = (TextView) view.findViewById(R.id.main_coupons_heading);
            this.f53785r = view.findViewById(R.id.seperator_item);
            this.f53786s = view.findViewById(R.id.seperator_section);
        }
    }

    public class SpeedyLinearLayoutManager extends LinearLayoutManager {
        private static final float MILLISECONDS_PER_INCH = 60.0f;

        public SpeedyLinearLayoutManager(Context context, int i11, boolean z11) {
            super(context, i11, z11);
        }

        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i11) {
            AnonymousClass1 r22 = new LinearSmoothScroller(recyclerView.getContext()) {
                public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
                    return 60.0f / ((float) displayMetrics.densityDpi);
                }

                public PointF computeScrollVectorForPosition(int i11) {
                    return SpeedyLinearLayoutManager.this.computeScrollVectorForPosition(i11);
                }
            };
            r22.setTargetPosition(i11);
            startSmoothScroll(r22);
        }
    }

    public class UpSellingSectionDataAdapter extends RecyclerView.Adapter<UpSellingSectionDataAdapterItemRowHolder> {

        /* renamed from: i  reason: collision with root package name */
        public int f53789i;
        private Context mContext;
        private ArrayList<MenuItem> restaurantUpsellings;

        public class UpSellingSectionDataAdapterItemRowHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public TextView f53799h;

            /* renamed from: i  reason: collision with root package name */
            public ImageView f53800i;

            /* renamed from: j  reason: collision with root package name */
            public TextView f53801j;

            /* renamed from: k  reason: collision with root package name */
            public Button f53802k;

            /* renamed from: l  reason: collision with root package name */
            public ProgressBar f53803l;

            /* renamed from: m  reason: collision with root package name */
            public View f53804m;

            public UpSellingSectionDataAdapterItemRowHolder(View view) {
                super(view);
                this.f53799h = (TextView) view.findViewById(R.id.up_selling_item_name);
                this.f53801j = (TextView) view.findViewById(R.id.up_selling_item_price);
                this.f53800i = (ImageView) view.findViewById(R.id.up_selling_img);
                this.f53802k = (Button) view.findViewById(R.id.upselling_add_to_cart);
                this.f53803l = (ProgressBar) view.findViewById(R.id.progressBar);
                this.f53804m = view.findViewById(R.id.touch_container);
            }
        }

        public UpSellingSectionDataAdapter(Context context, ArrayList<MenuItem> arrayList) {
            this.mContext = context;
            this.restaurantUpsellings = arrayList;
        }

        public int getItemCount() {
            ArrayList<MenuItem> arrayList = this.restaurantUpsellings;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        public void onBindViewHolder(final UpSellingSectionDataAdapterItemRowHolder upSellingSectionDataAdapterItemRowHolder, @SuppressLint({"RecyclerView"}) final int i11) {
            this.f53789i = i11;
            final MenuItem menuItem = Cart.getInstance().getRestaurantUpsellingsItmes().get(i11);
            upSellingSectionDataAdapterItemRowHolder.f53799h.setText(menuItem.f13862name);
            TextView textView = upSellingSectionDataAdapterItemRowHolder.f53801j;
            textView.setText("" + TalabatFormatter.getInstance().getFormattedCurrency(menuItem.price, true));
            if (!TalabatUtils.isNullOrEmpty(menuItem.getThumbnail())) {
                upSellingSectionDataAdapterItemRowHolder.f53800i.setVisibility(0);
                CartScreen cartScreen = CartScreen.this;
                if (cartScreen.isValidContextForGlide(cartScreen)) {
                    GlideApp.with((FragmentActivity) CartScreen.this).clear((View) upSellingSectionDataAdapterItemRowHolder.f53800i);
                    GlideApp.with((FragmentActivity) CartScreen.this).load(menuItem.getThumbnail(200)).listener((RequestListener) new RequestListener<Drawable>() {
                        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
                            String trim = menuItem.getThumbnail(200).trim();
                            if (!TalabatUtils.isNullOrEmpty(trim.substring(trim.lastIndexOf("/") + 1))) {
                                upSellingSectionDataAdapterItemRowHolder.f53803l.setVisibility(0);
                            } else {
                                upSellingSectionDataAdapterItemRowHolder.f53803l.setVisibility(8);
                                upSellingSectionDataAdapterItemRowHolder.f53800i.setImageResource(0);
                                upSellingSectionDataAdapterItemRowHolder.f53800i.setVisibility(0);
                            }
                            return false;
                        }

                        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                            upSellingSectionDataAdapterItemRowHolder.f53803l.setVisibility(8);
                            return false;
                        }
                    }).apply(TalabatGlideModule.requestOptions().transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners(CartScreen.this.getResources().getDimensionPixelSize(R.dimen.card_corner_radius))})).into(upSellingSectionDataAdapterItemRowHolder.f53800i);
                }
            } else {
                upSellingSectionDataAdapterItemRowHolder.f53800i.setImageResource(0);
                upSellingSectionDataAdapterItemRowHolder.f53800i.setVisibility(0);
            }
            upSellingSectionDataAdapterItemRowHolder.f53804m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CartScreen.this.cartPresenter.addUpsellingItem(menuItem);
                    CartScreen.this.upsellingScrollPosition = i11;
                    CartScreen.this.cartList.smoothScrollToPosition(CartScreen.this.mainListTotalCount);
                    CartRecyclerviewAdapter cartRecyclerviewAdapter = CartScreen.this.cartRecyclerviewAdapter;
                    cartRecyclerviewAdapter.notifyItemRangeChanged(0, cartRecyclerviewAdapter.getItemCount() - 1);
                    AppTracker.upsellCokeItemAddClicked(CartScreen.this, menuItem.f13862name);
                }
            });
            upSellingSectionDataAdapterItemRowHolder.f53802k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    upSellingSectionDataAdapterItemRowHolder.f53804m.performClick();
                }
            });
        }

        public UpSellingSectionDataAdapterItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new UpSellingSectionDataAdapterItemRowHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.upselling_single_item, viewGroup, false));
        }
    }

    public class UpSellingViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public RecyclerView f53806h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f53807i;

        /* renamed from: j  reason: collision with root package name */
        public ImageView f53808j;

        /* renamed from: k  reason: collision with root package name */
        public LinearLayout f53809k;

        public UpSellingViewHolder(View view) {
            super(view);
            this.f53806h = (RecyclerView) view.findViewById(R.id.up_selling_vertical_list);
            this.f53807i = (TextView) view.findViewById(R.id.up_selling_txt);
            this.f53808j = (ImageView) view.findViewById(R.id.up_selling_img);
            this.f53809k = (LinearLayout) view.findViewById(R.id.upselling_container);
        }
    }

    private String constructMainContent(Restaurant restaurant) {
        if (restaurant.isTalabatGo) {
            return getResources().getString(R.string.shop_busy_main_text_tgo);
        }
        return getResources().getString(R.string.shop_busy_main_text_tmp).replace(RichContentLoadTimeRecorder.DELIMETER, restaurant.f13873name);
    }

    private String constructSecondaryText(Restaurant restaurant) {
        if (restaurant.isTalabatGo) {
            return getResources().getString(R.string.shop_busy_second_text_tgo);
        }
        return getResources().getString(R.string.shop_busy_second_text_tmp);
    }

    @NotNull
    private CartPresenter createCartPresenter(ConfigurationLocalRepository configurationLocalRepository, DiscoveryConfigurationRepository discoveryConfigurationRepository, LocationConfigurationRepository locationConfigurationRepository, OrderExperienceConfigurationRepository orderExperienceConfigurationRepository, ITalabatFeatureFlag iTalabatFeatureFlag, GetAutoApplyDiscountsUseCase getAutoApplyDiscountsUseCase) {
        ITalabatFeatureFlag iTalabatFeatureFlag2 = iTalabatFeatureFlag;
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        ITalabatFeatureFlag iTalabatFeatureFlag3 = iTalabatFeatureFlag;
        CustomerAddressesRepository provideCustomerAddressesRepository = AddressesDependencyProvider.INSTANCE.provideCustomerAddressesRepository(iTalabatFeatureFlag2);
        CustomerRepository customerRepository = this.E;
        UpdateAreaOfSelectedAddressIfChangedUseCase provideUpdateAreaOfSelectedAddressIfChangedUseCase = LocationDependencyProvider.INSTANCE.provideUpdateAreaOfSelectedAddressIfChangedUseCase(this, this.f53708p, iTalabatFeatureFlag2);
        Scheduler io2 = Schedulers.io();
        Scheduler mainThread = AndroidSchedulers.mainThread();
        v0 v0Var = r10;
        v0 v0Var2 = new v0(this);
        w0 w0Var = r11;
        w0 w0Var2 = new w0();
        DependencyProvider dependencyProvider = DependencyProvider.INSTANCE;
        SelectSavedAddressIfCanDeliverToVendorUseCase provideSelectSavedAddressIfCanDeliverToVendorUseCase = dependencyProvider.provideSelectSavedAddressIfCanDeliverToVendorUseCase(dependencyProvider.provideHomeMapCache(this), this.E, dependencyProvider.provideDeliverAreaDetailsNetworkRepository(dependencyProvider.provideDeliveryAreaDetailsApi()));
        TalabatExperiment talabatExperiment = TalabatExperiment.INSTANCE;
        GetTProOrderStatusUseCase getTProOrderStatusUseCase = this.B;
        PaymentConfigurationRepository paymentConfigurationRepository = this.f53713u;
        CartUtility cartUtility = this.f53717y;
        return new CartPresenter(this, provideCustomerAddressesRepository, customerRepository, configurationLocalRepository, locationConfigurationRepository2, provideUpdateAreaOfSelectedAddressIfChangedUseCase, io2, mainThread, v0Var, w0Var, provideSelectSavedAddressIfCanDeliverToVendorUseCase, iTalabatFeatureFlag3, talabatExperiment, getTProOrderStatusUseCase, discoveryConfigurationRepository, orderExperienceConfigurationRepository, paymentConfigurationRepository, cartUtility, getAutoApplyDiscountsUseCase, this.C, this.f53708p, this.D);
    }

    private boolean dismissDialog() {
        Dialog dialog = this.popupWindow;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        this.popupWindow.dismiss();
        return true;
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

    private String getImageUrl() {
        String replaceAll = GlobalDataModel.PARALLELBIN.commonIconUrl.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "VoucherCampaign/" + replaceAll;
    }

    private boolean getParallelBinNotificationShown() {
        return getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getBoolean("ParallelBinCampaignStatus", false);
    }

    private PickupConfig getPickupConfig() {
        return (PickupConfig) RemoteConfiguration.INSTANCE.getRemoteConfiguration(VendorListRemoteConfigurationsKeys.PICKUP_VL_CONFIG, new PickupConfig(), PickupConfig.class);
    }

    /* access modifiers changed from: private */
    public void handleDeliveryFeeValue(FeeValue feeValue) {
        float f11;
        ICartPresenter iCartPresenter = this.cartPresenter;
        if (feeValue == null) {
            f11 = 0.0f;
        } else {
            f11 = (float) feeValue.getValue();
        }
        iCartPresenter.handleDeliveryFee(f11);
        this.deliveryFee = feeValue;
        notifyFooterChanged();
    }

    /* access modifiers changed from: private */
    public void handleDisclaimerBannerInfo(DisclaimerBannerDisplayModel disclaimerBannerDisplayModel2) {
        this.disclaimerBannerDisplayModel = disclaimerBannerDisplayModel2;
        notifyFooterChanged();
    }

    /* access modifiers changed from: private */
    public void handleFeesDescriptions(FeesDescriptionsDisplayModel feesDescriptionsDisplayModel) {
        this.feesDescriptions = feesDescriptionsDisplayModel;
        CartRecyclerviewAdapter cartRecyclerviewAdapter2 = this.cartRecyclerviewAdapter;
        cartRecyclerviewAdapter2.notifyItemChanged(cartRecyclerviewAdapter2.getAllItemsCount());
    }

    /* access modifiers changed from: private */
    public void handleServiceFeeValue(FeeValue feeValue) {
        float f11;
        ICartPresenter iCartPresenter = this.cartPresenter;
        if (feeValue == null) {
            f11 = 0.0f;
        } else {
            f11 = (float) feeValue.getValue();
        }
        iCartPresenter.handleServiceFee(f11);
        this.serviceFee = feeValue;
        notifyFooterChanged();
    }

    /* access modifiers changed from: private */
    public void handleSmallOrderFeeValue(FeeValue feeValue) {
        float f11;
        ICartPresenter iCartPresenter = this.cartPresenter;
        if (feeValue == null) {
            f11 = 0.0f;
        } else {
            f11 = (float) feeValue.getValue();
        }
        iCartPresenter.handleSmallOrderFee(f11);
        this.smallOrderFee = feeValue;
        notifyFooterChanged();
    }

    private Boolean isDynamicMOVEnabled() {
        return Boolean.valueOf(!this.f53715w.getStringVariant(MenuExperimentsKeys.IS_DYNAMIC_MOV_ENABLED, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Control"));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$isGrlRestaurantRedirect$14(View view) {
        AppTracker.onMcdCloseClicked(this);
        this.popupWindow.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$isGrlRestaurantRedirect$15(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, View view) {
        AppTracker.onMcdNewAddressClicked(this);
        this.popupWindow.dismiss();
        redirectAddAddressScreen(address, false, z11, z12, z13, z14, z15, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$isGrlRestaurantRedirect$16(Address address, boolean z11, boolean z12, boolean z13, View view) {
        AppTracker.onMcdUpdateaAddressClicked(this);
        this.popupWindow.dismiss();
        redirectAddAddressScreen(address, false, false, false, z11, z12, z13, false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$observeApiResponses$9(Boolean bool) {
        if (bool == null) {
            return;
        }
        if (bool.booleanValue()) {
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            this.cartPresenter.clearShowBusyPopup();
            if (restaurant != null) {
                trackTheEvent(restaurant);
                openBusyBottomSheet(restaurant, constructMainContent(restaurant), constructSecondaryText(restaurant));
                return;
            }
            return;
        }
        proceedWithOpeningCheckoutScreen();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$observeVoucherStackingError$8(Boolean bool) {
        if (bool != null) {
            this.cartPresenter.getFreeDeliveryVoucherStackingError().setValue(null);
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setTitle((CharSequence) getString(R.string.free_delivery_voucher_stacking_error_title));
            builder.setMessage((CharSequence) getString(R.string.free_delivery_voucher_stacking_error_body));
            builder.setPositiveButton((int) R.string.close, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(View view) {
        this.cartPresenter.addMoreItemsClicked(Cart.getInstance().getRestaurant(), GlobalConstants.LOGGER_CART_HAS_ITEMS_SCENARIO);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        this.cartPresenter.addMoreItemsClicked(Cart.getInstance().getRestaurant(), GlobalConstants.LOGGER_CART_EMPTY_SCENARIO);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        if (this.isEditing) {
            this.isEditing = false;
            this.edit_cart.setText(R.string.edit);
            this.delete.setVisibility(8);
            this.clear_cart.setVisibility(8);
            this.cartPresenter.editCartCompleted();
        } else {
            this.isEditing = true;
            this.edit_cart.setText(R.string.done);
            this.delete.setVisibility(8);
            this.clear_cart.setVisibility(8);
        }
        this.cartList.getRecycledViewPool().clear();
        this.cartRecyclerviewAdapter.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(DialogInterface dialogInterface, int i11) {
        Cart.getInstance().clearCart(this);
        onCartEmpty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new i1(this));
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().rejectGem(true);
        }
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            checkShopStatusAndredirectToCheckout();
        } else if (GEMEngine.getEligibleOfferAmount() == 0.0f) {
            this.mGemDialogSwitcher.showGemDialog(4, false);
        } else {
            checkShopStatusAndredirectToCheckout();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        if (getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false)) {
            startActivity(new Intent(this, HomeScreenActivity.class));
            exitAnimation();
            return;
        }
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onParallelBinAvailable$17(View view) {
        this.parallelBinView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onParallelBinAvailable$18(View view) {
        new ParallelBinDialog().show(getSupportFragmentManager(), "Parallel Bin Dialog");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showLoginOptionsBottomSheet$13() {
        this.cartPresenter.onGuestCheckoutRequested();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Unit lambda$showUserVerifyicationView$11(String str, String str2, String str3, Intent intent) {
        intent.putExtra("firstName", str);
        intent.putExtra("lastName", str2);
        intent.putExtra("dateOfBirth", str3);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public void notifyFooterChanged() {
        CartRecyclerviewAdapter cartRecyclerviewAdapter2 = this.cartRecyclerviewAdapter;
        cartRecyclerviewAdapter2.notifyItemChanged(cartRecyclerviewAdapter2.getAllItemsCount());
    }

    private void observeApiResponses() {
        this.cartPresenter.getShowBusyPopup().observe(this, new g1(this));
    }

    private void observeVoucherStackingError() {
        this.cartPresenter.getFreeDeliveryVoucherStackingError().observe(this, new h1(this));
    }

    private void openBusyBottomSheet(Restaurant restaurant, String str, String str2) {
        boolean z11;
        Cuisine[] cuisineArr = restaurant.cuisines;
        int i11 = 0;
        if (cuisineArr == null || cuisineArr.length <= 0 || cuisineArr[0] == null) {
            z11 = false;
        } else {
            z11 = true;
        }
        BusyPopupBottomSheet.Companion companion = BusyPopupBottomSheet.Companion;
        if (z11) {
            i11 = cuisineArr[0].f13848id;
        }
        companion.newInstance(i11, 0, z11, 5, str, str2, getResources().getString(R.string.view_similar_restaurants), this).showDialog(getSupportFragmentManager(), "busy popup bottom sheet dialog");
    }

    /* access modifiers changed from: private */
    public void openUrl(String str) {
        if (str != null && !str.isEmpty()) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
        }
    }

    private void proceedWithOpeningCheckoutScreen() {
        if (Cart.getInstance().isBestCouponAvailable()) {
            Coupon bestCoupon = Cart.getInstance().getBestCoupon();
            if (bestCoupon != null) {
                selectCoupon(bestCoupon);
                showBestCouponPopup(Cart.getInstance().getRestaurant());
                return;
            }
            return;
        }
        this.cartPresenter.confirmButtonPressed(Cart.getInstance().getRestaurant(), this, true, false, true, false, false);
    }

    /* access modifiers changed from: private */
    public void redirectAddAddressScreen(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        String str;
        stopLodingPopup();
        if (TalabatUtils.isMcdInforMapEnabledCountry()) {
            if (!(McdMapTempAddress.getInstance().getSelectedGrlTempAddress() == null || address == null)) {
                address = AddressesKt.merge(address, McdMapTempAddress.getInstance().getSelectedGrlTempAddress());
            }
        } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
            if (McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() == null || address == null) {
                address = AddressesKt.merge(new Address(), McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress());
            } else {
                address = AddressesKt.merge(address, McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress());
            }
        } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
            address = null;
        } else if (!(McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress() == null || address == null)) {
            address = AddressesKt.merge(address, McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress());
        }
        Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), "cart");
        if (z16) {
            addressFormActivityIntent = new Intent(this, AddAddressScreen2.class);
        }
        addressFormActivityIntent.putExtra("noAreaChange", true);
        addressFormActivityIntent.putExtra("from", "Cart Screen");
        if (address != null) {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) address);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) address);
            }
        } else {
            str = "";
        }
        addressFormActivityIntent.putExtra("address", str);
        addressFormActivityIntent.putExtra("value", str);
        addressFormActivityIntent.putExtra("map_compulsory", z11);
        addressFormActivityIntent.putExtra("nineCookiesEnabled", z14);
        addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", true);
        addressFormActivityIntent.putExtra("isNewAddressFromCartOrderFlow", z12);
        addressFormActivityIntent.putExtra("newaddressCreation", z13);
        addressFormActivityIntent.putExtra("nineCookiesEnabled", z14);
        addressFormActivityIntent.putExtra("talabatDeliveryAvailable", z15);
        addressFormActivityIntent.putExtra("isGlrEnabledRes", z16);
        addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", z17);
        addressFormActivityIntent.putExtra("isFromMcdAddressFlow", z16);
        if (z16) {
            addressFormActivityIntent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        }
        startActivityForResult(addressFormActivityIntent, 300);
    }

    /* access modifiers changed from: private */
    public void selectPromotion(Promotion promotion) {
        String str;
        String str2;
        if (Cart.getInstance().canAddPromotion(promotion)) {
            if (promotion.isBenefitListOfItems) {
                Intent intent = new Intent(this, FreeItemList.class);
                Gson gson = UniversalGson.INSTANCE.gson;
                BenefitItem[] benefitItemArr = promotion.benefitItems;
                if (!(gson instanceof Gson)) {
                    str2 = gson.toJson((Object) benefitItemArr);
                } else {
                    str2 = GsonInstrumentation.toJson(gson, (Object) benefitItemArr);
                }
                Cart.getInstance().setSelectedPromotion(promotion);
                intent.putExtra("freeItems", str2);
                startActivityForResult(intent, 100);
            } else if (promotion.benefitItems[0].containsChoices) {
                Intent intent2 = new Intent(this, FreeItemDetails.class);
                Gson gson2 = UniversalGson.INSTANCE.gson;
                BenefitItem benefitItem = promotion.benefitItems[0];
                if (!(gson2 instanceof Gson)) {
                    str = gson2.toJson((Object) benefitItem);
                } else {
                    str = GsonInstrumentation.toJson(gson2, (Object) benefitItem);
                }
                intent2.putExtra("BenefitItem", str);
                Cart.getInstance().setSelectedPromotion(promotion);
                startActivityForResult(intent2, 100);
            } else {
                Cart.getInstance().setSelectedPromotion(promotion);
            }
            this.cartRecyclerviewAdapter.notifyDataSetChanged();
        }
    }

    private void setBroadcastReceiver() {
        registerReceiver(this.closeActivityReceiver, new IntentFilter(GlobalConstants.BROADCAST_KILL_CART));
    }

    private void setupFees() {
        FeesViewModel feesViewModel = (FeesViewModel) this.f53716x.create(FeesViewModel.class);
        this.G = feesViewModel;
        feesViewModel.getServiceFeeValue().observe(this, new y0(this));
        this.G.getSmallOrderFeeValue().observe(this, new z0(this));
        this.G.getDeliveryFeeValue().observe(this, new a1(this));
        this.G.getFeesDescriptions().observe(this, new b1(this));
        this.G.getDisclaimerBannerInformation().observe(this, new c1(this));
    }

    private void showCartAnimation() {
    }

    private void trackOnExpressCheckoutClicked() {
        Cart instance = Cart.getInstance();
        if (instance != null && instance.getCartItems() != null) {
            int size = instance.getCartItems().size();
            Restaurant restaurant = instance.getRestaurant();
            AppTracker.onExperssCheckoutClicked(this, size, AppTracker.getRestaurantId(restaurant), restaurant);
        }
    }

    private void trackTheEvent(Restaurant restaurant) {
        AppTracker.onBusyBottomSheetOpened(this, restaurant, ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
        this.cartPresenter.observeBusyPopupOpen(restaurant);
    }

    /* access modifiers changed from: private */
    public void voucherApplied(VoucherData voucherData) {
        LoyaltyVoucherResult layoutVoucherResult = VoucherDataKt.toLayoutVoucherResult(voucherData);
        LoyaltyVoucherRM loyaltyVoucherRM = new LoyaltyVoucherRM();
        loyaltyVoucherRM.result = layoutVoucherResult;
        Cart.getInstance().saveLoyaltyVoucher(getContext(), loyaltyVoucherRM);
        Cart.getInstance().calculateLoyaltyDiscount(getContext());
        notifyRecyclerViewFooter();
    }

    public void animateView(int i11, int i12, final View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "translationY", new float[]{(float) i11, (float) i12});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                view.setVisibility(0);
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    @VisibleForTesting
    public void applyPickupVoucher() {
        String pickupDiscountCode;
        if (!this.f53714v.getFeatureFlag(SearchFeatureFlagsKeys.SEARCH_ENABLE_PICKUP_DIFFERENTIAL_DISCOUNTS, false)) {
            PickupConfig pickupConfig = getPickupConfig();
            String voucherCode = pickupConfig.getVoucherCode();
            if (voucherCode == null) {
                voucherCode = PickupConfig.DEFAULT_VOUCHER_CODE;
            }
            if (pickupConfig.getShouldApplyVoucher()) {
                this.loyaltyDashboardApplyVouchersView.redeemVoucherCode(voucherCode);
            }
        } else if (Cart.getInstance().getRestaurant() != null && (pickupDiscountCode = Cart.getInstance().getRestaurant().getPickupDiscountCode()) != null && !m0.a(pickupDiscountCode)) {
            this.loyaltyDashboardApplyVouchersView.redeemVoucherCode(pickupDiscountCode);
        }
    }

    public void checkShopStatusAndredirectToCheckout() {
        if (GlobalDataModel.FunWithFlag.FunWithFlagEnableBusyPopupInCart) {
            this.cartPresenter.getShopStatus();
        } else {
            proceedWithOpeningCheckoutScreen();
        }
    }

    public void destroyPresenter() {
        this.cartPresenter = null;
    }

    public int getBlackColor() {
        return getResources().getColor(R.color.text_black);
    }

    public Context getContext() {
        return this;
    }

    public CartListViewItem getCouponOrPromotion(int i11) {
        int i12;
        boolean z11;
        boolean z12;
        boolean z13 = false;
        if (Cart.getInstance().getCoupons() != null) {
            int length = Cart.getInstance().getCoupons().length;
            if (Cart.getInstance().getCoupons().length > i11) {
                Coupon coupon = Cart.getInstance().getCoupons()[i11];
                if (i11 == 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (i11 == Cart.getInstance().getCoupons().length - 1) {
                    z13 = true;
                }
                return new CartListViewItem(coupon, z12, z13);
            }
        }
        if (Cart.getInstance().getPromotions() == null) {
            return null;
        }
        if (Cart.getInstance().getCoupons() != null) {
            i12 = Cart.getInstance().getCoupons().length;
        } else {
            i12 = 0;
        }
        if (Cart.getInstance().getPromotions().length + i12 <= i11) {
            return null;
        }
        int i13 = i11 - i12;
        Promotion promotion = Cart.getInstance().getPromotions()[i13];
        if (i13 == Cart.getInstance().getPromotions().length - 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (Cart.getInstance().getPromotions().length - 1 == i13) {
            z13 = true;
        }
        return new CartListViewItem(promotion, z11, z13);
    }

    public String getDeliveryChargesString() {
        return getResources().getString(R.string.restaurant_del_charges);
    }

    public String getFreeString() {
        return getResources().getString(R.string.free_caps);
    }

    public /* synthetic */ Map getGemComponentState() {
        return b.a(this);
    }

    public Context getGemContext() {
        return this;
    }

    public /* synthetic */ String getGemRemainingSecondsText() {
        return b.b(this);
    }

    public String getGemScreenType() {
        return ScreenNames.getScreenType(getScreenName());
    }

    public /* synthetic */ String getGemSelectedRestaurantPositionText() {
        return b.c(this);
    }

    public /* synthetic */ String getGemSelectedTierIndexText() {
        return b.d(this);
    }

    public int getGemTextColor(int i11) {
        return getResources().getColor(new int[]{R.color.gem_card_1, R.color.gem_card_2, R.color.gem_card_3, R.color.gem_card_4}[i11]);
    }

    public int getIndexOfMenuItem(int i11) {
        return i11 - (Cart.getInstance().getCouponsAndPromotionsCount() + (Cart.getInstance().hasReorderItemsStatus() ? 1 : 0));
    }

    public String getMinimumOrderString() {
        boolean z11;
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (Cart.getInstance().selectedCoupon != null) {
            z11 = Cart.getInstance().selectedCoupon.enforceMinOrderAmt;
        } else {
            z11 = false;
        }
        float f11 = Cart.getInstance().couponDiscount;
        if (restaurant == null) {
            return null;
        }
        String displayMinimumAmount = restaurant.getDisplayMinimumAmount();
        if (isDynamicMOVEnabled().booleanValue()) {
            displayMinimumAmount = restaurant.getDisplayDynamicMinimumAmount(Cart.getInstance().getCartSubTotal(), z11, f11);
        }
        return getResources().getString(R.string.min_order_amount_cart, new Object[]{displayMinimumAmount});
    }

    public String getMunicipalityTaxText() {
        return getResources().getString(R.string.muncipality_tax);
    }

    public String getNormalVoucherText() {
        return getResources().getString(R.string.dicount_voucher);
    }

    public IGlobalPresenter getPresenter() {
        return this.cartPresenter;
    }

    public int getPromoColor() {
        return getResources().getColor(R.color.promo);
    }

    public String getScreenName() {
        return "Cart Screen";
    }

    public String getTalabatChargesString() {
        return getResources().getString(R.string.talabat_charges);
    }

    public String getTouristTaxLabelText() {
        return getResources().getString(R.string.tourist_tax);
    }

    public int getVoucherDiscountTextColor() {
        return getResources().getColor(R.color.promo);
    }

    public String getZeroVoucherText() {
        return getResources().getString(R.string.zero_per_voucher_label);
    }

    public int getZeroVoucherTextColor() {
        return getResources().getColor(R.color.promo);
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f53704l = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f53704l, getScreenName());
            beginTransaction.commit();
        }
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public void isGrlRestaurantRedirect(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        String str;
        Address address2 = address;
        if (z15) {
            if (!dismissDialog()) {
                stopLodingPopup();
                if (TalabatUtils.isNullOrEmpty(address2.profileName)) {
                    str = GlobalDataModel.SelectedAreaName;
                } else {
                    str = address2.profileName + "(" + GlobalDataModel.SelectedAreaName + ")";
                }
                Dialog dialog = new Dialog(this, R.style.CustomStyle);
                this.popupWindow = dialog;
                dialog.requestWindowFeature(1);
                this.popupWindow.setContentView(R.layout.infomap_popup);
                this.popupWindow.getWindow().addFlags(4);
                this.popupWindow.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                this.popupWindow.setCancelable(false);
                this.popupWindow.setCanceledOnTouchOutside(false);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                this.popupWindow.getWindow().setLayout((int) (((double) displayMetrics.widthPixels) * 0.7d), -2);
                ((TextView) this.popupWindow.findViewById(R.id.address_update_text)).setText(getString(R.string.delivery_details_of_your_pinned).replace(RichContentLoadTimeRecorder.DELIMETER, str));
                ((ImageView) this.popupWindow.findViewById(R.id.close_popup_button)).setOnClickListener(new k1(this));
                Address address3 = address;
                this.popupWindow.findViewById(R.id.new_address_view).setOnClickListener(new l1(this, address3, z11, z12, z13, z14, z16));
                this.popupWindow.findViewById(R.id.continue_view).setOnClickListener(new m1(this, address3, z13, z14, z16));
                this.popupWindow.show();
                AppTracker.onMcdAddressPopupShown(this);
            }
        } else if (!z11 || !z12) {
            onRedirectToCheckOut(false, true, z13, z14, z16, false);
        } else {
            redirectAddAddressScreen(address, false, z11, z12, z13, z14, z16, true);
        }
    }

    public void isMapCompulsory(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        String str;
        String str2;
        Address address2 = address;
        if (!z11) {
            redirectAddAddressScreen(address, z11, z12, z13, z14, z15, false, false);
        } else if (!z12 || !z13) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setTitle((int) R.string.delivery_popup_title);
            if (TalabatUtils.isNullOrEmpty(address2.profileName)) {
                str = GlobalDataModel.SelectedAreaName;
            } else {
                str = address2.profileName + "(" + GlobalDataModel.SelectedAreaName + ")";
            }
            if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName)) {
                str2 = getString(R.string.force_map_message).replace("#", str);
            } else {
                str2 = getString(R.string.force_map_message);
            }
            builder.setMessage((CharSequence) str2);
            final Address address3 = address;
            final boolean z16 = z11;
            final boolean z17 = z12;
            final boolean z18 = z13;
            final boolean z19 = z14;
            final boolean z21 = z15;
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CartScreen.this.redirectAddAddressScreen(address3, z16, z17, z18, z19, z21, false, false);
                }
            });
            builder.show();
        } else {
            redirectAddAddressScreen(address, z11, z12, z13, z14, z15, false, false);
        }
    }

    public void mapFirstRedirect(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19) {
        Address address2 = address;
        boolean z21 = z12;
        boolean z22 = z14;
        boolean z23 = z17;
        stopLodingPopup();
        GlobalDataModel.GEO_CORDINATES.polyGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
        if (z19) {
            onRedirectToCheckOut(z11, z16, z14, z15, z17, z19);
        } else if (GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION != GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW) {
            Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), "cart");
            if (z23) {
                addressFormActivityIntent = new Intent(this, AddAddressScreen2.class);
            }
            addressFormActivityIntent.putExtra("noAreaChange", true);
            addressFormActivityIntent.putExtra("from", "Cart Screen");
            boolean z24 = z13;
            addressFormActivityIntent.putExtra("isNewAddressFromCartOrderFlow", z13);
            addressFormActivityIntent.putExtra("newaddressCreation", z12);
            addressFormActivityIntent.putExtra("isUpdateNowSelected", false);
            addressFormActivityIntent.putExtra("isFromHomeScreenMap", true);
            addressFormActivityIntent.putExtra("address", "");
            addressFormActivityIntent.putExtra("value", "");
            boolean z25 = z11;
            addressFormActivityIntent.putExtra("map_compulsory", z11);
            addressFormActivityIntent.putExtra("nineCookiesEnabled", z14);
            addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", true);
            addressFormActivityIntent.putExtra("isNewAddressFromCartOrderFlow", z12);
            addressFormActivityIntent.putExtra("nineCookiesEnabled", z14);
            boolean z26 = z15;
            addressFormActivityIntent.putExtra("talabatDeliveryAvailable", z15);
            addressFormActivityIntent.putExtra("isGlrEnabledRes", z23);
            addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", z12);
            addressFormActivityIntent.putExtra("isFromMcdAddressFlow", z23);
            startActivityForResult(addressFormActivityIntent, 300);
        } else if (address2 != null) {
            this.cartPresenter.updateAddressWithGoogleApi(address);
        }
    }

    public void mapFirstUpdateAddressRedirect(Address address, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17, boolean z18, boolean z19) {
        String str;
        stopLodingPopup();
        GlobalDataModel.GEO_CORDINATES.polyGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.areaCenterPoint = null;
        GlobalDataModel.GEO_CORDINATES.AreaPolGonPoints = null;
        GlobalDataModel.GEO_CORDINATES.ValidateWithareaPolygon = false;
        HomeMapTemp.INSTANCE.updateAddressNotSaved(true);
        Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), "cart");
        if (z17) {
            addressFormActivityIntent = new Intent(this, AddAddressScreen2.class);
        }
        addressFormActivityIntent.putExtra("noAreaChange", true);
        addressFormActivityIntent.putExtra("from", "Cart Screen");
        if (GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION != GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW || address == null) {
            str = "";
        } else {
            Gson gson = UniversalGson.INSTANCE.gson;
            if (!(gson instanceof Gson)) {
                str = gson.toJson((Object) address);
            } else {
                str = GsonInstrumentation.toJson(gson, (Object) address);
            }
            addressFormActivityIntent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            addressFormActivityIntent.putExtra("isUpdateNowSelected", true);
        }
        addressFormActivityIntent.putExtra("isFromHomeScreenMap", true);
        addressFormActivityIntent.putExtra("address", str);
        addressFormActivityIntent.putExtra("value", str);
        addressFormActivityIntent.putExtra("map_compulsory", z11);
        addressFormActivityIntent.putExtra("nineCookiesEnabled", z14);
        addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", true);
        addressFormActivityIntent.putExtra("isNewAddressFromCartOrderFlow", z12);
        addressFormActivityIntent.putExtra("nineCookiesEnabled", z14);
        addressFormActivityIntent.putExtra("talabatDeliveryAvailable", z15);
        addressFormActivityIntent.putExtra("isGlrEnabledRes", z17);
        addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", z12);
        addressFormActivityIntent.putExtra("isFromMcdAddressFlow", z17);
        addressFormActivityIntent.putExtra("isFromMcdAddressFlow", z17);
        addressFormActivityIntent.putExtra(GlobalConstants.HOME_SCREEN_MAP.SHOW_ADDRESS_CONFIRMATION, true);
        startActivityForResult(addressFormActivityIntent, 300);
    }

    public void navigateToFlutterMenu() {
        if (!getIntent().getBooleanExtra("isFromFlutterMenuScreen", false) || getIntent().getBooleanExtra(NavigationMethodChannel.IS_VENDOR_LIST, false)) {
            MenuNavigatorController.INSTANCE.navigateToMenu(this, new MenuNavigatorModel(Cart.getInstance().getRestaurant().branchId, Cart.getInstance().getDeliveryMode(), GlobalDataModel.ShopClickOrigin, Boolean.valueOf(Cart.getInstance().getRestaurant().isProRestaurant), -1), this.f53714v, this.A, this.f53718z);
            finish();
            return;
        }
        super.onBackPressed();
    }

    public void navigateToQuickOrderScreen(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        trackOnExpressCheckoutClicked();
        Intent intent = new Intent(this, QuickOrderScreen.class);
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z12);
        intent.putExtra("talabatDeliveryAvailable", z13);
        intent.putExtra("isGlrEnabledRes", z14);
        intent.putExtra("isFromHomeScreenMap", z15);
        startActivity(intent);
    }

    public void notifyItemRemovedToAdapter(int i11) {
        CartRecyclerviewAdapter cartRecyclerviewAdapter2 = this.cartRecyclerviewAdapter;
        if (cartRecyclerviewAdapter2 != null) {
            cartRecyclerviewAdapter2.notifyItemRemoved(Cart.getInstance().getCouponsAndPromotionsCount());
        }
    }

    public void notifyRecyclerViewFooter() {
        if (Cart.getInstance() != null) {
            Cart.getInstance().recalcualteTotal();
        }
        if (this.cartRecyclerviewAdapter != null) {
            this.cartList.post(new u0(this));
        }
    }

    public void notifySubTotalChanged(float f11) {
        this.G.onSubtotalChanged(f11, Cart.getInstance().getCartSubTotal(), Cart.getInstance().getCouponDiscount(), GlobalDataModel.LATLONGFORAPI.getLatitudeDouble().doubleValue(), GlobalDataModel.LATLONGFORAPI.getLongitudeDouble().doubleValue());
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        boolean z11;
        boolean z12;
        Object obj;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 100) {
            if (i12 == -1) {
                String stringExtra = intent.getStringExtra("selectedFreeItem");
                Gson gson = UniversalGson.INSTANCE.gson;
                Class cls = BenefitItem.class;
                if (!(gson instanceof Gson)) {
                    obj = gson.fromJson(stringExtra, cls);
                } else {
                    obj = GsonInstrumentation.fromJson(gson, stringExtra, cls);
                }
                Cart.getInstance().setSelectedBenefitItem((BenefitItem) obj);
                Cart.getInstance().recalcualteTotal();
                this.cartRecyclerviewAdapter.notifyDataSetChanged();
                return;
            }
            Cart.getInstance().setNoBenefitItemSelected();
            Cart.getInstance().recalcualteTotal();
            this.cartRecyclerviewAdapter.notifyDataSetChanged();
        } else if (i11 == 200 || i11 == 201) {
            this.cartPresenter.removeVoucherIfRequired();
            this.isRedirecting = true;
            if (i12 == -1) {
                this.cartPresenter.confirmButtonPressed(Cart.getInstance().getRestaurant(), this, true, false, true, false, false);
            } else if (i12 == 2) {
                this.cartPresenter.onResultFromLoginScreenForAddressList();
            } else if (i12 == EmailLoginActivityResults.RESULT_SUCCESSFUL_LOGIN.getResultCode()) {
                this.cartPresenter.onResultSuccessFromProgressiveLoginBottomSheet();
            }
        } else if (i11 == 300) {
            Flag flag = this.isFromVoucherViewToLogin;
            if (flag == null || !flag.getValue()) {
                Cart.getInstance().setCanShowLoyallyVoucherInCheckOut(true);
                if (i12 == -1) {
                    this.isRedirecting = true;
                    if (intent != null) {
                        boolean booleanExtra = intent.getBooleanExtra("isAddressFromCartOrderFlow", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("nineCookiesEnabled", false);
                        intent.getBooleanExtra("talabatDeliveryAvailable", false);
                        this.ismcdKsaAddressUpdateIgnore = intent.getBooleanExtra(GlobalConstants.INFOR_MAP.IS_MCD_KSA_UPDATE_IGNORE, false);
                        z12 = booleanExtra;
                        z11 = booleanExtra2;
                    } else {
                        z12 = false;
                        z11 = false;
                    }
                    this.cartPresenter.confirmButtonPressed(Cart.getInstance().getRestaurant(), this, z12, z11, this.ismcdKsaAddressUpdateIgnore, false, false);
                }
            }
        } else if (i11 == 500 && i12 == -1) {
            redirectToCheckoutAfterVerifyingUserInfo();
        }
    }

    public void onAddMoreItemClicked() {
        this.cartPresenter.addMoreItemsClicked(Cart.getInstance().getRestaurant(), GlobalConstants.LOGGER_GEM_FLOW);
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        if (this.fromCardScreen) {
            Intent intent = new Intent(this, RestaurantMenuScreenR.class);
            intent.addFlags(67108864);
            startActivity(intent);
            exitAnimation();
            return;
        }
        super.onBackPressed();
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public /* synthetic */ void onBackToRestaurantMenuPage(Dialog dialog) {
        a.c(this, dialog);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        finish();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onBusyPopupClosed() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            AppTracker.onBusyBottomSheetClosed(this, restaurant, ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
        }
    }

    public void onCartEmpty() {
        this.edit_cart.setVisibility(4);
        this.cartFullView.setVisibility(8);
        this.cartEmptyView.setVisibility(0);
        onShakeImage(R.id.no_cart_item);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public void onContinueToCheckout() {
        checkShopStatusAndredirectToCheckout();
    }

    public void onCouponsAndPromotionsLoaded(boolean z11, boolean z12) {
        this.showLoadingForCoupons = false;
        stopLodingPopup();
        if (z12 && z11) {
            Cart.getInstance().recalcualteTotal();
            this.cartRecyclerviewAdapter.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle) {
        ApiContainer apiContainer = (ApiContainer) getApplication();
        DaggerCartScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (FeesFeatureApi) apiContainer.getFeature(FeesFeatureApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (ExperimentCoreLibApi) apiContainer.getFeature(ExperimentCoreLibApi.class), (IncentiveAutoApplyDiscountsFeatureApi) apiContainer.getFeature(IncentiveAutoApplyDiscountsFeatureApi.class), (FoodCartFeatureApi) apiContainer.getFeature(FoodCartFeatureApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (NavigationCoreLibApi) apiContainer.getFeature(NavigationCoreLibApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        this.F.startTrace(new ScreenTrackerParams("cart", CartScreenPerformanceParams.SCREEN_NAME, "cart"));
        if (bundle != null) {
            Cart.getInstance();
            Cart.getSavedCart(this);
            Cart.getSavedMcdCartAddress(this);
        }
        setContentView((int) R.layout.cart_screen);
        new GemCartScreenBinder().accept((AppCompatActivity) this);
        showCartAnimation();
        setBroadcastReceiver();
        try {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setToolbarPadding(this.mToolbar);
            Cart instance = Cart.getInstance();
            this.f53714v.getFeatureFlag((FWFKey) TalabatFeatureFlagConstants.ENABLE_BUSY_POPUP_CART, false, false, (Function1<? super Boolean, Unit>) new n0());
            if (instance.hasItems()) {
                AppTracker.onCartPageLoaded(getContext(), instance.getRestaurant());
                if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                    if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null) {
                        Cart.getInstance().setInforMapAddress(McdMapTempAddress.getInstance().getSelectedGrlTempAddress());
                    }
                } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    if (McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() != null) {
                        Cart.getInstance().setMcdBhBlockAddress(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress());
                    }
                } else if (TalabatUtils.isMcdLatLngEnabledCountry() && McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress() != null) {
                    Cart.getInstance().setMcdKsLatLngAddress(McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress());
                }
            }
            this.cartList = (RecyclerView) findViewById(R.id.cartList);
            this.minimumOrderAmount = (TextView) findViewById(R.id.minimum_order_text);
            this.f53702j = new SpeedyLinearLayoutManager(this, 1, false);
            final CustomLayoutmanger customLayoutmanger = new CustomLayoutmanger(this, 1, false);
            this.f53701i = new SpeedyLinearLayoutManager(this, 1, false);
            this.cartList.setLayoutManager(customLayoutmanger);
            RecyclerView.ItemAnimator itemAnimator = this.cartList.getItemAnimator();
            if (itemAnimator instanceof SimpleItemAnimator) {
                ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
            }
            this.restaurantName = (TextView) findViewById(R.id.restaurantName);
            this.edit_cart = (Button) findViewById(R.id.edit_cart);
            this.delete = (Button) findViewById(R.id.delete_button);
            this.clear_cart = (Button) findViewById(R.id.clear_cart);
            this.continueButton = (Button) findViewById(R.id.btn_checkout);
            this.add_moreItems = (Button) findViewById(R.id.btn_moreItems);
            this.cartEmptyView = findViewById(R.id.cart_empty);
            this.cartFullView = findViewById(R.id.cart_full_view);
            this.restaurantArea = (TextView) findViewById(R.id.restaurantAreaName);
            this.addItems = (Button) findViewById(R.id.no_items_add_items);
            this.backButton = (ImageButton) findViewById(R.id.back);
            this.parallelBinView = findViewById(R.id.parallel_bin_view);
            this.parallelBinImageView = findViewById(R.id.parallel_bin_image_view);
            this.parallelBinImage = (ImageView) findViewById(R.id.parallel_bin_image);
            this.parallelBinProgressBar = (ProgressBar) findViewById(R.id.parallel_bin_image_progressBar);
            this.parallelText = (TextView) findViewById(R.id.parallel_bin_content);
            this.parallelBinMore = (TextView) findViewById(R.id.parallel_bin_more);
            CartPresenter createCartPresenter = createCartPresenter(this.f53710r, this.f53709q, this.f53711s, this.f53712t, this.f53714v, this.H);
            this.cartPresenter = createCartPresenter;
            this.showLoadingForCoupons = true;
            createCartPresenter.setViews();
            CartRecyclerviewAdapter cartRecyclerviewAdapter2 = new CartRecyclerviewAdapter(this.cartPresenter.getCartFooterListener());
            this.cartRecyclerviewAdapter = cartRecyclerviewAdapter2;
            this.cartList.setAdapter(cartRecyclerviewAdapter2);
            if (this.mGemDialogSwitcher == null) {
                this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
                this.mGemDialogSwitcher = new GemDialogSwitcher(this, this, getScreenName());
            }
            inflateGemFooter();
            this.add_moreItems.setOnClickListener(new o0(this));
            this.addItems.setOnClickListener(new p0(this));
            this.edit_cart.setOnClickListener(new q0(this));
            this.delete.setOnClickListener(new View.OnClickListener() {

                /* renamed from: b  reason: collision with root package name */
                public String f53719b = "";

                public void onClick(View view) {
                    if (CartScreen.this.deleteSelectionItems != null) {
                        for (int i11 = 0; i11 < CartScreen.this.deleteSelectionItems.size(); i11++) {
                            if (CartScreen.this.deleteSelectionItems.get(i11, false)) {
                                this.f53719b += "" + i11;
                            }
                        }
                    }
                }
            });
            this.clear_cart.setOnClickListener(new r0(this));
            this.continueButton.setOnClickListener(new s0(this));
            this.backButton.setOnClickListener(new t0(this));
            this.cartList.addOnScrollListener(new RecyclerView.OnScrollListener() {
                public void onScrolled(@NonNull RecyclerView recyclerView, int i11, int i12) {
                    super.onScrolled(recyclerView, i11, i12);
                    if (CartScreen.this.mToolbar != null) {
                        if (customLayoutmanger.findFirstCompletelyVisibleItemPosition() == 0) {
                            CartScreen.this.mToolbar.setElevation(0.0f);
                        } else {
                            CartScreen.this.mToolbar.setElevation(10.0f);
                        }
                    }
                }
            });
            observeVoucherStackingError();
            observeApiResponses();
            setupFees();
            this.cartPresenter.onViewLoaded();
        } catch (Exception e11) {
            e11.printStackTrace();
            pauseBannerForNextScreen();
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        try {
            BroadcastReceiver broadcastReceiver = this.closeActivityReceiver;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void onError() {
    }

    public void onGemEnabledItemUpdated() {
        if (GEMEngine.getInstance() != null && GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance().gemItemCartUpdation(Cart.getInstance().getCartSubTotal());
        }
        notifyRecyclerViewFooter();
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onLeaveOfferClicked(boolean z11) {
        showHideGemFooter(this.f53704l, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
            if (this.cartPresenter == null) {
                this.cartPresenter = createCartPresenter(this.f53710r, this.f53709q, this.f53711s, this.f53712t, this.f53714v, this.H);
                this.showLoadingForCoupons = true;
            }
            this.cartPresenter.setViews();
        }
        CartRecyclerviewAdapter cartRecyclerviewAdapter2 = this.cartRecyclerviewAdapter;
        if (cartRecyclerviewAdapter2 != null) {
            cartRecyclerviewAdapter2.notifyDataSetChanged();
        }
    }

    public void onMenuLoadingStarted() {
        startLodingPopup();
    }

    public void onNewIntent(Intent intent) {
        CartRecyclerviewAdapter cartRecyclerviewAdapter2;
        super.onNewIntent(intent);
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance().startListening(this, false);
        }
        if (!(intent.getStringExtra("from") == null || !intent.getStringExtra("from").equals("Checkout Screen") || (cartRecyclerviewAdapter2 = this.cartRecyclerviewAdapter) == null)) {
            this.cartList.setAdapter(cartRecyclerviewAdapter2);
        }
        notifyRecyclerViewFooter();
    }

    public void onParallelBinAvailable() {
        int i11;
        this.parallelBinView.setOnClickListener(new d1(this));
        TextView textView = this.parallelBinMore;
        if (GlobalDataModel.PARALLELBIN.moreBinModels.size() > 0) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        textView.setVisibility(i11);
        this.parallelBinMore.setOnClickListener(new e1(this));
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
                        CartScreen.this.parallelBinImageView.setVisibility(0);
                        CartScreen.this.parallelBinImage.setImageResource(R.drawable.ic_promo);
                        return false;
                    }

                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                        CartScreen.this.parallelBinProgressBar.setVisibility(8);
                        return false;
                    }
                }).into(this.parallelBinImage);
            }
        } else {
            this.parallelBinImageView.setVisibility(0);
            this.parallelBinImage.setImageResource(R.drawable.ic_promo);
        }
        if (!isGemActive() && !getParallelBinNotificationShown()) {
            AppTracker.onBinNotificationShown(this, getScreenName());
            setParallelBinNotificationShown();
            animateView(-this.parallelBinView.getHeight(), 0, this.parallelBinView);
            startParallelBinTimer();
        }
    }

    public void onPause() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        if (Cart.getInstance() != null) {
            Cart.getInstance().saveCart(this);
            Cart.getInstance().clearReorderStatus();
        }
        super.onPause();
    }

    public void onReadMoreInfoClicked() {
        this.G.onReadMoreExternalInfoClicked(getScreenName());
    }

    public void onRedirectToAddressSelection(boolean z11, boolean z12, boolean z13, boolean z14) {
        stopLodingPopup();
        Intent intent = new Intent(this, AddressList.class);
        intent.putExtra(GlobalConstants.ExtraNames.ISFORSELECTION, true);
        intent.putExtra(GlobalConstants.FORCE_MAP.RESTAURANT_TRACK_ENFORCE_MAP, z11);
        intent.putExtra("isAddressFromCartOrderFlow", true);
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z12);
        intent.putExtra("talabatDeliveryAvailable", z13);
        intent.putExtra("isGlrEnabledRes", z14);
        startActivityForResult(intent, 300);
    }

    public void onRedirectToCheckOut(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        stopLodingPopup();
        Intent intent = new Intent(this, CheckOutScreen.class);
        AppTracker.onCheckoutClicked(this, Cart.getInstance(), AppTracker.getRestaurantId(Cart.getInstance().getRestaurant()), Cart.getInstance().getCartCount(), getScreenName(), ScreenNames.getScreenType(getScreenName()));
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z13);
        intent.putExtra("isAddressFromCartOrderFlow", z12);
        intent.putExtra("talabatDeliveryAvailable", z14);
        intent.putExtra("isGlrEnabledRes", z15);
        intent.putExtra(GlobalConstants.INFOR_MAP.IS_FROM_MCD_NEW_ADDRESS_CHECKOUT, z16);
        startActivity(intent);
    }

    public void onRedirectToGroceryMenuPage() {
        stopLodingPopup();
        startActivity(new Intent(this, GroceryMenuScreen.class).addFlags(335544320));
        finish();
    }

    public void onRedirectToLogin(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        String str;
        stopLodingPopup();
        Intent intent = new Intent(this, LoginScreen.class);
        intent.putExtra("from", "Cart Screen");
        intent.putExtra("map_compulsory", z11);
        intent.putExtra("nineCookiesEnabled", z12);
        intent.putExtra("talabatDeliveryAvailable", z13);
        intent.putExtra("isGlrEnabledRes", z14);
        intent.putExtra("isFromHomeScreenMap", z15);
        if (z14) {
            if (!TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                    Gson gson = UniversalGson.INSTANCE.gson;
                    Address selectedMcdBlockTempAddress = McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress();
                    if (!(gson instanceof Gson)) {
                        str = gson.toJson((Object) selectedMcdBlockTempAddress);
                    } else {
                        str = GsonInstrumentation.toJson(gson, (Object) selectedMcdBlockTempAddress);
                    }
                } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                    Gson gson2 = UniversalGson.INSTANCE.gson;
                    Address selectedMcdLatLangTempAddress = McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress();
                    if (!(gson2 instanceof Gson)) {
                        str = gson2.toJson((Object) selectedMcdLatLangTempAddress);
                    } else {
                        str = GsonInstrumentation.toJson(gson2, (Object) selectedMcdLatLangTempAddress);
                    }
                }
                intent.putExtra("value", str);
                intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            } else if (McdMapTempAddress.getInstance().getSelectedGrlTempAddress() != null) {
                Gson gson3 = UniversalGson.INSTANCE.gson;
                Address selectedGrlTempAddress = McdMapTempAddress.getInstance().getSelectedGrlTempAddress();
                if (!(gson3 instanceof Gson)) {
                    str = gson3.toJson((Object) selectedGrlTempAddress);
                } else {
                    str = GsonInstrumentation.toJson(gson3, (Object) selectedGrlTempAddress);
                }
                intent.putExtra("value", str);
                intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            }
            str = "";
            intent.putExtra("value", str);
            intent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        }
        startActivityForResult(intent, 200);
    }

    public void onRedirectToMenuPage() {
        stopLodingPopup();
        Intent intent = new Intent(this, RestaurantMenuScreenR.class);
        intent.addFlags(335544320);
        startActivity(intent);
        finish();
    }

    public void onRequestError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onResume() {
        CartRecyclerviewAdapter cartRecyclerviewAdapter2;
        if (getIntent() != null) {
            this.fromCardScreen = getIntent().getBooleanExtra(GlobalConstants.KEY_FROMCARDSCREEN, false);
        }
        showHideGemFooter(this.f53704l, this, false);
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.showLoadingForCoupons = false;
            stopLodingPopup();
        }
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow && GlobalDataModel.GEMCONSTANTS.reloadRequired) {
            GlobalDataModel.GEMCONSTANTS.reloadRequired = false;
            if (this.cartPresenter == null) {
                this.cartPresenter = createCartPresenter(this.f53710r, this.f53709q, this.f53711s, this.f53712t, this.f53714v, this.H);
                this.showLoadingForCoupons = true;
            }
            this.cartPresenter.setViews();
            CartRecyclerviewAdapter cartRecyclerviewAdapter3 = this.cartRecyclerviewAdapter;
            if (cartRecyclerviewAdapter3 != null) {
                cartRecyclerviewAdapter3.notifyDataSetChanged();
            }
        }
        if (!(getIntent().getStringExtra("from") == null || !getIntent().getStringExtra("from").equals("Checkout Screen") || (cartRecyclerviewAdapter2 = this.cartRecyclerviewAdapter) == null)) {
            this.cartList.setAdapter(cartRecyclerviewAdapter2);
        }
        if (!this.isRedirecting) {
            notifyRecyclerViewFooter();
        } else {
            this.isRedirecting = false;
        }
        TextView textView = this.restaurantArea;
        textView.setText("(" + Cart.getInstance().getCartAreaName() + ")");
        this.cartPresenter.removeBinDiscount();
        this.cartPresenter.recalculateAppliedVoucher();
        super.onResume();
    }

    public void onReviewLoadingCompleted(RestaurantReviewPaging[] restaurantReviewPagingArr, int i11, int i12, RatingSection ratingSection) {
        RestaurantReview restaurantReview = new RestaurantReview();
        restaurantReview.rev = restaurantReviewPagingArr;
        restaurantReview.ratingSection = ratingSection;
        restaurantReview.totalPages = i11;
        restaurantReview.totalReviews = i12;
        GlobalDataModel.REVIEWS.mRestaurantReviews = restaurantReview;
        finish();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void onServerError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onSetWalletABTestStatus(boolean z11) {
        if (BuildConfig.IS_ALPHA.booleanValue()) {
            GlobalDataModel.isUserEligibleForWalletPaymentOptionABTest = true;
        } else {
            GlobalDataModel.isUserEligibleForWalletPaymentOptionABTest = z11;
        }
    }

    public void onShopClicked(Restaurant restaurant, int i11) {
        if (restaurant != null) {
            AppTracker.onBusyBottomSheetRecommendedRestaurantClicked(this, restaurant, ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
            this.cartPresenter.observeBusyPopupRestaurantSelection(restaurant);
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            com.talabat.talabatnavigation.Navigator.Companion.navigate((Context) this, OPNavigatorActions.Companion.createNavigatorModelForMenuBridgeActivity(restaurant.branchId, restaurant.shopType, restaurant.isGlrEnabled, restaurant.isDarkStore, restaurant.isMigrated));
        }
    }

    public void onUpsellingItemsRecieved(ArrayList<MenuItem> arrayList) {
        CartRecyclerviewAdapter cartRecyclerviewAdapter2 = this.cartRecyclerviewAdapter;
        if (cartRecyclerviewAdapter2 != null) {
            cartRecyclerviewAdapter2.notifyDataSetChanged();
        }
    }

    public void onWindowFocusChanged(boolean z11) {
    }

    public void redirectToCheckoutAfterVerifyingUserInfo() {
        this.cartPresenter.confirmButtonPressed(Cart.getInstance().getRestaurant(), this, true, false, true, false, true);
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public void selectCoupon(Coupon coupon) {
        if (Cart.getInstance().canAddCoupon(coupon)) {
            Cart.getInstance().setSelectedCoupon(coupon);
            Cart.getInstance().recalcualteTotal();
            this.cartRecyclerviewAdapter.notifyDataSetChanged();
        }
    }

    public void setContinueButtonAlpha(float f11) {
        this.continueButton.setAlpha(f11);
    }

    public void setContinueButtonEnabledStatus(boolean z11) {
        this.continueButton.setEnabled(z11);
    }

    public void setLoyaltyDashboardApplyVouchersView(ApplyVouchersView applyVouchersView) {
        this.loyaltyDashboardApplyVouchersView = applyVouchersView;
    }

    public void setMinimumOrderText(String str) {
        this.minimumOrderAmount.setText(str);
    }

    public void setMinimumOrderVisibility(int i11) {
        this.minimumOrderAmount.setVisibility(i11);
    }

    public void setParallelBinNotificationShown() {
        SharedPreferences.Editor edit = getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
        edit.putBoolean("ParallelBinCampaignStatus", true);
        edit.apply();
    }

    public void setRestaurantName(String str, String str2) {
        this.restaurantName.setText(str);
        TextView textView = this.restaurantArea;
        textView.setText("(" + str2 + ")");
    }

    public void showBestCouponPopup(final Restaurant restaurant) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((int) R.string.best_coupon_selected);
        builder.setNegativeButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CartScreen.this.cartPresenter.confirmButtonPressed(restaurant, CartScreen.this, true, false, true, false, false);
            }
        });
        builder.show();
    }

    public void showCouponLoading() {
        this.showLoadingForCoupons = true;
        startLodingPopup();
    }

    public void showCouponPopup(final Coupon coupon) {
        boolean z11;
        if (Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().ismixoffer) {
            z11 = true;
        } else {
            z11 = false;
        }
        int hintType = coupon.getHintType(this.cartPresenter.getIsNonCombinationalPromotionItemPresent(), Cart.getInstance().isCouponApplied());
        if (hintType == 0) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setMessage((int) R.string.coupon_cannot_be_combined);
            builder.setNegativeButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder.show();
        } else if (hintType == 4) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder2.setMessage((CharSequence) getString(R.string.satisfy_minimum_order_amount).replace(RichContentLoadTimeRecorder.DELIMETER, coupon.getFormattedQualifyingAmount(Cart.getInstance().getCartSubTotal())));
            builder2.setNegativeButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder2.show();
        } else if (hintType == 3) {
            AlertDialog.Builder builder3 = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder3.setMessage((CharSequence) getString(R.string.add_more_itmes_to_cart_for_offer).replace(RichContentLoadTimeRecorder.DELIMETER, coupon.getFormattedQualifyingAmount(Cart.getInstance().getCartSubTotal(z11, true))));
            builder3.setNegativeButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder3.show();
        } else if (hintType == 5) {
            AlertDialog.Builder builder4 = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder4.setMessage((CharSequence) getString(R.string.best_coupon_selected));
            builder4.setNegativeButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder4.show();
        } else if (hintType == 1 && Cart.getInstance().getRestaurant() != null && !Cart.getInstance().getRestaurant().ismixoffer && Cart.getInstance().isPromotionApplied()) {
            AlertDialog.Builder builder5 = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder5.setMessage((CharSequence) getString(R.string.promotion_to_coupon));
            builder5.setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CartScreen.this.selectCoupon(coupon);
                }
            });
            builder5.setNegativeButton((int) R.string.f54880no, (DialogInterface.OnClickListener) null);
            builder5.show();
        }
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showLoginOptionsBottomSheet(boolean z11) {
        new LoginOptionsBottomSheet(this, 201, new x0(z11), new f1(this)).show();
    }

    public void showMinimumOrderAmountPopup() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) getString(R.string.selected_items_cost_is_less));
        builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    public void showPromotionPoup(final Promotion promotion) {
        int hintType = promotion.getHintType();
        boolean isPromotionApplied = Cart.getInstance().isPromotionApplied();
        if (isPromotionApplied && Cart.getInstance().getRestaurant() != null && !Cart.getInstance().getRestaurant().ismixoffer) {
            isPromotionApplied = false;
        }
        if (hintType == 3) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setMessage((CharSequence) getString(R.string.add_more_itmes_to_cart_for_promotion).replace(RichContentLoadTimeRecorder.DELIMETER, promotion.getFormattedQualifyingAmount(Cart.getInstance().getCartSubTotal(isPromotionApplied, false))));
            builder.setNegativeButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
            builder.show();
        } else if (hintType == 1 && Cart.getInstance().getRestaurant() != null && !Cart.getInstance().getRestaurant().ismixoffer && Cart.getInstance().isCouponApplied()) {
            AlertDialog.Builder builder2 = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder2.setMessage((CharSequence) getString(R.string.coupon_to_promotion));
            builder2.setPositiveButton((int) R.string.yes, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CartScreen.this.selectPromotion(promotion);
                }
            });
            builder2.setNegativeButton((int) R.string.f54880no, (DialogInterface.OnClickListener) null);
            builder2.show();
        }
    }

    public void showTimeOutDialog() {
        if (this.mGemDialogSwitcher.isDialogShowing()) {
            onCloseButtonClicked(this.mGemDialogSwitcher.dialog);
        }
        notifyRecyclerViewFooter();
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f53704l, this, this);
    }

    public void showTimerView(boolean z11, String str) {
        this.f53704l.setTimerText(str);
    }

    public void showUserVerifyicationView(String str, String str2, String str3) {
        NavigatorModelForResult createOpenScreenModelForResult = ComplianceUserStatusActions.INSTANCE.createOpenScreenModelForResult(500);
        createOpenScreenModelForResult.setInit(new j1(str, str2, str3));
        com.talabat.talabatnavigation.Navigator.Companion.navigate((Activity) this, createOpenScreenModelForResult);
    }

    public void startParallelBinTimer() {
        this.f53705m = 10;
        this.f53706n = new Handler();
        AnonymousClass11 r02 = new Runnable() {
            public void run() {
                CartScreen cartScreen = CartScreen.this;
                int i11 = cartScreen.f53705m;
                if (i11 > 0) {
                    cartScreen.f53705m = i11 - 1;
                    cartScreen.f53706n.postDelayed(this, 1000);
                    return;
                }
                if (!cartScreen.parallelBinViewClosed) {
                    CartScreen.this.parallelBinViewClosed = true;
                    AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                    alphaAnimation.setDuration(700);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setStartOffset(50);
                    alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationEnd(Animation animation) {
                            CartScreen.this.parallelBinView.setVisibility(8);
                        }

                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }
                    });
                    CartScreen.this.parallelBinView.startAnimation(alphaAnimation);
                    CartScreen.this.stopParallelBinTimer();
                }
                CartScreen.this.f53706n.removeCallbacks(this);
            }
        };
        this.f53707o = r02;
        r02.run();
    }

    public void stopLoading() {
        stopLodingPopup();
    }

    public void stopLodingPopup() {
        if (!this.showLoadingForCoupons) {
            super.stopLodingPopup();
            this.F.stopTrace(new ScreenTrackerParams("cart", CartScreenPerformanceParams.SCREEN_NAME, "cart"));
        }
    }

    public void stopParallelBinTimer() {
        Handler handler;
        Runnable runnable = this.f53707o;
        if (runnable != null && (handler = this.f53706n) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void viewAllRestaurantsClicked() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            AppTracker.onBusyBottomSheetViewAllClicked(this, restaurant, ScreenNames.BUSY_POPUP, ScreenNames.getScreenType(ScreenNames.BUSY_POPUP));
        }
        this.cartPresenter.observeBusyPopupViewSimilarClick();
        Navigator.Companion companion = com.talabat.talabatnavigation.Navigator.Companion;
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
}
