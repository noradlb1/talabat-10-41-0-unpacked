package com.newrelic.agent.android.analytics;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AnalyticsValidator {
    private static final String ALLOWABLE_EVENT_TYPE_CHARS = "^[\\p{L}\\p{Nd} _:.]+$";
    private static final String NEW_RELIC_PREFIX = "newRelic";
    private static final String NR_PREFIX = "nr.";
    private static final String PUBLIC_PREFIX = "Public_";
    protected static Set<String> excludedAttributeNames = new HashSet<String>() {
        {
            add(AnalyticsAttribute.APP_INSTALL_ATTRIBUTE);
            add(AnalyticsAttribute.APP_UPGRADE_ATTRIBUTE);
            add(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE);
        }
    };
    protected static Set<String> excludedEventNames = new HashSet<String>() {
    };
    private static final AgentLog log = AgentLogManager.getAgentLog();
    static final Set<String> reservedAttributeNames = new HashSet<String>() {
        {
            add(AnalyticsAttribute.EVENT_TYPE_ATTRIBUTE);
            add("type");
            add("timestamp");
            add("category");
            add(AnalyticsAttribute.ACCOUNT_ID_ATTRIBUTE);
            add("appId");
            add(AnalyticsAttribute.APP_NAME_ATTRIBUTE);
            add("uuid");
            add("sessionId");
            add(AnalyticsAttribute.OS_NAME_ATTRIBUTE);
            add(AnalyticsAttribute.OS_VERSION_ATTRIBUTE);
            add(AnalyticsAttribute.OS_MAJOR_VERSION_ATTRIBUTE);
            add(AnalyticsAttribute.DEVICE_MANUFACTURER_ATTRIBUTE);
            add(AnalyticsAttribute.DEVICE_MODEL_ATTRIBUTE);
            add(AnalyticsAttribute.MEM_USAGE_MB_ATTRIBUTE);
            add("carrier");
            add(AnalyticsAttribute.NEW_RELIC_VERSION_ATTRIBUTE);
            add(AnalyticsAttribute.INTERACTION_DURATION_ATTRIBUTE);
            add(AnalyticsAttribute.APP_INSTALL_ATTRIBUTE);
            add(AnalyticsAttribute.APP_UPGRADE_ATTRIBUTE);
            add("platform");
            add("platformVersion");
            add(AnalyticsAttribute.LAST_INTERACTION_ATTRIBUTE);
            add(AnalyticsAttribute.OS_BUILD_ATTRIBUTE);
            add(AnalyticsAttribute.RUNTIME_ATTRIBUTE);
            add(AnalyticsAttribute.ARCHITECTURE_ATTRIBUTE);
            add("appBuild");
        }
    };
    static final Set<String> reservedEventNames = new HashSet<String>() {
    };
    static final Set<String> reservedEventTypes = new HashSet<String>() {
        {
            add(AnalyticsEvent.EVENT_TYPE_MOBILE);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_REQUEST_ERROR);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_BREADCRUMB);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_CRASH);
            add(AnalyticsEvent.EVENT_TYPE_MOBILE_USER_ACTION);
        }
    };

    public boolean isExcludedAttributeName(String str) {
        return excludedAttributeNames.contains(str);
    }

    public boolean isReservedAttributeName(String str) {
        if (reservedAttributeNames.contains(str)) {
            AgentLog agentLog = log;
            agentLog.error("Attribute name [" + str + "] is in the reserved names list.");
            return true;
        } else if (str.startsWith(NEW_RELIC_PREFIX)) {
            AgentLog agentLog2 = log;
            agentLog2.error("Attribute name [" + str + "] starts with reserved prefix [newRelic]");
            return true;
        } else if (str.startsWith(NR_PREFIX)) {
            AgentLog agentLog3 = log;
            agentLog3.error("Attribute name [" + str + "] starts with reserved prefix [nr.]");
            return true;
        } else if (!str.startsWith(PUBLIC_PREFIX)) {
            return false;
        } else {
            AgentLog agentLog4 = log;
            agentLog4.error("Attribute name [" + str + "] starts with reserved prefix [Public_]");
            return true;
        }
    }

    public boolean isReservedEventType(String str) {
        boolean z11;
        if (!isValidEventType(str) || !reservedEventTypes.contains(str)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            AgentLog agentLog = log;
            agentLog.error("Event type [" + str + "] is reserved and will be ignored.");
        }
        return z11;
    }

    public boolean isValidAttribute(AnalyticsAttribute analyticsAttribute) {
        if (analyticsAttribute == null || !isValidAttributeName(analyticsAttribute.getName()) || !isValidAttributeValue(analyticsAttribute.getName(), analyticsAttribute.valueAsString())) {
            return false;
        }
        return true;
    }

    public boolean isValidAttributeName(String str) {
        boolean isValidKeyName = isValidKeyName(str);
        if (isValidKeyName && !(!isReservedAttributeName(str))) {
            AgentLog agentLog = log;
            agentLog.error("Attribute name [" + str + "] is reserved for internal use and will be ignored.");
        }
        return isValidKeyName;
    }

    public boolean isValidAttributeValue(String str, String str2) {
        boolean z11;
        if (str2 == null || str2.isEmpty() || str2.getBytes().length >= 4096) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            AgentLog agentLog = log;
            agentLog.error("Attribute value for name " + str + " is null, empty, or exceeds the maximum length of 4096 bytes.");
        }
        return z11;
    }

    public boolean isValidEventName(String str) {
        return str != null && !str.isEmpty() && str.length() < 255;
    }

    public boolean isValidEventType(String str) {
        boolean z11;
        if (str != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            z11 = str.matches(ALLOWABLE_EVENT_TYPE_CHARS);
        }
        if (!z11) {
            AgentLog agentLog = log;
            agentLog.error("Event type [" + str + "] is invalid and will be ignored. Custom event types may only include alphanumeric, ' ', '.', ':' or '_' characters.");
        }
        return z11;
    }

    public boolean isValidKeyName(String str) {
        boolean z11;
        if (str == null || str.isEmpty() || str.length() >= 255) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            AgentLog agentLog = log;
            agentLog.error("Attribute name [" + str + "] is null, empty, or exceeds the maximum length of 255 characters.");
        }
        return z11;
    }

    public AnalyticsEventCategory toValidCategory(AnalyticsEventCategory analyticsEventCategory) {
        return analyticsEventCategory == null ? AnalyticsEventCategory.Custom : analyticsEventCategory;
    }

    public String toValidEventType(String str) {
        return (str == null || str.isEmpty()) ? AnalyticsEvent.EVENT_TYPE_MOBILE : str;
    }

    public Set<AnalyticsAttribute> toValidatedAnalyticsAttributes(Map<String, Object> map) {
        try {
            HashSet hashSet = new HashSet();
            for (String next : map.keySet()) {
                AnalyticsAttribute createAttribute = AnalyticsAttribute.createAttribute(next, map.get(next));
                if (isValidAttribute(createAttribute)) {
                    hashSet.add(createAttribute);
                } else {
                    AgentLog agentLog = log;
                    agentLog.warn(String.format("Attribute " + next + "] ignored: value is null, empty or exceeds the maximum name length", new Object[0]));
                }
            }
            return hashSet;
        } catch (Exception e11) {
            log.error("Error occurred filtering attribute map: ", e11);
            return Collections.emptySet();
        }
    }

    public Set<AnalyticsAttribute> toValidatedAnalyticsAttributes(Set<AnalyticsAttribute> set) {
        try {
            HashSet hashSet = new HashSet();
            for (AnalyticsAttribute next : set) {
                if (isValidAttribute(next)) {
                    hashSet.add(new AnalyticsAttribute(next));
                } else {
                    AgentLog agentLog = log;
                    String name2 = next.getName();
                    agentLog.warn(String.format("Attribute " + name2 + "] ignored: value is null, empty or exceeds the maximum name length", new Object[0]));
                }
            }
            return hashSet;
        } catch (Exception e11) {
            log.error("Error occurred filtering attribute set: ", e11);
            return Collections.emptySet();
        }
    }
}
