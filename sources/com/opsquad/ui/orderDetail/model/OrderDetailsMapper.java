package com.opsquad.ui.orderDetail.model;

import com.opsquad.features.orderDetails.models.responses.OrderDetailResponse;
import com.opsquad.features.orderDetails.models.responses.OrderDetailsRootResponse;
import com.opsquad.features.orderDetails.models.responses.OrderItemResponse;
import com.opsquad.ui.orderDetail.rows.RowDisplayModel;
import com.opsquad.ui.orderDetail.rows.deliveryAddressCell.DeliveryAddressMapper;
import com.opsquad.ui.orderDetail.rows.orderDetailheaderCell.OrderDetailHeaderMapper;
import com.opsquad.ui.orderDetail.rows.orderSummaryCell.OrderSummaryMapper;
import com.opsquad.ui.orderDetail.rows.paymentItemCell.PaymentItemMapper;
import com.opsquad.ui.orderDetail.rows.vendorInfoCell.VendorInfoMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/opsquad/ui/orderDetail/model/OrderDetailsMapper;", "", "()V", "Companion", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsMapper {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002¨\u0006\u000e"}, d2 = {"Lcom/opsquad/ui/orderDetail/model/OrderDetailsMapper$Companion;", "", "()V", "mapOrderDetailsRootResponseToDisplayModel", "Lcom/opsquad/ui/orderDetail/model/OrderDetailDisplayModel;", "field", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailsRootResponse;", "mapOrderResponseToDisplayModel", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailResponse;", "baseUrl", "", "mapRows", "", "Lcom/opsquad/ui/orderDetail/rows/RowDisplayModel;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final OrderDetailDisplayModel mapOrderResponseToDisplayModel(OrderDetailResponse orderDetailResponse, String str) {
            OrderDetailDisplayModel orderDetailDisplayModel = new OrderDetailDisplayModel();
            orderDetailDisplayModel.setRows(OrderDetailsMapper.Companion.mapRows(orderDetailResponse, str));
            return orderDetailDisplayModel;
        }

        private final List<RowDisplayModel> mapRows(OrderDetailResponse orderDetailResponse, String str) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new VendorInfoMapper().getVendorInfoRow(orderDetailResponse, str));
            arrayList.add(new DeliveryAddressMapper().mapDeliveryAddressDataModel(orderDetailResponse));
            arrayList.add(new OrderDetailHeaderMapper().mapOrderDetailHeaderView());
            ArrayList<OrderItemResponse> orderItems = orderDetailResponse.getOrderItems();
            if (orderItems != null) {
                Iterator<OrderItemResponse> it = orderItems.iterator();
                while (it.hasNext()) {
                    OrderItemResponse next = it.next();
                    OrderSummaryMapper orderSummaryMapper = new OrderSummaryMapper();
                    Intrinsics.checkNotNullExpressionValue(next, "orderItem");
                    arrayList.add(orderSummaryMapper.mapOrderSummaryDataModel(next));
                }
            }
            arrayList.addAll(new PaymentItemMapper().buildPaymentContent(orderDetailResponse));
            return arrayList;
        }

        @NotNull
        public final OrderDetailDisplayModel mapOrderDetailsRootResponseToDisplayModel(@NotNull OrderDetailsRootResponse orderDetailsRootResponse) {
            Intrinsics.checkNotNullParameter(orderDetailsRootResponse, "field");
            OrderDetailDisplayModel orderDetailDisplayModel = new OrderDetailDisplayModel();
            String baseUrl = orderDetailsRootResponse.getBaseUrl();
            OrderDetailResponse result = orderDetailsRootResponse.getResult();
            if (result != null) {
                return OrderDetailsMapper.Companion.mapOrderResponseToDisplayModel(result, baseUrl);
            }
            return orderDetailDisplayModel;
        }
    }
}
