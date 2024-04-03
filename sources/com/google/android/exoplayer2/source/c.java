package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class c implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f35017b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f35018c;

    public /* synthetic */ c(Class cls, DataSource.Factory factory) {
        this.f35017b = cls;
        this.f35018c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.newInstance(this.f35017b, this.f35018c);
    }
}
