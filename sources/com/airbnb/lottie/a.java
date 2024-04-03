package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class a implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40440a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f40441b;

    public /* synthetic */ a(LottieDrawable lottieDrawable, float f11) {
        this.f40440a = lottieDrawable;
        this.f40441b = f11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40440a.lambda$setProgress$13(this.f40441b, lottieComposition);
    }
}
