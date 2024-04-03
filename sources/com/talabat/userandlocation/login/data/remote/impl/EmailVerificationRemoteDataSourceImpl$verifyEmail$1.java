package com.talabat.userandlocation.login.data.remote.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.login.data.remote.impl.EmailVerificationRemoteDataSourceImpl", f = "EmailVerificationRemoteDataSourceImpl.kt", i = {0}, l = {22}, m = "verifyEmail", n = {"this"}, s = {"L$0"})
public final class EmailVerificationRemoteDataSourceImpl$verifyEmail$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12339h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12340i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EmailVerificationRemoteDataSourceImpl f12341j;

    /* renamed from: k  reason: collision with root package name */
    public int f12342k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmailVerificationRemoteDataSourceImpl$verifyEmail$1(EmailVerificationRemoteDataSourceImpl emailVerificationRemoteDataSourceImpl, Continuation<? super EmailVerificationRemoteDataSourceImpl$verifyEmail$1> continuation) {
        super(continuation);
        this.f12341j = emailVerificationRemoteDataSourceImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12340i = obj;
        this.f12342k |= Integer.MIN_VALUE;
        return this.f12341j.verifyEmail((String) null, this);
    }
}
