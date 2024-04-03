package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class e implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40625a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f40626b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f40627c;

    public /* synthetic */ e(LottieDrawable lottieDrawable, int i11, int i12) {
        this.f40625a = lottieDrawable;
        this.f40626b = i11;
        this.f40627c = i12;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40625a.lambda$setMinAndMaxFrame$10(this.f40626b, this.f40627c, lottieComposition);
    }
}
