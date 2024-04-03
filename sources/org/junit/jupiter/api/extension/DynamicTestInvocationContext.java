package org.junit.jupiter.api.extension;

import org.apiguardian.api.API;
import org.junit.jupiter.api.function.Executable;

@API(since = "5.8", status = API.Status.EXPERIMENTAL)
public interface DynamicTestInvocationContext {
    Executable getExecutable();
}
