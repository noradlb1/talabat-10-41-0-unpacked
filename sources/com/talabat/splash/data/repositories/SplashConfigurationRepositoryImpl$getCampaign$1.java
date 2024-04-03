package com.talabat.splash.data.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl", f = "SplashConfigurationRepositoryImpl.kt", i = {}, l = {32}, m = "getCampaign", n = {}, s = {})
public final class SplashConfigurationRepositoryImpl$getCampaign$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f61457h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SplashConfigurationRepositoryImpl f61458i;

    /* renamed from: j  reason: collision with root package name */
    public int f61459j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashConfigurationRepositoryImpl$getCampaign$1(SplashConfigurationRepositoryImpl splashConfigurationRepositoryImpl, Continuation<? super SplashConfigurationRepositoryImpl$getCampaign$1> continuation) {
        super(continuation);
        this.f61458i = splashConfigurationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61457h = obj;
        this.f61459j |= Integer.MIN_VALUE;
        return this.f61458i.getCampaign(this);
    }
}
