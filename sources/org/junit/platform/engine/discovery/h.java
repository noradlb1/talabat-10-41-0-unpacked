package org.junit.platform.engine.discovery;

import j$.util.function.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExcludePackageNameFilter f28035a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f28036b;

    public /* synthetic */ h(ExcludePackageNameFilter excludePackageNameFilter, String str) {
        this.f28035a = excludePackageNameFilter;
        this.f28036b = str;
    }

    public final Object get() {
        return this.f28035a.lambda$apply$1(this.f28036b);
    }
}
