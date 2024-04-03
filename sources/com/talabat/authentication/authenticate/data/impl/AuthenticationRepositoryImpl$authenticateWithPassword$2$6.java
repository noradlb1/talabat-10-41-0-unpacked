package com.talabat.authentication.authenticate.data.impl;

import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class AuthenticationRepositoryImpl$authenticateWithPassword$2$6 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation<PasswordAuthentication> f55406b;

    public AuthenticationRepositoryImpl$authenticateWithPassword$2$6(Continuation<? super PasswordAuthentication> continuation) {
        this.f55406b = continuation;
    }

    public final void accept(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "p0");
        Continuation<PasswordAuthentication> continuation = this.f55406b;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }
}
