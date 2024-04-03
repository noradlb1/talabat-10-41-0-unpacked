package com.talabat.core.fwfprojectskeys.domain.projects.vendorlist;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/vendorlist/VendorListFeatureFlagsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "VENDOR_LIST_PHARMACY_EXPERIMENT", "PICKUP_VL_ENABLE_CASH_PAYMENT", "CAN_SHOW_GEM_POPUP", "CAN_HIDE_GEM_POPUP", "CAN_SHOW_PICKUP_TOGGLE", "MINIMIZE_GEM_POPUP", "CAN_SHOW_CART_ICON", "CAN_SHOW_CUISINES", "CAN_SHOW_FAVORITE_ICON", "CAN_SHOW_FAVORITES_SWIPE", "CAN_SHOW_FAVORITES_BUTTON_ON_SWIMLANES", "CAN_ROUTE_TO_SEARCH", "CAN_SHOW_FAVORITES_ON_COLLECTIONS", "FREE_DELIVERY_NEW_CUSTOMERS", "CAN_SHOW_FAVORITES_SWIPE_ONBOARDING", "CAN_FIRE_IMPRESSIONS_TRACKING", "CAN_SHOW_FAVORITES_NOTIFICATION_DOT", "CAN_SHOW_TOP_TEN_SWIMLANE", "VENDORLIST_COLLECTION_DEEP_LINK_NAVIGATION", "VENDORLIST_DEEP_LINK_NAVIGATION_HOF", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum VendorListFeatureFlagsKeys implements FWFKey {
    VENDOR_LIST_PHARMACY_EXPERIMENT("ff_vendorlist_pharmacy", (int) null, 2, (FWFProjectName) null),
    PICKUP_VL_ENABLE_CASH_PAYMENT("ff_vendorlist_pickup_enable_cash_payment", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_GEM_POPUP("ff_vendorlist_show_gem_popup", (int) null, 2, (FWFProjectName) null),
    CAN_HIDE_GEM_POPUP("ff_vendorlist_hide_gems_popup", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_PICKUP_TOGGLE("ff_vendorlist_show_pickup", (int) null, 2, (FWFProjectName) null),
    MINIMIZE_GEM_POPUP("ff_vendorlist_minimize_gem_popup", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_CART_ICON("ff_vendorlist_show_cart_icon", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_CUISINES("ff_vendorlist_show_cuisines", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_FAVORITE_ICON("ff_vendorlist_show_flutter_favoritelist_screen", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_FAVORITES_SWIPE("ff_vendorlist_favorites_show_swipe_model", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_FAVORITES_BUTTON_ON_SWIMLANES("ff_vendorlist_favorites_show_favorite_button_swimlanes", (int) null, 2, (FWFProjectName) null),
    CAN_ROUTE_TO_SEARCH("ff_vendorlist_route_to_search", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_FAVORITES_ON_COLLECTIONS("ff_vendorlist_show_favorites_on_collections", (int) null, 2, (FWFProjectName) null),
    FREE_DELIVERY_NEW_CUSTOMERS("ff_vendorlist_free_delivery_new_customers", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_FAVORITES_SWIPE_ONBOARDING("ff_vendorlist_favorites_show_swipe_onboarding", (int) null, 2, (FWFProjectName) null),
    CAN_FIRE_IMPRESSIONS_TRACKING("ff_vendorlist_impression_tracking", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_FAVORITES_NOTIFICATION_DOT("ff_vendorlist_favorites_show_notification_dot", (int) null, 2, (FWFProjectName) null),
    CAN_SHOW_TOP_TEN_SWIMLANE("ff_vendorlist_show_top_vendor", (int) null, 2, (FWFProjectName) null),
    VENDORLIST_COLLECTION_DEEP_LINK_NAVIGATION("ff_vendorlist_deep_link", (int) null, 2, (FWFProjectName) null),
    VENDORLIST_DEEP_LINK_NAVIGATION_HOF("ff_vendorlist_deep_link_hof", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private VendorListFeatureFlagsKeys(String str, FWFProjectName fWFProjectName) {
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
