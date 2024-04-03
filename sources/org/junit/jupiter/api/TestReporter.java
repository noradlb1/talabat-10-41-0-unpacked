package org.junit.jupiter.api;

import java.util.Map;
import org.apiguardian.api.API;

@FunctionalInterface
@API(since = "5.0", status = API.Status.STABLE)
public interface TestReporter {
    @API(since = "5.3", status = API.Status.STABLE)
    void publishEntry(String str);

    void publishEntry(String str, String str2);

    void publishEntry(Map<String, String> map);
}
