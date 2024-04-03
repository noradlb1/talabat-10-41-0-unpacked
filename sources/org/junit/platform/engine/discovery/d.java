package org.junit.platform.engine.discovery;

import j$.util.function.Supplier;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExcludeClassNameFilter f28029a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28030b;

    public /* synthetic */ d(ExcludeClassNameFilter excludeClassNameFilter, String str) {
        this.f28029a = excludeClassNameFilter;
        this.f28030b = str;
    }

    public final Object get() {
        return this.f28029a.lambda$apply$1(this.f28030b);
    }
}
