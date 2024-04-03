package com.talabat.core.fwfprojectskeys.domain.projects.vendorlist;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/vendorlist/VendorListExperimentsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "PICKUP_TOGGLE_REVAMP", "PICKUP_TOOL_TIP", "FLUTTER_FOOD_LIST_SCREEN", "PICKUP_SWIMLANES", "PICKUP_BLOCKING_MODAL_REVAMP", "CARD_VIEW_DEFAULT_TYPE", "HOF_HOLDOUT_Q3", "HIDE_DELIVERY_MODE_TAB", "SHOW_FAVORITES_UPDATED_TOAST", "SHOW_TOP_TEN_SWIMLANE", "SHOW_LOCKED_GEM", "HIDE_GEM_POPUP", "REORDER_SHOW_BOTTOMSHEET", "EXP_VENDORLIST_PROSPECTS_DEEP_LINK_HOF", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum VendorListExperimentsKeys implements FWFKey {
    PICKUP_TOGGLE_REVAMP("exp_vendorlist_pickup_toggle_revamp", (int) null, 2, (FWFProjectName) null),
    PICKUP_TOOL_TIP("exp_vendorlist_pickup_tooltip", (int) null, 2, (FWFProjectName) null),
    FLUTTER_FOOD_LIST_SCREEN("exp_vendorlist_show_flutter_foodlist_screen", (int) null, 2, (FWFProjectName) null),
    PICKUP_SWIMLANES("exp_vendorlist_pickup_swimlanes", (int) null, 2, (FWFProjectName) null),
    PICKUP_BLOCKING_MODAL_REVAMP("exp_vendorlist_pickup_blocking_modal_revamp", (int) null, 2, (FWFProjectName) null),
    CARD_VIEW_DEFAULT_TYPE("exp_vendorlist_cardview_as_default", (int) null, 2, (FWFProjectName) null),
    HOF_HOLDOUT_Q3("exp_holdout_vl_23_q3", (int) null, 2, (FWFProjectName) null),
    HIDE_DELIVERY_MODE_TAB("exp_vendorlist_hide_pickup_tab", (int) null, 2, (FWFProjectName) null),
    SHOW_FAVORITES_UPDATED_TOAST("exp_vendorlist_show_favorites_updated_toast", (int) null, 2, (FWFProjectName) null),
    SHOW_TOP_TEN_SWIMLANE("exp_vendorlist_show_top_vendor", (int) null, 2, (FWFProjectName) null),
    SHOW_LOCKED_GEM("exp_vendorlist_show_locked_gem", (int) null, 2, (FWFProjectName) null),
    HIDE_GEM_POPUP("exp_vendorlist_hidden_gem", (int) null, 2, (FWFProjectName) null),
    REORDER_SHOW_BOTTOMSHEET("exp_vendorlist_reorder_bottomsheet", (int) null, 2, (FWFProjectName) null),
    EXP_VENDORLIST_PROSPECTS_DEEP_LINK_HOF("exp_vendorlist_prospects_deep_link_hof", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private VendorListExperimentsKeys(String str, FWFProjectName fWFProjectName) {
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
