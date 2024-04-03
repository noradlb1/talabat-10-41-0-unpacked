package com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote;

import dagger.Lazy;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/remote/IncentiveAutoApplyDiscountsRemoteDataSource;", "", "incentiveAutoApplyDiscountsService", "Ldagger/Lazy;", "Lcom/talabat/feature/incentiveautoapplydiscounts/data/datasource/remote/IncentiveAutoApplyDiscountsApi;", "(Ldagger/Lazy;)V", "getAutoApplyDiscounts", "", "Lcom/talabat/feature/incentiveautoapplydiscounts/data/model/AutoApplyDiscountItemResponse;", "autoApplyDiscountsRequest", "Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;", "(Lcom/talabat/feature/incentiveautoapplydiscounts/domain/entity/AutoApplyDiscountsRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_feature_incentive-auto-apply-discounts_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IncentiveAutoApplyDiscountsRemoteDataSource {
    @NotNull
    private final Lazy<IncentiveAutoApplyDiscountsApi> incentiveAutoApplyDiscountsService;

    @Inject
    public IncentiveAutoApplyDiscountsRemoteDataSource(@NotNull Lazy<IncentiveAutoApplyDiscountsApi> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "incentiveAutoApplyDiscountsService");
        this.incentiveAutoApplyDiscountsService = lazy;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getAutoApplyDiscounts(@org.jetbrains.annotations.NotNull com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.util.List<com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountItemResponse>> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1 r0 = (com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1) r0
            int r1 = r0.f58565j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f58565j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1 r0 = new com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource$getAutoApplyDiscounts$1
            r0.<init>(r11, r13)
        L_0x0018:
            r9 = r0
            java.lang.Object r13 = r9.f58563h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f58565j
            r10 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r10) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005f
        L_0x002a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r13)
            dagger.Lazy<com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsApi> r13 = r11.incentiveAutoApplyDiscountsService
            java.lang.Object r13 = r13.get()
            r1 = r13
            com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsApi r1 = (com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsApi) r1
            int r2 = r12.getCountryId()
            int r3 = r12.getAreaId()
            int r4 = r12.getBrandId()
            int r5 = r12.getBranchId()
            double r6 = r12.getSubTotalAmount()
            int r8 = r12.getOrderDeliveryMode()
            r9.f58565j = r10
            java.lang.Object r13 = r1.getAutoApplyDiscounts(r2, r3, r4, r5, r6, r8, r9)
            if (r13 != r0) goto L_0x005f
            return r0
        L_0x005f:
            com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountResponse r13 = (com.talabat.feature.incentiveautoapplydiscounts.data.model.AutoApplyDiscountResponse) r13
            java.util.List r12 = r13.getResult()
            r13 = r12
            java.util.Collection r13 = (java.util.Collection) r13
            if (r13 == 0) goto L_0x0073
            boolean r13 = r13.isEmpty()
            if (r13 == 0) goto L_0x0071
            goto L_0x0073
        L_0x0071:
            r13 = 0
            goto L_0x0074
        L_0x0073:
            r13 = r10
        L_0x0074:
            r13 = r13 ^ r10
            if (r13 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r12 = 0
        L_0x0079:
            if (r12 == 0) goto L_0x007c
            return r12
        L_0x007c:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r13 = "Empty list"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.feature.incentiveautoapplydiscounts.data.datasource.remote.IncentiveAutoApplyDiscountsRemoteDataSource.getAutoApplyDiscounts(com.talabat.feature.incentiveautoapplydiscounts.domain.entity.AutoApplyDiscountsRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
