package org.junit.jupiter.engine.support;

import org.apiguardian.api.API;
import org.junit.platform.engine.support.hierarchical.ThrowableCollector;

@API(since = "5.4", status = API.Status.INTERNAL)
public class JupiterThrowableCollectorFactory {
    public static ThrowableCollector createThrowableCollector() {
        return new OpenTest4JAndJUnit4AwareThrowableCollector();
    }
}
