package com.talabat.location.area.domain.usecases.impl;

import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$3<T> implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Continuation<Unit> f61033b;

    public UpdateAreaOfSelectedAddressIfChangedUseCaseImpl$updateAddress$2$3(Continuation<? super Unit> continuation) {
        this.f61033b = continuation;
    }

    public final void accept(Throwable th2) {
        Continuation<Unit> continuation = this.f61033b;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }
}
