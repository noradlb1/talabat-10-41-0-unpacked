package com.talabat.feature.walletcobrandedcc.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl", f = "WalletCobrandedCcRepositoryImpl.kt", i = {}, l = {30}, m = "getWalletStatus", n = {}, s = {})
public final class WalletCobrandedCcRepositoryImpl$getWalletStatus$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59441h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletCobrandedCcRepositoryImpl f59442i;

    /* renamed from: j  reason: collision with root package name */
    public int f59443j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCobrandedCcRepositoryImpl$getWalletStatus$1(WalletCobrandedCcRepositoryImpl walletCobrandedCcRepositoryImpl, Continuation<? super WalletCobrandedCcRepositoryImpl$getWalletStatus$1> continuation) {
        super(continuation);
        this.f59442i = walletCobrandedCcRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59441h = obj;
        this.f59443j |= Integer.MIN_VALUE;
        return this.f59442i.getWalletStatus(this);
    }
}
