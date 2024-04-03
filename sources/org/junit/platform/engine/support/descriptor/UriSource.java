package org.junit.platform.engine.support.descriptor;

import java.net.URI;
import org.apiguardian.api.API;
import org.junit.platform.engine.TestSource;

@API(since = "1.0", status = API.Status.STABLE)
public interface UriSource extends TestSource {
    URI getUri();
}
