package org.junit.jupiter.engine.discovery;

import java.util.List;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.descriptor.JupiterEngineDescriptor;
import org.junit.jupiter.engine.discovery.AbstractOrderingVisitor;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.TestDescriptor;

class ClassOrderingVisitor extends AbstractOrderingVisitor<JupiterEngineDescriptor, ClassBasedTestDescriptor, DefaultClassDescriptor> {
    private final JupiterConfiguration configuration;

    public ClassOrderingVisitor(JupiterConfiguration jupiterConfiguration) {
        this.configuration = jupiterConfiguration;
    }

    /* access modifiers changed from: private */
    public AbstractOrderingVisitor<JupiterEngineDescriptor, ClassBasedTestDescriptor, DefaultClassDescriptor>.DescriptorWrapperOrderer createDescriptorWrapperOrderer(ClassOrderer classOrderer) {
        i iVar;
        if (classOrderer == null) {
            iVar = null;
        } else {
            iVar = new i(this, classOrderer);
        }
        return new AbstractOrderingVisitor.DescriptorWrapperOrderer(iVar, new j(classOrderer), new k(classOrderer));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$createDescriptorWrapperOrderer$3(ClassOrderer classOrderer, List list) {
        classOrderer.orderClasses(new DefaultClassOrdererContext(list, this.configuration));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ClassOrderer lambda$getDescriptorWrapperOrderer$2(Class cls) {
        return (ClassOrderer) ReflectionUtils.newInstance(cls, new Object[0]);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String lambda$visit$1(JupiterEngineDescriptor jupiterEngineDescriptor) {
        return "Failed to order classes";
    }

    private static String nullSafeToString(ClassOrderer classOrderer) {
        return classOrderer != null ? classOrderer.getClass().getName() : "<unknown>";
    }

    /* access modifiers changed from: private */
    /* renamed from: orderContainedClasses */
    public void lambda$visit$0(JupiterEngineDescriptor jupiterEngineDescriptor, ClassOrderer classOrderer) {
        g(jupiterEngineDescriptor, ClassBasedTestDescriptor.class, new h(), createDescriptorWrapperOrderer(classOrderer));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [org.junit.jupiter.engine.discovery.AbstractAnnotatedDescriptorWrapper, org.junit.jupiter.engine.discovery.AbstractAnnotatedDescriptorWrapper<?>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.junit.jupiter.engine.discovery.AbstractOrderingVisitor<org.junit.jupiter.engine.descriptor.JupiterEngineDescriptor, org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor, org.junit.jupiter.engine.discovery.DefaultClassDescriptor>.DescriptorWrapperOrderer f(org.junit.jupiter.engine.discovery.AbstractOrderingVisitor<org.junit.jupiter.engine.descriptor.JupiterEngineDescriptor, org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor, org.junit.jupiter.engine.discovery.DefaultClassDescriptor>.DescriptorWrapperOrderer r2, org.junit.jupiter.engine.discovery.AbstractAnnotatedDescriptorWrapper<?> r3) {
        /*
            r1 = this;
            java.lang.reflect.AnnotatedElement r3 = r3.a()
            java.lang.Class<org.junit.jupiter.api.TestClassOrder> r0 = org.junit.jupiter.api.TestClassOrder.class
            j$.util.Optional r3 = org.junit.platform.commons.util.AnnotationUtils.findAnnotation((java.lang.reflect.AnnotatedElement) r3, r0)
            e30.h r0 = new e30.h
            r0.<init>()
            j$.util.Optional r3 = r3.map(r0)
            org.junit.jupiter.engine.discovery.l r0 = new org.junit.jupiter.engine.discovery.l
            r0.<init>()
            j$.util.Optional r3 = r3.map(r0)
            org.junit.jupiter.engine.discovery.m r0 = new org.junit.jupiter.engine.discovery.m
            r0.<init>(r1)
            j$.util.Optional r3 = r3.map(r0)
            java.lang.Object r2 = r3.orElse(r2)
            org.junit.jupiter.engine.discovery.AbstractOrderingVisitor$DescriptorWrapperOrderer r2 = (org.junit.jupiter.engine.discovery.AbstractOrderingVisitor.DescriptorWrapperOrderer) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.junit.jupiter.engine.discovery.ClassOrderingVisitor.f(org.junit.jupiter.engine.discovery.AbstractOrderingVisitor$DescriptorWrapperOrderer, org.junit.jupiter.engine.discovery.AbstractAnnotatedDescriptorWrapper):org.junit.jupiter.engine.discovery.AbstractOrderingVisitor$DescriptorWrapperOrderer");
    }

    public void visit(TestDescriptor testDescriptor) {
        e(JupiterEngineDescriptor.class, testDescriptor, new f(this, this.configuration.getDefaultTestClassOrderer().orElse(null)), new g());
    }
}
