package com.talabat.feature.mission.control.data.remote;

import com.talabat.feature.mission.control.data.remote.model.LifeStyleMissionControlResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001JM\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005H§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/LifeStyleMissionControlApi;", "", "getLifeStyleMissionControls", "Lcom/talabat/feature/mission/control/data/remote/model/LifeStyleMissionControlResponse;", "countryCode", "", "variant", "screen", "vendorId", "isDarkstore", "", "talabatBranchId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LifeStyleMissionControlApi {
    @Nullable
    @GET("v1/{country_code}/missions/lifestyle")
    Object getLifeStyleMissionControls(@NotNull @Path("country_code") String str, @NotNull @Query("variant") String str2, @NotNull @Query("screen") String str3, @NotNull @Query("vendor_id") String str4, @Query("is_darkstore") boolean z11, @NotNull @Query("talabatBranchId") String str5, @NotNull Continuation<? super LifeStyleMissionControlResponse> continuation);
}
