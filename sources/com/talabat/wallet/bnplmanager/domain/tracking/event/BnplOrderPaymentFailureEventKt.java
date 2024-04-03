package com.talabat.wallet.bnplmanager.domain.tracking.event;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"ATTRIBUTE_KEY_FLOOD_ACTIVE", "", "ATTRIBUTE_KEY_FLOOD_MESSAGE", "ATTRIBUTE_KEY_FLOOD_TYPE", "ATTRIBUTE_KEY_FLOOD_VALUE", "ATTRIBUTE_KEY_OTHERS_CONTACTLESS_DELIVERY", "ATTRIBUTE_KEY_OTHERS_DELIVERY_ADDRESS_STATUS", "ATTRIBUTE_KEY_OTHERS_EXPEDITION_TYPE", "ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD", "ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT", "ATTRIBUTE_KEY_OTHERS_SHOP_PAYMENT_METHODS", "ATTRIBUTE_KEY_OTHERS_TRANSACTION_FAIL_REASON", "ATTRIBUTE_KEY_OTHERS_TRANSACTION_ID", "ATTRIBUTE_KEY_OTHERS_USER_ONLINE_PAYMENT_METHODS", "ATTRIBUTE_KEY_RESTAURANT_CHAIN_ID", "ATTRIBUTE_KEY_RESTAURANT_CHAIN_NAME", "ATTRIBUTE_KEY_RESTAURANT_CHAIN_SHOPS", "ATTRIBUTE_KEY_RESTAURANT_DELIVERY_PROVIDER", "ATTRIBUTE_KEY_RESTAURANT_ORDER_PICK_UP", "ATTRIBUTE_KEY_RESTAURANT_SHOP_DELIVERY_TIME", "ATTRIBUTE_KEY_RESTAURANT_SHOP_ID", "ATTRIBUTE_KEY_RESTAURANT_SHOP_NAME", "ATTRIBUTE_KEY_RESTAURANT_SHOP_STATUS", "ATTRIBUTE_VALUE_NOT_AVAILABLE", "ATTRIBUTE_VALUE_OTHERS_EXPEDITION_TYPE", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BnplOrderPaymentFailureEventKt {
    @NotNull
    public static final String ATTRIBUTE_KEY_FLOOD_ACTIVE = "floodActive";
    @NotNull
    public static final String ATTRIBUTE_KEY_FLOOD_MESSAGE = "floodMessage";
    @NotNull
    public static final String ATTRIBUTE_KEY_FLOOD_TYPE = "floodType";
    @NotNull
    public static final String ATTRIBUTE_KEY_FLOOD_VALUE = "floodValue";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_CONTACTLESS_DELIVERY = "contactlessDelivery";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_DELIVERY_ADDRESS_STATUS = "deliveryAddressStatus";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_EXPEDITION_TYPE = "expeditionType";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD = "orderPaymentMethod";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_ORDER_PAYMENT_METHOD_DEFAULT = "orderPaymentMethodDefault";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_SHOP_PAYMENT_METHODS = "shopPaymentMethods";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_TRANSACTION_FAIL_REASON = "transactionFailReason";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_TRANSACTION_ID = "transactionId";
    @NotNull
    public static final String ATTRIBUTE_KEY_OTHERS_USER_ONLINE_PAYMENT_METHODS = "userOnlinePaymentMethods";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_CHAIN_ID = "chainId";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_CHAIN_NAME = "chainName";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_CHAIN_SHOPS = "chainShops";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_DELIVERY_PROVIDER = "deliveryProvider";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_ORDER_PICK_UP = "orderPickup";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_SHOP_DELIVERY_TIME = "shopDeliveryTime";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_SHOP_ID = "shopId";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_SHOP_NAME = "shopName";
    @NotNull
    public static final String ATTRIBUTE_KEY_RESTAURANT_SHOP_STATUS = "shopStatus";
    @NotNull
    public static final String ATTRIBUTE_VALUE_NOT_AVAILABLE = "0.0";
    @NotNull
    public static final String ATTRIBUTE_VALUE_OTHERS_EXPEDITION_TYPE = "delivery";
}
