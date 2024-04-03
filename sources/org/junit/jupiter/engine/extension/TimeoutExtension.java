package org.junit.jupiter.engine.extension;

import g30.o;
import j$.util.Optional;
import j$.util.function.Function;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.DynamicTestInvocationContext;
import org.junit.jupiter.api.extension.ExtensionConfigurationException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.InvocationInterceptor;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.engine.extension.TimeoutInvocationFactory;
import org.junit.platform.commons.support.AnnotationSupport;
import org.junit.platform.commons.util.ClassUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.RuntimeUtils;
import z20.e;

class TimeoutExtension implements BeforeAllCallback, BeforeEachCallback, InvocationInterceptor {
    private static final String DISABLED_MODE_VALUE = "disabled";
    private static final String DISABLED_ON_DEBUG_MODE_VALUE = "disabled_on_debug";
    private static final String ENABLED_MODE_VALUE = "enabled";
    private static final String GLOBAL_TIMEOUT_CONFIG_KEY = "global_timeout_config";
    private static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create(Timeout.class);
    private static final String TESTABLE_METHOD_TIMEOUT_KEY = "testable_method_timeout_from_annotation";
    private static final String TESTABLE_METHOD_TIMEOUT_THREAD_MODE_KEY = "testable_method_timeout_thread_mode_from_annotation";

    @FunctionalInterface
    public interface TimeoutProvider extends Function<TimeoutConfiguration, Optional<TimeoutDuration>> {
    }

    private <T> InvocationInterceptor.Invocation<T> decorate(InvocationInterceptor.Invocation<T> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext, TimeoutDuration timeoutDuration) {
        if (timeoutDuration == null || isTimeoutDisabled(extensionContext)) {
            return invocation;
        }
        return new TimeoutInvocationFactory(extensionContext.getRoot().getStore(NAMESPACE)).a(resolveTimeoutThreadMode(extensionContext), new TimeoutInvocationFactory.TimeoutInvocationParameters(invocation, timeoutDuration, new h0(this, reflectiveInvocationContext, extensionContext)));
    }

    /* access modifiers changed from: private */
    /* renamed from: describe */
    public String lambda$decorate$3(ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) {
        Method executable = reflectiveInvocationContext.getExecutable();
        Optional<Class<?>> testClass = extensionContext.getTestClass();
        if (!testClass.isPresent() || !reflectiveInvocationContext.getTargetClass().equals(testClass.get())) {
            return ReflectionUtils.getFullyQualifiedMethodName(reflectiveInvocationContext.getTargetClass(), executable);
        }
        return String.format("%s(%s)", new Object[]{executable.getName(), ClassUtils.nullSafeToString((Class<?>[]) executable.getParameterTypes())});
    }

    private Timeout.ThreadMode getAnnotationThreadMode(ExtensionContext extensionContext) {
        return (Timeout.ThreadMode) extensionContext.getStore(NAMESPACE).get(TESTABLE_METHOD_TIMEOUT_THREAD_MODE_KEY, Timeout.ThreadMode.class);
    }

    private TimeoutDuration getDefaultTimeout(ExtensionContext extensionContext, TimeoutProvider timeoutProvider) {
        return (TimeoutDuration) ((Optional) timeoutProvider.apply(getGlobalTimeoutConfiguration(extensionContext))).orElse(null);
    }

    private TimeoutConfiguration getGlobalTimeoutConfiguration(ExtensionContext extensionContext) {
        ExtensionContext root = extensionContext.getRoot();
        return (TimeoutConfiguration) root.getStore(NAMESPACE).getOrComputeIfAbsent(GLOBAL_TIMEOUT_CONFIG_KEY, new e0(root), TimeoutConfiguration.class);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [org.junit.jupiter.api.extension.ReflectiveInvocationContext, org.junit.jupiter.api.extension.ReflectiveInvocationContext<java.lang.reflect.Method>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T intercept(org.junit.jupiter.api.extension.InvocationInterceptor.Invocation<T> r1, org.junit.jupiter.api.extension.ReflectiveInvocationContext<java.lang.reflect.Method> r2, org.junit.jupiter.api.extension.ExtensionContext r3, org.junit.jupiter.engine.extension.TimeoutDuration r4, org.junit.jupiter.engine.extension.TimeoutExtension.TimeoutProvider r5) throws java.lang.Throwable {
        /*
            r0 = this;
            if (r4 != 0) goto L_0x0006
            org.junit.jupiter.engine.extension.TimeoutDuration r4 = r0.getDefaultTimeout(r3, r5)
        L_0x0006:
            org.junit.jupiter.api.extension.InvocationInterceptor$Invocation r1 = r0.decorate(r1, r2, r3, r4)
            java.lang.Object r1 = r1.proceed()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.extension.TimeoutExtension.intercept(org.junit.jupiter.api.extension.InvocationInterceptor$Invocation, org.junit.jupiter.api.extension.ReflectiveInvocationContext, org.junit.jupiter.api.extension.ExtensionContext, org.junit.jupiter.engine.extension.TimeoutDuration, org.junit.jupiter.engine.extension.TimeoutExtension$TimeoutProvider):java.lang.Object");
    }

    private void interceptLifecycleMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext, TimeoutProvider timeoutProvider) throws Throwable {
        intercept(invocation, reflectiveInvocationContext, extensionContext, readTimeoutFromAnnotation(Optional.of(reflectiveInvocationContext.getExecutable())).orElse(null), timeoutProvider);
    }

    private <T> T interceptTestableMethod(InvocationInterceptor.Invocation<T> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext, TimeoutProvider timeoutProvider) throws Throwable {
        return intercept(invocation, reflectiveInvocationContext, extensionContext, (TimeoutDuration) extensionContext.getStore(NAMESPACE).get(TESTABLE_METHOD_TIMEOUT_KEY, TimeoutDuration.class), timeoutProvider);
    }

    private boolean isTimeoutDisabled(ExtensionContext extensionContext) {
        return ((Boolean) extensionContext.getConfigurationParameter("junit.jupiter.execution.timeout.mode").map(new a0(this)).orElse(Boolean.FALSE)).booleanValue();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ TimeoutConfiguration lambda$getGlobalTimeoutConfiguration$2(ExtensionContext extensionContext, String str) {
        return new TimeoutConfiguration(extensionContext);
    }

    private void readAndStoreTimeoutSoChildrenInheritIt(ExtensionContext extensionContext) {
        readTimeoutFromAnnotation(extensionContext.getElement()).ifPresent(new j0(extensionContext));
        readTimeoutThreadModeFromAnnotation(extensionContext.getElement()).ifPresent(new k0(extensionContext));
    }

    private Optional<TimeoutDuration> readTimeoutFromAnnotation(Optional<AnnotatedElement> optional) {
        return AnnotationSupport.findAnnotation((Optional<? extends AnnotatedElement>) optional, Timeout.class).map(new g0());
    }

    private Optional<Timeout.ThreadMode> readTimeoutThreadModeFromAnnotation(Optional<AnnotatedElement> optional) {
        return AnnotationSupport.findAnnotation((Optional<? extends AnnotatedElement>) optional, Timeout.class).map(new o());
    }

    private Timeout.ThreadMode resolveTimeoutThreadMode(ExtensionContext extensionContext) {
        Timeout.ThreadMode annotationThreadMode = getAnnotationThreadMode(extensionContext);
        if (annotationThreadMode == null || annotationThreadMode == Timeout.ThreadMode.INFERRED) {
            return getGlobalTimeoutConfiguration(extensionContext).q().orElse(Timeout.ThreadMode.SAME_THREAD);
        }
        return annotationThreadMode;
    }

    public void beforeAll(ExtensionContext extensionContext) {
        readAndStoreTimeoutSoChildrenInheritIt(extensionContext);
    }

    public void beforeEach(ExtensionContext extensionContext) {
        readAndStoreTimeoutSoChildrenInheritIt(extensionContext);
    }

    public void interceptAfterAllMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        interceptLifecycleMethod(invocation, reflectiveInvocationContext, extensionContext, new f0());
    }

    public void interceptAfterEachMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        interceptLifecycleMethod(invocation, reflectiveInvocationContext, extensionContext, new i0());
    }

    public void interceptBeforeAllMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        interceptLifecycleMethod(invocation, reflectiveInvocationContext, extensionContext, new c0());
    }

    public void interceptBeforeEachMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        interceptLifecycleMethod(invocation, reflectiveInvocationContext, extensionContext, new l0());
    }

    public /* synthetic */ void interceptDynamicTest(InvocationInterceptor.Invocation invocation, DynamicTestInvocationContext dynamicTestInvocationContext, ExtensionContext extensionContext) {
        e.e(this, invocation, dynamicTestInvocationContext, extensionContext);
    }

    public /* synthetic */ void interceptDynamicTest(InvocationInterceptor.Invocation invocation, ExtensionContext extensionContext) {
        e.f(this, invocation, extensionContext);
    }

    public /* synthetic */ Object interceptTestClassConstructor(InvocationInterceptor.Invocation invocation, ReflectiveInvocationContext reflectiveInvocationContext, ExtensionContext extensionContext) {
        return e.g(this, invocation, reflectiveInvocationContext, extensionContext);
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [org.junit.jupiter.api.extension.ReflectiveInvocationContext, org.junit.jupiter.api.extension.ReflectiveInvocationContext<java.lang.reflect.Method>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> T interceptTestFactoryMethod(org.junit.jupiter.api.extension.InvocationInterceptor.Invocation<T> r2, org.junit.jupiter.api.extension.ReflectiveInvocationContext<java.lang.reflect.Method> r3, org.junit.jupiter.api.extension.ExtensionContext r4) throws java.lang.Throwable {
        /*
            r1 = this;
            org.junit.jupiter.engine.extension.b0 r0 = new org.junit.jupiter.engine.extension.b0
            r0.<init>()
            java.lang.Object r2 = r1.interceptTestableMethod(r2, r3, r4, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.extension.TimeoutExtension.interceptTestFactoryMethod(org.junit.jupiter.api.extension.InvocationInterceptor$Invocation, org.junit.jupiter.api.extension.ReflectiveInvocationContext, org.junit.jupiter.api.extension.ExtensionContext):java.lang.Object");
    }

    public void interceptTestMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        interceptTestableMethod(invocation, reflectiveInvocationContext, extensionContext, new d0());
    }

    public void interceptTestTemplateMethod(InvocationInterceptor.Invocation<Void> invocation, ReflectiveInvocationContext<Method> reflectiveInvocationContext, ExtensionContext extensionContext) throws Throwable {
        interceptTestableMethod(invocation, reflectiveInvocationContext, extensionContext, new z());
    }

    /* access modifiers changed from: private */
    public boolean isTimeoutDisabled(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1609594047:
                if (str.equals("enabled")) {
                    c11 = 0;
                    break;
                }
                break;
            case 270940796:
                if (str.equals(DISABLED_MODE_VALUE)) {
                    c11 = 1;
                    break;
                }
                break;
            case 613410390:
                if (str.equals(DISABLED_ON_DEBUG_MODE_VALUE)) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return RuntimeUtils.isDebugMode();
            default:
                throw new ExtensionConfigurationException("Unsupported timeout mode: " + str);
        }
    }
}
