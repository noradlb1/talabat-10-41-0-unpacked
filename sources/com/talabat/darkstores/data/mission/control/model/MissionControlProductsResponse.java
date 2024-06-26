package com.talabat.darkstores.data.mission.control.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResponse;", "", "result", "Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResult;", "(Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResult;)V", "getResult", "()Lcom/talabat/darkstores/data/mission/control/model/MissionControlProductsResult;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionControlProductsResponse {
    @NotNull
    private final MissionControlProductsResult result;

    public MissionControlProductsResponse(@NotNull @Json(name = "result") MissionControlProductsResult missionControlProductsResult) {
        Intrinsics.checkNotNullParameter(missionControlProductsResult, "result");
        this.result = missionControlProductsResult;
    }

    public static /* synthetic */ MissionControlProductsResponse copy$default(MissionControlProductsResponse missionControlProductsResponse, MissionControlProductsResult missionControlProductsResult, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            missionControlProductsResult = missionControlProductsResponse.result;
        }
        return missionControlProductsResponse.copy(missionControlProductsResult);
    }

    @NotNull
    public final MissionControlProductsResult component1() {
        return this.result;
    }

    @NotNull
    public final MissionControlProductsResponse copy(@NotNull @Json(name = "result") MissionControlProductsResult missionControlProductsResult) {
        Intrinsics.checkNotNullParameter(missionControlProductsResult, "result");
        return new MissionControlProductsResponse(missionControlProductsResult);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MissionControlProductsResponse) && Intrinsics.areEqual((Object) this.result, (Object) ((MissionControlProductsResponse) obj).result);
    }

    @NotNull
    public final MissionControlProductsResult getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    @NotNull
    public String toString() {
        MissionControlProductsResult missionControlProductsResult = this.result;
        return "MissionControlProductsResponse(result=" + missionControlProductsResult + ")";
    }
}
