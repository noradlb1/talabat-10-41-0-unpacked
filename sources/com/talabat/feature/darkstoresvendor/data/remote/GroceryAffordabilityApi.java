package com.talabat.feature.darkstoresvendor.data.remote;

import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\nH'¨\u0006\f"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/remote/GroceryAffordabilityApi;", "", "getVendorInfo", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "customerId", "", "vendorCode", "globalEntityId", "latitude", "", "longitude", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface GroceryAffordabilityApi {
    @NotNull
    @GET("api/v1/vendor-info/{id}")
    Single<VendorResponse> getVendorInfo(@NotNull @Header("x-customer-id") String str, @NotNull @Path("id") String str2, @NotNull @Query("ge_id") String str3, @Query("lat") double d11, @Query("lon") double d12);
}
