package com.newrelic.agent.android.distributedtracing;

import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.agentdata.AgentDataController;
import com.newrelic.agent.android.harvest.HarvestConfiguration;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

public class DistributedTracing implements TraceFacade, TraceListener {
    public static final String ACTION_TYPE_ATTRIBUTE = "actionType";
    public static final String NR_GUID_ATTRIBUTE = "guid";
    public static final String NR_ID_ATTRIBUTE = "id";
    public static final String NR_SPAN_ID_ATTRIBUTE = "span.id";
    public static final String NR_TRACE_ID_ATTRIBUTE = "trace.id";
    static final DistributedTracing instance = new DistributedTracing();
    static final AgentLog log = AgentLogManager.getAgentLog();
    AtomicReference<TraceListener> traceListener = new AtomicReference<>(this);

    public static long generateNormalizedTimestamp() {
        return System.currentTimeMillis();
    }

    public static String generateRandomBytes(int i11) {
        String str = "";
        while (str.length() < i11) {
            str = str + UUID.randomUUID().toString().replace(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "");
        }
        return str.substring(0, i11);
    }

    public static String generateSpanId() {
        return generateRandomBytes(16);
    }

    public static String generateTraceId() {
        return generateRandomBytes(32);
    }

    public static final DistributedTracing getInstance() {
        return instance;
    }

    private void invokeListeners(TraceContext traceContext) {
        try {
            traceContext.requestContext.put(NR_TRACE_ID_ATTRIBUTE, traceContext.traceId);
            instance.traceListener.get().onTraceCreated(traceContext.requestContext);
        } catch (Exception e11) {
            DistributedTracing distributedTracing = instance;
            distributedTracing.traceListener.set(distributedTracing);
            AgentLog agentLog = log;
            String localizedMessage = e11.getLocalizedMessage();
            agentLog.error("The provided listener has thrown an exception and has been removed: " + localizedMessage);
            AgentDataController.sendAgentData(e11, (Map<String, Object>) null);
        }
        try {
            traceContext.requestContext.put(NR_SPAN_ID_ATTRIBUTE, traceContext.tracePayload.getSpanId());
            instance.traceListener.get().onSpanCreated(traceContext.requestContext);
        } catch (Exception e12) {
            DistributedTracing distributedTracing2 = instance;
            distributedTracing2.traceListener.set(distributedTracing2);
            AgentLog agentLog2 = log;
            String localizedMessage2 = e12.getLocalizedMessage();
            agentLog2.error("The provided listener has thrown an exception and has been removed: " + localizedMessage2);
            AgentDataController.sendAgentData(e12, new HashMap());
        }
    }

    public static void setDistributedTraceListener(TraceListener traceListener2) {
        instance.setTraceListener(traceListener2);
    }

    public void onSpanCreated(Map<String, String> map) {
    }

    public void onTraceCreated(Map<String, String> map) {
    }

    public void setConfiguration(TraceConfiguration traceConfiguration) {
        TraceConfiguration.setInstance(traceConfiguration);
    }

    public void setTraceListener(TraceListener traceListener2) {
        if (!FeatureFlag.featureEnabled(FeatureFlag.DistributedTracing)) {
            return;
        }
        if (traceListener2 == null) {
            this.traceListener.set(this);
        } else {
            this.traceListener.set(traceListener2);
        }
    }

    public TraceContext startTrace(TransactionState transactionState) {
        TraceContext createTraceContext = TraceContext.createTraceContext(new HashMap<String, String>(transactionState) {
            final /* synthetic */ TransactionState val$transactionState;

            {
                this.val$transactionState = r3;
                put("url", r3.getUrl());
                put("httpMethod", r3.getHttpMethod());
                put("thread.id", Long.toString(Thread.currentThread().getId()));
            }
        });
        invokeListeners(createTraceContext);
        return createTraceContext;
    }

    public void setConfiguration(HarvestConfiguration harvestConfiguration) {
        TraceConfiguration.getInstance().setConfiguration(harvestConfiguration);
    }
}
