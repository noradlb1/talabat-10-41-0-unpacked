package com.talabat.core.social.login.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository", f = "SocialLoginAAAAuthenticationRepository.kt", i = {0}, l = {30}, m = "authenticateWithFacebookAuth", n = {"this"}, s = {"L$0"})
public final class SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55971h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55972i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SocialLoginAAAAuthenticationRepository f55973j;

    /* renamed from: k  reason: collision with root package name */
    public int f55974k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1(SocialLoginAAAAuthenticationRepository socialLoginAAAAuthenticationRepository, Continuation<? super SocialLoginAAAAuthenticationRepository$authenticateWithFacebookAuth$1> continuation) {
        super(continuation);
        this.f55973j = socialLoginAAAAuthenticationRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55972i = obj;
        this.f55974k |= Integer.MIN_VALUE;
        return this.f55973j.authenticateWithFacebookAuth((String) null, (String) null, this);
    }
}
