package com.talabat.homescreen.network.model.order;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/talabat/homescreen/network/model/order/OrderStatusRefreshResponse;", "", "serverTimestamp", "", "result", "Lcom/talabat/homescreen/network/model/order/OrderStatusRefreshArrayResponse;", "(Ljava/lang/String;Lcom/talabat/homescreen/network/model/order/OrderStatusRefreshArrayResponse;)V", "getResult", "()Lcom/talabat/homescreen/network/model/order/OrderStatusRefreshArrayResponse;", "getServerTimestamp", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusRefreshResponse {
    @SerializedName("result")
    @NotNull
    private final OrderStatusRefreshArrayResponse result;
    @SerializedName("timestamp")
    @NotNull
    private final String serverTimestamp;

    public OrderStatusRefreshResponse(@NotNull String str, @NotNull OrderStatusRefreshArrayResponse orderStatusRefreshArrayResponse) {
        Intrinsics.checkNotNullParameter(str, "serverTimestamp");
        Intrinsics.checkNotNullParameter(orderStatusRefreshArrayResponse, "result");
        this.serverTimestamp = str;
        this.result = orderStatusRefreshArrayResponse;
    }

    public static /* synthetic */ OrderStatusRefreshResponse copy$default(OrderStatusRefreshResponse orderStatusRefreshResponse, String str, OrderStatusRefreshArrayResponse orderStatusRefreshArrayResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = orderStatusRefreshResponse.serverTimestamp;
        }
        if ((i11 & 2) != 0) {
            orderStatusRefreshArrayResponse = orderStatusRefreshResponse.result;
        }
        return orderStatusRefreshResponse.copy(str, orderStatusRefreshArrayResponse);
    }

    @NotNull
    public final String component1() {
        return this.serverTimestamp;
    }

    @NotNull
    public final OrderStatusRefreshArrayResponse component2() {
        return this.result;
    }

    @NotNull
    public final OrderStatusRefreshResponse copy(@NotNull String str, @NotNull OrderStatusRefreshArrayResponse orderStatusRefreshArrayResponse) {
        Intrinsics.checkNotNullParameter(str, "serverTimestamp");
        Intrinsics.checkNotNullParameter(orderStatusRefreshArrayResponse, "result");
        return new OrderStatusRefreshResponse(str, orderStatusRefreshArrayResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OrderStatusRefreshResponse)) {
            return false;
        }
        OrderStatusRefreshResponse orderStatusRefreshResponse = (OrderStatusRefreshResponse) obj;
        return Intrinsics.areEqual((Object) this.serverTimestamp, (Object) orderStatusRefreshResponse.serverTimestamp) && Intrinsics.areEqual((Object) this.result, (Object) orderStatusRefreshResponse.result);
    }

    @NotNull
    public final OrderStatusRefreshArrayResponse getResult() {
        return this.result;
    }

    @NotNull
    public final String getServerTimestamp() {
        return this.serverTimestamp;
    }

    public int hashCode() {
        return (this.serverTimestamp.hashCode() * 31) + this.result.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.serverTimestamp;
        OrderStatusRefreshArrayResponse orderStatusRefreshArrayResponse = this.result;
        return "OrderStatusRefreshResponse(serverTimestamp=" + str + ", result=" + orderStatusRefreshArrayResponse + ")";
    }
}
