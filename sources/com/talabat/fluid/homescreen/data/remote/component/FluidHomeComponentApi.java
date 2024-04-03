package com.talabat.fluid.homescreen.data.remote.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001Jk\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/fluid/homescreen/data/remote/component/FluidHomeComponentApi;", "", "fetchFluidHomeComponent", "Lcom/talabat/fluid/homescreen/data/remote/component/ContentApiResponse;", "externalUserId", "", "voucher", "campaignName", "externalExperiments", "deviceWidthInDP", "countryCode", "latitude", "", "longitude", "areaId", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DDILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FluidHomeComponentApi {
    @Nullable
    @GET("/home/v1/{country_code}/content")
    Object fetchFluidHomeComponent(@NotNull @Header("external-user-id") String str, @NotNull @Header("voucher") String str2, @NotNull @Header("voucher-campaign") String str3, @NotNull @Header("external_experiments") String str4, @NotNull @Header("X-Device-Width") String str5, @NotNull @Path("country_code") String str6, @Query("lat") double d11, @Query("lon") double d12, @Query("area_id") int i11, @NotNull Continuation<? super ContentApiResponse> continuation);
}
