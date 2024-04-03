package com.talabat.splash.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.splash.domain.usecase.GetDynamicSplashContentUseCase", f = "GetDynamicSplashContentUseCase.kt", i = {0, 1, 1}, l = {17, 25}, m = "getDynamicSplashContent", n = {"this", "this", "configuration"}, s = {"L$0", "L$0", "L$1"})
public final class GetDynamicSplashContentUseCase$getDynamicSplashContent$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61493h;

    /* renamed from: i  reason: collision with root package name */
    public Object f61494i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f61495j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GetDynamicSplashContentUseCase f61496k;

    /* renamed from: l  reason: collision with root package name */
    public int f61497l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetDynamicSplashContentUseCase$getDynamicSplashContent$1(GetDynamicSplashContentUseCase getDynamicSplashContentUseCase, Continuation<? super GetDynamicSplashContentUseCase$getDynamicSplashContent$1> continuation) {
        super(continuation);
        this.f61496k = getDynamicSplashContentUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61495j = obj;
        this.f61497l |= Integer.MIN_VALUE;
        return this.f61496k.getDynamicSplashContent(this);
    }
}
