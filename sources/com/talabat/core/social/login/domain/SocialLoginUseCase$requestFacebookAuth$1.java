package com.talabat.core.social.login.domain;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.social.login.domain.SocialLoginUseCase", f = "SocialLoginUseCase.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {45, 48, 49}, m = "requestFacebookAuth", n = {"this", "registrationBlock", "email", "token", "facebookUserData", "this", "email", "token", "facebookUserData", "facebookUserData"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0"})
public final class SocialLoginUseCase$requestFacebookAuth$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55983h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55984i;

    /* renamed from: j  reason: collision with root package name */
    public Object f55985j;

    /* renamed from: k  reason: collision with root package name */
    public Object f55986k;

    /* renamed from: l  reason: collision with root package name */
    public Object f55987l;

    /* renamed from: m  reason: collision with root package name */
    public /* synthetic */ Object f55988m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ SocialLoginUseCase f55989n;

    /* renamed from: o  reason: collision with root package name */
    public int f55990o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialLoginUseCase$requestFacebookAuth$1(SocialLoginUseCase socialLoginUseCase, Continuation<? super SocialLoginUseCase$requestFacebookAuth$1> continuation) {
        super(continuation);
        this.f55989n = socialLoginUseCase;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55988m = obj;
        this.f55990o |= Integer.MIN_VALUE;
        return this.f55989n.requestFacebookAuth((Activity) null, (Function2<? super FacebookUserData, ? super Continuation<? super Unit>, ? extends Object>) null, (Continuation<? super FacebookUserData>) this);
    }
}
