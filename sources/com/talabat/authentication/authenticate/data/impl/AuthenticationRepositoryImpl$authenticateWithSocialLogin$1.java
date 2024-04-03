package com.talabat.authentication.authenticate.data.impl;

import com.talabat.authentication.authenticate.domain.repository.SocialAuthenticationRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl", f = "AuthenticationRepositoryImpl.kt", i = {0, 0}, l = {52}, m = "authenticateWithSocialLogin", n = {"this", "$this$authenticateWithSocialLogin_u24lambda_u2d0"}, s = {"L$0", "L$1"})
public final class AuthenticationRepositoryImpl$authenticateWithSocialLogin$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55407h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55408i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f55409j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f55410k;

    /* renamed from: l  reason: collision with root package name */
    public int f55411l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthenticationRepositoryImpl$authenticateWithSocialLogin$1(AuthenticationRepositoryImpl authenticationRepositoryImpl, Continuation<? super AuthenticationRepositoryImpl$authenticateWithSocialLogin$1> continuation) {
        super(continuation);
        this.f55410k = authenticationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55409j = obj;
        this.f55411l |= Integer.MIN_VALUE;
        return this.f55410k.authenticateWithSocialLogin((String) null, (SocialAuthenticationRepository.Platform) null, (String) null, this);
    }
}
