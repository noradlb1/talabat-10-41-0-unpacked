package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class j implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40637a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40638b;

    public /* synthetic */ j(LottieDrawable lottieDrawable, int i11) {
        this.f40637a = lottieDrawable;
        this.f40638b = i11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40637a.lambda$setMaxFrame$4(this.f40638b, lottieComposition);
    }
}
