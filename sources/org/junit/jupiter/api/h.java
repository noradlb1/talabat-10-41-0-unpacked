package org.junit.jupiter.api;

import j$.util.function.Supplier;

public final /* synthetic */ class h implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f57149a;

    public /* synthetic */ h(String str) {
        this.f57149a = str;
    }

    public final Object get() {
        return AssertTimeoutPreemptively.lambda$assertTimeoutPreemptively$2(this.f57149a);
    }
}
