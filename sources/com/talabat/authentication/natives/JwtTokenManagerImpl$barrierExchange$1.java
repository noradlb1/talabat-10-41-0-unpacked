package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0}, l = {621}, m = "barrierExchange", n = {"this"}, s = {"L$0"})
public final class JwtTokenManagerImpl$barrierExchange$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55446h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55447i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ JwtTokenManagerImpl f55448j;

    /* renamed from: k  reason: collision with root package name */
    public int f55449k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtTokenManagerImpl$barrierExchange$1(JwtTokenManagerImpl jwtTokenManagerImpl, Continuation<? super JwtTokenManagerImpl$barrierExchange$1> continuation) {
        super(continuation);
        this.f55448j = jwtTokenManagerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55447i = obj;
        this.f55449k |= Integer.MIN_VALUE;
        return this.f55448j.barrierExchange(this);
    }
}
