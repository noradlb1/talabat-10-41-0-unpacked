package com.talabat.darkstores.domain.mapper;

import com.talabat.darkstores.data.SearchCategory;
import com.talabat.darkstores.data.mission.control.model.MissionControlProductsResponse;
import com.talabat.darkstores.data.mission.control.model.MissionControlProductsResult;
import com.talabat.darkstores.data.search.model.Filters;
import com.talabat.darkstores.domain.model.MissionControlProducts;
import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapperImpl;", "Lcom/talabat/darkstores/domain/mapper/MissionControlProductsResponseToDomainMapper;", "()V", "invoke", "Lcom/talabat/darkstores/domain/model/MissionControlProducts;", "response", "Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResponse;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlProductsResponseToDomainMapperImpl implements MissionControlProductsResponseToDomainMapper {
    @NotNull
    public MissionControlProducts invoke(@NotNull MissionControlProductsResponse missionControlProductsResponse) {
        List<Filters.Category> categories;
        SearchCategory searchCategory;
        Intrinsics.checkNotNullParameter(missionControlProductsResponse, "response");
        MissionControlProductsResult result = missionControlProductsResponse.getResult();
        List<Product> products = result.getProducts();
        int pageNumber = result.getPageInfo().getPageNumber();
        boolean isLast = result.getPageInfo().isLast();
        Filters filters = result.getFilters();
        ArrayList arrayList = null;
        if (!(filters == null || (categories = filters.getCategories()) == null)) {
            ArrayList arrayList2 = new ArrayList();
            for (Filters.Category category : categories) {
                String name2 = category.getName();
                if (name2 != null) {
                    searchCategory = new SearchCategory(category.getId(), name2);
                } else {
                    searchCategory = null;
                }
                if (searchCategory != null) {
                    arrayList2.add(searchCategory);
                }
            }
            arrayList = arrayList2;
        }
        return new MissionControlProducts(products, pageNumber, arrayList, isLast);
    }
}
