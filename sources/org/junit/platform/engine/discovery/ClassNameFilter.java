package org.junit.platform.engine.discovery;

import org.apiguardian.api.API;
import org.junit.platform.engine.DiscoveryFilter;

@API(since = "1.0", status = API.Status.STABLE)
public interface ClassNameFilter extends DiscoveryFilter<String> {
    public static final String STANDARD_INCLUDE_PATTERN = "^(Test.*|.+[.$]Test.*|.*Tests?)$";
}
