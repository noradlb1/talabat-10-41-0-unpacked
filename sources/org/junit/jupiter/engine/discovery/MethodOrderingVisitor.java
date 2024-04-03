package org.junit.jupiter.engine.discovery;

import d30.z0;
import e30.p;
import e30.q;
import e30.r;
import e30.s;
import j$.util.Optional;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.descriptor.MethodBasedTestDescriptor;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;
import org.junit.platform.commons.support.AnnotationSupport;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.TestDescriptor;

class MethodOrderingVisitor extends AbstractOrderingVisitor<ClassBasedTestDescriptor, MethodBasedTestDescriptor, DefaultMethodDescriptor> {
    private final JupiterConfiguration configuration;

    public MethodOrderingVisitor(JupiterConfiguration jupiterConfiguration) {
        this.configuration = jupiterConfiguration;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ MethodOrderer lambda$orderContainedMethods$2(Class cls) {
        return (MethodOrderer) ReflectionUtils.newInstance(cls, new Object[0]);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$orderContainedMethods$3(MethodOrderer methodOrderer, Class cls, List list) {
        methodOrderer.orderMethods(new DefaultMethodOrdererContext(cls, list, this.configuration));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$orderContainedMethods$6(Class cls, ClassBasedTestDescriptor classBasedTestDescriptor, MethodOrderer methodOrderer) {
        Class<MethodBasedTestDescriptor> cls2 = MethodBasedTestDescriptor.class;
        g(classBasedTestDescriptor, cls2, new c0(), new AbstractOrderingVisitor.DescriptorWrapperOrderer(new h0(this, methodOrderer, cls), new i0(methodOrderer, cls), new j0(methodOrderer, cls)));
        Optional<U> map = methodOrderer.getDefaultExecutionMode().map(new z0());
        Objects.requireNonNull(classBasedTestDescriptor);
        map.ifPresent(new q(classBasedTestDescriptor));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$visit$0(ClassBasedTestDescriptor classBasedTestDescriptor) {
        orderContainedMethods(classBasedTestDescriptor, classBasedTestDescriptor.getTestClass());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$visit$1(ClassBasedTestDescriptor classBasedTestDescriptor) {
        return "Failed to order methods for " + classBasedTestDescriptor.getTestClass();
    }

    private void orderContainedMethods(ClassBasedTestDescriptor classBasedTestDescriptor, Class<?> cls) {
        Optional<U> map = AnnotationSupport.findAnnotation((AnnotatedElement) cls, TestMethodOrder.class).map(new p()).map(new d0()).map(new r());
        JupiterConfiguration jupiterConfiguration = this.configuration;
        Objects.requireNonNull(jupiterConfiguration);
        ((Optional) map.orElseGet(new s(jupiterConfiguration))).ifPresent(new e0(this, cls, classBasedTestDescriptor));
    }

    public void visit(TestDescriptor testDescriptor) {
        e(ClassBasedTestDescriptor.class, testDescriptor, new f0(this), new g0());
    }
}
