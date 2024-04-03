package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class m implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40640a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40641b;

    public /* synthetic */ m(LottieDrawable lottieDrawable, String str) {
        this.f40640a = lottieDrawable;
        this.f40641b = str;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40640a.lambda$setMaxFrame$7(this.f40641b, lottieComposition);
    }
}
