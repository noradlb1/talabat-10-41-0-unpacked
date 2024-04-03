package org.junit.jupiter.engine.descriptor;

import d30.o1;
import d30.p1;
import d30.q1;
import d30.r1;
import f30.i;
import j$.lang.Iterable;
import java.lang.reflect.Method;
import org.apiguardian.api.API;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.junit.jupiter.engine.execution.BeforeEachMethodAdapter;
import org.junit.jupiter.engine.execution.DefaultExecutableInvoker;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.jupiter.engine.support.JupiterThrowableCollectorFactory;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.hierarchical.Node;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.0", status = API.Status.INTERNAL)
public class TestMethodTestDescriptor extends MethodBasedTestDescriptor {
    public static final String SEGMENT_TYPE = "method";
    private static final InterceptingExecutableInvoker.ReflectiveInterceptorCall<Method, Void> defaultInterceptorCall = i.b(new r1());
    private static final InterceptingExecutableInvoker executableInvoker = new InterceptingExecutableInvoker();
    private final InterceptingExecutableInvoker.ReflectiveInterceptorCall<Method, Void> interceptorCall;

    /* renamed from: org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62419a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.junit.platform.engine.TestExecutionResult$Status[] r0 = org.junit.platform.engine.TestExecutionResult.Status.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62419a = r0
                org.junit.platform.engine.TestExecutionResult$Status r1 = org.junit.platform.engine.TestExecutionResult.Status.SUCCESSFUL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f62419a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.junit.platform.engine.TestExecutionResult$Status r1 = org.junit.platform.engine.TestExecutionResult.Status.ABORTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f62419a     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.junit.platform.engine.TestExecutionResult$Status r1 = org.junit.platform.engine.TestExecutionResult.Status.FAILED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.AnonymousClass1.<clinit>():void");
        }
    }

    @FunctionalInterface
    public interface CallbackInvoker<T extends Extension> {
        void invoke(T t11, ExtensionContext extensionContext) throws Throwable;
    }

    public TestMethodTestDescriptor(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, cls, method, jupiterConfiguration);
        this.interceptorCall = defaultInterceptorCall;
    }

    private void invokeAfterEachCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        invokeAllAfterMethodsOrCallbacks(AfterEachCallback.class, jupiterEngineExecutionContext, new e0());
    }

    private void invokeAfterEachExecutionExceptionHandlers(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, Throwable th2) {
        k(LifecycleMethodExecutionExceptionHandler.class, extensionRegistry, th2, new q0(extensionContext));
    }

    private void invokeAfterEachMethods(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        invokeAllAfterMethodsOrCallbacks(AfterEachMethodAdapter.class, jupiterEngineExecutionContext, new d0(this, jupiterEngineExecutionContext.getExtensionRegistry()));
    }

    private void invokeAfterTestExecutionCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        invokeAllAfterMethodsOrCallbacks(AfterTestExecutionCallback.class, jupiterEngineExecutionContext, new f0());
    }

    private <T extends Extension> void invokeAllAfterMethodsOrCallbacks(Class<T> cls, JupiterEngineExecutionContext jupiterEngineExecutionContext, CallbackInvoker<T> callbackInvoker) {
        MutableExtensionRegistry extensionRegistry = jupiterEngineExecutionContext.getExtensionRegistry();
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        Iterable.EL.forEach(extensionRegistry.getReversedExtensions(cls), new l0(jupiterEngineExecutionContext.getThrowableCollector(), callbackInvoker, extensionContext));
    }

    private void invokeBeforeEachCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        invokeBeforeMethodsOrCallbacksUntilExceptionOccurs(BeforeEachCallback.class, jupiterEngineExecutionContext, new i0());
    }

    private void invokeBeforeEachExecutionExceptionHandlers(ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, Throwable th2) {
        k(LifecycleMethodExecutionExceptionHandler.class, extensionRegistry, th2, new o0(extensionContext));
    }

    private void invokeBeforeEachMethods(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        invokeBeforeMethodsOrCallbacksUntilExceptionOccurs(BeforeEachMethodAdapter.class, jupiterEngineExecutionContext, new p0(this, jupiterEngineExecutionContext.getExtensionRegistry()));
    }

    private <T extends Extension> void invokeBeforeMethodsOrCallbacksUntilExceptionOccurs(Class<T> cls, JupiterEngineExecutionContext jupiterEngineExecutionContext, CallbackInvoker<T> callbackInvoker) {
        MutableExtensionRegistry extensionRegistry = jupiterEngineExecutionContext.getExtensionRegistry();
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        ThrowableCollector throwableCollector = jupiterEngineExecutionContext.getThrowableCollector();
        for (E j0Var : extensionRegistry.getExtensions(cls)) {
            throwableCollector.execute(new j0(callbackInvoker, j0Var, extensionContext));
            if (throwableCollector.isNotEmpty()) {
                return;
            }
        }
    }

    private void invokeBeforeTestExecutionCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        invokeBeforeMethodsOrCallbacksUntilExceptionOccurs(BeforeTestExecutionCallback.class, jupiterEngineExecutionContext, new m0());
    }

    private void invokeTestExecutionExceptionHandlers(ExtensionRegistry extensionRegistry, ExtensionContext extensionContext, Throwable th2) {
        k(TestExecutionExceptionHandler.class, extensionRegistry, th2, new g0(extensionContext));
    }

    private void invokeTestInstancePreDestroyCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        invokeAllAfterMethodsOrCallbacks(TestInstancePreDestroyCallback.class, jupiterEngineExecutionContext, new k0());
    }

    private boolean isPerMethodLifecycle(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        return jupiterEngineExecutionContext.getExtensionContext().getTestInstanceLifecycle().orElse(TestInstance.Lifecycle.PER_CLASS) == TestInstance.Lifecycle.PER_METHOD;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$cleanUp$1(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Throwable {
        super.cleanUp(jupiterEngineExecutionContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeAfterEachMethods$10(ExtensionRegistry extensionRegistry, AfterEachMethodAdapter afterEachMethodAdapter, ExtensionContext extensionContext) throws Throwable {
        try {
            afterEachMethodAdapter.invokeAfterEachMethod(extensionContext, extensionRegistry);
        } catch (Throwable th2) {
            invokeAfterEachExecutionExceptionHandlers(extensionContext, extensionRegistry, th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeBeforeEachMethods$3(ExtensionRegistry extensionRegistry, BeforeEachMethodAdapter beforeEachMethodAdapter, ExtensionContext extensionContext) throws Throwable {
        try {
            beforeEachMethodAdapter.invokeBeforeEachMethod(extensionContext, extensionRegistry);
        } catch (Throwable th2) {
            invokeBeforeEachExecutionExceptionHandlers(extensionContext, extensionRegistry, th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeTestMethod$7(ExtensionContext extensionContext, JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Throwable {
        try {
            executableInvoker.invoke(getTestMethod(), extensionContext.getRequiredTestInstance(), extensionContext, (ExtensionRegistry) jupiterEngineExecutionContext.getExtensionRegistry(), this.interceptorCall);
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            invokeTestExecutionExceptionHandlers(jupiterEngineExecutionContext.getExtensionRegistry(), extensionContext, th2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$nodeFinished$15(TestExecutionResult.Status status, ExtensionContext extensionContext, TestExecutionResult testExecutionResult, TestWatcher testWatcher) {
        int i11 = AnonymousClass1.f62419a[status.ordinal()];
        if (i11 == 1) {
            testWatcher.testSuccessful(extensionContext);
        } else if (i11 == 2) {
            testWatcher.testAborted(extensionContext, testExecutionResult.getThrowable().orElse(null));
        } else if (i11 == 3) {
            testWatcher.testFailed(extensionContext, testExecutionResult.getThrowable().orElse(null));
        }
    }

    public void G(JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
        jupiterEngineExecutionContext.getThrowableCollector().execute(new q1(this, jupiterEngineExecutionContext.getExtensionContext(), jupiterEngineExecutionContext));
    }

    public MutableExtensionRegistry H(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry i11 = ExtensionUtils.i(jupiterEngineExecutionContext.getExtensionRegistry(), getTestMethod());
        ExtensionUtils.k(i11, getTestMethod());
        return i11;
    }

    public TestDescriptor.Type getType() {
        return TestDescriptor.Type.TEST;
    }

    public void cleanUp(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Exception {
        if (isPerMethodLifecycle(jupiterEngineExecutionContext) && jupiterEngineExecutionContext.getExtensionContext().getTestInstance().isPresent()) {
            invokeTestInstancePreDestroyCallbacks(jupiterEngineExecutionContext);
        }
        jupiterEngineExecutionContext.getThrowableCollector().execute(new p1(this, jupiterEngineExecutionContext));
        jupiterEngineExecutionContext.getThrowableCollector().assertEmpty();
    }

    public JupiterEngineExecutionContext execute(JupiterEngineExecutionContext jupiterEngineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
        ThrowableCollector throwableCollector = jupiterEngineExecutionContext.getThrowableCollector();
        invokeBeforeEachCallbacks(jupiterEngineExecutionContext);
        if (throwableCollector.isEmpty()) {
            invokeBeforeEachMethods(jupiterEngineExecutionContext);
            if (throwableCollector.isEmpty()) {
                invokeBeforeTestExecutionCallbacks(jupiterEngineExecutionContext);
                if (throwableCollector.isEmpty()) {
                    G(jupiterEngineExecutionContext, dynamicTestExecutor);
                }
                invokeAfterTestExecutionCallbacks(jupiterEngineExecutionContext);
            }
            invokeAfterEachMethods(jupiterEngineExecutionContext);
        }
        invokeAfterEachCallbacks(jupiterEngineExecutionContext);
        return jupiterEngineExecutionContext;
    }

    public void nodeFinished(JupiterEngineExecutionContext jupiterEngineExecutionContext, TestDescriptor testDescriptor, TestExecutionResult testExecutionResult) {
        if (jupiterEngineExecutionContext != null) {
            p(jupiterEngineExecutionContext, true, new o1(testExecutionResult.getStatus(), jupiterEngineExecutionContext.getExtensionContext(), testExecutionResult));
        }
    }

    public JupiterEngineExecutionContext prepare(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry H = H(jupiterEngineExecutionContext);
        ThrowableCollector createThrowableCollector = JupiterThrowableCollectorFactory.createThrowableCollector();
        MethodExtensionContext methodExtensionContext = new MethodExtensionContext(jupiterEngineExecutionContext.getExtensionContext(), jupiterEngineExecutionContext.getExecutionListener(), this, jupiterEngineExecutionContext.getConfiguration(), createThrowableCollector, new DefaultExecutableInvoker(jupiterEngineExecutionContext));
        createThrowableCollector.execute(new n0(jupiterEngineExecutionContext, H, createThrowableCollector, methodExtensionContext));
        return jupiterEngineExecutionContext.extend().withExtensionRegistry(H).withExtensionContext(methodExtensionContext).withThrowableCollector(createThrowableCollector).build();
    }

    public TestMethodTestDescriptor(UniqueId uniqueId, String str, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration, InterceptingExecutableInvoker.ReflectiveInterceptorCall<Method, Void> reflectiveInterceptorCall) {
        super(uniqueId, str, cls, method, jupiterConfiguration);
        this.interceptorCall = reflectiveInterceptorCall;
    }
}
