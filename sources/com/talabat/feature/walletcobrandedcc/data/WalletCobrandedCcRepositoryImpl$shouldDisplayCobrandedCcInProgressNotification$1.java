package com.talabat.feature.walletcobrandedcc.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.feature.walletcobrandedcc.data.WalletCobrandedCcRepositoryImpl", f = "WalletCobrandedCcRepositoryImpl.kt", i = {}, l = {26}, m = "shouldDisplayCobrandedCcInProgressNotification", n = {}, s = {})
public final class WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f59444h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletCobrandedCcRepositoryImpl f59445i;

    /* renamed from: j  reason: collision with root package name */
    public int f59446j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1(WalletCobrandedCcRepositoryImpl walletCobrandedCcRepositoryImpl, Continuation<? super WalletCobrandedCcRepositoryImpl$shouldDisplayCobrandedCcInProgressNotification$1> continuation) {
        super(continuation);
        this.f59445i = walletCobrandedCcRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f59444h = obj;
        this.f59446j |= Integer.MIN_VALUE;
        return this.f59445i.shouldDisplayCobrandedCcInProgressNotification(this);
    }
}
