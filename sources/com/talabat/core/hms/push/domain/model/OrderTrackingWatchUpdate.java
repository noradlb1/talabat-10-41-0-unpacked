package com.talabat.core.hms.push.domain.model;

import com.talabat.helpers.AppUrls;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/core/hms/push/domain/model/OrderTrackingWatchUpdate;", "", "orders", "", "Lcom/talabat/core/hms/push/domain/model/OrderUpdate;", "message", "", "(Ljava/util/List;Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getOrders", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_hms_push_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderTrackingWatchUpdate {
    @NotNull
    private final String message;
    @NotNull
    private final List<OrderUpdate> orders;

    public OrderTrackingWatchUpdate() {
        this((List) null, (String) null, 3, (DefaultConstructorMarker) null);
    }

    public OrderTrackingWatchUpdate(@NotNull List<OrderUpdate> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, AppUrls.PLACEORDER_SEGMENT);
        Intrinsics.checkNotNullParameter(str, "message");
        this.orders = list;
        this.message = str;
    }

    public static /* synthetic */ OrderTrackingWatchUpdate copy$default(OrderTrackingWatchUpdate orderTrackingWatchUpdate, List<OrderUpdate> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = orderTrackingWatchUpdate.orders;
        }
        if ((i11 & 2) != 0) {
            str = orderTrackingWatchUpdate.message;
        }
        return orderTrackingWatchUpdate.copy(list, str);
    }

    @NotNull
    public final List<OrderUpdate> component1() {
        return this.orders;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final OrderTrackingWatchUpdate copy(@NotNull List<OrderUpdate> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, AppUrls.PLACEORDER_SEGMENT);
        Intrinsics.checkNotNullParameter(str, "message");
        return new OrderTrackingWatchUpdate(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderTrackingWatchUpdate)) {
            return false;
        }
        OrderTrackingWatchUpdate orderTrackingWatchUpdate = (OrderTrackingWatchUpdate) obj;
        return Intrinsics.areEqual((Object) this.orders, (Object) orderTrackingWatchUpdate.orders) && Intrinsics.areEqual((Object) this.message, (Object) orderTrackingWatchUpdate.message);
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @NotNull
    public final List<OrderUpdate> getOrders() {
        return this.orders;
    }

    public int hashCode() {
        return (this.orders.hashCode() * 31) + this.message.hashCode();
    }

    @NotNull
    public String toString() {
        List<OrderUpdate> list = this.orders;
        String str = this.message;
        return "OrderTrackingWatchUpdate(orders=" + list + ", message=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OrderTrackingWatchUpdate(List list, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.emptyList() : list, (i11 & 2) != 0 ? "" : str);
    }
}
