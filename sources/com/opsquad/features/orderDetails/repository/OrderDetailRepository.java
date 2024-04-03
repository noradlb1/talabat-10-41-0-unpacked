package com.opsquad.features.orderDetails.repository;

import com.opsquad.features.orderDetails.models.responses.OrderDetailResponse;
import com.opsquad.features.orderDetails.models.responses.OrderDetailsRootResponse;
import com.opsquad.features.orderDetails.network.OrderServices;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/opsquad/features/orderDetails/repository/OrderDetailRepository;", "Lcom/opsquad/features/orderDetails/repository/OrderDetailRepositoryInterface;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "orderService", "Lcom/opsquad/features/orderDetails/network/OrderServices;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/opsquad/features/orderDetails/network/OrderServices;)V", "getOrderDetail", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/opsquad/features/orderDetails/models/responses/OrderDetailsRootResponse;", "orderID", "", "com_talabat_NewArchi_OPSquad_OPSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailRepository implements OrderDetailRepositoryInterface {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final OrderServices orderService;

    public OrderDetailRepository(@NotNull NetworkHandler networkHandler2, @NotNull OrderServices orderServices) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(orderServices, "orderService");
        this.networkHandler = networkHandler2;
        this.orderService = orderServices;
    }

    @NotNull
    public Either<Failure, OrderDetailsRootResponse> getOrderDetail(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderID");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.orderService.orderDetails(str), OrderDetailRepository$getOrderDetail$1.INSTANCE, new OrderDetailsRootResponse((OrderDetailResponse) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
