package org.junit.platform.engine.support.discovery;

import e30.u;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.Map;
import j$.util.Optional;
import j$.util.function.Function;
import j$.util.function.Supplier;
import j$.util.stream.Collectors;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.commons.util.CollectionUtils;
import org.junit.platform.commons.util.UnrecoverableExceptions;
import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.EngineDiscoveryListener;
import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.SelectorResolutionResult;
import org.junit.platform.engine.TestDescriptor;
import org.junit.platform.engine.UniqueId;
import org.junit.platform.engine.discovery.ClassSelector;
import org.junit.platform.engine.discovery.ClasspathResourceSelector;
import org.junit.platform.engine.discovery.ClasspathRootSelector;
import org.junit.platform.engine.discovery.DirectorySelector;
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
import q30.b;
import q30.c;
import q30.d;
import q30.e;
import q30.f;

class EngineDiscoveryRequestResolution {
    private final Map<DiscoverySelector, SelectorResolver.Context> contextBySelector;
    private final SelectorResolver.Context defaultContext;
    /* access modifiers changed from: private */
    public final TestDescriptor engineDescriptor;
    private final Queue<DiscoverySelector> remainingSelectors;
    private final EngineDiscoveryRequest request;
    private final Map<DiscoverySelector, SelectorResolver.Resolution> resolvedSelectors = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final Map<UniqueId, SelectorResolver.Match> resolvedUniqueIds;
    private final List<SelectorResolver> resolvers;
    private final List<TestDescriptor.Visitor> visitors;

    public EngineDiscoveryRequestResolution(EngineDiscoveryRequest engineDiscoveryRequest, TestDescriptor testDescriptor, List<SelectorResolver> list, List<TestDescriptor.Visitor> list2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.resolvedUniqueIds = linkedHashMap;
        this.remainingSelectors = new ArrayDeque();
        this.contextBySelector = new HashMap();
        this.request = engineDiscoveryRequest;
        this.engineDescriptor = testDescriptor;
        this.resolvers = list;
        this.visitors = list2;
        this.defaultContext = new DefaultContext((TestDescriptor) null);
        linkedHashMap.put(testDescriptor.getUniqueId(), SelectorResolver.Match.exact(testDescriptor));
    }

    private void enqueueAdditionalSelectors(SelectorResolver.Resolution resolution) {
        this.remainingSelectors.addAll(resolution.getSelectors());
        Collection.EL.stream(resolution.getMatches()).filter(new b()).forEach(new a(this));
    }

    private SelectorResolver.Context getContext(DiscoverySelector discoverySelector) {
        return (SelectorResolver.Context) Map.EL.getOrDefault(this.contextBySelector, discoverySelector, this.defaultContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$enqueueAdditionalSelectors$0(DefaultContext defaultContext2, DiscoverySelector discoverySelector) {
        this.contextBySelector.put(discoverySelector, defaultContext2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$enqueueAdditionalSelectors$1(SelectorResolver.Match match) {
        Set<? extends DiscoverySelector> expand = match.expand();
        if (!expand.isEmpty()) {
            this.remainingSelectors.addAll(expand);
            Iterable.EL.forEach(expand, new d(this, new DefaultContext(match.getTestDescriptor())));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SelectorResolver.Resolution lambda$resolve$2(DiscoverySelector discoverySelector, SelectorResolver selectorResolver) {
        SelectorResolver.Context context = getContext(discoverySelector);
        if (discoverySelector instanceof ClasspathResourceSelector) {
            return selectorResolver.resolve((ClasspathResourceSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof ClasspathRootSelector) {
            return selectorResolver.resolve((ClasspathRootSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof ClassSelector) {
            return selectorResolver.resolve((ClassSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof IterationSelector) {
            return selectorResolver.resolve((IterationSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof NestedClassSelector) {
            return selectorResolver.resolve((NestedClassSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof DirectorySelector) {
            return selectorResolver.resolve((DirectorySelector) discoverySelector, context);
        }
        if (discoverySelector instanceof FileSelector) {
            return selectorResolver.resolve((FileSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof MethodSelector) {
            return selectorResolver.resolve((MethodSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof NestedMethodSelector) {
            return selectorResolver.resolve((NestedMethodSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof ModuleSelector) {
            return selectorResolver.resolve((ModuleSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof PackageSelector) {
            return selectorResolver.resolve((PackageSelector) discoverySelector, context);
        }
        if (discoverySelector instanceof UriSelector) {
            return selectorResolver.resolve((UriSelector) discoverySelector, context);
        }
        return selectorResolver.resolve(discoverySelector, context);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$resolve$4(SelectorResolver.Match match) {
        this.resolvedUniqueIds.put(match.getTestDescriptor().getUniqueId(), match);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SelectorResolver.Resolution lambda$resolve$5(DiscoverySelector discoverySelector, SelectorResolver.Resolution resolution) {
        this.contextBySelector.remove(discoverySelector);
        this.resolvedSelectors.put(discoverySelector, resolution);
        Iterable.EL.forEach(resolution.getMatches(), new e(this));
        return resolution;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ SelectorResolver.Resolution lambda$resolveUniqueId$3(UniqueIdSelector uniqueIdSelector, SelectorResolver selectorResolver) {
        return selectorResolver.resolve(uniqueIdSelector, getContext(uniqueIdSelector));
    }

    /* access modifiers changed from: private */
    public Optional<SelectorResolver.Resolution> resolve(DiscoverySelector discoverySelector) {
        if (this.resolvedSelectors.containsKey(discoverySelector)) {
            return Optional.of(this.resolvedSelectors.get(discoverySelector));
        }
        if (discoverySelector instanceof UniqueIdSelector) {
            return resolveUniqueId((UniqueIdSelector) discoverySelector);
        }
        return resolve(discoverySelector, new f(this, discoverySelector));
    }

    private void resolveCompletely(DiscoverySelector discoverySelector) {
        EngineDiscoveryListener discoveryListener = this.request.getDiscoveryListener();
        UniqueId uniqueId = this.engineDescriptor.getUniqueId();
        try {
            Optional<SelectorResolver.Resolution> resolve = resolve(discoverySelector);
            if (resolve.isPresent()) {
                discoveryListener.selectorProcessed(uniqueId, discoverySelector, SelectorResolutionResult.resolved());
                enqueueAdditionalSelectors(resolve.get());
                return;
            }
            discoveryListener.selectorProcessed(uniqueId, discoverySelector, SelectorResolutionResult.unresolved());
        } catch (Throwable th2) {
            UnrecoverableExceptions.rethrowIfUnrecoverable(th2);
            discoveryListener.selectorProcessed(uniqueId, discoverySelector, SelectorResolutionResult.failed(th2));
        }
    }

    private Optional<SelectorResolver.Resolution> resolveUniqueId(UniqueIdSelector uniqueIdSelector) {
        UniqueId uniqueId = uniqueIdSelector.getUniqueId();
        if (this.resolvedUniqueIds.containsKey(uniqueId)) {
            return Optional.of(SelectorResolver.Resolution.match(this.resolvedUniqueIds.get(uniqueId)));
        }
        if (!uniqueId.hasPrefix(this.engineDescriptor.getUniqueId())) {
            return Optional.empty();
        }
        return resolve(uniqueIdSelector, new b(this, uniqueIdSelector));
    }

    public void j() {
        this.remainingSelectors.addAll(this.request.getSelectorsByType(DiscoverySelector.class));
        while (!this.remainingSelectors.isEmpty()) {
            resolveCompletely(this.remainingSelectors.poll());
        }
        List<TestDescriptor.Visitor> list = this.visitors;
        TestDescriptor testDescriptor = this.engineDescriptor;
        Objects.requireNonNull(testDescriptor);
        Iterable.EL.forEach(list, new c(testDescriptor));
    }

    public class DefaultContext implements SelectorResolver.Context {
        private final TestDescriptor parent;

        public DefaultContext(TestDescriptor testDescriptor) {
            this.parent = testDescriptor;
        }

        /* access modifiers changed from: private */
        /* renamed from: createAndAdd */
        public <T extends TestDescriptor> Optional<T> lambda$addToParent$0(TestDescriptor testDescriptor, Function<TestDescriptor, Optional<T>> function) {
            Optional<T> apply = function.apply(testDescriptor);
            if (apply.isPresent()) {
                UniqueId uniqueId = ((TestDescriptor) apply.get()).getUniqueId();
                if (EngineDiscoveryRequestResolution.this.resolvedUniqueIds.containsKey(uniqueId)) {
                    return Optional.of(((SelectorResolver.Match) EngineDiscoveryRequestResolution.this.resolvedUniqueIds.get(uniqueId)).getTestDescriptor());
                }
                testDescriptor.addChild((TestDescriptor) apply.get());
            }
            return apply;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ Optional lambda$resolve$1(DiscoverySelector discoverySelector, Set set) {
            if (set.size() > 1) {
                throw new JUnitException("Selector " + discoverySelector + " did not yield unique test descriptor: " + ((String) Collection.EL.stream(set).map(new u()).map(new f()).collect(Collectors.joining(IndicativeSentencesGeneration.DEFAULT_SEPARATOR))));
            } else if (set.size() == 1) {
                return Optional.of(((SelectorResolver.Match) CollectionUtils.getOnlyElement(set)).getTestDescriptor());
            } else {
                return Optional.empty();
            }
        }

        public <T extends TestDescriptor> Optional<T> addToParent(Function<TestDescriptor, Optional<T>> function) {
            TestDescriptor testDescriptor = this.parent;
            if (testDescriptor != null) {
                return lambda$addToParent$0(testDescriptor, function);
            }
            return lambda$addToParent$0(EngineDiscoveryRequestResolution.this.engineDescriptor, function);
        }

        public Optional<TestDescriptor> resolve(DiscoverySelector discoverySelector) {
            return EngineDiscoveryRequestResolution.this.resolve(discoverySelector).map(new e()).flatMap(new h(discoverySelector));
        }

        public <T extends TestDescriptor> Optional<T> addToParent(Supplier<DiscoverySelector> supplier, Function<TestDescriptor, Optional<T>> function) {
            TestDescriptor testDescriptor = this.parent;
            if (testDescriptor != null) {
                return lambda$addToParent$0(testDescriptor, function);
            }
            return resolve(supplier.get()).flatMap(new g(this, function));
        }
    }

    private Optional<SelectorResolver.Resolution> resolve(DiscoverySelector discoverySelector, Function<SelectorResolver, SelectorResolver.Resolution> function) {
        return Collection.EL.stream(this.resolvers).map(function).filter(new d()).findFirst().map(new c(this, discoverySelector));
    }
}
