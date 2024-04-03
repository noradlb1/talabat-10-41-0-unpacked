package com.instabug.library.core.plugin;

import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.dataretention.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public abstract class Plugin {
    public static final int STATE_BACKGROUND = 0;
    public static final int STATE_FOREGROUND = 1;
    public static final int STATE_PROCESSING_ATTACHMENT = 2;
    @Nullable
    protected WeakReference<Context> contextWeakReference;
    private int lifeCycleState = -1;
    protected int state = 0;

    private boolean canSleep() {
        return this.lifeCycleState == 3;
    }

    private boolean canStart() {
        int i11 = this.lifeCycleState;
        return i11 == 1 || i11 == 5;
    }

    private boolean canStop() {
        int i11 = this.lifeCycleState;
        return i11 == 4 || i11 == 2 || i11 == 3;
    }

    private boolean canWake() {
        int i11 = this.lifeCycleState;
        return i11 == 2 || i11 == 4;
    }

    @Nullable
    public Context getAppContext() {
        return Instabug.getApplicationContext();
    }

    @NonNull
    public List<f> getDataDisposalPolicies() {
        return Collections.emptyList();
    }

    public abstract long getLastActivityTime();

    @Nullable
    public ArrayList<PluginPromptOption> getPluginOptions(boolean z11) {
        return null;
    }

    @Nullable
    public ArrayList<PluginPromptOption> getPromptOptions() {
        return null;
    }

    public int getState() {
        return this.state;
    }

    @CallSuper
    public void init(Context context) {
        this.contextWeakReference = new WeakReference<>(context);
        this.lifeCycleState = 1;
    }

    public void initDefaultPromptOptionAvailabilityState() {
    }

    public void invoke(PluginPromptOption pluginPromptOption) {
    }

    public boolean isAppContextAvailable() {
        WeakReference<Context> weakReference = this.contextWeakReference;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public abstract boolean isFeatureEnabled();

    public void onLocaleChanged(Locale locale, Locale locale2) {
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public abstract void sleep();

    public void sleepIfPossible() {
        if (canSleep()) {
            sleep();
            this.lifeCycleState = 4;
        }
    }

    public abstract void start(Context context);

    public void startIfPossible(Context context) {
        if (canStart()) {
            start(context);
            this.lifeCycleState = 2;
        }
    }

    public abstract void stop();

    public void stopIfPossible() {
        if (canStop()) {
            stop();
            this.lifeCycleState = 5;
        }
    }

    public abstract void wake();

    public void wakeIfPossible() {
        if (canWake()) {
            wake();
            this.lifeCycleState = 3;
        }
    }
}
