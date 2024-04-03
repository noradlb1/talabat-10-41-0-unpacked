package com.talabat.authentication.natives;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.natives.JwtTokenManagerImpl", f = "JwtTokenManagerImpl.kt", i = {0, 0, 1}, l = {152, 154}, m = "getValidToken", n = {"this", "path", "this"}, s = {"L$0", "L$1", "L$0"})
public final class JwtTokenManagerImpl$getValidToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55486h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55487i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f55488j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ JwtTokenManagerImpl f55489k;

    /* renamed from: l  reason: collision with root package name */
    public int f55490l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JwtTokenManagerImpl$getValidToken$1(JwtTokenManagerImpl jwtTokenManagerImpl, Continuation<? super JwtTokenManagerImpl$getValidToken$1> continuation) {
        super(continuation);
        this.f55489k = jwtTokenManagerImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55488j = obj;
        this.f55490l |= Integer.MIN_VALUE;
        return this.f55489k.getValidToken((String) null, this);
    }
}
