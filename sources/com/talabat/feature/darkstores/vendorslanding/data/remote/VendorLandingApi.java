package com.talabat.feature.darkstores.vendorslanding.data.remote;

import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponse;
import com.talabat.feature.darkstores.vendorslanding.data.model.VendorLandingResponseV2;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J6\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\nH'J@\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u0006H'¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/darkstores/vendorslanding/data/remote/VendorLandingApi;", "", "getVendor", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponse;", "countryCode", "", "vendorId", "talabatBranchId", "isDarkstore", "", "getVendorV2", "Lcom/talabat/feature/darkstores/vendorslanding/data/model/VendorLandingResponseV2;", "vendorCode", "latitude", "longitude", "com_talabat_feature_darkstores-vendor-landing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VendorLandingApi {
    @NotNull
    @GET("v1/{country_code}/pages/vendors/{vendor_id}/home")
    Single<VendorLandingResponse> getVendor(@NotNull @Path("country_code") String str, @NotNull @Path("vendor_id") String str2, @NotNull @Query("talabatBranchId") String str3, @Query("isDarkstore") boolean z11);

    @NotNull
    @GET("v2/{country_code}/pages/vendors/{vendor_code}/home")
    Single<VendorLandingResponseV2> getVendorV2(@NotNull @Path("country_code") String str, @NotNull @Path("vendor_code") String str2, @Query("isDarkstore") boolean z11, @NotNull @Query("lat") String str3, @NotNull @Query("lon") String str4);
}
