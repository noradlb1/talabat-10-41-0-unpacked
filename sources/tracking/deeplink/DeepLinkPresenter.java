package tracking.deeplink;

import JsonModels.MenuItemsResponseModel;
import JsonModels.Response.RestaurantSlugRM;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import buisnessmodels.Cart;
import buisnessmodels.ChoiceLoader;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import buisnessmodels.restaurantmenu.MenuResponseMapper;
import com.apptimize.c;
import com.facebook.AuthenticationTokenClaims;
import com.huawei.hms.flutter.map.constants.Param;
import com.huawei.hms.framework.common.ContainerUtils;
import com.talabat.configuration.MutableConfigurationLocalRepository;
import com.talabat.configuration.MutableLocationConfigurationRepository;
import com.talabat.configuration.discovery.AppVersionProvider;
import com.talabat.configuration.location.Area;
import com.talabat.configuration.payment.PaymentConfigurationRepository;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwf.data.FunWithFlags;
import com.talabat.core.navigation.domain.screen.voucherlist.VouchersListDeeplinkBuilder;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.feature.ulcampaign.domain.usecase.VoucherCampaignDeeplinkUseCase;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.growthSquad.VouchersNavigationActions;
import com.talabat.user.address.domain.repository.CustomerAddressesRepository;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import datamodels.City;
import datamodels.Country;
import datamodels.Cuisine;
import datamodels.DeliveryArea;
import datamodels.OrderDetails;
import datamodels.QuickFilter;
import datamodels.QuickRestaurant;
import datamodels.RateOrderReq;
import datamodels.Restaurant;
import datamodels.mappers.CityToOldCityMapper;
import datamodels.mappers.CountryToOldCountryMapper;
import io.reactivex.Scheduler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import library.talabat.SharedPreferencesManager;
import library.talabat.mvp.listingmenubridge.DarkstoresTrackingData;
import library.talabat.mvp.login.domain.repository.CustomerRepository;
import net.bytebuddy.description.type.TypeDescription;
import org.apache.commons.compress.compressors.CompressorStreamFactory;
import tracking.firebaseauth.TalabatFirebaseImpl;
import tracking.gtm.datalayerLogger.DatalayerLoggerImpl;
import tracking.gtm.datalayerLogger.DatalayerModel;
import tracking.observability.VendorInfoAPIObservability;

public class DeepLinkPresenter implements IDeepLinkPresenter, DeeplinkRequestListener {
    private static final String BRANCH_CODE = "bid";
    private static final String CHAIN_ID = "cid";
    private static final String DEEPLINK_INFO = "i";
    private static final String DEEPLINK_PICKUP_SCREEN = "pi";
    private static final String DEEPLINK_SHORT_NAME_RIDER_CHAT = "rc";
    private static final String DEEPLINK_TYPE = "t";
    private static final int EMPTY_INTEGER = -1;
    private static final String MIGRATED_VENDOR = "mv";
    private static final String PRODUCT_BY_SKU = "5";
    private static final String SCREEN_TITLE = "n";
    private final AppVersionProvider appVersionProvider;
    int areaId = AppUrlResult.dataError;
    private boolean areasLoaded = false;
    int branchId = AppUrlResult.dataError;
    private int brandId = 0;
    private CityToOldCityMapper cityToOldCityMapper;
    int countryId = AppUrlResult.dataError;
    private CountryToOldCountryMapper countryToOldCountryMapper;
    SparseArray<Cuisine> cuisineSparseArray = new SparseArray<>();
    private final CustomerAddressesRepository customerAddressesRepository;
    private final CustomerRepository customerRepository;
    Uri data;
    private IDeepLinkInteractor deepLinkInteractor;
    private DeepLinkStatusListener deepLinkStatusListener;
    private DeeplinkListener deeplinkListener;
    private boolean forceRedirectToHome = false;
    private final Scheduler ioScheduler;
    boolean isAppLink = false;
    private String isDeepLinkFromHomeWidget = "";
    private boolean isQatarSelected = false;
    boolean isTesting = false;
    private boolean isWebViewRedirection = false;
    private final MutableLocationConfigurationRepository locationConfigRepository;
    private final Scheduler mainScheduler;
    private final MutableConfigurationLocalRepository mutableConfigurationLocalRepository;
    @Nullable
    private final IObservabilityManager observabilityManager;
    private OrderTrackingDeeplinksCallback orderTrackingDeeplinksCallback;
    private String[] parts;
    private final PaymentConfigurationRepository paymentConfigurationRepository;
    private SharedPreferences preferences;
    private final SharedPreferencesManager preferencesManager;
    int restaurantId = AppUrlResult.dataError;
    private String shortName = "";
    private boolean shouldLoadAreas = false;
    private boolean shouldLoadUserInfo = false;
    SparseArray<String> slugSparseArray = new SparseArray<>();
    private final ITalabatFeatureFlag talabatFeatureFlag;
    int urlType = AppUrlResult.dataError;
    private boolean userInfoLoaded = false;
    private final VendorInfoAPIObservability vendorInfoAPIObservability;
    VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase;
    private String webRedirectionPath = "";

    public DeepLinkPresenter(DeeplinkListener deeplinkListener2, CustomerAddressesRepository customerAddressesRepository2, CustomerRepository customerRepository2, MutableLocationConfigurationRepository mutableLocationConfigurationRepository, SharedPreferencesManager sharedPreferencesManager, Scheduler scheduler, Scheduler scheduler2, SharedPreferences sharedPreferences, MutableConfigurationLocalRepository mutableConfigurationLocalRepository2, PaymentConfigurationRepository paymentConfigurationRepository2, ITalabatFeatureFlag iTalabatFeatureFlag, AppVersionProvider appVersionProvider2, VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase2, VendorInfoAPIObservability vendorInfoAPIObservability2, @Nullable IObservabilityManager iObservabilityManager) {
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.deeplinkListener = deeplinkListener2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.locationConfigRepository = mutableLocationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.preferences = sharedPreferences;
        this.preferencesManager = sharedPreferencesManager;
        this.appVersionProvider = appVersionProvider2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.voucherCampaignDeeplinkUseCase = voucherCampaignDeeplinkUseCase2;
        this.vendorInfoAPIObservability = vendorInfoAPIObservability2;
        this.observabilityManager = iObservabilityManager;
    }

    private void callMenuApi() {
        GlobalDataModel.JSON.menuItemsResponseModel = new MenuItemsResponseModel();
        GlobalDataModel.MENU.doNotLoad = true;
        if (ChoiceLoader.getInstance() != null) {
            ChoiceLoader.stopChoiceLoader();
        }
        MenuResponseMapper.INSTANCE.clear();
        IDeepLinkInteractor deepLinkInteractor2 = getDeepLinkInteractor();
        deepLinkInteractor2.getRestaurantInfoOnly(this.branchId + "");
    }

    private void dataLayerLinkRecieved(String str, String str2, String str3) {
        TalabatFirebaseImpl talabatFirebaseImpl = new TalabatFirebaseImpl();
        DatalayerLoggerImpl datalayerLoggerImpl = new DatalayerLoggerImpl(this.preferences);
        if (datalayerLoggerImpl.isForDisabling(getStringValue(str))) {
            datalayerLoggerImpl.removeLogging();
        } else {
            datalayerLoggerImpl.setLogger(talabatFirebaseImpl, str2, str3);
        }
    }

    private String getAreaIdFromDeeplink() {
        try {
            if (this.parts == null) {
                return "";
            }
            int i11 = 0;
            String str = "";
            while (true) {
                try {
                    String[] strArr = this.parts;
                    if (i11 >= strArr.length) {
                        return str;
                    }
                    String str2 = strArr[i11];
                    if (str2.replace(" ", "").contains("a=")) {
                        try {
                            str = str2.split("=")[1];
                        } catch (Exception unused) {
                            str = "";
                        }
                    }
                    i11++;
                } catch (Exception unused2) {
                    return str;
                }
            }
        } catch (Exception unused3) {
            return "";
        }
    }

    private String getCleanedSearchQuery(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            return str.replace("+", " ");
        }
        return str;
    }

    private QuickFilter getCollectionFromCollectionsDeeplink(String str) {
        QuickFilter quickFilter = null;
        if (GlobalDataModel.collections != null) {
            for (int i11 = 0; i11 < GlobalDataModel.collections.size(); i11++) {
                if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.collections.get(i11).getDeepLink()) && GlobalDataModel.collections.get(i11).getDeepLink() != null && GlobalDataModel.collections.get(i11).getDeepLink().equals(str)) {
                    quickFilter = GlobalDataModel.collections.get(i11);
                }
            }
        }
        return quickFilter;
    }

    private Country getCountry(int i11) {
        for (com.talabat.configuration.location.Country next : this.locationConfigRepository.countries()) {
            if (next.getCountry().getCountryId() == i11) {
                return this.countryToOldCountryMapper.apply(next);
            }
        }
        return null;
    }

    private String getCountryCodeFromAppLink(Uri uri) {
        if (uri.toString().contains("/kuwait/")) {
            return com.talabat.configuration.country.Country.KUWAIT.getTwoLetterCode();
        }
        if (uri.toString().contains("/ksa/") || uri.toString().contains("/saudi/")) {
            return com.talabat.configuration.country.Country.KSA.getTwoLetterCode();
        }
        if (uri.toString().contains("/bahrain/")) {
            return com.talabat.configuration.country.Country.BAHRAIN.getTwoLetterCode();
        }
        if (uri.toString().contains("/uae/")) {
            return com.talabat.configuration.country.Country.UAE.getTwoLetterCode();
        }
        if (uri.toString().contains("/oman/")) {
            return com.talabat.configuration.country.Country.OMAN.getTwoLetterCode();
        }
        if (uri.toString().contains("/qatar/")) {
            return com.talabat.configuration.country.Country.QATAR.getTwoLetterCode();
        }
        if (uri.toString().contains("/jordan/")) {
            return com.talabat.configuration.country.Country.JORDAN.getTwoLetterCode();
        }
        if (uri.toString().contains("/egypt/")) {
            return com.talabat.configuration.country.Country.EGYPT.getTwoLetterCode();
        }
        return "";
    }

    private int getCountryId(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case 3108:
                    if (str.equals("ae")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3142:
                    if (str.equals("bh")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3234:
                    if (str.equals("eg")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3368:
                    if (str.equals("iq")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 3397:
                    if (str.equals("jo")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 3436:
                    if (str.equals("kw")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3550:
                    if (str.equals("om")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 3600:
                    if (str.equals(FunWithFlags.ENV_QA)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3617:
                    if (str.equals("qr")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 3662:
                    if (str.equals("sa")) {
                        c11 = 9;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    return 4;
                case 1:
                    return 3;
                case 2:
                    return 9;
                case 3:
                    return 10;
                case 4:
                    return 8;
                case 5:
                    return 1;
                case 6:
                    return 5;
                case 7:
                case 8:
                    return 6;
                case 9:
                    return 2;
            }
        }
        return 0;
    }

    private String getCountryIdFromDeeplink() {
        try {
            if (this.parts == null) {
                return "";
            }
            int i11 = 0;
            String str = "";
            while (true) {
                try {
                    String[] strArr = this.parts;
                    if (i11 >= strArr.length) {
                        return str;
                    }
                    String str2 = strArr[i11];
                    if (str2.replace(" ", "").contains("c=")) {
                        try {
                            str = str2.split("=")[1];
                        } catch (Exception unused) {
                            str = "";
                        }
                    }
                    i11++;
                } catch (Exception unused2) {
                    return str;
                }
            }
        } catch (Exception unused3) {
            return "";
        }
    }

    private IDeepLinkInteractor getDeepLinkInteractor() {
        if (this.isTesting) {
            MockDeepLinkInteractor mockDeepLinkInteractor = new MockDeepLinkInteractor(this);
            this.deepLinkInteractor = mockDeepLinkInteractor;
            return mockDeepLinkInteractor;
        }
        if (this.deepLinkInteractor == null) {
            CustomerAddressesRepository customerAddressesRepository2 = this.customerAddressesRepository;
            CustomerRepository customerRepository2 = this.customerRepository;
            MutableConfigurationLocalRepository mutableConfigurationLocalRepository2 = this.mutableConfigurationLocalRepository;
            this.deepLinkInteractor = new DeepLinkInteractor(this, customerAddressesRepository2, customerRepository2, mutableConfigurationLocalRepository2, this.locationConfigRepository, this.ioScheduler, this.mainScheduler, mutableConfigurationLocalRepository2, this.paymentConfigurationRepository, this.talabatFeatureFlag, this.appVersionProvider, this.vendorInfoAPIObservability);
        }
        return this.deepLinkInteractor;
    }

    @Nullable
    private Bundle getDeeplinkBundle() {
        String[] strArr = this.parts;
        if (strArr == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String split : strArr) {
            String[] split2 = split.split("=");
            if (split2.length == 2) {
                bundle.putString(split2[0], split2[1]);
            }
        }
        return bundle;
    }

    private void handleMigratedVendorDeeplink() {
        int intValue = getIntValue(BRANCH_CODE);
        int intValue2 = getIntValue("cid");
        if (intValue != -1) {
            getDeepLinkInteractor().getMigratedVendorInfo(intValue);
        } else if (intValue2 != -1) {
            getDeepLinkInteractor().getRestaurantDetails(intValue2);
        }
    }

    private boolean isValidDeepLink() {
        if (this.parts != null) {
            String screenShortName = getScreenShortName();
            if (screenShortName == null) {
                setDefaultCountryAndArea();
            } else if (!screenShortName.equals("l") && !screenShortName.equals("s")) {
                setDefaultCountryAndArea();
            }
            if (TalabatUtils.isNullOrEmpty(screenShortName)) {
                return false;
            }
        }
        return true;
    }

    private void onAllRequiredDataAvailable() {
        FunWithFlags.updateSelectedCountry(this.mutableConfigurationLocalRepository.selectedCountry());
        processAppLink();
    }

    private void onDLForceRedirectToHomeScreenWithQatar() {
        int i11 = GlobalDataModel.SelectedCountryId;
        com.talabat.configuration.country.Country country = com.talabat.configuration.country.Country.QATAR;
        if (i11 == country.getCountryId()) {
            this.isQatarSelected = true;
        }
        getDeepLinkInteractor().loadAppinitCountrySpecficData(country.getCountryId());
    }

    private void redirectToGlobalHelpCenter() {
        this.deeplinkListener.onDeepLinkNavigateToGlobalHelpCenter(getStringValue(DEEPLINK_INFO), getStringValue("case_id"));
    }

    private void redirectToGroceryHome() {
        this.deeplinkListener.onDLRedirectToGroceryHomeScreen(getDeeplinkBundle());
    }

    private void redirectToHomeWithVoucherDetailsBottomSheet() {
        this.deeplinkListener.onDLRedirectToHomeScreenWithVoucherDetailsBottomSheet(getStringValue("campaign"), getStringValue("src"), getStringValue("brandId"));
    }

    private void redirectToRiderChat() {
        OrderTrackingDeeplinksCallback orderTrackingDeeplinksCallback2 = this.orderTrackingDeeplinksCallback;
        if (orderTrackingDeeplinksCallback2 != null) {
            orderTrackingDeeplinksCallback2.onRiderChatRedirection(getStringValue("orderId"));
        } else {
            this.deeplinkListener.onRiderChatRedirection(getStringValue("orderId"));
        }
    }

    @Deprecated(forRemoval = true)
    private void redirectToScreen(String str) {
        if (this.isAppLink) {
            return;
        }
        if (TalabatUtils.isNullOrEmpty(str)) {
            if (GlobalDataModel.SelectedCountryId == 0) {
                this.deeplinkListener.onDLRedirectToSelectCountryScreen();
            } else {
                this.deeplinkListener.onDLRedirectToHomeScreen();
            }
        } else if (str.equals("l")) {
            setForceRedirectToHomeThenListing();
        } else if (str.equals("s")) {
            getDeepLinkInteractor().getRestaurantDetails(getIntValue("v"));
        } else if (str.equals("q")) {
            getDeepLinkInteractor().getAllRestaurantsForCountry(GlobalDataModel.SelectedCountryId);
        } else if (str.equals(c.f41585a)) {
            getDeepLinkInteractor().getOrderDetails(getStringValue("t"));
        } else if (str.equals("r")) {
            this.deeplinkListener.onDLRedirectToReorderScreen();
        } else {
            boolean z11 = true;
            if (str.equals("e")) {
                if (Customer.getInstance().isLoggedIn()) {
                    setForceRedirectToHome();
                } else {
                    this.deeplinkListener.onDLRedirectToLoginScreen((Intent) null, !this.isDeepLinkFromHomeWidget.isEmpty());
                }
            } else if (str.equals(CompressorStreamFactory.Z)) {
                if (Customer.getInstance().isLoggedIn()) {
                    this.deeplinkListener.onDLRedirectToAccountInfoScreen();
                } else {
                    setForceRedirectToHome();
                }
            } else if (str.equals("o")) {
                getDeepLinkInteractor().rateOrder(getStringValue("t"));
            } else if (str.equals("b")) {
                if (Cart.getInstance().hasItems()) {
                    this.deeplinkListener.onDLRedirectToCartScreen();
                } else {
                    setForceRedirectToHome();
                }
            } else if (str.equals("t")) {
                this.deeplinkListener.onDLRedirectToOrdersListScreen();
            } else if (str.equals("d")) {
                this.deeplinkListener.onDLRedirectToAddressListScreen();
            } else if (str.equals("g")) {
                this.deeplinkListener.onDLRedirectToGiftVoucherScreen();
            } else if (str.equals(Param.X)) {
                this.deeplinkListener.onDLRedirectToRedeemVoucherScreen(getStringValue("vc"));
            } else if (str.equals("k")) {
                this.deeplinkListener.onDLRedirectToPurchaseTalabatCreditScreen();
            } else if (str.equals("h")) {
                this.deeplinkListener.onDLRedirectToOffersScreen();
            } else if (str.equals("w")) {
                this.deeplinkListener.onDLRedirectToNotificationScreen();
            } else if (str.equals("n")) {
                this.deeplinkListener.onDLRedirectToNewRestaurantScreen();
            } else if (str.equals("lc")) {
                this.deeplinkListener.onDLRedirectToLiveChatScreen(getStringValue("deptid"));
            } else if (str.equals("cs")) {
                this.deeplinkListener.onDLRedirectToTalabatCreditStatementScreen();
            } else if (str.equals("ss")) {
                this.deeplinkListener.onDLRedirectToSettingsScreen();
            } else if (str.equals("tw")) {
                String stringValue = getStringValue("url");
                String stringValue2 = getStringValue("qs");
                if (!TalabatUtils.isNullOrEmpty(stringValue2)) {
                    if (stringValue2.contains(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
                        stringValue2 = TypeDescription.Generic.OfWildcardType.SYMBOL + stringValue2.replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "=");
                    } else {
                        stringValue2 = "";
                    }
                }
                this.deeplinkListener.onDLRedirectToWebview(stringValue + stringValue2, this.isWebViewRedirection);
            } else if (str.equals("focq")) {
                onDLForceRedirectToHomeScreenWithQatar();
            } else if (str.equals("track")) {
                this.deeplinkListener.onDLRedirectToOrderTrackingWebview(getStringValue("url"));
            } else if (str.equals("loyalty")) {
                this.deeplinkListener.onDLRedirectTLoyaltyDashboardScreen();
            } else if (str.equals("voucher_wallet")) {
                String stringValue3 = getStringValue("campaign");
                String stringValue4 = getStringValue("src");
                String stringValue5 = getStringValue("brandId");
                String stringValue6 = getStringValue(VouchersListDeeplinkBuilder.OPEN_BOTTOMSHEET);
                if (stringValue6.isEmpty() || !Boolean.parseBoolean(stringValue6)) {
                    z11 = false;
                }
                if (Customer.getInstance().isLoggedIn()) {
                    this.deeplinkListener.onDLRedirectVoucherWalletScreen(stringValue3, stringValue4, stringValue5, z11);
                    return;
                }
                NavigatorModel navigationModel = VouchersNavigationActions.navigationModel(stringValue3, stringValue4, stringValue5, false, z11);
                Intent intent = new Intent(navigationModel.getAction());
                intent.putExtras(navigationModel.getOptions());
                this.deeplinkListener.onDLRedirectToLoginScreen(intent, false);
            } else if (str.equals("voucher_campaign")) {
                this.deeplinkListener.onDLRedirectToHomeScreen();
            } else if (str.equals("voucher_popup")) {
                redirectToHomeWithVoucherDetailsBottomSheet();
            } else if (str.equals("dine")) {
                redirectToTLife();
            } else if (str.equals("ds")) {
                getDeepLinkInteractor().getDarkstoresAvailability();
            } else if (str.equals(MIGRATED_VENDOR)) {
                handleMigratedVendorDeeplink();
            } else if (str.equals("wdash")) {
                this.deeplinkListener.onDeepLinkNavigateToWalletDashBoard();
            } else if (str.equals(AuthenticationTokenClaims.JSON_KEY_SUB)) {
                this.deeplinkListener.onDeepLinkNavigateToSubscriptionScreen();
            } else if (str.equals("paylater")) {
                this.deeplinkListener.onDeepLinkNavigateToBNPLDashboard();
            } else if (str.equals("ml")) {
                DatalayerModel datalayerModel = DatalayerModel.INSTANCE;
                dataLayerLinkRecieved(datalayerModel.getTYPE(), getStringValue(datalayerModel.getKEY()), getStringValue(datalayerModel.getUSERNAME()));
            } else if (str.equals("ghc")) {
                redirectToGlobalHelpCenter();
            } else if (str.equals(DEEPLINK_SHORT_NAME_RIDER_CHAT)) {
                redirectToRiderChat();
            } else if (str.equals(DEEPLINK_PICKUP_SCREEN)) {
                this.deeplinkListener.onDeepLinkNavigateToPickupScreen();
            } else if (str.equals("gem")) {
                this.deeplinkListener.onDeepLinkNavigateToGemComponent(getStringValue("t"));
            } else if (str.equals("tpro")) {
                this.deeplinkListener.onDeepLinkNavigateToTproBenefits();
            } else if (str.equals("gh")) {
                redirectToGroceryHome();
            } else if (str.equals(FilterEngine.DEEPLINKFILER.OFFERS)) {
                this.deeplinkListener.onDeepLinkNavigateToHomeOfOffers();
            } else {
                setForceRedirectToHome();
            }
        }
    }

    private void redirectToScreenFromUrl(int i11) {
        if (i11 == 100) {
            getDeepLinkInteractor().getRestaurants(this.areaId, GlobalDataModel.SelectedCityId, 0);
        } else if (i11 == 105) {
            callMenuApi();
        } else if (i11 == 106) {
            getDeepLinkInteractor().getAllRestaurantsForCountry(GlobalDataModel.SelectedCountryId);
        } else if (i11 == 107) {
            getDeepLinkInteractor().getRestaurantDetails(this.brandId);
        }
    }

    private void redirectToTLife() {
        String stringValue = getStringValue("v");
        String stringValue2 = getStringValue("from");
        String stringValue3 = getStringValue("subscribed");
        if (stringValue.equalsIgnoreCase("")) {
            DeeplinkListener deeplinkListener2 = this.deeplinkListener;
            boolean z11 = true;
            boolean z12 = !stringValue2.isEmpty();
            if (stringValue3.isEmpty() || !Boolean.parseBoolean(stringValue3)) {
                z11 = false;
            }
            deeplinkListener2.onDLRedirectTLifeVendorsList(z12, z11);
            return;
        }
        this.deeplinkListener.onDLRedirectTLifeOfferPage(stringValue);
    }

    private void restListDeepLink() {
        FilterEngine filterEngine;
        String stringValue = getStringValue("f");
        String stringValue2 = getStringValue("fid");
        String stringValue3 = getStringValue("sort");
        if (!TalabatUtils.isNullOrEmpty(stringValue)) {
            filterEngine = new FilterEngine();
            filterEngine.setFilterFromDeeplink(stringValue, stringValue2);
        } else {
            filterEngine = null;
        }
        if (!TalabatUtils.isNullOrEmpty(stringValue3)) {
            if (filterEngine == null) {
                filterEngine = new FilterEngine();
            }
            filterEngine.setSortFromDeepLink(stringValue3);
        }
        if (filterEngine != null) {
            GlobalDataModel.filterEngine = filterEngine;
        }
        this.deeplinkListener.onDLRedirectToRestauranListScreen();
    }

    private void setDefaultCountryAndArea() {
        int i11;
        List<Area> areas;
        if (GlobalDataModel.SelectedCountryId <= 0) {
            String countryIdFromDeeplink = getCountryIdFromDeeplink();
            if (!TalabatUtils.isNullOrEmpty(countryIdFromDeeplink)) {
                int countryId2 = getCountryId(countryIdFromDeeplink);
                this.mutableConfigurationLocalRepository.setSelectedCountry(countryId2);
                if (this.observabilityManager != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("country", "" + countryId2);
                }
            }
        }
        if (GlobalDataModel.SelectedAreaId <= 0) {
            String areaIdFromDeeplink = getAreaIdFromDeeplink();
            if (!TalabatUtils.isNullOrEmpty(areaIdFromDeeplink)) {
                try {
                    i11 = Integer.parseInt(areaIdFromDeeplink);
                } catch (Exception unused) {
                    i11 = AppUrlResult.dataError;
                }
                if (i11 > 0 && (areas = this.locationConfigRepository.areas()) != null) {
                    for (Area next : areas) {
                        if (next.getId() == i11) {
                            GlobalDataModel.SelectedAreaName = next.getAreaName();
                            GlobalDataModel.SelectedAreaId = next.getId();
                            GlobalDataModel.SelectedCityId = next.getCityId();
                            return;
                        }
                    }
                }
            }
        }
    }

    private void setForceRedirectToHome() {
        if (GlobalDataModel.SelectedCountryId == 0) {
            this.deeplinkListener.onDLRedirectToSelectCountryScreen();
        } else {
            this.deeplinkListener.onDLRedirectToHomeScreen();
        }
    }

    private void setForceRedirectToHomeThenListing() {
        setForceRedirectToHomeThenListing(false);
    }

    private void storeCampaignVoucherParams() {
        VoucherCampaignDeeplinkUseCase voucherCampaignDeeplinkUseCase2 = this.voucherCampaignDeeplinkUseCase;
        if (voucherCampaignDeeplinkUseCase2 != null) {
            voucherCampaignDeeplinkUseCase2.invoke(this.parts);
        }
    }

    public void appLinkRecived(Uri uri, Context context) {
        this.isWebViewRedirection = false;
        this.isAppLink = true;
        this.data = uri;
        if (!this.deeplinkListener.canHandleAppLink(uri)) {
            if (uri.toString().toLowerCase().contains("/restaurants/")) {
                String cuisineIdFromUrl = AppUrlResult.getCuisineIdFromUrl(uri);
                if (cuisineIdFromUrl != null) {
                    FilterEngine filterEngine = new FilterEngine();
                    GlobalDataModel.filterEngine = filterEngine;
                    filterEngine.setCuisineFromApplink(cuisineIdFromUrl);
                }
                setForceRedirectToHomeThenListing();
            } else if (uri.toString().toLowerCase().contains("reset-password")) {
                this.deeplinkListener.onALRedirectToDeepLinkWebviewScreen(uri.toString());
            } else if (uri.toString().toLowerCase().contains("/deeplink")) {
                this.isAppLink = false;
                deepLinkRecived(uri.getQuery());
            } else if (uri.toString().toLowerCase().contains("/talabat-mart")) {
                this.isAppLink = false;
                String countryCodeFromAppLink = getCountryCodeFromAppLink(uri);
                StringBuilder sb2 = new StringBuilder();
                if (!countryCodeFromAppLink.isEmpty()) {
                    sb2.append("c=");
                    sb2.append(countryCodeFromAppLink);
                    sb2.append("&s=ds");
                    if (uri.toString().toLowerCase().contains("/product/")) {
                        sb2.append("&t=");
                        sb2.append("5");
                        sb2.append("&i=");
                        sb2.append(uri.getLastPathSegment());
                    }
                }
                deepLinkRecived(sb2.toString());
            } else if (uri.toString().toLowerCase().contains("contact-us")) {
                this.deeplinkListener.onDeepLinkNavigateToGlobalHelpCenter("", "");
            } else {
                this.mutableConfigurationLocalRepository.setSelectedCountry(0);
                if (this.observabilityManager != null) {
                    new HashMap().put("uri", uri.toString());
                }
                GlobalDataModel.SelectedCountryName = "";
                GlobalDataModel.SelectedAreaId = AppUrlResult.dataError;
                GlobalDataModel.SelectedAreaName = "";
                GlobalDataModel.SelectedCityId = AppUrlResult.dataError;
                GlobalDataModel.SelectedCityName = "";
                if (AppUrlResult.processUrl(uri)) {
                    int countryIdFromUrl = AppUrlResult.getCountryIdFromUrl();
                    this.mutableConfigurationLocalRepository.setSelectedCountry(countryIdFromUrl);
                    if (this.observabilityManager != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("countryIdFromUrl", "" + countryIdFromUrl);
                    }
                    getDeepLinkInteractor().getRequiredData(context);
                    return;
                }
                if (this.observabilityManager != null) {
                    new HashMap();
                }
                this.deeplinkListener.onDLRedirectToHomeScreen();
            }
        }
    }

    public void deepLinkRecived(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(str);
        if (TalabatUtils.isNullOrEmpty(str)) {
            this.forceRedirectToHome = true;
            return;
        }
        this.isWebViewRedirection = false;
        this.isAppLink = false;
        if (!TalabatUtils.isNullOrEmpty(str)) {
            this.parts = str.split(ContainerUtils.FIELD_DELIMITER);
            storeCampaignVoucherParams();
        }
        this.forceRedirectToHome = !isValidDeepLink();
    }

    public int getIntValue(String str) {
        try {
            return Integer.parseInt(getStringValue(str));
        } catch (Exception unused) {
            return -1;
        }
    }

    public String getScreenShortName() {
        return getStringValue("s");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:7|8|9|10|11|12|23|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getStringValue(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String[] r1 = r8.parts     // Catch:{ Exception -> 0x003b }
            if (r1 == 0) goto L_0x003b
            int r2 = r1.length     // Catch:{ Exception -> 0x003b }
            java.lang.String[] r3 = new java.lang.String[r2]     // Catch:{ Exception -> 0x003b }
            int r1 = r1.length     // Catch:{ Exception -> 0x003b }
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ Exception -> 0x003b }
            r4 = 0
            r5 = r4
        L_0x000e:
            java.lang.String[] r6 = r8.parts     // Catch:{ Exception -> 0x003b }
            int r7 = r6.length     // Catch:{ Exception -> 0x003b }
            if (r5 >= r7) goto L_0x002a
            r6 = r6[r5]     // Catch:{ Exception -> 0x003b }
            java.lang.String r7 = "="
            java.lang.String[] r6 = r6.split(r7)     // Catch:{ Exception -> 0x003b }
            r7 = r6[r4]     // Catch:{ Exception -> 0x003b }
            r3[r5] = r7     // Catch:{ Exception -> 0x003b }
            r7 = 1
            r6 = r6[r7]     // Catch:{ Exception -> 0x0025 }
            r1[r5] = r6     // Catch:{ Exception -> 0x0025 }
            goto L_0x0027
        L_0x0025:
            r1[r5] = r0     // Catch:{ Exception -> 0x003b }
        L_0x0027:
            int r5 = r5 + 1
            goto L_0x000e
        L_0x002a:
            r5 = r0
        L_0x002b:
            if (r4 >= r2) goto L_0x003a
            r6 = r3[r4]     // Catch:{ Exception -> 0x003b }
            boolean r6 = r6.equals(r9)     // Catch:{ Exception -> 0x003b }
            if (r6 == 0) goto L_0x0037
            r5 = r1[r4]     // Catch:{ Exception -> 0x003b }
        L_0x0037:
            int r4 = r4 + 1
            goto L_0x002b
        L_0x003a:
            r0 = r5
        L_0x003b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: tracking.deeplink.DeepLinkPresenter.getStringValue(java.lang.String):java.lang.String");
    }

    public void onAreasRecieved() {
        int i11;
        boolean z11;
        if (this.isAppLink) {
            getDeepLinkInteractor().getUserInfo();
            i11 = AppUrlResult.dataError;
        } else {
            i11 = getIntValue("a");
        }
        this.areasLoaded = true;
        boolean z12 = false;
        if (!this.shouldLoadUserInfo || this.userInfoLoaded) {
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<Area> it = this.locationConfigRepository.areas().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Area next = it.next();
            if (next.getId() == i11) {
                City[] cityArr = TalabatUtils.getSelectedCountry(this.mutableConfigurationLocalRepository, this.locationConfigRepository).cities;
                int length = cityArr.length;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    }
                    City city = cityArr[i12];
                    if (city.f13843id == next.getCityId()) {
                        this.deeplinkListener.onDLSaveCity(city.f13843id, city.f13844name);
                        z12 = true;
                        break;
                    }
                    i12++;
                }
                this.deeplinkListener.onDLSaveArea(next.getId(), next.getAreaName());
            }
        }
        if (!this.isAppLink) {
            this.forceRedirectToHome = !z12;
            if (z11) {
                redirectToScreen(this.shortName);
            }
        }
    }

    public void onCountryReceived() {
        if (GlobalDataModel.cuisines != null) {
            onAllRequiredDataAvailable();
        } else {
            getDeepLinkInteractor().loadCuisines();
        }
    }

    public void onCountryRedirectionCompleted() {
        this.deeplinkListener.onDLForceRedirectToHomeScreenWithQatar(this.isQatarSelected, this.mutableConfigurationLocalRepository);
    }

    public void onCuisinesRecieved() {
        onAllRequiredDataAvailable();
    }

    public void onDarkStoresEntrySuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData) {
        String str;
        int intValue = getIntValue("t");
        String stringValue = getStringValue(DEEPLINK_INFO);
        Uri uri = this.data;
        if (uri != null) {
            str = uri.toString();
        } else {
            str = "";
        }
        String stringValue2 = getStringValue("n");
        this.deeplinkListener.onDLRedirectToDarkstores(restaurant, intValue, stringValue, str, stringValue2, darkstoresTrackingData);
    }

    public void onGroceryMenuLoadingCompleted(MenuItemsResponseModel menuItemsResponseModel) {
        if (this.isAppLink) {
            this.deeplinkListener.onALRedirectToGroceryMenu();
        }
    }

    public void onMigratedInfoSuccess(Restaurant restaurant, DarkstoresTrackingData darkstoresTrackingData) {
        this.deeplinkListener.onDLRedirectToDarkstores(restaurant, getIntValue("t"), getStringValue(DEEPLINK_INFO), "", getStringValue("n"), darkstoresTrackingData);
    }

    public void onOrderDetailsRecieved(OrderDetails orderDetails) {
        this.deeplinkListener.onDLRedirectToOrderDetailsScreen(orderDetails);
    }

    public void onRateOrderDataRecieved(RateOrderReq rateOrderReq) {
        this.deeplinkListener.onDLRedirectToRateOrderScreen(rateOrderReq);
    }

    public void onRestaurantDetailsLoaded(Restaurant restaurant, DeliveryArea[] deliveryAreaArr, City[] cityArr) {
        this.deeplinkListener.onDLRedirectToRestaurantScreen(restaurant, deliveryAreaArr, cityArr, getIntValue("t"), getStringValue(DEEPLINK_INFO));
    }

    public void onRestaurantListLoaded(ArrayList<QuickRestaurant> arrayList) {
        if (this.isAppLink) {
            this.deeplinkListener.onALRedirectToRestaurantSearchScreen();
        } else {
            this.deeplinkListener.onDLRedirectToRestaurantSearchScreen(getCleanedSearchQuery(getStringValue("q")));
        }
    }

    public void onRestaurantMenuLoaded() {
        if (this.isAppLink) {
            this.deeplinkListener.onALRedirectToRestauranMenu();
        }
    }

    public void onRestaurantSlugDetailsLoaded(RestaurantSlugRM restaurantSlugRM) {
        try {
            int i11 = restaurantSlugRM.result.urlTrans[0].restaurantId;
            this.brandId = i11;
            if (i11 > 0) {
                redirectToScreenFromUrl(this.urlType);
            } else {
                this.deeplinkListener.onDLRedirectToHomeScreen();
            }
        } catch (Exception unused) {
            this.deeplinkListener.onDLRedirectToHomeScreen();
        }
    }

    public void onUserInfoRecieved() {
        boolean z11 = true;
        this.userInfoLoaded = true;
        if (!this.isAppLink) {
            if (this.shouldLoadAreas && !this.areasLoaded) {
                z11 = false;
            }
            if (z11) {
                redirectToScreen(this.shortName);
            }
        } else if (GlobalDataModel.cuisines != null) {
            onAllRequiredDataAvailable();
        } else {
            getDeepLinkInteractor().loadCuisines();
        }
    }

    public void processAppLink() {
        int i11;
        this.countryId = AppUrlResult.getCountryIdFromUrl();
        List<Area> areas = this.locationConfigRepository.areas();
        List<com.talabat.configuration.location.Country> countries = this.locationConfigRepository.countries();
        if (!countries.isEmpty() && (i11 = this.countryId) != -200 && i11 > 0) {
            this.deeplinkListener.onDLSaveCountry(getCountry(i11), this.mutableConfigurationLocalRepository);
        }
        AppUrlResult.obtainDataFromSlug(this.locationConfigRepository);
        int areaIdFromUrl = AppUrlResult.getAreaIdFromUrl(this.locationConfigRepository);
        this.areaId = areaIdFromUrl;
        if (areaIdFromUrl != -200 && areaIdFromUrl > 0 && areas != null && areas.size() > 0 && !countries.isEmpty()) {
            for (Area next : areas) {
                int id2 = next.getId();
                int i12 = this.areaId;
                if (id2 == i12) {
                    GlobalDataModel.SelectedAreaId = i12;
                    GlobalDataModel.SelectedAreaName = next.getAreaName();
                    GlobalDataModel.SelectedCityId = next.getCityId();
                }
            }
            for (com.talabat.configuration.location.Country next2 : countries) {
                if (next2.getCountry().getCountryId() == this.mutableConfigurationLocalRepository.selectedCountry().getCountryId()) {
                    GlobalDataModel.SelectedCountryName = next2.getCountry().getCountryName();
                    Iterator<com.talabat.configuration.location.City> it = next2.getCities().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.talabat.configuration.location.City next3 = it.next();
                        if (next3.getId() == GlobalDataModel.SelectedCityId) {
                            GlobalDataModel.SelectedCityName = next3.getName();
                            break;
                        }
                    }
                }
            }
        }
        if (GlobalDataModel.SelectedAreaId > 0 && !TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedAreaName)) {
            this.deeplinkListener.onDLSaveArea(GlobalDataModel.SelectedAreaId, GlobalDataModel.SelectedAreaName);
        }
        if (GlobalDataModel.SelectedCityId > 0 && !TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedCityName)) {
            this.deeplinkListener.onDLSaveCity(GlobalDataModel.SelectedCityId, GlobalDataModel.SelectedCityName);
        }
        this.urlType = AppUrlResult.getUrlType();
        this.branchId = AppUrlResult.getBranchIdFromUrl();
        this.restaurantId = AppUrlResult.getRestaurantIdFromUrl();
        if (AppUrlResult.getCuisineIdFromUrl() == null) {
            AppUrlResult.obtainCuisineFromUrl();
            this.cuisineSparseArray = AppUrlResult.getCuisineIdFromUrl();
        }
        this.slugSparseArray = AppUrlResult.getSlugFromUrl();
        int i13 = this.urlType;
        if (i13 == -200) {
            return;
        }
        if (i13 != 100) {
            switch (i13) {
                case 105:
                    if (this.areaId <= 0 || this.branchId <= 0) {
                        this.deeplinkListener.onDLRedirectToHomeScreen();
                        return;
                    } else {
                        redirectToScreenFromUrl(i13);
                        return;
                    }
                case 106:
                    if (this.countryId > 0) {
                        redirectToScreenFromUrl(i13);
                        return;
                    } else {
                        this.deeplinkListener.onDLRedirectToHomeScreen();
                        return;
                    }
                case 107:
                    getDeepLinkInteractor().getRestaurantIdFromSlug(AppUrlResult.countryNameSlug, AppUrlResult.currentRestaurantSlug);
                    return;
                default:
                    this.deeplinkListener.onDLRedirectToHomeScreen();
                    return;
            }
        } else if (this.countryId <= 0 || this.areaId <= 0) {
            this.deeplinkListener.onDLRedirectToHomeScreen();
        } else {
            redirectToScreenFromUrl(i13);
        }
    }

    @Deprecated(forRemoval = true)
    public void redirectToDeepLink() {
        FilterEngine filterEngine;
        boolean z11 = this.isWebViewRedirection;
        if (z11) {
            this.deeplinkListener.onDLRedirectToWebview(this.webRedirectionPath, z11);
            this.isWebViewRedirection = false;
        } else if (!this.isAppLink) {
            DeepLinkStatusListener deepLinkStatusListener2 = this.deepLinkStatusListener;
            if (deepLinkStatusListener2 != null) {
                deepLinkStatusListener2.onDataRetrieved();
            }
            if (this.forceRedirectToHome) {
                setForceRedirectToHome();
                return;
            }
            this.shortName = getScreenShortName();
            this.isDeepLinkFromHomeWidget = getStringValue("from");
            if (this.shortName.equals("l")) {
                String stringValue = getStringValue("f");
                String stringValue2 = getStringValue("fid");
                String stringValue3 = getStringValue("sort");
                String stringValue4 = getStringValue(BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL);
                if (!TalabatUtils.isNullOrEmpty(stringValue)) {
                    filterEngine = new FilterEngine();
                    filterEngine.setFilterFromDeeplink(stringValue, stringValue2);
                } else {
                    filterEngine = null;
                }
                if (!TalabatUtils.isNullOrEmpty(stringValue3)) {
                    if (filterEngine == null) {
                        filterEngine = new FilterEngine();
                    }
                    filterEngine.setSortFromDeepLink(stringValue3);
                }
                if (!TalabatUtils.isNullOrEmpty(stringValue4)) {
                    try {
                        int parseInt = Integer.parseInt(stringValue4);
                        SharedPreferencesManager sharedPreferencesManager = this.preferencesManager;
                        sharedPreferencesManager.saveFavVerical(sharedPreferencesManager.getLastFavVertical(), parseInt);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(Integer.valueOf(parseInt));
                        this.preferencesManager.saveMoreTileVerticalId(arrayList);
                    } catch (NumberFormatException e11) {
                        LogManager.error(e11, "Cannot parse vertical id");
                    }
                } else {
                    this.preferencesManager.saveFavVerical(GlobalConstants.VerticalTypes.RESTAURANT, 0);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(0);
                    this.preferencesManager.saveMoreTileVerticalId(arrayList2);
                }
                String stringValue5 = getStringValue("li");
                String stringValue6 = getStringValue("from");
                if (stringValue5 != null && !stringValue5.equalsIgnoreCase("")) {
                    GlobalDataModel.collectionDeeplink = stringValue5;
                } else if (filterEngine != null) {
                    GlobalDataModel.filterEngine = filterEngine;
                }
                if (this.isDeepLinkFromHomeWidget.isEmpty()) {
                    setForceRedirectToHomeThenListing();
                    return;
                }
                GlobalDataModel.collectionDeeplink = null;
                this.deeplinkListener.onDeepLinkNavigateToCollectionScreen(stringValue5, stringValue6);
                return;
            }
            int countryId2 = getCountryId(getStringValue(c.f41585a));
            int intValue = getIntValue("a");
            if (GlobalDataModel.SelectedCountryId == 0) {
                if (countryId2 == 0) {
                    this.deeplinkListener.onDLRedirectToSelectCountryScreen();
                    return;
                }
                this.deeplinkListener.onDLSaveCountry(getCountry(countryId2), this.mutableConfigurationLocalRepository);
                this.shouldLoadUserInfo = true;
                if (intValue > 0) {
                    this.shouldLoadAreas = true;
                }
                getDeepLinkInteractor().getUserInfo();
                if (this.shouldLoadAreas) {
                    getDeepLinkInteractor().getAreas();
                }
            } else if (intValue > 0) {
                this.shouldLoadAreas = true;
                getDeepLinkInteractor().getAreas();
            } else {
                redirectToScreen(this.shortName);
            }
        }
    }

    public void redirectToHome() {
        setForceRedirectToHome();
    }

    public void setDeepLinkStatusListener(DeepLinkStatusListener deepLinkStatusListener2) {
        this.deepLinkStatusListener = deepLinkStatusListener2;
    }

    public void setTesting(boolean z11) {
        this.isTesting = z11;
    }

    public void showDarkstoresErrorMessage() {
        this.deeplinkListener.showDarkstoresErrorMessage();
    }

    public void talabatWebReceived(String str) {
        this.isAppLink = false;
        this.isWebViewRedirection = true;
        this.webRedirectionPath = str;
    }

    private void setForceRedirectToHomeThenListing(boolean z11) {
        if (GlobalDataModel.SelectedCountryId == 0) {
            this.deeplinkListener.onDLRedirectToSelectCountryScreen();
        } else if (this.preferencesManager.getLastFavVerticalId() == 1) {
            redirectToGroceryHome();
        } else {
            this.deeplinkListener.onDLRedirectToHomeScreenThenListing(z11);
        }
    }

    public void onRestaurantListLoaded() {
        if (this.isAppLink) {
            this.deeplinkListener.onALRedirectToRestauranListScreen();
            return;
        }
        String stringValue = getStringValue("li");
        if (TalabatUtils.isNullOrEmpty(stringValue) || GlobalDataModel.collections == null) {
            restListDeepLink();
            return;
        }
        QuickFilter collectionFromCollectionsDeeplink = getCollectionFromCollectionsDeeplink(stringValue);
        if (collectionFromCollectionsDeeplink != null) {
            Restaurant[] restaurantArr = GlobalDataModel.restaurants;
            int length = restaurantArr.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (restaurantArr[i11].getFiltersId().contains(collectionFromCollectionsDeeplink.getId())) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (z11) {
                this.deeplinkListener.onDLRedirectToRestauransQuickFilterListScreen(collectionFromCollectionsDeeplink);
            } else {
                this.deeplinkListener.onDLRedirectToRestauranListScreen();
            }
        } else {
            this.deeplinkListener.onDLRedirectToRestauranListScreen();
        }
    }

    public DeepLinkPresenter(OrderTrackingDeeplinksCallback orderTrackingDeeplinksCallback2, CustomerAddressesRepository customerAddressesRepository2, CustomerRepository customerRepository2, MutableLocationConfigurationRepository mutableLocationConfigurationRepository, SharedPreferencesManager sharedPreferencesManager, Scheduler scheduler, Scheduler scheduler2, SharedPreferences sharedPreferences, MutableConfigurationLocalRepository mutableConfigurationLocalRepository2, PaymentConfigurationRepository paymentConfigurationRepository2, ITalabatFeatureFlag iTalabatFeatureFlag, AppVersionProvider appVersionProvider2, VendorInfoAPIObservability vendorInfoAPIObservability2, @Nullable IObservabilityManager iObservabilityManager) {
        CityToOldCityMapper cityToOldCityMapper2 = new CityToOldCityMapper();
        this.cityToOldCityMapper = cityToOldCityMapper2;
        this.countryToOldCountryMapper = new CountryToOldCountryMapper(cityToOldCityMapper2);
        this.orderTrackingDeeplinksCallback = orderTrackingDeeplinksCallback2;
        this.customerAddressesRepository = customerAddressesRepository2;
        this.customerRepository = customerRepository2;
        this.locationConfigRepository = mutableLocationConfigurationRepository;
        this.ioScheduler = scheduler;
        this.mainScheduler = scheduler2;
        this.preferences = sharedPreferences;
        this.preferencesManager = sharedPreferencesManager;
        this.appVersionProvider = appVersionProvider2;
        this.mutableConfigurationLocalRepository = mutableConfigurationLocalRepository2;
        this.paymentConfigurationRepository = paymentConfigurationRepository2;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.vendorInfoAPIObservability = vendorInfoAPIObservability2;
        this.observabilityManager = iObservabilityManager;
    }
}
