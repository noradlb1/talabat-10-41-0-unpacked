package com.talabat.feature.rewards.domain.model;

import com.squareup.moshi.Json;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/talabat/feature/rewards/domain/model/MissionProgress;", "", "totalSteps", "", "completedSteps", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCompletedSteps", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalSteps", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/feature/rewards/domain/model/MissionProgress;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionProgress {
    @Nullable
    private final Integer completedSteps;
    @Nullable
    private final Integer totalSteps;

    public MissionProgress() {
        this((Integer) null, (Integer) null, 3, (DefaultConstructorMarker) null);
    }

    public MissionProgress(@Nullable @Json(name = "totalSteps") Integer num, @Nullable @Json(name = "completedSteps") Integer num2) {
        this.totalSteps = num;
        this.completedSteps = num2;
    }

    public static /* synthetic */ MissionProgress copy$default(MissionProgress missionProgress, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = missionProgress.totalSteps;
        }
        if ((i11 & 2) != 0) {
            num2 = missionProgress.completedSteps;
        }
        return missionProgress.copy(num, num2);
    }

    @Nullable
    public final Integer component1() {
        return this.totalSteps;
    }

    @Nullable
    public final Integer component2() {
        return this.completedSteps;
    }

    @NotNull
    public final MissionProgress copy(@Nullable @Json(name = "totalSteps") Integer num, @Nullable @Json(name = "completedSteps") Integer num2) {
        return new MissionProgress(num, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionProgress)) {
            return false;
        }
        MissionProgress missionProgress = (MissionProgress) obj;
        return Intrinsics.areEqual((Object) this.totalSteps, (Object) missionProgress.totalSteps) && Intrinsics.areEqual((Object) this.completedSteps, (Object) missionProgress.completedSteps);
    }

    @Nullable
    public final Integer getCompletedSteps() {
        return this.completedSteps;
    }

    @Nullable
    public final Integer getTotalSteps() {
        return this.totalSteps;
    }

    public int hashCode() {
        Integer num = this.totalSteps;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.completedSteps;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.totalSteps;
        Integer num2 = this.completedSteps;
        return "MissionProgress(totalSteps=" + num + ", completedSteps=" + num2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissionProgress(Integer num, Integer num2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : num2);
    }
}
