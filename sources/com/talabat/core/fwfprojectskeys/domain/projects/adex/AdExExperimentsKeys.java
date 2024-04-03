package com.talabat.core.fwfprojectskeys.domain.projects.adex;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/adex/AdExExperimentsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "SEARCH_GEM_ORGANIC_LISTING_SOURCE", "SHOW_FLUTTER_GEM_COLLECTION", "NEW_SPONSORED_TAG", "GEM_MIGRATION_FOOD_LIST", "GEM_HOME_MIGRATION", "GEM_MENU_MIGRATION", "MINIMIZE_GEM_POPUP", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum AdExExperimentsKeys implements FWFKey {
    SEARCH_GEM_ORGANIC_LISTING_SOURCE("exp_adex_search_gem_organic_listing_source", (int) null, 2, (FWFProjectName) null),
    SHOW_FLUTTER_GEM_COLLECTION("exp_adex_aa_test_gem_collection_flutter", (int) null, 2, (FWFProjectName) null),
    NEW_SPONSORED_TAG("exp_adex_new_sponsored_tag", (int) null, 2, (FWFProjectName) null),
    GEM_MIGRATION_FOOD_LIST("exp_adex_gem_migration_foodlist", (int) null, 2, (FWFProjectName) null),
    GEM_HOME_MIGRATION("exp_adex_gem_home_migration", (int) null, 2, (FWFProjectName) null),
    GEM_MENU_MIGRATION("exp_adex_gem_menu_migration", (int) null, 2, (FWFProjectName) null),
    MINIMIZE_GEM_POPUP("exp_adex_minimize_gem_popup", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private AdExExperimentsKeys(String str, FWFProjectName fWFProjectName) {
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
