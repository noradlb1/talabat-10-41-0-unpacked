package com.talabat.feature.mission.control.data.remote;

import com.talabat.feature.mission.control.data.remote.model.PrimaryMissionControlResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\tH§@ø\u0001\u0000¢\u0006\u0002\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/PrimaryMissionControlApi;", "", "getPrimaryMissionControls", "Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponse;", "string", "", "vendorId", "talabatBranchId", "isDarkstore", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface PrimaryMissionControlApi {
    @Nullable
    @GET("v1/{country_code}/missions/primary")
    Object getPrimaryMissionControls(@NotNull @Path("country_code") String str, @NotNull @Query("vendorId") String str2, @NotNull @Query("talabatBranchId") String str3, @Query("isDarkstore") boolean z11, @NotNull Continuation<? super PrimaryMissionControlResponse> continuation);
}
