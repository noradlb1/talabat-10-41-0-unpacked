package com.talabat.feature.address.data.remote.api;

import io.reactivex.Completable;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'J\u0012\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\nH'J\u001b\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/address/data/remote/api/AddressApi;", "", "addAddress", "Lio/reactivex/Single;", "Lcom/talabat/feature/address/data/remote/api/AddAddressResponse;", "body", "Lcom/talabat/feature/address/data/remote/api/AddressBody;", "deleteAddress", "Lio/reactivex/Completable;", "id", "", "getCustomerAddressesFor", "Lcom/talabat/feature/address/data/remote/api/CustomerAddressesResponse;", "countryId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAddress", "Lcom/talabat/feature/address/data/remote/api/UpdateAddressResponse;", "com_talabat_feature_address_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AddressApi {
    @NotNull
    @POST("v2/user/addresses")
    Single<AddAddressResponse> addAddress(@NotNull @Body AddressBody addressBody);

    @NotNull
    @DELETE("v2/user/addresses/{id}")
    Completable deleteAddress(@NotNull @Path("id") String str);

    @Nullable
    @GET("v1/user/addresses")
    Object getCustomerAddressesFor(@Query("countryId") int i11, @NotNull Continuation<? super CustomerAddressesResponse> continuation);

    @NotNull
    @PUT("v2/user/addresses/{id}")
    Single<UpdateAddressResponse> updateAddress(@NotNull @Path("id") String str, @NotNull @Body AddressBody addressBody);
}
