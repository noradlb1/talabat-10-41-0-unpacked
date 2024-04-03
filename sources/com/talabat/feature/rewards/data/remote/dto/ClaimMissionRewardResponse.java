package com.talabat.feature.rewards.data.remote.dto;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0003\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0004HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/feature/rewards/data/remote/dto/ClaimMissionRewardResponse;", "", "errors", "", "", "(Ljava/util/List;)V", "getErrors", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_rewards_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ClaimMissionRewardResponse {
    @Nullable
    private final List<String> errors;

    public ClaimMissionRewardResponse() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public ClaimMissionRewardResponse(@Nullable @Json(name = "errors") List<String> list) {
        this.errors = list;
    }

    public static /* synthetic */ ClaimMissionRewardResponse copy$default(ClaimMissionRewardResponse claimMissionRewardResponse, List<String> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = claimMissionRewardResponse.errors;
        }
        return claimMissionRewardResponse.copy(list);
    }

    @Nullable
    public final List<String> component1() {
        return this.errors;
    }

    @NotNull
    public final ClaimMissionRewardResponse copy(@Nullable @Json(name = "errors") List<String> list) {
        return new ClaimMissionRewardResponse(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClaimMissionRewardResponse) && Intrinsics.areEqual((Object) this.errors, (Object) ((ClaimMissionRewardResponse) obj).errors);
    }

    @Nullable
    public final List<String> getErrors() {
        return this.errors;
    }

    public int hashCode() {
        List<String> list = this.errors;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        List<String> list = this.errors;
        return "ClaimMissionRewardResponse(errors=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ClaimMissionRewardResponse(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }
}
