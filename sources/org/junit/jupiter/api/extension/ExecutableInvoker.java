package org.junit.jupiter.api.extension;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apiguardian.api.API;

@API(since = "5.9", status = API.Status.EXPERIMENTAL)
public interface ExecutableInvoker {
    <T> T invoke(Constructor<T> constructor);

    <T> T invoke(Constructor<T> constructor, Object obj);

    Object invoke(Method method);

    Object invoke(Method method, Object obj);
}
