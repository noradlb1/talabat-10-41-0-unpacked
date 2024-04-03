package com.talabat.homescreen.network.model.order;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0007HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/talabat/homescreen/network/model/order/OrderStatusRefreshItemResponse;", "", "id", "", "newOrderStatus", "", "isSuccessful", "", "(Ljava/lang/String;IZ)V", "getId", "()Ljava/lang/String;", "()Z", "getNewOrderStatus", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusRefreshItemResponse {
    @SerializedName("id")
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f60967id;
    @SerializedName("iso")
    private final boolean isSuccessful;
    @SerializedName("eos")
    private final int newOrderStatus;

    public OrderStatusRefreshItemResponse(@NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.f60967id = str;
        this.newOrderStatus = i11;
        this.isSuccessful = z11;
    }

    public static /* synthetic */ OrderStatusRefreshItemResponse copy$default(OrderStatusRefreshItemResponse orderStatusRefreshItemResponse, String str, int i11, boolean z11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = orderStatusRefreshItemResponse.f60967id;
        }
        if ((i12 & 2) != 0) {
            i11 = orderStatusRefreshItemResponse.newOrderStatus;
        }
        if ((i12 & 4) != 0) {
            z11 = orderStatusRefreshItemResponse.isSuccessful;
        }
        return orderStatusRefreshItemResponse.copy(str, i11, z11);
    }

    @NotNull
    public final String component1() {
        return this.f60967id;
    }

    public final int component2() {
        return this.newOrderStatus;
    }

    public final boolean component3() {
        return this.isSuccessful;
    }

    @NotNull
    public final OrderStatusRefreshItemResponse copy(@NotNull String str, int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "id");
        return new OrderStatusRefreshItemResponse(str, i11, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderStatusRefreshItemResponse)) {
            return false;
        }
        OrderStatusRefreshItemResponse orderStatusRefreshItemResponse = (OrderStatusRefreshItemResponse) obj;
        return Intrinsics.areEqual((Object) this.f60967id, (Object) orderStatusRefreshItemResponse.f60967id) && this.newOrderStatus == orderStatusRefreshItemResponse.newOrderStatus && this.isSuccessful == orderStatusRefreshItemResponse.isSuccessful;
    }

    @NotNull
    public final String getId() {
        return this.f60967id;
    }

    public final int getNewOrderStatus() {
        return this.newOrderStatus;
    }

    public int hashCode() {
        int hashCode = ((this.f60967id.hashCode() * 31) + this.newOrderStatus) * 31;
        boolean z11 = this.isSuccessful;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isSuccessful() {
        return this.isSuccessful;
    }

    @NotNull
    public String toString() {
        String str = this.f60967id;
        int i11 = this.newOrderStatus;
        boolean z11 = this.isSuccessful;
        return "OrderStatusRefreshItemResponse(id=" + str + ", newOrderStatus=" + i11 + ", isSuccessful=" + z11 + ")";
    }
}
