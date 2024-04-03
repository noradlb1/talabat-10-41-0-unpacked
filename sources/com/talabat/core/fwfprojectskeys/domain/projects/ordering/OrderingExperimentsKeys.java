package com.talabat.core.fwfprojectskeys.domain.projects.ordering;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/ordering/OrderingExperimentsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "ENABLE_TPRO_CHECKOUT", "EXP_LENDING_BNPL_PAYMENT_FALLBACK", "EXP_LENDING_BNPL_CHANGE_AUTO_PAYMENT_CARD", "EXP_LENDING_BNPL_MULTIPLE_ORDER_PAYMENT", "EXP_HOLDOUT_EXPERIMENT", "EXP_HOLDOUT_Q1_2024_EXPERIMENT", "EXP_HOLDOUT_FOOD_CART_EXPERIMENT", "EXP_HOLDOUT_PRICING_EXPERIMENT", "MENU_IMAGE_LOADING_EXPERIMENT", "MENU_QUICK_ADD", "MENU_BASKET_SAVINGS", "EXP_ORDERING_TPRO_QUICK_SUBSCRIBE", "EXP_ORDERING_SHOWING_REORDER_IN_HOME_BOTTOM_TAB", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum OrderingExperimentsKeys implements FWFKey {
    ENABLE_TPRO_CHECKOUT("exp_ordering_enable_tpro_subscribe_free_trial_at_checkout", (int) null, 2, (FWFProjectName) null),
    EXP_LENDING_BNPL_PAYMENT_FALLBACK("exp_ordering_lending_pay_later_payment_fallback", (int) null, 2, (FWFProjectName) null),
    EXP_LENDING_BNPL_CHANGE_AUTO_PAYMENT_CARD("exp_ordering_lending_change_auto_payment_card", (int) null, 2, (FWFProjectName) null),
    EXP_LENDING_BNPL_MULTIPLE_ORDER_PAYMENT("exp_ordering_lending_pay_later_multiple_order_payment", (int) null, 2, (FWFProjectName) null),
    EXP_HOLDOUT_EXPERIMENT("exp_ordering_holdout_23_q4", (int) null, 2, (FWFProjectName) null),
    EXP_HOLDOUT_Q1_2024_EXPERIMENT("exp_ordering_and_food_finding_holdout_24_q1", (int) null, 2, (FWFProjectName) null),
    EXP_HOLDOUT_FOOD_CART_EXPERIMENT("exp_ordering_foodcart_holdout_23_q4", (int) null, 2, (FWFProjectName) null),
    EXP_HOLDOUT_PRICING_EXPERIMENT("exp_ordering_pricing_holdout_23_q4", (int) null, 2, (FWFProjectName) null),
    MENU_IMAGE_LOADING_EXPERIMENT("exp_ordering_image_loading", (int) null, 2, (FWFProjectName) null),
    MENU_QUICK_ADD("exp_ordering_quick_add", (int) null, 2, (FWFProjectName) null),
    MENU_BASKET_SAVINGS("exp_ordering_basket_savings", (int) null, 2, (FWFProjectName) null),
    EXP_ORDERING_TPRO_QUICK_SUBSCRIBE("exp_ordering_tpro_quick_subscribe", (int) null, 2, (FWFProjectName) null),
    EXP_ORDERING_SHOWING_REORDER_IN_HOME_BOTTOM_TAB("exp_ordering_showing_reorder_in_home_bottom_tab", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private OrderingExperimentsKeys(String str, FWFProjectName fWFProjectName) {
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
