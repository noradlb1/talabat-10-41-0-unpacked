package org.junit.jupiter.engine.descriptor;

import org.apiguardian.api.API;

@API(since = "5.1", status = API.Status.INTERNAL)
public interface Filterable {
    DynamicDescendantFilter getDynamicDescendantFilter();
}
