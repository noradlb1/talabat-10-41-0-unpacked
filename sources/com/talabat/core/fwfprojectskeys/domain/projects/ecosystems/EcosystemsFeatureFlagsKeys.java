package com.talabat.core.fwfprojectskeys.domain.projects.ecosystems;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/ecosystems/EcosystemsFeatureFlagsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "IS_FLUTTER_REWARDS_DASHBOARD_ENABLED", "IS_REWARDS_ENABLED", "IS_REWARDS_MENUBFF_REDEEM_ENABLED", "IS_MISSIONS_WIDGET_ENABLED", "IS_TALABAT_PRO_SUBSCRIPTION_ENABLED", "IS_REACTIVATE_FROM_ROI_BANNER_ENABLED", "IS_EXPIRED_MODE_ROI_BANNER_ENABLED", "IS_TALABAT_PRO_DISCLAIMER_TEXT_ENABLED", "IS_MORE_BUTTON_ON_WALLET_DASHBOARD_ENABLED", "IS_TALABAT_REF_NUMBER_ON_MORE_BOTTOM_SHEET_ENABLED", "SHOULD_SHOW_NAVIGATION_BAR_ON_COBRANDED_CC_WEB_VIEW", "SHOULD_SHOW_WALLET_TRANSACTION_DETAILS_IN_FLUTTER", "IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED", "IS_TOP_UP_FLUTTER_ENABLED", "IS_CARDS_MANAGEMENT_FLUTTER_ENABLED", "IS_QUICK_SUBSCRIBE_NFV_ENABLED", "IS_IN_APP_MESSAGES_FREQUENCY_CAPPING_ENABLED", "SHOULD_SHOW_BENEFITS_LIST_TO_CCC_IN_PROGRESS", "IS_DINE_OUT_CAROUSEL_ENABLED", "SHOW_DINE_OUT_CUISINE_FILTERS", "IS_FLUTTER_WALLET_DASHBOARD_ENABLED", "IS_FLUTTER_WALLET_DASHBOARD_TOP_UP_ENABLED", "IS_FLUTTER_WALLET_DASHBOARD_MORE_BUTTON_ENABLED", "IS_FLUTTER_WALLET_DASHBOARD_CARDS_ENABLED_ENABLED", "IS_FLUTTER_CARD_MANAGEMENT_SHOW_ADD_CARD_ENABLED", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum EcosystemsFeatureFlagsKeys implements FWFKey {
    IS_FLUTTER_REWARDS_DASHBOARD_ENABLED("ff_ecosystems_is_flutter_rewards_dashboard_enabled", (int) null, 2, (FWFProjectName) null),
    IS_REWARDS_ENABLED("ff_ecosystems_is_rewards_enabled", (int) null, 2, (FWFProjectName) null),
    IS_REWARDS_MENUBFF_REDEEM_ENABLED("ff_ecosystems_enable_redeem_and_apply", (int) null, 2, (FWFProjectName) null),
    IS_MISSIONS_WIDGET_ENABLED("ff_ecosystems_is_missions_widget_enabled", (int) null, 2, (FWFProjectName) null),
    IS_TALABAT_PRO_SUBSCRIPTION_ENABLED("ff_ecosystems_is_talabat_pro_subscription_enabled", (int) null, 2, (FWFProjectName) null),
    IS_REACTIVATE_FROM_ROI_BANNER_ENABLED("ff_ecosystems_is_roi_banner_reactivate_enabled", (int) null, 2, (FWFProjectName) null),
    IS_EXPIRED_MODE_ROI_BANNER_ENABLED("ff_ecosystems_is_roi_banner_expired_mode_enabled", (int) null, 2, (FWFProjectName) null),
    IS_TALABAT_PRO_DISCLAIMER_TEXT_ENABLED("ff_ecosystems_is_talabat_pro_disclaimer_text_enabled", (int) null, 2, (FWFProjectName) null),
    IS_MORE_BUTTON_ON_WALLET_DASHBOARD_ENABLED("ff_ecosystems_wallet_dashboard_show_more_button", (int) null, 2, (FWFProjectName) null),
    IS_TALABAT_REF_NUMBER_ON_MORE_BOTTOM_SHEET_ENABLED("ff_ecosystems_more_bottom_sheet_show_talabat_ref_number", (int) null, 2, (FWFProjectName) null),
    SHOULD_SHOW_NAVIGATION_BAR_ON_COBRANDED_CC_WEB_VIEW("ff_ecosystems_cobranded_cc_web_view_navigation_bar", (int) null, 2, (FWFProjectName) null),
    SHOULD_SHOW_WALLET_TRANSACTION_DETAILS_IN_FLUTTER("ff_ecosystems_wallet_dashboard_trans_details_flutter", (int) null, 2, (FWFProjectName) null),
    IS_TPRO_SHAHID_B2B_RENEWABLE_PLAN_MODE_ENABLED("ff_ecosystems_is_tpro_shahid_b2b_renewable_plan_mode_enabled", (int) null, 2, (FWFProjectName) null),
    IS_TOP_UP_FLUTTER_ENABLED("ff_ecosystems_top_up_flutter_screen_enabled", (int) null, 2, (FWFProjectName) null),
    IS_CARDS_MANAGEMENT_FLUTTER_ENABLED("ff_ecosystems_cards_management_flutter_screen_enabled", (int) null, 2, (FWFProjectName) null),
    IS_QUICK_SUBSCRIBE_NFV_ENABLED("ff_ecosystems_is_quick_subscribe_nfv_enabled", (int) null, 2, (FWFProjectName) null),
    IS_IN_APP_MESSAGES_FREQUENCY_CAPPING_ENABLED("ff_ecosystems_is_iams_frequency_capping_enabled", (int) null, 2, (FWFProjectName) null),
    SHOULD_SHOW_BENEFITS_LIST_TO_CCC_IN_PROGRESS("ff_ecosystems_wallet_ccc_show_benefits_list_for_in_progress", (int) null, 2, (FWFProjectName) null),
    IS_DINE_OUT_CAROUSEL_ENABLED("ff_ecosystems_enrich_vendor_card_enabled", (int) null, 2, (FWFProjectName) null),
    SHOW_DINE_OUT_CUISINE_FILTERS("ff_ecosystems_dineout_cuisine_filters", (int) null, 2, (FWFProjectName) null),
    IS_FLUTTER_WALLET_DASHBOARD_ENABLED("ff_ecosystems_is_flutter_wallet_dashboard_enabled", (int) null, 2, (FWFProjectName) null),
    IS_FLUTTER_WALLET_DASHBOARD_TOP_UP_ENABLED("ff_ecosystems_wallet_dashboard_show_top_up_button", (int) null, 2, (FWFProjectName) null),
    IS_FLUTTER_WALLET_DASHBOARD_MORE_BUTTON_ENABLED("ff_ecosystems_wallet_dashboard_show_more_button", (int) null, 2, (FWFProjectName) null),
    IS_FLUTTER_WALLET_DASHBOARD_CARDS_ENABLED_ENABLED("ff_ecosystems_wallet_dashboard_show_cards_management_button", (int) null, 2, (FWFProjectName) null),
    IS_FLUTTER_CARD_MANAGEMENT_SHOW_ADD_CARD_ENABLED("ff_ecosystems_card_management_show_add_card", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private EcosystemsFeatureFlagsKeys(String str, FWFProjectName fWFProjectName) {
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
