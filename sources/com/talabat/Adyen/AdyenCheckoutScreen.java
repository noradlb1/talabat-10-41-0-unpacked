package com.talabat.Adyen;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Request.AdyenRequestModels.AdyenPurchaseRequest;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import JsonModels.Response.AdyenResponse.AdyenPurchaseResponse;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.parser.UniversalGson;
import adyen.com.adyencse.pojo.Card;
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
import android.graphics.drawable.Drawable;
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
import android.util.Log;
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
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.text.HtmlCompat;
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
import com.talabat.core.di.ApiContainer;
import com.talabat.di.checkout.DaggerCheckoutAdyenScreenComponent;
import com.talabat.feature.tokenization.data.mapper.NonEnglishNumbersMapper;
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
import com.talabat.talabatcommon.views.wallet.walletPaymentOption.view.PaymentWidgetBottomSheetFragmentKt;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import com.talabat.wallet.bnplmanager.presentation.viewmodel.BNPLManagerViewModel;
import datamodels.CustomerInfo;
import datamodels.InvalidItem;
import datamodels.OrderDetails;
import datamodels.QuickOrderInfo;
import datamodels.Restaurant;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.inject.Inject;
import library.talabat.gemengine.GemView;
import library.talabat.mvp.AdyenMVP.AdyenPresenter;
import library.talabat.mvp.AdyenMVP.AdyenView;
import library.talabat.mvp.AdyenMVP.IAdyenPresenter;
import library.talabat.mvp.IGlobalPresenter;
import library.talabat.mvp.placeorder.PlaceOrderView;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.json.JSONException;
import org.json.JSONObject;
import tracking.AppTracker;
import tracking.Purchase;
import tracking.ScreenNames;
import xq.b;
import yq.a;

@Instrumented
public class AdyenCheckoutScreen extends TalabatBase implements AdyenView, PlaceOrderView, GemView, OnGemAlertDialogClickListener, GemAccessor {
    private static final int MOB_VERIFCATION_DIALOG = 301;
    private static final int PAYMENTPAGE = 300;
    public static String binNumber = "";
    @Inject
    public TermsAndConditionsConfigurationRepository A;
    @Inject
    public NonEnglishNumbersMapper B;
    /* access modifiers changed from: private */
    public View BtnLayout;
    private TextView alternateMunicipalityText;
    private TextView alternateTouristText;
    private TextView amountTV;
    private float balanceAmountToPay = 0.0f;
    /* access modifiers changed from: private */
    public boolean binApplied = false;
    /* access modifiers changed from: private */
    public boolean binAvailable = false;
    private TextView binMessage;
    private View binView;
    private Button cancelBtn = null;
    /* access modifiers changed from: private */
    public boolean cardErrorAvailable = true;
    private EditText cardNumberET;
    /* access modifiers changed from: private */
    public TextView cardNumberErrorTV;
    /* access modifiers changed from: private */
    public TextInputLayout cardNumberIL;
    /* access modifiers changed from: private */
    public ImageView cardTypeIV = null;
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
    public int height = 0;
    /* access modifiers changed from: private */
    public EditText holderNameET = null;
    private TextInputLayout holderNameIL = null;

    /* renamed from: i  reason: collision with root package name */
    public String f53563i;
    /* access modifiers changed from: private */
    public IAdyenPresenter iAdyenPresenter;
    /* access modifiers changed from: private */
    public boolean isBinRequestSent = false;
    private boolean isFromAptimize;
    private boolean isNeedUpdate;
    private boolean isOrderSuccess = false;
    private boolean isPlaceOrderClicked = false;
    private boolean isPostDated = false;
    private boolean isQuickOrder = false;
    /* access modifiers changed from: private */
    public boolean isTalabatCreditForUae = false;
    private boolean isTalabatDelVoucher = false;
    private boolean isZeroPercentageVoucherApplied;

    /* renamed from: j  reason: collision with root package name */
    public String f53564j;

    /* renamed from: k  reason: collision with root package name */
    public String f53565k;

    /* renamed from: l  reason: collision with root package name */
    public String f53566l;
    /* access modifiers changed from: private */
    public String lastInput = "";
    public BinRequest localBinRequest = null;

    /* renamed from: m  reason: collision with root package name */
    public String f53567m;
    private GemDialogSwitcher mGemDialogSwitcher;
    /* access modifiers changed from: private */
    public long mLastClickTime = 0;
    private Toolbar mToolbar;
    private View muncipalityTaxView;

    /* renamed from: n  reason: collision with root package name */
    public boolean f53568n;
    private View normalFlowView;

    /* renamed from: o  reason: collision with root package name */
    public String f53569o;
    private TextView oldDeliveryCharges;

    /* renamed from: p  reason: collision with root package name */
    public boolean f53570p = false;
    private Button payBtn = null;
    private TextView payByCreditCardAmount;
    private View payByCreditCardView;
    private TextView payBytalabatCreditAmount;
    /* access modifiers changed from: private */
    public View payLoadingPB = null;
    private TextView paymentTerms;
    private String paymnentMethod;
    public int popupWidth;
    private String publicKey;

    /* renamed from: q  reason: collision with root package name */
    public GemFooterCartView f53571q;

    /* renamed from: r  reason: collision with root package name */
    public PlaceOrderRequestModel f53572r = null;
    private float remainingTalabatCredit = 0.0f;
    private TextView remainingToPayAmount;
    private View remainingToPayView;
    private RelativeLayout rememberMeRL = null;
    private ToggleButton rememberMeTB = null;

    /* renamed from: s  reason: collision with root package name */
    public String f53573s;
    public View scanCard;
    public int screenWidth;
    private View securityInfoBackBtn;
    /* access modifiers changed from: private */
    public View securityInfoContentView;
    private View securityInfoTxt;
    private View showCaseView;
    /* access modifiers changed from: private */
    public View sub_content_view;
    private TextView subtotal;
    private boolean successCalled = false;

    /* renamed from: t  reason: collision with root package name */
    public QuickOrderInfo f53574t;
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
    private String transactionId;
    private TextView tvVoucherDiscount;

    /* renamed from: u  reason: collision with root package name */
    public String f53575u = "";
    private String userNameFromAddress;
    @Inject

    /* renamed from: v  reason: collision with root package name */
    public AppVersionProvider f53576v;
    private TextView voucher_discount_value;
    private View voucher_discount_view;
    @Inject

    /* renamed from: w  reason: collision with root package name */
    public ConfigurationLocalRepository f53577w;
    @Inject

    /* renamed from: x  reason: collision with root package name */
    public DiscoveryConfigurationRepository f53578x;
    @Inject

    /* renamed from: y  reason: collision with root package name */
    public LocationConfigurationRepository f53579y;
    @Inject

    /* renamed from: z  reason: collision with root package name */
    public PaymentConfigurationRepository f53580z;

    public interface SlideAnimationListener {
        void onAnimationFinish();

        void onAnimationStart();
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
    }

    private void applyCardForValidate(String str, String str2) {
        if (Cart.getInstance() != null) {
            Cart.getInstance().setBinAndLatDigitForValidate(str, str2);
        }
    }

    private Card buildCardData() {
        try {
            Card.Builder expiryMonth = new Card.Builder().setHolderName(this.userNameFromAddress).setCvc(this.f53567m).setExpiryMonth(this.f53565k);
            return expiryMonth.setExpiryYear("20" + this.f53566l).setGenerationTime(new Date()).setNumber(this.f53563i).build();
        } catch (ArrayIndexOutOfBoundsException | IllegalStateException | NullPointerException e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(e11.getClass().getSimpleName());
            sb2.append(": ");
            sb2.append(e11.getLocalizedMessage());
            stopLodingPopup();
            e11.printStackTrace();
            goToError(e11.getLocalizedMessage());
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void disablePayButton() {
        this.payByCreditCardView.setVisibility(8);
        this.remainingToPayView.setVisibility(0);
        this.payBtn.setEnabled(false);
        this.payBtn.setAlpha(0.5f);
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

    private void getTokenForAdyen() {
        JSONObject loadJsonConfiguration = loadJsonConfiguration(getApplicationContext());
        Card buildCardData = buildCardData();
        if (buildCardData != null) {
            try {
                String serialize = buildCardData.serialize(loadJsonConfiguration.getString("publicKey"));
                AdyenPurchaseRequest adyenPurchaseRequest = new AdyenPurchaseRequest();
                adyenPurchaseRequest.language = GlobalDataModel.SelectedLanguage;
                adyenPurchaseRequest.saveCard = this.f53568n;
                adyenPurchaseRequest.token = serialize;
                adyenPurchaseRequest.transactionId = this.transactionId;
                goToSuccess(adyenPurchaseRequest);
            } catch (Exception e11) {
                stopLodingPopup();
                e11.printStackTrace();
                goToError(e11.getLocalizedMessage());
                e11.getLocalizedMessage();
            }
        }
    }

    private void goToError(String str) {
        binNumber = "";
        stopLodingPopup();
        Intent intent = new Intent(this, PaymentErrorScreen.class);
        intent.putExtra("url", "");
        intent.putExtra("isFromCheckoutDotCom", true);
        intent.putExtra("isGateWayError", true);
        intent.putExtra("paymentMethod", this.paymnentMethod);
        intent.putExtra("encryptedTransactionIdError", this.transactionId);
        startActivity(intent);
        finish();
    }

    private void goToSuccess(AdyenPurchaseRequest adyenPurchaseRequest) {
        this.payLoadingPB.setVisibility(0);
        this.successCalled = true;
        this.payBtn.setVisibility(0);
        this.iAdyenPresenter.proceedPayment(adyenPurchaseRequest);
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
    public /* synthetic */ void lambda$onCreate$0(GEMEngine gEMEngine) throws Exception {
        gEMEngine.startListening(this, true);
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
        this.grandTotal.setText(instance.getCartTotalDisplayPrice());
        setTaxAndDelivery();
    }

    /* access modifiers changed from: private */
    public void securityInformationView() {
        this.contentView.clearAnimation();
        slidein();
        View view = this.securityInfoBackBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AdyenCheckoutScreen.this.slideOut();
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
        String str;
        String str2;
        Cart instance = Cart.getInstance();
        Restaurant restaurant = instance.getRestaurant();
        this.subtotal.setText(instance.getCartSubTotalDisplayPrice());
        if (restaurant != null) {
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
                setDeliveryCharges(instance.getDeliveryChargesDisplayPrice(), str);
            }
            if (restaurant.getMunicipalityTax() > 0.0f) {
                setMuncipalityTaxView(instance.getDisplayMuncipalityTax());
                if (!TalabatUtils.isNullOrEmpty(restaurant.altMunicipalityText)) {
                    setAltTextMuncipalityTax(restaurant.altMunicipalityText);
                }
            }
            if (restaurant.getTouristTax() > 0.0f) {
                setTouristTaxView(instance.getDispalyTouristTax());
                if (!TalabatUtils.isNullOrEmpty(restaurant.altTouristTaxText)) {
                    setAltTextTouristTax(restaurant.altTouristTaxText);
                }
            }
        }
        setGrandTotal(instance.getCartTotalDisplayPrice());
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
                AdyenCheckoutScreen.this.validateCardNumber(z11);
            }
        });
        this.cardNumberET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                float f11;
                String str;
                float f12;
                String str2;
                String str3;
                String str4 = "";
                String obj = editable.toString();
                int length = editable.length();
                if (length >= 4) {
                    AdyenCheckoutScreen adyenCheckoutScreen = AdyenCheckoutScreen.this;
                    adyenCheckoutScreen.f53575u = adyenCheckoutScreen.getPaymentMethodOptionName(obj.substring(0, 4));
                    AdyenCheckoutScreen adyenCheckoutScreen2 = AdyenCheckoutScreen.this;
                    adyenCheckoutScreen2.updateCardTypeIndicator(adyenCheckoutScreen2.f53575u);
                    int visibility = AdyenCheckoutScreen.this.cardTypeIV.getVisibility();
                    ImageView unused = AdyenCheckoutScreen.this.cardTypeIV;
                    if (visibility != 0) {
                        AdyenCheckoutScreen adyenCheckoutScreen3 = AdyenCheckoutScreen.this;
                        adyenCheckoutScreen3.f53575u = adyenCheckoutScreen3.getPaymentMethodOptionName(obj);
                        AdyenCheckoutScreen adyenCheckoutScreen4 = AdyenCheckoutScreen.this;
                        adyenCheckoutScreen4.updateCardTypeIndicator(adyenCheckoutScreen4.f53575u);
                        AdyenCheckoutScreen adyenCheckoutScreen5 = AdyenCheckoutScreen.this;
                        int[] a02 = adyenCheckoutScreen5.lengthController(adyenCheckoutScreen5.f53575u);
                        if (!TalabatUtils.isNullOrEmpty(obj) && a02[1] > 0) {
                            if (obj.length() != a02[1]) {
                                AdyenCheckoutScreen.this.cardErrorAvailable = true;
                                AdyenCheckoutScreen.this.disablePayButton();
                            } else {
                                AdyenCheckoutScreen.this.cardErrorAvailable = false;
                                AdyenCheckoutScreen.this.enablePayButton();
                            }
                        }
                    }
                } else {
                    AdyenCheckoutScreen.this.updateCardTypeIndicator((String) null);
                    AdyenCheckoutScreen adyenCheckoutScreen6 = AdyenCheckoutScreen.this;
                    int[] a03 = adyenCheckoutScreen6.lengthController(adyenCheckoutScreen6.f53575u);
                    if (!TalabatUtils.isNullOrEmpty(obj) && a03[1] > 0) {
                        if (obj.length() != a03[1]) {
                            AdyenCheckoutScreen.this.cardErrorAvailable = true;
                            AdyenCheckoutScreen.this.disablePayButton();
                        } else {
                            AdyenCheckoutScreen.this.cardErrorAvailable = false;
                            AdyenCheckoutScreen.this.enablePayButton();
                        }
                    }
                }
                if (AdyenCheckoutScreen.this.validateCardAutofoucs()) {
                    AdyenCheckoutScreen.this.expiryDateET.requestFocus();
                }
                if (!TalabatUtils.isNullOrEmpty(editable.toString()) && editable.toString().length() >= 4 && !TalabatUtils.isNullOrEmpty(AdyenCheckoutScreen.this.getPaymentMethodOptionName(editable.toString()))) {
                    if (length >= 7) {
                        try {
                            if (!AdyenCheckoutScreen.binNumber.equals(editable.toString().substring(0, 6)) || !AdyenCheckoutScreen.this.binAvailable || AdyenCheckoutScreen.this.iAdyenPresenter.getBinResponse() == null) {
                                if (!AdyenCheckoutScreen.binNumber.equals(editable.toString().substring(0, 6))) {
                                    AdyenCheckoutScreen.this.isBinRequestSent = false;
                                    if (!AdyenCheckoutScreen.this.isBinRequestSent) {
                                        AdyenCheckoutScreen.binNumber = editable.toString().substring(0, 6);
                                        Cart instance = Cart.getInstance();
                                        if (instance.hasVoucherApplied()) {
                                            str2 = instance.getVoucherCode();
                                            f12 = instance.getVoucherDiscount();
                                        } else {
                                            str2 = str4;
                                            f12 = 0.0f;
                                        }
                                        if (!TalabatUtils.isNullOrEmpty(AdyenCheckoutScreen.this.f53572r.address.mobileNumber)) {
                                            str3 = AdyenCheckoutScreen.this.f53572r.address.mobileNumber;
                                        } else {
                                            str3 = str4;
                                        }
                                        BinRequest binRequest = new BinRequest(instance.getSubtotalForVoucher(), instance.getRestaurant().getId(), instance.getDeliveryChargeForVoucher(), instance.isPromotionApplied(), instance.isFreeItemAdded(), instance.isCouponApplied(), str3, AdyenCheckoutScreen.binNumber, str2, f12, GlobalDataModel.SelectedAreaId, instance.getRestaurant().getBranchId());
                                        AdyenCheckoutScreen adyenCheckoutScreen7 = AdyenCheckoutScreen.this;
                                        adyenCheckoutScreen7.localBinRequest = binRequest;
                                        if (!adyenCheckoutScreen7.isGemActive() && !AdyenCheckoutScreen.this.isTalabatCreditForUae && !AdyenCheckoutScreen.this.isDarkStore()) {
                                            AdyenCheckoutScreen.this.iAdyenPresenter.checkForBinVoucher(binRequest);
                                            AdyenCheckoutScreen.this.isBinRequestSent = true;
                                        }
                                    }
                                }
                            } else if (AdyenCheckoutScreen.this.iAdyenPresenter.getBinResponse().binNum.equals(AdyenCheckoutScreen.binNumber)) {
                                AdyenCheckoutScreen.this.iAdyenPresenter.applyAvailableBinResponse();
                            }
                        } catch (Exception unused2) {
                            if (!AdyenCheckoutScreen.binNumber.equals(editable.toString().substring(0, 6))) {
                                AdyenCheckoutScreen.this.isBinRequestSent = false;
                                if (!AdyenCheckoutScreen.this.isBinRequestSent) {
                                    AdyenCheckoutScreen.binNumber = editable.toString();
                                    Cart instance2 = Cart.getInstance();
                                    if (instance2.hasVoucherApplied()) {
                                        str = instance2.getVoucherCode();
                                        f11 = instance2.getVoucherDiscount();
                                    } else {
                                        str = str4;
                                        f11 = 0.0f;
                                    }
                                    if (!TalabatUtils.isNullOrEmpty(AdyenCheckoutScreen.this.f53572r.address.mobileNumber)) {
                                        str4 = AdyenCheckoutScreen.this.f53572r.address.mobileNumber;
                                    }
                                    BinRequest binRequest2 = new BinRequest(instance2.getSubtotalForVoucher(), instance2.getRestaurant().getId(), instance2.getDeliveryChargeForVoucher(), instance2.isPromotionApplied(), instance2.isFreeItemAdded(), instance2.isCouponApplied(), str4, AdyenCheckoutScreen.binNumber, str, f11, GlobalDataModel.SelectedAreaId, instance2.getRestaurant().getBranchId());
                                    AdyenCheckoutScreen adyenCheckoutScreen8 = AdyenCheckoutScreen.this;
                                    adyenCheckoutScreen8.localBinRequest = binRequest2;
                                    if (!adyenCheckoutScreen8.isGemActive() && !AdyenCheckoutScreen.this.isTalabatCreditForUae && !AdyenCheckoutScreen.this.isDarkStore()) {
                                        AdyenCheckoutScreen.this.iAdyenPresenter.checkForBinVoucher(binRequest2);
                                        AdyenCheckoutScreen.this.isBinRequestSent = true;
                                    }
                                }
                            }
                        }
                    } else {
                        AdyenCheckoutScreen.this.removeBin();
                    }
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                String str;
                AdyenCheckoutScreen adyenCheckoutScreen = AdyenCheckoutScreen.this;
                adyenCheckoutScreen.removeErrorTheme(adyenCheckoutScreen.cardNumberErrorTV, AdyenCheckoutScreen.this.cardNumberIL);
                if (!TalabatUtils.isNullOrEmpty(charSequence.toString())) {
                    str = charSequence.toString();
                } else {
                    str = "";
                }
                AdyenCheckoutScreen.this.disablePayButton();
                AdyenCheckoutScreen adyenCheckoutScreen2 = AdyenCheckoutScreen.this;
                int[] a02 = adyenCheckoutScreen2.lengthController(adyenCheckoutScreen2.f53575u);
                if (!TalabatUtils.isNullOrEmpty(str) && a02[1] > 0) {
                    if (str.length() != a02[1]) {
                        AdyenCheckoutScreen.this.cardErrorAvailable = true;
                        AdyenCheckoutScreen.this.disablePayButton();
                        return;
                    }
                    AdyenCheckoutScreen.this.cardErrorAvailable = false;
                    AdyenCheckoutScreen.this.enablePayButton();
                }
            }
        });
        this.cvvET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                AdyenCheckoutScreen.this.validateCVV(z11);
            }
        });
        this.cvvET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 == 6) {
                    ((InputMethodManager) AdyenCheckoutScreen.this.getSystemService("input_method")).hideSoftInputFromWindow(AdyenCheckoutScreen.this.cvvET.getWindowToken(), 0);
                }
                return false;
            }
        });
        this.cvvET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                AdyenCheckoutScreen adyenCheckoutScreen = AdyenCheckoutScreen.this;
                adyenCheckoutScreen.removeErrorTheme(adyenCheckoutScreen.cvvErrorTV, AdyenCheckoutScreen.this.cvvIL);
                if (AdyenCheckoutScreen.this.validateCvvDateAutoFocus(true)) {
                    AdyenCheckoutScreen.this.holderNameET.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        this.expiryDateET.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z11) {
                boolean unused = AdyenCheckoutScreen.this.validateExpiryDate(z11);
            }
        });
        this.expiryDateET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (!TalabatUtils.isNullOrEmpty(editable.toString())) {
                    AdyenCheckoutScreen adyenCheckoutScreen = AdyenCheckoutScreen.this;
                    adyenCheckoutScreen.formatExpiryDate(adyenCheckoutScreen.expiryDateET, AdyenCheckoutScreen.this.lastInput, editable.toString());
                    AdyenCheckoutScreen adyenCheckoutScreen2 = AdyenCheckoutScreen.this;
                    adyenCheckoutScreen2.lastInput = adyenCheckoutScreen2.expiryDateET.getText().toString();
                }
                if (AdyenCheckoutScreen.this.validateExpiryDateAutoFocus(true)) {
                    AdyenCheckoutScreen.this.cvvET.requestFocus();
                }
            }

            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
                AdyenCheckoutScreen adyenCheckoutScreen = AdyenCheckoutScreen.this;
                adyenCheckoutScreen.removeErrorTheme(adyenCheckoutScreen.expDateErrorTV, AdyenCheckoutScreen.this.expiryDateIL);
            }
        });
    }

    private void showBinView() {
        this.binView.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public void updateCardTypeIndicator(String str) {
        if (str != null) {
            this.cardTypeIV.setImageDrawable(getCardTypeIcon(str, this));
            if (this.cardTypeIV.getVisibility() != 0) {
                lengthController(str);
                this.cardTypeIV.setVisibility(0);
                return;
            }
            return;
        }
        this.cardTypeIV.setVisibility(8);
        lengthController(this.f53575u);
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.Adyen.AdyenCheckoutScreen.updateTextColor():void");
    }

    /* access modifiers changed from: private */
    public void validateCVV(boolean z11) {
        int i11;
        String editTextValue = getEditTextValue(this.cvvET, true);
        String editTextValue2 = getEditTextValue(this.cardNumberET, true);
        if (editTextValue2.length() >= 4) {
            String paymentMethodOptionName = getPaymentMethodOptionName(editTextValue2);
            if (paymentMethodOptionName == null || !paymentMethodOptionName.equals("AMEX")) {
                i11 = 3;
            } else {
                i11 = 4;
            }
            if (!z11 && editTextValue.length() != i11 && editTextValue.length() != 0) {
                String string = getResources().getString(R.string.pf_cancel_cvv_length);
                if (i11 == 4) {
                    string = getResources().getString(R.string.pf_cancel_cvv_amex_length);
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
        boolean z11 = true;
        String editTextValue = getEditTextValue(this.cardNumberET, true);
        int[] lengthController = lengthController(this.f53575u);
        if (editTextValue.length() == lengthController[1] && editTextValue.contains("*")) {
            return false;
        }
        if (editTextValue.length() >= 4) {
            str = getPaymentMethodOptionName(editTextValue);
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
            if (editTextValue.length() != lengthController[1]) {
                z11 = false;
            }
            removeErrorTheme(this.cardNumberErrorTV, this.cardNumberIL);
            if (this.binAvailable && (editText2 = this.cardNumberET) != null && !TalabatUtils.isNullOrEmpty(editText2.getText().toString()) && this.cardNumberET.getText().toString().length() >= 7 && binNumber.equals(this.cardNumberET.getText().toString().substring(0, 6)) && this.iAdyenPresenter.getBinResponse() != null && this.iAdyenPresenter.getBinResponse().binNum.equals(binNumber)) {
                showBinView();
            }
            return z11;
        } else if (editTextValue.length() == lengthController[1]) {
            removeBin();
            this.cardErrorAvailable = true;
            addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getResources().getString(R.string.pf_errors_card_number_invalid));
            return false;
        } else {
            this.cardErrorAvailable = false;
            enablePayButton();
            if (!this.binAvailable || (editText = this.cardNumberET) == null || TalabatUtils.isNullOrEmpty(editText.getText().toString()) || this.cardNumberET.getText().toString().length() < 7 || !binNumber.equals(this.cardNumberET.getText().toString().substring(0, 6)) || this.iAdyenPresenter.getBinResponse() == null || !this.iAdyenPresenter.getBinResponse().binNum.equals(binNumber)) {
                return false;
            }
            showBinView();
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void validateCardNumber(boolean z11) {
        EditText editText;
        String editTextValue = getEditTextValue(this.cardNumberET, true);
        int[] lengthController = lengthController(this.f53575u);
        if (editTextValue.length() == lengthController[1] && editTextValue.contains("*")) {
            return;
        }
        if (!z11 && editTextValue.length() != lengthController[1] && editTextValue.length() != 0) {
            String string = getResources().getString(R.string.pf_errors_card_number_length);
            if ("AMEX".equals(this.f53575u)) {
                string = getResources().getString(R.string.pf_errors_card_number_amex_length);
            }
            removeBin();
            this.cardErrorAvailable = true;
            addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, string);
        } else if (!z11 && editTextValue.length() == lengthController[1]) {
            String paymentMethodOptionName = getPaymentMethodOptionName(editTextValue.substring(0, 4));
            if (paymentMethodOptionName == null || paymentMethodOptionName.trim().isEmpty()) {
                removeBin();
                this.cardErrorAvailable = true;
                addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getResources().getString(R.string.pf_errors_card_number_mismatch_ck));
            } else if (!isLuhnValid(editTextValue)) {
                removeBin();
                this.cardErrorAvailable = true;
                addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, getResources().getString(R.string.pf_errors_card_number_invalid));
            }
        } else if (this.binAvailable && (editText = this.cardNumberET) != null && !TalabatUtils.isNullOrEmpty(editText.getText().toString()) && this.cardNumberET.getText().toString().length() >= 7 && binNumber.equals(this.cardNumberET.getText().toString().substring(0, 6)) && this.iAdyenPresenter.getBinResponse() != null && this.iAdyenPresenter.getBinResponse().binNum.equals(binNumber)) {
            showBinView();
        }
    }

    /* access modifiers changed from: private */
    public boolean validateCvvDateAutoFocus(boolean z11) {
        boolean z12;
        String editTextValue = getEditTextValue(this.cvvET, true);
        String paymentMethodOptionName = getPaymentMethodOptionName(getEditTextValue(this.cardNumberET, true));
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
        int[] lengthController = lengthController(this.f53575u);
        if (str3.isEmpty()) {
            this.cardErrorAvailable = true;
            addErrorTheme(this.cardNumberErrorTV, this.cardNumberIL, string);
            this.cardNumberET.setFocusable(true);
        } else if (str3.length() < lengthController[1]) {
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
        if (str3.length() == lengthController[1] && str2.length() == lengthController[0]) {
            return true;
        }
        validateCVV(false);
        this.cvvET.setFocusable(true);
        return false;
    }

    public void addErrorTheme(TextView textView, TextInputLayout textInputLayout, String str) {
        disablePayButton();
        textView.setText(HtmlCompat.fromHtml(str, 63));
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
            getTokenForAdyen();
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
                AdyenCheckoutScreen.this.contentView.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue());
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
            int[] lengthController = lengthController(this.f53575u);
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
        if (!z12 || !z13 || !z11) {
            disablePayButton();
            return;
        }
        this.payBtn.setEnabled(true);
        this.payBtn.setAlpha(1.0f);
        this.cancelBtn.setEnabled(true);
        this.cancelBtn.setAlpha(1.0f);
        this.payByCreditCardView.setVisibility(0);
        this.remainingToPayView.setVisibility(8);
    }

    public void fillViews() {
        String obj = this.expiryDateET.getText().toString();
        this.amountTV.setText(this.f53569o);
        if (this.isQuickOrder) {
            this.rememberMeRL.setVisibility(8);
            this.rememberMeTB.setChecked(false);
        } else {
            this.rememberMeRL.setVisibility(0);
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

    public Drawable getCardTypeIcon(String str, Context context) {
        if (str.equals("MASTERCARD")) {
            return getResources().getDrawable(R.drawable.icon_tokenization_mastercard);
        }
        if (str.equals("VISA")) {
            return getResources().getDrawable(R.drawable.icon_tokenization_visa);
        }
        if (str.equals("AMEX")) {
            return getResources().getDrawable(R.drawable.icon_amex_checkout);
        }
        if (str.equals("DISCOVER")) {
            return getResources().getDrawable(R.drawable.bt_ic_discover);
        }
        if (str.equals("DINERS_CLUB")) {
            return getResources().getDrawable(R.drawable.bt_ic_dinersclub);
        }
        if (str.equals(GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_JCB)) {
            return getResources().getDrawable(R.drawable.bt_ic_jcb);
        }
        if (str.equals(GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_MAESTRO)) {
            return getResources().getDrawable(R.drawable.bt_ic_maestro);
        }
        if (str.equals("UNIONPAY")) {
            return getResources().getDrawable(R.drawable.bt_ic_unionpay);
        }
        if (str.equals("MEEZA")) {
            return getResources().getDrawable(R.drawable.ic_meeza_card_icon);
        }
        return null;
    }

    public String getEditTextValue(EditText editText, boolean z11) {
        String str;
        if (z11) {
            str = "" + editText.getText().toString().trim();
        } else {
            str = "" + editText.getText().toString();
        }
        return this.B.map(str);
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

    public String getPaymentMethodOptionName(String str) {
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
            Pattern compile10 = Pattern.compile("^5078\\d*");
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
                if (this.f53580z.walletConfig().isAmexAvailable()) {
                    return "AMEX";
                }
                return null;
            } else if (!compile5.matcher(str).find() && !compile6.matcher(str).find() && !compile7.matcher(str).find() && !compile8.matcher(str).find() && !compile9.matcher(str).find() && compile10.matcher(str).find()) {
                return "MEEZA";
            } else {
                return null;
            }
        } catch (Exception unused) {
        }
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.CHECKOUT_DOT_COM_SCREEN_CREDIT;
    }

    public void handleWithCreditCard(float f11, String str, String str2) {
    }

    public /* synthetic */ boolean isGemActive() {
        return b.e(this);
    }

    public /* synthetic */ boolean isGemOffersActive() {
        return b.f(this);
    }

    public JSONObject loadJsonConfiguration(Context context) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.config), "UTF-8"));
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return new JSONObject(sb2.toString());
                }
                sb2.append(readLine);
            }
        } catch (IOException e11) {
            Log.e("ADYENJSON", e11.getMessage(), e11);
            return null;
        } catch (JSONException e12) {
            Log.e("ADYENJSON", e12.getMessage(), e12);
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void m0() {
        if (SystemClock.elapsedRealtime() - this.mLastClickTime >= PaymentWidgetBottomSheetFragmentKt.DURATION_DELAY_DURING_FAILURE) {
            this.mLastClickTime = SystemClock.elapsedRealtime();
            validateFieldsAndContinue();
        }
    }

    public void n0() {
        new DarkstoresSharedPreferencesHelper(this).resetDsCart();
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
        Bundle bundleWithCommonValues = getBundleWithCommonValues(this.transactionId, this.encryptedOrderId, Boolean.TRUE, Boolean.valueOf(this.isOrderSuccess), this.customerName);
        bundleWithCommonValues.putBoolean("isFromCheckoutDotCom", true);
        bundleWithCommonValues.putBoolean("isFromAptimize", this.isFromAptimize);
        bundleWithCommonValues.putString("paymentMethod", this.paymnentMethod);
        OrderTrackingNavigator.navigateToOrderTracking((Context) this, bundleWithCommonValues, true);
        n0();
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
                    this.f53574t = savedQuickOrderAddressData;
                    Gson gson = UniversalGson.INSTANCE.gson;
                    if (!(gson instanceof Gson)) {
                        str = gson.toJson((Object) savedQuickOrderAddressData);
                    } else {
                        str = GsonInstrumentation.toJson(gson, (Object) savedQuickOrderAddressData);
                    }
                    this.f53573s = str;
                    this.f53572r.setAddress(this.f53574t.address);
                } else {
                    this.f53572r.setAddress(Customer.getInstance().getSelectedCustomerAddress());
                }
                GlobalDataModel.BIN.numberUpdated = true;
                GlobalDataModel.BIN.updatedNumber = intent.getStringExtra("updatedMobileNo");
            }
        }
    }

    public /* synthetic */ void onAddMoreItemClicked() {
        a.a(this);
    }

    public void onAdyenFailed(String str) {
        binNumber = "";
        Intent intent = new Intent(this, PaymentErrorScreen.class);
        intent.putExtra("url", "");
        intent.putExtra("isFromCheckoutDotCom", true);
        intent.putExtra("isGateWayError", false);
        intent.putExtra("paymentMethod", this.paymnentMethod);
        intent.putExtra("encryptedTransactionIdError", this.transactionId);
        stopLodingPopup();
        startActivity(intent);
        finish();
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
    }

    public void onBackToCheckoutPage(Dialog dialog) {
        dialog.dismiss();
        finish();
    }

    public void onBackToRestaurantMenuPage(Dialog dialog) {
        finish();
        dialog.dismiss();
        Intent intent = new Intent(this, RestaurantMenuScreenR.class);
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
                AdyenCheckoutScreen.this.stopLodingPopup();
                AdyenCheckoutScreen.this.removeBin();
                AdyenCheckoutScreen.this.enablePayButton();
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
                    GlobalDataModel.BIN.stoppedBinNumber = AdyenCheckoutScreen.binNumber;
                }
            }
        });
        builder.show();
    }

    public void onBinNotAvailable(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
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

    public void onBinVoucherAvailable(BinResponse binResponse) {
        this.binAvailable = true;
        if (!TalabatUtils.isNullOrEmpty(binResponse.binNum) && binNumber.equals(binResponse.binNum)) {
            this.binMessage.setText(binResponse.message);
            applyBin(binResponse.binDiscount, binNumber, binResponse.binMinimumOrderAmount);
        }
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
        DaggerCheckoutAdyenScreenComponent.factory().create((ConfigurationLocalCoreLibApi) apiContainer.getFeature(ConfigurationLocalCoreLibApi.class), (ConfigurationRemoteCoreLibApi) apiContainer.getFeature(ConfigurationRemoteCoreLibApi.class)).inject(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT > 23) {
            TalabatUtils.changeLocale(this, GlobalDataModel.SelectedLanguage);
        }
        getWindow().setFlags(8192, 8192);
        if (TalabatUtils.isArabic()) {
            setContentView((int) R.layout.activity_get_card_token_ar);
        } else {
            setContentView((int) R.layout.activity_get_card_token_en);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        this.screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.isQuickOrder = getIntent().getBooleanExtra("isQuick", false);
        this.f53569o = getIntent().getStringExtra("transactionAmount");
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
        this.f53573s = getIntent().getStringExtra("quickOrderString");
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
                this.f53572r = (PlaceOrderRequestModel) obj2;
            } catch (Exception unused) {
                this.f53572r = null;
            }
        }
        String str2 = this.f53573s;
        if (str2 != null) {
            Class cls2 = QuickOrderInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(str2, cls2);
            } else {
                obj = GsonInstrumentation.fromJson(gson, str2, cls2);
            }
            this.f53574t = (QuickOrderInfo) obj;
        }
        this.userNameFromAddress = null;
        if (Customer.getInstance().isLoggedIn(getContext())) {
            CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
            this.userNameFromAddress = customerInfo.firstName + " " + customerInfo.lastName;
        } else if (this.f53574t != null) {
            this.userNameFromAddress = this.f53574t.firstName + " " + this.f53574t.lastName;
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
        this.paymentTerms = (TextView) findViewById(R.id.payment_terms);
        this.tvVoucherDiscount = (TextView) findViewById(R.id.voucher_discount);
        this.rememberMeRL.setVisibility(0);
        this.securityInfoTxt = findViewById(R.id.more_security_container);
        this.securityInfoContentView = findViewById(R.id.security_info_container);
        this.securityInfoBackBtn = findViewById(R.id.security_back);
        this.sub_content_view = findViewById(R.id.sub_content_view);
        this.termsLayout = findViewById(R.id.terms_layout);
        this.BtnLayout = findViewById(R.id.button_layout);
        new GemDiscountViewBinder((GemCheckoutDiscountView) findViewById(R.id.gemCheckoutDiscountView), findViewById(R.id.gem_discount_view_layout)).accept((AppCompatActivity) this);
        String replace = getString(R.string.by_placing_the_order_agree_to_terms_replace).replace("#", getResources().getString(R.string.credit_card));
        String string = getString(R.string.terms_and_conditions);
        final String checkoutPaymentTermsUrl = this.A.config().checkoutPaymentTermsUrl();
        this.title = getString(R.string.credit_card_payment);
        this.termsTitle = getString(R.string.credit_terms);
        try {
            checkoutPaymentTermsUrl = checkoutPaymentTermsUrl.replace(BNPLManagerViewModel.BNPL_PAYMENT_METHOD, "0").replace(BNPLManagerViewModel.BNPL_ADDITIONAL_PAYMENT_METHOD, ExifInterface.GPS_MEASUREMENT_2D);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        AnonymousClass1 r62 = new ClickableSpan() {
            public void onClick(View view) {
                Intent intent = new Intent(AdyenCheckoutScreen.this, TWebViewScreen.class);
                intent.putExtra("url", checkoutPaymentTermsUrl);
                intent.putExtra(LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE, AdyenCheckoutScreen.this.termsTitle);
                AdyenCheckoutScreen.this.startActivity(intent);
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(AdyenCheckoutScreen.this.getResources().getColor(R.color.colorSecondary));
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
        lengthController(this.f53575u);
        fillViews();
        AdyenPresenter adyenPresenter = new AdyenPresenter(this.f53576v, this.f53577w, this.f53578x, this.f53579y, this.f53580z, this, this);
        this.iAdyenPresenter = adyenPresenter;
        adyenPresenter.setUpViews();
        this.payBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdyenCheckoutScreen.this.m0();
            }
        });
        new GemPaymentAdyenBinder().accept(this);
        this.cancelBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - AdyenCheckoutScreen.this.mLastClickTime >= PaymentWidgetBottomSheetFragmentKt.DURATION_DELAY_DURING_FAILURE) {
                    AdyenCheckoutScreen.this.mLastClickTime = SystemClock.elapsedRealtime();
                    AlertDialog.Builder builder = new AlertDialog.Builder(AdyenCheckoutScreen.this, R.style.AlertDialogTheme);
                    builder.create().requestWindowFeature(1);
                    builder.setTitle((CharSequence) null);
                    builder.setMessage((CharSequence) AdyenCheckoutScreen.this.getResources().getString(R.string.pf_cancel_payment_msg));
                    builder.setPositiveButton((CharSequence) AdyenCheckoutScreen.this.getResources().getString(R.string.yes), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(final DialogInterface dialogInterface, int i11) {
                            AdyenCheckoutScreen adyenCheckoutScreen = AdyenCheckoutScreen.this;
                            adyenCheckoutScreen.animateSlideTo(0, adyenCheckoutScreen.contentView.getHeight(), new SlideAnimationListener() {
                                public void onAnimationFinish() {
                                    AdyenCheckoutScreen.binNumber = "";
                                    AdyenCheckoutScreen.this.binAvailable = false;
                                    AdyenCheckoutScreen.this.binApplied = false;
                                    AdyenCheckoutScreen.this.localBinRequest = null;
                                    Cart.getInstance().removeBinDiscountIfApplied();
                                    Cart.getInstance().recalcualteTotal();
                                    AdyenCheckoutScreen.this.finish();
                                }

                                public void onAnimationStart() {
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                    });
                    builder.setNegativeButton((CharSequence) AdyenCheckoutScreen.this.getResources().getString(R.string.f54880no), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i11) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder.setCancelable(false);
                    builder.show();
                }
            }
        });
        getWindow().setLayout(-1, -2);
        this.cvvET.setImeOptions(6);
        this.cvvET.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i11, KeyEvent keyEvent) {
                if (i11 != 6) {
                    return false;
                }
                ((InputMethodManager) AdyenCheckoutScreen.this.getSystemService("input_method")).hideSoftInputFromWindow(AdyenCheckoutScreen.this.cvvET.getWindowToken(), 1);
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
        this.securityInfoTxt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdyenCheckoutScreen.this.securityInformationView();
            }
        });
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_in_up);
        loadAnimation.setDuration(500);
        loadAnimation.setFillAfter(true);
        this.contentView.startAnimation(loadAnimation);
        GEMEngine.withGemEngine(new ve.a(this));
        TalabatBugReportManager.INSTANCE.blockViewsRecording(this.cardNumberET, this.expiryDateET, this.cvvET, this.holderNameET);
    }

    public void onDarkstoresDjiniError(String str) {
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                dialogInterface.dismiss();
                AdyenCheckoutScreen.this.setResult(-1);
                AdyenCheckoutScreen.this.finish();
            }
        });
        builder.show();
    }

    public void onDestroy() {
        TalabatBugReportManager.INSTANCE.removeViewBlocking(this.cardNumberET, this.holderNameET, this.cvvET, this.expiryDateET);
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
                AppTracker.onDuplicateOrderPopupClosed(AdyenCheckoutScreen.this);
            }
        });
        ((ImageView) this.duplicateOrderDialog.findViewById(R.id.close_popup_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AdyenCheckoutScreen.this.duplicateOrderDialog.dismiss();
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
                AdyenCheckoutScreen.this.onPopupRadioClicked(radioButton);
            }
        });
        radioButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setEnabled(true);
                button.setAlpha(1.0f);
                AdyenCheckoutScreen.this.onPopupRadioClicked(radioButton2);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                button.setEnabled(true);
                button.setAlpha(1.0f);
                AdyenCheckoutScreen.this.onPopupRadioClicked(radioButton3);
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
                    AdyenCheckoutScreen.this.duplicateOrderDialog.dismiss();
                } else if (radioButton2.isChecked()) {
                    AdyenCheckoutScreen.this.startLodingPopup();
                    AppTracker.onDuplicateOrderPopupConfirmClicked(AdyenCheckoutScreen.this, "view_order");
                    AdyenCheckoutScreen.this.iAdyenPresenter.showOrderDetails(str4);
                } else if (radioButton3.isChecked()) {
                    AdyenCheckoutScreen.this.duplicateOrderDialog.dismiss();
                    AppTracker.onDuplicateOrderPopupConfirmClicked(AdyenCheckoutScreen.this, "continue_order");
                    PlaceOrderRequestModel placeOrderRequestModel = AdyenCheckoutScreen.this.f53572r;
                    if (placeOrderRequestModel != null) {
                        placeOrderRequestModel.setAllowDuplicateOrder(true);
                    }
                    GlobalConstants.isDuplicateOrder = true;
                    AdyenCheckoutScreen.this.placeOrder();
                }
            }
        });
        ((Button) this.duplicateOrderDialog.findViewById(R.id.home_btn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AdyenCheckoutScreen.this, HomeScreenActivity.class);
                intent.addFlags(67108864);
                AppTracker.onDuplicateOrderPopupConfirmClicked(AdyenCheckoutScreen.this, "go_to_home");
                AdyenCheckoutScreen.this.startActivity(intent);
                if (Cart.getInstance() != null) {
                    Cart.getInstance().clearCart(AdyenCheckoutScreen.this);
                }
                AdyenCheckoutScreen.this.duplicateOrderDialog.dismiss();
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
        PlaceOrderRequestModel placeOrderRequestModel = this.f53572r;
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
                AdyenCheckoutScreen.this.payLoadingPB.setVisibility(0);
                AdyenCheckoutScreen.this.iAdyenPresenter.removeInvalidCoupon(z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((CharSequence) getString(R.string.change_time).toString(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    AdyenCheckoutScreen.this.stopLodingPopup();
                    dialogInterface.dismiss();
                }
            });
        }
        builder.show();
        stopLodingPopup();
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
                    AppTracker.onKNETFailureLghtboxClosed(AdyenCheckoutScreen.this);
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
                AdyenCheckoutScreen.this.payLoadingPB.setVisibility(0);
                AdyenCheckoutScreen.this.iAdyenPresenter.removeInvalidItems(z11, invalidItemArr);
            }
        });
        if (z11) {
            builder.setNegativeButton((CharSequence) getString(R.string.cancel).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    AdyenCheckoutScreen.this.stopLodingPopup();
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
                AdyenCheckoutScreen.this.payLoadingPB.setVisibility(0);
                AdyenCheckoutScreen.this.iAdyenPresenter.removeInvalidPromotion(z11);
            }
        });
        if (z11) {
            builder.setNegativeButton((CharSequence) getString(R.string.change_time).toUpperCase(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    AdyenCheckoutScreen.this.stopLodingPopup();
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
                AdyenCheckoutScreen.this.payLoadingPB.setVisibility(0);
                AdyenCheckoutScreen.this.iAdyenPresenter.removeInvalidVoucher(z11);
                dialogInterface.dismiss();
            }
        });
        if (z11) {
            builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i11) {
                    AdyenCheckoutScreen.this.stopLodingPopup();
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

    public void onRedirectToPaymentWebViewWithAdyen(AdyenPurchaseResponse adyenPurchaseResponse) {
        String str = "";
        binNumber = str;
        Intent intent = new Intent(this, PaymentWebViewScreen.class);
        intent.putExtra("title", getString(R.string.credit_card_payment));
        intent.putExtra("url", adyenPurchaseResponse.redirectUrl);
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

    public void onRequestError() {
        stopLodingPopup();
        Toast.makeText(getContext(), getResources().getString(R.string.server_error_msg), 0).show();
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.contentView.getLayoutParams();
        layoutParams.addRule(12);
        this.contentView.setLayoutParams(layoutParams);
        if (!this.isPlaceOrderClicked) {
            enablePayButton();
        }
        try {
            View view = this.sub_content_view;
            if (view != null) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        AdyenCheckoutScreen.this.sub_content_view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        AdyenCheckoutScreen adyenCheckoutScreen = AdyenCheckoutScreen.this;
                        adyenCheckoutScreen.height = adyenCheckoutScreen.sub_content_view.getMeasuredHeight() + AdyenCheckoutScreen.this.termsLayout.getMeasuredHeight() + AdyenCheckoutScreen.this.BtnLayout.getMeasuredHeight();
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public /* synthetic */ void onSendCVVToProxyServer(RecurringPurchaseRequest recurringPurchaseRequest, int i11) {
        w10.a.c(this, recurringPurchaseRequest, i11);
    }

    public void onServerError() {
        stopLodingPopup();
        Toast.makeText(this, getResources().getString(R.string.server_error_msg), 1).show();
    }

    public void onSuccessfulAdyen() {
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
        n0();
        finish();
    }

    public void onUserTypeErrorForDiscount(String str) {
        Cart.getInstance().removeTgoFreeDeliveryTiers();
        stopLodingPopup();
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage((CharSequence) str);
        builder.setPositiveButton((CharSequence) getString(R.string.f54881ok), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                AdyenCheckoutScreen.this.setTaxAndDelivery();
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
            this.f53572r.setCart(Cart.getInstance().getTransactionCart());
        }
        this.iAdyenPresenter.placeOrder(this.f53572r);
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
    public void setBinApplied(boolean z11) {
        this.binApplied = z11;
    }

    @VisibleForTesting
    public void setCardErrorAvailableForAdyen(boolean z11) {
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
                if (AdyenCheckoutScreen.this.iAdyenPresenter != null) {
                    AdyenCheckoutScreen.this.payLoadingPB.setVisibility(0);
                    AdyenCheckoutScreen.this.iAdyenPresenter.tryMoreRestaurantsClicked();
                }
            }
        });
        builder.setNegativeButton((int) R.string.cancel, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i11) {
                AdyenCheckoutScreen.this.stopLodingPopup();
            }
        });
        builder.show();
        enablePayButton();
    }

    public /* synthetic */ void showGemDialog() {
        v00.a.a(this);
    }

    public /* synthetic */ void showInAppReminder(int i11) {
        v00.a.b(this, i11);
    }

    public void showTimeOutDialog() {
        BinRequest binRequest;
        if (GEMEngine.getInstance().getCurrentGemIndex() > 0) {
            showGemTimeOutDialog(this.mGemDialogSwitcher, this.f53571q, this, this);
        }
        try {
            if (!TalabatUtils.isNullOrEmpty(this.cardNumberET.getText().toString().trim()) && this.cardNumberET.getText().toString().trim().length() >= 7 && (binRequest = this.localBinRequest) != null && binRequest.getBinNum().equals(this.cardNumberET.getText().toString().trim().substring(0, 6))) {
                this.iAdyenPresenter.checkForBinVoucher(this.localBinRequest);
                this.isBinRequestSent = true;
            }
        } catch (Exception unused) {
        }
    }

    public void showTimerView(boolean z11, String str) {
    }

    public void slideOut() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, (float) this.height, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                AdyenCheckoutScreen.this.contentView.setVisibility(0);
                AdyenCheckoutScreen.this.contentView.clearAnimation();
                AdyenCheckoutScreen.this.securityInfoContentView.clearAnimation();
                AdyenCheckoutScreen.this.contentView.setFocusableInTouchMode(true);
                AdyenCheckoutScreen.this.securityInfoContentView.setVisibility(8);
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
        layoutParams.height = this.height;
        this.securityInfoContentView.setLayoutParams(layoutParams);
        this.securityInfoContentView.setVisibility(0);
        this.securityInfoContentView.requestLayout();
        TranslateAnimation translateAnimation = new TranslateAnimation((float) this.securityInfoContentView.getWidth(), 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(300);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
                AdyenCheckoutScreen.this.contentView.setFocusableInTouchMode(false);
                AdyenCheckoutScreen.this.contentView.setVisibility(0);
                AdyenCheckoutScreen.this.contentView.clearAnimation();
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                AdyenCheckoutScreen.this.contentView.setVisibility(0);
                AdyenCheckoutScreen.this.contentView.clearAnimation();
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

    public void stopProgressBar() {
        stopLodingPopup();
    }

    public void validateFieldsAndContinue() {
        this.f53564j = this.holderNameET.getText().toString().trim();
        this.f53563i = this.cardNumberET.getText().toString().trim();
        this.f53568n = this.rememberMeTB.isChecked();
        this.f53567m = this.cvvET.getText().toString().trim();
        if (validateForm(this.expiryDateET.getText().toString(), this.f53567m, this.f53563i) && this.expiryDateIL.getError() == null && this.cardNumberIL.getError() == null && this.cvvIL.getError() == null && this.expiryDateET.getText().toString().length() == 5) {
            this.f53565k = this.expiryDateET.getText().toString().trim().substring(0, 2);
            this.f53566l = this.expiryDateET.getText().toString().trim().substring(3, 5);
            applyCardForValidate(TalabatUtils.getSixBinNumber(this.f53563i), TalabatUtils.getLastDigitNumberValidate(this.f53563i));
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
            intent.putExtra("value", this.f53573s);
        }
        intent.putExtra("smsToken", str3);
        intent.putExtra("encryptedNumber", str4);
        startActivityForResult(intent, 301);
    }

    public /* synthetic */ GemAnalyticsAccessor withGemAnalytics() {
        return b.i(this);
    }
}
