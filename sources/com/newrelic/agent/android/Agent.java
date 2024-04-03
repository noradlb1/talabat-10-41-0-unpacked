package com.newrelic.agent.android;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Encoder;
import java.lang.reflect.Field;
import java.util.List;

public class Agent {
    public static final String DEFAULT_BUILD_ID = "";
    public static final String MONO_INSTRUMENTATION_FLAG = "NO";
    private static final AgentImpl NULL_AGENT_IMPL;
    public static final String VERSION = "7.2.1";
    private static String buildId = null;
    private static AgentImpl impl;
    private static Object implLock = new Object();

    static {
        NullAgentImpl nullAgentImpl = new NullAgentImpl();
        NULL_AGENT_IMPL = nullAgentImpl;
        impl = nullAgentImpl;
    }

    public static void addTransactionData(TransactionData transactionData) {
        getImpl().addTransactionData(transactionData);
    }

    public static void disable() {
        getImpl().disable();
    }

    public static String getActiveNetworkCarrier() {
        return getImpl().getNetworkCarrier();
    }

    public static String getActiveNetworkWanType() {
        return getImpl().getNetworkWanType();
    }

    public static List<TransactionData> getAndClearTransactionData() {
        return getImpl().getAndClearTransactionData();
    }

    public static ApplicationInformation getApplicationInformation() {
        return getImpl().getApplicationInformation();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.newrelic.agent.android.logging.AgentLogManager.getAgentLog().error("Agent.getBuildId() was unable to find a valid build Id. Crashes and handled exceptions will not be accepted.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getBuildId() {
        /*
            java.lang.Object r0 = implLock
            monitor-enter(r0)
            java.lang.String r1 = buildId     // Catch:{ all -> 0x0043 }
            if (r1 != 0) goto L_0x003f
            java.lang.String r1 = ""
            java.lang.String r2 = getMonoInstrumentationFlag()     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "YES"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0043 }
            if (r2 == 0) goto L_0x0018
            java.lang.String r1 = ""
            goto L_0x003d
        L_0x0018:
            java.lang.Class<com.newrelic.agent.android.Agent> r2 = com.newrelic.agent.android.Agent.class
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = "com.newrelic.agent.android.NewRelicConfig"
            java.lang.Class r2 = r2.loadClass(r3)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = "BUILD_ID"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0034 }
            r3 = 0
            java.lang.Object r2 = r2.get(r3)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0034 }
            goto L_0x003d
        L_0x0034:
            com.newrelic.agent.android.logging.AgentLog r2 = com.newrelic.agent.android.logging.AgentLogManager.getAgentLog()     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "Agent.getBuildId() was unable to find a valid build Id. Crashes and handled exceptions will not be accepted."
            r2.error(r3)     // Catch:{ all -> 0x0043 }
        L_0x003d:
            buildId = r1     // Catch:{ all -> 0x0043 }
        L_0x003f:
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = buildId
            return r0
        L_0x0043:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0043 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.Agent.getBuildId():java.lang.String");
    }

    public static String getCrossProcessId() {
        return getImpl().getCrossProcessId();
    }

    public static DeviceInformation getDeviceInformation() {
        return getImpl().getDeviceInformation();
    }

    public static Encoder getEncoder() {
        return getImpl().getEncoder();
    }

    public static AgentImpl getImpl() {
        AgentImpl agentImpl;
        synchronized (implLock) {
            agentImpl = impl;
        }
        return agentImpl;
    }

    public static boolean getIsObfuscated() {
        boolean z11 = false;
        try {
            Field declaredField = Agent.class.getClassLoader().loadClass("com.newrelic.agent.android.NewRelicConfig").getDeclaredField("OBFUSCATED");
            declaredField.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredField.get((Object) null)).booleanValue();
            try {
                declaredField.setAccessible(false);
                return booleanValue;
            } catch (Exception unused) {
                z11 = booleanValue;
            }
        } catch (Exception unused2) {
            AgentLogManager.getAgentLog().error("Unable to get obfuscated flag in crash");
            return z11;
        }
    }

    public static String getMonoInstrumentationFlag() {
        return MONO_INSTRUMENTATION_FLAG;
    }

    public static int getResponseBodyLimit() {
        return getImpl().getResponseBodyLimit();
    }

    public static int getStackTraceLimit() {
        return getImpl().getStackTraceLimit();
    }

    public static String getVersion() {
        return VERSION;
    }

    public static boolean hasReachableNetworkConnection(String str) {
        return getImpl().hasReachableNetworkConnection(str);
    }

    public static boolean isDisabled() {
        return getImpl().isDisabled();
    }

    public static boolean isInstantApp() {
        return getImpl().isInstantApp();
    }

    public static void mergeTransactionData(List<TransactionData> list) {
        getImpl().mergeTransactionData(list);
    }

    public static void setImpl(AgentImpl agentImpl) {
        synchronized (implLock) {
            if (agentImpl == null) {
                impl = NULL_AGENT_IMPL;
            } else {
                impl = agentImpl;
            }
        }
    }

    public static void setLocation(String str, String str2) {
        getImpl().setLocation(str, str2);
    }

    public static void start() {
        getImpl().start();
    }

    public static void stop() {
        getImpl().stop();
    }
}
