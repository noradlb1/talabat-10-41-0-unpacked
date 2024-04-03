package com.newrelic.agent.android.util;

import android.annotation.TargetApi;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@TargetApi(14)
public class UiBackgroundListener implements ComponentCallbacks2 {
    protected final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new NamedThreadFactory("UiBackgroundListener"));

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i11) {
        if (i11 == 20) {
            this.executor.submit(new Runnable() {
                public void run() {
                    ApplicationStateMonitor.getInstance().uiHidden();
                }
            });
        }
    }
}
