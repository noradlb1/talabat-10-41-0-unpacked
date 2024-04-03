package org.junit.jupiter.engine.discovery;

import d30.b;
import j$.util.Collection;
import j$.util.Optional;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor;
import org.junit.jupiter.engine.descriptor.ClassTestDescriptor;
import org.junit.jupiter.engine.descriptor.NestedClassTestDescriptor;
import org.junit.jupiter.engine.discovery.predicates.IsNestedTestClass;
import org.junit.jupiter.engine.discovery.predicates.IsTestClassWithTests;
import org.junit.platform.commons.support.ReflectionSupport;
import org.junit.platform.commons.util.FunctionUtils;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.engine.discovery.ClasspathResourceSelector;
import org.junit.platform.engine.discovery.ClasspathRootSelector;
import org.junit.platform.engine.discovery.DirectorySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.engine.discovery.FileSelector;
import org.junit.platform.engine.discovery.IterationSelector;
import org.junit.platform.engine.discovery.MethodSelector;
import org.junit.platform.engine.discovery.ModuleSelector;
import org.junit.platform.engine.discovery.NestedClassSelector;
import org.junit.platform.engine.discovery.NestedMethodSelector;
import org.junit.platform.engine.discovery.PackageSelector;
import org.junit.platform.engine.discovery.UniqueIdSelector;
import org.junit.platform.engine.discovery.UriSelector;
import org.junit.platform.engine.support.discovery.SelectorResolver;
import q30.j;
import x20.n;

class ClassSelectorResolver implements SelectorResolver {
    private static final IsNestedTestClass isNestedTestClass = new IsNestedTestClass();
    private static final IsTestClassWithTests isTestClassWithTests = new IsTestClassWithTests();
    private final Predicate<String> classNameFilter;
    private final JupiterConfiguration configuration;

    public ClassSelectorResolver(Predicate<String> predicate, JupiterConfiguration jupiterConfiguration) {
        this.classNameFilter = predicate;
        this.configuration = jupiterConfiguration;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$0(Class cls, TestDescriptor testDescriptor) {
        return Optional.of(newClassTestDescriptor(testDescriptor, cls));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$2(Class cls, TestDescriptor testDescriptor) {
        return Optional.of(newNestedClassTestDescriptor(testDescriptor, cls));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ DiscoverySelector lambda$resolve$3(NestedClassSelector nestedClassSelector) {
        return selectClass(nestedClassSelector.getEnclosingClasses());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$4(NestedClassSelector nestedClassSelector, TestDescriptor testDescriptor) {
        return Optional.of(newNestedClassTestDescriptor(testDescriptor, nestedClassSelector.getNestedClass()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$5(Class cls, TestDescriptor testDescriptor) {
        return Optional.of(newClassTestDescriptor(testDescriptor, cls));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SelectorResolver.Resolution lambda$resolve$6(SelectorResolver.Context context, Class cls) {
        return toResolution(context.addToParent(new x(this, cls)));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$8(TestDescriptor testDescriptor, Class cls) {
        return Optional.of(newNestedClassTestDescriptor(testDescriptor, cls));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$9(String str, TestDescriptor testDescriptor) {
        if (testDescriptor instanceof ClassBasedTestDescriptor) {
            return Collection.EL.stream(ReflectionUtils.findNestedClasses(((ClassBasedTestDescriptor) testDescriptor).getTestClass(), isNestedTestClass.and(FunctionUtils.where(new n(), Predicate.CC.isEqual(str))))).findFirst().flatMap(new n(this, testDescriptor));
        }
        return Optional.empty();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Set lambda$toResolution$12(Class cls, List list) {
        return (Set) Stream.CC.concat(Collection.EL.stream(ReflectionUtils.findMethods(cls, IsTestClassWithTests.isTestOrTestFactoryOrTestTemplateMethod)).map(new u(this, list)), Collection.EL.stream(ReflectionSupport.findNestedClasses(cls, isNestedTestClass)).map(new v(list))).collect(Collectors.toCollection(new b()));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SelectorResolver.Resolution lambda$toResolution$13(ClassBasedTestDescriptor classBasedTestDescriptor) {
        Class<?> testClass = classBasedTestDescriptor.getTestClass();
        ArrayList arrayList = new ArrayList(classBasedTestDescriptor.getEnclosingTestClasses());
        arrayList.add(testClass);
        return SelectorResolver.Resolution.match(SelectorResolver.Match.exact(classBasedTestDescriptor, new w(this, testClass, arrayList)));
    }

    private ClassTestDescriptor newClassTestDescriptor(TestDescriptor testDescriptor, Class<?> cls) {
        return new ClassTestDescriptor(testDescriptor.getUniqueId().append("class", cls.getName()), cls, this.configuration);
    }

    private NestedClassTestDescriptor newNestedClassTestDescriptor(TestDescriptor testDescriptor, Class<?> cls) {
        return new NestedClassTestDescriptor(testDescriptor.getUniqueId().append(NestedClassTestDescriptor.SEGMENT_TYPE, cls.getSimpleName()), cls, this.configuration);
    }

    private DiscoverySelector selectClass(List<Class<?>> list) {
        if (list.size() == 1) {
            return DiscoverySelectors.selectClass(list.get(0));
        }
        int size = list.size() - 1;
        return DiscoverySelectors.selectNestedClass(list.subList(0, size), list.get(size));
    }

    /* access modifiers changed from: private */
    /* renamed from: selectMethod */
    public DiscoverySelector lambda$toResolution$10(List<Class<?>> list, Method method) {
        if (list.size() == 1) {
            return DiscoverySelectors.selectMethod(list.get(0), method);
        }
        int size = list.size() - 1;
        return DiscoverySelectors.selectNestedMethod(list.subList(0, size), list.get(size), method);
    }

    private SelectorResolver.Resolution toResolution(Optional<? extends ClassBasedTestDescriptor> optional) {
        return (SelectorResolver.Resolution) optional.map(new r(this)).orElse(SelectorResolver.Resolution.unresolved());
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(DiscoverySelector discoverySelector, SelectorResolver.Context context) {
        return j.a(this, discoverySelector, context);
    }

    public SelectorResolver.Resolution resolve(ClassSelector classSelector, SelectorResolver.Context context) {
        Class<?> javaClass = classSelector.getJavaClass();
        if (isTestClassWithTests.test(javaClass)) {
            if (this.classNameFilter.test(javaClass.getName())) {
                return toResolution(context.addToParent(new o(this, javaClass)));
            }
        } else if (isNestedTestClass.test(javaClass)) {
            return toResolution(context.addToParent(new p(javaClass), new q(this, javaClass)));
        }
        return SelectorResolver.Resolution.unresolved();
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(ClasspathResourceSelector classpathResourceSelector, SelectorResolver.Context context) {
        return j.c(this, classpathResourceSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(ClasspathRootSelector classpathRootSelector, SelectorResolver.Context context) {
        return j.d(this, classpathRootSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(DirectorySelector directorySelector, SelectorResolver.Context context) {
        return j.e(this, directorySelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(FileSelector fileSelector, SelectorResolver.Context context) {
        return j.f(this, fileSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(IterationSelector iterationSelector, SelectorResolver.Context context) {
        return j.g(this, iterationSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(MethodSelector methodSelector, SelectorResolver.Context context) {
        return j.h(this, methodSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(ModuleSelector moduleSelector, SelectorResolver.Context context) {
        return j.i(this, moduleSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(NestedMethodSelector nestedMethodSelector, SelectorResolver.Context context) {
        return j.k(this, nestedMethodSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(PackageSelector packageSelector, SelectorResolver.Context context) {
        return j.l(this, packageSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(UriSelector uriSelector, SelectorResolver.Context context) {
        return j.n(this, uriSelector, context);
    }

    public SelectorResolver.Resolution resolve(NestedClassSelector nestedClassSelector, SelectorResolver.Context context) {
        if (isNestedTestClass.test(nestedClassSelector.getNestedClass())) {
            return toResolution(context.addToParent(new s(this, nestedClassSelector), new t(this, nestedClassSelector)));
        }
        return SelectorResolver.Resolution.unresolved();
    }

    public SelectorResolver.Resolution resolve(UniqueIdSelector uniqueIdSelector, SelectorResolver.Context context) {
        UniqueId uniqueId = uniqueIdSelector.getUniqueId();
        UniqueId.Segment lastSegment = uniqueId.getLastSegment();
        if ("class".equals(lastSegment.getType())) {
            return (SelectorResolver.Resolution) ReflectionUtils.tryToLoadClass(lastSegment.getValue()).toOptional().filter(isTestClassWithTests).map(new y(this, context)).orElse(SelectorResolver.Resolution.unresolved());
        }
        if (!NestedClassTestDescriptor.SEGMENT_TYPE.equals(lastSegment.getType())) {
            return SelectorResolver.Resolution.unresolved();
        }
        return toResolution(context.addToParent(new z(uniqueId), new a0(this, lastSegment.getValue())));
    }
}
