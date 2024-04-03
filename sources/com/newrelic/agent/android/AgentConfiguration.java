package com.newrelic.agent.android;

import com.newrelic.agent.android.analytics.AnalyticsAttributeStore;
import com.newrelic.agent.android.crash.CrashStore;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.NullPayloadStore;
import com.newrelic.agent.android.payload.Payload;
import com.newrelic.agent.android.payload.PayloadStore;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.Constants;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgentConfiguration {
    private static final String DEFAULT_COLLECTOR_HOST = "mobile-collector.newrelic.com";
    private static final String DEFAULT_CRASH_COLLECTOR_HOST = "mobile-crash.newrelic.com";
    static final String DEFAULT_DEVICE_UUID = "0";
    public static final String DEFAULT_FED_RAMP_COLLECTOR_HOST = "gov-mobile-collector.newrelic.com";
    private static final String DEFAULT_FED_RAMP_CRASH_COLLECTOR_HOST = "gov-mobile-crash.newrelic.com";
    public static final String DEFAULT_REGION_COLLECTOR_HOST = "mobile-collector.%s.nr-data.net";
    private static final String DEFAULT_REGION_CRASH_COLLECTOR_HOST = "mobile-crash.%s.nr-data.net";
    static final int DEVICE_UUID_MAX_LEN = 40;
    private static final String HEX_COLLECTOR_PATH = "/mobile/f";
    private static final int HEX_COLLECTOR_TIMEOUT = 5000;
    private static final int NUM_IO_THREADS = 3;
    private static final int PAYLOAD_TTL = 172800000;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private AnalyticsAttributeStore analyticsAttributeStore;
    private ApplicationFramework applicationFramework = ApplicationFramework.Native;
    private String applicationFrameworkVersion = Agent.getVersion();
    private String applicationToken;
    private String collectorHost = DEFAULT_COLLECTOR_HOST;
    private String crashCollectorHost = DEFAULT_CRASH_COLLECTOR_HOST;
    private CrashStore crashStore;
    private String customApplicationVersion = null;
    private String customBuildId = null;
    private String deviceID;
    private boolean enableAnalyticsEvents = true;
    private String launchActivityClassName = null;
    private PayloadStore<Payload> payloadStore = new NullPayloadStore();
    private String region = null;
    private boolean reportCrashes = false;
    private boolean reportHandledExceptions = true;
    private String sessionID = provideSessionId();
    private boolean useLocationService = false;
    private boolean useSsl = true;

    public AnalyticsAttributeStore getAnalyticsAttributeStore() {
        return this.analyticsAttributeStore;
    }

    public String getAppTokenHeader() {
        return Constants.Network.APPLICATION_LICENSE_HEADER;
    }

    public String getAppVersionHeader() {
        return Constants.Network.APP_VERSION_HEADER;
    }

    public ApplicationFramework getApplicationFramework() {
        return this.applicationFramework;
    }

    public String getApplicationFrameworkVersion() {
        return this.applicationFrameworkVersion;
    }

    public String getApplicationToken() {
        return this.applicationToken;
    }

    public String getCollectorHost() {
        return this.collectorHost;
    }

    public String getCrashCollectorHost() {
        return this.crashCollectorHost;
    }

    public CrashStore getCrashStore() {
        return this.crashStore;
    }

    public String getCustomApplicationVersion() {
        return this.customApplicationVersion;
    }

    public String getCustomBuildIdentifier() {
        return this.customBuildId;
    }

    public String getDefaultCollectorHost() {
        return DEFAULT_COLLECTOR_HOST;
    }

    public String getDefaultCrashCollectorHost() {
        return DEFAULT_CRASH_COLLECTOR_HOST;
    }

    public String getDeviceID() {
        return this.deviceID;
    }

    public String getDeviceOsNameHeader() {
        return Constants.Network.DEVICE_OS_NAME_HEADER;
    }

    public boolean getEnableAnalyticsEvents() {
        return this.enableAnalyticsEvents;
    }

    public String getFedRampCollectorHost() {
        return DEFAULT_FED_RAMP_COLLECTOR_HOST;
    }

    public String getFedRampCrashCollectorHost() {
        return DEFAULT_FED_RAMP_CRASH_COLLECTOR_HOST;
    }

    public String getHexCollectorHost() {
        return getCollectorHost();
    }

    public String getHexCollectorPath() {
        return HEX_COLLECTOR_PATH;
    }

    public int getHexCollectorTimeout() {
        return 5000;
    }

    public int getIOThreadSize() {
        return 3;
    }

    public String getLaunchActivityClassName() {
        return this.launchActivityClassName;
    }

    public PayloadStore<Payload> getPayloadStore() {
        return this.payloadStore;
    }

    public int getPayloadTTL() {
        return PAYLOAD_TTL;
    }

    public String getRegionalCollectorFromLicenseKey(String str) {
        String parseRegionFromApplicationToken = parseRegionFromApplicationToken(str);
        if (parseRegionFromApplicationToken == null || "".equals(str)) {
            return DEFAULT_COLLECTOR_HOST;
        }
        return String.format(DEFAULT_REGION_COLLECTOR_HOST, new Object[]{parseRegionFromApplicationToken});
    }

    public boolean getReportCrashes() {
        return this.reportCrashes;
    }

    public boolean getReportHandledExceptions() {
        return this.reportHandledExceptions;
    }

    public String getSessionID() {
        return this.sessionID;
    }

    public String parseRegionFromApplicationToken(String str) {
        if (str != null && !"".equals(str)) {
            Matcher matcher = Pattern.compile("^(.+?)x{1,2}.*").matcher(str);
            if (matcher.matches()) {
                try {
                    String group = matcher.group(1);
                    if (group != null) {
                        if (!"".equals(group)) {
                            return group;
                        }
                    }
                    log.warn("Region prefix empty");
                } catch (Exception e11) {
                    AgentLog agentLog = log;
                    agentLog.error("getRegionalCollectorFromLicenseKey: " + e11);
                }
            }
        }
        return null;
    }

    public String provideSessionId() {
        String uuid = UUID.randomUUID().toString();
        this.sessionID = uuid;
        return uuid;
    }

    public void setAnalyticsAttributeStore(AnalyticsAttributeStore analyticsAttributeStore2) {
        this.analyticsAttributeStore = analyticsAttributeStore2;
    }

    public void setApplicationFramework(ApplicationFramework applicationFramework2) {
        this.applicationFramework = applicationFramework2;
    }

    public void setApplicationFrameworkVersion(String str) {
        this.applicationFrameworkVersion = str;
    }

    public void setApplicationToken(String str) {
        this.applicationToken = str;
        this.region = parseRegionFromApplicationToken(str);
        if (FeatureFlag.featureEnabled(FeatureFlag.FedRampEnabled)) {
            this.collectorHost = DEFAULT_FED_RAMP_COLLECTOR_HOST;
            this.crashCollectorHost = DEFAULT_FED_RAMP_CRASH_COLLECTOR_HOST;
            return;
        }
        String str2 = this.region;
        if (str2 != null) {
            this.collectorHost = String.format(DEFAULT_REGION_COLLECTOR_HOST, new Object[]{str2});
            this.crashCollectorHost = String.format(DEFAULT_REGION_CRASH_COLLECTOR_HOST, new Object[]{this.region});
            return;
        }
        this.collectorHost = DEFAULT_COLLECTOR_HOST;
        this.crashCollectorHost = DEFAULT_CRASH_COLLECTOR_HOST;
    }

    public void setCollectorHost(String str) {
        this.collectorHost = str;
    }

    public void setCrashCollectorHost(String str) {
        this.crashCollectorHost = str;
    }

    public void setCrashStore(CrashStore crashStore2) {
        this.crashStore = crashStore2;
    }

    public void setCustomApplicationVersion(String str) {
        this.customApplicationVersion = str;
    }

    public void setCustomBuildIdentifier(String str) {
        this.customBuildId = str;
    }

    public void setDeviceID(String str) {
        if (str == null) {
            this.deviceID = "0";
            return;
        }
        String trim = str.trim();
        if (trim.isEmpty()) {
            this.deviceID = "0";
            return;
        }
        if (trim.length() > 40) {
            StatsEngine.get().inc(MetricNames.METRIC_UUID_TRUNCATED);
        }
        this.deviceID = trim.substring(0, Math.min(40, trim.length()));
    }

    public void setEnableAnalyticsEvents(boolean z11) {
        this.enableAnalyticsEvents = z11;
    }

    public void setLaunchActivityClassName(String str) {
        this.launchActivityClassName = str;
    }

    public void setPayloadStore(PayloadStore<Payload> payloadStore2) {
        this.payloadStore = payloadStore2;
    }

    public void setReportCrashes(boolean z11) {
        this.reportCrashes = z11;
    }

    public void setReportHandledExceptions(boolean z11) {
        this.reportHandledExceptions = z11;
    }

    public void setUseSsl(boolean z11) {
        if (!z11) {
            log.error("Unencrypted http requests are no longer supported");
        }
        this.useSsl = true;
    }

    public boolean useSsl() {
        return this.useSsl;
    }
}
