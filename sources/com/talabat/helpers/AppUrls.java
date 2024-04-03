package com.talabat.helpers;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.gem.adapters.data.ServerKt;
import com.talabat.restaurants.v2.data.vendors.VendorsBaseUrl;
import com.talabat.talabatcommon.feature.TalabatCommonUrlConstantsKt;
import com.talabat.talabatcommon.feature.ridersTip.UrlConstantsKt;
import com.talabat.talabatcommon.feature.vouchers.loyalty.LoyaltyUrlConstants;

public class AppUrls {
    public static final String ACCEPT_GEM_URL;
    public static final String ACCOUNT_INFO;
    public static final String ADYEN_RECUR_PAYMENT_API = "adyenapi/v1/purchase/recur";
    public static final String APP_FEEDBACK;
    public static final String AREA_POLYGON;
    public static final String BASEURL;
    public static final String CANCEL_GEM_URL;
    public static final String CHANGE_EMAIL;
    public static final String CHANGE_PASSWORD;
    public static final String CHECK_NUMBER;
    public static final String COMPLETE_GEM_URL = (BASEURLS.getBaseurl() + "v1/restaurants/completedGem/{branchId}/{orderId}/{countryId}");
    public static final String CUSTOMVOUCHER;
    public static final String DARKSTORES_URL;
    public static final String DECRYPTION_URL;
    public static final String DELETESAVEDCARD;
    public static final String DELETE_ADDRESS;
    public static final String FORGOT_PASSWORD_TALABAT;
    public static final String GETADDRESSES = (BASEURLS.getBaseurl() + "v1/customer/{cityid}/addresses/");
    public static final String GETAPPINFO;
    public static final String GETAPPINFOV2;
    public static final String GETAREAFROMCODINATES;
    public static final String GETAREAS;
    public static final String GETCOUNTRYAREAS;
    public static final String GETCUISINES;
    public static final String GETGOOGLEADDRESS;
    public static final String GETGOOGLEADDRESSV2;
    public static final String GETGOOGLE_ADDRESS_MICROSERVICE;
    public static final String GETLANDINGPAGE;
    public static final String GETLATLONGFROMSUGGESTION;
    public static final String GETLOGIN;
    public static final String GETMENUSECTIONSWITHHEROIMAGE;
    public static final String GETPLACESSUGGESTION;
    public static final String GETQUALIFIEDCOUPONS;
    public static final String GETRESTANTS;
    public static final String GETRESTANTS_INFO;
    public static final String GETRESTANTS_V2;
    public static final String GETRESTAURANT_DELIVERY_TIMES;
    @Deprecated
    public static final String GETUSERINFO;
    public static final String GET_ADDRESS_BASED_DELIVERY_AREA;
    public static final String GET_ALL_BINS;
    public static final String GET_BIN_DETAILS;
    public static final String GET_BIN_RESTRICTION_FOR_VOUCHER;
    public static final String GET_BIN_TOKENS;
    public static final String GET_BIN_VOUCHER;
    public static final String GET_CREDIT_LIST;
    public static final String GET_GEM_OFFERS;
    public static final String GET_GEO_ADDRESS_BASED_RES_BRANCH;
    public static final String GET_GIFTVOUCHER;
    public static final String GET_GIFTVOUCHER_TRANSACTION_DETAILS;
    public static final String GET_LOYALTY_VOUCHER_INFO;
    public static final String GET_PREVIOUS_ORDER_LIST;
    public static final String GET_QC_PREVIOUS_ORDER_SWIMLANE = (BASEURLS.buildRootUrl("release") + "grocery/v1/{countryCode}/swimlanes/buy-again?isDarkstore={isDarkstore}&talabatBranchId={talabatBranchId}");
    public static final String GET_SHOP_STATUS;
    public static final String GET_TALABATCREDIT_STATEMENT;
    public static final String GET_TALABAT_CREDIT_TRANSACTION_DETAILS;
    public static final String GET_TERMS_URL;
    public static final String GET_UPSELLITEMS;
    public static final String GET_USERFEEDBACK = (BASEURLS.getCheckoutBaseUrl() + "trackapi/v1/track/{encryptedTransactionID}/deliveryfeedback");
    public static final String GLOBAL_SEARCH_BASE_URL = buildGlobalSearchBaseUrl("release");
    public static final String GROCERY_SEARCH_ALL;
    public static final String GROCERY_SORT_FILTER;
    public static final String INFORMAP_ADDRESS_CONVERT_BRANCH_ID;
    public static final String INSTRUMENTATION_TESTING_SERVER_BASE_URL = "http://localhost:8000/";
    public static final String LAST_ORDER_DETAILS;
    public static final String LOYALTY_VOUCHER_BASE_URL;
    public static final String MAPUSERIDS;
    public static final String MCD_BAHRAIN_ADDRESS_GRL_UPDATE;
    public static final String MCD_BAHRAIN_GET_BLOCKS;
    public static final String MCD_BAHRAIN_GET_BRANCH_ID;
    public static final String MCD_JORDAN_GET_BRANCH_ID;
    public static final String MCD_KSA_CONVERT_TO_ADDRESS;
    public static final String MCD_KSA_CONVERT_TO_ADDRESS_JORDAN;
    public static final String MCD_KSA_GET_BRANCH_ID;
    public static final String MOBILENUMBERVERIFY;
    public static final String OFFERSLIST;
    public static final String ORDERDETAILSTALABAT;
    public static final String ORDERLIST;
    public static final String ORDERLIST_COUNTRYID_PAGE;
    public static final String PAYMENT_ERROR;
    public static final String PERSEUS_URL = (BASEURLS.getBaseUrlForPerseus() + "v1/insert/talabat/hit");
    public static final String PLACEORDER;
    public static final String PLACEORDER_SEGMENT = "orders";
    public static final String PURCHASE_TALABAT_CREDIT;
    public static final String QUICKFINDRESTAURANTS;
    public static final String QUICK_USER_REGISTRATION = (BASEURLS.getBaseurl() + "v1/pages/thankyou/quickregister");
    public static final String RATEORDER = (BASEURLS.getBaseurl() + "v1/orders/{encryptedOrderId}/ratings");
    public static final String RATE_BASE_URL = buildRateBaseUrl("release");
    public static final String REDEEM_TALABATCREDIT_VOUCHER;
    public static final String REJECT_GEM_URL;
    public static final String REORDERARES;
    public static final String REORDER_ITEMS_WITH_LOCATION;
    public static final String RESTAURANTSLUGURL;
    public static final String RESTAURANT_DETAILS;
    public static final String RESTAURANT_DETAILS_WITH_DELAREAS;
    public static final String RESTAURANT_FRANCHAISE_BASED_LOCATION;
    public static final String RESTAURANT_FRANCHASE;
    public static final String RESTAURANT_POLYGON;
    public static final String RESTAURANT_REVIEWS_PAGE;
    public static final String ROOTURL;
    public static final String SAVE_USERFEEDBACK = (BASEURLS.getCheckoutBaseUrl() + "trackapi/v1/track/deliveryfeedback");
    public static final String SPLIT_GROCERY_ITEMS_FOR_SECTION;
    public static final String SPLIT_GROCERY_MENU;
    public static final String SPLIT_RESTAURANT_ALL_CHOICE;
    public static final String SPLIT_RESTAURANT_CHOICE;
    public static final String SPLIT_RESTAURANT_INFO_WITH_LOCATION;
    public static final String SPLIT_RESTAURANT_MENU;
    public static final String SPLIT_RESTAURANT_THIRD_CHOICE;
    public static final String TALABAT_CREDIT_CASHBACK;
    public static final String TALABAT_CREDIT_CASHBACK_BASEURL;
    public static final String TRACKING_ORDER_STATUS_V2 = (buildTrackBaseUrl("release") + "api/v1/Track/order/{encryptedOrderId}/{isTgo}");
    public static final String TRACKING_TRANSACTION_V2 = (buildTrackBaseUrl("release") + "api/v1/Track/transaction/{encryptedTransId}/{isTgo}");
    public static final String TRANSACTION = (BASEURLS.getBaseurl() + "v1/apps/" + TRANSACTION_THANK_YOU_SEGMENT + "/{transactionId}");
    public static final String TRANSACTION_THANK_YOU_SEGMENT = "thankyou";
    public static final String UPDATE_ADDRESS_WITH_LAT_LNG;
    public static final String UPDATE_NUMBER;
    public static final String USER_LOCATION_BASE_URL;
    public static final String VALIDATEADDRESS;
    public static final String VENDORS_BASE_URL;
    public static final String VENDORS_URL;
    public static final String VERIFY_OPTION;
    public static final String VOUCHERS_UN_APPLY_ALL;
    public static final String WALLET_CREDIT_CARD_AB_TEST_BASE_URL = "https://api.talabat.com/apiAndroid/";
    public static final String WALLET_CREDIT_CARD_AB_TEST_URL = "https://api.talabat.com/apiAndroid/v1/customer/WalletABTestUserExists";

    static {
        String baseurl = BASEURLS.getBaseurl();
        BASEURL = baseurl;
        String checkoutBaseUrl = BASEURLS.getCheckoutBaseUrl();
        ROOTURL = checkoutBaseUrl;
        String buildVendorsBaseUrl = buildVendorsBaseUrl("release");
        VENDORS_BASE_URL = buildVendorsBaseUrl;
        String buildUserLocationBaseURL = BASEURLS.buildUserLocationBaseURL("release");
        USER_LOCATION_BASE_URL = buildUserLocationBaseURL;
        String buildLoyaltyVoucherBaseURL = buildLoyaltyVoucherBaseURL();
        LOYALTY_VOUCHER_BASE_URL = buildLoyaltyVoucherBaseURL;
        String baseurlForCashback = BASEURLS.getBaseurlForCashback("release");
        TALABAT_CREDIT_CASHBACK_BASEURL = baseurlForCashback;
        GETLANDINGPAGE = baseurl + "v1/pages/landing";
        GETAREAS = baseurl + "v1/pages/home/area/";
        GETCOUNTRYAREAS = baseurl + "v1/apps/areas/";
        GETCUISINES = baseurl + "v1/apps/cuisine/";
        GETUSERINFO = baseurl + "v1/apps/userinfo/";
        GETAPPINFO = baseurl + "v1/apps/appinfo/";
        GETAPPINFOV2 = baseurl + "v2/apps/appinfo/";
        GETAREAFROMCODINATES = baseurl + "v1/apps/googlearea/{latitude}/{longitude}/{countryid}";
        VENDORS_URL = buildVendorsBaseUrl + "/api/v2/vendors/";
        DARKSTORES_URL = buildVendorsBaseUrl + "/api/v1/darkstore/{areaId}/{latitude}/{longitude}";
        GETRESTANTS = checkoutBaseUrl + "restaurantapi/v1/vendors";
        GETRESTANTS_INFO = checkoutBaseUrl + "restaurantapi/v1/vendorslistinginfo";
        GETRESTANTS_V2 = checkoutBaseUrl + "restaurantapi/v2/vendors";
        GET_TERMS_URL = baseurl + "v1/restaurants/collectionterms";
        RESTAURANT_DETAILS = baseurl + "v1/cart/restaurant/{restaurantid}/branch/{branchid}/area/{areaid}";
        RESTAURANT_REVIEWS_PAGE = baseurl + "v1/branches/{branchid}/reviews/{pageNumber}";
        QUICKFINDRESTAURANTS = baseurl + "v1/restaurants/quickfind/{countryid}";
        RESTAURANT_DETAILS_WITH_DELAREAS = baseurl + "v1/restaurants/info/{restaurantid}";
        RESTAURANT_FRANCHASE = baseurl + "v1/restaurants/franchise/{restaurantgroupid}/{areaid}";
        GETMENUSECTIONSWITHHEROIMAGE = baseurl + "v1/restaurants/branches/{Branchid}/areas/{areaid}/menu";
        OFFERSLIST = baseurl + "v1/apps/promotions/{countryid}";
        DELETE_ADDRESS = baseurl + "v1/customer/{cityId}/addresses/del/{AddressId}";
        GETLOGIN = baseurl + "v1/AuthToken";
        FORGOT_PASSWORD_TALABAT = baseurl + "v1/Account/ForgetPassword/{countryId}";
        VALIDATEADDRESS = baseurl + "v1/customer/address/validate";
        ORDERLIST = baseurl + "v1/orders/city/{CityId}/area/{areaId}";
        ORDERLIST_COUNTRYID_PAGE = baseurl + "v1/orders/country/{countryid}/{pageNumber}";
        GETRESTAURANT_DELIVERY_TIMES = baseurl + "v1/branches/{Branchid}/areas/{areaid}/deliverytimings?status={restaurantstatus}";
        REORDER_ITEMS_WITH_LOCATION = baseurl + "v2/orders/{orderid}/reorder";
        REORDERARES = baseurl + "/v1/orders/{orderid}/areas-for-reorder";
        ORDERDETAILSTALABAT = baseurl + TalabatCommonUrlConstantsKt.ORDER_DETAIL_URL;
        PLACEORDER = baseurl + "v1/" + PLACEORDER_SEGMENT;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(baseurl);
        sb2.append("v1/cart/coupons/{branchId}/{areaId}/{total}/");
        GETQUALIFIEDCOUPONS = sb2.toString();
        CUSTOMVOUCHER = baseurl + "v1/apps/campaign/{restaurantid}";
        CHANGE_EMAIL = baseurl + "v1/account/ChangeEmail";
        CHANGE_PASSWORD = baseurl + "v1/account/ChangePassword";
        GET_GIFTVOUCHER = baseurl + "v1/customer/countries/{countryid}/giftvouchers";
        REDEEM_TALABATCREDIT_VOUCHER = baseurl + "v1/customer/countries/{countryId}/creditvoucher/{creditvoucher}";
        GET_GIFTVOUCHER_TRANSACTION_DETAILS = baseurl + "v1/country/{countryid}/thankyouGiftVoucher/{transid}";
        GET_TALABATCREDIT_STATEMENT = baseurl + "v1/customer/countries/{countryid}/creditstatement";
        GET_CREDIT_LIST = baseurl + "v1/customer/countries/{countryId}/talabatcredit";
        PURCHASE_TALABAT_CREDIT = baseurl + "v1/customer/countries/{countryId}/talabatcredit";
        GET_TALABAT_CREDIT_TRANSACTION_DETAILS = baseurl + "v1/country/{countryid}/thankyouTalabatCredit/{transid}";
        ACCOUNT_INFO = baseurl + "v1/customer";
        PAYMENT_ERROR = baseurl + "v1/apps/paymenterror/{errorSlug}";
        APP_FEEDBACK = baseurl + "v1/customer/feedback";
        GETPLACESSUGGESTION = baseurl + "v1/apps/nearbyplaces/{countryid}";
        GETLATLONGFROMSUGGESTION = baseurl + "v1/apps/googlePlaceDetails/{placeid}";
        DELETESAVEDCARD = baseurl + "v1/customer/delcard/{tokenName}/{payProvider}";
        MOBILENUMBERVERIFY = baseurl + "v1/customer/verify";
        VERIFY_OPTION = baseurl + "v2/customer/verifyoption";
        UPDATE_NUMBER = baseurl + "v2/customer/editmobnumber";
        CHECK_NUMBER = baseurl + "v2/customer/mobilecheck";
        AREA_POLYGON = baseurl + "v1/apps/areas/{areaId}/polygon";
        RESTAURANTSLUGURL = baseurl + "v1/restaurants/{countrySlug}/slug/{restaurantSlug}";
        GET_UPSELLITEMS = baseurl + "v1/restaurants/{restautandid}/branches/{branchid}/upsell";
        INFORMAP_ADDRESS_CONVERT_BRANCH_ID = checkoutBaseUrl + "informap/v1/stores";
        DECRYPTION_URL = baseurl + "v1/decrypt/vcpayload";
        GET_GEM_OFFERS = baseurl + "v1/restaurants/gemOffers";
        ACCEPT_GEM_URL = baseurl + ServerKt.ACCEPT_GEM_URL;
        REJECT_GEM_URL = baseurl + ServerKt.REJECT_GEM_URL;
        CANCEL_GEM_URL = baseurl + "v1/restaurants/cancelGem/{countrySlug}/{offerId}";
        GET_BIN_VOUCHER = baseurl + "v1/orders/binvoucher";
        GET_BIN_TOKENS = baseurl + "v2/customer/tokens/{payProvider}/{countryId}/{restaurantId}/{branchId}/{areaId}";
        GET_BIN_DETAILS = baseurl + "v1/restaurants/binofferdetails";
        MCD_BAHRAIN_GET_BLOCKS = checkoutBaseUrl + "informap/v1/country/{countryId}/blocks";
        MCD_BAHRAIN_GET_BRANCH_ID = checkoutBaseUrl + "informap/v1/country/{countryId}/stores";
        MCD_BAHRAIN_ADDRESS_GRL_UPDATE = baseurl + "v1/customer/address/grl";
        MCD_KSA_CONVERT_TO_ADDRESS = checkoutBaseUrl + "informap/v1/country/{countryId}/street";
        MCD_KSA_GET_BRANCH_ID = checkoutBaseUrl + "informap/v1/country/ksa/store";
        MCD_JORDAN_GET_BRANCH_ID = checkoutBaseUrl + "informap/v1/jordan/store";
        MCD_KSA_CONVERT_TO_ADDRESS_JORDAN = checkoutBaseUrl + "informap/v1/jordan/street";
        MAPUSERIDS = baseurl + "v1/customer/devicetokens";
        SPLIT_RESTAURANT_INFO_WITH_LOCATION = checkoutBaseUrl + "restaurantapi/v3/branch/{branchId}/info";
        SPLIT_RESTAURANT_MENU = checkoutBaseUrl + "menuapi/v2/branches/{branchId}/menu";
        SPLIT_RESTAURANT_CHOICE = checkoutBaseUrl + "menuapi/v2/branches/{branchId}/menu/{sectionId}/choices";
        SPLIT_RESTAURANT_ALL_CHOICE = checkoutBaseUrl + "menuapi/v2/branches/{branchId}/sectionchoices";
        SPLIT_GROCERY_MENU = checkoutBaseUrl + "menuapi/v1/branches/{branchId}/grocerymenu";
        SPLIT_GROCERY_ITEMS_FOR_SECTION = checkoutBaseUrl + "menuapi/v1/branches/{branchId}/grocerysectionitems/{sectionId}/{pageNumber}";
        GROCERY_SEARCH_ALL = checkoutBaseUrl + "menuapi/v1/branches/{branchId}/menu/search";
        GROCERY_SORT_FILTER = checkoutBaseUrl + "menuapi/v1/branches/{branchId}/grocerysectionitems/{sectionId}/filter";
        SPLIT_RESTAURANT_THIRD_CHOICE = checkoutBaseUrl + "menuapi/v2/subchoices";
        UPDATE_ADDRESS_WITH_LAT_LNG = baseurl + "v1/customer/address/updateinfo";
        GET_ALL_BINS = baseurl + "v1/cardbin/binOffers";
        GET_ADDRESS_BASED_DELIVERY_AREA = baseurl + "v2/customer/addresses";
        GET_GEO_ADDRESS_BASED_RES_BRANCH = baseurl + "v3/apps/address";
        RESTAURANT_FRANCHAISE_BASED_LOCATION = baseurl + "v1/restaurants/franchise/branches";
        RESTAURANT_POLYGON = buildVendorsBaseUrl + "/api/v2/vendors/{vendorid}/fullpolygon/{latitude}/{longitude}";
        LAST_ORDER_DETAILS = baseurl + "v1/apps/userorders/{countryid}";
        TALABAT_CREDIT_CASHBACK = baseurlForCashback + "Cashback/CalculateEstimatedCashback";
        GETGOOGLEADDRESSV2 = baseurl + "v2/apps/address/{latitude}/{longitude}/{countryid}";
        GETGOOGLEADDRESS = baseurl + "v1/apps/address/{latitude}/{longitude}/{countryid}";
        GETGOOGLE_ADDRESS_MICROSERVICE = buildUserLocationBaseURL + "Location/{latitude}/{longitude}/{countryid}";
        GET_LOYALTY_VOUCHER_INFO = buildLoyaltyVoucherBaseURL + "api/v1/me/vouchers/{loyaltyVoucherId}?brandId={brandId}";
        VOUCHERS_UN_APPLY_ALL = buildLoyaltyVoucherBaseURL + "api/v1/me/vouchers/unapply-all";
        GET_BIN_RESTRICTION_FOR_VOUCHER = buildLoyaltyVoucherBaseURL + "api/v2/me/vouchers/apply?customerVoucherId={customerVoucherId}";
        GET_PREVIOUS_ORDER_LIST = baseurl + "v2/orders/previous-orders";
        GET_SHOP_STATUS = buildVendorsBaseUrl + "/api/v3/vendors/status";
    }

    public static String buildGlobalSearchBaseUrl(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (BASEURLS.shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://gs.talabat.com";
        }
        if (BASEURLS.shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        return "https://gs-qa.talabat.com";
    }

    private static String buildLoyaltyVoucherBaseURL() {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (BASEURLS.shouldUseProductionURLs("release", talabatEnvironment.getEnvironment())) {
            return "https://loyalty.talabat.com/";
        }
        if (BASEURLS.shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        return LoyaltyUrlConstants.URL_LOYALTY_BASE_QA;
    }

    public static String buildRateBaseUrl(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (BASEURLS.shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://feedback.talabat.com";
        }
        if (BASEURLS.shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        return "https://feedback-qa.talabat.com";
    }

    public static String buildTrackBaseUrl(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (BASEURLS.shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return "https://track.talabat.com/";
        }
        if (BASEURLS.shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return "http://localhost:8000/";
        }
        return "https://track-dev.dhhmena.com/";
    }

    public static String buildVendorsBaseUrl(String str) {
        TalabatEnvironment talabatEnvironment = TalabatEnvironment.INSTANCE;
        if (BASEURLS.shouldUseProductionURLs(str, talabatEnvironment.getEnvironment())) {
            return VendorsBaseUrl.BASE_URL_PROD;
        }
        if (BASEURLS.shouldUseMockServerUrls(talabatEnvironment.getEnvironment())) {
            return UrlConstantsKt.INSTRUMENTATION_TESTING_BASE_URL;
        }
        return VendorsBaseUrl.BASE_URL_QA;
    }
}
