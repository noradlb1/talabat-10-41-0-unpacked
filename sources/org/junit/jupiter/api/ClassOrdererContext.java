package org.junit.jupiter.api;

import j$.util.Optional;
import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.8", status = API.Status.EXPERIMENTAL)
public interface ClassOrdererContext {
    List<? extends ClassDescriptor> getClassDescriptors();

    Optional<String> getConfigurationParameter(String str);
}
