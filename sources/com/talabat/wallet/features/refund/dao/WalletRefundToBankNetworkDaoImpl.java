package com.talabat.wallet.features.refund.dao;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.wallet.features.refund.network.WalletRefundToBankApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/talabat/wallet/features/refund/dao/WalletRefundToBankNetworkDaoImpl;", "Lcom/talabat/wallet/features/refund/dao/WalletRefundToBankNetworkDao;", "walletRefundApi", "Lcom/talabat/wallet/features/refund/network/WalletRefundToBankApi;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "(Lcom/talabat/wallet/features/refund/network/WalletRefundToBankApi;Lcom/talabat/configuration/ConfigurationLocalRepository;)V", "getCanRefundToBankStatus", "", "orderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refundToBankStatus", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletRefundToBankNetworkDaoImpl implements WalletRefundToBankNetworkDao {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final WalletRefundToBankApi walletRefundApi;

    public WalletRefundToBankNetworkDaoImpl(@NotNull WalletRefundToBankApi walletRefundToBankApi, @NotNull ConfigurationLocalRepository configurationLocalRepository2) {
        Intrinsics.checkNotNullParameter(walletRefundToBankApi, "walletRefundApi");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        this.walletRefundApi = walletRefundToBankApi;
        this.configurationLocalRepository = configurationLocalRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCanRefundToBankStatus(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$getCanRefundToBankStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$getCanRefundToBankStatus$1 r0 = (com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$getCanRefundToBankStatus$1) r0
            int r1 = r0.f12585j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12585j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$getCanRefundToBankStatus$1 r0 = new com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$getCanRefundToBankStatus$1
            r0.<init>(r8, r10)
        L_0x0018:
            r5 = r0
            java.lang.Object r10 = r5.f12583h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f12585j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x004f
        L_0x002a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            com.talabat.wallet.features.refund.network.WalletRefundToBankApi r1 = r8.walletRefundApi
            r10 = 0
            com.talabat.configuration.ConfigurationLocalRepository r3 = r8.configurationLocalRepository
            com.talabat.configuration.country.Country r3 = r3.selectedCountry()
            int r4 = r3.getCountryId()
            r6 = 1
            r7 = 0
            r5.f12585j = r2
            r2 = r10
            r3 = r9
            java.lang.Object r10 = com.talabat.wallet.features.refund.network.WalletRefundToBankApi.DefaultImpls.getCanRefundToBankStatus$default(r1, r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L_0x004f
            return r0
        L_0x004f:
            com.talabat.wallet.features.refund.model.WalletRefundCanRevertToBankResponse r10 = (com.talabat.wallet.features.refund.model.WalletRefundCanRevertToBankResponse) r10
            java.lang.Boolean r9 = r10.getResult()
            if (r9 == 0) goto L_0x005c
            boolean r9 = r9.booleanValue()
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl.getCanRefundToBankStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object refundToBankStatus(@org.jetbrains.annotations.NotNull java.lang.String r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Boolean> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1 r0 = (com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1) r0
            int r1 = r0.f12588j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12588j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1 r0 = new com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl$refundToBankStatus$1
            r0.<init>(r8, r10)
        L_0x0018:
            r5 = r0
            java.lang.Object r10 = r5.f12586h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f12588j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x004f
        L_0x002a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r10)
            com.talabat.wallet.features.refund.network.WalletRefundToBankApi r1 = r8.walletRefundApi
            r10 = 0
            com.talabat.configuration.ConfigurationLocalRepository r3 = r8.configurationLocalRepository
            com.talabat.configuration.country.Country r3 = r3.selectedCountry()
            int r4 = r3.getCountryId()
            r6 = 1
            r7 = 0
            r5.f12588j = r2
            r2 = r10
            r3 = r9
            java.lang.Object r10 = com.talabat.wallet.features.refund.network.WalletRefundToBankApi.DefaultImpls.refundToBank$default(r1, r2, r3, r4, r5, r6, r7)
            if (r10 != r0) goto L_0x004f
            return r0
        L_0x004f:
            com.talabat.wallet.features.refund.model.WalletRefundRevertToBankResponse r10 = (com.talabat.wallet.features.refund.model.WalletRefundRevertToBankResponse) r10
            java.lang.Boolean r9 = r10.getResult()
            if (r9 == 0) goto L_0x005c
            boolean r9 = r9.booleanValue()
            goto L_0x005d
        L_0x005c:
            r9 = 0
        L_0x005d:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.features.refund.dao.WalletRefundToBankNetworkDaoImpl.refundToBankStatus(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
