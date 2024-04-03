package com.google.android.exoplayer2.source;

import com.google.common.base.Supplier;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f35020b;

    public /* synthetic */ d(Class cls) {
        this.f35020b = cls;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.newInstance(this.f35020b);
    }
}
