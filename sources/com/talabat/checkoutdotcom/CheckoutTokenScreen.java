package com.talabat.checkoutdotcom;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.PurchaseRequest;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.CheckoutDotComResponse.PurchaseResponse;
import JsonModels.parser.UniversalGson;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeRecorder;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.integration.nfv.observability.NfvObservabilityHandler;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.CartScreen;
import com.talabat.GemDialogSwitcher;
import com.talabat.GemFooterCartView;
import com.talabat.GroceryMenuScreen;
import com.talabat.MobileNumberVerification;
import com.talabat.OrderDetailsScreen;
import com.talabat.PaymentErrorScreen;
import com.talabat.PaymentWebViewScreen;
import com.talabat.R;
import com.talabat.RestaurantMenuScreenR;
import com.talabat.TWebViewScreen;
import com.talabat.bugreport.TalabatBugReportManager;
import com.talabat.components.gem.checkout.GemDiscountViewBinder;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.di.ConfigurationLocalCoreLibApi;
import com.talabat.configuration.di.ConfigurationRemoteCoreLibApi;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.configuration.tcs.TermsAndConditionsConfigurationRepository;
import com.talabat.core.context.domain.ContextCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkCoreLibApi;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.featureflag.domain.FeatureFlagCoreLibApi;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.core.observabilityNew.domain.ObservabilityCoreLibApi;
import com.talabat.di.checkout.DaggerCheckoutTokenScreenComponent;
import com.talabat.feature.fees.domain.FeesFeatureApi;
import com.talabat.feature.fees.presentation.displaymodel.FeeValue;
import com.talabat.feature.fees.presentation.ui.FeesMismatchErrorDialog;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModel;
import com.talabat.feature.fees.presentation.viewmodel.FeesViewModelFactory;
import com.talabat.feature.tokenization.domain.TokenizationFeatureApi;
import com.talabat.fees.ServiceFeeView;
import com.talabat.fees.SmallOrderFeeView;
import com.talabat.gem.adapters.presentation.checkout.GemCheckoutDiscountView;
import com.talabat.gem.integration.GemAccessor;
import com.talabat.gem.integration.GemAnalyticsAccessor;
import com.talabat.geminterfaces.OnGemAlertDialogClickListener;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.OrderTrackingNavigator;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.talabatcommon.helpers.DarkstoresSharedPreferencesHelper;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.DebitCardBinVerificationDisplayModel;
import com.talabat.talabatcommon.views.wallet.debitcarddeflection.presentation.displaymodel.PaymentButtonTypeDisplayModel;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.model.WalletCardType;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutCard;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.CheckoutResponse;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.ICheckoutKit;
import com.talabat.talabatcommon.views.wallet.walletCardManagement.viewModel.TokenGenerationException;
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragmentKt;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import com.talabat.wallet.checkoutpaymentmanager.di.module.DomainModule;
import com.talabat.wallet.debitcarddeflection.presentation.viewmodel.BenefitManagerViewModel;
import com.talabat.wallet.debitcarddeflection.presentation.viewmodel.di.factory.DebitCardDeflectionViewModelFactory;
import datamodels.CustomerInfo;
import datamodels.InvalidItem;
import datamodels.OrderDetails;
import datamodels.QuickOrderInfo;
import datamodels.Restaurant;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.Dispatchers;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.checkout.checkoutrefactor.AddCardRefactorPresenter;
import library.talabat.mvp.checkoutdotcom.CheckoutDotComPresenter;
import library.talabat.mvp.checkoutdotcom.CheckoutDotComView;
import library.talabat.mvp.checkoutdotcom.ICheckoutDotComPresenter;
import library.talabat.mvp.placeorder.PlaceOrderView;
import org.apache.commons.compress.archivers.tar.TarConstants;
import sf.c;
import sf.d;
import sf.e;
import sf.f;
import sf.g;
import sf.h;
import tracking.AppTracker;
import tracking.Purchase;
import tracking.ScreenNames;
import xq.b;
import yq.a;

@Instrumented
public class CheckoutTokenScreen extends TalabatBase implements CheckoutDotComView, PlaceOrderView, GemView, OnGemAlertDialogClickListener, GemAccessor {
    private static final int MOB_VERIFCATION_DIALOG = 301;
    private static final int PAYMENTPAGE = 300;
    private static final int PAY_WITH_BENEFIT = 100;
    public static String binNumber = "";
    @Inject
    public LocationConfigurationRepository A;
    @Inject
    public PaymentConfigurationRepository B;
    /* access modifiers changed from: private */
    public View BtnLayout;
    @Inject
    public FeesViewModelFactory C;
    @Inject
    public IObservabilityManager D;
    @Inject
    public ITalabatFeatureFlag E;
    public FeesViewModel F;
    @Inject
    public ICheckoutKit G;
    @Inject
    public TermsAndConditionsConfigurationRepository H;
    public int ScreenHeight;
    private AddCardPresenter addCardPresenter;
    private TextView alternateMunicipalityText;
    private TextView alternateTouristText;
    private TextView amountTV;
    private float balanceAmountToPay = 0.0f;
    private View benefitBinContainer;
    /* access modifiers changed from: private */
    public BenefitManagerViewModel benefitManagerViewModel;
    private View benefitNotificationContainer;
    private TextView benefitNotificationTextView;
    /* access modifiers changed from: private */
    public boolean binApplied = false;
    /* access modifiers changed from: private */
    public boolean binAvailable = false;
    private TextView binMessage;
    private View binView;
    private Button cancelBtn = null;
    /* access modifiers changed from: private */
    public boolean cardErrorAvailable = true;
    /* access modifiers changed from: private */
    public EditText cardNumberET;
    /* access modifiers changed from: private */
    public TextView cardNumberErrorTV;
    /* access modifiers changed from: private */
    public TextInputLayout cardNumberIL;
    /* access modifiers changed from: private */
    public ImageView cardTypeIV = null;
    private ImageView closeBottomSheet;
    private TextView combinedDiscountText;
    /* access modifiers changed from: private */
    public View contentView;
    private TextView coupon_discount_value;
    private View coupon_discount_view;
    private String customerName = "";
    /* access modifiers changed from: private */
    public EditText cvvET;
    private boolean cvvErrorAvailable = true;
    /* access modifiers changed from: private */
    public TextView cvvErrorTV;
    private View cvvExpView;
    /* access modifiers changed from: private */
    public TextInputLayout cvvIL;
    private TextView deliveryChargesText;
    private TextView deliveryChargesValue;
    private View deliveryChargesView;
    /* access modifiers changed from: private */
    public Dialog duplicateOrderDialog;
    private RadioButton[] duplicateOrderPopupRadioGroup;
    private String encryptedOrderId;
    /* access modifiers changed from: private */
    public TextView expDateErrorTV;
    /* access modifiers changed from: private */
    public EditText expiryDateET;
    /* access modifiers changed from: private */
    public TextInputLayout expiryDateIL;
    private boolean expiryErrorAvailable = true;
    private View gemDiscountView;
    private TextView gemOfferText;
    private TextView gemOfferValue;
    private TextView grandTotal;
    /* access modifiers changed from: private */
    public EditText holderNameET = null;
    private TextInputLayout holderNameIL = null;

    /* renamed from: i  reason: collision with root package name */
    public String f55541i;
    /* access modifiers changed from: private */
    public ICheckoutDotComPresenter iCheckoutDotComPresenter;
    private boolean isBinDiscountAppliedForTracking = false;
    /* access modifiers changed from: private */
    public boolean isBinRequestSent = false;
    private boolean isFromAptimize;
    private boolean isNeedUpdate;
    private boolean isOrderSuccess = false;
    private boolean isPlaceOrderClicked = false;
    private boolean isPostDated = false;
    /* access modifiers changed from: private */
    public boolean isQPayDown = false;
    private boolean isQuickOrder = false;
    /* access modifiers changed from: private */
    public boolean isTalabatCreditForUae = false;
    private boolean isTalabatDelVoucher = false;
    private boolean isZeroPercentageVoucherApplied;

    /* renamed from: j  reason: collision with root package name */
    public String f55542j;

    /* renamed from: k  reason: collision with root package name */
    public String f55543k;

    /* renamed from: l  reason: collision with root package name */
    public String f55544l;
    /* access modifiers changed from: private */
    public String lastInput = "";
    public BinRequest localBinRequest = null;

    /* renamed from: m  reason: collision with root package name */
    public String f55545m;
    private GemDialogSwitcher mGemDialogSwitcher;
    /* access modifiers changed from: private */
    public long mLastClickTime = 0;
    private Toolbar mToolbar;
    private View muncipalityTaxView;

    /* renamed from: n  reason: collision with root package name */
    public boolean f55546n;
    private LinearLayout nonBenefitBinContainer;
    private View normalFlowView;

    /* renamed from: o  reason: collision with root package name */
    public String f55547o;
    private TextView oldDeliveryCharges;

    /* renamed from: p  reason: collision with root package name */
    public boolean f55548p = false;
    private ViewGroup parentLayout;
    private Button payBtn = null;
    private TextView payByCreditCardAmount;
    private View payByCreditCardView;
    private TextView payBytalabatCreditAmount;
    /* access modifiers changed from: private */
    public View payLoadingPB = null;
    private TextView paymentTerms;
    /* access modifiers changed from: private */
    public String paymnentMethod;
    public int popupWidth;
    private String publicKey;
    /* access modifiers changed from: private */
    public PurchaseRequest purchaseRequest;

    /* renamed from: q  reason: collision with root package name */
    public GemFooterCartView f55549q;
    private View qPayBinContainer;

    /* renamed from: r  reason: collision with root package name */
    public PlaceOrderRequestModel f55550r = null;
    private float remainingTalabatCredit = 0.0f;
    private TextView remainingToPayAmount;
    private View remainingToPayView;
    private RelativeLayout rememberMeRL = null;
    private ToggleButton rememberMeTB = null;
    private TextView riderTipChargesText;
    private View riderTipChargesView;

    /* renamed from: s  reason: collision with root package name */
    public String f55551s;
    public View scanCard;
    public int screenWidth;
    private View securityInfoBackBtn;
    /* access modifiers changed from: private */
    public View securityInfoContentView;
    private View securityInfoTxt;
    private String selectedCardName = "";
    private ServiceFeeView serviceFeeView;
    private View showCaseView;
    private SmallOrderFeeView smallOrderFeeView;
    /* access modifiers changed from: private */
    public View sub_content_view;
    private TextView subtotal;
    private boolean successCalled = false;

    /* renamed from: t  reason: collision with root package name */
    public QuickOrderInfo f55552t;
    private View talabatCreditFlowView;
    private TextView talabatCreditgrandTotal;
    private TextView talabat_delivery_discount_value;
    private View talabat_delivery_discount_view;
    private TextView taxTextView;
    /* access modifiers changed from: private */
    public View termsLayout;
    /* access modifiers changed from: private */
    public String termsTitle;
    private String title;
    private TextView touristTaxText;
    private View touristTaxView;
    /* access modifiers changed from: private */
    public String transactionId;
    private TextView tvVoucherDiscount;

    /* renamed from: u  reason: collision with root package name */
    public String f55553u = "";

    /* renamed from: v  reason: collision with root package name */
    public int f55554v = 0;
    private TextView voucher_discount_value;
    private View voucher_discount_view;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public AppVersionProvider f55555w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public ConfigurationLocalRepository f55556x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public DeepLinkNavigator f55557y;
    @Inject

    /* renamed from: z  reason: collision with root package name */
    public DiscoveryConfigurationRepository f55558z;

    public interface SlideAnimationListener {
        void onAnimationFinish();

        void onAnimationStart();
    }

    private void addCard(final String str, String str2, String str3, String str4, String str5) {
        CheckoutCard checkoutCard = new CheckoutCard(str, str2, str3, str4, str5);
        AnonymousClass45 r92 = new Continuation<CheckoutResponse>() {
            @NonNull
            public CoroutineContext getContext() {
                return Dispatchers.getDefault();
            }

            public void resumeWith(@NonNull Object obj) {
                if (obj instanceof Result.Failure) {
                    Throwable th2 = ((Result.Failure) obj).exception;
                    if (th2 instanceof TokenGenerationException) {
                        CheckoutTokenScreen.this.handleTokenGenerationException((TokenGenerationException) th2);
                    } else {
                        CheckoutTokenScreen.this.goToError("");
                    }
                } else if (obj instanceof CheckoutResponse) {
                    CheckoutTokenScreen.this.purchaseRequest = new PurchaseRequest();
                    CheckoutTokenScreen.this.purchaseRequest.transactionId = CheckoutTokenScreen.this.transactionId;
                    CheckoutTokenScreen.this.purchaseRequest.token = ((CheckoutResponse) obj).getToken();
                    CheckoutTokenScreen.this.purchaseRequest.language = GlobalDataModel.SelectedLanguage;
                    CheckoutTokenScreen.this.purchaseRequest.saveCard = CheckoutTokenScreen.this.f55546n;
                    if (!TalabatUtils.isNullOrEmpty(str)) {
                        CheckoutTokenScreen.this.purchaseRequest.binNumber = str.substring(0, 6).trim();
                    }
                    if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.CHECKOUTDOTCOM.routingEnabledPublicKey)) {
                        CheckoutTokenScreen.this.purchaseRequest.bankId = GlobalDataModel.CHECKOUTDOTCOM.bankId;
                    } else {
                        CheckoutTokenScreen.this.purchaseRequest.bankId = -1;
                    }
                    CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                    checkoutTokenScreen.goToSuccess(checkoutTokenScreen.purchaseRequest);
                }
            }
        };
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            this.G.createCardToken(checkoutCard, Integer.valueOf(restaurant.shopType), r92);
        }
    }

    private void addCloseBottomSheetListener() {
        this.closeBottomSheet.setOnClickListener(new g(this));
    }

    private void applyBin(float f11, String str, float f12) {
        Cart instance = Cart.getInstance();
        instance.setBinVoucherDiscount(f11, str, f12);
        showBinView();
        if (instance.hasVoucherApplied()) {
            this.talabat_delivery_discount_view.setVisibility(8);
            this.voucher_discount_view.setVisibility(0);
            TextView textView = this.voucher_discount_value;
            textView.setText("- " + Cart.getInstance().getDisplayVoucherDiscount());
        }
        this.grandTotal.setText(instance.getCartTotalDisplayPrice());
        setTaxAndDelivery();
        this.binApplied = true;
        this.isBinDiscountAppliedForTracking = true;
    }

    private void applyCardForValidate(String str, String str2) {
        if (Cart.getInstance() != null) {
            Cart.getInstance().setBinAndLatDigitForValidate(str, str2);
        }
    }

    private void applyCharges(Restaurant restaurant, Cart cart) {
        String str;
        String str2;
        if (!TalabatUtils.isNullOrEmpty(restaurant.altDelChargetxt)) {
            setAltTextDeliveryCharges(restaurant.altDelChargetxt);
        }
        if (restaurant.talabatCharges > 0.0f) {
            if (!TalabatUtils.isNullOrEmpty(restaurant.altTalabatText)) {
                str2 = restaurant.altTalabatText;
            } else {
                str2 = "t";
            }
            setDeliveryCharges(restaurant.getDisplayTalabatCharge(), str2);
        } else {
            if (!TalabatUtils.isNullOrEmpty(restaurant.altDelChargetxt)) {
                str = restaurant.altDelChargetxt;
            } else {
                str = "d";
            }
            setDeliveryCharges(cart.getDeliveryChargesDisplayPrice(), str);
        }
        if (restaurant.getMunicipalityTax() > 0.0f) {
            setMuncipalityTaxView(cart.getDisplayMuncipalityTax());
            if (!TalabatUtils.isNullOrEmpty(restaurant.altMunicipalityText)) {
                setAltTextMuncipalityTax(restaurant.altMunicipalityText);
            }
        }
        if (restaurant.getTouristTax() > 0.0f) {
            setTouristTaxView(cart.getDispalyTouristTax());
            if (!TalabatUtils.isNullOrEmpty(restaurant.altTouristTaxText)) {
                setAltTextTouristTax(restaurant.altTouristTaxText);
            }
        }
        if (cart.getRiderTip() > 0.0d) {
            showRiderTipCharges(cart.getRiderTip());
        }
    }

    private void applyTotalPickupDiscount(Cart cart) {
        if (cart.isLoyaltyVoucherApplied() && cart.isPickup()) {
            this.talabat_delivery_discount_view.setVisibility(8);
            this.voucher_discount_view.setVisibility(0);
            this.combinedDiscountText.setText(R.string.total_pickup_discount);
            this.voucher_discount_value.setText(getString(R.string.pickupDiscountCoupon, new Object[]{cart.getDisplayLoyaltyDiscount()}));
        }
    }

    /* access modifiers changed from: private */
    public void disablePayButton() {
        if (!this.benefitManagerViewModel.getBenefitDeflectedShown()) {
            this.payByCreditCardView.setVisibility(8);
            this.remainingToPayView.setVisibility(0);
            this.payBtn.setEnabled(false);
            this.payBtn.setAlpha(0.5f);
        }
    }

    private void disableViews() {
        AnonymousClass42 r02 = new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        };
        this.cvvIL.setLongClickable(false);
        this.cvvET.setCustomSelectionActionModeCallback(r02);
        this.cvvET.setLongClickable(false);
        this.cvvET.setTextIsSelectable(false);
        this.expiryDateIL.setLongClickable(false);
        this.expiryDateET.setCustomSelectionActionModeCallback(r02);
        this.expiryDateET.setTextIsSelectable(false);
        this.expiryDateET.setLongClickable(false);
        this.cardNumberIL.setLongClickable(false);
        this.cardNumberET.setCustomSelectionActionModeCallback(r02);
        this.cardNumberET.setTextIsSelectable(false);
        this.cardNumberET.setLongClickable(false);
    }

    private void enablePayButtonClick() {
        this.payBtn.setEnabled(true);
        this.payBtn.setAlpha(1.0f);
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

    private String getErrorCode(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 47671:
                if (str.equals("007")) {
                    c11 = 0;
                    break;
                }
                break;
            case 47792:
                if (str.equals("044")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1507425:
                if (str.equals("1002")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1507426:
                if (str.equals("1003")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1507427:
                if (str.equals("1004")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1507428:
                if (str.equals("1005")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1507429:
                if (str.equals("1006")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1507430:
                if (str.equals("1007")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1507431:
                if (str.equals("1008")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1507432:
                if (str.equals("1009")) {
                    c11 = 9;
                    break;
                }
                break;
            case 47653715:
                if (str.equals("20012")) {
                    c11 = 10;
                    break;
                }
                break;
            case 47653838:
                if (str.equals("20051")) {
                    c11 = 11;
                    break;
                }
                break;
            case 47653937:
                if (str.equals("20087")) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return getResources().getString(R.string.paid_before);
            case 1:
                return getResources().getString(R.string.inactive_card);
            case 2:
                return getString(R.string.maintenance);
            case 3:
                return getString(R.string.card_number_not_valid);
            case 4:
                return getString(R.string.card_details_valid);
            case 5:
                return getResources().getString(R.string.card_exp_invalid);
            case 6:
                return getResources().getString(R.string.invalid_transaction);
            case 7:
                return getResources().getString(R.string.currently_not_available);
            case 8:
                return getResources().getString(R.string.related_to_customer);
            case 9:
                return getResources().getString(R.string.transaction_amount);
            case 10:
                return getString(R.string.invalid_3d);
            case 11:
                return getString(R.string.insufficient_fund);
            case 12:
                return getResources().getString(R.string.invalid_cvv_exp_cot);
            default:
                return getResources().getString(R.string.Unexpected_System_Error);
        }
    }

    public static String getPaymentMethodOptionName(String str, boolean z11) {
        try {
            Pattern compile = Pattern.compile("^4\\d*");
            Pattern compile2 = Pattern.compile("^4(026|17500|405|508|844|91[37])");
            Pattern compile3 = Pattern.compile("^(5[1-5]|222[1-9]|22[3-9]|2[3-6]|27[0-1]|2720)\\d*");
            Pattern compile4 = Pattern.compile("^3[47]\\d*");
            Pattern compile5 = Pattern.compile("^(6011|65|64[4-9]|622)\\d*");
            Pattern compile6 = Pattern.compile("^(36|38|30[0-5])\\d*");
            Pattern compile7 = Pattern.compile("^35\\d*");
            Pattern compile8 = Pattern.compile("^(5018|5020|5038|6020|6304|6703|6759|676[1-3])\\d*");
            Pattern compile9 = Pattern.compile("^62\\d*");
            if (str == null) {
                return null;
            }
            if (compile.matcher(str).find()) {
                return "VISA";
            }
            if (compile2.matcher(str).find()) {
                return "VISA";
            }
            if (compile3.matcher(str).find()) {
                return "MASTERCARD";
            }
            if (compile4.matcher(str).find()) {
                if (z11) {
                    return "AMEX";
                }
                return null;
            } else if (compile5.matcher(str).find() || compile6.matcher(str).find() || compile7.matcher(str).find() || compile8.matcher(str).find()) {
                return null;
            } else {
                compile9.matcher(str).find();
                return null;
            }
        } catch (Exception unused) {
        }
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

    /* access modifiers changed from: private */
    public void goToError(String str) {
        binNumber = "";
        runOnUiThread(new Runnable() {
            public void run() {
                CheckoutTokenScreen.this.stopLodingPopup();
                Intent intent = new Intent(CheckoutTokenScreen.this, PaymentErrorScreen.class);
                intent.putExtra("url", "");
                intent.putExtra("isFromCheckoutDotCom", true);
                intent.putExtra("isGateWayError", true);
                intent.putExtra("paymentMethod", CheckoutTokenScreen.this.paymnentMethod);
                intent.putExtra("encryptedTransactionIdError", CheckoutTokenScreen.this.transactionId);
                CheckoutTokenScreen.this.startActivity(intent);
                CheckoutTokenScreen.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    public void goToSuccess(PurchaseRequest purchaseRequest2) {
        startLodingPopup();
        this.payLoadingPB.setVisibility(0);
        this.successCalled = true;
        this.payBtn.setVisibility(0);
        this.iCheckoutDotComPresenter.proceedPayment(purchaseRequest2);
    }

    /* access modifiers changed from: private */
    public void handleTokenGenerationException(TokenGenerationException tokenGenerationException) {
        if (tokenGenerationException != null) {
            goToError("");
        }
    }

    private void hideAddCardToggle() {
        this.rememberMeTB.setChecked(false);
        this.rememberMeRL.setVisibility(8);
    }

    private void hideKeyBoard() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.securityInfoContentView.getWindowToken(), 0);
    }

    /* access modifiers changed from: private */
    public boolean isDarkStore() {
        try {
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            if (restaurant == null) {
                return false;
            }
            if (restaurant.isDarkStore || restaurant.isMigrated) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isLuhnValid(String str) {
        String stringBuffer = new StringBuffer(str).reverse().toString();
        int length = stringBuffer.length();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            char charAt = stringBuffer.charAt(i11);
            if (Character.isDigit(charAt)) {
                int digit = Character.digit(charAt, 10);
                if (i11 % 2 == 0) {
                    i12 += digit;
                } else {
                    i13 += (digit / 5) + ((digit * 2) % 10);
                }
                i11++;
            } else {
                throw new IllegalArgumentException(String.format("Not a digit: '%s'", new Object[]{Character.valueOf(charAt)}));
            }
        }
        if ((i12 + i13) % 10 == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$addCloseBottomSheetListener$2(View view) {
        this.cancelBtn.performClick();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$0(View view) {
        securityInformationView();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreate$1(GEMEngine gEMEngine) throws Exception {
        gEMEngine.startListening(this, true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onFeesMismatchError$3(View view) {
        this.F.onContinueOrderClicked(getScreenName());
    }

    /* access modifiers changed from: private */
    public int[] lengthController(String str) {
        int[] iArr = new int[2];
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.cvvET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            this.cardNumberET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
            iArr[0] = 3;
            iArr[1] = 16;
        } else if ("AMEX".equals(str)) {
            this.cvvET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(4)});
            this.cardNumberET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(15)});
            iArr[0] = 4;
            iArr[1] = 15;
        } else {
            this.cvvET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(3)});
            this.cardNumberET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
            iArr[0] = 3;
            iArr[1] = 16;
        }
        this.holderNameET.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        return iArr;
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

    /* access modifiers changed from: private */
    public void removeBin() {
        this.binView.setVisibility(8);
        Cart instance = Cart.getInstance();
        instance.removeBinDiscountIfApplied();
        instance.recalcualteTotal();
        if (!instance.hasVoucherApplied()) {
            if (this.voucher_discount_view.getVisibility() == 0) {
                this.voucher_discount_view.setVisibility(8);
            }
            if (this.talabat_delivery_discount_view.getVisibility() == 0) {
                this.talabat_delivery_discount_view.setVisibility(8);
            }
        } else if (this.isTalabatDelVoucher) {
            this.talabat_delivery_discount_view.setVisibility(0);
            this.voucher_discount_view.setVisibility(8);
            TextView textView = this.talabat_delivery_discount_value;
            textView.setText("- " + Cart.getInstance().getDisplayVoucherDiscount());
        } else {
            this.talabat_delivery_discount_view.setVisibility(8);
            this.voucher_discount_view.setVisibility(0);
            TextView textView2 = this.voucher_discount_value;
            textView2.setText("- " + Cart.getInstance().getDisplayVoucherDiscount());
        }
        this.binApplied = true;
        this.isBinDiscountAppliedForTracking = false;
        this.grandTotal.setText(instance.getCartTotalDisplayPrice());
        setTaxAndDelivery();
    }

    private void securityInformationView() {
        this.contentView.clearAnimation();
        slidein();
        View view = this.securityInfoBackBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    CheckoutTokenScreen.this.slideOut();
                }
            });
        }
    }

    private void setDeliveryView(String str) {
        Cart instance = Cart.getInstance();
        float calculateDeliveryCharges = instance.calculateDeliveryCharges();
        int i11 = (calculateDeliveryCharges > 0.0f ? 1 : (calculateDeliveryCharges == 0.0f ? 0 : -1));
        if (i11 < 0 || Cart.getInstance().getRestaurant().getTalabatCharges() > 0.0f) {
            instance.setNewDeliveryCharge(-1.0f);
            this.deliveryChargesText.setTextColor(getResources().getColor(R.color.text_color_lightGrey));
            this.deliveryChargesValue.setTextColor(getResources().getColor(R.color.text_color_lightGrey));
            this.oldDeliveryCharges.setVisibility(8);
            this.deliveryChargesValue.setText(str);
            return;
        }
        this.deliveryChargesText.setTextColor(getResources().getColor(R.color.talabat_red));
        this.deliveryChargesValue.setTextColor(getResources().getColor(R.color.talabat_red));
        this.oldDeliveryCharges.setVisibility(0);
        this.oldDeliveryCharges.setText(str);
        if (i11 == 0) {
            this.deliveryChargesValue.setText(getResources().getString(R.string.free_caps));
        } else {
            this.deliveryChargesValue.setText(TalabatFormatter.getInstance().getFormattedCurrency(calculateDeliveryCharges));
        }
    }

    private void setGrandTotal(String str) {
        this.grandTotal.setText(str);
        this.talabatCreditgrandTotal.setText(str);
    }

    /* access modifiers changed from: private */
    public void setTaxAndDelivery() {
        Cart instance = Cart.getInstance();
        Restaurant restaurant = instance.getRestaurant();
        if (restaurant != null) {
            this.subtotal.setText(instance.getCartSubTotalDisplayPrice());
            if (!instance.isPickup()) {
                applyCharges(restaurant, instance);
            }
            setGrandTotal(instance.getCartTotalPaymentDisplayPrice());
        }
    }

    private void setupFees() {
        ServiceFeeView serviceFeeView2 = (ServiceFeeView) findViewById(R.id.service_fee_view);
        this.serviceFeeView = serviceFeeView2;
        serviceFeeView2.setTextColor(ContextCompat.getColor(this, R.color.text_color_lightGrey));
        SmallOrderFeeView smallOrderFeeView2 = (SmallOrderFeeView) findViewById(R.id.small_order_fee_view);
        this.smallOrderFeeView = smallOrderFeeView2;
        smallOrderFeeView2.setTextColor(ContextCompat.getColor(this, R.color.text_color_lightGrey));
        FeesViewModel feesViewModel = (FeesViewModel) this.C.create(FeesViewModel.class);
        this.F = feesViewModel;
        feesViewModel.getServiceFeeValue().observe(this, new e(this));
        this.F.getSmallOrderFeeValue().observe(this, new f(this));
        this.F.onSubtotalChanged(Cart.getInstance().getCartSubTotalBeforeDiscounts(), Cart.getInstance().getCartSubTotal(), Cart.getInstance().getCouponDiscount(), GlobalDataModel.LATLONGFORAPI.getLatitudeDouble().doubleValue(), GlobalDataModel.LATLONGFORAPI.getLongitudeDouble().doubleValue());
    }

    private void setupListeners() {
        AnonymousClass8 r02 = new ActionMode.Callback() {
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                return false;
            }

            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            public void onDestroyActionMode(ActionMode actionMode) {
            }

            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }
        };
        this.cvvIL.setLongClickable(false);
        this.cvvET.setCustomSelectionActionModeCallback(r02);
        this.cvvET.setLongClickable(false);
        this.cvvET.setTextIsSelectable(false);
        this.expiryDateIL.setLongClickable(false);
        this.expiryDateET.setCustomSelectionActionModeCallback(r02);
        this.expiryDateET.setTextIsSelectable(false);
        this.expiryDateET.setLongClickable(false);
        this.cardNumberIL.setLongClickable(false);
        this.cardNumberET.setCustomSelectionActionModeCallback(r02);
        this.cardNumberET.setTextIsSelectable(false);
        this.cardNumberET.setLongClickable(false);
        this.cardNumberET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                CheckoutTokenScreen.this.validateCardNumber(z11);
            }
        });
        this.cardNumberET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                float f11;
                String str;
                float f12;
                String str2;
                String str3;
                String obj = editable.toString();
                int length = editable.length();
                if (!CheckoutTokenScreen.this.isQPayDown) {
                    CheckoutTokenScreen.this.benefitManagerViewModel.onDebitCardBinVerified(obj);
                }
                String str4 = "";
                if (length >= 4) {
                    boolean isAmexAvailable = CheckoutTokenScreen.this.B.walletConfig().isAmexAvailable();
                    CheckoutTokenScreen.this.f55553u = CheckoutTokenScreen.getPaymentMethodOptionName(obj.substring(0, 4), isAmexAvailable);
                    CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                    checkoutTokenScreen.updateCardTypeIndicator(checkoutTokenScreen.f55553u);
                    int visibility = CheckoutTokenScreen.this.cardTypeIV.getVisibility();
                    ImageView unused = CheckoutTokenScreen.this.cardTypeIV;
                    if (visibility != 0) {
                        CheckoutTokenScreen.this.f55553u = CheckoutTokenScreen.getPaymentMethodOptionName(obj, isAmexAvailable);
                        CheckoutTokenScreen checkoutTokenScreen2 = CheckoutTokenScreen.this;
                        checkoutTokenScreen2.updateCardTypeIndicator(checkoutTokenScreen2.f55553u);
                        CheckoutTokenScreen checkoutTokenScreen3 = CheckoutTokenScreen.this;
                        int[] p02 = checkoutTokenScreen3.lengthController(checkoutTokenScreen3.f55553u);
                        if (!TalabatUtils.isNullOrEmpty(obj) && p02[1] > 0) {
                            if (obj.length() != p02[1]) {
                                CheckoutTokenScreen.this.cardErrorAvailable = true;
                                CheckoutTokenScreen.this.disablePayButton();
                            } else {
                                CheckoutTokenScreen.this.cardErrorAvailable = false;
                                CheckoutTokenScreen.this.enablePayButton();
                            }
                        }
                    }
                } else {
                    CheckoutTokenScreen.this.updateCardTypeIndicator((String) null);
                    int[] p03 = CheckoutTokenScreen.this.lengthController(str4);
                    if (!TalabatUtils.isNullOrEmpty(obj) && p03[1] > 0) {
                        if (obj.length() != p03[1]) {
                            CheckoutTokenScreen.this.cardErrorAvailable = true;
                            CheckoutTokenScreen.this.disablePayButton();
                        } else {
                            CheckoutTokenScreen.this.cardErrorAvailable = false;
                            CheckoutTokenScreen.this.enablePayButton();
                        }
                    }
                }
                if (CheckoutTokenScreen.this.validateCardAutofoucs()) {
                    CheckoutTokenScreen.this.expiryDateET.requestFocus();
                }
                if (!TalabatUtils.isNullOrEmpty(editable.toString()) && editable.toString().length() >= 4) {
                    if (TalabatUtils.isNullOrEmpty(CheckoutTokenScreen.getPaymentMethodOptionName(editable.toString(), CheckoutTokenScreen.this.B.walletConfig().isAmexAvailable()))) {
                        return;
                    }
                    if (length >= 7) {
                        try {
                            if (!CheckoutTokenScreen.binNumber.equals(editable.toString().substring(0, 6)) || !CheckoutTokenScreen.this.binAvailable || CheckoutTokenScreen.this.iCheckoutDotComPresenter.getBinResponse() == null) {
                                if (!CheckoutTokenScreen.binNumber.equals(editable.toString().substring(0, 6))) {
                                    CheckoutTokenScreen.this.isBinRequestSent = false;
                                    if (!CheckoutTokenScreen.this.isBinRequestSent) {
                                        CheckoutTokenScreen.binNumber = editable.toString().substring(0, 6);
                                        Cart instance = Cart.getInstance();
                                        if (instance.hasVoucherApplied()) {
                                            str2 = instance.getVoucherCode();
                                            f12 = instance.getVoucherDiscount();
                                        } else {
                                            f12 = 0.0f;
                                            str2 = str4;
                                        }
                                        if (!TalabatUtils.isNullOrEmpty(CheckoutTokenScreen.this.f55550r.address.mobileNumber)) {
                                            str3 = CheckoutTokenScreen.this.f55550r.address.mobileNumber;
                                        } else {
                                            str3 = str4;
                                        }
                                        BinRequest binRequest = new BinRequest(instance.getSubtotalForVoucher(), instance.getRestaurant().getId(), instance.getDeliveryChargeForVoucher(), instance.isPromotionApplied(), instance.isFreeItemAdded(), instance.isCouponApplied(), str3, CheckoutTokenScreen.binNumber, str2, f12, GlobalDataModel.SelectedAreaId, instance.getRestaurant().getBranchId());
                                        CheckoutTokenScreen checkoutTokenScreen4 = CheckoutTokenScreen.this;
                                        checkoutTokenScreen4.localBinRequest = binRequest;
                                        if (!checkoutTokenScreen4.isGemActive() && !CheckoutTokenScreen.this.isTalabatCreditForUae && !CheckoutTokenScreen.this.isDarkStore()) {
                                            CheckoutTokenScreen.this.iCheckoutDotComPresenter.checkForBinVoucher(binRequest);
                                            CheckoutTokenScreen.this.isBinRequestSent = true;
                                        }
                                    }
                                }
                            } else if (CheckoutTokenScreen.this.iCheckoutDotComPresenter.getBinResponse().binNum.equals(CheckoutTokenScreen.binNumber)) {
                                CheckoutTokenScreen.this.iCheckoutDotComPresenter.applyAvailableBinResponse();
                            }
                        } catch (Exception unused2) {
                            if (!CheckoutTokenScreen.binNumber.equals(editable.toString().substring(0, 6))) {
                                CheckoutTokenScreen.this.isBinRequestSent = false;
                                if (!CheckoutTokenScreen.this.isBinRequestSent) {
                                    CheckoutTokenScreen.binNumber = editable.toString();
                                    Cart instance2 = Cart.getInstance();
                                    if (instance2.hasVoucherApplied()) {
                                        str = instance2.getVoucherCode();
                                        f11 = instance2.getVoucherDiscount();
                                    } else {
                                        f11 = 0.0f;
                                        str = str4;
                                    }
                                    if (!TalabatUtils.isNullOrEmpty(CheckoutTokenScreen.this.f55550r.address.mobileNumber)) {
                                        str4 = CheckoutTokenScreen.this.f55550r.address.mobileNumber;
                                    }
                                    BinRequest binRequest2 = new BinRequest(instance2.getSubtotalForVoucher(), instance2.getRestaurant().getId(), instance2.getDeliveryChargeForVoucher(), instance2.isPromotionApplied(), instance2.isFreeItemAdded(), instance2.isCouponApplied(), str4, CheckoutTokenScreen.binNumber, str, f11, GlobalDataModel.SelectedAreaId, instance2.getRestaurant().getBranchId());
                                    CheckoutTokenScreen checkoutTokenScreen5 = CheckoutTokenScreen.this;
                                    checkoutTokenScreen5.localBinRequest = binRequest2;
                                    if (!checkoutTokenScreen5.isGemActive() && !CheckoutTokenScreen.this.isTalabatCreditForUae && !CheckoutTokenScreen.this.isDarkStore()) {
                                        CheckoutTokenScreen.this.iCheckoutDotComPresenter.checkForBinVoucher(binRequest2);
                                        CheckoutTokenScreen.this.isBinRequestSent = true;
                                    }
                                }
                            }
                        }
                    } else {
                        CheckoutTokenScreen.this.removeBin();
                    }
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                String str;
                CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                checkoutTokenScreen.removeErrorTheme(checkoutTokenScreen.cardNumberErrorTV, CheckoutTokenScreen.this.cardNumberIL);
                String str2 = "";
                if (!TalabatUtils.isNullOrEmpty(charSequence.toString())) {
                    str = charSequence.toString();
                } else {
                    str = str2;
                }
                CheckoutTokenScreen.this.disablePayButton();
                if (!TalabatUtils.isNullOrEmpty(CheckoutTokenScreen.this.f55553u) && CheckoutTokenScreen.this.f55553u.equals("AMEX")) {
                    str2 = "AMEX";
                }
                int[] p02 = CheckoutTokenScreen.this.lengthController(str2);
                if (!TalabatUtils.isNullOrEmpty(str) && p02[1] > 0) {
                    if (str.length() != p02[1]) {
                        CheckoutTokenScreen.this.cardErrorAvailable = true;
                        CheckoutTokenScreen.this.disablePayButton();
                        return;
                    }
                    CheckoutTokenScreen.this.cardErrorAvailable = false;
                    CheckoutTokenScreen.this.enablePayButton();
                }
            }
        });
        this.cvvET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                CheckoutTokenScreen.this.validateCVV(z11);
            }
        });
        this.cvvET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 == 6) {
                    ((InputMethodManager) CheckoutTokenScreen.this.getSystemService("input_method")).hideSoftInputFromWindow(CheckoutTokenScreen.this.cvvET.getWindowToken(), 0);
                }
                return false;
            }
        });
        this.cvvET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                checkoutTokenScreen.removeErrorTheme(checkoutTokenScreen.cvvErrorTV, CheckoutTokenScreen.this.cvvIL);
                if (CheckoutTokenScreen.this.validateCvvDateAutoFocus(true)) {
                    CheckoutTokenScreen.this.holderNameET.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.expiryDateET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                boolean unused = CheckoutTokenScreen.this.validateExpiryDate(z11);
            }
        });
        this.expiryDateET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (!TalabatUtils.isNullOrEmpty(editable.toString())) {
                    CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                    checkoutTokenScreen.formatExpiryDate(checkoutTokenScreen.expiryDateET, CheckoutTokenScreen.this.lastInput, editable.toString());
                    CheckoutTokenScreen checkoutTokenScreen2 = CheckoutTokenScreen.this;
                    checkoutTokenScreen2.lastInput = checkoutTokenScreen2.expiryDateET.getText().toString();
                }
                if (CheckoutTokenScreen.this.validateExpiryDateAutoFocus(true)) {
                    CheckoutTokenScreen.this.cvvET.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                checkoutTokenScreen.removeErrorTheme(checkoutTokenScreen.expDateErrorTV, CheckoutTokenScreen.this.expiryDateIL);
            }
        });
    }

    private void showBenefitAddCardDeflection() {
        this.termsLayout.setVisibility(8);
        this.payBtn.setText(R.string.pay_with_benefit);
        this.cancelBtn.setText(R.string.use_another_card);
        this.benefitNotificationTextView.setText(R.string.benefit_add_card_notification_text);
        enablePayButtonClick();
        this.benefitManagerViewModel.setDebitCardDeflectedShown(true);
        this.nonBenefitBinContainer.setVisibility(8);
        this.qPayBinContainer.setVisibility(8);
        this.benefitBinContainer.setVisibility(0);
        this.benefitNotificationContainer.setVisibility(0);
    }

    private void showBinView() {
        this.binView.setVisibility(0);
    }

    private void showDefaultAddCardViews() {
        this.termsLayout.setVisibility(0);
        this.payBtn.setText(R.string.pf_pay_btn_hint);
        this.payBtn.setEnabled(false);
        this.cancelBtn.setText(R.string.cancel);
        this.payBtn.setAlpha(0.5f);
        this.benefitManagerViewModel.setDebitCardDeflectedShown(false);
        this.nonBenefitBinContainer.setVisibility(0);
        this.benefitBinContainer.setVisibility(8);
        this.qPayBinContainer.setVisibility(8);
        this.benefitNotificationContainer.setVisibility(4);
    }

    private void showQPayAddCardDeflection() {
        this.termsLayout.setVisibility(8);
        this.payBtn.setText(R.string.pay_with_debit_card);
        this.benefitNotificationTextView.setText(R.string.qpay_add_card_notification_text);
        enablePayButtonClick();
        this.benefitManagerViewModel.setDebitCardDeflectedShown(true);
        this.cancelBtn.setText(R.string.use_another_card);
        this.nonBenefitBinContainer.setVisibility(8);
        this.benefitBinContainer.setVisibility(8);
        this.qPayBinContainer.setVisibility(0);
        this.benefitNotificationContainer.setVisibility(0);
    }

    private void showRiderTipCharges(double d11) {
        this.riderTipChargesView.setVisibility(0);
        this.riderTipChargesText.setText(TalabatFormatter.getInstance().getFormattedCurrency((float) d11, true));
    }

    /* access modifiers changed from: private */
    public void showServiceFee(FeeValue feeValue) {
        String str;
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
    public void showSmallOrderFee(FeeValue feeValue) {
        this.smallOrderFeeView.showSmallOrderFee(feeValue);
        this.smallOrderFeeView.setDescriptionText((String) null);
    }

    private void startPlaceOrderWithBenefit() {
        animateSlideTo(0, this.contentView.getHeight(), new SlideAnimationListener() {
            public void onAnimationFinish() {
                CheckoutTokenScreen.this.finish();
            }

            public void onAnimationStart() {
                CheckoutTokenScreen.this.setResult(100, new Intent().putExtra("isBenefit", true));
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateCardTypeIndicator(String str) {
        if (str != null) {
            this.cardTypeIV.setImageResource(WalletCardType.Companion.getCardTypeFromCardName(str).getIconResource());
            if (this.cardTypeIV.getVisibility() != 0) {
                lengthController(str);
                this.cardTypeIV.setVisibility(0);
                return;
            }
            return;
        }
        this.cardTypeIV.setVisibility(8);
        lengthController((String) null);
    }

    /* access modifiers changed from: private */
    public void updatePaymentMethod(PaymentButtonTypeDisplayModel paymentButtonTypeDisplayModel) {
        if (!(paymentButtonTypeDisplayModel instanceof PaymentButtonTypeDisplayModel.PayWithDefaultPayment)) {
            startPlaceOrderWithBenefit();
        } else if (SystemClock.elapsedRealtime() - this.mLastClickTime >= PaymentWidgetBottomSheetFragmentKt.DURATION_DELAY_DURING_FAILURE) {
            hideKeyBoard();
            this.mLastClickTime = SystemClock.elapsedRealtime();
            validateFieldsAndContinue();
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.checkoutdotcom.CheckoutTokenScreen.updateTextColor():void");
    }

    /* access modifiers changed from: private */
    public void validateCVV(boolean z11) {
        int i11;
        String editTextValue = getEditTextValue(this.cvvET, true);
        boolean isAmexAvailable = this.B.walletConfig().isAmexAvailable();
        String editTextValue2 = getEditTextValue(this.cardNumberET, true);
        if (editTextValue2.length() >= 4) {
            String paymentMethodOptionName = getPaymentMethodOptionName(editTextValue2, isAmexAvailable);
            if (paymentMethodOptionName == null || !paymentMethodOptionName.equals("AMEX")) {
                i11 = 3;
            } else {
                i11 = 4;
            }
            if (!z11 && editTextValue.length() != i11 && editTextValue.length() != 0) {
                String string = getString(R.string.pf_cancel_cvv_length);
                if (i11 == 4) {
                    string = getString(R.string.pf_cancel_cvv_amex_length);
                }
                this.cvvErrorAvailable = true;
                addErrorTheme(this.cvvErrorTV, this.cvvIL, string);
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean validateCardAutofoucs() {
        String str;
        EditText editText;
        EditText editText2;
        boolean isAmexAvailable = this.B.walletConfig().isAmexAvailable();
        boolean z11 = true;
        String editTextValue = getEditTextValue(this.cardNumberET, true);
        if (editTextValue.length() == 16 && editTextValue.contains("*")) {
            return false;
        }
        if (editTextValue.length() >= 4) {
            str = getPaymentMethodOptionName(editTextValue, isAmexAvailable);
        } else {
            str = null;
        }
        if (editTextValue.length() < 4) {
            return false;
        }
        if (str == null || str.trim().isEmpty()) {
            removeBin();
            this.cardErrorAvailable = true;
            addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getResources().getString(R.string.pf_errors_card_number_mismatch_ck));
            return false;
        } else if (isLuhnValid(editTextValue)) {
            if (editTextValue.length() != 16) {
                z11 = false;
            }
            removeErrorTheme(this.cardNumberErrorTV, this.cardNumberIL);
            if (this.binAvailable && (editText2 = this.cardNumberET) != null && !TalabatUtils.isNullOrEmpty(editText2.getText().toString()) && this.cardNumberET.getText().toString().length() >= 7 && binNumber.equals(this.cardNumberET.getText().toString().substring(0, 6)) && this.iCheckoutDotComPresenter.getBinResponse() != null && this.iCheckoutDotComPresenter.getBinResponse().binNum.equals(binNumber)) {
                showBinView();
            }
            return z11;
        } else if (editTextValue.length() == 16) {
            removeBin();
            this.cardErrorAvailable = true;
            addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getString(R.string.pf_errors_card_number_invalid));
            return false;
        } else {
            this.cardErrorAvailable = false;
            enablePayButton();
            if (!this.binAvailable || (editText = this.cardNumberET) == null || TalabatUtils.isNullOrEmpty(editText.getText().toString()) || this.cardNumberET.getText().toString().length() < 7 || !binNumber.equals(this.cardNumberET.getText().toString().substring(0, 6)) || this.iCheckoutDotComPresenter.getBinResponse() == null || !this.iCheckoutDotComPresenter.getBinResponse().binNum.equals(binNumber)) {
                return false;
            }
            showBinView();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void validateCardNumber(boolean z11) {
        String str;
        EditText editText;
        boolean isAmexAvailable = this.B.walletConfig().isAmexAvailable();
        String editTextValue = getEditTextValue(this.cardNumberET, true);
        int i11 = 16;
        if (editTextValue.length() != 16 || !editTextValue.contains("*")) {
            if (editTextValue.length() >= 4) {
                str = getPaymentMethodOptionName(editTextValue, isAmexAvailable);
            } else {
                str = null;
            }
            if (str != null && str.equals("AMEX")) {
                i11 = 15;
            }
            if (!z11 && editTextValue.length() != i11 && editTextValue.length() != 0) {
                String string = getResources().getString(R.string.pf_errors_card_number_length);
                if (i11 == 15) {
                    string = getResources().getString(R.string.pf_errors_card_number_amex_length);
                }
                removeBin();
                this.cardErrorAvailable = true;
                addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, string);
            } else if (!z11 && editTextValue.length() == i11) {
                String paymentMethodOptionName = getPaymentMethodOptionName(editTextValue.substring(0, 4), isAmexAvailable);
                if (paymentMethodOptionName == null || paymentMethodOptionName.trim().isEmpty()) {
                    removeBin();
                    this.cardErrorAvailable = true;
                    addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getResources().getString(R.string.pf_errors_card_number_mismatch_ck));
                } else if (!isLuhnValid(editTextValue)) {
                    removeBin();
                    this.cardErrorAvailable = true;
                    addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getResources().getString(R.string.pf_errors_card_number_invalid));
                }
            } else if (this.binAvailable && (editText = this.cardNumberET) != null && !TalabatUtils.isNullOrEmpty(editText.getText().toString()) && this.cardNumberET.getText().toString().length() >= 7 && binNumber.equals(this.cardNumberET.getText().toString().substring(0, 6)) && this.iCheckoutDotComPresenter.getBinResponse() != null && this.iCheckoutDotComPresenter.getBinResponse().binNum.equals(binNumber)) {
                showBinView();
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean validateCvvDateAutoFocus(boolean z11) {
        boolean z12;
        boolean isAmexAvailable = this.B.walletConfig().isAmexAvailable();
        String editTextValue = getEditTextValue(this.cvvET, true);
        String paymentMethodOptionName = getPaymentMethodOptionName(getEditTextValue(this.cardNumberET, true), isAmexAvailable);
        if (paymentMethodOptionName == null || !paymentMethodOptionName.equals("AMEX") ? editTextValue.length() != 3 : editTextValue.length() != 4) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (z12) {
            this.cvvErrorAvailable = false;
            enablePayButton();
        } else {
            this.cvvErrorAvailable = true;
            disablePayButton();
        }
        return z12;
    }

    /* access modifiers changed from: private */
    public boolean validateExpiryDate(boolean z11) {
        if (z11) {
            this.expiryDateIL.setHint(getResources().getText(R.string.pf_expiry_date_value));
        } else {
            String editTextValue = getEditTextValue(this.expiryDateET, true);
            this.expiryDateIL.setHint(getResources().getText(R.string.pf_expiry_date_hint));
            if (editTextValue.length() != 0 && editTextValue.length() != 5) {
                this.expiryErrorAvailable = true;
                addErrorTheme(this.expDateErrorTV, this.expiryDateIL, getResources().getString(R.string.pf_cancel_exp_date_invalid));
                return false;
            } else if (editTextValue.length() == 5) {
                Calendar instance = Calendar.getInstance();
                int i11 = instance.get(2) + 1;
                String valueOf = String.valueOf(instance.get(1));
                if (!editTextValue.contains("/") || editTextValue.substring(0, 2).replace("/", "").equals(TarConstants.VERSION_POSIX)) {
                    this.expiryErrorAvailable = true;
                    addErrorTheme(this.expDateErrorTV, this.expiryDateIL, getResources().getString(R.string.pf_cancel_exp_date_invalid));
                    return false;
                } else if (Integer.valueOf(valueOf.substring(2).replace("/", "")).intValue() > Integer.valueOf(editTextValue.substring(3).replace("/", "")).intValue()) {
                    this.expiryErrorAvailable = true;
                    addErrorTheme(this.expDateErrorTV, this.expiryDateIL, getResources().getString(R.string.pf_cancel_exp_date_in_past));
                    return false;
                } else if (Integer.valueOf(valueOf.substring(2).replace("/", "")) == Integer.valueOf(editTextValue.substring(3).replace("/", "")) && i11 > Integer.valueOf(editTextValue.substring(0, 2).replace("/", "")).intValue()) {
                    this.expiryErrorAvailable = true;
                    addErrorTheme(this.expDateErrorTV, this.expiryDateIL, getResources().getString(R.string.pf_cancel_exp_date_in_past));
                    return false;
                }
            }
        }
        enablePayButton();
        return true;
    }

    /* access modifiers changed from: private */
    public boolean validateExpiryDateAutoFocus(boolean z11) {
        String editTextValue = getEditTextValue(this.expiryDateET, true);
        if (editTextValue.length() == 5) {
            Calendar instance = Calendar.getInstance();
            int i11 = instance.get(2) + 1;
            String valueOf = String.valueOf(instance.get(1));
            if (Integer.valueOf(valueOf.substring(2).replace("/", "")).intValue() > Integer.valueOf(editTextValue.substring(3).replace("/", "")).intValue()) {
                this.expiryErrorAvailable = true;
                addErrorTheme(this.expDateErrorTV, this.expiryDateIL, getResources().getString(R.string.pf_cancel_exp_date_invalid));
            } else if (Integer.valueOf(valueOf.substring(2).replace("/", "")) != Integer.valueOf(editTextValue.substring(3).replace("/", "")) || i11 <= Integer.valueOf(editTextValue.substring(0, 2).replace("/", "")).intValue()) {
                this.expiryErrorAvailable = false;
                removeErrorTheme(this.expDateErrorTV, this.expiryDateIL);
                return true;
            } else {
                this.expiryErrorAvailable = true;
                addErrorTheme(this.expDateErrorTV, this.expiryDateIL, getResources().getString(R.string.pf_cancel_exp_date_invalid));
            }
        }
        return false;
    }

    private boolean validateForm(String str, String str2, String str3) {
        String string = getResources().getString(R.string.checkout_cancel_required_field);
        if (str3.isEmpty()) {
            this.cardErrorAvailable = true;
            addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, string);
            this.cardNumberET.setFocusable(true);
        } else if (str3.length() < 16 && !this.f55553u.equals("AMEX")) {
            this.cardErrorAvailable = true;
            addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getResources().getString(R.string.pf_errors_card_number_length));
            this.cardNumberET.setFocusable(true);
        }
        if (str.isEmpty()) {
            this.expiryErrorAvailable = true;
            addErrorTheme(this.expDateErrorTV, this.expiryDateIL, string);
            this.expiryDateET.setFocusable(true);
        }
        if (str2.isEmpty()) {
            this.cvvErrorAvailable = true;
            addErrorTheme(this.cvvErrorTV, this.cvvIL, string);
            this.cvvET.setFocusable(true);
        }
        if (!validateExpiryDate(false)) {
            return false;
        }
        if ((str3.length() == 16 && str2.length() == 3) || (str3.length() == 15 && str2.length() == 4)) {
            return true;
        }
        validateCVV(false);
        this.cvvET.setFocusable(true);
        return false;
    }

    public void A0(String str, OrderDetails orderDetails) {
        Intent intent = new Intent(this, OrderDetailsScreen.class);
        intent.putExtra("value", str);
        intent.putExtra("statusBoolean", orderDetails.status);
        intent.addFlags(67108864);
        startActivity(intent);
    }

    public void B0() {
        new DarkstoresSharedPreferencesHelper(this).resetDsCart();
    }

    public void addErrorTheme(TextView textView, TextInputLayout textInputLayout, String str) {
        disablePayButton();
        textView.setText(str);
        textView.setVisibility(0);
        this.cvvExpView.setVisibility(0);
    }

    public void addNewCard() {
        try {
            this.payBtn.setEnabled(false);
            this.payBtn.setAlpha(0.5f);
            this.cancelBtn.setEnabled(false);
            this.cancelBtn.setAlpha(0.5f);
            this.payLoadingPB.setVisibility(0);
            disableViews();
            addCard(this.f55541i, this.f55542j, this.f55543k, this.f55544l, this.f55545m);
        } catch (Exception e11) {
            stopLodingPopup();
            e11.printStackTrace();
            goToError(e11.getLocalizedMessage());
        }
    }

    public void animateSlideTo(int i11, int i12, final SlideAnimationListener slideAnimationListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.contentView, "translationY", new float[]{(float) i11, (float) i12});
        ofFloat.setDuration(400);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                SlideAnimationListener slideAnimationListener = slideAnimationListener;
                if (slideAnimationListener != null) {
                    slideAnimationListener.onAnimationFinish();
                }
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                SlideAnimationListener slideAnimationListener = slideAnimationListener;
                if (slideAnimationListener != null) {
                    slideAnimationListener.onAnimationStart();
                }
            }
        });
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CheckoutTokenScreen.this.contentView.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        ofFloat.start();
    }

    public void clearCvv() {
    }

    public void destroyPresenter() {
    }

    public void enablePayButton() {
        boolean z11;
        boolean z12;
        boolean z13;
        if (this.cardErrorAvailable || this.expiryErrorAvailable || this.cvvErrorAvailable) {
            z11 = false;
            z13 = true;
            z12 = true;
        } else {
            int[] lengthController = lengthController(this.f55553u);
            String obj = this.cardNumberET.getText().toString();
            String obj2 = this.cvvET.getText().toString();
            String obj3 = this.expiryDateET.getText().toString();
            if (TalabatUtils.isNullOrEmpty(obj) || lengthController[1] <= 0 || obj.length() != lengthController[1]) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (TalabatUtils.isNullOrEmpty(obj2) || lengthController[0] <= 0 || obj2.length() != lengthController[0]) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (TalabatUtils.isNullOrEmpty(obj3) || obj3.length() != 5) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        if (z12 && z13 && z11) {
            enablePayButtonClick();
            this.cancelBtn.setEnabled(true);
            this.cancelBtn.setAlpha(1.0f);
            this.payByCreditCardView.setVisibility(0);
            this.remainingToPayView.setVisibility(8);
        } else if (this.benefitManagerViewModel.getBenefitDeflectedShown()) {
            enablePayButtonClick();
        } else {
            disablePayButton();
        }
    }

    public void fillViews() {
        String obj = this.expiryDateET.getText().toString();
        this.amountTV.setText(this.f55547o);
        if (this.isQuickOrder) {
            this.securityInfoTxt.setVisibility(8);
            this.rememberMeRL.setVisibility(8);
            this.rememberMeTB.setChecked(false);
            findViewById(R.id.more_security_container_seprator).setVisibility(8);
        } else {
            this.rememberMeRL.setVisibility(0);
            this.securityInfoTxt.setVisibility(0);
            findViewById(R.id.more_security_container_seprator).setVisibility(0);
            this.rememberMeTB.setChecked(true);
        }
        if (obj != null && !obj.isEmpty() && obj.length() >= 4) {
            this.expiryDateET.setText(obj.substring(0, 2) + "/" + obj.substring(2));
        }
    }

    public void formatExpiryDate(EditText editText, String str, String str2) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy", Locale.US);
        try {
            Calendar.getInstance().setTime(simpleDateFormat.parse(str2));
        } catch (ParseException unused) {
            if (str2.length() != 2 || str.endsWith("/")) {
                if (str2.length() != 2 || !str.endsWith("/")) {
                    if (str2.length() == 1 && Integer.parseInt(str2.replace("/", "")) > 1) {
                        editText.setText("0" + editText.getText().toString() + "/");
                        editText.setSelection(editText.getText().toString().length());
                    }
                } else if (Integer.parseInt(str2.replace("/", "")) <= 12) {
                    editText.setText(editText.getText().toString().substring(0, 1));
                    editText.setSelection(editText.getText().toString().length());
                } else {
                    editText.setText("");
                    editText.setSelection(editText.getText().toString().length());
                }
            } else if (Integer.parseInt(str2.replace("/", "")) <= 12) {
                editText.setText(editText.getText().toString() + "/");
                editText.setSelection(editText.getText().toString().length());
            } else {
                editText.setText("0" + editText.getText().toString().charAt(0) + "/" + editText.getText().toString().charAt(1));
                editText.setSelection(editText.getText().toString().length());
            }
        }
    }

    public String getEditTextValue(EditText editText, boolean z11) {
        if (z11) {
            return "" + editText.getText().toString().trim();
        }
        return "" + editText.getText().toString();
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

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return new AddCardRefactorPresenter().getScreenName(getIntent().getBooleanExtra("hideAddCard", false));
    }

    public String getSelectedCardName() {
        String paymentMethodOptionName = getPaymentMethodOptionName(getEditTextValue(this.cardNumberET, true), this.B.walletConfig().isAmexAvailable());
        this.selectedCardName = paymentMethodOptionName;
        return paymentMethodOptionName;
    }

    public void handleWithCreditCard(float f11, String str, String str2) {
    }

    public boolean isBinApplied() {
        return this.isBinDiscountAppliedForTracking;
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public void navigateToThankyouScreen() {
        binNumber = "";
        this.localBinRequest = null;
        if (Customer.getInstance().isLoggedIn(getContext()) && this.isTalabatCreditForUae) {
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            customerInfo.talabatCredit = this.remainingTalabatCredit;
            Customer.getInstance().setCustomerInfo(customerInfo);
        }
        stopLodingPopup();
        Bundle bundleWithCommonValues = getBundleWithCommonValues(this.transactionId, this.encryptedOrderId, Boolean.valueOf(this.isPostDated), Boolean.TRUE, this.customerName);
        bundleWithCommonValues.putBoolean("isFromCheckoutDotCom", true);
        bundleWithCommonValues.putBoolean("isFromAptimize", this.isFromAptimize);
        bundleWithCommonValues.putString("paymentMethod", this.paymnentMethod);
        OrderTrackingNavigator.navigateToOrderTracking((Context) this, bundleWithCommonValues, true);
        B0();
        finish();
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        String str;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 300) {
            if (i12 == -1) {
                navigateToThankyouScreen();
            }
        } else if (i11 == 301 && i12 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("isUpdateCheckOut", false);
            this.isNeedUpdate = booleanExtra;
            if (booleanExtra) {
                if (this.isQuickOrder) {
                    QuickOrderInfo savedQuickOrderAddressData = getSavedQuickOrderAddressData();
                    this.f55552t = savedQuickOrderAddressData;
                    Gson gson = UniversalGson.INSTANCE.gson;
                    if (!(gson instanceof Gson)) {
                        str = gson.toJson((Object) savedQuickOrderAddressData);
                    } else {
                        str = GsonInstrumentation.toJson(gson, (Object) savedQuickOrderAddressData);
                    }
                    this.f55551s = str;
                    this.f55550r.setAddress(this.f55552t.address);
                } else {
                    this.f55550r.setAddress(Customer.getInstance().getSelectedCustomerAddress());
                }
                GlobalDataModel.BIN.numberUpdated = true;
                GlobalDataModel.BIN.updatedNumber = intent.getStringExtra("updatedMobileNo");
            }
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAuthError() {
    }

    public /* synthetic */ void onBNPLOrderError() {
        w10.a.a(this);
    }

    public /* synthetic */ void onBNPLOrderSuccess(PlaceOrderResponse placeOrderResponse) {
        w10.a.b(this, placeOrderResponse);
    }

    public void onBackPressed() {
        View view = this.securityInfoContentView;
        if (view != null && view.getVisibility() == 0) {
            slideOut();
        }
    }

    public void onBackToCheckoutPage(Dialog dialog) {
        dialog.dismiss();
        finish();
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        finish();
        dialog.dismiss();
        Intent intent = new Intent();
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        if (restaurant != null) {
            if (restaurant.shopType == 1) {
                intent = new Intent(this, GroceryMenuScreen.class);
            } else {
                intent = new Intent(this, RestaurantMenuScreenR.class);
            }
        }
        intent.putExtra("from", ScreenNames.CHECKOUT_DOT_COM_SCREEN_CREDIT);
        intent.addFlags(163840);
        startActivity(intent);
    }

    public void onBackToRestaurantPage(Dialog dialog) {
    }

    public void onBinError(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setCancelable(false);
        builder.setTitle((CharSequence) getString(R.string.bin_expired_title));
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckoutTokenScreen.this.stopLodingPopup();
                CheckoutTokenScreen.this.removeBin();
                CheckoutTokenScreen.this.enablePayButton();
                ArrayList arrayList = new ArrayList();
                if (Customer.getInstance().getSavedCards() != null) {
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
                    GlobalDataModel.BIN.stoppedBinNumber = CheckoutTokenScreen.binNumber;
                }
            }
        });
        builder.show();
    }

    public void onBinVoucherAvailable(BinResponse binResponse) {
        this.binAvailable = true;
        if (!TalabatUtils.isNullOrEmpty(binResponse.binNum) && binNumber.equals(binResponse.binNum)) {
            this.binMessage.setText(binResponse.message);
            applyBin(binResponse.binDiscount, binNumber, binResponse.binMinimumOrderAmount);
        }
    }

    public void onCheckoutDotComFailed(String str) {
        binNumber = "";
        stopLodingPopup();
        Intent intent = new Intent(this, PaymentErrorScreen.class);
        intent.putExtra("url", "");
        intent.putExtra("isFromCheckoutDotCom", true);
        intent.putExtra("isGateWayError", false);
        intent.putExtra("paymentMethod", this.paymnentMethod);
        intent.putExtra("encryptedTransactionIdError", this.transactionId);
        startActivity(intent);
        finish();
    }

    public void onCheckoutDotComRecurringFailed(String str) {
        stopLodingPopup();
        Intent intent = new Intent(this, PaymentErrorScreen.class);
        intent.putExtra("url", "");
        intent.putExtra("isFromCheckoutDotCom", true);
        intent.putExtra("isGateWayError", false);
        intent.putExtra("paymentMethod", this.paymnentMethod);
        intent.putExtra("encryptedTransactionIdError", this.transactionId);
        startActivity(intent);
    }

    public void onCloseButtonClicked(Dialog dialog) {
        dialog.dismiss();
    }

    public /* synthetic */ void onContinueToCheckout() {
        a.f(this);
    }

    public void onCreate(Bundle bundle) {
        String str;
        float f11;
        Object obj;
        Object obj2;
        ApiContainer apiContainer = (ApiContainer) getApplication();
        DaggerCheckoutTokenScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class), (ContextCoreLibApi) apiContainer.getFeature(ContextCoreLibApi.class), (FeatureFlagCoreLibApi) apiContainer.getFeature(FeatureFlagCoreLibApi.class), (FeesFeatureApi) apiContainer.getFeature(FeesFeatureApi.class), (ObservabilityCoreLibApi) apiContainer.getFeature(ObservabilityCoreLibApi.class), (TokenizationFeatureApi) apiContainer.getFeature(TokenizationFeatureApi.class), (DeepLinkCoreLibApi) apiContainer.getFeature(DeepLinkCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT > 23) {
            TalabatUtils.changeLocale(this, GlobalDataModel.SelectedLanguage);
        }
        getWindow().setFlags(8192, 8192);
        if (TalabatUtils.isRTL()) {
            setContentView((int) R.layout.activity_get_card_token_ar);
        } else {
            setContentView((int) R.layout.activity_get_card_token_en);
        }
        this.parentLayout = (ViewGroup) findViewById(R.id.parent_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.isQuickOrder = getIntent().getBooleanExtra("isQuick", false);
        this.isQPayDown = getIntent().getBooleanExtra("isQPayDown", false);
        this.f55547o = getIntent().getStringExtra("transactionAmount");
        this.transactionId = getIntent().getStringExtra("transactionId");
        this.encryptedOrderId = getIntent().getStringExtra("encryptedOrderId");
        this.isFromAptimize = getIntent().getBooleanExtra("isFromAptimize", false);
        this.isPostDated = getIntent().getBooleanExtra("isPostDated", this.isPostDated);
        this.isOrderSuccess = getIntent().getBooleanExtra("isOrderSuccess", this.isOrderSuccess);
        this.remainingTalabatCredit = getIntent().getFloatExtra("talabatCredit", this.remainingTalabatCredit);
        this.isTalabatCreditForUae = getIntent().getBooleanExtra("isTalabatCreditForUae", false);
        this.balanceAmountToPay = getIntent().getFloatExtra("balanceAmountToPay", 0.0f);
        this.paymnentMethod = getIntent().getStringExtra("paymentMethod");
        this.isTalabatDelVoucher = getIntent().getBooleanExtra("isTalabatDelVoucher", false);
        this.f55551s = getIntent().getStringExtra("quickOrderString");
        this.customerName = getIntent().getStringExtra("customerName");
        this.isZeroPercentageVoucherApplied = Cart.getInstance().isZeroVoucherApplied();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (getIntent().hasExtra("placeOrderRequestModel")) {
            str = getIntent().getStringExtra("placeOrderRequestModel");
        } else {
            str = "";
        }
        if (!TalabatUtils.isNullOrEmpty(str)) {
            Class cls = PlaceOrderRequestModel.class;
            try {
                if (!(gson instanceof Gson)) {
                    obj2 = gson.fromJson(str, cls);
                } else {
                    obj2 = GsonInstrumentation.fromJson(gson, str, cls);
                }
                this.f55550r = (PlaceOrderRequestModel) obj2;
            } catch (Exception unused) {
                this.f55550r = null;
            }
        }
        String str2 = this.f55551s;
        if (str2 != null) {
            Class cls2 = QuickOrderInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str2, cls2);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str2, cls2);
            }
            this.f55552t = (QuickOrderInfo) obj;
        }
        this.normalFlowView = findViewById(R.id.normal_flow_view);
        this.talabatCreditFlowView = findViewById(R.id.talabat_credit_flow_view);
        this.remainingToPayView = findViewById(R.id.remaining_to_pay_view);
        this.payByCreditCardView = findViewById(R.id.pay_by_credit_card_view);
        this.talabatCreditgrandTotal = (TextView) findViewById(R.id.talabat_credit_grand_total_value);
        this.payBytalabatCreditAmount = (TextView) findViewById(R.id.talabat_credit_payment_amount);
        this.payByCreditCardAmount = (TextView) findViewById(R.id.credit_card_payment_amount);
        this.remainingToPayAmount = (TextView) findViewById(R.id.remaining_pay_amount);
        this.expiryDateET = (EditText) findViewById(R.id.expiryDateET);
        this.cardNumberET = (EditText) findViewById(R.id.cardNumberET);
        this.holderNameET = (EditText) findViewById(R.id.holderNameET);
        this.cvvExpView = findViewById(R.id.cvv_exp_error);
        this.cvvET = (EditText) findViewById(R.id.cvvET);
        this.expiryDateIL = (TextInputLayout) findViewById(R.id.expiryDateIL);
        this.cardNumberIL = (TextInputLayout) findViewById(R.id.cardNumberIL);
        this.holderNameIL = (TextInputLayout) findViewById(R.id.holderNameIL);
        this.cvvIL = (TextInputLayout) findViewById(R.id.cvvIL);
        this.payLoadingPB = findViewById(R.id.progress_layout);
        this.payBtn = (Button) findViewById(R.id.generate_token);
        this.cancelBtn = (Button) findViewById(R.id.cancel);
        this.amountTV = (TextView) findViewById(R.id.amount_transaction);
        this.cardNumberErrorTV = (TextView) findViewById(R.id.cardNumErrorTV);
        this.expDateErrorTV = (TextView) findViewById(R.id.expiryDateErrorTV);
        this.cvvErrorTV = (TextView) findViewById(R.id.cvvErrorTV);
        this.rememberMeRL = (RelativeLayout) findViewById(R.id.rememberMeRL);
        this.rememberMeTB = (ToggleButton) findViewById(R.id.rememberMeTB);
        this.cardTypeIV = (ImageView) findViewById(R.id.cartTypeIV);
        this.gemDiscountView = findViewById(R.id.gem_discount_view);
        this.gemOfferText = (TextView) findViewById(R.id.gem_offer_text);
        this.gemOfferValue = (TextView) findViewById(R.id.gem_offer_price);
        this.contentView = findViewById(R.id.content_view);
        this.binView = findViewById(R.id.bin_voucher_View);
        this.binMessage = (TextView) findViewById(R.id.bin_voucher_text);
        this.combinedDiscountText = (TextView) findViewById(R.id.voucher_discount);
        this.subtotal = (TextView) findViewById(R.id.subtotal_value);
        this.voucher_discount_value = (TextView) findViewById(R.id.discount_voucher_value);
        this.voucher_discount_view = findViewById(R.id.dicount_voucher_layout);
        this.coupon_discount_value = (TextView) findViewById(R.id.coupon_discount_value);
        this.talabat_delivery_discount_value = (TextView) findViewById(R.id.talabat_delivery_voucher_discount_value);
        this.coupon_discount_view = findViewById(R.id.coupon_discount_layout);
        this.talabat_delivery_discount_view = findViewById(R.id.talabat_delivery_voucher_discount_layout);
        this.deliveryChargesValue = (TextView) findViewById(R.id.delivery_charges_value);
        this.deliveryChargesText = (TextView) findViewById(R.id.delivery_charges_text);
        this.deliveryChargesView = findViewById(R.id.restaurant_delivery_charges_view);
        TextView textView = (TextView) findViewById(R.id.old_delivery_charges);
        this.oldDeliveryCharges = textView;
        textView.setPaintFlags(textView.getPaintFlags() | 16);
        this.grandTotal = (TextView) findViewById(R.id.grand_total_value);
        this.muncipalityTaxView = findViewById(R.id.muncipality_charges_view);
        this.touristTaxView = findViewById(R.id.tourist_tax_view);
        this.taxTextView = (TextView) findViewById(R.id.muncipality_charges_value);
        this.touristTaxText = (TextView) findViewById(R.id.tourist_tax_value);
        this.alternateMunicipalityText = (TextView) findViewById(R.id.muncipality_charges_text);
        this.alternateTouristText = (TextView) findViewById(R.id.tourist_tax_text);
        this.tvVoucherDiscount = (TextView) findViewById(R.id.voucher_discount);
        this.benefitNotificationTextView = (TextView) findViewById(R.id.benefit_notification_text_view);
        this.paymentTerms = (TextView) findViewById(R.id.payment_terms);
        this.nonBenefitBinContainer = (LinearLayout) findViewById(R.id.non_benefit_bin_input_container);
        this.benefitBinContainer = findViewById(R.id.benefit_add_card_deflection);
        this.qPayBinContainer = findViewById(R.id.qpay_add_card_deflection);
        this.closeBottomSheet = (ImageView) findViewById(R.id.close_bottom_sheet);
        this.benefitNotificationContainer = findViewById(R.id.benefit_notification_container);
        this.riderTipChargesView = findViewById(R.id.rider_tip_charges_view);
        this.riderTipChargesText = (TextView) findViewById(R.id.rider_tip_charges_text);
        this.securityInfoTxt = findViewById(R.id.more_security_container);
        this.securityInfoContentView = findViewById(R.id.security_info_container);
        this.securityInfoBackBtn = findViewById(R.id.security_back);
        this.sub_content_view = findViewById(R.id.sub_content_view);
        this.termsLayout = findViewById(R.id.terms_layout);
        this.BtnLayout = findViewById(R.id.button_layout);
        BenefitManagerViewModel create = DebitCardDeflectionViewModelFactory.Companion.create(this, PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_QPAY_ADD_CARD_DEFLECTION_ENABLED, this.f55556x, this.E, this.D);
        this.benefitManagerViewModel = create;
        create.getDebitCardBinVerificationData().observe(this, new sf.a(this));
        this.benefitManagerViewModel.getPaymentButtonTypeData().observe(this, new sf.b(this));
        new GemDiscountViewBinder((GemCheckoutDiscountView) findViewById(R.id.gemCheckoutDiscountView), findViewById(R.id.gem_discount_view_layout)).accept((AppCompatActivity) this);
        String replace = getString(R.string.by_placing_the_order_agree_to_terms_replace).replace("#", getResources().getString(R.string.credit_card));
        String string = getString(R.string.terms_and_conditions);
        final String checkoutPaymentTermsUrl = this.H.config().checkoutPaymentTermsUrl();
        this.title = getString(R.string.credit_card_payment);
        this.termsTitle = getString(R.string.credit_terms);
        try {
            checkoutPaymentTermsUrl = checkoutPaymentTermsUrl.replace(BNPLManagerViewModel.BNPL_PAYMENT_METHOD, "0").replace(BNPLManagerViewModel.BNPL_ADDITIONAL_PAYMENT_METHOD, ExifInterface.GPS_MEASUREMENT_2D);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        AnonymousClass1 r62 = new ClickableSpan() {
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutTokenScreen.this, TWebViewScreen.class);
                intent.putExtra("url", checkoutPaymentTermsUrl);
                intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, CheckoutTokenScreen.this.termsTitle);
                CheckoutTokenScreen.this.startActivity(intent);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(CheckoutTokenScreen.this.getResources().getColor(R.color.colorSecondary));
                textPaint.setUnderlineText(false);
            }
        };
        SpannableString spannableString = new SpannableString(replace + " " + string);
        spannableString.setSpan(Integer.valueOf(getResources().getColor(R.color.colorSecondary)), replace.length(), spannableString.length(), 0);
        spannableString.setSpan(r62, replace.length() + 1, spannableString.length(), 33);
        this.paymentTerms.setText(spannableString);
        this.paymentTerms.setMovementMethod(LinkMovementMethod.getInstance());
        setupListeners();
        this.lastInput = "";
        this.expiryDateET.setText("");
        lengthController((String) null);
        fillViews();
        this.iCheckoutDotComPresenter = new CheckoutDotComPresenter(this.f55555w, this.f55556x, this.f55558z, this.A, this.B, this, this);
        this.addCardPresenter = new AddCardPresenterImpl(this.E, DomainModule.INSTANCE.provideSelectedCountryRepository((ApiContainer) getApplication()));
        this.iCheckoutDotComPresenter.setUpViews();
        this.payBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckoutTokenScreen.this.benefitManagerViewModel.onPayButtonClicked();
            }
        });
        new GemPaymentBinder(this.benefitManagerViewModel).accept(this);
        this.cancelBtn.setOnClickListener(new View.OnClickListener() {
            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onClick$0(final DialogInterface dialogInterface, int i11) {
                DebitCardBinVerificationDisplayModel value = CheckoutTokenScreen.this.benefitManagerViewModel.getDebitCardBinVerificationData().getValue();
                if (value == null || (value instanceof DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews)) {
                    CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                    checkoutTokenScreen.animateSlideTo(0, checkoutTokenScreen.contentView.getHeight(), new SlideAnimationListener() {
                        public void onAnimationFinish() {
                            CheckoutTokenScreen.binNumber = "";
                            CheckoutTokenScreen.this.binAvailable = false;
                            CheckoutTokenScreen.this.binApplied = false;
                            CheckoutTokenScreen.this.localBinRequest = null;
                            Cart.getInstance().removeBinDiscountIfApplied();
                            Cart.getInstance().recalcualteTotal();
                            CheckoutTokenScreen.this.finish();
                        }

                        public void onAnimationStart() {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                CheckoutTokenScreen.this.cardNumberET.setText("");
            }

            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - CheckoutTokenScreen.this.mLastClickTime >= PaymentWidgetBottomSheetFragmentKt.DURATION_DELAY_DURING_FAILURE) {
                    CheckoutTokenScreen.this.mLastClickTime = SystemClock.elapsedRealtime();
                    AlertDialog.Builder builder = new AlertDialog.Builder(CheckoutTokenScreen.this, R.style.AlertDialogTheme);
                    builder.create().requestWindowFeature(1);
                    builder.setTitle((CharSequence) null);
                    builder.setMessage((CharSequence) CheckoutTokenScreen.this.getString(R.string.pf_cancel_payment_msg));
                    builder.setPositiveButton((CharSequence) CheckoutTokenScreen.this.getString(R.string.yes), (DialogInterface.OnClickListener) new a(this));
                    builder.setNegativeButton((CharSequence) CheckoutTokenScreen.this.getString(R.string.f54880no), (DialogInterface.OnClickListener) new b());
                    builder.setCancelable(false);
                    builder.show();
                }
            }
        });
        getWindow().setLayout(-1, -2);
        this.securityInfoTxt.setOnClickListener(new c(this));
        this.cvvET.setImeOptions(6);
        this.cvvET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 != 6) {
                    return false;
                }
                ((InputMethodManager) CheckoutTokenScreen.this.getSystemService("input_method")).hideSoftInputFromWindow(CheckoutTokenScreen.this.cvvET.getWindowToken(), 1);
                return false;
            }
        });
        if (this.isTalabatCreditForUae) {
            this.normalFlowView.setVisibility(8);
            this.talabatCreditFlowView.setVisibility(0);
        } else {
            this.normalFlowView.setVisibility(0);
            this.talabatCreditFlowView.setVisibility(8);
        }
        Cart instance = Cart.getInstance();
        this.subtotal.setText(instance.getCartSubTotalDisplayPrice());
        setTaxAndDelivery();
        if (instance.hasVoucherApplied()) {
            if (this.isTalabatDelVoucher) {
                this.talabat_delivery_discount_view.setVisibility(0);
                this.voucher_discount_view.setVisibility(8);
                this.talabat_delivery_discount_value.setText("- " + Cart.getInstance().getDisplayVoucherDiscount());
            } else {
                this.talabat_delivery_discount_view.setVisibility(8);
                this.voucher_discount_view.setVisibility(0);
                this.voucher_discount_value.setText("- " + Cart.getInstance().getDisplayVoucherDiscount());
            }
        } else if (this.isZeroPercentageVoucherApplied) {
            this.talabat_delivery_discount_view.setVisibility(8);
            this.voucher_discount_view.setVisibility(0);
            this.voucher_discount_value.setText(Cart.getInstance().getDisplayVoucherDiscount());
            this.tvVoucherDiscount.setText(getString(R.string.zero_per_voucher_label));
            this.tvVoucherDiscount.setTextColor(getResources().getColor(R.color.talabat_grey));
            this.voucher_discount_value.setTextColor(getResources().getColor(R.color.talabat_grey));
        } else if (instance.isLoyaltyVoucherApplied()) {
            this.voucher_discount_view.setVisibility(0);
            this.voucher_discount_value.setText("- " + instance.getDisplayLoyaltyDiscount());
        }
        if (instance.isFreeDeliveryTypeVoucherApplied()) {
            this.talabat_delivery_discount_view.setVisibility(0);
            this.talabat_delivery_discount_value.setText("- " + instance.getFreeDeliveryDiscountAmount());
        }
        applyTotalPickupDiscount(instance);
        if (instance.isCouponApplied()) {
            this.coupon_discount_view.setVisibility(0);
            this.coupon_discount_value.setText(instance.getCouponDiscountDisplayAmount());
        } else {
            this.coupon_discount_view.setVisibility(8);
        }
        if (Customer.getInstance() == null || !Customer.getInstance().isLoggedIn(getContext()) || Customer.getInstance().getCustomerInfo() == null) {
            f11 = 0.0f;
        } else {
            f11 = Customer.getInstance().getCustomerInfo().talabatCredit;
        }
        float cartTotalPrice = instance.getCartTotalPrice();
        float f12 = f11 - cartTotalPrice;
        if (f12 < 0.0f) {
            f12 = 0.0f;
        }
        this.remainingTalabatCredit = f12;
        if (f11 < cartTotalPrice) {
            this.payBytalabatCreditAmount.setText(TalabatFormatter.getInstance().getFormattedCurrency(f11));
            this.payByCreditCardAmount.setText(TalabatFormatter.getInstance().getFormattedCurrency(this.balanceAmountToPay));
            this.remainingToPayAmount.setText(TalabatFormatter.getInstance().getFormattedCurrency(this.balanceAmountToPay));
        }
        if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance();
            if (GEMEngine.getEligibleOfferAmount() > 0.0f) {
                setGemOfferCharge();
            }
        }
        if (getIntent().getBooleanExtra("hideAddCard", false)) {
            hideAddCardToggle();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        loadAnimation.setDuration(500);
        loadAnimation.setFillAfter(true);
        this.contentView.startAnimation(loadAnimation);
        GEMEngine.withGemEngine(new d(this));
        addCloseBottomSheetListener();
        TalabatBugReportManager.INSTANCE.blockViewsRecording(this.expiryDateET, this.cardNumberET, this.holderNameET, this.cvvET);
        if (instance.isPickup()) {
            this.deliveryChargesView.setVisibility(8);
        }
        setupFees();
    }

    public void onDarkstoresDjiniError(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckoutTokenScreen.this.setResult(-1);
                CheckoutTokenScreen.this.finish();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public void onDestroy() {
        TalabatBugReportManager.INSTANCE.removeViewBlocking(this.expiryDateET, this.cvvET, this.cardNumberET, this.holderNameET);
        super.onDestroy();
    }

    public void onDuplicateOrder(String str, String str2, int i11, String str3) {
        stopLodingPopup();
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
        this.duplicateOrderDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                AppTracker.onDuplicateOrderPopupClosed(CheckoutTokenScreen.this);
            }
        });
        ((ImageView) this.duplicateOrderDialog.findViewById(R.id.close_popup_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                CheckoutTokenScreen.this.duplicateOrderDialog.dismiss();
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
                CheckoutTokenScreen.this.onPopupRadioClicked(radioButton);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setEnabled(true);
                button.setAlpha(1.0f);
                CheckoutTokenScreen.this.onPopupRadioClicked(radioButton2);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setEnabled(true);
                button.setAlpha(1.0f);
                CheckoutTokenScreen.this.onPopupRadioClicked(radioButton3);
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
        final String str4 = str3;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (radioButton.isChecked()) {
                    CheckoutTokenScreen.this.duplicateOrderDialog.dismiss();
                } else if (radioButton2.isChecked()) {
                    CheckoutTokenScreen.this.startLodingPopup();
                    AppTracker.onDuplicateOrderPopupConfirmClicked(CheckoutTokenScreen.this, "view_order");
                    CheckoutTokenScreen.this.iCheckoutDotComPresenter.showOrderDetails(str4);
                } else if (radioButton3.isChecked()) {
                    CheckoutTokenScreen.this.duplicateOrderDialog.dismiss();
                    AppTracker.onDuplicateOrderPopupConfirmClicked(CheckoutTokenScreen.this, "continue_order");
                    PlaceOrderRequestModel placeOrderRequestModel = CheckoutTokenScreen.this.f55550r;
                    if (placeOrderRequestModel != null) {
                        placeOrderRequestModel.setAllowDuplicateOrder(true);
                    }
                    GlobalConstants.isDuplicateOrder = true;
                    CheckoutTokenScreen.this.placeOrder();
                }
            }
        });
        ((Button) this.duplicateOrderDialog.findViewById(R.id.home_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(CheckoutTokenScreen.this, HomeScreenActivity.class);
                intent.addFlags(67108864);
                AppTracker.onDuplicateOrderPopupConfirmClicked(CheckoutTokenScreen.this, "go_to_home");
                CheckoutTokenScreen.this.startActivity(intent);
                if (Cart.getInstance() != null) {
                    Cart.getInstance().clearCart(CheckoutTokenScreen.this);
                }
                CheckoutTokenScreen.this.duplicateOrderDialog.dismiss();
            }
        });
        try {
            this.duplicateOrderDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        } catch (Exception unused) {
        }
        this.duplicateOrderDialog.setCancelable(false);
        AppTracker.onDuplicateOrderPopupShown(this);
        this.duplicateOrderDialog.show();
    }

    public void onError() {
    }

    public void onFeesMismatchError(String str) {
        FeesMismatchErrorDialog.show(this.parentLayout, str, new h(this));
    }

    public void onGemError(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                if (GEMEngine.getInstance() != null) {
                    GEMEngine.getInstance().rejectGem(false);
                }
            }
        });
        builder.show();
        stopLodingPopup();
    }

    public /* synthetic */ void onGemSessionChanged() {
        b.g(this);
    }

    public void onGeneralError(int i11, String str) {
        PlaceOrderRequestModel placeOrderRequestModel = this.f55550r;
        if (placeOrderRequestModel != null && placeOrderRequestModel.isDarkStore && Cart.getInstance().getDarkstoresCartId() != null && Cart.getInstance().getDarkstoresDjiniVendorId() != null) {
            NfvObservabilityHandler.INSTANCE.onDarkstoresCheckoutFailure(Cart.getInstance().getDarkstoresCartId(), Cart.getInstance().getDarkstoresDjiniVendorId(), i11, str);
        }
    }

    public /* synthetic */ void onInterestClicked(Restaurant restaurant) {
        a.g(this, restaurant);
    }

    public void onInvalidConditionHandled() {
        stopLodingPopup();
        finish();
    }

    public /* synthetic */ void onLeaveOfferClicked(boolean z11) {
        a.h(this, z11);
    }

    public void onMinimumOrderConditionForBINFailed(String str, String str2) {
        this.binAvailable = true;
        if (!TalabatUtils.isNullOrEmpty(str2) && binNumber.equals(str2)) {
            this.binMessage.setText(str);
            showBinView();
        }
    }

    public void onNullResponseReceived() {
        stopLodingPopup();
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
    }

    public void onOrderCouponNotAvailable(String str, final boolean z11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) getString(R.string.remove).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                CheckoutTokenScreen.this.payLoadingPB.setVisibility(0);
                CheckoutTokenScreen.this.iCheckoutDotComPresenter.removeInvalidCoupon(z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((CharSequence) getString(R.string.change_time).toString(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CheckoutTokenScreen.this.stopLodingPopup();
                    dialogInterface.dismiss();
                }
            });
        }
        builder.show();
        stopLodingPopup();
    }

    public void onOrderDetailsRecieved(final OrderDetails orderDetails) {
        final String str;
        stopLodingPopup();
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            str = gson.toJson((Object) orderDetails);
        } else {
            str = GsonInstrumentation.toJson(gson, (Object) orderDetails);
        }
        if (this.E.getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_SHOW_NEW_FLUTTER_ORDER_DETAILS, false)) {
            final String str2 = "talabat://?s=order-details&order_id=" + orderDetails.getOrderTransactionID() + "&country_iso=" + this.A.selectedCountry().getCountry().getTwoLetterCode();
            this.f55557y.canHandleDeepLink(str2, new Continuation() {
                @NonNull
                public CoroutineContext getContext() {
                    return Dispatchers.getMain();
                }

                public void resumeWith(@NonNull Object obj) {
                    if (!(obj instanceof Boolean)) {
                        CheckoutTokenScreen.this.A0(str, orderDetails);
                    } else if (((Boolean) obj).booleanValue()) {
                        CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                        checkoutTokenScreen.f55557y.navigateTo(checkoutTokenScreen, str2, (Function0<Unit>) null);
                    } else {
                        CheckoutTokenScreen.this.A0(str, orderDetails);
                    }
                }
            });
            return;
        }
        A0(str, orderDetails);
    }

    public void onOrderError(final int i11, String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (i11 == 58) {
                    AppTracker.onKNETFailureLghtboxClosed(CheckoutTokenScreen.this);
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
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) getString(R.string.view_cart).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                CheckoutTokenScreen.this.payLoadingPB.setVisibility(0);
                CheckoutTokenScreen.this.iCheckoutDotComPresenter.removeInvalidItems(z11, invalidItemArr);
            }
        });
        if (z11) {
            builder.setNegativeButton((CharSequence) getString(R.string.cancel).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CheckoutTokenScreen.this.stopLodingPopup();
                    dialogInterface.dismiss();
                }
            });
        }
        builder.show();
        stopLodingPopup();
    }

    public void onOrderPromotionNotAvailable(String str, final boolean z11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) getString(R.string.remove).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckoutTokenScreen.this.payLoadingPB.setVisibility(0);
                CheckoutTokenScreen.this.iCheckoutDotComPresenter.removeInvalidPromotion(z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((CharSequence) getString(R.string.change_time).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CheckoutTokenScreen.this.stopLodingPopup();
                    dialogInterface.dismiss();
                }
            });
        }
        builder.show();
        stopLodingPopup();
    }

    public void onOrderSucess(PlaceOrderResponse placeOrderResponse) {
        stopLodingPopup();
        Customer.getInstance().getCustomerInfo().talabatCredit = this.remainingTalabatCredit;
        if (isGemActive()) {
            withGemAnalytics().onOrderComplete(placeOrderResponse.transactionId);
        }
        Bundle bundleWithCommonValues = getBundleWithCommonValues(placeOrderResponse.transactionId, placeOrderResponse.encryptedOrderId, Boolean.valueOf(this.isPostDated), Boolean.valueOf(placeOrderResponse.isOrderSuccess), this.customerName);
        bundleWithCommonValues.putBoolean("isFromAptimize", this.isFromAptimize);
        bundleWithCommonValues.putBoolean("isFromVisaCheckout", false);
        OrderTrackingNavigator.navigateToOrderTracking((Context) this, bundleWithCommonValues, true);
        finish();
    }

    public void onOrderVoucherNotAvailable(String str, final boolean z11) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setCancelable(false);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckoutTokenScreen.this.payLoadingPB.setVisibility(0);
                CheckoutTokenScreen.this.iCheckoutDotComPresenter.removeInvalidVoucher(z11);
                dialogInterface.dismiss();
            }
        });
        if (z11) {
            builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    CheckoutTokenScreen.this.stopLodingPopup();
                    dialogInterface.dismiss();
                }
            });
        }
        builder.show();
        stopLodingPopup();
    }

    public void onPause() {
        GEMEngine.withGemEngine(new ve.b());
        super.onPause();
    }

    public void onRedirectToCartPage() {
        stopLodingPopup();
        Intent intent = new Intent(this, CartScreen.class);
        intent.putExtra(GlobalConstants.KEY_FROMCARDSCREEN, true);
        intent.addFlags(67108864);
        startActivity(intent);
        finish();
    }

    public void onRedirectToPaymentPage(PlaceOrderResponse placeOrderResponse, String str, String str2, int i11) {
    }

    public void onRedirectToPaymentWebViewWithCheckoutDotCom(PurchaseResponse purchaseResponse) {
        String str = "";
        binNumber = str;
        Intent intent = new Intent(this, PaymentWebViewScreen.class);
        intent.putExtra("title", getString(R.string.credit_card_payment));
        intent.putExtra("url", purchaseResponse.redirectUrl);
        intent.putExtra("paymenttransactionId", this.transactionId);
        intent.putExtra("isFromCheckout", true);
        intent.putExtra("map_compulsory", getIntent().getBooleanExtra("map_compulsory", false));
        intent.putExtra("nineCookiesEnabled", getIntent().getBooleanExtra("nineCookiesEnabled", false));
        intent.putExtra("isAddressFromCartOrderFlow", getIntent().getBooleanExtra("isAddressFromCartOrderFlow", false));
        intent.putExtra("talabatDeliveryAvailable", getIntent().getBooleanExtra("talabatDeliveryAvailable", false));
        intent.putExtra("newaddressCreation", getIntent().getBooleanExtra("newaddressCreation", false));
        intent.putExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, getIntent().getBooleanExtra(GlobalConstants.FORCE_MAP.CHECKOUT_SUCCESS, false));
        intent.putExtra("isFromAptimize", getIntent().getBooleanExtra("isFromAptimize", false));
        intent.putExtra("isGlrEnabledRes", getIntent().getBooleanExtra("isGlrEnabledRes", false));
        intent.putExtra("isNewAddressCreationFromGrlFlow", getIntent().getBooleanExtra("isNewAddressCreationFromGrlFlow", false));
        intent.putExtra("isQuick", getIntent().getBooleanExtra("isQuick", false));
        if (getIntent().hasExtra("value")) {
            str = getIntent().getStringExtra("value");
        }
        intent.putExtra("value", str);
        intent.putExtra("appendedName", getIntent().getStringExtra("appendedName"));
        stopLodingPopup();
        startActivityForResult(intent, 300);
    }

    public void onRedirectToRestaurantList() {
        stopLodingPopup();
        Intent intent = new Intent(this, RestaurantsListScreenRefactor.class);
        GlobalDataModel.showOnlyOpenRestaurant = true;
        Cart.getInstance().removeVoucherIfApplied();
        Cart.getInstance().removeBinDiscountIfApplied();
        intent.putExtra(GlobalConstants.ExtraNames.REDIRECT, "Restaurant List Screen");
        intent.putExtra(GlobalConstants.ExtraNames.RESTAURANT_LIST_FITLER_CLOSED, true);
        intent.putExtra(GlobalConstants.KEY_FROMCARDSCREEN, true);
        intent.setFlags(67108864);
        startActivity(intent);
    }

    public void onRequestException(boolean z11) {
        stopLodingPopup();
        if (z11) {
            Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
        }
    }

    public void onResponseRecieved() {
        this.isPlaceOrderClicked = false;
        enablePayButton();
    }

    public void onResume() {
        super.onResume();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        this.contentView.setLayoutParams(layoutParams);
        try {
            View view = this.sub_content_view;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        CheckoutTokenScreen.this.sub_content_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        CheckoutTokenScreen checkoutTokenScreen = CheckoutTokenScreen.this;
                        checkoutTokenScreen.f55554v = checkoutTokenScreen.sub_content_view.getMeasuredHeight() + CheckoutTokenScreen.this.termsLayout.getMeasuredHeight() + CheckoutTokenScreen.this.BtnLayout.getMeasuredHeight();
                    }
                });
            }
        } catch (Exception unused) {
        }
        if (!this.isPlaceOrderClicked) {
            enablePayButton();
        }
    }

    public /* synthetic */ void onSendCVVToProxyServer(RecurringPurchaseRequest recurringPurchaseRequest, int i11) {
        w10.a.c(this, recurringPurchaseRequest, i11);
    }

    public void onServerError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onSuccessfulCheckoutDotCom() {
        this.payBtn.setVisibility(8);
        navigateToThankyouScreen();
    }

    public void onSuccessfulRecurringCheckoutDotCom() {
        stopLodingPopup();
        Customer.getInstance().getCustomerInfo().talabatCredit = this.remainingTalabatCredit;
        if (isGemActive()) {
            withGemAnalytics().onOrderComplete(this.transactionId);
        }
        Bundle bundleWithCommonValues = getBundleWithCommonValues(this.transactionId, this.encryptedOrderId, Boolean.valueOf(this.isPostDated), Boolean.TRUE, this.customerName);
        bundleWithCommonValues.putString("paymentMethod", this.paymnentMethod);
        bundleWithCommonValues.putBoolean("isFromCheckoutDotCom", true);
        OrderTrackingNavigator.navigateToOrderTracking((Context) this, bundleWithCommonValues, true);
        B0();
        finish();
    }

    public void onUserTypeErrorForDiscount(String str) {
        Cart.getInstance().removeTgoFreeDeliveryTiers();
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckoutTokenScreen.this.setTaxAndDelivery();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    public void onVisaCheckoutOrderPlaced(Purchase purchase, String str, String str2) {
    }

    public void placeOrder() {
        this.cardErrorAvailable = false;
        this.expiryErrorAvailable = false;
        this.cvvErrorAvailable = false;
        this.isPlaceOrderClicked = true;
        this.payBtn.setEnabled(false);
        this.payBtn.setAlpha(0.5f);
        this.cancelBtn.setEnabled(false);
        this.cancelBtn.setAlpha(0.5f);
        this.payLoadingPB.setVisibility(0);
        if (this.binApplied) {
            this.f55550r.setCart(Cart.getInstance().getTransactionCart());
        }
        this.iCheckoutDotComPresenter.placeOrder(this.f55550r);
    }

    public void removeErrorTheme(TextView textView, TextInputLayout textInputLayout) {
        enablePayButton();
        textView.setVisibility(8);
        if (textInputLayout.getError() != null) {
            textInputLayout.setError((CharSequence) null);
        }
    }

    public /* synthetic */ void resetGemFlow() {
        b.h(this);
    }

    @VisibleForTesting
    public void setAddCardPresenter(AddCardPresenter addCardPresenter2) {
        this.addCardPresenter = addCardPresenter2;
    }

    public void setAltTextDeliveryCharges(String str) {
        this.deliveryChargesText.setText(str);
    }

    public void setAltTextMuncipalityTax(String str) {
        this.alternateMunicipalityText.setText(str);
    }

    public void setAltTextTouristTax(String str) {
        this.alternateTouristText.setText(str);
    }

    @VisibleForTesting
    public void setCardErrorAvailable(boolean z11) {
        this.cardErrorAvailable = z11;
    }

    public void setDeliveryCharges(String str, String str2) {
        if (str2.equals("d")) {
            str2 = getString(R.string.restaurant_del_charges);
        } else if (str2.equals("t")) {
            str2 = getString(R.string.talabat_charges);
        }
        this.deliveryChargesText.setText(str2);
        setDeliveryView(str);
    }

    public void setEncryptedOrderId(String str) {
        this.encryptedOrderId = str;
    }

    public void setGemOfferCharge() {
        this.gemOfferValue.setText(Cart.getInstance().getGemOfferDisplayAmount());
        updateTextColor();
        if (GEMEngine.hasGemDiscount()) {
            this.gemDiscountView.setVisibility(0);
        } else {
            this.gemDiscountView.setVisibility(8);
        }
    }

    public void setMuncipalityTaxView(String str) {
        this.muncipalityTaxView.setVisibility(0);
        this.taxTextView.setText(str);
    }

    public void setPlaceOrderResponse(PlaceOrderResponse placeOrderResponse) {
    }

    public void setTouristTaxView(String str) {
        this.touristTaxView.setVisibility(0);
        this.touristTaxText.setText(str);
    }

    public void setTransactionId(String str) {
        this.transactionId = str;
    }

    public void showBusyPopup(String str, boolean z11) {
        String str2;
        String str3;
        String str4;
        stopNonCancelableLoading();
        Cart instance = Cart.getInstance();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        if (z11) {
            if (instance.getRestaurant().isTalabatGo) {
                str2 = getString(R.string.bsy_close_tgo_alert_title);
            } else {
                str2 = instance.getRestaurant().getName();
            }
            if (instance.getRestaurant().isTalabatGo) {
                str3 = str.replace(RichContentLoadTimeRecorder.DELIMETER, instance.getRestaurant().f13873name);
            } else {
                str3 = str.replace("#phrest#", instance.getRestaurant().branchName);
            }
            if (instance.getRestaurant().isTalabatGo) {
                str4 = getString(R.string.continue_to_tgo_restaurant);
            } else {
                str4 = getString(R.string.try_more_restaurants);
            }
        } else {
            str2 = instance.getRestaurant().getName();
            str3 = str.replace("#phrest#", instance.getRestaurant().branchName);
            str4 = getString(R.string.try_more_restaurants);
        }
        builder.setTitle((CharSequence) str2);
        builder.setMessage((CharSequence) str3);
        builder.setPositiveButton((CharSequence) str4, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                if (CheckoutTokenScreen.this.iCheckoutDotComPresenter != null) {
                    CheckoutTokenScreen.this.payLoadingPB.setVisibility(0);
                    CheckoutTokenScreen.this.iCheckoutDotComPresenter.tryMoreRestaurantsClicked();
                }
            }
        });
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                CheckoutTokenScreen.this.stopLodingPopup();
            }
        });
        builder.show();
        enablePayButton();
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public void showInAppReminder(int i11) {
    }

    public void showTimeOutDialog() {
        BinRequest binRequest;
        if (GEMEngine.getInstance().getCurrentGemIndex() > 0) {
            showGemTimeOutDialog(this.mGemDialogSwitcher, this.f55549q, this, this);
        }
        try {
            if (!TalabatUtils.isNullOrEmpty(this.cardNumberET.getText().toString().trim()) && this.cardNumberET.getText().toString().trim().length() >= 7 && (binRequest = this.localBinRequest) != null && binRequest.getBinNum().equals(this.cardNumberET.getText().toString().trim().substring(0, 6))) {
                this.iCheckoutDotComPresenter.checkForBinVoucher(this.localBinRequest);
                this.isBinRequestSent = true;
            }
        } catch (Exception unused) {
        }
    }

    public void showTimerView(boolean z11, String str) {
    }

    public void slideOut() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.f55554v, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                CheckoutTokenScreen.this.contentView.setVisibility(0);
                CheckoutTokenScreen.this.contentView.clearAnimation();
                CheckoutTokenScreen.this.securityInfoContentView.clearAnimation();
                CheckoutTokenScreen.this.contentView.setFocusableInTouchMode(true);
                CheckoutTokenScreen.this.securityInfoContentView.setVisibility(8);
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.securityInfoContentView.startAnimation(translateAnimation);
    }

    public void slidein() {
        hideKeyBoard();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.securityInfoContentView.getLayoutParams();
        layoutParams.height = this.f55554v;
        this.securityInfoContentView.setLayoutParams(layoutParams);
        this.securityInfoContentView.setVisibility(0);
        this.securityInfoContentView.requestLayout();
        TranslateAnimation translateAnimation = new TranslateAnimation((float) this.securityInfoContentView.getWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                CheckoutTokenScreen.this.contentView.setFocusableInTouchMode(false);
                CheckoutTokenScreen.this.contentView.setVisibility(0);
                CheckoutTokenScreen.this.contentView.clearAnimation();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                CheckoutTokenScreen.this.contentView.setVisibility(0);
                CheckoutTokenScreen.this.contentView.clearAnimation();
            }
        });
        this.securityInfoContentView.startAnimation(translateAnimation);
    }

    public /* synthetic */ void stopLoading() {
        v00.a.e(this);
    }

    public void stopLodingPopup() {
        super.stopLodingPopup();
        this.payLoadingPB.setVisibility(8);
    }

    @VisibleForTesting
    public void updateBenefitBinVerificationView(DebitCardBinVerificationDisplayModel debitCardBinVerificationDisplayModel) {
        if (debitCardBinVerificationDisplayModel instanceof DebitCardBinVerificationDisplayModel.ShowBenefitAddCardDeflection) {
            showBenefitAddCardDeflection();
        } else if (debitCardBinVerificationDisplayModel instanceof DebitCardBinVerificationDisplayModel.ShowQPayAddCardDeflection) {
            showQPayAddCardDeflection();
        } else if (debitCardBinVerificationDisplayModel instanceof DebitCardBinVerificationDisplayModel.ShowDefaultAddCardViews) {
            showDefaultAddCardViews();
        }
    }

    public void validateFieldsAndContinue() {
        this.f55542j = this.addCardPresenter.getCardHolderName(this.holderNameET.getText().toString().trim());
        this.f55541i = this.cardNumberET.getText().toString().trim();
        this.f55546n = this.rememberMeTB.isChecked();
        this.f55545m = this.cvvET.getText().toString().trim();
        if (validateForm(this.expiryDateET.getText().toString(), this.f55545m, this.f55541i) && this.expiryDateIL.getError() == null && this.cardNumberIL.getError() == null && this.cvvIL.getError() == null && this.expiryDateET.getText().toString().length() == 5) {
            this.f55543k = this.expiryDateET.getText().toString().trim().substring(0, 2);
            this.f55544l = this.expiryDateET.getText().toString().trim().substring(3, 5);
            applyCardForValidate(TalabatUtils.getSixBinNumber(this.f55541i), TalabatUtils.getLastDigitNumberValidate(this.f55541i));
            if (!this.cardErrorAvailable && !this.expiryErrorAvailable && !this.cvvErrorAvailable) {
                if (!this.isTalabatCreditForUae) {
                    placeOrder();
                } else {
                    addNewCard();
                }
            }
        }
    }

    public void verifyMobileNumber(String str, String str2, String str3, String str4) {
        stopLodingPopup();
        Intent intent = new Intent(this, MobileNumberVerification.class);
        intent.putExtra("userselectedmobno", str);
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId()) {
            intent.putExtra("userSelectedInternationalCountryCode", str2);
        }
        intent.putExtra("isFromAptimize", this.isFromAptimize);
        if (this.isQuickOrder) {
            intent.putExtra("isQuick", true);
            intent.putExtra("value", this.f55551s);
        }
        intent.putExtra("smsToken", str3);
        intent.putExtra("encryptedNumber", str4);
        startActivityForResult(intent, 301);
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }
}
