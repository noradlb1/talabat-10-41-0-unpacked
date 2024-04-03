package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class o implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40681a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40682b;

    public /* synthetic */ o(LottieDrawable lottieDrawable, String str) {
        this.f40681a = lottieDrawable;
        this.f40682b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40681a.lambda$setMinFrame$6(this.f40682b, lottieComposition);
    }
}
