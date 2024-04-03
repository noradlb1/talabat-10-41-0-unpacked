package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0}, l = {323}, m = "doRefreshToken$refreshTokenRemote", n = {"this$0"}, s = {"L$0"})
public final class JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55466h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55467i;

    /* renamed from: j  reason: collision with root package name */
    public int f55468j;

    public JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1(Continuation<? super JwtTokenManagerImpl$doRefreshToken$refreshTokenRemote$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55467i = obj;
        this.f55468j |= Integer.MIN_VALUE;
        return JwtTokenManagerImpl.doRefreshToken$refreshTokenRemote((JwtTokenManagerImpl) null, (String) null, this);
    }
}
