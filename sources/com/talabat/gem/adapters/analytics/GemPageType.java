package com.talabat.gem.adapters.analytics;

public @interface GemPageType {
    public static final String PAGE_CART = "cart";
    public static final String PAGE_CHECKOUT = "checkout";
    public static final String PAGE_LISTING = "shop_list";
    public static final String PAGE_MENU = "shop_details";

    String value();
}
