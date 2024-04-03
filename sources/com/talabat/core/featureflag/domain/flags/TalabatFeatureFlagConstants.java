package com.talabat.core.featureflag.domain.flags;

import com.talabat.core.featureflag.domain.flags.darkstores.DarkstoresFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.flagskeys.GrowthFeatureFlagConstantKt;
import com.talabat.core.featureflag.domain.flags.location.LocationFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.pay.PayFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.rewards.RewardsFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.subscription.SubscriptionFeatureFlagConstants;
import com.talabat.core.featureflag.domain.flags.tcs.TermsAndConditionsFeatureFlagConstants;
import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0003\b\u0001\b\u0001\u0018\u0000 \u00012\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0002\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZj\u0002\b[j\u0002\b\\j\u0002\b]j\u0002\b^j\u0002\b_j\u0002\b`j\u0002\baj\u0002\bbj\u0002\bcj\u0002\bdj\u0002\bej\u0002\bfj\u0002\bgj\u0002\bhj\u0002\bij\u0002\bjj\u0002\bkj\u0002\blj\u0002\bmj\u0002\bnj\u0002\boj\u0002\bpj\u0002\bqj\u0002\brj\u0002\bsj\u0002\btj\u0002\buj\u0002\bvj\u0002\bwj\u0002\bxj\u0002\byj\u0002\bzj\u0002\b{j\u0002\b|j\u0002\b}j\u0002\b~j\u0002\bj\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001j\u0003\b\u0001¨\u0006\u0001"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/TalabatFeatureFlagConstants;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "OBSERVE_CACHE_SUCCESS_FLAG", "DISABLE_OBSERVABILITY_FEATURE_KEY", "CONSUME_REVERSE_GEO_CODE_MICRO_SERVICE", "ENABLE_TRACK_API_V2", "ENABLE_PERIMETER_X", "CHANGE_RETROFIT_BASE_URL", "CAN_CHECK_FOR_AREA_SPLIT", "ENABLE_HELP", "BRAZE_P2_PLACE_ORDER", "ENABLE_TLIFE_WIDGET", "FIX_HOME_SCREEN_REFRESH", "FLAG_NEW_GROCERY_CELL_DESIGN", "SHOULD_SEND_VERTICAL_IDS", "SHOULD_SEND_MORE_IN_SEARCH", "GD_IS_AB_TEST_RANK_FACTORS_ENABLED", "FILTER_GEM_USING_RATE", "FILTER_GEM_BY_MOV_ANDROID", "FIlLTER_GEM_BY_CUISINE_ANDROID", "ENABLE_SMART_LUNCH", "NEW_VENDOR_API", "ENABLE_VENDOR_SEARCH_AUTOCOMPLETE", "ENABLE_GLOBAL_SEARCH_AUTOCOMPLETE", "ENABLE_SEARCH_NEW_FOOD_TAB", "ENABLE_SEARCH_NEW_QCOMMERCE_TAB", "ENABLE_SEARCH_SORT_AND_FILTER", "ENABLE_SEARCH_NESTED_DISHES", "SHOULD_HIDE_SEARCH_SORT_AND_FILTER_CPC", "SHOW_QATAR_SPECIAL_LOGO_SPLASH", "ENABLE_ANDROID_SMART_LOCK", "SHOW__SOCIAL_RESPONSIBILITY_AND_ABOUT_US", "SPLASH_VIEW_TYPE", "ADD_OBSERVABILITY_TO_APP_LAUNCH", "REGISTRATION_VALIDATION_UX", "PRIORITISE_FACEBOOK_LOGIN", "BLOCK_KURDISH_NAMES", "REMOVE_PARSING_ERROR_AS_INT", "ENABLE_MOBILE_NUMBER_LOGIN", "EGYPT_ADDRESS_FORM_LABEL_CHANGES", "ENABLE_OTP_FOR_MOBILE_REGISTRATION", "ENABLE_OTP_FOR_MOBILE_LOGIN", "REGISTRATION_CONSENT_CHECKBOX", "PROGRESSIVE_LOGIN_WITH_AAA", "MIGRATION_FEATURE_ADDRESS", "ENABLE_AAA_EMAIL_LOGIN_IN_OLD_SCREEN", "ENABLE_FACEBOOK_LOGIN_IN_OLD_SCREEN", "DESIGN_SYSTEM_LOGIN_SCREEN_ADOPTION", "HANDLE_TOO_MANY_REQUESTS_IN_LOGIN", "REMOVE_CONFIRM_ADDRESS_POP_UP", "ENABLE_SOFT_POS", "ENABLE_BUSY_POPUP_CART", "ENABLE_MENU_MAPPER", "ENABLE_REORDER_NOTIFICATION", "ENABLE_NO_ITEMS_BOTTOMSHEET", "SHOW_NEW_VENDOR_INFO", "DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_SIMPLE_CARD", "DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_ALERT", "TALABAT_DAILY_ENTRY_FEATURE", "ENABLE_DYNAMIC_VERTICALS_LAUNCHER", "VERTICALS_LAUNCHER_API_ACTIVE", "DARKSTORES_DELIVERY_FEE_FEATURE", "DARKSTORES_VOUCHERS_ENABLED", "DARKSTORES_CAN_USE_VERTICALS_API", "NFV_NEW_RELIC_OBSERVABILITY_ENABLED", "ENABLE_GROWTH_WIDGET", "ENABLE_PROMOTION_WIDGET", "LAUNCHER_ENABLE_TILES", "ENABLE_DARKSTORES_LISTING_PROMO_TAG", "ENABLE_DARKSTORES_MISSION_CONTROL", "ENABLE_PRODUCT_EXPAND_DECRIPTION", "ENABLE_PRODUCT_ZOOM_IMAGE", "ENABLE_DARKSTORES_CAMPAIGN_VISUALISATION", "ENABLE_TPRO_SIDE_MENU_BANNER", "ENABLE_TPRO_ONBOARDING_DEEPLINKS", "DARKSTORES_VLP_DYNAMIC_CATEGORIES_ROWS_COUNT", "DESIGN_SYSTEM_DARKSTORES_SCREEN_ADOPTION", "DARKSTORE_USES_DYNAMIC_DESIGN_VARIANT", "ENABLE_SEARCH_CATEGORY", "HIDE_SAFETY_MESSAGE_KUWAIT", "HIDE_SAFETY_MESSAGE_UAE", "HIDE_SAFETY_MESSAGE_KSA", "HIDE_SAFETY_MESSAGE_BAHRAIN", "HIDE_SAFETY_MESSAGE_QATAR", "HIDE_SAFETY_MESSAGE_OMAN", "HIDE_SAFETY_MESSAGE_JORDAN", "HIDE_SAFETY_MESSAGE_EGYPT", "HIDE_SAFETY_MESSAGE_IRAQ", "CHANGE_HEADER_COLOUR_ON_SCROLL", "ENABLE_ORDER_TRACKING_POLLING_REFRESH", "ENABLE_RE_ORDERS_REFRESH", "ENABLE_COMPENSATION_FEATURE_OBSERVABILITY", "ENABLE_NEW_HELP_CENTER", "ENABLE_FWF_TRACKING_ON_APP", "ENABLE_DID_NUMBER", "ENABLE_LANGUAGE_CHOICES_FOR_IRAQ", "ENABLE_LIVE_CHAT_PROJECT_R_BRANDING_FEATURE_KEY", "ENABLE_RESPONSE_OBSERVABILITY", "ENABLE_RATE_LIMIT_TRACK_API", "ENABLE_TRACK_ORDER_SCREEN_LIFECYCLE_OBSERVABILITY", "ENABLE_TMART_SPECIAL_QUEUE", "ENABLE_ORDER_STAR_RATING", "ENABLE_NEW_ORDER_RATING_DETAILS_API", "ENABLE_CANCELLATION_POLICY", "ENABLE_PICKUP_BLOCKING_MODAL", "MINIMIZE_GEM_POPUP", "MINIMIZE_GEM_POPUP_AB", "STOP_GEM_FEATURE", "GEM_NEW_HOME", "GEM_FLOATING_BUTTON_ENABLED", "ENABLE_OFFERING_NAVIGATION", "BRAZE_P2_LOGIN", "BRAZE_P2_GUEST", "SEARCH_IN_BOTTOM_NAVIGATION", "ENABLE_DYNAMIC_SPLASH", "HOME_OF_OFFERS_TABBAR_ENTRY_POINT", "ENABLE_TPRO_FOR_TMART", "ENABLE_TPRO_FOR_NFV", "IS_TPRO_FEATURE_ENABLED", "BRAND_UPDATES", "ENABLE_SAVINGS_CANCEL_FLOW", "ENABLE_SAVINGS_ACCOUNT_BANNER", "IS_CREATE_CART_IN_REORDER_ENABLED", "Companion", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum TalabatFeatureFlagConstants implements FWFKey {
    OBSERVE_CACHE_SUCCESS_FLAG("android_fwf_observe_cache_success", (int) null, 2, (FWFProjectName) null),
    DISABLE_OBSERVABILITY_FEATURE_KEY("android-disable-observability-feature", (int) null, 2, (FWFProjectName) null),
    CONSUME_REVERSE_GEO_CODE_MICRO_SERVICE("consume-ul-new-reverse-geocoding-micro-service-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_TRACK_API_V2("enable-track-api-v2", (int) null, 2, (FWFProjectName) null),
    ENABLE_PERIMETER_X("enable-perimeter-x-sdk-android", (int) null, 2, (FWFProjectName) null),
    CHANGE_RETROFIT_BASE_URL("change-retrofit-base-url", (int) null, 2, (FWFProjectName) null),
    CAN_CHECK_FOR_AREA_SPLIT("android-can-check-area-split", (int) null, 2, (FWFProjectName) null),
    ENABLE_HELP("enable-help", (int) null, 2, (FWFProjectName) null),
    BRAZE_P2_PLACE_ORDER("android-braze-p2-migrator-place-order", (int) null, 2, (FWFProjectName) null),
    ENABLE_TLIFE_WIDGET("tlife_enabled", (int) null, 2, (FWFProjectName) null),
    FIX_HOME_SCREEN_REFRESH("fix-home-screen-refresh", (int) null, 2, (FWFProjectName) null),
    FLAG_NEW_GROCERY_CELL_DESIGN("newgrocerycell", (int) null, 2, (FWFProjectName) null),
    SHOULD_SEND_VERTICAL_IDS("android_send_vertical_ids_home_search", (int) null, 2, (FWFProjectName) null),
    SHOULD_SEND_MORE_IN_SEARCH("android_show_more_on_home_search", (int) null, 2, (FWFProjectName) null),
    GD_IS_AB_TEST_RANK_FACTORS_ENABLED("isabtestrankfactorsenabled", (int) null, 2, (FWFProjectName) null),
    FILTER_GEM_USING_RATE("filtergemusingrate", (int) null, 2, (FWFProjectName) null),
    FILTER_GEM_BY_MOV_ANDROID("filter_gem_by_mov_android", (int) null, 2, (FWFProjectName) null),
    FIlLTER_GEM_BY_CUISINE_ANDROID("filter_gem_by_cuisine_android", (int) null, 2, (FWFProjectName) null),
    ENABLE_SMART_LUNCH("android-enable-smart-lunch", (int) null, 2, (FWFProjectName) null),
    NEW_VENDOR_API("new_vendor_api", (int) null, 2, (FWFProjectName) null),
    ENABLE_VENDOR_SEARCH_AUTOCOMPLETE("enable_vendor_search_autocomplete", (int) null, 2, (FWFProjectName) null),
    ENABLE_GLOBAL_SEARCH_AUTOCOMPLETE("enable_global_search_autocomplete", (int) null, 2, (FWFProjectName) null),
    ENABLE_SEARCH_NEW_FOOD_TAB("ff_search_new_food_tab", (int) null, 2, (FWFProjectName) null),
    ENABLE_SEARCH_NEW_QCOMMERCE_TAB("ff_search_new_qcommerce_tab", (int) null, 2, (FWFProjectName) null),
    ENABLE_SEARCH_SORT_AND_FILTER("enable_search_sort_and_filter", (int) null, 2, (FWFProjectName) null),
    ENABLE_SEARCH_NESTED_DISHES("enable_search_nested_dishes", (int) null, 2, (FWFProjectName) null),
    SHOULD_HIDE_SEARCH_SORT_AND_FILTER_CPC("should_hide_search_sort_and_filter_cpc", (int) null, 2, (FWFProjectName) null),
    SHOW_QATAR_SPECIAL_LOGO_SPLASH("show-qatar-special-logo-splash", (int) null, 2, (FWFProjectName) null),
    ENABLE_ANDROID_SMART_LOCK("enable-android-smartlock", (int) null, 2, (FWFProjectName) null),
    SHOW__SOCIAL_RESPONSIBILITY_AND_ABOUT_US("show-social-responsibility-and-about-us", (int) null, 2, (FWFProjectName) null),
    SPLASH_VIEW_TYPE("enable-splash_viewtype_android", (int) null, 2, (FWFProjectName) null),
    ADD_OBSERVABILITY_TO_APP_LAUNCH("applaunch_observability", (int) null, 2, (FWFProjectName) null),
    REGISTRATION_VALIDATION_UX("improve_validation_ux", (int) null, 2, (FWFProjectName) null),
    PRIORITISE_FACEBOOK_LOGIN("prioritise_facebook_login", (int) null, 2, (FWFProjectName) null),
    BLOCK_KURDISH_NAMES("block_kurdish_names", (int) null, 2, (FWFProjectName) null),
    REMOVE_PARSING_ERROR_AS_INT("remove_parsing_error_as_int", (int) null, 2, (FWFProjectName) null),
    ENABLE_MOBILE_NUMBER_LOGIN("android-enable-mobile-number-login", (int) null, 2, (FWFProjectName) null),
    EGYPT_ADDRESS_FORM_LABEL_CHANGES("android-egypt-address-form-label-changes", (int) null, 2, (FWFProjectName) null),
    ENABLE_OTP_FOR_MOBILE_REGISTRATION("android-enable-otp-for-mobile-registration", (int) null, 2, (FWFProjectName) null),
    ENABLE_OTP_FOR_MOBILE_LOGIN("android-enable-otp-for-mobile-login", (int) null, 2, (FWFProjectName) null),
    REGISTRATION_CONSENT_CHECKBOX("android-registration-consent-checkbox", (int) null, 2, (FWFProjectName) null),
    PROGRESSIVE_LOGIN_WITH_AAA("android-progressive-login-with-aaa", (int) null, 2, (FWFProjectName) null),
    MIGRATION_FEATURE_ADDRESS("migration_feature_address", (int) null, 2, (FWFProjectName) null),
    ENABLE_AAA_EMAIL_LOGIN_IN_OLD_SCREEN("enable_aaa_email_login_in_old_screen", (int) null, 2, (FWFProjectName) null),
    ENABLE_FACEBOOK_LOGIN_IN_OLD_SCREEN("enable_facebook_login_in_old_screen", (int) null, 2, (FWFProjectName) null),
    DESIGN_SYSTEM_LOGIN_SCREEN_ADOPTION("design-system-login-screen-adoption", (int) null, 2, (FWFProjectName) null),
    HANDLE_TOO_MANY_REQUESTS_IN_LOGIN("handle_too_many_requests_in_login", (int) null, 2, (FWFProjectName) null),
    REMOVE_CONFIRM_ADDRESS_POP_UP("remove_confirm_address_pop_up", (int) null, 2, (FWFProjectName) null),
    ENABLE_SOFT_POS("enable-soft-pos-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_BUSY_POPUP_CART("enable-busy-popup-cart-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_MENU_MAPPER("enable-menu-mapper-new-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_REORDER_NOTIFICATION("enable-reorder-notification-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_NO_ITEMS_BOTTOMSHEET("enable-no-items-bottomsheet-android", (int) null, 2, (FWFProjectName) null),
    SHOW_NEW_VENDOR_INFO("android-ox-show-new-vendor-info", (int) null, 2, (FWFProjectName) null),
    DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_SIMPLE_CARD("design-system-checkout-screen-adoption-simple-card", (int) null, 2, (FWFProjectName) null),
    DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_ALERT("design-system-checkout-screen-adoption-alert", (int) null, 2, (FWFProjectName) null),
    TALABAT_DAILY_ENTRY_FEATURE("darkstores_integration_v2", (int) null, 2, (FWFProjectName) null),
    ENABLE_DYNAMIC_VERTICALS_LAUNCHER("verticals_dynamic_launcher_v3", (int) null, 2, (FWFProjectName) null),
    VERTICALS_LAUNCHER_API_ACTIVE("verticals_launcher_api_active", (int) null, 2, (FWFProjectName) null),
    DARKSTORES_DELIVERY_FEE_FEATURE("darkstores_delivery_fee_feature", (int) null, 2, (FWFProjectName) null),
    DARKSTORES_VOUCHERS_ENABLED("darkstores_vouchers_enabled", (int) null, 2, (FWFProjectName) null),
    DARKSTORES_CAN_USE_VERTICALS_API("darkstores_enable_verticals_api", (int) null, 2, (FWFProjectName) null),
    NFV_NEW_RELIC_OBSERVABILITY_ENABLED("nfv_new_relic_observability", (int) null, 2, (FWFProjectName) null),
    ENABLE_GROWTH_WIDGET("android_darkstores_enable_growth_widget_v2", (int) null, 2, (FWFProjectName) null),
    ENABLE_PROMOTION_WIDGET("android_darkstores_enable_promotions_widget_v2", (int) null, 2, (FWFProjectName) null),
    LAUNCHER_ENABLE_TILES("android_nfv_home_can_use_tiles_api_v2", (int) null, 2, (FWFProjectName) null),
    ENABLE_DARKSTORES_LISTING_PROMO_TAG("android_darkstores_enable_listing_promo_tag", (int) null, 2, (FWFProjectName) null),
    ENABLE_DARKSTORES_MISSION_CONTROL("darkstores_mission_control", (int) null, 2, (FWFProjectName) null),
    ENABLE_PRODUCT_EXPAND_DECRIPTION("android_darkstores_product_description_expand_enabled", (int) null, 2, (FWFProjectName) null),
    ENABLE_PRODUCT_ZOOM_IMAGE("android_darkstores_product_image_zoom_enabled", (int) null, 2, (FWFProjectName) null),
    ENABLE_DARKSTORES_CAMPAIGN_VISUALISATION("android_darkstores_show_campaign_visualisation", (int) null, 2, (FWFProjectName) null),
    ENABLE_TPRO_SIDE_MENU_BANNER("android-show-tpro-banner-for-account-tab", (int) null, 2, (FWFProjectName) null),
    ENABLE_TPRO_ONBOARDING_DEEPLINKS("subscription-android-enable-onboarding-deeplink", (int) null, 2, (FWFProjectName) null),
    DARKSTORES_VLP_DYNAMIC_CATEGORIES_ROWS_COUNT("darkstores_vlp_dynamic_categories_rows_count", (int) null, 2, (FWFProjectName) null),
    DESIGN_SYSTEM_DARKSTORES_SCREEN_ADOPTION("design-system-darkstores-screen-adoption", (int) null, 2, (FWFProjectName) null),
    DARKSTORE_USES_DYNAMIC_DESIGN_VARIANT("darkstore-uses-dynamic-design-variant", (int) null, 2, (FWFProjectName) null),
    ENABLE_SEARCH_CATEGORY("enable-darkstore-categories-list-search", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_KUWAIT("hide-home-safety-message-kuwait-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_UAE("hide-home-safety-message-uae-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_KSA("hide-home-safety-message-ksa-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_BAHRAIN("hide-home-safety-message-bahrain-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_QATAR("hide-home-safety-message-qatar-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_OMAN("hide-home-safety-message-oman-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_JORDAN("hide-home-safety-message-jordan-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_EGYPT("hide-home-safety-message-egypt-android", (int) null, 2, (FWFProjectName) null),
    HIDE_SAFETY_MESSAGE_IRAQ("hide-home-safety-message-iraq-android", (int) null, 2, (FWFProjectName) null),
    CHANGE_HEADER_COLOUR_ON_SCROLL("change-header-colour-on-scroll-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_ORDER_TRACKING_POLLING_REFRESH("enable-order-tracking-polling-refresh-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_RE_ORDERS_REFRESH("enable-re-orders-refresh-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_COMPENSATION_FEATURE_OBSERVABILITY("enable-compensation-feature-observability-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_NEW_HELP_CENTER("enable-new-help-center-in-progress-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_FWF_TRACKING_ON_APP("enable-fwf-tracking-on-app-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_DID_NUMBER("enable-did-number", (int) null, 2, (FWFProjectName) null),
    ENABLE_LANGUAGE_CHOICES_FOR_IRAQ("android-enable-language-choices-for-iraq", (int) null, 2, (FWFProjectName) null),
    ENABLE_LIVE_CHAT_PROJECT_R_BRANDING_FEATURE_KEY("android-enable-live-chat-project-r-branding-feature", (int) null, 2, (FWFProjectName) null),
    ENABLE_RESPONSE_OBSERVABILITY("enabled-response-observability", (int) null, 2, (FWFProjectName) null),
    ENABLE_RATE_LIMIT_TRACK_API("enable-rate-limit-track-api", (int) null, 2, (FWFProjectName) null),
    ENABLE_TRACK_ORDER_SCREEN_LIFECYCLE_OBSERVABILITY("enable-track-order-screen-lifecycle-observability", (int) null, 2, (FWFProjectName) null),
    ENABLE_TMART_SPECIAL_QUEUE("enable-tmart-special-queue-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_ORDER_STAR_RATING("enable-order-star-rating-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_NEW_ORDER_RATING_DETAILS_API("enable-new-order-rating-details-api-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_CANCELLATION_POLICY("enable-cancellation-policy-android", (int) null, 2, (FWFProjectName) null),
    ENABLE_PICKUP_BLOCKING_MODAL("enable_pickup_blocking_modal", (int) null, 2, (FWFProjectName) null),
    MINIMIZE_GEM_POPUP("minimize-gem-popup-android", (int) null, 2, (FWFProjectName) null),
    MINIMIZE_GEM_POPUP_AB("minimize-gem-popup-ab-android", (int) null, 2, (FWFProjectName) null),
    STOP_GEM_FEATURE("android-gem-feature-stop", (int) null, 2, (FWFProjectName) null),
    GEM_NEW_HOME("android-gem-new-homepage", (int) null, 2, (FWFProjectName) null),
    GEM_FLOATING_BUTTON_ENABLED("gem_floating_button_enabled", (int) null, 2, (FWFProjectName) null),
    ENABLE_OFFERING_NAVIGATION("offering-collection-dummy", (int) null, 2, (FWFProjectName) null),
    BRAZE_P2_LOGIN("android-braze-p2-migrator-login", (int) null, 2, (FWFProjectName) null),
    BRAZE_P2_GUEST("android-braze-p2-migrator-guest", (int) null, 2, (FWFProjectName) null),
    SEARCH_IN_BOTTOM_NAVIGATION("search-in-bottom-navigation", (int) null, 2, (FWFProjectName) null),
    ENABLE_DYNAMIC_SPLASH("enable-dynamic-splash-android", (int) null, 2, (FWFProjectName) null),
    HOME_OF_OFFERS_TABBAR_ENTRY_POINT("home-of-offers-tabbar-entry-point", (int) null, 2, (FWFProjectName) null),
    ENABLE_TPRO_FOR_TMART("subsriptions-android-tpro-tmart", (int) null, 2, (FWFProjectName) null),
    ENABLE_TPRO_FOR_NFV("subscriptions-android-tpro-nfv", (int) null, 2, (FWFProjectName) null),
    IS_TPRO_FEATURE_ENABLED("subscriptions-android-tpro-kill-switch", (int) null, 2, (FWFProjectName) null),
    BRAND_UPDATES("show-new-tpro-brand", (int) null, 2, (FWFProjectName) null),
    ENABLE_SAVINGS_CANCEL_FLOW("subscriptions-android-savings-cancel-flow", (int) null, 2, (FWFProjectName) null),
    ENABLE_SAVINGS_ACCOUNT_BANNER("subscriptions-android-savings-account-banner", (int) null, 2, (FWFProjectName) null),
    IS_CREATE_CART_IN_REORDER_ENABLED("is-create-cart-in-reorder-enabled", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/talabat/core/featureflag/domain/flags/TalabatFeatureFlagConstants$Companion;", "", "()V", "FEATURE_KEYS", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "getFEATURE_KEYS", "()[Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "nfvFlags", "getNfvFlags", "com_talabat_core_feature-flag_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final FWFKey[] getNfvFlags() {
            return new FWFKey[]{TalabatFeatureFlagConstants.TALABAT_DAILY_ENTRY_FEATURE, TalabatFeatureFlagConstants.VERTICALS_LAUNCHER_API_ACTIVE, TalabatFeatureFlagConstants.DARKSTORES_DELIVERY_FEE_FEATURE, TalabatFeatureFlagConstants.DARKSTORES_VOUCHERS_ENABLED, TalabatFeatureFlagConstants.DARKSTORES_CAN_USE_VERTICALS_API, TalabatFeatureFlagConstants.ENABLE_GROWTH_WIDGET, TalabatFeatureFlagConstants.ENABLE_PROMOTION_WIDGET, TalabatFeatureFlagConstants.LAUNCHER_ENABLE_TILES, TalabatFeatureFlagConstants.ENABLE_DARKSTORES_LISTING_PROMO_TAG, TalabatFeatureFlagConstants.ENABLE_DARKSTORES_MISSION_CONTROL, TalabatFeatureFlagConstants.ENABLE_PRODUCT_EXPAND_DECRIPTION, TalabatFeatureFlagConstants.ENABLE_PRODUCT_ZOOM_IMAGE, TalabatFeatureFlagConstants.NFV_NEW_RELIC_OBSERVABILITY_ENABLED, TalabatFeatureFlagConstants.ENABLE_DYNAMIC_VERTICALS_LAUNCHER, TalabatFeatureFlagConstants.ENABLE_DARKSTORES_CAMPAIGN_VISUALISATION, TalabatFeatureFlagConstants.DESIGN_SYSTEM_DARKSTORES_SCREEN_ADOPTION, TalabatFeatureFlagConstants.DARKSTORE_USES_DYNAMIC_DESIGN_VARIANT, TalabatFeatureFlagConstants.ENABLE_SEARCH_CATEGORY, TalabatFeatureFlagConstants.ENABLE_TPRO_FOR_NFV};
        }

        @NotNull
        public final FWFKey[] getFEATURE_KEYS() {
            return (FWFKey[]) ArraysKt___ArraysJvmKt.plus((T[]) ArraysKt___ArraysJvmKt.plus((T[]) ArraysKt___ArraysJvmKt.plus((T[]) ArraysKt___ArraysJvmKt.plus((T[]) ArraysKt___ArraysJvmKt.plus((T[]) ArraysKt___ArraysJvmKt.plus((T[]) ArraysKt___ArraysJvmKt.plus((T[]) ArraysKt___ArraysJvmKt.plus((T[]) new FWFKey[]{TalabatFeatureFlagConstants.FILTER_GEM_USING_RATE, TalabatFeatureFlagConstants.ENABLE_ANDROID_SMART_LOCK, TalabatFeatureFlagConstants.FILTER_GEM_BY_MOV_ANDROID, TalabatFeatureFlagConstants.FIlLTER_GEM_BY_CUISINE_ANDROID, TalabatFeatureFlagConstants.ENABLE_SMART_LUNCH, TalabatFeatureFlagConstants.NEW_VENDOR_API, TalabatFeatureFlagConstants.SHOW__SOCIAL_RESPONSIBILITY_AND_ABOUT_US, TalabatFeatureFlagConstants.CHANGE_RETROFIT_BASE_URL, TalabatFeatureFlagConstants.HIDE_SAFETY_MESSAGE_KUWAIT, TalabatFeatureFlagConstants.ENABLE_HELP, TalabatFeatureFlagConstants.HIDE_SAFETY_MESSAGE_UAE, TalabatFeatureFlagConstants.HIDE_SAFETY_MESSAGE_KSA, TalabatFeatureFlagConstants.HIDE_SAFETY_MESSAGE_BAHRAIN, TalabatFeatureFlagConstants.HIDE_SAFETY_MESSAGE_QATAR, TalabatFeatureFlagConstants.HIDE_SAFETY_MESSAGE_OMAN, TalabatFeatureFlagConstants.HIDE_SAFETY_MESSAGE_JORDAN, TalabatFeatureFlagConstants.CONSUME_REVERSE_GEO_CODE_MICRO_SERVICE, TalabatFeatureFlagConstants.SHOW_QATAR_SPECIAL_LOGO_SPLASH, TalabatFeatureFlagConstants.SPLASH_VIEW_TYPE, TalabatFeatureFlagConstants.ENABLE_PERIMETER_X, TalabatFeatureFlagConstants.CAN_CHECK_FOR_AREA_SPLIT, TalabatFeatureFlagConstants.ENABLE_LIVE_CHAT_PROJECT_R_BRANDING_FEATURE_KEY, TalabatFeatureFlagConstants.DISABLE_OBSERVABILITY_FEATURE_KEY, TalabatFeatureFlagConstants.ENABLE_LANGUAGE_CHOICES_FOR_IRAQ, TalabatFeatureFlagConstants.ENABLE_SOFT_POS, TalabatFeatureFlagConstants.ENABLE_ORDER_TRACKING_POLLING_REFRESH, TalabatFeatureFlagConstants.REGISTRATION_VALIDATION_UX, TalabatFeatureFlagConstants.ADD_OBSERVABILITY_TO_APP_LAUNCH, TalabatFeatureFlagConstants.ENABLE_RE_ORDERS_REFRESH, TalabatFeatureFlagConstants.ENABLE_COMPENSATION_FEATURE_OBSERVABILITY, TalabatFeatureFlagConstants.ENABLE_NEW_HELP_CENTER, TalabatFeatureFlagConstants.PRIORITISE_FACEBOOK_LOGIN, TalabatFeatureFlagConstants.BLOCK_KURDISH_NAMES, TalabatFeatureFlagConstants.REMOVE_PARSING_ERROR_AS_INT, TalabatFeatureFlagConstants.ENABLE_MOBILE_NUMBER_LOGIN, TalabatFeatureFlagConstants.EGYPT_ADDRESS_FORM_LABEL_CHANGES, TalabatFeatureFlagConstants.ENABLE_OTP_FOR_MOBILE_REGISTRATION, TalabatFeatureFlagConstants.ENABLE_OTP_FOR_MOBILE_LOGIN, TalabatFeatureFlagConstants.REGISTRATION_CONSENT_CHECKBOX, TalabatFeatureFlagConstants.PROGRESSIVE_LOGIN_WITH_AAA, TalabatFeatureFlagConstants.MIGRATION_FEATURE_ADDRESS, TalabatFeatureFlagConstants.ENABLE_AAA_EMAIL_LOGIN_IN_OLD_SCREEN, TalabatFeatureFlagConstants.ENABLE_FACEBOOK_LOGIN_IN_OLD_SCREEN, TalabatFeatureFlagConstants.DESIGN_SYSTEM_LOGIN_SCREEN_ADOPTION, TalabatFeatureFlagConstants.HANDLE_TOO_MANY_REQUESTS_IN_LOGIN, TalabatFeatureFlagConstants.REMOVE_CONFIRM_ADDRESS_POP_UP, TalabatFeatureFlagConstants.DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_SIMPLE_CARD, TalabatFeatureFlagConstants.DESIGN_SYSTEM_CHECKOUT_SCREEN_ADOPTION_ALERT, TalabatFeatureFlagConstants.OBSERVE_CACHE_SUCCESS_FLAG, TalabatFeatureFlagConstants.ENABLE_MENU_MAPPER, TalabatFeatureFlagConstants.ENABLE_FWF_TRACKING_ON_APP, TalabatFeatureFlagConstants.ENABLE_BUSY_POPUP_CART, TalabatFeatureFlagConstants.ENABLE_REORDER_NOTIFICATION, TalabatFeatureFlagConstants.ENABLE_NO_ITEMS_BOTTOMSHEET, TalabatFeatureFlagConstants.FLAG_NEW_GROCERY_CELL_DESIGN, TalabatFeatureFlagConstants.ENABLE_DID_NUMBER, TalabatFeatureFlagConstants.MINIMIZE_GEM_POPUP, TalabatFeatureFlagConstants.MINIMIZE_GEM_POPUP_AB, TalabatFeatureFlagConstants.GEM_FLOATING_BUTTON_ENABLED, TalabatFeatureFlagConstants.SHOW_NEW_VENDOR_INFO, TalabatFeatureFlagConstants.ENABLE_RESPONSE_OBSERVABILITY, TalabatFeatureFlagConstants.ENABLE_RATE_LIMIT_TRACK_API, TalabatFeatureFlagConstants.ENABLE_TRACK_ORDER_SCREEN_LIFECYCLE_OBSERVABILITY, TalabatFeatureFlagConstants.SHOULD_SEND_VERTICAL_IDS, TalabatFeatureFlagConstants.SHOULD_SEND_MORE_IN_SEARCH, TalabatFeatureFlagConstants.GD_IS_AB_TEST_RANK_FACTORS_ENABLED, TalabatFeatureFlagConstants.ENABLE_TMART_SPECIAL_QUEUE, TalabatFeatureFlagConstants.ENABLE_ORDER_STAR_RATING, TalabatFeatureFlagConstants.BRAZE_P2_PLACE_ORDER, TalabatFeatureFlagConstants.ENABLE_NEW_ORDER_RATING_DETAILS_API, TalabatFeatureFlagConstants.BRAZE_P2_LOGIN, TalabatFeatureFlagConstants.BRAZE_P2_GUEST, TalabatFeatureFlagConstants.ENABLE_DYNAMIC_SPLASH, TalabatFeatureFlagConstants.HOME_OF_OFFERS_TABBAR_ENTRY_POINT, TalabatFeatureFlagConstants.ENABLE_OFFERING_NAVIGATION, TalabatFeatureFlagConstants.STOP_GEM_FEATURE, TalabatFeatureFlagConstants.ENABLE_PICKUP_BLOCKING_MODAL, TalabatFeatureFlagConstants.GEM_NEW_HOME, TalabatFeatureFlagConstants.DARKSTORES_VLP_DYNAMIC_CATEGORIES_ROWS_COUNT, TalabatFeatureFlagConstants.ENABLE_TPRO_SIDE_MENU_BANNER, TalabatFeatureFlagConstants.ENABLE_VENDOR_SEARCH_AUTOCOMPLETE, TalabatFeatureFlagConstants.ENABLE_GLOBAL_SEARCH_AUTOCOMPLETE, TalabatFeatureFlagConstants.ENABLE_SEARCH_NEW_FOOD_TAB, TalabatFeatureFlagConstants.ENABLE_SEARCH_NEW_QCOMMERCE_TAB, TalabatFeatureFlagConstants.ENABLE_SEARCH_SORT_AND_FILTER, TalabatFeatureFlagConstants.ENABLE_SEARCH_NESTED_DISHES, TalabatFeatureFlagConstants.SHOULD_HIDE_SEARCH_SORT_AND_FILTER_CPC, TalabatFeatureFlagConstants.ENABLE_TPRO_FOR_TMART, TalabatFeatureFlagConstants.ENABLE_SAVINGS_CANCEL_FLOW, TalabatFeatureFlagConstants.ENABLE_SAVINGS_ACCOUNT_BANNER, TalabatFeatureFlagConstants.IS_TPRO_FEATURE_ENABLED, TalabatFeatureFlagConstants.BRAND_UPDATES, TalabatFeatureFlagConstants.ENABLE_TPRO_ONBOARDING_DEEPLINKS, TalabatFeatureFlagConstants.ENABLE_CANCELLATION_POLICY, TalabatFeatureFlagConstants.ENABLE_TLIFE_WIDGET, TalabatFeatureFlagConstants.FIX_HOME_SCREEN_REFRESH, TalabatFeatureFlagConstants.IS_CREATE_CART_IN_REORDER_ENABLED}, GrowthFeatureFlagConstantKt.getGrowthFlags().invoke()), DarkstoresFeatureFlagConstants.Companion.getDarkStoreFlags()), LocationFeatureFlagConstants.Companion.getLocationFlags().invoke()), (T[]) getNfvFlags()), PayFeatureFlagConstants.INSTANCE.getPayFlags().invoke()), SubscriptionFeatureFlagConstants.INSTANCE.getSubscriptionFlags().invoke()), (T[]) RewardsFeatureFlagConstants.Companion.getRewardsFlags()), TermsAndConditionsFeatureFlagConstants.Companion.getTermsAndConditionsFlags().invoke());
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    private TalabatFeatureFlagConstants(String str, FWFProjectName fWFProjectName) {
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
