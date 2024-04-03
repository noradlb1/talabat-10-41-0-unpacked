package com.newrelic.agent.android.rum;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.AgentConfiguration;
import com.newrelic.agent.android.FeatureFlag;
import com.newrelic.agent.android.background.ApplicationStateEvent;
import com.newrelic.agent.android.background.ApplicationStateListener;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.metric.MetricNames;
import com.newrelic.agent.android.stats.StatsEngine;
import java.io.Closeable;
import java.io.IOException;
import java.util.Date;

public class AppApplicationLifeCycle implements Application.ActivityLifecycleCallbacks, Closeable, ApplicationStateListener {
    private static int activityReferences = 0;
    private static final AgentConfiguration agentConfiguration = new AgentConfiguration();
    private static final DeviceInformation deviceInformation = Agent.getDeviceInformation();
    private static boolean firstActivityCreated = false;
    private static boolean firstActivityResumed = false;
    private static boolean firstDrawInvoked = false;
    private static boolean isActivityChangingConfig = false;
    private static boolean isBackgrounded = false;
    private static boolean isForegrounded = false;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    private Context context;

    private String emptyIfNull(String str) {
        return str == null ? "" : str;
    }

    public void applicationBackgrounded(ApplicationStateEvent applicationStateEvent) {
        AgentLog agentLog = log;
        agentLog.debug("App launch time applicationBackgrounded" + new Date().getTime());
    }

    public void applicationForegrounded(ApplicationStateEvent applicationStateEvent) {
        AgentLog agentLog = log;
        agentLog.debug("App launch time applicationForegrounded" + new Date().getTime());
    }

    public void close() throws IOException {
        ((Application) this.context).unregisterActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        boolean z11;
        try {
            AppTracer instance = AppTracer.getInstance();
            if (bundle == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            instance.setIsColdStart(z11);
            if (!firstActivityCreated) {
                firstActivityCreated = true;
                instance.setFirstActivityCreatedTime(Long.valueOf(SystemClock.uptimeMillis()));
                instance.setFirstActivityName(activity.getLocalClassName());
                instance.setFirstActivityReferrer(activity.getReferrer() + "");
                instance.setFirstActivityIntent(activity.getIntent());
            }
            log.debug("App launch time onActivityCreated " + new Date().getTime());
        } catch (Exception e11) {
            log.error("App launch time exception: " + e11);
        }
    }

    public void onActivityDestroyed(Activity activity) {
        AgentLog agentLog = log;
        agentLog.debug("App launch time onActivityDestroyed" + new Date().getTime());
    }

    public void onActivityPaused(Activity activity) {
        AgentLog agentLog = log;
        agentLog.debug("App launch time onActivityPaused" + new Date().getTime());
    }

    public void onActivityResumed(Activity activity) {
        try {
            if (!FeatureFlag.featureEnabled(FeatureFlag.AppStartMetrics)) {
                log.verbose("App launch time feature is not enabled.");
                return;
            }
            AgentLog agentLog = log;
            agentLog.debug(activity.getLocalClassName());
            AppTracer instance = AppTracer.getInstance();
            instance.setFirstActivityResumeTime(Long.valueOf(SystemClock.uptimeMillis()));
            AppStartUpMetrics appStartUpMetrics = new AppStartUpMetrics();
            if (!firstActivityResumed) {
                AgentConfiguration agentConfiguration2 = agentConfiguration;
                if (agentConfiguration2.getLaunchActivityClassName() == null || agentConfiguration2.getLaunchActivityClassName().equalsIgnoreCase(activity.getLocalClassName())) {
                    firstActivityResumed = true;
                    if (instance.isColdStart()) {
                        StatsEngine.get().sample(MetricNames.APP_LAUNCH_COLD, ((float) appStartUpMetrics.getColdStartTime().longValue()) / 1000.0f);
                    }
                    agentLog.debug("App launch time " + appStartUpMetrics.toString());
                }
            }
            if (isForegrounded) {
                isForegrounded = false;
                StatsEngine.get().sample(MetricNames.APP_LAUNCH_HOT, ((float) appStartUpMetrics.getHotStartTime().longValue()) / 1000.0f);
            }
            agentLog.debug("App launch time " + appStartUpMetrics.toString());
        } catch (Exception e11) {
            AgentLog agentLog2 = log;
            agentLog2.error("App launch time exception: " + e11);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AgentLog agentLog = log;
        agentLog.debug("App launch time onActivitySaveInstanceState" + new Date().getTime());
    }

    public void onActivityStarted(Activity activity) {
        AgentLog agentLog = log;
        agentLog.debug("App launch time onActivityStarted " + new Date().getTime());
        AppTracer instance = AppTracer.getInstance();
        int i11 = activityReferences + 1;
        activityReferences = i11;
        if (i11 == 1 && !isActivityChangingConfig && isBackgrounded) {
            isForegrounded = true;
            isBackgrounded = false;
            instance.setFirstActivityStartTime(Long.valueOf(SystemClock.uptimeMillis()));
        }
    }

    public void onActivityStopped(Activity activity) {
        AgentLog agentLog = log;
        agentLog.debug("App launch time onActivityStopped" + new Date().getTime());
        boolean isChangingConfigurations = activity.isChangingConfigurations();
        isActivityChangingConfig = isChangingConfigurations;
        int i11 = activityReferences - 1;
        activityReferences = i11;
        if (i11 == 0 && !isChangingConfigurations) {
            isBackgrounded = true;
        }
    }

    public void onColdStartInitiated(Context context2) {
        this.context = context2.getApplicationContext();
        ((Application) context2).registerActivityLifecycleCallbacks(this);
    }
}
