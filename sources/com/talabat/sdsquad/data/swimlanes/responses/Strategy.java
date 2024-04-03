package com.talabat.sdsquad.data.swimlanes.responses;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/sdsquad/data/swimlanes/responses/Strategy;", "", "recommendationStrategy", "", "requestId", "userId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getRecommendationStrategy", "()Ljava/lang/String;", "getRequestId", "getUserId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Strategy {
    @SerializedName("recommendation_strategy")
    @Nullable
    private final String recommendationStrategy;
    @SerializedName("request_id")
    @Nullable
    private final String requestId;
    @SerializedName("user_id")
    @Nullable
    private final String userId;

    public Strategy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.recommendationStrategy = str;
        this.requestId = str2;
        this.userId = str3;
    }

    public static /* synthetic */ Strategy copy$default(Strategy strategy, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = strategy.recommendationStrategy;
        }
        if ((i11 & 2) != 0) {
            str2 = strategy.requestId;
        }
        if ((i11 & 4) != 0) {
            str3 = strategy.userId;
        }
        return strategy.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.recommendationStrategy;
    }

    @Nullable
    public final String component2() {
        return this.requestId;
    }

    @Nullable
    public final String component3() {
        return this.userId;
    }

    @NotNull
    public final Strategy copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new Strategy(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return Intrinsics.areEqual((Object) this.recommendationStrategy, (Object) strategy.recommendationStrategy) && Intrinsics.areEqual((Object) this.requestId, (Object) strategy.requestId) && Intrinsics.areEqual((Object) this.userId, (Object) strategy.userId);
    }

    @Nullable
    public final String getRecommendationStrategy() {
        return this.recommendationStrategy;
    }

    @Nullable
    public final String getRequestId() {
        return this.requestId;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    public int hashCode() {
        String str = this.recommendationStrategy;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.requestId;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.userId;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.recommendationStrategy;
        String str2 = this.requestId;
        String str3 = this.userId;
        return "Strategy(recommendationStrategy=" + str + ", requestId=" + str2 + ", userId=" + str3 + ")";
    }
}
