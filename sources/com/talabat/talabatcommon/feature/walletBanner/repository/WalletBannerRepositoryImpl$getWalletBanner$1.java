package com.talabat.talabatcommon.feature.walletBanner.repository;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.walletBanner.repository.WalletBannerRepositoryImpl", f = "WalletBannerRepository.kt", i = {}, l = {16}, m = "getWalletBanner", n = {}, s = {})
public final class WalletBannerRepositoryImpl$getWalletBanner$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61696h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletBannerRepositoryImpl f61697i;

    /* renamed from: j  reason: collision with root package name */
    public int f61698j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBannerRepositoryImpl$getWalletBanner$1(WalletBannerRepositoryImpl walletBannerRepositoryImpl, Continuation<? super WalletBannerRepositoryImpl$getWalletBanner$1> continuation) {
        super(continuation);
        this.f61697i = walletBannerRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61696h = obj;
        this.f61698j |= Integer.MIN_VALUE;
        return this.f61697i.getWalletBanner((String) null, this);
    }
}
