package com.google.firebase.components;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import n9.a;
import n9.b;
import n9.c;
import n9.d;
import n9.e;

public final class Component<T> {
    private final Set<Dependency> dependencies;
    private final ComponentFactory<T> factory;
    private final int instantiation;

    /* renamed from: name  reason: collision with root package name */
    private final String f47319name;
    private final Set<Qualified<? super T>> providedInterfaces;
    private final Set<Class<?>> publishedEvents;
    private final int type;

    public static <T> Builder<T> builder(Class<T> cls) {
        return new Builder<>((Class) cls, new Class[0]);
    }

    public static <T> Component<T> intoSet(T t11, Class<T> cls) {
        return intoSetBuilder(cls).factory(new b(t11)).build();
    }

    public static <T> Builder<T> intoSetBuilder(Class<T> cls) {
        return builder(cls).intoSet();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$intoSet$3(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$intoSet$4(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$0(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$1(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$of$2(Object obj, ComponentContainer componentContainer) {
        return obj;
    }

    @Deprecated
    public static <T> Component<T> of(Class<T> cls, T t11) {
        return builder(cls).factory(new e(t11)).build();
    }

    public Set<Dependency> getDependencies() {
        return this.dependencies;
    }

    public ComponentFactory<T> getFactory() {
        return this.factory;
    }

    @Nullable
    public String getName() {
        return this.f47319name;
    }

    public Set<Qualified<? super T>> getProvidedInterfaces() {
        return this.providedInterfaces;
    }

    public Set<Class<?>> getPublishedEvents() {
        return this.publishedEvents;
    }

    public boolean isAlwaysEager() {
        return this.instantiation == 1;
    }

    public boolean isEagerInDefaultApp() {
        return this.instantiation == 2;
    }

    public boolean isLazy() {
        return this.instantiation == 0;
    }

    public boolean isValue() {
        return this.type == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.providedInterfaces.toArray()) + ">{" + this.instantiation + ", type=" + this.type + ", deps=" + Arrays.toString(this.dependencies.toArray()) + "}";
    }

    public Component<T> withFactory(ComponentFactory<T> componentFactory) {
        return new Component(this.f47319name, this.providedInterfaces, this.dependencies, this.instantiation, this.type, componentFactory, this.publishedEvents);
    }

    public static class Builder<T> {
        private final Set<Dependency> dependencies;
        private ComponentFactory<T> factory;
        private int instantiation;

        /* renamed from: name  reason: collision with root package name */
        private String f47320name;
        private final Set<Qualified<? super T>> providedInterfaces;
        private final Set<Class<?>> publishedEvents;
        private int type;

        /* access modifiers changed from: private */
        @CanIgnoreReturnValue
        public Builder<T> intoSet() {
            this.type = 1;
            return this;
        }

        @CanIgnoreReturnValue
        private Builder<T> setInstantiation(int i11) {
            boolean z11;
            if (this.instantiation == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Instantiation type has already been set.");
            this.instantiation = i11;
            return this;
        }

        private void validateInterface(Qualified<?> qualified) {
            Preconditions.checkArgument(!this.providedInterfaces.contains(qualified), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @CanIgnoreReturnValue
        public Builder<T> add(Dependency dependency) {
            Preconditions.checkNotNull(dependency, "Null dependency");
            validateInterface(dependency.getInterface());
            this.dependencies.add(dependency);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> alwaysEager() {
            return setInstantiation(1);
        }

        public Component<T> build() {
            boolean z11;
            if (this.factory != null) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11, "Missing required property: factory.");
            return new Component(this.f47320name, new HashSet(this.providedInterfaces), new HashSet(this.dependencies), this.instantiation, this.type, this.factory, this.publishedEvents);
        }

        @CanIgnoreReturnValue
        public Builder<T> eagerInDefaultApp() {
            return setInstantiation(2);
        }

        @CanIgnoreReturnValue
        public Builder<T> factory(ComponentFactory<T> componentFactory) {
            this.factory = (ComponentFactory) Preconditions.checkNotNull(componentFactory, "Null factory");
            return this;
        }

        public Builder<T> name(@NonNull String str) {
            this.f47320name = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<T> publishes(Class<?> cls) {
            this.publishedEvents.add(cls);
            return this;
        }

        @SafeVarargs
        private Builder(Class<T> cls, Class<? super T>... clsArr) {
            this.f47320name = null;
            HashSet hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            Preconditions.checkNotNull(cls, "Null interface");
            hashSet.add(Qualified.unqualified(cls));
            for (Class<? super T> cls2 : clsArr) {
                Preconditions.checkNotNull(cls2, "Null interface");
                this.providedInterfaces.add(Qualified.unqualified(cls2));
            }
        }

        @SafeVarargs
        private Builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
            this.f47320name = null;
            HashSet hashSet = new HashSet();
            this.providedInterfaces = hashSet;
            this.dependencies = new HashSet();
            this.instantiation = 0;
            this.type = 0;
            this.publishedEvents = new HashSet();
            Preconditions.checkNotNull(qualified, "Null interface");
            hashSet.add(qualified);
            for (Qualified<? super T> checkNotNull : qualifiedArr) {
                Preconditions.checkNotNull(checkNotNull, "Null interface");
            }
            Collections.addAll(this.providedInterfaces, qualifiedArr);
        }
    }

    private Component(@Nullable String str, Set<Qualified<? super T>> set, Set<Dependency> set2, int i11, int i12, ComponentFactory<T> componentFactory, Set<Class<?>> set3) {
        this.f47319name = str;
        this.providedInterfaces = Collections.unmodifiableSet(set);
        this.dependencies = Collections.unmodifiableSet(set2);
        this.instantiation = i11;
        this.type = i12;
        this.factory = componentFactory;
        this.publishedEvents = Collections.unmodifiableSet(set3);
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Class<T> cls, Class<? super T>... clsArr) {
        return new Builder<>((Class) cls, (Class[]) clsArr);
    }

    public static <T> Component<T> intoSet(T t11, Qualified<T> qualified) {
        return intoSetBuilder(qualified).factory(new c(t11)).build();
    }

    public static <T> Builder<T> intoSetBuilder(Qualified<T> qualified) {
        return builder(qualified).intoSet();
    }

    @SafeVarargs
    public static <T> Component<T> of(T t11, Class<T> cls, Class<? super T>... clsArr) {
        return builder(cls, clsArr).factory(new a(t11)).build();
    }

    public static <T> Builder<T> builder(Qualified<T> qualified) {
        return new Builder<>((Qualified) qualified, new Qualified[0]);
    }

    @SafeVarargs
    public static <T> Component<T> of(T t11, Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return builder(qualified, qualifiedArr).factory(new d(t11)).build();
    }

    @SafeVarargs
    public static <T> Builder<T> builder(Qualified<T> qualified, Qualified<? super T>... qualifiedArr) {
        return new Builder<>((Qualified) qualified, (Qualified[]) qualifiedArr);
    }
}
