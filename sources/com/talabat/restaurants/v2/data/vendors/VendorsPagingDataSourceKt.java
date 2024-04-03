package com.talabat.restaurants.v2.data.vendors;

import androidx.paging.PagingSource;
import com.talabat.restaurants.v2.domain.vendors.PaginatedResponseMapperKt;
import datamodels.RestaurantListItemModel;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a(\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002¨\u0006\u0007"}, d2 = {"toLoadResult", "Landroidx/paging/PagingSource$LoadResult;", "", "Ldatamodels/RestaurantListItemModel;", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "verticalIds", "", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class VendorsPagingDataSourceKt {
    /* access modifiers changed from: private */
    public static final PagingSource.LoadResult<Integer, RestaurantListItemModel> toLoadResult(RestaurantListResponsePaginated restaurantListResponsePaginated, List<Integer> list) {
        List list2;
        Integer num;
        List<RestaurantListItemModel> listViewModel = PaginatedResponseMapperKt.toListViewModel(restaurantListResponsePaginated, list);
        if (listViewModel == null || (list2 = CollectionsKt___CollectionsKt.toList(listViewModel)) == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        if (restaurantListResponsePaginated.getPage() * 50 < restaurantListResponsePaginated.getTotalVendors()) {
            num = Integer.valueOf(restaurantListResponsePaginated.getPage() + 1);
        } else {
            num = null;
        }
        return new PagingSource.LoadResult.Page(list2, null, num);
    }
}
