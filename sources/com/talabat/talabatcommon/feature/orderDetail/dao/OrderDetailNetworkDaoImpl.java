package com.talabat.talabatcommon.feature.orderDetail.dao;

import com.talabat.talabatcommon.feature.orderDetail.network.OrderDetailApi;
import com.talabat.talabatcommon.feature.orderDetail.network.OrderDetailRetrofitBuilder;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/orderDetail/dao/OrderDetailNetworkDaoImpl;", "Lcom/talabat/talabatcommon/feature/orderDetail/dao/OrderDetailNetworkDao;", "()V", "orderDetailApi", "Lcom/talabat/talabatcommon/feature/orderDetail/network/OrderDetailApi;", "getOrderDetail", "Ldatamodels/OrderDetails;", "transactionOrderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OrderDetailNetworkDaoImpl implements OrderDetailNetworkDao {
    @NotNull
    private final OrderDetailApi orderDetailApi = OrderDetailRetrofitBuilder.INSTANCE.getOrderDetailApi();

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getOrderDetail(@org.jetbrains.annotations.NotNull java.lang.String r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super datamodels.OrderDetails> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl$getOrderDetail$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl$getOrderDetail$1 r0 = (com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl$getOrderDetail$1) r0
            int r1 = r0.f61556j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61556j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl$getOrderDetail$1 r0 = new com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl$getOrderDetail$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f61554h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61556j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.talabatcommon.feature.orderDetail.network.OrderDetailApi r6 = r4.orderDetailApi
            r0.f61556j = r3
            java.lang.Object r6 = r6.getOrderDetail(r5, r0)
            if (r6 != r1) goto L_0x003f
            return r1
        L_0x003f:
            JsonModels.OrderDetailsRM r6 = (JsonModels.OrderDetailsRM) r6
            datamodels.OrderDetails r5 = r6.result
            java.lang.String r6 = "orderDetailApi.getOrderD…nOrderId\n        ).result"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl.getOrderDetail(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
