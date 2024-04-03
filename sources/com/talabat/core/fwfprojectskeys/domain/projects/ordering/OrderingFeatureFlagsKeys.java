package com.talabat.core.fwfprojectskeys.domain.projects.ordering;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/ordering/OrderingFeatureFlagsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "LENDING_BNPL_OVERDUE_ENABLED", "LENDING_BNPL_RIDER_TIP_ENABLED", "LENDING_BNPL_PAYMENT_FALLBACK_ENABLED", "LENDING_BNPL_NEW_ADHOC_PAYMENT_ENABLED", "LENDING_BNPL_HIDE_OPTION_ENABLED", "LENDING_BNPL_MULTI_ORDERS_PAYMENT", "WALLET_DASHBOARD_COBRANDED_CC", "LENDING_IS_BNPL_LIABILITY_LIMIT_INCREASED", "LENDING_IS_UPW_ENABLED", "LENDING_ADHOC_IS_UPW_ENABLED", "ADD_CARD_HOLDER_NAME_ENABLED", "INCENTIVE_AUTO_APPLY_DISCOUNTS_ENABLED", "CART_INCREMENT_QUANTITY_ENABLED", "CART_FALLBACK_ENABLED", "PAYMENT_SHOULD_USE_FLUTTER_WEB_VIEW", "PAYMENT_METHOD_FALLBACK_METHOD_ENABLED", "FLUTTER_CART_CHECKOUT_DEEPLINK_ENABLED", "FLUTTER_CART_MENU_DEEPLINK_ENABLED", "FLUTTER_USE_UL_REDIRECTION_FLUTTER_CART", "FLUTTER_LOAD_CHECKOUT_USING_HTTP_POST", "FLUTTER_CHECKOUT_ADDRESS_LIST_DEEPLINK_ENABLED", "FLUTTER_CHECKOUT_ADD_ADDRESS_BUTTON_ENABLED", "FLUTTER_CHECKOUT_ORDER_TRACKING_DEEPLINK_ENABLED", "FLUTTER_HOME_CART_DEEPLINK_ENABLED", "FLUTTER_MENU_CART_DEEPLINK_ENABLED", "FLUTTER_PUSH_NOTIFICATION_CART_DEEPLINK_ENABLED", "FLUTTER_VENDOR_LIST_CART_DEEPLINK_ENABLED", "CART_CACHE_ENABLED", "ENABLE_CHECKOUT_PURCHASE_TRACKING_EVENTS", "IS_GUEST_USER_CHECKOUT_ENABLED", "FLUTTER_SEND_THANK_YOU_EMAIL", "IS_CART_SYNC_ON_MISMATCH_ENABLED", "BADGE_ORDER_LIST_TAB_BAR_ENABLED", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum OrderingFeatureFlagsKeys implements FWFKey {
    LENDING_BNPL_OVERDUE_ENABLED("ff_ordering_bnpl_ob_notification_enabled", (int) null, 2, (FWFProjectName) null),
    LENDING_BNPL_RIDER_TIP_ENABLED("ff_ordering_bnpl_rider_tip_enabled", (int) null, 2, (FWFProjectName) null),
    LENDING_BNPL_PAYMENT_FALLBACK_ENABLED("ff_ordering_bnpl_payment_fallback_enabled", (int) null, 2, (FWFProjectName) null),
    LENDING_BNPL_NEW_ADHOC_PAYMENT_ENABLED("ff_ordering_bnpl_new_adhoc_payment_enabled", (int) null, 2, (FWFProjectName) null),
    LENDING_BNPL_HIDE_OPTION_ENABLED("ff_ordering_bnpl_hide_option_enabled", (int) null, 2, (FWFProjectName) null),
    LENDING_BNPL_MULTI_ORDERS_PAYMENT("ff_ordering_bnpl_multi_orders_payment_enabled", (int) null, 2, (FWFProjectName) null),
    WALLET_DASHBOARD_COBRANDED_CC("ff_ordering_wallet_dashboard_cobranded_cc", (int) null, 2, (FWFProjectName) null),
    LENDING_IS_BNPL_LIABILITY_LIMIT_INCREASED("ff_ordering_is_bnpl_liability_limit_increased", (int) null, 2, (FWFProjectName) null),
    LENDING_IS_UPW_ENABLED("ff_ordering_paylater_is_upw_enabled", (int) null, 2, (FWFProjectName) null),
    LENDING_ADHOC_IS_UPW_ENABLED("ff_ordering_adhoc_payment_is_upw_enabled", (int) null, 2, (FWFProjectName) null),
    ADD_CARD_HOLDER_NAME_ENABLED("ff_ordering_is_add_card_holder_name_enabled", (int) null, 2, (FWFProjectName) null),
    INCENTIVE_AUTO_APPLY_DISCOUNTS_ENABLED("ff_ordering_auto_apply_discounts", (int) null, 2, (FWFProjectName) null),
    CART_INCREMENT_QUANTITY_ENABLED("ff_ordering_cart_increment_quantity_enable", (int) null, 2, (FWFProjectName) null),
    CART_FALLBACK_ENABLED("ff_ordering_flutter_cart_fallback_enabled", (int) null, 2, (FWFProjectName) null),
    PAYMENT_SHOULD_USE_FLUTTER_WEB_VIEW("ff_ordering_secure_payment_redirection_should_use_flutter_web_view", (int) null, 2, (FWFProjectName) null),
    PAYMENT_METHOD_FALLBACK_METHOD_ENABLED("ff_ordering_fallback_for_payment_method_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_CART_CHECKOUT_DEEPLINK_ENABLED("ff_ordering_flutter_cart_checkout_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_CART_MENU_DEEPLINK_ENABLED("ff_ordering_flutter_cart_menu_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_USE_UL_REDIRECTION_FLUTTER_CART("ff_ordering_use_ul_redirection_flutter_cart", (int) null, 2, (FWFProjectName) null),
    FLUTTER_LOAD_CHECKOUT_USING_HTTP_POST("ff_ordering_load_checkout_using_http_post", (int) null, 2, (FWFProjectName) null),
    FLUTTER_CHECKOUT_ADDRESS_LIST_DEEPLINK_ENABLED("ff_ordering_flutter_checkout_address_list_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_CHECKOUT_ADD_ADDRESS_BUTTON_ENABLED("ff_ordering_flutter_add_address_button_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_CHECKOUT_ORDER_TRACKING_DEEPLINK_ENABLED("ff_ordering_flutter_checkout_order_tracking_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_HOME_CART_DEEPLINK_ENABLED("ff_ordering_flutter_home_screen_cart_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_MENU_CART_DEEPLINK_ENABLED("ff_ordering_flutter_menu_cart_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_PUSH_NOTIFICATION_CART_DEEPLINK_ENABLED("ff_ordering_flutter_push_notification_cart_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    FLUTTER_VENDOR_LIST_CART_DEEPLINK_ENABLED("ff_ordering_flutter_vendor_list_cart_deeplink_enabled", (int) null, 2, (FWFProjectName) null),
    CART_CACHE_ENABLED("ff_ordering_cart_cache_enabled", (int) null, 2, (FWFProjectName) null),
    ENABLE_CHECKOUT_PURCHASE_TRACKING_EVENTS("ff_ordering_enable_checkout_purchase_events", (int) null, 2, (FWFProjectName) null),
    IS_GUEST_USER_CHECKOUT_ENABLED("ff_ordering_guest_user_checkout", (int) null, 2, (FWFProjectName) null),
    FLUTTER_SEND_THANK_YOU_EMAIL("ff_ordering_send_thank_you_email", (int) null, 2, (FWFProjectName) null),
    IS_CART_SYNC_ON_MISMATCH_ENABLED("ff_ordering_sync_cart_on_mismatch", (int) null, 2, (FWFProjectName) null),
    BADGE_ORDER_LIST_TAB_BAR_ENABLED("ff_ordering_badge_order_list_tab_bar_enabled", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private OrderingFeatureFlagsKeys(String str, FWFProjectName fWFProjectName) {
        this.value = str;
        this.projectName = fWFProjectName;
    }

    @NotNull
    public FWFProjectName getProjectName() {
        return this.projectName;
    }

    @NotNull
    public String getValue() {
        return this.value;
    }
}
