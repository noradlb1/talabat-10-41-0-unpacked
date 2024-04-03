package org.junit.jupiter.api.parallel;

import org.apiguardian.api.API;

@API(since = "5.3", status = API.Status.EXPERIMENTAL)
public class Resources {
    @API(since = "5.8", status = API.Status.EXPERIMENTAL)
    public static final String GLOBAL = "org.junit.platform.engine.support.hierarchical.ExclusiveResource.GLOBAL_KEY";
    @API(since = "5.4", status = API.Status.EXPERIMENTAL)
    public static final String LOCALE = "java.util.Locale.default";
    public static final String SYSTEM_ERR = "java.lang.System.err";
    public static final String SYSTEM_OUT = "java.lang.System.out";
    public static final String SYSTEM_PROPERTIES = "java.lang.System.properties";
    @API(since = "5.4", status = API.Status.EXPERIMENTAL)
    public static final String TIME_ZONE = "java.util.TimeZone.default";

    private Resources() {
    }
}
