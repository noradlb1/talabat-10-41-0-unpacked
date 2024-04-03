package com.newrelic.agent.android;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.model.NetworkLog;
import com.newrelic.agent.android.agentdata.AgentDataController;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.analytics.EventListener;
import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.distributedtracing.DistributedTracing;
import com.newrelic.agent.android.distributedtracing.TraceContext;
import com.newrelic.agent.android.distributedtracing.TraceListener;
import com.newrelic.agent.android.hybrid.StackTrace;
import com.newrelic.agent.android.hybrid.data.DataController;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.logging.AndroidAgentLog;
import com.newrelic.agent.android.logging.NullAgentLog;
import com.newrelic.agent.android.measurement.http.HttpTransactionMeasurement;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.metric.MetricUnit;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.newrelic.agent.android.tracing.TracingInactiveException;
import com.newrelic.agent.android.util.Constants;
import com.newrelic.agent.android.util.NetworkFailure;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class NewRelic {
    private static final String UNKNOWN_HTTP_REQUEST_TYPE = "unknown";
    protected static final AgentConfiguration agentConfiguration = new AgentConfiguration();
    protected static boolean isShutdown = false;
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    protected static boolean started = false;
    protected int logLevel = 3;
    protected boolean loggingEnabled = true;

    public NewRelic(String str) {
        agentConfiguration.setApplicationToken(str);
    }

    public static void _noticeHttpTransaction(String str, String str2, int i11, long j11, long j12, long j13, long j14, String str3, Map<String, String> map, String str4) {
        noticeHttpTransaction(str, str2, i11, j11, j12, j13, j14, str3, map, str4, (Map<String, Object>) null);
    }

    public static boolean addHTTPHeadersTrackingFor(List<String> list) {
        return HttpHeaders.getInstance().addHttpHeadersAsAttributes(list);
    }

    private static void checkEmpty(String str, String str2) {
        checkNull(str, str2);
        if (str.length() == 0) {
            throw new IllegalArgumentException(str2);
        }
    }

    private static boolean checkNegative(int i11, String str) {
        if (i11 >= 0) {
            return false;
        }
        log.error(str);
        if (!FeatureFlag.featureEnabled(FeatureFlag.HandledExceptions)) {
            return true;
        }
        recordHandledException((Exception) new RuntimeException(str));
        return true;
    }

    private static void checkNull(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void crashNow() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "crashNow"));
        crashNow("This is a demonstration crash courtesy of New Relic");
    }

    public static String currentSessionId() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "currentSessionId"));
        return agentConfiguration.getSessionID();
    }

    public static void disableFeature(FeatureFlag featureFlag) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "disableFeature/<state>").replace(MetricNames.TAG_STATE, featureFlag.name()));
        AgentLog agentLog = log;
        agentLog.debug("Disable feature: " + featureFlag.name());
        FeatureFlag.disableFeature(featureFlag);
    }

    public static void enableFeature(FeatureFlag featureFlag) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "enableFeature/<state>").replace(MetricNames.TAG_STATE, featureFlag.name()));
        AgentLog agentLog = log;
        agentLog.debug("Enable feature: " + featureFlag.name());
        FeatureFlag.enableFeature(featureFlag);
    }

    public static void endInteraction(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "endInteraction"));
        AgentLog agentLog = log;
        agentLog.debug("NewRelic.endInteraction invoked. id: " + str);
        TraceMachine.endTrace(str);
    }

    public static void endMethodTrace() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "endMethodTrace"));
        log.debug("NewRelic.endMethodTrace invoked.");
        TraceMachine.exitMethod();
    }

    public static boolean incrementAttribute(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "incrementAttribute(String)"));
        return AnalyticsControllerImpl.getInstance().incrementAttribute(str, 1.0d);
    }

    private boolean isInstrumented() {
        return true;
    }

    public static boolean isStarted() {
        return started;
    }

    private void logRecourse() {
        log.error("Failed to detect New Relic instrumentation. The current runtime variant may be excluded from instrumentation, or instrumentation failed during your build process. Please visit http://support.newrelic.com.");
    }

    public static TraceContext noticeDistributedTrace(Map<String, String> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "noticeDistributedTrace"));
        return TraceContext.createTraceContext(map);
    }

    public static void noticeHttpTransaction(Map<String, Object> map) {
        Map<String, Object> map2 = map;
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "noticeHttpTransaction(Map Attribute)"));
        try {
            noticeHttpTransaction((String) map2.get("url"), (String) map2.get("httpMethod"), Integer.parseInt((String) map2.get("statusCode")), Long.parseLong((String) map2.get("startTimeMs")), Long.parseLong((String) map2.get("endTimeMs")), Long.parseLong((String) map2.get(AnalyticsAttribute.BYTES_SENT_ATTRIBUTE)), Long.parseLong((String) map2.get(AnalyticsAttribute.BYTES_RECEIVED_ATTRIBUTE)), (String) map2.get("responseBody"), (Map<String, String>) null, (String) map2.get("appData"), (Map) map2.get("traceAttributes"));
        } catch (NumberFormatException e11) {
            log.error(e11.getMessage());
            recordHandledException((Exception) e11);
        }
    }

    public static void noticeNetworkFailure(Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "noticeNetworkFailure(Map Attribute)"));
        try {
            noticeNetworkFailure((String) map.get("url"), (String) map.get("httpMethod"), Long.parseLong((String) map.get("startTimeMs")), Long.parseLong((String) map.get("endTimeMs")), NetworkFailure.fromErrorCode(Integer.parseInt((String) map.get("errorCode"))), (String) map.get("message"), (Map) map.get("traceAttributes"));
        } catch (NumberFormatException e11) {
            log.error(e11.getMessage());
            recordHandledException((Exception) e11);
        }
    }

    public static boolean recordBreadcrumb(String str) {
        return recordBreadcrumb(str, (Map<String, Object>) null);
    }

    public static boolean recordCustomEvent(String str, Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordCustomEvent"));
        if (map == null) {
            map = new HashMap<>();
        }
        return AnalyticsControllerImpl.getInstance().recordCustomEvent(str, map);
    }

    public static boolean recordHandledException(Exception exc) {
        return recordHandledException(exc, (Map<String, Object>) null);
    }

    public static boolean recordJSErrorException(StackTrace stackTrace) {
        return DataController.sendAgentData(stackTrace);
    }

    public static void recordMetric(String str, String str2, int i11, double d11, double d12, MetricUnit metricUnit, MetricUnit metricUnit2) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordMetric"));
        AgentLog agentLog = log;
        agentLog.debug("NewRelic.recordMetric invoked for name " + str + ", category: " + str2 + ", count: " + i11 + ", totalValue " + d11 + ", exclusiveValue: " + d12 + ", countUnit: " + metricUnit + ", valueUnit: " + metricUnit2);
        checkNull(str2, "recordMetric: category must not be null. If no MetricCategory is applicable, use MetricCategory.NONE.");
        checkEmpty(str, "recordMetric: name must not be empty.");
        if (!checkNegative(i11, "recordMetric: count must not be negative.")) {
            Measurements.addCustomMetric(str, str2, i11, d11, d12, metricUnit, metricUnit2);
        }
    }

    public static boolean removeAllAttributes() {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "removeAllAttribute"));
        return AnalyticsControllerImpl.getInstance().removeAllAttributes();
    }

    public static boolean removeAttribute(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "removeAttribute"));
        return AnalyticsControllerImpl.getInstance().removeAttribute(str);
    }

    public static boolean setAttribute(String str, String str2) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setAttribute(String,String)"));
        return AnalyticsControllerImpl.getInstance().setAttribute(str, str2);
    }

    public static void setEventListener(EventListener eventListener) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setEventListener"));
        AnalyticsControllerImpl.getInstance().getEventManager().setEventListener(eventListener);
    }

    public static void setInteractionName(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setInteractionName"));
        TraceMachine.setRootDisplayName(str);
    }

    public static void setMaxEventBufferTime(int i11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setMaxEventBufferTime"));
        AnalyticsControllerImpl.getInstance().setMaxEventBufferTime(i11);
    }

    public static void setMaxEventPoolSize(int i11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setMaxEventPoolSize"));
        AnalyticsControllerImpl.getInstance().setMaxEventPoolSize(i11);
    }

    public static boolean setUserId(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setUserId"));
        return AnalyticsControllerImpl.getInstance().setAttribute("userId", str);
    }

    public static void shutdown() {
        StatsEngine.reset();
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "shutdown"));
        if (started) {
            try {
                isShutdown = true;
                Agent.getImpl().stop();
            } finally {
                Agent.setImpl(NullAgentImpl.instance);
                started = false;
                log.warn("Agent is shut down.");
            }
        }
    }

    public static String startInteraction(String str) {
        checkNull(str, "startInteraction: actionName must be an action/method name.");
        AgentLog agentLog = log;
        agentLog.debug("NewRelic.startInteraction invoked with actionName: " + str);
        TraceMachine.startTracing(str.replace("/", RealDiscoveryConfigurationRepository.VERSION_DELIMETER), true, FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing));
        try {
            return TraceMachine.getActivityTrace().getId();
        } catch (TracingInactiveException unused) {
            return null;
        }
    }

    public static void startMethodTrace(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "startMethodTrace"));
        checkNull(str, "startMethodTrace: actionName must be an action/method name.");
        TraceMachine.enterMethod(str);
    }

    public static NewRelic withApplicationToken(String str) {
        return new NewRelic(str);
    }

    public void start(Context context) {
        AgentLog agentLog;
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "start"));
        if (isShutdown) {
            log.error("NewRelic agent has shut down, relaunch your application to restart the agent.");
        } else if (started) {
            log.debug("NewRelic is already running.");
        } else {
            try {
                if (this.loggingEnabled) {
                    agentLog = new AndroidAgentLog();
                } else {
                    agentLog = new NullAgentLog();
                }
                AgentLogManager.setAgentLog(agentLog);
                AgentLog agentLog2 = log;
                agentLog2.setLevel(this.logLevel);
                if (!InstantApps.isInstantApp(context)) {
                    if (!isInstrumented()) {
                        logRecourse();
                        return;
                    }
                }
                AndroidAgentImpl.init(context, agentConfiguration);
                started = true;
                if (agentLog2.getLevel() >= 5) {
                    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                    if (stackTrace.length > 3) {
                        StackTraceElement stackTraceElement = stackTrace[3];
                        agentLog2.debug("Agent started from " + stackTraceElement.getClassName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + stackTraceElement.getMethodName() + CertificateUtil.DELIMITER + stackTraceElement.getLineNumber());
                    }
                }
            } catch (Throwable th2) {
                log.error("Error occurred while starting the New Relic agent!", th2);
                logRecourse();
            }
        }
    }

    public NewRelic usingCollectorAddress(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "usingCollectorAddress"));
        agentConfiguration.setCollectorHost(str);
        return this;
    }

    public NewRelic usingCrashCollectorAddress(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "usingCrashCollectorAddress"));
        agentConfiguration.setCrashCollectorHost(str);
        return this;
    }

    public NewRelic withApplicationBuild(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withApplicationBuild"));
        if (!TextUtils.isEmpty(str)) {
            agentConfiguration.setCustomBuildIdentifier(str);
        }
        return this;
    }

    public NewRelic withApplicationFramework(ApplicationFramework applicationFramework, String str) {
        String str2;
        String str3;
        StatsEngine notice = StatsEngine.notice();
        String replace = MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withApplicationFramework");
        if (applicationFramework != null) {
            str2 = applicationFramework.name();
        } else {
            str2 = "<missing>";
        }
        String replace2 = replace.replace(MetricNames.TAG_FRAMEWORK, str2);
        if (str != null) {
            str3 = str;
        } else {
            str3 = "";
        }
        notice.inc(replace2.replace(MetricNames.TAG_FRAMEWORK_VERSION, str3));
        if (applicationFramework != null) {
            agentConfiguration.setApplicationFramework(applicationFramework);
        }
        agentConfiguration.setApplicationFrameworkVersion(str);
        return this;
    }

    public NewRelic withApplicationVersion(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withApplicationVersion/<state>").replace(MetricNames.TAG_STATE, str));
        if (str != null) {
            agentConfiguration.setCustomApplicationVersion(str);
        }
        return this;
    }

    public NewRelic withCrashReportingEnabled(boolean z11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withCrashReportingEnabled/<state>").replace(MetricNames.TAG_STATE, Boolean.toString(z11)));
        agentConfiguration.setReportCrashes(z11);
        return this;
    }

    public NewRelic withDeviceID(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withDeviceID"));
        agentConfiguration.setDeviceID(str);
        return this;
    }

    public NewRelic withDistributedTraceListener(TraceListener traceListener) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withDistributedTraceListener"));
        if (FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            DistributedTracing.setDistributedTraceListener(traceListener);
        }
        return this;
    }

    public NewRelic withLaunchActivityName(String str) {
        agentConfiguration.setLaunchActivityClassName(str);
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "AppLaunch/<state>").replace(MetricNames.TAG_STATE, str));
        return this;
    }

    public NewRelic withLogLevel(int i11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withLogLevel/<state>").replace(MetricNames.TAG_STATE, Integer.toString(i11)));
        this.logLevel = i11;
        return this;
    }

    public NewRelic withLoggingEnabled(boolean z11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "withLoggingEnabled/<state>").replace(MetricNames.TAG_STATE, Boolean.toString(z11)));
        this.loggingEnabled = z11;
        return this;
    }

    public static boolean recordBreadcrumb(String str, Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordBreadcrumb"));
        if (map == null) {
            map = new HashMap<>();
        }
        if (str != null && !str.isEmpty()) {
            map.put("name", str);
        }
        return AnalyticsControllerImpl.getInstance().recordBreadcrumb(str, map);
    }

    public static boolean recordHandledException(Exception exc, Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordHandledException"));
        if (map == null) {
            map = new HashMap<>();
        }
        return recordHandledException((Throwable) exc, map);
    }

    public static void crashNow(String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "crashNow(String)"));
        throw new RuntimeException(str);
    }

    public static boolean incrementAttribute(String str, double d11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "incrementAttribute(String, double)"));
        return AnalyticsControllerImpl.getInstance().incrementAttribute(str, d11);
    }

    public static boolean setAttribute(String str, double d11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setAttribute(String,double)"));
        return AnalyticsControllerImpl.getInstance().setAttribute(str, d11);
    }

    public static String startInteraction(Context context, String str) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_DEPRECATED.replace(MetricNames.TAG_NAME, "startInteraction"));
        checkNull(context, "startInteraction: context must be an Activity instance.");
        checkNull(str, "startInteraction: actionName must be an action/method name.");
        AgentLog agentLog = log;
        agentLog.debug("NewRelic.startInteraction invoked with actionName: " + str);
        TraceMachine.startTracing(context.getClass().getSimpleName() + "#" + str.replace("/", RealDiscoveryConfigurationRepository.VERSION_DELIMETER), false, FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing));
        try {
            return TraceMachine.getActivityTrace().getId();
        } catch (TracingInactiveException unused) {
            return null;
        }
    }

    public static boolean recordCustomEvent(String str, String str2, Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        if (str2 != null && !str2.isEmpty()) {
            map.put("name", str2);
        }
        return recordCustomEvent(str, map);
    }

    public static boolean recordHandledException(Throwable th2) {
        return recordHandledException(th2, (Map<String, Object>) null);
    }

    public static boolean recordHandledException(Throwable th2, Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "recordThrowable"));
        if (map == null) {
            map = new HashMap<>();
        }
        return AgentDataController.sendAgentData(th2, map);
    }

    public static void recordMetric(String str, String str2, double d11) {
        recordMetric(str, str2, 1, d11, d11, (MetricUnit) null, (MetricUnit) null);
    }

    public static boolean setAttribute(String str, boolean z11) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "setAttribute(String,boolean)"));
        return AnalyticsControllerImpl.getInstance().setAttribute(str, z11);
    }

    public static void recordMetric(String str, String str2) {
        recordMetric(str, str2, 1.0d);
    }

    public static void noticeNetworkFailure(String str, String str2, long j11, long j12, NetworkFailure networkFailure, String str3) {
        noticeNetworkFailure(str, str2, j11, j12, networkFailure, str3, (Map<String, Object>) null);
    }

    public static void noticeNetworkFailure(String str, String str2, long j11, long j12, NetworkFailure networkFailure) {
        noticeNetworkFailure(str, str2, j11, j12, networkFailure, "", (Map<String, Object>) null);
    }

    public static void noticeNetworkFailure(String str, String str2, long j11, long j12, Exception exc) {
        checkEmpty(str, "noticeHttpException: url must not be empty.");
        noticeNetworkFailure(str, str2, j11, j12, NetworkFailure.exceptionToNetworkFailure(exc), exc.getMessage());
    }

    public static void noticeHttpTransaction(String str, String str2, int i11, long j11, long j12, long j13, long j14) {
        _noticeHttpTransaction(str, str2, i11, j11, j12, j13, j14, (String) null, (Map<String, String>) null, (String) null);
    }

    public static void noticeHttpTransaction(String str, String str2, int i11, long j11, long j12, long j13, long j14, String str3) {
        _noticeHttpTransaction(str, str2, i11, j11, j12, j13, j14, str3, (Map<String, String>) null, (String) null);
    }

    public static void noticeHttpTransaction(String str, String str2, int i11, long j11, long j12, long j13, long j14, String str3, Map<String, String> map) {
        _noticeHttpTransaction(str, str2, i11, j11, j12, j13, j14, str3, map, (String) null);
    }

    @Deprecated
    public static void noticeNetworkFailure(String str, long j11, long j12, NetworkFailure networkFailure) {
        noticeNetworkFailure(str, "unknown", j11, j12, networkFailure);
    }

    public static void noticeHttpTransaction(String str, String str2, int i11, long j11, long j12, long j13, long j14, String str3, Map<String, String> map, String str4) {
        _noticeHttpTransaction(str, str2, i11, j11, j12, j13, j14, str3, map, str4);
    }

    @Deprecated
    public static void noticeNetworkFailure(String str, long j11, long j12, Exception exc) {
        noticeNetworkFailure(str, "unknown", j11, j12, exc);
    }

    public static void noticeHttpTransaction(String str, String str2, int i11, long j11, long j12, long j13, long j14, String str3, Map<String, String> map, URLConnection uRLConnection) {
        String headerField;
        URLConnection uRLConnection2 = uRLConnection;
        if (uRLConnection2 == null || (headerField = uRLConnection2.getHeaderField(Constants.Network.CROSS_PROCESS_ID_HEADER)) == null || headerField.length() <= 0) {
            _noticeHttpTransaction(str, str2, i11, j11, j12, j13, j14, str3, map, (String) null);
        } else {
            _noticeHttpTransaction(str, str2, i11, j11, j12, j13, j14, str3, map, headerField);
        }
    }

    public static void noticeNetworkFailure(String str, String str2, long j11, long j12, NetworkFailure networkFailure, String str3, Map<String, Object> map) {
        StatsEngine.notice().inc(MetricNames.SUPPORTABILITY_API.replace(MetricNames.TAG_NAME, "_noticeNetworkFailure"));
        float f11 = (float) (j12 - j11);
        if (!checkNegative((int) f11, "_noticeNetworkFailure: the startTimeMs is later than the endTimeMs, resulting in a negative total time.")) {
            float f12 = f11 / 1000.0f;
            HashMap hashMap = r0;
            HashMap hashMap2 = new HashMap();
            hashMap2.put(Constants.Transactions.CONTENT_LENGTH, "0");
            hashMap2.put("content_type", NetworkLog.HTML);
            TaskQueue.queue(new HttpTransactionMeasurement(new TransactionData(str, str2, Agent.getActiveNetworkCarrier(), f12, NetworkFailure.Unknown.getErrorCode(), networkFailure.getErrorCode(), 0, 0, (String) null, Agent.getActiveNetworkWanType(), (TraceContext) null, str3, hashMap, map)));
        }
    }

    public static void noticeHttpTransaction(String str, String str2, int i11, long j11, long j12, long j13, long j14, String str3, Map<String, String> map, String str4, Map<String, Object> map2) {
        String str5 = str;
        checkEmpty(str5, "noticeHttpTransaction: url must not be empty.");
        checkEmpty(str2, "noticeHttpTransaction: httpMethod must not be empty.");
        try {
            new URL(str5);
            float f11 = (float) (j12 - j11);
            if (!checkNegative((int) f11, "noticeHttpTransaction: the startTimeMs is later than the endTimeMs, resulting in a negative total time.")) {
                String str6 = str;
                String str7 = str2;
                TransactionData transactionData = r0;
                TransactionData transactionData2 = new TransactionData(str6, str7, Agent.getActiveNetworkCarrier(), (float) (((double) f11) / 1000.0d), i11, 0, j13, j14, str4, Agent.getActiveNetworkWanType(), (TraceContext) null, str3, map, map2);
                TaskQueue.queue(new HttpTransactionMeasurement(transactionData));
            }
        } catch (MalformedURLException unused) {
            throw new IllegalArgumentException("noticeHttpTransaction: URL is malformed: " + str5);
        }
    }
}
