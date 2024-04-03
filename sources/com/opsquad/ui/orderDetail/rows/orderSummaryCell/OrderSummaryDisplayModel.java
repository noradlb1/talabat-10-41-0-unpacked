package com.opsquad.ui.orderDetail.rows.orderSummaryCell;

import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/orderSummaryCell/OrderSummaryDisplayModel;", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "()V", "itemChoices", "", "getItemChoices", "()Ljava/lang/String;", "setItemChoices", "(Ljava/lang/String;)V", "orderDescription", "getOrderDescription", "setOrderDescription", "orderPrice", "getOrderPrice", "setOrderPrice", "orderQuantity", "getOrderQuantity", "setOrderQuantity", "specialRequest", "getSpecialRequest", "setSpecialRequest", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderSummaryDisplayModel extends RowDisplayModel {
    @NotNull
    private String itemChoices = "";
    @NotNull
    private String orderDescription = "";
    @NotNull
    private String orderPrice = "";
    @NotNull
    private String orderQuantity = "";
    @NotNull
    private String specialRequest = "";

    @NotNull
    public final String getItemChoices() {
        return this.itemChoices;
    }

    @NotNull
    public final String getOrderDescription() {
        return this.orderDescription;
    }

    @NotNull
    public final String getOrderPrice() {
        return this.orderPrice;
    }

    @NotNull
    public final String getOrderQuantity() {
        return this.orderQuantity;
    }

    @NotNull
    public final String getSpecialRequest() {
        return this.specialRequest;
    }

    public final void setItemChoices(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.itemChoices = str;
    }

    public final void setOrderDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderDescription = str;
    }

    public final void setOrderPrice(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderPrice = str;
    }

    public final void setOrderQuantity(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderQuantity = str;
    }

    public final void setSpecialRequest(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.specialRequest = str;
    }
}
