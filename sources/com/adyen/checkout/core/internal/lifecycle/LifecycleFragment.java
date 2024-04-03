package com.adyen.checkout.core.internal.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Instrumented
public final class LifecycleFragment extends Fragment implements TraceFieldInterface {
    private static final String TAG = "com.adyen.checkout.core.internal.lifecycle.LifecycleFragment";
    public Trace _nr_trace;
    private final List<Listener> mListeners = new ArrayList();
    private State mState = State.INITIALIZED;

    public interface Listener {
        void onActive();

        void onDestroy();

        void onInactive();
    }

    public enum State {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(@NonNull State state) {
            return compareTo(state) >= 0;
        }
    }

    @NonNull
    public static LifecycleFragment addIfNeeded(@NonNull Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            fragmentManager.executePendingTransactions();
        } catch (IllegalStateException unused) {
        }
        String str = TAG;
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(str);
        if (!(findFragmentByTag instanceof LifecycleFragment)) {
            findFragmentByTag = new LifecycleFragment();
            fragmentManager.beginTransaction().add(findFragmentByTag, str).commit();
        }
        return (LifecycleFragment) findFragmentByTag;
    }

    public void addListener(@NonNull Listener listener) {
        if (!this.mListeners.contains(listener)) {
            if (this.mState.isAtLeast(State.INITIALIZED)) {
                this.mListeners.add(listener);
            }
            if (this.mState.isAtLeast(State.RESUMED)) {
                listener.onActive();
            }
        }
    }

    @NonNull
    public State getState() {
        return this.mState;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("LifecycleFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "LifecycleFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "LifecycleFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        this.mState = State.CREATED;
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        super.onDestroy();
        this.mState = State.DESTROYED;
        Iterator it = new ArrayList(this.mListeners).iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onDestroy();
        }
    }

    public void onPause() {
        super.onPause();
        this.mState = State.STARTED;
        Iterator it = new ArrayList(this.mListeners).iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onInactive();
        }
    }

    public void onResume() {
        super.onResume();
        this.mState = State.RESUMED;
        Iterator it = new ArrayList(this.mListeners).iterator();
        while (it.hasNext()) {
            ((Listener) it.next()).onActive();
        }
    }

    public void onStart() {
        super.onStart();
        this.mState = State.STARTED;
    }

    public void onStop() {
        super.onStop();
        this.mState = State.CREATED;
    }

    public void removeListener(@NonNull Listener listener) {
        if (this.mListeners.contains(listener)) {
            this.mListeners.remove(listener);
            if (this.mState.isAtLeast(State.RESUMED)) {
                listener.onInactive();
            }
            if (this.mState.isAtLeast(State.INITIALIZED)) {
                listener.onDestroy();
            }
        }
    }
}
