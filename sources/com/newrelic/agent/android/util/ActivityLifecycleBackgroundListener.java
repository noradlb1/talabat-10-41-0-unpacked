package com.newrelic.agent.android.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class ActivityLifecycleBackgroundListener extends UiBackgroundListener implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public static final AgentLog log = AgentLogManager.getAgentLog();
    private AtomicBoolean isInBackground = new AtomicBoolean(false);

    public void onActivityCreated(Activity activity, Bundle bundle) {
        log.info("ActivityLifecycleBackgroundListener.onActivityCreated");
        this.isInBackground.set(false);
    }

    public void onActivityDestroyed(Activity activity) {
        log.info("ActivityLifecycleBackgroundListener.onActivityDestroyed");
        this.isInBackground.set(false);
    }

    public void onActivityPaused(Activity activity) {
        if (this.isInBackground.compareAndSet(false, true)) {
            this.executor.submit(new Runnable() {
                public void run() {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityPaused - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().uiHidden();
                }
            });
        }
    }

    public void onActivityResumed(Activity activity) {
        log.info("ActivityLifecycleBackgroundListener.onActivityResumed");
        if (this.isInBackground.getAndSet(false)) {
            this.executor.submit(new Runnable() {
                public void run() {
                    ApplicationStateMonitor.getInstance().activityStarted();
                }
            });
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        if (this.isInBackground.compareAndSet(true, false)) {
            this.executor.submit(new Runnable() {
                public void run() {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityStarted - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().activityStarted();
                }
            });
        }
    }

    public void onActivityStopped(Activity activity) {
        if (this.isInBackground.getAndSet(true)) {
            this.executor.submit(new Runnable() {
                public void run() {
                    ActivityLifecycleBackgroundListener.log.debug("ActivityLifecycleBackgroundListener.onActivityStopped - notifying ApplicationStateMonitor");
                    ApplicationStateMonitor.getInstance().activityStopped();
                }
            });
        }
    }

    public void onTrimMemory(int i11) {
        AgentLog agentLog = log;
        agentLog.info("ActivityLifecycleBackgroundListener.onTrimMemory level: " + i11);
        if (20 == i11) {
            this.isInBackground.set(true);
        }
        super.onTrimMemory(i11);
    }
}
