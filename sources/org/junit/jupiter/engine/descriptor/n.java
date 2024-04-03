package org.junit.jupiter.engine.descriptor;

import org.junit.jupiter.api.extension.DynamicTestInvocationContext;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.engine.execution.InvocationInterceptorChain;

public final /* synthetic */ class n implements InvocationInterceptorChain.VoidInterceptorCall {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DynamicTestInvocationContext f62459a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExtensionContext f62460b;

    public /* synthetic */ n(DynamicTestInvocationContext dynamicTestInvocationContext, ExtensionContext extensionContext) {
        this.f62459a = dynamicTestInvocationContext;
        this.f62460b = extensionContext;
    }

    public final void apply(InvocationInterceptor invocationInterceptor, InvocationInterceptor.Invocation invocation) {
        invocationInterceptor.interceptDynamicTest(invocation, this.f62459a, this.f62460b);
    }
}
