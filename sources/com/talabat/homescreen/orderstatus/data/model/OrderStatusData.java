package com.talabat.homescreen.orderstatus.data.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/talabat/homescreen/orderstatus/data/model/OrderStatusData;", "", "orderId", "", "orderStatus", "", "isOrderSuccessful", "", "(Ljava/lang/String;IZ)V", "()Z", "getOrderId", "()Ljava/lang/String;", "getOrderStatus", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusData {
    private final boolean isOrderSuccessful;
    @NotNull
    private final String orderId;
    private final int orderStatus;

    public OrderStatusData(@NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.orderId = str;
        this.orderStatus = i11;
        this.isOrderSuccessful = z11;
    }

    public static /* synthetic */ OrderStatusData copy$default(OrderStatusData orderStatusData, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = orderStatusData.orderId;
        }
        if ((i12 & 2) != 0) {
            i11 = orderStatusData.orderStatus;
        }
        if ((i12 & 4) != 0) {
            z11 = orderStatusData.isOrderSuccessful;
        }
        return orderStatusData.copy(str, i11, z11);
    }

    @NotNull
    public final String component1() {
        return this.orderId;
    }

    public final int component2() {
        return this.orderStatus;
    }

    public final boolean component3() {
        return this.isOrderSuccessful;
    }

    @NotNull
    public final OrderStatusData copy(@NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        return new OrderStatusData(str, i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderStatusData)) {
            return false;
        }
        OrderStatusData orderStatusData = (OrderStatusData) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) orderStatusData.orderId) && this.orderStatus == orderStatusData.orderStatus && this.isOrderSuccessful == orderStatusData.isOrderSuccessful;
    }

    @NotNull
    public final String getOrderId() {
        return this.orderId;
    }

    public final int getOrderStatus() {
        return this.orderStatus;
    }

    public int hashCode() {
        int hashCode = ((this.orderId.hashCode() * 31) + this.orderStatus) * 31;
        boolean z11 = this.isOrderSuccessful;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isOrderSuccessful() {
        return this.isOrderSuccessful;
    }

    @NotNull
    public String toString() {
        String str = this.orderId;
        int i11 = this.orderStatus;
        boolean z11 = this.isOrderSuccessful;
        return "OrderStatusData(orderId=" + str + ", orderStatus=" + i11 + ", isOrderSuccessful=" + z11 + ")";
    }
}
