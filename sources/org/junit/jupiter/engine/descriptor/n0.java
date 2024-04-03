package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class n0 implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f62461a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MutableExtensionRegistry f62462b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f62463c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MethodExtensionContext f62464d;

    public /* synthetic */ n0(JupiterEngineExecutionContext jupiterEngineExecutionContext, MutableExtensionRegistry mutableExtensionRegistry, ThrowableCollector throwableCollector, MethodExtensionContext methodExtensionContext) {
        this.f62461a = jupiterEngineExecutionContext;
        this.f62462b = mutableExtensionRegistry;
        this.f62463c = throwableCollector;
        this.f62464d = methodExtensionContext;
    }

    public final void execute() {
        this.f62464d.c(this.f62461a.getTestInstancesProvider().getTestInstances(this.f62462b, this.f62463c));
    }
}
