package org.junit.platform.engine.discovery;

import j$.util.function.Supplier;

public final /* synthetic */ class p implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IncludePackageNameFilter f28047a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28048b;

    public /* synthetic */ p(IncludePackageNameFilter includePackageNameFilter, String str) {
        this.f28047a = includePackageNameFilter;
        this.f28048b = str;
    }

    public final Object get() {
        return this.f28047a.lambda$apply$1(this.f28048b);
    }
}
