package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {}, l = {340}, m = "doRefreshToken$logout", n = {}, s = {})
public final class JwtTokenManagerImpl$doRefreshToken$logout$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f55464h;

    /* renamed from: i  reason: collision with root package name */
    public int f55465i;

    public JwtTokenManagerImpl$doRefreshToken$logout$1(Continuation<? super JwtTokenManagerImpl$doRefreshToken$logout$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55464h = obj;
        this.f55465i |= Integer.MIN_VALUE;
        Object access$doRefreshToken$logout = JwtTokenManagerImpl.doRefreshToken$logout((JwtTokenManagerImpl) null, (String) null, this);
        return access$doRefreshToken$logout == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? access$doRefreshToken$logout : Result.m6328boximpl(access$doRefreshToken$logout);
    }
}
