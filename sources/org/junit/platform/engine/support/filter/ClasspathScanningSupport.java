package org.junit.platform.engine.support.filter;

import j$.util.function.Predicate;
import java.util.ArrayList;
import org.apiguardian.api.API;
import org.junit.platform.commons.util.ClassFilter;
import org.junit.platform.engine.EngineDiscoveryRequest;
import org.junit.platform.engine.discovery.ClassNameFilter;
import org.junit.platform.engine.discovery.PackageNameFilter;
import org.junit.platform.engine.e;

@Deprecated
@API(since = "1.5", status = API.Status.DEPRECATED)
public final class ClasspathScanningSupport {
    private ClasspathScanningSupport() {
    }

    @Deprecated
    public static ClassFilter buildClassFilter(EngineDiscoveryRequest engineDiscoveryRequest, Predicate<Class<?>> predicate) {
        return ClassFilter.of(buildClassNamePredicate(engineDiscoveryRequest), predicate);
    }

    @Deprecated
    public static Predicate<String> buildClassNamePredicate(EngineDiscoveryRequest engineDiscoveryRequest) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(engineDiscoveryRequest.getFiltersByType(ClassNameFilter.class));
        arrayList.addAll(engineDiscoveryRequest.getFiltersByType(PackageNameFilter.class));
        return e.d(arrayList).toPredicate();
    }
}
