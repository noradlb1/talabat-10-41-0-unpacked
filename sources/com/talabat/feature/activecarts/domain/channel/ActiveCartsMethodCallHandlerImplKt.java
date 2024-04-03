package com.talabat.feature.activecarts.domain.channel;

import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"BASKET_LISTING_METHOD_CHANNEL", "", "KEY_CART_ID", "KEY_FORCE_REQUEST", "METHOD_GET_BASKET_LIST", "METHOD_NAVIGATE_TO_FOOD_BASKET", "METHOD_NAVIGATE_TO_Q_COMMERCE_BASKET", "dispatchError", "", "Lio/flutter/plugin/common/MethodChannel$Result;", "throwable", "", "com_talabat_feature_active-carts_domain_domain"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ActiveCartsMethodCallHandlerImplKt {
    @NotNull
    private static final String BASKET_LISTING_METHOD_CHANNEL = "com.talabat.flutter/basket-listing";
    @NotNull
    private static final String KEY_CART_ID = "cartId";
    @NotNull
    private static final String KEY_FORCE_REQUEST = "forceRequest";
    @NotNull
    private static final String METHOD_GET_BASKET_LIST = "getBasketList";
    @NotNull
    private static final String METHOD_NAVIGATE_TO_FOOD_BASKET = "navigateToFoodBasket";
    @NotNull
    private static final String METHOD_NAVIGATE_TO_Q_COMMERCE_BASKET = "navigateToQCommerceBasket";

    /* access modifiers changed from: private */
    public static final void dispatchError(MethodChannel.Result result, Throwable th2) {
        result.error(th2.getClass().getSimpleName(), th2.getMessage(), th2);
    }
}
