package com.talabat.restaurants.v2.data.vendors;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JW\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsPaginatedDataSource;", "", "getAllVendorsPaginated", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "areaParams", "Lcom/talabat/restaurants/v2/data/vendors/AreaParams;", "filterParams", "Lcom/talabat/restaurants/v2/data/vendors/FilterParams;", "verticalIds", "", "", "page", "size", "externalExperiments", "", "(Lcom/talabat/restaurants/v2/data/vendors/AreaParams;Lcom/talabat/restaurants/v2/data/vendors/FilterParams;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Single;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsPaginatedDataSource {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getAllVendorsPaginated$default(VendorsPaginatedDataSource vendorsPaginatedDataSource, AreaParams areaParams, FilterParams filterParams, List list, Integer num, Integer num2, String str, int i11, Object obj) {
            if (obj == null) {
                return vendorsPaginatedDataSource.getAllVendorsPaginated(areaParams, (i11 & 2) != 0 ? null : filterParams, list, num, num2, (i11 & 32) != 0 ? null : str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAllVendorsPaginated");
        }
    }

    @NotNull
    Single<RestaurantListResponsePaginated> getAllVendorsPaginated(@NotNull AreaParams areaParams, @Nullable FilterParams filterParams, @Nullable List<Integer> list, @Nullable Integer num, @Nullable Integer num2, @Nullable String str);
}
