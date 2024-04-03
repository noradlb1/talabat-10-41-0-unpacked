package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.application.GetQPayDeflectionEnabledUseCase;
import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.repository.QPayDeflectionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/GetQPayDeflectionBinsUseCase;", "", "qPayDeflectionRepository", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/repository/QPayDeflectionRepository;", "getQPayDeflectionEnabledUseCase", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/application/GetQPayDeflectionEnabledUseCase;", "(Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/repository/QPayDeflectionRepository;Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/application/GetQPayDeflectionEnabledUseCase;)V", "invoke", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/entity/QPayDeflectionBinDetail;", "binsCsv", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetQPayDeflectionBinsUseCase {
    @NotNull
    private final GetQPayDeflectionEnabledUseCase getQPayDeflectionEnabledUseCase;
    @NotNull
    private final QPayDeflectionRepository qPayDeflectionRepository;

    public GetQPayDeflectionBinsUseCase(@NotNull QPayDeflectionRepository qPayDeflectionRepository2, @NotNull GetQPayDeflectionEnabledUseCase getQPayDeflectionEnabledUseCase2) {
        Intrinsics.checkNotNullParameter(qPayDeflectionRepository2, "qPayDeflectionRepository");
        Intrinsics.checkNotNullParameter(getQPayDeflectionEnabledUseCase2, "getQPayDeflectionEnabledUseCase");
        this.qPayDeflectionRepository = qPayDeflectionRepository2;
        this.getQPayDeflectionEnabledUseCase = getQPayDeflectionEnabledUseCase2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064 A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase$invoke$1 r0 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase$invoke$1) r0
            int r1 = r0.f11917l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11917l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase$invoke$1 r0 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase$invoke$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f11915j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f11917l
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0046
            if (r2 == r5) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r9 = r0.f11913h
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.mapper.QPayDeflectionMapper r9 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.mapper.QPayDeflectionMapper) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0089 }
            goto L_0x0078
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003a:
            java.lang.Object r9 = r0.f11914i
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase r9 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase) r9
            java.lang.Object r2 = r0.f11913h
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0089 }
            goto L_0x005c
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.Result$Companion r10 = kotlin.Result.Companion     // Catch:{ all -> 0x0089 }
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.application.GetQPayDeflectionEnabledUseCase r10 = r8.getQPayDeflectionEnabledUseCase     // Catch:{ all -> 0x0089 }
            r0.f11913h = r9     // Catch:{ all -> 0x0089 }
            r0.f11914i = r8     // Catch:{ all -> 0x0089 }
            r0.f11917l = r5     // Catch:{ all -> 0x0089 }
            java.lang.Object r10 = r10.invoke(r0)     // Catch:{ all -> 0x0089 }
            if (r10 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r2 = r9
            r9 = r8
        L_0x005c:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0089 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0089 }
            if (r10 == 0) goto L_0x007f
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.mapper.QPayDeflectionMapper r10 = com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.mapper.QPayDeflectionMapper.INSTANCE     // Catch:{ all -> 0x0089 }
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.repository.QPayDeflectionRepository r9 = r9.qPayDeflectionRepository     // Catch:{ all -> 0x0089 }
            r0.f11913h = r10     // Catch:{ all -> 0x0089 }
            r0.f11914i = r6     // Catch:{ all -> 0x0089 }
            r0.f11917l = r4     // Catch:{ all -> 0x0089 }
            java.lang.Object r9 = r9.getBins(r2, r0)     // Catch:{ all -> 0x0089 }
            if (r9 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0078:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayDeflectionBinsResponseDto r10 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayDeflectionBinsResponseDto) r10     // Catch:{ all -> 0x0089 }
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r9 = r9.mapToQPayDeflectionBinDetail(r10)     // Catch:{ all -> 0x0089 }
            goto L_0x0084
        L_0x007f:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r9 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail     // Catch:{ all -> 0x0089 }
            r9.<init>(r6, r6, r3, r6)     // Catch:{ all -> 0x0089 }
        L_0x0084:
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)     // Catch:{ all -> 0x0089 }
            goto L_0x0094
        L_0x0089:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m6329constructorimpl(r9)
        L_0x0094:
            java.lang.Throwable r10 = kotlin.Result.m6332exceptionOrNullimpl(r9)
            if (r10 == 0) goto L_0x00b6
            kotlin.Pair[] r0 = new kotlin.Pair[r5]
            java.lang.String r10 = r10.getMessage()
            if (r10 != 0) goto L_0x00a4
            java.lang.String r10 = ""
        L_0x00a4:
            java.lang.String r1 = "errorMessage"
            kotlin.Pair r10 = kotlin.TuplesKt.to(r1, r10)
            r1 = 0
            r0[r1] = r10
            java.util.Map r10 = kotlin.collections.MapsKt__MapsKt.mutableMapOf(r0)
            java.lang.String r0 = "QPay get bin deflection API failed"
            com.talabat.observability.ObservabilityManager.trackUnExpectedScenario(r0, r10)
        L_0x00b6:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail r10 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.entity.QPayDeflectionBinDetail
            r10.<init>(r6, r6, r3, r6)
            boolean r0 = kotlin.Result.m6335isFailureimpl(r9)
            if (r0 == 0) goto L_0x00c2
            r9 = r10
        L_0x00c2:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.GetQPayDeflectionBinsUseCase.invoke(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
