package com.talabat.homescreen.orderstatus.domain.entity;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/homescreen/orderstatus/domain/entity/OrderStatusEntity;", "", "orderId", "", "orderStatus", "isOrderSuccessful", "", "(IIZ)V", "()Z", "getOrderId", "()I", "getOrderStatus", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusEntity {
    private final boolean isOrderSuccessful;
    private final int orderId;
    private final int orderStatus;

    public OrderStatusEntity(int i11, int i12, boolean z11) {
        this.orderId = i11;
        this.orderStatus = i12;
        this.isOrderSuccessful = z11;
    }

    public static /* synthetic */ OrderStatusEntity copy$default(OrderStatusEntity orderStatusEntity, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = orderStatusEntity.orderId;
        }
        if ((i13 & 2) != 0) {
            i12 = orderStatusEntity.orderStatus;
        }
        if ((i13 & 4) != 0) {
            z11 = orderStatusEntity.isOrderSuccessful;
        }
        return orderStatusEntity.copy(i11, i12, z11);
    }

    public final int component1() {
        return this.orderId;
    }

    public final int component2() {
        return this.orderStatus;
    }

    public final boolean component3() {
        return this.isOrderSuccessful;
    }

    @NotNull
    public final OrderStatusEntity copy(int i11, int i12, boolean z11) {
        return new OrderStatusEntity(i11, i12, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderStatusEntity)) {
            return false;
        }
        OrderStatusEntity orderStatusEntity = (OrderStatusEntity) obj;
        return this.orderId == orderStatusEntity.orderId && this.orderStatus == orderStatusEntity.orderStatus && this.isOrderSuccessful == orderStatusEntity.isOrderSuccessful;
    }

    public final int getOrderId() {
        return this.orderId;
    }

    public final int getOrderStatus() {
        return this.orderStatus;
    }

    public int hashCode() {
        int i11 = ((this.orderId * 31) + this.orderStatus) * 31;
        boolean z11 = this.isOrderSuccessful;
        if (z11) {
            z11 = true;
        }
        return i11 + (z11 ? 1 : 0);
    }

    public final boolean isOrderSuccessful() {
        return this.isOrderSuccessful;
    }

    @NotNull
    public String toString() {
        int i11 = this.orderId;
        int i12 = this.orderStatus;
        boolean z11 = this.isOrderSuccessful;
        return "OrderStatusEntity(orderId=" + i11 + ", orderStatus=" + i12 + ", isOrderSuccessful=" + z11 + ")";
    }
}
