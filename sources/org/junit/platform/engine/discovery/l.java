package org.junit.platform.engine.discovery;

import j$.util.function.Supplier;

public final /* synthetic */ class l implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IncludeClassNameFilter f28041a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28042b;

    public /* synthetic */ l(IncludeClassNameFilter includeClassNameFilter, String str) {
        this.f28041a = includeClassNameFilter;
        this.f28042b = str;
    }

    public final Object get() {
        return this.f28041a.lambda$apply$1(this.f28042b);
    }
}
