package com.talabat.authentication.authenticate.data.remote.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.authentication.authenticate.data.remote.impl.AuthenticationRemoteDataSourceImpl", f = "AuthenticationRemoteDataSourceImpl.kt", i = {0}, l = {86}, m = "migrationExchangeToken", n = {"this"}, s = {"L$0"})
public final class AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f55421h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f55422i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ AuthenticationRemoteDataSourceImpl f55423j;

    /* renamed from: k  reason: collision with root package name */
    public int f55424k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1(AuthenticationRemoteDataSourceImpl authenticationRemoteDataSourceImpl, Continuation<? super AuthenticationRemoteDataSourceImpl$migrationExchangeToken$1> continuation) {
        super(continuation);
        this.f55423j = authenticationRemoteDataSourceImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f55422i = obj;
        this.f55424k |= Integer.MIN_VALUE;
        return this.f55423j.migrationExchangeToken(this);
    }
}
