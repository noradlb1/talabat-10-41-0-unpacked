package com.talabat.wallet.features.walletTransactionDetail.dao;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.features.walletTransactionDetail.dao.WalletTransactionDetailNetworkDaoImpl", f = "WalletTransactionDetailNetworkDaoImpl.kt", i = {}, l = {15}, m = "getWalletTransactionDetail", n = {}, s = {})
public final class WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f12595h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletTransactionDetailNetworkDaoImpl f12596i;

    /* renamed from: j  reason: collision with root package name */
    public int f12597j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1(WalletTransactionDetailNetworkDaoImpl walletTransactionDetailNetworkDaoImpl, Continuation<? super WalletTransactionDetailNetworkDaoImpl$getWalletTransactionDetail$1> continuation) {
        super(continuation);
        this.f12596i = walletTransactionDetailNetworkDaoImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12595h = obj;
        this.f12597j |= Integer.MIN_VALUE;
        return this.f12596i.getWalletTransactionDetail(0, 0, this);
    }
}
