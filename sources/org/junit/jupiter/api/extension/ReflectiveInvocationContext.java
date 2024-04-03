package org.junit.jupiter.api.extension;

import j$.util.Optional;
import java.lang.reflect.Executable;
import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.5", status = API.Status.EXPERIMENTAL)
public interface ReflectiveInvocationContext<T extends Executable> {
    List<Object> getArguments();

    T getExecutable();

    Optional<Object> getTarget();

    Class<?> getTargetClass();
}
