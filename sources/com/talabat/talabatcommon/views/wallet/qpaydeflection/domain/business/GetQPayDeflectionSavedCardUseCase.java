package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionSavedCardUseCase;", "", "checkoutPaymentManagerRepository", "Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;", "getQPayDeflectionBinsUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionBinsUseCase;", "(Lcom/talabat/talabatcommon/views/wallet/checkoutpaymentmanager/domain/repository/CheckoutPaymentManagerRepository;Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionBinsUseCase;)V", "invoke", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBinDetail;", "isQPayServiceDown", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetQPayDeflectionSavedCardUseCase {
    @NotNull
    private final CheckoutPaymentManagerRepository checkoutPaymentManagerRepository;
    @NotNull
    private final GetQPayDeflectionBinsUseCase getQPayDeflectionBinsUseCase;

    public GetQPayDeflectionSavedCardUseCase(@NotNull CheckoutPaymentManagerRepository checkoutPaymentManagerRepository2, @NotNull GetQPayDeflectionBinsUseCase getQPayDeflectionBinsUseCase2) {
        Intrinsics.checkNotNullParameter(checkoutPaymentManagerRepository2, "checkoutPaymentManagerRepository");
        Intrinsics.checkNotNullParameter(getQPayDeflectionBinsUseCase2, "getQPayDeflectionBinsUseCase");
        this.checkoutPaymentManagerRepository = checkoutPaymentManagerRepository2;
        this.getQPayDeflectionBinsUseCase = getQPayDeflectionBinsUseCase2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0088 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a2 A[Catch:{ all -> 0x00ac }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(boolean r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail> r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r20
            boolean r2 = r0 instanceof com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase$invoke$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase$invoke$1 r2 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase$invoke$1) r2
            int r3 = r2.f11923m
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f11923m = r3
            goto L_0x001c
        L_0x0017:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase$invoke$1 r2 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase$invoke$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f11921k
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f11923m
            r5 = 3
            r6 = 1
            r7 = 0
            if (r4 == 0) goto L_0x0041
            if (r4 != r6) goto L_0x0039
            boolean r3 = r2.f11918h
            java.lang.Object r4 = r2.f11920j
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase r4 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase) r4
            java.lang.Object r2 = r2.f11919i
            java.util.List r2 = (java.util.List) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00ac }
            goto L_0x0079
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r0)
            com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository r0 = r1.checkoutPaymentManagerRepository
            java.util.List r0 = r0.getSavedCardList()
            r8 = r0
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.lang.String r9 = ","
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase$invoke$binsCsv$1 r14 = com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase$invoke$binsCsv$1.INSTANCE
            r15 = 30
            r16 = 0
            java.lang.String r4 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            kotlin.Result$Companion r8 = kotlin.Result.Companion     // Catch:{ all -> 0x00ac }
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase r8 = r1.getQPayDeflectionBinsUseCase     // Catch:{ all -> 0x00ac }
            r2.f11919i = r0     // Catch:{ all -> 0x00ac }
            r2.f11920j = r1     // Catch:{ all -> 0x00ac }
            r9 = r19
            r2.f11918h = r9     // Catch:{ all -> 0x00ac }
            r2.f11923m = r6     // Catch:{ all -> 0x00ac }
            java.lang.Object r2 = r8.invoke(r4, r2)     // Catch:{ all -> 0x00ac }
            if (r2 != r3) goto L_0x0072
            return r3
        L_0x0072:
            r4 = r1
            r3 = r9
            r17 = r2
            r2 = r0
            r0 = r17
        L_0x0079:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r0 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail) r0     // Catch:{ all -> 0x00ac }
            java.util.List r8 = r0.getBinsDetails()     // Catch:{ all -> 0x00ac }
            java.util.Collection r8 = (java.util.Collection) r8     // Catch:{ all -> 0x00ac }
            boolean r8 = r8.isEmpty()     // Catch:{ all -> 0x00ac }
            r8 = r8 ^ r6
            if (r8 == 0) goto L_0x00a2
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.mapper.QPayDeflectionMapper r8 = com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.mapper.QPayDeflectionMapper.INSTANCE     // Catch:{ all -> 0x00ac }
            java.util.List r2 = r8.filterQPayBins(r0, r2)     // Catch:{ all -> 0x00ac }
            com.talabat.talabatcommon.views.wallet.checkoutpaymentmanager.domain.repository.CheckoutPaymentManagerRepository r4 = r4.checkoutPaymentManagerRepository     // Catch:{ all -> 0x00ac }
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch:{ all -> 0x00ac }
            java.util.Collection r2 = (java.util.Collection) r2     // Catch:{ all -> 0x00ac }
            r8.<init>(r2)     // Catch:{ all -> 0x00ac }
            r4.setSavedCardList(r8)     // Catch:{ all -> 0x00ac }
            if (r3 == 0) goto L_0x00a7
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r0 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail     // Catch:{ all -> 0x00ac }
            r0.<init>(r7, r7, r5, r7)     // Catch:{ all -> 0x00ac }
            return r0
        L_0x00a2:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r0 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail     // Catch:{ all -> 0x00ac }
            r0.<init>(r7, r7, r5, r7)     // Catch:{ all -> 0x00ac }
        L_0x00a7:
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)     // Catch:{ all -> 0x00ac }
            goto L_0x00b7
        L_0x00ac:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m6329constructorimpl(r0)
        L_0x00b7:
            java.lang.Throwable r2 = kotlin.Result.m6332exceptionOrNullimpl(r0)
            if (r2 == 0) goto L_0x00d9
            kotlin.Pair[] r3 = new kotlin.Pair[r6]
            java.lang.String r2 = r2.getMessage()
            if (r2 != 0) goto L_0x00c7
            java.lang.String r2 = ""
        L_0x00c7:
            java.lang.String r4 = "errorMessage"
            kotlin.Pair r2 = kotlin.TuplesKt.to(r4, r2)
            r4 = 0
            r3[r4] = r2
            java.util.Map r2 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r3)
            java.lang.String r3 = "QPay get bin deflection API failed"
            com.talabat.observability.ObservabilityManager.trackUnExpectedScenario(r3, r2)
        L_0x00d9:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r2 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail
            r2.<init>(r7, r7, r5, r7)
            boolean r3 = kotlin.Result.m6335isFailureimpl(r0)
            if (r3 == 0) goto L_0x00e5
            r0 = r2
        L_0x00e5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionSavedCardUseCase.invoke(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
