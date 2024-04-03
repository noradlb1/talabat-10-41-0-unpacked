package com.talabat.feature.mission.control.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponse;", "", "result", "Lcom/talabat/feature/mission/control/data/remote/model/Result;", "(Lcom/talabat/feature/mission/control/data/remote/model/Result;)V", "getResult", "()Lcom/talabat/feature/mission/control/data/remote/model/Result;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrimaryMissionControlResponse {
    @Nullable
    private final Result result;

    public PrimaryMissionControlResponse(@Nullable @Json(name = "result") Result result2) {
        this.result = result2;
    }

    public static /* synthetic */ PrimaryMissionControlResponse copy$default(PrimaryMissionControlResponse primaryMissionControlResponse, Result result2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            result2 = primaryMissionControlResponse.result;
        }
        return primaryMissionControlResponse.copy(result2);
    }

    @Nullable
    public final Result component1() {
        return this.result;
    }

    @NotNull
    public final PrimaryMissionControlResponse copy(@Nullable @Json(name = "result") Result result2) {
        return new PrimaryMissionControlResponse(result2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PrimaryMissionControlResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((PrimaryMissionControlResponse) obj).result);
    }

    @Nullable
    public final Result getResult() {
        return this.result;
    }

    public int hashCode() {
        Result result2 = this.result;
        if (result2 == null) {
            return 0;
        }
        return result2.hashCode();
    }

    @NotNull
    public String toString() {
        Result result2 = this.result;
        return "PrimaryMissionControlResponse(result=" + result2 + ")";
    }
}
