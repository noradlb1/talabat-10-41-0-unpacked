package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class h implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40633a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40634b;

    public /* synthetic */ h(LottieDrawable lottieDrawable, int i11) {
        this.f40633a = lottieDrawable;
        this.f40634b = i11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40633a.lambda$setMinFrame$2(this.f40634b, lottieComposition);
    }
}
