package com.talabat.darkstores.data.recentsearches.mapper;

import com.talabat.darkstores.data.recentsearches.local.SearchQueryRecord;
import com.talabat.darkstores.domain.model.RecentSearch;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0002¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/data/recentsearches/mapper/RecentSearchDatabaseToDomainModelMapper;", "", "invoke", "Lcom/talabat/darkstores/domain/model/RecentSearch;", "model", "Lcom/talabat/darkstores/data/recentsearches/local/SearchQueryRecord;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RecentSearchDatabaseToDomainModelMapper {
    @NotNull
    RecentSearch invoke(@NotNull SearchQueryRecord searchQueryRecord);
}
