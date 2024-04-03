package org.objenesis;

import j$.util.concurrent.ConcurrentHashMap;
import org.objenesis.instantiator.ObjectInstantiator;
import org.objenesis.strategy.InstantiatorStrategy;

public class ObjenesisBase implements Objenesis {

    /* renamed from: a  reason: collision with root package name */
    public final InstantiatorStrategy f63296a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, ObjectInstantiator<?>> f63297b;

    public ObjenesisBase(InstantiatorStrategy instantiatorStrategy) {
        this(instantiatorStrategy, true);
    }

    public <T> ObjectInstantiator<T> getInstantiatorOf(Class<T> cls) {
        if (!cls.isPrimitive()) {
            ConcurrentHashMap<String, ObjectInstantiator<?>> concurrentHashMap = this.f63297b;
            if (concurrentHashMap == null) {
                return this.f63296a.newInstantiatorOf(cls);
            }
            ObjectInstantiator<T> objectInstantiator = concurrentHashMap.get(cls.getName());
            if (objectInstantiator != null) {
                return objectInstantiator;
            }
            ObjectInstantiator<T> newInstantiatorOf = this.f63296a.newInstantiatorOf(cls);
            ObjectInstantiator<T> putIfAbsent = this.f63297b.putIfAbsent(cls.getName(), newInstantiatorOf);
            if (putIfAbsent == null) {
                return newInstantiatorOf;
            }
            return putIfAbsent;
        }
        throw new IllegalArgumentException("Primitive types can't be instantiated in Java");
    }

    public <T> T newInstance(Class<T> cls) {
        return getInstantiatorOf(cls).newInstance();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getClass().getName());
        sb2.append(" using ");
        sb2.append(this.f63296a.getClass().getName());
        sb2.append(this.f63297b == null ? " without" : " with");
        sb2.append(" caching");
        return sb2.toString();
    }

    public ObjenesisBase(InstantiatorStrategy instantiatorStrategy, boolean z11) {
        if (instantiatorStrategy != null) {
            this.f63296a = instantiatorStrategy;
            this.f63297b = z11 ? new ConcurrentHashMap<>() : null;
            return;
        }
        throw new IllegalArgumentException("A strategy can't be null");
    }
}
