package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;

public final /* synthetic */ class p implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f40683a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KeyPath f40684b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f40685c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ LottieValueCallback f40686d;

    public /* synthetic */ p(LottieDrawable lottieDrawable, KeyPath keyPath, Object obj, LottieValueCallback lottieValueCallback) {
        this.f40683a = lottieDrawable;
        this.f40684b = keyPath;
        this.f40685c = obj;
        this.f40686d = lottieValueCallback;
    }

    public final void run(LottieComposition lottieComposition) {
        this.f40683a.lambda$addValueCallback$14(this.f40684b, this.f40685c, this.f40686d, lottieComposition);
    }
}
