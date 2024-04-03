package org.junit.jupiter.engine.execution;

import j$.util.function.Function;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.util.Preconditions;
import z20.d;

@API(since = "5.0", status = API.Status.INTERNAL)
public class NamespaceAwareStore implements ExtensionContext.Store {
    private final ExtensionContext.Namespace namespace;
    private final ExtensionValuesStore valuesStore;

    public NamespaceAwareStore(ExtensionValuesStore extensionValuesStore, ExtensionContext.Namespace namespace2) {
        this.valuesStore = extensionValuesStore;
        this.namespace = namespace2;
    }

    public Object get(Object obj) {
        Preconditions.notNull(obj, "key must not be null");
        return this.valuesStore.g(this.namespace, obj);
    }

    public /* synthetic */ Object getOrComputeIfAbsent(Class cls) {
        return d.a(this, cls);
    }

    public <K, V> Object getOrComputeIfAbsent(K k11, Function<K, V> function) {
        Preconditions.notNull(k11, "key must not be null");
        Preconditions.notNull(function, "defaultCreator function must not be null");
        return this.valuesStore.i(this.namespace, k11, function);
    }

    public /* synthetic */ Object getOrDefault(Object obj, Class cls, Object obj2) {
        return d.b(this, obj, cls, obj2);
    }

    public void put(Object obj, Object obj2) {
        Preconditions.notNull(obj, "key must not be null");
        this.valuesStore.k(this.namespace, obj, obj2);
    }

    public Object remove(Object obj) {
        Preconditions.notNull(obj, "key must not be null");
        return this.valuesStore.l(this.namespace, obj);
    }

    public <T> T get(Object obj, Class<T> cls) {
        Preconditions.notNull(obj, "key must not be null");
        Preconditions.notNull(cls, "requiredType must not be null");
        return this.valuesStore.h(this.namespace, obj, cls);
    }

    public <T> T remove(Object obj, Class<T> cls) {
        Preconditions.notNull(obj, "key must not be null");
        Preconditions.notNull(cls, "requiredType must not be null");
        return this.valuesStore.m(this.namespace, obj, cls);
    }

    public <K, V> V getOrComputeIfAbsent(K k11, Function<K, V> function, Class<V> cls) {
        Preconditions.notNull(k11, "key must not be null");
        Preconditions.notNull(function, "defaultCreator function must not be null");
        Preconditions.notNull(cls, "requiredType must not be null");
        return this.valuesStore.j(this.namespace, k11, function, cls);
    }
}
