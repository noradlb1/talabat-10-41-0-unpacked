package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class f implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40628a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40629b;

    public /* synthetic */ f(LottieDrawable lottieDrawable, String str) {
        this.f40628a = lottieDrawable;
        this.f40629b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40628a.lambda$setMinAndMaxFrame$8(this.f40629b, lottieComposition);
    }
}
