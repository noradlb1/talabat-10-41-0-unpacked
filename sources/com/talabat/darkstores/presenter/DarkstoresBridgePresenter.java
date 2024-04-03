package com.talabat.darkstores.presenter;

import JsonModels.Response.CustomerAddressInfoJsonResult;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.android.volley.VolleyError;
import com.designsystem.ds_input_field.DateInputField;
import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.discovery.DiscoveryConfigurationRepository;
import com.talabat.configuration.location.Country;
import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointFeeDescription;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointProduct;
import com.talabat.darkstores.helper.DarkstoreCartItemMapper;
import com.talabat.darkstores.interactor.DarkstoresBridgeInteractor;
import com.talabat.darkstores.view.DarkstoresBridgeActivity;
import com.talabat.domain.address.Address;
import com.talabat.feature.fees.domain.model.FeeDescription;
import com.talabat.feature.fees.domain.model.FeeDescriptionType;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.userandlocation.compliance.status.di.module.UserStatusDomainModule;
import datamodels.CartMenuItem;
import datamodels.CustomerInfo;
import datamodels.Restaurant;
import io.reactivex.Scheduler;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002BG\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\u0006\u0010;\u001a\u00020<J\b\u0010=\u001a\u00020'H\u0002J\u0010\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u000209H\u0016J\b\u0010@\u001a\u00020<H\u0002J\b\u0010A\u001a\u00020'H\u0002J\"\u0010B\u001a\u00020'2\b\u0010C\u001a\u0004\u0018\u00010D2\u0006\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020'H\u0002J\b\u0010G\u001a\u00020<H\u0002J\b\u0010H\u001a\u00020<H\u0016J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\u0018\u0010M\u001a\u00020'2\u0006\u0010E\u001a\u00020'2\u0006\u0010F\u001a\u00020'H\u0002J\b\u0010N\u001a\u00020<H\u0002J\b\u0010O\u001a\u00020'H\u0002J8\u0010P\u001a\u00020<2\u0006\u0010Q\u001a\u0002092\u0006\u0010R\u001a\u00020'2\u0006\u0010+\u001a\u00020'2\u0006\u0010:\u001a\u00020'2\u0006\u0010S\u001a\u00020'2\u0006\u0010T\u001a\u00020'H\u0016J\u0010\u0010U\u001a\u00020<2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020<H\u0016J\b\u0010Y\u001a\u00020<H\u0016J\u001c\u0010Z\u001a\u00020<2\b\u0010[\u001a\u0004\u0018\u00010D2\b\u0010\\\u001a\u0004\u0018\u00010DH\u0016J\b\u0010]\u001a\u00020<H\u0002J\b\u0010^\u001a\u00020<H\u0016J\u0012\u0010_\u001a\u00020<2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u0006\u0010b\u001a\u00020<J\u0010\u0010c\u001a\u00020<2\u0006\u0010d\u001a\u00020eH\u0002J\u0010\u0010f\u001a\u00020<2\u0006\u0010C\u001a\u00020DH\u0016R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, d2 = {"Lcom/talabat/darkstores/presenter/DarkstoresBridgePresenter;", "Lcom/talabat/darkstores/presenter/IDarkstoresBridgePresenter;", "Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor$BridgeCallbackListener;", "mView", "Lcom/talabat/darkstores/view/DarkstoresBridgeActivity;", "customerAddressesRepository", "Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;", "customerRepository", "Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;", "appVersionProvider", "Lcom/talabat/configuration/discovery/AppVersionProvider;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "discoveryConfigurationRepository", "Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;", "locationConfigRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "cart", "Lbuisnessmodels/Cart;", "(Lcom/talabat/darkstores/view/DarkstoresBridgeActivity;Lcom/talabat/user/address/domain/repository/CustomerAddressesRepository;Llibrary/talabat/mvp/login/domain/repository/CustomerRepository;Lcom/talabat/configuration/discovery/AppVersionProvider;Lcom/talabat/configuration/ConfigurationLocalRepository;Lcom/talabat/configuration/discovery/DiscoveryConfigurationRepository;Lcom/talabat/configuration/location/LocationConfigurationRepository;Lbuisnessmodels/Cart;)V", "getCart", "()Lbuisnessmodels/Cart;", "cartMenuItems", "Ljava/util/ArrayList;", "Ldatamodels/CartMenuItem;", "Lkotlin/collections/ArrayList;", "getCartMenuItems", "()Ljava/util/ArrayList;", "setCartMenuItems", "(Ljava/util/ArrayList;)V", "getConfigurationLocalRepository", "()Lcom/talabat/configuration/ConfigurationLocalRepository;", "exitPointData", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "getExitPointData", "()Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "setExitPointData", "(Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;)V", "isCartFlow", "", "isForceMapFromRestaurant", "isMapcompulsory", "isNineCookiesTrackingEnabled", "isNineCookiesTrackingEnabledFromAddress", "isOneAddressUpdate", "isRestaurantTrackOrder", "isTalabatDevliveryAvailable", "issMapFirstReDirectCheckout", "getLocationConfigRepository", "()Lcom/talabat/configuration/location/LocationConfigurationRepository;", "mDarkstoresBridgeInteractor", "Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor;", "getMDarkstoresBridgeInteractor", "()Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor;", "setMDarkstoresBridgeInteractor", "(Lcom/talabat/darkstores/interactor/DarkstoresBridgeInteractor;)V", "mRestaurant", "Ldatamodels/Restaurant;", "mcdKsaAddressUpdateIgnore", "addItemsToCart", "", "canCheckComplianceStatusOfUser", "checkIfBackupNeeded", "restaurantBackup", "clearCartAndSetRestaurant", "deselectAddress", "enforceMapForCoordinates", "address", "Lcom/talabat/domain/address/Address;", "restaurantTrackOrder", "mapEnforce", "failure", "geoAddressNotReceived", "getFormattedDateOfBirth", "", "customerInfo", "Ldatamodels/CustomerInfo;", "isCheckoutEnofrceMap", "loadCustomerDetails", "needCompliance", "onCheckoutClicked", "restaurant", "isFromCartFlow", "isMapFirstReDirectCheckout", "isAfterVerifyingUserInfo", "onCustomerinfoLoaded", "customerAddressInfoJsonResult", "LJsonModels/Response/CustomerAddressInfoJsonResult;", "onDataError", "onDestroy", "onGeoAddressRecieved", "GeoAddress", "UserSelectedResult", "onItemsAdded", "onNetworkError", "onServerError", "volleyError", "Lcom/android/volley/VolleyError;", "prepareCart", "showUserVerificationView", "customer", "Lbuisnessmodels/Customer;", "updateAddressWithGoogleApi", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DarkstoresBridgePresenter implements IDarkstoresBridgePresenter, DarkstoresBridgeInteractor.BridgeCallbackListener {
    @NotNull
    private final Cart cart;
    @NotNull
    private ArrayList<CartMenuItem> cartMenuItems;
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @Nullable
    private ExitPointData exitPointData;
    private boolean isCartFlow;
    private boolean isForceMapFromRestaurant;
    private boolean isMapcompulsory;
    private boolean isNineCookiesTrackingEnabled;
    private boolean isNineCookiesTrackingEnabledFromAddress;
    private boolean isOneAddressUpdate;
    private boolean isRestaurantTrackOrder;
    private boolean isTalabatDevliveryAvailable;
    private boolean issMapFirstReDirectCheckout;
    @NotNull
    private final LocationConfigurationRepository locationConfigRepository;
    @Nullable
    private DarkstoresBridgeInteractor mDarkstoresBridgeInteractor;
    @Nullable
    private Restaurant mRestaurant;
    @NotNull
    private DarkstoresBridgeActivity mView;
    private boolean mcdKsaAddressUpdateIgnore;

    public DarkstoresBridgePresenter(@NotNull DarkstoresBridgeActivity darkstoresBridgeActivity, @NotNull CustomerAddressesRepository customerAddressesRepository, @NotNull CustomerRepository customerRepository, @NotNull AppVersionProvider appVersionProvider, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull DiscoveryConfigurationRepository discoveryConfigurationRepository, @NotNull LocationConfigurationRepository locationConfigurationRepository, @NotNull Cart cart2) {
        DarkstoresBridgeActivity darkstoresBridgeActivity2 = darkstoresBridgeActivity;
        ConfigurationLocalRepository configurationLocalRepository3 = configurationLocalRepository2;
        LocationConfigurationRepository locationConfigurationRepository2 = locationConfigurationRepository;
        Cart cart3 = cart2;
        Intrinsics.checkNotNullParameter(darkstoresBridgeActivity2, "mView");
        Intrinsics.checkNotNullParameter(customerAddressesRepository, "customerAddressesRepository");
        Intrinsics.checkNotNullParameter(customerRepository, "customerRepository");
        Intrinsics.checkNotNullParameter(appVersionProvider, "appVersionProvider");
        Intrinsics.checkNotNullParameter(configurationLocalRepository3, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(discoveryConfigurationRepository, "discoveryConfigurationRepository");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigRepository");
        Intrinsics.checkNotNullParameter(cart3, "cart");
        this.mView = darkstoresBridgeActivity2;
        this.configurationLocalRepository = configurationLocalRepository3;
        this.locationConfigRepository = locationConfigurationRepository2;
        this.cart = cart3;
        this.cartMenuItems = new ArrayList<>();
        this.mcdKsaAddressUpdateIgnore = true;
        DarkstoresBridgeInteractor darkstoresBridgeInteractor = new DarkstoresBridgeInteractor(this, customerAddressesRepository, customerRepository, appVersionProvider, discoveryConfigurationRepository, locationConfigurationRepository2, (Scheduler) null, (Scheduler) null, 192, (DefaultConstructorMarker) null);
        this.mDarkstoresBridgeInteractor = darkstoresBridgeInteractor;
        this.mRestaurant = darkstoresBridgeInteractor.getDarkstore();
    }

    private final boolean canCheckComplianceStatusOfUser() {
        UserStatusDomainModule userStatusDomainModule = UserStatusDomainModule.INSTANCE;
        return userStatusDomainModule.provideUserStatusRepository().isAllowedToCheckStatusOfUser(userStatusDomainModule.getDurationStatusCanBeCheckedAgain());
    }

    private final void clearCartAndSetRestaurant() {
        Restaurant restaurant = GlobalDataModel.SELECTED.restaurant;
        Cart.getInstance().clearCart(this.mView);
        Cart.getInstance().setRestaurant(restaurant, this.mView);
    }

    private final boolean deselectAddress() {
        if (Customer.getInstance() == null || GlobalDataModel.HOME_SCREEN_MAP.MAP_FRST_UPDATE_OPTION == GlobalDataModel.HOME_SCREEN_MAP.UPDATE_NOW) {
            return false;
        }
        return true;
    }

    private final boolean enforceMapForCoordinates(Address address, boolean z11, boolean z12) {
        boolean z13 = false;
        if (!z11 && !z12 && !this.isNineCookiesTrackingEnabled) {
            this.isMapcompulsory = false;
        } else if (this.isNineCookiesTrackingEnabledFromAddress) {
            this.isMapcompulsory = false;
        } else if (address != null) {
            if (address.latitude <= 0.0d || address.longitude <= 0.0d) {
                z13 = true;
            }
            this.isMapcompulsory = z13;
        } else {
            this.isMapcompulsory = true;
        }
        return this.isMapcompulsory;
    }

    private final void failure() {
    }

    private final String getFormattedDateOfBirth(CustomerInfo customerInfo) {
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateInputField.DefaultDateFormat, locale);
        String str = null;
        try {
            Date parse = simpleDateFormat.parse(customerInfo.birthday);
            if (parse != null) {
                str = simpleDateFormat2.format(parse);
            }
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final boolean isCheckoutEnofrceMap(boolean z11, boolean z12) {
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

    private final void loadCustomerDetails() {
        DarkstoresBridgeInteractor darkstoresBridgeInteractor = this.mDarkstoresBridgeInteractor;
        if (darkstoresBridgeInteractor != null) {
            darkstoresBridgeInteractor.loadCustomerDetails();
        }
    }

    private final boolean needCompliance() {
        boolean z11;
        Country countryById = this.locationConfigRepository.getCountryById(this.configurationLocalRepository.selectedCountry().getCountryId());
        if (countryById == null || !countryById.isComplianceEnabled()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11 || !canCheckComplianceStatusOfUser()) {
            return false;
        }
        return true;
    }

    private final void onItemsAdded() {
        this.mView.onItemsAddedToCart();
    }

    private final void showUserVerificationView(Customer customer) {
        String str = customer.getCustomerInfo().firstName;
        String str2 = customer.getCustomerInfo().lastName;
        CustomerInfo customerInfo = customer.getCustomerInfo();
        Intrinsics.checkNotNullExpressionValue(customerInfo, "customer.customerInfo");
        String formattedDateOfBirth = getFormattedDateOfBirth(customerInfo);
        DarkstoresBridgeActivity darkstoresBridgeActivity = this.mView;
        Intrinsics.checkNotNullExpressionValue(str, "firstName");
        Intrinsics.checkNotNullExpressionValue(str2, "lastName");
        darkstoresBridgeActivity.showUserVerificationView(str, str2, formattedDateOfBirth);
    }

    public final void addItemsToCart() {
        float f11;
        Iterator<CartMenuItem> it = this.cartMenuItems.iterator();
        while (it.hasNext()) {
            this.cart.addItemForDarkstores(it.next(), this.mView);
        }
        ExitPointData exitPointData2 = this.exitPointData;
        if (exitPointData2 != null) {
            Iterable<ExitPointFeeDescription> feeDescriptions = exitPointData2.getFeeDescriptions();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(feeDescriptions, 10));
            for (ExitPointFeeDescription exitPointFeeDescription : feeDescriptions) {
                arrayList.add(new FeeDescription(FeeDescriptionType.valueOf(exitPointFeeDescription.getType()), exitPointFeeDescription.getName(), exitPointFeeDescription.getDescription(), (String) null, exitPointFeeDescription.getUrl(), exitPointFeeDescription.getUrlText()));
            }
            Cart cart2 = this.cart;
            float absoluteCartDiscount = exitPointData2.getAbsoluteCartDiscount();
            float deliveryAbsoluteDiscount = exitPointData2.getDeliveryAbsoluteDiscount();
            String cartId = exitPointData2.getCartId();
            String dijiniVendorId = exitPointData2.getDijiniVendorId();
            float absoluteTotalDiscount = exitPointData2.getAbsoluteTotalDiscount();
            Float deliveryTotal = exitPointData2.getDeliveryTotal();
            float f12 = 0.0f;
            if (deliveryTotal != null) {
                f11 = deliveryTotal.floatValue();
            } else {
                f11 = 0.0f;
            }
            Float serviceFee = exitPointData2.getServiceFee();
            if (serviceFee != null) {
                f12 = serviceFee.floatValue();
            }
            cart2.updateCartDarkstoreInfo(absoluteCartDiscount, deliveryAbsoluteDiscount, cartId, dijiniVendorId, absoluteTotalDiscount, f11, f12, exitPointData2.getSelectedFulfillmentPreference(), exitPointData2.getAgeRestricedLimit(), arrayList, exitPointData2.getDeliveryFee(), exitPointData2.getScheduledDeliveryDiscount());
        }
        if (this.cart.getCartItems().size() > 0) {
            onItemsAdded();
        } else {
            failure();
        }
    }

    public void checkIfBackupNeeded(@NotNull Restaurant restaurant) {
        Intrinsics.checkNotNullParameter(restaurant, "restaurantBackup");
        if (Cart.getInstance().getRestaurant() == null) {
            Cart.getInstance().setRestaurant(restaurant, this.mView);
            GlobalDataModel.SELECTED.updateRestaurant(restaurant);
            this.mRestaurant = restaurant;
        }
    }

    public void geoAddressNotReceived() {
    }

    @NotNull
    public final Cart getCart() {
        return this.cart;
    }

    @NotNull
    public final ArrayList<CartMenuItem> getCartMenuItems() {
        return this.cartMenuItems;
    }

    @NotNull
    public final ConfigurationLocalRepository getConfigurationLocalRepository() {
        return this.configurationLocalRepository;
    }

    @Nullable
    public final ExitPointData getExitPointData() {
        return this.exitPointData;
    }

    @NotNull
    public final LocationConfigurationRepository getLocationConfigRepository() {
        return this.locationConfigRepository;
    }

    @Nullable
    public final DarkstoresBridgeInteractor getMDarkstoresBridgeInteractor() {
        return this.mDarkstoresBridgeInteractor;
    }

    public void onCheckoutClicked(@NotNull Restaurant restaurant, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        boolean z16;
        boolean z17;
        boolean z18;
        Restaurant restaurant2 = restaurant;
        boolean z19 = z11;
        Intrinsics.checkNotNullParameter(restaurant, "restaurant");
        this.mRestaurant = restaurant2;
        this.mcdKsaAddressUpdateIgnore = z13;
        boolean z21 = false;
        this.isOneAddressUpdate = false;
        if (restaurant2 != null) {
            z16 = restaurant2.isForceMap;
        } else {
            z16 = false;
        }
        this.isRestaurantTrackOrder = z16;
        if (restaurant2 != null) {
            z17 = restaurant2.isForceMap;
        } else {
            z17 = false;
        }
        this.isForceMapFromRestaurant = z17;
        if (restaurant2 != null) {
            z18 = restaurant2.isNineCookiesEnabledRestaurant;
        } else {
            z18 = false;
        }
        this.isNineCookiesTrackingEnabled = z18;
        this.isNineCookiesTrackingEnabledFromAddress = z12;
        if (restaurant2 != null) {
            z21 = restaurant2.isTalabatGo;
        }
        this.isTalabatDevliveryAvailable = z21;
        this.issMapFirstReDirectCheckout = z14;
        Customer instance = Customer.getInstance();
        if (!instance.isLoggedIn()) {
            this.mView.onRedirectToLogin(enforceMapForCoordinates((Address) null, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
        } else if (!needCompliance() || z15) {
            Address selectedCustomerAddress = instance.getSelectedCustomerAddress();
            if (selectedCustomerAddress == null || selectedCustomerAddress.areaId != GlobalDataModel.SelectedAreaId) {
                this.isOneAddressUpdate = true;
                this.isCartFlow = z19;
                instance.deselectCustomerAddress(this.mView.getContext());
                this.mView.startLodingPopup();
                loadCustomerDetails();
                return;
            }
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (homeMapTemp.getUpdateAddressNotSaved() && homeMapTemp.getHomeMapSavedLatLng() != null) {
                this.mView.mapFirstRedirect(selectedCustomerAddress, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, z11, false, false, z14);
            } else if (homeMapTemp.getHomeMapSavedLatLng() != null && homeMapTemp.getEnabledHomeMapRedirectEnabled()) {
                this.mView.mapFirstRedirect(selectedCustomerAddress, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, z11, false, false, z14);
            } else if (enforceMapForCoordinates(selectedCustomerAddress, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
                this.mView.isMapCompulsory(selectedCustomerAddress, enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
            } else {
                this.isCartFlow = z19;
                this.mView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(instance, "customer");
            showUserVerificationView(instance);
        }
    }

    public void onCustomerinfoLoaded(@NotNull CustomerAddressInfoJsonResult customerAddressInfoJsonResult) {
        Intrinsics.checkNotNullParameter(customerAddressInfoJsonResult, "customerAddressInfoJsonResult");
        Customer instance = Customer.getInstance();
        if (instance.getSelectedCustomerAddress() != null) {
            HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
            if (homeMapTemp.getHomeMapSavedLatLng() != null && homeMapTemp.getEnabledHomeMapRedirectEnabled()) {
                this.mView.mapFirstRedirect(instance.getSelectedCustomerAddress(), isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
            } else if (enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
                Address selectedCustomerAddress = instance.getSelectedCustomerAddress();
                if (selectedCustomerAddress != null) {
                    this.mView.isMapCompulsory(selectedCustomerAddress, enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
                }
            } else {
                this.mView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
            }
        } else if (instance.getCustomerAddress(GlobalDataModel.SelectedAreaId) == null || instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).size() == 0) {
            HomeMapTemp homeMapTemp2 = HomeMapTemp.INSTANCE;
            if (homeMapTemp2.getHomeMapSavedLatLng() == null || !homeMapTemp2.getEnabledHomeMapRedirectEnabled()) {
                Address selectedCustomerAddress2 = instance.getSelectedCustomerAddress();
                if (selectedCustomerAddress2 != null) {
                    this.mView.isMapCompulsory(selectedCustomerAddress2, enforceMapForCoordinates(instance.getSelectedCustomerAddress(), this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), true, true, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
                    return;
                }
                return;
            }
            this.mView.mapFirstRedirect(instance.getSelectedCustomerAddress(), isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), true, true, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
        } else {
            if (instance.getCustomerAddress(GlobalDataModel.SelectedAreaId) != null) {
                boolean z11 = true;
                if (instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).size() != 1) {
                    HomeMapTemp homeMapTemp3 = HomeMapTemp.INSTANCE;
                    if (homeMapTemp3.getHomeMapSavedLatLng() == null || !homeMapTemp3.getEnabledHomeMapRedirectEnabled()) {
                        DarkstoresBridgeActivity darkstoresBridgeActivity = this.mView;
                        if (!this.isRestaurantTrackOrder && !this.isForceMapFromRestaurant) {
                            z11 = false;
                        }
                        darkstoresBridgeActivity.onRedirectToAddressSelection(z11, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false);
                        return;
                    }
                    this.mView.mapFirstRedirect((Address) null, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
                    return;
                }
            }
            Address address = instance.getCustomerAddress(GlobalDataModel.SelectedAreaId).get(0);
            Customer.getInstance().setSelectedCustomerAddress(this.mView, address.f58343id, address.areaId);
            HomeMapTemp homeMapTemp4 = HomeMapTemp.INSTANCE;
            if (homeMapTemp4.getHomeMapSavedLatLng() != null && homeMapTemp4.getEnabledHomeMapRedirectEnabled()) {
                if (deselectAddress()) {
                    Customer.getInstance().deselectCustomerAddress();
                }
                this.mView.mapFirstRedirect(address, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
            } else if (enforceMapForCoordinates(address, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant)) {
                DarkstoresBridgeActivity darkstoresBridgeActivity2 = this.mView;
                Intrinsics.checkNotNullExpressionValue(address, "address");
                darkstoresBridgeActivity2.isMapCompulsory(address, enforceMapForCoordinates(address, this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable);
            } else {
                this.mView.onRedirectToCheckOut(isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), this.isCartFlow, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, false, false);
            }
        }
    }

    public void onDataError() {
        this.mView.onDataError();
    }

    public void onDestroy() {
    }

    public void onGeoAddressRecieved(@Nullable Address address, @Nullable Address address2) {
        this.mView.stopLodingPopup();
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
            this.mView.mapFirstUpdateAddressRedirect(address2, isCheckoutEnofrceMap(this.isRestaurantTrackOrder, this.isForceMapFromRestaurant), false, false, this.isNineCookiesTrackingEnabled, this.isTalabatDevliveryAvailable, this.isCartFlow, false, false, this.issMapFirstReDirectCheckout);
        }
    }

    public void onNetworkError() {
    }

    public void onServerError(@Nullable VolleyError volleyError) {
        this.mView.onServerError(volleyError);
    }

    public final void prepareCart() {
        ExitPointData exitPointData2 = this.exitPointData;
        Unit unit = null;
        if (exitPointData2 != null) {
            for (ExitPointProduct map : exitPointData2.getItems()) {
                this.cartMenuItems.add(CartMenuItem.createWithDarkstoreProduct(DarkstoreCartItemMapper.Companion.map(map)));
            }
            if (this.cartMenuItems.size() > 0) {
                if (Cart.getInstance().hasItems()) {
                    clearCartAndSetRestaurant();
                }
                addItemsToCart();
            } else {
                failure();
            }
            DarkstoresBridgeInteractor darkstoresBridgeInteractor = this.mDarkstoresBridgeInteractor;
            if (darkstoresBridgeInteractor != null) {
                darkstoresBridgeInteractor.updateCartSpecialRequest(exitPointData2.getDarkstoresSpecialRequest());
                unit = Unit.INSTANCE;
            }
        }
        if (unit == null) {
            failure();
        }
    }

    public final void setCartMenuItems(@NotNull ArrayList<CartMenuItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.cartMenuItems = arrayList;
    }

    public final void setExitPointData(@Nullable ExitPointData exitPointData2) {
        this.exitPointData = exitPointData2;
    }

    public final void setMDarkstoresBridgeInteractor(@Nullable DarkstoresBridgeInteractor darkstoresBridgeInteractor) {
        this.mDarkstoresBridgeInteractor = darkstoresBridgeInteractor;
    }

    public void updateAddressWithGoogleApi(@NotNull Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.mView.startLodingPopup();
        DarkstoresBridgeInteractor darkstoresBridgeInteractor = this.mDarkstoresBridgeInteractor;
        if (darkstoresBridgeInteractor != null) {
            darkstoresBridgeInteractor.updateAddresswithGoogleAddress(address);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DarkstoresBridgePresenter(com.talabat.darkstores.view.DarkstoresBridgeActivity r12, com.talabat.user.address.domain.repository.CustomerAddressesRepository r13, library.talabat.mvp.login.domain.repository.CustomerRepository r14, com.talabat.configuration.discovery.AppVersionProvider r15, com.talabat.configuration.ConfigurationLocalRepository r16, com.talabat.configuration.discovery.DiscoveryConfigurationRepository r17, com.talabat.configuration.location.LocationConfigurationRepository r18, buisnessmodels.Cart r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r11 = this;
            r0 = r20
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0011
            buisnessmodels.Cart r0 = buisnessmodels.Cart.getInstance()
            java.lang.String r1 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r10 = r0
            goto L_0x0013
        L_0x0011:
            r10 = r19
        L_0x0013:
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.darkstores.presenter.DarkstoresBridgePresenter.<init>(com.talabat.darkstores.view.DarkstoresBridgeActivity, com.talabat.user.address.domain.repository.CustomerAddressesRepository, library.talabat.mvp.login.domain.repository.CustomerRepository, com.talabat.configuration.discovery.AppVersionProvider, com.talabat.configuration.ConfigurationLocalRepository, com.talabat.configuration.discovery.DiscoveryConfigurationRepository, com.talabat.configuration.location.LocationConfigurationRepository, buisnessmodels.Cart, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
