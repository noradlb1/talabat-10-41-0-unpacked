package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenRepositoryImpl", f = "JwtTokenRepositoryImpl.kt", i = {}, l = {14}, m = "refreshJwt", n = {}, s = {})
public final class JwtTokenRepositoryImpl$refreshJwt$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f55504h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ JwtTokenRepositoryImpl f55505i;

    /* renamed from: j  reason: collision with root package name */
    public int f55506j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtTokenRepositoryImpl$refreshJwt$1(JwtTokenRepositoryImpl jwtTokenRepositoryImpl, Continuation<? super JwtTokenRepositoryImpl$refreshJwt$1> continuation) {
        super(continuation);
        this.f55505i = jwtTokenRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55504h = obj;
        this.f55506j |= Integer.MIN_VALUE;
        return this.f55505i.refreshJwt((String) null, this);
    }
}
