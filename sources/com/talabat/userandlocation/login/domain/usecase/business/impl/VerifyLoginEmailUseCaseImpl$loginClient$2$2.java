package com.talabat.userandlocation.login.domain.usecase.business.impl;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VerifyLoginEmailUseCaseImpl$loginClient$2$2<T> implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation<Unit> f12368b;

    public VerifyLoginEmailUseCaseImpl$loginClient$2$2(Continuation<? super Unit> continuation) {
        this.f12368b = continuation;
    }

    public final void accept(Throwable th2) {
        Continuation<Unit> continuation = this.f12368b;
        Result.Companion companion = Result.Companion;
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        continuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
    }
}
