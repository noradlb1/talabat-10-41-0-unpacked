package com.talabat.helpers;

import android.graphics.Bitmap;

public class GlobalConstants {
    public static final String ARABIC = "ar-KW";
    public static final String BROADCAST_KILL_CART = "finish_cart";
    public static final String BROADCAST_KILL_MENU = "finish_restaurant_menu";
    public static final String COVID_ARABIC_URL = "https://campaigns.talabat.com/ar/covid-19-customer-guidelines";
    public static final String COVID_URL = "https://campaigns.talabat.com/en/covid-19-customer-guidelines";
    public static final int DEFAULT_ANIMATION_LEVEL = 2;
    public static final String ENGLISH = "en-US";
    public static final String FWF_PROD_URL = "https://fwf-client-api.talabat.com";
    public static final String FWF_QA_URL = "https://fwf-client-api-qa.dhhmena.com";
    public static final int IRAQ_COUNTRY_CODE = 964;
    public static final String ITEM_ID = "itemId";
    public static String KEY_FROMCARDSCREEN = "fromCardScreen";
    public static String KEY_TOCART = "toCartScreen";
    public static final String KURDISH_BADINI = "ku-BA";
    public static final String KURDISH_BADINI_LOCAL = "ku-IR";
    public static final String KURDISH_SORANI = "ku-SO";
    public static final String KURDISH_SORANI_LOCAL = "ckb";
    public static final String LOGGER_BUSY_POPUP_BUSY_RESTAURANT = "busy_restaurant";
    public static final String LOGGER_BUSY_POPUP_NEW_RESTAURANT = "new_restaurant";
    public static String LOGGER_CART_EMPTY_SCENARIO = "empty cart flow";
    public static String LOGGER_CART_HAS_ITEMS_SCENARIO = "cart with items flow";
    public static String LOGGER_GEM_FLOW = "gem flow";
    public static String SettingSelection = "";
    public static String Version = "1.0";
    public static int centerPointRange = 1000;
    public static String commaDecimalPattern = "#,###,###.###";
    public static long currentRequestTime = 0;
    public static String defaultDecimalPattern = "0.";
    public static final boolean filterAnimation = true;
    public static boolean isDrawAreaPolygon = true;
    public static boolean isDrawCountryPolygon = true;
    public static boolean isDuplicateOrder = false;
    public static boolean isItemCart = false;
    public static boolean isLightNavigationDrawer = true;
    public static boolean isNetworkDialogShowing = false;
    public static boolean isSideMenuInitialSelection = false;
    public static boolean isUserSelectedAreaCenterPointEnabled = true;
    public static long lastPaymentRequestedTime = 0;
    public static long lastRequestedTime = 0;
    public static String networkConnectionType = "";
    public static int notificationUnreadCount = 0;
    public static long requestStartTImeinMilliSecond = 0;
    public static final boolean showAnimation = false;

    public static final class ADDRESS_VALIDATION_ERROR_CODES {
        public static final int ADDRESS_LIMIT_REACHED = 11;
        public static final int MOB_10_DIGITS = 2;
        public static final int MOB_DIGITS_LEN = 21;
        public static final int MOB_NOT_NUMERIC = 23;
        public static final int MOB_OTHER = 3;
        public static final int MOB_STARTS_WITH = 22;
    }

    public interface ANIMATION_LEVEL {
        public static final int LEVEL_ONE = 1;
        public static final int LEVEL_THREE = 3;
        public static final int LEVEL_TWO = 2;
        public static final int NO_ANIMATION = 0;
    }

    public static final class BANNER {
        public static final String BANNERTYPE = "bannerType";
        public static final String BANNERTYPE_IMAGE = "image";
        public static final String BANNERTYPE_WEB = "Web";
        public static final String CLICKLINK = "link";
        public static final String INLINE_ADS = "11765624";
        public static final String LINKTYPE = "linkType";
        public static final String LINKTYPE_DEEPLINK = "deepLink";
        public static final String LINKTYPE_WEBLINK = "webLink";
        public static final String TEMPLATEID = "10065101";
        public static final String URL = "url";
        public static Bitmap temp;
    }

    public static final class BRAND_DEEP_LINK_NAVIGATION {
        public static final String DISABLE_SIDEMENU = "disbable_sidemenu";
    }

    public static final class CHECKOUT_VOUCHER {
        public static final boolean VOUCHER_LOADED = false;
    }

    public static final class CHOOSE_COUNTRY_CODE {
        public static final String COUNTRY_CODE = "countrycode";
        public static final String COUNTRY_DIAL_CODE = "countrydialcode";
        public static final String COUNTRY_GCC = "gcccountry";
    }

    public static final class ExtraNames {
        public static final String ADD_ADDRESS_FILTERAREAS = "filterAreas";
        public static final String AFTER_LOGIN_DEEPLINK = "after_login_deeplink";
        public static final String AFTER_LOGIN_INTENT = "after_login_intent";
        public static final String AREA_CHOOSED = "areachoosed";
        public static final String AREA_LAT_LNG = "areaLatLng";
        public static final String BRANCH_ID = "branchId";
        public static final String DELIVERY_AREA = "deliveryArea";
        public static final String DELIVERY_MODE = "deliveryMode";
        public static final String EDIT = "isForEdit";
        public static final String EMAIL_NOT_FOUND_REDIRECT = "email_not_found_redirect";
        public static final String ENCRYPTED_ORDER_ID = "encryptedOrderId";
        public static final String FORCEFILTERCITY = "forcefilterCities";
        public static final String FRANCHISE_GRP_ID = "franchise_Grp_id";
        public static final String FROM = "from";
        public static final String FROM_HOME = "fromHome";
        public static final String HELP_CENTER_CONTACT_NO = "help_center_contact_no";
        public static final String HELP_CENTER_ENTRY_POINT = "help_center_entryPoint";
        public static final String HELP_CENTER_EN_OID = "savedEncId";
        public static final String HELP_CENTER_MOST_RECENT_ORDER_DETAIL = "most_recent_order_detail";
        public static final String HELP_CENTER_SECTION_TITLE = "section_title";
        public static final String ID = "id";
        public static final String INFO_HERO_IMG = "Info_Hero_Img";
        public static final String ISFORSELECTION = "isForSelection";
        public static final String ISFROMAPPLINK = "isFromApplink";
        public static final String ISFROMDEEPLINK = "isFromDeeplink";
        public static final String IS_FETCHING_CL = "is_fetching_cl";
        public static final String IS_FRANCHISE_ADDRESS_UPDATED = "isDeliverableAddressUpdated";
        public static final String IS_FRANCHISE_REST = "iFranchiseRest";
        public static final String IS_FRANCHISE_SELECTED = "is_franchise_selected";
        public static final String IS_FROM_BRAND_LOCATION = "location";
        public static final String IS_FROM_BRAND_REORDER = "isFromBrandReorder";
        public static final String IS_FROM_BRAND_REORDER_MAP_FLOW = "is_Map_flow";
        public static final String IS_FROM_BRAND_RES_GRP_ID = "res_grp_id";
        public static final String IS_FROM_LOCATION_WELCOME = "is_from_location_welcome";
        public static final String IS_FROM_RE_ORDER = "is_from_re_order";
        public static final String IS_FROM_RE_ORDER_LIST = "is_from_re_order_list";
        public static final String IS_HOME_REFRESH_CALL_BACK = "is_home_refresh_call_back";
        public static final String IS_IGNORE_CURRENT_LOCATION = "isIgnoreCurrentLocation";
        public static final String IS_LOAD_DELIVERY_ADDRESS = "isLoadDeliverAddress";
        public static final String IS_LOAD_MAP_FROM_WELCOME = "is_load_map_welcome";
        public static final String IS_REDIRECT_BACK_HOME_IF_VERTICAL = "redirect_back_home_from_welcome";
        public static final String IS_SHOW_MAP_SEARCH = "is_show_map_search";
        public static final String LOADAREAFOMHOME = "loadAreaFromFromHome";
        public static final String LOCALEINTENT = "localeIntent";
        public static final String MIGRATED_INFO = "deeplink_migrated_info";
        public static final String MIGRATED_TYPE = "deeplink_migrated_type";
        public static final String NAME = "name";
        public static final String PICKUP = "pickup";
        public static final String REDIRECT = "redirect";
        public static final String REDIRECT_BACK = "redirect_back";
        public static final String REDIRECT_LOCATION_COUNTRY_SELECTION = "redirect_map_country_selection";
        public static final String REDIRECT_NAVIGATION = "redirect_navigation";
        public static final String REF = "ref";
        public static final String RESET_PRE_BRANCH = "reset_pre_branch";
        public static final String RESTAURANT_LIST_FITLER_CLOSED = "restaurantListFilterClosed";
        public static final String RE_ORDER_BRANCH_ID = "re_order_branch_id";
        public static final String RE_ORDER_ID = "re_order_id";
        public static final String RE_ORDER_RES_ID = "re_order_res_id";
        public static final String RE_ORDER_RES_NAME = "re_order_res_name";
        public static final String RIDER = "rider";
        public static final String SAVE = "save";
        public static final String SAVEAREA = "savearea";
        public static final String SELECTED_AREA_ID = "selectedAreaId";
        public static final String SELECTED_AREA_NAME = "selectedAreaName";
        public static final String SELECTED_CITY_ID = "selectedCityId";
        public static final String SELECTED_CITY_NAME = "selectedCityName";
        public static final String SELECT_AREA_FOR_ADD_ADDRESS = "selectAddress";
        public static final String SHOP_CLICK_ORIGIN = "shopClickOrigin";
        public static final String SHOULD_FORCE_LOCATION_IN_HOME = "should_show_force_location_selection";
        public static final String SHOWUSERADDRESS = "showUserAreas";
        public static final String SLUG_NAME = "slug_name";
        public static final String TRANSACTIONID = "transId";
        public static final String USER_SELECTED_ADDRESS = "UserSelectedAddress";
        public static final String VALUE = "value";
    }

    public static final class FORCE_MAP {
        public static final String CHECKOUT_SUCCESS = "Is_Order_flow_sucess";
        public static final String EVENT_ORIGIN = "eventOrigin";
        public static final String FORCE_MAP_ADDRESS_OBJECT = "address";
        public static final String IS_ADDRESS_FROM_CART_ORDER_Flow = "isAddressFromCartOrderFlow";
        public static final String IS_ADD_ADDRESS_FROM_CHECKOUT = "isAddAddressfromCheckout";
        public static final String IS_EDIT_ADDRESS_FROM_SIDE_MENU = "isEditAddressFromSideMenu";
        public static final String IS_FROM_SKIP = "skip";
        public static final String IS_MAP_ENFORCE_FROM_CHECK_OUT = "ISmapenforcefromcheckout";
        public static final String IS_NEW_ADDRESS_FROM_CART = "isNewAddressFromCartOrderFlow";
        public static final String IS_NEW_ADDRESS_FROM_REG = "isNewAddressFromCartOrderReg";
        public static final String IS_TALABAT_DELIVERY_AVAILABLE = "talabatDeliveryAvailable";
        public static final String LOCATION_MIS_MATCH = "locationmissmatch";
        public static final String MAP_COMPULSORY = "map_compulsory";
        public static final String MAP_FROM_SIDEMENU = "mapFromSideMenu";
        public static final String NEW_ADDRESS_CREATION = "newaddressCreation";
        public static final String NINE_COOKIES_ENABLED = "nineCookiesEnabled";
        public static final String RESTAURANT_TRACK_ENFORCE_MAP = "restaurant_track_enforce_map";
    }

    public static final class HOME_SCREEN_MAP {
        public static final String FROM_HOME_SCREEN_MAP = "isFromHomeScreenMap";
        public static final String FROM_HOME_SCREEN_UPDATE_NOW_EDIT = "isUpdateNowSelected";
        public static final String SHOW_ADDRESS_CONFIRMATION = "showAddressConfirmation";
    }

    public static final class INFOR_MAP {
        public static final String INFORMAP_GLR_ID = "info_glr_id";
        public static final String INFORMAP_SELECTED_AREA_ID = "info_selected_area_id";
        public static final String IS_DISABLE_ADDRESS_EDIT_GRL_CART = "isdisableAddressEditGrl";
        public static final String IS_FROM_MCD_ADDRESS_FLOW = "isFromMcdAddressFlow";
        public static final String IS_FROM_MCD_NEW_ADDRESS_CHECKOUT = "isFromMcdNewAddressFromCheckout";
        public static final String IS_FROM_REORDER_FLOW = "isinformapfromreorder";
        public static final String IS_GLR_ENABLED_RESTAURANT = "isGlrEnabledRes";
        public static final String IS_MCD_KSA_UPDATE_IGNORE = "is_mcd_ksa_ignore";
        public static final String IS_MCD_KSA_UPDATE_LOCATION = "is_mcd_ksa_location_updated";
        public static final String IS_NEW_ADDRESS_CREATION_FROM_GRL_FLOW = "isNewAddressCreationFromGrlFlow";
        public static final String IS_TITLE_CORRECTION = "isfromtitlecorrection";
        public static final String MCD_BRANCH_ID_MENU = "grlbranchidmenu";
        public static final String RESTAURANT_ID = "isinformapResid";
        public static final String RESTAURANT_NAME = "isinformapResName";
        public static final String SELECTED_GRL_ID = "isSelectedGrlID";
        public static final String TB_BRANCH_ID_MENU = "branchidmenu";
    }

    public static final class ITEMDETAILS {
        public static int noHeaderVariation = 2;
        public static int noRevamp = 1;
        public static int staticHeaderWithChoices = 3;
        public static int staticHeaderWithChoicesAndProgressBar = 4;
    }

    public static final class LOGIN {
        public static final String RESET_EMAIL = "reset_email";
        public static final String RESET_MOBILE = "reset_mobile";
    }

    public final class MCD_GOOGLE_MAP {
        public static final String MCD_GOOGLE_MAP_BLOCK = "mcd_block";
        public static final String MCD_GOOGLE_MAP_BRANCH_ID = "mcd_branch_id";
        public static final String MCD_GOOGLE_MAP_FLOW = "mcd_map_flow";
        public static final String MCD_RESTAURANT_ID = "mcd_restaurant_id";

        public MCD_GOOGLE_MAP() {
        }
    }

    public static final class NormalUpdate {
        public static boolean IS_NORMAL_UPDATE = false;
        public static String NORMAL_UPDATE_MSG = "";
    }

    public static final class PAYFORT_CARD_TYPE {
        public static final String TOKEN_CARD_TYPE_AMEX = "AMEX";
        public static final String TOKEN_CARD_TYPE_DINERSCLUB = "DINERSCLUB";
        public static final String TOKEN_CARD_TYPE_DISCOVER = "DISCOVER";
        public static final String TOKEN_CARD_TYPE_JCB = "JCB";
        public static final String TOKEN_CARD_TYPE_MAESTRO = "MAESTRO";
        public static final String TOKEN_CARD_TYPE_MASTER_CARD = "MASTERCARD";
        public static final String TOKEN_CARD_TYPE_VISA = "VISA";
    }

    public static final class PrefsConstants {
        public static final String ADJUST_FIRE_BASE_TOKEN = "fireBaseAdjustToken";
        public static final String AREA_ID = "AREA";
        public static final String AREA_NAME = "AREA_NAME";
        public static final String CAN_HIDE_SPLASH_VIDEO = "canHideSplashVideo";
        public static final String CART = "cart";
        public static final String CART_SAVED_TIME = "cart_saved_time";
        public static final String CART_SAVED_UP_SELLING = "cart_saved_up_selling";
        public static final String CITY_ID = "CITY";
        public static final String CITY_NAME = "CITY_NAME";
        public static final String COUNTRY_ID = "COUNTRY";
        public static final String COUNTRY_NAME = "COUNTRY_NAME";
        public static final String FALLBACK_GUEST_ADDRESS = "fallback_guest_address";
        public static final String GRL_ADDRESS_CART_SAVED_TIME = "grl_address_cart_saved_time";
        public static final String GRL_CART = "grl_cart";
        public static final String HOME_MAP_PREF_ADDRESS = "homeMapAddress";
        public static final String HOME_MAP_PREF_AREAID = "homeMapPreAreaId";
        public static final String HOME_MAP_PREF_LOCATION = "homeMapPrefLocation";
        public static final String HOME_MAP_PREF_STREET_NAME = "homeMapPreStreetName";
        public static final String HOME_MAP_PREF_ZOOM = "homeMapPreZoom";
        public static final String HOME_MAP_REDIRECT = "home_map_redirect";
        public static final String ISFIRST_TIME = "isFirstTime";
        public static final String ISOLDCUSTOMER = "isOldCustomer";
        public static final String ISTOKENMIGRATED = "isTokenMigrated";
        public static final String IS_FIRST_INSTALL = "is_first_install";
        public static final String LOCALE = "LOCALE";
        public static final String MCD_BLOCK_ADDRESS_CART_SAVED_TIME = "mcd_block_address_cart_saved_time";
        public static final String MCD_BLOCK_CART = "mcd_block_cart";
        public static final String MCD_LAT_LANG_CART = "mcd_lat_lang_cart";
        public static final String MCD_LAT_LANG_CART_SAVED_TIME = "mcd_lat_lang_cart_saved_time";
        public static final String QATAR_SPECIAL_SPLASH_LOGO = "qatar_special_splash";
        public static final String SPLASH_VIEW_TYPE = "splash_view_type";
        public static final String TALABAT_INFO_BAR_STATUS = "talabatinfowindow";

        public static String getNAME() {
            return "talabat";
        }
    }

    public static final class PrefsWithBackupConstants {
        public static final String DEVICE_ID = "talabat_device_id";
        public static final String NAME = "talabat_shared_pref_with_backup";

        private PrefsWithBackupConstants() {
        }
    }

    public static final class RECYCLER_ANIMATION_ID {
        public static final int SLIDE_FROM_ALPHA = 4;
        public static final int SLIDE_FROM_BOTTOM = 2;
        public static final int SLIDE_FROM_LEFT = 1;
        public static final int SLIDE_FROM_RIGHT = 0;
        public static final int SLIDE_FROM_SWING_BOTTOM = 3;
    }

    public static final class REG_ERROR_CODE {
        public static final int INVALID_BIRTH_DATE = -16;
        public static final int INVALID_FIRSTNAME = -8;
        public static final int LAST_NAME_LETTERS_ = -9;
        public static final int LAST_NAME_MAX_100 = -10;
        public static final int LAST_NAME_MIN = -11;
        public static final int LOGIN_INVALID_EMAIL = -3;
        public static final int NAME_LETTERS_ONLY = -12;
        public static final int NAME_MAX_100 = -13;
        public static final int NAME_MIN = -14;
        public static final int PASSWORD_POLICY_ERROR = -5;
        public static final int REGION_WRONG = -15;
        public static final int REGISTER_ERROR = -7;
        public static final int TOO_MANY_REQUEST = -2;
        public static final int UNKNOWN_ERROR = -6;
        public static final int UN_MATCHED_PASSWORD = -4;
        public static final int USER_EXISTS = -1;
    }

    public interface SAVEDINSTANCE {
        public static final String NULL = "null";
        public static final String PRESENTER = "p";
    }

    public static final class SMART_LOGIN_TYPE {
        public static final int FACEBOOK = 1;
        public static final int GOOGLE = 0;
        public static final int MOBILE = 4;
        public static final int NORMAL = 2;
        public static final int SMARTLOCK = 3;
    }

    public static class VerticalTypes {
        public static String GROCERY = "grocery";
        public static String RESTAURANT = "restaurant";
        public static String VERTICAL = "vertical";
    }

    public static final class serverErrorCode {
        public static int CONNECTION_FAILED_ERROR_CODE = 500;
        public static int CONNECTION_TIMED_OUT_CODE = 408;
        public static int GEO_BLOCK_ERROR_CODE = 403;
        public static int NOT_RESPONDING_ERROR_CODE = 429;
        public static int NO_INTERNET_CONNECTION_CODE = 100;
    }
}
