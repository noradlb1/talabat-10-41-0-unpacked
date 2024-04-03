package com.adyen.checkout.core.internal;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.adyen.checkout.core.Observable;
import com.adyen.checkout.core.Observer;
import com.adyen.checkout.core.internal.lifecycle.LifecycleFragment;
import java.util.HashMap;
import java.util.Map;

public class ObservableImpl<T> implements Observable<T> {
    private static final int START_VERSION = -1;
    private volatile T mData;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private final Map<Observer<T>, ObservableImpl<T>.ObserverWrapper> mObservers = new HashMap();
    private int mVersion = -1;

    public final class LifecycleBoundObserver extends ObservableImpl<T>.ObserverWrapper implements LifecycleFragment.Listener {
        private final LifecycleFragment mLifecycleFragment;

        public void f() {
            this.mLifecycleFragment.removeListener(this);
        }

        public boolean g() {
            return this.mLifecycleFragment.getState().isAtLeast(LifecycleFragment.State.STARTED);
        }

        public void onActive() {
            e(true);
        }

        public void onDestroy() {
            this.mLifecycleFragment.removeListener(this);
        }

        public void onInactive() {
            e(false);
        }

        private LifecycleBoundObserver(@NonNull LifecycleFragment lifecycleFragment, @NonNull Observer<T> observer) {
            super(observer);
            this.mLifecycleFragment = lifecycleFragment;
        }
    }

    public abstract class ObserverWrapper {
        /* access modifiers changed from: private */
        public boolean mActive;
        /* access modifiers changed from: private */
        public int mLastVersion = -1;
        /* access modifiers changed from: private */
        public final Observer<T> mObserver;

        public ObserverWrapper(Observer<T> observer) {
            this.mObserver = observer;
        }

        public void e(boolean z11) {
            if (z11 != this.mActive) {
                this.mActive = z11;
                if (z11) {
                    ObservableImpl.this.dispatchingValue(this);
                }
            }
        }

        public void f() {
        }

        public abstract boolean g();
    }

    public ObservableImpl(@Nullable T t11) {
        if (t11 != null) {
            setValue(t11);
        }
    }

    private static void assertMainThread(@NonNull String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }

    private void considerNotify(@NonNull ObservableImpl<T>.ObserverWrapper observerWrapper) {
        if (observerWrapper.mActive) {
            if (!observerWrapper.g()) {
                observerWrapper.e(false);
                return;
            }
            int b11 = observerWrapper.mLastVersion;
            int i11 = this.mVersion;
            if (b11 < i11) {
                int unused = observerWrapper.mLastVersion = i11;
                observerWrapper.mObserver.onChanged(this.mData);
            }
        }
    }

    /* access modifiers changed from: private */
    public void dispatchingValue(@Nullable ObservableImpl<T>.ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (observerWrapper == null) {
                for (Map.Entry<Observer<T>, ObservableImpl<T>.ObserverWrapper> value : this.mObservers.entrySet()) {
                    considerNotify((ObserverWrapper) value.getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(observerWrapper);
                observerWrapper = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public void observe(@NonNull Activity activity, @NonNull Observer<T> observer) {
        LifecycleFragment addIfNeeded = LifecycleFragment.addIfNeeded(activity);
        if (addIfNeeded.getState() != LifecycleFragment.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(addIfNeeded, observer);
            if (this.mObservers.get(observer) == null) {
                this.mObservers.put(observer, lifecycleBoundObserver);
                addIfNeeded.addListener(lifecycleBoundObserver);
            }
        }
    }

    public void removeObserver(@NonNull Observer<T> observer) {
        assertMainThread("removeObserver");
        ObserverWrapper remove = this.mObservers.remove(observer);
        if (remove != null) {
            remove.f();
            remove.e(false);
        }
    }

    @MainThread
    public void setValue(@NonNull T t11) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t11;
        dispatchingValue((ObservableImpl<T>.ObserverWrapper) null);
    }
}
