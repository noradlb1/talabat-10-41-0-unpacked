package org.junit.jupiter.api.extension;

import java.util.List;
import org.apiguardian.api.API;

@API(since = "5.0", status = API.Status.STABLE)
public interface TestTemplateInvocationContext {
    List<Extension> getAdditionalExtensions();

    String getDisplayName(int i11);
}
