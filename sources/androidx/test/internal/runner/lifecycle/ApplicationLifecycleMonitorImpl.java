package androidx.test.internal.runner.lifecycle;

import android.app.Application;
import android.util.Log;
import androidx.test.internal.util.Checks;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitor;
import androidx.test.runner.lifecycle.ApplicationStage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApplicationLifecycleMonitorImpl implements ApplicationLifecycleMonitor {
    private static final String TAG = "ApplicationLifecycleMonitorImpl";
    private final List<WeakReference<ApplicationLifecycleCallback>> callbacks = new ArrayList();

    public void addLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback) {
        Checks.checkNotNull(applicationLifecycleCallback);
        synchronized (this.callbacks) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
            boolean z11 = true;
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback2 = (ApplicationLifecycleCallback) it.next().get();
                if (applicationLifecycleCallback2 == null) {
                    it.remove();
                } else if (applicationLifecycleCallback2 == applicationLifecycleCallback) {
                    z11 = false;
                }
            }
            if (z11) {
                this.callbacks.add(new WeakReference(applicationLifecycleCallback));
            }
        }
    }

    public void removeLifecycleCallback(ApplicationLifecycleCallback applicationLifecycleCallback) {
        Checks.checkNotNull(applicationLifecycleCallback);
        synchronized (this.callbacks) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback2 = (ApplicationLifecycleCallback) it.next().get();
                if (applicationLifecycleCallback2 == null) {
                    it.remove();
                } else if (applicationLifecycleCallback2 == applicationLifecycleCallback) {
                    it.remove();
                }
            }
        }
    }

    public void signalLifecycleChange(Application application, ApplicationStage applicationStage) {
        synchronized (this.callbacks) {
            Iterator<WeakReference<ApplicationLifecycleCallback>> it = this.callbacks.iterator();
            while (it.hasNext()) {
                ApplicationLifecycleCallback applicationLifecycleCallback = (ApplicationLifecycleCallback) it.next().get();
                if (applicationLifecycleCallback == null) {
                    it.remove();
                } else {
                    try {
                        String valueOf = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                        sb2.append("running callback: ");
                        sb2.append(valueOf);
                        applicationLifecycleCallback.onApplicationLifecycleChanged(application, applicationStage);
                        String valueOf2 = String.valueOf(applicationLifecycleCallback);
                        StringBuilder sb3 = new StringBuilder(valueOf2.length() + 20);
                        sb3.append("callback completes: ");
                        sb3.append(valueOf2);
                    } catch (RuntimeException e11) {
                        Log.e(TAG, String.format("Callback threw exception! (callback: %s stage: %s)", new Object[]{applicationLifecycleCallback, applicationStage}), e11);
                    }
                }
            }
        }
    }
}
