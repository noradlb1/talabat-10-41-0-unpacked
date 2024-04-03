package com.talabat.feature.rating.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/talabat/feature/rating/domain/model/DashboardOrderResponse;", "", "timestamp", "", "result", "Lcom/talabat/feature/rating/domain/model/DashboardOrderList;", "baseUrl", "(Ljava/lang/String;Lcom/talabat/feature/rating/domain/model/DashboardOrderList;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getResult", "()Lcom/talabat/feature/rating/domain/model/DashboardOrderList;", "getTimestamp", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DashboardOrderResponse {
    @Nullable
    private final String baseUrl;
    @NotNull
    private final DashboardOrderList result;
    @Nullable
    private final String timestamp;

    public DashboardOrderResponse(@Nullable String str, @NotNull DashboardOrderList dashboardOrderList, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(dashboardOrderList, "result");
        this.timestamp = str;
        this.result = dashboardOrderList;
        this.baseUrl = str2;
    }

    public static /* synthetic */ DashboardOrderResponse copy$default(DashboardOrderResponse dashboardOrderResponse, String str, DashboardOrderList dashboardOrderList, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = dashboardOrderResponse.timestamp;
        }
        if ((i11 & 2) != 0) {
            dashboardOrderList = dashboardOrderResponse.result;
        }
        if ((i11 & 4) != 0) {
            str2 = dashboardOrderResponse.baseUrl;
        }
        return dashboardOrderResponse.copy(str, dashboardOrderList, str2);
    }

    @Nullable
    public final String component1() {
        return this.timestamp;
    }

    @NotNull
    public final DashboardOrderList component2() {
        return this.result;
    }

    @Nullable
    public final String component3() {
        return this.baseUrl;
    }

    @NotNull
    public final DashboardOrderResponse copy(@Nullable String str, @NotNull DashboardOrderList dashboardOrderList, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(dashboardOrderList, "result");
        return new DashboardOrderResponse(str, dashboardOrderList, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DashboardOrderResponse)) {
            return false;
        }
        DashboardOrderResponse dashboardOrderResponse = (DashboardOrderResponse) obj;
        return Intrinsics.areEqual((Object) this.timestamp, (Object) dashboardOrderResponse.timestamp) && Intrinsics.areEqual((Object) this.result, (Object) dashboardOrderResponse.result) && Intrinsics.areEqual((Object) this.baseUrl, (Object) dashboardOrderResponse.baseUrl);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final DashboardOrderList getResult() {
        return this.result;
    }

    @Nullable
    public final String getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        String str = this.timestamp;
        int i11 = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.result.hashCode()) * 31;
        String str2 = this.baseUrl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        String str = this.timestamp;
        DashboardOrderList dashboardOrderList = this.result;
        String str2 = this.baseUrl;
        return "DashboardOrderResponse(timestamp=" + str + ", result=" + dashboardOrderList + ", baseUrl=" + str2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DashboardOrderResponse(String str, DashboardOrderList dashboardOrderList, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, dashboardOrderList, (i11 & 4) != 0 ? null : str2);
    }
}
