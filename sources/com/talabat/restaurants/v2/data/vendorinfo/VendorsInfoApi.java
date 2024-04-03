package com.talabat.restaurants.v2.data.vendorinfo;

import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import library.talabat.com.talabatlib.RestuarntListResponse;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH'¨\u0006\f"}, d2 = {"Lcom/talabat/restaurants/v2/data/vendorinfo/VendorsInfoApi;", "", "getVendorsInfo", "Lio/reactivex/Single;", "Llibrary/talabat/com/talabatlib/RestuarntListResponse;", "apiVersion", "", "latitude", "", "longitude", "verticalIds", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorsInfoApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getVendorsInfo$default(VendorsInfoApi vendorsInfoApi, int i11, String str, String str2, List list, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 1) != 0) {
                    i11 = 1;
                }
                return vendorsInfoApi.getVendorsInfo(i11, str, str2, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getVendorsInfo");
        }
    }

    @NotNull
    @GET("/restaurantapi/v{version}/vendortags")
    Single<RestuarntListResponse> getVendorsInfo(@Path("version") int i11, @NotNull @Query("latitude") String str, @NotNull @Query("longitude") String str2, @NotNull @Query("verticalIds") List<Integer> list);
}
