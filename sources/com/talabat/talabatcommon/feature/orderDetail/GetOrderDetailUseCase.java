package com.talabat.talabatcommon.feature.orderDetail;

import com.talabat.talabatcommon.feature.orderDetail.repository.OrderDetailRepository;
import datamodels.OrderDetails;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/orderDetail/GetOrderDetailUseCase;", "", "orderDetailRepository", "Lcom/talabat/talabatcommon/feature/orderDetail/repository/OrderDetailRepository;", "(Lcom/talabat/talabatcommon/feature/orderDetail/repository/OrderDetailRepository;)V", "invoke", "Ldatamodels/OrderDetails;", "transactionOrderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOrderDetailUseCase {
    @NotNull
    private final OrderDetailRepository orderDetailRepository;

    public GetOrderDetailUseCase(@NotNull OrderDetailRepository orderDetailRepository2) {
        Intrinsics.checkNotNullParameter(orderDetailRepository2, "orderDetailRepository");
        this.orderDetailRepository = orderDetailRepository2;
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull Continuation<? super OrderDetails> continuation) {
        return this.orderDetailRepository.getOrderDetail(str, continuation);
    }
}
