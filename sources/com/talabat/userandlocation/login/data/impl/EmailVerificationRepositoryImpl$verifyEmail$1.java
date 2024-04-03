package com.talabat.userandlocation.login.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.talabat.userandlocation.login.data.impl.EmailVerificationRepositoryImpl", f = "EmailVerificationRepositoryImpl.kt", i = {0}, l = {14}, m = "verifyEmail", n = {"email"}, s = {"L$0"})
public final class EmailVerificationRepositoryImpl$verifyEmail$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f12335h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f12336i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ EmailVerificationRepositoryImpl f12337j;

    /* renamed from: k  reason: collision with root package name */
    public int f12338k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmailVerificationRepositoryImpl$verifyEmail$1(EmailVerificationRepositoryImpl emailVerificationRepositoryImpl, Continuation<? super EmailVerificationRepositoryImpl$verifyEmail$1> continuation) {
        super(continuation);
        this.f12337j = emailVerificationRepositoryImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f12336i = obj;
        this.f12338k |= Integer.MIN_VALUE;
        return this.f12337j.verifyEmail((String) null, this);
    }
}
