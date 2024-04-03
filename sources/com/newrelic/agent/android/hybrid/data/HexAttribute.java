package com.newrelic.agent.android.hybrid.data;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HexAttribute {
    public static final String HEX_ATTR_APP_BUILD_ID = "appBuild";
    public static final String HEX_ATTR_APP_VERSION = "appVersion";
    public static final String HEX_ATTR_JSERROR_BUILDID = "buildId";
    public static final String HEX_ATTR_JSERROR_BUNDLEID = "bundleId";
    public static final String HEX_ATTR_JSERROR_COLUMN = "column";
    public static final String HEX_ATTR_JSERROR_FATAL = "fatal";
    public static final String HEX_ATTR_JSERROR_FILENAME = "fileName";
    public static final String HEX_ATTR_JSERROR_LINE_NUMBER = "lineNumber";
    public static final String HEX_ATTR_JSERROR_MESSAGE = "message";
    public static final String HEX_ATTR_JSERROR_METHOD = "method";
    public static final String HEX_ATTR_JSERROR_NAME = "name";
    public static final String HEX_ATTR_JSERROR_THREAD = "thread";
    public static final String HEX_ATTR_THREAD_CRASHED = "crashed";
    public static final String HEX_ATTR_THREAD_ID = "threadId";
    public static final String HEX_ATTR_THREAD_NUMBER = "threadNumber";
    public static final String HEX_ATTR_THREAD_PRI = "priority";
    public static final String HEX_ATTR_THREAD_STATE = "state";
    public static final Set<String> HEX_REQUIRED_ATTRIBUTES = new HashSet(Arrays.asList(new String[]{"name", "message", "fatal", HEX_ATTR_JSERROR_BUILDID, HEX_ATTR_JSERROR_BUNDLEID, AnalyticsAttribute.SESSION_TIME_SINCE_LOAD_ATTRIBUTE}));
    public static final Set<String> HEX_SESSION_ATTR_WHITELIST = new HashSet(Arrays.asList(new String[]{AnalyticsAttribute.OS_NAME_ATTRIBUTE, AnalyticsAttribute.OS_VERSION_ATTRIBUTE, AnalyticsAttribute.OS_BUILD_ATTRIBUTE, AnalyticsAttribute.OS_MAJOR_VERSION_ATTRIBUTE, AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE, AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE, "uuid", "carrier", AnalyticsAttribute.NEW_RELIC_VERSION_ATTRIBUTE, AnalyticsAttribute.MEM_USAGE_MB_ATTRIBUTE, "sessionId", "platform", "platformVersion", AnalyticsAttribute.RUNTIME_ATTRIBUTE, AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE, "appBuild"}));
}
