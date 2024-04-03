package com.talabat.wallet.walletbalance.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.wallet.walletbalance.data.impl.WalletBalanceRepositoryImpl", f = "WalletBalanceRepositoryImpl.kt", i = {0}, l = {16}, m = "getWalletBalance", n = {"this"}, s = {"L$0"})
public final class WalletBalanceRepositoryImpl$getWalletBalance$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12854h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12855i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ WalletBalanceRepositoryImpl f12856j;

    /* renamed from: k  reason: collision with root package name */
    public int f12857k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBalanceRepositoryImpl$getWalletBalance$1(WalletBalanceRepositoryImpl walletBalanceRepositoryImpl, Continuation<? super WalletBalanceRepositoryImpl$getWalletBalance$1> continuation) {
        super(continuation);
        this.f12856j = walletBalanceRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12855i = obj;
        this.f12857k |= Integer.MIN_VALUE;
        return this.f12856j.getWalletBalance(this);
    }
}
