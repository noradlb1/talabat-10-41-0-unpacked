package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class g implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40630a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f40631b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ float f40632c;

    public /* synthetic */ g(LottieDrawable lottieDrawable, float f11, float f12) {
        this.f40630a = lottieDrawable;
        this.f40631b = f11;
        this.f40632c = f12;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40630a.lambda$setMinAndMaxProgress$11(this.f40631b, this.f40632c, lottieComposition);
    }
}
