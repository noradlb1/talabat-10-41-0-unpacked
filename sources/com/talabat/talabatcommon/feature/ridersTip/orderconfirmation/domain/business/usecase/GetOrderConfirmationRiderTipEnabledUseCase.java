package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase;

import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipABTestVariant;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipFeatureUseCase;
import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetTipRiderStateUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ#\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/business/usecase/GetOrderConfirmationRiderTipEnabledUseCase;", "", "isOrderConfirmationRiderTipFeatureUseCaseEnabled", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipFeatureUseCase;", "isOrderConfirmationRiderTipExperimentEnabled", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipABTestVariant;", "isRiderTipped", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetTipRiderStateUseCase;", "(Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipFeatureUseCase;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetOrderConfirmationRiderTipABTestVariant;Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/GetTipRiderStateUseCase;)V", "invoke", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/entity/OrderConfirmationRiderTipStatus;", "encryptedOrderId", "", "orderStatus", "Lcom/talabat/talabatcommon/enums/OrderStatus;", "(Ljava/lang/String;Lcom/talabat/talabatcommon/enums/OrderStatus;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetOrderConfirmationRiderTipEnabledUseCase {
    @NotNull
    private final GetOrderConfirmationRiderTipABTestVariant isOrderConfirmationRiderTipExperimentEnabled;
    @NotNull
    private final GetOrderConfirmationRiderTipFeatureUseCase isOrderConfirmationRiderTipFeatureUseCaseEnabled;
    @NotNull
    private final GetTipRiderStateUseCase isRiderTipped;

    public GetOrderConfirmationRiderTipEnabledUseCase(@NotNull GetOrderConfirmationRiderTipFeatureUseCase getOrderConfirmationRiderTipFeatureUseCase, @NotNull GetOrderConfirmationRiderTipABTestVariant getOrderConfirmationRiderTipABTestVariant, @NotNull GetTipRiderStateUseCase getTipRiderStateUseCase) {
        Intrinsics.checkNotNullParameter(getOrderConfirmationRiderTipFeatureUseCase, "isOrderConfirmationRiderTipFeatureUseCaseEnabled");
        Intrinsics.checkNotNullParameter(getOrderConfirmationRiderTipABTestVariant, "isOrderConfirmationRiderTipExperimentEnabled");
        Intrinsics.checkNotNullParameter(getTipRiderStateUseCase, "isRiderTipped");
        this.isOrderConfirmationRiderTipFeatureUseCaseEnabled = getOrderConfirmationRiderTipFeatureUseCase;
        this.isOrderConfirmationRiderTipExperimentEnabled = getOrderConfirmationRiderTipABTestVariant;
        this.isRiderTipped = getTipRiderStateUseCase;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: com.talabat.talabatcommon.enums.OrderStatus} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.String r8, @org.jetbrains.annotations.Nullable com.talabat.talabatcommon.enums.OrderStatus r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase$invoke$1 r0 = (com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase$invoke$1) r0
            int r1 = r0.f61572m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61572m = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase$invoke$1 r0 = new com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase$invoke$1
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f61570k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61572m
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0042
            if (r2 != r4) goto L_0x003a
            java.lang.Object r8 = r0.f61569j
            com.talabat.talabatcommon.enums.OrderStatus r8 = (com.talabat.talabatcommon.enums.OrderStatus) r8
            java.lang.Object r9 = r0.f61568i
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r0 = r0.f61567h
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase r0 = (com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a3
        L_0x003a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0042:
            java.lang.Object r8 = r0.f61569j
            r9 = r8
            com.talabat.talabatcommon.enums.OrderStatus r9 = (com.talabat.talabatcommon.enums.OrderStatus) r9
            java.lang.Object r8 = r0.f61568i
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.f61567h
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase r2 = (com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0068
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r10)
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipFeatureUseCase r10 = r7.isOrderConfirmationRiderTipFeatureUseCaseEnabled
            r0.f61567h = r7
            r0.f61568i = r8
            r0.f61569j = r9
            r0.f61572m = r5
            java.lang.Object r10 = r10.invoke(r0)
            if (r10 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r2 = r7
        L_0x0068:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x008e
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipABTestVariant r10 = r2.isOrderConfirmationRiderTipExperimentEnabled
            boolean r10 = r10.invoke()
            if (r10 == 0) goto L_0x008e
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetTipRiderStateUseCase r10 = r2.isRiderTipped
            boolean r10 = r10.invoke(r8)
            if (r10 == 0) goto L_0x008e
            int r10 = r8.length()
            if (r10 <= 0) goto L_0x0088
            r10 = r5
            goto L_0x0089
        L_0x0088:
            r10 = r3
        L_0x0089:
            if (r10 == 0) goto L_0x008e
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus$RiderWasTipped r8 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus.RiderWasTipped.INSTANCE
            goto L_0x00d5
        L_0x008e:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipFeatureUseCase r10 = r2.isOrderConfirmationRiderTipFeatureUseCaseEnabled
            r0.f61567h = r2
            r0.f61568i = r8
            r0.f61569j = r9
            r0.f61572m = r4
            java.lang.Object r10 = r10.invoke(r0)
            if (r10 != r1) goto L_0x009f
            return r1
        L_0x009f:
            r0 = r2
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x00a3:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00d3
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetOrderConfirmationRiderTipABTestVariant r10 = r0.isOrderConfirmationRiderTipExperimentEnabled
            boolean r10 = r10.invoke()
            if (r10 == 0) goto L_0x00d3
            int r10 = r9.length()
            if (r10 <= 0) goto L_0x00ba
            r3 = r5
        L_0x00ba:
            if (r3 == 0) goto L_0x00d3
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase.GetTipRiderStateUseCase r10 = r0.isRiderTipped
            boolean r9 = r10.invoke(r9)
            if (r9 != 0) goto L_0x00d3
            com.talabat.talabatcommon.enums.OrderStatus r9 = com.talabat.talabatcommon.enums.OrderStatus.PREPARING
            if (r8 == r9) goto L_0x00d0
            com.talabat.talabatcommon.enums.OrderStatus r9 = com.talabat.talabatcommon.enums.OrderStatus.DELIVERED
            if (r8 == r9) goto L_0x00d0
            com.talabat.talabatcommon.enums.OrderStatus r9 = com.talabat.talabatcommon.enums.OrderStatus.DELIVERING
            if (r8 != r9) goto L_0x00d3
        L_0x00d0:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus$RiderTipIsAvailable r8 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus.RiderTipIsAvailable.INSTANCE
            goto L_0x00d5
        L_0x00d3:
            com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus$RiderTipIsUnAvailable r8 = com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.entity.OrderConfirmationRiderTipStatus.RiderTipIsUnAvailable.INSTANCE
        L_0x00d5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.business.usecase.GetOrderConfirmationRiderTipEnabledUseCase.invoke(java.lang.String, com.talabat.talabatcommon.enums.OrderStatus, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
