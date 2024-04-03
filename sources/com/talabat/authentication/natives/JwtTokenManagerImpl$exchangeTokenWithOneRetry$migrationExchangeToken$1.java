package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0}, l = {174}, m = "exchangeTokenWithOneRetry$migrationExchangeToken", n = {"this$0"}, s = {"L$0"})
public final class JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55483h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55484i;

    /* renamed from: j  reason: collision with root package name */
    public int f55485j;

    public JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1(Continuation<? super JwtTokenManagerImpl$exchangeTokenWithOneRetry$migrationExchangeToken$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55484i = obj;
        this.f55485j |= Integer.MIN_VALUE;
        return JwtTokenManagerImpl.exchangeTokenWithOneRetry$migrationExchangeToken((JwtTokenManagerImpl) null, this);
    }
}
