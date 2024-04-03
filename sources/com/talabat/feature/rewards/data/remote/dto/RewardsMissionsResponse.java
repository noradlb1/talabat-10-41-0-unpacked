package com.talabat.feature.rewards.data.remote.dto;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/rewards/data/remote/dto/RewardsMissionsResponse;", "", "result", "Lcom/talabat/feature/rewards/data/remote/dto/MissionsResult;", "(Lcom/talabat/feature/rewards/data/remote/dto/MissionsResult;)V", "getResult", "()Lcom/talabat/feature/rewards/data/remote/dto/MissionsResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RewardsMissionsResponse {
    @Nullable
    private final MissionsResult result;

    public RewardsMissionsResponse() {
        this((MissionsResult) null, 1, (DefaultConstructorMarker) null);
    }

    public RewardsMissionsResponse(@Nullable @Json(name = "result") MissionsResult missionsResult) {
        this.result = missionsResult;
    }

    public static /* synthetic */ RewardsMissionsResponse copy$default(RewardsMissionsResponse rewardsMissionsResponse, MissionsResult missionsResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            missionsResult = rewardsMissionsResponse.result;
        }
        return rewardsMissionsResponse.copy(missionsResult);
    }

    @Nullable
    public final MissionsResult component1() {
        return this.result;
    }

    @NotNull
    public final RewardsMissionsResponse copy(@Nullable @Json(name = "result") MissionsResult missionsResult) {
        return new RewardsMissionsResponse(missionsResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RewardsMissionsResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((RewardsMissionsResponse) obj).result);
    }

    @Nullable
    public final MissionsResult getResult() {
        return this.result;
    }

    public int hashCode() {
        MissionsResult missionsResult = this.result;
        if (missionsResult == null) {
            return 0;
        }
        return missionsResult.hashCode();
    }

    @NotNull
    public String toString() {
        MissionsResult missionsResult = this.result;
        return "RewardsMissionsResponse(result=" + missionsResult + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RewardsMissionsResponse(MissionsResult missionsResult, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : missionsResult);
    }
}
