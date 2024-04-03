package org.junit.platform.engine.support.hierarchical;

import j$.util.Collection;
import j$.util.Comparator;
import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import j$.util.function.Function;
import j$.util.stream.Collectors;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.junit.platform.commons.util.CollectionUtils;
import org.junit.platform.engine.support.hierarchical.ExclusiveResource;
import r30.i;
import r30.j;
import r30.k;

class LockManager {
    private static final Comparator<ExclusiveResource> COMPARATOR = Comparator.EL.thenComparing(Comparator.CC.comparing(new i(), Comparator.EL.thenComparing((java.util.Comparator) globalKeyFirst(), Comparator.CC.naturalOrder())), (Function) new k());
    private final Map<String, ReadWriteLock> locksByKey = new ConcurrentHashMap();

    private List<Lock> getDistinctSortedLocks(Collection<ExclusiveResource> collection) {
        return (List) Collection.EL.stream(((Map) Collection.EL.stream(collection).sorted(COMPARATOR).distinct().collect(Collectors.groupingBy(new i(), new j(), Collectors.toList()))).values()).map(new h()).map(new i(this)).collect(Collectors.toList());
    }

    private static java.util.Comparator<String> globalKeyFirst() {
        return Comparator.CC.comparing(new j());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ExclusiveResource lambda$getDistinctSortedLocks$1(List list) {
        return (ExclusiveResource) list.get(0);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ ReadWriteLock lambda$toLock$2(String str) {
        return new ReentrantReadWriteLock();
    }

    /* access modifiers changed from: private */
    public Lock toLock(ExclusiveResource exclusiveResource) {
        ReadWriteLock readWriteLock = (ReadWriteLock) Map.EL.computeIfAbsent(this.locksByKey, exclusiveResource.getKey(), new g());
        if (exclusiveResource.getLockMode() == ExclusiveResource.LockMode.READ) {
            return readWriteLock.readLock();
        }
        return readWriteLock.writeLock();
    }

    private ResourceLock toResourceLock(List<Lock> list) {
        int size = list.size();
        if (size == 0) {
            return NopLock.f28072b;
        }
        if (size != 1) {
            return new CompositeLock(list);
        }
        return new SingleLock(list.get(0));
    }

    public ResourceLock e(ExclusiveResource exclusiveResource) {
        return new SingleLock(toLock(exclusiveResource));
    }

    public ResourceLock f(java.util.Collection<ExclusiveResource> collection) {
        if (collection.size() == 1) {
            return e((ExclusiveResource) CollectionUtils.getOnlyElement(collection));
        }
        return toResourceLock(getDistinctSortedLocks(collection));
    }
}
