package com.talabat.restaurants.v2.data.vendors;

import datamodels.Restaurant;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import mt.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JJ\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsByIdDataSourceImpl;", "Lcom/talabat/restaurants/v2/data/vendors/VendorByIdDataSource;", "vendorsApiPaginated", "Lcom/talabat/restaurants/v2/data/vendors/VendorsApiPaginated;", "(Lcom/talabat/restaurants/v2/data/vendors/VendorsApiPaginated;)V", "getVendorById", "Lio/reactivex/Single;", "", "Ldatamodels/Restaurant;", "areaParams", "Lcom/talabat/restaurants/v2/data/vendors/AreaParams;", "vendorIds", "", "externalExperiments", "", "deviceEntrypoint", "deviceCTA", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsByIdDataSourceImpl implements VendorByIdDataSource {
    @NotNull
    private final VendorsApiPaginated vendorsApiPaginated;

    public VendorsByIdDataSourceImpl(@NotNull VendorsApiPaginated vendorsApiPaginated2) {
        Intrinsics.checkNotNullParameter(vendorsApiPaginated2, "vendorsApiPaginated");
        this.vendorsApiPaginated = vendorsApiPaginated2;
    }

    /* access modifiers changed from: private */
    /* renamed from: getVendorById$lambda-0  reason: not valid java name */
    public static final List m10735getVendorById$lambda0(RestaurantListResponsePaginated restaurantListResponsePaginated) {
        Intrinsics.checkNotNullParameter(restaurantListResponsePaginated, "it");
        List<Restaurant> vendors = restaurantListResponsePaginated.getVendors();
        if (vendors == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return vendors;
    }

    @NotNull
    public Single<List<Restaurant>> getVendorById(@NotNull AreaParams areaParams, @Nullable List<Integer> list, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(areaParams, "areaParams");
        Single<R> map = this.vendorsApiPaginated.getVendors(areaParams.getAreaId(), areaParams.getCountryId(), areaParams.getLat(), areaParams.getLon(), (Integer) null, (Integer) null, (List<Integer>) null, (List<Integer>) null, (String) null, (List<Integer>) null, list, str, str2, str3).map(new a());
        Intrinsics.checkNotNullExpressionValue(map, "vendorsApiPaginated.getV…ors ?: listOf()\n        }");
        return map;
    }
}
