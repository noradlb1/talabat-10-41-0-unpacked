package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;

public final /* synthetic */ class t implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f62614a;

    public /* synthetic */ t(String str) {
        this.f62614a = str;
    }

    public final Object get() {
        return String.format("Invalid timeout thread mode '%s' set via the '%s' configuration parameter.", new Object[]{this.f62614a, "junit.jupiter.execution.timeout.thread.mode.default"});
    }
}
