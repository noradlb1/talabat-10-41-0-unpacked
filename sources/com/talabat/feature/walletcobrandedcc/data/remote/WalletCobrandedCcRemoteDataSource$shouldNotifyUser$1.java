package com.talabat.feature.walletcobrandedcc.data.remote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.walletcobrandedcc.data.remote.WalletCobrandedCcRemoteDataSource", f = "WalletCobrandedCcRemoteDataSource.kt", i = {}, l = {10}, m = "shouldNotifyUser", n = {}, s = {})
public final class WalletCobrandedCcRemoteDataSource$shouldNotifyUser$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59450h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletCobrandedCcRemoteDataSource f59451i;

    /* renamed from: j  reason: collision with root package name */
    public int f59452j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCobrandedCcRemoteDataSource$shouldNotifyUser$1(WalletCobrandedCcRemoteDataSource walletCobrandedCcRemoteDataSource, Continuation<? super WalletCobrandedCcRemoteDataSource$shouldNotifyUser$1> continuation) {
        super(continuation);
        this.f59451i = walletCobrandedCcRemoteDataSource;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59450h = obj;
        this.f59452j |= Integer.MIN_VALUE;
        return this.f59451i.shouldNotifyUser(0, this);
    }
}
