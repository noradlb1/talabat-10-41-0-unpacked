package com.talabat.feature.rating.domain.usecase;

import com.talabat.feature.rating.domain.model.DashboardOrder;
import com.talabat.feature.rating.domain.model.GetPastOrdersRequestParamsProvider;
import com.talabat.feature.rating.domain.model.OrderStatus;
import com.talabat.feature.rating.domain.repo.GetPastOrdersRepository;
import com.talabat.feature.rating.domain.repo.RatingSession;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0013\u0010\r\u001a\u0004\u0018\u00010\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u0004\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCaseImpl;", "Lcom/talabat/feature/rating/domain/usecase/ShouldRateLastOrderUseCase;", "getPastOrdersRepository", "Lcom/talabat/feature/rating/domain/repo/GetPastOrdersRepository;", "ratingSession", "Lcom/talabat/feature/rating/domain/repo/RatingSession;", "getPastOrdersRequestParamsProvider", "Lcom/talabat/feature/rating/domain/model/GetPastOrdersRequestParamsProvider;", "(Lcom/talabat/feature/rating/domain/repo/GetPastOrdersRepository;Lcom/talabat/feature/rating/domain/repo/RatingSession;Lcom/talabat/feature/rating/domain/model/GetPastOrdersRequestParamsProvider;)V", "canRate", "", "order", "Lcom/talabat/feature/rating/domain/model/DashboardOrder;", "getEncryptedOrderIdForLastOrder", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastOrder", "isNotPickUpOrder", "isOrderDelivered", "orderStatus", "", "isRatingDismissed", "orderId", "isRatingNotRated", "com_talabat_feature_rating_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ShouldRateLastOrderUseCaseImpl implements ShouldRateLastOrderUseCase {
    @NotNull
    private final GetPastOrdersRepository getPastOrdersRepository;
    @NotNull
    private final GetPastOrdersRequestParamsProvider getPastOrdersRequestParamsProvider;
    @NotNull
    private final RatingSession ratingSession;

    @Inject
    public ShouldRateLastOrderUseCaseImpl(@NotNull GetPastOrdersRepository getPastOrdersRepository2, @NotNull RatingSession ratingSession2, @NotNull GetPastOrdersRequestParamsProvider getPastOrdersRequestParamsProvider2) {
        Intrinsics.checkNotNullParameter(getPastOrdersRepository2, "getPastOrdersRepository");
        Intrinsics.checkNotNullParameter(ratingSession2, "ratingSession");
        Intrinsics.checkNotNullParameter(getPastOrdersRequestParamsProvider2, "getPastOrdersRequestParamsProvider");
        this.getPastOrdersRepository = getPastOrdersRepository2;
        this.ratingSession = ratingSession2;
        this.getPastOrdersRequestParamsProvider = getPastOrdersRequestParamsProvider2;
    }

    private final boolean canRate(DashboardOrder dashboardOrder) {
        if (!isRatingNotRated(dashboardOrder) || !isRatingDismissed(dashboardOrder.getEncryptedOrderId()) || !isNotPickUpOrder(dashboardOrder)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getLastOrder(kotlin.coroutines.Continuation<? super com.talabat.feature.rating.domain.model.DashboardOrder> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getLastOrder$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getLastOrder$1 r0 = (com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getLastOrder$1) r0
            int r1 = r0.f58687j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58687j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getLastOrder$1 r0 = new com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getLastOrder$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f58685h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58687j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0049
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.feature.rating.domain.repo.GetPastOrdersRepository r5 = r4.getPastOrdersRepository
            com.talabat.feature.rating.domain.model.GetPastOrdersRequestParamsProvider r2 = r4.getPastOrdersRequestParamsProvider
            com.talabat.feature.rating.domain.model.GetPastOrdersRequestParams r2 = r2.getPastOrdersRequestParams()
            int r2 = r2.getCountryId()
            r0.f58687j = r3
            java.lang.Object r5 = r5.getPastOrders(r2, r0)
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            com.talabat.feature.rating.domain.model.DashboardOrderResponse r5 = (com.talabat.feature.rating.domain.model.DashboardOrderResponse) r5
            com.talabat.feature.rating.domain.model.DashboardOrderList r5 = r5.getResult()
            java.util.List r5 = r5.getOrders()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0059:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x006e
            java.lang.Object r0 = r5.next()
            r1 = r0
            com.talabat.feature.rating.domain.model.DashboardOrder r1 = (com.talabat.feature.rating.domain.model.DashboardOrder) r1
            boolean r1 = r1.isDineOutOrder()
            r1 = r1 ^ r3
            if (r1 == 0) goto L_0x0059
            goto L_0x006f
        L_0x006e:
            r0 = 0
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl.getLastOrder(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean isNotPickUpOrder(DashboardOrder dashboardOrder) {
        return !dashboardOrder.isPickUpOrder();
    }

    private final boolean isOrderDelivered(int i11) {
        return OrderStatus.DELIVERED.ordinal() == i11;
    }

    private final boolean isRatingDismissed(String str) {
        if (this.ratingSession.isRatingDismissed(str) || this.ratingSession.isRatingShown()) {
            return false;
        }
        return true;
    }

    private final boolean isRatingNotRated(DashboardOrder dashboardOrder) {
        return !dashboardOrder.isOrderRated() && isOrderDelivered(dashboardOrder.getNewOrderStatus());
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getEncryptedOrderIdForLastOrder(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1 r0 = (com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1) r0
            int r1 = r0.f58684k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58684k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1 r0 = new com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl$getEncryptedOrderIdForLastOrder$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f58682i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f58684k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f58681h
            com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl r0 = (com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0044
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.f58681h = r4
            r0.f58684k = r3
            java.lang.Object r5 = r4.getLastOrder(r0)
            if (r5 != r1) goto L_0x0043
            return r1
        L_0x0043:
            r0 = r4
        L_0x0044:
            com.talabat.feature.rating.domain.model.DashboardOrder r5 = (com.talabat.feature.rating.domain.model.DashboardOrder) r5
            if (r5 == 0) goto L_0x0053
            boolean r0 = r0.canRate(r5)
            if (r0 == 0) goto L_0x0053
            java.lang.String r5 = r5.getEncryptedOrderId()
            return r5
        L_0x0053:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.rating.domain.usecase.ShouldRateLastOrderUseCaseImpl.getEncryptedOrderIdForLastOrder(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
