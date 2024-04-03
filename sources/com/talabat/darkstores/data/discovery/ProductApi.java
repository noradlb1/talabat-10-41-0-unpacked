package com.talabat.darkstores.data.discovery;

import com.talabat.darkstores.data.discovery.model.PastOrdersResponse;
import com.talabat.darkstores.data.discovery.model.ProductListingResponse;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0016\b\u0001\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\bH'J@\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u0006H'J@\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u0006H'¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/data/discovery/ProductApi;", "", "getPastOrders", "Lio/reactivex/Single;", "Lcom/talabat/darkstores/data/discovery/model/PastOrdersResponse;", "vendorId", "", "parameters", "", "getProductDetails", "Lcom/talabat/darkstores/data/discovery/model/ProductListingResponse;", "id", "brand", "countryCode", "language", "getProductDetailsBySku", "sku", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ProductApi {
    @NotNull
    @GET("v1/vendors/{vendor_id}/past-orders")
    Single<PastOrdersResponse> getPastOrders(@NotNull @Path("vendor_id") String str, @NotNull @QueryMap Map<String, String> map);

    @NotNull
    @GET("v1/vendors/{vendor_id}/products/{product_id}")
    Single<ProductListingResponse> getProductDetails(@NotNull @Path("vendor_id") String str, @NotNull @Path("product_id") String str2, @NotNull @Query("brand") String str3, @NotNull @Query("country_code") String str4, @NotNull @Query("language_code") String str5);

    @NotNull
    @GET("v1/vendors/{vendor_id}/products")
    Single<ProductListingResponse> getProductDetailsBySku(@NotNull @Path("vendor_id") String str, @NotNull @Query("sku") String str2, @NotNull @Query("brand") String str3, @NotNull @Query("country_code") String str4, @NotNull @Query("language_code") String str5);
}
