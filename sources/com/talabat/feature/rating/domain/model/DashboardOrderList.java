package com.talabat.feature.rating.domain.model;

import com.talabat.helpers.AppUrls;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/rating/domain/model/DashboardOrderList;", "", "orders", "", "Lcom/talabat/feature/rating/domain/model/DashboardOrder;", "baseUrl", "", "(Ljava/util/List;Ljava/lang/String;)V", "getBaseUrl", "()Ljava/lang/String;", "getOrders", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DashboardOrderList {
    @Nullable
    private final String baseUrl;
    @NotNull
    private final List<DashboardOrder> orders;

    public DashboardOrderList(@NotNull List<DashboardOrder> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, AppUrls.PLACEORDER_SEGMENT);
        this.orders = list;
        this.baseUrl = str;
    }

    public static /* synthetic */ DashboardOrderList copy$default(DashboardOrderList dashboardOrderList, List<DashboardOrder> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = dashboardOrderList.orders;
        }
        if ((i11 & 2) != 0) {
            str = dashboardOrderList.baseUrl;
        }
        return dashboardOrderList.copy(list, str);
    }

    @NotNull
    public final List<DashboardOrder> component1() {
        return this.orders;
    }

    @Nullable
    public final String component2() {
        return this.baseUrl;
    }

    @NotNull
    public final DashboardOrderList copy(@NotNull List<DashboardOrder> list, @Nullable String str) {
        Intrinsics.checkNotNullParameter(list, AppUrls.PLACEORDER_SEGMENT);
        return new DashboardOrderList(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DashboardOrderList)) {
            return false;
        }
        DashboardOrderList dashboardOrderList = (DashboardOrderList) obj;
        return Intrinsics.areEqual((Object) this.orders, (Object) dashboardOrderList.orders) && Intrinsics.areEqual((Object) this.baseUrl, (Object) dashboardOrderList.baseUrl);
    }

    @Nullable
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final List<DashboardOrder> getOrders() {
        return this.orders;
    }

    public int hashCode() {
        int hashCode = this.orders.hashCode() * 31;
        String str = this.baseUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        List<DashboardOrder> list = this.orders;
        String str = this.baseUrl;
        return "DashboardOrderList(orders=" + list + ", baseUrl=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DashboardOrderList(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i11 & 2) != 0 ? null : str);
    }
}
