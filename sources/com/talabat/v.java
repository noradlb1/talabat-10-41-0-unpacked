package com.talabat;

import com.talabat.RestaurantsSearchActivity;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ RestaurantsSearchActivity.AnonymousClass1 f56689b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CharSequence f56690c;

    public /* synthetic */ v(RestaurantsSearchActivity.AnonymousClass1 r12, CharSequence charSequence) {
        this.f56689b = r12;
        this.f56690c = charSequence;
    }

    public final void run() {
        this.f56689b.lambda$onTextChanged$0(this.f56690c);
    }
}
