package com.talabat.talabatcommon.feature.darkstores.lookingGlass.network;

import com.talabat.talabatcommon.feature.darkstores.lookingGlass.model.response.LookingGlassResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\u000b\u001a\u00020\t2\b\b\u0001\u0010\f\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u0006H'¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/network/LookingGlassApi;", "", "getGlassData", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/darkstores/lookingGlass/model/response/LookingGlassResponse;", "countryId", "", "areaId", "productTag", "", "lat", "lng", "limit", "offset", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LookingGlassApi {
    @NotNull
    @GET("v1/lookingglass")
    Call<LookingGlassResponse> getGlassData(@Query("countryId") int i11, @Query("areaId") int i12, @NotNull @Query("productTag") String str, @NotNull @Query("latitude") String str2, @NotNull @Query("longitude") String str3, @Query("limit") int i13, @Query("offset") int i14);
}
