package org.junit.platform.engine.support.discovery;

import e30.c;
import j$.util.Collection;
import j$.util.function.Function;
import j$.util.function.Predicate;
import j$.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.Preconditions;
import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.discovery.ClassNameFilter;
import org.junit.platform.engine.discovery.PackageNameFilter;
import org.junit.platform.engine.e;
import q30.g;
import q30.h;
import q30.i;

@API(since = "1.5", status = API.Status.EXPERIMENTAL)
public class EngineDiscoveryRequestResolver<T extends TestDescriptor> {
    private final List<Function<InitializationContext<T>, SelectorResolver>> resolverCreators;
    private final List<Function<InitializationContext<T>, TestDescriptor.Visitor>> visitorCreators;

    @API(since = "1.5", status = API.Status.EXPERIMENTAL)
    public static class Builder<T extends TestDescriptor> {
        private final List<Function<InitializationContext<T>, SelectorResolver>> resolverCreators;
        private final List<Function<InitializationContext<T>, TestDescriptor.Visitor>> visitorCreators;

        /* access modifiers changed from: private */
        public static /* synthetic */ SelectorResolver lambda$addClassContainerSelectorResolver$0(Predicate predicate, InitializationContext initializationContext) {
            return new ClassContainerSelectorResolver(predicate, initializationContext.getClassNameFilter());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ SelectorResolver lambda$addSelectorResolver$1(SelectorResolver selectorResolver, InitializationContext initializationContext) {
            return selectorResolver;
        }

        public Builder<T> addClassContainerSelectorResolver(Predicate<Class<?>> predicate) {
            Preconditions.notNull(predicate, "classFilter must not be null");
            return addSelectorResolver(new i(predicate));
        }

        public Builder<T> addSelectorResolver(SelectorResolver selectorResolver) {
            Preconditions.notNull(selectorResolver, "resolver must not be null");
            return addSelectorResolver(new h(selectorResolver));
        }

        public Builder<T> addTestDescriptorVisitor(Function<InitializationContext<T>, TestDescriptor.Visitor> function) {
            this.visitorCreators.add(function);
            return this;
        }

        public EngineDiscoveryRequestResolver<T> build() {
            return new EngineDiscoveryRequestResolver<>(this.resolverCreators, this.visitorCreators);
        }

        private Builder() {
            this.resolverCreators = new ArrayList();
            this.visitorCreators = new ArrayList();
        }

        public Builder<T> addSelectorResolver(Function<InitializationContext<T>, SelectorResolver> function) {
            this.resolverCreators.add(function);
            return this;
        }
    }

    public static class DefaultInitializationContext<T extends TestDescriptor> implements InitializationContext<T> {
        private final Predicate<String> classNameFilter;
        private final T engineDescriptor;
        private final EngineDiscoveryRequest request;

        public DefaultInitializationContext(EngineDiscoveryRequest engineDiscoveryRequest, T t11) {
            this.request = engineDiscoveryRequest;
            this.engineDescriptor = t11;
            this.classNameFilter = buildClassNamePredicate(engineDiscoveryRequest);
        }

        private Predicate<String> buildClassNamePredicate(EngineDiscoveryRequest engineDiscoveryRequest) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(engineDiscoveryRequest.getFiltersByType(ClassNameFilter.class));
            arrayList.addAll(engineDiscoveryRequest.getFiltersByType(PackageNameFilter.class));
            return e.d(arrayList).toPredicate();
        }

        public Predicate<String> getClassNameFilter() {
            return this.classNameFilter;
        }

        public EngineDiscoveryRequest getDiscoveryRequest() {
            return this.request;
        }

        public T getEngineDescriptor() {
            return this.engineDescriptor;
        }
    }

    @API(since = "1.5", status = API.Status.EXPERIMENTAL)
    public interface InitializationContext<T extends TestDescriptor> {
        Predicate<String> getClassNameFilter();

        EngineDiscoveryRequest getDiscoveryRequest();

        T getEngineDescriptor();
    }

    public static <T extends TestDescriptor> Builder<T> builder() {
        return new Builder<>();
    }

    private <R> List<R> instantiate(List<Function<InitializationContext<T>, R>> list, InitializationContext<T> initializationContext) {
        return (List) Collection.EL.stream(list).map(new g(initializationContext)).collect(Collectors.toCollection(new c()));
    }

    public void resolve(EngineDiscoveryRequest engineDiscoveryRequest, T t11) {
        Preconditions.notNull(engineDiscoveryRequest, "request must not be null");
        Preconditions.notNull(t11, "engineDescriptor must not be null");
        DefaultInitializationContext defaultInitializationContext = new DefaultInitializationContext(engineDiscoveryRequest, t11);
        new EngineDiscoveryRequestResolution(engineDiscoveryRequest, t11, instantiate(this.resolverCreators, defaultInitializationContext), instantiate(this.visitorCreators, defaultInitializationContext)).j();
    }

    private EngineDiscoveryRequestResolver(List<Function<InitializationContext<T>, SelectorResolver>> list, List<Function<InitializationContext<T>, TestDescriptor.Visitor>> list2) {
        this.resolverCreators = new ArrayList(list);
        this.visitorCreators = new ArrayList(list2);
    }
}
