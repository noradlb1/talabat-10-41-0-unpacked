package com.newrelic.agent.android.ndk;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.NewRelic;
import com.newrelic.agent.android.agentdata.AgentDataController;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.crash.CrashReporter;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.harvest.HarvestAdapter;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.ndk.AgentNDK;
import com.newrelic.agent.android.stats.StatsEngine;
import i.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;

public class NativeReporting extends HarvestAdapter implements AgentNDKListener {
    protected static AtomicReference<NativeReporting> instance = new AtomicReference<>((Object) null);
    protected static final AgentLog log = AgentLogManager.getAgentLog();

    public static class ANRException extends NativeException {
        public ANRException(String str) {
            super(str);
        }
    }

    public static class NativeCrashException extends NativeException {
        public NativeCrashException(String str) {
            super(str);
        }
    }

    public static class NativeUnhandledException extends NativeException {
        public NativeUnhandledException(String str) {
            super(str);
        }
    }

    public NativeReporting(Context context, AgentConfiguration agentConfiguration) {
        new AgentNDK.Builder(context).withBuildId(Agent.getBuildId()).withSessionId(agentConfiguration.getSessionID()).withReportListener(this).withLogger(log).build();
    }

    public static void crashNow(String str) {
        if (isInitialized()) {
            AgentNDK.getInstance().crashNow(str);
        }
    }

    public static NativeReporting getInstance() {
        return instance.get();
    }

    public static NativeReporting initialize(Context context, AgentConfiguration agentConfiguration) {
        b.a(instance, (Object) null, new NativeReporting(context, agentConfiguration));
        Harvest.addHarvestListener(instance.get());
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_INIT);
        return instance.get();
    }

    public static boolean isInitialized() {
        return (instance.get() == null || AgentNDK.getInstance() == null) ? false : true;
    }

    public static boolean isRooted() {
        if (!isInitialized()) {
            return false;
        }
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_ROOTED_DEVICE);
        return AgentNDK.getInstance().isRooted();
    }

    public static void shutdown() {
        if (isInitialized()) {
            Harvest.removeHarvestListener(instance.get());
            instance.get().stop();
        }
        instance.set((Object) null);
    }

    public boolean onApplicationNotResponding(String str) {
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_ANR);
        AnonymousClass3 r02 = new HashMap<String, Object>() {
            {
                put("platform", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
                put(AnalyticsAttribute.ANR, Boolean.TRUE);
            }
        };
        NativeException aNRException = new ANRException(str);
        r02.put("crashingThreadId", Long.valueOf(aNRException.getNativeStackTrace().getCrashedThread().getThreadId()));
        r02.put("nativeThreads", aNRException.getNativeStackTrace().getThreads());
        r02.put("exceptionMessage", aNRException.getNativeStackTrace().getExceptionMessage());
        return AgentDataController.sendAgentData(aNRException, r02);
    }

    public void onHarvestStart() {
        AgentNDK.getInstance().flushPendingReports();
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_FLUSH);
    }

    public boolean onNativeCrash(String str) {
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_CRASH);
        AnalyticsControllerImpl instance2 = AnalyticsControllerImpl.getInstance();
        AnonymousClass1 r12 = new HashSet<AnalyticsAttribute>(instance2) {
            final /* synthetic */ AnalyticsControllerImpl val$analyticsController;

            {
                this.val$analyticsController = r2;
                addAll(r2.getSessionAttributes());
            }
        };
        NativeCrashException nativeCrashException = new NativeCrashException(str);
        r12.add(new AnalyticsAttribute("platform", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE));
        r12.add(new AnalyticsAttribute(AnalyticsAttribute.NATIVE_CRASH, true));
        r12.add(new AnalyticsAttribute("exceptionMessage", nativeCrashException.getNativeStackTrace().getExceptionMessage()));
        r12.add(new AnalyticsAttribute("crashingThreadId", (double) nativeCrashException.getNativeStackTrace().getCrashedThread().getThreadId()));
        CrashReporter.getInstance().storeAndReportCrash(new NativeCrash(nativeCrashException, r12, instance2.getEventManager().getQueuedEvents()));
        return true;
    }

    public boolean onNativeException(String str) {
        StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_REPORTS_EXCEPTION);
        AnonymousClass2 r02 = new HashMap<String, Object>() {
            {
                put("platform", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE);
                put(AnalyticsAttribute.UNHANDLED_NATIVE_EXCEPTION, Boolean.TRUE);
            }
        };
        NativeException nativeUnhandledException = new NativeUnhandledException(str);
        r02.put("crashingThreadId", Long.valueOf(nativeUnhandledException.getNativeStackTrace().getCrashedThread().getThreadId()));
        r02.put("nativeThreads", nativeUnhandledException.getNativeStackTrace().getThreads());
        r02.put("exceptionMessage", nativeUnhandledException.getNativeStackTrace().getExceptionMessage());
        return AgentDataController.sendAgentData(nativeUnhandledException, r02);
    }

    public void start() {
        if (isInitialized()) {
            AgentNDK.getInstance().start();
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_START);
            boolean isRooted = isRooted();
            if (isRooted) {
                NewRelic.setAttribute("RootedDevice", isRooted);
                return;
            }
            return;
        }
        log.error("CrashReporter: Must first initialize native module.");
    }

    public void stop() {
        if (isInitialized()) {
            AgentNDK.getInstance().stop();
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_NDK_STOP);
        }
    }
}
