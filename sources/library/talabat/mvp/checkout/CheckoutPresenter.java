package library.talabat.mvp.checkout;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.PlaceOrderRequestModel;
import JsonModels.PlaceOrderResponse;
import JsonModels.Request.BIN.BinRequest;
import JsonModels.Request.CheckoutDotComRequest.RecurringPurchaseRequest;
import JsonModels.Response.BIN.BinResponse;
import JsonModels.Response.BinTokenRM;
import JsonModels.Response.Cashback.CashbackRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherResult;
import JsonModels.Response.MenuItemResponse;
import JsonModels.Response.VisaCheckoutResponse.DecryptionResponse;
import JsonModels.Response.VisaCheckoutResponse.PurchaseResponse;
import JsonModels.parser.UniversalGson;
import android.content.SharedPreferences;
import androidx.annotation.VisibleForTesting;
import b10.g;
import b10.h;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.TalabatFormatter;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.android.volley.VolleyError;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.buildconfig.BuildConfig;
import com.talabat.core.experiment.data.TalabatExperiment;
import com.talabat.core.experiment.data.squads.TalabatExperimentConstants;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingExperimentsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListExperimentsKeys;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.domain.address.Address;
import com.talabat.feature.darkstoresscheduleddelivery.domain.model.DeliverySlotContent;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.DarkstoresScheduledDeliveryUseCase;
import com.talabat.feature.darkstoresscheduleddelivery.domain.usecase.IsDarkstoresScheduledDeliveryDiscountEnabledUseCase;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.ISubscriptionsTracker;
import com.talabat.feature.subscriptions.domain.model.SubscriptionMultiPlan;
import com.talabat.feature.subscriptions.domain.model.SubscriptionPaymentStatus;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper;
import com.talabat.feature.subscriptions.domain.wrapper.PostSubscriptionPaymentRxWrapper;
import com.talabat.feature.tpro.presentation.checkout.SubscriptionAtCheckoutBannerViewModel;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.lib.Integration;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CardInformation;
import datamodels.CartMenuItem;
import datamodels.CustomerInfo;
import datamodels.InvalidItem;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.OrderDetails;
import datamodels.Restaurant;
import datamodels.TransactionCart;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.checkout.tracking.PickupBrazeCheckoutLoadedEvent;
import library.talabat.mvp.checkout.tracking.ScheduleDeliveryClickedEvent;
import library.talabat.mvp.checkout.tracking.ScheduleDeliveryClosedEvent;
import library.talabat.mvp.checkout.tracking.ScheduleDeliveryConfirmedEvent;
import library.talabat.mvp.checkout.tracking.TransactionFailedEvent;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.homemap.HomeMapUtils;
import library.talabat.mvp.placeorder.IPlaceOrderPresenter;
import org.json.JSONException;
import tracking.AppTracker;

@Instrumented
public class CheckoutPresenter implements ICheckoutPresenter, CheckoutListener {
    private String TPRO_CHECKOUT_SCREEN_NAME = SubscriptionAtCheckoutBannerViewModel.TPRO_CHECKOUT_SCREEN_NAME;
    private String TPRO_CHECKOUT_SCREEN_TYPE = "checkout";
    private int additionalPaymentMethod;
    @VisibleForTesting
    Address address;
    private float availableTalabatCredit = 0.0f;
    private boolean cashbackEnabled = false;
    private ICheckoutInteractor checkoutInteractor;
    /* access modifiers changed from: private */
    public CheckoutView checkoutView;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private CustomerRepository customerRepository;
    private String cvv = "";
    /* access modifiers changed from: private */
    public Disposable darkstoreDeliverySlotsDisposable;
    private final DarkstoresScheduledDeliveryUseCase darkstoresScheduledDeliveryUseCase;
    private String defaultPayementMethod = "";
    /* access modifiers changed from: private */
    public Disposable disposable;
    private boolean doesMyBasketMeetsMOV;
    private final ITalabatFeatureFlag featureFlag;
    private boolean fromVisaCheckout = false;
    private final GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper;
    private final GetTProOrderStatusUseCase getTProOrderStatusUseCase;
    private boolean hideAddCard;
    private InvalidItem[] invalidItems;
    private boolean isCheckoutDotCom = false;
    /* access modifiers changed from: private */
    public boolean isDarkstoreDeliverySlotsRequestInProgress = false;
    private final IsDarkstoresScheduledDeliveryDiscountEnabledUseCase isDarkstoresScheduledDeliveryDiscountEnabled;
    private boolean isDeliverytimeIntervallsLoaded = false;
    private boolean isEditAddressFromCheckoutScreen;
    private boolean isForceCvv = false;
    private boolean isGoGreen = false;
    private boolean isPostDatedOrder = false;
    private boolean isQuickOrder;
    private boolean isTalabatDelVoucher = false;
    private final LocationConfigurationRepository locationConfigRepository;
    private boolean onDeliveryTimingApiCalled = false;
    private float payByOther;
    private float payBytalabatCredit;
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    private IPlaceOrderPresenter placeOrderPresenter;
    private PlaceOrderRequestModel placeOrderRequestModel;
    private PlaceOrderUIDProvider placeOrderUIDProvider;
    String plansId = "";
    private final PostSubscriptionPaymentRxWrapper postSubscriptionPaymentRxWrapper;
    private boolean preOrderTimingsAvailable = false;
    private int progressCounter;
    private PlaceOrderResponse response;
    private String restaurantStatus;
    private final List<Integer> scheduledDeliveryVerticals = Arrays.asList(new Integer[]{1, 2, 3, 10});
    private int selectedPayementMethod = -1;
    private int selectedPayementMethodForGA = -1;
    private ISubscriptionStatusRepository subscriptionStatusRepository;
    private final ISubscriptionsTracker subscriptionsTracker;
    private ITalabatExperiment talabatExperiment;
    private final TalabatTracker talabatTracker;

    public CheckoutPresenter(CheckoutView checkoutView2, AppVersionProvider appVersionProvider, PaymentConfigurationRepository paymentConfigurationRepository2, IPlaceOrderPresenter iPlaceOrderPresenter, PlaceOrderUIDProvider placeOrderUIDProvider2, ITalabatExperiment iTalabatExperiment, GetTProOrderStatusUseCase getTProOrderStatusUseCase2, ITalabatFeatureFlag iTalabatFeatureFlag, TalabatTracker talabatTracker2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository, DarkstoresScheduledDeliveryUseCase darkstoresScheduledDeliveryUseCase2, IsDarkstoresScheduledDeliveryDiscountEnabledUseCase isDarkstoresScheduledDeliveryDiscountEnabledUseCase, CustomerRepository customerRepository2, PostSubscriptionPaymentRxWrapper postSubscriptionPaymentRxWrapper2, ISubscriptionStatusRepository iSubscriptionStatusRepository, GetActiveSubscriptionsRxWrapper getActiveSubscriptionsRxWrapper2, ISubscriptionsTracker iSubscriptionsTracker) {
        this.checkoutView = checkoutView2;
        this.checkoutInteractor = new CheckoutInteractor(appVersionProvider, configurationLocalRepository2, locationConfigurationRepository, paymentConfigurationRepository2, this, postSubscriptionPaymentRxWrapper2, getActiveSubscriptionsRxWrapper2, iSubscriptionStatusRepository);
        this.placeOrderPresenter = iPlaceOrderPresenter;
        this.placeOrderUIDProvider = placeOrderUIDProvider2;
        this.talabatExperiment = iTalabatExperiment;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
        this.postSubscriptionPaymentRxWrapper = postSubscriptionPaymentRxWrapper2;
        this.getActiveSubscriptionsRxWrapper = getActiveSubscriptionsRxWrapper2;
        this.subscriptionsTracker = iSubscriptionsTracker;
        if (Cart.getInstance().getRestaurant() != null) {
            int i11 = Cart.getInstance().getRestaurant().statusType;
            if (i11 == 0) {
                this.restaurantStatus = "Open";
            } else if (i11 == 5) {
                this.restaurantStatus = "Preorder";
            } else if (i11 == 1) {
                this.restaurantStatus = "Closed";
            } else {
                this.restaurantStatus = "Busy";
            }
        }
        this.defaultPayementMethod = "";
        this.getTProOrderStatusUseCase = getTProOrderStatusUseCase2;
        this.featureFlag = iTalabatFeatureFlag;
        this.talabatTracker = talabatTracker2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.darkstoresScheduledDeliveryUseCase = darkstoresScheduledDeliveryUseCase2;
        this.isDarkstoresScheduledDeliveryDiscountEnabled = isDarkstoresScheduledDeliveryDiscountEnabledUseCase;
        this.customerRepository = customerRepository2;
        Cart.getInstance().setDarkstoreScheduledDeliveryDiscountEnabled(isDarkstoresScheduledDeliveryDiscountEnabledUseCase.invoke());
    }

    private boolean areLocationsDifferent(Address address2, Address address3) {
        if (address2 == null || address3 == null || ((double) HomeMapUtils.INSTANCE.distanceBetween(address2.latitude, address2.longitude, address3.latitude, address3.longitude)) > 0.0d) {
            return true;
        }
        return false;
    }

    private void arrangePlanIdForTracker(SubscriptionMultiPlan subscriptionMultiPlan) {
        for (int i11 = 0; i11 < subscriptionMultiPlan.getPlans().size(); i11++) {
            this.plansId += subscriptionMultiPlan.getPlans().get(i11).getPlanId();
            if (i11 < subscriptionMultiPlan.getPlans().size() - 1) {
                this.plansId += ",";
            }
        }
    }

    private void bindDeliverFees(Restaurant restaurant, Cart cart, TProOrderStatus tProOrderStatus) {
        String str;
        String str2;
        if (restaurant.talabatCharges > 0.0f) {
            if (!TalabatUtils.isNullOrEmpty(restaurant.altTalabatText)) {
                str2 = restaurant.altTalabatText;
            } else {
                str2 = "t";
            }
            this.checkoutView.setDeliveryCharges(restaurant.getDisplayTalabatCharge(), str2);
        } else {
            if (!TalabatUtils.isNullOrEmpty(restaurant.altDelChargetxt)) {
                str = restaurant.altDelChargetxt;
            } else {
                str = "d";
            }
            this.checkoutView.setDeliveryCharges(cart.getDeliveryChargesDisplayPrice(), str);
        }
        this.checkoutView.setFreeDeliveryReturn(cart.getDeliveryChargesDisplayPrice(), tProOrderStatus);
    }

    private void callMenuApi() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        if (restaurant == null) {
            return;
        }
        if (restaurant.shopType == 1) {
            GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.FALSE);
            this.checkoutInteractor.getGroceryMenu(restaurant);
            return;
        }
        MenuResponseMapper.INSTANCE.clear();
        this.checkoutInteractor.getRestaurantInfoOnly(restaurant);
        this.checkoutInteractor.getRestaurantMenuOnly(restaurant);
    }

    private int getAdditionalPaymentMethodForDebitCards(int i11, int i12) {
        if (i11 == 1 && i12 == Country.QATAR.getCountryId()) {
            return 8;
        }
        return 0;
    }

    private int getCustomerCode() {
        Customer instance = Customer.getInstance();
        if (instance == null || instance.getCustomerInfo() == null) {
            return 0;
        }
        return instance.getCustomerInfo().f13850id;
    }

    private String getMobileNumber(boolean z11) {
        String str;
        if (!Customer.getInstance().isLoggedIn()) {
            str = getMobileNumberForGuestUser(z11);
        } else if (Customer.getInstance().getSelectedCustomerAddress() != null) {
            if (!z11 || Customer.getInstance().getSelectedCustomerAddress().mobilNumberCountryCode == null) {
                str = "";
            } else {
                str = Customer.getInstance().getSelectedCustomerAddress().mobilNumberCountryCode;
            }
            if (Customer.getInstance().getSelectedCustomerAddress().mobileNumber != null) {
                str = str + Customer.getInstance().getSelectedCustomerAddress().mobileNumber;
            }
        } else {
            str = "";
        }
        if (TalabatUtils.isNullOrEmpty(str)) {
            return "";
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getMobileNumberForGuestUser(boolean r6) {
        /*
            r5 = this;
            library.talabat.mvp.checkout.CheckoutView r0 = r5.checkoutView
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = com.talabat.helpers.GlobalConstants.PrefsConstants.getNAME()
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            JsonModels.parser.UniversalGson r1 = JsonModels.parser.UniversalGson.INSTANCE
            com.google.gson.Gson r1 = r1.gson
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = ""
            r2.append(r3)
            int r4 = com.talabat.helpers.GlobalDataModel.SelectedAreaId
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            boolean r2 = r0.contains(r2)
            if (r2 == 0) goto L_0x0078
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            int r4 = com.talabat.helpers.GlobalDataModel.SelectedAreaId
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = r0.getString(r2, r3)
            boolean r2 = r1 instanceof com.google.gson.Gson
            java.lang.Class<datamodels.QuickOrderInfo> r4 = datamodels.QuickOrderInfo.class
            if (r2 != 0) goto L_0x004c
            java.lang.Object r0 = r1.fromJson((java.lang.String) r0, r4)
            goto L_0x0050
        L_0x004c:
            java.lang.Object r0 = com.newrelic.agent.android.instrumentation.GsonInstrumentation.fromJson((com.google.gson.Gson) r1, (java.lang.String) r0, r4)
        L_0x0050:
            datamodels.QuickOrderInfo r0 = (datamodels.QuickOrderInfo) r0
            if (r0 == 0) goto L_0x0078
            if (r6 == 0) goto L_0x005d
            com.talabat.domain.address.Address r6 = r0.address
            java.lang.String r6 = r6.mobilNumberCountryCode
            if (r6 == 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r6 = r3
        L_0x005e:
            com.talabat.domain.address.Address r1 = r0.address
            java.lang.String r1 = r1.mobileNumber
            if (r1 == 0) goto L_0x0079
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r6)
            com.talabat.domain.address.Address r6 = r0.address
            java.lang.String r6 = r6.mobileNumber
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            goto L_0x0079
        L_0x0078:
            r6 = r3
        L_0x0079:
            boolean r0 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r6)
            if (r0 == 0) goto L_0x0080
            goto L_0x0081
        L_0x0080:
            r3 = r6
        L_0x0081:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.checkout.CheckoutPresenter.getMobileNumberForGuestUser(boolean):java.lang.String");
    }

    private String getNormalVoucherText() {
        return this.checkoutView.getNormalVoucherText();
    }

    private int getVendorId() {
        return Cart.getInstance().getRestaurant().getBranchId();
    }

    private boolean getuserHaveSelectedSavedCard() {
        if (isTokenisationAvailable()) {
            return Customer.getInstance().isCreditCardsAvailable();
        }
        return false;
    }

    private boolean isCurrentSelectedCountryEnabledForTalabatCredits() {
        if (this.configurationLocalRepository.selectedCountry() == Country.OMAN || this.configurationLocalRepository.selectedCountry() == Country.BAHRAIN) {
            return false;
        }
        return true;
    }

    private boolean isDarkStore() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return false;
        }
        if (restaurant.isDarkStore || restaurant.isMigrated) {
            return true;
        }
        return false;
    }

    private boolean isLoyaltyOrderAction(LoyaltyVoucherRM loyaltyVoucherRM) {
        LoyaltyVoucherResult loyaltyVoucherResult;
        if (loyaltyVoucherRM == null || (loyaltyVoucherResult = loyaltyVoucherRM.result) == null) {
            return false;
        }
        String voucherOptionType = loyaltyVoucherResult.getVoucherOptionType();
        if (loyaltyVoucherResult.f476id == null || !voucherOptionType.equals("LOYALTY")) {
            return false;
        }
        return true;
    }

    private boolean isRiderTipSupportedPaymentMethod(int i11) {
        if (i11 == 3 && !isCurrentSelectedCountryEnabledForTalabatCredits()) {
            return false;
        }
        if (i11 == 11) {
            return this.featureFlag.getFeatureFlag(OrderingFeatureFlagsKeys.LENDING_BNPL_RIDER_TIP_ENABLED, false);
        }
        if (i11 != 0) {
            return true;
        }
        return false;
    }

    private boolean isVisaCheckoutEnabled() {
        if (Cart.getInstance().getRestaurant() == null) {
            return false;
        }
        datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigRepository);
        if (!Cart.getInstance().getRestaurant().isAcceptsCredit() || selectedCountry == null || !selectedCountry.isVisaCheckoutAvailable || GlobalDataModel.SelectedCountryId != Country.UAE.getCountryId()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onSubscriptionPlansLoaded$1(Function1 function1, TProOrderStatus tProOrderStatus) {
        boolean z11;
        if (!tProOrderStatus.isValidMovDifferenceValue() || !tProOrderStatus.isFreeDeliveryEligibleVendor() || !tProOrderStatus.getMovAchieved()) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.doesMyBasketMeetsMOV = z11;
        function1.invoke(Boolean.valueOf(z11));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setTaxAndDelivery$0(Restaurant restaurant, Cart cart, TProOrderStatus tProOrderStatus) {
        bindDeliverFees(restaurant, cart, tProOrderStatus);
        return Unit.INSTANCE;
    }

    private void logLoyaltyOrderAction(Cart cart) {
        LoyaltyVoucherRM loyaltyVoucher = cart.getLoyaltyVoucher();
        if (isLoyaltyOrderAction(loyaltyVoucher)) {
            String str = loyaltyVoucher.result.f476id;
            int i11 = Customer.getInstance().getCustomerInfo().f13850id;
            String valueOf = String.valueOf(cart.getRestaurant().f13872id);
            float loyaltyDiscount = cart.getLoyaltyDiscount() + cart.getFreeDeliveryDiscountAmount();
            float allDiscounts = cart.getAllDiscounts() + loyaltyDiscount;
            this.talabatTracker.track(new LoyaltyOrderTrackingEvent(new LoyaltyOrderTrackData(i11, cart.getCartTotalPrice(), valueOf, str, BigDecimal.valueOf((double) loyaltyDiscount).setScale(2, RoundingMode.HALF_UP).floatValue(), BigDecimal.valueOf((double) allDiscounts).setScale(2, RoundingMode.HALF_UP).floatValue())));
        }
    }

    private void logPickupCheckoutLoadedEvent() {
        Cart instance = Cart.getInstance();
        Restaurant restaurant = instance.getRestaurant();
        if (restaurant != null) {
            this.talabatTracker.track(new PickupBrazeCheckoutLoadedEvent(restaurant.f13873name, restaurant.getCuisinesText(), (double) instance.getCartTotalPrice()));
        }
    }

    private void onValidationError(int i11, int i12, boolean z11) {
        this.checkoutView.stopNonCancelableLoading();
        this.checkoutView.onValidationError(i11, i12, z11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void passCardValidate() {
        /*
            r5 = this;
            buisnessmodels.Cart r0 = buisnessmodels.Cart.getInstance()
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x005b
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            if (r0 == 0) goto L_0x005b
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            buisnessmodels.tokenisation.TokenisationCreditCard r2 = r0.getSelectedCreditCardValidate()
            if (r2 == 0) goto L_0x005b
            buisnessmodels.tokenisation.TokenisationCreditCard r2 = r0.getSelectedCreditCardValidate()
            java.lang.String r2 = r2.cardnumber
            boolean r2 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r2)
            if (r2 != 0) goto L_0x0045
            buisnessmodels.tokenisation.TokenisationCreditCard r2 = r0.getSelectedCreditCardValidate()
            java.lang.String r2 = r2.cardnumber
            boolean r3 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r2)     // Catch:{ Exception -> 0x0046 }
            if (r3 != 0) goto L_0x0046
            java.lang.String r3 = "x"
            boolean r3 = r2.contains(r3)     // Catch:{ Exception -> 0x0046 }
            if (r3 == 0) goto L_0x0046
            java.lang.String r3 = "-"
            java.lang.String[] r3 = r2.split(r3)     // Catch:{ Exception -> 0x0046 }
            int r4 = r3.length     // Catch:{ Exception -> 0x0046 }
            if (r4 <= 0) goto L_0x0046
            r4 = 1
            r2 = r3[r4]     // Catch:{ Exception -> 0x0046 }
            goto L_0x0046
        L_0x0045:
            r2 = r1
        L_0x0046:
            buisnessmodels.tokenisation.TokenisationCreditCard r3 = r0.getSelectedCreditCardValidate()
            java.lang.String r3 = r3.binNumber
            boolean r3 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r3)
            if (r3 != 0) goto L_0x0058
            buisnessmodels.tokenisation.TokenisationCreditCard r0 = r0.getSelectedCreditCardValidate()
            java.lang.String r1 = r0.binNumber
        L_0x0058:
            r0 = r1
            r1 = r2
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            boolean r2 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r1)
            if (r2 != 0) goto L_0x006f
            boolean r2 = com.talabat.helpers.TalabatUtils.isNullOrEmpty((java.lang.String) r0)
            if (r2 != 0) goto L_0x006f
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            r2.setBinAndLatDigitForValidate(r0, r1)
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.checkout.CheckoutPresenter.passCardValidate():void");
    }

    private void refreshVoucherViews(Restaurant restaurant) {
        if (restaurant != null) {
            setTaxAndDelivery(Boolean.FALSE);
            this.checkoutView.enableTalabatCreditCashbackView();
            this.checkoutView.setPaymentView(true, restaurant.isAcceptsDebit(), restaurant.isAcceptsCredit(), isTokenisationAvailable(), getuserHaveSelectedSavedCard(), getTokenProvider(), restaurant.isTalabatGo, restaurant.acceptsCash, isVisaCheckoutEnabled());
        }
    }

    private void saveTempAddress(Address address2) {
        if (address2 != null) {
            HomeMapTemp.INSTANCE.setTempAddress(address2);
            SharedPreferences.Editor edit = this.checkoutView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).edit();
            edit.putString(GlobalConstants.PrefsConstants.HOME_MAP_PREF_ADDRESS, storeTempAddress(address2));
            edit.apply();
        }
    }

    private void setDeliveryAddressView(Address address2) {
        if (!isDarkStore()) {
            LatLng latLng = GlobalDataModel.CHECKOUT.currentLatLong;
            if (latLng != null) {
                if (address2 != null && areLocationsDifferent(address2, latLng)) {
                    GlobalDataModel.CHECKOUT.currentLatLong = new LatLng(address2.latitude, address2.longitude);
                }
                LatLng latLng2 = GlobalDataModel.CHECKOUT.currentLatLong;
                updateCurrentLocationAndCallApi(latLng2.latitude, latLng2.longitude);
            } else if (address2 != null) {
                GlobalDataModel.CHECKOUT.currentLatLong = new LatLng(address2.latitude, address2.longitude);
                if (Customer.getInstance().isLoggedIn()) {
                    if (areLocationsDifferent(address2, Customer.getInstance().getSelectedCustomerAddress())) {
                        updateCurrentLocationAndCallApi(address2.latitude, address2.longitude);
                    }
                } else if (areLocationsDifferent(address2, HomeMapTemp.INSTANCE.getTempAddress())) {
                    saveTempAddress(address2);
                    updateCurrentLocationAndCallApi(address2.latitude, address2.longitude);
                }
            }
        }
        if (address2 == null) {
            return;
        }
        if (this.talabatExperiment.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_DELIVERY_ADDRESS_MAP_CHECKOUT, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.checkoutView.setAddressViewMap(address2);
        } else {
            this.checkoutView.setAddressView(address2);
        }
    }

    private String storeTempAddress(Address address2) {
        Gson gson = UniversalGson.INSTANCE.gson;
        if (!(gson instanceof Gson)) {
            return gson.toJson((Object) address2);
        }
        return GsonInstrumentation.toJson(gson, (Object) address2);
    }

    private void updateCurrentLocationAndCallApi(double d11, double d12) {
        showProgress();
        updateBranch(Cart.getInstance().getRestaurant().branchId, d11, d12);
    }

    public void addAgeLimitToPlaceOrderModel(PlaceOrderRequestModel placeOrderRequestModel2, String str) {
        if (str != null && !str.isEmpty()) {
            placeOrderRequestModel2.setAgeLimit(str);
        }
    }

    public void applyBinVoucher(BinResponse binResponse, String str, boolean z11) {
        if (TalabatUtils.isNullOrEmpty(binResponse.binNum) || !str.equals(binResponse.binNum)) {
            this.checkoutView.stopNonCancelableLoading();
        } else if (z11) {
            Cart.getInstance().setBinVoucherDiscount(binResponse.binDiscount, binResponse.binNum, binResponse.binMinimumOrderAmount);
            this.checkoutView.onUpdateBNPLCartBinVoucher();
        } else {
            this.checkoutView.applyBinVoucherViews(binResponse.binDiscount, binResponse.binNum, binResponse.binMinimumOrderAmount);
        }
        setTaxAndDelivery(Boolean.FALSE);
    }

    public boolean calculateMOVWithTProOrder(Function1<Boolean, Unit> function1) {
        boolean z11;
        boolean equals = this.talabatExperiment.getStringVariant(OrderingExperimentsKeys.ENABLE_TPRO_CHECKOUT, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Variation1");
        Customer instance = Customer.getInstance();
        if (instance != null) {
            z11 = instance.isShowPro();
        } else {
            z11 = false;
        }
        if (equals && z11) {
            this.checkoutInteractor.getGetActiveSubscriptions(function1);
        }
        return this.doesMyBasketMeetsMOV;
    }

    public void callCashBackApi(float f11) {
        this.checkoutInteractor.callCashBackApi(f11);
    }

    public boolean canShowVouchers() {
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(GrowthFeatureFlagConstantKt.FunWithFlagEnableBasketVouchersKey.invoke(Integer.valueOf(GlobalDataModel.SelectedCountryId)), false);
        if (Cart.getInstance().canShowVoucherInCart() || Integration.isGemActive() || isDarkStore() || !featureFlag2) {
            return false;
        }
        return true;
    }

    @VisibleForTesting
    public void checkAddressWithCurrentLocation(double d11, double d12, LatLng latLng) {
        if (Double.valueOf(HomeMapUtils.INSTANCE.distanceBetweenTwoCordinatesbet(d11, d12, latLng.latitude, latLng.longitude)).doubleValue() <= 480.0d || isPickup()) {
            this.checkoutView.hideShowCurreAwareness();
        } else {
            this.checkoutView.showCurrentLocationAwareness();
        }
    }

    public void checkForBinVoucher(BinRequest binRequest) {
        this.checkoutInteractor.checkForBinVoucher(binRequest);
    }

    public void continueWithAdyenPayment(RecurringPurchaseRequest recurringPurchaseRequest) {
        this.placeOrderPresenter.continueWithAdyenPaymentAfterCVVSentToProxy(recurringPurchaseRequest);
    }

    public void continueWithCheckoutPayment(RecurringPurchaseRequest recurringPurchaseRequest) {
        this.placeOrderPresenter.continueWithCheckoutPaymentAfterCVVSentToProxy(recurringPurchaseRequest);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005b A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void currentLoactionAwareness(com.google.android.gms.maps.model.LatLng r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x001f
            double r0 = r8.latitude
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x001f
            double r4 = r8.longitude
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x001f
            library.talabat.mvp.homemap.HomeMapTemp r2 = library.talabat.mvp.homemap.HomeMapTemp.INSTANCE
            java.lang.Double r0 = java.lang.Double.valueOf(r0)
            double r3 = r8.longitude
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r2.setUserCurrentLocation(r0, r1)
        L_0x001f:
            boolean r0 = r7.isQuickOrder
            if (r0 == 0) goto L_0x0033
            com.talabat.domain.address.Address r0 = r7.address
            if (r0 == 0) goto L_0x0057
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            com.talabat.domain.address.Address r1 = r7.address
            double r2 = r1.latitude
            double r4 = r1.longitude
            r0.<init>(r2, r4)
            goto L_0x0058
        L_0x0033:
            buisnessmodels.Customer r0 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r0 = r0.getSelectedCustomerAddress()
            if (r0 == 0) goto L_0x0057
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            buisnessmodels.Customer r1 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r1 = r1.getSelectedCustomerAddress()
            double r1 = r1.latitude
            buisnessmodels.Customer r3 = buisnessmodels.Customer.getInstance()
            com.talabat.domain.address.Address r3 = r3.getSelectedCustomerAddress()
            double r3 = r3.longitude
            r0.<init>(r1, r3)
            goto L_0x0058
        L_0x0057:
            r0 = 0
        L_0x0058:
            r6 = r0
            if (r8 == 0) goto L_0x0065
            if (r6 == 0) goto L_0x0065
            double r2 = r8.latitude
            double r4 = r8.longitude
            r1 = r7
            r1.checkAddressWithCurrentLocation(r2, r4, r6)
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.checkout.CheckoutPresenter.currentLoactionAwareness(com.google.android.gms.maps.model.LatLng):void");
    }

    public void editDeliveryAddress() {
        this.checkoutView.onRedirectToEditAddress(getDeliveryAddress());
    }

    public void fetchCurrentLocationAwareness() {
        if (TalabatExperiment.INSTANCE.getBooleanVariant(TalabatExperimentConstants.CAN_SHOW_DELIVERY_ADDRESS_MAP_CHECKOUT, BuildConfig.IS_ALPHA.booleanValue(), TalabatExperimentDataSourceStrategy.APPTIMIZE)) {
            this.checkoutView.fetchCurrentLocation();
        }
    }

    public void fetchDarkstoreDeliverySlots() {
        this.darkstoresScheduledDeliveryUseCase.getDeliverySlots(Cart.getInstance().getRestaurant().branchId).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<List<DeliverySlotContent>>() {
            public void onError(Throwable th2) {
                CheckoutPresenter.this.isDarkstoreDeliverySlotsRequestInProgress = false;
                CheckoutPresenter.this.checkoutView.stopLodingPopup();
            }

            public void onSubscribe(Disposable disposable) {
                CheckoutPresenter.this.darkstoreDeliverySlotsDisposable = disposable;
                CheckoutPresenter.this.isDarkstoreDeliverySlotsRequestInProgress = true;
            }

            public void onSuccess(List<DeliverySlotContent> list) {
                CheckoutPresenter.this.checkoutView.stopLodingPopup();
                CheckoutPresenter.this.isDarkstoreDeliverySlotsRequestInProgress = false;
                if (list != null && !list.isEmpty()) {
                    CheckoutPresenter.this.checkoutView.updateDeliverySlots(list);
                }
            }
        });
    }

    @VisibleForTesting
    public int getAdditionalPaymentMethod() {
        return this.additionalPaymentMethod;
    }

    public String getBinDiscountAmount() {
        return TalabatFormatter.getInstance().getFormattedCurrency(Cart.getInstance().getBinVoucherDiscount(), true);
    }

    public void getBinOfferDetails(String str) {
        Cart instance = Cart.getInstance();
        if (instance.getRestaurant() != null) {
            this.checkoutInteractor.getBinOfferDetails(instance.getRestaurant().getId(), instance.isPromotionApplied(), instance.isFreeItemAdded(), instance.isCouponApplied(), str, instance.getRestaurant().getBranchId());
        }
    }

    public void getBinTokens() {
        if (Integration.isGemActive()) {
            this.checkoutView.doNotExpectBin();
        } else if (!this.paymentConfigurationRepository.config().isBinCampAvailable()) {
            this.checkoutView.doNotExpectBin();
        } else if (this.customerRepository.isLoggedIn() && this.customerRepository.hasSavedCards()) {
            if (!GlobalDataModel.BIN.handled || !GlobalDataModel.BIN.tokensModified || GlobalDataModel.BIN.savedTokens.size() <= 0) {
                this.checkoutInteractor.getCustomerTokensForBin();
                return;
            }
            this.checkoutView.doNotExpectBin();
            if (GlobalDataModel.BIN.tokensModified && GlobalDataModel.BIN.savedTokens != null) {
                Customer instance = Customer.getInstance();
                ArrayList<TokenisationCreditCard> arrayList = GlobalDataModel.BIN.savedTokens;
                instance.setSavedCreditCards((TokenisationCreditCard[]) arrayList.toArray(new TokenisationCreditCard[arrayList.size()]));
            }
        }
    }

    public String getCartAgeLimit() {
        return Cart.getInstance().getDarkstoresAgeLimit();
    }

    public String getCartItemUnavailabilityValue() {
        return Cart.getInstance().getMigratedPartialFulfillmentPreference();
    }

    public void getDecryptedData(String str, String str2) {
        this.checkoutView.startLodingPopup();
        this.checkoutInteractor.sendDecryptRequest(str, str2);
    }

    public String getDefaultPaymentMethod() {
        return this.defaultPayementMethod;
    }

    public Address getDeliveryAddress() {
        if (this.isQuickOrder) {
            return this.address;
        }
        return Customer.getInstance().getSelectedCustomerAddress();
    }

    public String getFreeDeliveryDiscountAmount() {
        return "- " + TalabatFormatter.getInstance().getFormattedCurrency(Cart.getInstance().getFreeDeliveryDiscountAmount(), true);
    }

    public boolean getHideAddCardStatus() {
        return this.hideAddCard;
    }

    public String getLoyaltyDiscount() {
        return "- " + Cart.getInstance().getDisplayLoyaltyDiscount();
    }

    public String getLoyaltyVoucherText() {
        String str;
        if (Cart.getInstance().getLoyaltyVoucher() != null) {
            str = Cart.getInstance().getLoyaltyVoucher().getTitle();
        } else {
            str = "";
        }
        if (TalabatUtils.isNullOrEmpty(str)) {
            return getNormalVoucherText();
        }
        return str;
    }

    public void getParallelBinData(boolean z11) {
        this.checkoutInteractor.getAllBinOffers(z11);
    }

    public PlaceOrderRequestModel getPlaceOrderRequestModel() {
        return this.placeOrderRequestModel;
    }

    public String getReplacedString(StringBuilder sb2, String str, String str2) {
        if (sb2.length() <= 0) {
            return "";
        }
        if (!sb2.toString().contains(str)) {
            return sb2.toString();
        }
        int lastIndexOf = sb2.lastIndexOf(str);
        sb2.replace(lastIndexOf, 2 + lastIndexOf, " ### ");
        return sb2.toString().trim();
    }

    public MenuItem getRestaurantMenuItem(int i11) {
        MenuItem menuItem;
        MenuItem menuItem2 = new MenuItem();
        Iterator<MenuSection> it = getRestaurantMenuSections().iterator();
        while (it.hasNext()) {
            MenuSection next = it.next();
            int i12 = 0;
            if (Integration.isGemActive()) {
                MenuItem[] menuItemArr = next.items;
                if (menuItemArr != null && menuItemArr.length >= 1) {
                    int length = menuItemArr.length;
                    while (true) {
                        if (i12 >= length) {
                            break;
                        }
                        menuItem = menuItemArr[i12];
                        if (!menuItem.isPromotional && !menuItem.excludedFromGem && menuItem.f13861id == i11) {
                            break;
                        }
                        i12++;
                    }
                }
            } else {
                MenuItem[] menuItemArr2 = next.items;
                if (menuItemArr2 != null && menuItemArr2.length >= 1) {
                    int length2 = menuItemArr2.length;
                    while (true) {
                        if (i12 >= length2) {
                            break;
                        }
                        menuItem = menuItemArr2[i12];
                        if (menuItem.f13861id == i11) {
                            break;
                        }
                        i12++;
                    }
                }
            }
            menuItem2 = menuItem;
        }
        return menuItem2;
    }

    public ArrayList<MenuSection> getRestaurantMenuSections() {
        MenuItemRM menuItemRM;
        MenuSection[] menuSectionArr;
        ArrayList<MenuSection> arrayList = new ArrayList<>();
        MenuItemsResponseModel menuItemsResponseModel = GlobalDataModel.JSON.menuItemsResponseModel;
        if (menuItemsResponseModel == null || (menuItemRM = menuItemsResponseModel.menu) == null || (menuSectionArr = menuItemRM.menuSection) == null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(Arrays.asList(menuSectionArr));
        boolean z11 = false;
        for (int i11 = 0; i11 < arrayList2.size(); i11++) {
            if (Integration.isGemActive()) {
                if (((MenuSection) arrayList2.get(i11)).items != null && ((MenuSection) arrayList2.get(i11)).items.length >= 1) {
                    for (int i12 = 0; i12 < ((MenuSection) arrayList2.get(i11)).items.length; i12++) {
                        if (!((MenuSection) arrayList2.get(i11)).items[i12].isPromotional && !((MenuSection) arrayList2.get(i11)).items[i12].excludedFromGem) {
                            z11 = true;
                        }
                    }
                    if (z11) {
                        arrayList.add((MenuSection) arrayList2.get(i11));
                        z11 = false;
                    }
                }
            } else if (((MenuSection) arrayList2.get(i11)).items != null && ((MenuSection) arrayList2.get(i11)).items.length >= 1) {
                arrayList.add((MenuSection) arrayList2.get(i11));
            }
        }
        return arrayList;
    }

    public Float getScheduledDeliveryDiscount() {
        if (this.isDarkstoresScheduledDeliveryDiscountEnabled.invoke()) {
            return Cart.getInstance().getDarkStoreScheduledDeliveryDiscount();
        }
        return null;
    }

    @VisibleForTesting
    public int getSelectedPayementMethod() {
        return this.selectedPayementMethod;
    }

    public void getTProOrderStatus(Function1<? super TProOrderStatus, Unit> function1, boolean z11, boolean z12) {
        this.getTProOrderStatusUseCase.invoke(true, z11, z12, function1);
    }

    public int getTokenProvider() {
        datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigRepository);
        if (selectedCountry != null) {
            return selectedCountry.tokenisationProvider;
        }
        return 0;
    }

    public String getVoucherAmount() {
        return "- " + Cart.getInstance().getDisplayVoucherDiscount();
    }

    public void handleDeliveryFee(double d11) {
        Cart.getInstance().setRemoteDeliveryFee((float) d11);
        this.checkoutView.setTotalAmount();
    }

    public void handleServiceFee(float f11) {
        Cart.getInstance().setServiceFee(f11);
        this.checkoutView.setTotalAmount();
    }

    public void handleSmallOrderFee(float f11) {
        Cart.getInstance().setSmallOrderFee(f11);
        this.checkoutView.setTotalAmount();
    }

    public void hideBinAvailableNotification() {
        this.checkoutView.hideBinAvailableNotification();
    }

    public void hideProgress() {
        int i11 = this.progressCounter - 1;
        this.progressCounter = i11;
        if (i11 <= 0) {
            this.checkoutView.stopNonCancelableLoading();
            this.checkoutView.stopScreenTrace();
            this.progressCounter = 0;
        }
    }

    public boolean isAnyVoucherAvailable() {
        if (Cart.getInstance().isVoucherApplied() || Cart.getInstance().isZeroVoucherApplied() || Cart.getInstance().isLoyaltyVoucherApplied() || Cart.getInstance().isFreeDeliveryTypeVoucherApplied()) {
            return true;
        }
        return false;
    }

    public boolean isDarkstoreDeliverySlotsRequestInProgress() {
        return this.isDarkstoreDeliverySlotsRequestInProgress;
    }

    public boolean isDarkstoresScheduledDeliveryEnabled() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null || !this.scheduledDeliveryVerticals.contains(Integer.valueOf(restaurant.shopType)) || (!restaurant.hasPreOrderOnClosed && restaurant.statusType != 5)) {
            return false;
        }
        return true;
    }

    public boolean isDarkstoresVouchersEnabled() {
        boolean z11 = !TalabatUtils.isNullOrEmpty(getMobileNumber(false));
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(GrowthFeatureFlagConstantKt.FunWithFlagEnableTmartVouchersKey.invoke(Integer.valueOf(GlobalDataModel.SelectedCountryId)), false);
        boolean featureFlag3 = this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.DARKSTORES_VOUCHERS_ENABLED, false);
        if (!z11 || !featureFlag3 || !isDarkStore() || !featureFlag2) {
            return false;
        }
        return true;
    }

    public boolean isDeliveryTimingApiCalled() {
        return this.onDeliveryTimingApiCalled;
    }

    public boolean isDesignSystemAlert() {
        return this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_ALERT, true);
    }

    public boolean isDesignSystemSimpleCard() {
        return this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_SIMPLE_CARD, false);
    }

    public boolean isFlutterBNPLCheckoutEnabled() {
        return this.featureFlag.getFeatureFlag(PayFeatureFlagConstants.PayFeatureFlagsWithoutCountry.PAY_ANDROID_FLUTTER_BNPL_CHECKOUT_ENABLED, false);
    }

    public boolean isFreeDeliveryDiscountFull() {
        return Cart.getInstance().isFreeDeliveryDiscountFull();
    }

    public boolean isFreeDeliveryTypeVoucherApplied() {
        return Cart.getInstance().isFreeDeliveryTypeVoucherApplied();
    }

    public boolean isLoyaltyVoucher() {
        return Cart.getInstance().isLoyaltyVoucherApplied();
    }

    public boolean isNormalVoucher() {
        if (Cart.getInstance().isZeroVoucherApplied() || Cart.getInstance().isTalabatDeliveryVoucher()) {
            return false;
        }
        return true;
    }

    public boolean isPickup() {
        return Cart.getInstance().isPickup();
    }

    public boolean isTalabatDelVoucher() {
        return this.isTalabatDelVoucher;
    }

    public boolean isTalabatDeliveryVoucher() {
        if (Cart.getInstance().isZeroVoucherApplied() || !Cart.getInstance().isTalabatDeliveryVoucher()) {
            return false;
        }
        return true;
    }

    public boolean isTokenisationAvailable() {
        if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId() || GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId() || GlobalDataModel.SelectedCountryId == Country.KUWAIT.getCountryId() || GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId() || GlobalDataModel.SelectedCountryId == Country.BAHRAIN.getCountryId() || GlobalDataModel.SelectedCountryId == Country.JORDAN.getCountryId() || GlobalDataModel.SelectedCountryId == Country.EGYPT.getCountryId() || GlobalDataModel.SelectedCountryId == Country.IRAQ.getCountryId()) {
            LogManager.debug("[ALOV]: isTokenisationAvailable :: HIT");
            datamodels.Country selectedCountry = TalabatUtils.getSelectedCountry(this.configurationLocalRepository, this.locationConfigRepository);
            if (selectedCountry == null || !selectedCountry.isTokenisationEnabledCountry) {
                return false;
            }
            return true;
        }
        LogManager.debug("[ALOV]: isTokenisationAvailable :: MISS");
        return false;
    }

    public boolean isVoucherForOnlinePayment() {
        return Cart.getInstance().isOnlySupportsOnlinePayment();
    }

    public boolean isVoucherStackingEnabled() {
        return this.featureFlag.getFeatureFlag(GrowthFeatureFlagConstantKt.FunWithFlagsEnableCompoundingStackedIncentives, false);
    }

    public boolean isZeroVoucher() {
        return Cart.getInstance().isZeroVoucherApplied();
    }

    public void onBinNotAvailable(String str) {
        this.checkoutView.onBinNotAvailable(str);
    }

    public void onBinResponseReceived(BinTokenRM binTokenRM) {
        this.checkoutView.onBinTokenRecieved(binTokenRM.result);
    }

    public void onBinVoucherAvailable(BinResponse binResponse) {
        this.checkoutView.onBinVoucherAvailable(binResponse);
    }

    public void onCashbackResponseError() {
        this.checkoutView.onCashbackResponseError();
    }

    public void onCashbackResponseReceived(CashbackRM cashbackRM) {
        this.checkoutView.onCashbackResponseReceived(cashbackRM);
    }

    public void onDataError() {
        this.checkoutView.onDataError();
    }

    public void onDecryptionDataReceived(DecryptionResponse decryptionResponse) {
        this.checkoutView.onDataDecrypted(decryptionResponse);
    }

    public void onDecryptionErrorOccurred(String str) {
        this.checkoutView.onDataDecryptionFailed(str);
    }

    public void onDeliverySlotClicked() {
        Cart.getInstance().setDarkstoreScheduledDeliveryOptionSelected(true);
        setTaxAndDelivery(Boolean.FALSE);
    }

    public void onDeliveryTimesLoaded(ArrayList<String> arrayList) {
        this.checkoutView.stopLodingPopup();
        if (arrayList == null) {
            onDeliveryTimesNotavailable();
        } else if (arrayList.size() > 0) {
            this.preOrderTimingsAvailable = true;
            this.checkoutView.onDeliveryTimesLoaded(arrayList);
        } else {
            onDeliveryTimesNotavailable();
        }
    }

    public void onDeliveryTimesNotavailable() {
        this.checkoutView.stopLodingPopup();
        this.preOrderTimingsAvailable = false;
        this.checkoutView.onDeliveryTimesNotavailable();
    }

    public void onDestroy() {
        this.checkoutView = null;
        ICheckoutInteractor iCheckoutInteractor = this.checkoutInteractor;
        if (iCheckoutInteractor != null) {
            iCheckoutInteractor.unregister();
        }
        this.checkoutInteractor = null;
        Disposable disposable2 = this.disposable;
        if (disposable2 != null && !disposable2.isDisposed()) {
            this.disposable.dispose();
        }
        Disposable disposable3 = this.darkstoreDeliverySlotsDisposable;
        if (disposable3 != null && !disposable3.isDisposed()) {
            this.darkstoreDeliverySlotsDisposable.dispose();
        }
    }

    public void onEmptyMenuReceived(String str) {
        this.checkoutView.onEmptyMenuReceived(str);
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && restaurant != null && instance.getRestaurant().f13873name.equals(restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.checkoutView.onRedirectToCartPage();
    }

    public void onHideLoader() {
        this.checkoutView.hideLoader();
    }

    public void onLoyaltyVoucherError() {
        this.checkoutView.stopLodingPopup();
    }

    public void onLoyaltyVoucherInfoReceived(LoyaltyVoucherRM loyaltyVoucherRM) {
        updateLoyaltyInfo(loyaltyVoucherRM);
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        this.checkoutView.onRedirectToCartPage();
    }

    public void onMinimumOrderConditionFailed(String str) {
        this.checkoutView.onMinimumOrderConditionForBINFailed(str);
    }

    public void onMobileNumberUpdate(String str) {
        this.checkoutView.updateAddressMobileNumber(str);
    }

    public void onNetworkError() {
        this.checkoutView.stopLodingPopup();
        this.checkoutView.onNetworkError();
    }

    public void onNewAddressSelected(boolean z11) {
        this.isEditAddressFromCheckoutScreen = z11;
        Customer instance = Customer.getInstance();
        if (instance.getSelectedCustomerAddress() == null) {
            LogManager.logException(new Exception("Address become null on new address selection"));
            if (TalabatUtils.isNullOrEmpty(instance.getSelectedCustomerAddressId())) {
                LogManager.logException(new Exception("Address id become null"));
            }
        }
        setDeliveryAddressView(instance.getSelectedCustomerAddress());
        this.checkoutView.onLocationChanged();
    }

    public void onNullResponseReceived() {
        this.checkoutView.stopNonCancelableLoading();
        this.checkoutView.onNullResponseReceived();
    }

    public void onOrderDetailsRecieved(OrderDetails orderDetails) {
        this.checkoutView.onOrderDetailsRecieved(orderDetails);
    }

    public void onOrderNowClicked() {
        Cart.getInstance().setDarkstoreScheduledDeliveryOptionSelected(false);
        setTaxAndDelivery(Boolean.FALSE);
    }

    public void onParallelBinAvailable(boolean z11) {
        CheckoutView checkoutView2 = this.checkoutView;
        if (checkoutView2 != null) {
            checkoutView2.onParallelBinAvailable(z11);
        }
    }

    public void onRedirectToPaymentWebViewWithVisaCheckout(PurchaseResponse purchaseResponse) {
        this.checkoutView.redirectToPaymentWebViewForVisaCheckout(purchaseResponse);
    }

    public void onRequestError() {
        CheckoutView checkoutView2 = this.checkoutView;
        if (checkoutView2 != null) {
            checkoutView2.onRequestError();
        }
    }

    public void onRestaurantListLoaded() {
        this.checkoutView.stopLodingPopup();
        this.checkoutView.onRedirectToRestaurantList();
    }

    public void onRiderTipClosed() {
        if (shouldShowRiderTip()) {
            this.checkoutView.updateSaveTipStatus();
        }
    }

    public void onRiderTipValueChange(Double d11) {
        float f11;
        if (d11 == null) {
            f11 = 0.0f;
        } else {
            f11 = d11.floatValue();
        }
        Cart.getInstance().setRiderTip((double) f11);
        if (d11 == null) {
            this.checkoutView.hideRiderTipCharges();
        } else {
            this.checkoutView.showRiderTipCharges(TalabatFormatter.getInstance().getFormattedCurrency(d11.floatValue(), true));
        }
        if (this.selectedPayementMethod == 3) {
            this.checkoutView.showTalabatCreditView();
        }
        this.checkoutView.setTotalAmount();
    }

    public void onServerError() {
        this.checkoutView.onServerError();
    }

    public void onSubscriptionPlansLoaded(Function1<Boolean, Unit> function1) {
        getTProOrderStatus(new g(this, function1), false, true);
    }

    public void onViewLoaded() {
        if (shouldShowRiderTip()) {
            this.checkoutView.initRiderTipView();
        }
        try {
            if (isPickup()) {
                logPickupCheckoutLoadedEvent();
            }
        } catch (Exception unused) {
        }
    }

    public void onVisaCheckoutDetailsReceived(String str, String str2) {
        this.checkoutInteractor.proceedForVisaCheckout(str, str2);
    }

    public void onVisaCheckoutPaymentErrorWebview(String str) {
        this.checkoutView.onRedirectToPaymentErrorForVisa(str);
    }

    public boolean onlyBinApplied() {
        return Cart.getInstance().hasBinVoucher() && !Cart.getInstance().isVoucherApplied();
    }

    public void payRemainingWithCreditCard() {
        boolean z11;
        if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().selectedCreditCard == null || !Customer.getInstance().selectedCreditCard.isForceCvv) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.isForceCvv = z11;
        if (this.selectedPayementMethod != 3 || !z11 || !TalabatUtils.isNullOrEmpty(this.cvv)) {
            this.placeOrderPresenter.payRemainingWithCreditCard();
        } else {
            this.checkoutView.getCvvForSavedCard(true);
        }
    }

    public void paymentMethodSelected(int i11) {
        setPaymentMethod(i11);
        if (isRiderTipSupportedPaymentMethod(i11)) {
            this.checkoutView.showRiderTipView();
        } else {
            onRiderTipValueChange((Double) null);
            this.checkoutView.hideRiderTipView();
        }
        if (i11 == 3) {
            this.checkoutView.showTalabatCreditView();
        } else {
            this.checkoutView.hideTalabatCreditView();
            this.checkoutView.showCashView();
        }
        this.checkoutView.onPaymentMethodSelected(i11);
    }

    public void paymentSuccessfull() {
        if (this.selectedPayementMethod == 3) {
            try {
                if (Customer.getInstance().isLoggedIn()) {
                    AppTracker.onTalabatCreditUpdated(this.checkoutView.getContext(), String.valueOf(Customer.getInstance().getCustomerInfo().talabatCredit));
                } else {
                    AppTracker.onTalabatCreditUpdated(this.checkoutView.getContext(), "");
                }
            } catch (Exception unused) {
            }
        }
        this.checkoutView.onOrderSucess(this.response);
    }

    public void postDateButtonClicked(boolean z11) {
        this.checkoutView.onPostDatedSelectionChanged(z11);
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (z11 && !this.isDeliverytimeIntervallsLoaded && restaurant != null) {
            this.onDeliveryTimingApiCalled = true;
            ICheckoutInteractor iCheckoutInteractor = this.checkoutInteractor;
            int i11 = restaurant.branchId;
            int i12 = GlobalDataModel.SelectedAreaId;
            iCheckoutInteractor.getDeliveryTimeIntervals(i11, i12, restaurant.statusType + "");
        }
    }

    public void postSubscriptionPayment(CardInformation cardInformation) {
        this.checkoutInteractor.postSubscriptionPayment(cardInformation);
    }

    public void prepareForPlacingOrder(boolean z11, boolean z12, boolean z13, String str, String str2, String str3, boolean z14) {
        boolean z15;
        boolean z16;
        int i11;
        boolean z17;
        String str4;
        boolean z18 = z11;
        boolean z19 = z13;
        LogManager.debug("[ALOV]: prepareForPlacingOrder :: enter");
        Cart instance = Cart.getInstance();
        int i12 = this.selectedPayementMethod;
        String deliveryTime = this.checkoutView.getDeliveryTime();
        instance.getGeneralRequest();
        float f11 = this.payBytalabatCredit;
        this.placeOrderPresenter.setPayBytalabatCredit(f11);
        float f12 = this.payByOther;
        this.placeOrderPresenter.setIsQuickOrder(z19);
        this.placeOrderRequestModel = null;
        this.isCheckoutDotCom = z18;
        String deviceId = TalabatUtils.getDeviceId(this.checkoutView.getContext());
        if (this.fromVisaCheckout) {
            this.additionalPaymentMethod = 1;
        } else {
            this.additionalPaymentMethod = 0;
        }
        int i13 = this.selectedPayementMethod;
        if (i13 == 3) {
            if (this.cashbackEnabled) {
                this.additionalPaymentMethod = 1;
            } else {
                this.additionalPaymentMethod = 0;
            }
        }
        this.additionalPaymentMethod = getAdditionalPaymentMethodForDebitCards(i13, GlobalDataModel.SelectedCountryId);
        logLoyaltyOrderAction(instance);
        AppTracker.onPurchaseInitialised(this.checkoutView.getContext(), AppTracker.getRestaurantId(instance.getRestaurant()), this.selectedPayementMethodForGA, instance.getRestaurant(), this.checkoutView.isContactlessEnabled(), this.defaultPayementMethod, Cart.getInstance().getRiderTip());
        LogManager.debug("[ALOV]: prepareForPlacingOrder :: enter :: init done");
        if (!z19) {
            LogManager.debug("[ALOV]: prepareForPlacingOrder :: not quick enter");
            if (Customer.getInstance().getSelectedCustomerAddress() == null) {
                onValidationError(0, i12, z18);
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: exit - validation error - no selected customer address");
                return;
            }
        }
        if (!this.isPostDatedOrder || !TalabatUtils.isNullOrEmpty(deliveryTime)) {
            LogManager.debug("[ALOV]: prepareForPlacingOrder :: validation done");
            if (!z18 && i12 < 0) {
                onValidationError(2, i12, z18);
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: exit - validation error - no selected payment method");
                return;
            }
            if (i12 == 11) {
                this.additionalPaymentMethod = 11;
                i12 = 2;
            }
            String providePlaceOrderUID = this.placeOrderUIDProvider.providePlaceOrderUID(z19);
            this.isGoGreen = instance.getUserPreferenceForThisOrder().isGoGreen;
            if (z19) {
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside - quick");
                Customer instance2 = Customer.getInstance();
                CustomerInfo customerInfo = new CustomerInfo();
                String str5 = str;
                customerInfo.firstName = str5;
                String str6 = str2;
                customerInfo.lastName = str6;
                customerInfo.mobile = this.address.mobileNumber;
                instance2.setCustomerInfo(customerInfo);
                int i14 = i12;
                z16 = false;
                z15 = true;
                this.placeOrderRequestModel = new PlaceOrderRequestModel(str5, str6, str3, i14, deliveryTime, f11, f12, f12, this.address, instance.getTransactionCart(), z12, providePlaceOrderUID, this.additionalPaymentMethod, this.isGoGreen, deviceId, GlobalDataModel.SelectedCountryId, this.checkoutView.isContactlessEnabled(), instance.getDeliveryMode(), Double.valueOf(Cart.getInstance().getRiderTip()), instance.isDarkstoreScheduledDeliveryDiscountApplied());
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside - quick :: done");
                i11 = 2;
            } else {
                i11 = 2;
                z15 = true;
                float f13 = f12;
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside - pass card bin number");
                passCardValidate();
                if (TalabatUtils.isNullOrEmpty(providePlaceOrderUID)) {
                    Address address2 = this.address;
                    if (address2 != null) {
                        str4 = address2.mobileNumber;
                    } else if (Customer.getInstance().getSelectedCustomerAddress() != null) {
                        str4 = Customer.getInstance().getSelectedCustomerAddress().mobileNumber;
                    } else {
                        str4 = "";
                    }
                    providePlaceOrderUID = str4;
                }
                Address selectedCustomerAddress = Customer.getInstance().getSelectedCustomerAddress();
                TransactionCart transactionCart = instance.getTransactionCart();
                int i15 = this.additionalPaymentMethod;
                boolean z21 = this.isGoGreen;
                int i16 = GlobalDataModel.SelectedCountryId;
                boolean isContactlessEnabled = this.checkoutView.isContactlessEnabled();
                String deliveryMode = instance.getDeliveryMode();
                Double valueOf = Double.valueOf(Cart.getInstance().getRiderTip());
                boolean isDarkstoreScheduledDeliveryDiscountApplied = instance.isDarkstoreScheduledDeliveryDiscountApplied();
                PlaceOrderRequestModel placeOrderRequestModel2 = r6;
                z16 = false;
                PlaceOrderRequestModel placeOrderRequestModel3 = new PlaceOrderRequestModel(i12, deliveryTime, f11, f13, f13, selectedCustomerAddress, transactionCart, z12, providePlaceOrderUID, i15, z21, deviceId, i16, isContactlessEnabled, deliveryMode, valueOf, isDarkstoreScheduledDeliveryDiscountApplied);
                this.placeOrderRequestModel = placeOrderRequestModel2;
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside - pass card bin number :: done");
            }
            if (z18) {
                this.checkoutView.onCallCheckoutDotCom("", false, this.placeOrderRequestModel, this.isTalabatDelVoucher, z14, "");
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: isCheckoutDotCom");
            } else {
                LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom");
                try {
                    this.checkoutView.onPlaceOrderLocalValidataionPassed();
                    if (this.checkoutView.isBinDiscountApplied()) {
                        LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom #1");
                        AppTracker.onBinDiscountApplied(this.checkoutView.getContext(), "existingCard", this.checkoutView.getSelectedCardName());
                    } else {
                        LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom #2");
                        if (Cart.getInstance().binMinimumOrderAmountForTracking > 0.0f) {
                            LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom #3");
                            AppTracker.onBinDiscountExcluded(this.checkoutView.getContext(), Cart.getInstance().binMinimumOrderAmountForTracking);
                            Cart.getInstance().binMinimumOrderAmountForTracking = 0.0f;
                        }
                        LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom #4");
                    }
                    LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom #5");
                    AppTracker.onGoGreenSelected(this.checkoutView.getContext(), this.placeOrderRequestModel.isGoGreen);
                    if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().selectedCreditCard == null || !Customer.getInstance().selectedCreditCard.isForceCvv) {
                        z17 = z16;
                    } else {
                        z17 = z15;
                    }
                    this.isForceCvv = z17;
                    if (this.selectedPayementMethod != i11 || !z17 || !TalabatUtils.isNullOrEmpty(this.cvv)) {
                        LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom #7");
                        this.placeOrderRequestModel.setDarkStore(this.checkoutView.getDarkStoreStatus());
                        this.placeOrderRequestModel.setItemUnavailabilityAction(getCartItemUnavailabilityValue());
                        addAgeLimitToPlaceOrderModel(this.placeOrderRequestModel, getCartAgeLimit());
                        this.checkoutView.showNonCancelableProgress();
                        this.placeOrderPresenter.placeOrder(this.placeOrderRequestModel);
                    } else {
                        LogManager.debug("[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom #6");
                        this.checkoutView.getCvvForSavedCard(z16);
                    }
                } catch (JSONException e11) {
                    LogManager.error(e11, "[ALOV]: prepareForPlacingOrder :: inside :: NOT isCheckoutDotCom :: ERROR");
                    ObservabilityManager.trackUnExpectedScenario("prepareForPlacingOrder failed", new HashMap());
                }
            }
            LogManager.debug("[ALOV]: prepareForPlacingOrder :: exit");
            return;
        }
        onValidationError(1, i12, z18);
        LogManager.debug("[ALOV]: prepareForPlacingOrder :: exit - validation error - no delivery time");
    }

    public void recalculateAppliedVoucher() {
        Cart instance = Cart.getInstance();
        if (instance.isLoyaltyVoucherApplied() && isVoucherStackingEnabled()) {
            instance.calculateLoyaltyDiscount(this.checkoutView.getContext());
        }
    }

    public void recalculateAppliedVoucherIfBinApplied() {
        if (Cart.getInstance().hasBinVoucher()) {
            recalculateAppliedVoucher();
        }
    }

    public void redirectToThankyouPage() {
        PlaceOrderResponse placeOrderResponse = this.response;
        if (placeOrderResponse != null) {
            this.checkoutView.onOrderSucess(placeOrderResponse);
        }
    }

    public void removeInvalidCoupon(boolean z11) {
        this.isPostDatedOrder = z11;
        Cart.getInstance().removeInvalidSelectedCoupon(!this.isPostDatedOrder);
        if (this.isPostDatedOrder) {
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            if (restaurant != null) {
                this.checkoutView.setPaymentView(true, restaurant.isAcceptsDebit(), restaurant.isAcceptsCredit(), isTokenisationAvailable(), getuserHaveSelectedSavedCard(), getTokenProvider(), restaurant.isTalabatGo, restaurant.acceptsCash, isVisaCheckoutEnabled());
                return;
            }
            return;
        }
        this.checkoutView.onRedirectToCartPage();
    }

    public void removeInvalidItems(InvalidItem[] invalidItemArr, boolean z11) {
        this.isPostDatedOrder = z11;
        this.invalidItems = invalidItemArr;
        Cart.getInstance().removeInvalidItems(this.invalidItems);
        Cart.getInstance().recalcualteTotal();
        this.checkoutView.startLodingPopup();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        callMenuApi();
    }

    public void removeInvalidPromotion(boolean z11) {
        this.isPostDatedOrder = z11;
        Cart.getInstance().removeInvalidSelectedPromotion(!this.isPostDatedOrder);
        if (this.isPostDatedOrder) {
            Restaurant restaurant = Cart.getInstance().getRestaurant();
            if (restaurant != null) {
                this.checkoutView.setPaymentView(true, restaurant.isAcceptsDebit(), restaurant.isAcceptsCredit(), isTokenisationAvailable(), getuserHaveSelectedSavedCard(), getTokenProvider(), restaurant.isTalabatGo, restaurant.acceptsCash, isVisaCheckoutEnabled());
                return;
            }
            return;
        }
        this.checkoutView.onRedirectToCartPage();
    }

    public void removeInvalidVoucher(boolean z11) {
        this.isPostDatedOrder = z11;
        removeVoucherFromCart();
        this.checkoutView.setVoucherView();
    }

    public void removeInvalidVouchers() {
        if (Cart.getInstance().isVoucherApplied() && Cart.getInstance().getSavedVoucher() != null && !Cart.getInstance().getSavedVoucher().getMobileNumber().equals(getMobileNumber(true))) {
            Cart.getInstance().removeVoucherIfApplied();
            Cart.getInstance().recalcualteTotal();
        }
    }

    public void removeVoucher() {
        removeVoucherFromCart();
        this.checkoutView.setVoucherView();
    }

    public void removeVoucherFromCart() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        Cart.getInstance().removeLoyaltyVoucherIfAvailable();
        Cart.getInstance().removeVoucherIfApplied();
        Cart.getInstance().recalcualteTotal();
        refreshVoucherViews(restaurant);
    }

    public void sendScheduledDeliveryClickedEvent() {
        this.talabatTracker.track(new ScheduleDeliveryClickedEvent(getVendorId()));
    }

    public void sendScheduledDeliveryClosedEvent() {
        this.talabatTracker.track(new ScheduleDeliveryClosedEvent(getVendorId(), getCustomerCode()));
    }

    public void sendScheduledDeliveryConfirmedEvent(String str) {
        this.talabatTracker.track(new ScheduleDeliveryConfirmedEvent(getVendorId(), getCustomerCode(), str));
    }

    public void sendSubscriptionAttemptedEvent() {
        this.subscriptionsTracker.tProAttempted(this.TPRO_CHECKOUT_SCREEN_TYPE, this.TPRO_CHECKOUT_SCREEN_NAME, this.plansId);
    }

    public void sendSubscriptionCompletedEvent() {
        this.subscriptionsTracker.tProCompleted(this.TPRO_CHECKOUT_SCREEN_TYPE, this.TPRO_CHECKOUT_SCREEN_NAME, this.plansId);
    }

    public void sendSubscriptionFailedEvent() {
        this.subscriptionsTracker.tProFailed(this.TPRO_CHECKOUT_SCREEN_TYPE, this.TPRO_CHECKOUT_SCREEN_NAME, this.plansId);
    }

    public void sendSubscriptionPlanClickedEvent() {
        this.subscriptionsTracker.tProPlanClicked(this.TPRO_CHECKOUT_SCREEN_TYPE, this.TPRO_CHECKOUT_SCREEN_NAME, this.plansId);
    }

    public void sendTransactionFailedEvent(String str) {
        this.talabatTracker.track(new TransactionFailedEvent(this.selectedPayementMethodForGA, str, Cart.getInstance().getRestaurant()));
    }

    public void setAdditionalPaymentMethod(int i11) {
        this.additionalPaymentMethod = i11;
    }

    public void setAddress(Address address2) {
        this.address = address2;
    }

    public void setCashBackAvailable(boolean z11) {
        this.cashbackEnabled = z11;
    }

    public void setCvv(String str, boolean z11) {
        this.cvv = str;
        this.placeOrderPresenter.setCvv(str);
        if (z11) {
            this.placeOrderPresenter.payRemainingWithCreditCard();
        }
    }

    public void setDefaultPaymentMethodForGA(String str) {
        this.defaultPayementMethod = str;
        this.placeOrderPresenter.setDefaultPaymentMethodForGA(str);
    }

    public void setFromVisaCheckout(boolean z11) {
        this.fromVisaCheckout = z11;
        this.placeOrderPresenter.setFromVisaCheckout(z11);
    }

    public void setHideAddCardStatus(boolean z11) {
        this.hideAddCard = z11;
    }

    public void setPaymentMethod(int i11) {
        this.selectedPayementMethod = i11;
        this.placeOrderPresenter.setSelectedPaymentMethod(i11);
    }

    public void setPaymentView(Restaurant restaurant, boolean z11) {
        this.checkoutView.setPaymentView(true, restaurant.isAcceptsDebit(), restaurant.isAcceptsCredit(), isTokenisationAvailable(), getuserHaveSelectedSavedCard(), getTokenProvider(), restaurant.isTalabatGo, restaurant.acceptsCash, isVisaCheckoutEnabled());
    }

    public void setPlaceOrderResponse(PlaceOrderResponse placeOrderResponse) {
        this.response = placeOrderResponse;
    }

    public void setPostDatedOrder(boolean z11) {
        this.isPostDatedOrder = z11;
    }

    @VisibleForTesting
    public void setSelectedPayementMethod(int i11) {
        this.selectedPayementMethod = i11;
    }

    public void setSelectedPaymentMethodForGA(int i11) {
        this.selectedPayementMethodForGA = i11;
        this.placeOrderPresenter.setSelectedPaymentMethodForGA(i11);
        if (Cart.getInstance().getRestaurant() != null) {
            AppTracker.onPaymentMethodSelected(this.checkoutView.getContext(), Cart.getInstance().getRestaurant().f13872id, this.selectedPayementMethodForGA, this.defaultPayementMethod, (int) Cart.getInstance().getCartSubTotal(), Cart.getInstance().getRestaurant());
        }
    }

    public void setTaxAndDelivery(Boolean bool) {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        Cart instance = Cart.getInstance();
        if (restaurant != null) {
            if (!isPickup()) {
                if (!TalabatUtils.isNullOrEmpty(restaurant.altDelChargetxt)) {
                    this.checkoutView.setAltTextDeliveryCharges(restaurant.altDelChargetxt);
                }
                getTProOrderStatus(new h(this, restaurant, instance), bool.booleanValue(), false);
                this.checkoutView.setTotalAmount();
            }
            if (restaurant.getMunicipalityTax() > 0.0f) {
                this.checkoutView.setMuncipalityTaxView(instance.getDisplayMuncipalityTax());
                if (!TalabatUtils.isNullOrEmpty(restaurant.altMunicipalityText)) {
                    this.checkoutView.setAltTextMuncipalityTax(restaurant.altMunicipalityText);
                }
            }
            if (restaurant.getTouristTax() > 0.0f) {
                this.checkoutView.setTouristTaxView(instance.getDispalyTouristTax());
                if (!TalabatUtils.isNullOrEmpty(restaurant.altTouristTaxText)) {
                    this.checkoutView.setAltTextTouristTax(restaurant.altTouristTaxText);
                }
            }
        }
    }

    public void setUpViews(boolean z11, boolean z12, boolean z13, boolean z14) {
        boolean z15;
        this.isQuickOrder = z11;
        this.isEditAddressFromCheckoutScreen = z14;
        if (z11) {
            setDeliveryAddressView(this.address);
        } else {
            Customer.getInstance();
            if (isPickup()) {
                Address address2 = new Address();
                this.address = address2;
                address2.latitude = Cart.getInstance().getRestaurant().latitude;
                this.address.longitude = Cart.getInstance().getRestaurant().longitude;
                setDeliveryAddressView(this.address);
            } else {
                setDeliveryAddressView(Customer.getInstance().getSelectedCustomerAddress());
            }
            if (GlobalDataModel.GEMCONSTANTS.isGemFlow && !GlobalDataModel.GEMCONSTANTS.isGemRedeemed) {
                Cart.getInstance().setGemOfferAmount(GlobalDataModel.GEMCONSTANTS.eligibleGemOfferPrice);
                Cart.getInstance().recalcualteTotal();
            }
        }
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            Cart instance = Cart.getInstance();
            boolean z16 = true;
            if (Cart.getInstance().isPromotionApplied()) {
                CartMenuItem.createWith(Cart.getInstance().getPromotionItem(), true).setQuantity(1);
            }
            CheckoutView checkoutView2 = this.checkoutView;
            if ((instance.getRestaurant().hasPreOrderOnClosed || instance.getRestaurant().statusType == 5) && this.preOrderTimingsAvailable) {
                z15 = true;
            } else {
                z15 = false;
            }
            checkoutView2.setPostDateOrderLayout(z15);
            setTaxAndDelivery(Boolean.FALSE);
            if (GEMEngine.getInstance() != null && GlobalDataModel.GEMCONSTANTS.isGemFlow) {
                GEMEngine.getInstance();
                if (GEMEngine.getEligibleOfferAmount() > 0.0f) {
                    this.checkoutView.setGemOfferCharge();
                }
            }
            if (GlobalDataModel.SelectedCountryId == Country.UAE.getCountryId() || GlobalDataModel.SelectedCountryId == Country.KSA.getCountryId() || GlobalDataModel.SelectedCountryId == Country.QATAR.getCountryId() || GlobalDataModel.SelectedCountryId == Country.OMAN.getCountryId() ? z11 || !this.customerRepository.isTalabatCreditAvailable() || !restaurant.isAcceptsCredit() : z11 || !this.customerRepository.isTalabatCreditAvailable() || !restaurant.isAcceptsDebit()) {
                z16 = false;
            }
            setPaymentView(restaurant, z11);
            if (z16) {
                this.checkoutView.showTalabatCreditView();
            }
            this.checkoutView.setVoucherView();
            if (!TalabatUtils.isNullOrEmpty(restaurant.desclaimer)) {
                this.checkoutView.setDescalimer(restaurant.desclaimer);
            }
            this.checkoutView.setChangeAddressBtn(z12, z13);
            this.checkoutView.setRestaurantName(restaurant.getName());
            this.checkoutView.enableTalabatCreditCashbackView();
        }
    }

    public boolean shouldHideOrderNowForGroceryScheduledDelivery() {
        int i11;
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null || !restaurant.hasPreOrderOnClosed || ((i11 = restaurant.statusType) != 5 && i11 != 1)) {
            return false;
        }
        return true;
    }

    public boolean shouldShowPickupConfirmationDialog(boolean z11) {
        boolean featureFlag2 = this.featureFlag.getFeatureFlag(com.talabat.core.experiment.data.TalabatExperimentConstants.ENABLE_PICKUP_BLOCKING_MODAL, false);
        boolean equals = this.talabatExperiment.getStringVariant(VendorListExperimentsKeys.PICKUP_BLOCKING_MODAL_REVAMP, "Control", TalabatExperimentDataSourceStrategy.FWF).equals("Variation1");
        if (!z11 || !featureFlag2 || !equals) {
            return false;
        }
        return true;
    }

    public boolean shouldShowRiderTip() {
        return !isPickup() && Cart.getInstance().getRestaurant().isTalabatGo;
    }

    public void showBinAvailableNotification(String str) {
    }

    public void showOrderDetails(String str) {
        this.checkoutInteractor.getOrderDetails(str);
    }

    public void showProgress() {
        this.progressCounter++;
        this.checkoutView.showNonCancelableProgress();
    }

    public void showSubscriptionErrorDialog() {
        sendSubscriptionFailedEvent();
        this.checkoutView.showSubscriptionErrorDialog();
    }

    public void tryMoreRestaurantsClicked() {
        if (GlobalDataModel.restaurants == null) {
            this.checkoutView.startLodingPopup();
            this.checkoutInteractor.getRestaurants(Cart.getInstance().getCartAreaId(), Cart.getInstance().getCartCityId(), 0);
            return;
        }
        this.checkoutView.onRedirectToRestaurantList();
    }

    public void updateBranch(int i11, double d11, double d12) {
        Single.fromObservable(this.checkoutInteractor.getRestaurantInfo(i11, d11, d12)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<MenuItemResponse>() {
            public void onError(Throwable th2) {
                CheckoutPresenter.this.hideProgress();
            }

            public void onSubscribe(Disposable disposable) {
                CheckoutPresenter.this.disposable = disposable;
            }

            public void onSuccess(MenuItemResponse menuItemResponse) {
                MenuItemsResponseModel menuItemsResponseModel;
                Restaurant restaurant;
                CheckoutPresenter.this.hideProgress();
                if (menuItemResponse != null && (menuItemsResponseModel = menuItemResponse.result) != null && (restaurant = menuItemsResponseModel.restaurant) != null) {
                    Restaurant restaurant2 = GlobalDataModel.SELECTED.restaurant;
                    if (restaurant2 != null && restaurant.f13872id == restaurant2.f13872id) {
                        restaurant.setRecommendation(restaurant2.isRecommendation());
                        Restaurant restaurant3 = menuItemResponse.result.restaurant;
                        Restaurant restaurant4 = GlobalDataModel.SELECTED.restaurant;
                        restaurant3.itemPosition = restaurant4.itemPosition;
                        restaurant3.swimlanePosition = restaurant4.swimlanePosition;
                    } else if (restaurant2 == null) {
                        ObservabilityManager.trackUnExpectedScenario("dps info global Restaurant null in CheckoutPresenter", new HashMap());
                    }
                    menuItemResponse.result.restaurant.setPickup(Boolean.valueOf(Cart.getInstance().isPickup()));
                    menuItemResponse.result.restaurant.setPickupDistanceInKm(GlobalDataModel.SELECTED.getRestaurant().getPickupDistanceKm());
                    GlobalDataModel.SELECTED.updateRestaurant(menuItemResponse.result.restaurant);
                    Cart.getInstance().setRestaurant(menuItemResponse.result.restaurant);
                    CheckoutPresenter.this.setTaxAndDelivery(Boolean.FALSE);
                    Cart.getInstance().recalcualteTotal();
                    CheckoutPresenter.this.checkoutView.setTotalAmount();
                } else if (menuItemResponse == null) {
                    ObservabilityManager.trackUnExpectedScenario("info api MenuItemResponse null in CheckoutPresenter", new HashMap());
                } else {
                    MenuItemsResponseModel menuItemsResponseModel2 = menuItemResponse.result;
                    if (menuItemsResponseModel2 == null) {
                        ObservabilityManager.trackUnExpectedScenario("info api MenuItemsResponseModel null in CheckoutPresenter", new HashMap());
                    } else if (menuItemsResponseModel2.restaurant == null) {
                        ObservabilityManager.trackUnExpectedScenario("info api Restaurant null in CheckoutPresenter", new HashMap());
                    }
                }
            }
        });
    }

    public void updateLoyaltyInfo(LoyaltyVoucherRM loyaltyVoucherRM) {
        CheckoutView checkoutView2 = this.checkoutView;
        if (checkoutView2 != null) {
            checkoutView2.stopLodingPopup();
            Cart instance = Cart.getInstance();
            instance.saveLoyaltyVoucher(this.checkoutView.getContext(), loyaltyVoucherRM);
            instance.calculateLoyaltyDiscount(this.checkoutView.getContext());
            instance.setVoucherRedeemedinCheckout(true);
            instance.recalcualteTotal();
            refreshVoucherViews(instance.getRestaurant());
            this.checkoutView.onLoyaltyVoucherInfoReceived(loyaltyVoucherRM);
        }
    }

    public void updateMobileNumber(String str) {
        if (this.address != null && !TalabatUtils.isNullOrEmpty(str)) {
            this.address.mobileNumber = str;
        }
    }

    public void usePaymentResult(SubscriptionPaymentStatus subscriptionPaymentStatus) {
        sendSubscriptionCompletedEvent();
        this.checkoutView.hideTProSubscriptionBanner(Boolean.valueOf(subscriptionPaymentStatus.getResult().isSubscribed()));
        this.checkoutView.makePaymentForPlaceOrder();
    }

    public void onServerError(VolleyError volleyError) {
        this.checkoutView.onServerError(volleyError);
    }

    private boolean areLocationsDifferent(Address address2, LatLng latLng) {
        if (address2 == null || latLng == null || ((double) HomeMapUtils.INSTANCE.distanceBetween(address2.latitude, address2.longitude, latLng.latitude, latLng.longitude)) > 0.0d) {
            return true;
        }
        return false;
    }
}
