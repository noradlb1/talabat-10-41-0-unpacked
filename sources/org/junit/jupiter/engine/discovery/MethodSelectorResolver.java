package org.junit.jupiter.engine.discovery;

import d30.a2;
import d30.i0;
import e30.t;
import e30.v;
import e30.w;
import j$.util.DesugarArrays;
import j$.util.Optional;
import j$.util.function.BiFunction;
import j$.util.function.Predicate;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.engine.config.JupiterConfiguration;
import org.junit.jupiter.engine.descriptor.Filterable;
import org.junit.jupiter.engine.descriptor.TestFactoryTestDescriptor;
import org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor;
import org.junit.jupiter.engine.descriptor.TestTemplateInvocationTestDescriptor;
import org.junit.jupiter.engine.descriptor.TestTemplateTestDescriptor;
import org.junit.jupiter.engine.discovery.predicates.IsNestedTestClass;
import org.junit.jupiter.engine.discovery.predicates.IsTestClassWithTests;
import org.junit.jupiter.engine.discovery.predicates.IsTestFactoryMethod;
import org.junit.jupiter.engine.discovery.predicates.IsTestMethod;
import org.junit.jupiter.engine.discovery.predicates.IsTestTemplateMethod;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.junit.platform.commons.util.ClassUtils;
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

class MethodSelectorResolver implements SelectorResolver {
    private static final Logger logger = LoggerFactory.getLogger(MethodSelectorResolver.class);
    /* access modifiers changed from: private */
    public static final MethodFinder methodFinder = new MethodFinder();
    private static final Predicate<Class<?>> testClassPredicate = new IsTestClassWithTests().or(new IsNestedTestClass());

    /* renamed from: a  reason: collision with root package name */
    public final JupiterConfiguration f62487a;

    public enum MethodType {
        TEST(new IsTestMethod(), "method", new String[0]) {
            public TestDescriptor h(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
                return new TestMethodTestDescriptor(uniqueId, cls, method, jupiterConfiguration);
            }
        },
        TEST_FACTORY(new IsTestFactoryMethod(), TestFactoryTestDescriptor.SEGMENT_TYPE, TestFactoryTestDescriptor.DYNAMIC_CONTAINER_SEGMENT_TYPE, TestFactoryTestDescriptor.DYNAMIC_TEST_SEGMENT_TYPE) {
            public TestDescriptor h(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
                return new TestFactoryTestDescriptor(uniqueId, cls, method, jupiterConfiguration);
            }
        },
        TEST_TEMPLATE(new IsTestTemplateMethod(), TestTemplateTestDescriptor.SEGMENT_TYPE, TestTemplateInvocationTestDescriptor.SEGMENT_TYPE) {
            public TestDescriptor h(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration) {
                return new TestTemplateTestDescriptor(uniqueId, cls, method, jupiterConfiguration);
            }
        };
        
        private final Set<String> dynamicDescendantSegmentTypes;
        private final Predicate<Method> methodPredicate;
        private final String segmentType;

        private UniqueId createUniqueId(Method method, TestDescriptor testDescriptor) {
            return testDescriptor.getUniqueId().append(this.segmentType, String.format("%s(%s)", new Object[]{method.getName(), ClassUtils.nullSafeToString((Class<?>[]) method.getParameterTypes())}));
        }

        /* access modifiers changed from: private */
        public Optional<TestDescriptor> resolve(List<Class<?>> list, Class<?> cls, Method method, SelectorResolver.Context context, JupiterConfiguration jupiterConfiguration) {
            if (!this.methodPredicate.test(method)) {
                return Optional.empty();
            }
            return context.addToParent(new v0(this, list, cls), new w0(this, method, cls, jupiterConfiguration));
        }

        /* access modifiers changed from: private */
        public Optional<TestDescriptor> resolveUniqueIdIntoTestDescriptor(UniqueId uniqueId, SelectorResolver.Context context, JupiterConfiguration jupiterConfiguration) {
            UniqueId.Segment lastSegment = uniqueId.getLastSegment();
            if (this.segmentType.equals(lastSegment.getType())) {
                return context.addToParent(new s0(uniqueId), new t0(this, lastSegment, jupiterConfiguration));
            }
            if (this.dynamicDescendantSegmentTypes.contains(lastSegment.getType())) {
                return resolveUniqueIdIntoTestDescriptor(uniqueId.removeLastSegment(), context, jupiterConfiguration);
            }
            return Optional.empty();
        }

        /* access modifiers changed from: private */
        /* renamed from: selectClass */
        public DiscoverySelector lambda$resolve$0(List<Class<?>> list, Class<?> cls) {
            if (list.isEmpty()) {
                return DiscoverySelectors.selectClass(cls);
            }
            return DiscoverySelectors.selectNestedClass(list, cls);
        }

        public abstract TestDescriptor h(UniqueId uniqueId, Class<?> cls, Method method, JupiterConfiguration jupiterConfiguration);

        private MethodType(Predicate<Method> predicate, String str, String... strArr) {
            this.methodPredicate = predicate;
            this.segmentType = str;
            this.dynamicDescendantSegmentTypes = new LinkedHashSet(Arrays.asList(strArr));
        }
    }

    public MethodSelectorResolver(JupiterConfiguration jupiterConfiguration) {
        this.f62487a = jupiterConfiguration;
    }

    private Supplier<Set<? extends DiscoverySelector>> expansionCallback(TestDescriptor testDescriptor) {
        return new k0(testDescriptor);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Set lambda$expansionCallback$7(TestDescriptor testDescriptor) {
        if (testDescriptor instanceof Filterable) {
            ((Filterable) testDescriptor).getDynamicDescendantFilter().allowAll();
        }
        return Collections.emptySet();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$0(List list, Class cls, Method method, SelectorResolver.Context context, MethodType methodType) {
        return methodType.resolve(list, cls, method, context, this.f62487a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SelectorResolver.Match lambda$resolve$1(BiFunction biFunction, TestDescriptor testDescriptor) {
        return (SelectorResolver.Match) biFunction.apply(testDescriptor, expansionCallback(testDescriptor));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Optional lambda$resolve$4(UniqueId uniqueId, SelectorResolver.Context context, MethodType methodType) {
        return methodType.resolveUniqueIdIntoTestDescriptor(uniqueId, context, this.f62487a);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SelectorResolver.Resolution lambda$resolve$5(UniqueId uniqueId, TestDescriptor testDescriptor) {
        SelectorResolver.Match match;
        boolean equals = uniqueId.equals(testDescriptor.getUniqueId());
        if (testDescriptor instanceof Filterable) {
            Filterable filterable = (Filterable) testDescriptor;
            if (equals) {
                filterable.getDynamicDescendantFilter().allowAll();
            } else {
                filterable.getDynamicDescendantFilter().allowUniqueIdPrefix(uniqueId);
            }
        }
        if (equals) {
            match = SelectorResolver.Match.exact(testDescriptor);
        } else {
            match = SelectorResolver.Match.partial(testDescriptor, expansionCallback(testDescriptor));
        }
        return SelectorResolver.Resolution.match(match);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ SelectorResolver.Match lambda$resolve$6(IterationSelector iterationSelector, TestDescriptor testDescriptor, Supplier supplier) {
        if (testDescriptor instanceof Filterable) {
            ((Filterable) testDescriptor).getDynamicDescendantFilter().allowIndex(iterationSelector.getIterationIndices());
        }
        return SelectorResolver.Match.partial(testDescriptor, supplier);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(DiscoverySelector discoverySelector, SelectorResolver.Context context) {
        return j.a(this, discoverySelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(ClassSelector classSelector, SelectorResolver.Context context) {
        return j.b(this, classSelector, context);
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

    public SelectorResolver.Resolution resolve(MethodSelector methodSelector, SelectorResolver.Context context) {
        return resolve(context, Collections.emptyList(), methodSelector.getJavaClass(), new v(methodSelector), new w());
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(ModuleSelector moduleSelector, SelectorResolver.Context context) {
        return j.i(this, moduleSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(NestedClassSelector nestedClassSelector, SelectorResolver.Context context) {
        return j.j(this, nestedClassSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(PackageSelector packageSelector, SelectorResolver.Context context) {
        return j.l(this, packageSelector, context);
    }

    public /* synthetic */ SelectorResolver.Resolution resolve(UriSelector uriSelector, SelectorResolver.Context context) {
        return j.n(this, uriSelector, context);
    }

    public SelectorResolver.Resolution resolve(NestedMethodSelector nestedMethodSelector, SelectorResolver.Context context) {
        return resolve(context, nestedMethodSelector.getEnclosingClasses(), nestedMethodSelector.getNestedClass(), new t(nestedMethodSelector), new w());
    }

    private SelectorResolver.Resolution resolve(SelectorResolver.Context context, List<Class<?>> list, Class<?> cls, Supplier<Method> supplier, BiFunction<TestDescriptor, Supplier<Set<? extends DiscoverySelector>>, SelectorResolver.Match> biFunction) {
        if (!testClassPredicate.test(cls)) {
            return SelectorResolver.Resolution.unresolved();
        }
        Method method = supplier.get();
        Set set = (Set) DesugarArrays.stream((T[]) MethodType.values()).map(new n0(this, list, cls, method, context)).filter(new i0()).map(new a2()).map(new o0(this, biFunction)).collect(Collectors.toSet());
        if (set.size() > 1) {
            logger.warn(new p0(set, method));
        }
        return set.isEmpty() ? SelectorResolver.Resolution.unresolved() : SelectorResolver.Resolution.matches(set);
    }

    public SelectorResolver.Resolution resolve(UniqueIdSelector uniqueIdSelector, SelectorResolver.Context context) {
        UniqueId uniqueId = uniqueIdSelector.getUniqueId();
        return (SelectorResolver.Resolution) DesugarArrays.stream((T[]) MethodType.values()).map(new q0(this, uniqueId, context)).filter(new i0()).map(new a2()).map(new r0(this, uniqueId)).findFirst().orElse(SelectorResolver.Resolution.unresolved());
    }

    public SelectorResolver.Resolution resolve(IterationSelector iterationSelector, SelectorResolver.Context context) {
        if (!(iterationSelector.getParentSelector() instanceof MethodSelector)) {
            return SelectorResolver.Resolution.unresolved();
        }
        MethodSelector methodSelector = (MethodSelector) iterationSelector.getParentSelector();
        return resolve(context, Collections.emptyList(), methodSelector.getJavaClass(), new v(methodSelector), new l0(iterationSelector));
    }
}
