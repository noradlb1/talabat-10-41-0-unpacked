package org.junit.platform.commons.util;

import j$.util.function.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28006a;

    public /* synthetic */ h(String str) {
        this.f28006a = str;
    }

    public final Object get() {
        return ClasspathScanner.lambda$getRootUrisForPackage$8(this.f28006a);
    }
}
