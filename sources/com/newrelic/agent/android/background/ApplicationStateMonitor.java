package com.newrelic.agent.android.background;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.newrelic.agent.android.util.NamedThreadFactory;
import he.a;
import he.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class ApplicationStateMonitor {
    private static ApplicationStateMonitor instance = null;
    private static final AgentLog log = AgentLogManager.getAgentLog();
    /* access modifiers changed from: private */
    public AtomicLong activityCount = new AtomicLong(0);
    protected final ArrayList<ApplicationStateListener> applicationStateListeners = new ArrayList<>();
    protected final ExecutorService executor = Executors.newSingleThreadExecutor(new NamedThreadFactory("AppStateMon"));
    protected AtomicBoolean foregrounded = new AtomicBoolean(true);

    public ApplicationStateMonitor() {
        log.info("Application state monitor has started");
    }

    public static ApplicationStateMonitor getInstance() {
        if (instance == null) {
            setInstance(new ApplicationStateMonitor());
        }
        return instance;
    }

    public static boolean isAppInBackground() {
        return !getInstance().getForegrounded();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$activityStarted$1() {
        if (this.activityCount.incrementAndGet() == 1 && !this.foregrounded.get()) {
            this.foregrounded.set(true);
            notifyApplicationInForeground();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$uiHidden$0() {
        if (this.foregrounded.get()) {
            log.info("UI has become hidden (app backgrounded)");
            notifyApplicationInBackground();
            this.foregrounded.set(false);
        }
    }

    private void notifyApplicationInBackground() {
        ArrayList arrayList;
        log.verbose("Application appears to have gone to the background");
        synchronized (this.applicationStateListeners) {
            arrayList = new ArrayList(this.applicationStateListeners);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationBackgrounded(applicationStateEvent);
        }
    }

    private void notifyApplicationInForeground() {
        ArrayList arrayList;
        synchronized (this.applicationStateListeners) {
            arrayList = new ArrayList(this.applicationStateListeners);
        }
        ApplicationStateEvent applicationStateEvent = new ApplicationStateEvent(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ApplicationStateListener) it.next()).applicationForegrounded(applicationStateEvent);
        }
    }

    public static void setInstance(ApplicationStateMonitor applicationStateMonitor) {
        instance = applicationStateMonitor;
    }

    public void activityStarted() {
        this.executor.execute(new b(this));
    }

    public void activityStopped() {
        this.executor.execute(new Runnable() {
            public void run() {
                if (ApplicationStateMonitor.this.activityCount.decrementAndGet() == 0) {
                    ApplicationStateMonitor.this.uiHidden();
                }
            }
        });
    }

    public void addApplicationStateListener(ApplicationStateListener applicationStateListener) {
        synchronized (this.applicationStateListeners) {
            this.applicationStateListeners.add(applicationStateListener);
        }
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public boolean getForegrounded() {
        return this.foregrounded.get();
    }

    public void removeApplicationStateListener(ApplicationStateListener applicationStateListener) {
        synchronized (this.applicationStateListeners) {
            this.applicationStateListeners.remove(applicationStateListener);
        }
    }

    public void uiHidden() {
        this.executor.execute(new a(this));
    }
}
