package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class i implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40635a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f40636b;

    public /* synthetic */ i(LottieDrawable lottieDrawable, float f11) {
        this.f40635a = lottieDrawable;
        this.f40636b = f11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40635a.lambda$setMinProgress$3(this.f40636b, lottieComposition);
    }
}
