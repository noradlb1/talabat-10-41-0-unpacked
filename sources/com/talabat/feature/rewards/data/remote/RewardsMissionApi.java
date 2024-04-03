package com.talabat.feature.rewards.data.remote;

import com.talabat.feature.rewards.data.remote.dto.ClaimMissionRewardResponse;
import com.talabat.feature.rewards.data.remote.dto.RewardsMissionsResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J1\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ1\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ=\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\r\u001a\u00020\u00052\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/rewards/data/remote/RewardsMissionApi;", "", "acceptMission", "Lcom/talabat/feature/rewards/data/remote/dto/ClaimMissionRewardResponse;", "countryId", "", "missionId", "screen", "", "(IILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "claimMissionReward", "getMissions", "Lcom/talabat/feature/rewards/data/remote/dto/RewardsMissionsResponse;", "countryCode", "chainId", "(IILjava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RewardsMissionApi {
    @NotNull
    @Deprecated
    public static final String API = "api";
    @NotNull
    @Deprecated
    public static final String CHAIN_ID = "chain_id";
    @NotNull
    @Deprecated
    public static final String CLAIM_REWARD = "claim-reward";
    @NotNull
    @Deprecated
    public static final String COUNTRY = "Country";
    @NotNull
    @Deprecated
    public static final String COUNTRY_CODE = "countrycode";
    public static final /* synthetic */ Companion Companion = Companion.f58749a;
    @NotNull
    @Deprecated
    public static final String MISSIONS = "missions";
    @NotNull
    @Deprecated
    public static final String MISSIONS_ACCEPT_URL = "api/v3/missions/{missionId}/opt-in";
    @NotNull
    @Deprecated
    public static final String MISSIONS_CLAIM_REWARD_URL = "api/v3/missions/{missionId}/claim-reward";
    @NotNull
    @Deprecated
    public static final String MISSIONS_URL = "api/v3/missions";
    @NotNull
    @Deprecated
    public static final String MISSION_ID = "missionId";
    @NotNull
    @Deprecated
    public static final String OPT_IN = "opt-in";
    @NotNull
    @Deprecated
    public static final String SCREEN = "screen";
    @NotNull
    @Deprecated
    public static final String V3 = "v3";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/rewards/data/remote/RewardsMissionApi$Companion;", "", "()V", "API", "", "CHAIN_ID", "CLAIM_REWARD", "COUNTRY", "COUNTRY_CODE", "MISSIONS", "MISSIONS_ACCEPT_URL", "MISSIONS_CLAIM_REWARD_URL", "MISSIONS_URL", "MISSION_ID", "OPT_IN", "SCREEN", "V3", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        @NotNull
        public static final String API = "api";
        @NotNull
        public static final String CHAIN_ID = "chain_id";
        @NotNull
        public static final String CLAIM_REWARD = "claim-reward";
        @NotNull
        public static final String COUNTRY = "Country";
        @NotNull
        public static final String COUNTRY_CODE = "countrycode";
        @NotNull
        public static final String MISSIONS = "missions";
        @NotNull
        public static final String MISSIONS_ACCEPT_URL = "api/v3/missions/{missionId}/opt-in";
        @NotNull
        public static final String MISSIONS_CLAIM_REWARD_URL = "api/v3/missions/{missionId}/claim-reward";
        @NotNull
        public static final String MISSIONS_URL = "api/v3/missions";
        @NotNull
        public static final String MISSION_ID = "missionId";
        @NotNull
        public static final String OPT_IN = "opt-in";
        @NotNull
        public static final String SCREEN = "screen";
        @NotNull
        public static final String V3 = "v3";

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f58749a = new Companion();

        private Companion() {
        }
    }

    @POST("api/v3/missions/{missionId}/opt-in")
    @Nullable
    Object acceptMission(@Header("Country") int i11, @Path("missionId") int i12, @Nullable @Query("screen") String str, @NotNull Continuation<? super ClaimMissionRewardResponse> continuation);

    @POST("api/v3/missions/{missionId}/claim-reward")
    @Nullable
    Object claimMissionReward(@Header("Country") int i11, @Path("missionId") int i12, @Nullable @Query("screen") String str, @NotNull Continuation<? super ClaimMissionRewardResponse> continuation);

    @Nullable
    @GET("api/v3/missions")
    Object getMissions(@Header("Country") int i11, @Query("countrycode") int i12, @Nullable @Query("chain_id") Integer num, @Nullable @Query("screen") String str, @NotNull Continuation<? super RewardsMissionsResponse> continuation);
}
