package com.adyen.checkout.ui.internal.common.util.image;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

abstract class LifecycleAwareRequest extends Request implements LifecycleObserver {
    private boolean mDestroyed;
    private Lifecycle mLifecycle;

    public LifecycleAwareRequest(@NonNull Rembrandt rembrandt, @NonNull RequestArgs requestArgs, @NonNull Lifecycle lifecycle) {
        super(rembrandt, requestArgs);
        this.mLifecycle = lifecycle;
        lifecycle.addObserver(this);
    }

    public boolean a() {
        return this.mDestroyed;
    }

    public void c() {
        Lifecycle lifecycle = this.mLifecycle;
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
        this.mLifecycle = null;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        this.mDestroyed = true;
        c();
    }
}
