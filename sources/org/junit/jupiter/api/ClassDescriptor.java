package org.junit.jupiter.api;

import j$.util.Optional;
import java.lang.annotation.Annotation;
import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.8", status = API.Status.EXPERIMENTAL)
public interface ClassDescriptor {
    <A extends Annotation> Optional<A> findAnnotation(Class<A> cls);

    <A extends Annotation> List<A> findRepeatableAnnotations(Class<A> cls);

    String getDisplayName();

    Class<?> getTestClass();

    boolean isAnnotated(Class<? extends Annotation> cls);
}
