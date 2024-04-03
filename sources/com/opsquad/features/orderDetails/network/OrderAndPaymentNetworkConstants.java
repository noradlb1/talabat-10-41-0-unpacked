package com.opsquad.features.orderDetails.network;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/opsquad/features/orderDetails/network/OrderAndPaymentNetworkConstants;", "", "()V", "ORDERS_API", "", "ORDER_ID", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderAndPaymentNetworkConstants {
    @NotNull
    public static final OrderAndPaymentNetworkConstants INSTANCE = new OrderAndPaymentNetworkConstants();
    @NotNull
    public static final String ORDERS_API = "v1/orders/{transactionID}/details";
    @NotNull
    public static final String ORDER_ID = "transactionID";

    private OrderAndPaymentNetworkConstants() {
    }
}
