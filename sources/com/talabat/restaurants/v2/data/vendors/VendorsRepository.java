package com.talabat.restaurants.v2.data.vendors;

import JsonModels.Request.RestaurantReq;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&JF\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\rH&¨\u0006\u0012"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsRepository;", "", "getVendorsByArea", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "isForceUpdate", "", "requestBody", "LJsonModels/Request/RestaurantReq;", "getVendorsByPolygons", "apiVersion", "", "latitude", "", "longitude", "verticalIds", "", "weightSet", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsRepository {
    @NotNull
    Single<RestuarntListResponse> getVendorsByArea(boolean z11, @NotNull RestaurantReq restaurantReq);

    @NotNull
    Single<RestuarntListResponse> getVendorsByPolygons(boolean z11, int i11, @NotNull String str, @NotNull String str2, @Nullable List<Integer> list, @NotNull String str3);
}
