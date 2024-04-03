package com.talabat.feature.pickup.data;

import com.talabat.feature.pickup.data.entity.PickupVendorDto;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\\\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\b2\b\b\u0003\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\f\u001a\u00020\u00062\u0010\b\u0001\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000eH'¨\u0006\u000f"}, d2 = {"Lcom/talabat/feature/pickup/data/PickupApi;", "", "getPickupVendors", "Lio/reactivex/Single;", "Lcom/talabat/feature/pickup/data/entity/PickupVendorDto;", "version", "", "userCountry", "", "lat", "lon", "radius", "pageNumber", "cuisineIds", "", "com_talabat_feature_pickup_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PickupApi {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ Single getPickupVendors$default(PickupApi pickupApi, int i11, String str, String str2, String str3, String str4, int i12, List list, int i13, Object obj) {
            int i14;
            String str5;
            if (obj == null) {
                if ((i13 & 1) != 0) {
                    i14 = 1;
                } else {
                    i14 = i11;
                }
                if ((i13 & 16) != 0) {
                    str5 = "10";
                } else {
                    str5 = str4;
                }
                return pickupApi.getPickupVendors(i14, str, str2, str3, str5, i12, list);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPickupVendors");
        }
    }

    @NotNull
    @GET("/pickup/v{version}/{country_code}/vendors")
    Single<PickupVendorDto> getPickupVendors(@Path("version") int i11, @NotNull @Path("country_code") String str, @NotNull @Query("lat") String str2, @NotNull @Query("lon") String str3, @NotNull @Query("radius") String str4, @Query("page_no") int i12, @Nullable @Query("cuisine_id") List<Integer> list);
}
