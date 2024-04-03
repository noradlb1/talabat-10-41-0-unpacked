package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class f implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f47327a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f47328b;

    public /* synthetic */ f(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2) {
        this.f47327a = deferredHandler;
        this.f47328b = deferredHandler2;
    }

    public final void handle(Provider provider) {
        OptionalProvider.lambda$whenAvailable$2(this.f47327a, this.f47328b, provider);
    }
}
