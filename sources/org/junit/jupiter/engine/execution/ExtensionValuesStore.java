package org.junit.jupiter.engine.execution;

import f30.c;
import f30.d;
import f30.e;
import f30.f;
import j$.util.Collection;
import j$.util.Comparator;
import j$.util.Optional;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import j$.util.function.Supplier;
import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContextException;
import org.junit.jupiter.engine.support.JupiterThrowableCollectorFactory;
import org.junit.platform.commons.util.ReflectionUtils;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.0", status = API.Status.INTERNAL)
public class ExtensionValuesStore {
    private static final Comparator<StoredValue> REVERSE_INSERT_ORDER = Comparator.EL.reversed(Comparator.CC.comparing(new a()));
    private final AtomicInteger insertOrderSequence = new AtomicInteger();
    private final ExtensionValuesStore parentStore;
    private final ConcurrentMap<CompositeKey, StoredValue> storedValues = new ConcurrentHashMap(4);

    public static class CompositeKey {
        private final Object key;
        private final ExtensionContext.Namespace namespace;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            CompositeKey compositeKey = (CompositeKey) obj;
            if (!this.namespace.equals(compositeKey.namespace) || !this.key.equals(compositeKey.key)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.namespace, this.key});
        }

        private CompositeKey(ExtensionContext.Namespace namespace2, Object obj) {
            this.namespace = namespace2;
            this.key = obj;
        }
    }

    public static class MemoizingSupplier implements Supplier<Object> {
        private static final Object NO_VALUE_SET = new Object();
        private final Supplier<Object> delegate;
        private final Lock lock;
        private volatile Object value;

        public static class Failure {
            /* access modifiers changed from: private */
            public final RuntimeException exception;

            public Failure(RuntimeException runtimeException) {
                this.exception = runtimeException;
            }
        }

        private void computeValue() {
            this.lock.lock();
            try {
                if (this.value == NO_VALUE_SET) {
                    this.value = this.delegate.get();
                }
            } catch (RuntimeException e11) {
                this.value = new Failure(e11);
            } catch (Throwable th2) {
                this.lock.unlock();
                throw th2;
            }
            this.lock.unlock();
        }

        public Object get() {
            if (this.value == NO_VALUE_SET) {
                computeValue();
            }
            if (!(this.value instanceof Failure)) {
                return this.value;
            }
            throw ((Failure) this.value).exception;
        }

        private MemoizingSupplier(Supplier<Object> supplier) {
            this.lock = new ReentrantLock();
            this.value = NO_VALUE_SET;
            this.delegate = supplier;
        }
    }

    public static class StoredValue {
        /* access modifiers changed from: private */
        public final int order;
        private final Supplier<Object> supplier;

        public StoredValue(int i11, Supplier<Object> supplier2) {
            this.order = i11;
            this.supplier = supplier2;
        }

        /* access modifiers changed from: private */
        public Object evaluate() {
            return this.supplier.get();
        }

        /* access modifiers changed from: private */
        public Object evaluateSafely() {
            try {
                return evaluate();
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    public ExtensionValuesStore(ExtensionValuesStore extensionValuesStore) {
        this.parentStore = extensionValuesStore;
    }

    private <T> T castToRequiredType(Object obj, Object obj2, Class<T> cls) {
        if (obj2 == null) {
            return null;
        }
        if (!ReflectionUtils.isAssignableTo(obj2, (Class<?>) cls)) {
            throw new ExtensionContextException(String.format("Object stored under key [%s] is not of required type [%s]", new Object[]{obj, cls.getName()}));
        } else if (cls.isPrimitive()) {
            return ReflectionUtils.getWrapperType(cls).cast(obj2);
        } else {
            return cls.cast(obj2);
        }
    }

    private StoredValue getStoredValue(CompositeKey compositeKey) {
        StoredValue storedValue = this.storedValues.get(compositeKey);
        if (storedValue != null) {
            return storedValue;
        }
        ExtensionValuesStore extensionValuesStore = this.parentStore;
        if (extensionValuesStore != null) {
            return extensionValuesStore.getStoredValue(compositeKey);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$closeAllStoredCloseableValues$1(StoredValue storedValue) {
        return storedValue.evaluateSafely() instanceof ExtensionContext.Store.CloseableResource;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ExtensionContext.Store.CloseableResource lambda$closeAllStoredCloseableValues$2(StoredValue storedValue) {
        return (ExtensionContext.Store.CloseableResource) storedValue.evaluate();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$closeAllStoredCloseableValues$3(ThrowableCollector throwableCollector, ExtensionContext.Store.CloseableResource closeableResource) {
        Objects.requireNonNull(closeableResource);
        throwableCollector.execute(new d(closeableResource));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Object lambda$put$5(Object obj) {
        return obj;
    }

    private StoredValue storedValue(Supplier<Object> supplier) {
        return new StoredValue(this.insertOrderSequence.getAndIncrement(), supplier);
    }

    public void closeAllStoredCloseableValues() {
        ThrowableCollector createThrowableCollector = JupiterThrowableCollectorFactory.createThrowableCollector();
        Collection.EL.stream(this.storedValues.values()).filter(new b()).sorted(REVERSE_INSERT_ORDER).map(new c()).forEach(new e(createThrowableCollector));
        createThrowableCollector.assertEmpty();
    }

    public Object g(ExtensionContext.Namespace namespace, Object obj) {
        StoredValue storedValue = getStoredValue(new CompositeKey(namespace, obj));
        if (storedValue != null) {
            return storedValue.evaluate();
        }
        return null;
    }

    public <T> T h(ExtensionContext.Namespace namespace, Object obj, Class<T> cls) {
        return castToRequiredType(obj, g(namespace, obj), cls);
    }

    public <K, V> Object i(ExtensionContext.Namespace namespace, K k11, Function<K, V> function) {
        CompositeKey compositeKey = new CompositeKey(namespace, k11);
        StoredValue storedValue = getStoredValue(compositeKey);
        if (storedValue == null) {
            StoredValue storedValue2 = storedValue(new MemoizingSupplier(new c(function, k11)));
            storedValue = (StoredValue) Optional.ofNullable(this.storedValues.putIfAbsent(compositeKey, storedValue2)).orElse(storedValue2);
        }
        return storedValue.evaluate();
    }

    public <K, V> V j(ExtensionContext.Namespace namespace, K k11, Function<K, V> function, Class<V> cls) {
        return castToRequiredType(k11, i(namespace, k11, function), cls);
    }

    public void k(ExtensionContext.Namespace namespace, Object obj, Object obj2) {
        this.storedValues.put(new CompositeKey(namespace, obj), storedValue(new f(obj2)));
    }

    public Object l(ExtensionContext.Namespace namespace, Object obj) {
        StoredValue remove = this.storedValues.remove(new CompositeKey(namespace, obj));
        if (remove != null) {
            return remove.evaluate();
        }
        return null;
    }

    public <T> T m(ExtensionContext.Namespace namespace, Object obj, Class<T> cls) {
        return castToRequiredType(obj, l(namespace, obj), cls);
    }
}
