package tracking;

import JsonModels.PolygonEvents;
import android.content.Context;
import androidx.annotation.Nullable;
import buisnessmodels.Cart;
import datamodels.MenuSection;
import datamodels.RateOrderReq;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import tracking.ShopClickedEvent;
import tracking.models.pay.BNPLOrderPaymentFailureTrackingModel;

public interface IAppTracker {
    void onDarkstoresAddToCartClicked(@NotNull Context context, String str, String str2, String str3, String str4, String str5, float f11, int i11, boolean z11, boolean z12, String str6, String str7, @Nullable String str8, @Nullable Integer num, int i12, @Nullable String str9, Integer num2);

    void onDarkstoresSearchResultsClicked(Context context, String str, String str2, @Nullable String str3);

    void onDarkstoresSearchResultsLoaded(Context context, @Nullable String str, String str2, String str3, String str4, List<String> list);

    void onDarkstoresShopDetailsLoaded(Context context, String str, String str2, boolean z11, String str3);

    void onOfferingRestaurantListUpdated(Context context, ArrayList<Restaurant> arrayList, String str, String str2, String str3, String str4, boolean z11, int i11, int i12, boolean z12, String str5, PolygonEvents polygonEvents, String str6, HashMap<String, String> hashMap, ShopClickedEvent.EventOriginSource eventOriginSource, String str7, Boolean bool, Boolean bool2);

    void onOfferingRestaurantsClicked(Context context, Restaurant restaurant, String str, String str2, String str3, String str4, String str5, String str6, PolygonEvents polygonEvents, String str7, HashMap<String, String> hashMap, ShopClickedEvent.EventOriginSource eventOriginSource, boolean z11);

    void onOrderRating(Context context, RateOrderReq rateOrderReq, String str, int i11, int i12, boolean z11);

    void onPushBNPLError(Context context, String str, String str2, String str3);

    void onPushBNPLFakeTestSubmitted(Context context, boolean z11, boolean z12);

    void onPushBNPLOrderPaymentFailureEvent(Context context, BNPLOrderPaymentFailureTrackingModel bNPLOrderPaymentFailureTrackingModel);

    void onPushBNPLValidationLoaded(Context context, String str, String str2);

    void onPushBeginCheckoutEvent(Context context, Cart cart, String str, Boolean bool, Boolean bool2, Boolean bool3);

    void onPushPaymentMethodChanged(Context context, String str, String str2);

    void onPushPlaceFakeOrder(Context context, String str);

    void onRestaurantInfoLoaded(Context context, Restaurant restaurant, boolean z11, String str, ArrayList<MenuSection> arrayList, int i11, int i12, String str2);

    void onSearchClosed(Context context, @Nullable String str, String str2, @Nullable String str3, int i11);

    void onSearchErrorShown(Context context, String str, String str2, String str3, String str4);

    void onSubscriptionVerificationCancelled(Context context, String str, String str2, String str3, String str4);

    void onSubscriptionVerificationClicked(Context context, String str, String str2, String str3, String str4);

    void onSubscriptionVerificationCodeExpired(Context context, String str, String str2, String str3, String str4, String str5);

    void onSubscriptionVerificationCodeResend(Context context, String str, String str2, String str3, String str4, String str5);

    void onSubscriptionVerificationContinued(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void onSubscriptionVerificationErrorShown(Context context, String str, String str2, String str3, String str4, String str5, String str6);

    void onSubscriptionVerificationStarted(Context context, String str, String str2, String str3, String str4, String str5);

    void onSubscriptionVerificationValidated(Context context, String str, String str2, String str3, String str4, String str5);
}
