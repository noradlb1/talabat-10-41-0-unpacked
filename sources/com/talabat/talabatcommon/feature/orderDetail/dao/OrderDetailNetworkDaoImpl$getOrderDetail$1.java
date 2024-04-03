package com.talabat.talabatcommon.feature.orderDetail.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.orderDetail.dao.OrderDetailNetworkDaoImpl", f = "OrderDetailNetworkDaoImpl.kt", i = {}, l = {11}, m = "getOrderDetail", n = {}, s = {})
public final class OrderDetailNetworkDaoImpl$getOrderDetail$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61554h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OrderDetailNetworkDaoImpl f61555i;

    /* renamed from: j  reason: collision with root package name */
    public int f61556j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderDetailNetworkDaoImpl$getOrderDetail$1(OrderDetailNetworkDaoImpl orderDetailNetworkDaoImpl, Continuation<? super OrderDetailNetworkDaoImpl$getOrderDetail$1> continuation) {
        super(continuation);
        this.f61555i = orderDetailNetworkDaoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61554h = obj;
        this.f61556j |= Integer.MIN_VALUE;
        return this.f61555i.getOrderDetail((String) null, this);
    }
}
