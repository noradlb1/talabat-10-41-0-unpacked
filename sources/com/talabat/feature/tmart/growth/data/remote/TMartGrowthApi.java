package com.talabat.feature.tmart.growth.data.remote;

import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimRequest;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthClaimResponse;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthReminderResponse;
import com.talabat.feature.tmart.growth.data.remote.model.TMartGrowthVoucherResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\bJ9\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010JC\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0013\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014JC\u0010\u0015\u001a\u00020\n2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0016\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/tmart/growth/data/remote/TMartGrowthApi;", "", "claimVoucher", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimResponse;", "countryCode", "", "claimRequest", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimRequest;", "(Ljava/lang/String;Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthClaimRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBasicWidgetData", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthVoucherResponse;", "areaId", "", "latitude", "", "longitude", "(Ljava/lang/String;IDDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getVoucherReminder", "Lcom/talabat/feature/tmart/growth/data/remote/model/TMartGrowthReminderResponse;", "screenType", "(Ljava/lang/String;IDDLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWidgetData", "voucherId", "com_talabat_feature_tmartGrowth_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TMartGrowthApi {
    @POST("v1/{country_code}/growth-widget")
    @Nullable
    Object claimVoucher(@NotNull @Path("country_code") String str, @NotNull @Body TMartGrowthClaimRequest tMartGrowthClaimRequest, @NotNull Continuation<? super TMartGrowthClaimResponse> continuation);

    @Nullable
    @GET("v1/{country_code}/reminder-widget-basic/{area_id}/{lat}/{lon}")
    Object getBasicWidgetData(@NotNull @Path("country_code") String str, @Path("area_id") int i11, @Path("lat") double d11, @Path("lon") double d12, @NotNull Continuation<? super TMartGrowthVoucherResponse> continuation);

    @Nullable
    @GET("v1/{country_code}/reminder-widget")
    Object getVoucherReminder(@NotNull @Path("country_code") String str, @Query("area_id") int i11, @Query("lat") double d11, @Query("lon") double d12, @NotNull @Query("screen") String str2, @NotNull Continuation<? super TMartGrowthReminderResponse> continuation);

    @Nullable
    @GET("v1/{country_code}/growth-widget/{area_id}/{lat}/{lon}/{voucher_option_id}")
    Object getWidgetData(@NotNull @Path("country_code") String str, @Path("area_id") int i11, @Path("lat") double d11, @Path("lon") double d12, @NotNull @Path("voucher_option_id") String str2, @NotNull Continuation<? super TMartGrowthVoucherResponse> continuation);
}
