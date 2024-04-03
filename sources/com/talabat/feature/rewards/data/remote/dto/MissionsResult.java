package com.talabat.feature.rewards.data.remote.dto;

import com.squareup.moshi.Json;
import com.talabat.feature.rewards.domain.model.Mission;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/rewards/data/remote/dto/MissionsResult;", "", "data", "", "Lcom/talabat/feature/rewards/domain/model/Mission;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionsResult {
    @Nullable
    private final List<Mission> data;

    public MissionsResult() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public MissionsResult(@Nullable @Json(name = "data") List<Mission> list) {
        this.data = list;
    }

    public static /* synthetic */ MissionsResult copy$default(MissionsResult missionsResult, List<Mission> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = missionsResult.data;
        }
        return missionsResult.copy(list);
    }

    @Nullable
    public final List<Mission> component1() {
        return this.data;
    }

    @NotNull
    public final MissionsResult copy(@Nullable @Json(name = "data") List<Mission> list) {
        return new MissionsResult(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MissionsResult) && Intrinsics.areEqual((Object) this.data, (Object) ((MissionsResult) obj).data);
    }

    @Nullable
    public final List<Mission> getData() {
        return this.data;
    }

    public int hashCode() {
        List<Mission> list = this.data;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<Mission> list = this.data;
        return "MissionsResult(data=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissionsResult(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
