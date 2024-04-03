package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LazySet f47323b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Provider f47324c;

    public /* synthetic */ b(LazySet lazySet, Provider provider) {
        this.f47323b = lazySet;
        this.f47324c = provider;
    }

    public final void run() {
        this.f47323b.add(this.f47324c);
    }
}
