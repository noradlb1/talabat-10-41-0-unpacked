package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class b implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40474a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f40475b;

    public /* synthetic */ b(LottieDrawable lottieDrawable, float f11) {
        this.f40474a = lottieDrawable;
        this.f40475b = f11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40474a.lambda$setMaxProgress$5(this.f40475b, lottieComposition);
    }
}
