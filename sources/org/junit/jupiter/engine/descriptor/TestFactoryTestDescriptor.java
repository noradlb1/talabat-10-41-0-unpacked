package org.junit.jupiter.engine.descriptor;

import d30.j1;
import d30.k0;
import d30.k1;
import d30.l1;
import j$.util.Optional;
import j$.util.stream.Stream;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Objects;
import org.apiguardian.api.API;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.PreconditionViolationException;
import org.junit.platform.commons.util.CollectionUtils;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.engine.support.descriptor.ClasspathResourceSource;
import org.junit.platform.engine.support.descriptor.a;
import org.junit.platform.engine.support.hierarchical.Node;

@API(since = "5.0", status = API.Status.INTERNAL)
public class TestFactoryTestDescriptor extends TestMethodTestDescriptor implements Filterable {
    public static final String DYNAMIC_CONTAINER_SEGMENT_TYPE = "dynamic-container";
    public static final String DYNAMIC_TEST_SEGMENT_TYPE = "dynamic-test";
    public static final String SEGMENT_TYPE = "test-factory";
    private static final InterceptingExecutableInvoker executableInvoker = new InterceptingExecutableInvoker();
    private static final InterceptingExecutableInvoker.ReflectiveInterceptorCall<Method, Object> interceptorCall = new l1();
    private final DynamicDescendantFilter dynamicDescendantFilter = new DynamicDescendantFilter();

    public TestFactoryTestDescriptor(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, cls, method, jupiterConfiguration);
    }

    /* JADX WARNING: type inference failed for: r10v3, types: [j$.util.function.Supplier] */
    /* JADX WARNING: type inference failed for: r0v7, types: [d30.i1] */
    /* JADX WARNING: type inference failed for: r0v8, types: [d30.h1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static j$.util.Optional<org.junit.jupiter.engine.descriptor.JupiterTestDescriptor> M(org.junit.jupiter.engine.descriptor.JupiterTestDescriptor r7, org.junit.jupiter.api.DynamicNode r8, int r9, org.junit.platform.engine.TestSource r10, org.junit.jupiter.engine.descriptor.DynamicDescendantFilter r11, org.junit.jupiter.engine.config.JupiterConfiguration r12) {
        /*
            j$.util.Optional r0 = r8.getTestSourceUri()
            d30.g1 r1 = new d30.g1
            r1.<init>()
            j$.util.Optional r0 = r0.map(r1)
            java.lang.Object r10 = r0.orElse(r10)
            r4 = r10
            org.junit.platform.engine.TestSource r4 = (org.junit.platform.engine.TestSource) r4
            boolean r10 = r8 instanceof org.junit.jupiter.api.DynamicTest
            java.lang.String r0 = "#"
            if (r10 == 0) goto L_0x0040
            r3 = r8
            org.junit.jupiter.api.DynamicTest r3 = (org.junit.jupiter.api.DynamicTest) r3
            org.junit.platform.engine.UniqueId r8 = r7.getUniqueId()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "dynamic-test"
            org.junit.platform.engine.UniqueId r8 = r8.append(r0, r10)
            d30.h1 r10 = new d30.h1
            r0 = r10
            r1 = r8
            r2 = r9
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x0066
        L_0x0040:
            r3 = r8
            org.junit.jupiter.api.DynamicContainer r3 = (org.junit.jupiter.api.DynamicContainer) r3
            org.junit.platform.engine.UniqueId r8 = r7.getUniqueId()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "dynamic-container"
            org.junit.platform.engine.UniqueId r8 = r8.append(r0, r10)
            d30.i1 r10 = new d30.i1
            r0 = r10
            r1 = r8
            r2 = r9
            r5 = r11
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x0066:
            int r9 = r9 + -1
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            boolean r8 = r11.test((org.junit.platform.engine.UniqueId) r8, (java.lang.Integer) r9)
            if (r8 == 0) goto L_0x0080
            java.lang.Object r8 = r10.get()
            org.junit.jupiter.engine.descriptor.JupiterTestDescriptor r8 = (org.junit.jupiter.engine.descriptor.JupiterTestDescriptor) r8
            r8.setParent(r7)
            j$.util.Optional r7 = j$.util.Optional.of(r8)
            return r7
        L_0x0080:
            j$.util.Optional r7 = j$.util.Optional.empty()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.descriptor.TestFactoryTestDescriptor.M(org.junit.jupiter.engine.descriptor.JupiterTestDescriptor, org.junit.jupiter.api.DynamicNode, int, org.junit.platform.engine.TestSource, org.junit.jupiter.engine.descriptor.DynamicDescendantFilter, org.junit.jupiter.engine.config.JupiterConfiguration):j$.util.Optional");
    }

    public static TestSource N(URI uri) {
        Preconditions.notNull(uri, "URI must not be null");
        if (ClasspathResourceSource.CLASSPATH_SCHEME.equals(uri.getScheme())) {
            return ClasspathResourceSource.from(uri);
        }
        if ("class".equals(uri.getScheme())) {
            return ClassSource.from(uri);
        }
        if ("method".equals(uri.getScheme())) {
            return MethodSourceSupport.d(uri);
        }
        return a.a(uri);
    }

    private JUnitException invalidReturnTypeException(Throwable th2) {
        return new JUnitException(String.format("@TestFactory method [%s] must return a single %2$s or a Stream, Collection, Iterable, Iterator, or array of %2$s.", new Object[]{getTestMethod().toGenericString(), DynamicNode.class.getName()}), th2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JupiterTestDescriptor lambda$createDynamicDescriptor$2(UniqueId uniqueId, int i11, DynamicTest dynamicTest, TestSource testSource, JupiterConfiguration jupiterConfiguration) {
        return new DynamicTestTestDescriptor(uniqueId, i11, dynamicTest, testSource, jupiterConfiguration);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JupiterTestDescriptor lambda$createDynamicDescriptor$3(UniqueId uniqueId, int i11, DynamicContainer dynamicContainer, TestSource testSource, DynamicDescendantFilter dynamicDescendantFilter2, JupiterConfiguration jupiterConfiguration) {
        return new DynamicContainerTestDescriptor(uniqueId, i11, dynamicContainer, testSource, dynamicDescendantFilter2.withoutIndexFiltering(), jupiterConfiguration);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$invokeTestMethod$0() {
        return new JUnitException("Illegal state: TestSource must be present");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeTestMethod$1(ExtensionContext extensionContext, JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) throws Throwable {
        Stream<DynamicNode> dynamicNodeStream;
        Object invoke = executableInvoker.invoke(getTestMethod(), extensionContext.getRequiredTestInstance(), extensionContext, (ExtensionRegistry) jupiterEngineExecutionContext.getExtensionRegistry(), interceptorCall);
        TestSource orElseThrow = getSource().orElseThrow(new k1());
        try {
            dynamicNodeStream = toDynamicNodeStream(invoke);
            int i11 = 1;
            for (DynamicNode M : dynamicNodeStream) {
                Optional<JupiterTestDescriptor> M2 = M(this, M, i11, orElseThrow, getDynamicDescendantFilter(), this.f62416b);
                Objects.requireNonNull(dynamicTestExecutor);
                M2.ifPresent(new k0(dynamicTestExecutor));
                i11++;
            }
            dynamicNodeStream.close();
            dynamicTestExecutor.awaitFinished();
            return;
        } catch (ClassCastException e11) {
            throw invalidReturnTypeException(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    private Stream<DynamicNode> toDynamicNodeStream(Object obj) {
        if (obj instanceof DynamicNode) {
            return Stream.CC.of((DynamicNode) obj);
        }
        try {
            return CollectionUtils.toStream(obj);
        } catch (PreconditionViolationException e11) {
            throw invalidReturnTypeException(e11);
        }
    }

    public void G(JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
        jupiterEngineExecutionContext.getThrowableCollector().execute(new j1(this, jupiterEngineExecutionContext.getExtensionContext(), jupiterEngineExecutionContext, dynamicTestExecutor));
    }

    public DynamicDescendantFilter getDynamicDescendantFilter() {
        return this.dynamicDescendantFilter;
    }

    public TestDescriptor.Type getType() {
        return TestDescriptor.Type.CONTAINER;
    }

    public boolean mayRegisterTests() {
        return true;
    }

    public void nodeFinished(JupiterEngineExecutionContext jupiterEngineExecutionContext, TestDescriptor testDescriptor, TestExecutionResult testExecutionResult) {
    }

    public void nodeSkipped(JupiterEngineExecutionContext jupiterEngineExecutionContext, TestDescriptor testDescriptor, Node.SkipResult skipResult) {
    }
}
