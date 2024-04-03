package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

public final /* synthetic */ class b implements ThrowableCollector.Executable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JupiterEngineExecutionContext f62424a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ThrowableCollector f62425b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ClassExtensionContext f62426c;

    public /* synthetic */ b(JupiterEngineExecutionContext jupiterEngineExecutionContext, ThrowableCollector throwableCollector, ClassExtensionContext classExtensionContext) {
        this.f62424a = jupiterEngineExecutionContext;
        this.f62425b = throwableCollector;
        this.f62426c = classExtensionContext;
    }

    public final void execute() {
        this.f62426c.c(this.f62424a.getTestInstancesProvider().getTestInstances(this.f62424a.getExtensionRegistry(), this.f62425b));
    }
}
