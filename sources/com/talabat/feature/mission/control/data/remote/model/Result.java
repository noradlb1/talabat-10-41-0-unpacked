package com.talabat.feature.mission.control.data.remote.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0001\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/mission/control/data/remote/model/Result;", "", "missions", "", "Lcom/talabat/feature/mission/control/data/remote/model/PrimaryMissionControlResponseData;", "(Ljava/util/List;)V", "getMissions", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_mission-control_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Result {
    @Nullable
    private final List<PrimaryMissionControlResponseData> missions;

    public Result(@Nullable @Json(name = "missions") List<PrimaryMissionControlResponseData> list) {
        this.missions = list;
    }

    public static /* synthetic */ Result copy$default(Result result, List<PrimaryMissionControlResponseData> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = result.missions;
        }
        return result.copy(list);
    }

    @Nullable
    public final List<PrimaryMissionControlResponseData> component1() {
        return this.missions;
    }

    @NotNull
    public final Result copy(@Nullable @Json(name = "missions") List<PrimaryMissionControlResponseData> list) {
        return new Result(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Result) && Intrinsics.areEqual((Object) this.missions, (Object) ((Result) obj).missions);
    }

    @Nullable
    public final List<PrimaryMissionControlResponseData> getMissions() {
        return this.missions;
    }

    public int hashCode() {
        List<PrimaryMissionControlResponseData> list = this.missions;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<PrimaryMissionControlResponseData> list = this.missions;
        return "Result(missions=" + list + ")";
    }
}
