package com.talabat.feature.walletcobrandedcc.data.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource", f = "WalletCobrandedCcRemoteDataSource.kt", i = {}, l = {16}, m = "getWalletStatus", n = {}, s = {})
public final class WalletCobrandedCcRemoteDataSource$getWalletStatus$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59447h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletCobrandedCcRemoteDataSource f59448i;

    /* renamed from: j  reason: collision with root package name */
    public int f59449j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCobrandedCcRemoteDataSource$getWalletStatus$1(WalletCobrandedCcRemoteDataSource walletCobrandedCcRemoteDataSource, Continuation<? super WalletCobrandedCcRemoteDataSource$getWalletStatus$1> continuation) {
        super(continuation);
        this.f59448i = walletCobrandedCcRemoteDataSource;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59447h = obj;
        this.f59449j |= Integer.MIN_VALUE;
        return this.f59448i.getWalletStatus(0, this);
    }
}
