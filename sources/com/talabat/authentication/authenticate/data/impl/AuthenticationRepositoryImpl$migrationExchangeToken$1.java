package com.talabat.authentication.authenticate.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.authenticate.data.impl.AuthenticationRepositoryImpl", f = "AuthenticationRepositoryImpl.kt", i = {0, 0}, l = {105}, m = "migrationExchangeToken", n = {"this", "$this$migrationExchangeToken_u24lambda_u2d5"}, s = {"L$0", "L$1"})
public final class AuthenticationRepositoryImpl$migrationExchangeToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55412h;

    /* renamed from: i  reason: collision with root package name */
    public Object f55413i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f55414j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRepositoryImpl f55415k;

    /* renamed from: l  reason: collision with root package name */
    public int f55416l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthenticationRepositoryImpl$migrationExchangeToken$1(AuthenticationRepositoryImpl authenticationRepositoryImpl, Continuation<? super AuthenticationRepositoryImpl$migrationExchangeToken$1> continuation) {
        super(continuation);
        this.f55415k = authenticationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55414j = obj;
        this.f55416l |= Integer.MIN_VALUE;
        return this.f55415k.migrationExchangeToken(this);
    }
}
