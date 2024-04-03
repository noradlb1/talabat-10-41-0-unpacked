package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase;

import com.talabat.talabatcommon.enums.OrderStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase", f = "GetOrderConfirmationRiderTipEnabledUseCase.kt", i = {0, 0, 0, 1, 1, 1}, l = {19, 26}, m = "invoke", n = {"this", "encryptedOrderId", "orderStatus", "this", "encryptedOrderId", "orderStatus"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class GetOrderConfirmationRiderTipEnabledUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61567h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61568i;

    /* renamed from: j  reason: collision with root package name */
    public Object f61569j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f61570k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ GetOrderConfirmationRiderTipEnabledUseCase f61571l;

    /* renamed from: m  reason: collision with root package name */
    public int f61572m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetOrderConfirmationRiderTipEnabledUseCase$invoke$1(GetOrderConfirmationRiderTipEnabledUseCase getOrderConfirmationRiderTipEnabledUseCase, Continuation<? super GetOrderConfirmationRiderTipEnabledUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61571l = getOrderConfirmationRiderTipEnabledUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61570k = obj;
        this.f61572m |= Integer.MIN_VALUE;
        return this.f61571l.invoke((String) null, (OrderStatus) null, this);
    }
}
