package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

public final /* synthetic */ class e implements Supplier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultMediaSourceFactory.DelegateFactoryLoader f35025b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DataSource.Factory f35026c;

    public /* synthetic */ e(DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader, DataSource.Factory factory) {
        this.f35025b = delegateFactoryLoader;
        this.f35026c = factory;
    }

    public final Object get() {
        return this.f35025b.lambda$maybeLoadSupplier$4(this.f35026c);
    }
}
