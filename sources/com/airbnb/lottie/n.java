package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

public final /* synthetic */ class n implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40677a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f40678b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f40679c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f40680d;

    public /* synthetic */ n(LottieDrawable lottieDrawable, String str, String str2, boolean z11) {
        this.f40677a = lottieDrawable;
        this.f40678b = str;
        this.f40679c = str2;
        this.f40680d = z11;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40677a.lambda$setMinAndMaxFrame$9(this.f40678b, this.f40679c, this.f40680d, lottieComposition);
    }
}
