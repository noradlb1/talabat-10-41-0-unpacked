package com.talabat.feature.fees.data.remote;

import com.talabat.feature.fees.data.remote.dto.FeesResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Jg\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\u000b2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0001\u0010\u000f\u001a\u0004\u0018\u00010\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/fees/data/remote/PricingApi;", "", "getFees", "Lcom/talabat/feature/fees/data/remote/dto/FeesResponse;", "vendorId", "", "countryId", "latitude", "", "longitude", "deliveryMode", "", "subtotalBeforeDiscounts", "", "subtotal", "couponDiscount", "(IIDDLjava/lang/String;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PricingApi {
    @Nullable
    @GET("/restaurantapi/v1/vendors/{vendorId}/fees")
    Object getFees(@Path("vendorId") int i11, @Query("countryId") int i12, @Query("latitude") double d11, @Query("longitude") double d12, @NotNull @Query("deliveryMode") String str, @Nullable @Query("subtotal") Float f11, @Nullable @Query("subtotalAfterItemDiscounts") Float f12, @Nullable @Query("couponDiscount") Float f13, @NotNull Continuation<? super FeesResponse> continuation);
}
