package com.opsquad.ui.orderDetail.rows.vendorInfoCell;

import com.opsquad.ui.orderDetail.model.enums.OrderStatusStyle;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001a\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001a\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/vendorInfoCell/VendorInfoRowDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "()V", "orderID", "", "getOrderID", "()Ljava/lang/String;", "setOrderID", "(Ljava/lang/String;)V", "orderStatus", "getOrderStatus", "setOrderStatus", "orderStatusStyle", "Lcom/opsquad/ui/orderDetail/model/enums/OrderStatusStyle;", "getOrderStatusStyle", "()Lcom/opsquad/ui/orderDetail/model/enums/OrderStatusStyle;", "setOrderStatusStyle", "(Lcom/opsquad/ui/orderDetail/model/enums/OrderStatusStyle;)V", "orderTime", "getOrderTime", "setOrderTime", "restaurantLogoUrl", "getRestaurantLogoUrl", "setRestaurantLogoUrl", "vendorName", "getVendorName", "setVendorName", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorInfoRowDisplayModel extends RowDisplayModel {
    @NotNull
    private String orderID = "";
    @NotNull
    private String orderStatus = "";
    @NotNull
    private OrderStatusStyle orderStatusStyle = OrderStatusStyle.NEGATIVE;
    @NotNull
    private String orderTime = "";
    @NotNull
    private String restaurantLogoUrl = "";
    @NotNull
    private String vendorName = "";

    @NotNull
    public final String getOrderID() {
        return this.orderID;
    }

    @NotNull
    public final String getOrderStatus() {
        return this.orderStatus;
    }

    @NotNull
    public final OrderStatusStyle getOrderStatusStyle() {
        return this.orderStatusStyle;
    }

    @NotNull
    public final String getOrderTime() {
        return this.orderTime;
    }

    @NotNull
    public final String getRestaurantLogoUrl() {
        return this.restaurantLogoUrl;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public final void setOrderID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderID = str;
    }

    public final void setOrderStatus(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderStatus = str;
    }

    public final void setOrderStatusStyle(@NotNull OrderStatusStyle orderStatusStyle2) {
        Intrinsics.checkNotNullParameter(orderStatusStyle2, "<set-?>");
        this.orderStatusStyle = orderStatusStyle2;
    }

    public final void setOrderTime(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderTime = str;
    }

    public final void setRestaurantLogoUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.restaurantLogoUrl = str;
    }

    public final void setVendorName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vendorName = str;
    }
}
