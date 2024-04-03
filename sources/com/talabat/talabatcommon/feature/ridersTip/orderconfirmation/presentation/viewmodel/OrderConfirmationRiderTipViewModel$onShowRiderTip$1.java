package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel;

import com.talabat.talabatcommon.enums.OrderStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel$onShowRiderTip$1", f = "OrderConfirmationRiderTipViewModel.kt", i = {}, l = {36, 42}, m = "invokeSuspend", n = {}, s = {})
public final class OrderConfirmationRiderTipViewModel$onShowRiderTip$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f61573h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ OrderConfirmationRiderTipViewModel f61574i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ OrderStatus f61575j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderConfirmationRiderTipViewModel$onShowRiderTip$1(OrderConfirmationRiderTipViewModel orderConfirmationRiderTipViewModel, OrderStatus orderStatus, Continuation<? super OrderConfirmationRiderTipViewModel$onShowRiderTip$1> continuation) {
        super(2, continuation);
        this.f61574i = orderConfirmationRiderTipViewModel;
        this.f61575j = orderStatus;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new OrderConfirmationRiderTipViewModel$onShowRiderTip$1(this.f61574i, this.f61575j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((OrderConfirmationRiderTipViewModel$onShowRiderTip$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f61573h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0078
        L_0x0012:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004d
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r6)
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r6 = r5.f61574i
            androidx.lifecycle.MutableLiveData r6 = r6.getRiderTipStatusDisplayModel()
            java.lang.Object r6 = r6.getValue()
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel$ShowRiderTipGiven r1 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel.ShowRiderTipGiven.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r6 == 0) goto L_0x0036
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0036:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r6 = r5.f61574i
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase r6 = r6.isRiderTipEnabledUseCase
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r1 = r5.f61574i
            java.lang.String r1 = r1.getEncryptedOrderId()
            com.talabat.talabatcommon.enums.OrderStatus r4 = r5.f61575j
            r5.f61573h = r3
            java.lang.Object r6 = r6.invoke(r1, r4, r5)
            if (r6 != r0) goto L_0x004d
            return r0
        L_0x004d:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus$RiderWasTipped r1 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus.RiderWasTipped.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r1)
            if (r6 == 0) goto L_0x0061
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r6 = r5.f61574i
            androidx.lifecycle.MutableLiveData r6 = r6.getRiderTipStatusDisplayModel()
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel$ShowRiderTipGiven r0 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel.ShowRiderTipGiven.INSTANCE
            r6.postValue(r0)
            goto L_0x0097
        L_0x0061:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r6 = r5.f61574i
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase r6 = r6.isRiderTipEnabledUseCase
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r1 = r5.f61574i
            java.lang.String r1 = r1.getEncryptedOrderId()
            com.talabat.talabatcommon.enums.OrderStatus r3 = r5.f61575j
            r5.f61573h = r2
            java.lang.Object r6 = r6.invoke(r1, r3, r5)
            if (r6 != r0) goto L_0x0078
            return r0
        L_0x0078:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus$RiderTipIsAvailable r0 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus.RiderTipIsAvailable.INSTANCE
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r0)
            if (r6 == 0) goto L_0x008c
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r6 = r5.f61574i
            androidx.lifecycle.MutableLiveData r6 = r6.getRiderTipStatusDisplayModel()
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel$ShowOrderConfirmationRiderTip r0 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel.ShowOrderConfirmationRiderTip.INSTANCE
            r6.postValue(r0)
            goto L_0x0097
        L_0x008c:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel r6 = r5.f61574i
            androidx.lifecycle.MutableLiveData r6 = r6.getRiderTipStatusDisplayModel()
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel$HideOrderConfirmationRiderTip r0 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.displaymodel.OrderConfirmationRiderTipDisplayModel.HideOrderConfirmationRiderTip.INSTANCE
            r6.postValue(r0)
        L_0x0097:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.presentation.viewmodel.OrderConfirmationRiderTipViewModel$onShowRiderTip$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
