package org.junit.jupiter.api;

import j$.util.Optional;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.7", status = API.Status.STABLE)
public interface MethodDescriptor {
    <A extends Annotation> Optional<A> findAnnotation(Class<A> cls);

    <A extends Annotation> List<A> findRepeatableAnnotations(Class<A> cls);

    @API(since = "5.7", status = API.Status.EXPERIMENTAL)
    String getDisplayName();

    Method getMethod();

    boolean isAnnotated(Class<? extends Annotation> cls);
}
