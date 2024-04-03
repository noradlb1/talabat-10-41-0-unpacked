package org.junit.jupiter.engine.descriptor;

import j$.util.function.Supplier;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class d implements Supplier {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ClassBasedTestDescriptor f62428a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f62429b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClassExtensionContext f62430c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistry f62431d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ExtensionRegistrar f62432e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f62433f;

    public /* synthetic */ d(ClassBasedTestDescriptor classBasedTestDescriptor, JupiterEngineExecutionContext jupiterEngineExecutionContext, ClassExtensionContext classExtensionContext, ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ThrowableCollector throwableCollector) {
        this.f62428a = classBasedTestDescriptor;
        this.f62429b = jupiterEngineExecutionContext;
        this.f62430c = classExtensionContext;
        this.f62431d = extensionRegistry;
        this.f62432e = extensionRegistrar;
        this.f62433f = throwableCollector;
    }

    public final Object get() {
        return this.f62428a.lambda$testInstancesProvider$4(this.f62429b, this.f62430c, this.f62431d, this.f62432e, this.f62433f);
    }
}
