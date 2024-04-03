package androidx.lifecycle;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

public class ServiceLifecycleDispatcher {
    private final Handler mHandler = new Handler();
    private DispatchRunnable mLastDispatchRunnable;
    private final LifecycleRegistry mRegistry;

    public static class DispatchRunnable implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final Lifecycle.Event f36108b;
        private final LifecycleRegistry mRegistry;
        private boolean mWasExecuted = false;

        public DispatchRunnable(@NonNull LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.mRegistry = lifecycleRegistry;
            this.f36108b = event;
        }

        public void run() {
            if (!this.mWasExecuted) {
                this.mRegistry.handleLifecycleEvent(this.f36108b);
                this.mWasExecuted = true;
            }
        }
    }

    public ServiceLifecycleDispatcher(@NonNull LifecycleOwner lifecycleOwner) {
        this.mRegistry = new LifecycleRegistry(lifecycleOwner);
    }

    private void postDispatchRunnable(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.mLastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.mRegistry, event);
        this.mLastDispatchRunnable = dispatchRunnable2;
        this.mHandler.postAtFrontOfQueue(dispatchRunnable2);
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mRegistry;
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP);
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }
}
