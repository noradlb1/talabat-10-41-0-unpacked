package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {1, 1}, l = {135, 140}, m = "getValidToken$getJwtToken", n = {"this$0", "$path"}, s = {"L$0", "L$1"})
public final class JwtTokenManagerImpl$getValidToken$getJwtToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55491h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55492i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f55493j;

    /* renamed from: k  reason: collision with root package name */
    public int f55494k;

    public JwtTokenManagerImpl$getValidToken$getJwtToken$1(Continuation<? super JwtTokenManagerImpl$getValidToken$getJwtToken$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55493j = obj;
        this.f55494k |= Integer.MIN_VALUE;
        return JwtTokenManagerImpl.getValidToken$getJwtToken((JwtTokenManagerImpl) null, (String) null, this);
    }
}
