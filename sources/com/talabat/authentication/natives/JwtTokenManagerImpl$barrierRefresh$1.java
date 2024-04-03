package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0}, l = {646}, m = "barrierRefresh", n = {"this"}, s = {"L$0"})
public final class JwtTokenManagerImpl$barrierRefresh$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55450h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55451i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ JwtTokenManagerImpl f55452j;

    /* renamed from: k  reason: collision with root package name */
    public int f55453k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtTokenManagerImpl$barrierRefresh$1(JwtTokenManagerImpl jwtTokenManagerImpl, Continuation<? super JwtTokenManagerImpl$barrierRefresh$1> continuation) {
        super(continuation);
        this.f55452j = jwtTokenManagerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55451i = obj;
        this.f55453k |= Integer.MIN_VALUE;
        return this.f55452j.barrierRefresh(this);
    }
}
