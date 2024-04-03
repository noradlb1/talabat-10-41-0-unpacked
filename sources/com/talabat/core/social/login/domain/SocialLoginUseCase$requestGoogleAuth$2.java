package com.talabat.core.social.login.domain;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.social.login.domain.SocialLoginUseCase", f = "SocialLoginUseCase.kt", i = {0, 0, 0, 1, 1}, l = {80, 83, 84}, m = "requestGoogleAuth", n = {"this", "registrationBlock", "result", "this", "result"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
public final class SocialLoginUseCase$requestGoogleAuth$2 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55991h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55992i;

    /* renamed from: j  reason: collision with root package name */
    public Object f55993j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f55994k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ SocialLoginUseCase f55995l;

    /* renamed from: m  reason: collision with root package name */
    public int f55996m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialLoginUseCase$requestGoogleAuth$2(SocialLoginUseCase socialLoginUseCase, Continuation<? super SocialLoginUseCase$requestGoogleAuth$2> continuation) {
        super(continuation);
        this.f55995l = socialLoginUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55994k = obj;
        this.f55996m |= Integer.MIN_VALUE;
        return this.f55995l.requestGoogleAuth(0, (Function3<? super String, ? super String, ? super Continuation<? super Unit>, ? extends Object>) null, (Continuation<? super Unit>) this);
    }
}
