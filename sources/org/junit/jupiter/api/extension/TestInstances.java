package org.junit.jupiter.api.extension;

import j$.util.Optional;
import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.7", status = API.Status.STABLE)
public interface TestInstances {
    <T> Optional<T> findInstance(Class<T> cls);

    List<Object> getAllInstances();

    List<Object> getEnclosingInstances();

    Object getInnermostInstance();
}
