package com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business;

import com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.repository.QPayDeflectionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayServiceDownUseCase;", "", "qPayDeflectionRepository", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/repository/QPayDeflectionRepository;", "isQPayFallbackEnabled", "Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayFallbackEnabled;", "(Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/repository/QPayDeflectionRepository;Lcom/talabat/talabatcommon/views/wallet/qpaydeflection/domain/business/IsQPayFallbackEnabled;)V", "invoke", "", "isDebitCardAccepted", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class IsQPayServiceDownUseCase {
    @NotNull
    private final IsQPayFallbackEnabled isQPayFallbackEnabled;
    @NotNull
    private final QPayDeflectionRepository qPayDeflectionRepository;

    public IsQPayServiceDownUseCase(@NotNull QPayDeflectionRepository qPayDeflectionRepository2, @NotNull IsQPayFallbackEnabled isQPayFallbackEnabled2) {
        Intrinsics.checkNotNullParameter(qPayDeflectionRepository2, "qPayDeflectionRepository");
        Intrinsics.checkNotNullParameter(isQPayFallbackEnabled2, "isQPayFallbackEnabled");
        this.qPayDeflectionRepository = qPayDeflectionRepository2;
        this.isQPayFallbackEnabled = isQPayFallbackEnabled2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(boolean r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase$invoke$1 r0 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase$invoke$1) r0
            int r1 = r0.f11928l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f11928l = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase$invoke$1 r0 = new com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase$invoke$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f11926j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f11928l
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 == r5) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006f
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            boolean r7 = r0.f11925i
            java.lang.Object r2 = r0.f11924h
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase r2 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0052
        L_0x003f:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayFallbackEnabled r8 = r6.isQPayFallbackEnabled
            r0.f11924h = r6
            r0.f11925i = r7
            r0.f11928l = r5
            java.lang.Object r8 = r8.invoke(r0)
            if (r8 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r2 = r6
        L_0x0052:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 != 0) goto L_0x005f
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        L_0x005f:
            if (r7 == 0) goto L_0x0088
            com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.repository.QPayDeflectionRepository r7 = r2.qPayDeflectionRepository
            r8 = 0
            r0.f11924h = r8
            r0.f11928l = r3
            java.lang.Object r8 = r7.isServiceDown(r0)
            if (r8 != r1) goto L_0x006f
            return r1
        L_0x006f:
            com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayStatusResponseDto r8 = (com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayStatusResponseDto) r8
            com.talabat.talabatcommon.views.wallet.qpaydeflection.data.remote.dto.QPayStatusResultDto r7 = r8.getQPayStatusResultDto()
            if (r7 == 0) goto L_0x0084
            java.lang.Boolean r7 = r7.isServiceDown()
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            goto L_0x0085
        L_0x0084:
            r7 = r4
        L_0x0085:
            if (r7 == 0) goto L_0x0088
            r4 = r5
        L_0x0088:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.views.wallet.qpaydeflection.domain.business.IsQPayServiceDownUseCase.invoke(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
