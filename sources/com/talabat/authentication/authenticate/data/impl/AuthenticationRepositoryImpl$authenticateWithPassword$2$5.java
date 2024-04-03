package com.talabat.authentication.authenticate.data.impl;

import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class AuthenticationRepositoryImpl$authenticateWithPassword$2$5 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation<PasswordAuthentication> f55405b;

    public AuthenticationRepositoryImpl$authenticateWithPassword$2$5(Continuation<? super PasswordAuthentication> continuation) {
        this.f55405b = continuation;
    }

    public final void accept(PasswordAuthentication passwordAuthentication) {
        this.f55405b.resumeWith(Result.m6329constructorimpl(passwordAuthentication));
    }
}
