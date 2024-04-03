package library.talabat.mvp.cart;

import JsonModels.MenuItemRM;
import JsonModels.MenuItemsResponseModel;
import JsonModels.Request.McdBlockMapGrlUpdateRequest;
import JsonModels.Request.McdBranchRequest;
import JsonModels.Response.CustomerAddressInfoJsonResult;
import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherRM;
import JsonModels.Response.McdStoresResponse;
import JsonModels.Response.ShopStatus.ShopStatusResponse;
import JsonModels.Response.UpsellingResponse;
import JsonModels.RestaurantReviewResponse;
import JsonModels.parser.UniversalGson;
import a10.b;
import a10.c;
import a10.d;
import a10.e;
import a10.f;
import a10.g;
import a10.h;
import a10.i;
import a10.j;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import androidx.annotation.VisibleForTesting;
import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.Customer;
import buisnessmodels.GEMEngine;
import buisnessmodels.McdMapTempAddress;
import buisnessmodels.TalabatFormatter;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import com.android.volley.VolleyError;
import com.designsystem.ds_input_field.DateInputField;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.country.Country;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.experiment.domain.ITalabatExperiment;
import com.talabat.core.experiment.domain.TalabatExperimentDataSourceStrategy;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt;
import com.talabat.core.fwfprojectskeys.domain.projects.ordering.OrderingFeatureFlagsKeys;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QcommerceExperimentsKeys;
import com.talabat.customer.domain.CustomerRepository;
import com.talabat.domain.address.Address;
import com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.feature.subscriptions.domain.model.TProOrderStatus;
import com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.UserAction;
import com.talabat.observability.common.ViewStatus;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CampaignVoucher;
import datamodels.CartMenuItem;
import datamodels.ChoiceItem;
import datamodels.ChoiceSection;
import datamodels.CustomerInfo;
import datamodels.MenuItem;
import datamodels.MenuSection;
import datamodels.QuickOrderInfo;
import datamodels.RatingSection;
import datamodels.Restaurant;
import datamodels.RestaurantReview;
import datamodels.RestaurantReviewPaging;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase;
import tracking.AppTracker;
import tracking.ScreenNames;
import xq.a;

@Instrumented
public class CartPresenter implements ICartPresenter, CartListener, CartAdapterListener {
    private static final String BUSYPOPUP_ERROR_MESSAGE = "Cart restaurant null in busy popup in cart screen";
    private static final String BUSYPOPUP_PROCEED_TO_CHECKOUT = "proceed to checkout view";
    private static final String BUSYPOPUP_RECOMMENDED_RESTAURANT = "recommended restaurant";
    private static final String BUSYPOPUP_VIEW_SIMILAR = "view similar restaurants button";
    private static final String INCONSISTENCY_IN_CART_ITEMS_ATTRIBUTE_KEY = "inconsistency in cart items";
    private static final String QC_NFV_EXPERIMENT_VARIATION1 = "Variation1";
    private static final String REORDER_ITEM_MISSING_VIEW_ATTRIBUTE_KEY = "message displayed";
    private static final String REORDER_ITEM_MISSING_VIEW_BODY = "Item missing notification";
    private static final String REORDER_ITEM_MISSING_VIEW_CLOSE_BUTTON = "Item missing notification close button";
    private boolean addMoreItemButtonClicked;
    private final AppVersionProvider appVersionProvider;
    private final CanCheckComplianceStatusOfUserDelegate canCheckComplianceStatusOfUserDelegate;
    private ICartInteractor cartInteractor;
    private final CartUtility cartUtility;
    private CartView cartView;
    private final ConfigurationLocalRepository configurationLocalRepository;
    private float couponRefreshedAmount;
    private final CustomerRepository customerRepository;
    private final DiscoveryConfigurationRepository discoveryConfigurationRepository;
    private CompositeDisposable disposable;
    private final ITalabatFeatureFlag featureFlag;
    private final GetTProOrderStatusUseCase getTProOrderStatusUseCase;
    private Scheduler ioScheduler;
    private boolean isCartFlow;
    private boolean isForceMapFromRestaurant;
    private final Callable<Boolean> isGemActive;
    private boolean isGlrRestaurant;
    private boolean isMapcompulsory;
    private boolean isNineCookiesTrackingEnabled;
    private boolean isNineCookiesTrackingEnabledFromAddress;
    private boolean isNonCombinationalItemPresent;
    private boolean isOneAddressUpdate;
    private boolean isRestaurantTrackOrder;
    private boolean isTalabatDevliveryAvailable;
    private boolean issMapFirstReDirectCheckout;
    private final LocationConfigurationRepository locationConfigRepository;
    private Scheduler mainScheduler;
    private boolean mcdKsaAddressUpdateIgnore;
    private final OrderExperienceConfigurationRepository orderExperienceConfigurationRepository;
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    private RatingSection ratingSection;
    private int restId;
    private RestaurantReviewPaging[] restaurantReviews;
    private final SelectSavedAddressIfCanDeliverToVendorUseCase selectSavedAddressIfCanDeliverToVendorUseCase;
    Address selectedAddress;
    private MutableLiveData<Boolean> showBusyPopup;
    private final ISubscriptionStatusRepository subscriptionStatusRepository;
    private final ITalabatExperiment talabatExperiment;
    private int totalPages;
    private int totalReviews;

    public interface CanCheckComplianceStatusOfUserDelegate {
        boolean canCheckComplianceStatusOfUser();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CartPresenter(library.talabat.mvp.cart.CartView r22, com.talabat.user.address.domain.repository.CustomerAddressesRepository r23, com.talabat.customer.domain.CustomerRepository r24, com.talabat.configuration.ConfigurationLocalRepository r25, com.talabat.configuration.location.LocationConfigurationRepository r26, com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCase r27, io.reactivex.Scheduler r28, io.reactivex.Scheduler r29, java.util.concurrent.Callable<java.lang.Boolean> r30, library.talabat.mvp.cart.CartPresenter.CanCheckComplianceStatusOfUserDelegate r31, library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase r32, com.talabat.core.featureflag.domain.ITalabatFeatureFlag r33, com.talabat.core.experiment.domain.ITalabatExperiment r34, com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase r35, com.talabat.configuration.discovery.DiscoveryConfigurationRepository r36, com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository r37, com.talabat.configuration.payment.PaymentConfigurationRepository r38, library.talabat.mvp.cart.CartUtility r39, com.talabat.feature.incentiveautoapplydiscounts.domain.GetAutoApplyDiscountsUseCase r40, com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper r41, com.talabat.configuration.discovery.AppVersionProvider r42, com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository r43) {
        /*
            r21 = this;
            r7 = r21
            r0 = r21
            r1 = r22
            r19 = r24
            r16 = r25
            r17 = r26
            r2 = r28
            r3 = r29
            r4 = r30
            r5 = r31
            r6 = r32
            r8 = r33
            r9 = r34
            r10 = r35
            r11 = r36
            r12 = r37
            r13 = r38
            r14 = r39
            r15 = r42
            r18 = r43
            r20 = 0
            r7 = r20
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            library.talabat.mvp.cart.CartInteractor r14 = new library.talabat.mvp.cart.CartInteractor
            datamodels.mappers.AutoApplyDiscountMapper r11 = new datamodels.mappers.AutoApplyDiscountMapper
            r11.<init>()
            r0 = r14
            r1 = r21
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r26
            r6 = r27
            r7 = r33
            r8 = r28
            r9 = r29
            r10 = r40
            r12 = r41
            r13 = r42
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r0 = r21
            r0.cartInteractor = r14
            buisnessmodels.Cart r1 = buisnessmodels.Cart.getInstance()
            boolean r1 = r1.hasItems()
            if (r1 == 0) goto L_0x0071
            library.talabat.mvp.cart.ICartInteractor r1 = r0.cartInteractor
            buisnessmodels.Cart r2 = buisnessmodels.Cart.getInstance()
            datamodels.Restaurant r2 = r2.getRestaurant()
            int r2 = r2.getId()
            r1.getCampaignVoucher(r2)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.cart.CartPresenter.<init>(library.talabat.mvp.cart.CartView, com.talabat.user.address.domain.repository.CustomerAddressesRepository, com.talabat.customer.domain.CustomerRepository, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.location.LocationConfigurationRepository, com.talabat.location.area.domain.usecases.UpdateAreaOfSelectedAddressIfChangedUseCase, io.reactivex.Scheduler, io.reactivex.Scheduler, java.util.concurrent.Callable, library.talabat.mvp.cart.CartPresenter$CanCheckComplianceStatusOfUserDelegate, library.talabat.mvp.login.domain.usecases.SelectSavedAddressIfCanDeliverToVendorUseCase, com.talabat.core.featureflag.domain.ITalabatFeatureFlag, com.talabat.core.experiment.domain.ITalabatExperiment, com.talabat.feature.subscriptions.domain.usecase.GetTProOrderStatusUseCase, com.talabat.configuration.discovery.DiscoveryConfigurationRepository, com.talabat.configuration.orderexperience.OrderExperienceConfigurationRepository, com.talabat.configuration.payment.PaymentConfigurationRepository, library.talabat.mvp.cart.CartUtility, com.talabat.feature.incentiveautoapplydiscounts.domain.GetAutoApplyDiscountsUseCase, com.talabat.feature.subscriptions.domain.wrapper.GetActiveSubscriptionsRxWrapper, com.talabat.configuration.discovery.AppVersionProvider, com.talabat.feature.subscriptions.domain.ISubscriptionStatusRepository):void");
    }

    private void callMenuApi() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        if (restaurant.shopType == 1) {
            GlobalDataModel.JSON.groceryMenuLoaded.setValue(Boolean.FALSE);
            this.cartInteractor.getGroceryMenu(restaurant);
            return;
        }
        MenuResponseMapper.INSTANCE.clear();
        this.cartInteractor.getRestaurantInfoOnly(restaurant);
        this.cartInteractor.getRestaurantMenuOnly(restaurant);
    }

    private boolean canNFVNavigateToFlutterMenu() {
        Restaurant restaurant;
        if (isQCNFVNavigationToFlutterFoodMenuEnabled() && (restaurant = GlobalDataModel.SELECTED.getRestaurant()) != null && !restaurant.isMigrated && !restaurant.isDarkStore) {
            return true;
        }
        return false;
    }

    private void checkWithStoresAvailableSelectedAddress(Address address, boolean z11) {
        this.cartView.startLodingPopup();
        int i11 = Cart.getInstance().getRestaurant().f13872id;
        this.restId = i11;
        this.cartInteractor.getMcdLatLngStoresCheck(new McdBranchRequest(address, i11), z11);
    }

    private boolean deselectAddress() {
        if (Customer.getInstance() == null || GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION == GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW) {
            return false;
        }
        return true;
    }

    private String getBranchId() {
        if (Cart.getInstance().getRestaurant() != null) {
            return String.valueOf(Cart.getInstance().getRestaurant().branchId);
        }
        return "";
    }

    private List<Integer> getChoicesIds(ArrayList<ChoiceSection> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() == 0) {
            return arrayList2;
        }
        Iterator<ChoiceSection> it = arrayList.iterator();
        while (it.hasNext()) {
            Iterator<ChoiceItem> it2 = it.next().itemChoices.iterator();
            while (it2.hasNext()) {
                arrayList2.add(Integer.valueOf(it2.next().f13839id));
            }
        }
        return arrayList2;
    }

    private float getDeliveryChargeTier() {
        return Cart.getInstance().calculateDeliveryCharges();
    }

    private String getDisplayDeliveryCharge() {
        return Cart.getInstance().getDeliveryChargesDisplayPrice();
    }

    private String getDisplayTalabatCharge() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant != null) {
            return restaurant.getDisplayTalabatCharge();
        }
        return "";
    }

    private String getFormattedDateOfBirth(CustomerInfo customerInfo) {
        try {
            Locale locale = Locale.US;
            Date parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", locale).parse(customerInfo.birthday);
            if (parse != null) {
                return new SimpleDateFormat(DateInputField.DefaultDateFormat, locale).format(parse);
            }
            return "";
        } catch (Exception e11) {
            LogManager.logException(e11);
            return "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getMobileNumberForGuestUser(boolean r6) {
        /*
            r5 = this;
            library.talabat.mvp.cart.CartView r0 = r5.cartView
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
        throw new UnsupportedOperationException("Method not decompiled: library.talabat.mvp.cart.CartPresenter.getMobileNumberForGuestUser(boolean):java.lang.String");
    }

    private void getParallelBin() {
        if (!isGemActive().booleanValue() && this.paymentConfigurationRepository.config().isBinCampAvailable() && !getParallelBinNotificationShown()) {
            this.cartInteractor.getAllBinOffers();
        }
    }

    private void grlUpdateIsRequired(Address address) {
        Cart.getInstance();
        Cart.getSavedMcdCartAddress(this.cartView.getContext());
        if (McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() != null && !TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().grlid)) {
            if (TalabatUtils.isNullOrEmpty(address.grlid)) {
                updateGrlBlock(address);
            } else if (!address.grlid.equals(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().grlid)) {
                updateGrlBlock(address);
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleErrorFromSelectSavedAddress(Throwable th2) {
        LogManager.logException(th2);
        confirmButtonPressed(Cart.getInstance().getRestaurant(), this.cartView.getContext(), true, false, true, false, false);
    }

    /* access modifiers changed from: private */
    public void handleResultFromSelectSavedAddress(SelectSavedAddressIfCanDeliverToVendorUseCase.Result result) {
        if (result instanceof SelectSavedAddressIfCanDeliverToVendorUseCase.Result.Successful) {
            confirmButtonPressed(Cart.getInstance().getRestaurant(), this.cartView.getContext(), true, false, true, false, false);
        } else if (result instanceof SelectSavedAddressIfCanDeliverToVendorUseCase.Result.Failed) {
            LogManager.error((Throwable) null, ((SelectSavedAddressIfCanDeliverToVendorUseCase.Result.Failed) result).getError());
            confirmButtonPressed(Cart.getInstance().getRestaurant(), this.cartView.getContext(), true, false, true, false, false);
        } else if (result instanceof SelectSavedAddressIfCanDeliverToVendorUseCase.Result.ShouldSelectAddressManually) {
            onResultFromLoginScreenForAddressList();
        }
    }

    private boolean hasBlock(Address address) {
        return address != null && !TalabatUtils.isNullOrEmpty(address.block);
    }

    private boolean hasGrlId(Address address) {
        return address != null && !TalabatUtils.isNullOrEmpty(address.grl);
    }

    private boolean hasMcdLatitudeLongitude(Address address) {
        if (address == null || TalabatUtils.isNullOrEmptyLatLng(address.latitude, address.longitude)) {
            return false;
        }
        return true;
    }

    private boolean isAddressUpdateRequired(Address address) {
        Cart.getInstance();
        Cart.getSavedMcdCartAddress(this.cartView.getContext());
        if (address == null || McdMapTempAddress.getInstance().getSelectedGrlTempAddress() == null) {
            return false;
        }
        if (TalabatUtils.isNullOrEmpty(address.getGrlId()) || TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedGrlTempAddress().getGrlId()) || !address.getGrlId().equals(McdMapTempAddress.getInstance().getSelectedGrlTempAddress().getGrlId())) {
            return true;
        }
        return false;
    }

    private boolean isCheckoutEnofrceMap(boolean z11, boolean z12) {
        boolean z13 = false;
        if (this.isNineCookiesTrackingEnabledFromAddress) {
            this.isMapcompulsory = false;
        } else {
            if (this.isRestaurantTrackOrder || this.isNineCookiesTrackingEnabled) {
                z13 = true;
            }
            this.isMapcompulsory = z13;
        }
        return this.isMapcompulsory;
    }

    private boolean isComplianceConsentEnabledCountry() {
        Country selectedCountry = this.configurationLocalRepository.selectedCountry();
        com.talabat.configuration.location.Country country = null;
        for (com.talabat.configuration.location.Country next : this.locationConfigRepository.countries()) {
            if (selectedCountry.getCountryId() == next.getCountry().getCountryId()) {
                country = next;
            }
        }
        if (country == null || !country.isComplianceEnabled()) {
            return false;
        }
        return true;
    }

    private Boolean isGemActive() {
        return (Boolean) Single.fromCallable(this.isGemActive).blockingGet();
    }

    private boolean isGrlEnabledRes(boolean z11) {
        if (!z11 || (!TalabatUtils.isMcdInforMapEnabledCountry() && !TalabatUtils.isMcdBlockMenuEnabledCountry() && !TalabatUtils.isMcdLatLngEnabledCountry())) {
            return false;
        }
        return z11;
    }

    private boolean isGrlIdEnforce(Address address) {
        return address != null && !TalabatUtils.isNullOrEmpty(address.getGrlId());
    }

    private boolean isGuestUserInfoAvailable() {
        Object obj;
        SharedPreferences sharedPreferences = this.cartView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
        Gson gson = UniversalGson.INSTANCE.gson;
        if (sharedPreferences.contains("" + GlobalDataModel.SelectedAreaId)) {
            String string = sharedPreferences.getString("" + GlobalDataModel.SelectedAreaId, "");
            Class cls = QuickOrderInfo.class;
            if (!(gson instanceof Gson)) {
                obj = gson.fromJson(string, cls);
            } else {
                obj = GsonInstrumentation.fromJson(gson, string, cls);
            }
            QuickOrderInfo quickOrderInfo = (QuickOrderInfo) obj;
            if (quickOrderInfo == null || quickOrderInfo.address == null) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean isLoyaltyVoucherAvailable() {
        return Cart.getInstance().isLoyaltyAvailable();
    }

    private boolean isMcdBlockAddressUpdateRequired(Address address) {
        Cart.getInstance();
        Cart.getSavedMcdCartAddress(this.cartView.getContext());
        if (address == null || McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress() == null) {
            return false;
        }
        if (TalabatUtils.isNullOrEmpty(address.block) || TalabatUtils.isNullOrEmpty(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().block) || !address.block.equals(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().block)) {
            return true;
        }
        return false;
    }

    private boolean isMcdLatitudeLongitudeUpdateAddressUpdateRequired() {
        return this.mcdKsaAddressUpdateIgnore;
    }

    private boolean isQCNFVNavigationToFlutterFoodMenuEnabled() {
        return "Variation1".equals(this.talabatExperiment.getStringVariant(QcommerceExperimentsKeys.QCOMMERCE_NFV_NAVIGATE_TO_FLUTTER_FOOD_MENU, "", TalabatExperimentDataSourceStrategy.FWF));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$setViews$1() {
        setViewsIfCartHasItems();
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$subscribeToSubtotalChanges$0(Float f11) throws Exception {
        return f11.floatValue() != 0.0f;
    }

    /* access modifiers changed from: private */
    public void logError(Throwable th2) {
        String str;
        if (TalabatUtils.isNullOrEmpty(th2.getMessage())) {
            str = "Shop Status API error in Cart Screen";
        } else {
            str = "Shop Status API error in Cart Screen -> " + th2.getMessage();
        }
        ObservabilityManager.trackUnExpectedScenario(str, new HashMap());
    }

    private Observable<ShopStatusResponse> requestShopStatus(String str) {
        boolean z11;
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant == null || !restaurant.isPickup().booleanValue()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return this.cartInteractor.getShopStatus(str, GlobalDataModel.LATLONGFORAPI.getLatitude(), GlobalDataModel.LATLONGFORAPI.getLongitude(), z11);
    }

    private boolean restaurantHasDeliveryChargesTiers() {
        Cart instance = Cart.getInstance();
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return false;
        }
        if (instance.calculateDeliveryCharges() >= 0.0f && restaurant.getTalabatCharges() <= 0.0f) {
            return true;
        }
        instance.setNewDeliveryCharge(-1.0f);
        return false;
    }

    private boolean restaurantHasTalabatCharge() {
        if (Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().talabatCharges <= 0.0f) {
            return false;
        }
        return true;
    }

    private void setViewsIfCartHasItems() {
        Cart instance = Cart.getInstance();
        getParallelBin();
        getBinTokens();
        this.cartView.setRestaurantName(Cart.getInstance().getRestaurant().getName(), instance.getCartAreaName());
        this.cartView.notifyRecyclerViewFooter();
        Customer instance2 = Customer.getInstance();
        if (!GlobalDataModel.Apptimize.MapInFunnelEnabled && instance2.isLoggedIn()) {
            loadCustomerDetailsBackground();
        }
        if (instance.getRestaurant().isCokeRestaurant && instance.getUpsellingItemCount() == 0) {
            this.cartInteractor.loadUpSellingItems(instance.getRestaurant());
        }
        if (!GlobalDataModel.GEMCONSTANTS.isGemFlow) {
            loadCouponsAndPromotions(instance.getRestaurant().getBranchId(), Cart.getInstance().getCartSubTotal(), instance.getRestaurant());
            if (isLoyaltyVoucherAvailable()) {
                Cart.getInstance().calculateLoyaltyDiscount(this.cartView.getContext());
            }
        } else if (GEMEngine.getInstance() != null) {
            GEMEngine.getInstance().supressCouponsAndPromotionForCart();
        }
    }

    private void startProgress() {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            cartView2.showNonCancelableProgress();
        }
    }

    /* access modifiers changed from: private */
    public void stopProgress() {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            cartView2.stopNonCancelableLoading();
        }
    }

    private void subscribeToSubtotalChanges() {
        CompositeDisposable compositeDisposable = this.disposable;
        Flowable<Float> filter = Cart.getInstance().getCartSubTotalObservable().filter(new d());
        CartView cartView2 = this.cartView;
        Objects.requireNonNull(cartView2);
        compositeDisposable.add(filter.subscribe(new e(cartView2), new a()));
    }

    private void updateGrlBlock(Address address) {
        Customer.getInstance().updateAddressGrl(address.f58343id, McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().grl, McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().grlid);
        this.cartInteractor.updateSelectedAddressGrl(new McdBlockMapGrlUpdateRequest(McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().grl, McdMapTempAddress.getInstance().getSelectedMcdBlockTempAddress().grlid, address.f58343id));
    }

    public void addMoreItemsClicked(Restaurant restaurant, String str) {
        if (restaurant != null) {
            AppTracker.onAddMoreItemClicked(this.cartView.getContext(), AppTracker.getRestaurantId(restaurant));
            this.addMoreItemButtonClicked = true;
            if (GlobalDataModel.SELECTED.getRestaurant() == null || !Cart.getInstance().isRestaurantCart(GlobalDataModel.SELECTED.getRestaurant())) {
                GlobalDataModel.SELECTED.updateRestaurant(restaurant);
                this.cartView.onMenuLoadingStarted();
                GlobalDataModel.MENU.doNotLoad = true;
                if (ChoiceLoader.getInstance() != null) {
                    ChoiceLoader.stopChoiceLoader();
                }
                callMenuApi();
            } else if (GlobalDataModel.SELECTED.getRestaurant().shopType != 1) {
                handleMenuNavigation();
            } else if (canNFVNavigateToFlutterMenu()) {
                this.cartView.navigateToFlutterMenu();
            } else {
                this.cartView.onRedirectToGroceryMenuPage();
            }
        } else {
            ObservabilityManager.trackUnExpectedScenario("Cart restaurant is null in " + str, new HashMap());
        }
    }

    public void addUpsellingItem(MenuItem menuItem) {
        Cart instance = Cart.getInstance();
        this.cartUtility.addItem(instance.addUpsellingItem(menuItem, this.cartView.getContext()), instance.getRestaurant().getBranchId(), instance.getDeliveryMode());
        this.cartView.onGemEnabledItemUpdated();
        this.cartView.notifyRecyclerViewFooter();
        loadCouponsAndPromotions(instance.getRestaurant().getBranchId(), Cart.getInstance().getCartSubTotal(), instance.getRestaurant());
        if (isLoyaltyVoucherApplied()) {
            Cart.getInstance().calculateLoyaltyDiscount(this.cartView.getContext());
        }
    }

    public void clearShowBusyPopup() {
        this.showBusyPopup.postValue(null);
    }

    public void closeReorderStatusView() {
        ObservabilityManager.trackEvent("Cart Screen", REORDER_ITEM_MISSING_VIEW_CLOSE_BUTTON, UserAction.TAP, (Map<String, String>) new HashMap());
        Cart.getInstance().clearReorderStatus();
    }

    public void confirmButtonPressed(Restaurant restaurant, Context context, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        Restaurant restaurant2 = restaurant;
        boolean z16 = z11;
        this.mcdKsaAddressUpdateIgnore = z13;
        this.isOneAddressUpdate = false;
        boolean z17 = restaurant2.isForceMap;
        this.isRestaurantTrackOrder = z17;
        this.isForceMapFromRestaurant = z17;
        this.isNineCookiesTrackingEnabled = restaurant2.isNineCookiesEnabledRestaurant;
        this.isNineCookiesTrackingEnabledFromAddress = z12;
        this.isTalabatDevliveryAvailable = restaurant2.isTalabatGo;
        this.isGlrRestaurant = restaurant2.isGlrEnabled;
        this.issMapFirstReDirectCheckout = z14;
        if (Cart.getInstance().isMinimumOrderAmountPassed()) {
            Customer instance = Customer.getInstance();
            if (!instance.isLoggedIn()) {
                redirectToLogin();
            } else if (!isComplianceConsentEnabledCountry() || z15 || !this.canCheckComplianceStatusOfUserDelegate.canCheckComplianceStatusOfUser()) {
                Address selectedCustomerAddress = instance.getSelectedCustomerAddress();
                if (isPickup()) {
                    this.cartView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
                } else if (selectedCustomerAddress == null || selectedCustomerAddress.areaId != GlobalDataModel.SelectedAreaId) {
                    this.isOneAddressUpdate = true;
                    this.isCartFlow = z16;
                    instance.deselectCustomerAddress(this.cartView.getContext());
                    this.cartView.startLodingPopup();
                    loadCustomerDetails();
                } else if (isGrlEnabledRes(this.isGlrRestaurant)) {
                    Cart.getInstance().saveMcdAddressCartToPrefs(this.cartView.getContext());
                    if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                        if (!hasGrlId(selectedCustomerAddress)) {
                            this.cartView.isGrlRestaurantRedirect(selectedCustomerAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isAddressUpdateRequired(selectedCustomerAddress), true);
                        } else if (isAddressUpdateRequired(selectedCustomerAddress)) {
                            this.cartView.isGrlRestaurantRedirect(selectedCustomerAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isAddressUpdateRequired(selectedCustomerAddress), true);
                        } else {
                            this.cartView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, true, false);
                        }
                    } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                        if (!hasBlock(selectedCustomerAddress)) {
                            this.cartView.isGrlRestaurantRedirect(selectedCustomerAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdBlockAddressUpdateRequired(selectedCustomerAddress), true);
                        } else if (isMcdBlockAddressUpdateRequired(selectedCustomerAddress)) {
                            this.cartView.isGrlRestaurantRedirect(selectedCustomerAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdBlockAddressUpdateRequired(selectedCustomerAddress), true);
                        } else {
                            grlUpdateIsRequired(selectedCustomerAddress);
                            this.cartView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, true, false);
                        }
                    } else if (TalabatUtils.isMcdLatLngEnabledCountry()) {
                        this.isCartFlow = z16;
                        if (!hasMcdLatitudeLongitude(selectedCustomerAddress)) {
                            this.cartView.isGrlRestaurantRedirect(selectedCustomerAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdLatitudeLongitudeUpdateAddressUpdateRequired(), true);
                        } else if (isMcdLatitudeLongitudeUpdateAddressUpdateRequired()) {
                            this.selectedAddress = selectedCustomerAddress;
                            checkWithStoresAvailableSelectedAddress(selectedCustomerAddress, false);
                        } else {
                            this.cartView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, true, false);
                        }
                    }
                } else {
                    HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                    if (homeMapTemp.getUpdateAddressNotSaved() && homeMapTemp.getHomeMapSavedLatLng() != null) {
                        this.cartView.mapFirstRedirect(selectedCustomerAddress, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, z11, false, false, z14);
                    } else if (homeMapTemp.getHomeMapSavedLatLng() != null && homeMapTemp.getEnabledHomeMapRedirectEnabled()) {
                        this.cartView.mapFirstRedirect(selectedCustomerAddress, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, z11, false, false, z14);
                    } else if (enforceMapForCoordinates(selectedCustomerAddress, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
                        this.cartView.isMapCompulsory(selectedCustomerAddress, enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
                    } else {
                        this.isCartFlow = z16;
                        this.cartView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
                    }
                }
            } else {
                CustomerInfo customerInfo = instance.getCustomerInfo();
                this.cartView.showUserVerifyicationView(customerInfo.firstName, customerInfo.lastName, getFormattedDateOfBirth(customerInfo));
            }
        } else {
            this.cartView.showMinimumOrderAmountPopup();
        }
    }

    public void decreaseQuantity(CartMenuItem cartMenuItem) {
        int quantity = cartMenuItem.getQuantity() - 1;
        if (quantity > 0) {
            Cart instance = Cart.getInstance();
            instance.setQuantity(cartMenuItem, quantity);
            instance.recalcualteTotal();
            this.cartView.onGemEnabledItemUpdated();
            this.cartView.notifyRecyclerViewFooter();
            AppTracker.onItemRemovedFromCart(this.cartView.getContext(), Cart.getInstance().getRestaurant(), cartMenuItem, "cart_modify", ScreenNames.getScreenType(this.cartView.getScreenName()), this.cartView.getScreenName());
            loadCouponsAndPromotions(instance.getRestaurant().getBranchId(), Cart.getInstance().getCartSubTotal(), instance.getRestaurant());
            if (isLoyaltyVoucherApplied()) {
                Cart.getInstance().calculateLoyaltyDiscount(this.cartView.getContext());
            }
        }
        updateQuantity(cartMenuItem, quantity);
    }

    public boolean disableGeneralRequest(Restaurant restaurant) {
        if (restaurant != null) {
            return restaurant.disableGeneralRequest;
        }
        return false;
    }

    public void editCartCompleted() {
        Cart instance = Cart.getInstance();
        loadCouponsAndPromotions(instance.getRestaurant().getBranchId(), Cart.getInstance().getCartSubTotal(), instance.getRestaurant());
        if (isLoyaltyVoucherApplied()) {
            Cart.getInstance().calculateLoyaltyDiscount(this.cartView.getContext());
        }
    }

    public boolean enforceMapForCoordinates(Address address, boolean z11, boolean z12) {
        if (!z11 && !z12 && !this.isNineCookiesTrackingEnabled) {
            this.isMapcompulsory = false;
        } else if (this.isNineCookiesTrackingEnabledFromAddress) {
            this.isMapcompulsory = false;
        } else if (address == null) {
            this.isMapcompulsory = true;
        } else if (address.latitude <= 0.0d || address.longitude <= 0.0d) {
            this.isMapcompulsory = true;
        } else {
            this.isMapcompulsory = false;
        }
        return this.isMapcompulsory;
    }

    public void geoAddressNotReceived() {
    }

    public String getBinDiscountAmount() {
        return TalabatFormatter.getInstance().getFormattedCurrency(Cart.getInstance().getBinVoucherDiscount(), true);
    }

    public void getBinTokens() {
        if (!isGemActive().booleanValue() && this.paymentConfigurationRepository.config().isBinCampAvailable() && this.customerRepository.isLoggedIn() && this.customerRepository.hasSavedCards() && !GlobalDataModel.BIN.handled) {
            this.cartInteractor.getCustomerTokensForBin();
        }
    }

    public CartAdapterListener getCartFooterListener() {
        return this;
    }

    public String getCartTotalPrice() {
        return Cart.getInstance().getCartTotalDisplayPrice();
    }

    public String getCouponDiscountAmount() {
        return Cart.getInstance().getCouponDiscountDisplayAmount();
    }

    public String getDeliveryCharge() {
        if (Cart.getInstance().isRemoteDeliveryFee()) {
            return TalabatFormatter.getInstance().getFormattedCurrency(Cart.getInstance().getNewDeliveryCharge());
        }
        if (restaurantHasDeliveryChargesTiers()) {
            if (getDeliveryChargeTier() == 0.0f) {
                return this.cartView.getFreeString();
            }
            return TalabatFormatter.getInstance().getFormattedCurrency(getDeliveryChargeTier());
        } else if (restaurantHasTalabatCharge()) {
            return getDisplayTalabatCharge();
        } else {
            return getDisplayDeliveryCharge();
        }
    }

    public String getDeliveryChargeText() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null) {
            return "";
        }
        if (restaurant.talabatCharges > 0.0f) {
            if (!TalabatUtils.isNullOrEmpty(restaurant.altTalabatText)) {
                return restaurant.altTalabatText;
            }
            return this.cartView.getTalabatChargesString();
        } else if (!TalabatUtils.isNullOrEmpty(restaurant.altDelChargetxt)) {
            return restaurant.altDelChargetxt;
        } else {
            return this.cartView.getDeliveryChargesString();
        }
    }

    public int getDeliveryChargesTextColor() {
        boolean z11;
        if (!restaurantHasDeliveryChargesTiers() || Cart.getInstance().isRemoteDeliveryFee()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return this.cartView.getPromoColor();
        }
        return this.cartView.getBlackColor();
    }

    public String getFreeDeliveryDiscountAmount() {
        return "- " + TalabatFormatter.getInstance().getFormattedCurrency(Cart.getInstance().getFreeDeliveryDiscountAmount(), true);
    }

    public String getFreeDeliveryReturn() {
        return getDeliveryCharge();
    }

    public MutableLiveData<Boolean> getFreeDeliveryVoucherStackingError() {
        return Cart.getInstance().getFreeDeliveryVoucherStackingError();
    }

    public String getGemOfferAmount() {
        return Cart.getInstance().getGemOfferDisplayAmount();
    }

    public int getGemTextColor() {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            return cartView2.getGemTextColor(getGemTextColorIndexForArray(GEMEngine.getInstance()));
        }
        return Color.parseColor("#EEB200");
    }

    public int getGemTextColorIndexForArray(GEMEngine gEMEngine) {
        int currentGemIndex = gEMEngine.getCurrentGemIndex();
        int gemCount = gEMEngine.getGemCount();
        if (currentGemIndex == 2) {
            return 1;
        }
        if (currentGemIndex == 3 && gemCount == 4) {
            return 2;
        }
        if ((currentGemIndex == 3 && gemCount == 3) || currentGemIndex == 4) {
            return 3;
        }
        return 0;
    }

    public boolean getIsNonCombinationalPromotionItemPresent() {
        return this.isNonCombinationalItemPresent;
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

    public String getMessageFromReorderResponse() {
        return Cart.getInstance().getReorderStatusContent();
    }

    public String getMinimumOrderAmount() {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            return cartView2.getMinimumOrderString();
        }
        return "";
    }

    public String getMobileNumber(boolean z11) {
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

    public String getMunicipalityTaxAmount() {
        return Cart.getInstance().getDisplayMuncipalityTax();
    }

    public String getMunicipalityTaxLabelText() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null || TalabatUtils.isNullOrEmpty(restaurant.altMunicipalityText)) {
            return this.cartView.getMunicipalityTaxText();
        }
        return restaurant.altMunicipalityText;
    }

    public boolean getNoCutlerySelection() {
        return Cart.getInstance().getGoGreenSelection();
    }

    public String getNormalVoucherText() {
        return this.cartView.getNormalVoucherText();
    }

    public String getOldDeliveryCharge() {
        return getDisplayDeliveryCharge();
    }

    public boolean getParallelBinNotificationShown() {
        return this.cartView.getContext().getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0).getBoolean("ParallelBinCampaignStatus", false);
    }

    public CharSequence getReorderStatusContent() {
        HashMap hashMap = new HashMap();
        hashMap.put(REORDER_ITEM_MISSING_VIEW_ATTRIBUTE_KEY, Cart.getInstance().getReorderStatusContent());
        ObservabilityManager.trackEvent("Cart Screen", REORDER_ITEM_MISSING_VIEW_BODY, ViewStatus.VISIBLE, (Map<String, String>) hashMap);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getTitleFromReorderResponse() + getMessageFromReorderResponse());
        spannableStringBuilder.setSpan(new StyleSpan(1), 0, getTitleFromReorderResponse().length(), 33);
        return spannableStringBuilder;
    }

    public String getReplacedString(StringBuilder sb2, String str, String str2) {
        if (sb2 == null || sb2.length() <= 0) {
            return "";
        }
        if (TalabatUtils.isNullOrEmpty(str) || TalabatUtils.isNullOrEmpty(str2) || !sb2.toString().contains(str)) {
            return sb2.toString();
        }
        int lastIndexOf = sb2.lastIndexOf(str);
        sb2.replace(lastIndexOf, str.length() + lastIndexOf, str2);
        return sb2.toString().trim();
    }

    public MenuItem getRestaurantMenuItem(int i11) {
        MenuItem menuItem;
        MenuItem menuItem2 = new MenuItem();
        Iterator<MenuSection> it = getRestaurantMenuSections().iterator();
        while (it.hasNext()) {
            MenuSection next = it.next();
            int i12 = 0;
            if (isGemActive().booleanValue()) {
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
            if (isGemActive().booleanValue()) {
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

    public String getSavedGeneralRequest() {
        return Cart.getInstance().getGeneralRequest();
    }

    public void getShopStatus() {
        startProgress();
        this.disposable.add(requestShopStatusDisposable());
    }

    public MutableLiveData<Boolean> getShowBusyPopup() {
        return this.showBusyPopup;
    }

    public String getSubtotalPrice() {
        return Cart.getInstance().getCartSubTotalDisplayPrice();
    }

    public String getTitleFromReorderResponse() {
        return Cart.getInstance().getReorderStatusTitle();
    }

    public String getTouristTaxAmount() {
        return Cart.getInstance().getDispalyTouristTax();
    }

    public String getTouristTaxLabelText() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null || TalabatUtils.isNullOrEmpty(restaurant.altTouristTaxText)) {
            return this.cartView.getTouristTaxLabelText();
        }
        return restaurant.altTouristTaxText;
    }

    public String getVoucherAmount() {
        return "- " + Cart.getInstance().getDisplayVoucherDiscount();
    }

    public int getVoucherDiscountTextColor() {
        return this.cartView.getVoucherDiscountTextColor();
    }

    public String getZeroVoucherText() {
        return this.cartView.getZeroVoucherText();
    }

    public int getZeroVoucherTextColor() {
        return this.cartView.getZeroVoucherTextColor();
    }

    public void handleDeliveryFee(float f11) {
        Cart.getInstance().setDeliveryFee(f11);
    }

    @VisibleForTesting
    public void handleMenuNavigation() {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        if (restaurant == null) {
            return;
        }
        if (restaurant.shopType == 0 || isPickup()) {
            this.cartView.navigateToFlutterMenu();
        } else if (canNFVNavigateToFlutterMenu()) {
            this.cartView.navigateToFlutterMenu();
        } else {
            this.cartView.onRedirectToMenuPage();
        }
    }

    public void handleServiceFee(float f11) {
        Cart.getInstance().setServiceFee(f11);
    }

    public void handleSmallOrderFee(float f11) {
        Cart.getInstance().setSmallOrderFee(f11);
    }

    public boolean hasMunicipalityTax() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null || restaurant.getMunicipalityTax() <= 0.0f) {
            return false;
        }
        return true;
    }

    public boolean hasTouristTax() {
        Restaurant restaurant = Cart.getInstance().getRestaurant();
        if (restaurant == null || restaurant.getTouristTax() <= 0.0f) {
            return false;
        }
        return true;
    }

    public void increaseQuantiy(CartMenuItem cartMenuItem) {
        int quantity = cartMenuItem.getQuantity() + 1;
        if (quantity < 101) {
            Cart instance = Cart.getInstance();
            instance.setQuantity(cartMenuItem, quantity);
            instance.recalcualteTotal();
            this.cartView.onGemEnabledItemUpdated();
            this.cartView.notifyRecyclerViewFooter();
            AppTracker.onItemQuantityIncreased(this.cartView.getContext(), cartMenuItem);
            loadCouponsAndPromotions(instance.getRestaurant().getBranchId(), Cart.getInstance().getCartSubTotal(), instance.getRestaurant());
            if (isLoyaltyVoucherApplied()) {
                Cart.getInstance().calculateLoyaltyDiscount(this.cartView.getContext());
            }
        }
        updateQuantity(cartMenuItem, cartMenuItem.getQuantity());
    }

    public boolean isCouponApplied() {
        return Cart.getInstance().isCouponApplied();
    }

    public boolean isFreeDeliveryDiscountFull() {
        return Cart.getInstance().isFreeDeliveryDiscountFull();
    }

    public boolean isFreeDeliveryTypeVoucherApplied() {
        return Cart.getInstance().isFreeDeliveryTypeVoucherApplied();
    }

    public boolean isLoyaltyVoucherApplied() {
        return Cart.getInstance().isLoyaltyVoucherApplied();
    }

    public boolean isMinimumOrderAmountPassed() {
        return Cart.getInstance().isMinimumOrderAmountPassed();
    }

    public boolean isNormalVoucher() {
        if (Cart.getInstance().isZeroVoucherApplied() || Cart.getInstance().isTalabatDeliveryVoucher()) {
            return false;
        }
        return true;
    }

    public boolean isOnlyBinApplied() {
        return Cart.getInstance().hasBinVoucher() && !Cart.getInstance().isVoucherApplied();
    }

    public boolean isPickup() {
        return Cart.getInstance().isPickup();
    }

    public boolean isTalabatDeliveryVoucher() {
        if (Cart.getInstance().isZeroVoucherApplied() || !Cart.getInstance().isTalabatDeliveryVoucher()) {
            return false;
        }
        return true;
    }

    public boolean isVoucherApplied() {
        return Cart.getInstance().isVoucherApplied() || Cart.getInstance().isZeroVoucherApplied();
    }

    public boolean isVoucherStackingEnabled() {
        return this.featureFlag.getFeatureFlag(GrowthFeatureFlagConstantKt.FunWithFlagsEnableCompoundingStackedIncentives, false);
    }

    public boolean isZeroVoucher() {
        return Cart.getInstance().isZeroVoucherApplied();
    }

    public void loadCouponsAndPromotions(int i11, float f11, Restaurant restaurant) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(restaurant.isMealDealAvailable);
        sb2.append("");
        sb2.append(restaurant.isCouponAvailable);
        if (GlobalDataModel.GEMCONSTANTS.cartCouponSupressed && !isGemActive().booleanValue()) {
            GlobalDataModel.GEMCONSTANTS.cartCouponSupressed = false;
            restaurant.isCouponAvailable = true;
            Cart.getInstance().getRestaurant().isCouponAvailable = true;
        }
        if (f11 <= 0.0f || this.couponRefreshedAmount == f11 || (!restaurant.isMealDealAvailable && !restaurant.isCouponAvailable)) {
            this.cartView.onCouponsAndPromotionsLoaded(false, false);
            return;
        }
        this.isNonCombinationalItemPresent = Cart.getInstance().isNonCombinationalPromotionalItemPresent();
        this.couponRefreshedAmount = f11;
        this.cartView.showCouponLoading();
        this.cartInteractor.loadCouponsAndPromotions(i11, f11, restaurant);
    }

    public void loadCustomerDetails() {
        this.cartInteractor.loadCustomerDetails();
    }

    public void loadCustomerDetailsBackground() {
        this.cartInteractor.updateUserInfoBackground();
    }

    public void mcdBranchFailed() {
        this.cartView.isGrlRestaurantRedirect(this.selectedAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdLatitudeLongitudeUpdateAddressUpdateRequired(), true);
    }

    public void mcdBranchReceived(McdStoresResponse mcdStoresResponse, boolean z11) {
        McdStoresResponse mcdStoresResponse2 = mcdStoresResponse;
        if (mcdStoresResponse2 == null) {
            this.cartView.isGrlRestaurantRedirect(this.selectedAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdLatitudeLongitudeUpdateAddressUpdateRequired(), true);
        } else if (mcdStoresResponse2.result.statusCode != 0) {
            this.cartView.isGrlRestaurantRedirect(this.selectedAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdLatitudeLongitudeUpdateAddressUpdateRequired(), true);
        } else if (mcdStoresResponse2.tlbBranchId <= 0) {
        } else {
            if (Cart.getInstance().getRestaurant().branchId == mcdStoresResponse2.tlbBranchId) {
                this.cartView.onRedirectToCheckOut(false, this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, true, z11);
            } else {
                this.cartView.isGrlRestaurantRedirect(this.selectedAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdLatitudeLongitudeUpdateAddressUpdateRequired(), true);
            }
        }
    }

    public void notifyItemRemoved(int i11) {
        this.cartView.notifyItemRemovedToAdapter(i11);
    }

    public void observeBusyPopupOpen(Restaurant restaurant) {
        HashMap hashMap = new HashMap();
        if (restaurant != null) {
            hashMap.put(GlobalConstants.LOGGER_BUSY_POPUP_BUSY_RESTAURANT, restaurant.branchName);
        } else {
            ObservabilityManager.trackUnExpectedScenario(BUSYPOPUP_ERROR_MESSAGE, new HashMap());
        }
        ObservabilityManager.trackEvent("Cart Screen", BUSYPOPUP_PROCEED_TO_CHECKOUT, UserAction.TAP, (Map<String, String>) hashMap);
    }

    public void observeBusyPopupRestaurantSelection(Restaurant restaurant) {
        HashMap hashMap = new HashMap();
        if (Cart.getInstance().getRestaurant() != null) {
            hashMap.put(GlobalConstants.LOGGER_BUSY_POPUP_BUSY_RESTAURANT, Cart.getInstance().getRestaurant().branchName);
        } else {
            ObservabilityManager.trackUnExpectedScenario(BUSYPOPUP_ERROR_MESSAGE, new HashMap());
        }
        hashMap.put(GlobalConstants.LOGGER_BUSY_POPUP_NEW_RESTAURANT, restaurant.branchName);
        ObservabilityManager.trackEvent("Cart Screen", BUSYPOPUP_RECOMMENDED_RESTAURANT, UserAction.TAP, (Map<String, String>) hashMap);
    }

    public void observeBusyPopupViewSimilarClick() {
        HashMap hashMap = new HashMap();
        if (Cart.getInstance().getRestaurant() != null) {
            hashMap.put(GlobalConstants.LOGGER_BUSY_POPUP_BUSY_RESTAURANT, Cart.getInstance().getRestaurant().branchName);
        } else {
            ObservabilityManager.trackUnExpectedScenario(BUSYPOPUP_ERROR_MESSAGE, new HashMap());
        }
        ObservabilityManager.trackEvent("Cart Screen", BUSYPOPUP_VIEW_SIMILAR, UserAction.TAP, (Map<String, String>) hashMap);
    }

    public void observeInconsistencyInCartItems(int i11, int i12, int i13, int i14, Boolean bool, Restaurant restaurant) {
        HashMap hashMap = new HashMap();
        hashMap.put("position", String.valueOf(i11));
        hashMap.put("upSellingItemsCount", String.valueOf(i12));
        hashMap.put("couponsAndPromotionsCount", String.valueOf(i13));
        hashMap.put("allItemsCount", String.valueOf(i14));
        hashMap.put("hasReorderItemsStatus", String.valueOf(bool));
        hashMap.put("restaurant id", String.valueOf(restaurant.f13872id));
        ObservabilityManager.trackUnExpectedScenario(INCONSISTENCY_IN_CART_ITEMS_ATTRIBUTE_KEY, hashMap);
    }

    public void onAdditionalRequestEdited(String str) {
        Cart.getInstance().setGeneralRequest(str);
    }

    public void onCouponsAndPromotionsLoaded(boolean z11) {
        this.cartView.onCouponsAndPromotionsLoaded(z11, true);
        recalculateAppliedVoucher();
    }

    public void onCustomVoucherRecived(CampaignVoucher campaignVoucher) {
        Cart.getInstance().setRestaurantCampaignVoucher(campaignVoucher);
    }

    public void onCustomerinfoLoaded(CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        Customer instance = Customer.getInstance();
        boolean z11 = false;
        if (instance.getSelectedCustomerAddress() != null) {
            if (!isGrlEnabledRes(this.isGlrRestaurant)) {
                HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                if (homeMapTemp.getHomeMapSavedLatLng() != null && homeMapTemp.getEnabledHomeMapRedirectEnabled()) {
                    this.cartView.mapFirstRedirect(instance.getSelectedCustomerAddress(), isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
                } else if (enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
                    this.cartView.isMapCompulsory(instance.getSelectedCustomerAddress(), enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
                } else {
                    this.cartView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
                }
            } else if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (isGrlIdEnforce(instance.getSelectedCustomerAddress())) {
                    Cart.getInstance().saveMcdAddressCartToPrefs(this.cartView.getContext());
                    this.cartView.onRedirectToCheckOut(false, this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant), false);
                    return;
                }
                this.cartView.isGrlRestaurantRedirect(instance.getSelectedCustomerAddress(), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isAddressUpdateRequired(instance.getSelectedCustomerAddress()), true);
            } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                if (hasBlock(instance.getSelectedCustomerAddress())) {
                    Cart.getInstance().saveMcdAddressCartToPrefs(this.cartView.getContext());
                    if (isMcdBlockAddressUpdateRequired(instance.getSelectedCustomerAddress())) {
                        this.cartView.isGrlRestaurantRedirect(instance.getSelectedCustomerAddress(), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdBlockAddressUpdateRequired(instance.getSelectedCustomerAddress()), true);
                        return;
                    }
                    grlUpdateIsRequired(instance.getSelectedCustomerAddress());
                    this.cartView.onRedirectToCheckOut(false, this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant), false);
                    return;
                }
                this.cartView.isGrlRestaurantRedirect(instance.getSelectedCustomerAddress(), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdBlockAddressUpdateRequired(instance.getSelectedCustomerAddress()), true);
            } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
            } else {
                if (hasMcdLatitudeLongitude(instance.getSelectedCustomerAddress())) {
                    Cart.getInstance().saveMcdAddressCartToPrefs(this.cartView.getContext());
                    if (isMcdLatitudeLongitudeUpdateAddressUpdateRequired()) {
                        this.selectedAddress = instance.getSelectedCustomerAddress();
                        checkWithStoresAvailableSelectedAddress(instance.getSelectedCustomerAddress(), false);
                        return;
                    }
                    this.cartView.onRedirectToCheckOut(false, this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant), true);
                    return;
                }
                this.cartView.isGrlRestaurantRedirect(instance.getSelectedCustomerAddress(), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdLatitudeLongitudeUpdateAddressUpdateRequired(), true);
            }
        } else if (instance.getCustomerAddress(GlobalDataModel.SelectedAreaId) == null || instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).size() == 0) {
            if (isGrlEnabledRes(this.isGlrRestaurant)) {
                this.cartView.isGrlRestaurantRedirect(instance.getSelectedCustomerAddress(), true, true, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, true);
                return;
            }
            HomeMapTemp homeMapTemp2 = HomeMapTemp.INSTANCE;
            if (homeMapTemp2.getHomeMapSavedLatLng() == null || !homeMapTemp2.getEnabledHomeMapRedirectEnabled()) {
                this.cartView.isMapCompulsory(instance.getSelectedCustomerAddress(), enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), true, true, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
                return;
            }
            this.cartView.mapFirstRedirect(instance.getSelectedCustomerAddress(), isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), true, true, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
        } else if (instance.getCustomerAddress(GlobalDataModel.SelectedAreaId) == null || instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).size() == 1) {
            Address address = instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).get(0);
            Customer.getInstance().setSelectedCustomerAddress(this.cartView.getContext(), address.f58343id, address.areaId);
            if (!isGrlEnabledRes(this.isGlrRestaurant)) {
                HomeMapTemp homeMapTemp3 = HomeMapTemp.INSTANCE;
                if (homeMapTemp3.getHomeMapSavedLatLng() != null && homeMapTemp3.getEnabledHomeMapRedirectEnabled()) {
                    if (deselectAddress()) {
                        Customer.getInstance().deselectCustomerAddress();
                    }
                    CartView cartView2 = this.cartView;
                    if (deselectAddress()) {
                        address = null;
                    }
                    cartView2.mapFirstRedirect(address, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, deselectAddress(), this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
                } else if (enforceMapForCoordinates(address, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
                    this.cartView.isMapCompulsory(address, enforceMapForCoordinates(address, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
                } else {
                    this.cartView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
                }
            } else if (TalabatUtils.isMcdInforMapEnabledCountry()) {
                if (isAddressUpdateRequired(address)) {
                    this.cartView.isGrlRestaurantRedirect(instance.getSelectedCustomerAddress(), true, true, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, true, true);
                    return;
                }
                Cart.getInstance().saveMcdAddressCartToPrefs(this.cartView.getContext());
                this.cartView.onRedirectToCheckOut(false, this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant), false);
            } else if (TalabatUtils.isMcdBlockMenuEnabledCountry()) {
                if (isMcdBlockAddressUpdateRequired(address)) {
                    this.cartView.isGrlRestaurantRedirect(instance.getSelectedCustomerAddress(), true, true, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, true, true);
                    return;
                }
                Cart.getInstance().saveMcdAddressCartToPrefs(this.cartView.getContext());
                grlUpdateIsRequired(address);
                this.cartView.onRedirectToCheckOut(false, this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant), false);
            } else if (!TalabatUtils.isMcdLatLngEnabledCountry()) {
            } else {
                if (isMcdLatitudeLongitudeUpdateAddressUpdateRequired()) {
                    this.selectedAddress = instance.getSelectedCustomerAddress();
                    if (!this.isOneAddressUpdate || instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).size() != 1) {
                        checkWithStoresAvailableSelectedAddress(instance.getSelectedCustomerAddress(), true);
                    } else {
                        this.cartView.isGrlRestaurantRedirect(this.selectedAddress, false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isMcdLatitudeLongitudeUpdateAddressUpdateRequired(), true);
                    }
                } else {
                    Cart.getInstance().saveMcdAddressCartToPrefs(this.cartView.getContext());
                    this.cartView.onRedirectToCheckOut(false, this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant), true);
                }
            }
        } else if (isGrlEnabledRes(this.isGlrRestaurant)) {
            CartView cartView3 = this.cartView;
            if (!isGrlEnabledRes(this.isGlrRestaurant) && (this.isRestaurantTrackOrder || this.isForceMapFromRestaurant)) {
                z11 = true;
            }
            cartView3.onRedirectToAddressSelection(z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant));
        } else {
            HomeMapTemp homeMapTemp4 = HomeMapTemp.INSTANCE;
            if (homeMapTemp4.getHomeMapSavedLatLng() == null || !homeMapTemp4.getEnabledHomeMapRedirectEnabled()) {
                CartView cartView4 = this.cartView;
                if (!isGrlEnabledRes(this.isGlrRestaurant) && (this.isRestaurantTrackOrder || this.isForceMapFromRestaurant)) {
                    z11 = true;
                }
                cartView4.onRedirectToAddressSelection(z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes(this.isGlrRestaurant));
                return;
            }
            this.cartView.mapFirstRedirect((Address) null, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
        }
    }

    public void onCustomerinfoLoadedBackGround(CustomerAddressInfoJsonResult customerAddressInfoJsonResult, Subscription subscription) {
        Customer instance = Customer.getInstance();
        if (subscription == null) {
            if (instance.getCustomerInfo().tProSubscriptionInfo != null) {
                subscription = instance.getCustomerInfo().tProSubscriptionInfo;
            } else {
                subscription = new Subscription();
            }
        }
        CustomerInfo customerInfo = customerAddressInfoJsonResult.result.customer;
        customerInfo.tProSubscriptionInfo = subscription;
        instance.setCustomerInfo(customerInfo);
        this.subscriptionStatusRepository.setTProSubscriptionInfo(subscription);
    }

    public void onDataError() {
        this.cartView.onDataError();
    }

    public void onDestroy() {
        this.cartView = null;
        ICartInteractor iCartInteractor = this.cartInteractor;
        if (iCartInteractor != null) {
            iCartInteractor.unregister();
        }
        this.cartInteractor = null;
        CompositeDisposable compositeDisposable = this.disposable;
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            this.disposable.dispose();
        }
    }

    public void onEmptyMenuReceived(String str) {
        this.cartView.onEmptyMenuReceived(str);
    }

    public void onGeoAddressRecieved(Address address, Address address2) {
        this.cartView.stopLodingPopup();
        if (address2 != null && address != null) {
            if (TalabatUtils.isNullOrEmpty(address.block)) {
                address2.block = "";
            }
            if (TalabatUtils.isNullOrEmpty(address.street)) {
                address2.street = "";
            }
            if (TalabatUtils.isNullOrEmpty(address.extraDirections)) {
                address2.extraDirections = "";
            }
            if (TalabatUtils.isNullOrEmpty(address.judda)) {
                address2.judda = "";
            }
            this.cartView.mapFirstUpdateAddressRedirect(address2, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
        }
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Restaurant restaurant = GlobalDataModel.SELECTED.getRestaurant();
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && restaurant != null && instance.getRestaurant().f13873name.equals(restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        if (this.addMoreItemButtonClicked) {
            this.addMoreItemButtonClicked = false;
            if (canNFVNavigateToFlutterMenu()) {
                this.cartView.navigateToFlutterMenu();
            } else {
                this.cartView.onRedirectToGroceryMenuPage();
            }
        }
    }

    public void onGuestCheckoutRequested() {
        boolean z11;
        boolean z12;
        boolean isGrlEnabledRes = isGrlEnabledRes(this.isGlrRestaurant);
        if (isGrlEnabledRes || !enforceMapForCoordinates((Address) null, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!isGrlEnabledRes) {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (homeMapTemp.getHomeMapSavedLatLng() != null && homeMapTemp.getEnabledHomeMapRedirectEnabled()) {
                z12 = true;
                this.cartView.navigateToQuickOrderScreen(z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes, z12);
            }
        }
        z12 = false;
        this.cartView.navigateToQuickOrderScreen(z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes, z12);
    }

    public void onLoyaltyVoucherError() {
        this.cartView.stopLodingPopup();
    }

    public void onLoyaltyVoucherInfoReceived(LoyaltyVoucherRM loyaltyVoucherRM) {
        this.cartView.stopLodingPopup();
        Cart.getInstance().saveLoyaltyVoucher(this.cartView.getContext(), loyaltyVoucherRM);
        Cart.getInstance().calculateLoyaltyDiscount(this.cartView.getContext());
        this.cartView.notifyRecyclerViewFooter();
    }

    public void onMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        Cart instance = Cart.getInstance();
        if (instance.hasItems() && menuItemsResponseModel.restaurant != null && instance.getRestaurant().f13873name.equals(menuItemsResponseModel.restaurant.f13873name) && GlobalDataModel.SelectedAreaName.equals(menuItemsResponseModel.restaurant.areaName)) {
            instance.setTgoFreeDeliveryTiers();
        }
        if (this.addMoreItemButtonClicked) {
            this.addMoreItemButtonClicked = false;
            handleMenuNavigation();
        }
    }

    public void onNetworkError() {
        this.cartView.stopLodingPopup();
        this.cartView.onNetworkError();
    }

    public void onParallelBinAvailable() {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            cartView2.onParallelBinAvailable();
        }
    }

    public void onRequestError() {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            cartView2.onRequestError();
        }
    }

    public void onResultFromLoginScreenForAddressList() {
        boolean z11;
        boolean isGrlEnabledRes = isGrlEnabledRes(this.isGlrRestaurant);
        if (isGrlEnabledRes || (!this.isRestaurantTrackOrder && !this.isForceMapFromRestaurant)) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.cartView.onRedirectToAddressSelection(z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes);
    }

    public void onResultSuccessFromProgressiveLoginBottomSheet() {
        this.disposable.add(this.selectSavedAddressIfCanDeliverToVendorUseCase.selectSavedAddressIfCanDeliverToVendor().subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).subscribe(new b(this), new c(this)));
    }

    public void onReviewLoadingCompleted(RestaurantReviewResponse restaurantReviewResponse) {
        RestaurantReview restaurantReview = restaurantReviewResponse.result;
        RestaurantReviewPaging[] restaurantReviewPagingArr = restaurantReview.rev;
        this.restaurantReviews = restaurantReviewPagingArr;
        int i11 = restaurantReview.totalPages;
        this.totalPages = i11;
        int i12 = restaurantReview.totalReviews;
        this.totalReviews = i12;
        RatingSection ratingSection2 = restaurantReview.ratingSection;
        this.ratingSection = ratingSection2;
        this.cartView.onReviewLoadingCompleted(restaurantReviewPagingArr, i11, i12, ratingSection2);
    }

    public void onServerError(VolleyError volleyError) {
        this.cartView.onServerError(volleyError);
    }

    public void onUpsellingItemsReceived(UpsellingResponse upsellingResponse) {
        this.cartView.onUpsellingItemsRecieved(upsellingResponse.result.upsellingItems);
    }

    public void onViewLoaded() {
        subscribeToSubtotalChanges();
    }

    public void onWalletCreditCardABTestStatusResponse(boolean z11) {
        this.cartView.onSetWalletABTestStatus(z11);
    }

    public void recalculateAppliedVoucher() {
        Cart instance = Cart.getInstance();
        if (instance.isLoyaltyVoucherApplied() && isVoucherStackingEnabled()) {
            instance.calculateLoyaltyDiscount(this.cartView.getContext());
        }
    }

    public void redirectToLogin() {
        boolean z11;
        boolean z12;
        HomeMapTemp homeMapTemp;
        boolean isGrlEnabledRes = isGrlEnabledRes(this.isGlrRestaurant);
        if (isGrlEnabledRes || (homeMapTemp = HomeMapTemp.INSTANCE) == null || homeMapTemp.getHomeMapSavedLatLng() == null || !homeMapTemp.getEnabledHomeMapRedirectEnabled()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (this.featureFlag.getFeatureFlag(TalabatFeatureFlagConstants.PROGRESSIVE_LOGIN_WITH_AAA, false)) {
            this.cartView.showLoginOptionsBottomSheet(this.featureFlag.getFeatureFlag(OrderingFeatureFlagsKeys.IS_GUEST_USER_CHECKOUT_ENABLED, false));
            return;
        }
        if (isGrlEnabledRes || !enforceMapForCoordinates((Address) null, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
            z12 = false;
        } else {
            z12 = true;
        }
        this.cartView.onRedirectToLogin(z12, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, isGrlEnabledRes, z11);
    }

    public void removeBinDiscount() {
        Cart instance = Cart.getInstance();
        if (instance.hasBinVoucher() && isVoucherStackingEnabled()) {
            instance.removeBinDiscountIfApplied();
        }
    }

    public void removeInvalidVouchers() {
        if (isVoucherApplied() && Cart.getInstance().getSavedVoucher() != null && !Cart.getInstance().getSavedVoucher().getMobileNumber().equals(getMobileNumber(true))) {
            removeVoucher();
        }
    }

    public void removeItemAtPosition(int i11, Context context) {
        Cart instance = Cart.getInstance();
        if (i11 >= 0 && instance.getCartItems().size() >= i11 && instance.getCartItems().get(i11) != null) {
            CartMenuItem cartMenuItem = instance.getCartItems().get(i11);
            updateQuantity(cartMenuItem, 0);
            instance.deleteItemAtPostion(i11, context);
            instance.recalcualteTotal();
            this.cartView.onGemEnabledItemUpdated();
            AppTracker.onItemRemovedFromCart(context, Cart.getInstance().getRestaurant(), cartMenuItem, "cart_modify", ScreenNames.getScreenType(this.cartView.getScreenName()), this.cartView.getScreenName());
            if (instance.hasItems()) {
                this.cartView.notifyRecyclerViewFooter();
                loadCouponsAndPromotions(instance.getRestaurant().getBranchId(), Cart.getInstance().getCartSubTotal(), instance.getRestaurant());
                if (isLoyaltyVoucherApplied()) {
                    Cart.getInstance().calculateLoyaltyDiscount(this.cartView.getContext());
                    return;
                }
                return;
            }
            this.cartView.onCartEmpty();
            this.cartUtility.clearCart();
            if (instance.getRestaurant().isGlrEnabled) {
                instance.clearinfoMapAddress();
            }
        }
    }

    public void removeVoucher() {
        Cart.getInstance().removeLoyaltyVoucherIfAvailable();
        Cart.getInstance().removeVoucherIfApplied();
        Cart.getInstance().recalcualteTotal();
        this.cartView.notifyRecyclerViewFooter();
    }

    public void removeVoucherIfRequired() {
        if (Customer.getInstance().isLoggedIn() && isGuestUserInfoAvailable()) {
            removeVoucher();
        }
        removeInvalidVouchers();
    }

    public Disposable requestShopStatusDisposable() {
        return requestShopStatusDisposable(getBranchId());
    }

    public void setContinueButtonEnabled(boolean z11) {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            cartView2.setContinueButtonEnabledStatus(z11);
            if (z11) {
                this.cartView.setContinueButtonAlpha(1.0f);
            } else {
                this.cartView.setContinueButtonAlpha(0.5f);
            }
        }
    }

    public void setMinimumOrderAmountVisible(boolean z11) {
        CartView cartView2 = this.cartView;
        if (cartView2 != null) {
            String minimumOrderString = cartView2.getMinimumOrderString();
            if (!z11 || minimumOrderString == null) {
                this.cartView.setMinimumOrderVisibility(8);
            } else {
                this.cartView.setMinimumOrderVisibility(0);
            }
            this.cartView.setMinimumOrderText(minimumOrderString);
        }
    }

    public void setNoCutlerySelection(boolean z11) {
        Cart.getInstance().setGoGreenSelection(z11);
    }

    public void setViews() {
        if (Cart.getInstance().hasItems()) {
            this.cartInteractor.checkForSelectedAddressAreaUpdate(new j(this));
        } else {
            this.cartView.onCartEmpty();
        }
    }

    public void shouldShowFreeDelivery(Function1<? super TProOrderStatus, Unit> function1) {
        this.getTProOrderStatusUseCase.invoke(true, false, false, function1);
    }

    public boolean shouldShowNoCutlery() {
        if (!this.orderExperienceConfigurationRepository.config().isGoGreen() || Cart.getInstance().getRestaurant() == null || Cart.getInstance().getRestaurant().shopType != 0) {
            return false;
        }
        return true;
    }

    public boolean shouldShowOldDeliveryCharge() {
        return restaurantHasDeliveryChargesTiers() && !Cart.getInstance().isRemoteDeliveryFee();
    }

    public void updateAddressWithGoogleApi(Address address) {
        this.cartView.startLodingPopup();
        this.cartInteractor.updateAddresswithGoogleAddress(address);
    }

    public void updateQuantity(CartMenuItem cartMenuItem, int i11) {
        List<Integer> list;
        CartUtility cartUtility2 = this.cartUtility;
        int i12 = cartMenuItem.f13861id;
        String str = cartMenuItem.specialRequest;
        if (str == null) {
            str = "";
        }
        ArrayList<ChoiceSection> arrayList = cartMenuItem.selectedChoices;
        if (arrayList != null) {
            list = getChoicesIds(arrayList);
        } else {
            list = Collections.emptyList();
        }
        cartUtility2.updateQuantity(i12, str, i11, list);
    }

    public void onServerError() {
        this.cartView.onServerError();
    }

    public Disposable requestShopStatusDisposable(String str) {
        Single<R> doFinally = Single.fromObservable(requestShopStatus(str)).subscribeOn(this.ioScheduler).observeOn(this.mainScheduler).doOnError(new f(this)).map(new g()).onErrorReturnItem(Boolean.FALSE).doFinally(new h(this));
        MutableLiveData<Boolean> mutableLiveData = this.showBusyPopup;
        Objects.requireNonNull(mutableLiveData);
        return doFinally.subscribe((Consumer<? super R>) new i(mutableLiveData));
    }

    public CartPresenter(CartView cartView2, Scheduler scheduler, Scheduler scheduler2, Callable<Boolean> callable, CanCheckComplianceStatusOfUserDelegate canCheckComplianceStatusOfUserDelegate2, SelectSavedAddressIfCanDeliverToVendorUseCase selectSavedAddressIfCanDeliverToVendorUseCase2, ICartInteractor iCartInteractor, ITalabatFeatureFlag iTalabatFeatureFlag, ITalabatExperiment iTalabatExperiment, GetTProOrderStatusUseCase getTProOrderStatusUseCase2, DiscoveryConfigurationRepository discoveryConfigurationRepository2, OrderExperienceConfigurationRepository orderExperienceConfigurationRepository2, PaymentConfigurationRepository paymentConfigurationRepository2, CartUtility cartUtility2, AppVersionProvider appVersionProvider2, ConfigurationLocalRepository configurationLocalRepository2, LocationConfigurationRepository locationConfigurationRepository, ISubscriptionStatusRepository iSubscriptionStatusRepository, CustomerRepository customerRepository2) {
        this.addMoreItemButtonClicked = false;
        this.isMapcompulsory = false;
        this.totalPages = 0;
        this.totalReviews = 0;
        this.mcdKsaAddressUpdateIgnore = true;
        this.isOneAddressUpdate = false;
        this.disposable = new CompositeDisposable();
        this.showBusyPopup = new MutableLiveData<>();
        this.cartView = cartView2;
        this.selectSavedAddressIfCanDeliverToVendorUseCase = selectSavedAddressIfCanDeliverToVendorUseCase2;
        this.cartInteractor = iCartInteractor;
        this.mainScheduler = scheduler2;
        this.ioScheduler = scheduler;
        this.isGemActive = callable;
        this.canCheckComplianceStatusOfUserDelegate = canCheckComplianceStatusOfUserDelegate2;
        this.featureFlag = iTalabatFeatureFlag;
        this.talabatExperiment = iTalabatExperiment;
        this.getTProOrderStatusUseCase = getTProOrderStatusUseCase2;
        this.discoveryConfigurationRepository = discoveryConfigurationRepository2;
        this.orderExperienceConfigurationRepository = orderExperienceConfigurationRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.cartUtility = cartUtility2;
        this.appVersionProvider = appVersionProvider2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.locationConfigRepository = locationConfigurationRepository;
        this.customerRepository = customerRepository2;
        this.subscriptionStatusRepository = iSubscriptionStatusRepository;
    }
}
