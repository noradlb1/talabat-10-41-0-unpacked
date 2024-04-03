package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\n\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n"}, d2 = {"T", "kotlin.jvm.PlatformType", "c", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class RememberLottieCompositionKt$await$2$1<T> implements LottieListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<T> f40594a;

    public RememberLottieCompositionKt$await$2$1(CancellableContinuation<? super T> cancellableContinuation) {
        this.f40594a = cancellableContinuation;
    }

    public final void onResult(T t11) {
        if (!this.f40594a.isCompleted()) {
            this.f40594a.resumeWith(Result.m6329constructorimpl(t11));
        }
    }
}
