package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class d implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40623a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40624b;

    public /* synthetic */ d(LottieDrawable lottieDrawable, int i11) {
        this.f40623a = lottieDrawable;
        this.f40624b = i11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40623a.lambda$setFrame$12(this.f40624b, lottieComposition);
    }
}
