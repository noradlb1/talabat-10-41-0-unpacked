package com.talabat.core.fwfprojectskeys.domain.projects.qcommerce;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b'\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,¨\u0006-"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/qcommerce/QCommerceFeatureFlagsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "BASKET_BASED_DELIVERY_FEE", "PRODUCT_DETAIL_PAGE_SWIMLANES", "RECALCULATE_BANNER_IMPRESSION", "ENABLE_SERVICE_FEE_DESCRIPTION_FIX", "HOME_SINGLE_API", "PRESCRIPTION_DIRECT_ORDER_FLOW", "LIFESTYLE_MISSION_V2", "SWIMLANE_IMPRESSIONS_TRACKING", "SEARCH_RESULT_IMPRESSIONS_TRACKING", "CAMPAIGN_API_OBSERVABILITY", "PRODUCT_LISTING_HIDE_CART_ON_SCROLL", "ITEM_REPLACEMENT_TIMER", "QCOMMERCE_PHARMACY_USER_AGREE", "QCOMMERCE_PHARMACY_WORKING_HOURS", "QCOMMERCE_PHARMACY_NEW_BANNER", "QCOMMERCE_PHARMACY_BYPASS_PHONE_VERIFICATION", "QCOMMERCE_NEW_HOW_IT_WORKS_BS", "QCOMMERCE_TOGGLE_PRESCRITPION_BS", "QCOMMERCE_CAMPAIGN_PROGRESS_IN_CART", "QCOMMERCE_HIGHLIGHTED_VENDORS_REVIEW", "QCOMMERCE_GATEWAY_SWIMLANE_API_MIGRATION", "QCOMMERCE_GHOME_HEADLESS_MISSION_CONTROL", "QCOMMERCE_PRE_SEARCH_SHOW_RECENT_SEARCHES", "QCOMMERCE_VOUCHER_DETAILS_BOTTOM_SHEET", "QCOMMERCE_IMAGE_OPTIMIZATION", "QCOMMERCE_VOUCHER_MOV_PROGRESSBAR", "SHOW_FLUTTER_PLP_FOR_BANNERS", "QCOMMERCE_SHOW_GROCERY_HOME", "QCOMMERCE_SHOW_GROCERY_HOME_NFV", "QCOMMERCE_SHOW_NEW_FLUTTER_ORDER_DETAILS", "QCOMMERCE_BASKET_LIST_DS_FLUTTER_ENABLED", "QCOMMERCE_ENABLE_SEARCH_GATEWAY_ENDPOINT", "QCOMMERCE_FIXED_FONT_SIZE", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum QCommerceFeatureFlagsKeys implements FWFKey {
    BASKET_BASED_DELIVERY_FEE("ff_qcommerce_basket_based_delivery_fee", (int) null, 2, (FWFProjectName) null),
    PRODUCT_DETAIL_PAGE_SWIMLANES("ff_qcommerce_product_detail_page_swimlanes", (int) null, 2, (FWFProjectName) null),
    RECALCULATE_BANNER_IMPRESSION("ff_qcommerce_recalculate_banner_impression", (int) null, 2, (FWFProjectName) null),
    ENABLE_SERVICE_FEE_DESCRIPTION_FIX("ff_qcommerce_enable_service_fee_description_fix", (int) null, 2, (FWFProjectName) null),
    HOME_SINGLE_API("ff_qcommerce_home_single_api", (int) null, 2, (FWFProjectName) null),
    PRESCRIPTION_DIRECT_ORDER_FLOW("ff_qcommerce_pharmacy_direct_order_flow", (int) null, 2, (FWFProjectName) null),
    LIFESTYLE_MISSION_V2("ff_qcommerce_fast_vlp_lifestyle_missions_v2", (int) null, 2, (FWFProjectName) null),
    SWIMLANE_IMPRESSIONS_TRACKING("ff_qcommerce_swimlane_impressions_tracking", (int) null, 2, (FWFProjectName) null),
    SEARCH_RESULT_IMPRESSIONS_TRACKING("ff_qcommerce_search_result_impressions_tracking", (int) null, 2, (FWFProjectName) null),
    CAMPAIGN_API_OBSERVABILITY("ff_qcommerce_campaign_api_observability", (int) null, 2, (FWFProjectName) null),
    PRODUCT_LISTING_HIDE_CART_ON_SCROLL("ff_qcommerce_product_listing_hide_cart_on_scroll", (int) null, 2, (FWFProjectName) null),
    ITEM_REPLACEMENT_TIMER("ff_qcommerce_item_replacement_timer", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_PHARMACY_USER_AGREE("ff_qcommerce_pharmacy_user_agree", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_PHARMACY_WORKING_HOURS("ff_qcommerce_pharmacy_working_hours", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_PHARMACY_NEW_BANNER("ff_qcommerce_pharmacy_banner_v2", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_PHARMACY_BYPASS_PHONE_VERIFICATION("ff_qcommerce_pharmacy_bypass_phone_verification", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_NEW_HOW_IT_WORKS_BS("ff_qcommerce_pharmacy_show_new_bottom_sheet_how_it_works", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_TOGGLE_PRESCRITPION_BS("ff_qcommerce_pharmacy_hide_upload_bottom_sheet", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_CAMPAIGN_PROGRESS_IN_CART("ff_qcommerce_campaign_progress_in_cart_enabled", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_HIGHLIGHTED_VENDORS_REVIEW("ff_qcommerce_highlighted_vendors_review", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_GATEWAY_SWIMLANE_API_MIGRATION("ff_qcommerce_gateway_swimlane_api_migration", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_GHOME_HEADLESS_MISSION_CONTROL("ff_qcommerce_ghome_headless_mission_control", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_PRE_SEARCH_SHOW_RECENT_SEARCHES("ff_qcommerce_pre_search_show_recent_searches", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_VOUCHER_DETAILS_BOTTOM_SHEET("ff_qcommerce_voucher_details_bottom_sheet", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_IMAGE_OPTIMIZATION("ff_qcommerce_image_optimization", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_VOUCHER_MOV_PROGRESSBAR("ff_qcommerce_voucher_mov_progressbar", (int) null, 2, (FWFProjectName) null),
    SHOW_FLUTTER_PLP_FOR_BANNERS("ff_qcommerce_show_flutter_plp_for_banners", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_SHOW_GROCERY_HOME("ff_qcommerce_show_grocery_home", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_SHOW_GROCERY_HOME_NFV("ff_qcommerce_show_grocery_home_nfv", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_SHOW_NEW_FLUTTER_ORDER_DETAILS("ff_qcommerce_flutter_order_details", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_BASKET_LIST_DS_FLUTTER_ENABLED("ff_qcommerce_basket_list_ds_flutter_enabled", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_ENABLE_SEARCH_GATEWAY_ENDPOINT("ff_qcommerce_enable_search_gateway_endpoint", (int) null, 2, (FWFProjectName) null),
    QCOMMERCE_FIXED_FONT_SIZE("ff_qcommerce_fixed_font_size", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private QCommerceFeatureFlagsKeys(String str, FWFProjectName fWFProjectName) {
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
