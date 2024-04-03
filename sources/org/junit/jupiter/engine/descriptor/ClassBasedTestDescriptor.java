package org.junit.jupiter.engine.descriptor;

import d30.a0;
import d30.b0;
import d30.c0;
import d30.d;
import d30.d0;
import d30.e;
import d30.e0;
import d30.f;
import d30.g;
import d30.h;
import d30.i;
import d30.j;
import d30.k;
import d30.l;
import d30.m;
import d30.n;
import d30.o;
import d30.p;
import d30.q;
import d30.r;
import d30.s;
import d30.t;
import d30.v;
import d30.w;
import d30.x;
import d30.y;
import d30.z;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionConfigurationException;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.LifecycleMethodExecutionExceptionHandler;
import org.junit.jupiter.api.extension.TestInstanceFactory;
import org.junit.jupiter.api.extension.TestInstanceFactoryContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;
import org.junit.jupiter.api.extension.TestInstancePreConstructCallback;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.jupiter.api.extension.TestInstantiationException;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.AfterEachMethodAdapter;
import org.junit.jupiter.engine.execution.BeforeEachMethodAdapter;
import org.junit.jupiter.engine.execution.DefaultExecutableInvoker;
import org.junit.jupiter.engine.execution.DefaultTestInstances;
import org.junit.jupiter.engine.execution.InterceptingExecutableInvoker;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.execution.TestInstancesProvider;
import org.junit.jupiter.engine.extension.ExtensionRegistrar;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.jupiter.engine.extension.MutableExtensionRegistry;
import org.junit.jupiter.engine.support.JupiterThrowableCollectorFactory;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.commons.util.StringUtils;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestTag;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.ClassSource;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;
import org.junit.platform.engine.support.hierarchical.Node;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.5", status = API.Status.INTERNAL)
public abstract class ClassBasedTestDescriptor extends JupiterTestDescriptor {
    private static final InterceptingExecutableInvoker executableInvoker = new InterceptingExecutableInvoker();
    private List<Method> afterAllMethods;
    private List<Method> beforeAllMethods;

    /* renamed from: c  reason: collision with root package name */
    public final Set<TestTag> f62413c;

    /* renamed from: d  reason: collision with root package name */
    public final TestInstance.Lifecycle f62414d;
    private Node.ExecutionMode defaultChildExecutionMode;
    private final Class<?> testClass;
    private TestInstanceFactory testInstanceFactory;

    public ClassBasedTestDescriptor(UniqueId uniqueId, Class<?> cls, Supplier<String> supplier, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, cls, supplier, ClassSource.from(cls), jupiterConfiguration);
        Node.ExecutionMode executionMode;
        this.testClass = cls;
        this.f62413c = JupiterTestDescriptor.j(cls);
        TestInstance.Lifecycle a11 = TestInstanceLifecycleUtils.a(cls, jupiterConfiguration);
        this.f62414d = a11;
        if (a11 == TestInstance.Lifecycle.PER_CLASS) {
            executionMode = Node.ExecutionMode.SAME_THREAD;
        } else {
            executionMode = null;
        }
        this.defaultChildExecutionMode = executionMode;
    }

    private void executeAndMaskThrowable(Executable executable) {
        try {
            executable.execute();
        } catch (Throwable th2) {
            ExceptionUtils.throwAsUncheckedException(th2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: instantiateAndPostProcessTestInstance */
    public TestInstances lambda$testInstancesProvider$4(JupiterEngineExecutionContext jupiterEngineExecutionContext, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ThrowableCollector throwableCollector) {
        TestInstances O = O(jupiterEngineExecutionContext, extensionRegistry, extensionRegistrar, extensionContext, throwableCollector);
        throwableCollector.execute(new s(this, O, extensionRegistry, extensionContext, extensionRegistrar));
        return O;
    }

    private void invokeAfterAllCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry extensionRegistry = jupiterEngineExecutionContext.getExtensionRegistry();
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        Iterable.EL.forEach(extensionRegistry.getReversedExtensions(AfterAllCallback.class), new h(jupiterEngineExecutionContext.getThrowableCollector(), extensionContext));
    }

    private void invokeAfterAllMethodExecutionExceptionHandlers(ExtensionRegistry extensionRegistry, ExtensionContext extensionContext, Throwable th2) {
        k(LifecycleMethodExecutionExceptionHandler.class, extensionRegistry, th2, new e(extensionContext));
    }

    private void invokeAfterAllMethods(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry extensionRegistry = jupiterEngineExecutionContext.getExtensionRegistry();
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        Iterable.EL.forEach(this.afterAllMethods, new e0(this, jupiterEngineExecutionContext.getThrowableCollector(), extensionContext.getTestInstance().orElse(null), extensionContext, extensionRegistry));
    }

    private void invokeBeforeAllCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry extensionRegistry = jupiterEngineExecutionContext.getExtensionRegistry();
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        ThrowableCollector throwableCollector = jupiterEngineExecutionContext.getThrowableCollector();
        for (E yVar : extensionRegistry.getExtensions(BeforeAllCallback.class)) {
            throwableCollector.execute(new y(yVar, extensionContext));
            if (throwableCollector.isNotEmpty()) {
                return;
            }
        }
    }

    private void invokeBeforeAllMethodExecutionExceptionHandlers(ExtensionRegistry extensionRegistry, ExtensionContext extensionContext, Throwable th2) {
        k(LifecycleMethodExecutionExceptionHandler.class, extensionRegistry, th2, new c(extensionContext));
    }

    private void invokeBeforeAllMethods(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry extensionRegistry = jupiterEngineExecutionContext.getExtensionRegistry();
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        ThrowableCollector throwableCollector = jupiterEngineExecutionContext.getThrowableCollector();
        Object orElse = extensionContext.getTestInstance().orElse(null);
        for (Method kVar : this.beforeAllMethods) {
            throwableCollector.execute(new k(this, kVar, orElse, extensionContext, extensionRegistry));
            if (throwableCollector.isNotEmpty()) {
                return;
            }
        }
    }

    private void invokeMethodInExtensionContext(Method method, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, InterceptingExecutableInvoker.ReflectiveInterceptorCall.VoidMethodInterceptorCall voidMethodInterceptorCall) {
        Method method2 = method;
        executableInvoker.invoke(method2, (Object) extensionContext.getRequiredTestInstances().findInstance(this.testClass).orElseThrow(new i(method)), extensionContext, extensionRegistry, f30.i.b(voidMethodInterceptorCall));
    }

    private Object invokeTestClassConstructor(Optional<Object> optional, ExtensionRegistry extensionRegistry, ExtensionContext extensionContext) {
        return executableInvoker.invoke(ReflectionUtils.getDeclaredConstructor(this.testClass), optional, extensionContext, extensionRegistry, new v());
    }

    private Object invokeTestInstanceFactory(Optional<Object> optional, ExtensionContext extensionContext) {
        Class<?> cls;
        String str;
        try {
            Object createTestInstance = this.testInstanceFactory.createTestInstance(new DefaultTestInstanceFactoryContext(this.testClass, optional), extensionContext);
            if (this.testClass.isInstance(createTestInstance)) {
                return createTestInstance;
            }
            String name2 = this.testClass.getName();
            if (createTestInstance == null) {
                cls = null;
            } else {
                cls = createTestInstance.getClass();
            }
            if (cls == null) {
                str = "null";
            } else {
                str = cls.getName();
            }
            if (name2.equals(str)) {
                str = str + "@" + Integer.toHexString(System.identityHashCode(cls));
                name2 = name2 + "@" + Integer.toHexString(System.identityHashCode(this.testClass));
            }
            throw new TestInstantiationException(String.format("TestInstanceFactory [%s] failed to return an instance of [%s] and instead returned an instance of [%s].", new Object[]{this.testInstanceFactory.getClass().getName(), name2, str}));
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            if (!(th2 instanceof TestInstantiationException)) {
                String format = String.format("TestInstanceFactory [%s] failed to instantiate test class [%s]", new Object[]{this.testInstanceFactory.getClass().getName(), this.testClass.getName()});
                if (StringUtils.isNotBlank(th2.getMessage())) {
                    format = format + ": " + th2.getMessage();
                }
                throw new TestInstantiationException(format, th2);
            }
            throw th2;
        }
    }

    private void invokeTestInstancePostProcessors(Object obj, ExtensionRegistry extensionRegistry, ExtensionContext extensionContext) {
        extensionRegistry.stream(TestInstancePostProcessor.class).forEach(new r(this, obj, extensionContext));
    }

    private void invokeTestInstancePreConstructCallbacks(TestInstanceFactoryContext testInstanceFactoryContext, ExtensionRegistry extensionRegistry, ExtensionContext extensionContext) {
        extensionRegistry.stream(TestInstancePreConstructCallback.class).forEach(new t(this, testInstanceFactoryContext, extensionContext));
    }

    private void invokeTestInstancePreDestroyCallbacks(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        ExtensionContext extensionContext = jupiterEngineExecutionContext.getExtensionContext();
        Iterable.EL.forEach(jupiterEngineExecutionContext.getExtensionRegistry().getReversedExtensions(TestInstancePreDestroyCallback.class), new j(jupiterEngineExecutionContext.getThrowableCollector(), extensionContext));
    }

    private boolean isPerClassLifecycle(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        return jupiterEngineExecutionContext.getExtensionContext().getTestInstanceLifecycle().orElse(TestInstance.Lifecycle.PER_METHOD) == TestInstance.Lifecycle.PER_CLASS;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$instantiateAndPostProcessTestInstance$6(TestInstances testInstances, ExtensionRegistry extensionRegistry, ExtensionContext extensionContext, ExtensionRegistrar extensionRegistrar) throws Throwable {
        invokeTestInstancePostProcessors(testInstances.getInnermostInstance(), extensionRegistry, extensionContext);
        ExtensionUtils.l(extensionRegistrar, this.testClass, testInstances.getInnermostInstance());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeAfterAllMethods$15(Method method, Object obj, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) throws Throwable {
        try {
            executableInvoker.invoke(method, obj, extensionContext, extensionRegistry, f30.i.b(new x()));
        } catch (Throwable th2) {
            invokeAfterAllMethodExecutionExceptionHandlers(extensionRegistry, extensionContext, th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeAfterAllMethods$16(ThrowableCollector throwableCollector, Object obj, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry, Method method) {
        throwableCollector.execute(new e(this, method, obj, extensionContext, extensionRegistry));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeBeforeAllMethods$13(Method method, Object obj, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) throws Throwable {
        try {
            executableInvoker.invoke(method, obj, extensionContext, extensionRegistry, f30.i.b(new c0()));
        } catch (Throwable th2) {
            invokeBeforeAllMethodExecutionExceptionHandlers(extensionRegistry, extensionContext, th2);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JUnitException lambda$invokeMethodInExtensionContext$25(Method method) {
        return new JUnitException("Failed to find instance for method: " + method.toGenericString());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeTestInstancePostProcessors$11(Object obj, ExtensionContext extensionContext, TestInstancePostProcessor testInstancePostProcessor) {
        executeAndMaskThrowable(new q(testInstancePostProcessor, obj, extensionContext));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$invokeTestInstancePreConstructCallbacks$9(TestInstanceFactoryContext testInstanceFactoryContext, ExtensionContext extensionContext, TestInstancePreConstructCallback testInstancePreConstructCallback) {
        executeAndMaskThrowable(new o(testInstancePreConstructCallback, testInstanceFactoryContext, extensionContext));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$registerMethodsAsExtensions$22(ExtensionRegistrar extensionRegistrar, Function function, Method method) {
        ExtensionUtils.k(extensionRegistrar, method);
        extensionRegistrar.registerSyntheticExtension((Extension) function.apply(method), method);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$synthesizeAfterEachMethodAdapter$24(Method method, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) throws Throwable {
        invokeMethodInExtensionContext(method, extensionContext, extensionRegistry, new m());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$synthesizeBeforeEachMethodAdapter$23(Method method, ExtensionContext extensionContext, ExtensionRegistry extensionRegistry) throws Throwable {
        invokeMethodInExtensionContext(method, extensionContext, extensionRegistry, new d());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ TestInstances lambda$testInstancesProvider$5(ClassExtensionContext classExtensionContext, JupiterEngineExecutionContext jupiterEngineExecutionContext, ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ThrowableCollector throwableCollector) {
        return classExtensionContext.getTestInstances().orElseGet(new d(this, jupiterEngineExecutionContext, classExtensionContext, extensionRegistry, extensionRegistrar, throwableCollector));
    }

    private void registerAfterEachMethodAdapters(ExtensionRegistrar extensionRegistrar) {
        ArrayList arrayList = new ArrayList(LifecycleMethodUtils.f(this.testClass));
        Collections.reverse(arrayList);
        registerMethodsAsExtensions(arrayList, extensionRegistrar, new b0(this));
    }

    private void registerBeforeEachMethodAdapters(ExtensionRegistrar extensionRegistrar) {
        registerMethodsAsExtensions(LifecycleMethodUtils.h(this.testClass), extensionRegistrar, new g(this));
    }

    private void registerMethodsAsExtensions(List<Method> list, ExtensionRegistrar extensionRegistrar, Function<Method, Extension> function) {
        Iterable.EL.forEach(list, new d0(extensionRegistrar, function));
    }

    private TestInstanceFactory resolveTestInstanceFactory(ExtensionRegistry extensionRegistry) {
        List<E> extensions = extensionRegistry.getExtensions(TestInstanceFactory.class);
        if (extensions.size() == 1) {
            return (TestInstanceFactory) extensions.get(0);
        }
        if (extensions.size() <= 1) {
            return null;
        }
        throw new ExtensionConfigurationException(String.format("The following TestInstanceFactory extensions were registered for test class [%s], but only one is permitted: %s", new Object[]{this.testClass.getName(), (String) Collection.EL.stream(extensions).map(new w()).collect(Collectors.joining(IndicativeSentencesGeneration.DEFAULT_SEPARATOR))}));
    }

    /* access modifiers changed from: private */
    public AfterEachMethodAdapter synthesizeAfterEachMethodAdapter(Method method) {
        return new f(this, method);
    }

    /* access modifiers changed from: private */
    public BeforeEachMethodAdapter synthesizeBeforeEachMethodAdapter(Method method) {
        return new l(this, method);
    }

    private TestInstancesProvider testInstancesProvider(JupiterEngineExecutionContext jupiterEngineExecutionContext, ClassExtensionContext classExtensionContext) {
        return new a(this, classExtensionContext, jupiterEngineExecutionContext);
    }

    public TestInstances N(Optional<TestInstances> optional, ExtensionRegistry extensionRegistry, ExtensionContext extensionContext) {
        Object obj;
        Optional<U> map = optional.map(new z());
        invokeTestInstancePreConstructCallbacks(new DefaultTestInstanceFactoryContext(this.testClass, map), extensionRegistry, extensionContext);
        if (this.testInstanceFactory != null) {
            obj = invokeTestInstanceFactory(map, extensionContext);
        } else {
            obj = invokeTestClassConstructor(map, extensionRegistry, extensionContext);
        }
        return (TestInstances) optional.map(new a0(obj)).orElse(DefaultTestInstances.of(obj));
    }

    public abstract TestInstances O(JupiterEngineExecutionContext jupiterEngineExecutionContext, ExtensionRegistry extensionRegistry, ExtensionRegistrar extensionRegistrar, ExtensionContext extensionContext, ThrowableCollector throwableCollector);

    public Optional<Node.ExecutionMode> f() {
        return Optional.ofNullable(this.defaultChildExecutionMode);
    }

    public abstract List<Class<?>> getEnclosingTestClasses();

    public Set<ExclusiveResource> getExclusiveResources() {
        return g(getTestClass());
    }

    public String getLegacyReportingName() {
        return this.testClass.getName();
    }

    public final Class<?> getTestClass() {
        return this.testClass;
    }

    public TestDescriptor.Type getType() {
        return TestDescriptor.Type.CONTAINER;
    }

    public Optional<Node.ExecutionMode> i() {
        return h(getTestClass());
    }

    public void setDefaultChildExecutionMode(Node.ExecutionMode executionMode) {
        this.defaultChildExecutionMode = executionMode;
    }

    public void after(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        ThrowableCollector throwableCollector = jupiterEngineExecutionContext.getThrowableCollector();
        Throwable throwable = throwableCollector.getThrowable();
        if (jupiterEngineExecutionContext.beforeAllMethodsExecuted()) {
            invokeAfterAllMethods(jupiterEngineExecutionContext);
        }
        if (jupiterEngineExecutionContext.beforeAllCallbacksExecuted()) {
            invokeAfterAllCallbacks(jupiterEngineExecutionContext);
        }
        if (isPerClassLifecycle(jupiterEngineExecutionContext) && jupiterEngineExecutionContext.getExtensionContext().getTestInstance().isPresent()) {
            invokeTestInstancePreDestroyCallbacks(jupiterEngineExecutionContext);
        }
        if (throwable != throwableCollector.getThrowable()) {
            throwableCollector.assertEmpty();
        }
    }

    public JupiterEngineExecutionContext before(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        ThrowableCollector throwableCollector = jupiterEngineExecutionContext.getThrowableCollector();
        if (isPerClassLifecycle(jupiterEngineExecutionContext)) {
            throwableCollector.execute(new b(jupiterEngineExecutionContext, throwableCollector, (ClassExtensionContext) jupiterEngineExecutionContext.getExtensionContext()));
        }
        if (throwableCollector.isEmpty()) {
            jupiterEngineExecutionContext.beforeAllCallbacksExecuted(true);
            invokeBeforeAllCallbacks(jupiterEngineExecutionContext);
            if (throwableCollector.isEmpty()) {
                jupiterEngineExecutionContext.beforeAllMethodsExecuted(true);
                invokeBeforeAllMethods(jupiterEngineExecutionContext);
            }
        }
        throwableCollector.assertEmpty();
        return jupiterEngineExecutionContext;
    }

    public JupiterEngineExecutionContext prepare(JupiterEngineExecutionContext jupiterEngineExecutionContext) {
        MutableExtensionRegistry i11 = ExtensionUtils.i(jupiterEngineExecutionContext.getExtensionRegistry(), this.testClass);
        ExtensionUtils.l(i11, this.testClass, (Object) null);
        TestInstanceFactory resolveTestInstanceFactory = resolveTestInstanceFactory(i11);
        this.testInstanceFactory = resolveTestInstanceFactory;
        if (resolveTestInstanceFactory == null) {
            ExtensionUtils.j(i11, this.testClass);
        }
        Class<?> cls = this.testClass;
        TestInstance.Lifecycle lifecycle = this.f62414d;
        TestInstance.Lifecycle lifecycle2 = TestInstance.Lifecycle.PER_METHOD;
        boolean z11 = true;
        this.beforeAllMethods = LifecycleMethodUtils.g(cls, lifecycle == lifecycle2);
        Class<?> cls2 = this.testClass;
        if (this.f62414d != lifecycle2) {
            z11 = false;
        }
        this.afterAllMethods = LifecycleMethodUtils.e(cls2, z11);
        Iterable.EL.forEach(this.beforeAllMethods, new n(i11));
        registerBeforeEachMethodAdapters(i11);
        registerAfterEachMethodAdapters(i11);
        Iterable.EL.forEach(this.afterAllMethods, new p(i11));
        ThrowableCollector createThrowableCollector = JupiterThrowableCollectorFactory.createThrowableCollector();
        ClassExtensionContext classExtensionContext = new ClassExtensionContext(jupiterEngineExecutionContext.getExtensionContext(), jupiterEngineExecutionContext.getExecutionListener(), this, this.f62414d, jupiterEngineExecutionContext.getConfiguration(), createThrowableCollector, new DefaultExecutableInvoker(jupiterEngineExecutionContext));
        return jupiterEngineExecutionContext.extend().withTestInstancesProvider(testInstancesProvider(jupiterEngineExecutionContext, classExtensionContext)).withExtensionRegistry(i11).withExtensionContext(classExtensionContext).withThrowableCollector(createThrowableCollector).build();
    }
}
