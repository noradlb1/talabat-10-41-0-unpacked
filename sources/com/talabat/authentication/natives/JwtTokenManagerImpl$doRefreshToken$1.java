package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {349, 367, 410}, m = "doRefreshToken", n = {"this", "path", "this", "path", "error", "this", "e"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class JwtTokenManagerImpl$doRefreshToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55458h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55459i;

    /* renamed from: j  reason: collision with root package name */
    public Object f55460j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f55461k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ JwtTokenManagerImpl f55462l;

    /* renamed from: m  reason: collision with root package name */
    public int f55463m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtTokenManagerImpl$doRefreshToken$1(JwtTokenManagerImpl jwtTokenManagerImpl, Continuation<? super JwtTokenManagerImpl$doRefreshToken$1> continuation) {
        super(continuation);
        this.f55462l = jwtTokenManagerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55461k = obj;
        this.f55463m |= Integer.MIN_VALUE;
        return this.f55462l.doRefreshToken((String) null, this);
    }
}
