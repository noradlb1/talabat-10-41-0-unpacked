package org.junit.jupiter.api;

import j$.util.Optional;
import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.7", status = API.Status.STABLE)
public interface MethodOrdererContext {
    Optional<String> getConfigurationParameter(String str);

    List<? extends MethodDescriptor> getMethodDescriptors();

    Class<?> getTestClass();
}
