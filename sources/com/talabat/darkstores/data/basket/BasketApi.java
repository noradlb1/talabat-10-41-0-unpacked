package com.talabat.darkstores.data.basket;

import com.talabat.darkstores.data.basket.model.SwimlaneResponse;
import com.talabat.darkstores.data.darkstores.model.CartRequestByCartId;
import com.talabat.darkstores.data.darkstores.model.CartRequestByVendorId;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import io.reactivex.Single;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0006H'J.\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\b\b\u0001\u0010\u0010\u001a\u00020\u00062\u0014\b\u0001\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0012H'Jr\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u00062\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0015\u001a\u00020\u00062\b\b\u0001\u0010\u0016\u001a\u00020\u00172\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u00192\b\b\u0001\u0010\u001a\u001a\u00020\u0017H'J\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0018\u001a\u00020\u001cH'¨\u0006\u001d"}, d2 = {"Lcom/talabat/darkstores/data/basket/BasketApi;", "", "getCart", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "customerId", "", "platformVendorId", "globalVendorId", "globalEntityId", "latitude", "", "longitude", "deliveryType", "getSwimlane", "Lcom/talabat/darkstores/data/basket/model/SwimlaneResponse;", "vendorId", "parameters", "", "postCartByCartId", "cartId", "locale", "autoAdd", "", "cartRequest", "Lcom/talabat/darkstores/data/darkstores/model/CartRequestByCartId;", "enableBasketBasedDeliveryFee", "postCartByVendorId", "Lcom/talabat/darkstores/data/darkstores/model/CartRequestByVendorId;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BasketApi {
    @NotNull
    @GET("v2/cart")
    Single<CartResponse> getCart(@NotNull @Header("x-customer-id") String str, @NotNull @Query("platform_vendor_id") String str2, @NotNull @Query("global_vendor_id") String str3, @NotNull @Query("ge_id") String str4, @Query("lat") double d11, @Query("lon") double d12, @NotNull @Query("delivery_type") String str5);

    @NotNull
    @GET("v1/swimlane/{vendor_id}")
    Single<SwimlaneResponse> getSwimlane(@NotNull @Path("vendor_id") String str, @NotNull @QueryMap Map<String, String> map);

    @NotNull
    @POST("v2/cart/{cart_id}")
    @Deprecated(message = "Use postCartByVendorId")
    Single<CartResponse> postCartByCartId(@NotNull @Path("cart_id") String str, @NotNull @Header("x-customer-id") String str2, @NotNull @Query("locale") String str3, @Query("auto_add") boolean z11, @Query("lat") double d11, @Query("lon") double d12, @NotNull @Query("vendor-id") String str4, @NotNull @Query("delivery_type") String str5, @NotNull @Body CartRequestByCartId cartRequestByCartId, @Query("enableBasketBasedDeliveryFee") boolean z12);

    @NotNull
    @POST("v2/cart")
    Single<CartResponse> postCartByVendorId(@NotNull @Header("x-customer-id") String str, @NotNull @Body CartRequestByVendorId cartRequestByVendorId);
}
