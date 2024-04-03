package com.talabat.feature.darkstorescartlist.data.remote;

import com.talabat.feature.darkstorescartlist.data.model.CartInfoListResponse;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/talabat/feature/darkstorescartlist/data/remote/CartListApi;", "", "getCartInfoList", "Lio/reactivex/Single;", "Lcom/talabat/feature/darkstorescartlist/data/model/CartInfoListResponse;", "customerId", "", "latitude", "", "longitude", "com_talabat_feature_darkstores-cart-list_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CartListApi {
    @NotNull
    @GET("v1/cart/summary")
    Single<CartInfoListResponse> getCartInfoList(@NotNull @Header("x-customer-id") String str, @Query("lat") double d11, @Query("lon") double d12);
}
