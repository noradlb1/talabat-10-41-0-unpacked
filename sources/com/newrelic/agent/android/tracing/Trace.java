package com.newrelic.agent.android.tracing;

import com.newrelic.agent.android.instrumentation.MetricCategory;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.Util;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Trace {
    private static final String CATEGORY_PARAMETER = "category";
    private static final AgentLog log = AgentLogManager.getAgentLog();
    public long childExclusiveTime;
    private volatile Set<UUID> children;
    public String displayName;
    public long entryTimestamp;
    public long exclusiveTime;
    public long exitTimestamp;
    private boolean isComplete;
    public String metricBackgroundName;
    public String metricName;
    public final UUID myUUID;
    private volatile Map<String, Object> params;
    public final UUID parentUUID;
    private List<String> rawAnnotationParams;
    public String scope;
    public long threadId;
    public String threadName;
    public TraceMachine traceMachine;
    private TraceType type;

    public Trace() {
        this.myUUID = new UUID(Util.getRandom().nextLong(), Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = "main";
        this.type = TraceType.TRACE;
        this.isComplete = false;
        this.parentUUID = null;
    }

    private static Object createParameter(String str, String str2, String str3) {
        try {
            Class<?> cls = Class.forName(str2);
            if (MetricCategory.class == cls) {
                return MetricCategory.valueOf(str3);
            }
            if (String.class == cls) {
                return str3;
            }
            return null;
        } catch (ClassNotFoundException e11) {
            AgentLog agentLog = log;
            String message = e11.getMessage();
            agentLog.error("Unable to resolve parameter class in enterMethod: " + message, e11);
            return null;
        }
    }

    public void addChild(Trace trace) {
        if (this.children == null) {
            synchronized (this) {
                if (this.children == null) {
                    this.children = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        this.children.add(trace.myUUID);
    }

    public void complete() throws TracingInactiveException {
        if (this.isComplete) {
            AgentLog agentLog = log;
            String uuid = this.myUUID.toString();
            agentLog.warn("Attempted to double complete trace " + uuid);
            return;
        }
        if (this.exitTimestamp == 0) {
            this.exitTimestamp = System.currentTimeMillis();
        }
        this.exclusiveTime = getDurationAsMilliseconds() - this.childExclusiveTime;
        this.isComplete = true;
        try {
            this.traceMachine.storeCompletedTrace(this);
        } catch (NullPointerException unused) {
            throw new TracingInactiveException();
        }
    }

    public Map<String, Object> getAnnotationParams() {
        HashMap hashMap = new HashMap();
        List<String> list = this.rawAnnotationParams;
        if (list != null && list.size() > 0) {
            Iterator<String> it = this.rawAnnotationParams.iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object createParameter = createParameter(next, it.next(), it.next());
                if (createParameter != null) {
                    hashMap.put(next, createParameter);
                }
            }
        }
        return hashMap;
    }

    public MetricCategory getCategory() {
        if (!getAnnotationParams().containsKey("category")) {
            return null;
        }
        Object obj = getAnnotationParams().get("category");
        if (obj instanceof MetricCategory) {
            return (MetricCategory) obj;
        }
        log.error("Category annotation parameter is not of type MetricCategory");
        return null;
    }

    public Set<UUID> getChildren() {
        if (this.children == null) {
            synchronized (this) {
                if (this.children == null) {
                    this.children = Collections.synchronizedSet(new HashSet());
                }
            }
        }
        return this.children;
    }

    public long getDurationAsMilliseconds() {
        return this.exitTimestamp - this.entryTimestamp;
    }

    public float getDurationAsSeconds() {
        return ((float) (this.exitTimestamp - this.entryTimestamp)) / 1000.0f;
    }

    public Map<String, Object> getParams() {
        if (this.params == null) {
            synchronized (this) {
                if (this.params == null) {
                    this.params = new ConcurrentHashMap();
                }
            }
        }
        return this.params;
    }

    public TraceType getType() {
        return this.type;
    }

    public boolean isComplete() {
        return this.isComplete;
    }

    public void prepareForSerialization() {
        getParams().put("type", this.type.toString());
    }

    public void setAnnotationParams(List<String> list) {
        this.rawAnnotationParams = list;
    }

    public void setType(TraceType traceType) {
        this.type = traceType;
    }

    public Trace(String str, UUID uuid, TraceMachine traceMachine2) {
        this.myUUID = new UUID(Util.getRandom().nextLong(), Util.getRandom().nextLong());
        this.entryTimestamp = 0;
        this.exitTimestamp = 0;
        this.exclusiveTime = 0;
        this.childExclusiveTime = 0;
        this.threadId = 0;
        this.threadName = "main";
        this.type = TraceType.TRACE;
        this.isComplete = false;
        this.displayName = str;
        this.parentUUID = uuid;
        this.traceMachine = traceMachine2;
    }
}
