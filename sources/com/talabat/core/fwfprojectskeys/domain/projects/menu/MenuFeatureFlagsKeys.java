package com.talabat.core.fwfprojectskeys.domain.projects.menu;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/menu/MenuFeatureFlagsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "MENU_ADD_TO_BASKET", "MENU_REMOVE_CORRUPTED_CHOICE_IMAGES", "MENU_ENABLE_FLUTTER_BUSY_VENDOR_SHEET", "MENU_ENABLE_MENU_DEEP_LINK_NAVIGATION", "MENU_ENABLE_ITEM_DETAILS_MICRO_INTERACTIONS", "MENU_DISABLE_VENDOR_UPDATES_TO_GDM", "MENU_DISABLE_MENU_UPDATES_TO_GDM", "MENU_FREE_DELIVERY_NEW_CUSTOMERS", "MENU_SHOW_FAVORITES", "IS_MENU_ORPHAN_DIALOG_FIX_ENABLED", "IS_MENU_RESPONSE_CHECKS_ENABLED", "IS_MENU_CART_DOMAIN_ENABLED", "IS_MENU_NATIVE_TO_FLUTTER_VIA_DEEPLINK_ENABLED", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum MenuFeatureFlagsKeys implements FWFKey {
    MENU_ADD_TO_BASKET("ff_menu_is_add_to_basket_enable", (int) null, 2, (FWFProjectName) null),
    MENU_REMOVE_CORRUPTED_CHOICE_IMAGES("ff_menu_remove_corrupted_choice_images", (int) null, 2, (FWFProjectName) null),
    MENU_ENABLE_FLUTTER_BUSY_VENDOR_SHEET("ff_menu_enable_flutter_busy_vendor_sheet", (int) null, 2, (FWFProjectName) null),
    MENU_ENABLE_MENU_DEEP_LINK_NAVIGATION("ff_menu_deep_link", (int) null, 2, (FWFProjectName) null),
    MENU_ENABLE_ITEM_DETAILS_MICRO_INTERACTIONS("ff_menu_item_details_micro_interactions_enabled", (int) null, 2, (FWFProjectName) null),
    MENU_DISABLE_VENDOR_UPDATES_TO_GDM("ff_menu_disable_vendor_channel", (int) null, 2, (FWFProjectName) null),
    MENU_DISABLE_MENU_UPDATES_TO_GDM("ff_menu_disable_menu_channel", (int) null, 2, (FWFProjectName) null),
    MENU_FREE_DELIVERY_NEW_CUSTOMERS("ff_menu_free_delivery_new_customers", (int) null, 2, (FWFProjectName) null),
    MENU_SHOW_FAVORITES("ff_menu_show_favorites", (int) null, 2, (FWFProjectName) null),
    IS_MENU_ORPHAN_DIALOG_FIX_ENABLED("ff_menu_orphan_dialog", (int) null, 2, (FWFProjectName) null),
    IS_MENU_RESPONSE_CHECKS_ENABLED("ff_menu_is_response_checks_on", (int) null, 2, (FWFProjectName) null),
    IS_MENU_CART_DOMAIN_ENABLED("ff_menu_cart_domain", (int) null, 2, (FWFProjectName) null),
    IS_MENU_NATIVE_TO_FLUTTER_VIA_DEEPLINK_ENABLED("ff_menu_native_to_flutter_with_deeplink", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private MenuFeatureFlagsKeys(String str, FWFProjectName fWFProjectName) {
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
