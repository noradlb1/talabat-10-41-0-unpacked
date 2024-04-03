package com.talabat.splash.domain.usecase;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.splash.domain.usecase.GetAuthenticationTokenUseCase", f = "GetAuthenticationTokenUseCase.kt", i = {0}, l = {48}, m = "invoke", n = {"this"}, s = {"L$0"})
public final class GetAuthenticationTokenUseCase$invoke$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f61489h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f61490i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ GetAuthenticationTokenUseCase f61491j;

    /* renamed from: k  reason: collision with root package name */
    public int f61492k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetAuthenticationTokenUseCase$invoke$1(GetAuthenticationTokenUseCase getAuthenticationTokenUseCase, Continuation<? super GetAuthenticationTokenUseCase$invoke$1> continuation) {
        super(continuation);
        this.f61491j = getAuthenticationTokenUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f61490i = obj;
        this.f61492k |= Integer.MIN_VALUE;
        return this.f61491j.invoke(this);
    }
}
