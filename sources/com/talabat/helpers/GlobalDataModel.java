package com.talabat.helpers;

import JsonModels.MenuItemsResponseModel;
import JsonModels.PolygonEvents;
import JsonModels.Response.ParallelBin.MoreBinModel;
import JsonModels.Response.SplitRestaurantApiResponse.TgoFreeDeliveryResponse;
import JsonModels.RestaurantListJM;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import buisnessmodels.sponsors.SponsorsRepository;
import buisnessmodels.tokenisation.TokenisationCreditCard;
import com.adjust.sdk.AdjustAttribution;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.BuildConfig;
import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.featureflag.domain.flags.TalabatFeatureFlagConstants;
import com.talabat.lib.Integration;
import com.talabat.observability.ObservabilityManager;
import com.talabat.talabatcore.extensions.StringBuilderKt;
import datamodels.Area;
import datamodels.CartMenuItem;
import datamodels.ChoiceSection;
import datamodels.Country;
import datamodels.Cuisine;
import datamodels.CustomerInfo;
import datamodels.DashboardOrderList;
import datamodels.DeliveryArea;
import datamodels.Filter;
import datamodels.GemTier;
import datamodels.JMenuSection;
import datamodels.MenuItem;
import datamodels.OffersItem;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantReview;
import datamodels.Swimlane;
import datamodels.Token;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import library.talabat.inlineadsengine.AdsWrapper;
import library.talabat.mvp.homemap.AllCountryPolygonRM;
import library.talabat.mvp.homemap.HomeMapTemp;
import zr.c;
import zr.d;

public class GlobalDataModel {
    public static CustomerInfo CustomerInfo = null;
    public static boolean IsChatStarted = false;
    public static boolean PageOpenFromHelpCenter = false;
    public static boolean SHOULD_SHOW_PROMO_WIDGET = true;
    public static int SelectedAreaId = 0;
    public static String SelectedAreaName = null;
    public static int SelectedCityId = 0;
    public static String SelectedCityName = null;
    @Deprecated
    public static int SelectedCountryId = 0;
    public static String SelectedCountryName = null;
    public static String SelectedLanguage = "en-US";
    @Nullable
    public static Swimlane SelectedSwimlane = null;
    public static String ShopClickOrigin = "";
    public static String TOP_ITEMS_JSON = null;
    public static AdjustAttribution adjustAttribution = null;
    public static ArrayList<AdsWrapper> adsWrappers = null;
    @Deprecated
    public static Area[] areas = null;
    public static boolean backFromMenuToList = false;
    public static String callId = "";
    public static Cuisine[] collectionCuisines = null;
    public static String collectionDeeplink = null;
    public static FilterEngine collectionFilterEngine = null;
    public static ArrayList<Filter> collectionFilters = null;
    public static ArrayList<Restaurant> collectionRestaurants = null;
    public static ArrayList<Restaurant> collectionSearchRestaurants = null;
    public static ArrayList<QuickFilter> collections = null;
    @Deprecated
    public static Country[] countries = null;
    public static Cuisine[] cuisines = null;
    private static String deepLinksQuery = null;
    public static String deviceSize = "";
    public static String encryptedUserId = "";
    public static FilterEngine filterEngine = null;
    public static ArrayList<Filter> filters = null;
    public static String googleAdId = null;
    public static List<Restaurant> groceryRestaurants = null;
    public static String imageBaseUrl = null;
    public static boolean isFeedbackShowing = false;
    public static boolean isFirstTimeUser = false;
    public static Boolean isLoyaltyEnabledForThisUser = null;
    public static boolean isSearchActive = false;
    public static boolean isUserEligibleForWalletPaymentOptionABTest = false;
    /* access modifiers changed from: private */
    public static int maxSponsoredSlots = 0;
    public static Integer[] popularCuisinesIds = null;
    public static String quickOrderUserId = "userinfo";
    public static DeliveryArea[] restaurantDeliveryAreas = null;
    public static Restaurant[] restaurants = null;
    private static Subject<Integer> selectedCountryIdSubject = BehaviorSubject.createDefault(Integer.valueOf(SelectedCountryId));
    public static String selectedMenuItemRef = "";
    public static boolean showOnlyOpenRestaurant = false;
    @Deprecated
    @Nullable
    public static Token token;

    public static class AD {
        public static long sideBannerRequestTime;
        public static NativeCustomTemplateAd sidebanner;

        public static void countryChanged() {
            sideBannerRequestTime = 0;
            sidebanner = null;
        }

        public static void sideBannerAdRequestFailed() {
            sideBannerRequestTime = System.currentTimeMillis();
        }
    }

    public static final class ADJUST_DEEPLINK {
        public static Uri DIFFERED_DEEPLINK;
    }

    public static class ADYENCONSTANTS {
        public static String adyenPayUrl = "adyenapi/v1/purchase/pay";
    }

    public static class ANIMATIONHELPER {
        public static boolean addItemClicked = false;
    }

    public static class APPBOYNOTIFICATION {
        public static boolean isNotificationAvail = false;
        public static long mLastCreditLoadTime;
        public static int notificationCount;
    }

    public static final class Apptimize {
        public static Boolean CAN_PRIORITIZE_SEARCH = Boolean.FALSE;
        public static boolean CAN_SHOW_CUSTOM_GOOGLE_AUTO_COMPLETE_WIDGET = false;
        public static boolean CAN_SHOW_GOOGLE_AUTO_COMPLETE_WIDGET = false;
        @Deprecated
        public static boolean MapInFunnelEnabled = false;
        public static int itemDetailsHeaderVariant = 0;
    }

    public static final class BIN {
        public static boolean handled = false;
        public static boolean numberUpdated = false;
        @Deprecated
        public static ArrayList<TokenisationCreditCard> savedTokens = new ArrayList<>();
        public static String stoppedBinNumber = "";
        public static boolean tokensModified = false;
        public static String updatedNumber = "";
    }

    public static class CHECKOUT {
        public static LatLng currentLatLong = null;
        public static int timeOut = 95;
    }

    public static class CHECKOUTDOTCOM {
        public static int bankId;
        @Deprecated
        public static String publicKey;
        public static String routingEnabledPublicKey;
    }

    public static class CONTACTLESS {
        public static boolean contactlessEnabled = false;
    }

    public static final class DASHBOARDDATA {
        public static boolean fromPush = false;
        public static DashboardOrderList[] orderInfo = null;
        public static boolean orderListReceived = false;
        public static String serverTime = "";
    }

    public static final class FunWithFlag {
        public static boolean FunWithFlagChangeRetrofitBaseUrl = false;
        public static boolean FunWithFlagEnableBusyPopupInCart = false;
        public static boolean FunWithFlagEnableWalletDeleteCard = false;
        public static boolean TalabatCreditRevampEnabled = true;
    }

    public static class GEMCONSTANTS {
        public static GemTier GemTiers = null;
        public static boolean cartCouponSupressed = false;
        public static float eligibleGemOfferPrice = 0.0f;
        public static double gemGracePeriod = 0.0d;
        public static double gemTimer = 15.0d;
        public static boolean isAdDisableGem = false;
        public static boolean isGemBlocked = false;
        public static boolean isGemFlow = false;
        public static boolean isGemForthankyou = false;
        public static boolean isGemRedeemed = true;
        public static boolean isGemStarted = false;
        public static boolean menuCouponSupressed = false;
        public static int menuRestaurantId = 0;
        public static boolean reloadRequired = false;

        public static boolean isGemFlow() {
            return isGemFlow;
        }

        public static void setGemFlow(boolean z11) {
            isGemFlow = z11;
        }
    }

    public static class GEO_CORDINATES {
        public static List<LatLng> AreaPolGonPoints = null;
        public static boolean ValidateWithareaPolygon = false;
        public static com.talabat.maps.domain.model.LatLng addressPageLatLang = null;
        public static ArrayList<AllCountryPolygonRM> allCountryPolygonRMS = null;
        public static LatLng areaCenterPoint = null;
        public static boolean isRefreshBrandAddress = false;
        public static boolean isUserChangedCartArea = false;
        public static boolean isUserInteractedWithMapLocation;
        public static List<LatLng> polyGonPoints;
        public static float saveTempZoomLevel;
    }

    public static final class GEO_LOCATION_TRACKING {
        public static String ADDRESS_STATUS = "N/A";
        public static String GEO_LOCATION_API_METHOD = "reverse geocoding";
    }

    public static final class GROCERY {
        public static final int pageSize = 10;
    }

    public static class HOME_SCREEN_MAP {
        public static LatLng ADDRESS_FUSED_LOCATON = null;
        public static boolean CONFIRMED_LOCATION_AWARNESS = false;
        public static LatLng FUSED_LOCATION_FROM_HOME = null;
        public static int MAP_FRST_UPDATE_OPTION = 0;
        public static boolean REFRSH_LOCATION_FROM_BG = false;
        public static int SAVE_FOR_LATER = 2;
        public static int UPDATE_NOW = 1;
        public static boolean USER_IGNORE_LOCATION_AWARENESS;
    }

    public static class JSON {
        public static MutableLiveData<LatLng> CurrentLocationFromStart = new MutableLiveData<>();
        public static MutableLiveData<LatLng> DeliverCurrentLocation = new MutableLiveData<>();
        public static Restaurant[] franchiseRestaurants;
        public static MutableLiveData<Boolean> groceryMenuItemsLoadedForSection = new MutableLiveData<>();
        public static MutableLiveData<Boolean> groceryMenuLoaded = new MutableLiveData<>();
        public static MenuItemsResponseModel menuItemsResponseModel;
        public static MutableLiveData<Boolean> netWorkErrorOccured = new MutableLiveData<>();
        public static JMenuSection[] sideMenuSection;
        public static JMenuSection[] sideMenuSectionLinks;
        public static TgoFreeDeliveryResponse tgoFreeDeliveryResponse = new TgoFreeDeliveryResponse();
    }

    public static final class LATLONGFORAPI {
        public static String latitude;
        public static String longitude;

        public static String getLatitude() {
            if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().getSelectedCustomerAddress() == null) {
                HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                if (homeMapTemp.getHomeMapSavedLatLng() != null) {
                    latitude = String.valueOf(homeMapTemp.getHomeMapSavedLatLng().latitude);
                } else {
                    latitude = "";
                }
            } else {
                latitude = Customer.getInstance().getSelectedCustomerAddress().latitude + "";
            }
            return latitude;
        }

        public static Double getLatitudeDouble() {
            String latitude2 = getLatitude();
            if (latitude2.isEmpty()) {
                return Double.valueOf(0.0d);
            }
            return Double.valueOf(Double.parseDouble(latitude2));
        }

        public static String getLongitude() {
            if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().getSelectedCustomerAddress() == null) {
                HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                if (homeMapTemp.getHomeMapSavedLatLng() != null) {
                    longitude = String.valueOf(homeMapTemp.getHomeMapSavedLatLng().longitude);
                } else {
                    longitude = "";
                }
            } else {
                longitude = Customer.getInstance().getSelectedCustomerAddress().longitude + "";
            }
            return longitude;
        }

        public static Double getLongitudeDouble() {
            String longitude2 = getLongitude();
            if (longitude2.isEmpty()) {
                return Double.valueOf(0.0d);
            }
            return Double.valueOf(Double.parseDouble(longitude2));
        }
    }

    public static class MAP_ADDRESS_TYPE {
        public static int AUTOMATIC_MAP_ADDRESS = 1;
        public static int MANUAL_MAP_ADDRESS = 2;
    }

    public static class MENU {
        public static boolean AddToCartClicked = false;
        public static boolean ChoiceClicked = false;
        public static int ChoicesForBranch = 0;
        public static boolean MenuCalledOnce = false;
        public static boolean doNotLoad = false;
        public static boolean isQuickAddEnabled = false;
        public static MenuItem menuItem = null;
        public static boolean priceOnSelectionItemAvailable = false;
        public static int requestAtOnceCount = 5;
        public static int requiredCount;
        public static int responseReceived;
    }

    public static final class MENUTYPE {
        public static final int CARDS = 2;
        public static final int LIST = 1;
    }

    public static class OFFERS {
        public static ArrayList<OffersItem> offersList;
    }

    public static final class PARALLELBIN {
        public static String commonIconUrl = null;
        public static String commonMessage = null;
        public static ArrayList<MoreBinModel> moreBinModels = null;
        public static boolean notAvailable = false;
        public static boolean parallelBinLoaded = false;

        public PARALLELBIN(String str, String str2, ArrayList<MoreBinModel> arrayList) {
            commonMessage = str;
            commonIconUrl = str2;
            moreBinModels = arrayList;
            parallelBinLoaded = true;
        }

        public static String getAllBinCampaignIdsForGA() {
            StringBuilder sb2 = new StringBuilder();
            ArrayList<MoreBinModel> arrayList = moreBinModels;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<MoreBinModel> it = moreBinModels.iterator();
                while (it.hasNext()) {
                    StringBuilderKt.addStringWithComma(sb2, it.next().campaignId);
                }
            }
            return sb2.toString();
        }

        public static void reset() {
            commonMessage = "";
            commonIconUrl = "";
            moreBinModels = new ArrayList<>();
            notAvailable = false;
            parallelBinLoaded = false;
        }
    }

    public static final class PLACEORDER {
        public static boolean foundInvalidCoupon = false;
        public static boolean foundInvalidPromotion = false;
        public static boolean foundInvalidVoucher = false;
    }

    public static final class POLYGON_TRACKING {
        public static PolygonEvents polygonEvents;
    }

    public static final class RECENT_LATLONG {
        public static double latitude;
        public static double longitude;

        public static double getLatitude() {
            if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().getSelectedCustomerAddress() == null) {
                HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                if (homeMapTemp.getHomeMapSavedLatLng() != null) {
                    latitude = homeMapTemp.getHomeMapSavedLatLng().latitude;
                } else {
                    latitude = 0.0d;
                }
            } else {
                latitude = Customer.getInstance().getSelectedCustomerAddress().latitude;
            }
            return latitude;
        }

        public static double getLongitude() {
            if (!Customer.getInstance().isLoggedIn() || Customer.getInstance().getSelectedCustomerAddress() == null) {
                HomeMapTemp homeMapTemp = HomeMapTemp.INSTANCE;
                if (homeMapTemp.getHomeMapSavedLatLng() != null) {
                    longitude = homeMapTemp.getHomeMapSavedLatLng().longitude;
                } else {
                    longitude = 0.0d;
                }
            } else {
                longitude = Customer.getInstance().getSelectedCustomerAddress().longitude;
            }
            return longitude;
        }
    }

    public static class REFRESHFLAGS {
        public static boolean isRestaurantListRefreshed;
    }

    public static class REVIEWS {
        public static RestaurantReview mRestaurantReviews;
    }

    public static class SELECTED {
        private static final EntityUpdater<Restaurant> RESTAURANT_UPDATER = new EntityUpdater<>(new c(), new d());
        public static CartMenuItem cartMenuItem = null;
        public static ChoiceSection choiceSection = null;
        public static int choiceSectionPosition = -1;
        public static Restaurant restaurant;

        @Nullable
        public static Restaurant getRestaurant() {
            return restaurant;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ boolean lambda$static$0(Restaurant restaurant2, Restaurant restaurant3) throws Exception {
            return restaurant2.f13872id == restaurant3.f13872id;
        }

        public static void setRestaurant(Restaurant restaurant2) {
            restaurant = restaurant2;
        }

        private static void trackIsPickupFlag(@Nullable Restaurant restaurant2) {
            Boolean bool;
            String str;
            HashMap hashMap = new HashMap();
            if (restaurant2 != null) {
                bool = restaurant2.isPickup();
            } else {
                bool = null;
            }
            if (bool != null) {
                str = bool.toString();
            } else {
                str = "null";
            }
            hashMap.put("flag", str);
            hashMap.put("stackTrace", StacktraceUtils.current());
            ObservabilityManager.track("updatingRestaurant", "DeliveryModeStatus", hashMap);
        }

        public static void updateRestaurant(@Nullable Restaurant restaurant2) {
            String str;
            try {
                restaurant = RESTAURANT_UPDATER.apply(restaurant, restaurant2);
            } catch (Throwable th2) {
                if (TalabatUtils.isNullOrEmpty(th2.getMessage())) {
                    str = "Update Restaurant, cause not available";
                } else {
                    str = "Update Restaurant -> " + th2.getMessage();
                }
                ObservabilityManager.trackUnExpectedScenario(str, new HashMap());
                restaurant = restaurant2;
            }
            try {
                trackIsPickupFlag(restaurant2);
            } catch (Exception e11) {
                ObservabilityManager.trackEvent("exception -> " + e11, "DeliveryModeStatus", (Map<String, String>) new HashMap());
            }
        }
    }

    public static final class SHOPTYPE {
        public static final int COSMETIC = 6;
        public static final int ELECTRONICS = 4;
        public static final int FLOWERS = 3;
        public static final int GROCERY = 1;
        public static final int MORE = 10;
        public static final int PET_SHOP = 5;
        public static final int PHARMACY = 2;
        public static final int RESTAURANT = 0;
    }

    public static class TEMP {
        public static ArrayList<Restaurant> collectionFilteredRestaurants;
        public static ArrayList<Restaurant> filteredRestaurants;
    }

    public static class USERINFO {
        public static final String FACEBOOKLINK = "https://www.facebook.com/talabat";
        public static final String INSTAGRAMLINK = "https://www.instagram.com/talabat";
        private static String SOCIAL_INITIATIVES_AR = "https://blog.talabat.com/ar/social-initiatives/";
        private static String SOCIAL_INITIATIVES_EN = "https://blog.talabat.com/social-initiatives/";
        public static final String TWITTERLINK = "https://www.twitter.com/talabat";

        public static String getSocialInitiativesLink() {
            return TalabatUtils.isArabic() ? SOCIAL_INITIATIVES_AR : SOCIAL_INITIATIVES_EN;
        }
    }

    public static class VISACHECKOUT {
        public static String visaCheckoutPayUrl;
    }

    public static boolean consumeNewMicroService(ITalabatFeatureFlag iTalabatFeatureFlag) {
        return iTalabatFeatureFlag.getFeatureFlag(TalabatFeatureFlagConstants.CONSUME_REVERSE_GEO_CODE_MICRO_SERVICE, true);
    }

    public static String getAppName() {
        return "Talabat";
    }

    public static String getAppPAckageID() {
        return BuildConfig.APPLICATION_ID;
    }

    public static String getDeepLinksQuery() {
        return deepLinksQuery;
    }

    public static Observable<Integer> getSelectedCountryIdObservable() {
        return selectedCountryIdSubject;
    }

    public static String getUaIDForPerseus() {
        if (BASEURLS.shouldUseProductionURLs("release", TalabatEnvironment.INSTANCE.getEnvironment())) {
            return library.talabat.com.talabatlib.BuildConfig.TALABAT_LIVE_UAID;
        }
        return library.talabat.com.talabatlib.BuildConfig.TALABAT_STAGGING_UAID;
    }

    public static void launchRxNextEventOnCountryId(int i11) {
        selectedCountryIdSubject.onNext(Integer.valueOf(i11));
    }

    public static void resetUserLoyaltyEligibilityFlag() {
        isLoyaltyEnabledForThisUser = null;
    }

    public static void setDeepLinksQuery(String str) {
        deepLinksQuery = str;
    }

    public static SponsorsRepository sponsorsRepository() {
        return new SponsorsRepository() {
            public long getMaxSponsoredRank() {
                return 9999;
            }

            public int getMaxSponsoredSlots() {
                return GlobalDataModel.maxSponsoredSlots;
            }

            public boolean isSponsoredSortingActive() {
                return Integration.isSponsoredSortingActive().invoke().booleanValue();
            }
        };
    }

    public static void updateRestaurantsData(@Nullable RestaurantListJM restaurantListJM) {
        if (restaurantListJM != null) {
            restaurants = restaurantListJM.restaurants;
            maxSponsoredSlots = restaurantListJM.maxSponsoredSlots;
        }
    }
}
