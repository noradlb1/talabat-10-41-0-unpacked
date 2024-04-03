package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class b implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f35015b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f35016c;

    public /* synthetic */ b(Class cls, DataSource.Factory factory) {
        this.f35015b = cls;
        this.f35016c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.newInstance(this.f35015b, this.f35016c);
    }
}
