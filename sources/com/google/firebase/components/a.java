package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ OptionalProvider f47321b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Provider f47322c;

    public /* synthetic */ a(OptionalProvider optionalProvider, Provider provider) {
        this.f47321b = optionalProvider;
        this.f47322c = provider;
    }

    public final void run() {
        this.f47321b.set(this.f47322c);
    }
}
