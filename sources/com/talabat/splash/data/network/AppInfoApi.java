package com.talabat.splash.data.network;

import com.talabat.splash.domain.entity.AppInitRootEntity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H'¨\u0006\u0007"}, d2 = {"Lcom/talabat/splash/data/network/AppInfoApi;", "", "getAppInfo", "Lretrofit2/Call;", "Lcom/talabat/splash/domain/entity/AppInitRootEntity;", "countryId", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AppInfoApi {
    @NotNull
    @GET("v2/apps/appinfo/{countryId}")
    Call<AppInitRootEntity> getAppInfo(@NotNull @Path("countryId") String str);
}
