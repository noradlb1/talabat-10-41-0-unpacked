package com.adyen.checkout.core.internal;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.adyen.checkout.core.internal.lifecycle.LifecycleFragment;
import java.util.ArrayList;
import java.util.List;

abstract class BaseManager<H, D> {
    private D mData;
    /* access modifiers changed from: private */
    public final List<H> mHandlers = new ArrayList();
    private final Listener mListener;

    public final class ActivityScopedHandler implements LifecycleFragment.Listener {
        private H mHandler;
        private LifecycleFragment mLifecycleFragment;

        public void onActive() {
            BaseManager.this.mHandlers.add(0, this.mHandler);
            BaseManager.this.checkDispatch();
        }

        public void onDestroy() {
            this.mLifecycleFragment.removeListener(this);
            this.mHandler = null;
            this.mLifecycleFragment = null;
        }

        public void onInactive() {
            BaseManager.this.mHandlers.remove(this.mHandler);
        }

        private ActivityScopedHandler(@NonNull Activity activity, @NonNull H h11) {
            LifecycleFragment addIfNeeded = LifecycleFragment.addIfNeeded(activity);
            this.mLifecycleFragment = addIfNeeded;
            this.mHandler = h11;
            addIfNeeded.addListener(this);
        }
    }

    public interface Listener {
        void onHandled();
    }

    public BaseManager(@NonNull Listener listener) {
        this.mListener = listener;
    }

    /* access modifiers changed from: private */
    public void checkDispatch() {
        if (this.mData != null && !this.mHandlers.isEmpty()) {
            d(this.mHandlers.get(0), this.mData);
            this.mListener.onHandled();
            this.mData = null;
        }
    }

    public void c(@NonNull Activity activity, @NonNull H h11) {
        new ActivityScopedHandler(activity, h11);
        checkDispatch();
    }

    public abstract void d(@NonNull H h11, @NonNull D d11);

    public void e(@NonNull D d11) {
        this.mData = d11;
        checkDispatch();
    }
}
