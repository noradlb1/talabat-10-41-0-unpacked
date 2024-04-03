package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class a implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Class f35001b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f35002c;

    public /* synthetic */ a(Class cls, DataSource.Factory factory) {
        this.f35001b = cls;
        this.f35002c = factory;
    }

    public final Object get() {
        return DefaultMediaSourceFactory.newInstance(this.f35001b, this.f35002c);
    }
}
