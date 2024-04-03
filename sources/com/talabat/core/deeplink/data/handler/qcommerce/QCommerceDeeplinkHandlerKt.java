package com.talabat.core.deeplink.data.handler.qcommerce;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000*8\u0010 \"\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\"0!¢\u0006\u0002\b$2\u0019\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\"0!¢\u0006\u0002\b$¨\u0006%"}, d2 = {"CAMPAIGN_TYPE", "", "CART_TYPE", "CATEGORY_TYPE", "DEFAULT_EVENT_ORIGIN", "", "DEFAULT_SHOP_CLICK_ORIGIN", "ENABLED_VARIATION", "KEY_DEEPLINK_INFO", "KEY_NAVIGATION_TARGET", "KEY_SCREEN_NAME", "LIFESTYLE_MISSION_TYPE", "PATH_BANNER", "PATH_BASKET", "PATH_BRANCHES", "PATH_CATEGORY", "PATH_PRODUCT", "PATH_PRODUCTS", "PATH_QCOMMERCE", "PATH_SWIMLANE", "PRODUCT_SKU_TYPE", "PRODUCT_TYPE", "QUERY_BANNER_ID", "QUERY_CATEGORY_ID", "QUERY_EVENT_ORIGIN", "QUERY_IS_LEGACY_BANNER", "QUERY_PRODUCT_ID", "QUERY_PRODUCT_SKU", "QUERY_REDIRECT", "QUERY_SHOP_CLICK_ORIGIN", "QUERY_SWIMLANE_ID", "QUERY_SWIMLANE_NAME", "RouteBuilderModifier", "Lkotlin/Function2;", "Landroid/net/Uri$Builder;", "Lcom/talabat/core/deeplink/data/ParsedLinkModel;", "Lkotlin/ExtensionFunctionType;", "com_talabat_core_deeplink_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class QCommerceDeeplinkHandlerKt {
    private static final int CAMPAIGN_TYPE = 2;
    private static final int CART_TYPE = 3;
    private static final int CATEGORY_TYPE = 4;
    @NotNull
    private static final String DEFAULT_EVENT_ORIGIN = "deeplink";
    @NotNull
    private static final String DEFAULT_SHOP_CLICK_ORIGIN = "deeplink";
    @NotNull
    private static final String ENABLED_VARIATION = "Variation1";
    @NotNull
    private static final String KEY_DEEPLINK_INFO = "i";
    @NotNull
    private static final String KEY_NAVIGATION_TARGET = "t";
    @NotNull
    private static final String KEY_SCREEN_NAME = "n";
    private static final int LIFESTYLE_MISSION_TYPE = 7;
    @NotNull
    private static final String PATH_BANNER = "banner";
    @NotNull
    private static final String PATH_BASKET = "basket";
    @NotNull
    private static final String PATH_BRANCHES = "branches";
    @NotNull
    private static final String PATH_CATEGORY = "category";
    @NotNull
    private static final String PATH_PRODUCT = "product";
    @NotNull
    private static final String PATH_PRODUCTS = "products";
    @NotNull
    private static final String PATH_QCOMMERCE = "qcommerce";
    @NotNull
    private static final String PATH_SWIMLANE = "swimlane";
    private static final int PRODUCT_SKU_TYPE = 5;
    private static final int PRODUCT_TYPE = 1;
    @NotNull
    private static final String QUERY_BANNER_ID = "id";
    @NotNull
    private static final String QUERY_CATEGORY_ID = "id";
    @NotNull
    private static final String QUERY_EVENT_ORIGIN = "eventOrigin";
    @NotNull
    private static final String QUERY_IS_LEGACY_BANNER = "isLegacyBanners";
    @NotNull
    private static final String QUERY_PRODUCT_ID = "productId";
    @NotNull
    private static final String QUERY_PRODUCT_SKU = "productSku";
    @NotNull
    private static final String QUERY_REDIRECT = "redirect";
    @NotNull
    private static final String QUERY_SHOP_CLICK_ORIGIN = "shopClickOrigin";
    @NotNull
    private static final String QUERY_SWIMLANE_ID = "id";
    @NotNull
    private static final String QUERY_SWIMLANE_NAME = "name";
}
