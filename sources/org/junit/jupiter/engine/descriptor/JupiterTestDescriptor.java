package org.junit.jupiter.engine.descriptor;

import d30.b;
import d30.c;
import d30.t0;
import d30.u0;
import d30.v0;
import d30.w0;
import d30.x0;
import d30.y0;
import d30.z0;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import java.util.Set;
import org.apiguardian.api.API;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.execution.ConditionEvaluator;
import org.junit.jupiter.engine.execution.JupiterEngineExecutionContext;
import org.junit.jupiter.engine.extension.ExtensionRegistry;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.ExceptionUtils;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.TestSource;
import org.junit.platform.engine.TestTag;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.support.descriptor.AbstractTestDescriptor;
import org.junit.platform.engine.support.hierarchical.EngineExecutionContext;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;
import org.junit.platform.engine.support.hierarchical.Node;
import r30.l;

@API(since = "5.0", status = API.Status.INTERNAL)
public abstract class JupiterTestDescriptor extends AbstractTestDescriptor implements Node<JupiterEngineExecutionContext> {
    private static final ConditionEvaluator conditionEvaluator = new ConditionEvaluator();
    private static final Logger logger = LoggerFactory.getLogger(JupiterTestDescriptor.class);

    /* renamed from: b  reason: collision with root package name */
    public final JupiterConfiguration f62416b;

    /* renamed from: org.junit.jupiter.engine.descriptor.JupiterTestDescriptor$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62417a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f62418b;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002e */
        static {
            /*
                org.junit.jupiter.api.parallel.ResourceAccessMode[] r0 = org.junit.jupiter.api.parallel.ResourceAccessMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f62418b = r0
                r1 = 1
                org.junit.jupiter.api.parallel.ResourceAccessMode r2 = org.junit.jupiter.api.parallel.ResourceAccessMode.READ     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f62418b     // Catch:{ NoSuchFieldError -> 0x001d }
                org.junit.jupiter.api.parallel.ResourceAccessMode r3 = org.junit.jupiter.api.parallel.ResourceAccessMode.READ_WRITE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                org.junit.jupiter.api.parallel.ExecutionMode[] r2 = org.junit.jupiter.api.parallel.ExecutionMode.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f62417a = r2
                org.junit.jupiter.api.parallel.ExecutionMode r3 = org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT     // Catch:{ NoSuchFieldError -> 0x002e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002e }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002e }
            L_0x002e:
                int[] r1 = f62417a     // Catch:{ NoSuchFieldError -> 0x0038 }
                org.junit.jupiter.api.parallel.ExecutionMode r2 = org.junit.jupiter.api.parallel.ExecutionMode.SAME_THREAD     // Catch:{ NoSuchFieldError -> 0x0038 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0038 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0038 }
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.descriptor.JupiterTestDescriptor.AnonymousClass1.<clinit>():void");
        }
    }

    @FunctionalInterface
    public interface ExceptionHandlerInvoker<E extends Extension> {
        void invoke(E e11, Throwable th2) throws Throwable;
    }

    public JupiterTestDescriptor(UniqueId uniqueId, AnnotatedElement annotatedElement, Supplier<String> supplier, TestSource testSource, JupiterConfiguration jupiterConfiguration) {
        this(uniqueId, DisplayNameUtils.h(annotatedElement, supplier), testSource, jupiterConfiguration);
    }

    private <E extends Extension> void invokeExecutionExceptionHandlers(List<E> list, Throwable th2, ExceptionHandlerInvoker<E> exceptionHandlerInvoker) {
        if (list.isEmpty()) {
            ExceptionUtils.throwAsUncheckedException(th2);
        }
        try {
            exceptionHandlerInvoker.invoke((Extension) list.remove(0), th2);
        } catch (Throwable th3) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th3);
            invokeExecutionExceptionHandlers(list, th3, exceptionHandlerInvoker);
        }
    }

    public static Set<TestTag> j(AnnotatedElement annotatedElement) {
        return (Set) Collection.EL.stream(AnnotationUtils.findRepeatableAnnotations(annotatedElement, Tag.class)).map(new u0()).filter(new v0(annotatedElement)).map(new w0()).collect(Collectors.collectingAndThen(Collectors.toCollection(new b()), new c()));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ExclusiveResource lambda$getExclusiveResourcesFromAnnotation$2(ResourceLock resourceLock) {
        return new ExclusiveResource(resourceLock.value(), toLockMode(resourceLock.mode()));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getTags$1(AnnotatedElement annotatedElement, String str) {
        boolean isValid = TestTag.isValid(str);
        if (!isValid) {
            logger.warn(new t0(str, annotatedElement));
        }
        return isValid;
    }

    public static Node.ExecutionMode toExecutionMode(ExecutionMode executionMode) {
        int i11 = AnonymousClass1.f62417a[executionMode.ordinal()];
        if (i11 == 1) {
            return Node.ExecutionMode.CONCURRENT;
        }
        if (i11 == 2) {
            return Node.ExecutionMode.SAME_THREAD;
        }
        throw new JUnitException("Unknown ExecutionMode: " + executionMode);
    }

    private static ExclusiveResource.LockMode toLockMode(ResourceAccessMode resourceAccessMode) {
        int i11 = AnonymousClass1.f62418b[resourceAccessMode.ordinal()];
        if (i11 == 1) {
            return ExclusiveResource.LockMode.READ;
        }
        if (i11 == 2) {
            return ExclusiveResource.LockMode.READ_WRITE;
        }
        throw new JUnitException("Unknown ResourceAccessMode: " + resourceAccessMode);
    }

    private Node.SkipResult toSkipResult(ConditionEvaluationResult conditionEvaluationResult) {
        if (conditionEvaluationResult.isDisabled()) {
            return Node.SkipResult.skip(conditionEvaluationResult.getReason().orElse("<unknown>"));
        }
        return Node.SkipResult.doNotSkip();
    }

    public /* synthetic */ void after(EngineExecutionContext engineExecutionContext) {
        l.a(this, engineExecutionContext);
    }

    public /* synthetic */ void around(EngineExecutionContext engineExecutionContext, Node.Invocation invocation) {
        l.b(this, engineExecutionContext, invocation);
    }

    public /* synthetic */ EngineExecutionContext before(EngineExecutionContext engineExecutionContext) {
        return l.c(this, engineExecutionContext);
    }

    public /* synthetic */ EngineExecutionContext execute(EngineExecutionContext engineExecutionContext, Node.DynamicTestExecutor dynamicTestExecutor) {
        return l.e(this, engineExecutionContext, dynamicTestExecutor);
    }

    public Optional<Node.ExecutionMode> f() {
        return Optional.empty();
    }

    public Set<ExclusiveResource> g(AnnotatedElement annotatedElement) {
        return (Set) Collection.EL.stream(AnnotationUtils.findRepeatableAnnotations(annotatedElement, ResourceLock.class)).map(new x0()).collect(Collectors.toSet());
    }

    public /* synthetic */ Set getExclusiveResources() {
        return l.f(this);
    }

    public Node.ExecutionMode getExecutionMode() {
        Optional<Node.ExecutionMode> i11 = i();
        if (i11.isPresent()) {
            return i11.get();
        }
        Optional<TestDescriptor> parent = getParent();
        while (parent.isPresent() && (parent.get() instanceof JupiterTestDescriptor)) {
            JupiterTestDescriptor jupiterTestDescriptor = (JupiterTestDescriptor) parent.get();
            Optional<Node.ExecutionMode> i12 = jupiterTestDescriptor.i();
            if (i12.isPresent()) {
                return i12.get();
            }
            Optional<Node.ExecutionMode> f11 = jupiterTestDescriptor.f();
            if (f11.isPresent()) {
                return f11.get();
            }
            parent = jupiterTestDescriptor.getParent();
        }
        return toExecutionMode(this.f62416b.getDefaultExecutionMode());
    }

    public Optional<Node.ExecutionMode> h(AnnotatedElement annotatedElement) {
        return AnnotationUtils.findAnnotation(annotatedElement, Execution.class).map(new y0()).map(new z0());
    }

    public Optional<Node.ExecutionMode> i() {
        return Optional.empty();
    }

    public <E extends Extension> void k(Class<E> cls, ExtensionRegistry extensionRegistry, Throwable th2, ExceptionHandlerInvoker<E> exceptionHandlerInvoker) {
        invokeExecutionExceptionHandlers(extensionRegistry.getReversedExtensions(cls), th2, exceptionHandlerInvoker);
    }

    public /* synthetic */ void nodeFinished(EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, TestExecutionResult testExecutionResult) {
        l.h(this, engineExecutionContext, testDescriptor, testExecutionResult);
    }

    public /* synthetic */ void nodeSkipped(EngineExecutionContext engineExecutionContext, TestDescriptor testDescriptor, Node.SkipResult skipResult) {
        l.i(this, engineExecutionContext, testDescriptor, skipResult);
    }

    public abstract JupiterEngineExecutionContext prepare(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Exception;

    public JupiterTestDescriptor(UniqueId uniqueId, String str, TestSource testSource, JupiterConfiguration jupiterConfiguration) {
        super(uniqueId, str, testSource);
        this.f62416b = jupiterConfiguration;
    }

    public void cleanUp(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Exception {
        jupiterEngineExecutionContext.close();
    }

    public Node.SkipResult shouldBeSkipped(JupiterEngineExecutionContext jupiterEngineExecutionContext) throws Exception {
        jupiterEngineExecutionContext.getThrowableCollector().assertEmpty();
        return toSkipResult(conditionEvaluator.evaluate(jupiterEngineExecutionContext.getExtensionRegistry(), jupiterEngineExecutionContext.getConfiguration(), jupiterEngineExecutionContext.getExtensionContext()));
    }
}
