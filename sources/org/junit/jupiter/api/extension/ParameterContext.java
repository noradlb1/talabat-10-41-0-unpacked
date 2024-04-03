package org.junit.jupiter.api.extension;

import j$.util.Optional;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Parameter;
import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.0", status = API.Status.STABLE)
public interface ParameterContext {
    <A extends Annotation> Optional<A> findAnnotation(Class<A> cls);

    <A extends Annotation> List<A> findRepeatableAnnotations(Class<A> cls);

    Executable getDeclaringExecutable();

    int getIndex();

    Parameter getParameter();

    Optional<Object> getTarget();

    boolean isAnnotated(Class<? extends Annotation> cls);
}
