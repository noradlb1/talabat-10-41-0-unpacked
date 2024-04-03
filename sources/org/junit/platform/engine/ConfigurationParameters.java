package org.junit.platform.engine;

import j$.util.Optional;
import j$.util.function.Function;
import java.util.Set;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.STABLE)
public interface ConfigurationParameters {
    public static final String CONFIG_FILE_NAME = "junit-platform.properties";

    Optional<String> get(String str);

    @API(since = "1.3", status = API.Status.STABLE)
    <T> Optional<T> get(String str, Function<String, T> function);

    Optional<Boolean> getBoolean(String str);

    @API(since = "1.9", status = API.Status.STABLE)
    Set<String> keySet();

    @Deprecated
    @API(since = "1.9", status = API.Status.DEPRECATED)
    int size();
}
