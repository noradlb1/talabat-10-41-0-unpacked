package com.opsquad.ui.orderDetail.viewmodel;

import com.opsquad.features.orderDetails.GetOrderDetails;
import com.opsquad.ui.orderDetail.model.OrderDetailDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/opsquad/ui/orderDetail/viewmodel/OrderDetailsViewModelImpl;", "Lcom/opsquad/ui/orderDetail/viewmodel/OrderDetailsViewModel;", "orderDetail", "Lcom/opsquad/features/orderDetails/GetOrderDetails;", "(Lcom/opsquad/features/orderDetails/GetOrderDetails;)V", "getOrderDetails", "", "orderID", "", "handleOrderDetails", "Lcom/opsquad/ui/orderDetail/model/OrderDetailDisplayModel;", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailsViewModelImpl extends OrderDetailsViewModel {
    @NotNull
    private final GetOrderDetails orderDetail;

    public OrderDetailsViewModelImpl(@NotNull GetOrderDetails getOrderDetails) {
        Intrinsics.checkNotNullParameter(getOrderDetails, "orderDetail");
        this.orderDetail = getOrderDetails;
    }

    /* access modifiers changed from: private */
    public final void handleOrderDetails(OrderDetailDisplayModel orderDetailDisplayModel) {
        getSuccessData().setValue(orderDetailDisplayModel);
    }

    public void getOrderDetails(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        this.orderDetail.invoke(str, new OrderDetailsViewModelImpl$getOrderDetails$1(this));
    }
}
