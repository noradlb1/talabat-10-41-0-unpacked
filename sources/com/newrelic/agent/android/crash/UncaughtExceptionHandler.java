package com.newrelic.agent.android.crash;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.newrelic.agent.android.analytics.AnalyticsControllerImpl;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.harvest.Harvest;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.payload.PayloadController;
import com.newrelic.agent.android.stats.StatsEngine;
import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

public class UncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    protected static final AgentLog log = AgentLogManager.getAgentLog();
    static Thread.UncaughtExceptionHandler previousExceptionHandler = null;
    private final CrashReporter crashReporter;
    protected final AtomicBoolean handledException = new AtomicBoolean(false);

    public UncaughtExceptionHandler(CrashReporter crashReporter2) {
        this.crashReporter = crashReporter2;
    }

    public void chainExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Thread thread, Throwable th2) {
        if (uncaughtExceptionHandler != null) {
            AgentLog agentLog = log;
            String simpleName = uncaughtExceptionHandler.getClass().getSimpleName();
            agentLog.debug("Chaining crash reporting duties to " + simpleName);
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }

    public Thread.UncaughtExceptionHandler getPreviousExceptionHandler() {
        return previousExceptionHandler;
    }

    public void installExceptionHandler() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler == null) {
            log.debug("Installing New Relic crash handler.");
        } else if (defaultUncaughtExceptionHandler instanceof UncaughtExceptionHandler) {
            log.debug("New Relic crash handler already installed.");
            return;
        } else {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = previousExceptionHandler;
            if (uncaughtExceptionHandler != null) {
                if (uncaughtExceptionHandler instanceof UncaughtExceptionHandler) {
                    AgentLog agentLog = log;
                    String name2 = uncaughtExceptionHandler.getClass().getName();
                    agentLog.warn("Previous uncaught exception handler[" + name2 + "] exists, and it is us! Replace it.");
                } else {
                    AgentLog agentLog2 = log;
                    String name3 = uncaughtExceptionHandler.getClass().getName();
                    String name4 = UncaughtExceptionHandler.class.getName();
                    agentLog2.warn("Previous uncaught exception handler[" + name3 + "] exists. Assuming it delegates to [" + name4 + "]");
                    return;
                }
            }
            AgentLog agentLog3 = log;
            String name5 = defaultUncaughtExceptionHandler.getClass().getName();
            agentLog3.debug("Installing New Relic crash handler and chaining to " + name5);
        }
        previousExceptionHandler = defaultUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void resetExceptionHandler() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        if (!(previousExceptionHandler == null || (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) == null)) {
            if (defaultUncaughtExceptionHandler instanceof UncaughtExceptionHandler) {
                Thread.setDefaultUncaughtExceptionHandler(previousExceptionHandler);
                previousExceptionHandler = null;
            } else {
                AgentLog agentLog = log;
                String name2 = defaultUncaughtExceptionHandler.getClass().getName();
                agentLog.warn("Previous uncaught exception handler[" + name2 + "] was set after agent start. Let it be...");
            }
        }
        this.handledException.set(false);
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        String str;
        if (!this.handledException.compareAndSet(false, true)) {
            StatsEngine.get().inc(MetricNames.SUPPORTABILITY_CRASH_RECURSIVE_HANDLER);
            return;
        }
        try {
            AgentConfiguration agentConfiguration = this.crashReporter.getAgentConfiguration();
            if (this.crashReporter.isEnabled()) {
                if (FeatureFlag.featureEnabled(FeatureFlag.CrashReporting)) {
                    AgentLog agentLog = log;
                    String className = thread.getStackTrace()[0].getClassName();
                    agentLog.debug("A crash has been detected in " + className + " and will be reported ASAP.");
                    if (agentConfiguration.getEnableAnalyticsEvents()) {
                        str = "enabled ";
                    } else {
                        str = "disabled";
                    }
                    agentLog.debug("Analytics data is currently " + str);
                    AnalyticsControllerImpl instance = AnalyticsControllerImpl.getInstance();
                    instance.setEnabled(true);
                    long millisSinceStart = Harvest.getMillisSinceStart();
                    if (millisSinceStart != 0) {
                        instance.setAttribute(AnalyticsAttribute.SESSION_DURATION_ATTRIBUTE, (double) (((float) millisSinceStart) / 1000.0f), false);
                    }
                    this.crashReporter.storeAndReportCrash(new Crash(th2, instance.getSessionAttributes(), instance.getEventManager().getQueuedEvents(), agentConfiguration.getEnableAnalyticsEvents()));
                    if (Agent.isInstantApp()) {
                        Harvest.shutdown();
                        ApplicationStateMonitor.getInstance().uiHidden();
                    }
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = previousExceptionHandler;
                    PayloadController.shutdown();
                    chainExceptionHandler(uncaughtExceptionHandler, thread, th2);
                    return;
                }
            }
            log.debug("A crash has been detected but crash reporting is disabled!");
        } finally {
            if (Agent.isInstantApp()) {
                Harvest.shutdown();
                ApplicationStateMonitor.getInstance().uiHidden();
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = previousExceptionHandler;
            PayloadController.shutdown();
            chainExceptionHandler(uncaughtExceptionHandler2, thread, th2);
        }
    }
}
