package tracking;

import androidx.annotation.NonNull;
import com.talabat.core.tracking.domain.AnalyticsType;

public class AdjustTokens {
    @NonNull
    private static AnalyticsType analyticsType = AnalyticsType.GOOGLE;

    public static void a(@NonNull AnalyticsType analyticsType2) {
        analyticsType = analyticsType2;
    }

    @NonNull
    public static String addToCart() {
        return analyticsType == AnalyticsType.HUAWEI ? "hpcd6x" : "21rn4r";
    }

    @NonNull
    public static String addToCartNfv() {
        return analyticsType == AnalyticsType.HUAWEI ? "9qmif8" : "6b3fum";
    }

    @NonNull
    public static String addToCartTMart() {
        return "ytm8lj";
    }

    @NonNull
    public static String appLanuch() {
        return analyticsType == AnalyticsType.HUAWEI ? "mykjxr" : "6mjg76";
    }

    @NonNull
    public static String firstOrder() {
        return analyticsType == AnalyticsType.HUAWEI ? "7jcuif" : "u3efyj";
    }

    @NonNull
    public static String firstOrderNfv() {
        return analyticsType == AnalyticsType.HUAWEI ? "9qmif8" : "qg2v4s";
    }

    @NonNull
    public static String firstOrderTMart() {
        return "1sq8qe";
    }

    @NonNull
    public static String firstorderInApp() {
        return "wg0cze";
    }

    @NonNull
    public static String login() {
        return analyticsType == AnalyticsType.HUAWEI ? "27zzjj" : "whr2bj";
    }

    @NonNull
    public static String orderCompleted() {
        return analyticsType == AnalyticsType.HUAWEI ? "ot7zia" : "7rff25";
    }

    @NonNull
    public static String orderCompletedNfv() {
        return analyticsType == AnalyticsType.HUAWEI ? "smo30j" : "ubm1gn";
    }

    @NonNull
    public static String orderCompletedTMart() {
        return "ola3at";
    }

    @NonNull
    public static String orderWithVoucher() {
        return analyticsType == AnalyticsType.HUAWEI ? "jf5sul" : "5v69ll";
    }

    @NonNull
    public static String proceedToCheckout() {
        return analyticsType == AnalyticsType.HUAWEI ? "3gwcxh" : "tslgks";
    }

    @NonNull
    public static String rateOrder() {
        return analyticsType == AnalyticsType.HUAWEI ? "uk1qaj" : "utdpli";
    }

    @NonNull
    public static String restaurantListScreenOpened() {
        return analyticsType == AnalyticsType.HUAWEI ? "dowt18" : "9b2w2l";
    }

    @NonNull
    public static String restaurantSearch() {
        return analyticsType == AnalyticsType.HUAWEI ? "end4i3" : "56pplh";
    }

    @NonNull
    public static String signUp() {
        return analyticsType == AnalyticsType.HUAWEI ? "ercojc" : "vx8y3q";
    }

    @NonNull
    public static String socialLogin() {
        return analyticsType == AnalyticsType.HUAWEI ? "friin4" : "ukrc3o";
    }

    @NonNull
    public static String tProSubscribed() {
        return "6yrlou";
    }

    public static String tProVendorOrder() {
        return "mykvco";
    }

    @NonNull
    public static String viewDeals() {
        return analyticsType == AnalyticsType.HUAWEI ? "1f7200" : "w16cep";
    }

    @NonNull
    public static String viewRestaurant() {
        return analyticsType == AnalyticsType.HUAWEI ? "revqi9" : "p16se3";
    }

    @NonNull
    public static String voucherRejected() {
        return analyticsType == AnalyticsType.HUAWEI ? "pf4epw" : "wlt0mj";
    }
}
