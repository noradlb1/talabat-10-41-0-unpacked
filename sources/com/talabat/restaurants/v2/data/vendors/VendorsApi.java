package com.talabat.restaurants.v2.data.vendors;

import JsonModels.Request.RestaurantReq;
import io.reactivex.Single;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH'Jb\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0003\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000b2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\b\u0001\u0010\u0011\u001a\u00020\u000bH'¨\u0006\u0012"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendors/VendorsApi;", "", "getVendorsByArea", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "apiVersion", "", "restaurantReq", "LJsonModels/Request/RestaurantReq;", "getVendorsByPolygons", "latitude", "", "longitude", "experimentDynamicWeightsVertical", "personalApiExperiment", "externalExperiments", "verticalIds", "weightSet", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getVendorsByArea$default(VendorsApi vendorsApi, int i11, RestaurantReq restaurantReq, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 2;
                }
                return vendorsApi.getVendorsByArea(i11, restaurantReq);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsByArea");
        }

        public static /* synthetic */ Single getVendorsByPolygons$default(VendorsApi vendorsApi, int i11, String str, String str2, int i12, String str3, String str4, String str5, String str6, int i13, Object obj) {
            if (obj == null) {
                return vendorsApi.getVendorsByPolygons(i11, str, str2, (i13 & 8) != 0 ? -1 : i12, str3, (i13 & 32) != 0 ? null : str4, str5, str6);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsByPolygons");
        }
    }

    @NotNull
    @POST("restaurantapi/v{version}/vendors")
    Single<RestuarntListResponse> getVendorsByArea(@Path("version") int i11, @NotNull @Body RestaurantReq restaurantReq);

    @NotNull
    @GET("/api/v{version}/vendors/{latitude}/{longitude}")
    Single<RestuarntListResponse> getVendorsByPolygons(@Path("version") int i11, @NotNull @Path("latitude") String str, @NotNull @Path("longitude") String str2, @Header("DynamicWeightsVertical") int i12, @NotNull @Header("PersonalAPIExp_Variant") String str3, @Nullable @Header("external_experiments") String str4, @Nullable @Query(encoded = true, value = "verticalIds") String str5, @NotNull @Query("weightSet") String str6);
}
