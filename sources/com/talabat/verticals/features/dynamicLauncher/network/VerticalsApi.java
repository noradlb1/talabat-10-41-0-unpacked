package com.talabat.verticals.features.dynamicLauncher.network;

import com.talabat.verticals.features.dynamicLauncher.model.response.VerticalsResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH'¨\u0006\n"}, d2 = {"Lcom/talabat/verticals/features/dynamicLauncher/network/VerticalsApi;", "", "getVerticals", "Lretrofit2/Call;", "Lcom/talabat/verticals/features/dynamicLauncher/model/response/VerticalsResponse;", "countryId", "", "lat", "", "lng", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface VerticalsApi {
    @NotNull
    @GET("/api/v2/verticals")
    Call<VerticalsResponse> getVerticals(@Query("countryId") int i11, @NotNull @Query("latitude") String str, @NotNull @Query("longitude") String str2);
}
