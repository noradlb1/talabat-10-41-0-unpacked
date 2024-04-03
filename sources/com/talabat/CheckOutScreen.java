package com.talabat;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.BIN.BinTokenResponse;
import JsonModels.Response.Cashback.CashBackResponse;
import JsonModels.Response.Cashback.CashbackRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import JsonModels.Response.VisaCheckoutResponse.DecryptionResponse;
import JsonModels.Response.VisaCheckoutResponse.PurchaseResponse;
import JsonModels.parser.UniversalGson;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.McdMapTempAddress;
import buisnessmodels.TalabatFormatter;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.designsystem.ds_alert.DSAlert;
import com.designsystem.ds_simple_card.DSSimpleCard;
import com.designsystem.ds_tag.DSTag;
import com.designsystem.ds_text_link.DSTextLink;
import com.google.gson.Gson;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.Adyen.AdyenCheckoutScreen;
import com.talabat.CheckoutOrderTimeSelectorView;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.checkoutdotcom.CheckoutTokenScreen;
import com.talabat.components.gem.checkout.GemCheckoutScreenBinder;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFeatureFlagsKeys;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.IScreenTracker;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.core.observabilityNew.domain.common.ApiStatus;
import com.talabat.core.observabilityNew.domain.entity.ScreenTrackerParams;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.core.ui.di.AndroidComponentsKt;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.customer.domain.di.CustomerCoreLibApi;
import com.talabat.designhelpers.PinEntryEditText.PinView;
import com.talabat.designhelpers.Utils;
import com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLayoutListener;
import com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout;
import com.talabat.di.checkout.DaggerCheckoutScreenComponent;
import com.talabat.dialogs.ParallelBinDialog;
import com.talabat.dialogs.ProCheckoutWarningDialog;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.feature.bnplcheckout.BNPLCheckoutFlutterBottomSheet;
import com.talabat.feature.bnplcheckout.presentation.BNPLCheckoutFlutterFragment;
import com.talabat.feature.bnplcheckout.presentation.CardInfo;
import com.talabat.feature.cancellationpolicy.domain.HelpCenterFeatureApi;
import com.talabat.feature.cancellationpolicy.domain.ICancellationPolicyFlag;
import com.talabat.feature.darkstoresscheduleddelivery.domain.DarkstoresScheduledDeliveryFeatureApi;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.DarkstoresScheduledDeliveryUseCase;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCase;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;
import com.talabat.feature.fees.presentation.displaymodel.FeesDescriptionsDisplayModel;
import com.talabat.feature.fees.presentation.ui.FeesMismatchErrorDialog;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModel;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModelFactory;
import com.talabat.feature.helpcenter.presentation.CancellationPolicyView;
import com.talabat.feature.pickup.data.events.PopupClicked;
import com.talabat.feature.pickup.data.events.PopupLoaded;
import com.talabat.feature.pickup.domain.PickupFeatureApi;
import com.talabat.feature.pickup.presentation.PickupConfirmationDialogView;
import com.talabat.feature.ridertips.presentation.view.RiderTipView;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.di.SubscriptionsFeatureApi;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import com.talabat.feature.subscriptions.domain.wrapper.PostSubscriptionPaymentRxWrapper;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerView;
import com.talabat.feature.tpro.presentation.util.ToastExtensionsKt;
import com.talabat.fees.ServiceFeeView;
import com.talabat.fees.ShowFeesDescriptionBottomSheetClickListener;
import com.talabat.fees.SmallOrderFeeView;
import com.talabat.fragments.DeliverySlotPickerFragment;
import com.talabat.fragments.StringBottomsheetDialogFragment;
import com.talabat.gem.adapters.analytics.GemPageType;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.BuildConfigType;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.OrderTrackingNavigator;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.homemaphelper.CurrentLocationFetchRefactor;
import com.talabat.maps.domain.CameraUpdateFactory;
import com.talabat.maps.domain.FrameworkMap;
import com.talabat.maps.domain.LatLngFactory;
import com.talabat.maps.domain.MapsInitializer;
import com.talabat.maps.domain.ModelsRepository;
import com.talabat.maps.domain.OnMapReadyCallback;
import com.talabat.maps.domain.di.MapsCoreLibApi;
import com.talabat.maps.domain.model.LatLng;
import com.talabat.maps.presentation.MapContainerFragment;
import com.talabat.notifications.brazemigrator.guestuser.PlaceOrderIdProviderImp;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.screenrecorder.ScreenRecorder;
import com.talabat.talabatcommon.feature.vouchers.loyalty.tracking.GrowthTracker;
import com.talabat.talabatcommon.helpers.DarkstoresSharedPreferencesHelper;
import com.talabat.talabatcommon.helpers.GlideApp;
import com.talabat.talabatcommon.views.bottomsheet.OnReadMoreInfoClickedCallback;
import com.talabat.talabatcommon.views.checkoutForceCVV.view.CheckoutForceCVVBottomSheet;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.CheckoutForceCVVVViewModel;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.CheckoutForceCVVViewModelFactory;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.displaymodel.ForceCVVBottomSheetDisplayModel;
import com.talabat.talabatcommon.views.checkoutForceCVV.viewModel.displaymodel.ProceedToPaymentDisplayModel;
import com.talabat.talabatcommon.views.statusViews.Status;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVoucherOwner;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersView;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.ApplyVouchersViewCallback;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherData;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherDataKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModelKt;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.PaymentButtonTypeDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardType;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragmentKt;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.ul.addressform.FlutterAddressFormActivity;
import com.talabat.wallet.bnplmanager.data.local.BNPLManagerLocalDataSource;
import com.talabat.wallet.bnplmanager.data.remote.dto.BNPLEligibilityRequestDto;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLCardDetail;
import com.talabat.wallet.bnplmanager.data.remote.dto.request.BNPLOrderPaymentRequestDto;
import com.talabat.wallet.bnplmanager.di.factory.BNPLManagerViewModelFactory;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLFakeDoorTestAttemptedState;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPaymentFallbackEligibleStatus;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan;
import com.talabat.wallet.bnplmanager.domain.entity.BNPLValidationError;
import com.talabat.wallet.bnplmanager.domain.entity.DeliveryProvider;
import com.talabat.wallet.bnplmanager.domain.tracking.BNPLTrackerImplKt;
import com.talabat.wallet.bnplmanager.presentation.displaymodel.BNPLOrderPaymentState;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import com.talabat.wallet.bnplmanager.ui.BNPLBottomSheetInterface;
import com.talabat.wallet.bnplmanager.ui.BNPLEligibilityErrorDialog;
import com.talabat.wallet.bnplmanager.ui.BNPLInitiatePlaceOrderFragmentKt;
import com.talabat.wallet.bnplmanager.ui.BNPLOrderPaymentErrorDialog;
import com.talabat.wallet.bnplmanager.ui.BNPLPlaceOrderBottomSheet;
import com.talabat.wallet.bnplmanager.ui.BNPLPlaceOrderBottomSheetInterface;
import com.talabat.wallet.bnplmanager.ui.BnplOrderPaymentErrorDialogCallback;
import com.talabat.wallet.checkoutbinvoucher.di.factory.CheckoutBinVoucherViewModelFactory;
import com.talabat.wallet.checkoutbinvoucher.domain.entity.BinVoucherCheckEligibilityModel;
import com.talabat.wallet.checkoutbinvoucher.presentation.displaymodel.CheckoutBinVoucherState;
import com.talabat.wallet.checkoutbinvoucher.presentation.viewmodel.CheckoutBinVoucherViewModel;
import com.talabat.wallet.checkoutpaymentmanager.di.factory.CheckoutPaymentManagerViewModelFactory;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPlanEligibilityState;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.BNPLPopUpViewState;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.CheckoutPaymentUpdateDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.displaymodel.WalletBalanceDisplayModel;
import com.talabat.wallet.checkoutpaymentmanager.presentation.viewmodel.CheckoutPaymentUpdateViewModel;
import com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel;
import com.talabat.wallet.debitcarddeflection.presentation.viewmodel.di.factory.DebitCardDeflectionViewModelFactory;
import com.talabat.wallet.debitcarddeflection.ui.DebitCardBinInfoBottomSheet;
import com.talabat.wallet.debitcarddeflection.ui.DebitCardBinInfoBottomSheetInterface;
import com.talabat.wallet.payproxymanager.di.factory.PayProxyManagerViewModelFactory;
import com.talabat.wallet.payproxymanager.preesentation.displaymodel.SendCVVToProxyDisplayModel;
import com.talabat.wallet.payproxymanager.preesentation.viewmodel.PayProxyManagerViewModel;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import com.visa.checkout.CheckoutButton;
import com.visa.checkout.Environment;
import com.visa.checkout.Profile;
import com.visa.checkout.PurchaseInfo;
import com.visa.checkout.VisaCheckoutSdk;
import com.visa.checkout.VisaPaymentSummary;
import datamodels.CardInformation;
import datamodels.CartMenuItem;
import datamodels.CustomerInfo;
import datamodels.InvalidItem;
import datamodels.OrderDetails;
import datamodels.QuickOrderInfo;
import datamodels.Restaurant;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.checkout.CheckoutPresenter;
import library.talabat.mvp.checkout.CheckoutView;
import library.talabat.mvp.checkout.ICheckoutPresenter;
import library.talabat.mvp.checkout.checkoutrefactor.CheckoutRefactorPresenter;
import library.talabat.mvp.checkout.checkoutrefactor.CheckoutRefactorView;
import library.talabat.mvp.checkout.checkoutrefactor.PayProxyManagerPresenter;
import library.talabat.mvp.numberverification.INumberVerificationPresenter;
import library.talabat.mvp.payfortcardlist.IPayfortCardListPresenter;
import library.talabat.mvp.payfortcardlist.PayfortCardListPresenter;
import library.talabat.mvp.payfortcardlist.PayfortSavedCardListView;
import library.talabat.mvp.placeorder.PlaceOrderInteractor;
import library.talabat.mvp.placeorder.PlaceOrderPresenter;
import library.talabat.mvp.placeorder.PlaceOrderView;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import tracking.AppTracker;
import tracking.Purchase;
import tracking.ScreenNames;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;
import ue.a3;
import ue.a4;
import ue.a5;
import ue.b3;
import ue.b4;
import ue.b5;
import ue.c3;
import ue.c4;
import ue.c5;
import ue.d3;
import ue.d4;
import ue.e3;
import ue.e4;
import ue.f3;
import ue.f4;
import ue.g3;
import ue.g4;
import ue.h2;
import ue.h3;
import ue.h4;
import ue.i2;
import ue.i3;
import ue.i4;
import ue.j2;
import ue.j3;
import ue.j4;
import ue.k2;
import ue.k3;
import ue.k4;
import ue.l2;
import ue.l3;
import ue.l4;
import ue.m2;
import ue.m3;
import ue.m4;
import ue.n2;
import ue.n3;
import ue.n4;
import ue.o2;
import ue.o3;
import ue.o4;
import ue.p2;
import ue.p3;
import ue.p4;
import ue.q2;
import ue.q3;
import ue.q4;
import ue.r2;
import ue.r3;
import ue.r4;
import ue.s2;
import ue.s3;
import ue.s4;
import ue.t2;
import ue.t3;
import ue.t4;
import ue.u2;
import ue.u3;
import ue.u4;
import ue.v2;
import ue.v3;
import ue.v4;
import ue.w2;
import ue.w3;
import ue.w4;
import ue.x2;
import ue.x3;
import ue.x4;
import ue.y2;
import ue.y3;
import ue.y4;
import ue.z2;
import ue.z3;
import ue.z4;
import xq.b;
import yq.a;

@Instrumented
@GemPageType("checkout")
public class CheckOutScreen extends TalabatBase implements CheckoutView, PlaceOrderView, PayfortSavedCardListView, GemView, OnGemAlertDialogClickListener, CurrentLocationFetchRefactor.onLocationListener, StringBottomsheetDialogFragment.Listener, CheckoutForceCVVBottomSheet.CheckoutForceCVVBottomSheetInterface, GemAccessor, CheckoutRefactorView, DebitCardBinInfoBottomSheetInterface, SelectCardDialogAdapterInterface, BNPLBottomSheetInterface, BNPLPlaceOrderBottomSheetInterface, BnplOrderPaymentErrorDialogCallback, OnReadMoreInfoClickedCallback {
    private static final int ADDRESS_PAGE = 100;
    private static final int ADD_CARD_CHECKOUT = 304;
    private static final int MOB_VERIFCATION_DIALOG = 302;
    private static final int NEW_CARD_FOR_RESULT = 305;
    private static final int PAYMENTPAGE = 300;
    private static final int PAY_WITH_BENEFIT = 100;
    private static final int VISA_CHECKOUT_REQUEST_CODE = 303;
    public RadioButton A;
    public RadioButton B;
    public SubscriptionAtCheckoutBannerView C;
    @Inject
    public AppVersionProvider D;
    @Inject
    public ConfigurationLocalRepository E;
    @Inject
    public PickupFeatureApi F;
    @Inject
    public LocationConfigurationRepository G;
    @Inject
    public DiscoveryConfigurationRepository H;
    @Inject
    public PaymentConfigurationRepository I;
    @Inject
    public FeesViewModelFactory J;
    @Inject
    public IObservabilityManager K;
    @Inject
    public ITalabatFeatureFlag L;
    @Inject
    public ISubscriptionsTracker M;
    @Inject
    public DarkstoresScheduledDeliveryUseCase N;
    @Inject
    public IsDarkstoresScheduledDeliveryDiscountEnabledUseCase O;
    @Inject
    public TermsAndConditionsConfigurationRepository P;
    private IPayfortCardListPresenter PayfortCardListPresenter;
    @Inject
    public GetTProOrderStatusUseCase Q;
    @Inject
    public ModelsRepository R;
    @Inject
    public LatLngFactory S;
    @Inject
    public MapsInitializer T;
    @Inject
    public CameraUpdateFactory U;
    @Inject
    public CustomerRepository V;
    @Inject
    public IScreenTracker W;
    @Inject
    public PostSubscriptionPaymentRxWrapper X;
    @Inject
    public GetActiveSubscriptionsRxWrapper Y;
    @Inject
    public ISubscriptionStatusRepository Z;

    /* renamed from: a0  reason: collision with root package name */
    public FeesViewModel f53825a0;
    private View aboutFees;
    private boolean addCardPopupShown = false;
    private TextView addressDescription;
    private ImageView addressIcon;
    private TextView addressName;
    private boolean allowDuplicate = false;
    @VisibleForTesting
    public ApplyVouchersViewCallback applyVouchersViewCallback = new ApplyVouchersViewCallback() {
        public void applyVouchersViewFailure(@NotNull VoucherFailures voucherFailures) {
        }

        @NotNull
        public String getBranchId() {
            return String.valueOf(Cart.getInstance().getRestaurant().branchId);
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
            return String.valueOf(Cart.getInstance().getRestaurant().f13872id);
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
            CheckOutScreen.this.onRedirectToLoginScreen();
        }

        public void successApplyFreeItemVoucher(@NotNull Pair<VoucherData, VoucherItemsDisplayModel> pair) {
            if (!Cart.getInstance().isItemExistInCart(pair.getSecond().getResult().getId())) {
                Cart.getInstance().addItem(VoucherItemsDisplayModelKt.createCartMenuItem(pair.getSecond()), CheckOutScreen.this.getApplicationContext());
            }
            CheckOutScreen.this.voucherApplied(pair.getFirst());
        }

        public void successApplyVoucher(@NotNull VoucherData voucherData) {
            CheckOutScreen.this.voucherApplied(voucherData);
        }

        public void unAppliedAllVouchers() {
            CheckOutScreen.this.checkoutPresenter.removeVoucher();
        }
    };
    private TextView areaName;
    private View availableCredit;
    private TextView availableCreditValue;
    private View avoidCashWarningView;
    @Inject

    /* renamed from: b0  reason: collision with root package name */
    public ICancellationPolicyFlag f53826b0;
    private ImageView bNPLEligibilityErrorImageView;
    private View bNPLFakeDoorTestLayoutView;
    private TextView bNPLFakeDoorTestPaymentTypeTextView;
    private DSTag bNPLFakeDoorTestTagView;
    private View bNPLLayoutView;
    private TextView bNPLPaymentTypeTextView;
    private RadioButton bNPLRadioButton;
    private DSTag bNPLTagView;
    private ImageButton back;
    private float balanceAmountToPay = 0.0f;
    private BenefitManagerViewModel benefitManagerViewModel;
    private boolean binApplied = false;
    private TextView binMessage;
    /* access modifiers changed from: private */
    public boolean binMessageShown = false;
    private TextView binOffersText;
    private View binOffersView;
    private boolean binResponseReceived = true;
    private BinTokenResponse[] binTokens;
    /* access modifiers changed from: private */
    public View binView;
    /* access modifiers changed from: private */
    public boolean binViewClosed = false;
    private BNPLManagerViewModel bnplManagerViewModel;
    private BNPLPlaceOrderBottomSheet bnplPlaceOrderBottomSheet;
    private BNPLPlan bnplPlan;
    @Inject

    /* renamed from: c0  reason: collision with root package name */
    public BNPLManagerLocalDataSource f53827c0;
    private Button cancelCvv;
    private RelativeLayout cardAvilableView;
    private RecyclerView cardList;
    /* access modifiers changed from: private */
    public Dialog cardListDialog;
    public RadioButton[] cardRadioButtons;
    /* access modifiers changed from: private */
    public Cart cart = Cart.getInstance();
    private RadioButton cash;
    private ImageView cashIcon;
    private TextView cashLabelTxt;
    private View cashLayout;
    private TextView cashTotal;
    private TextView cashbackAvailableCredit;
    private View cashbackFeatureView;
    private View cashbackLayout;
    private ProgressBar cashbackProgressBar;
    private TextView cashbackText;
    private TextView changeAddress;
    private Button changeSelectCardTxt;
    private CheckoutBinVoucherViewModel checkoutBinVoucherViewModel;
    private ImageView checkoutDotComIcon;
    private TextView checkoutDotComTxt;
    /* access modifiers changed from: private */
    public CheckoutForceCVVVViewModel checkoutForceCVVVViewModel;
    /* access modifiers changed from: private */
    public CheckoutPaymentUpdateViewModel checkoutPaymentUpdateViewModel;
    /* access modifiers changed from: private */
    public ICheckoutPresenter checkoutPresenter;
    private CheckoutRefactorPresenter checkoutRefactorPresenter;
    private TextView checkout_disclaimer_text;
    private View checkout_disclaimer_view;
    private View checkoutdotLayout;
    private ImageView closeBinNotificationView;
    private ImageView closePopup;
    private View combinedDiscountLayout;
    private TextView combinedDiscountText;
    private TextView combinedDiscountValue;
    private Button confirmChoice;
    private CheckBox contactLessSelector;
    private View contactlessFeatureView;
    private TextView coupon_discount_value;
    private View coupon_discount_view;
    private ImageView creditIcon;
    private TextView creditLabelTxt;
    private View creditLayout;
    private LatLng currentLocation = null;
    private RadioButton debitCard;
    private TextView debitCardLabelTxt;
    private ImageView debitIcon;
    private View debitLayout;
    private ImageView defaultCreditCardIcon;
    private TextView defaultCreditCardName;
    /* access modifiers changed from: private */
    public RelativeLayout defaultPaymentOption;
    private boolean deferDarkstoreScheduleLaterClick = false;
    /* access modifiers changed from: private */
    public View deliveryAddressView;
    private TextView deliveryChargesText;
    private TextView deliveryChargesValue;
    private View deliveryChargesView;
    private FeeValue deliveryFeeCache;
    private View deliveryFeeClickableArea;
    private View deliveryFeeInfoIcon;
    private DSTag deliveryFirstOrder;
    private List<DeliverySlotContent> deliverySlots;
    private String deliveryTime = "";
    private RecyclerView dialogRecyclerView;
    private TextView directions;
    private TextView disabledCashExplanationText;
    private View disabledCashExplanationView;
    private TextView discountVoucherAmount;
    private TextView discountVoucherTxt;
    private View discountVoucherView;
    private DSAlert dsAlertCancellationPolicyNote;
    /* access modifiers changed from: private */
    public Dialog duplicateOrderDialog;
    private RadioButton[] duplicateOrderPopupRadioGroup;
    /* access modifiers changed from: private */
    public PinView editTextCvv;
    private String encryptedOrderId = "";
    private String encryptedTransactionId = "";
    private boolean existingCard = false;
    /* access modifiers changed from: private */
    public ExpandableLinearLayout expandableLinearLayout;
    private TextView expiryDate;
    private View expiryLayout;
    private FeesDescriptionsDisplayModel feesDescriptions;
    private String firstName;
    private Dialog forceCvvDialog;
    private TextView freeDeliverTypeVoucherAmount;
    private TextView freeDeliveryMore;
    private TextView freeDeliveryReturnValue;
    private TextView freeDeliverySavingsText;
    private TalabatTextView freeDeliveryText;
    private View freeDeliveryTypeVoucherLayout;
    private TextView freeDeliveryTypeVoucherText;
    private View freeDeliveryView;
    private TextView freeTrialInfoText;
    private RelativeLayout freeTrialLayout;
    private boolean fromPlaceOrder = false;
    private View gemDiscountView;
    private TextView gemOfferText;
    private TextView gemOfferValue;
    private TextView grandTotal;

    /* renamed from: i  reason: collision with root package name */
    public final TalabatFormatter f53828i = TalabatFormatter.getInstance();
    private String inforMapAddress = "";
    /* access modifiers changed from: private */
    public boolean isAddressFromCartOrderFlow;
    private boolean isBinDiscountAppliedForTracking = false;
    private boolean isCheckoutDotCom = false;
    private boolean isEditAddressFromCheckoutScreen;
    private boolean isFromAptimize;
    private boolean isFromChange = false;
    /* access modifiers changed from: private */
    public boolean isFromVisaCheckout = false;
    /* access modifiers changed from: private */
    public boolean isGateWayError;
    private boolean isGlrEnableAddNewAddress;
    /* access modifiers changed from: private */
    public boolean isGrlEnabled;
    /* access modifiers changed from: private */
    public boolean isLoggedIn;
    /* access modifiers changed from: private */
    public boolean isMapcompulsory;
    /* access modifiers changed from: private */
    public boolean isNewAddressCreation;
    private boolean isNewAddressCreationGlrFlow;
    /* access modifiers changed from: private */
    public boolean isNineCookiesTrackingEnabled;
    private boolean isOrderFlowSucess;
    private boolean isPostDated = false;
    /* access modifiers changed from: private */
    public boolean isQuick = false;
    /* access modifiers changed from: private */
    public boolean isTalabatDeliveryAvailable;
    private boolean isTokenisationAvaliable = false;

    /* renamed from: j  reason: collision with root package name */
    public float f53829j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    public boolean f53830k;
    private RelativeLayout kNetDebitCardLayout;
    private TextView knetTotal;

    /* renamed from: l  reason: collision with root package name */
    public String f53831l;
    /* access modifiers changed from: private */
    public String lastFour;
    private String lastName;
    private ActivityResultLauncher<Intent> launcher;
    private ApplyVouchersView loyaltyDashboardApplyVouchersView = null;

    /* renamed from: m  reason: collision with root package name */
    public QuickOrderInfo f53832m;
    /* access modifiers changed from: private */
    public SavedCardRecyclerViewAdapter mAdapter;
    private TextView mAddressDescriptionAb;
    private TextView mAddressNameAb;
    private View mAddressViewContainer;
    private View mAddressViewContainerMap;
    private TextView mAreaNameAb;
    private View mCurrentLocationAwarenessTxt;
    private TextView mDeliveryAddressTitle;
    private TextView mDirectionsAb;
    private GemDialogSwitcher mGemDialogSwitcher;
    private long mLastClickTime = 0;
    private TextView mMobileCountryCode;
    private TextView mMobileNumberAb;
    private TextView mMobileNumberLabel;
    private TextView mPhoneNumberAb;
    private ImageView mQuickAddressArrow;
    /* access modifiers changed from: private */
    public Toolbar mToolbar;
    private View mobileContainer;
    private String mobileForBin = "";
    private TextView mobileNumber;
    @VisibleForTesting

    /* renamed from: n  reason: collision with root package name */
    public Button f53833n;
    private NestedScrollView nestedScrollView;
    private View newTalabatCreditView;
    private Button noCardAddCardButton;
    private View noCardView;
    private INumberVerificationPresenter numberVerificationPresenter;

    /* renamed from: o  reason: collision with root package name */
    public GemFooterCartView f53834o;
    private TextView oldDeliveryCharges;
    private boolean orderSuccess;

    /* renamed from: p  reason: collision with root package name */
    public String f53835p = "";
    /* access modifiers changed from: private */
    public ImageView parallelBinImage;
    private View parallelBinImageView;
    private TextView parallelBinMore;
    /* access modifiers changed from: private */
    public ProgressBar parallelBinProgressBar;
    private View parallelBinView;
    private TextView parallelText;
    public View parentLayout;
    private View payByCash;
    private View payByKnet;
    private TextView payByMethod;
    private PayProxyManagerViewModel payProxyManagerViewModel;
    private View payRemainingbyCredit;
    /* access modifiers changed from: private */
    public Button payWithCVV;
    private TextView paymentBy;
    private LinearLayout paymentLayoutView;
    /* access modifiers changed from: private */
    public LinearLayout paymentOptionsContainer;
    private TextView paymentOptionsTitle;
    private TextView paymentTerms;
    private String paymnentMethod;
    private TextView phoneNumber;
    private TextView pickupText;
    private TextView pickupTime;
    private View pickupTimeContainer;
    private String planId = "";
    public int popupWidth;
    private View postDateDelivery;
    private String postOrderButtonText;
    private TextView preOrderTitle;
    /* access modifiers changed from: private */
    public boolean preselected = false;

    /* renamed from: q  reason: collision with root package name */
    public Handler f53836q;
    private RelativeLayout qPayDebitCardLayout;
    private String quickUserMobile = "";

    /* renamed from: r  reason: collision with root package name */
    public Runnable f53837r;
    /* access modifiers changed from: private */
    public RadioButton[] radioButtons;
    private boolean recurringFailed = false;
    private TextView remainingCreditAmount;
    private View remainingTalabatCreditView;
    private TextView removeVoucher;
    /* access modifiers changed from: private */
    public String requestedBinNumber;
    private TextView restaurantName;
    private TextView riderTipChargesText;
    private View riderTipChargesView;
    private RiderTipView riderTipView;

    /* renamed from: s  reason: collision with root package name */
    public String f53838s = "";
    /* access modifiers changed from: private */
    public boolean savedCardSelected = false;
    private View savingsView;
    private View scheduleLater;
    public int screenWidth;
    private SelectCardDialogAdapter selectCardDialogAdapter;
    /* access modifiers changed from: private */
    public CardInfo selectedCardInfo;
    /* access modifiers changed from: private */
    public String selectedCardName = "";
    private RelativeLayout selectedCardView;
    private DeliverySlotContent selectedDeliverySlot;
    /* access modifiers changed from: private */
    public TokenisationCreditCard selectedItem = null;
    /* access modifiers changed from: private */
    public RadioButton selectedPayfortCard;
    private int selectedPaymentMethod = -1;
    private ServiceFeeView serviceFeeView;
    private TextView showMorePaymentOptionsTextView;
    private SmallOrderFeeView smallOrderFeeView;
    private View softPOSView;
    private TextView subtotal;

    /* renamed from: t  reason: collision with root package name */
    public CurrentLocationFetchRefactor f53839t;
    private TextView talabatCreditBalance;
    private TextView talabatCreditTxt;
    private View talabatCreditView;
    private TextView talabatDeliveryVoucherAmount;
    private View talabatDeliveryVoucherView;
    private TextView talabtCreditTotalDisplay;
    /* access modifiers changed from: private */
    public String termsTitle;
    private String title;
    private ArrayList<TokenisationCreditCard> tokenisationCreditCards;
    private String transactionAmount = "";
    private String transactionId = "";

    /* renamed from: u  reason: collision with root package name */
    public ArrayList<String> f53840u;
    private ConstraintLayout unAvailableKNetMessageView;
    private RelativeLayout unAvailableKNetView;
    private ConstraintLayout unAvailableQPayMessageView;
    private RelativeLayout unAvailableQPayView;

    /* renamed from: v  reason: collision with root package name */
    public boolean f53841v = false;
    private boolean verificationPopupShown = false;
    private CheckoutButton visaCheckoutButton;
    /* access modifiers changed from: private */
    public View visaCheckoutExpandedView;
    private ImageView visaCheckoutIcon;
    private View visaCheckoutLayout;
    private RadioButton visaCheckoutRadio;
    private TextView visaCheckoutTxt;
    private ProgressBar visaIconProgress;
    private String visaIconUrl = "https://secure.checkout.visa.com/VmeCardArts/partner/POS_vertical_large_49x31_wht01.png";

    /* renamed from: w  reason: collision with root package name */
    public String f53842w = "";
    private boolean waitingForBinResponse = false;
    private AppCompatImageView warningImage;

    /* renamed from: x  reason: collision with root package name */
    public String f53843x = "";

    /* renamed from: y  reason: collision with root package name */
    public RadioButton f53844y;

    /* renamed from: z  reason: collision with root package name */
    public RadioButton f53845z;

    public class SavedCardRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private Set<String> benefitBins = new HashSet();
        private List<TokenisationCreditCard> cardList;
        private DebitCardBinInfoBottomSheetInterface listener;
        private Context mContext;
        private int preSelectionPosition;
        private TokenisationCreditCard preselector;
        private Set<String> qPayBins = new HashSet();

        public class CustomViewHolder extends RecyclerView.ViewHolder {

            /* renamed from: h  reason: collision with root package name */
            public FrameLayout f53918h;

            /* renamed from: i  reason: collision with root package name */
            public ConstraintLayout f53919i;

            /* renamed from: j  reason: collision with root package name */
            public RadioButton f53920j;

            /* renamed from: k  reason: collision with root package name */
            public ImageView f53921k;

            /* renamed from: l  reason: collision with root package name */
            public TextView f53922l;

            /* renamed from: m  reason: collision with root package name */
            public TextView f53923m;

            /* renamed from: n  reason: collision with root package name */
            public TextView f53924n;

            /* renamed from: o  reason: collision with root package name */
            public TextView f53925o;

            /* renamed from: p  reason: collision with root package name */
            public View f53926p;

            /* renamed from: q  reason: collision with root package name */
            public View f53927q;

            /* renamed from: r  reason: collision with root package name */
            public ImageView f53928r;

            public CustomViewHolder(View view) {
                super(view);
                this.f53918h = (FrameLayout) view.findViewById(R.id.convert_view);
                this.f53919i = (ConstraintLayout) view.findViewById(R.id.main_container);
                this.f53920j = (RadioButton) view.findViewById(R.id.card_selector);
                this.f53921k = (ImageView) view.findViewById(R.id.card_img);
                this.f53922l = (TextView) view.findViewById(R.id.card_no);
                this.f53923m = (TextView) view.findViewById(R.id.card_expiry_date);
                this.f53924n = (TextView) view.findViewById(R.id.expires_in_text);
                this.f53925o = (TextView) view.findViewById(R.id.bin_voucher_text);
                this.f53928r = (ImageView) view.findViewById(R.id.bin_discount_icon);
                this.f53926p = view.findViewById(R.id.benefit_info);
                this.f53927q = view.findViewById(R.id.qpay_info);
            }
        }

        public SavedCardRecyclerViewAdapter(Context context, List<TokenisationCreditCard> list, DebitCardBinInfoBottomSheetInterface debitCardBinInfoBottomSheetInterface) {
            this.mContext = context;
            this.cardList = list;
            CheckOutScreen.this.cardRadioButtons = new RadioButton[list.size()];
            this.listener = debitCardBinInfoBottomSheetInterface;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$0(View view) {
            openBenefitBinInfoBottomSheet(CheckOutScreen.this.checkoutPaymentUpdateViewModel.getBenefitBinDeflectionExpiryDate());
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$onBindViewHolder$1(View view) {
            openBenefitBinInfoBottomSheet(CheckOutScreen.this.checkoutPaymentUpdateViewModel.getQPayBinDeflectionExpiryDate());
        }

        /* access modifiers changed from: private */
        public void onCardSelected(TokenisationCreditCard tokenisationCreditCard) {
            float f11;
            String str;
            TokenisationCreditCard tokenisationCreditCard2 = tokenisationCreditCard;
            CheckOutScreen.this.selectedCardName = tokenisationCreditCard2.cardtype;
            Customer.getInstance().setSelectedCreditCard(tokenisationCreditCard2);
            CheckOutScreen checkOutScreen = CheckOutScreen.this;
            checkOutScreen.onPaymentSelected(checkOutScreen.selectedPayfortCard.getId());
            CheckOutScreen.this.savedCardSelected = true;
            CheckOutScreen.this.checkoutForceCVVVViewModel.onLoadCheckoutCVVPopUpStatus(tokenisationCreditCard2.binNumber, CheckOutScreen.this.cart.getCartTotalPrice(), false);
            if (!CheckOutScreen.this.isGemActive() && CheckOutScreen.this.I.config().isBinCampAvailable() && !CheckOutScreen.this.isDarkStore()) {
                if (!tokenisationCreditCard2.isBinDiscountValid || CheckOutScreen.this.cart.getRestaurant() == null) {
                    CheckOutScreen.this.removeBin();
                    return;
                }
                if (CheckOutScreen.this.cart.hasVoucherApplied()) {
                    str = CheckOutScreen.this.cart.getVoucherCode();
                    f11 = CheckOutScreen.this.cart.getVoucherDiscount();
                } else {
                    str = "";
                    f11 = 0.0f;
                }
                String mobileForBin = CheckOutScreen.this.getMobileForBin();
                CheckOutScreen.this.requestedBinNumber = tokenisationCreditCard2.binNumber;
                BinRequest binRequest = new BinRequest(CheckOutScreen.this.cart.getSubtotalForVoucher(), CheckOutScreen.this.cart.getRestaurant().getId(), CheckOutScreen.this.cart.getDeliveryChargeForVoucher(), CheckOutScreen.this.cart.isPromotionApplied(), CheckOutScreen.this.cart.isFreeItemAdded(), CheckOutScreen.this.cart.isCouponApplied(), mobileForBin, tokenisationCreditCard2.binNumber, str, f11, GlobalDataModel.SelectedAreaId, CheckOutScreen.this.cart.getRestaurant().getBranchId());
                CheckOutScreen.this.showNonCancelableProgress();
                CheckOutScreen.this.checkoutPresenter.checkForBinVoucher(binRequest);
            }
        }

        /* access modifiers changed from: private */
        public void onRadioButtonClicked(RadioButton radioButton) {
            for (RadioButton radioButton2 : CheckOutScreen.this.cardRadioButtons) {
                if (radioButton2 != null) {
                    if (radioButton2 == radioButton) {
                        radioButton2.setChecked(true);
                        CheckOutScreen checkOutScreen = CheckOutScreen.this;
                        checkOutScreen.adjustCheckedRadioButtons(checkOutScreen.radioButtons);
                    } else {
                        radioButton2.setChecked(false);
                    }
                }
            }
            CheckOutScreen.this.f53833n.setVisibility(0);
            CheckOutScreen.this.expandableLinearLayout.forceCollapse();
        }

        private void openBenefitBinInfoBottomSheet(String str) {
            DebitCardBinInfoBottomSheet debitCardBinInfoBottomSheet = new DebitCardBinInfoBottomSheet(str, this.listener);
            FragmentManager supportFragmentManager = CheckOutScreen.this.getSupportFragmentManager();
            supportFragmentManager.beginTransaction();
            debitCardBinInfoBottomSheet.show(supportFragmentManager, "");
        }

        /* access modifiers changed from: private */
        public void populateBenefitBins(Set<String> set) {
            this.benefitBins = set;
            notifyDataSetChanged();
        }

        public int getItemCount() {
            List<TokenisationCreditCard> list = this.cardList;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i11) {
            final CustomViewHolder customViewHolder = (CustomViewHolder) viewHolder;
            final TokenisationCreditCard tokenisationCreditCard = this.cardList.get(i11);
            CheckOutScreen.this.cardRadioButtons[i11] = customViewHolder.f53920j;
            if (tokenisationCreditCard.expiremonth > 0 && tokenisationCreditCard.expireyear > 0) {
                TextView textView = customViewHolder.f53923m;
                textView.setText("" + tokenisationCreditCard.expiremonth + "/" + tokenisationCreditCard.expireyear);
            }
            if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardnumber)) {
                customViewHolder.f53922l.setText(tokenisationCreditCard.cardnumber);
            }
            if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardtype)) {
                customViewHolder.f53921k.setImageResource(WalletCardType.Companion.getCardTypeFromCardName(tokenisationCreditCard.cardtype).getIconResource());
            }
            if (i11 == 0) {
                if (tokenisationCreditCard.isBinDiscountValid || !TalabatUtils.isNullOrEmpty(tokenisationCreditCard.message)) {
                    CheckOutScreen.this.preselected = true;
                }
                onRadioButtonClicked(customViewHolder.f53920j);
                onCardSelected(tokenisationCreditCard);
            }
            if ((tokenisationCreditCard.isBinDiscountValid || !TalabatUtils.isNullOrEmpty(tokenisationCreditCard.message)) && !CheckOutScreen.this.preselected) {
                onRadioButtonClicked(customViewHolder.f53920j);
                onCardSelected(tokenisationCreditCard);
                CheckOutScreen.this.preselected = true;
            }
            if (CheckOutScreen.this.preselected && CheckOutScreen.this.checkoutPresenter != null) {
                CheckOutScreen.this.checkoutPresenter.setDefaultPaymentMethodForGA(WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD);
            }
            if ((tokenisationCreditCard.isBinDiscountValid || !TalabatUtils.isNullOrEmpty(tokenisationCreditCard.message)) && !CheckOutScreen.this.isDarkStore()) {
                customViewHolder.f53928r.setVisibility(0);
                customViewHolder.f53925o.setVisibility(0);
                if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.message)) {
                    if (!CheckOutScreen.this.binMessageShown) {
                        CheckOutScreen.this.binMessageShown = true;
                        CheckOutScreen.this.closeBinOffers();
                    }
                    customViewHolder.f53925o.setText(tokenisationCreditCard.message);
                }
            } else {
                customViewHolder.f53928r.setVisibility(8);
                customViewHolder.f53925o.setVisibility(8);
            }
            customViewHolder.f53920j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CheckOutScreen.this.preselected = false;
                    SavedCardRecyclerViewAdapter.this.onRadioButtonClicked(customViewHolder.f53920j);
                    SavedCardRecyclerViewAdapter.this.onCardSelected(tokenisationCreditCard);
                }
            });
            customViewHolder.f53919i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CheckOutScreen.this.preselected = false;
                    customViewHolder.f53920j.performClick();
                }
            });
            customViewHolder.f53918h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CheckOutScreen.this.preselected = false;
                    customViewHolder.f53920j.performClick();
                }
            });
            if (this.benefitBins.contains(tokenisationCreditCard.binNumber)) {
                customViewHolder.f53926p.setVisibility(0);
            }
            if (this.qPayBins.contains(tokenisationCreditCard.binNumber)) {
                customViewHolder.f53927q.setVisibility(0);
            }
            customViewHolder.f53926p.setOnClickListener(new b5(this));
            customViewHolder.f53927q.setOnClickListener(new c5(this));
        }

        @NonNull
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_checkout_card_list_view, viewGroup, false));
        }

        public void populateQPayBins(Set<String> set) {
            this.qPayBins = set;
            notifyDataSetChanged();
        }

        public void updateList(ArrayList<TokenisationCreditCard> arrayList) {
            this.cardList = arrayList;
            notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public void addNewAddressFromCheckout(Address address) {
        String str;
        stopLodingPopup();
        if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
            address = null;
        } else if (!(McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress() == null || address == null)) {
            address = AddressesKt.merge(address, McdMapTempAddress.getInstance().getSelectedMcdLatLangTempAddress());
        }
        Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), "checkout");
        addressFormActivityIntent.putExtra("noAreaChange", true);
        addressFormActivityIntent.putExtra("isFromCheckout", true);
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
        addressFormActivityIntent.putExtra("map_compulsory", this.isMapcompulsory);
        addressFormActivityIntent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", true);
        addressFormActivityIntent.putExtra("isNewAddressFromCartOrderFlow", true);
        addressFormActivityIntent.putExtra("newaddressCreation", true);
        addressFormActivityIntent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        addressFormActivityIntent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
        addressFormActivityIntent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", true);
        addressFormActivityIntent.putExtra("isFromMcdAddressFlow", this.isGrlEnabled);
        addressFormActivityIntent.putExtra(GlobalConstants.INFOR_MAP.IS_FROM_MCD_NEW_ADDRESS_CHECKOUT, this.isGlrEnableAddNewAddress);
        if (this.isGrlEnabled) {
            addressFormActivityIntent.putExtra(GlobalConstants.ExtraNames.EDIT, false);
        }
        startActivityForResult(addressFormActivityIntent, 100);
    }

    /* access modifiers changed from: private */
    public void adjustCheckedRadioButtons(RadioButton[] radioButtonArr) {
        for (RadioButton checked : radioButtonArr) {
            checked.setChecked(false);
        }
    }

    private void animateOffersView(int i11, int i12, final View view) {
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

    private void applyBin(float f11, String str, float f12) {
        this.cart.setBinVoucherDiscount(f11, str, f12);
        setVoucherView();
        this.binApplied = true;
        this.isBinDiscountAppliedForTracking = true;
        updateAmountDisplay(Boolean.FALSE);
    }

    private void arrangeViewsForTproChecked() {
        this.checkoutPresenter.sendSubscriptionPlanClickedEvent();
        if (this.cash.isChecked()) {
            resetPaymentViews();
        }
        hideAvoidCashWarningView();
        setViewAlphas(Float.valueOf(0.5f));
        this.disabledCashExplanationView.setVisibility(0);
        this.warningImage.setVisibility(0);
        this.disabledCashExplanationText.setText(getString(R.string.pro_subscription_check_warning));
        this.freeTrialLayout.setVisibility(0);
    }

    private void arrangeViewsForTproUnchecked() {
        setViewAlphas(Float.valueOf(1.0f));
        this.disabledCashExplanationView.setVisibility(8);
        this.freeTrialLayout.setVisibility(8);
    }

    private void bindFreeDeliveryTypeVoucher() {
        int i11;
        if (this.checkoutPresenter.isFreeDeliveryTypeVoucherApplied()) {
            this.discountVoucherView.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(8);
            this.talabatDeliveryVoucherView.setVisibility(8);
            this.freeDeliveryTypeVoucherLayout.setVisibility(0);
            if (this.checkoutPresenter.isFreeDeliveryDiscountFull()) {
                i11 = R.string.free_delivery_type_voucher_free;
            } else {
                i11 = R.string.free_delivery_type_voucher_discount;
            }
            this.freeDeliveryTypeVoucherText.setText(i11);
            this.freeDeliverTypeVoucherAmount.setText(this.checkoutPresenter.getFreeDeliveryDiscountAmount());
        }
    }

    private void bindLoyaltyVoucherView() {
        if (this.checkoutPresenter.isLoyaltyVoucher()) {
            this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            this.talabatDeliveryVoucherView.setVisibility(8);
            this.checkoutPresenter.recalculateAppliedVoucher();
            if (this.cart.isVoucherRedeemedInCheckout()) {
                this.combinedDiscountLayout.setVisibility(8);
                this.discountVoucherView.setVisibility(0);
                this.removeVoucher.setVisibility(8);
                this.discountVoucherTxt.setText(this.checkoutPresenter.getLoyaltyVoucherText());
                this.discountVoucherAmount.setText(this.checkoutPresenter.getLoyaltyDiscount());
                return;
            }
            this.discountVoucherView.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(0);
            this.combinedDiscountText.setText(getString(R.string.dicount_voucher));
            this.combinedDiscountValue.setText(this.checkoutPresenter.getLoyaltyDiscount());
        }
    }

    private void bindNormalVoucherView() {
        if (this.checkoutPresenter.isNormalVoucher()) {
            this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            this.talabatDeliveryVoucherView.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(8);
            this.discountVoucherTxt.setText(getString(R.string.dicount_voucher));
            this.discountVoucherView.setVisibility(0);
            this.removeVoucher.setVisibility(0);
            this.discountVoucherAmount.setText(this.checkoutPresenter.getVoucherAmount());
        }
    }

    private void bindPickupTotalDiscount() {
        if (this.checkoutPresenter.isPickup()) {
            this.combinedDiscountText.setText(R.string.total_pickup_discount);
        }
    }

    private void bindTalabatFreeDeliveryVoucher() {
        if (this.checkoutPresenter.isTalabatDeliveryVoucher()) {
            this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            this.discountVoucherView.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(8);
            this.talabatDeliveryVoucherView.setVisibility(0);
            this.talabatDeliveryVoucherAmount.setText(this.checkoutPresenter.getVoucherAmount());
        }
    }

    private void bindZeroVoucherView() {
        if (this.checkoutPresenter.isZeroVoucher()) {
            this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            this.talabatDeliveryVoucherView.setVisibility(8);
            if (this.cart.isVoucherRedeemedInCheckout()) {
                this.combinedDiscountLayout.setVisibility(8);
                this.discountVoucherTxt.setText(getString(R.string.zero_per_voucher_label));
                this.discountVoucherView.setVisibility(0);
                this.removeVoucher.setVisibility(8);
                this.discountVoucherAmount.setText(this.checkoutPresenter.getVoucherAmount());
                return;
            }
            this.discountVoucherView.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(0);
            this.combinedDiscountText.setText(getString(R.string.zero_per_voucher_label));
            this.combinedDiscountValue.setText(this.checkoutPresenter.getVoucherAmount());
        }
    }

    private void callParallelBinApi(boolean z11) {
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (iCheckoutPresenter != null) {
            iCheckoutPresenter.getParallelBinData(z11);
        }
    }

    private void clearCartInCaseOfQCommerceVendors() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return;
        }
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            Cart.getInstance().clearCartFromDarkstores(this);
        }
    }

    /* access modifiers changed from: private */
    public void clearSelectedRadioButtons() {
        for (RadioButton checked : this.radioButtons) {
            checked.setChecked(false);
        }
    }

    /* access modifiers changed from: private */
    public void closeBinOffers() {
        animateOffersView(0, -this.binOffersView.getHeight(), this.binOffersView);
        this.binOffersView.setVisibility(8);
    }

    private void displayBenefitDeflectionViews(CheckoutPaymentUpdateDisplayModel checkoutPaymentUpdateDisplayModel) {
        this.paymentLayoutView.setVisibility(0);
        this.checkoutPresenter.hideProgress();
        SavedCardRecyclerViewAdapter savedCardRecyclerViewAdapter = this.mAdapter;
        if (savedCardRecyclerViewAdapter != null) {
            savedCardRecyclerViewAdapter.updateList(Customer.getInstance().getSavedCards());
            this.mAdapter.populateBenefitBins(((CheckoutPaymentUpdateDisplayModel.ShowBenefitBinsInfo) checkoutPaymentUpdateDisplayModel).getBins());
        }
        this.checkoutPaymentUpdateViewModel.setBenefitBinDeflectionExpiryDate(((CheckoutPaymentUpdateDisplayModel.ShowBenefitBinsInfo) checkoutPaymentUpdateDisplayModel).getBenefitCardDeflectionExpiryDate());
    }

    private void displayQPayDeflectionViews(CheckoutPaymentUpdateDisplayModel checkoutPaymentUpdateDisplayModel) {
        this.paymentLayoutView.setVisibility(0);
        this.checkoutPresenter.hideProgress();
        SavedCardRecyclerViewAdapter savedCardRecyclerViewAdapter = this.mAdapter;
        if (savedCardRecyclerViewAdapter != null) {
            savedCardRecyclerViewAdapter.updateList(Customer.getInstance().getSavedCards());
            this.mAdapter.populateQPayBins(((CheckoutPaymentUpdateDisplayModel.ShowQPayBinsInfo) checkoutPaymentUpdateDisplayModel).getBins());
        }
        this.checkoutPaymentUpdateViewModel.setQPayBinDeflectionExpiryDate(((CheckoutPaymentUpdateDisplayModel.ShowQPayBinsInfo) checkoutPaymentUpdateDisplayModel).getQPayCardDeflectionExpiryDate());
    }

    private Bundle getBundleWithCommonValues(String str, String str2, Boolean bool, Boolean bool2, String str3) {
        Bundle bundle = new Bundle();
        bundle.putString("transId", str);
        bundle.putString("encryptedOrderId", str2);
        bundle.putBoolean("isPostDated", bool.booleanValue());
        bundle.putBoolean("isOrderSuccess", bool2.booleanValue());
        bundle.putString("customerName", str3);
        return bundle;
    }

    private String getDeliveryTimeLabel() {
        if (this.cart.getRestaurant() == null) {
            return getResources().getText(R.string.daily_entry_order_now).toString();
        }
        if (isDarkStore()) {
            return this.cart.getRestaurant().getDeliveryTime();
        }
        return getResources().getString(R.string.within) + " " + this.cart.getRestaurant().getDeliveryTime();
    }

    private String getImageUrl() {
        String replaceAll = GlobalDataModel.PARALLELBIN.commonIconUrl.replaceAll(" ", "%20");
        return GlobalDataModel.imageBaseUrl + "VoucherCampaign/" + replaceAll;
    }

    @LayoutRes
    private int getPostDateDeliveryLayoutResource() {
        if (this.checkoutPresenter.isDarkstoresScheduledDeliveryEnabled()) {
            return R.layout.checkout_darkstores_post_date_delivery_card;
        }
        if (this.checkoutPresenter.isDesignSystemSimpleCard()) {
            return R.layout.checkout_post_date_delivery_card_ds;
        }
        return R.layout.checkout_post_date_delivery_card;
    }

    private String getPostOrderText() {
        if (this.checkoutPresenter.isPickup()) {
            return getResources().getString(R.string.place_pickup_order);
        }
        return getResources().getString(R.string.place_your_order);
    }

    @Nullable
    private FeeValue getPreCalculatedServiceFeeForDarkstore() {
        if (Cart.getInstance().getServiceFee() == 0.0f) {
            return null;
        }
        return new FeeValue(getString(R.string.service_fee_label), (double) Cart.getInstance().getServiceFee(), TalabatFormatter.getInstance().getFormattedCurrency(Cart.getInstance().getServiceFee()), (String) null, (String) null);
    }

    private QuickOrderInfo getSavedQuickOrderAddressData() {
        Object obj;
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!sharedPreferences.contains("" + GlobalDataModel.SelectedAreaId)) {
            return null;
        }
        try {
            String string = sharedPreferences.getString("" + GlobalDataModel.SelectedAreaId, "");
            Class cls = QuickOrderInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            return (QuickOrderInfo) obj;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private SpannableStringBuilder getSpannableAddress() {
        Restaurant restaurant = this.cart.getRestaurant();
        String str = restaurant.f13873name + " " + this.cart.getPickupDistanceKm();
        SpannableStringBuilder valueOf = SpannableStringBuilder.valueOf("");
        valueOf.append(str);
        valueOf.setSpan(new ForegroundColorSpan(getColor(R.color.ds_neutral_55)), str.indexOf(this.cart.getPickupDistanceKm()), str.length(), 33);
        return valueOf;
    }

    private TalabatTracker getTalabatTracker() {
        return ((TrackingCoreLibApi) AndroidComponentsKt.apiContainer((Activity) this).getFeature(TrackingCoreLibApi.class)).getTalabatTracker();
    }

    private void goToTermsAndConditions(String str) {
        Intent intent = new Intent(this, TWebViewScreen.class);
        intent.putExtra("url", str);
        intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, getString(R.string.tpro_terms_and_conditions));
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void handleBnplPaymentFallbackEligibileState(BNPLPaymentFallbackEligibleStatus bNPLPaymentFallbackEligibleStatus) {
        if (bNPLPaymentFallbackEligibleStatus instanceof BNPLPaymentFallbackEligibleStatus.IsEligibleForBnplPaymentFallback) {
            showBNPLView(Boolean.FALSE, Boolean.TRUE);
            this.bnplManagerViewModel.onBnplFallbackOptionShown();
        }
    }

    /* access modifiers changed from: private */
    public void handleDeliveryFee(FeeValue feeValue) {
        this.deliveryFeeCache = feeValue;
        stopNonCancelableLoading();
        if (feeValue != null) {
            this.checkoutPresenter.handleDeliveryFee(feeValue.getValue());
            showDeliveryFee(feeValue);
            bindFreeDeliveryTypeVoucher();
        }
    }

    /* access modifiers changed from: private */
    public void handlePaymenError(Intent intent) {
        if (intent != null && intent.hasExtra(PaymentErrorScreen.ERROR_REASON_MESSAGE_EXTRA)) {
            String stringExtra = intent.getStringExtra(PaymentErrorScreen.ERROR_REASON_MESSAGE_EXTRA);
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.checkoutPresenter.sendTransactionFailedEvent(stringExtra);
        }
        this.bnplManagerViewModel.onPlaceOrderFailedWithPaymentMethodError(this.checkoutPresenter.getSelectedPayementMethod());
    }

    /* access modifiers changed from: private */
    public void handleServiceFee(FeeValue feeValue) {
        float f11;
        String str;
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (feeValue == null) {
            f11 = 0.0f;
        } else {
            f11 = (float) feeValue.getValue();
        }
        iCheckoutPresenter.handleServiceFee(f11);
        String str2 = null;
        if (feeValue == null) {
            str = null;
        } else {
            str = feeValue.getLabel();
        }
        if (feeValue != null) {
            str2 = feeValue.getFormattedValue();
        }
        this.serviceFeeView.showServiceFee(str, str2);
    }

    /* access modifiers changed from: private */
    public void handleSmallOrderFee(FeeValue feeValue) {
        float f11;
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (feeValue == null) {
            f11 = 0.0f;
        } else {
            f11 = (float) feeValue.getValue();
        }
        iCheckoutPresenter.handleSmallOrderFee(f11);
        this.smallOrderFeeView.showSmallOrderFee(feeValue);
    }

    private void hideAllPaymentOptionsExceptDefault(boolean z11) {
        if (z11 || BuildConfig.IS_ALPHA.booleanValue()) {
            Restaurant restaurant = this.cart.getRestaurant();
            if (Customer.getInstance().isLoggedIn(getContext()) && restaurant != null && restaurant.acceptsCredit && Customer.getInstance().getSavedCards() != null) {
                ArrayList<TokenisationCreditCard> savedCards = Customer.getInstance().getSavedCards();
                if (savedCards.size() > 0) {
                    this.defaultPaymentOption.setVisibility(0);
                    this.paymentOptionsContainer.setVisibility(8);
                    setDefaultPaymentOption(savedCards.get(0));
                }
            }
        }
    }

    private void hideAvoidCashWarningView() {
        if (this.avoidCashWarningView.getVisibility() == 0) {
            this.avoidCashWarningView.setVisibility(8);
        }
    }

    private void hideContactlessFeature() {
        GlobalDataModel.CONTACTLESS.contactlessEnabled = false;
        this.contactlessFeatureView.setVisibility(8);
        this.contactLessSelector.setChecked(false);
    }

    private void hideOrderNowForGroceryScheduledDelivery() {
        View view = this.postDateDelivery;
        if (view instanceof CheckoutOrderTimeSelectorView) {
            ((CheckoutOrderTimeSelectorView) view).hideOrderNowOption();
        }
    }

    private void hideSoftPosView() {
        if (this.softPOSView.getVisibility() == 0) {
            this.softPOSView.setVisibility(8);
        }
    }

    private boolean isCardExpired(int i11, int i12) {
        Calendar instance = Calendar.getInstance();
        int i13 = instance.get(2) + 1;
        String valueOf = String.valueOf(instance.get(1));
        if (Integer.valueOf(valueOf.substring(2).replace("/", "")).intValue() > i12) {
            return true;
        }
        if (Integer.valueOf(valueOf.substring(2).replace("/", "")).intValue() != i12 || i13 <= i11) {
            return false;
        }
        return true;
    }

    private boolean isCashbackEnabledCountry() {
        List<Country> countries = this.G.countries();
        int countryId = this.E.selectedCountry().getCountryId();
        for (Country next : countries) {
            if (countryId == next.getCountry().getCountryId()) {
                return next.isTalabatPayEnabled();
            }
        }
        return false;
    }

    private void isChageAddressButtonLabel() {
        if (this.isGrlEnabled) {
            this.changeAddress.setVisibility(8);
        } else {
            this.changeAddress.setVisibility(0);
        }
    }

    private boolean isContactlessEnabledCountry() {
        boolean z11;
        boolean z12;
        if (this.cart.getRestaurant() != null) {
            z11 = this.cart.getRestaurant().isSafeDropOff();
        } else {
            z11 = false;
        }
        List<Country> countries = this.G.countries();
        int countryId = this.E.selectedCountry().getCountryId();
        Iterator<Country> it = countries.iterator();
        while (true) {
            if (!it.hasNext()) {
                z12 = false;
                break;
            }
            Country next = it.next();
            if (countryId == next.getCountry().getCountryId()) {
                z12 = next.isContactlessPaymentEnabled();
                break;
            }
        }
        if (!z12 || !z11) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean isDarkStore() {
        Restaurant restaurant = this.cart.getRestaurant();
        if (restaurant == null) {
            return false;
        }
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            return true;
        }
        return false;
    }

    private boolean isPreOrderForRamadan() {
        if (this.cart.getRestaurant() == null || this.cart.getRestaurant().statusType != 5) {
            return false;
        }
        return true;
    }

    private boolean isSoftPosEnabledRestaurant() {
        if (this.cart.getRestaurant() == null || !this.L.getFeatureFlag(TalabatFeatureFlagConstants.ENABLE_SOFT_POS, false)) {
            return false;
        }
        return this.cart.getRestaurant().isSoftPosSupported;
    }

    private boolean isTalabatCreditAvaialable() {
        boolean z11;
        Restaurant restaurant = this.cart.getRestaurant();
        if (restaurant == null) {
            return false;
        }
        datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.E, this.G);
        if (selectedCountry != null) {
            z11 = selectedCountry.enableTalabtCredit;
        } else {
            z11 = false;
        }
        if (!z11 || !Customer.getInstance().isLoggedIn(getContext())) {
            return false;
        }
        if ((restaurant.isAcceptsCredit() || restaurant.isAcceptsDebit()) && Customer.getInstance().getCustomerInfo() != null && Customer.getInstance().getCustomerInfo().talabatCredit > 0.0f) {
            return true;
        }
        return false;
    }

    private boolean isVisaCheckoutEnabled() {
        if (this.cart.getRestaurant() == null || TalabatUtils.getSelectedCountry(this.E, this.G) == null || !this.cart.getRestaurant().isAcceptsCredit() || !TalabatUtils.getSelectedCountry(this.E, this.G).isVisaCheckoutAvailable || GlobalDataModel.SelectedCountryId != com.talabat.configuration.country.Country.UAE.getCountryId() || !isVisaSDKSupportedVersion()) {
            return false;
        }
        return true;
    }

    private boolean isVisaSDKSupportedVersion() {
        return true;
    }

    private void killCart() {
        Cart.getInstance().setRiderTip(0.0d);
        S1();
        sendBroadcast(new Intent(GlobalConstants.BROADCAST_KILL_CART));
    }

    private void killMenuScreen() {
        sendBroadcast(new Intent(GlobalConstants.BROADCAST_KILL_MENU));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$hideTProSubscriptionBanner$42(Map map, Boolean bool, TProOrderStatus tProOrderStatus) {
        map.clear();
        map.put("PreCartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
        updateAmountDisplay(bool);
        try {
            map.put("isChecked", String.valueOf(bool));
            map.put("PostCartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
            map.put("CartDeliveryCharges", String.valueOf(Cart.getInstance().getDeliveryCharges()));
            map.put("UserId", String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
            this.K.track("TickSubscriptionAtCheckout_hideTProSubscriptionBanner", "tpro", map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$hideTProSubscriptionBanner$43(Map map, Boolean bool) {
        try {
            map.put("PostCartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
            map.put("CartDeliveryCharges", String.valueOf(Cart.getInstance().getDeliveryCharges()));
            map.put("UserId", String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
            this.K.track("SubscribeAtCheckoutShown", "tpro", map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        this.cash.setEnabled(!bool.booleanValue());
        this.debitCard.setEnabled(!bool.booleanValue());
        this.f53844y.setEnabled(!bool.booleanValue());
        this.f53845z.setEnabled(!bool.booleanValue());
        this.A.setEnabled(!bool.booleanValue());
        this.B.setEnabled(!bool.booleanValue());
        this.bNPLRadioButton.setEnabled(!bool.booleanValue());
        this.cashLayout.setEnabled(!bool.booleanValue());
        this.debitLayout.setEnabled(!bool.booleanValue());
        this.newTalabatCreditView.setEnabled(!bool.booleanValue());
        this.checkoutdotLayout.setEnabled(!bool.booleanValue());
        this.kNetDebitCardLayout.setEnabled(!bool.booleanValue());
        this.qPayDebitCardLayout.setEnabled(!bool.booleanValue());
        this.bNPLLayoutView.setEnabled(!bool.booleanValue());
        if (bool.booleanValue()) {
            this.freeTrialInfoText.setText(this.C.getFreeTrialText());
            arrangeViewsForTproChecked();
        } else {
            arrangeViewsForTproUnchecked();
        }
        this.checkoutPresenter.getTProOrderStatus(new l2(this, map, bool), bool.booleanValue(), false);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$hideTProSubscriptionBanner$44(String str) {
        openTermsAndConditions(str);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        onPaymentMethodChosen(this.cash);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(RadioButton radioButton, View view) {
        onPaymentMethodChosen(radioButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$10(View view) {
        prepareUIViewsForBNPL();
        Boolean bool = Boolean.FALSE;
        showBNPLView(bool, bool);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$11(View view) {
        resetVisaCheckoutInstance();
        this.cart.removeBinDiscountIfApplied();
        this.cart.setVoucherRedeemedinCheckout(false);
        clearCartInCaseOfQCommerceVendors();
        if (!this.f53830k || !this.isQuick) {
            finish();
            return;
        }
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$12(View view) {
        this.cash.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$13(View view) {
        this.debitCard.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$15(View view) {
        this.f53844y.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$16(View view) {
        this.f53845z.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$17(View view) {
        this.visaCheckoutRadio.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$19(View view) {
        this.bNPLRadioButton.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$2(View view) {
        onRadioButtonClicked(this.debitCard);
        onPaymentSelected(this.debitCard.getId());
        this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$20(View view) {
        this.A.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$21(View view) {
        this.B.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$22(View view) {
        if (this.visaCheckoutRadio.isChecked()) {
            this.f53833n.setVisibility(8);
            this.expandableLinearLayout.expand(300, Utils.createInterpolator(0));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$23(View view) {
        if (!isPickUp()) {
            proceedWithPlaceOrder();
        } else if (isForceCvvDialogShown()) {
            proceedWithPlaceOrder();
        } else {
            Q1();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$3(View view) {
        onPaymentMethodChosen(this.f53844y);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$4(View view) {
        onPaymentMethodChosen(this.selectedPayfortCard);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$5(View view) {
        onPaymentMethodChosen(this.f53845z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$6(View view) {
        onPaymentMethodChosen(this.A);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$7(View view) {
        onPaymentMethodChosen(this.B);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$8(View view) {
        onPaymentMethodChosen(this.visaCheckoutRadio);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$9(RadioButton radioButton, View view) {
        this.paymentTerms.setVisibility(8);
        onPaymentMethodChosen(radioButton);
        openBNPLTrackingBottomSheet();
        this.f53833n.setEnabled(false);
        this.f53833n.setText(getResources().getString(R.string.coming_soon));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x004d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void lambda$onDuplicateOrder$47(android.widget.RadioButton r9, android.widget.RadioButton r10, java.lang.String r11, android.widget.RadioButton r12, android.view.View r13) {
        /*
            r8 = this;
            java.lang.String r13 = "continue_order"
            boolean r9 = r9.isChecked()
            if (r9 == 0) goto L_0x000e
            android.app.Dialog r9 = r8.duplicateOrderDialog
            r9.dismiss()
            goto L_0x006b
        L_0x000e:
            boolean r9 = r10.isChecked()
            if (r9 == 0) goto L_0x0023
            r8.startLodingPopup()
            java.lang.String r9 = "view_order"
            tracking.AppTracker.onDuplicateOrderPopupConfirmClicked(r8, r9)
            library.talabat.mvp.checkout.ICheckoutPresenter r9 = r8.checkoutPresenter
            r9.showOrderDetails(r11)
            goto L_0x006b
        L_0x0023:
            boolean r9 = r12.isChecked()
            if (r9 == 0) goto L_0x006b
            r9 = 1
            com.talabat.helpers.GlobalConstants.isDuplicateOrder = r9     // Catch:{ Exception -> 0x004d }
            java.lang.String r9 = "[ALOV] before prepareForPlacingOrder #1"
            com.talabat.talabatcore.logger.LogManager.debug(r9)     // Catch:{ Exception -> 0x004d }
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r8.checkoutPresenter     // Catch:{ Exception -> 0x004d }
            r1 = 0
            r2 = 1
            boolean r3 = r8.isQuick     // Catch:{ Exception -> 0x004d }
            java.lang.String r4 = r8.getFirstName()     // Catch:{ Exception -> 0x004d }
            java.lang.String r5 = r8.getLastName()     // Catch:{ Exception -> 0x004d }
            java.lang.String r6 = ""
            library.talabat.mvp.checkout.ICheckoutPresenter r9 = r8.checkoutPresenter     // Catch:{ Exception -> 0x004d }
            boolean r7 = r9.getHideAddCardStatus()     // Catch:{ Exception -> 0x004d }
            r0.prepareForPlacingOrder(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x004d }
            goto L_0x0059
        L_0x004b:
            r9 = move-exception
            goto L_0x0062
        L_0x004d:
            com.talabat.core.observabilityNew.domain.IObservabilityManager r9 = r8.K     // Catch:{ all -> 0x004b }
            java.lang.String r10 = "prepareForPlacingOrder failed"
            java.util.HashMap r11 = new java.util.HashMap     // Catch:{ all -> 0x004b }
            r11.<init>()     // Catch:{ all -> 0x004b }
            r9.trackUnExpectedScenario(r10, r11)     // Catch:{ all -> 0x004b }
        L_0x0059:
            tracking.AppTracker.onDuplicateOrderPopupConfirmClicked(r8, r13)
            android.app.Dialog r9 = r8.duplicateOrderDialog
            r9.dismiss()
            goto L_0x006b
        L_0x0062:
            tracking.AppTracker.onDuplicateOrderPopupConfirmClicked(r8, r13)
            android.app.Dialog r10 = r8.duplicateOrderDialog
            r10.dismiss()
            throw r9
        L_0x006b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.CheckOutScreen.lambda$onDuplicateOrder$47(android.widget.RadioButton, android.widget.RadioButton, java.lang.String, android.widget.RadioButton, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onFeesMismatchError$28(View view) {
        this.f53825a0.onContinueOrderClicked(getScreenName());
        updateFeesValues();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onParallelBinAvailable$48(View view) {
        new ParallelBinDialog().show(getSupportFragmentManager(), "Parallel Bin Dialog");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onUserTypeErrorForDiscount$53(DialogInterface dialogInterface, int i11) {
        updateAmountDisplay(Boolean.FALSE);
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$proceedWithPickupPlaceOrder$34(Restaurant restaurant, String str, Boolean bool) {
        getTalabatTracker().track(new PopupClicked(restaurant, str, bool.booleanValue()));
        if (!bool.booleanValue()) {
            return null;
        }
        proceedWithPlaceOrder();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setFeesDescriptions$24(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        this.f53825a0.onDeliveryFeeInfoClicked(getScreenName());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setFeesDescriptions$25(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        this.f53825a0.onGeneralFeesInfoClicked(getScreenName());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setFeesDescriptions$26(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        this.f53825a0.onServiceFeeInfoClicked(getScreenName());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setFeesDescriptions$27(View.OnClickListener onClickListener, View view) {
        onClickListener.onClick(view);
        this.f53825a0.onSmallOrderFeeInfoClicked(getScreenName());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setPaymentView$45(Boolean bool) {
        if (!bool.booleanValue()) {
            this.cashLayout.setVisibility(8);
            return null;
        }
        this.cashLayout.setVisibility(0);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setPaymentView$46(TProOrderStatus tProOrderStatus) {
        updateDeliveryFeeVisibility(this.checkoutPresenter.isPickup(), tProOrderStatus.isFreeDelivery());
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setScheduleLaterOnClickListener$29(View view) {
        onDarkstoreScheduleLaterClicked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setScheduleLaterOnClickListener$30(View view) {
        onOrderNowClicked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setScheduleLaterOnClickListener$31(View view) {
        onScheduleLaterClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setScheduleLaterVisibility$32() {
        onScheduleLaterClick();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setVisibilityOfSubscriptionOnCheckoutBanner$37(Map map, Boolean bool, TProOrderStatus tProOrderStatus) {
        map.clear();
        map.put("PreCartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
        updateAmountDisplay(bool);
        try {
            map.put("isChecked", String.valueOf(bool));
            map.put("PostCartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
            map.put("CartDeliveryCharges", String.valueOf(Cart.getInstance().getDeliveryCharges()));
            map.put("UserId", String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
            this.K.track("TickSubscriptionAtCheckout_setVisibilityOfSubscriptionOnCheckoutBanner", "tpro", map);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setVisibilityOfSubscriptionOnCheckoutBanner$38(Map map, Boolean bool) {
        this.cash.setEnabled(!bool.booleanValue());
        this.debitCard.setEnabled(!bool.booleanValue());
        this.f53844y.setEnabled(!bool.booleanValue());
        this.f53845z.setEnabled(!bool.booleanValue());
        this.A.setEnabled(!bool.booleanValue());
        this.B.setEnabled(!bool.booleanValue());
        this.bNPLRadioButton.setEnabled(!bool.booleanValue());
        this.cashLayout.setEnabled(!bool.booleanValue());
        this.debitLayout.setEnabled(!bool.booleanValue());
        this.newTalabatCreditView.setEnabled(!bool.booleanValue());
        this.checkoutdotLayout.setEnabled(!bool.booleanValue());
        this.kNetDebitCardLayout.setEnabled(!bool.booleanValue());
        this.qPayDebitCardLayout.setEnabled(!bool.booleanValue());
        this.bNPLLayoutView.setEnabled(!bool.booleanValue());
        if (bool.booleanValue()) {
            this.freeTrialInfoText.setText(this.C.getFreeTrialText());
            arrangeViewsForTproChecked();
        } else {
            arrangeViewsForTproUnchecked();
        }
        this.checkoutPresenter.getTProOrderStatus(new i2(this, map, bool), bool.booleanValue(), false);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setVisibilityOfSubscriptionOnCheckoutBanner$39(String str) {
        openTermsAndConditions(str);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setVisibilityOfSubscriptionOnCheckoutBanner$40(Boolean bool) {
        boolean shouldShowSubscriptionBanner = this.C.shouldShowSubscriptionBanner(bool.booleanValue());
        HashMap hashMap = new HashMap();
        if (shouldShowSubscriptionBanner) {
            try {
                hashMap.put("PostCartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
                hashMap.put("CartDeliveryCharges", String.valueOf(Cart.getInstance().getDeliveryCharges()));
                hashMap.put("UserId", String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
                this.K.track("SubscribeAtCheckoutShown", "tpro", hashMap);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            this.C.setVisibility(0);
            this.C.showSubscriptionAtCheckoutBannerView();
            this.C.setOnCheckedChangeListenerForCheckout(new p2(this, hashMap));
            this.C.setTermsAndConditionsClick(new q2(this));
        } else {
            this.C.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setVoucherView$50(View view) {
        GrowthTracker.INSTANCE.onVoucherRemoved(Cart.getInstance().getVoucherCode(), Cart.getInstance().getVoucherDiscount(), VoucherOptionType.MARKETING.name());
        this.checkoutPresenter.removeVoucher();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showBottomSheetForDeliveryTiming$54(DeliverySlotContent deliverySlotContent) {
        this.checkoutPresenter.sendScheduledDeliveryConfirmedEvent(deliverySlotContent.getDisplayTime());
        this.selectedDeliverySlot = deliverySlotContent;
        ((CheckoutOrderTimeSelectorView) this.postDateDelivery).updateSelectedDeliverySlot(deliverySlotContent);
        this.checkoutPresenter.onDeliverySlotClicked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showBusyPopup$49(DialogInterface dialogInterface, int i11) {
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (iCheckoutPresenter != null) {
            iCheckoutPresenter.tryMoreRestaurantsClicked();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showCVVPopup$51(View view) {
        this.forceCvvDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showCVVPopup$52(boolean z11, View view) {
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (iCheckoutPresenter != null) {
            iCheckoutPresenter.setCvv(this.editTextCvv.getText().toString(), z11);
            startLodingPopup();
        }
        if (!z11) {
            makePaymentForPlaceOrder();
        }
        this.forceCvvDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showContactlessFeatureIfAvailable$35(View view) {
        this.contactLessSelector.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showContactlessFeatureIfAvailable$36(CompoundButton compoundButton, boolean z11) {
        if (this.contactLessSelector.isChecked()) {
            GlobalDataModel.CONTACTLESS.contactlessEnabled = true;
            if (this.cash.isChecked()) {
                resetPaymentViews();
            }
            hideAvoidCashWarningView();
            this.cash.setEnabled(false);
            this.cash.setAlpha(0.5f);
            this.cashLayout.setEnabled(false);
            this.cashLayout.setAlpha(0.5f);
            this.disabledCashExplanationView.setVisibility(0);
            return;
        }
        GlobalDataModel.CONTACTLESS.contactlessEnabled = false;
        this.cash.setEnabled(true);
        this.cash.setAlpha(1.0f);
        this.cashLayout.setEnabled(true);
        this.cashLayout.setAlpha(1.0f);
        this.disabledCashExplanationView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$showSubscriptionErrorDialog$41(Boolean bool) {
        finish();
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$updateBNPLPopView$33(DialogInterface dialogInterface) {
        clearSelectedRadioButtons();
        SavedCardRecyclerViewAdapter savedCardRecyclerViewAdapter = this.mAdapter;
        if (savedCardRecyclerViewAdapter != null) {
            savedCardRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    private void loadDeliveryAddressMap(final LatLng latLng) {
        MapContainerFragment mapContainerFragment = (MapContainerFragment) getSupportFragmentManager().findFragmentById(R.id.delivery_address_map);
        mapContainerFragment.init((ViewGroup) null);
        mapContainerFragment.getMapAsync(new OnMapReadyCallback() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onMapReady$0(LatLng latLng) {
                if (CheckOutScreen.this.deliveryAddressView != null) {
                    CheckOutScreen.this.deliveryAddressView.performClick();
                }
            }

            public void onMapReady(FrameworkMap frameworkMap) {
                frameworkMap.getUiSettings().setScrollGesturesEnabled(false);
                frameworkMap.getUiSettings().setAllGesturesEnabled(false);
                frameworkMap.moveCamera(CheckOutScreen.this.U.newLatLngZoom(latLng, frameworkMap.getMaxZoomLevel() - 6.0f));
                frameworkMap.setOnMapClickListener(new a(this));
            }
        });
    }

    private void loadVisaCheckoutIcon(String str) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = this.visaIconUrl;
        }
        String str2 = str;
        this.visaIconUrl = str2;
        ImageDownloadHelper.Companion.downloadUsingGlide(this, str2, this.visaCheckoutIcon, (RequestOptions) null, ContextCompat.getDrawable(this, R.drawable.checkout_visa_icon));
        this.visaIconProgress.setVisibility(8);
    }

    private void observeFeesDescriptions() {
        this.f53825a0.getFeesDescriptions().observe(this, new j2(this));
    }

    private void observeFeesValues() {
        this.f53825a0.getServiceFeeValue().observe(this, new o4(this));
        this.f53825a0.getSmallOrderFeeValue().observe(this, new p4(this));
        this.f53825a0.getDeliveryFeeValue().observe(this, new q4(this));
        triggerFeesUpdate();
    }

    private void onDarkstoreScheduleLaterClicked() {
        this.checkoutPresenter.sendScheduledDeliveryClickedEvent();
        if (this.checkoutPresenter.isDarkstoreDeliverySlotsRequestInProgress()) {
            startLodingPopup();
            this.deferDarkstoreScheduleLaterClick = true;
        } else if (this.deliverySlots != null) {
            showBottomSheetForDeliveryTiming();
        } else {
            startLodingPopup();
            this.checkoutPresenter.fetchDarkstoreDeliverySlots();
        }
    }

    private void onOrderNowClicked() {
        this.checkoutPresenter.onOrderNowClicked();
    }

    private void onPaymentMethodUpdated() {
        this.checkoutPaymentUpdateViewModel.onPaymentMethodUpdated(this.cart, this.checkoutPresenter.getDefaultPaymentMethod(), Customer.getInstance().getSavedCards(), new BNPLEligibilityRequestDto(GlobalDataModel.SelectedCountryId, Float.valueOf(this.cart.getCartTotalPaymentPrice()), Integer.valueOf(this.cart.getRestaurant().shopType), Integer.valueOf(DeliveryProvider.Companion.getDeliveryProvider(this.cart.getRestaurant().isTalabatGo).getProvider())));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0235  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onPaymentSelected(int r17) {
        /*
            r16 = this;
            r1 = r16
            r2 = r17
            r0 = 2132020082(0x7f140b72, float:1.9678517E38)
            java.lang.String r3 = r1.getString(r0)
            com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository r0 = r1.P
            com.talabat.configuration.tcs.TermsAndConditionsConfig r0 = r0.config()
            java.lang.String r4 = r0.checkoutPaymentTermsUrl()
            r5 = 0
            r1.recurringFailed = r5
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            java.lang.String r6 = ""
            r0.setCvv(r6, r5)
            android.widget.Button r0 = r1.f53833n
            r7 = 1
            r0.setEnabled(r7)
            android.widget.Button r0 = r1.f53833n
            java.lang.String r8 = r1.postOrderButtonText
            r0.setText(r8)
            r16.hideAvoidCashWarningView()
            r16.hideSoftPosView()
            r0 = 2131428117(0x7f0b0315, float:1.847787E38)
            r8 = 8
            r9 = 300(0x12c, double:1.48E-321)
            r11 = 0
            if (r2 != r0) goto L_0x008e
            r1.isFromVisaCheckout = r5
            r1.savedCardSelected = r5
            r16.removeBin()
            r1.selectedPaymentMethod = r5
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setFromVisaCheckout(r5)
            android.view.View r0 = r1.payByCash
            r0.setVisibility(r5)
            android.widget.TextView r0 = r1.paymentBy
            android.content.res.Resources r2 = r16.getResources()
            r13 = 2132019417(0x7f1408d9, float:1.9677168E38)
            java.lang.String r2 = r2.getString(r13)
            r0.setText(r2)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.paymentMethodSelected(r5)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setSelectedPaymentMethodForGA(r5)
            android.widget.TextView r0 = r1.paymentTerms
            r0.setVisibility(r8)
            android.widget.Button r0 = r1.f53833n
            r0.setVisibility(r5)
            com.talabat.helpers.GlobalConstants.lastPaymentRequestedTime = r11
            com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout r0 = r1.expandableLinearLayout
            android.animation.TimeInterpolator r2 = com.talabat.designhelpers.Utils.createInterpolator(r5)
            r0.collapse(r9, r2)
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            r0.clearSelectedCardValidate()
            r16.showAvoidCashWarningView()
            r16.showSoftPosView()
            goto L_0x04be
        L_0x008e:
            r0 = 2131428597(0x7f0b04f5, float:1.8478843E38)
            java.lang.String r13 = "1"
            r14 = 2132018080(0x7f1403a0, float:1.9674457E38)
            java.lang.String r15 = "0"
            java.lang.String r8 = "{pm}"
            java.lang.String r9 = "{type}"
            if (r2 != r0) goto L_0x0104
            r16.removeBin()
            r1.isFromVisaCheckout = r5
            r1.savedCardSelected = r5
            r1.selectedPaymentMethod = r7
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setFromVisaCheckout(r5)
            android.widget.TextView r0 = r1.paymentTerms
            r0.setVisibility(r5)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.paymentMethodSelected(r7)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setSelectedPaymentMethodForGA(r7)
            java.lang.String r0 = r1.getString(r14)
            r1.title = r0
            r0 = 2132018081(0x7f1403a1, float:1.9674459E38)
            java.lang.String r0 = r1.getString(r0)
            r1.termsTitle = r0
            java.lang.String r0 = r4.replace(r9, r15)     // Catch:{ Exception -> 0x00d5 }
            java.lang.String r4 = r0.replace(r8, r13)     // Catch:{ Exception -> 0x00d5 }
            goto L_0x00d9
        L_0x00d5:
            r0 = move-exception
            r0.printStackTrace()
        L_0x00d9:
            library.talabat.mvp.checkout.checkoutrefactor.CheckoutRefactorPresenter r0 = r1.checkoutRefactorPresenter
            r0.onSelectingDebitCardPaymentMethod()
            library.talabat.mvp.checkout.checkoutrefactor.CheckoutRefactorPresenter r0 = r1.checkoutRefactorPresenter
            java.lang.String r6 = r0.onDebitPaymentMethodUrlUpdated()
            android.view.View r0 = r1.payByCash
            r0.setVisibility(r5)
            com.talabat.helpers.GlobalConstants.lastPaymentRequestedTime = r11
            android.widget.Button r0 = r1.f53833n
            r0.setVisibility(r5)
            com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout r0 = r1.expandableLinearLayout
            android.animation.TimeInterpolator r2 = com.talabat.designhelpers.Utils.createInterpolator(r5)
            r8 = 300(0x12c, double:1.48E-321)
            r0.collapse(r8, r2)
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            r0.clearSelectedCardValidate()
            goto L_0x04be
        L_0x0104:
            r0 = 2131428512(0x7f0b04a0, float:1.847867E38)
            r10 = 2132017997(0x7f14034d, float:1.9674288E38)
            r11 = 2132017993(0x7f140349, float:1.967428E38)
            java.lang.String r12 = "2"
            java.lang.String r7 = "#"
            r14 = 2
            if (r2 != r0) goto L_0x01a3
            r16.removeBin()
            r1.isFromVisaCheckout = r5
            r1.savedCardSelected = r5
            r1.existingCard = r5
            r1.selectedPaymentMethod = r14
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setFromVisaCheckout(r5)
            java.lang.String r0 = r1.getString(r11)
            r1.title = r0
            java.lang.String r0 = r1.getString(r10)
            r1.termsTitle = r0
            java.lang.String r0 = r4.replace(r9, r15)     // Catch:{ Exception -> 0x0139 }
            java.lang.String r4 = r0.replace(r8, r12)     // Catch:{ Exception -> 0x0139 }
            goto L_0x013d
        L_0x0139:
            r0 = move-exception
            r0.printStackTrace()
        L_0x013d:
            android.widget.TextView r0 = r1.paymentTerms
            r0.setVisibility(r5)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.paymentMethodSelected(r14)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setSelectedPaymentMethodForGA(r14)
            r2 = 2132017546(0x7f14018a, float:1.9673373E38)
            java.lang.String r0 = r1.getString(r2)
            android.content.res.Resources r2 = r16.getResources()
            r6 = 2132017988(0x7f140344, float:1.967427E38)
            java.lang.String r2 = r2.getString(r6)
            java.lang.String r0 = r0.replace(r7, r2)
            android.view.View r2 = r1.payByCash
            r2.setVisibility(r5)
            r2 = 2132019414(0x7f1408d6, float:1.9677162E38)
            java.lang.CharSequence r2 = r1.getText(r2)
            java.lang.String r2 = r2.toString()
            android.content.res.Resources r8 = r16.getResources()
            java.lang.String r6 = r8.getString(r6)
            java.lang.String r2 = r2.replace(r7, r6)
            r1.paymnentMethod = r2
            android.widget.TextView r6 = r1.paymentBy
            r6.setText(r2)
            r6 = 0
            com.talabat.helpers.GlobalConstants.lastPaymentRequestedTime = r6
            android.widget.Button r2 = r1.f53833n
            r2.setVisibility(r5)
            com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout r2 = r1.expandableLinearLayout
            android.animation.TimeInterpolator r6 = com.talabat.designhelpers.Utils.createInterpolator(r5)
            r7 = 300(0x12c, double:1.48E-321)
            r2.collapse(r7, r6)
            buisnessmodels.Customer r2 = buisnessmodels.Customer.getInstance()
            r2.clearSelectedCardValidate()
        L_0x01a0:
            r6 = r0
            goto L_0x04be
        L_0x01a3:
            r0 = 2131431701(0x7f0b1115, float:1.8485139E38)
            if (r2 != r0) goto L_0x0271
            r0 = 2132018080(0x7f1403a0, float:1.9674457E38)
            java.lang.String r0 = r1.getString(r0)
            r1.title = r0
            int r0 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r2 = com.talabat.configuration.country.Country.UAE
            int r6 = r2.getCountryId()
            if (r0 != r6) goto L_0x01c1
            java.lang.String r0 = r1.getString(r11)
            r1.title = r0
        L_0x01c1:
            r16.removeBin()
            r1.isFromVisaCheckout = r5
            r1.savedCardSelected = r5
            r6 = 3
            r1.selectedPaymentMethod = r6
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setFromVisaCheckout(r5)
            int r0 = com.talabat.helpers.GlobalDataModel.SelectedCountryId     // Catch:{ Exception -> 0x0200 }
            int r2 = r2.getCountryId()     // Catch:{ Exception -> 0x0200 }
            if (r0 == r2) goto L_0x01f6
            int r0 = com.talabat.helpers.GlobalDataModel.SelectedCountryId     // Catch:{ Exception -> 0x0200 }
            com.talabat.configuration.country.Country r2 = com.talabat.configuration.country.Country.JORDAN     // Catch:{ Exception -> 0x0200 }
            int r2 = r2.getCountryId()     // Catch:{ Exception -> 0x0200 }
            if (r0 == r2) goto L_0x01f6
            int r0 = com.talabat.helpers.GlobalDataModel.SelectedCountryId     // Catch:{ Exception -> 0x0200 }
            com.talabat.configuration.country.Country r2 = com.talabat.configuration.country.Country.EGYPT     // Catch:{ Exception -> 0x0200 }
            int r2 = r2.getCountryId()     // Catch:{ Exception -> 0x0200 }
            if (r0 != r2) goto L_0x01ed
            goto L_0x01f6
        L_0x01ed:
            java.lang.String r0 = r4.replace(r9, r12)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r0 = r0.replace(r8, r13)     // Catch:{ Exception -> 0x0200 }
            goto L_0x01fe
        L_0x01f6:
            java.lang.String r0 = r4.replace(r9, r12)     // Catch:{ Exception -> 0x0200 }
            java.lang.String r0 = r0.replace(r8, r12)     // Catch:{ Exception -> 0x0200 }
        L_0x01fe:
            r4 = r0
            goto L_0x0204
        L_0x0200:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0204:
            android.widget.TextView r0 = r1.paymentTerms
            r0.setVisibility(r5)
            android.view.View r0 = r1.payByCash
            r2 = 8
            r0.setVisibility(r2)
            android.view.View r0 = r1.talabatCreditView
            r0.setVisibility(r5)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.paymentMethodSelected(r6)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setSelectedPaymentMethodForGA(r6)
            com.talabat.configuration.country.Country r0 = com.talabat.configuration.country.Country.OMAN
            com.talabat.configuration.ConfigurationLocalRepository r2 = r1.E
            com.talabat.configuration.country.Country r2 = r2.selectedCountry()
            if (r0 != r2) goto L_0x0235
            android.content.res.Resources r0 = r16.getResources()
            r2 = 2132020058(0x7f140b5a, float:1.9678468E38)
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0240
        L_0x0235:
            android.content.res.Resources r0 = r16.getResources()
            r2 = 2132020044(0x7f140b4c, float:1.967844E38)
            java.lang.String r0 = r0.getString(r2)
        L_0x0240:
            r2 = 2132017546(0x7f14018a, float:1.9673373E38)
            java.lang.String r2 = r1.getString(r2)
            java.lang.String r6 = r2.replace(r7, r0)
            r7 = 0
            com.talabat.helpers.GlobalConstants.lastPaymentRequestedTime = r7
            r0 = 2132020047(0x7f140b4f, float:1.9678446E38)
            java.lang.String r0 = r1.getString(r0)
            r1.termsTitle = r0
            android.widget.Button r0 = r1.f53833n
            r0.setVisibility(r5)
            com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout r0 = r1.expandableLinearLayout
            android.animation.TimeInterpolator r2 = com.talabat.designhelpers.Utils.createInterpolator(r5)
            r7 = 300(0x12c, double:1.48E-321)
            r0.collapse(r7, r2)
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            r0.clearSelectedCardValidate()
            goto L_0x04be
        L_0x0271:
            r0 = 2131431226(0x7f0b0f3a, float:1.8484175E38)
            if (r2 != r0) goto L_0x02f9
            r13 = 1
            r1.existingCard = r13
            r1.isFromVisaCheckout = r5
            r1.selectedPaymentMethod = r14
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setFromVisaCheckout(r5)
            java.lang.String r0 = r1.getString(r11)
            r1.title = r0
            java.lang.String r0 = r1.getString(r10)
            r1.termsTitle = r0
            java.lang.String r0 = r4.replace(r9, r15)     // Catch:{ Exception -> 0x0297 }
            java.lang.String r4 = r0.replace(r8, r12)     // Catch:{ Exception -> 0x0297 }
            goto L_0x029b
        L_0x0297:
            r0 = move-exception
            r0.printStackTrace()
        L_0x029b:
            android.widget.TextView r0 = r1.paymentTerms
            r0.setVisibility(r5)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.paymentMethodSelected(r14)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setSelectedPaymentMethodForGA(r14)
            r2 = 2132017546(0x7f14018a, float:1.9673373E38)
            java.lang.String r0 = r1.getString(r2)
            android.content.res.Resources r2 = r16.getResources()
            r6 = 2132017988(0x7f140344, float:1.967427E38)
            java.lang.String r2 = r2.getString(r6)
            java.lang.String r0 = r0.replace(r7, r2)
            android.view.View r2 = r1.payByCash
            r2.setVisibility(r5)
            r2 = 2132019414(0x7f1408d6, float:1.9677162E38)
            java.lang.CharSequence r2 = r1.getText(r2)
            java.lang.String r2 = r2.toString()
            android.content.res.Resources r8 = r16.getResources()
            java.lang.String r6 = r8.getString(r6)
            java.lang.String r2 = r2.replace(r7, r6)
            r1.paymnentMethod = r2
            android.widget.TextView r6 = r1.paymentBy
            r6.setText(r2)
            android.widget.Button r2 = r1.f53833n
            r2.setVisibility(r5)
            r6 = 0
            com.talabat.helpers.GlobalConstants.lastPaymentRequestedTime = r6
            com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout r2 = r1.expandableLinearLayout
            android.animation.TimeInterpolator r6 = com.talabat.designhelpers.Utils.createInterpolator(r5)
            r7 = 300(0x12c, double:1.48E-321)
            r2.collapse(r7, r6)
            goto L_0x01a0
        L_0x02f9:
            r0 = 2131428175(0x7f0b034f, float:1.8477987E38)
            r13 = 2131430782(0x7f0b0d7e, float:1.8483275E38)
            r10 = 2131429819(0x7f0b09bb, float:1.8481321E38)
            if (r2 == r0) goto L_0x03fa
            if (r2 == r10) goto L_0x03fa
            if (r2 != r13) goto L_0x030a
            goto L_0x03fa
        L_0x030a:
            r0 = 2131432512(0x7f0b1440, float:1.8486784E38)
            if (r2 != r0) goto L_0x03b2
            r16.removeBin()
            r1.savedCardSelected = r5
            r2 = 1
            r1.isFromVisaCheckout = r2
            r1.selectedPaymentMethod = r14
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setFromVisaCheckout(r2)
            java.lang.String r0 = r1.getString(r11)
            r1.title = r0
            r0 = 2132017997(0x7f14034d, float:1.9674288E38)
            java.lang.String r0 = r1.getString(r0)
            r1.termsTitle = r0
            java.lang.String r0 = r4.replace(r9, r15)     // Catch:{ Exception -> 0x0337 }
            java.lang.String r0 = r0.replace(r8, r12)     // Catch:{ Exception -> 0x0337 }
            r4 = r0
            goto L_0x033b
        L_0x0337:
            r0 = move-exception
            r0.printStackTrace()
        L_0x033b:
            android.widget.TextView r0 = r1.paymentTerms
            r0.setVisibility(r5)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.paymentMethodSelected(r14)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r2 = 50
            r0.setSelectedPaymentMethodForGA(r2)
            r2 = 2132017546(0x7f14018a, float:1.9673373E38)
            java.lang.String r0 = r1.getString(r2)
            android.content.res.Resources r2 = r16.getResources()
            r6 = 2132017988(0x7f140344, float:1.967427E38)
            java.lang.String r2 = r2.getString(r6)
            java.lang.String r0 = r0.replace(r7, r2)
            android.view.View r2 = r1.payByCash
            r2.setVisibility(r5)
            r2 = 2132019414(0x7f1408d6, float:1.9677162E38)
            java.lang.CharSequence r2 = r1.getText(r2)
            java.lang.String r2 = r2.toString()
            android.content.res.Resources r8 = r16.getResources()
            java.lang.String r6 = r8.getString(r6)
            java.lang.String r2 = r2.replace(r7, r6)
            r1.paymnentMethod = r2
            android.widget.TextView r6 = r1.paymentBy
            r6.setText(r2)
            r6 = 0
            com.talabat.helpers.GlobalConstants.lastPaymentRequestedTime = r6
            java.lang.String r2 = com.talabat.helpers.GlobalDataModel.callId
            boolean r2 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r2)
            if (r2 == 0) goto L_0x0399
            android.widget.Button r2 = r1.f53833n
            r6 = 8
            r2.setVisibility(r6)
            goto L_0x03a9
        L_0x0399:
            android.widget.Button r2 = r1.f53833n
            r2.setVisibility(r5)
            com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout r2 = r1.expandableLinearLayout
            android.animation.TimeInterpolator r6 = com.talabat.designhelpers.Utils.createInterpolator(r5)
            r7 = 300(0x12c, double:1.48E-321)
            r2.collapse(r7, r6)
        L_0x03a9:
            buisnessmodels.Customer r2 = buisnessmodels.Customer.getInstance()
            r2.clearSelectedCardValidate()
            goto L_0x01a0
        L_0x03b2:
            r0 = 2131427781(0x7f0b01c5, float:1.8477188E38)
            if (r2 != r0) goto L_0x04be
            com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel r0 = r1.bnplManagerViewModel
            com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository r2 = r1.P
            com.talabat.configuration.tcs.TermsAndConditionsConfig r2 = r2.config()
            java.lang.String r2 = r2.checkoutPaymentTermsUrl()
            java.lang.String r4 = r0.getBNPLTermsAndConditionUrl(r2)
            r2 = 2132019414(0x7f1408d6, float:1.9677162E38)
            java.lang.CharSequence r0 = r1.getText(r2)
            java.lang.String r0 = r0.toString()
            android.content.res.Resources r2 = r16.getResources()
            r6 = 2132019421(0x7f1408dd, float:1.9677176E38)
            java.lang.String r2 = r2.getString(r6)
            java.lang.String r0 = r0.replace(r7, r2)
            r1.paymnentMethod = r0
            android.widget.TextView r2 = r1.paymentBy
            r2.setText(r0)
            r0 = 2132019421(0x7f1408dd, float:1.9677176E38)
            java.lang.String r0 = r1.getString(r0)
            r1.termsTitle = r0
            r0 = 2132017466(0x7f14013a, float:1.9673211E38)
            java.lang.String r6 = r1.getString(r0)
            goto L_0x04be
        L_0x03fa:
            r16.removeBin()
            r1.isFromVisaCheckout = r5
            r1.savedCardSelected = r5
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            r0.clearSelectedCard()
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            r0.clearSelectedCardValidate()
            r1.selectedPaymentMethod = r14
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setFromVisaCheckout(r5)
            java.lang.String r0 = r1.getString(r11)
            r1.title = r0
            r0 = 2132017997(0x7f14034d, float:1.9674288E38)
            java.lang.String r0 = r1.getString(r0)
            r1.termsTitle = r0
            java.lang.String r0 = r4.replace(r9, r15)     // Catch:{ Exception -> 0x042e }
            java.lang.String r4 = r0.replace(r8, r12)     // Catch:{ Exception -> 0x042e }
            goto L_0x0432
        L_0x042e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0432:
            android.widget.TextView r0 = r1.paymentTerms
            r0.setVisibility(r5)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.paymentMethodSelected(r14)
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setSelectedPaymentMethodForGA(r14)
            r6 = 2132017546(0x7f14018a, float:1.9673373E38)
            java.lang.String r0 = r1.getString(r6)
            android.content.res.Resources r6 = r16.getResources()
            r8 = 2132017988(0x7f140344, float:1.967427E38)
            java.lang.String r6 = r6.getString(r8)
            java.lang.String r6 = r0.replace(r7, r6)
            android.view.View r0 = r1.payByCash
            r0.setVisibility(r5)
            r9 = 2132019414(0x7f1408d6, float:1.9677162E38)
            java.lang.CharSequence r0 = r1.getText(r9)
            java.lang.String r0 = r0.toString()
            android.content.res.Resources r9 = r16.getResources()
            java.lang.String r8 = r9.getString(r8)
            java.lang.String r0 = r0.replace(r7, r8)
            r1.paymnentMethod = r0
            android.widget.TextView r7 = r1.paymentBy
            r7.setText(r0)
            android.widget.Button r0 = r1.f53833n
            r0.setVisibility(r5)
            com.talabat.designhelpers.expandableLayoutHelpers.ExpandableLinearLayout r0 = r1.expandableLinearLayout
            android.animation.TimeInterpolator r7 = com.talabat.designhelpers.Utils.createInterpolator(r5)
            r8 = 300(0x12c, double:1.48E-321)
            r0.collapse(r8, r7)
            r7 = 0
            com.talabat.helpers.GlobalConstants.lastPaymentRequestedTime = r7
            if (r2 == r10) goto L_0x0499
            if (r2 != r13) goto L_0x0493
            goto L_0x0499
        L_0x0493:
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r0.setHideAddCardStatus(r5)
            goto L_0x049f
        L_0x0499:
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            r2 = 1
            r0.setHideAddCardStatus(r2)
        L_0x049f:
            java.lang.String r0 = "[ALOV] before prepareForPlacingOrder #2"
            com.talabat.talabatcore.logger.LogManager.debug(r0)
            library.talabat.mvp.checkout.ICheckoutPresenter r7 = r1.checkoutPresenter
            r8 = 1
            boolean r9 = r1.allowDuplicate
            boolean r10 = r1.isQuick
            java.lang.String r11 = r16.getFirstName()
            java.lang.String r12 = r16.getLastName()
            java.lang.String r13 = ""
            library.talabat.mvp.checkout.ICheckoutPresenter r0 = r1.checkoutPresenter
            boolean r14 = r0.getHideAddCardStatus()
            r7.prepareForPlacingOrder(r8, r9, r10, r11, r12, r13, r14)
        L_0x04be:
            com.talabat.CheckOutScreen$29 r0 = new com.talabat.CheckOutScreen$29
            r0.<init>(r4)
            android.text.SpannableString r2 = new android.text.SpannableString
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r6)
            java.lang.String r7 = " "
            r4.append(r7)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            r2.<init>(r3)
            android.content.res.Resources r3 = r16.getResources()
            r4 = 2131099751(0x7f060067, float:1.7811864E38)
            int r3 = r3.getColor(r4)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r4 = r6.length()
            int r7 = r2.length()
            r2.setSpan(r3, r4, r7, r5)
            int r3 = r6.length()
            r4 = 1
            int r3 = r3 + r4
            int r4 = r2.length()
            r5 = 33
            r2.setSpan(r0, r3, r4, r5)
            android.widget.TextView r0 = r1.paymentTerms
            r0.setText(r2)
            android.widget.TextView r0 = r1.paymentTerms
            android.text.method.MovementMethod r2 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.CheckOutScreen.onPaymentSelected(int):void");
    }

    /* access modifiers changed from: private */
    public void onPopupRadioClicked(RadioButton radioButton) {
        RadioButton[] radioButtonArr = this.duplicateOrderPopupRadioGroup;
        if (radioButtonArr != null) {
            for (RadioButton radioButton2 : radioButtonArr) {
                if (radioButton2 == radioButton) {
                    radioButton2.setChecked(true);
                } else {
                    radioButton2.setChecked(false);
                }
            }
        }
    }

    private void onRadioButtonClicked(RadioButton radioButton) {
        for (RadioButton radioButton2 : this.radioButtons) {
            if (radioButton2 == radioButton) {
                radioButton2.setChecked(true);
                RadioButton[] radioButtonArr = this.cardRadioButtons;
                if (radioButtonArr != null && radioButtonArr.length > 0) {
                    adjustCheckedRadioButtons(radioButtonArr);
                }
            } else {
                radioButton2.setChecked(false);
            }
        }
        RadioButton radioButton3 = this.visaCheckoutRadio;
        if (radioButton != radioButton3) {
            this.f53833n.setVisibility(0);
            this.expandableLinearLayout.collapse(300, Utils.createInterpolator(0));
        } else if (radioButton != radioButton3 || TalabatUtils.isNullOrEmpty(GlobalDataModel.callId)) {
            this.f53833n.setVisibility(8);
            this.expandableLinearLayout.expand(300, Utils.createInterpolator(0));
        } else {
            this.f53833n.setVisibility(0);
            this.expandableLinearLayout.collapse(300, Utils.createInterpolator(0));
        }
    }

    /* access modifiers changed from: private */
    public Unit onRiderTipValueChange(Double d11) {
        this.checkoutPresenter.onRiderTipValueChange(d11);
        return null;
    }

    /* access modifiers changed from: private */
    public void onScheduleLaterClick() {
        this.f53841v = true;
        if (this.checkoutPresenter.isDeliveryTimingApiCalled()) {
            ArrayList<String> arrayList = this.f53840u;
            if (arrayList != null && arrayList.size() > 0) {
                showBottomSheetForDeliveryTiming();
                return;
            }
            return;
        }
        this.checkoutPresenter.postDateButtonClicked(true);
        startLodingPopup();
    }

    private void onSendTrackingEvent(String str, String str2, String str3) {
        this.bnplManagerViewModel.onBNPLOrderPaymentError(new BNPLOrderPaymentFailureTrackingModel(BNPLInitiatePlaceOrderFragmentKt.BNPL_TRACKING_NAME, str2, Cart.getInstance().getRestaurant(), GlobalDataModel.CONTACTLESS.contactlessEnabled, this.checkoutPresenter.getDefaultPaymentMethod(), str3, str, GlobalDataModel.POLYGON_TRACKING.polygonEvents));
    }

    private void openForceCVVBottomSheet(TokenisationCreditCard tokenisationCreditCard) {
        if (tokenisationCreditCard.cardnumber != null) {
            CheckoutForceCVVBottomSheet checkoutForceCVVBottomSheet = new CheckoutForceCVVBottomSheet(tokenisationCreditCard.cardnumber, this);
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            supportFragmentManager.beginTransaction();
            checkoutForceCVVBottomSheet.show(supportFragmentManager, "");
        }
    }

    /* access modifiers changed from: private */
    public void openForceCVVUpdate(ForceCVVBottomSheetDisplayModel forceCVVBottomSheetDisplayModel) {
        if (forceCVVBottomSheetDisplayModel instanceof ForceCVVBottomSheetDisplayModel.OpenForceCVVBottomSheet) {
            openForceCVVBottomSheet(Customer.getInstance().getSelectedCreditCard());
        } else if (forceCVVBottomSheetDisplayModel instanceof ForceCVVBottomSheetDisplayModel.PayRemainingWithCredit) {
            this.checkoutPresenter.payRemainingWithCreditCard();
        } else {
            this.K.trackUnExpectedScenario("unexpected display model", new HashMap());
        }
    }

    private void openTermsAndConditions(String str) {
        Intent intent = new Intent(this, TWebViewScreen.class);
        intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, getString(R.string.tpro_terms_and_conditions));
        intent.putExtra("url", str);
        startActivity(intent);
    }

    private void payfortPaymentView(boolean z11, TokenisationCreditCard tokenisationCreditCard) {
        if (z11) {
            this.cardList.setVisibility(0);
            PayfortCardListPresenter payfortCardListPresenter = new PayfortCardListPresenter(this.D, this.E, this.G, this);
            this.PayfortCardListPresenter = payfortCardListPresenter;
            payfortCardListPresenter.setUpViews();
            return;
        }
        this.selectedCardView.setVisibility(8);
        this.cardList.setVisibility(8);
    }

    private void placeOrderTrigger() {
        int i11;
        LogManager.debug("[ALOV]: placeOrderTrigger :: enter");
        this.transactionAmount = TalabatFormatter.getInstance().getFormattedCurrency(this.cart.getCartTotalPrice(), true);
        LogManager.debug("[ALOV]: placeOrderTrigger :: transactionAmount - " + this.transactionAmount);
        showNonCancelableProgress();
        try {
            datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.E, this.G);
            LogManager.debug("[ALOV]: placeOrderTrigger :: selectedCountryFull - " + selectedCountry);
            if (selectedCountry != null) {
                i11 = selectedCountry.tokenisationProvider;
            } else {
                i11 = -1;
            }
            LogManager.debug("[ALOV]: placeOrderTrigger :: tokenizationProvider - " + i11);
            if (this.checkoutPresenter != null) {
                if (this.selectedPaymentMethod != 2 || !this.isTokenisationAvaliable || i11 != 2 || this.existingCard || this.isFromVisaCheckout) {
                    LogManager.debug("[ALOV]: placeOrderTrigger :: OTHERE METHOD");
                    this.checkoutPresenter.prepareForPlacingOrder(false, this.allowDuplicate, this.isQuick, getFirstName(), getLastName(), "", this.checkoutPresenter.getHideAddCardStatus());
                } else {
                    LogManager.debug("[ALOV]: placeOrderTrigger :: CREDITCARD");
                    this.fromPlaceOrder = true;
                    this.checkoutPresenter.prepareForPlacingOrder(true, this.allowDuplicate, this.isQuick, getFirstName(), getLastName(), "", this.checkoutPresenter.getHideAddCardStatus());
                }
            }
            LogManager.debug("[ALOV]: placeOrderTrigger :: exit");
        } catch (Exception e11) {
            LogManager.error(e11, "[ALOV]: placeOrderTrigger :: error during place order");
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void removeBin() {
        if (this.binApplied) {
            this.cart.removeBinDiscountIfApplied();
            this.cart.recalcualteTotal();
            setVoucherView();
            this.binApplied = false;
            this.isBinDiscountAppliedForTracking = false;
            updateAmountDisplay(Boolean.FALSE);
        }
    }

    /* access modifiers changed from: private */
    public void resetPaymentViews() {
        this.payByCash.setVisibility(8);
        this.paymentTerms.setVisibility(8);
        this.selectedPaymentMethod = -1;
        this.checkoutPresenter.setPaymentMethod(-1);
        hideTalabatCreditView();
        RadioButton[] radioButtonArr = this.cardRadioButtons;
        if (radioButtonArr != null && radioButtonArr.length > 0) {
            adjustCheckedRadioButtons(radioButtonArr);
        }
        RadioButton[] radioButtonArr2 = this.radioButtons;
        if (radioButtonArr2 != null && radioButtonArr2.length > 0) {
            adjustCheckedRadioButtons(radioButtonArr2);
        }
        this.f53833n.setVisibility(0);
        this.expandableLinearLayout.collapse(300, Utils.createInterpolator(0));
    }

    private void resetVisaCheckoutInstance() {
        GlobalDataModel.callId = "";
        this.selectedPaymentMethod = -1;
        this.payByCash.setVisibility(8);
        this.paymentTerms.setVisibility(8);
        this.checkoutPresenter.setPaymentMethod(this.selectedPaymentMethod);
        this.isFromVisaCheckout = false;
        this.f53833n.setVisibility(0);
        this.expandableLinearLayout.collapse(300, Utils.createInterpolator(0));
        clearSelectedRadioButtons();
    }

    private void setAddressIcon() {
        if (this.checkoutPresenter.isPickup()) {
            this.addressIcon.setImageResource(R.drawable.ic_location_pin);
        } else {
            this.addressIcon.setImageResource(R.drawable.ic_m_address_pin);
        }
    }

    @RequiresApi(api = 17)
    private void setConfiguration() {
        if (TalabatUtils.isEnglish()) {
            Configuration configuration = getResources().getConfiguration();
            configuration.setLayoutDirection(new Locale("en"));
            getResources().updateConfiguration(configuration, getResources().getDisplayMetrics());
        } else if (TalabatUtils.isRTL()) {
            Configuration configuration2 = getResources().getConfiguration();
            configuration2.setLayoutDirection(new Locale(ArchiveStreamFactory.AR));
            getResources().updateConfiguration(configuration2, getResources().getDisplayMetrics());
        }
    }

    private void setDefaultPaymentOption(TokenisationCreditCard tokenisationCreditCard) {
        if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardnumber)) {
            this.defaultCreditCardName.setText(tokenisationCreditCard.cardnumber);
        }
        if (!TalabatUtils.isNullOrEmpty(tokenisationCreditCard.cardtype)) {
            this.defaultCreditCardIcon.setImageResource(WalletCardType.Companion.getCardTypeFromCardName(tokenisationCreditCard.cardtype).getIconResource());
        }
        this.selectedCardName = tokenisationCreditCard.cardtype;
        Customer.getInstance().setSelectedCreditCard(tokenisationCreditCard);
        onPaymentSelected(this.selectedPayfortCard.getId());
        this.savedCardSelected = true;
    }

    private void setDeliveryView(String str) {
        float calculateDeliveryCharges = this.cart.calculateDeliveryCharges();
        if (this.cart.getRestaurant() == null) {
            return;
        }
        if (this.cart.isRemoteDeliveryFee()) {
            this.deliveryChargesText.setTextColor(getResources().getColor(R.color.text_black));
            this.deliveryChargesValue.setTextColor(getResources().getColor(R.color.text_black));
            this.oldDeliveryCharges.setVisibility(8);
            this.deliveryChargesValue.setText(str);
            return;
        }
        int i11 = (calculateDeliveryCharges > 0.0f ? 1 : (calculateDeliveryCharges == 0.0f ? 0 : -1));
        if (i11 < 0 || this.cart.getRestaurant().getTalabatCharges() > 0.0f) {
            this.cart.setNewDeliveryCharge(-1.0f);
            this.deliveryChargesText.setTextColor(getResources().getColor(R.color.text_black));
            this.deliveryChargesValue.setTextColor(getResources().getColor(R.color.text_black));
            this.oldDeliveryCharges.setVisibility(8);
            this.deliveryChargesValue.setText(str);
            return;
        }
        this.deliveryChargesText.setTextColor(getResources().getColor(R.color.promo));
        this.deliveryChargesValue.setTextColor(getResources().getColor(R.color.promo));
        this.oldDeliveryCharges.setTextColor(getResources().getColor(R.color.promo));
        this.oldDeliveryCharges.setVisibility(0);
        this.oldDeliveryCharges.setText(str);
        if (i11 == 0) {
            this.deliveryChargesValue.setText(getResources().getString(R.string.free_caps));
        } else {
            this.deliveryChargesValue.setText(TalabatFormatter.getInstance().getFormattedCurrency(calculateDeliveryCharges));
        }
    }

    /* access modifiers changed from: private */
    public void setFeesDescriptions(FeesDescriptionsDisplayModel feesDescriptionsDisplayModel) {
        t4 t4Var;
        u4 u4Var;
        int i11;
        s4 s4Var;
        this.feesDescriptions = feesDescriptionsDisplayModel;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FeesDescriptionsDisplayModel feesDescriptionsDisplayModel2 = this.feesDescriptions;
        int i12 = 0;
        boolean z11 = true;
        if (Cart.getInstance().getRestaurant().shopType != 1) {
            z11 = false;
        }
        ShowFeesDescriptionBottomSheetClickListener showFeesDescriptionBottomSheetClickListener = new ShowFeesDescriptionBottomSheetClickListener(supportFragmentManager, feesDescriptionsDisplayModel2, z11);
        w4 w4Var = null;
        if (!isDarkStore() || !this.L.getFeatureFlag(QCommerceFeatureFlagsKeys.BASKET_BASED_DELIVERY_FEE, false)) {
            View view = this.deliveryFeeInfoIcon;
            if (this.feesDescriptions.getDeliveryFee() == null) {
                i11 = 8;
            } else {
                i11 = 0;
            }
            view.setVisibility(i11);
            View view2 = this.deliveryFeeClickableArea;
            if (this.feesDescriptions.getDeliveryFee() == null) {
                s4Var = null;
            } else {
                s4Var = new s4(this, showFeesDescriptionBottomSheetClickListener);
            }
            view2.setOnClickListener(s4Var);
        } else {
            this.deliveryFeeInfoIcon.setVisibility(8);
        }
        View view3 = this.aboutFees;
        if (this.feesDescriptions.getHowFeesWork() == null) {
            i12 = 8;
        }
        view3.setVisibility(i12);
        View view4 = this.aboutFees;
        if (this.feesDescriptions.getHowFeesWork() == null) {
            t4Var = null;
        } else {
            t4Var = new t4(this, showFeesDescriptionBottomSheetClickListener);
        }
        view4.setOnClickListener(t4Var);
        ServiceFeeView serviceFeeView2 = this.serviceFeeView;
        if (this.feesDescriptions.getServiceFee() == null) {
            u4Var = null;
        } else {
            u4Var = new u4(this, showFeesDescriptionBottomSheetClickListener);
        }
        serviceFeeView2.setOnInfoClickListener(u4Var);
        SmallOrderFeeView smallOrderFeeView2 = this.smallOrderFeeView;
        if (this.feesDescriptions.getSmallOrderFee() != null) {
            w4Var = new w4(this, showFeesDescriptionBottomSheetClickListener);
        }
        smallOrderFeeView2.setOnInfoClickListener(w4Var);
        if (this.feesDescriptions.getSmallOrderFee() != null) {
            this.smallOrderFeeView.setDescriptionText(this.feesDescriptions.getSmallOrderFee().getLocalDescription());
        }
    }

    private void setPreOrderTitle(CharSequence charSequence) {
        View view = this.postDateDelivery;
        if (view instanceof DSSimpleCard) {
            ((DSSimpleCard) view).setLabel(charSequence.toString());
            return;
        }
        TextView textView = this.preOrderTitle;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    private void setScheduleLaterLabel(CharSequence charSequence) {
        View view = this.scheduleLater;
        if (view instanceof DSTextLink) {
            ((DSTextLink) view).setText(charSequence.toString());
        } else if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
    }

    private void setScheduleLaterOnClickListener() {
        View view = this.postDateDelivery;
        if (view instanceof CheckoutOrderTimeSelectorView) {
            ((CheckoutOrderTimeSelectorView) view).setOnScheduleLaterClickListener(new s2(this));
            ((CheckoutOrderTimeSelectorView) this.postDateDelivery).setOnOrderNowClickListener(new d3(this));
            return;
        }
        View view2 = this.scheduleLater;
        if (view2 instanceof TextView) {
            view2.setOnClickListener(new o3(this));
        }
    }

    private void setScheduleLaterVisibility(int i11) {
        View view = this.scheduleLater;
        if (view != null) {
            view.setVisibility(i11);
        }
        View view2 = this.postDateDelivery;
        if (!(view2 instanceof DSSimpleCard)) {
            return;
        }
        if (i11 == 0) {
            ((DSSimpleCard) view2).setOnTap(new h4(this));
        } else {
            ((DSSimpleCard) view2).setOnTap((Function0<Unit>) null);
        }
    }

    private void setScheduledDeliveryDiscount() {
        View view = this.postDateDelivery;
        if (view instanceof CheckoutOrderTimeSelectorView) {
            ((CheckoutOrderTimeSelectorView) view).updateScheduledDeliveryDiscount(this.checkoutPresenter.getScheduledDeliveryDiscount());
        }
    }

    private void setUpCancellationPolicy() {
        CancellationPolicyView cancellationPolicyView = (CancellationPolicyView) findViewById(R.id.dsAlertCancellationPolicyNote);
        if (this.f53826b0.isCancellationPolicyIsEnabled()) {
            cancellationPolicyView.setVisibility(0);
            cancellationPolicyView.init();
            return;
        }
        cancellationPolicyView.setVisibility(8);
    }

    private void setViewAlphas(Float f11) {
        this.cash.setAlpha(f11.floatValue());
        this.cashLayout.setAlpha(f11.floatValue());
        this.debitCard.setAlpha(f11.floatValue());
        this.debitLayout.setAlpha(f11.floatValue());
        this.f53844y.setAlpha(f11.floatValue());
        this.newTalabatCreditView.setAlpha(f11.floatValue());
        this.f53845z.setAlpha(f11.floatValue());
        this.checkoutdotLayout.setAlpha(f11.floatValue());
        this.A.setAlpha(f11.floatValue());
        this.kNetDebitCardLayout.setAlpha(f11.floatValue());
        this.B.setAlpha(f11.floatValue());
        this.qPayDebitCardLayout.setAlpha(f11.floatValue());
        this.bNPLRadioButton.setAlpha(f11.floatValue());
        this.bNPLLayoutView.setAlpha(f11.floatValue());
    }

    private void setVisibilityOfSubscriptionOnCheckoutBanner() {
        this.checkoutPresenter.calculateMOVWithTProOrder(new o2(this));
    }

    private void setupCurrentLocationAwarenessTxt() {
        int i11;
        ViewStub viewStub = (ViewStub) findViewById(R.id.location_far_view_stub);
        if (this.checkoutPresenter.isDesignSystemAlert()) {
            i11 = R.layout.checkout_location_far_message_ds;
        } else {
            i11 = R.layout.checkout_location_far_message;
        }
        viewStub.setLayoutResource(i11);
        this.mCurrentLocationAwarenessTxt = viewStub.inflate();
    }

    private void setupDarkstoresFees() {
        handleServiceFee(getPreCalculatedServiceFeeForDarkstore());
    }

    private void setupFees() {
        setupFeesViews();
        setupFeesViewModel();
        if (isDarkStore()) {
            setupDarkstoresFees();
            setFeesDescriptions(this.f53825a0.getDarkstoreFeesDescriptions(Cart.getInstance().getFeeDescriptions()));
            return;
        }
        observeFeesValues();
        observeFeesDescriptions();
    }

    private void setupFeesViewModel() {
        this.f53825a0 = (FeesViewModel) this.J.create(FeesViewModel.class);
    }

    private void setupFeesViews() {
        this.serviceFeeView = (ServiceFeeView) findViewById(R.id.service_fee_view);
        this.smallOrderFeeView = (SmallOrderFeeView) findViewById(R.id.small_order_fee_view);
        this.aboutFees = findViewById(R.id.about_fees);
    }

    private void setupPostDateDelivery() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.post_dateDelivery_view_stub);
        viewStub.setLayoutResource(getPostDateDeliveryLayoutResource());
        View inflate = viewStub.inflate();
        this.postDateDelivery = inflate;
        if (inflate instanceof CheckoutOrderTimeSelectorView) {
            this.checkoutPresenter.fetchDarkstoreDeliverySlots();
            ((CheckoutOrderTimeSelectorView) this.postDateDelivery).setOrderNowTitle(getDeliveryTimeLabel());
        } else if (inflate instanceof DSSimpleCard) {
            DSTextLink dSTextLink = new DSTextLink(this);
            dSTextLink.setText(getString(R.string.schedule));
            ((DSSimpleCard) this.postDateDelivery).setTrailingView(dSTextLink);
            this.scheduleLater = dSTextLink;
            this.preOrderTitle = null;
        } else {
            this.scheduleLater = inflate.findViewById(R.id.schedule_order);
            this.preOrderTitle = (TextView) this.postDateDelivery.findViewById(R.id.preorder_title);
        }
    }

    private void shouldShowBinOffersView() {
        boolean z11 = true;
        if (Customer.getInstance().isLoggedIn(getContext()) && this.I.config().isBinCampAvailable()) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Customer.getInstance().getSavedCards());
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TokenisationCreditCard tokenisationCreditCard = (TokenisationCreditCard) it.next();
                if (tokenisationCreditCard.isBinDiscountValid && !TalabatUtils.isNullOrEmpty(tokenisationCreditCard.message) && this.binMessageShown) {
                    z11 = false;
                    break;
                }
            }
        }
        if (z11) {
            this.checkoutPresenter.getBinOfferDetails(getMobileForBin());
        } else {
            closeBinOffers();
        }
    }

    private void showAvoidCashWarningView() {
        if (!isContactlessEnabledCountry() || this.contactlessFeatureView.getVisibility() != 0 || isSoftPosEnabledRestaurant()) {
            this.avoidCashWarningView.setVisibility(8);
        } else {
            this.avoidCashWarningView.setVisibility(0);
        }
    }

    private void showBNPLDeferredView(int i11) {
        this.bNPLLayoutView.setVisibility(0);
        this.bNPLPaymentTypeTextView.setText(getString(R.string.order_today_pay_next_month).replace("#", String.valueOf(i11)));
    }

    private void showBNPLEligibilityErrorIcon() {
        this.bNPLTagView.setVisibility(8);
        this.bNPLEligibilityErrorImageView.setVisibility(0);
    }

    private void showBNPLInstallmentView(int i11, String str) {
        this.bNPLLayoutView.setVisibility(0);
        this.bNPLPaymentTypeTextView.setText(getString(R.string.bnpl_installmental_payment).replace(RichContentLoadTimeRecorder.DELIMETER, str).replace("#", String.valueOf(i11)));
    }

    private void showBNPLView(Boolean bool, Boolean bool2) {
        onPaymentMethodChosen(this.bNPLRadioButton);
        this.checkoutPresenter.paymentMethodSelected(11);
        this.checkoutPresenter.setSelectedPaymentMethodForGA(11);
        this.isFromVisaCheckout = false;
        this.savedCardSelected = false;
        this.selectedPaymentMethod = 11;
        this.checkoutPresenter.setFromVisaCheckout(false);
        Customer.getInstance().clearSelectedCardValidate();
        this.checkoutPaymentUpdateViewModel.onBNPLWidgetClicked(bool.booleanValue(), bool2.booleanValue());
    }

    private void showBinOffers() {
        animateOffersView(-this.binOffersView.getHeight(), 0, this.binOffersView);
    }

    private void showBottomSheetForDeliveryTiming() {
        if (this.postDateDelivery instanceof CheckoutOrderTimeSelectorView) {
            DeliverySlotPickerFragment.Companion.newInstance(this.deliverySlots, this.selectedDeliverySlot, new x4(this), new DeliverySlotPickerFragment.DeliverySlotPickerFragmentCloseListener() {
                public void onClosed() {
                    CheckOutScreen.this.checkoutPresenter.sendScheduledDeliveryClosedEvent();
                }
            }).show(getSupportFragmentManager());
        } else {
            StringBottomsheetDialogFragment.Companion.newInstance(R.layout.delivery_timing_row, this.f53840u, getString(R.string.choose_delivery_timings)).show(getSupportFragmentManager(), "deliverytimingsdialog");
        }
    }

    private void showCardExpiredErrorToast() {
        ToastExtensionsKt.showErrorToast(new Toast(this), getString(R.string.card_expired_error_message), this);
    }

    private void showContactlessFeatureIfAvailable() {
        this.contactlessFeatureView.setVisibility(0);
        this.contactlessFeatureView.setOnClickListener(new z3(this));
        this.contactLessSelector.setOnCheckedChangeListener(new k4(this));
        this.contactLessSelector.performClick();
    }

    private void showDeliveryFee(FeeValue feeValue) {
        String str;
        String str2;
        String str3;
        String str4 = null;
        if (feeValue == null) {
            str = null;
        } else {
            str = feeValue.getLabel();
        }
        if (feeValue == null) {
            str2 = null;
        } else {
            str2 = feeValue.getFormattedValue();
        }
        if (feeValue == null) {
            str3 = null;
        } else {
            str3 = feeValue.getTagLabel();
        }
        if (feeValue != null) {
            str4 = feeValue.getStandardFee();
        }
        this.deliveryChargesText.setText(str);
        if (str3 != null) {
            TextView textView = this.deliveryChargesValue;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            this.deliveryChargesValue.setText(str4);
            this.deliveryFirstOrder.setTitle(str3);
            this.deliveryFirstOrder.setVisibility(0);
            return;
        }
        this.deliveryFirstOrder.setVisibility(8);
        this.deliveryChargesValue.setText(str2);
    }

    private void showErrorNotification() {
        onSendTrackingEvent("", "", getString(R.string.sorry_something_went_wrong));
        cancelLoader();
        Status.Companion.notify(this, this.paymentLayoutView, getString(R.string.sorry_something_went_wrong));
    }

    private void showKNetFallbackView() {
        this.checkoutPresenter.hideProgress();
        this.paymentLayoutView.setVisibility(0);
        this.debitLayout.setVisibility(8);
        this.kNetDebitCardLayout.setVisibility(0);
        this.unAvailableKNetMessageView.setVisibility(0);
        this.unAvailableKNetView.setVisibility(0);
    }

    private void showPopUpErrorDialog(BNPLOrderPaymentState.BNPLPaymentError bNPLPaymentError) {
        onSendTrackingEvent(bNPLPaymentError.getBNPLOrderPaymentError().getCode(), bNPLPaymentError.getBNPLOrderPaymentError().getTitle(), bNPLPaymentError.getBNPLOrderPaymentError().getDescription());
        cancelLoader();
        new BNPLOrderPaymentErrorDialog(this, bNPLPaymentError.getBNPLOrderPaymentError(), this).show((ViewGroup) findViewById(R.id.checkout_parent));
    }

    private void showQPayFallbackView() {
        this.checkoutPresenter.hideProgress();
        this.debitLayout.setVisibility(8);
        this.paymentLayoutView.setVisibility(0);
        this.unAvailableQPayView.setVisibility(0);
        this.qPayDebitCardLayout.setVisibility(0);
        this.unAvailableQPayMessageView.setVisibility(0);
        SavedCardRecyclerViewAdapter savedCardRecyclerViewAdapter = this.mAdapter;
        if (savedCardRecyclerViewAdapter != null) {
            savedCardRecyclerViewAdapter.updateList(Customer.getInstance().getSavedCards());
        }
    }

    private void showSoftPosView() {
        if (isSoftPosEnabledRestaurant()) {
            this.softPOSView.setVisibility(0);
        } else {
            this.softPOSView.setVisibility(8);
        }
    }

    private static com.google.android.gms.maps.model.LatLng toGoogle(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new com.google.android.gms.maps.model.LatLng(latLng.getLatitude(), latLng.getLongitude());
    }

    private void triggerFeesUpdate() {
        this.f53825a0.onSubtotalChanged(Cart.getInstance().getCartSubTotalBeforeDiscounts(), Cart.getInstance().getCartSubTotal(), Cart.getInstance().getCouponDiscount(), GlobalDataModel.LATLONGFORAPI.getLatitudeDouble().doubleValue(), GlobalDataModel.LATLONGFORAPI.getLongitudeDouble().doubleValue());
    }

    private void updateAmountDisplay(Boolean bool) {
        if (!(this.checkoutPresenter == null || this.cart.getRestaurant() == null)) {
            this.checkoutPresenter.setTaxAndDelivery(bool);
        }
        setTotalAmount();
    }

    /* access modifiers changed from: private */
    public void updateBNPLOrderPaymentResult(BNPLOrderPaymentState bNPLOrderPaymentState) {
        if (bNPLOrderPaymentState instanceof BNPLOrderPaymentState.ServerError) {
            showErrorNotification();
        } else if (bNPLOrderPaymentState instanceof BNPLOrderPaymentState.BNPLPaymentError) {
            showPopUpErrorDialog((BNPLOrderPaymentState.BNPLPaymentError) bNPLOrderPaymentState);
        } else if (bNPLOrderPaymentState instanceof BNPLOrderPaymentState.BNPLPaymentSuccess) {
            navigateToOrderSuccessScreen(this.bnplManagerViewModel.getOrderResponse());
        }
    }

    /* access modifiers changed from: private */
    public void updateBNPLPopView(BNPLPopUpViewState bNPLPopUpViewState) {
        String str;
        if (bNPLPopUpViewState instanceof BNPLPopUpViewState.BNPLPlanPopUp) {
            if (this.checkoutPresenter.isFlutterBNPLCheckoutEnabled()) {
                BNPLPopUpViewState.BNPLPlanPopUp bNPLPlanPopUp = (BNPLPopUpViewState.BNPLPlanPopUp) bNPLPopUpViewState;
                this.bnplPlan = bNPLPlanPopUp.getPlan();
                boolean isChangeCardClicked = bNPLPlanPopUp.isChangeCardClicked();
                boolean isPaymentFallbackFlow = bNPLPlanPopUp.isPaymentFallbackFlow();
                String id2 = this.bnplPlan.getId();
                if (Cart.getInstance() != null) {
                    str = Float.toString(Cart.getInstance().getCartTotalPaymentPrice());
                } else {
                    str = "0";
                }
                new BNPLCheckoutFlutterBottomSheet(this, id2, str, isChangeCardClicked, isPaymentFallbackFlow).show();
                return;
            }
            BNPLPlaceOrderBottomSheet bNPLPlaceOrderBottomSheet = new BNPLPlaceOrderBottomSheet(this, ((BNPLPopUpViewState.BNPLPlanPopUp) bNPLPopUpViewState).getPlan(), this, this.checkoutPresenter.getDefaultPaymentMethod());
            this.bnplPlaceOrderBottomSheet = bNPLPlaceOrderBottomSheet;
            bNPLPlaceOrderBottomSheet.show();
        } else if (bNPLPopUpViewState instanceof BNPLPopUpViewState.BNPLErrorPopUp) {
            BNPLValidationError bNPLValidationError = ((BNPLPopUpViewState.BNPLErrorPopUp) bNPLPopUpViewState).getBNPLValidationError();
            this.bnplManagerViewModel.onBNPLErrorEventLoaded(bNPLValidationError, BNPLTrackerImplKt.BNPL_CHECKOUT_ERROR_VALIDATION_EVENT_NAME);
            BNPLEligibilityErrorDialog bNPLEligibilityErrorDialog = new BNPLEligibilityErrorDialog(bNPLValidationError);
            bNPLEligibilityErrorDialog.showNow(getSupportFragmentManager(), "");
            bNPLEligibilityErrorDialog.getDialog().setOnDismissListener(new m2(this));
        } else {
            this.K.trackUnExpectedScenario("unexpected BNPLPopUpViewState display model", new HashMap());
        }
    }

    /* access modifiers changed from: private */
    public void updateBNPLWidget(BNPLPlanEligibilityState bNPLPlanEligibilityState) {
        if (bNPLPlanEligibilityState instanceof BNPLPlanEligibilityState.BNPLDeferredPlanError) {
            showBNPLEligibilityErrorIcon();
            showBNPLDeferredView(((BNPLPlanEligibilityState.BNPLDeferredPlanError) bNPLPlanEligibilityState).getPlan().getPaymentCycleInDays());
        } else if (bNPLPlanEligibilityState instanceof BNPLPlanEligibilityState.BNPLInstallmentPlanError) {
            showBNPLEligibilityErrorIcon();
            BNPLPlanEligibilityState.BNPLInstallmentPlanError bNPLInstallmentPlanError = (BNPLPlanEligibilityState.BNPLInstallmentPlanError) bNPLPlanEligibilityState;
            showBNPLInstallmentView(bNPLInstallmentPlanError.getPlan().getPaymentCycles(), bNPLInstallmentPlanError.getInstallmentAmount());
        } else if (bNPLPlanEligibilityState instanceof BNPLPlanEligibilityState.BNPLDeferredPlan) {
            showBNPLDeferredView(((BNPLPlanEligibilityState.BNPLDeferredPlan) bNPLPlanEligibilityState).getPlan().getPaymentCycleInDays());
        } else if (bNPLPlanEligibilityState instanceof BNPLPlanEligibilityState.BNPLInstallmentPlan) {
            BNPLPlanEligibilityState.BNPLInstallmentPlan bNPLInstallmentPlan = (BNPLPlanEligibilityState.BNPLInstallmentPlan) bNPLPlanEligibilityState;
            showBNPLInstallmentView(bNPLInstallmentPlan.getPlan().getPaymentCycles(), bNPLInstallmentPlan.getInstallmentAmount());
        } else {
            this.bNPLLayoutView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void updateBinVoucherData(CheckoutBinVoucherState checkoutBinVoucherState) {
        if (checkoutBinVoucherState instanceof CheckoutBinVoucherState.FetchDiscountedCartPrice) {
            this.checkoutPresenter.checkForBinVoucher(((CheckoutBinVoucherState.FetchDiscountedCartPrice) checkoutBinVoucherState).getBinRequest());
            this.checkoutPresenter.showProgress();
        } else if (checkoutBinVoucherState instanceof CheckoutBinVoucherState.HideBinView) {
            removeBin();
            this.checkoutBinVoucherViewModel.setBinVoucherRequestFromBNPL(false);
            BNPLPlaceOrderBottomSheet bNPLPlaceOrderBottomSheet = this.bnplPlaceOrderBottomSheet;
            if (bNPLPlaceOrderBottomSheet != null) {
                bNPLPlaceOrderBottomSheet.updateBNPLPaymentDetail();
            }
        } else {
            this.K.trackUnExpectedScenario("unexpected CheckoutBinVoucherState display model", new HashMap());
        }
    }

    /* access modifiers changed from: private */
    public void updateCheckoutPaymentView(CheckoutPaymentUpdateDisplayModel checkoutPaymentUpdateDisplayModel) {
        if (checkoutPaymentUpdateDisplayModel.equals(CheckoutPaymentUpdateDisplayModel.Loading.INSTANCE)) {
            this.K.trackEvent("kNet fallback", ApiStatus.LOADING, (Map<String, String>) new HashMap());
        } else if (checkoutPaymentUpdateDisplayModel.equals(CheckoutPaymentUpdateDisplayModel.ShowKNetPaymentOption.INSTANCE)) {
            this.checkoutPresenter.hideProgress();
            this.paymentLayoutView.setVisibility(0);
            this.debitCard.performClick();
        } else if (checkoutPaymentUpdateDisplayModel.equals(CheckoutPaymentUpdateDisplayModel.ShowQPayPaymentOption.INSTANCE)) {
            this.debitLayout.setVisibility(0);
            this.checkoutPresenter.hideProgress();
            this.paymentLayoutView.setVisibility(0);
        } else if (checkoutPaymentUpdateDisplayModel instanceof CheckoutPaymentUpdateDisplayModel.HideQPayPaymentOption) {
            this.debitLayout.setVisibility(8);
            this.checkoutPresenter.hideProgress();
            this.paymentLayoutView.setVisibility(0);
        } else if (checkoutPaymentUpdateDisplayModel.equals(CheckoutPaymentUpdateDisplayModel.ShowKNetFallback.INSTANCE)) {
            showKNetFallbackView();
        } else if (checkoutPaymentUpdateDisplayModel.equals(CheckoutPaymentUpdateDisplayModel.ShowQPayFallback.INSTANCE)) {
            showQPayFallbackView();
        } else if (checkoutPaymentUpdateDisplayModel instanceof CheckoutPaymentUpdateDisplayModel.ShowBenefitBinsInfo) {
            displayBenefitDeflectionViews(checkoutPaymentUpdateDisplayModel);
        } else if (checkoutPaymentUpdateDisplayModel instanceof CheckoutPaymentUpdateDisplayModel.ShowQPayBinsInfo) {
            this.debitLayout.setVisibility(0);
            this.checkoutPresenter.hideProgress();
            this.paymentLayoutView.setVisibility(0);
            displayQPayDeflectionViews(checkoutPaymentUpdateDisplayModel);
        } else {
            this.paymentLayoutView.setVisibility(0);
            this.checkoutPresenter.hideProgress();
        }
    }

    private void updateDeliveryFeeVisibility(boolean z11, boolean z12) {
        int i11 = 0;
        if (!(!z11 && !z12)) {
            i11 = 8;
        }
        this.deliveryChargesView.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public void updateOpenForceCVVBottomSheetStatus(boolean z11) {
        if (z11) {
            this.checkoutPresenter.setCvv("", false);
            this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(true);
            return;
        }
        this.checkoutPresenter.setCvv("", false);
        this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(false);
    }

    /* access modifiers changed from: private */
    public void updatePayProxyData(SendCVVToProxyDisplayModel sendCVVToProxyDisplayModel) {
        if (sendCVVToProxyDisplayModel instanceof SendCVVToProxyDisplayModel.ContinueWithAdyenPayment) {
            this.checkoutPresenter.continueWithAdyenPayment(((SendCVVToProxyDisplayModel.ContinueWithAdyenPayment) sendCVVToProxyDisplayModel).getRecurringPurchaseRequest());
        } else if (sendCVVToProxyDisplayModel instanceof SendCVVToProxyDisplayModel.ContinueWithCheckoutPayment) {
            this.checkoutPresenter.continueWithCheckoutPayment(((SendCVVToProxyDisplayModel.ContinueWithCheckoutPayment) sendCVVToProxyDisplayModel).getRecurringPurchaseRequest());
        } else if (sendCVVToProxyDisplayModel instanceof SendCVVToProxyDisplayModel.CVVSentFailure) {
            onCheckoutDotComRecurringFailed("sending cvv to proxy failed");
        } else {
            this.K.trackEvent("cvv to proxy", ApiStatus.LOADING, (Map<String, String>) new HashMap());
        }
    }

    /* access modifiers changed from: private */
    public void updatePaymentMethod(PaymentButtonTypeDisplayModel paymentButtonTypeDisplayModel) {
        if (paymentButtonTypeDisplayModel instanceof PaymentButtonTypeDisplayModel.PaymentWithDebitCard) {
            placeOrderWithDebitCard();
        }
    }

    /* access modifiers changed from: private */
    public void updateProceedToPayment(ProceedToPaymentDisplayModel proceedToPaymentDisplayModel) {
        if (proceedToPaymentDisplayModel instanceof ProceedToPaymentDisplayModel.PayRemainingAmount) {
            this.checkoutPresenter.payRemainingWithCreditCard();
            this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(true);
        } else if (proceedToPaymentDisplayModel instanceof ProceedToPaymentDisplayModel.PayFullAmount) {
            this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(false);
            this.f53833n.performClick();
            this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(true);
        }
    }

    /* access modifiers changed from: private */
    public void updateSavedCardAdapter() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Customer.getInstance().getSavedCards());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TokenisationCreditCard tokenisationCreditCard = (TokenisationCreditCard) it.next();
            if (tokenisationCreditCard.isBinDiscountValid) {
                tokenisationCreditCard.isBinDiscountValid = false;
            }
        }
        Customer.getInstance().setSavedCreditCards((TokenisationCreditCard[]) arrayList.toArray(new TokenisationCreditCard[arrayList.size()]));
        ArrayList<TokenisationCreditCard> arrayList2 = GlobalDataModel.BIN.savedTokens;
        if (arrayList2 != null && arrayList2.size() > 0) {
            GlobalDataModel.BIN.savedTokens.clear();
        }
        GlobalDataModel.BIN.savedTokens = Customer.getInstance().getSavedCards();
        this.mAdapter.updateList(Customer.getInstance().getSavedCards());
        this.mAdapter.notifyDataSetChanged();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0022, code lost:
        if (r3 == 3) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateTextColor() {
        /*
            r6 = this;
            r0 = 4
            int[] r1 = new int[r0]
            r1 = {2131100013, 2131100014, 2131100015, 2131100016} // fill-array
            buisnessmodels.GEMEngine r2 = buisnessmodels.GEMEngine.getInstance()
            int r2 = r2.getCurrentGemIndex()
            buisnessmodels.GEMEngine r3 = buisnessmodels.GEMEngine.getInstance()
            int r3 = r3.getGemCount()
            r4 = 2
            if (r2 == r4) goto L_0x0025
            r5 = 3
            if (r2 == r5) goto L_0x0022
            if (r2 == r0) goto L_0x0020
            r4 = 0
            goto L_0x0026
        L_0x0020:
            r4 = r5
            goto L_0x0026
        L_0x0022:
            if (r3 != r5) goto L_0x0026
            goto L_0x0020
        L_0x0025:
            r4 = 1
        L_0x0026:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = ""
            r0.append(r2)
            r0.append(r4)
            android.widget.TextView r0 = r6.gemOfferText
            android.content.res.Resources r2 = r6.getResources()
            r3 = r1[r4]
            int r2 = r2.getColor(r3)
            r0.setTextColor(r2)
            android.widget.TextView r0 = r6.gemOfferValue
            android.content.res.Resources r2 = r6.getResources()
            r1 = r1[r4]
            int r1 = r2.getColor(r1)
            r0.setTextColor(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.CheckOutScreen.updateTextColor():void");
    }

    /* access modifiers changed from: private */
    public void updateWalletBalanceView(WalletBalanceDisplayModel walletBalanceDisplayModel) {
        if (walletBalanceDisplayModel.equals(WalletBalanceDisplayModel.ShowPaymentMethods.INSTANCE)) {
            this.checkoutPresenter.setUpViews(this.isQuick, this.isGrlEnabled, this.isGlrEnableAddNewAddress, this.isEditAddressFromCheckoutScreen);
            onPaymentMethodUpdated();
        } else if (walletBalanceDisplayModel.equals(WalletBalanceDisplayModel.LoadingWalletBalance.INSTANCE)) {
            this.checkoutPresenter.showProgress();
        } else {
            this.K.trackUnExpectedScenario("unexpected wallet balance display model state", new HashMap());
        }
    }

    /* access modifiers changed from: private */
    public void voucherApplied(VoucherData voucherData) {
        LoyaltyVoucherResult layoutVoucherResult = VoucherDataKt.toLayoutVoucherResult(voucherData);
        LoyaltyVoucherRM loyaltyVoucherRM = new LoyaltyVoucherRM();
        loyaltyVoucherRM.result = layoutVoucherResult;
        Cart.getInstance().saveLoyaltyVoucher(getContext(), loyaltyVoucherRM);
        Cart.getInstance().calculateLoyaltyDiscount(getContext());
        this.checkoutPresenter.updateLoyaltyInfo(loyaltyVoucherRM);
    }

    public void OnCurrentLocationPermissionStatus(@NotNull PermissionDeniedResponse permissionDeniedResponse) {
    }

    @NonNull
    public ICheckoutPresenter P1(PlaceOrderPresenter placeOrderPresenter) {
        AppVersionProvider appVersionProvider = this.D;
        PaymentConfigurationRepository paymentConfigurationRepository = this.I;
        PlaceOrderIdProviderImp placeOrderIdProviderImp = r6;
        PlaceOrderIdProviderImp placeOrderIdProviderImp2 = new PlaceOrderIdProviderImp(getApplication());
        return new CheckoutPresenter(this, appVersionProvider, paymentConfigurationRepository, placeOrderPresenter, placeOrderIdProviderImp, TalabatExperiment.INSTANCE, this.Q, this.L, getTalabatTracker(), this.E, this.G, this.N, this.O, this.V, this.X, this.Z, this.Y, this.M);
    }

    public void Q1() {
        if (this.checkoutPresenter.shouldShowPickupConfirmationDialog(this.F.getRepository().isFirstPickupOrder())) {
            String threeLetterCode = this.E.selectedCountry().getThreeLetterCode();
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            getTalabatTracker().track(new PopupLoaded(restaurant, threeLetterCode));
            PickupConfirmationDialogView.Companion.showPickupConfirmationDialog((ViewGroup) findViewById(R.id.checkout_parent), this, new a5(this, restaurant, threeLetterCode));
            return;
        }
        proceedWithPlaceOrder();
    }

    public void R1() {
        Cart.getInstance().setRiderTip(0.0d);
    }

    public void S1() {
        if (isDarkStore()) {
            new DarkstoresSharedPreferencesHelper(this).resetDsCart();
        }
    }

    public void addNewCard() {
    }

    public void adjustGemView() {
        showHideGemFooter(this.f53834o, this, false);
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow || GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice <= 0.0f) {
            this.gemDiscountView.setVisibility(8);
        } else {
            this.gemDiscountView.setVisibility(0);
        }
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

    public void applyBinVoucherViews(float f11, String str, float f12) {
        applyBin(f11, str, f12);
        stopNonCancelableLoading();
    }

    public void callPaymentErrorIntent() {
        stopNonCancelableLoading();
        this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(false);
        Intent intent = new Intent(this, PaymentErrorScreen.class);
        intent.putExtra("isFromVisaCheckout", true);
        intent.putExtra("isGateWayError", this.isGateWayError);
        intent.putExtra("paymentMethod", 2);
        intent.putExtra("encryptedTransactionIdError", this.transactionId);
        this.launcher.launch(intent);
        resetVisaCheckoutInstance();
    }

    public void cancelLoader() {
        stopNonCancelableLoading();
    }

    public void clearCvv() {
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (iCheckoutPresenter != null) {
            iCheckoutPresenter.setCvv("", false);
        }
    }

    public String currencyForVisaCheckout() {
        int i11 = GlobalDataModel.SelectedCountryId;
        return i11 != 2 ? i11 != 4 ? i11 != 6 ? PurchaseInfo.Currency.KWD : PurchaseInfo.Currency.QAR : PurchaseInfo.Currency.AED : PurchaseInfo.Currency.SAR;
    }

    public void deleteAllSavedCardList() {
    }

    public void deleteCardFail(String str) {
    }

    public void destroyPresenter() {
        this.checkoutPresenter = null;
    }

    public void doNotExpectBin() {
        this.binResponseReceived = true;
        this.waitingForBinResponse = false;
    }

    public void enableTalabatCreditCashbackView() {
        float f11;
        if (!isCashbackEnabledCountry() || !isTalabatCreditAvaialable()) {
            this.cashbackFeatureView.setVisibility(8);
            return;
        }
        this.cashbackFeatureView.setVisibility(0);
        this.cashbackProgressBar.setIndeterminate(true);
        this.cashbackProgressBar.setVisibility(0);
        this.cashbackText.setVisibility(8);
        this.cashbackAvailableCredit.setText(TalabatFormatter.getInstance().getFormattedCurrency(Customer.getInstance().getCustomerInfo().talabatCredit));
        float cartTotalPaymentPrice = this.cart.getCartTotalPaymentPrice();
        if (Customer.getInstance() == null || !Customer.getInstance().isLoggedIn(getContext()) || Customer.getInstance().getCustomerInfo() == null) {
            f11 = 0.0f;
        } else {
            f11 = Customer.getInstance().getCustomerInfo().talabatCredit;
        }
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (f11 < cartTotalPaymentPrice) {
            cartTotalPaymentPrice = f11;
        }
        iCheckoutPresenter.callCashBackApi(cartTotalPaymentPrice);
        this.cashbackText.setVisibility(8);
        this.checkoutPresenter.setCashBackAvailable(false);
    }

    public void fetchCurrentLocation() {
        if (this.f53839t == null) {
            this.f53839t = new CurrentLocationFetchRefactor(this, this);
        }
        if (this.f53839t.userAllowedAllLocationPermissions(this)) {
            this.f53839t.initLocationRequest(this);
            this.f53839t.fetchCurrentGpsLocation();
        }
    }

    public boolean getBinCampaignStatus() {
        return getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getBoolean("BinCampaignUserGuide", false);
    }

    public Context getContext() {
        return this;
    }

    public void getCvvForSavedCard(boolean z11) {
        showCVVPopup(z11);
    }

    public boolean getDarkStoreStatus() {
        return isDarkStore();
    }

    public String getDeliveryTime() {
        DeliverySlotContent deliverySlotContent;
        View view = this.postDateDelivery;
        if (view instanceof CheckoutOrderTimeSelectorView) {
            if (((CheckoutOrderTimeSelectorView) view).getMode() != CheckoutOrderTimeSelectorView.Mode.SCHEDULE_LATER || (deliverySlotContent = this.selectedDeliverySlot) == null) {
                return "";
            }
            return deliverySlotContent.getSlotTime();
        } else if (TalabatUtils.isNullOrEmpty(this.f53842w)) {
            return "";
        } else {
            return this.f53842w;
        }
    }

    public String getFirstName() {
        return this.firstName;
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

    public String getLastName() {
        return this.lastName;
    }

    public String getMobileForBin() {
        if (!TalabatUtils.isNullOrEmpty(this.mobileForBin)) {
            return this.mobileForBin;
        }
        if (!TalabatUtils.isNullOrEmpty(this.mobileNumber.getText().toString().replace(getString(R.string.address_mobile), "").trim())) {
            return this.mobileNumber.getText().toString().replace(getString(R.string.address_mobile), "").trim();
        }
        return "";
    }

    public String getNormalVoucherText() {
        return getResources().getString(R.string.dicount_voucher);
    }

    public IGlobalPresenter getPresenter() {
        return this.checkoutPresenter;
    }

    public Profile getProfile() {
        String str;
        String visaCheckoutPublicKey = this.I.config().getVisaCheckoutPublicKey();
        if (BuildConfigType.ThirdPartyToolsProductionMode()) {
            str = Environment.PRODUCTION;
        } else {
            str = Environment.SANDBOX;
        }
        return new Profile.ProfileBuilder(visaCheckoutPublicKey, str).setProfileName("TAndroid").setDisplayName("Talabat").setDataLevel(Profile.DataLevel.FULL).setCardBrands(new String[]{"VISA", "MASTERCARD", Profile.CardBrand.ELECTRON}).build();
    }

    public PurchaseInfo getPurchaseInfo() {
        return new PurchaseInfo.PurchaseInfoBuilder(new BigDecimal((double) this.cart.getCartTotalPrice()), currencyForVisaCheckout()).setUserReviewAction(PurchaseInfo.UserReviewAction.CONTINUE).setShippingAddressRequired(false).setSubTotal(new BigDecimal((double) this.cart.getCartTotalPrice())).setReviewMessage(getString(R.string.visa_checkout_review_message)).build();
    }

    public String getRequestedBinNumber() {
        return this.requestedBinNumber;
    }

    public String getScreenName() {
        return "Checkout Screen";
    }

    public String getSelectedCardName() {
        return this.selectedCardName;
    }

    public int getSelectedPaymentMethod() {
        return this.selectedPaymentMethod;
    }

    public int getTokenProvider() {
        return TalabatUtils.getSelectedCountry(this.E, this.G).tokenisationProvider;
    }

    @VisibleForTesting
    public TokenisationCreditCard getTokenisationCreditCard() {
        return this.selectedItem;
    }

    public Context getcontext() {
        return this;
    }

    public void handleWithCreditCard(float f11, final String str, final String str2) {
        this.balanceAmountToPay = f11;
        this.transactionId = str;
        this.encryptedOrderId = str2;
        if (!this.V.isLoggedIn() || !this.V.hasSavedCards()) {
            ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
            if (iCheckoutPresenter != null) {
                onCallCheckoutDotCom(str, true, iCheckoutPresenter.getPlaceOrderRequestModel(), this.checkoutPresenter.isTalabatDelVoucher(), this.checkoutPresenter.getHideAddCardStatus(), str2);
                return;
            }
            return;
        }
        int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenWidth = i11;
        this.popupWidth = i11 - (((int) getResources().getDimension(R.dimen.card_popup_outer_margin)) * 2);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.popupWidth, -2);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.card_list_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(this);
        this.cardListDialog = dialog;
        dialog.setContentView(inflate, layoutParams);
        this.cardListDialog.setTitle("");
        RecyclerView recyclerView = (RecyclerView) this.cardListDialog.findViewById(R.id.items_recyclerView);
        this.dialogRecyclerView = recyclerView;
        recyclerView.setNestedScrollingEnabled(false);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.dialogRecyclerView.setLayoutManager(linearLayoutManager);
        ((TextView) this.cardListDialog.findViewById(R.id.header_pay_with_string)).setText(getResources().getString(R.string.pay_remaining_amount_with).replace(RichContentLoadTimeRecorder.DELIMETER, TalabatFormatter.getInstance().getFormattedCurrency(f11)));
        this.confirmChoice = (Button) this.cardListDialog.findViewById(R.id.confirm);
        this.closePopup = (ImageView) this.cardListDialog.findViewById(R.id.close_popup_button);
        this.confirmChoice.setEnabled(false);
        this.confirmChoice.setAlpha(0.5f);
        SelectCardDialogAdapter selectCardDialogAdapter2 = new SelectCardDialogAdapter(this.tokenisationCreditCards);
        this.selectCardDialogAdapter = selectCardDialogAdapter2;
        selectCardDialogAdapter2.setSelectCardDialogAdapterInterface(this);
        this.dialogRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        this.dialogRecyclerView.setAdapter(this.selectCardDialogAdapter);
        this.closePopup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckOutScreen.this.stopLodingPopup();
                CheckOutScreen.this.resetPaymentViews();
                CheckOutScreen.this.cardListDialog.dismiss();
            }
        });
        this.confirmChoice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (CheckOutScreen.this.selectedItem != null && !TalabatUtils.isNullOrEmpty(CheckOutScreen.this.selectedItem.token)) {
                    if (CheckOutScreen.this.selectedItem.token.equals("new card")) {
                        CheckOutScreen.this.cardListDialog.dismiss();
                        if (CheckOutScreen.this.checkoutPresenter != null) {
                            CheckOutScreen checkOutScreen = CheckOutScreen.this;
                            checkOutScreen.onCallCheckoutDotCom(str, true, checkOutScreen.checkoutPresenter.getPlaceOrderRequestModel(), CheckOutScreen.this.checkoutPresenter.isTalabatDelVoucher(), CheckOutScreen.this.checkoutPresenter.getHideAddCardStatus(), str2);
                            return;
                        }
                        return;
                    }
                    CheckOutScreen.this.cardListDialog.dismiss();
                    CheckOutScreen.this.startLodingPopup();
                    if (CheckOutScreen.this.checkoutPresenter != null) {
                        Customer.getInstance().setSelectedCreditCard(CheckOutScreen.this.selectedItem);
                        CheckOutScreen.this.checkoutForceCVVVViewModel.onPayRemainingWithCredit();
                    }
                }
            }
        });
        this.cardListDialog.setCancelable(false);
        this.cardListDialog.show();
        stopNonCancelableLoading();
    }

    public void hideBinAvailableNotification() {
        if (this.binOffersView.getVisibility() != 8) {
            closeBinOffers();
        }
    }

    public void hideLoader() {
        this.checkoutPresenter.hideProgress();
    }

    public void hideRiderTipCharges() {
        this.riderTipChargesView.setVisibility(8);
    }

    public void hideRiderTipView() {
        findViewById(R.id.rider_tip_container).setVisibility(8);
        RiderTipView riderTipView2 = this.riderTipView;
        if (riderTipView2 != null) {
            riderTipView2.disableRiderTip();
        }
    }

    public void hideShowCurreAwareness() {
        View view = this.mCurrentLocationAwarenessTxt;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void hideTProSubscriptionBanner(Boolean bool) {
        HashMap hashMap = new HashMap();
        if (!bool.booleanValue()) {
            this.C.setVisibility(0);
            this.C.showSubscriptionAtCheckoutBannerView();
            this.C.setOnCheckedChangeListenerForCheckout(new m4(this, hashMap));
            this.C.setTermsAndConditionsClick(new n4(this));
            return;
        }
        this.C.hideSubscriptionAtCheckoutBannerView();
        arrangeViewsForTproUnchecked();
    }

    public void hideTalabatCreditView() {
        this.talabatCreditView.setVisibility(8);
    }

    public void inflateGemFooter() {
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            this.f53834o = new GemFooterCartView();
            if (GEMEngine.getInstance() != null) {
                GEMEngine.getInstance().startListening(this, false);
            }
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
            beginTransaction.add((int) R.id.gem_footer_view, (Fragment) this.f53834o, getScreenName());
            beginTransaction.commit();
        }
    }

    public void initRiderTipView() {
        RiderTipView riderTipView2 = (RiderTipView) ((ViewStub) findViewById(R.id.rider_tip_stub)).inflate();
        this.riderTipView = riderTipView2;
        riderTipView2.setOnRiderTipValueChange(new l4(this));
    }

    public void initialiseVisaCheckout() {
        if (BuildConfigType.ThirdPartyToolsProductionMode()) {
            this.visaCheckoutButton.init(this, getProfile(), getPurchaseInfo(), new VisaCheckoutSdk.VisaCheckoutResultListener() {
                public void onButtonClick(VisaCheckoutSdk.VisaCheckoutResultListener.LaunchReadyHandler launchReadyHandler) {
                    launchReadyHandler.launch();
                }

                public void onResult(VisaPaymentSummary visaPaymentSummary) {
                    String str;
                    CheckOutScreen.this.adjustGemView();
                    if (VisaPaymentSummary.PAYMENT_SUCCESS.equalsIgnoreCase(visaPaymentSummary.getStatusName())) {
                        GlobalDataModel.callId = visaPaymentSummary.getCallId();
                        CheckOutScreen.this.isFromVisaCheckout = true;
                        CheckOutScreen checkOutScreen = CheckOutScreen.this;
                        if (!TalabatUtils.isNullOrEmpty(visaPaymentSummary.getLastFourDigits())) {
                            str = "xxxx-" + visaPaymentSummary.getLastFourDigits();
                        } else {
                            str = "";
                        }
                        checkOutScreen.lastFour = str;
                        CheckOutScreen.this.checkoutPresenter.getDecryptedData(visaPaymentSummary.getEncKey(), visaPaymentSummary.getEncPaymentData());
                        if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.callId)) {
                            CheckOutScreen.this.f53833n.performClick();
                        }
                    } else if (VisaPaymentSummary.PAYMENT_CANCEL.equalsIgnoreCase(visaPaymentSummary.getStatusName())) {
                        CheckOutScreen.this.resetPaymentViews();
                        CheckOutScreen.this.f53835p = "User Canceled";
                    } else if (VisaPaymentSummary.PAYMENT_ERROR.equalsIgnoreCase(visaPaymentSummary.getStatusName())) {
                        CheckOutScreen checkOutScreen2 = CheckOutScreen.this;
                        checkOutScreen2.f53835p = "Purchase failed!";
                        checkOutScreen2.isGateWayError = true;
                    } else if (VisaPaymentSummary.PAYMENT_FAILURE.equalsIgnoreCase(visaPaymentSummary.getStatusName())) {
                        CheckOutScreen.this.resetPaymentViews();
                        CheckOutScreen checkOutScreen3 = CheckOutScreen.this;
                        checkOutScreen3.f53835p = "Purchase failed!";
                        checkOutScreen3.isGateWayError = true;
                        CheckOutScreen.this.callPaymentErrorIntent();
                    }
                }
            });
        }
    }

    @VisibleForTesting
    public boolean isBinApplied() {
        return this.binApplied;
    }

    public boolean isBinDiscountApplied() {
        return this.isBinDiscountAppliedForTracking;
    }

    public boolean isContactlessEnabled() {
        return this.contactLessSelector.isChecked();
    }

    public boolean isForceCvvDialogShown() {
        Dialog dialog = this.forceCvvDialog;
        return dialog != null && dialog.isShowing();
    }

    public boolean isFromVisaCheckout() {
        return this.isFromVisaCheckout;
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public boolean isPickUp() {
        return this.checkoutPresenter.isPickup();
    }

    public boolean isSavedCardSelected() {
        return this.savedCardSelected;
    }

    public void makePaymentForPlaceOrder() {
        hideLoader();
        LogManager.debug("[ALOV]: proceedWithPlaceOrder");
        if (SystemClock.elapsedRealtime() - this.mLastClickTime < PaymentWidgetBottomSheetFragmentKt.DURATION_DELAY_DURING_FAILURE) {
            LogManager.debug("[ALOV]: proceedWithPlaceOrder :: elapse");
            return;
        }
        LogManager.debug("[ALOV]: proceedWithPlaceOrder :: enter");
        this.checkoutPresenter.onRiderTipClosed();
        this.mLastClickTime = SystemClock.elapsedRealtime();
        if (this.bNPLRadioButton.isChecked() && this.bnplManagerViewModel.isBNPLPlaceOrderClicked()) {
            LogManager.debug("[ALOV]: proceedWithPlaceOrder :: bnpl clicked");
            this.bnplManagerViewModel.setBNPLPlaceOrderClicked(false);
            placeOrderTrigger();
        } else if (this.bNPLRadioButton.isChecked()) {
            LogManager.debug("[ALOV]: proceedWithPlaceOrder :: bnpl");
            this.checkoutPaymentUpdateViewModel.onBNPLWidgetClicked(false, false);
        } else if (this.checkoutForceCVVVViewModel.getShouldOpenForceCVVBottomSheet()) {
            LogManager.debug("[ALOV]: proceedWithPlaceOrder :: force CVV");
            openForceCVVBottomSheet(Customer.getInstance().getSelectedCreditCard());
        } else if (this.savedCardSelected) {
            LogManager.debug("[ALOV]: proceedWithPlaceOrder :: save card");
            if (this.binResponseReceived) {
                LogManager.debug("[ALOV]: proceedWithPlaceOrder :: save card :: bin");
                placeOrderTrigger();
            } else {
                LogManager.debug("[ALOV]: proceedWithPlaceOrder :: save card :: other");
                this.waitingForBinResponse = true;
                startLodingPopup();
            }
        } else {
            LogManager.debug("[ALOV]: proceedWithPlaceOrder :: other");
            placeOrderTrigger();
        }
        LogManager.debug("[ALOV]: proceedWithPlaceOrder :: exit");
    }

    public void navigateToOrderSuccessScreen(PlaceOrderResponse placeOrderResponse) {
        onOrderSucess(placeOrderResponse);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        String str;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 300) {
            if (i12 == -1) {
                this.checkoutPresenter.paymentSuccessfull();
            } else if (i12 == 100) {
                handlePaymenError(intent);
            }
        } else if (i11 == 100) {
            if (i12 == -1) {
                this.checkoutPresenter.onNewAddressSelected(true);
                this.checkoutPresenter.currentLoactionAwareness(toGoogle(this.currentLocation));
            }
        } else if (i11 == 302) {
            this.verificationPopupShown = false;
            if (i12 == -1) {
                boolean booleanExtra = intent.getBooleanExtra("isUpdateCheckOut", false);
                this.f53830k = booleanExtra;
                if (booleanExtra) {
                    if (this.isQuick) {
                        QuickOrderInfo savedQuickOrderAddressData = getSavedQuickOrderAddressData();
                        this.f53832m = savedQuickOrderAddressData;
                        Gson gson = UniversalGson.INSTANCE.gson;
                        if (!(gson instanceof Gson)) {
                            str = gson.toJson((Object) savedQuickOrderAddressData);
                        } else {
                            str = GsonInstrumentation.toJson(gson, (Object) savedQuickOrderAddressData);
                        }
                        this.f53831l = str;
                        QuickOrderInfo quickOrderInfo = this.f53832m;
                        if (quickOrderInfo != null) {
                            this.checkoutPresenter.setAddress(quickOrderInfo.address);
                        }
                    }
                    this.checkoutPresenter.removeVoucher();
                    this.checkoutPresenter.onMobileNumberUpdate(intent.getStringExtra("updatedMobileNo"));
                }
            }
        } else if (i11 != 303) {
            if (i11 == 305) {
                if (i12 == -1) {
                    finish();
                } else if (i12 == 100) {
                    this.benefitManagerViewModel.setDebitCardDeflectedShown(intent.getBooleanExtra("isBenefit", false));
                }
            } else if (i11 == 2020) {
                Cart.getInstance().setCanShowLoyallyVoucherInCheckOut(true);
            }
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public void onBNPLOrderError() {
        BNPLPlaceOrderBottomSheet bNPLPlaceOrderBottomSheet = this.bnplPlaceOrderBottomSheet;
        if (bNPLPlaceOrderBottomSheet != null) {
            bNPLPlaceOrderBottomSheet.onGetBNPNOrderFailure();
        }
    }

    public void onBNPLOrderSuccess(PlaceOrderResponse placeOrderResponse) {
        CardInfo cardInfo;
        String str;
        if (!this.checkoutPresenter.isFlutterBNPLCheckoutEnabled() || (cardInfo = this.selectedCardInfo) == null || this.bnplPlan == null) {
            BNPLPlaceOrderBottomSheet bNPLPlaceOrderBottomSheet = this.bnplPlaceOrderBottomSheet;
            if (bNPLPlaceOrderBottomSheet != null) {
                bNPLPlaceOrderBottomSheet.onGetBNPLOrderSuccess(placeOrderResponse);
                return;
            }
            return;
        }
        BNPLCardDetail bNPLCardDetail = new BNPLCardDetail(cardInfo.getCardTokenId(), this.selectedCardInfo.getLast4Digits(), this.selectedCardInfo.getExpiryDate(), this.selectedCardInfo.getCardNetwork(), this.selectedCardInfo.getBinNumber());
        this.bnplManagerViewModel.setOrderResponse(placeOrderResponse);
        BNPLManagerViewModel bNPLManagerViewModel = this.bnplManagerViewModel;
        String id2 = this.bnplPlan.getId();
        if (placeOrderResponse == null) {
            str = null;
        } else {
            str = placeOrderResponse.encryptedOrderId;
        }
        bNPLManagerViewModel.payOrderWithBNPL(new BNPLOrderPaymentRequestDto(id2, str, bNPLCardDetail));
    }

    public void onBackPressed() {
        if (getSupportFragmentManager().getFragments().isEmpty()) {
            this.back.performClick();
        }
        clearCartInCaseOfQCommerceVendors();
        super.onBackPressed();
    }

    public /* synthetic */ void onBackToCheckoutPage(Dialog dialog) {
        a.b(this, dialog);
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        backToRestaurantMenuPage(dialog, this.mGemDialogSwitcher, "Checkout Screen");
    }

    public void onBackToRestaurantPage(Dialog dialog) {
        dialog.dismiss();
        this.back.performClick();
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().rejectGem(false);
            Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
            intent.setFlags(67108864);
            intent.setFlags(4194304);
            startActivity(intent);
        }
    }

    public void onBinError(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setTitle((CharSequence) getString(R.string.bin_expired_title));
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckOutScreen.this.cart.removeBinDiscountIfApplied();
                CheckOutScreen.this.cart.recalcualteTotal();
                CheckOutScreen.this.setVoucherView();
                CheckOutScreen.this.updateSavedCardAdapter();
            }
        });
        builder.show();
    }

    public void onBinNotAvailable(String str) {
        stopNonCancelableLoading();
        BNPLPlaceOrderBottomSheet bNPLPlaceOrderBottomSheet = this.bnplPlaceOrderBottomSheet;
        if (bNPLPlaceOrderBottomSheet != null) {
            bNPLPlaceOrderBottomSheet.cancelLoader();
        }
        if (this.mAdapter != null) {
            updateSavedCardAdapter();
        }
        if (!this.preselected && !TalabatUtils.isNullOrEmpty(str)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            builder.setMessage((CharSequence) str);
            builder.setCancelable(false);
            builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
    }

    public void onBinTokenRecieved(BinTokenResponse[] binTokenResponseArr) {
        SavedCardRecyclerViewAdapter savedCardRecyclerViewAdapter;
        this.binTokens = binTokenResponseArr;
        ArrayList<TokenisationCreditCard> arrayList = this.tokenisationCreditCards;
        String str = "";
        if (arrayList != null && arrayList.size() > 0) {
            boolean z11 = false;
            boolean z12 = false;
            for (BinTokenResponse binTokenResponse : binTokenResponseArr) {
                Iterator<TokenisationCreditCard> it = this.tokenisationCreditCards.iterator();
                while (it.hasNext()) {
                    TokenisationCreditCard next = it.next();
                    if (next.token.equals(binTokenResponse.token)) {
                        boolean z13 = binTokenResponse.isBinDiscountValid;
                        next.isBinDiscountValid = z13;
                        next.binNumber = binTokenResponse.binNumber;
                        next.message = binTokenResponse.chkOutMesg;
                        if (!z12 && z13 && !TalabatUtils.isNullOrEmpty(binTokenResponse.menuMesg)) {
                            str = binTokenResponse.menuMesg;
                            z12 = true;
                        }
                        z11 = true;
                    }
                }
                Customer instance = Customer.getInstance();
                ArrayList<TokenisationCreditCard> arrayList2 = this.tokenisationCreditCards;
                instance.setSavedCreditCards((TokenisationCreditCard[]) arrayList2.toArray(new TokenisationCreditCard[arrayList2.size()]));
            }
            if (z11 && (savedCardRecyclerViewAdapter = this.mAdapter) != null) {
                savedCardRecyclerViewAdapter.updateList(Customer.getInstance().getSavedCards());
                this.mAdapter.notifyDataSetChanged();
            }
        }
        this.binMessage.setText(str);
        stopLodingPopup();
        this.binResponseReceived = true;
        if (this.waitingForBinResponse) {
            this.waitingForBinResponse = false;
            this.f53833n.performClick();
        }
        TalabatUtils.isNullOrEmpty(str);
    }

    public void onBinVoucherAvailable(BinResponse binResponse) {
        this.checkoutPresenter.applyBinVoucher(binResponse, this.requestedBinNumber, this.checkoutBinVoucherViewModel.isBinVoucherRequestFromBNPL());
    }

    public void onBottomSheetOpened(@NotNull String str) {
        this.bnplManagerViewModel.onBNPLFakeTestBottomSheetOpen(str);
    }

    public void onCallCheckoutDotCom(String str, boolean z11, PlaceOrderRequestModel placeOrderRequestModel, boolean z12, boolean z13, String str2) {
        Intent intent;
        String str3;
        boolean z14;
        boolean z15;
        this.transactionId = str;
        this.encryptedOrderId = str2;
        boolean z16 = false;
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.EGYPT.getCountryId()) {
            intent = new Intent(this, AdyenCheckoutScreen.class);
            if (this.selectedPaymentMethod == 3) {
                z15 = true;
            } else {
                z15 = false;
            }
            intent.putExtra("isTalabatCreditForUae", z15);
            intent.putExtra("customerName", this.f53838s);
            intent.putExtra("balanceAmountToPay", this.balanceAmountToPay);
        } else {
            Intent intent2 = new Intent(this, CheckoutTokenScreen.class);
            if (this.selectedPaymentMethod == 3) {
                z14 = true;
            } else {
                z14 = false;
            }
            intent2.putExtra("isTalabatCreditForUae", z14);
            intent2.putExtra("customerName", this.f53838s);
            intent2.putExtra("balanceAmountToPay", this.balanceAmountToPay);
            intent2.putExtra("hideAddCard", z13);
            intent = intent2;
        }
        this.addCardPopupShown = true;
        Gson gson = UniversalGson.INSTANCE.gson;
        placeOrderRequestModel.setDarkStore(isDarkStore());
        if (!(gson instanceof Gson)) {
            str3 = gson.toJson((Object) placeOrderRequestModel);
        } else {
            str3 = GsonInstrumentation.toJson(gson, (Object) placeOrderRequestModel);
        }
        intent.putExtra("isAddCard", true);
        intent.putExtra("isPostDated", this.isPostDated);
        intent.putExtra("isOrderSuccess", z11);
        intent.putExtra("transactionId", str);
        intent.putExtra("transactionAmount", this.transactionAmount);
        intent.putExtra("isQuick", this.isQuick);
        intent.putExtra("quickOrderString", this.f53831l);
        intent.putExtra("talabatCredit", this.f53829j);
        intent.putExtra("paymentMethod", this.paymnentMethod);
        intent.putExtra("placeOrderRequestModel", str3);
        intent.putExtra("isTalabatDelVoucher", z12);
        intent.putExtra("encryptedOrderId", str2);
        intent.putExtra("map_compulsory", this.isMapcompulsory);
        intent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
        intent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
        intent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
        intent.putExtra("newaddressCreation", this.isNewAddressCreation);
        intent.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, this.isOrderFlowSucess);
        intent.putExtra("isFromAptimize", this.isFromAptimize);
        intent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
        intent.putExtra("isNewAddressCreationFromGrlFlow", this.isNewAddressCreationGlrFlow);
        intent.putExtra("isQuick", this.isQuick);
        intent.putExtra("value", this.f53831l);
        intent.putExtra("appendedName", getIntent().getStringExtra("appendedName"));
        if (this.unAvailableQPayMessageView.getVisibility() == 0) {
            z16 = true;
        }
        intent.putExtra("isQPayDown", z16);
        this.isCheckoutDotCom = true;
        startActivityForResult(intent, 305);
        stopNonCancelableLoading();
    }

    public void onCashbackResponseError() {
        this.checkoutPresenter.setCashBackAvailable(false);
        this.cashbackProgressBar.setVisibility(8);
    }

    public void onCashbackResponseReceived(CashbackRM cashbackRM) {
        CashBackResponse cashBackResponse;
        this.cashbackProgressBar.setVisibility(8);
        if (cashbackRM != null && (cashBackResponse = cashbackRM.result) != null) {
            if (cashBackResponse.amount > 0.0f) {
                this.checkoutPresenter.setCashBackAvailable(true);
                this.cashbackText.setText(getString(R.string.cashback_received_text).replace(RichContentLoadTimeRecorder.DELIMETER, TalabatFormatter.getInstance().getFormattedCurrency(cashbackRM.result.amount)));
                this.cashbackText.setVisibility(0);
                return;
            }
            this.cashbackText.setVisibility(8);
            this.checkoutPresenter.setCashBackAvailable(false);
        }
    }

    public void onChangeCardClicked() {
        showBNPLView(Boolean.TRUE, Boolean.FALSE);
    }

    public void onCheckoutDotComRecurringFailed(String str) {
        Intent intent = new Intent(this, PaymentErrorScreen.class);
        intent.putExtra("url", "");
        intent.putExtra("isFromCheckoutDotCom", true);
        intent.putExtra("isGateWayError", false);
        intent.putExtra("paymentMethod", this.paymnentMethod);
        intent.putExtra("encryptedTransactionIdError", this.transactionId);
        this.launcher.launch(intent);
        stopNonCancelableLoading();
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        String str;
        Object obj;
        NestedScrollView nestedScrollView2;
        ApiContainer apiContainer = (ApiContainer) getApplication();
        DaggerCheckoutScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (FeesFeatureApi) apiContainer.getFeature(FeesFeatureApi.class), (HelpCenterFeatureApi) apiContainer.getFeature(HelpCenterFeatureApi.class), (MapsCoreLibApi) apiContainer.getFeature(MapsCoreLibApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (SubscriptionsFeatureApi) apiContainer.getFeature(SubscriptionsFeatureApi.class), (DarkstoresScheduledDeliveryFeatureApi) apiContainer.getFeature(DarkstoresScheduledDeliveryFeatureApi.class), (CustomerCoreLibApi) apiContainer.getFeature(CustomerCoreLibApi.class), (PickupFeatureApi) apiContainer.getFeature(PickupFeatureApi.class)).inject(this);
        super.onCreate(bundle);
        this.W.startTrace(new ScreenTrackerParams("checkout", "checkoutScreen", "checkout"));
        this.T.initialize();
        setContentView((int) R.layout.checkout_screen);
        try {
            ScreenRecorder.INSTANCE.stopScreenRecording();
            R1();
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            this.mToolbar = toolbar;
            setSupportActionBar(toolbar);
            setTitle(R.id.title, getString(R.string.checkout));
            CheckoutForceCVVVViewModel checkoutForceCVVViewModel = CheckoutForceCVVViewModelFactory.INSTANCE.getCheckoutForceCVVViewModel(AndroidComponentsKt.apiContainer((Activity) this));
            this.checkoutForceCVVVViewModel = checkoutForceCVVViewModel;
            checkoutForceCVVViewModel.getCheckoutCVVPopUpData().observe(this, new t2(this));
            this.checkoutForceCVVVViewModel.getOpenForceCVVData().observe(this, new f3(this));
            this.checkoutForceCVVVViewModel.getProceedToPaymentData().observe(this, new r3(this));
            this.checkoutPaymentUpdateViewModel = CheckoutPaymentManagerViewModelFactory.Companion.create(this, this.f53827c0);
            this.benefitManagerViewModel = DebitCardDeflectionViewModelFactory.Companion.create(this, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_SAVED_CARD_DEFLECTION_ENABLED, this.E, this.L, this.K);
            this.payProxyManagerViewModel = PayProxyManagerViewModelFactory.Companion.create(this, this.K);
            this.checkoutBinVoucherViewModel = CheckoutBinVoucherViewModelFactory.Companion.create(this);
            this.checkoutPaymentUpdateViewModel.getCheckoutPaymentUpdateDisplayModel().observe(this, new y3(this));
            this.checkoutPaymentUpdateViewModel.getWalletBalanceDisplayModel().observe(this, new a4(this));
            this.checkoutPaymentUpdateViewModel.getBNPLPlanEligibilityDisplayModel().observe(this, new b4(this));
            this.checkoutPaymentUpdateViewModel.getBNPLPopViewDisplayModel().observe(this, new c4(this));
            this.benefitManagerViewModel.getPaymentButtonTypeData().observe(this, new d4(this));
            this.payProxyManagerViewModel.getSendCVVToProxyData().observe(this, new e4(this));
            BNPLManagerViewModel create = BNPLManagerViewModelFactory.Companion.create(this, this.E, this.G, this.K, this.f53827c0);
            this.bnplManagerViewModel = create;
            create.getBNPLOrderPaymentData().observe(this, new f4(this));
            this.bnplManagerViewModel.getBNPLPaymentFallbackEligibleStateData().observe(this, new u2(this));
            this.checkoutBinVoucherViewModel.getCheckoutBinVoucherData().observe(this, new v2(this));
            this.paymentLayoutView = (LinearLayout) findViewById(R.id.checkout_payment_view);
            this.unAvailableKNetView = (RelativeLayout) findViewById(R.id.knet_unavailable);
            this.unAvailableKNetMessageView = (ConstraintLayout) findViewById(R.id.knet_unavailable_message);
            this.unAvailableQPayMessageView = (ConstraintLayout) findViewById(R.id.qpay_unavailable_message);
            this.A = (RadioButton) findViewById(R.id.knet_debit_card_radio);
            this.B = (RadioButton) findViewById(R.id.qpay_debit_card_radio);
            this.kNetDebitCardLayout = (RelativeLayout) findViewById(R.id.kNet_debit_card_layout);
            this.qPayDebitCardLayout = (RelativeLayout) findViewById(R.id.qpay_debit_card_layout);
            this.unAvailableQPayView = (RelativeLayout) findViewById(R.id.qpay_unavailable);
            this.nestedScrollView = (NestedScrollView) findViewById(R.id.root_scroll_view);
            this.isLoggedIn = Customer.getInstance().isLoggedIn(getContext());
            this.deliveryAddressView = findViewById(R.id.delivery_address_view);
            this.addressName = (TextView) findViewById(R.id.txtAddressProfileName);
            this.areaName = (TextView) findViewById(R.id.txtAddressAreaname);
            this.pickupTimeContainer = findViewById(R.id.pickupTimeContainer);
            this.mobileContainer = findViewById(R.id.mobileContainer);
            this.pickupText = (TextView) findViewById(R.id.pickupText);
            this.pickupTime = (TextView) findViewById(R.id.pickup_time);
            this.addressIcon = (ImageView) findViewById(R.id.address_icon);
            this.addressDescription = (TextView) findViewById(R.id.txtAddressDescription);
            this.mobileNumber = (TextView) findViewById(R.id.txtAddresMobile);
            this.phoneNumber = (TextView) findViewById(R.id.txtAddresPhone);
            this.directions = (TextView) findViewById(R.id.txtAdditionalDirections);
            this.mDeliveryAddressTitle = (TextView) findViewById(R.id.delivery_address_title);
            this.mAddressNameAb = (TextView) findViewById(R.id.txtAddressProfileNameAb);
            this.mAreaNameAb = (TextView) findViewById(R.id.txtAddressAreanameAb);
            this.mAddressDescriptionAb = (TextView) findViewById(R.id.txtAddressDescriptionAb);
            this.mMobileNumberAb = (TextView) findViewById(R.id.txtmobileNumber);
            this.mMobileCountryCode = (TextView) findViewById(R.id.txtAddresMobileCcode);
            this.mMobileNumberLabel = (TextView) findViewById(R.id.txtAddresMobileLabel);
            this.mPhoneNumberAb = (TextView) findViewById(R.id.txtAddresPhoneAb);
            this.mDirectionsAb = (TextView) findViewById(R.id.txtAdditionalDirectionsAb);
            this.mAddressViewContainer = findViewById(R.id.address_view_container);
            this.mAddressViewContainerMap = findViewById(R.id.address_view_container_map);
            this.restaurantName = (TextView) findViewById(R.id.restaurantName);
            this.talabatCreditView = findViewById(R.id.talabat_credit_details_view);
            this.newTalabatCreditView = findViewById(R.id.new_talabat_credit_section);
            this.paymentOptionsTitle = (TextView) findViewById(R.id.payment_options_title);
            this.talabtCreditTotalDisplay = (TextView) findViewById(R.id.talabat_credit_total);
            this.talabatCreditBalance = (TextView) findViewById(R.id.talabat_credit_balance_amount);
            this.binView = findViewById(R.id.bin_view);
            this.binMessage = (TextView) findViewById(R.id.bin_voucher_text);
            this.binOffersView = findViewById(R.id.bin_offers_view);
            this.binOffersText = (TextView) findViewById(R.id.bin_offers_text);
            this.parentLayout = findViewById(R.id.checkout_parent);
            this.closeBinNotificationView = (ImageView) findViewById(R.id.close_bin_view);
            this.payByKnet = findViewById(R.id.pay_by_knet_view);
            this.knetTotal = (TextView) findViewById(R.id.knet_total);
            this.changeAddress = (TextView) findViewById(R.id.change_address);
            this.availableCredit = findViewById(R.id.available_credit_view);
            this.availableCreditValue = (TextView) findViewById(R.id.available_credit_value);
            this.payByMethod = (TextView) findViewById(R.id.pay_by_method);
            this.payByCash = findViewById(R.id.pay_by_cash_view);
            this.cashTotal = (TextView) findViewById(R.id.cash_total);
            this.paymentBy = (TextView) findViewById(R.id.pay_method);
            this.subtotal = (TextView) findViewById(R.id.subtotal_value);
            this.discountVoucherAmount = (TextView) findViewById(R.id.discount_voucher_value);
            this.discountVoucherView = findViewById(R.id.dicount_voucher_layout);
            this.combinedDiscountLayout = findViewById(R.id.combined_discount_layout);
            this.combinedDiscountText = (TextView) findViewById(R.id.combined_discount_text);
            this.combinedDiscountValue = (TextView) findViewById(R.id.combined_discount_value);
            this.removeVoucher = (TextView) findViewById(R.id.remove_voucher);
            this.coupon_discount_value = (TextView) findViewById(R.id.coupon_discount_value);
            this.talabatDeliveryVoucherAmount = (TextView) findViewById(R.id.talabat_delivery_voucher_discount_value);
            this.coupon_discount_view = findViewById(R.id.coupon_discount_layout);
            this.talabatDeliveryVoucherView = findViewById(R.id.talabat_delivery_voucher_discount_layout);
            this.freeDeliveryTypeVoucherLayout = findViewById(R.id.free_delivery_voucher_layout);
            this.freeDeliverTypeVoucherAmount = (TextView) findViewById(R.id.free_delivery_voucher_amount);
            this.freeDeliveryTypeVoucherText = (TextView) findViewById(R.id.free_delivery_voucher_name);
            this.freeDeliverySavingsText = (TextView) findViewById(R.id.free_delivery_savings_text);
            this.freeDeliveryMore = (TextView) findViewById(R.id.free_delivery_more);
            this.savingsView = findViewById(R.id.savings_view);
            this.deliveryChargesValue = (TextView) findViewById(R.id.delivery_charges_value);
            this.freeDeliveryReturnValue = (TextView) findViewById(R.id.free_delivery_return_value);
            TextView textView = (TextView) findViewById(R.id.old_delivery_charges);
            this.oldDeliveryCharges = textView;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            this.deliveryChargesText = (TextView) findViewById(R.id.delivery_charges_text);
            this.deliveryFeeInfoIcon = findViewById(R.id.delivery_fee_tooltip_icon);
            this.deliveryFirstOrder = (DSTag) findViewById(R.id.delivery_first_order);
            this.deliveryFeeClickableArea = findViewById(R.id.delivery_fee_clickable_area);
            this.riderTipChargesText = (TextView) findViewById(R.id.rider_tip_charges_text);
            this.deliveryChargesView = findViewById(R.id.restaurant_delivery_charges_view);
            this.freeDeliveryText = (TalabatTextView) findViewById(R.id.free_delivery_text);
            this.freeDeliveryView = findViewById(R.id.restaurant_free_delivery_view);
            this.riderTipChargesView = findViewById(R.id.rider_tip_charges_view);
            this.riderTipChargesView = findViewById(R.id.rider_tip_charges_view);
            this.grandTotal = (TextView) findViewById(R.id.grand_total_value);
            this.f53833n = (Button) findViewById(R.id.placeorder);
            this.checkoutDotComTxt = (TextView) findViewById(R.id.checkout_radio_txt);
            this.freeTrialInfoText = (TextView) findViewById(R.id.free_trial_info);
            this.freeTrialLayout = (RelativeLayout) findViewById(R.id.free_trial_layout);
            PayProxyManagerPresenter payProxyManagerPresenter = new PayProxyManagerPresenter();
            PlaceOrderPresenter placeOrderPresenter = new PlaceOrderPresenter(this, new PlaceOrderInteractor(this.D, this.E, this.H, this.G, this.I), payProxyManagerPresenter, this.M, this.E, this.G);
            payProxyManagerPresenter.setListener(placeOrderPresenter);
            this.checkoutPresenter = P1(placeOrderPresenter);
            this.checkoutRefactorPresenter = new CheckoutRefactorPresenter(this);
            this.checkoutPresenter.postDateButtonClicked(true);
            this.checkoutPresenter.fetchCurrentLocationAwareness();
            this.postOrderButtonText = getPostOrderText();
            this.expiryLayout = findViewById(R.id.expiry_layout);
            this.expiryDate = (TextView) findViewById(R.id.card_expiry_date);
            setupPostDateDelivery();
            setScheduledDeliveryDiscount();
            setupCurrentLocationAwarenessTxt();
            this.cash = (RadioButton) findViewById(R.id.cash);
            this.debitCard = (RadioButton) findViewById(R.id.debit_card);
            RadioButton radioButton = (RadioButton) findViewById(R.id.bnpl_entering_point_radio_button);
            this.bNPLFakeDoorTestPaymentTypeTextView = (TextView) findViewById(R.id.bnpl_description_text_view);
            this.bNPLFakeDoorTestLayoutView = findViewById(R.id.bnpl_entering_point);
            this.bNPLFakeDoorTestTagView = (DSTag) findViewById(R.id.bnpl_entering_point_tag);
            this.bNPLRadioButton = (RadioButton) findViewById(R.id.bnpl_radio_button);
            this.bNPLPaymentTypeTextView = (TextView) findViewById(R.id.bnpl_plan_description_text_view);
            this.bNPLLayoutView = findViewById(R.id.bnpl_V1_entering_point);
            this.bNPLTagView = (DSTag) findViewById(R.id.bnpl_tag);
            this.bNPLEligibilityErrorImageView = (ImageView) findViewById(R.id.bnpl_eligibility_error_image_view);
            RadioButton radioButton2 = (RadioButton) findViewById(R.id.credit_card);
            this.f53844y = (RadioButton) findViewById(R.id.talabat_credit);
            this.payRemainingbyCredit = findViewById(R.id.pay_remaining_credit_card);
            this.remainingTalabatCreditView = findViewById(R.id.remaining_talabat_credit_view);
            this.remainingCreditAmount = (TextView) findViewById(R.id.remaining_credit_amount);
            this.f53845z = (RadioButton) findViewById(R.id.checkout_radio);
            this.visaCheckoutRadio = (RadioButton) findViewById(R.id.visa_checkout_radio);
            this.C = (SubscriptionAtCheckoutBannerView) findViewById(R.id.subscription_at_checkout_banner);
            this.checkoutDotComIcon = (ImageView) findViewById(R.id.checkout_icon);
            this.cashIcon = (ImageView) findViewById(R.id.cash_icon);
            this.creditIcon = (ImageView) findViewById(R.id.credit_icon);
            this.debitIcon = (ImageView) findViewById(R.id.debit_icon);
            this.visaIconProgress = (ProgressBar) findViewById(R.id.visa_icon_progressBar);
            this.visaCheckoutIcon = (ImageView) findViewById(R.id.visa_checkout_icon);
            this.visaIconProgress.setVisibility(0);
            loadVisaCheckoutIcon("");
            this.checkout_disclaimer_view = findViewById(R.id.checkout_disclamer_view);
            this.checkout_disclaimer_text = (TextView) findViewById(R.id.disclamer_text);
            this.paymentTerms = (TextView) findViewById(R.id.payment_terms);
            this.mQuickAddressArrow = (ImageView) findViewById(R.id.order_screen_arrow);
            this.isMapcompulsory = getIntent().getBooleanExtra("map_compulsory", false);
            this.isNineCookiesTrackingEnabled = getIntent().getBooleanExtra("nineCookiesEnabled", false);
            this.isAddressFromCartOrderFlow = getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false);
            this.isTalabatDeliveryAvailable = getIntent().getBooleanExtra("talabatDeliveryAvailable", false);
            this.isNewAddressCreation = getIntent().getBooleanExtra("newaddressCreation", false);
            this.isOrderFlowSucess = getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, false);
            this.isFromAptimize = getIntent().getBooleanExtra("isFromAptimize", false);
            this.isGrlEnabled = getIntent().getBooleanExtra("isGlrEnabledRes", false);
            this.isNewAddressCreationGlrFlow = getIntent().getBooleanExtra("isNewAddressCreationFromGrlFlow", false);
            this.isGlrEnableAddNewAddress = getIntent().getBooleanExtra(GlobalConstants.INFOR_MAP.IS_FROM_MCD_NEW_ADDRESS_CHECKOUT, false);
            this.isEditAddressFromCheckoutScreen = getIntent().getBooleanExtra("isEditAddressFlowFromCheckout", false);
            this.back = (ImageButton) findViewById(R.id.back);
            this.cashLabelTxt = (TextView) findViewById(R.id.cash_label_txt);
            this.debitCardLabelTxt = (TextView) findViewById(R.id.debit_card_label_txt);
            this.creditLabelTxt = (TextView) findViewById(R.id.credit_card_card_label_txt);
            this.talabatCreditTxt = (TextView) findViewById(R.id.talabat_credit_label_txt);
            this.visaCheckoutTxt = (TextView) findViewById(R.id.visa_checkout_labelTxt);
            this.cashLayout = findViewById(R.id.cash_radio_layout);
            this.creditLayout = findViewById(R.id.credit_radio_layout);
            this.debitLayout = findViewById(R.id.debit_radio_layout);
            this.visaCheckoutLayout = findViewById(R.id.visa_checkout_radio_layout);
            this.checkoutdotLayout = findViewById(R.id.checkout_radio_layout);
            RadioButton radioButton3 = (RadioButton) findViewById(R.id.selected_payfort_card);
            this.selectedPayfortCard = radioButton3;
            this.radioButtons = new RadioButton[]{this.cash, this.debitCard, radioButton2, this.f53844y, radioButton3, this.f53845z, this.A, this.B, this.visaCheckoutRadio, radioButton, this.bNPLRadioButton};
            this.selectedCardView = (RelativeLayout) findViewById(R.id.selected_payfort_card_layout);
            this.changeSelectCardTxt = (Button) findViewById(R.id.selected_card_change);
            this.contactlessFeatureView = findViewById(R.id.contactless_feature_view);
            this.contactLessSelector = (CheckBox) findViewById(R.id.contactless_selector);
            this.avoidCashWarningView = findViewById(R.id.avoid_cash_warning_view);
            this.disabledCashExplanationView = findViewById(R.id.disabled_cash_explanation_view);
            this.disabledCashExplanationText = (TextView) findViewById(R.id.disabled_cash_explanation_text);
            this.warningImage = (AppCompatImageView) findViewById(R.id.warning_image);
            if (TalabatUtils.isNotLowerThanLollipop() && (nestedScrollView2 = this.nestedScrollView) != null) {
                nestedScrollView2.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
                    public void onScrollChange(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
                        if (i12 == 0) {
                            CheckOutScreen.this.mToolbar.setElevation(0.0f);
                        } else {
                            CheckOutScreen.this.mToolbar.setElevation(10.0f);
                        }
                    }
                });
            }
            setVisibilityOfSubscriptionOnCheckoutBanner();
            this.cardAvilableView = (RelativeLayout) findViewById(R.id.card_available_view);
            this.noCardAddCardButton = (Button) findViewById(R.id.no_card_add_card);
            this.cardList = (RecyclerView) findViewById(R.id.card_list);
            this.expandableLinearLayout = (ExpandableLinearLayout) findViewById(R.id.expand_relative_layout);
            this.visaCheckoutExpandedView = findViewById(R.id.visa_checkout_expanded_view);
            this.gemDiscountView = findViewById(R.id.gem_discount_view);
            this.gemOfferText = (TextView) findViewById(R.id.gem_offer_text);
            this.gemOfferValue = (TextView) findViewById(R.id.gem_offer_price);
            this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
            this.parallelBinView = findViewById(R.id.parallel_bin_view);
            this.parallelBinImageView = findViewById(R.id.parallel_bin_image_view);
            this.parallelBinImage = (ImageView) findViewById(R.id.parallel_bin_image);
            this.parallelBinProgressBar = (ProgressBar) findViewById(R.id.parallel_bin_image_progressBar);
            this.parallelText = (TextView) findViewById(R.id.parallel_bin_content);
            this.parallelBinMore = (TextView) findViewById(R.id.parallel_bin_more);
            this.discountVoucherTxt = (TextView) findViewById(R.id.discount_txt);
            this.showMorePaymentOptionsTextView = (TextView) findViewById(R.id.show_more_payment_options);
            this.paymentOptionsContainer = (LinearLayout) findViewById(R.id.payment_options_container);
            this.defaultPaymentOption = (RelativeLayout) findViewById(R.id.default_payment_option);
            this.defaultCreditCardIcon = (ImageView) findViewById(R.id.default_credit_icon);
            this.defaultCreditCardName = (TextView) findViewById(R.id.default_credit_card_name);
            this.cashbackFeatureView = findViewById(R.id.cashback_feature_view);
            this.cashbackLayout = findViewById(R.id.cashback_layout);
            this.cashbackProgressBar = (ProgressBar) findViewById(R.id.cashback_progressBar);
            this.cashbackText = (TextView) findViewById(R.id.cashback_text);
            this.cashbackAvailableCredit = (TextView) findViewById(R.id.cashback_available_credit_txt);
            this.softPOSView = findViewById(R.id.soft_pos_info);
            this.showMorePaymentOptionsTextView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CheckOutScreen.this.paymentOptionsContainer.setVisibility(0);
                    CheckOutScreen.this.defaultPaymentOption.setVisibility(8);
                }
            });
            this.cash.setOnClickListener(new w2(this));
            radioButton2.setOnClickListener(new x2(this, radioButton2));
            this.debitCard.setOnClickListener(new y2(this));
            this.f53844y.setOnClickListener(new z2(this));
            this.selectedPayfortCard.setOnClickListener(new a3(this));
            this.f53845z.setOnClickListener(new b3(this));
            this.A.setOnClickListener(new c3(this));
            this.B.setOnClickListener(new e3(this));
            this.visaCheckoutRadio.setOnClickListener(new g3(this));
            radioButton.setOnClickListener(new h3(this, radioButton));
            this.bNPLRadioButton.setOnClickListener(new i3(this));
            this.back.setOnClickListener(new j3(this));
            this.cashLayout.setOnClickListener(new k3(this));
            this.debitLayout.setOnClickListener(new l3(this));
            this.creditLayout.setOnClickListener(new m3(radioButton2));
            this.newTalabatCreditView.setOnClickListener(new n3(this));
            this.checkoutdotLayout.setOnClickListener(new p3(this));
            this.visaCheckoutLayout.setOnClickListener(new q3(this));
            this.bNPLFakeDoorTestLayoutView.setOnClickListener(new s3(radioButton));
            this.bNPLLayoutView.setOnClickListener(new t3(this));
            this.kNetDebitCardLayout.setOnClickListener(new u3(this));
            this.qPayDebitCardLayout.setOnClickListener(new v3(this));
            this.expiryDate.setClickable(true);
            this.expiryDate.setOnClickListener(new w3(this));
            setScheduleLaterOnClickListener();
            if (this.f53844y.isChecked()) {
                this.talabatCreditView.setVisibility(0);
            } else {
                this.talabatCreditView.setVisibility(8);
            }
            this.f53833n.setOnClickListener(new x3(this));
            if (!this.checkoutPresenter.isPickup()) {
                new GemPaymentCheckoutBinder().accept(this);
            }
            boolean booleanExtra = getIntent().getBooleanExtra("isQuick", false);
            this.isQuick = booleanExtra;
            if (booleanExtra) {
                Gson gson = UniversalGson.INSTANCE.gson;
                if (getIntent().hasExtra("value")) {
                    str = getIntent().getStringExtra("value");
                } else {
                    str = null;
                }
                this.f53831l = str;
                if (str != null) {
                    Class cls = QuickOrderInfo.class;
                    if (!(gson instanceof Gson)) {
                        obj = gson.fromJson(str, cls);
                    } else {
                        obj = GsonInstrumentation.fromJson(gson, str, cls);
                    }
                    QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
                    this.f53832m = quickOrderInfo;
                    this.checkoutPresenter.setAddress(quickOrderInfo.address);
                    QuickOrderInfo quickOrderInfo2 = this.f53832m;
                    this.firstName = quickOrderInfo2.firstName;
                    this.lastName = quickOrderInfo2.lastName;
                }
            }
            if (!this.checkoutPresenter.isPickup()) {
                this.deliveryAddressView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        LogManager.info("UiTestInvestigation: deliveryAddressView Clicked (isQuick=" + CheckOutScreen.this.isQuick);
                        if (!CheckOutScreen.this.isQuick) {
                            CheckOutScreen.this.checkoutPresenter.editDeliveryAddress();
                        } else {
                            CheckOutScreen.this.finish();
                        }
                    }
                });
            }
            hideAllPaymentOptionsExceptDefault(GlobalDataModel.isUserEligibleForWalletPaymentOptionABTest);
            this.checkoutPaymentUpdateViewModel.onWalletBalanceLoaded();
            this.checkoutRefactorPresenter.onSettingDebitCardPaymentMethodLabel();
            if (!this.isQuick) {
                isChageAddressButtonLabel();
            }
            this.changeAddress.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (!CheckOutScreen.this.isLoggedIn) {
                        CheckOutScreen.this.finish();
                    } else if (CheckOutScreen.this.isGrlEnabled) {
                        Customer instance = Customer.getInstance();
                        if (instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).size() == 1) {
                            CheckOutScreen.this.addNewAddressFromCheckout(instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).get(0));
                        }
                    } else {
                        Intent intent = new Intent(CheckOutScreen.this, AddressList.class);
                        intent.putExtra(GlobalConstants.ExtraNames.ISFORSELECTION, true);
                        intent.putExtra("isOrderFlow", true);
                        intent.putExtra("isFromCheckout", true);
                        intent.putExtra("noAreaChange", true);
                        if (CheckOutScreen.this.isMapcompulsory) {
                            intent.putExtra(GlobalConstants.FORCE_MAP.IS_MAP_ENFORCE_FROM_CHECK_OUT, true);
                        } else {
                            intent.putExtra(GlobalConstants.FORCE_MAP.IS_MAP_ENFORCE_FROM_CHECK_OUT, false);
                        }
                        intent.putExtra("isAddressFromCartOrderFlow", CheckOutScreen.this.isAddressFromCartOrderFlow);
                        intent.putExtra("newaddressCreation", CheckOutScreen.this.isNewAddressCreation);
                        intent.putExtra("map_compulsory", CheckOutScreen.this.isMapcompulsory);
                        intent.putExtra("nineCookiesEnabled", CheckOutScreen.this.isNineCookiesTrackingEnabled);
                        intent.putExtra("talabatDeliveryAvailable", CheckOutScreen.this.isTalabatDeliveryAvailable);
                        intent.putExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, true);
                        intent.putExtra(GlobalConstants.FORCE_MAP.IS_ADD_ADDRESS_FROM_CHECKOUT, true);
                        intent.putExtra("noAreaChange", true);
                        CheckOutScreen.this.startActivityForResult(intent, 100);
                    }
                }
            });
            this.visaCheckoutButton = (CheckoutButton) findViewById(R.id.visa_checkout_button);
            this.expandableLinearLayout.setListener(new ExpandableLayoutListener() {
                public void onAnimationEnd() {
                }

                public void onAnimationStart() {
                }

                public void onClosed() {
                    CheckOutScreen.this.f53833n.setVisibility(0);
                }

                public void onOpened() {
                    CheckOutScreen.this.f53833n.setVisibility(8);
                }

                public void onPreClose() {
                    CheckOutScreen.this.visaCheckoutExpandedView.setVisibility(8);
                }

                public void onPreOpen() {
                    CheckOutScreen.this.visaCheckoutExpandedView.setVisibility(0);
                }
            });
            GlobalDataModel.callId = "";
            if (TalabatUtils.isNullOrEmpty("")) {
                this.expiryLayout.setVisibility(8);
                this.visaCheckoutTxt.setText(getResources().getString(R.string.visa_checkout));
            } else {
                this.expiryLayout.setVisibility(0);
            }
            inflateGemFooter();
            if (isGemActive()) {
                withGemAnalytics().onCheckoutLoaded();
            }
            this.closeBinNotificationView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CheckOutScreen.this.binViewClosed = true;
                    CheckOutScreen checkOutScreen = CheckOutScreen.this;
                    checkOutScreen.animateView(0, -checkOutScreen.binView.getHeight(), CheckOutScreen.this.binView);
                    CheckOutScreen.this.stopBinTimer();
                }
            });
            GlobalDataModel.callId = "";
            this.f53833n.setVisibility(0);
            this.expandableLinearLayout.collapse(300, Utils.createInterpolator(0));
            setAddressIcon();
            ApplyVouchersView applyVouchersView = (ApplyVouchersView) findViewById(R.id.checkoutApplyVouchersView);
            this.loyaltyDashboardApplyVouchersView = applyVouchersView;
            applyVouchersView.init(ApplyVoucherOwner.Checkout, this.applyVouchersViewCallback);
            if (isGemActive()) {
                findViewById(R.id.checkoutApplyVoucherViewLayout).setVisibility(8);
            }
            new GemCheckoutScreenBinder().accept(this);
            this.checkoutPresenter.onViewLoaded();
            setUpCancellationPolicy();
            setupFees();
        } catch (Exception e11) {
            Exception exc = e11;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            sb2.append(exc.getLocalizedMessage());
            exc.printStackTrace();
            finish();
        }
        getSupportFragmentManager().setFragmentResultListener(BNPLCheckoutFlutterFragment.REQUEST_KEY, this, new FragmentResultListener() {
            public void onFragmentResult(@NonNull String str, @NonNull Bundle bundle) {
                if (bundle.containsKey(BNPLCheckoutFlutterFragment.CARD_INFO_EXTRA)) {
                    CheckOutScreen.this.selectedCardInfo = (CardInfo) bundle.getParcelable(BNPLCheckoutFlutterFragment.CARD_INFO_EXTRA);
                    CheckOutScreen.this.placeOrderWithBNPL();
                } else if (bundle.containsKey(BNPLCheckoutFlutterFragment.OPTED_OUT_FROM_BNPL_FALLBACK_OPTION_EXTRA) && bundle.getBoolean(BNPLCheckoutFlutterFragment.OPTED_OUT_FROM_BNPL_FALLBACK_OPTION_EXTRA, false)) {
                    CheckOutScreen.this.clearSelectedRadioButtons();
                    if (CheckOutScreen.this.mAdapter != null) {
                        CheckOutScreen.this.mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
        this.launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            public void onActivityResult(ActivityResult activityResult) {
                if (activityResult.getResultCode() == 100) {
                    CheckOutScreen.this.handlePaymenError(activityResult.getData());
                }
            }
        });
    }

    public void onCurrentLocationReceived(boolean z11, Location location, float f11) {
        if (location != null) {
            this.currentLocation = this.S.createLatLng(location.getLatitude(), location.getLongitude());
        }
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (iCheckoutPresenter != null && location != null) {
            iCheckoutPresenter.currentLoactionAwareness(new com.google.android.gms.maps.model.LatLng(location.getLatitude(), location.getLongitude()));
        }
    }

    public void onDarkstoresDjiniError(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckOutScreen.this.finish();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public void onDataDecrypted(DecryptionResponse decryptionResponse) {
        stopLodingPopup();
        loadVisaCheckoutIcon(decryptionResponse.baseImageFileName);
        TextView textView = this.visaCheckoutTxt;
        textView.setText("xxxx-" + decryptionResponse.lastFourDigits);
        this.expiryLayout.setVisibility(0);
    }

    public void onDataDecryptionFailed(String str) {
        stopLodingPopup();
        this.expiryLayout.setVisibility(0);
        if (!TalabatUtils.isNullOrEmpty(this.lastFour)) {
            this.visaCheckoutTxt.setText(this.lastFour);
        } else {
            this.visaCheckoutTxt.setText(str);
        }
    }

    public void onDeliveryTimesLoaded(ArrayList<String> arrayList) {
        boolean z11;
        stopLodingPopup();
        if (this.cart.getRestaurant() != null) {
            if (this.cart.getRestaurant().hasPreOrderOnClosed || this.cart.getRestaurant().statusType == 5) {
                z11 = true;
            } else {
                z11 = false;
            }
            setPostDateOrderLayout(z11);
            this.f53840u = arrayList;
            if (this.f53841v) {
                this.f53841v = false;
                showBottomSheetForDeliveryTiming();
            }
        }
    }

    public void onDeliveryTimesNotavailable() {
    }

    public void onDestroy() {
        TalabatBugReportManager.INSTANCE.removeViewBlocking(this.editTextCvv);
        super.onDestroy();
    }

    public void onDuplicateOrder(String str, String str2, int i11, String str3) {
        stopNonCancelableLoading();
        this.popupWidth = this.screenWidth - (((int) getResources().getDimension(R.dimen.popup_outer_margin)) * 2);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.popupWidth, -2);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.duplicate_order_popup, (ViewGroup) null);
        Dialog dialog = new Dialog(this);
        this.duplicateOrderDialog = dialog;
        dialog.setContentView(inflate, layoutParams);
        this.duplicateOrderDialog.setTitle("");
        if (TalabatUtils.isNullOrEmpty(str)) {
            str = "";
        }
        ((TextView) this.duplicateOrderDialog.findViewById(R.id.duplicate_message)).setText(str);
        this.duplicateOrderDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                AppTracker.onDuplicateOrderPopupClosed(CheckOutScreen.this);
            }
        });
        final RadioButton radioButton = (RadioButton) this.duplicateOrderDialog.findViewById(R.id.modify_radio);
        final RadioButton radioButton2 = (RadioButton) this.duplicateOrderDialog.findViewById(R.id.view_order_radio);
        final RadioButton radioButton3 = (RadioButton) this.duplicateOrderDialog.findViewById(R.id.continue_radio);
        this.duplicateOrderPopupRadioGroup = new RadioButton[]{radioButton, radioButton2, radioButton3};
        View findViewById = this.duplicateOrderDialog.findViewById(R.id.modify_order_option);
        View findViewById2 = this.duplicateOrderDialog.findViewById(R.id.view_order);
        View findViewById3 = this.duplicateOrderDialog.findViewById(R.id.continue_order);
        final Button button = (Button) this.duplicateOrderDialog.findViewById(R.id.confirm);
        button.setEnabled(false);
        button.setAlpha(0.5f);
        ((ImageView) this.duplicateOrderDialog.findViewById(R.id.close_popup_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckOutScreen.this.checkoutPresenter.setCvv("", false);
                CheckOutScreen.this.duplicateOrderDialog.dismiss();
            }
        });
        findViewById.setVisibility(8);
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                radioButton.performClick();
            }
        });
        radioButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setEnabled(true);
                button.setAlpha(1.0f);
                CheckOutScreen.this.onPopupRadioClicked(radioButton);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setEnabled(true);
                button.setAlpha(1.0f);
                CheckOutScreen.this.onPopupRadioClicked(radioButton2);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setEnabled(true);
                button.setAlpha(1.0f);
                CheckOutScreen.this.onPopupRadioClicked(radioButton3);
            }
        });
        findViewById2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                radioButton2.performClick();
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                radioButton3.performClick();
            }
        });
        button.setOnClickListener(new h2(this, radioButton, radioButton2, str3, radioButton3));
        ((Button) this.duplicateOrderDialog.findViewById(R.id.home_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(CheckOutScreen.this, HomeScreenActivity.class);
                intent.addFlags(67108864);
                AppTracker.onDuplicateOrderPopupConfirmClicked(CheckOutScreen.this, "go_to_home");
                CheckOutScreen.this.startActivity(intent);
                if (CheckOutScreen.this.cart != null) {
                    CheckOutScreen.this.cart.clearCart(CheckOutScreen.this);
                }
                CheckOutScreen.this.duplicateOrderDialog.dismiss();
            }
        });
        try {
            this.duplicateOrderDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } catch (Exception unused) {
        }
        this.duplicateOrderDialog.setCancelable(false);
        AppTracker.onDuplicateOrderPopupShown(this);
        if (isValidContext(this)) {
            this.duplicateOrderDialog.show();
        }
    }

    public void onError() {
    }

    public void onFeesMismatchError(String str) {
        FeesMismatchErrorDialog.show((ViewGroup) this.parentLayout, str, new r2(this));
    }

    public void onGemError(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (GEMEngine.getInstance() != null) {
                    GEMEngine.getInstance().rejectGem(false);
                }
                CheckOutScreen.this.adjustGemView();
            }
        });
        builder.show();
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public void onGeneralError(int i11, String str) {
        if (this.checkoutPresenter.getPlaceOrderRequestModel().isDarkStore && Cart.getInstance().getDarkstoresCartId() != null && Cart.getInstance().getDarkstoresDjiniVendorId() != null) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresCheckoutFailure(Cart.getInstance().getDarkstoresCartId(), Cart.getInstance().getDarkstoresDjiniVendorId(), i11, str);
        }
    }

    public void onGetBinVoucher(@Nullable String str) {
        this.checkoutBinVoucherViewModel.onGetBinVoucher(new BinVoucherCheckEligibilityModel(isGemActive(), this.I.config().isBinCampAvailable(), isDarkStore(), str), getMobileForBin(), GlobalDataModel.SelectedAreaId, str, this.cart);
        this.requestedBinNumber = str;
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onItemClicked(@NotNull String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.f53842w = str;
            this.checkoutPresenter.setPostDatedOrder(true);
            setScheduleLaterLabel(getResources().getText(R.string.change));
            setPreOrderTitle(this.f53842w);
        }
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 == 4 && getSupportFragmentManager().getFragments().isEmpty()) {
            this.cart.removeBinDiscountIfApplied();
            finish();
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onLocationChanged() {
        triggerFeesUpdate();
    }

    public void onLoyaltyVoucherInfoReceived(LoyaltyVoucherRM loyaltyVoucherRM) {
        setVoucherView();
    }

    public void onMinimumOrderConditionForBINFailed(String str) {
        stopNonCancelableLoading();
        this.binApplied = true;
        removeBin();
    }

    public void onMixedPaymentCardSelected(TokenisationCreditCard tokenisationCreditCard) {
        this.selectedItem = tokenisationCreditCard;
        this.checkoutForceCVVVViewModel.onLoadCheckoutCVVPopUpStatus(tokenisationCreditCard.binNumber, this.balanceAmountToPay, true);
        Button button = this.confirmChoice;
        if (button != null) {
            button.setEnabled(true);
            this.confirmChoice.setAlpha(1.0f);
        }
    }

    public void onNullResponseReceived() {
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void onOrderCouponNotAvailable(String str, final boolean z11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.remove), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckOutScreen.this.checkoutPresenter.removeInvalidCoupon(z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((int) R.string.change_time, (DialogInterface.OnClickListener) null);
        }
        builder.show();
    }

    public void onOrderDetailsRecieved(OrderDetails orderDetails) {
        String str;
        stopLodingPopup();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) orderDetails);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) orderDetails);
        }
        Intent intent = new Intent(this, OrderDetailsScreen.class);
        intent.putExtra("value", str);
        intent.putExtra("statusBoolean", orderDetails.status);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    public void onOrderError(final int i11, String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (i11 == 58) {
                    AppTracker.onKNETFailureLghtboxClosed(CheckOutScreen.this);
                }
                dialogInterface.dismiss();
            }
        });
        builder.show();
        if (i11 == 58) {
            AppTracker.onKNETFailureLghtboxShown(this);
        }
    }

    public void onOrderItemNotAvailable(String str, final boolean z11, final InvalidItem[] invalidItemArr) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.view_cart), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckOutScreen.this.checkoutPresenter.removeInvalidItems(invalidItemArr, z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        }
        builder.show();
    }

    public void onOrderPromotionNotAvailable(String str, final boolean z11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.remove), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckOutScreen.this.checkoutPresenter.removeInvalidPromotion(z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((int) R.string.change_time, (DialogInterface.OnClickListener) null);
        }
        builder.show();
    }

    public void onOrderSucess(PlaceOrderResponse placeOrderResponse) {
        if (Cart.getInstance().getRiderTip() != 0.0d) {
            this.checkoutPaymentUpdateViewModel.onRiderTipGiven(placeOrderResponse.encryptedOrderId);
        }
        if (Customer.getInstance().isLoggedIn(getContext()) && this.selectedPaymentMethod == 3) {
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            customerInfo.talabatCredit = this.f53829j;
            Customer.getInstance().setCustomerInfo(customerInfo);
        }
        if (Cart.getInstance().isPickup()) {
            this.F.getRepository().setIsFirstPickupOrder();
        }
        Bundle bundleWithCommonValues = getBundleWithCommonValues(placeOrderResponse.transactionId, placeOrderResponse.encryptedOrderId, Boolean.valueOf(this.isPostDated), Boolean.valueOf(placeOrderResponse.isOrderSuccess), this.f53838s);
        bundleWithCommonValues.putBoolean("isFromAptimize", this.isFromAptimize);
        bundleWithCommonValues.putBoolean("isFromVisaCheckout", this.isFromVisaCheckout);
        OrderTrackingNavigator.navigateToOrderTracking((Context) this, bundleWithCommonValues, true);
        killCart();
        killMenuScreen();
        finish();
        stopNonCancelableLoading();
    }

    public void onOrderVoucherNotAvailable(String str, final boolean z11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckOutScreen.this.checkoutPresenter.removeInvalidVoucher(z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
        }
        builder.show();
    }

    public void onParallelBinAvailable(boolean z11) {
        int i11 = 8;
        if (isGemActive() || !z11 || this.checkoutPresenter.isPickup()) {
            this.parallelBinView.setVisibility(8);
            return;
        }
        TextView textView = this.parallelBinMore;
        if (GlobalDataModel.PARALLELBIN.moreBinModels.size() > 0) {
            i11 = 0;
        }
        textView.setVisibility(i11);
        this.parallelBinMore.setOnClickListener(new n2(this));
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
                        CheckOutScreen.this.parallelBinImage.setImageResource(R.drawable.ic_promo);
                        return false;
                    }

                    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
                        CheckOutScreen.this.parallelBinProgressBar.setVisibility(8);
                        return false;
                    }
                }).into(this.parallelBinImage);
            }
        } else {
            this.parallelBinImage.setImageResource(R.drawable.ic_promo);
        }
        this.parallelBinView.setAlpha(0.0f);
        this.parallelBinView.setVisibility(0);
        this.parallelBinView.animate().alpha(1.0f).setDuration(600).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                CheckOutScreen checkOutScreen = CheckOutScreen.this;
                AppTracker.onBinNotificationShown(checkOutScreen, checkOutScreen.getScreenName());
            }
        });
    }

    public void onPause() {
        if (!this.verificationPopupShown && !this.addCardPopupShown && GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            GEMEngine.getInstance();
            GEMEngine.stopListening();
        }
        super.onPause();
    }

    public void onPaymentMethodChosen(RadioButton radioButton) {
        onRadioButtonClicked(radioButton);
        onPaymentSelected(radioButton.getId());
        this.f53833n.setEnabled(true);
        this.checkoutForceCVVVViewModel.setShouldOpenForceCVVBottomSheet(false);
    }

    public void onPaymentMethodSelected(int i11) {
        if (isDarkStore()) {
            this.subtotal.setText(this.cart.getCartSubTotalDisplayPriceForDarkStore());
        } else {
            this.subtotal.setText(this.cart.getCartSubTotalDisplayPrice());
        }
        if (this.cart.isCouponApplied()) {
            this.coupon_discount_view.setVisibility(0);
            this.coupon_discount_value.setText(this.cart.getCouponDiscountDisplayAmount());
        } else if (!isDarkStore() || this.cart.getDarkStoreTotalDiscountToDisplay() <= 0.0f) {
            this.coupon_discount_view.setVisibility(8);
        } else {
            this.coupon_discount_view.setVisibility(0);
            TextView textView = this.coupon_discount_value;
            textView.setText("- " + TalabatFormatter.getInstance().getFormattedCurrency(this.cart.getDarkStoreTotalDiscountToDisplay()));
        }
        setTotalAmount();
    }

    public void onPlaceOrderLocalValidataionPassed() {
        showTalabatCreditView();
    }

    public void onPostDatedSelectionChanged(boolean z11) {
    }

    public void onReadMoreInfoClicked() {
        this.f53825a0.onReadMoreExternalInfoClicked(getScreenName());
    }

    public void onRedirectToAddressList() {
    }

    public void onRedirectToCartPage() {
        Intent intent = new Intent(this, CartScreen.class);
        intent.putExtra("from", "Checkout Screen");
        intent.putExtra(GlobalConstants.KEY_FROMCARDSCREEN, true);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void onRedirectToEditAddress(Address address) {
        String str;
        LogManager.info("UiTestInvestigation: onRedirectToEditAddress Called");
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) address);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) address);
        }
        Intent addressFormActivityIntent = FlutterAddressFormActivity.getAddressFormActivityIntent(getContext(), "checkout");
        addressFormActivityIntent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        addressFormActivityIntent.putExtra("isOrderFlow", true);
        addressFormActivityIntent.putExtra("isFromCheckout", true);
        addressFormActivityIntent.putExtra("noAreaChange", true);
        if (this.isGrlEnabled) {
            addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            addressFormActivityIntent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            addressFormActivityIntent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
            addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", this.isNewAddressCreationGlrFlow);
            addressFormActivityIntent.putExtra("address", str);
            addressFormActivityIntent.putExtra("isFromMcdAddressFlow", true);
            addressFormActivityIntent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
            addressFormActivityIntent.putExtra("value", str);
        } else {
            addressFormActivityIntent.putExtra("value", str);
            if (this.isMapcompulsory) {
                addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.IS_MAP_ENFORCE_FROM_CHECK_OUT, true);
            } else {
                addressFormActivityIntent.putExtra(GlobalConstants.FORCE_MAP.IS_MAP_ENFORCE_FROM_CHECK_OUT, false);
            }
            addressFormActivityIntent.putExtra("isAddressFromCartOrderFlow", this.isAddressFromCartOrderFlow);
            addressFormActivityIntent.putExtra("newaddressCreation", this.isNewAddressCreation);
            addressFormActivityIntent.putExtra("map_compulsory", this.isMapcompulsory);
            addressFormActivityIntent.putExtra("nineCookiesEnabled", this.isNineCookiesTrackingEnabled);
            addressFormActivityIntent.putExtra("talabatDeliveryAvailable", this.isTalabatDeliveryAvailable);
            addressFormActivityIntent.putExtra("isGlrEnabledRes", this.isGrlEnabled);
            addressFormActivityIntent.putExtra("isNewAddressCreationFromGrlFlow", this.isNewAddressCreationGlrFlow);
            addressFormActivityIntent.putExtra(GlobalConstants.ExtraNames.EDIT, true);
        }
        addressFormActivityIntent.putExtra("isEditAddressFlowFromCheckout", true);
        startActivity(addressFormActivityIntent);
    }

    public void onRedirectToPaymentErrorForVisa(String str) {
        this.isGateWayError = false;
        stopNonCancelableLoading();
        this.f53835p = str;
        callPaymentErrorIntent();
    }

    public void onRedirectToPaymentPage(PlaceOrderResponse placeOrderResponse, String str, String str2, int i11) {
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (iCheckoutPresenter != null) {
            iCheckoutPresenter.setPlaceOrderResponse(placeOrderResponse);
        }
        Intent intent = new Intent(this, PaymentWebViewScreen.class);
        intent.putExtra("title", this.title);
        intent.putExtra("url", str);
        intent.putExtra("paymenttransactionId", str2);
        if (this.selectedPaymentMethod == 2 && getTokenProvider() == 2) {
            intent.putExtra("isFromCheckout", true);
        }
        startActivityForResult(intent, 300);
        stopNonCancelableLoading();
    }

    public void onRedirectToRestaurantList() {
        resetVisaCheckoutInstance();
        this.cart.removeVoucherIfApplied();
        this.cart.removeBinDiscountIfApplied();
        startActivity(new Intent(this, RestaurantsListScreenRefactor.class));
    }

    public void onRequestError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onRequestException(boolean z11) {
        stopNonCancelableLoading();
        if (z11) {
            Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onResponseRecieved() {
    }

    public void onResume() {
        if (this.cart == null) {
            this.cart = Cart.getInstance();
        }
        this.cart.recalcualteTotal();
        this.cart.updateCartAreaInfo(GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedAreaName);
        if (isPreOrderForRamadan()) {
            this.checkoutPresenter.setPostDatedOrder(true);
            this.f53833n.setText(getResources().getText(R.string.place_preorder));
            if (TalabatUtils.isNullOrEmpty(this.f53842w)) {
                setPreOrderTitle(getResources().getText(R.string.order_for_later));
                setScheduleLaterLabel(getResources().getText(R.string.schedule));
            } else {
                setPreOrderTitle(this.f53842w);
                setScheduleLaterLabel(getResources().getText(R.string.change));
            }
        } else {
            this.f53833n.setText(this.postOrderButtonText);
            if (TalabatUtils.isNullOrEmpty(this.f53842w)) {
                this.checkoutPresenter.setPostDatedOrder(false);
                setScheduleLaterLabel(getResources().getText(R.string.schedule));
                setPreOrderTitle(getDeliveryTimeLabel());
            } else {
                this.checkoutPresenter.setPostDatedOrder(true);
                setScheduleLaterLabel(getResources().getText(R.string.change));
                setPreOrderTitle(this.f53842w);
            }
        }
        if (this.checkoutPresenter.shouldHideOrderNowForGroceryScheduledDelivery()) {
            hideOrderNowForGroceryScheduledDelivery();
        }
        if (this.I.config().isBinCampAvailable() && !isDarkStore() && !TalabatUtils.isNullOrEmpty(GlobalDataModel.BIN.stoppedBinNumber)) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Customer.getInstance().getSavedCards());
            Iterator it = arrayList.iterator();
            boolean z11 = false;
            while (it.hasNext()) {
                TokenisationCreditCard tokenisationCreditCard = (TokenisationCreditCard) it.next();
                if (tokenisationCreditCard.binNumber.equals(GlobalDataModel.BIN.stoppedBinNumber)) {
                    tokenisationCreditCard.isBinDiscountValid = false;
                    z11 = true;
                }
            }
            Customer.getInstance().setSavedCreditCards((TokenisationCreditCard[]) arrayList.toArray(new TokenisationCreditCard[arrayList.size()]));
            ArrayList<TokenisationCreditCard> arrayList2 = GlobalDataModel.BIN.savedTokens;
            if (arrayList2 != null && arrayList2.size() > 0) {
                GlobalDataModel.BIN.savedTokens.clear();
            }
            GlobalDataModel.BIN.savedTokens = Customer.getInstance().getSavedCards();
            if (z11) {
                this.mAdapter.updateList(Customer.getInstance().getSavedCards());
                this.mAdapter.notifyDataSetChanged();
            }
        }
        if (GlobalDataModel.BIN.numberUpdated) {
            GlobalDataModel.BIN.numberUpdated = false;
            updateAddressMobileNumber(GlobalDataModel.BIN.updatedNumber);
            GlobalDataModel.BIN.updatedNumber = "";
        }
        if (this.isCheckoutDotCom) {
            this.isCheckoutDotCom = false;
            resetPaymentViews();
        }
        adjustGemView();
        Restaurant restaurant = this.cart.getRestaurant();
        if (restaurant != null) {
            if (GlobalDataModel.PLACEORDER.foundInvalidVoucher) {
                GlobalDataModel.PLACEORDER.foundInvalidVoucher = false;
                ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
                if (iCheckoutPresenter != null) {
                    iCheckoutPresenter.setPaymentView(restaurant, this.isQuick);
                }
                enableTalabatCreditCashbackView();
            }
            if (GlobalDataModel.PLACEORDER.foundInvalidCoupon) {
                GlobalDataModel.PLACEORDER.foundInvalidCoupon = false;
                ICheckoutPresenter iCheckoutPresenter2 = this.checkoutPresenter;
                if (iCheckoutPresenter2 != null) {
                    iCheckoutPresenter2.setPaymentView(restaurant, this.isQuick);
                }
            }
            if (GlobalDataModel.PLACEORDER.foundInvalidPromotion) {
                GlobalDataModel.PLACEORDER.foundInvalidPromotion = false;
                ICheckoutPresenter iCheckoutPresenter3 = this.checkoutPresenter;
                if (iCheckoutPresenter3 != null) {
                    iCheckoutPresenter3.setPaymentView(restaurant, this.isQuick);
                }
            }
        }
        if (isVisaCheckoutEnabled()) {
            initialiseVisaCheckout();
            if (TalabatUtils.isNullOrEmpty(GlobalDataModel.callId)) {
                this.expiryLayout.setVisibility(8);
                this.visaCheckoutTxt.setText(getResources().getString(R.string.visa_checkout));
                loadVisaCheckoutIcon("");
            } else {
                this.expiryLayout.setVisibility(0);
                this.f53833n.setVisibility(0);
                this.expandableLinearLayout.collapse(300, Utils.createInterpolator(0));
            }
        }
        this.checkoutPresenter.removeInvalidVouchers();
        this.benefitManagerViewModel.onPayWithDebitCardClicked();
        super.onResume();
        setConfiguration();
    }

    public void onSendCVVToProxyServer(RecurringPurchaseRequest recurringPurchaseRequest, int i11) {
        this.payProxyManagerViewModel.onSendCVVToProxy(recurringPurchaseRequest, i11);
    }

    public void onServerError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onStop() {
        this.selectedItem = null;
        if (GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            showTimerView(true, "");
        }
        this.cart.setVoucherRedeemedinCheckout(false);
        super.onStop();
    }

    public void onSubmitTracking(boolean z11, boolean z12) {
        this.bnplManagerViewModel.onBNPLFakeTestSubmitted(z11, z12);
    }

    public void onSuccessfulRecurringCheckoutDotCom() {
        if (Customer.getInstance().isLoggedIn(getContext()) && this.selectedPaymentMethod == 3) {
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            customerInfo.talabatCredit = this.f53829j;
            Customer.getInstance().setCustomerInfo(customerInfo);
        }
        if (isGemActive()) {
            withGemAnalytics().onOrderComplete(this.transactionId);
        }
        Bundle bundleWithCommonValues = getBundleWithCommonValues(this.transactionId, this.encryptedOrderId, Boolean.valueOf(this.isPostDated), Boolean.TRUE, this.f53838s);
        bundleWithCommonValues.putString("paymentMethod", this.paymnentMethod);
        bundleWithCommonValues.putBoolean("isFromCheckoutDotCom", true);
        OrderTrackingNavigator.navigateToOrderTracking((Context) this, bundleWithCommonValues, true);
        killCart();
        killMenuScreen();
        finish();
        stopNonCancelableLoading();
    }

    public void onUpdateBNPLCartBinVoucher() {
        this.checkoutBinVoucherViewModel.setBinVoucherRequestFromBNPL(false);
        this.binApplied = true;
        this.isBinDiscountAppliedForTracking = true;
        BNPLPlaceOrderBottomSheet bNPLPlaceOrderBottomSheet = this.bnplPlaceOrderBottomSheet;
        if (bNPLPlaceOrderBottomSheet != null) {
            bNPLPlaceOrderBottomSheet.updateBNPLPaymentDetail();
        }
    }

    public void onUserTypeErrorForDiscount(String str) {
        this.cart.removeTgoFreeDeliveryTiers();
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new g4(this));
        builder.show();
    }

    public void onValidationError(int i11, int i12, boolean z11) {
        this.selectedPaymentMethod = i12;
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        if (i11 == 0) {
            builder.setMessage((int) R.string.choose_address_for_del);
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        } else if (i11 == 1) {
            if (z11) {
                this.checkoutPresenter.setPaymentMethod(this.selectedPaymentMethod);
                resetPaymentViews();
            }
            builder.setMessage((CharSequence) getString(R.string.choose_delivery_time));
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CheckOutScreen.this.onScheduleLaterClick();
                }
            });
        } else if (i11 == 2) {
            builder.setMessage((CharSequence) getString(R.string.choose_payment_method));
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        } else if (i11 == 302) {
            builder.setMessage((CharSequence) getString(R.string.please_swipe_visa_button));
            builder.setPositiveButton((int) R.string.f54881ok, (DialogInterface.OnClickListener) null);
        }
        builder.show();
    }

    public void onVisaCheckoutOrderPlaced(Purchase purchase, String str, String str2) {
        this.transactionId = str;
        this.encryptedOrderId = str2;
        this.checkoutPresenter.onVisaCheckoutDetailsReceived(str, GlobalDataModel.callId);
    }

    public void openBNPLTrackingBottomSheet() {
        this.checkoutPresenter.setSelectedPaymentMethodForGA(11);
        if (this.bnplManagerViewModel.getBnplFakeTestAttemptedData().getValue() == BNPLFakeDoorTestAttemptedState.NOT_ATTEMPTED) {
            new BNPLPlaceOrderBottomSheet(this, (BNPLPlan) null, (BNPLPlaceOrderBottomSheetInterface) null, (String) null).show();
        }
    }

    public void placeOrderWithBNPL() {
        this.checkoutPresenter.paymentMethodSelected(11);
        this.selectedPaymentMethod = 11;
        this.bnplManagerViewModel.setBNPLPlaceOrderClicked(true);
        this.f53833n.performClick();
    }

    public void placeOrderWithDebitCard() {
        this.debitCard.performClick();
        this.f53833n.performClick();
    }

    public void populateUserSelctedCreditCardView(boolean z11, TokenisationCreditCard tokenisationCreditCard) {
        payfortPaymentView(z11, tokenisationCreditCard);
    }

    public void prepareUIViewsForBNPL() {
        this.payByCash.setVisibility(0);
        this.f53833n.setVisibility(0);
        this.expandableLinearLayout.collapse(300, Utils.createInterpolator(0));
    }

    public void proceedWithPlaceOrder() {
        if (this.V.isTPro() || !this.C.isSubscriptionOnCheckoutSelectorChecked() || getSelectedPaymentMethod() != 2) {
            HashMap hashMap = new HashMap();
            try {
                hashMap.put("CartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
                hashMap.put("CartDeliveryCharges", String.valueOf(Cart.getInstance().getDeliveryCharges()));
                hashMap.put("UserId", String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
                this.K.track("not_subscribe_before_order", "tpro", hashMap);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            makePaymentForPlaceOrder();
            return;
        }
        this.checkoutPresenter.sendSubscriptionAttemptedEvent();
        TokenisationCreditCard selectedCreditCard = Customer.getInstance().getSelectedCreditCard();
        if (isCardExpired(selectedCreditCard.expiremonth, selectedCreditCard.expireyear)) {
            showCardExpiredErrorToast();
            return;
        }
        showLoader();
        String planId2 = this.C.getPlanId();
        this.planId = planId2;
        String str = selectedCreditCard.tokenId;
        String str2 = selectedCreditCard.cardnumber;
        CardInformation cardInformation = new CardInformation(planId2, str, str2.substring(str2.length() - 4), selectedCreditCard.cardtype, 3, Integer.toString(selectedCreditCard.expiremonth), Integer.toString(selectedCreditCard.expireyear));
        HashMap hashMap2 = new HashMap();
        try {
            hashMap2.put("CartSubTotal", String.valueOf(Cart.getInstance().getCartTotalPrice()));
            hashMap2.put("CartDeliveryCharges", String.valueOf(Cart.getInstance().getDeliveryCharges()));
            hashMap2.put("UserId", String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
            this.K.track("subscribe_before_order", "tpro", hashMap2);
        } catch (Exception e12) {
            e12.printStackTrace();
        }
        this.checkoutPresenter.postSubscriptionPayment(cardInformation);
    }

    public void redirectToPaymentWebViewForVisaCheckout(PurchaseResponse purchaseResponse) {
        stopNonCancelableLoading();
        Intent intent = new Intent(this, PaymentWebViewScreen.class);
        intent.putExtra("title", getString(R.string.credit_card_payment));
        intent.putExtra("url", purchaseResponse.redirectUrl);
        intent.putExtra("paymenttransactionId", this.transactionId);
        intent.putExtra("isFromVisaCheckout", true);
        startActivityForResult(intent, 300);
        resetVisaCheckoutInstance();
    }

    public void refreshSavedCardList(ArrayList<TokenisationCreditCard> arrayList, String str) {
        if (this.mAdapter != null) {
            startLodingPopup();
            this.mAdapter.updateList(arrayList);
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void removeCashPayment() {
        this.cashLayout.setVisibility(8);
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    public void savedCreditCardListLoaded(ArrayList<TokenisationCreditCard> arrayList) {
        this.tokenisationCreditCards = new ArrayList<>();
        if (arrayList == null) {
            this.cardList.setVisibility(8);
        } else if (arrayList.size() > 0) {
            Iterator<TokenisationCreditCard> it = arrayList.iterator();
            while (it.hasNext()) {
                TokenisationCreditCard next = it.next();
                if (next.isValidCard) {
                    this.tokenisationCreditCards.add(next);
                }
            }
            this.cardList.setVisibility(0);
            if (this.mAdapter == null) {
                this.mAdapter = new SavedCardRecyclerViewAdapter(this, this.tokenisationCreditCards, this);
                this.cardList.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                this.cardList.setAdapter(this.mAdapter);
            }
        }
    }

    public void sendCVVToCheckoutScreen(@NotNull String str) {
        this.checkoutPresenter.setCvv(str, false);
        this.checkoutForceCVVVViewModel.onProceedToPayment();
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01d0  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setAddressView(com.talabat.domain.address.Address r10) {
        /*
            r9 = this;
            android.view.View r0 = r9.mAddressViewContainerMap
            r1 = 8
            r0.setVisibility(r1)
            android.view.View r0 = r9.mAddressViewContainer
            r2 = 0
            r0.setVisibility(r2)
            android.widget.TextView r0 = r9.mDeliveryAddressTitle
            r3 = 2132017695(0x7f14021f, float:1.9673676E38)
            java.lang.String r3 = r9.getString(r3)
            r0.setText(r3)
            android.content.Intent r0 = r9.getIntent()
            java.lang.String r3 = "appendedName"
            java.lang.String r0 = r0.getStringExtra(r3)
            buisnessmodels.Customer r3 = buisnessmodels.Customer.getInstance()
            datamodels.CustomerInfo r3 = r3.getCustomerInfo()
            buisnessmodels.Customer r4 = buisnessmodels.Customer.getInstance()
            android.content.Context r5 = r9.getContext()
            boolean r4 = r4.isLoggedIn(r5)
            if (r4 == 0) goto L_0x0042
            if (r3 == 0) goto L_0x0042
            java.lang.String r3 = r3.getName()
            r9.f53838s = r3
            goto L_0x0044
        L_0x0042:
            r9.f53838s = r0
        L_0x0044:
            java.lang.String r3 = r10.profileName
            boolean r3 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r3)
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0050
            r3 = r4
            goto L_0x0052
        L_0x0050:
            java.lang.String r3 = r10.profileName
        L_0x0052:
            com.talabat.configuration.ConfigurationLocalRepository r5 = r9.E
            com.talabat.configuration.location.LocationConfigurationRepository r6 = r9.G
            datamodels.Country r5 = com.talabat.helpers.TalabatUtils.getSelectedCountry(r5, r6)
            java.lang.String r6 = ")"
            java.lang.String r7 = " ("
            if (r5 == 0) goto L_0x00ac
            boolean r5 = r5.isCityInAddress
            if (r5 == 0) goto L_0x00ac
            int r5 = r10.cityId
            if (r5 <= 0) goto L_0x00cd
            com.talabat.configuration.ConfigurationLocalRepository r4 = r9.E
            com.talabat.configuration.location.LocationConfigurationRepository r8 = r9.G
            java.lang.String r4 = com.talabat.helpers.TalabatUtils.getCityName(r5, r4, r8)
            boolean r5 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r3)
            java.lang.String r8 = ", "
            if (r5 == 0) goto L_0x008d
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r10.areaName
            r3.append(r5)
            r3.append(r8)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L_0x00aa
        L_0x008d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r3)
            r5.append(r7)
            java.lang.String r3 = r10.areaName
            r5.append(r3)
            r5.append(r8)
            r5.append(r4)
            r5.append(r6)
            java.lang.String r3 = r5.toString()
        L_0x00aa:
            r4 = r3
            goto L_0x00cd
        L_0x00ac:
            boolean r4 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r3)
            if (r4 == 0) goto L_0x00b5
            java.lang.String r3 = r10.areaName
            goto L_0x00aa
        L_0x00b5:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r3)
            r4.append(r7)
            java.lang.String r3 = r10.areaName
            r4.append(r3)
            r4.append(r6)
            java.lang.String r3 = r4.toString()
            goto L_0x00aa
        L_0x00cd:
            boolean r3 = r9.isQuick
            if (r3 == 0) goto L_0x00f7
            android.widget.TextView r3 = r9.addressName
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r0)
            java.lang.String r0 = "\n"
            r5.append(r0)
            r5.append(r4)
            java.lang.String r0 = r5.toString()
            r3.setText(r0)
            android.widget.TextView r0 = r9.changeAddress
            r0.setVisibility(r1)
            android.widget.ImageView r0 = r9.mQuickAddressArrow
            if (r0 == 0) goto L_0x0108
            r0.setVisibility(r1)
            goto L_0x0108
        L_0x00f7:
            android.widget.TextView r0 = r9.addressName
            r0.setText(r4)
            android.widget.TextView r0 = r9.changeAddress
            r0.setVisibility(r2)
            android.widget.ImageView r0 = r9.mQuickAddressArrow
            if (r0 == 0) goto L_0x0108
            r0.setVisibility(r2)
        L_0x0108:
            android.widget.TextView r0 = r9.addressDescription
            int r3 = com.talabat.helpers.GlobalDataModel.SelectedCountryId
            com.talabat.configuration.country.Country r4 = com.talabat.configuration.country.Country.LEBANON
            int r4 = r4.getCountryId()
            if (r3 != r4) goto L_0x0115
            r2 = 1
        L_0x0115:
            java.lang.String r2 = com.talabat.domain.address.AddressesKt.description(r10, r2)
            r0.setText(r2)
            java.lang.String r0 = r10.mobileNumber
            r9.quickUserMobile = r0
            com.talabat.configuration.ConfigurationLocalRepository r0 = r9.E
            com.talabat.configuration.location.LocationConfigurationRepository r2 = r9.G
            boolean r0 = com.talabat.helpers.TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(r0, r2)
            r2 = 2132017292(0x7f14008c, float:1.9672858E38)
            if (r0 == 0) goto L_0x017a
            java.lang.String r0 = r10.mobilNumberCountryCode
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
            if (r0 != 0) goto L_0x015f
            android.widget.TextView r0 = r9.mobileNumber
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r9.getString(r2)
            r3.append(r2)
            java.lang.String r2 = " +"
            r3.append(r2)
            java.lang.String r2 = r10.mobilNumberCountryCode
            r3.append(r2)
            java.lang.String r2 = "  "
            r3.append(r2)
            java.lang.String r2 = r10.mobileNumber
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.setText(r2)
            goto L_0x0194
        L_0x015f:
            android.widget.TextView r0 = r9.mobileNumber
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r9.getString(r2)
            r3.append(r2)
            java.lang.String r2 = r10.mobileNumber
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.setText(r2)
            goto L_0x0194
        L_0x017a:
            android.widget.TextView r0 = r9.mobileNumber
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = r9.getString(r2)
            r3.append(r2)
            java.lang.String r2 = r10.mobileNumber
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.setText(r2)
        L_0x0194:
            java.lang.String r0 = r10.phoneNumber
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
            if (r0 == 0) goto L_0x01a2
            android.widget.TextView r0 = r9.phoneNumber
            r0.setVisibility(r1)
            goto L_0x01c4
        L_0x01a2:
            android.widget.TextView r0 = r9.phoneNumber
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 2132017294(0x7f14008e, float:1.9672862E38)
            java.lang.String r3 = r9.getString(r3)
            r2.append(r3)
            java.lang.String r3 = " "
            r2.append(r3)
            java.lang.String r3 = r10.phoneNumber
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.setText(r2)
        L_0x01c4:
            java.lang.String r0 = r10.mobileNumber
            r9.mobileForBin = r0
            java.lang.String r10 = r10.extraDirections
            boolean r10 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r10)
            if (r10 == 0) goto L_0x01d6
            android.widget.TextView r10 = r9.directions
            r10.setVisibility(r1)
            goto L_0x01db
        L_0x01d6:
            android.widget.TextView r10 = r9.directions
            r10.setVisibility(r1)
        L_0x01db:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.CheckOutScreen.setAddressView(com.talabat.domain.address.Address):void");
    }

    public void setAddressViewMap(Address address) {
        String str;
        String str2;
        boolean z11 = false;
        this.mAddressViewContainerMap.setVisibility(0);
        this.mAddressViewContainer.setVisibility(8);
        this.mDeliveryAddressTitle.setText(getString(R.string.checkout_delivery_address_details));
        String stringExtra = getIntent().getStringExtra("appendedName");
        double d11 = address.latitude;
        if (d11 > 0.0d) {
            double d12 = address.longitude;
            if (d12 > 0.0d) {
                loadDeliveryAddressMap(this.S.createLatLng(d11, d12));
            }
        }
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        if (!Customer.getInstance().isLoggedIn(getContext()) || customerInfo == null) {
            this.f53838s = stringExtra;
        } else {
            this.f53838s = customerInfo.getName();
        }
        if (TalabatUtils.isNullOrEmpty(address.profileName)) {
            str = "";
        } else {
            str = address.profileName;
        }
        TalabatUtils.getSelectedCountry(this.E, this.G);
        if (TalabatUtils.isNullOrEmpty(str)) {
            str2 = address.areaName;
        } else {
            str2 = str + " (" + address.areaName + ")";
        }
        if (this.isQuick) {
            this.mAddressNameAb.setText(stringExtra + StringUtils.LF + str2);
            this.changeAddress.setVisibility(8);
            ImageView imageView = this.mQuickAddressArrow;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
        } else {
            this.mAddressNameAb.setText(str2);
            this.changeAddress.setVisibility(0);
            ImageView imageView2 = this.mQuickAddressArrow;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        TextView textView = this.mAddressDescriptionAb;
        if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.LEBANON.getCountryId()) {
            z11 = true;
        }
        textView.setText(AddressesKt.description(address, z11));
        this.quickUserMobile = address.mobileNumber;
        if (!TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.E, this.G)) {
            this.mMobileNumberLabel.setText(getString(R.string.address_mobile));
            this.mMobileNumberAb.setText(address.mobileNumber);
            this.mMobileCountryCode.setVisibility(8);
        } else if (!TalabatUtils.isNullOrEmpty(address.mobilNumberCountryCode)) {
            this.mMobileNumberLabel.setText(getString(R.string.address_mobile));
            this.mMobileNumberAb.setText(address.mobileNumber);
            this.mMobileCountryCode.setText("+" + address.mobilNumberCountryCode);
        } else {
            this.mMobileNumberLabel.setText(getString(R.string.address_mobile));
            this.mMobileNumberAb.setText(address.mobileNumber);
            this.mMobileCountryCode.setVisibility(8);
        }
        if (TalabatUtils.isNullOrEmpty(address.phoneNumber)) {
            this.mPhoneNumberAb.setVisibility(8);
        } else {
            this.mPhoneNumberAb.setText(getString(R.string.address_phone) + " " + address.phoneNumber);
        }
        this.mobileForBin = address.mobileNumber;
        if (TalabatUtils.isNullOrEmpty(address.extraDirections)) {
            this.mDirectionsAb.setVisibility(8);
        } else {
            this.mDirectionsAb.setVisibility(8);
        }
        if (this.checkoutPresenter.isPickup()) {
            this.mAddressDescriptionAb.setVisibility(8);
            this.mobileContainer.setVisibility(8);
            this.mAddressNameAb.setText(getSpannableAddress());
            this.mAreaNameAb.setVisibility(8);
        }
    }

    public void setAltTextDeliveryCharges(String str) {
        TextView textView = (TextView) findViewById(R.id.delivery_charges_text);
        if (textView != null) {
            FeeValue feeValue = this.deliveryFeeCache;
            if (feeValue == null || feeValue.getTagLabel() == null) {
                textView.setText(str);
            } else {
                textView.setText(this.deliveryFeeCache.getLabel());
            }
        }
    }

    public void setAltTextMuncipalityTax(String str) {
        TextView textView = (TextView) findViewById(R.id.muncipality_charges_text);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setAltTextTouristTax(String str) {
        TextView textView = (TextView) findViewById(R.id.tourist_tax_text);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setBenefitLabel() {
        this.payByMethod.setText(getString(R.string.pay_by).replace("#", getResources().getString(R.string.benefit)));
        this.debitCardLabelTxt.setText(getString(R.string.benefit));
        this.debitIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ds_benefit));
    }

    public void setChangeAddressBtn(boolean z11, boolean z12) {
        if (!this.isQuick) {
            int i11 = 0;
            if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                TextView textView = this.changeAddress;
                if (!z12) {
                    i11 = 8;
                }
                textView.setVisibility(i11);
            } else {
                TextView textView2 = this.changeAddress;
                if (z11) {
                    i11 = 8;
                }
                textView2.setVisibility(i11);
            }
            if (this.checkoutPresenter.isPickup()) {
                this.changeAddress.setVisibility(8);
            }
        }
    }

    public void setDebitCardLabel() {
        this.payByMethod.setText(getString(R.string.pay_by).replace("#", getString(R.string.debit_card)));
        this.debitCardLabelTxt.setText(getString(R.string.debit_card));
        this.debitIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_debit_card));
    }

    public void setDeliveryCharges(String str, @NonNull String str2) {
        FeeValue feeValue = this.deliveryFeeCache;
        if (feeValue == null || feeValue.getTagLabel() == null) {
            if (str2.equals("d")) {
                str2 = getString(R.string.restaurant_del_charges);
            } else if (str2.equals("t")) {
                str2 = getString(R.string.talabat_charges);
            }
            this.deliveryChargesText.setText(str2);
            setDeliveryView(str);
            return;
        }
        this.deliveryChargesText.setText(this.deliveryFeeCache.getLabel());
        setDeliveryView(this.deliveryFeeCache.getStandardFee());
    }

    public void setDescalimer(String str) {
        this.checkout_disclaimer_view.setVisibility(0);
        this.checkout_disclaimer_text.setText(str.trim());
    }

    public void setEncryptedOrderId(String str) {
        this.encryptedOrderId = str;
    }

    public void setFreeDeliveryReturn(String str, TProOrderStatus tProOrderStatus) {
        ApplyVouchersView applyVouchersView;
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatFeatureFlagConstants.BRAND_UPDATES, false, TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.freeDeliveryText.setCompoundDrawablesRelativeWithIntrinsicBounds((Drawable) null, (Drawable) null, getDrawable(R.drawable.bg_vendor_pro_tag_blue), (Drawable) null);
            this.freeDeliveryText.setTextColor(getColor(R.color.new_brand_blue));
            this.freeDeliveryReturnValue.setTextColor(getColor(R.color.new_brand_blue));
        }
        int visibility = this.freeDeliveryView.getVisibility();
        if (tProOrderStatus.isFreeDelivery()) {
            this.freeDeliveryView.setVisibility(0);
            this.freeDeliveryReturnValue.setText(str);
            TextView textView = this.freeDeliveryReturnValue;
            textView.setPaintFlags(textView.getPaintFlags() | 16);
            setTotalAmount();
        } else {
            this.freeDeliveryView.setVisibility(8);
        }
        updateDeliveryFeeVisibility(this.checkoutPresenter.isPickup(), tProOrderStatus.isFreeDelivery());
        if (tProOrderStatus.getShouldShowTProPromotion()) {
            this.savingsView.setVisibility(0);
            if (tProOrderStatus.isFreeDelivery()) {
                this.savingsView.setBackgroundColor(getColor(R.color.savings_view_background));
                this.freeDeliverySavingsText.setVisibility(0);
                this.freeDeliverySavingsText.setText(getString(R.string.free_delivery_savings, new Object[]{str}));
                this.freeDeliveryMore.setVisibility(8);
            } else {
                this.savingsView.setBackgroundColor(getColor(R.color.new_brand_blue));
                this.freeDeliverySavingsText.setVisibility(8);
                this.freeDeliveryMore.setVisibility(0);
                this.freeDeliveryMore.setText(getString(R.string.free_delivery_savings_not_enough, new Object[]{TalabatFormatter.getInstance().getFormattedCurrency((float) Math.abs(tProOrderStatus.getMovDifference()), true)}));
            }
        } else {
            this.savingsView.setVisibility(8);
        }
        if (visibility != this.freeDeliveryView.getVisibility() && (applyVouchersView = this.loyaltyDashboardApplyVouchersView) != null) {
            applyVouchersView.refreshAllVoucher();
        }
    }

    public void setGemOfferCharge() {
        this.gemOfferValue.setText(this.cart.getGemOfferDisplayAmount());
        updateTextColor();
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow || GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice <= 0.0f) {
            this.gemDiscountView.setVisibility(8);
        } else {
            this.gemDiscountView.setVisibility(0);
        }
    }

    @VisibleForTesting
    public void setICheckoutPresenter(ICheckoutPresenter iCheckoutPresenter) {
        this.checkoutPresenter = iCheckoutPresenter;
    }

    public void setKNetLabel() {
        this.payByMethod.setText(getString(R.string.pay_by).replace("#", getResources().getString(R.string.knet)));
        this.debitIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.icon_tokenization_knet));
        this.debitCardLabelTxt.setText(getString(R.string.knet));
    }

    public void setMuncipalityTaxView(String str) {
        findViewById(R.id.muncipality_charges_view).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.muncipality_charges_value);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setPaymentView(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i11, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        boolean z21;
        this.isTokenisationAvaliable = z14;
        datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.E, this.G);
        if (selectedCountry != null) {
            z19 = selectedCountry.enableTalabtCredit;
        } else {
            z19 = false;
        }
        if (!z19 || !Customer.getInstance().isLoggedIn(getContext()) || ((!z13 && !z12) || Customer.getInstance().getCustomerInfo() == null || Customer.getInstance().getCustomerInfo().talabatCredit <= 0.0f)) {
            z21 = false;
        } else {
            z21 = true;
        }
        if (isDarkStore()) {
            this.subtotal.setText(this.cart.getCartSubTotalDisplayPriceForDarkStore());
        } else {
            this.subtotal.setText(this.cart.getCartSubTotalDisplayPrice());
        }
        if (this.cart.isCouponApplied()) {
            this.coupon_discount_view.setVisibility(0);
            this.coupon_discount_value.setText(this.cart.getCouponDiscountDisplayAmount());
        } else if (!isDarkStore() || this.cart.getDarkStoreTotalDiscountToDisplay() <= 0.0f) {
            this.coupon_discount_view.setVisibility(8);
        } else {
            this.coupon_discount_view.setVisibility(0);
            this.coupon_discount_value.setText("- " + TalabatFormatter.getInstance().getFormattedCurrency(this.cart.getDarkStoreTotalDiscountToDisplay()));
        }
        setTotalAmount();
        if (z17) {
            this.cashLayout.setVisibility(0);
        } else {
            this.cashLayout.setVisibility(8);
        }
        if (!z17 || !z11) {
            this.cashLayout.setVisibility(8);
        } else {
            this.cashLayout.setVisibility(0);
        }
        if (this.checkoutPresenter.isPickup()) {
            this.cashLayout.setVisibility(8);
            this.L.getFeatureFlag((FWFKey) VendorListFeatureFlagsKeys.PICKUP_VL_ENABLE_CASH_PAYMENT, false, true, (Function1<? super Boolean, Unit>) new i4(this));
            this.postDateDelivery.setVisibility(8);
            this.pickupTimeContainer.setVisibility(0);
            if (!this.cart.getPickupTime().contains(getString(R.string.mins_))) {
                this.pickupTime.setText(getString(R.string.pickupTimeFormat, new Object[]{this.cart.getPickupTime(), getString(R.string.mins_)}));
            } else {
                this.pickupTime.setText(this.cart.getPickupTime());
            }
            this.riderTipChargesView.setVisibility(8);
            this.pickupText.setVisibility(0);
            this.changeAddress.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(8);
        } else {
            this.pickupText.setVisibility(8);
        }
        this.checkoutPresenter.getTProOrderStatus(new j4(this), false, false);
        if (z12) {
            this.debitLayout.setVisibility(0);
        } else {
            this.debitLayout.setVisibility(8);
        }
        if (!z12 && (!z13 || this.checkoutPresenter.isPickup())) {
            hideContactlessFeature();
        } else if (isContactlessEnabledCountry()) {
            showContactlessFeatureIfAvailable();
        } else {
            hideContactlessFeature();
        }
        if (z21) {
            showTalabatCreditView();
            if (!isCashbackEnabledCountry()) {
                this.availableCredit.setVisibility(0);
            } else {
                this.availableCredit.setVisibility(8);
            }
            this.availableCreditValue.setText(TalabatFormatter.getInstance().getFormattedCurrency(Customer.getInstance().getCustomerInfo().talabatCredit));
            this.newTalabatCreditView.setVisibility(0);
            this.paymentOptionsTitle.setText(getResources().getText(R.string.payment_methods));
        } else {
            this.newTalabatCreditView.setVisibility(8);
            this.availableCredit.setVisibility(8);
            this.paymentOptionsTitle.setText(getResources().getText(R.string.payment_methods));
        }
        if (!z12 && !z13) {
            ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
            if (iCheckoutPresenter != null) {
                iCheckoutPresenter.setDefaultPaymentMethodForGA("cash");
            }
            this.cash.performClick();
        }
        if (!isVisaCheckoutEnabled() || !isVisaSDKSupportedVersion()) {
            this.visaCheckoutLayout.setVisibility(8);
        } else {
            this.visaCheckoutLayout.setVisibility(0);
        }
        if (!z13 || !z14) {
            if (z13) {
                this.creditLayout.setVisibility(0);
            }
            this.selectedCardView.setVisibility(8);
            this.checkoutdotLayout.setVisibility(8);
        } else {
            this.creditLayout.setVisibility(8);
            if (i11 == 2) {
                this.checkoutdotLayout.setVisibility(0);
                if (z15) {
                    if (this.I.walletConfig().isAmexAvailable()) {
                        this.checkoutDotComIcon.setImageResource(R.drawable.icon_add_cc);
                    } else {
                        this.checkoutDotComIcon.setImageResource(R.drawable.icon_addcreditcard);
                    }
                    this.checkoutDotComTxt.setText(getResources().getString(R.string.different_credit_cards));
                } else {
                    if (this.I.walletConfig().isAmexAvailable()) {
                        this.checkoutDotComIcon.setImageResource(R.drawable.ico_creditcard);
                    } else {
                        this.checkoutDotComIcon.setImageResource(R.drawable.icon_tokenization_creditcard);
                    }
                    this.checkoutDotComTxt.setText(getResources().getString(R.string.credit_card));
                }
            }
            if (GlobalDataModel.SelectedCountryId == com.talabat.configuration.country.Country.EGYPT.getCountryId() && i11 == 4) {
                this.checkoutdotLayout.setVisibility(0);
                if (z15) {
                    this.checkoutDotComIcon.setImageResource(R.drawable.icon_addcreditcard);
                    this.checkoutDotComTxt.setText(getResources().getString(R.string.different_credit_cards));
                } else {
                    this.checkoutDotComIcon.setImageResource(R.drawable.icon_tokenization_creditcard);
                    this.checkoutDotComTxt.setText(getResources().getString(R.string.credit_card));
                }
            }
            if (!isGemActive() && !isDarkStore()) {
                this.binResponseReceived = false;
                this.checkoutPresenter.getBinTokens();
            }
            showParallelBinView();
            populateUserSelctedCreditCardView(z15, Customer.getInstance().getSelectedCreditCard());
        }
        if (!z13 || isGemActive() || isDarkStore()) {
            this.binOffersView.setVisibility(8);
        } else {
            shouldShowBinOffersView();
        }
    }

    public void setPlaceOrderResponse(PlaceOrderResponse placeOrderResponse) {
        ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
        if (iCheckoutPresenter != null) {
            iCheckoutPresenter.setPlaceOrderResponse(placeOrderResponse);
        }
    }

    public void setPostDateOrderLayout(boolean z11) {
        if (z11) {
            setScheduleLaterVisibility(0);
        } else {
            setScheduleLaterVisibility(8);
        }
    }

    public void setQPayLabel() {
        this.payByMethod.setText(getString(R.string.pay_by).replace("#", getResources().getString(R.string.debit_card)));
        this.debitCardLabelTxt.setText(getString(R.string.debit_card));
        this.debitIcon.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_naps));
    }

    public void setRestaurantName(String str) {
        if (this.checkoutPresenter.isPickup()) {
            if (!this.cart.getRestaurant().areaName.isEmpty()) {
                str = str + " (" + this.cart.getRestaurant().areaName + ")";
            }
            this.restaurantName.setText(str);
            return;
        }
        this.restaurantName.setText(str);
    }

    @VisibleForTesting
    public void setTokenisationCreditCard(TokenisationCreditCard tokenisationCreditCard) {
        this.selectedItem = tokenisationCreditCard;
    }

    public void setTotalAmount() {
        Cart cart2 = this.cart;
        if (cart2 != null) {
            String cartTotalPaymentDisplayPrice = cart2.getCartTotalPaymentDisplayPrice();
            TextView textView = this.grandTotal;
            if (textView != null) {
                textView.setText(cartTotalPaymentDisplayPrice);
            }
            TextView textView2 = this.cashTotal;
            if (textView2 != null) {
                textView2.setText(cartTotalPaymentDisplayPrice);
            }
        }
    }

    public void setTouristTaxView(String str) {
        findViewById(R.id.tourist_tax_view).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.tourist_tax_value);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void setVoucherView() {
        this.removeVoucher.setOnClickListener(new r4(this));
        if (this.checkoutPresenter.isAnyVoucherAvailable()) {
            this.checkoutPresenter.recalculateAppliedVoucherIfBinApplied();
            bindZeroVoucherView();
            bindNormalVoucherView();
            bindTalabatFreeDeliveryVoucher();
            bindLoyaltyVoucherView();
            bindPickupTotalDiscount();
            bindFreeDeliveryTypeVoucher();
            if (this.checkoutPresenter.isVoucherForOnlinePayment()) {
                removeCashPayment();
            }
        } else if (this.checkoutPresenter.onlyBinApplied()) {
            this.talabatDeliveryVoucherView.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(0);
            this.discountVoucherView.setVisibility(8);
            this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            this.combinedDiscountValue.setText(this.checkoutPresenter.getBinDiscountAmount());
        } else if (this.checkoutPresenter.canShowVouchers() || this.checkoutPresenter.isDarkstoresVouchersEnabled()) {
            showVoucherBottomSheet();
        } else {
            this.freeDeliveryTypeVoucherLayout.setVisibility(8);
            this.talabatDeliveryVoucherView.setVisibility(8);
            this.discountVoucherView.setVisibility(8);
            this.combinedDiscountLayout.setVisibility(8);
        }
    }

    @VisibleForTesting
    public void setmLastClickTime(long j11) {
        this.mLastClickTime = j11;
    }

    public void showBenefitMessage() {
        this.checkoutRefactorPresenter.onDebitPaymentShown(getString(R.string.by_placing_the_order_agree_to_terms_replace).replace("#", getResources().getString(R.string.benefit)));
        this.paymentBy.setText(getText(R.string.pay_by).toString().replace("#", getResources().getString(R.string.benefit)));
    }

    public void showBusyPopup(String str, boolean z11) {
        String str2;
        String str3;
        String str4;
        stopNonCancelableLoading();
        this.checkoutPresenter.setCvv("", false);
        Restaurant restaurant = this.cart.getRestaurant();
        if (restaurant != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
            if (z11) {
                if (restaurant.isTalabatGo) {
                    str2 = getString(R.string.bsy_close_tgo_alert_title);
                } else {
                    str2 = restaurant.getName();
                }
                if (restaurant.isTalabatGo) {
                    str3 = str.replace(RichContentLoadTimeRecorder.DELIMETER, restaurant.f13873name);
                } else {
                    str3 = str.replace("#phrest#", restaurant.branchName);
                }
                if (restaurant.isTalabatGo) {
                    str4 = getString(R.string.continue_to_tgo_restaurant);
                } else {
                    str4 = getString(R.string.try_more_restaurants);
                }
            } else {
                str2 = restaurant.getName();
                str3 = str.replace("#phrest#", restaurant.branchName);
                str4 = getString(R.string.try_more_restaurants);
            }
            builder.setTitle((CharSequence) str2);
            builder.setMessage((CharSequence) str3);
            builder.setPositiveButton((CharSequence) str4, (DialogInterface.OnClickListener) new k2(this));
            builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) null);
            builder.show();
        }
    }

    public void showCVVPopup(boolean z11) {
        stopNonCancelableLoading();
        int i11 = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.screenWidth = i11;
        this.popupWidth = i11 - (((int) getResources().getDimension(R.dimen.card_popup_outer_margin)) * 2);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.popupWidth, -2);
        View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.force_cvv_dialog, (ViewGroup) null);
        Dialog dialog = new Dialog(this);
        this.forceCvvDialog = dialog;
        dialog.setContentView(inflate, layoutParams);
        this.forceCvvDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.forceCvvDialog.setTitle("");
        this.cancelCvv = (Button) this.forceCvvDialog.findViewById(R.id.cancel_cvv);
        this.payWithCVV = (Button) this.forceCvvDialog.findViewById(R.id.pay_cvv);
        PinView pinView = (PinView) this.forceCvvDialog.findViewById(R.id.cvv_pin);
        this.editTextCvv = pinView;
        TalabatBugReportManager.INSTANCE.blockViewsRecording(pinView);
        this.editTextCvv.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (TalabatUtils.isNullOrEmpty(editable.toString())) {
                    CheckOutScreen.this.payWithCVV.setEnabled(false);
                } else if (editable.toString().length() == CheckOutScreen.this.editTextCvv.getItemCount()) {
                    CheckOutScreen.this.payWithCVV.setEnabled(true);
                } else {
                    CheckOutScreen.this.payWithCVV.setEnabled(false);
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.cancelCvv.setOnClickListener(new v4(this));
        this.payWithCVV.setOnClickListener(new y4(this, z11));
        this.forceCvvDialog.setCancelable(false);
        this.forceCvvDialog.show();
        this.editTextCvv.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.toggleSoftInput(2, 0);
        }
    }

    public void showCashView() {
        this.cashTotal.setText(TalabatFormatter.getInstance().getFormattedCurrency(this.cart.getCartTotalPrice()));
    }

    public void showCurrentLocationAwareness() {
        View view = this.mCurrentLocationAwarenessTxt;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void showDebitCardMessage() {
        this.checkoutRefactorPresenter.onDebitPaymentShown(getString(R.string.by_placing_the_order_agree_to_terms_replace).replace("#", getResources().getString(R.string.debit_card)));
        this.paymentBy.setText(getText(R.string.pay_by).toString().replace("#", getResources().getString(R.string.debit_card)));
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
        Context context = getContext();
        String string = getResources().getString(R.string.gem_order_notification);
        Toast.makeText(context, string.replace("#", "" + i11), 0).show();
    }

    public void showKNetMessage() {
        this.checkoutRefactorPresenter.onDebitPaymentShown(getString(R.string.by_placing_the_order_agree_to_terms_replace).replace("#", getString(R.string.knet)));
        this.paymentBy.setText(getText(R.string.pay_by).toString().replace("#", getString(R.string.knet)));
    }

    public void showLoader() {
        this.checkoutPresenter.showProgress();
    }

    public void showParallelBinView() {
        boolean z11;
        if (!isDarkStore() && !isGemActive() && this.I.config().isBinCampAvailable()) {
            if (Customer.getInstance().isLoggedIn(getContext()) && Customer.getInstance().getSavedCards() != null) {
                ArrayList<TokenisationCreditCard> savedCards = Customer.getInstance().getSavedCards();
                if (savedCards.size() > 0) {
                    Iterator<TokenisationCreditCard> it = savedCards.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        TokenisationCreditCard next = it.next();
                        if (next.isValidCard && next.isBinDiscountValid) {
                            z11 = false;
                            break;
                        }
                    }
                }
            }
            z11 = true;
            if (!z11) {
                this.parallelBinView.setVisibility(8);
                if (!GlobalDataModel.PARALLELBIN.notAvailable && !GlobalDataModel.PARALLELBIN.parallelBinLoaded) {
                    callParallelBinApi(z11);
                }
            } else if (GlobalDataModel.PARALLELBIN.notAvailable) {
            } else {
                if (GlobalDataModel.PARALLELBIN.parallelBinLoaded) {
                    onParallelBinAvailable(true);
                } else {
                    callParallelBinApi(z11);
                }
            }
        }
    }

    public void showQPayMessage() {
        this.checkoutRefactorPresenter.onDebitPaymentShown(getString(R.string.by_placing_the_order_agree_to_terms_replace).replace("#", getResources().getString(R.string.debit_card)));
        this.paymentBy.setText(getText(R.string.pay_by).toString().replace("#", getResources().getString(R.string.debit_card)));
    }

    public void showRiderTipCharges(String str) {
        this.riderTipChargesView.setVisibility(0);
        this.riderTipChargesText.setText(str);
    }

    public void showRiderTipView() {
        findViewById(R.id.rider_tip_container).setVisibility(0);
        RiderTipView riderTipView2 = this.riderTipView;
        if (riderTipView2 != null) {
            riderTipView2.enableRiderTip();
        }
    }

    public void showSubscriptionErrorDialog() {
        hideLoader();
        new ProCheckoutWarningDialog(this).showProCheckoutWarningDialog((ViewGroup) findViewById(R.id.checkout_parent), this, new z4(this));
    }

    public void showTalabatCreditView() {
        float f11;
        boolean z11;
        if (this.E.selectedCountry() == com.talabat.configuration.country.Country.OMAN) {
            this.talabatCreditTxt.setText(R.string.talabat_pay_oman);
        }
        float cartTotalPaymentPrice = this.cart.getCartTotalPaymentPrice();
        float f12 = 0.0f;
        if (Customer.getInstance() == null || !Customer.getInstance().isLoggedIn(getContext()) || Customer.getInstance().getCustomerInfo() == null) {
            f11 = 0.0f;
        } else {
            f11 = Customer.getInstance().getCustomerInfo().talabatCredit;
        }
        float f13 = f11 - cartTotalPaymentPrice;
        if (f13 >= 0.0f) {
            f12 = f13;
        }
        if (f11 < cartTotalPaymentPrice) {
            this.talabtCreditTotalDisplay.setText(TalabatFormatter.getInstance().getFormattedCurrency(f11));
            float f14 = cartTotalPaymentPrice - f11;
            datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.E, this.G);
            if (selectedCountry != null) {
                z11 = selectedCountry.enableTalabtCredit;
            } else {
                z11 = false;
            }
            if (z11) {
                this.payByKnet.setVisibility(8);
                this.payRemainingbyCredit.setVisibility(0);
                this.remainingCreditAmount.setText(TalabatFormatter.getInstance().getFormattedCurrency(f14));
            } else {
                this.payByKnet.setVisibility(0);
                this.payRemainingbyCredit.setVisibility(8);
                this.knetTotal.setText(TalabatFormatter.getInstance().getFormattedCurrency(f14));
            }
            this.talabatCreditBalance.setText(TalabatFormatter.getInstance().getFormattedCurrency(f12));
        } else {
            this.payByKnet.setVisibility(8);
            this.payRemainingbyCredit.setVisibility(8);
            this.talabtCreditTotalDisplay.setText(TalabatFormatter.getInstance().getFormattedCurrency(cartTotalPaymentPrice));
            this.talabatCreditBalance.setText(TalabatFormatter.getInstance().getFormattedCurrency(f12));
            if (!isCashbackEnabledCountry()) {
                this.availableCredit.setVisibility(0);
            }
        }
        this.f53829j = f12;
    }

    public void showTimeOutDialog() {
        this.gemDiscountView.setVisibility(8);
        showGemTimeOutDialog(this.mGemDialogSwitcher, this.f53834o, this, this);
        this.checkoutPresenter.setUpViews(false, this.isGrlEnabled, this.isGlrEnableAddNewAddress, this.isEditAddressFromCheckoutScreen);
        this.checkoutRefactorPresenter.onSettingDebitCardPaymentMethodLabel();
    }

    public void showTimerView(boolean z11, String str) {
        this.f53834o.setTimerText(str);
    }

    public void showVoucherBottomSheet() {
        this.discountVoucherView.setVisibility(8);
        this.talabatDeliveryVoucherView.setVisibility(8);
        this.freeDeliveryTypeVoucherLayout.setVisibility(8);
    }

    public void stopBinTimer() {
        Handler handler;
        Runnable runnable = this.f53837r;
        if (runnable != null && (handler = this.f53836q) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    public void stopLoading() {
    }

    public void stopScreenTrace() {
        this.W.stopTrace(new ScreenTrackerParams("checkout", "checkoutScreen", "checkout"));
    }

    public void updateAddressMobileNumber(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.mobileForBin = str;
            TextView textView = this.mobileNumber;
            textView.setText(getString(R.string.address_mobile) + str);
            ICheckoutPresenter iCheckoutPresenter = this.checkoutPresenter;
            if (iCheckoutPresenter != null) {
                iCheckoutPresenter.updateMobileNumber(str);
            }
        }
    }

    public void updateDeliverySlots(List<DeliverySlotContent> list) {
        this.deliverySlots = list;
        if (this.deferDarkstoreScheduleLaterClick) {
            showBottomSheetForDeliveryTiming();
        }
    }

    @VisibleForTesting
    public void updateFeesValues() {
        showNonCancelableProgress();
        this.f53825a0.onSubtotalChanged(Cart.getInstance().getCartSubTotalBeforeDiscounts(), Cart.getInstance().getCartSubTotal(), Cart.getInstance().getCouponDiscount(), GlobalDataModel.LATLONGFORAPI.getLatitudeDouble().doubleValue(), GlobalDataModel.LATLONGFORAPI.getLongitudeDouble().doubleValue());
    }

    public void updateSaveTipStatus() {
        RiderTipView riderTipView2 = this.riderTipView;
        if (riderTipView2 != null) {
            riderTipView2.onRiderTipClosed();
        }
    }

    public void verifyMobileNumber(String str, String str2, String str3, String str4) {
        this.checkoutPresenter.setCvv("", false);
        stopNonCancelableLoading();
        Intent intent = new Intent(this, MobileNumberVerification.class);
        intent.putExtra("userselectedmobno", str);
        if (TalabatUtils.isInterantionalCountryCodeVerificationEnabledCountry(this.E, this.G)) {
            intent.putExtra("userSelectedInternationalCountryCode", str2);
        }
        intent.putExtra("isFromAptimize", this.isFromAptimize);
        if (this.isQuick) {
            intent.putExtra("isQuick", true);
            intent.putExtra("value", this.f53831l);
        }
        intent.putExtra("smsToken", str3);
        intent.putExtra("encryptedNumber", str4);
        this.verificationPopupShown = true;
        startActivityForResult(intent, 302);
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }
}
