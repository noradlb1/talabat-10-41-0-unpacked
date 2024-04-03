package com.talabat.core.flutter.channels.impl.data.cart.dto;

import buisnessmodels.Cart;
import com.google.firebase.analytics.FirebaseAnalytics;
import datamodels.CartMenuItem;
import datamodels.Restaurant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0004\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0005¨\u0006\u0006"}, d2 = {"toMap", "", "", "", "Lbuisnessmodels/Cart;", "Ldatamodels/CartMenuItem;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FlutterCartKt {
    @NotNull
    public static final Map<String, Object> toMap(@NotNull Cart cart) {
        Intrinsics.checkNotNullParameter(cart, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Restaurant restaurant = cart.getRestaurant();
        linkedHashMap.put("cartBranchId", restaurant != null ? Integer.valueOf(restaurant.branchId) : null);
        linkedHashMap.put("cartSubTotal", Float.valueOf(cart.getCartSubTotal()));
        linkedHashMap.put("cartTotal", Float.valueOf(cart.getCartTotalPrice()));
        Restaurant restaurant2 = cart.getRestaurant();
        linkedHashMap.put("cartVendorName", restaurant2 != null ? restaurant2.f13873name : null);
        Restaurant restaurant3 = cart.getRestaurant();
        linkedHashMap.put("cartVendorImage", restaurant3 != null ? restaurant3.logoUrl : null);
        linkedHashMap.put("deliveryMode", cart.getDeliveryMode());
        if (cart.getCartItems() != null) {
            ArrayList<CartMenuItem> cartItems = cart.getCartItems();
            Intrinsics.checkNotNullExpressionValue(cartItems, "cartItems");
            if (!cartItems.isEmpty()) {
                ArrayList<CartMenuItem> cartItems2 = cart.getCartItems();
                Intrinsics.checkNotNullExpressionValue(cartItems2, "cartItems");
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(cartItems2, 10));
                for (CartMenuItem cartMenuItem : cartItems2) {
                    Intrinsics.checkNotNullExpressionValue(cartMenuItem, "it");
                    arrayList.add(toMap(cartMenuItem));
                }
                linkedHashMap.put("cartItems", arrayList);
                return linkedHashMap;
            }
        }
        linkedHashMap.put("cartItems", (Object) null);
        return linkedHashMap;
    }

    @NotNull
    public static final Map<String, Object> toMap(@NotNull CartMenuItem cartMenuItem) {
        Intrinsics.checkNotNullParameter(cartMenuItem, "<this>");
        return MapsKt__MapsKt.mutableMapOf(TuplesKt.to(FirebaseAnalytics.Param.QUANTITY, Integer.valueOf(cartMenuItem.getQuantity())), TuplesKt.to("itemId", Integer.valueOf(cartMenuItem.f13861id)));
    }
}
