package tracking;

import android.content.Context;
import android.util.Log;
import buisnessmodels.Customer;
import buisnessmodels.FilterEngine;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.AdjustEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONArrayInstrumentation;
import com.talabat.core.di.ApiContainer;
import com.talabat.core.tracking.common.events.ShopDetailsLoadedEvent;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import com.talabat.core.tracking.domain.TrackingCoreLibApi;
import com.talabat.feature.nfvinvendorsearch.presentation.activity.QCommerceFlutterActivityKt;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatUtils;
import com.talabat.observability.ObservabilityManager;
import com.talabat.observability.common.RegistrationStatus;
import com.talabat.observability.localTracer.PointOfInterest;
import com.talabat.observability.localTracer.PointOfInterestReporter;
import com.talabat.observability.localTracer.SectionOfInterest;
import com.visa.checkout.PurchaseInfo;
import datamodels.CartMenuItem;
import datamodels.Cuisine;
import datamodels.OffersDisplayModel;
import datamodels.RateOrderItem;
import datamodels.RateOrderReq;
import datamodels.Restaurant;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import library.talabat.mvp.homemap.HomeMapConstants;
import net.bytebuddy.utility.JavaConstant;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
public class TalabatAdjust {
    private static final String BRAZE_DEVICE_ID_PROPERTY = "braze_device_id";
    private static final String TAG = "Adjust";
    public static String userId = "";
    public static String version = "";

    public static class AdjustOfferList {
        public String restaurantBranchIds;
        public String restaurantIds;
        public String restaurantNames;

        private AdjustOfferList() {
        }
    }

    public static class AdjustRestaurantList {
        public String restaurantBranchIds;
        public String restaurantIdWithArea;
        public String restaurantIds;
        public String restaurantNames;

        private AdjustRestaurantList() {
        }
    }

    public static void a(AdjustEvent adjustEvent, String str, Purchase purchase, Restaurant restaurant) {
        StringBuilder sb2 = new StringBuilder();
        ArrayList<CartMenuItem> cart = purchase.getCart();
        int i11 = 0;
        for (int i12 = 0; i12 < purchase.getCart().size(); i12++) {
            if (restaurant.isDarkStore || restaurant.isMigrated) {
                sb2.append(cart.get(i12).getStringId());
                sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
                sb2.append(str);
            } else {
                sb2.append(cart.get(i12).f13861id);
                sb2.append(JavaConstant.Dynamic.DEFAULT_NAME);
                sb2.append(str);
            }
            if (i12 < cart.size() - 1) {
                sb2.append(",");
            }
            i11 += cart.get(i12).getQuantity();
        }
        String sb3 = sb2.toString();
        addAdjustProperty(adjustEvent, FirebaseAnalytics.Param.ITEM_CATEGORY, str);
        addAdjustProperty(adjustEvent, "item_ids", sb3);
        addAdjustProperty(adjustEvent, "currency", getSelectedCurrencyCode());
        addAdjustProperty(adjustEvent, FirebaseAnalytics.Param.PRICE, purchase.getTotal());
        addAdjustProperty(adjustEvent, "number_items", String.valueOf(i11));
    }

    private static void addAdjustProperty(AdjustEvent adjustEvent, String str, String str2) {
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            adjustEvent.addCallbackParameter(str, str2);
            adjustEvent.addPartnerParameter(str, str2);
        }
    }

    private static void addAdjustSessionCallbackProperty(String str, String str2) {
        if (!TalabatUtils.isNullOrEmpty(str2)) {
            Adjust.addSessionCallbackParameter(str, str2);
            Adjust.addSessionPartnerParameter(str, str2);
        }
    }

    private static void addCartItems(AdjustEvent adjustEvent, String str, Purchase purchase, Restaurant restaurant) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", (Object) str);
            jSONObject.put(FirebaseAnalytics.Param.QUANTITY, 1);
            jSONArray.put((Object) jSONObject);
            Iterator<CartMenuItem> it = purchase.getCart().iterator();
            while (it.hasNext()) {
                CartMenuItem next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                if (!restaurant.isDarkStore) {
                    if (!restaurant.isMigrated) {
                        jSONObject2.put("id", (Object) next.f13861id + JavaConstant.Dynamic.DEFAULT_NAME + str);
                        jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, next.getQuantity());
                        jSONObject2.put("item_price", (double) next.getTotalPrice());
                        jSONArray.put((Object) jSONObject2);
                    }
                }
                jSONObject2.put("id", (Object) next.getStringId() + JavaConstant.Dynamic.DEFAULT_NAME + str);
                jSONObject2.put(FirebaseAnalytics.Param.QUANTITY, next.getQuantity());
                jSONObject2.put("item_price", (double) next.getTotalPrice());
                jSONArray.put((Object) jSONObject2);
            }
            adjustEvent.addPartnerParameter("fb_content", JSONArrayInstrumentation.toString(jSONArray));
            a(adjustEvent, str, purchase, restaurant);
        } catch (JSONException unused) {
        }
    }

    public static void addEventAdjustCommonParameters() {
        if (Customer.getInstance().isLoggedIn() && Customer.getInstance().getCustomerInfo() != null) {
            String str = Customer.getInstance().getCustomerInfo().encgid;
            if (!TalabatUtils.isNullOrEmpty(str)) {
                addAdjustSessionCallbackProperty("user_id", str);
            }
        }
        if (GlobalDataModel.SelectedCountryId > 0) {
            addAdjustSessionCallbackProperty("country", "" + GlobalDataModel.SelectedCountryName);
        }
        String str2 = GlobalDataModel.SelectedAreaName;
        if (str2 != null) {
            addAdjustSessionCallbackProperty("area_name", str2);
        }
    }

    public static void addSessionCallbackParameter(Context context) {
        if (Customer.getInstance().isLoggedIn(context) && Customer.getInstance().getCustomerInfo() != null) {
            String str = Customer.getInstance().getCustomerInfo().encgid;
            if (!TalabatUtils.isNullOrEmpty(str)) {
                addAdjustSessionCallbackProperty("user_id", str);
            }
        }
        String str2 = "";
        if (GlobalDataModel.SelectedCountryId > 0) {
            addAdjustSessionCallbackProperty("country", str2 + GlobalDataModel.SelectedCountryName);
        }
        if (GlobalDataModel.SelectedCityId > 0) {
            addAdjustSessionCallbackProperty(ConstantsKt.ADJUST_CITY_ID, str2 + GlobalDataModel.SelectedCityId);
        }
        if (GlobalDataModel.SelectedAreaId > 0) {
            addAdjustSessionCallbackProperty("area_id", str2 + GlobalDataModel.SelectedAreaId);
        }
        if (!TalabatUtils.isNullOrEmpty(version)) {
            addAdjustSessionCallbackProperty("app_version", version);
        }
        if (!TalabatUtils.isNullOrEmpty(GlobalDataModel.SelectedLanguage)) {
            if (GlobalDataModel.SelectedLanguage.equals("en-US")) {
                str2 = "en";
            } else if (GlobalDataModel.SelectedLanguage.equals(GlobalConstants.ARABIC)) {
                str2 = ArchiveStreamFactory.AR;
            }
            Log.e("lang", str2);
            addAdjustSessionCallbackProperty(ConstantsKt.ADJUST_LANGUAGE, str2);
        }
    }

    public static void addToCart(Restaurant restaurant, CartMenuItem cartMenuItem) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.addToCart())) {
            if (restaurant.isTMart()) {
                sendAddToCartEvent(restaurant, cartMenuItem, AdjustTokens.addToCartTMart());
            } else if (restaurant.shopType != 0) {
                sendAddToCartEvent(restaurant, cartMenuItem, AdjustTokens.addToCartNfv());
            }
            sendAddToCartEvent(restaurant, cartMenuItem, AdjustTokens.addToCart());
        }
    }

    public static void appLanuch(Context context) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.appLanuch())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.appLanuch());
            addSessionCallbackParameter(context);
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static String createdAt() {
        try {
            return new SimpleDateFormat("M/d/yyyy").format(Calendar.getInstance().getTime());
        } catch (Exception unused) {
            return "N/A";
        }
    }

    public static void firstOrder(Purchase purchase) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.firstOrder())) {
            if (purchase.getRestaurant().isTMart()) {
                sendFirstOrderEvent(purchase, AdjustTokens.firstOrderTMart());
            } else if (purchase.getRestaurant().shopType != 0) {
                sendFirstOrderEvent(purchase, AdjustTokens.firstOrderNfv());
            }
            sendFirstOrderEvent(purchase, AdjustTokens.firstOrder());
        }
    }

    public static void firstorderInApp(Purchase purchase) {
        boolean z11;
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.firstorderInApp())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.firstOrder());
            Restaurant restaurant = purchase.getRestaurant();
            addEventAdjustCommonParameters();
            addAdjustProperty(adjustEvent, "transaction_id", "" + purchase.getTransactionId());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            if (restaurant.isMealDealAvailable || restaurant.isCouponAvailable) {
                z11 = true;
            } else {
                z11 = false;
            }
            sb2.append(z11);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb2.toString());
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.VENDOR_NAME, restaurant.getName());
            addAdjustProperty(adjustEvent, "vendor_id", "" + restaurant.branchId);
            addAdjustProperty(adjustEvent, "chain_id", "" + restaurant.getId());
            addAdjustProperty(adjustEvent, QCommerceFlutterActivityKt.KEY_VOUCHER_ID, "" + purchase.getVoucherCode());
            addAdjustProperty(adjustEvent, "voucher_value", "" + purchase.getVoucherAmount());
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_SCORE, "" + restaurant.rating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_QUANTITY, "" + restaurant.totalRating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.CUISINE_NAMES, getCuisines(restaurant.getCuisines()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(!restaurant.isTalabatGo);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.OWN_DELIVERY, sb3.toString());
            addAdjustProperty(adjustEvent, "total_transaction", purchase.getTotal());
            addAdjustProperty(adjustEvent, "currency", getSelectedCurrencyCode());
            addAdjustProperty(adjustEvent, TalabatAppBoy.BRAZE_PROPERTY_KEY_PAYMENT_METHOD, purchase.getPaymentMethod());
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static AdjustOfferList getAdjustOfferList(ArrayList<OffersDisplayModel> arrayList) {
        AdjustOfferList adjustOfferList = new AdjustOfferList();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        Iterator<OffersDisplayModel> it = arrayList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            OffersDisplayModel next = it.next();
            jSONArray.put((Object) "" + next.restaurantId);
            jSONArray3.put((Object) "" + next.branchId);
            jSONArray2.put((Object) next.restaurantName);
            i11++;
            if (i11 > 2) {
                break;
            }
        }
        adjustOfferList.restaurantIds = JSONArrayInstrumentation.toString(jSONArray);
        adjustOfferList.restaurantNames = JSONArrayInstrumentation.toString(jSONArray2);
        adjustOfferList.restaurantBranchIds = JSONArrayInstrumentation.toString(jSONArray3);
        return adjustOfferList;
    }

    public static AdjustRestaurantList getAjustRestaurantList(ArrayList<Restaurant> arrayList) {
        AdjustRestaurantList adjustRestaurantList = new AdjustRestaurantList();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        JSONArray jSONArray3 = new JSONArray();
        JSONArray jSONArray4 = new JSONArray();
        Iterator<Restaurant> it = arrayList.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            Restaurant next = it.next();
            jSONArray.put((Object) "" + next.getId());
            jSONArray2.put((Object) next.getName());
            jSONArray4.put((Object) "" + next.branchId);
            if (GlobalDataModel.SelectedAreaId > 0) {
                jSONArray3.put((Object) "" + GlobalDataModel.SelectedAreaId + JavaConstant.Dynamic.DEFAULT_NAME + next.getName());
            }
            i11++;
            if (i11 > 9) {
                break;
            }
        }
        adjustRestaurantList.restaurantIds = JSONArrayInstrumentation.toString(jSONArray);
        adjustRestaurantList.restaurantNames = JSONArrayInstrumentation.toString(jSONArray2);
        adjustRestaurantList.restaurantIdWithArea = JSONArrayInstrumentation.toString(jSONArray3);
        adjustRestaurantList.restaurantBranchIds = JSONArrayInstrumentation.toString(jSONArray4);
        return adjustRestaurantList;
    }

    private static float getAverageRating(RateOrderReq rateOrderReq) {
        float f11 = rateOrderReq.deliveryRating + rateOrderReq.packageRating + rateOrderReq.valueRating;
        RateOrderItem[] rateOrderItemArr = rateOrderReq.items;
        int length = rateOrderItemArr.length + 3;
        for (RateOrderItem rateOrderItem : rateOrderItemArr) {
            f11 += rateOrderItem.rating;
        }
        return f11 / ((float) length);
    }

    public static String getCuisines(Cuisine[] cuisineArr) {
        JSONArray jSONArray = new JSONArray();
        if (cuisineArr != null) {
            for (Cuisine name2 : cuisineArr) {
                jSONArray.put((Object) name2.getName());
            }
        }
        return JSONArrayInstrumentation.toString(jSONArray);
    }

    public static String getFBContent(int i11) {
        return "[{\"id\": \"" + i11 + "\", \"quantity\": 1}]";
    }

    public static String getFBContentType() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) "product");
        jSONArray.put((Object) "local_service_business");
        return JSONArrayInstrumentation.toString(jSONArray);
    }

    @Deprecated
    public static String getSelectedCountryIso() {
        switch (GlobalDataModel.SelectedCountryId) {
            case 2:
                return "SAU";
            case 3:
                return "BHR";
            case 4:
                return "ARE";
            case 5:
                return "OMN";
            case 6:
                return "QAT";
            case 7:
                return "LBN";
            case 8:
                return "JOR";
            case 9:
                return "EGY";
            case 10:
                return "IRQ";
            default:
                return "KWT";
        }
    }

    public static String getSelectedCountryName() {
        switch (GlobalDataModel.SelectedCountryId) {
            case 2:
                return HomeMapConstants.GEO_POLYGON_COUNTRY_KSA;
            case 3:
                return "Bahrain";
            case 4:
                return HomeMapConstants.GEO_POLYGON_COUNTRY_UAE;
            case 5:
                return HomeMapConstants.GEO_POLYGON_COUNTRY_OMAN;
            case 6:
                return HomeMapConstants.GEO_POLYGON_COUNTRY_QATAR;
            case 7:
                return "Lebanon";
            case 8:
                return HomeMapConstants.GEO_POLYGON_COUNTRY_JORDAN;
            case 9:
                return "Egypt";
            case 10:
                return "Iraq";
            default:
                return "Kuwait";
        }
    }

    public static String getSelectedCurrencyCode() {
        switch (GlobalDataModel.SelectedCountryId) {
            case 2:
                return PurchaseInfo.Currency.SAR;
            case 3:
                return "BHD";
            case 4:
                return PurchaseInfo.Currency.AED;
            case 5:
                return "OMR";
            case 6:
                return PurchaseInfo.Currency.QAR;
            case 7:
                return "LBP";
            case 8:
                return "JOD";
            case 9:
                return "EGP";
            case 10:
                return "IQD";
            default:
                return PurchaseInfo.Currency.KWD;
        }
    }

    public static String gtmLanguageSelected(String str) {
        if (TalabatUtils.isNullOrEmpty(str)) {
            return "";
        }
        if (str.equalsIgnoreCase(GlobalConstants.ARABIC)) {
            return "arabic";
        }
        if (str.equalsIgnoreCase(GlobalConstants.KURDISH_BADINI)) {
            return "Kurdish Badini";
        }
        if (str.equalsIgnoreCase(GlobalConstants.KURDISH_SORANI)) {
            return "Kurdish Sorani";
        }
        return "english";
    }

    public static void initializeAdjust(Context context) {
        PointOfInterestReporter.INSTANCE.startTraceLog(SectionOfInterest.SPLASH_ACTIVITY, PointOfInterest.ADJUST_INIT);
        if (context instanceof ApiContainer) {
            AdjustTokens.a(((TrackingCoreLibApi) ((ApiContainer) context).getFeature(TrackingCoreLibApi.class)).getAnalyticsType());
        }
        try {
            version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
        }
        PointOfInterestReporter.INSTANCE.endTraceLog(SectionOfInterest.SPLASH_ACTIVITY, PointOfInterest.ADJUST_INIT);
    }

    public static void integrateWithBraze(String str) {
        if (!TalabatUtils.isNullOrEmpty(str)) {
            Adjust.addSessionPartnerParameter(BRAZE_DEVICE_ID_PROPERTY, str);
        }
    }

    public static void login() {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.login())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.login());
            if (!TalabatUtils.isNullOrEmpty(userId)) {
                addAdjustSessionCallbackProperty("user_id", userId);
            }
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void orderCompleted(Purchase purchase) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.orderCompleted())) {
            sendOrderCompletedEvent(purchase, AdjustTokens.orderCompleted(), false);
            if (purchase.getRestaurant().isTMart()) {
                sendOrderCompletedEvent(purchase, AdjustTokens.orderCompletedTMart(), true);
            } else if (purchase.getRestaurant().shopType != 0) {
                sendOrderCompletedEvent(purchase, AdjustTokens.orderCompletedNfv(), true);
            }
        }
    }

    public static void orderWithVoucher(Purchase purchase) {
        String str;
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.orderWithVoucher())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.orderWithVoucher());
            Restaurant restaurant = purchase.getRestaurant();
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.VENDOR_NAME, restaurant.getName());
            addAdjustProperty(adjustEvent, "vendor_id", "" + restaurant.branchId);
            addAdjustProperty(adjustEvent, "chain_id", "" + restaurant.getId());
            addAdjustProperty(adjustEvent, QCommerceFlutterActivityKt.KEY_VOUCHER_ID, "" + purchase.getVoucherCode());
            addAdjustProperty(adjustEvent, "voucher_value", "" + purchase.getVoucherAmount());
            addAdjustProperty(adjustEvent, "transaction_id", purchase.getTransactionId());
            addAdjustProperty(adjustEvent, "total_transaction", purchase.getTotal());
            addAdjustProperty(adjustEvent, "currency", getSelectedCurrencyCode());
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_SCORE, "" + restaurant.rating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_QUANTITY, "" + restaurant.totalRating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.CUISINE_NAMES, getCuisines(restaurant.getCuisines()));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            boolean z11 = true;
            sb2.append(!restaurant.isTalabatGo);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.OWN_DELIVERY, sb2.toString());
            if (purchase.isFirstOrder()) {
                str = "true";
            } else {
                str = "false";
            }
            addAdjustProperty(adjustEvent, "is_acquisition", str);
            addAdjustProperty(adjustEvent, TalabatAppBoy.BRAZE_PROPERTY_KEY_PAYMENT_METHOD, purchase.getPaymentMethod());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            if (!restaurant.isMealDealAvailable && !restaurant.isCouponAvailable) {
                z11 = false;
            }
            sb3.append(z11);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb3.toString());
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void proceedToCheckout(int i11, Restaurant restaurant, String str) {
        boolean z11;
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.proceedToCheckout())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.proceedToCheckout());
            adjustEvent.addCallbackParameter(ShopDetailsLoadedEvent.VENDOR_NAME, str);
            addAdjustProperty(adjustEvent, "vendor_id", "" + restaurant.branchId);
            addAdjustProperty(adjustEvent, "chain_id", "" + i11);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            if (restaurant.isMealDealAvailable || restaurant.isCouponAvailable) {
                z11 = true;
            } else {
                z11 = false;
            }
            sb2.append(z11);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb2.toString());
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_SCORE, "" + restaurant.rating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_QUANTITY, "" + restaurant.totalRating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.CUISINE_NAMES, getCuisines(restaurant.getCuisines()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(!restaurant.isTalabatGo);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.OWN_DELIVERY, sb3.toString());
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void rateOrder(RateOrderReq rateOrderReq, int i11, int i12, boolean z11) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.rateOrder())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.rateOrder());
            if (z11) {
                addAdjustProperty(adjustEvent, FilterEngine.DEEPLINKSORT.RATING, "" + rateOrderReq.totalRating);
            } else {
                addAdjustProperty(adjustEvent, FilterEngine.DEEPLINKSORT.RATING, "" + getAverageRating(rateOrderReq));
            }
            addAdjustProperty(adjustEvent, "transaction_id", "" + i12);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.VENDOR_NAME, rateOrderReq.restName);
            addAdjustProperty(adjustEvent, "vendor_id", "" + i11);
            addAdjustProperty(adjustEvent, "chain_id", "" + rateOrderReq.restId);
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void restaurantListScreenOpened(ArrayList<Restaurant> arrayList, String str, String str2, String str3) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.restaurantListScreenOpened())) {
            AdjustRestaurantList ajustRestaurantList = getAjustRestaurantList(arrayList);
            addEventAdjustCommonParameters();
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.restaurantListScreenOpened());
            adjustEvent.addCallbackParameter("vendor_names", ajustRestaurantList.restaurantNames);
            addAdjustProperty(adjustEvent, "vendor_ids", ajustRestaurantList.restaurantBranchIds);
            addAdjustProperty(adjustEvent, "chain_ids", ajustRestaurantList.restaurantIds);
            addAdjustProperty(adjustEvent, "category", str);
            addAdjustProperty(adjustEvent, "sorting", str2);
            addAdjustProperty(adjustEvent, "filter", str3);
            adjustEvent.addPartnerParameter("fb_content_id", ajustRestaurantList.restaurantBranchIds);
            adjustEvent.addPartnerParameter("fb_content_type", getFBContentType());
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void restaurantOfferScreenOpened(ArrayList<OffersDisplayModel> arrayList) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.viewDeals())) {
            AdjustOfferList adjustOfferList = getAdjustOfferList(arrayList);
            addEventAdjustCommonParameters();
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.viewDeals());
            adjustEvent.addCallbackParameter("vendor_names", adjustOfferList.restaurantNames);
            addAdjustProperty(adjustEvent, "chain_ids", adjustOfferList.restaurantIds);
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void sendAddToCartEvent(Restaurant restaurant, CartMenuItem cartMenuItem, String str) {
        sendAddToCartEvent(restaurant, String.valueOf(cartMenuItem.f13861id), cartMenuItem.getQuantity(), cartMenuItem.getTotalPrice(), str);
    }

    public static void sendFirstOrderEvent(Purchase purchase, String str) {
        boolean z11;
        AdjustEvent adjustEvent = new AdjustEvent(str);
        Restaurant restaurant = purchase.getRestaurant();
        addEventAdjustCommonParameters();
        addAdjustProperty(adjustEvent, "transaction_id", "" + purchase.getTransactionId());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        if (restaurant.isMealDealAvailable || restaurant.isCouponAvailable) {
            z11 = true;
        } else {
            z11 = false;
        }
        sb2.append(z11);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb2.toString());
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.VENDOR_NAME, restaurant.getName());
        addAdjustProperty(adjustEvent, "vendor_id", "" + restaurant.branchId);
        addAdjustProperty(adjustEvent, "chain_id", "" + restaurant.getId());
        addAdjustProperty(adjustEvent, QCommerceFlutterActivityKt.KEY_VOUCHER_ID, "" + purchase.getVoucherCode());
        addAdjustProperty(adjustEvent, "voucher_value", "" + purchase.getVoucherAmount());
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_SCORE, "" + restaurant.rating);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_QUANTITY, "" + restaurant.totalRating);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.CUISINE_NAMES, getCuisines(restaurant.getCuisines()));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append(!restaurant.isTalabatGo);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.OWN_DELIVERY, sb3.toString());
        addAdjustProperty(adjustEvent, "total_transaction", purchase.getTotal());
        addAdjustProperty(adjustEvent, "currency", getSelectedCurrencyCode());
        addAdjustProperty(adjustEvent, TalabatAppBoy.BRAZE_PROPERTY_KEY_PAYMENT_METHOD, purchase.getPaymentMethod());
        addCartItems(adjustEvent, String.valueOf(restaurant.branchId), purchase, restaurant);
        adjustEvent.addPartnerParameter("fb_content_type", getFBContentType());
        Adjust.trackEvent(adjustEvent);
    }

    public static void sendOrderCompletedEvent(Purchase purchase, String str, boolean z11) {
        String str2;
        float f11;
        AdjustEvent adjustEvent = new AdjustEvent(str);
        Restaurant restaurant = purchase.getRestaurant();
        addEventAdjustCommonParameters();
        addAdjustProperty(adjustEvent, "transaction_id", purchase.getTransactionId());
        addAdjustProperty(adjustEvent, QCommerceFlutterActivityKt.KEY_VOUCHER_ID, "" + purchase.getVoucherCode());
        addAdjustProperty(adjustEvent, "voucher_value", "" + purchase.getVoucherAmount());
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.VENDOR_NAME, restaurant.getName());
        addAdjustProperty(adjustEvent, "vendor_id", "" + restaurant.branchId);
        addAdjustProperty(adjustEvent, "chain_id", "" + restaurant.getId());
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_SCORE, "" + restaurant.rating);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_QUANTITY, "" + restaurant.totalRating);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.CUISINE_NAMES, getCuisines(restaurant.getCuisines()));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        boolean z12 = true;
        sb2.append(!restaurant.isTalabatGo);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.OWN_DELIVERY, sb2.toString());
        if (purchase.isFirstOrder()) {
            str2 = "true";
        } else {
            str2 = "false";
        }
        addAdjustProperty(adjustEvent, "is_acquisition", str2);
        addAdjustProperty(adjustEvent, TalabatAppBoy.BRAZE_PROPERTY_KEY_PAYMENT_METHOD, purchase.getPaymentMethod());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        if (!restaurant.isMealDealAvailable && !restaurant.isCouponAvailable) {
            z12 = false;
        }
        sb3.append(z12);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb3.toString());
        adjustEvent.addPartnerParameter("fb_content_id", "" + restaurant.branchId);
        addCartItems(adjustEvent, String.valueOf(restaurant.branchId), purchase, restaurant);
        adjustEvent.addPartnerParameter("fb_content_type", getFBContentType());
        try {
            f11 = Float.parseFloat(purchase.getTotal());
        } catch (Exception e11) {
            Log.e("Adjust", e11.getMessage());
            f11 = 0.01f;
        }
        adjustEvent.setRevenue((double) f11, getSelectedCurrencyCode());
        if (!z11) {
            adjustEvent.setOrderId("{" + purchase.getTransactionId() + "}");
        }
        Adjust.trackEvent(adjustEvent);
    }

    public static void signUp() {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.signUp())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.signUp());
            if (!TalabatUtils.isNullOrEmpty(userId)) {
                addAdjustSessionCallbackProperty("user_id", userId);
            }
            Adjust.trackEvent(adjustEvent);
        }
        ObservabilityManager.trackRegistration(RegistrationStatus.Success, "Adjust Tracking", Collections.singletonMap("userId", userId));
    }

    public static void socialLogin(int i11) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.socialLogin())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.socialLogin());
            if (i11 == 100) {
                addAdjustSessionCallbackProperty("user_id", userId);
            }
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void viewRestaurant(Restaurant restaurant) {
        boolean z11;
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.viewRestaurant())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.viewRestaurant());
            adjustEvent.addCallbackParameter(ShopDetailsLoadedEvent.VENDOR_NAME, restaurant.getName());
            addAdjustProperty(adjustEvent, "vendor_id", "" + restaurant.branchId);
            addAdjustProperty(adjustEvent, "chain_id", "" + restaurant.f13872id);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("");
            if (restaurant.isMealDealAvailable || restaurant.isCouponAvailable) {
                z11 = true;
            } else {
                z11 = false;
            }
            sb2.append(z11);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb2.toString());
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_SCORE, "" + restaurant.rating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_QUANTITY, "" + restaurant.totalRating);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.CUISINE_NAMES, getCuisines(restaurant.getCuisines()));
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            sb3.append(!restaurant.isTalabatGo);
            addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.OWN_DELIVERY, sb3.toString());
            adjustEvent.addPartnerParameter("fb_content_id", "" + restaurant.branchId);
            adjustEvent.addPartnerParameter("fb_content", getFBContent(restaurant.branchId));
            adjustEvent.addPartnerParameter("fb_content_type", getFBContentType());
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void voucherRejected(ArrayList<CartMenuItem> arrayList, Restaurant restaurant, String str, String str2) {
        boolean z11;
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.voucherRejected())) {
            AdjustEvent adjustEvent = new AdjustEvent(AdjustTokens.voucherRejected());
            if (restaurant != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                if (restaurant.isMealDealAvailable || restaurant.isCouponAvailable) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                sb2.append(z11);
                addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb2.toString());
            }
            addAdjustProperty(adjustEvent, QCommerceFlutterActivityKt.KEY_VOUCHER_ID, "" + str);
            addAdjustProperty(adjustEvent, "voucher_rejection_reason", str2);
            Adjust.trackEvent(adjustEvent);
        }
    }

    public static void sendAddToCartEvent(Restaurant restaurant, String str, int i11, float f11, String str2) {
        AdjustEvent adjustEvent = new AdjustEvent(str2);
        adjustEvent.addCallbackParameter(ShopDetailsLoadedEvent.VENDOR_NAME, restaurant.getName());
        addAdjustProperty(adjustEvent, "vendor_id", "" + restaurant.branchId);
        addAdjustProperty(adjustEvent, "chain_id", "" + restaurant.getId());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(restaurant.isMealDealAvailable || restaurant.isCouponAvailable);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.DEAL, sb2.toString());
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_SCORE, "" + restaurant.rating);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.RATING_QUANTITY, "" + restaurant.totalRating);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.CUISINE_NAMES, getCuisines(restaurant.getCuisines()));
        StringBuilder sb3 = new StringBuilder();
        sb3.append("");
        sb3.append(!restaurant.isTalabatGo);
        addAdjustProperty(adjustEvent, ShopDetailsLoadedEvent.OWN_DELIVERY, sb3.toString());
        adjustEvent.addPartnerParameter("fb_content_id", "" + restaurant.branchId);
        String valueOf = String.valueOf(restaurant.branchId);
        adjustEvent.addPartnerParameter("fb_content", "[{\"id\": \"" + valueOf + "\", \"quantity\": 1},{\"id\": \"" + str + JavaConstant.Dynamic.DEFAULT_NAME + valueOf + "\", \"quantity\": \"" + i11 + "\", \"item_price\": \"" + f11 + "\"}]");
        adjustEvent.addPartnerParameter("fb_content_type", getFBContentType());
        Adjust.trackEvent(adjustEvent);
    }

    public static void addToCart(Restaurant restaurant, String str, int i11, float f11) {
        if (!TalabatUtils.isNullOrEmpty(AdjustTokens.addToCart())) {
            if (restaurant.isTMart()) {
                sendAddToCartEvent(restaurant, str, i11, f11, AdjustTokens.addToCartTMart());
            } else if (restaurant.shopType != 0) {
                sendAddToCartEvent(restaurant, str, i11, f11, AdjustTokens.addToCartNfv());
            }
            sendAddToCartEvent(restaurant, str, i11, f11, AdjustTokens.addToCart());
        }
    }
}
