package org.junit.jupiter.engine.extension;

import j$.util.function.Supplier;
import org.junit.jupiter.api.Timeout;

public final /* synthetic */ class s implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f62613a;

    public /* synthetic */ s(String str) {
        this.f62613a = str;
    }

    public final Object get() {
        return String.format("Invalid timeout thread mode '%s', only %s and %s can be used as configuration parameter for %s.", new Object[]{this.f62613a, Timeout.ThreadMode.SAME_THREAD, Timeout.ThreadMode.SEPARATE_THREAD, "junit.jupiter.execution.timeout.thread.mode.default"});
    }
}
