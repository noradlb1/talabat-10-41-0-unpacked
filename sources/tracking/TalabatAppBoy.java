package tracking;

import android.content.Context;
import android.content.SharedPreferences;
import buisnessmodels.Cart;
import buisnessmodels.Customer;
import com.appboy.enums.Gender;
import com.appboy.enums.NotificationSubscriptionType;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.models.outgoing.BrazeProperties;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.notifications.brazemigrator.BrazeUserMigratorConfig;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.RegistrationStatus;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.constants.TrackingConstants;
import com.talabat.talabatcore.logger.LogManager;
import datamodels.CustomerInfo;
import datamodels.RateOrderReq;
import datamodels.RedeemedVoucher;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import tracking.perseus.TalabatPerseus;

public class TalabatAppBoy {
    public static final String BRAZE_PROPERTY_KEY_CATEGORY_BOUGHT = "category_bought";
    public static final String BRAZE_PROPERTY_KEY_PAYMENT_METHOD = "payment_method";
    public static final String BRAZE_PROPERTY_KEY_VENDOR_ID = "vendor_id";
    public static final String BRAZE_PROPERTY_KEY_VOUCHER_USAGE = "voucher_usage";
    public static final String EVENT_NAME_ADD_TO_BASKET = "app_add_to_basket";
    public static final String EVENT_NAME_APP_NEWMENU = "app_new_menu";
    public static final String EVENT_NAME_APP_ORDERED = "app_order";
    public static final String EVENT_NAME_APP_ORDERED_AREA = "app_ordered_region";
    public static final String EVENT_NAME_APP_ORDERED_CITY = "app_ordered_city";
    public static final String EVENT_NAME_APP_ORDERED_COUNTRY = "app_ordered_country";
    public static final String EVENT_NAME_APP_ORDERED_RESTAURANT = "app_ordered_restaurant";
    public static final String EVENT_NAME_APP_ORDER_RATED = "app_rated_order";
    public static final String EVENT_NAME_APP_SEARCHED_AREA = "app_searched_region";
    public static final String EVENT_NAME_APP_SEARCHED_CITY = "app_searched_city";
    public static final String EVENT_NAME_APP_SEARCHED_COUNTRY = "app_searched_country";
    public static final String EVENT_NAME_APP_SEARCHED_RESTAURANT = "app_searched_restaurant";
    public static final String EVENT_NAME_APP_VOUCHER_APPLIED = "app_voucher_applied";
    public static final String EVENT_NAME_GROCERY_COLLECTION = "app_grocery_collection_loaded";
    public static final String EVENT_NAME_OPENED_REDEEM_OFFERS = "app_rewards_screen_loaded";
    public static final String EVENT_NAME_REGISTRATION_FINISHED = "app_finish_registration";
    public static final String EVENT_NAME_REGISTRATION_STARTED = "app_start_registration";
    public static final String EVENT_NAME_VOUCHER_REDEEMED = "app_voucher_redeemed";
    private static final String GPS_AD_ID = "gps_adid";
    public static final String REGISTRATION_TYPE = "registration_type";
    public static final String USER_ID = "user_id";

    public static void a(BrazeProperties brazeProperties, boolean z11, String str) {
        if (!str.equalsIgnoreCase("Grocery") || !z11) {
            checkAndAddProperty(brazeProperties, BRAZE_PROPERTY_KEY_CATEGORY_BOUGHT, str);
        } else {
            checkAndAddProperty(brazeProperties, BRAZE_PROPERTY_KEY_CATEGORY_BOUGHT, "tMart");
        }
    }

    public static void add_toCart(Context context) {
        Braze.getInstance(context).logCustomEvent(EVENT_NAME_ADD_TO_BASKET);
        Braze.getInstance(context).requestImmediateDataFlush();
    }

    public static void appOpened(Context context) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            checkAndSetCustomUserAttribute(currentUser, "app_language", GlobalDataModel.SelectedLanguage);
            currentUser.setCustomUserAttribute("app_pre_appboy_user", true);
            TalabatPerseus.Companion companion = TalabatPerseus.Companion;
            checkAndSetCustomUserAttribute(currentUser, "app_perseus_client_id", companion.getMyClientId(context));
            checkAndSetCustomUserAttribute(currentUser, "app_perseus_session_id", companion.getMySessionId());
        }
    }

    public static void areaSelected(Context context, String str, String str2) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            checkAndSetCustomUserAttribute(currentUser, "app_last_searched_region_id", str2);
            checkAndSetCustomUserAttribute(currentUser, "app_last_searched_region_text", str);
            Braze.getInstance(context).logCustomEvent(EVENT_NAME_APP_SEARCHED_AREA);
        }
    }

    public static void b(BrazeProperties brazeProperties) {
        RedeemedVoucher redeemedVoucher = Cart.getInstance().getRedeemedVoucher();
        if (redeemedVoucher != null) {
            checkAndAddProperty(brazeProperties, BRAZE_PROPERTY_KEY_VOUCHER_USAGE, Boolean.TRUE);
            checkAndAddProperty(brazeProperties, "customer_voucher_id", redeemedVoucher.getId());
            checkAndAddProperty(brazeProperties, "voucher_title", redeemedVoucher.getTitle());
            checkAndAddProperty(brazeProperties, "voucher_code", redeemedVoucher.getVoucherCode());
            checkAndAddProperty(brazeProperties, "voucher_tag", redeemedVoucher.getTag());
            checkAndAddProperty(brazeProperties, "voucher_valid_till_date", redeemedVoucher.getValidTil());
            checkAndAddProperty(brazeProperties, "voucher_discount_type", redeemedVoucher.getDiscountType());
            checkAndAddProperty(brazeProperties, "voucher_discount_value", Double.valueOf((double) redeemedVoucher.getDiscountValue().floatValue()));
            checkAndAddProperty(brazeProperties, "voucher_discount_cap", Double.valueOf((double) redeemedVoucher.getMaxDiscountCap().floatValue()));
            checkAndAddProperty(brazeProperties, "voucher_min_order_value", Double.valueOf((double) redeemedVoucher.getMinOrderValue().floatValue()));
            checkAndAddProperty(brazeProperties, "voucher_deeplink", redeemedVoucher.getDeepLink());
            checkAndAddProperty(brazeProperties, "voucher_description", redeemedVoucher.getDescription());
            checkAndAddProperty(brazeProperties, "termsAndConditions", redeemedVoucher.getTermsAndConditions());
            checkAndAddProperty(brazeProperties, "voucher_campaign_reference_id", redeemedVoucher.getCampaignReferenceId());
            return;
        }
        checkAndAddProperty(brazeProperties, BRAZE_PROPERTY_KEY_VOUCHER_USAGE, Boolean.FALSE);
    }

    public static void checkAndAddProperty(BrazeProperties brazeProperties, String str, Object obj) {
        if (obj != null) {
            brazeProperties.addProperty(str, obj);
        }
    }

    public static boolean checkAndSetCustomUserAttribute(BrazeUser brazeUser, String str, String str2) {
        if (brazeUser == null || str2 == null) {
            return false;
        }
        return brazeUser.setCustomUserAttribute(str, str2);
    }

    public static void citySelected(Context context, String str, String str2) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            currentUser.setCustomUserAttribute("app_last_searched_city_id", str2);
            checkAndSetCustomUserAttribute(currentUser, "app_last_searched_city_text", str);
            Braze.getInstance(context).logCustomEvent(EVENT_NAME_APP_SEARCHED_CITY);
        }
    }

    public static void completeTransaction(Context context, int i11, String str, String str2, String str3, String str4, String str5, String str6, boolean z11) {
        Braze instance = Braze.getInstance(context);
        BrazeUser currentUser = instance.getCurrentUser();
        if (currentUser != null) {
            currentUser.setCustomUserAttribute("app_last_ordered_city_id", GlobalDataModel.SelectedCityId);
            checkAndSetCustomUserAttribute(currentUser, "app_last_ordered_city_text", GlobalDataModel.SelectedCityName);
            currentUser.setCustomUserAttribute("app_last_ordered_region_id", GlobalDataModel.SelectedAreaId);
            checkAndSetCustomUserAttribute(currentUser, "app_last_ordered_region_text", GlobalDataModel.SelectedAreaName);
            currentUser.setCustomUserAttribute("app_last_ordered_country_id", GlobalDataModel.SelectedCountryId);
            checkAndSetCustomUserAttribute(currentUser, "app_last_ordered_country_text", TalabatAdjust.getSelectedCountryName());
            currentUser.setCustomUserAttribute("app_last_ordered_restaurant_id", i11);
            checkAndSetCustomUserAttribute(currentUser, "app_last_ordered_restaurant_text", str);
            checkAndSetCustomUserAttribute(currentUser, "app_last_ordered_restaurant_type", str4);
            checkAndSetCustomUserAttribute(currentUser, "app_last_payment_method", str5);
            checkAndSetCustomUserAttribute(currentUser, "app_last_ordered_time", str3);
            checkAndSetCustomUserAttribute(currentUser, "app_user_delivery_address", str2);
            SharedPreferences sharedPreferences = context.getSharedPreferences(GlobalConstants.PrefsConstants.getNAME(), 0);
            int i12 = sharedPreferences.getInt(BrazeUserMigratorConfig.APP_ORDERS_KEY, 0);
            currentUser.setCustomUserAttribute("app_last_ordered_status", 1);
            int i13 = i12 + 1;
            currentUser.setCustomUserAttribute(BrazeUserMigratorConfig.APP_ORDERS_KEY, i13);
            instance.logCustomEvent(EVENT_NAME_APP_NEWMENU);
            BrazeProperties brazeProperties = new BrazeProperties();
            checkAndAddProperty(brazeProperties, "vendor_id", String.valueOf(i11));
            BrazeProperties brazeProperties2 = new BrazeProperties();
            checkAndAddProperty(brazeProperties2, "vendor_id", String.valueOf(i11));
            if (GlobalDataModel.SELECTED.getRestaurant() != null && GlobalDataModel.SELECTED.getRestaurant().isPickup().booleanValue()) {
                checkAndAddProperty(brazeProperties2, TrackingConstants.EXPEDITION, "pickup");
            }
            checkAndAddProperty(brazeProperties2, BRAZE_PROPERTY_KEY_PAYMENT_METHOD, str5);
            a(brazeProperties2, z11, str6);
            b(brazeProperties2);
            instance.logCustomEvent(EVENT_NAME_APP_ORDERED, brazeProperties2);
            instance.logCustomEvent(EVENT_NAME_APP_ORDERED_RESTAURANT, brazeProperties);
            instance.logCustomEvent(EVENT_NAME_APP_ORDERED_CITY);
            instance.logCustomEvent(EVENT_NAME_APP_ORDERED_AREA);
            instance.logCustomEvent(EVENT_NAME_APP_ORDERED_COUNTRY);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt(BrazeUserMigratorConfig.APP_ORDERS_KEY, i13);
            edit.apply();
        }
    }

    public static void countrySelected(Context context) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            currentUser.setCustomUserAttribute("app_last_searched_country_id", GlobalDataModel.SelectedCountryId);
            checkAndSetCustomUserAttribute(currentUser, "app_last_searched_country_text", TalabatAdjust.getSelectedCountryName());
            Braze.getInstance(context).logCustomEvent(EVENT_NAME_APP_SEARCHED_COUNTRY);
        }
    }

    private static Map<String, String> generateBrazeInfo(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("isQuickUser", String.valueOf(false));
        hashMap.put("userEmail", str);
        hashMap.put("loginType", str2);
        try {
            hashMap.put("userId", String.valueOf(Customer.getInstance().getCustomerInfo().f13850id));
        } catch (Exception e11) {
            LogManager.logException(e11);
        }
        return hashMap;
    }

    public static int getAge(String str) {
        String str2 = "/";
        try {
            if (str.contains(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
                str2 = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            } else if (!str.contains(str2)) {
                str2 = "";
            }
            String[] split = str.split(str2);
            String[] split2 = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).split(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            return Integer.parseInt(split2[0]) - Integer.parseInt(split[0]);
        } catch (Exception e11) {
            LogManager.logException(e11);
            return 0;
        }
    }

    public static String getBdayInBrazeFormat(String str) {
        String str2;
        String str3;
        String str4;
        String str5 = "/";
        try {
            if (str.contains(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
                str5 = SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE;
            } else if (!str.contains(str5)) {
                str5 = "";
            }
            String[] split = str.split(str5);
            if (split[0].length() == 4) {
                str4 = split[0];
                str3 = split[1];
                str2 = split[2].substring(0, 2);
            } else if (split[2].length() == 4) {
                String substring = split[0].substring(0, 2);
                str3 = split[1];
                str4 = split[2];
                str2 = substring;
            } else {
                str2 = "";
                str4 = str2;
                str3 = str4;
            }
            return str4 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str3 + SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str2;
        } catch (Exception e11) {
            LogManager.logException(e11);
            return "";
        }
    }

    public static String getGender(String str) {
        if (str.equalsIgnoreCase("Male") || str.equalsIgnoreCase("1")) {
            return "Male";
        }
        return "Female";
    }

    public static void googleAdvertId(Context context, String str) {
        AppTracker.AdvertingId = str;
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            currentUser.addToCustomAttributeArray(GPS_AD_ID, str);
            Braze.getInstance(context).setGoogleAdvertisingId(str, true);
        }
    }

    public static void groceryCollectionLoaded(Context context) {
        Braze.getInstance(context).logCustomEvent(EVENT_NAME_GROCERY_COLLECTION);
    }

    public static void isRealAcquisition(Context context, boolean z11) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            currentUser.setCustomUserAttribute("app_real_acquisition", z11);
        }
    }

    public static void landOnRewardsScreen(@NotNull Context context) {
        Braze.getInstance(context).logCustomEvent(EVENT_NAME_OPENED_REDEEM_OFFERS);
    }

    public static void onLastSearchedLocation(Context context, double d11, double d12) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (d11 > 0.0d && d12 > 0.0d && currentUser != null) {
            currentUser.setCustomUserAttribute("app_last_searched_latitude", "" + d11);
            currentUser.setCustomUserAttribute("app_last_searched_longitude", "" + d12);
        }
    }

    public static void order_rated(Context context, RateOrderReq rateOrderReq, String str) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            currentUser.setCustomUserAttribute("app_rated_country_id", GlobalDataModel.SelectedCountryId);
            checkAndSetCustomUserAttribute(currentUser, "app_rated_country_text", TalabatAdjust.getSelectedCountryName());
            checkAndSetCustomUserAttribute(currentUser, "app_rated_restaurant_id", rateOrderReq.restId);
            checkAndSetCustomUserAttribute(currentUser, "app_rated_restaurant_name", rateOrderReq.restName);
            checkAndSetCustomUserAttribute(currentUser, "app_rated_order_id", str);
            currentUser.setCustomUserAttribute("app_rated_order_rating", rateOrderReq.totalRating + "");
            Braze.getInstance(context).logCustomEvent(EVENT_NAME_APP_ORDER_RATED);
        }
    }

    public static void purchase(Context context, Purchase purchase, String str, String str2, String str3, String str4, int i11) {
        String str5;
        Braze instance = Braze.getInstance(context);
        BrazeUser currentUser = instance.getCurrentUser();
        if (currentUser != null) {
            checkAndSetCustomUserAttribute(currentUser, "last_order_transaction_id", purchase.getEncyptedTransactionId());
            checkAndSetCustomUserAttribute(currentUser, "last_ordered_primary_cuisine", purchase.getCuisine1());
            checkAndSetCustomUserAttribute(currentUser, "last_ordered_secondary_cuisine", purchase.getSecondaryCuisines());
            if (purchase.getRestaurant().shopType == 0) {
                str5 = "restaurant";
            } else {
                str5 = "grocery";
            }
            currentUser.setCustomUserAttribute("last_ordered_vertical", str5);
            checkAndSetCustomUserAttribute(currentUser, "app_last_order_amount_LC", purchase.getTotal());
        }
        BrazeProperties brazeProperties = new BrazeProperties();
        checkAndAddProperty(brazeProperties, "first_user_name", str);
        checkAndAddProperty(brazeProperties, "last_user_name", str2);
        checkAndAddProperty(brazeProperties, "region", Integer.valueOf(GlobalDataModel.SelectedAreaId));
        checkAndAddProperty(brazeProperties, "country", TalabatAdjust.getSelectedCountryName());
        checkAndAddProperty(brazeProperties, "basket_size", Integer.valueOf(i11));
        checkAndAddProperty(brazeProperties, BRAZE_PROPERTY_KEY_PAYMENT_METHOD, purchase.getPaymentMethod());
        checkAndAddProperty(brazeProperties, AppTracker.LOGIN_TYPE_MOBILE_STRING, str3);
        instance.logPurchase("" + AppTracker.getRestaurantId(purchase.getRestaurant()), TalabatAdjust.getSelectedCurrencyCode(), BigDecimal.valueOf(Double.parseDouble(purchase.getTotal())), 1, brazeProperties);
        instance.requestImmediateDataFlush();
    }

    public static void pushNotificationOptOut(Context context, boolean z11) {
        NotificationSubscriptionType notificationSubscriptionType;
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            if (z11) {
                notificationSubscriptionType = NotificationSubscriptionType.OPTED_IN;
            } else {
                notificationSubscriptionType = NotificationSubscriptionType.UNSUBSCRIBED;
            }
            currentUser.setPushNotificationSubscriptionType(notificationSubscriptionType);
            currentUser.setCustomUserAttribute("app_android_opt_in", z11);
        }
    }

    public static void registrationFinishedTalabat(Context context, CustomerInfo customerInfo, String str) {
        if (customerInfo != null) {
            BrazeProperties brazeProperties = new BrazeProperties();
            checkAndAddProperty(brazeProperties, "user_id", String.valueOf(customerInfo.f13850id));
            checkAndAddProperty(brazeProperties, REGISTRATION_TYPE, str);
            Braze.getInstance(context).logCustomEvent(EVENT_NAME_REGISTRATION_FINISHED, brazeProperties);
            ObservabilityManager.trackRegistration(RegistrationStatus.Success, "Braze Registration Tracking", generateBrazeInfo(customerInfo.email, str));
        }
    }

    public static void registrationStarted(Context context, String str) {
        Braze.getInstance(context).logCustomEvent(EVENT_NAME_REGISTRATION_STARTED);
    }

    public static void restaurantSelected(Context context, int i11, String str) {
        String valueOf = String.valueOf(i11);
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            checkAndSetCustomUserAttribute(currentUser, "app_last_searched_restaurant_id", valueOf);
            checkAndSetCustomUserAttribute(currentUser, "app_last_searched_restaurant_text", str);
            BrazeProperties brazeProperties = new BrazeProperties();
            checkAndAddProperty(brazeProperties, "vendor_id", valueOf);
            Braze.getInstance(context).logCustomEvent("app_searched_restaurant", brazeProperties);
        }
    }

    public static void saveMapFirstLastOrderLatLng(Context context, double d11, double d12) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (d11 > 0.0d && d12 > 0.0d && currentUser != null) {
            currentUser.setCustomUserAttribute("app_last_ordered_lat", "" + d11);
            currentUser.setCustomUserAttribute("app_last_ordered_long", "" + d12);
        }
    }

    public static void sendCustomerInfo(Context context) {
        CustomerInfo customerInfo = Customer.getInstance().getCustomerInfo();
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (customerInfo != null && currentUser != null) {
            String str = customerInfo.birthday;
            String str2 = "";
            if (str == null) {
                str = str2;
            }
            if (customerInfo.getGender() != null) {
                str2 = customerInfo.getGender();
            }
            String gender = getGender(str2);
            String bdayInBrazeFormat = getBdayInBrazeFormat(str);
            checkAndSetCustomUserAttribute(currentUser, "app_birthday", bdayInBrazeFormat);
            currentUser.setCustomUserAttribute("app_age", getAge(bdayInBrazeFormat));
            checkAndSetCustomUserAttribute(currentUser, "app_gender", gender);
            currentUser.setFirstName(customerInfo.firstName);
            currentUser.setLastName(customerInfo.lastName);
            currentUser.setEmail(customerInfo.email);
            currentUser.addToCustomAttributeArray(GPS_AD_ID, AppTracker.AdvertingId);
            Braze.getInstance(context).setGoogleAdvertisingId(AppTracker.AdvertingId, true);
            currentUser.setCustomUserAttribute("app_pre_appboy_user", true);
            if (gender.equalsIgnoreCase("Male") || str2.equalsIgnoreCase("1")) {
                currentUser.setGender(Gender.MALE);
            } else {
                currentUser.setGender(Gender.FEMALE);
            }
            try {
                currentUser.setCustomUserAttribute("app_credit_remaining", Float.parseFloat(String.valueOf(customerInfo.talabatCredit)));
            } catch (Exception e11) {
                LogManager.logException(e11);
            }
        }
    }

    public static void updateRemainingTalabatCredit(Context context, String str) {
        BrazeUser currentUser = Braze.getInstance(context).getCurrentUser();
        if (currentUser != null) {
            try {
                currentUser.setCustomUserAttribute("app_credit_remaining", Float.parseFloat(str));
            } catch (Exception e11) {
                LogManager.logException(e11);
            }
        }
    }

    public static void voucherRedeemed(Context context) {
        Braze.getInstance(context).logCustomEvent(EVENT_NAME_VOUCHER_REDEEMED);
    }
}
