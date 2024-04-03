package com.opsquad.features.orderDetails;

import com.opsquad.features.orderDetails.models.responses.OrderDetailsRootResponse;
import com.opsquad.ui.orderDetail.model.OrderDetailDisplayModel;
import com.opsquad.ui.orderDetail.model.OrderDetailsMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/opsquad/ui/orderDetail/model/OrderDetailDisplayModel;", "orderDetailsRootResponse", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailsRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetOrderDetails$run$2 extends Lambda implements Function1<OrderDetailsRootResponse, OrderDetailDisplayModel> {
    public static final GetOrderDetails$run$2 INSTANCE = new GetOrderDetails$run$2();

    public GetOrderDetails$run$2() {
        super(1);
    }

    @NotNull
    public final OrderDetailDisplayModel invoke(@NotNull OrderDetailsRootResponse orderDetailsRootResponse) {
        Intrinsics.checkNotNullParameter(orderDetailsRootResponse, "orderDetailsRootResponse");
        return OrderDetailsMapper.Companion.mapOrderDetailsRootResponseToDisplayModel(orderDetailsRootResponse);
    }
}
