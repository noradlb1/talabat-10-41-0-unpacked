package com.talabat.talabatcommon.feature.walletCardManagement;

import com.talabat.talabatcommon.feature.walletCardManagement.repository.WalletCardManagementRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/GetDeleteWalletCardUseCase;", "", "walletCardManagementRepository", "Lcom/talabat/talabatcommon/feature/walletCardManagement/repository/WalletCardManagementRepository;", "sendDeletedSuccessEventUseCase", "Lcom/talabat/talabatcommon/feature/walletCardManagement/SendCardDeletedSuccessEventUseCase;", "sendCardDeletedFailedEventUseCase", "Lcom/talabat/talabatcommon/feature/walletCardManagement/SendCardDeletedFailedEventUseCase;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/repository/WalletCardManagementRepository;Lcom/talabat/talabatcommon/feature/walletCardManagement/SendCardDeletedSuccessEventUseCase;Lcom/talabat/talabatcommon/feature/walletCardManagement/SendCardDeletedFailedEventUseCase;)V", "invoke", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "walletDeleteCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetDeleteWalletCardUseCase {
    @NotNull
    private final SendCardDeletedFailedEventUseCase sendCardDeletedFailedEventUseCase;
    @NotNull
    private final SendCardDeletedSuccessEventUseCase sendDeletedSuccessEventUseCase;
    @NotNull
    private final WalletCardManagementRepository walletCardManagementRepository;

    public GetDeleteWalletCardUseCase(@NotNull WalletCardManagementRepository walletCardManagementRepository2, @NotNull SendCardDeletedSuccessEventUseCase sendCardDeletedSuccessEventUseCase, @NotNull SendCardDeletedFailedEventUseCase sendCardDeletedFailedEventUseCase2) {
        Intrinsics.checkNotNullParameter(walletCardManagementRepository2, "walletCardManagementRepository");
        Intrinsics.checkNotNullParameter(sendCardDeletedSuccessEventUseCase, "sendDeletedSuccessEventUseCase");
        Intrinsics.checkNotNullParameter(sendCardDeletedFailedEventUseCase2, "sendCardDeletedFailedEventUseCase");
        this.walletCardManagementRepository = walletCardManagementRepository2;
        this.sendDeletedSuccessEventUseCase = sendCardDeletedSuccessEventUseCase;
        this.sendCardDeletedFailedEventUseCase = sendCardDeletedFailedEventUseCase2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase$invoke$1 r0 = (com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase$invoke$1) r0
            int r1 = r0.f61710k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61710k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase$invoke$1 r0 = new com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase$invoke$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f61708i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f61710k
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 == r5) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            goto L_0x0034
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            java.lang.Object r7 = r0.f61707h
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult r7 = (com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0073
        L_0x003c:
            java.lang.Object r7 = r0.f61707h
            com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase r7 = (com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0055
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            com.talabat.talabatcommon.feature.walletCardManagement.repository.WalletCardManagementRepository r8 = r6.walletCardManagementRepository
            r0.f61707h = r6
            r0.f61710k = r5
            java.lang.Object r8 = r8.deleteCard(r7, r0)
            if (r8 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r7 = r6
        L_0x0055:
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult r8 = (com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult) r8
            java.lang.Boolean r2 = r8.isSuccessful()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 == 0) goto L_0x0075
            com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeletedSuccessEventUseCase r7 = r7.sendDeletedSuccessEventUseCase
            r0.f61707h = r8
            r0.f61710k = r4
            java.lang.Object r7 = r7.invoke(r0)
            if (r7 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r7 = r8
        L_0x0073:
            r8 = r7
            goto L_0x0094
        L_0x0075:
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardErrorResult r2 = r8.getError()
            if (r2 == 0) goto L_0x0094
            com.talabat.talabatcommon.feature.walletCardManagement.SendCardDeletedFailedEventUseCase r7 = r7.sendCardDeletedFailedEventUseCase
            java.lang.String r4 = r2.getTitle()
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardError r2 = r2.getCode()
            java.lang.String r2 = r2.getValue()
            r0.f61707h = r8
            r0.f61710k = r3
            java.lang.Object r7 = r7.invoke(r2, r4, r0)
            if (r7 != r1) goto L_0x0072
            return r1
        L_0x0094:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletCardManagement.GetDeleteWalletCardUseCase.invoke(com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
