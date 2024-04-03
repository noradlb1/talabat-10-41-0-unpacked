package com.talabat.splash.data.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.splash.data.repositories.SplashConfigurationRepositoryImpl", f = "SplashConfigurationRepositoryImpl.kt", i = {0}, l = {18}, m = "getConfiguration", n = {"this"}, s = {"L$0"})
public final class SplashConfigurationRepositoryImpl$getConfiguration$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61460h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61461i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SplashConfigurationRepositoryImpl f61462j;

    /* renamed from: k  reason: collision with root package name */
    public int f61463k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplashConfigurationRepositoryImpl$getConfiguration$1(SplashConfigurationRepositoryImpl splashConfigurationRepositoryImpl, Continuation<? super SplashConfigurationRepositoryImpl$getConfiguration$1> continuation) {
        super(continuation);
        this.f61462j = splashConfigurationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61461i = obj;
        this.f61463k |= Integer.MIN_VALUE;
        return this.f61462j.getConfiguration(this);
    }
}
