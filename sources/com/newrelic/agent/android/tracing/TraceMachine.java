package com.newrelic.agent.android.tracing;

import com.facebook.internal.security.CertificateUtil;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.Measurements;
import com.newrelic.agent.android.TaskQueue;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.api.v2.TraceMachineInterface;
import com.newrelic.agent.android.harvest.ActivityHistory;
import com.newrelic.agent.android.harvest.ActivitySighting;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import com.newrelic.agent.android.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TraceMachine extends HarvestAdapter {
    public static final String ACTIVITY_BACKGROUND_METRIC_PREFIX = "Mobile/Activity/Background/Name/";
    public static final String ACTIVITY_METRIC_PREFIX = "Mobile/Activity/Name/";
    public static final String ACTIVTY_DISPLAY_NAME_PREFIX = "Display ";
    public static int HEALTHY_TRACE_TIMEOUT = 500;
    public static final String NR_TRACE_FIELD = "_nr_trace";
    public static final String NR_TRACE_TYPE = "Lcom/newrelic/agent/android/tracing/Trace;";
    private static final Object TRACE_MACHINE_LOCK = new Object();
    public static int UNHEALTHY_TRACE_TIMEOUT = 60000;
    private static final List<ActivitySighting> activityHistory = new CopyOnWriteArrayList();
    public static final AtomicBoolean enabled = new AtomicBoolean(true);
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private static final ThreadLocal<Trace> threadLocalTrace = new ThreadLocal<>();
    private static final ThreadLocal<TraceStack> threadLocalTraceStack = new ThreadLocal<>();
    private static final Collection<TraceLifecycleAware> traceListeners = new CopyOnWriteArrayList();
    private static TraceMachine traceMachine = null;
    private static TraceMachineInterface traceMachineInterface;
    private ActivityTrace activityTrace;

    public static class TraceStack extends Stack<Trace> {
        private TraceStack() {
        }
    }

    public TraceMachine(Trace trace) {
        this.activityTrace = new ActivityTrace(trace);
        Harvest.addHarvestListener(this);
    }

    public static void addTraceListener(TraceLifecycleAware traceLifecycleAware) {
        traceListeners.add(traceLifecycleAware);
    }

    public static void clearActivityHistory() {
        activityHistory.clear();
    }

    public static void endLastActivitySighting() {
        ActivitySighting lastActivitySighting = getLastActivitySighting();
        if (lastActivitySighting != null) {
            lastActivitySighting.end(System.currentTimeMillis());
        }
    }

    public static void endTrace() {
        if (isTracingActive()) {
            traceMachine.completeActivityTrace();
        } else {
            log.debug("Attempted to end trace with no trace machine!");
        }
    }

    public static void enterMethod(String str) {
        enterMethod((Trace) null, str, (ArrayList<String>) null);
    }

    public static void enterNetworkSegment(String str) {
        try {
            if (!isTracingInactive()) {
                TraceType type = getCurrentTrace().getType();
                TraceType traceType = TraceType.NETWORK;
                if (type == traceType) {
                    exitMethod();
                }
                enterMethod((Trace) null, str, (ArrayList<String>) null);
                getCurrentTrace().setType(traceType);
            }
        } catch (TracingInactiveException unused) {
        } catch (Exception e11) {
            log.error("Caught error while calling enterNetworkSegment()", e11);
            AgentHealth.noticeException(e11);
        }
    }

    public static void exitMethod() {
        TraceMachineInterface traceMachineInterface2;
        try {
            if (!isTracingInactive()) {
                Trace trace = threadLocalTrace.get();
                if (trace == null) {
                    log.debug("threadLocalTrace is null");
                    return;
                }
                trace.exitTimestamp = System.currentTimeMillis();
                if (trace.threadId == 0 && (traceMachineInterface2 = traceMachineInterface) != null) {
                    trace.threadId = traceMachineInterface2.getCurrentThreadId();
                    trace.threadName = traceMachineInterface.getCurrentThreadName();
                }
                for (TraceLifecycleAware onExitMethod : traceListeners) {
                    onExitMethod.onExitMethod();
                }
                try {
                    trace.complete();
                    ThreadLocal<TraceStack> threadLocal = threadLocalTraceStack;
                    threadLocal.get().pop();
                    if (threadLocal.get().empty()) {
                        threadLocalTrace.set((Object) null);
                    } else {
                        Trace trace2 = (Trace) threadLocal.get().peek();
                        threadLocalTrace.set(trace2);
                        trace2.childExclusiveTime += trace.getDurationAsMilliseconds();
                    }
                    if (trace.getType() == TraceType.TRACE) {
                        TaskQueue.queue(trace);
                    }
                } catch (TracingInactiveException unused) {
                    threadLocalTrace.remove();
                    threadLocalTraceStack.remove();
                    if (trace.getType() == TraceType.TRACE) {
                        TaskQueue.queue(trace);
                    }
                }
            }
        } catch (Exception e11) {
            log.error("Caught error while calling exitMethod()", e11);
            AgentHealth.noticeException(e11);
        }
    }

    public static String formatActivityBackgroundMetricName(String str) {
        return ACTIVITY_BACKGROUND_METRIC_PREFIX + str;
    }

    public static String formatActivityDisplayName(String str) {
        return ACTIVTY_DISPLAY_NAME_PREFIX + str;
    }

    public static String formatActivityMetricName(String str) {
        return ACTIVITY_METRIC_PREFIX + str;
    }

    public static ActivityHistory getActivityHistory() {
        return new ActivityHistory(activityHistory);
    }

    public static ActivityTrace getActivityTrace() throws TracingInactiveException {
        try {
            return traceMachine.activityTrace;
        } catch (NullPointerException unused) {
            throw new TracingInactiveException();
        }
    }

    public static String getCurrentScope() {
        try {
            if (isTracingInactive()) {
                return null;
            }
            TraceMachineInterface traceMachineInterface2 = traceMachineInterface;
            if (traceMachineInterface2 != null) {
                if (!traceMachineInterface2.isUIThread()) {
                    return traceMachine.activityTrace.rootTrace.metricBackgroundName;
                }
            }
            return traceMachine.activityTrace.rootTrace.metricName;
        } catch (Exception e11) {
            log.error("Caught error while calling getCurrentScope()", e11);
            AgentHealth.noticeException(e11);
            return null;
        }
    }

    public static Trace getCurrentTrace() throws TracingInactiveException {
        if (!isTracingInactive()) {
            Trace trace = threadLocalTrace.get();
            if (trace != null) {
                return trace;
            }
            return getRootTrace();
        }
        throw new TracingInactiveException();
    }

    public static Map<String, Object> getCurrentTraceParams() throws TracingInactiveException {
        return getCurrentTrace().getParams();
    }

    public static ActivitySighting getLastActivitySighting() {
        List<ActivitySighting> list = activityHistory;
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static Trace getRootTrace() throws TracingInactiveException {
        try {
            return traceMachine.activityTrace.rootTrace;
        } catch (NullPointerException unused) {
            throw new TracingInactiveException();
        }
    }

    public static TraceMachine getTraceMachine() {
        return traceMachine;
    }

    public static void haltTracing() {
        synchronized (TRACE_MACHINE_LOCK) {
            if (!isTracingInactive()) {
                TraceMachine traceMachine2 = traceMachine;
                traceMachine = null;
                traceMachine2.activityTrace.discard();
                endLastActivitySighting();
                Harvest.removeHarvestListener(traceMachine2);
                threadLocalTrace.remove();
                threadLocalTraceStack.remove();
            }
        }
    }

    public static boolean isEnabled() {
        return enabled.get() && FeatureFlag.featureEnabled(FeatureFlag.InteractionTracing);
    }

    public static boolean isTracingActive() {
        return traceMachine != null;
    }

    public static boolean isTracingInactive() {
        return !isTracingActive();
    }

    private static void loadTraceContext(Trace trace) {
        if (!isTracingInactive()) {
            ThreadLocal<Trace> threadLocal = threadLocalTrace;
            if (threadLocal.get() == null) {
                threadLocal.set(trace);
                ThreadLocal<TraceStack> threadLocal2 = threadLocalTraceStack;
                threadLocal2.set(new TraceStack());
                if (trace != null) {
                    threadLocal2.get().push(trace);
                } else {
                    return;
                }
            } else if (trace == null) {
                ThreadLocal<TraceStack> threadLocal3 = threadLocalTraceStack;
                if (threadLocal3.get().isEmpty()) {
                    log.debug("No context to load!");
                    threadLocal.set((Object) null);
                    return;
                }
                trace = (Trace) threadLocal3.get().peek();
                threadLocal.set(trace);
            }
            AgentLog agentLog = log;
            String uuid = trace.myUUID.toString();
            agentLog.verbose("Trace " + uuid + " is now active");
        }
    }

    private static void pushTraceContext(Trace trace) {
        if (!isTracingInactive() && trace != null) {
            TraceStack traceStack = threadLocalTraceStack.get();
            if (traceStack.empty()) {
                traceStack.push(trace);
            } else if (traceStack.peek() != trace) {
                traceStack.push(trace);
            }
            threadLocalTrace.set(trace);
        }
    }

    private static Trace registerNewTrace(String str) throws TracingInactiveException {
        if (!isTracingInactive()) {
            Trace currentTrace = getCurrentTrace();
            Trace trace = new Trace(str, currentTrace.myUUID, traceMachine);
            try {
                traceMachine.activityTrace.addTrace(trace);
                AgentLog agentLog = log;
                String str2 = currentTrace.displayName;
                agentLog.verbose("Registering trace of " + str + " with parent " + str2);
                currentTrace.addChild(trace);
                return trace;
            } catch (Exception unused) {
                throw new TracingInactiveException();
            }
        } else {
            log.debug("Tried to register a new trace but tracing is inactive!");
            throw new TracingInactiveException();
        }
    }

    public static void removeTraceListener(TraceLifecycleAware traceLifecycleAware) {
        traceListeners.remove(traceLifecycleAware);
    }

    private static void renameActivityHistory(String str, String str2) {
        for (ActivitySighting next : activityHistory) {
            if (next.getName().equals(str)) {
                next.setName(str2);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:14|15|16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0049 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void setCurrentDisplayName(java.lang.String r5) {
        /*
            java.lang.Object r0 = TRACE_MACHINE_LOCK
            monitor-enter(r0)
            com.newrelic.agent.android.tracing.TraceMachine r1 = getTraceMachine()     // Catch:{ all -> 0x004d }
            traceMachine = r1     // Catch:{ all -> 0x004d }
            if (r1 == 0) goto L_0x004b
            com.newrelic.agent.android.tracing.Trace r1 = getCurrentTrace()     // Catch:{ TracingInactiveException -> 0x0049 }
            if (r1 == 0) goto L_0x004b
            r1.displayName = r5     // Catch:{ TracingInactiveException -> 0x0049 }
            java.util.Collection<com.newrelic.agent.android.tracing.TraceLifecycleAware> r5 = traceListeners     // Catch:{ TracingInactiveException -> 0x0049 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ TracingInactiveException -> 0x0049 }
        L_0x0019:
            boolean r1 = r5.hasNext()     // Catch:{ TracingInactiveException -> 0x0049 }
            if (r1 == 0) goto L_0x004b
            java.lang.Object r1 = r5.next()     // Catch:{ TracingInactiveException -> 0x0049 }
            com.newrelic.agent.android.tracing.TraceLifecycleAware r1 = (com.newrelic.agent.android.tracing.TraceLifecycleAware) r1     // Catch:{ TracingInactiveException -> 0x0049 }
            com.newrelic.agent.android.tracing.TraceMachine r2 = traceMachine     // Catch:{ Exception -> 0x002d }
            com.newrelic.agent.android.tracing.ActivityTrace r2 = r2.activityTrace     // Catch:{ Exception -> 0x002d }
            r1.onTraceRename(r2)     // Catch:{ Exception -> 0x002d }
            goto L_0x0019
        L_0x002d:
            r1 = move-exception
            com.newrelic.agent.android.logging.AgentLog r2 = log     // Catch:{ TracingInactiveException -> 0x0049 }
            java.lang.String r1 = r1.toString()     // Catch:{ TracingInactiveException -> 0x0049 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ TracingInactiveException -> 0x0049 }
            r3.<init>()     // Catch:{ TracingInactiveException -> 0x0049 }
            java.lang.String r4 = "Cannot name trace. Tracing is not available: "
            r3.append(r4)     // Catch:{ TracingInactiveException -> 0x0049 }
            r3.append(r1)     // Catch:{ TracingInactiveException -> 0x0049 }
            java.lang.String r1 = r3.toString()     // Catch:{ TracingInactiveException -> 0x0049 }
            r2.error(r1)     // Catch:{ TracingInactiveException -> 0x0049 }
            goto L_0x0019
        L_0x0049:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.newrelic.agent.android.tracing.TraceMachine.setCurrentDisplayName(java.lang.String):void");
    }

    public static void setCurrentTraceParam(String str, Object obj) {
        if (!isTracingInactive()) {
            try {
                Trace currentTrace = getCurrentTrace();
                if (currentTrace == null) {
                    throw new TracingInactiveException();
                } else if (str == null) {
                    log.error("Cannot set current trace param: key is null");
                } else if (obj == null) {
                    log.error("Cannot set current trace param: value is null");
                } else {
                    currentTrace.getParams().put(str, obj);
                }
            } catch (TracingInactiveException unused) {
            }
        }
    }

    public static void setRootDisplayName(String str) {
        if (!isTracingInactive()) {
            try {
                Trace rootTrace = getRootTrace();
                Measurements.renameActivity(rootTrace.displayName, str);
                renameActivityHistory(rootTrace.displayName, str);
                rootTrace.metricName = formatActivityMetricName(str);
                rootTrace.metricBackgroundName = formatActivityBackgroundMetricName(str);
                rootTrace.displayName = str;
                getCurrentTrace().scope = getCurrentScope();
            } catch (TracingInactiveException unused) {
            }
        }
    }

    public static void setTraceMachineInterface(TraceMachineInterface traceMachineInterface2) {
        traceMachineInterface = traceMachineInterface2;
    }

    public static void startTracing(String str) {
        startTracing(str, false);
    }

    public static void unloadTraceContext(Object obj) {
        try {
            if (!isTracingInactive()) {
                TraceMachineInterface traceMachineInterface2 = traceMachineInterface;
                if (traceMachineInterface2 == null || !traceMachineInterface2.isUIThread()) {
                    ThreadLocal<Trace> threadLocal = threadLocalTrace;
                    if (threadLocal.get() != null) {
                        AgentLog agentLog = log;
                        String uuid = threadLocal.get().myUUID.toString();
                        agentLog.verbose("Trace " + uuid + " is now inactive");
                    }
                    threadLocal.remove();
                    threadLocalTraceStack.remove();
                    try {
                        ((TraceFieldInterface) obj)._nr_setTrace((Trace) null);
                    } catch (ClassCastException e11) {
                        ExceptionHelper.recordSupportabilityMetric(e11, "TraceFieldInterface");
                        AgentLog agentLog2 = log;
                        String message = e11.getMessage();
                        agentLog2.error("Not a TraceFieldInterface: " + message);
                    }
                }
            }
        } catch (Exception e12) {
            log.error("Caught error while calling unloadTraceContext()", e12);
            AgentHealth.noticeException(e12);
        }
    }

    public void completeActivityTrace() {
        synchronized (TRACE_MACHINE_LOCK) {
            if (!isTracingInactive()) {
                TraceMachine traceMachine2 = traceMachine;
                traceMachine = null;
                traceMachine2.activityTrace.complete();
                endLastActivitySighting();
                for (TraceLifecycleAware onTraceComplete : traceListeners) {
                    onTraceComplete.onTraceComplete(traceMachine2.activityTrace);
                }
                Harvest.removeHarvestListener(traceMachine2);
            }
        }
    }

    public void onHarvestBefore() {
        if (isTracingActive()) {
            long currentTimeMillis = System.currentTimeMillis();
            ActivityTrace activityTrace2 = traceMachine.activityTrace;
            long j11 = activityTrace2.lastUpdatedAt;
            long j12 = activityTrace2.startedAt;
            if (j11 + ((long) HEALTHY_TRACE_TIMEOUT) >= currentTimeMillis || activityTrace2.hasMissingChildren()) {
                int i11 = UNHEALTHY_TRACE_TIMEOUT;
                if (j12 + ((long) i11) < currentTimeMillis) {
                    AgentLog agentLog = log;
                    agentLog.debug("Completing activity trace after hitting unhealthy timeout (" + i11 + "ms)");
                    completeActivityTrace();
                    StatsEngine.get().inc(MetricNames.SUPPORTABILITY_TRACES_UNHEALTHY);
                    return;
                }
                return;
            }
            AgentLog agentLog2 = log;
            int i12 = HEALTHY_TRACE_TIMEOUT;
            agentLog2.debug("Completing activity trace after hitting healthy timeout (" + i12 + "ms)");
            completeActivityTrace();
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_TRACES_HEALTHY);
            return;
        }
        log.debug("TraceMachine is inactive");
    }

    public void onHarvestSendFailed() {
        try {
            traceMachine.activityTrace.incrementReportAttemptCount();
        } catch (NullPointerException unused) {
        }
    }

    public void storeCompletedTrace(Trace trace) {
        try {
            if (isTracingInactive()) {
                log.debug("Attempted to store a completed trace with no trace machine!");
            } else {
                this.activityTrace.addCompletedTrace(trace);
            }
        } catch (Exception e11) {
            log.error("Caught error while calling storeCompletedTrace()", e11);
            AgentHealth.noticeException(e11);
        }
    }

    public static void enterMethod(String str, ArrayList<String> arrayList) {
        enterMethod((Trace) null, str, arrayList);
    }

    public static void startTracing(String str, boolean z11) {
        startTracing(str, z11, false);
    }

    public static void enterMethod(Trace trace, String str, ArrayList<String> arrayList) {
        try {
            if (!isTracingInactive()) {
                long currentTimeMillis = System.currentTimeMillis();
                ActivityTrace activityTrace2 = traceMachine.activityTrace;
                long j11 = activityTrace2.lastUpdatedAt;
                long j12 = activityTrace2.startedAt;
                if (((long) HEALTHY_TRACE_TIMEOUT) + j11 < currentTimeMillis) {
                    if (!activityTrace2.hasMissingChildren()) {
                        AgentLog agentLog = log;
                        agentLog.debug(String.format("LastUpdated[%d] CurrentTime[%d] Trigger[%d]", new Object[]{Long.valueOf(j11), Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis - j11)}));
                        int i11 = HEALTHY_TRACE_TIMEOUT;
                        agentLog.debug("Completing activity trace after hitting healthy timeout (" + i11 + "ms)");
                        if (isTracingActive()) {
                            traceMachine.completeActivityTrace();
                            return;
                        }
                        return;
                    }
                }
                int i12 = UNHEALTHY_TRACE_TIMEOUT;
                if (j12 + ((long) i12) < currentTimeMillis) {
                    AgentLog agentLog2 = log;
                    agentLog2.debug("Completing activity trace after hitting unhealthy timeout (" + i12 + "ms)");
                    if (isTracingActive()) {
                        traceMachine.completeActivityTrace();
                        return;
                    }
                    return;
                }
                loadTraceContext(trace);
                Trace registerNewTrace = registerNewTrace(str);
                pushTraceContext(registerNewTrace);
                registerNewTrace.scope = getCurrentScope();
                registerNewTrace.setAnnotationParams(arrayList);
                for (TraceLifecycleAware onEnterMethod : traceListeners) {
                    onEnterMethod.onEnterMethod();
                }
                registerNewTrace.entryTimestamp = System.currentTimeMillis();
            }
        } catch (TracingInactiveException unused) {
        } catch (Exception e11) {
            log.error("Caught error while calling enterMethod()", e11);
            AgentHealth.noticeException(e11);
        }
    }

    public static void startTracing(String str, boolean z11, boolean z12) {
        try {
            if (isEnabled()) {
                if ((z12 || FeatureFlag.featureEnabled(FeatureFlag.DefaultInteractions)) && Harvest.shouldCollectActivityTraces()) {
                    synchronized (TRACE_MACHINE_LOCK) {
                        if (isTracingActive()) {
                            traceMachine.completeActivityTrace();
                        }
                        threadLocalTrace.remove();
                        threadLocalTraceStack.set(new TraceStack());
                        Trace trace = new Trace();
                        if (z11) {
                            trace.displayName = str;
                        } else {
                            trace.displayName = formatActivityDisplayName(str);
                        }
                        trace.metricName = formatActivityMetricName(trace.displayName);
                        trace.metricBackgroundName = formatActivityBackgroundMetricName(trace.displayName);
                        trace.entryTimestamp = System.currentTimeMillis();
                        AgentLog agentLog = log;
                        String uuid = trace.myUUID.toString();
                        agentLog.debug("Started trace of " + str + CertificateUtil.DELIMITER + uuid);
                        TraceMachine traceMachine2 = new TraceMachine(trace);
                        traceMachine = traceMachine2;
                        trace.traceMachine = traceMachine2;
                        pushTraceContext(trace);
                        traceMachine.activityTrace.previousActivity = getLastActivitySighting();
                        activityHistory.add(new ActivitySighting(trace.entryTimestamp, trace.displayName));
                        for (TraceLifecycleAware onTraceStart : traceListeners) {
                            onTraceStart.onTraceStart(traceMachine.activityTrace);
                        }
                    }
                }
            }
        } catch (Exception e11) {
            log.error("Caught error while initializing TraceMachine, shutting it down", e11);
            AgentHealth.noticeException(e11);
            traceMachine = null;
            threadLocalTrace.remove();
            threadLocalTraceStack.remove();
        }
    }

    public static void endTrace(String str) {
        try {
            if (getActivityTrace().rootTrace.myUUID.toString().equals(str) && isTracingActive()) {
                traceMachine.completeActivityTrace();
            }
        } catch (TracingInactiveException unused) {
        }
    }
}
