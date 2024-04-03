package com.talabat.wallet.walletbalance.data.impl;

import com.talabat.wallet.walletbalance.data.local.WalletBalanceLocalSource;
import com.talabat.wallet.walletbalance.data.remote.WalletBalanceRemoteSource;
import com.talabat.wallet.walletbalance.domain.repository.WalletBalanceRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/walletbalance/data/impl/WalletBalanceRepositoryImpl;", "Lcom/talabat/wallet/walletbalance/domain/repository/WalletBalanceRepository;", "walletBalanceRemoteSource", "Lcom/talabat/wallet/walletbalance/data/remote/WalletBalanceRemoteSource;", "walletBalanceLocalSource", "Lcom/talabat/wallet/walletbalance/data/local/WalletBalanceLocalSource;", "(Lcom/talabat/wallet/walletbalance/data/remote/WalletBalanceRemoteSource;Lcom/talabat/wallet/walletbalance/data/local/WalletBalanceLocalSource;)V", "getWalletBalance", "Lcom/talabat/wallet/walletbalance/domain/entity/WalletBalance;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceRepositoryImpl implements WalletBalanceRepository {
    @NotNull
    private final WalletBalanceLocalSource walletBalanceLocalSource;
    @NotNull
    private final WalletBalanceRemoteSource walletBalanceRemoteSource;

    public WalletBalanceRepositoryImpl(@NotNull WalletBalanceRemoteSource walletBalanceRemoteSource2, @NotNull WalletBalanceLocalSource walletBalanceLocalSource2) {
        Intrinsics.checkNotNullParameter(walletBalanceRemoteSource2, "walletBalanceRemoteSource");
        Intrinsics.checkNotNullParameter(walletBalanceLocalSource2, "walletBalanceLocalSource");
        this.walletBalanceRemoteSource = walletBalanceRemoteSource2;
        this.walletBalanceLocalSource = walletBalanceLocalSource2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getWalletBalance(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.walletbalance.domain.entity.WalletBalance> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl$getWalletBalance$1
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl$getWalletBalance$1 r0 = (com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl$getWalletBalance$1) r0
            int r1 = r0.f12857k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12857k = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl$getWalletBalance$1 r0 = new com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl$getWalletBalance$1
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f12855i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12857k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.f12854h
            com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl r0 = (com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0046
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            com.talabat.wallet.walletbalance.data.remote.WalletBalanceRemoteSource r5 = r4.walletBalanceRemoteSource
            r0.f12854h = r4
            r0.f12857k = r3
            java.lang.Object r5 = r5.getWalletBalance(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r4
        L_0x0046:
            com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse r5 = (com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse) r5
            com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResultModel r5 = r5.getResult()
            if (r5 == 0) goto L_0x0053
            java.lang.Float r5 = r5.getBalanceAmount()
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            float r5 = com.talabat.talabatcommon.extentions.FloatKt.orZero((java.lang.Float) r5)
            com.talabat.wallet.walletbalance.domain.entity.WalletBalance r1 = new com.talabat.wallet.walletbalance.domain.entity.WalletBalance
            r1.<init>(r5)
            com.talabat.wallet.walletbalance.data.local.WalletBalanceLocalSource r5 = r0.walletBalanceLocalSource
            float r0 = r1.getBalance()
            r5.setWalletBalance(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl.getWalletBalance(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
