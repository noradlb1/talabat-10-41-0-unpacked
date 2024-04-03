package com.talabat.darkstores.data.discovery.mappers;

import com.talabat.darkstores.data.discovery.model.MultiListComponentItem;
import com.talabat.darkstores.data.discovery.model.MultiListFeedEndpointResponse;
import com.talabat.darkstores.data.discovery.model.NetworkSortOption;
import com.talabat.darkstores.data.discovery.model.SortOption;
import com.talabat.darkstores.data.discovery.model.SubcategorySwimalnesResponse;
import com.talabat.darkstores.model.Swimlane;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\b\u0007\u0012\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/darkstores/data/discovery/mappers/SubcategorySwimlanesResultMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/darkstores/data/discovery/model/MultiListFeedEndpointResponse;", "Lcom/talabat/darkstores/data/discovery/model/SubcategorySwimalnesResponse;", "sortOptionMapper", "Lcom/talabat/darkstores/data/discovery/model/NetworkSortOption;", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "(Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubcategorySwimlanesResultMapper implements ModelMapper<MultiListFeedEndpointResponse, SubcategorySwimalnesResponse> {
    @NotNull
    private final ModelMapper<NetworkSortOption, SortOption> sortOptionMapper;

    @Inject
    public SubcategorySwimlanesResultMapper(@NotNull ModelMapper<NetworkSortOption, SortOption> modelMapper) {
        Intrinsics.checkNotNullParameter(modelMapper, "sortOptionMapper");
        this.sortOptionMapper = modelMapper;
    }

    @NotNull
    public SubcategorySwimalnesResponse apply(@NotNull MultiListFeedEndpointResponse multiListFeedEndpointResponse) {
        List list;
        List<NetworkSortOption> sortOptions;
        Intrinsics.checkNotNullParameter(multiListFeedEndpointResponse, "source");
        MultiListComponentItem multiListComponentItem = (MultiListComponentItem) CollectionsKt___CollectionsKt.firstOrNull(multiListFeedEndpointResponse.getFeedItems().getComponentItems());
        List<Swimlane> swimlanes = multiListComponentItem != null ? multiListComponentItem.getSwimlanes() : null;
        MultiListComponentItem multiListComponentItem2 = (MultiListComponentItem) CollectionsKt___CollectionsKt.firstOrNull(multiListFeedEndpointResponse.getFeedItems().getComponentItems());
        if (multiListComponentItem2 == null || (sortOptions = multiListComponentItem2.getSortOptions()) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list = new ArrayList();
            for (NetworkSortOption apply : sortOptions) {
                SortOption apply2 = this.sortOptionMapper.apply(apply);
                if (apply2 != null) {
                    list.add(apply2);
                }
            }
        }
        if (swimlanes != null) {
            return new SubcategorySwimalnesResponse(swimlanes, list);
        }
        throw new IllegalArgumentException("Swimlane/FeedItems can not be empty or null");
    }
}
