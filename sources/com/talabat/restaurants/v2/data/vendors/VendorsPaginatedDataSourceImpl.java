package com.talabat.restaurants.v2.data.vendors;

import com.talabat.restaurants.v2.data.vendors.VendorsApiPaginated;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JS\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsPaginatedDataSourceImpl;", "Lcom/talabat/restaurants/v2/data/vendors/VendorsPaginatedDataSource;", "vendorsApi", "Lcom/talabat/restaurants/v2/data/vendors/VendorsApiPaginated;", "(Lcom/talabat/restaurants/v2/data/vendors/VendorsApiPaginated;)V", "getAllVendorsPaginated", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestaurantListResponsePaginated;", "areaParams", "Lcom/talabat/restaurants/v2/data/vendors/AreaParams;", "filterParams", "Lcom/talabat/restaurants/v2/data/vendors/FilterParams;", "verticalIds", "", "", "page", "size", "externalExperiments", "", "(Lcom/talabat/restaurants/v2/data/vendors/AreaParams;Lcom/talabat/restaurants/v2/data/vendors/FilterParams;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lio/reactivex/Single;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsPaginatedDataSourceImpl implements VendorsPaginatedDataSource {
    @NotNull
    private final VendorsApiPaginated vendorsApi;

    public VendorsPaginatedDataSourceImpl(@NotNull VendorsApiPaginated vendorsApiPaginated) {
        Intrinsics.checkNotNullParameter(vendorsApiPaginated, "vendorsApi");
        this.vendorsApi = vendorsApiPaginated;
    }

    @NotNull
    public Single<RestaurantListResponsePaginated> getAllVendorsPaginated(@NotNull AreaParams areaParams, @Nullable FilterParams filterParams, @Nullable List<Integer> list, @Nullable Integer num, @Nullable Integer num2, @Nullable String str) {
        List<Integer> list2;
        List<Integer> list3;
        Intrinsics.checkNotNullParameter(areaParams, "areaParams");
        VendorsApiPaginated vendorsApiPaginated = this.vendorsApi;
        int areaId = areaParams.getAreaId();
        int countryId = areaParams.getCountryId();
        String lat = areaParams.getLat();
        String lon = areaParams.getLon();
        String str2 = null;
        if (filterParams != null) {
            list2 = filterParams.getFilterIds();
        } else {
            list2 = null;
        }
        if (filterParams != null) {
            list3 = filterParams.getCuisineIds();
        } else {
            list3 = null;
        }
        if (filterParams != null) {
            str2 = filterParams.getSorting();
        }
        return VendorsApiPaginated.DefaultImpls.getVendors$default(vendorsApiPaginated, areaId, countryId, lat, lon, num, num2, list2, list3, str2, list, (List) null, str, (String) null, (String) null, 13312, (Object) null);
    }
}
