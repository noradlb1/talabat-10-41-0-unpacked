package com.talabat.core.fwfprojectskeys.domain.projects.search;

import com.talabat.core.fwfprojectskeys.domain.FWFKey;
import com.talabat.core.fwfprojectskeys.domain.FWFProjectName;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/core/fwfprojectskeys/domain/projects/search/SearchFeatureFlagsKeys;", "", "Lcom/talabat/core/fwfprojectskeys/domain/FWFKey;", "value", "", "projectName", "Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "(Ljava/lang/String;ILjava/lang/String;Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;)V", "getProjectName", "()Lcom/talabat/core/fwfprojectskeys/domain/FWFProjectName;", "getValue", "()Ljava/lang/String;", "SEARCH_ENABLE_PICKUP_BLOCKING_MODEL", "SEARCH_FAVORITES", "SEARCH_ENABLE_PICKUP_DIFFERENTIAL_DISCOUNTS", "ENABLE_CUISINES_ON_PRE_SEARCH", "GET_FLUTTER_SEARCHABLE_VERTICALS", "com_talabat_core_fwf-projects-keys_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum SearchFeatureFlagsKeys implements FWFKey {
    SEARCH_ENABLE_PICKUP_BLOCKING_MODEL("ff_search_pickup_blocking_modal", (int) null, 2, (FWFProjectName) null),
    SEARCH_FAVORITES("ff_search_favorites", (int) null, 2, (FWFProjectName) null),
    SEARCH_ENABLE_PICKUP_DIFFERENTIAL_DISCOUNTS("ff_search_pickup_enable_differential_discounts", (int) null, 2, (FWFProjectName) null),
    ENABLE_CUISINES_ON_PRE_SEARCH("ff_search_cuisines_in_pre_search", (int) null, 2, (FWFProjectName) null),
    GET_FLUTTER_SEARCHABLE_VERTICALS("ff_search_flutter_searchable_verticals", (int) null, 2, (FWFProjectName) null);
    
    @NotNull
    private final FWFProjectName projectName;
    @NotNull
    private final String value;

    private SearchFeatureFlagsKeys(String str, FWFProjectName fWFProjectName) {
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
