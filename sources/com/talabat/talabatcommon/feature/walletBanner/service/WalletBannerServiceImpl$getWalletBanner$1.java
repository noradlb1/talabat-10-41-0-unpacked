package com.talabat.talabatcommon.feature.walletBanner.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.talabatcommon.feature.walletBanner.service.WalletBannerServiceImpl", f = "WalletBannerService.kt", i = {}, l = {14}, m = "getWalletBanner", n = {}, s = {})
public final class WalletBannerServiceImpl$getWalletBanner$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61699h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ WalletBannerServiceImpl f61700i;

    /* renamed from: j  reason: collision with root package name */
    public int f61701j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBannerServiceImpl$getWalletBanner$1(WalletBannerServiceImpl walletBannerServiceImpl, Continuation<? super WalletBannerServiceImpl$getWalletBanner$1> continuation) {
        super(continuation);
        this.f61700i = walletBannerServiceImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61699h = obj;
        this.f61701j |= Integer.MIN_VALUE;
        return this.f61700i.getWalletBanner((String) null, this);
    }
}
