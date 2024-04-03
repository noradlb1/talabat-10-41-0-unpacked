package com.talabat.feature.rewards.domain.model;

import com.squareup.moshi.Json;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J,\u0010\u000e\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0003\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/talabat/feature/rewards/domain/model/MissionScope;", "", "country", "", "verticals", "", "(Ljava/lang/Integer;Ljava/util/List;)V", "getCountry", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVerticals", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/talabat/feature/rewards/domain/model/MissionScope;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_feature_rewards_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionScope {
    @Nullable
    private final Integer country;
    @Nullable
    private final List<Integer> verticals;

    public MissionScope() {
        this((Integer) null, (List) null, 3, (DefaultConstructorMarker) null);
    }

    public MissionScope(@Nullable @Json(name = "country") Integer num, @Nullable @Json(name = "verticals") List<Integer> list) {
        this.country = num;
        this.verticals = list;
    }

    public static /* synthetic */ MissionScope copy$default(MissionScope missionScope, Integer num, List<Integer> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = missionScope.country;
        }
        if ((i11 & 2) != 0) {
            list = missionScope.verticals;
        }
        return missionScope.copy(num, list);
    }

    @Nullable
    public final Integer component1() {
        return this.country;
    }

    @Nullable
    public final List<Integer> component2() {
        return this.verticals;
    }

    @NotNull
    public final MissionScope copy(@Nullable @Json(name = "country") Integer num, @Nullable @Json(name = "verticals") List<Integer> list) {
        return new MissionScope(num, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionScope)) {
            return false;
        }
        MissionScope missionScope = (MissionScope) obj;
        return Intrinsics.areEqual((Object) this.country, (Object) missionScope.country) && Intrinsics.areEqual((Object) this.verticals, (Object) missionScope.verticals);
    }

    @Nullable
    public final Integer getCountry() {
        return this.country;
    }

    @Nullable
    public final List<Integer> getVerticals() {
        return this.verticals;
    }

    public int hashCode() {
        Integer num = this.country;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<Integer> list = this.verticals;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.country;
        List<Integer> list = this.verticals;
        return "MissionScope(country=" + num + ", verticals=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MissionScope(Integer num, List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : list);
    }
}
