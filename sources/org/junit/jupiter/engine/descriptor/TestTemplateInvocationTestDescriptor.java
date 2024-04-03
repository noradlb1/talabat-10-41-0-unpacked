package org.junit.jupiter.engine.descriptor;

import d30.s1;
import d30.t1;
import f30.i;
import j$.lang.Iterable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;

@API(since = "5.0", status = API.Status.INTERNAL)
public class TestTemplateInvocationTestDescriptor extends TestMethodTestDescriptor {
    public static final String SEGMENT_TYPE = "test-template-invocation";
    private static final InterceptingExecutableInvoker.ReflectiveInterceptorCall<Method, Void> interceptorCall = i.b(new s1());
    private final int index;
    private TestTemplateInvocationContext invocationContext;

    public TestTemplateInvocationTestDescriptor(UniqueId uniqueId, Class<?> cls, Method method, TestTemplateInvocationContext testTemplateInvocationContext, int i11, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, testTemplateInvocationContext.getDisplayName(i11), cls, method, jupiterConfiguration, interceptorCall);
        this.invocationContext = testTemplateInvocationContext;
        this.index = i11;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$populateNewExtensionRegistry$0(MutableExtensionRegistry mutableExtensionRegistry, Extension extension) {
        mutableExtensionRegistry.registerExtension(extension, (Object) this.invocationContext);
    }

    public MutableExtensionRegistry H(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry H = super.H(jupiterEngineExecutionContext);
        Iterable.EL.forEach(this.invocationContext.getAdditionalExtensions(), new t1(this, H));
        return H;
    }

    public Set<ExclusiveResource> getExclusiveResources() {
        return Collections.emptySet();
    }

    public String getLegacyReportingName() {
        return super.getLegacyReportingName() + "[" + this.index + "]";
    }

    public void after(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        this.invocationContext = null;
    }
}
