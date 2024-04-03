package com.newrelic.agent.android.agentdata;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.agentdata.builder.AgentDataBuilder;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.crash.Crash;
import com.newrelic.agent.android.harvest.crash.ApplicationInfo;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.ExceptionHelper;
import com.newrelic.com.google.flatbuffers.FlatBufferBuilder;
import com.newrelic.mobile.fbs.HexAgentDataBundle;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AgentDataController {
    protected static final AgentConfiguration agentConfiguration = new AgentConfiguration();
    private static final AgentLog log = AgentLogManager.getAgentLog();

    /* renamed from: com.newrelic.agent.android.agentdata.AgentDataController$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType[] r0 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType = r0
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.STRING     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.DOUBLE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.newrelic.agent.android.analytics.AnalyticsAttribute$AttributeDataType r1 = com.newrelic.agent.android.analytics.AnalyticsAttribute.AttributeDataType.BOOLEAN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.agentdata.AgentDataController.AnonymousClass1.<clinit>():void");
        }
    }

    public static FlatBufferBuilder buildAgentDataFromHandledException(Throwable th2, Map<String, Object> map) {
        UUID uuid;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ApplicationInfo applicationInfo = new ApplicationInfo(Agent.getApplicationInformation());
        try {
            uuid = UUID.fromString(Crash.getSafeBuildId());
        } catch (IllegalArgumentException e11) {
            UUID randomUUID = UUID.randomUUID();
            ExceptionHelper.recordSupportabilityMetric(e11, "RandomUUID");
            uuid = randomUUID;
        }
        hashMap.put(HexAttribute.HEX_ATTR_APP_UUID_HI, Long.valueOf(uuid.getLeastSignificantBits()));
        hashMap.put(HexAttribute.HEX_ATTR_APP_UUID_LO, Long.valueOf(uuid.getMostSignificantBits()));
        hashMap.put("appVersion", applicationInfo.getApplicationVersion());
        hashMap.put("appBuild", applicationInfo.getApplicationBuild());
        hashMap.put("sessionId", agentConfiguration.getSessionID());
        hashMap.put(HexAttribute.HEX_ATTR_TIMESTAMP_MS, Long.valueOf(System.currentTimeMillis()));
        hashMap.put("message", th2.getMessage());
        hashMap.put(HexAttribute.HEX_ATTR_CAUSE, getRootCause(th2).toString());
        hashMap.put("name", th2.getClass().toString());
        hashMap.put("thread", threadSetFromStackElements(th2.getStackTrace()));
        hashMap.putAll(map);
        for (AnalyticsAttribute next : AnalyticsControllerImpl.getInstance().getSessionAttributes()) {
            int i11 = AnonymousClass1.$SwitchMap$com$newrelic$agent$android$analytics$AnalyticsAttribute$AttributeDataType[next.getAttributeDataType().ordinal()];
            if (i11 == 1) {
                hashMap2.put(next.getName(), next.getStringValue());
            } else if (i11 == 2) {
                hashMap2.put(next.getName(), Double.valueOf(next.getDoubleValue()));
            } else if (i11 == 3) {
                hashMap2.put(next.getName(), Boolean.valueOf(next.getBooleanValue()));
            }
        }
        long sessionDurationMillis = Agent.getImpl().getSessionDurationMillis();
        if (0 == sessionDurationMillis) {
            log.error("Harvest instance is not running! Session duration will be invalid");
        } else {
            hashMap2.put(AnalyticsAttribute.SESSION_TIME_SINCE_LOAD_ATTRIBUTE, Float.valueOf(((float) sessionDurationMillis) / 1000.0f));
        }
        hashMap2.put("obfuscated", Boolean.valueOf(Agent.getIsObfuscated()));
        hashMap2.putAll(map);
        HashSet hashSet = new HashSet();
        hashSet.add(hashMap);
        return AgentDataBuilder.startAndFinishAgentData(hashMap2, hashSet);
    }

    public static Throwable getRootCause(Throwable th2) {
        if (th2 == null) {
            return new Throwable("Unknown cause");
        }
        try {
            Throwable cause = th2.getCause();
            if (cause == null) {
                return th2;
            }
            return getRootCause(cause);
        } catch (Exception unused) {
            return th2;
        }
    }

    public static boolean sendAgentData(Throwable th2, Map<String, Object> map) {
        if (FeatureFlag.featureEnabled(FeatureFlag.HandledExceptions) || FeatureFlag.featureEnabled(FeatureFlag.NativeReporting)) {
            try {
                ByteBuffer slice = buildAgentDataFromHandledException(th2, map).dataBuffer().slice();
                byte[] bArr = new byte[slice.remaining()];
                slice.get(bArr);
                AgentLog agentLog = log;
                agentLog.audit(AgentDataBuilder.toJsonString(HexAgentDataBundle.getRootAsHexAgentDataBundle(ByteBuffer.wrap(bArr)), 0));
                boolean reportAgentData = AgentDataReporter.reportAgentData(bArr);
                if (!reportAgentData) {
                    String name2 = th2.getClass().getName();
                    agentLog.error("HandledException: exception " + name2 + " failed to record data.");
                }
                return reportAgentData;
            } catch (Exception unused) {
                AgentLog agentLog2 = log;
                String name3 = th2.getClass().getName();
                agentLog2.error("HandledException: exception " + name3 + " failed to record data.");
            }
        }
        return false;
    }

    public static List<Map<String, Object>> threadSetFromStackElements(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(HexAttribute.HEX_ATTR_CLASS_NAME, stackTraceElement.getClassName());
            linkedHashMap.put(HexAttribute.HEX_ATTR_METHOD_NAME, stackTraceElement.getMethodName());
            linkedHashMap.put("lineNumber", Integer.valueOf(stackTraceElement.getLineNumber()));
            linkedHashMap.put("fileName", stackTraceElement.getFileName());
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    public static FlatBufferBuilder buildAgentDataFromHandledException(Throwable th2) {
        return buildAgentDataFromHandledException(th2, new HashMap());
    }
}
