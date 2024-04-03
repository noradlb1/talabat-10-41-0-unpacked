package library.talabat.mvp.placeorder;

import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import com.android.volley.VolleyError;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.domain.address.Address;
import com.talabat.domain.address.AddressesKt;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.notifications.brazemigrator.BrazeUserMigratorConfig;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.wallet.ui.tracking.event.WalletTopUpCreditCardSelectionEventKt;
import datamodels.Campaign;
import datamodels.InvalidItem;
import java.util.HashSet;
import java.util.Set;
import library.talabat.mvp.checkout.checkoutrefactor.IPayProxyManagerPresenter;
import library.talabat.mvp.checkout.checkoutrefactor.PayProxyManagerListener;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import tracking.AppTracker;
import tracking.Purchase;

public class PlaceOrderPresenter implements IPlaceOrderPresenter, PlaceOrderListener, PayProxyManagerListener {
    private int additionalPaymentMethod;
    public Address address;
    public float availableTalabatCredit = 0.0f;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private Set<Integer> creditCardMixedPaymentCountries;
    private String cvv;
    private String defaultPayementMethod;
    public float discountAmount;
    public boolean fromVisaCheckout;
    private IPlaceOrderInteractor iPlaceOrderInteractor;
    public InvalidItem[] invalidItems;
    private boolean isPostDatedOrder;
    public boolean isQuickOrder;
    private final LocationConfigurationRepository locationConfigurationRepository;
    public float payBytalabatCredit;
    private IPayProxyManagerPresenter payProxyManagerPresenter;
    private PlaceOrderRequestModel placeOrderRequestModel;
    private PlaceOrderView placeOrderView;
    private PlaceOrderResponse response;
    private final String restaurantStatus;
    public int selectedPayementMethod = -1;
    private int selectedPayementMethodForGA;
    private ISubscriptionsTracker subscriptionsTracker;
    public String voucherCode;

    public PlaceOrderPresenter(PlaceOrderView placeOrderView2, IPlaceOrderInteractor iPlaceOrderInteractor2, IPayProxyManagerPresenter iPayProxyManagerPresenter, ISubscriptionsTracker iSubscriptionsTracker, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository2) {
        int i11 = 0;
        this.fromVisaCheckout = false;
        this.isPostDatedOrder = false;
        this.cvv = "";
        this.defaultPayementMethod = "";
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
        this.subscriptionsTracker = iSubscriptionsTracker;
        this.placeOrderView = placeOrderView2;
        this.iPlaceOrderInteractor = iPlaceOrderInteractor2;
        iPlaceOrderInteractor2.register(this);
        i11 = Cart.getInstance().getRestaurant() != null ? Cart.getInstance().getRestaurant().statusType : i11;
        if (i11 == 0) {
            this.restaurantStatus = "Open";
        } else if (i11 == 5) {
            this.restaurantStatus = "Preorder";
        } else if (i11 == 1) {
            this.restaurantStatus = "Closed";
        } else {
            this.restaurantStatus = "Busy";
        }
        this.payProxyManagerPresenter = iPayProxyManagerPresenter;
        this.creditCardMixedPaymentCountries = new HashSet();
        populateCountries();
    }

    private boolean getuserHaveSelectedSavedCard() {
        if (isTokenisationAvailable()) {
            return Customer.getInstance().isCreditCardsAvailable();
        }
        return false;
    }

    private void populateCountries() {
        this.creditCardMixedPaymentCountries.add(Integer.valueOf(Country.UAE.getCountryId()));
        this.creditCardMixedPaymentCountries.add(Integer.valueOf(Country.KSA.getCountryId()));
        this.creditCardMixedPaymentCountries.add(Integer.valueOf(Country.OMAN.getCountryId()));
        this.creditCardMixedPaymentCountries.add(Integer.valueOf(Country.JORDAN.getCountryId()));
        this.creditCardMixedPaymentCountries.add(Integer.valueOf(Country.EGYPT.getCountryId()));
        this.creditCardMixedPaymentCountries.add(Integer.valueOf(Country.QATAR.getCountryId()));
    }

    private void trackProVendorPurchase() {
        try {
            Cart instance = Cart.getInstance();
            boolean z11 = instance.getRestaurant().isProRestaurant;
            float cartTotalPrice = instance.getCartTotalPrice();
            String str = instance.getRestaurant().f13873name;
            String voucherCode2 = instance.getVoucherCode();
            float allDiscounts = instance.getAllDiscounts();
            boolean booleanValue = Customer.getInstance().isTPro().booleanValue();
            ISubscriptionsTracker iSubscriptionsTracker = this.subscriptionsTracker;
            if (iSubscriptionsTracker != null && z11) {
                iSubscriptionsTracker.proVendorOrder(cartTotalPrice, str, voucherCode2, allDiscounts, booleanValue);
            }
        } catch (Exception unused) {
        }
    }

    public void continueWithAdyenPaymentAfterCVVSentToProxy(RecurringPurchaseRequest recurringPurchaseRequest) {
        this.iPlaceOrderInteractor.continueWithAdyenSavedToken(recurringPurchaseRequest);
        this.cvv = "";
        this.placeOrderView.clearCvv();
    }

    public void continueWithCheckoutPaymentAfterCVVSentToProxy(RecurringPurchaseRequest recurringPurchaseRequest) {
        this.iPlaceOrderInteractor.continueWithCheckoutDotComSavedToken(recurringPurchaseRequest);
        this.cvv = "";
        this.placeOrderView.clearCvv();
    }

    @VisibleForTesting
    public int getAdditionalPaymentMethod() {
        return this.additionalPaymentMethod;
    }

    public String getCVV() {
        return this.cvv;
    }

    @VisibleForTesting
    public Set<Integer> getCreditCardMixedPaymentCountries() {
        return this.creditCardMixedPaymentCountries;
    }

    public RecurringPurchaseRequest getPaymentRequestModel(String str, String str2, String str3, String str4) {
        RecurringPurchaseRequest recurringPurchaseRequest = new RecurringPurchaseRequest();
        recurringPurchaseRequest.language = str3;
        recurringPurchaseRequest.token = str2;
        recurringPurchaseRequest.transactionId = str;
        recurringPurchaseRequest.cvv = str4;
        return recurringPurchaseRequest;
    }

    public int getTokenProvider() {
        return TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository).tokenisationProvider;
    }

    public String getUserId(Context context) {
        return context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getString(BrazeUserMigratorConfig.APP_BOY_USER_ID_KEY, "");
    }

    public boolean isTokenisationAvailable() {
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId() || GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId() || GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId() || GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId() || GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId() || GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId()) {
            return TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigurationRepository).isTokenisationEnabledCountry;
        }
        return false;
    }

    public void onBNPLOrderError() {
        this.placeOrderView.onBNPLOrderError();
    }

    public void onCheckoutDotComRecurringFailed(String str) {
        this.placeOrderView.onCheckoutDotComRecurringFailed(str);
    }

    public void onContinueWithAdyenPayment(@NotNull RecurringPurchaseRequest recurringPurchaseRequest) {
        continueWithAdyenPaymentAfterCVVSentToProxy(recurringPurchaseRequest);
    }

    public void onContinueWithCheckoutDotCom(@NotNull RecurringPurchaseRequest recurringPurchaseRequest) {
        continueWithCheckoutPaymentAfterCVVSentToProxy(recurringPurchaseRequest);
    }

    public void onDataError() {
        this.placeOrderView.onDataError();
    }

    public void onDestroy() {
        this.placeOrderView = null;
        IPlaceOrderInteractor iPlaceOrderInteractor2 = this.iPlaceOrderInteractor;
        if (iPlaceOrderInteractor2 != null) {
            iPlaceOrderInteractor2.unregister();
        }
        this.iPlaceOrderInteractor = null;
    }

    public void onDuplicateOrder(String str, int i11, String str2, String str3, String str4, int i12, String str5) {
        AppTracker.onTransactionFailed(this.placeOrderView.getContext(), this.selectedPayementMethodForGA, str, this.restaurantStatus, str3, Cart.getInstance().getRestaurant(), GlobalDataModel.CONTACTLESS.contactlessEnabled, this.defaultPayementMethod, str2, i11, Cart.getInstance().getRiderTip());
        String str6 = str;
        this.placeOrderView.onDuplicateOrder(str, str4, i12, str5);
    }

    public void onNetworkError() {
        this.placeOrderView.onNetworkError();
    }

    public void onOrderError(int i11, String str, String str2, String str3, InvalidItem[] invalidItemArr) {
        int i12 = i11;
        String str4 = str;
        InvalidItem[] invalidItemArr2 = invalidItemArr;
        this.placeOrderView.clearCvv();
        AppTracker.onTransactionFailed(this.placeOrderView.getContext(), this.selectedPayementMethodForGA, str, this.restaurantStatus, str3, Cart.getInstance().getRestaurant(), GlobalDataModel.CONTACTLESS.contactlessEnabled, this.defaultPayementMethod, str2, i11, Cart.getInstance().getRiderTip());
        this.placeOrderView.stopNonCancelableLoading();
        if (i12 == 60) {
            this.placeOrderView.onOrderCouponNotAvailable(str4, this.isPostDatedOrder);
        } else if (i12 == 62) {
            this.placeOrderView.onOrderVoucherNotAvailable(str4, this.isPostDatedOrder);
        } else if (i12 == 61) {
            this.placeOrderView.onOrderPromotionNotAvailable(str4, this.isPostDatedOrder);
        } else if (i12 == 64) {
            this.placeOrderView.onOrderVoucherNotAvailable(str4, this.isPostDatedOrder);
        } else if (i12 == 1 || i12 == 2 || i12 == 3) {
            this.invalidItems = invalidItemArr2;
            this.placeOrderView.onOrderItemNotAvailable(str4, false, invalidItemArr2);
        } else if (i12 == 707 || i12 == 801) {
            this.placeOrderView.onGemError(str4);
        } else if (i12 == 655) {
            this.placeOrderView.onBinError(str4);
        } else if (i12 == 662) {
            this.placeOrderView.onUserTypeErrorForDiscount(str4);
        } else if (i12 == 601) {
            this.placeOrderView.onDarkstoresDjiniError(str4);
        } else if (i12 == 901) {
            this.placeOrderView.onFeesMismatchError(str4);
        } else if (i12 == 903) {
            this.placeOrderView.onFeesMismatchError(str4);
        } else if (i12 == 904) {
            this.placeOrderView.onFeesMismatchError(str4);
        } else {
            this.placeOrderView.onOrderError(i12, str4);
        }
        this.placeOrderView.onGeneralError(i12, str4);
    }

    public void onOrderSucess(PlaceOrderResponse placeOrderResponse) {
        String str;
        String str2;
        String str3;
        boolean z11 = false;
        if (GEMEngine.getInstance() != null && GEMEngine.getInstance().isTimedout()) {
            GEMEngine.getInstance().rejectGem(false);
        }
        this.response = placeOrderResponse;
        this.placeOrderView.setPlaceOrderResponse(placeOrderResponse);
        new Campaign(placeOrderResponse.isCampEnabled, placeOrderResponse.campType, placeOrderResponse.campUrl);
        Purchase purchase = new Purchase();
        purchase.setFirstOrder(placeOrderResponse.isFirstOrder);
        purchase.setCart(Cart.getInstance().getCartItems());
        purchase.setTotal("" + Cart.getInstance().getCartTotalPrice());
        purchase.setTouristTax(Cart.getInstance().getTouristTax());
        purchase.setMunciplityTax(Cart.getInstance().getMuncipalityTax());
        purchase.setDelCharges("" + Cart.getInstance().getDeliveryCharges());
        purchase.setPaymentMethod(this.selectedPayementMethod, this.fromVisaCheckout, this.selectedPayementMethodForGA);
        purchase.setEncyptedTransactionId(placeOrderResponse.transactionId);
        purchase.setRestaurant(Cart.getInstance().getRestaurant());
        purchase.setRiderTip(Cart.getInstance().getRiderTip());
        Address address2 = this.address;
        if (address2 != null) {
            if (GlobalDataModel.SelectedCountryId == Country.LEBANON.getCountryId()) {
                z11 = true;
            }
            purchase.setAddress(AddressesKt.description(address2, z11));
        } else {
            Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
            if (GlobalDataModel.SelectedCountryId == Country.LEBANON.getCountryId()) {
                z11 = true;
            }
            purchase.setAddress(AddressesKt.description(selectedCustomerAddress, z11));
        }
        float f11 = this.payBytalabatCredit;
        if (f11 > 0.0f) {
            purchase.setUsedTalabatCredit(f11);
        }
        if (Cart.getInstance().hasVoucherApplied()) {
            purchase.setVoucher(Cart.getInstance().getVoucherCode(), "" + Cart.getInstance().voucherDiscount);
            if (Cart.getInstance().getRestaurantCampaignVoucher() != null) {
                str3 = Cart.getInstance().getRestaurantCampaignVoucher().getVoucherTypeForTracking();
            } else {
                str3 = "normal";
            }
            purchase.setVoucherType(str3);
        }
        if (!(!Cart.getInstance().isLoyaltyAvailable() || Cart.getInstance().getLoyaltyVoucher() == null || Cart.getInstance().getLoyaltyVoucher().result == null)) {
            purchase.setOfferVoucherId(Cart.getInstance().getLoyaltyVoucher().result.f476id);
        }
        try {
            Address address3 = this.address;
            if (address3 != null) {
                str = address3.mobileNumber;
            } else if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                str = Customer.getInstance().getSelectedCustomerAddress().mobileNumber;
            } else {
                str = "";
            }
            Address address4 = this.address;
            if (address4 != null) {
                str2 = address4.mobilNumberCountryCode;
            } else if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                str2 = Customer.getInstance().getSelectedCustomerAddress().mobilNumberCountryCode;
            } else {
                str2 = "";
            }
            purchase.setMobileCountryCode(str2);
            purchase.setMobileNumber(str);
        } catch (Exception unused) {
        }
        trackProVendorPurchase();
        AppTracker.savePurchase(purchase);
        int i11 = this.selectedPayementMethod;
        if (i11 == 0) {
            this.placeOrderView.onOrderSucess(placeOrderResponse);
        } else if (this.additionalPaymentMethod == 11) {
            this.placeOrderView.onBNPLOrderSuccess(placeOrderResponse);
        } else if (i11 == 3) {
            if (GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId() && !TalabatUtils.isNullOrEmpty(placeOrderResponse.paymentRedirectURL)) {
                this.placeOrderView.onRedirectToPaymentPage(placeOrderResponse, placeOrderResponse.paymentRedirectURL, "", this.selectedPayementMethod);
            } else if (this.creditCardMixedPaymentCountries.contains(Integer.valueOf(GlobalDataModel.SelectedCountryId))) {
                float f12 = placeOrderResponse.balanceAmount;
                if (f12 > 0.0f) {
                    this.placeOrderView.handleWithCreditCard(f12, placeOrderResponse.transactionId, placeOrderResponse.encryptedOrderId);
                } else {
                    this.placeOrderView.onOrderSucess(placeOrderResponse);
                }
            } else if (TalabatUtils.isNullOrEmpty(placeOrderResponse.paymentRedirectURL)) {
                this.placeOrderView.onOrderSucess(placeOrderResponse);
            } else {
                this.placeOrderView.onRedirectToPaymentPage(placeOrderResponse, placeOrderResponse.paymentRedirectURL, "", this.selectedPayementMethod);
            }
        } else if (i11 == 1) {
            this.placeOrderView.onRedirectToPaymentPage(placeOrderResponse, placeOrderResponse.paymentRedirectURL, placeOrderResponse.transactionId, i11);
        } else if (i11 != 2 || !isTokenisationAvailable() || this.fromVisaCheckout) {
            int i12 = this.selectedPayementMethod;
            if (i12 != 2 || !this.fromVisaCheckout) {
                this.placeOrderView.onRedirectToPaymentPage(placeOrderResponse, placeOrderResponse.paymentRedirectURL, placeOrderResponse.transactionId, i12);
                return;
            }
            GlobalDataModel.VISACHECKOUT.visaCheckoutPayUrl = placeOrderResponse.paymentRedirectURL;
            this.placeOrderView.onVisaCheckoutOrderPlaced(purchase, placeOrderResponse.transactionId, placeOrderResponse.encryptedOrderId);
        } else if (getTokenProvider() == 2 || getTokenProvider() == 4) {
            setPaymentRequirements(true, getPaymentRequestModel(placeOrderResponse.transactionId, Customer.getInstance().getSelectedCreditCard().token, GlobalDataModel.SelectedLanguage, this.cvv), getTokenProvider(), placeOrderResponse.encryptedOrderId);
        }
    }

    public void onRedirectToPaymentWebViewWithCheckoutDotCom(String str) {
        PlaceOrderView placeOrderView2 = this.placeOrderView;
        PlaceOrderResponse placeOrderResponse = this.response;
        placeOrderView2.onRedirectToPaymentPage(placeOrderResponse, str, placeOrderResponse.transactionId, this.selectedPayementMethod);
    }

    public void onRequestException(boolean z11) {
        this.placeOrderView.onRequestException(z11);
    }

    public void onResponseRecieved() {
        this.placeOrderView.onResponseRecieved();
    }

    public void onSendCVVToProxy(@NotNull RecurringPurchaseRequest recurringPurchaseRequest, int i11) {
        this.placeOrderView.onSendCVVToProxyServer(recurringPurchaseRequest, i11);
    }

    public void onServerError(VolleyError volleyError) {
        this.placeOrderView.onServerError(volleyError);
    }

    public void onSuccessfulRecurringCheckoutDotCom() {
        this.placeOrderView.onSuccessfulRecurringCheckoutDotCom();
    }

    public void payRemainingWithCreditCard() {
        if ((this.selectedPayementMethod == 3 && isTokenisationAvailable() && !this.fromVisaCheckout && getTokenProvider() == 2) || getTokenProvider() == 4) {
            setPaymentRequirements(false, getPaymentRequestModel(this.response.transactionId, Customer.getInstance().getSelectedCreditCard().token, GlobalDataModel.SelectedLanguage, this.cvv), getTokenProvider(), this.response.encryptedOrderId);
        }
    }

    public String paymentMethod(int i11, int i12) {
        return i11 == 0 ? "cash" : i11 == 1 ? "debit_card" : i11 == 2 ? i12 == 1 ? "visa_checkout" : WalletTopUpCreditCardSelectionEventKt.ATTRIBUTE_VALUE_ORDER_PAYMENT_METHOD : i11 == 3 ? "talabat_credit" : i11 == 4 ? "cash_own_delivery" : "cash";
    }

    public void placeOrder(PlaceOrderRequestModel placeOrderRequestModel2) throws JSONException {
        LogManager.debug("[ALOV]: Presenter placeOrder enter :: " + placeOrderRequestModel2);
        setAddress(placeOrderRequestModel2.address);
        this.placeOrderRequestModel = placeOrderRequestModel2;
        this.additionalPaymentMethod = placeOrderRequestModel2.additionalPaymentMethod;
        this.iPlaceOrderInteractor.placeOrder(placeOrderRequestModel2, this.placeOrderView.getContext());
        LogManager.debug("[ALOV]: Presenter placeOrder exit");
    }

    @VisibleForTesting
    public void setAdditionalPaymentMethod(int i11) {
        this.additionalPaymentMethod = i11;
    }

    public void setAddress(Address address2) {
        this.address = address2;
    }

    public void setCvv(String str) {
        this.cvv = str;
    }

    public void setDefaultPaymentMethodForGA(String str) {
        this.defaultPayementMethod = str;
    }

    public void setFromVisaCheckout(boolean z11) {
        this.fromVisaCheckout = z11;
    }

    public void setIsQuickOrder(boolean z11) {
        this.isQuickOrder = z11;
    }

    public void setPayBytalabatCredit(float f11) {
        this.payBytalabatCredit = f11;
    }

    public void setPaymentRequirements(boolean z11, RecurringPurchaseRequest recurringPurchaseRequest, int i11, String str) {
        this.placeOrderView.setTransactionId(recurringPurchaseRequest.transactionId);
        this.placeOrderView.setEncryptedOrderId(str);
        if (!TalabatUtils.isNullOrEmpty(recurringPurchaseRequest.token)) {
            this.payProxyManagerPresenter.checkCVVRequirement(recurringPurchaseRequest, i11);
        } else if (z11) {
            this.placeOrderView.stopNonCancelableLoading();
            this.placeOrderView.addNewCard();
        } else {
            ObservabilityManager.trackUnExpectedScenario("token should not be null or empty when card is not new");
        }
    }

    public void setSelectedPaymentMethod(int i11) {
        this.selectedPayementMethod = i11;
    }

    public void setSelectedPaymentMethodForGA(int i11) {
        this.selectedPayementMethodForGA = i11;
    }

    public void showBusyPopup(String str, int i11, String str2, String str3, boolean z11) {
        AppTracker.onTransactionFailed(this.placeOrderView.getContext(), this.selectedPayementMethodForGA, str, this.restaurantStatus, str3, Cart.getInstance().getRestaurant(), GlobalDataModel.CONTACTLESS.contactlessEnabled, this.defaultPayementMethod, str2, i11, Cart.getInstance().getRiderTip());
        String str4 = str;
        this.placeOrderView.showBusyPopup(str, z11);
    }

    public void verifyMobileNumber(String str, String str2, String str3, String str4) {
        this.placeOrderView.verifyMobileNumber(str, str2, str3, str4);
    }
}
