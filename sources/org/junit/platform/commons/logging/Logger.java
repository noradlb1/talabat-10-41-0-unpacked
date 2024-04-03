package org.junit.platform.commons.logging;

import j$.util.function.Supplier;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.INTERNAL)
public interface Logger {
    void config(Supplier<String> supplier);

    void config(Throwable th2, Supplier<String> supplier);

    void debug(Supplier<String> supplier);

    void debug(Throwable th2, Supplier<String> supplier);

    void error(Supplier<String> supplier);

    void error(Throwable th2, Supplier<String> supplier);

    void info(Supplier<String> supplier);

    void info(Throwable th2, Supplier<String> supplier);

    void trace(Supplier<String> supplier);

    void trace(Throwable th2, Supplier<String> supplier);

    void warn(Supplier<String> supplier);

    void warn(Throwable th2, Supplier<String> supplier);
}
