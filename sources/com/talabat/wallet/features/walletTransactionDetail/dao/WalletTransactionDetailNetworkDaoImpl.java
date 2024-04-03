package com.talabat.wallet.features.walletTransactionDetail.dao;

import com.talabat.wallet.features.walletTransactionDetail.network.WalletTransactionDetailApi;
import com.talabat.wallet.features.walletTransactionDetail.network.WalletTransactionDetailRetrofitBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionDetail/dao/WalletTransactionDetailNetworkDaoImpl;", "Lcom/talabat/wallet/features/walletTransactionDetail/dao/WalletTransactionDetailNetworkDao;", "walletTransactionDetailApi", "Lcom/talabat/wallet/features/walletTransactionDetail/network/WalletTransactionDetailApi;", "(Lcom/talabat/wallet/features/walletTransactionDetail/network/WalletTransactionDetailApi;)V", "getWalletTransactionDetail", "Lcom/talabat/wallet/features/walletTransactionDetail/model/WalletTransactionDetail;", "transactionType", "", "transactionId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletTransactionDetailNetworkDaoImpl implements WalletTransactionDetailNetworkDao {
    @NotNull
    private final WalletTransactionDetailApi walletTransactionDetailApi;

    public WalletTransactionDetailNetworkDaoImpl() {
        this((WalletTransactionDetailApi) null, 1, (DefaultConstructorMarker) null);
    }

    public WalletTransactionDetailNetworkDaoImpl(@NotNull WalletTransactionDetailApi walletTransactionDetailApi2) {
        Intrinsics.checkNotNullParameter(walletTransactionDetailApi2, "walletTransactionDetailApi");
        this.walletTransactionDetailApi = walletTransactionDetailApi2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getWalletTransactionDetail(int r9, int r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1 r0 = (com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1) r0
            int r1 = r0.f12597j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12597j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1 r0 = new com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1
            r0.<init>(r8, r11)
        L_0x0018:
            r5 = r0
            java.lang.Object r11 = r5.f12595h
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.f12597j
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0046
        L_0x002a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r11)
            com.talabat.wallet.features.walletTransactionDetail.network.WalletTransactionDetailApi r1 = r8.walletTransactionDetailApi
            r11 = 0
            r6 = 1
            r7 = 0
            r5.f12597j = r2
            r2 = r11
            r3 = r9
            r4 = r10
            java.lang.Object r11 = com.talabat.wallet.features.walletTransactionDetail.network.WalletTransactionDetailApi.DefaultImpls.getWalletTransactionDetail$default(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L_0x0046
            return r0
        L_0x0046:
            com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailResponse r11 = (com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetailResponse) r11
            com.talabat.wallet.features.walletTransactionDetail.model.WalletTransactionDetail r9 = r11.getResult()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl.getWalletTransactionDetail(int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WalletTransactionDetailNetworkDaoImpl(WalletTransactionDetailApi walletTransactionDetailApi2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? WalletTransactionDetailRetrofitBuilder.INSTANCE.getWalletDetailApi() : walletTransactionDetailApi2);
    }
}
