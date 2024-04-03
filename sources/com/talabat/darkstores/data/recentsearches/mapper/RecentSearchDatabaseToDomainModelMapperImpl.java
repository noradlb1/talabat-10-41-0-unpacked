package com.talabat.darkstores.data.recentsearches.mapper;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.talabat.darkstores.data.recentsearches.local.SearchQueryRecord;
import com.talabat.darkstores.domain.model.RecentSearch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/data/recentsearches/mapper/RecentSearchDatabaseToDomainModelMapperImpl;", "Lcom/talabat/darkstores/data/recentsearches/mapper/RecentSearchDatabaseToDomainModelMapper;", "()V", "invoke", "Lcom/talabat/darkstores/domain/model/RecentSearch;", "model", "Lcom/talabat/darkstores/data/recentsearches/local/SearchQueryRecord;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecentSearchDatabaseToDomainModelMapperImpl implements RecentSearchDatabaseToDomainModelMapper {
    @NotNull
    public RecentSearch invoke(@NotNull SearchQueryRecord searchQueryRecord) {
        Intrinsics.checkNotNullParameter(searchQueryRecord, DeviceRequestsHelper.DEVICE_INFO_MODEL);
        return new RecentSearch(searchQueryRecord.getId(), searchQueryRecord.getQuery());
    }
}
