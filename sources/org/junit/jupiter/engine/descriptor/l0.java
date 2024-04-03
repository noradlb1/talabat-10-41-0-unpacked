package org.junit.jupiter.engine.descriptor;

import j$.util.function.Consumer;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class l0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f62455b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TestMethodTestDescriptor.CallbackInvoker f62456c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62457d;

    public /* synthetic */ l0(ThrowableCollector throwableCollector, TestMethodTestDescriptor.CallbackInvoker callbackInvoker, ExtensionContext extensionContext) {
        this.f62455b = throwableCollector;
        this.f62456c = callbackInvoker;
        this.f62457d = extensionContext;
    }

    public final void accept(Object obj) {
        this.f62455b.execute(new h0(this.f62456c, (Extension) obj, this.f62457d));
    }

    public /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer.CC.$default$andThen(this, consumer);
    }
}
