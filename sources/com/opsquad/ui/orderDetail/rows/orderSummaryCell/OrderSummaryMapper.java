package com.opsquad.ui.orderDetail.rows.orderSummaryCell;

import com.opsquad.features.orderDetails.models.responses.OrderItemResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/opsquad/ui/orderDetail/rows/orderSummaryCell/OrderSummaryMapper;", "", "()V", "mapOrderSummaryDataModel", "Lcom/opsquad/ui/orderDetail/rows/orderSummaryCell/OrderSummaryDisplayModel;", "orderItem", "Lcom/opsquad/features/orderDetails/models/responses/OrderItemResponse;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderSummaryMapper {
    @NotNull
    public final OrderSummaryDisplayModel mapOrderSummaryDataModel(@NotNull OrderItemResponse orderItemResponse) {
        Intrinsics.checkNotNullParameter(orderItemResponse, "orderItem");
        OrderSummaryDisplayModel orderSummaryDisplayModel = new OrderSummaryDisplayModel();
        String itemName = orderItemResponse.getItemName();
        if (itemName == null) {
            itemName = "";
        }
        orderSummaryDisplayModel.setOrderDescription(itemName);
        orderSummaryDisplayModel.setOrderQuantity(String.valueOf(orderItemResponse.getItemQuantity()));
        orderSummaryDisplayModel.setOrderPrice(String.valueOf(orderItemResponse.getItemPrice()));
        orderSummaryDisplayModel.setItemChoices(String.valueOf(orderItemResponse.getItemChoices()));
        orderSummaryDisplayModel.setSpecialRequest(String.valueOf(orderItemResponse.getItemSpecialRequest()));
        return orderSummaryDisplayModel;
    }
}
