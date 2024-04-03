package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0}, l = {230}, m = "exchangeTokenWithOneRetry$exchangeToken", n = {"this$0"}, s = {"L$0"})
public final class JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55480h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55481i;

    /* renamed from: j  reason: collision with root package name */
    public int f55482j;

    public JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1(Continuation<? super JwtTokenManagerImpl$exchangeTokenWithOneRetry$exchangeToken$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55481i = obj;
        this.f55482j |= Integer.MIN_VALUE;
        return JwtTokenManagerImpl.exchangeTokenWithOneRetry$exchangeToken((JwtTokenManagerImpl) null, this);
    }
}
