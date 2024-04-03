package com.talabat.homescreen.orderstatus.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\u000fJ\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/homescreen/orderstatus/domain/entity/OrderEntity;", "", "encryptedOrderId", "", "orderType", "", "(Ljava/lang/String;I)V", "getEncryptedOrderId", "()Ljava/lang/String;", "getOrderType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "isPickup", "toString", "Companion", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderEntity {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int NORMAL = 0;
    public static final int PICKUP = 1;
    @NotNull
    private final String encryptedOrderId;
    private final int orderType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/homescreen/orderstatus/domain/entity/OrderEntity$Companion;", "", "()V", "NORMAL", "", "PICKUP", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public OrderEntity(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        this.encryptedOrderId = str;
        this.orderType = i11;
    }

    public static /* synthetic */ OrderEntity copy$default(OrderEntity orderEntity, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = orderEntity.encryptedOrderId;
        }
        if ((i12 & 2) != 0) {
            i11 = orderEntity.orderType;
        }
        return orderEntity.copy(str, i11);
    }

    @NotNull
    public final String component1() {
        return this.encryptedOrderId;
    }

    public final int component2() {
        return this.orderType;
    }

    @NotNull
    public final OrderEntity copy(@NotNull String str, int i11) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        return new OrderEntity(str, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderEntity)) {
            return false;
        }
        OrderEntity orderEntity = (OrderEntity) obj;
        return Intrinsics.areEqual((Object) this.encryptedOrderId, (Object) orderEntity.encryptedOrderId) && this.orderType == orderEntity.orderType;
    }

    @NotNull
    public final String getEncryptedOrderId() {
        return this.encryptedOrderId;
    }

    public final int getOrderType() {
        return this.orderType;
    }

    public int hashCode() {
        return (this.encryptedOrderId.hashCode() * 31) + this.orderType;
    }

    public final boolean isPickup() {
        return this.orderType == 1;
    }

    @NotNull
    public String toString() {
        String str = this.encryptedOrderId;
        int i11 = this.orderType;
        return "OrderEntity(encryptedOrderId=" + str + ", orderType=" + i11 + ")";
    }
}
