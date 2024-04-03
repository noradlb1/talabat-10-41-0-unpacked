package com.talabat.core.social.login.data;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.core.social.login.data.SocialLoginAAAAuthenticationRepository", f = "SocialLoginAAAAuthenticationRepository.kt", i = {0}, l = {12}, m = "authenticateWithGoogleAuth", n = {"this"}, s = {"L$0"})
public final class SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55975h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55976i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SocialLoginAAAAuthenticationRepository f55977j;

    /* renamed from: k  reason: collision with root package name */
    public int f55978k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1(SocialLoginAAAAuthenticationRepository socialLoginAAAAuthenticationRepository, Continuation<? super SocialLoginAAAAuthenticationRepository$authenticateWithGoogleAuth$1> continuation) {
        super(continuation);
        this.f55977j = socialLoginAAAAuthenticationRepository;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55976i = obj;
        this.f55978k |= Integer.MIN_VALUE;
        return this.f55977j.authenticateWithGoogleAuth((String) null, (String) null, this);
    }
}
