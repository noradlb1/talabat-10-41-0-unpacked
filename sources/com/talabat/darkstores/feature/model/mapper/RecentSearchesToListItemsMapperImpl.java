package com.talabat.darkstores.feature.model.mapper;

import com.talabat.darkstores.domain.model.RecentSearch;
import com.talabat.darkstores.feature.model.PreSearchItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004H\u0002¨\u0006\b"}, d2 = {"Lcom/talabat/darkstores/feature/model/mapper/RecentSearchesToListItemsMapperImpl;", "Lcom/talabat/darkstores/feature/model/mapper/RecentSearchesToListItemsMapper;", "()V", "invoke", "", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "models", "Lcom/talabat/darkstores/domain/model/RecentSearch;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RecentSearchesToListItemsMapperImpl implements RecentSearchesToListItemsMapper {
    @NotNull
    public List<PreSearchItem> invoke(@NotNull List<RecentSearch> list) {
        Intrinsics.checkNotNullParameter(list, "models");
        ArrayList arrayList = new ArrayList();
        if (!list.isEmpty()) {
            arrayList.add(PreSearchItem.RecentSearchesHeader.INSTANCE);
            Iterable<RecentSearch> iterable = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (RecentSearch recentSearch : iterable) {
                arrayList2.add(new PreSearchItem.RecentSearch(recentSearch.getId(), recentSearch.getQuery()));
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
        }
        return arrayList;
    }
}
