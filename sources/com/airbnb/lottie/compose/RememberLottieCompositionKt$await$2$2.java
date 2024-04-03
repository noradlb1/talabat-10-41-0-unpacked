package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n"}, d2 = {"T", "", "kotlin.jvm.PlatformType", "e", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class RememberLottieCompositionKt$await$2$2<T> implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f40595a;

    public RememberLottieCompositionKt$await$2$2(CancellableContinuation<? super T> cancellableContinuation) {
        this.f40595a = cancellableContinuation;
    }

    public final void onResult(Throwable th2) {
        if (!this.f40595a.isCompleted()) {
            CancellableContinuation<T> cancellableContinuation = this.f40595a;
            Intrinsics.checkNotNullExpressionValue(th2, "e");
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(th2)));
        }
    }
}
