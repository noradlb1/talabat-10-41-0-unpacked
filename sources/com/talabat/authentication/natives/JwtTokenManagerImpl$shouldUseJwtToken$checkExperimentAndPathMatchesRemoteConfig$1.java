package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0, 0, 0, 1, 1, 1}, l = {491, 495}, m = "shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig", n = {"$variation", "this$0", "$path", "$variation", "$path", "$this$shouldUseJwtToken_u24checkExperimentAndPathMatchesRemoteConfig_u24lambda_u2d28"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55499h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55500i;

    /* renamed from: j  reason: collision with root package name */
    public Object f55501j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f55502k;

    /* renamed from: l  reason: collision with root package name */
    public int f55503l;

    public JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1(Continuation<? super JwtTokenManagerImpl$shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55502k = obj;
        this.f55503l |= Integer.MIN_VALUE;
        return JwtTokenManagerImpl.shouldUseJwtToken$checkExperimentAndPathMatchesRemoteConfig((String) null, (JwtTokenManagerImpl) null, (String) null, this);
    }
}
