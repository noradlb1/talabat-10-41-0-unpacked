package com.talabat.core.fwfprojectskeys.domain.projects.home;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/home/HomePageExperimentsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "REFER_A_FRIEND_CONFIG", "FLUTTER_HOME_TAB", "FLUTTER_ACCOUNT_TAB", "HOMEPAGE_NEW_ONBOARDING", "FLUTTER_ORDERS_LIST", "HOME_OF_OFFERS_HOLDOUT", "HOME_OF_OFFERS", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum HomePageExperimentsKeys implements FWFKey {
    REFER_A_FRIEND_CONFIG("exp_homepage_refer_a_friend_config", (int) null, 2, (FWFProjectName) null),
    FLUTTER_HOME_TAB("exp_homepage_flutter_home_aa_test", (int) null, 2, (FWFProjectName) null),
    FLUTTER_ACCOUNT_TAB("exp_homepage_flutter_account_tab_aa_test", (int) null, 2, (FWFProjectName) null),
    HOMEPAGE_NEW_ONBOARDING("exp_homepage_new_onboarding", (int) null, 2, (FWFProjectName) null),
    FLUTTER_ORDERS_LIST("exp_homepage_orders_list_flutter", (int) null, 2, (FWFProjectName) null),
    HOME_OF_OFFERS_HOLDOUT("exp_homepage_home_of_offers_holdout", (int) null, 2, (FWFProjectName) null),
    HOME_OF_OFFERS("exp_homepage_home_of_offers", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private HomePageExperimentsKeys(String str, FWFProjectName fWFProjectName) {
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
