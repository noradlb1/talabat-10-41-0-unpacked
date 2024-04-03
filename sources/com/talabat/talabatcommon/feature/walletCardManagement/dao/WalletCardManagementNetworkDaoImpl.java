package com.talabat.talabatcommon.feature.walletCardManagement.dao;

import com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletAddCardRequestModel;
import com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletAddCardResponse;
import com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletCardManagement/dao/WalletCardManagementNetworkDaoImpl;", "Lcom/talabat/talabatcommon/feature/walletCardManagement/dao/WalletCardManagementNetworkDao;", "walletCardManagementApi", "Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/network/WalletCardManagementApi;)V", "addCardToWallet", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletAddCardResponse;", "walletAddCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletAddCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletDeleteCardResult;", "walletDeleteCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletDeleteCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setDefaultCard", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/response/WalletSetDefaultCardResult;", "walletSetDefaultCardRequestModel", "Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;", "(Lcom/talabat/talabatcommon/feature/walletCardManagement/model/request/WalletSetDefaultCardRequestModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCardManagementNetworkDaoImpl implements WalletCardManagementNetworkDao {
    @NotNull
    private final WalletCardManagementApi walletCardManagementApi;

    public WalletCardManagementNetworkDaoImpl(@NotNull WalletCardManagementApi walletCardManagementApi2) {
        Intrinsics.checkNotNullParameter(walletCardManagementApi2, "walletCardManagementApi");
        this.walletCardManagementApi = walletCardManagementApi2;
    }

    @Nullable
    public Object addCardToWallet(@NotNull WalletAddCardRequestModel walletAddCardRequestModel, @NotNull Continuation<? super WalletAddCardResponse> continuation) {
        return WalletCardManagementApi.DefaultImpls.addCardToWallet$default(this.walletCardManagementApi, 0, walletAddCardRequestModel, continuation, 1, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object deleteCard(@org.jetbrains.annotations.NotNull com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$deleteCard$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$deleteCard$1 r0 = (com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$deleteCard$1) r0
            int r1 = r0.f61721j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61721j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$deleteCard$1 r0 = new com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$deleteCard$1
            r0.<init>(r7, r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f61719h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f61721j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0045
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi r1 = r7.walletCardManagementApi
            r9 = 0
            r5 = 1
            r6 = 0
            r4.f61721j = r2
            r2 = r9
            r3 = r8
            java.lang.Object r9 = com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi.DefaultImpls.deleteCard$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0045
            return r0
        L_0x0045:
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResponse r9 = (com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResponse) r9
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult r8 = r9.getResult()
            if (r8 != 0) goto L_0x0058
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult r8 = new com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletDeleteCardResult
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0058:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl.deleteCard(com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletDeleteCardRequestModel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setDefaultCard(@org.jetbrains.annotations.NotNull com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$setDefaultCard$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$setDefaultCard$1 r0 = (com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$setDefaultCard$1) r0
            int r1 = r0.f61724j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f61724j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$setDefaultCard$1 r0 = new com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl$setDefaultCard$1
            r0.<init>(r7, r9)
        L_0x0018:
            r4 = r0
            java.lang.Object r9 = r4.f61722h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.f61724j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0045
        L_0x002a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi r1 = r7.walletCardManagementApi
            r9 = 0
            r5 = 1
            r6 = 0
            r4.f61724j = r2
            r2 = r9
            r3 = r8
            java.lang.Object r9 = com.talabat.talabatcommon.feature.walletCardManagement.network.WalletCardManagementApi.DefaultImpls.setDefaultCard$default(r1, r2, r3, r4, r5, r6)
            if (r9 != r0) goto L_0x0045
            return r0
        L_0x0045:
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResponse r9 = (com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResponse) r9
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult r8 = r9.getResult()
            if (r8 != 0) goto L_0x0058
            com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult r8 = new com.talabat.talabatcommon.feature.walletCardManagement.model.response.WalletSetDefaultCardResult
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 7
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0058:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.walletCardManagement.dao.WalletCardManagementNetworkDaoImpl.setDefaultCard(com.talabat.talabatcommon.feature.walletCardManagement.model.request.WalletSetDefaultCardRequestModel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
