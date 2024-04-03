package org.junit.jupiter.engine.execution;

import j$.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import org.apiguardian.api.API;
import org.junit.jupiter.api.extension.TestInstances;
import org.junit.platform.commons.util.Preconditions;

@API(since = "5.4", status = API.Status.INTERNAL)
public class DefaultTestInstances implements TestInstances {
    private final List<Object> instances;

    private DefaultTestInstances(List<Object> list) {
        this.instances = (List) Preconditions.notEmpty(list, "instances must not be empty");
    }

    public static DefaultTestInstances of(Object obj) {
        return new DefaultTestInstances(Collections.singletonList(obj));
    }

    public <T> Optional<T> findInstance(Class<T> cls) {
        Preconditions.notNull(cls, "requiredType must not be null");
        List<Object> list = this.instances;
        ListIterator<Object> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            Object previous = listIterator.previous();
            if (cls.isInstance(previous)) {
                return Optional.of(cls.cast(previous));
            }
        }
        return Optional.empty();
    }

    public List<Object> getAllInstances() {
        return this.instances;
    }

    public List<Object> getEnclosingInstances() {
        List<Object> list = this.instances;
        return list.subList(0, list.size() - 1);
    }

    public Object getInnermostInstance() {
        List<Object> list = this.instances;
        return list.get(list.size() - 1);
    }

    public static DefaultTestInstances of(TestInstances testInstances, Object obj) {
        ArrayList arrayList = new ArrayList(testInstances.getAllInstances());
        arrayList.add(obj);
        return new DefaultTestInstances(Collections.unmodifiableList(arrayList));
    }
}
