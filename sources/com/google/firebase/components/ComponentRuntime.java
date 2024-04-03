package com.google.firebase.components;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import i.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import n9.f;
import n9.i;
import n9.j;
import n9.k;
import n9.l;

public class ComponentRuntime implements ComponentContainer, ComponentLoader {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = new k();
    private final ComponentRegistrarProcessor componentRegistrarProcessor;
    private final Map<Component<?>, Provider<?>> components;
    private final AtomicReference<Boolean> eagerComponentsInitializedWith;
    private final EventBus eventBus;
    private final Map<Qualified<?>, Provider<?>> lazyInstanceMap;
    private final Map<Qualified<?>, LazySet<?>> lazySetMap;
    private final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;

    public static final class Builder {
        private final List<Component<?>> additionalComponents = new ArrayList();
        private ComponentRegistrarProcessor componentRegistrarProcessor = ComponentRegistrarProcessor.NOOP;
        private final Executor defaultExecutor;
        private final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();

        public Builder(Executor executor) {
            this.defaultExecutor = executor;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        @CanIgnoreReturnValue
        public Builder addComponent(Component<?> component) {
            this.additionalComponents.add(component);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addComponentRegistrar(ComponentRegistrar componentRegistrar) {
            this.lazyRegistrars.add(new l(componentRegistrar));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.lazyRegistrars.addAll(collection);
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents, this.componentRegistrarProcessor);
        }

        @CanIgnoreReturnValue
        public Builder setProcessor(ComponentRegistrarProcessor componentRegistrarProcessor2) {
            this.componentRegistrarProcessor = componentRegistrarProcessor2;
            return this;
        }
    }

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    private void discoverComponents(List<Component<?>> list) {
        ArrayList<Runnable> arrayList = new ArrayList<>();
        synchronized (this) {
            Iterator<Provider<ComponentRegistrar>> it = this.unprocessedRegistrarProviders.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.componentRegistrarProcessor.processRegistrar(componentRegistrar));
                        it.remove();
                    }
                } catch (InvalidRegistrarException e11) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e11);
                }
            }
            if (this.components.isEmpty()) {
                CycleDetector.detect(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.components.keySet());
                arrayList2.addAll(list);
                CycleDetector.detect(arrayList2);
            }
            for (Component next : list) {
                this.components.put(next, new Lazy(new i(this, next)));
            }
            arrayList.addAll(processInstanceComponents(list));
            arrayList.addAll(processSetComponents());
            processDependencies();
        }
        for (Runnable run : arrayList) {
            run.run();
        }
        maybeInitializeEagerComponents();
    }

    private void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z11) {
        for (Map.Entry next : map.entrySet()) {
            Component component = (Component) next.getKey();
            Provider provider = (Provider) next.getValue();
            if (component.isAlwaysEager() || (component.isEagerInDefaultApp() && z11)) {
                provider.get();
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T add : iterable) {
            arrayList.add(add);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object lambda$discoverComponents$0(Component component) {
        return component.getFactory().create(new RestrictedComponentContainer(component, this));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ComponentRegistrar lambda$toProviders$1(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    private void maybeInitializeEagerComponents() {
        Boolean bool = this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    private void processDependencies() {
        for (Component next : this.components.keySet()) {
            Iterator<Dependency> it = next.getDependencies().iterator();
            while (true) {
                if (it.hasNext()) {
                    Dependency next2 = it.next();
                    if (next2.isSet() && !this.lazySetMap.containsKey(next2.getInterface())) {
                        this.lazySetMap.put(next2.getInterface(), LazySet.fromCollection(Collections.emptySet()));
                    } else if (this.lazyInstanceMap.containsKey(next2.getInterface())) {
                        continue;
                    } else if (next2.isRequired()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.getInterface()}));
                    } else if (!next2.isSet()) {
                        this.lazyInstanceMap.put(next2.getInterface(), OptionalProvider.empty());
                    }
                }
            }
        }
    }

    private List<Runnable> processInstanceComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component next : list) {
            if (next.isValue()) {
                Provider provider = this.components.get(next);
                for (Qualified qualified : next.getProvidedInterfaces()) {
                    if (!this.lazyInstanceMap.containsKey(qualified)) {
                        this.lazyInstanceMap.put(qualified, provider);
                    } else {
                        arrayList.add(new a((OptionalProvider) this.lazyInstanceMap.get(qualified), provider));
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> processSetComponents() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.components.entrySet()) {
            Component component = (Component) next.getKey();
            if (!component.isValue()) {
                Provider provider = (Provider) next.getValue();
                for (Qualified qualified : component.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(qualified)) {
                        hashMap.put(qualified, new HashSet());
                    }
                    ((Set) hashMap.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (!this.lazySetMap.containsKey(entry.getKey())) {
                this.lazySetMap.put((Qualified) entry.getKey(), LazySet.fromCollection((Collection) entry.getValue()));
            } else {
                LazySet lazySet = this.lazySetMap.get(entry.getKey());
                for (Provider bVar : (Set) entry.getValue()) {
                    arrayList.add(new b(lazySet, bVar));
                }
            }
        }
        return arrayList;
    }

    private static Iterable<Provider<ComponentRegistrar>> toProviders(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        for (ComponentRegistrar jVar : iterable) {
            arrayList.add(new j(jVar));
        }
        return arrayList;
    }

    public /* synthetic */ Object get(Qualified qualified) {
        return f.a(this, qualified);
    }

    public /* synthetic */ Object get(Class cls) {
        return f.b(this, cls);
    }

    @VisibleForTesting
    public Collection<Component<?>> getAllComponentsForTest() {
        return this.components.keySet();
    }

    public <T> Deferred<T> getDeferred(Qualified<T> qualified) {
        Provider<T> provider = getProvider(qualified);
        if (provider == null) {
            return OptionalProvider.empty();
        }
        if (provider instanceof OptionalProvider) {
            return (OptionalProvider) provider;
        }
        return OptionalProvider.of(provider);
    }

    public /* synthetic */ Deferred getDeferred(Class cls) {
        return f.c(this, cls);
    }

    public synchronized <T> Provider<T> getProvider(Qualified<T> qualified) {
        Preconditions.checkNotNull(qualified, "Null interface requested.");
        return this.lazyInstanceMap.get(qualified);
    }

    public /* synthetic */ Provider getProvider(Class cls) {
        return f.d(this, cls);
    }

    @VisibleForTesting
    @RestrictTo({RestrictTo.Scope.TESTS})
    public void initializeAllComponentsForTests() {
        for (Provider<?> provider : this.components.values()) {
            provider.get();
        }
    }

    public void initializeEagerComponents(boolean z11) {
        HashMap hashMap;
        if (b.a(this.eagerComponentsInitializedWith, (Object) null, Boolean.valueOf(z11))) {
            synchronized (this) {
                hashMap = new HashMap(this.components);
            }
            doInitializeEagerComponents(hashMap, z11);
        }
    }

    public /* synthetic */ Set setOf(Qualified qualified) {
        return f.e(this, qualified);
    }

    public /* synthetic */ Set setOf(Class cls) {
        return f.f(this, cls);
    }

    public synchronized <T> Provider<Set<T>> setOfProvider(Qualified<T> qualified) {
        LazySet lazySet = this.lazySetMap.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return EMPTY_PROVIDER;
    }

    public /* synthetic */ Provider setOfProvider(Class cls) {
        return f.g(this, cls);
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, toProviders(iterable), Arrays.asList(componentArr), ComponentRegistrarProcessor.NOOP);
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection, ComponentRegistrarProcessor componentRegistrarProcessor2) {
        this.components = new HashMap();
        this.lazyInstanceMap = new HashMap();
        this.lazySetMap = new HashMap();
        this.eagerComponentsInitializedWith = new AtomicReference<>();
        EventBus eventBus2 = new EventBus(executor);
        this.eventBus = eventBus2;
        this.componentRegistrarProcessor = componentRegistrarProcessor2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(eventBus2, EventBus.class, (Class<? super T>[]) new Class[]{Subscriber.class, Publisher.class}));
        arrayList.add(Component.of(this, ComponentLoader.class, (Class<? super T>[]) new Class[0]));
        for (Component next : collection) {
            if (next != null) {
                arrayList.add(next);
            }
        }
        this.unprocessedRegistrarProviders = iterableToList(iterable);
        discoverComponents(arrayList);
    }

    public void discoverComponents() {
        synchronized (this) {
            if (!this.unprocessedRegistrarProviders.isEmpty()) {
                discoverComponents(new ArrayList());
            }
        }
    }
}
