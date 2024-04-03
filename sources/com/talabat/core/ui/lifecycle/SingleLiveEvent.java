package com.talabat.core.ui.lifecycle;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import qh.a;

public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private static final String TAG = "SingleLiveEvent";
    private final AtomicBoolean mPending = new AtomicBoolean(false);

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$observe$0(Observer observer, Object obj) {
        if (this.mPending.compareAndSet(true, false)) {
            observer.onChanged(obj);
        }
    }

    @MainThread
    public void call() {
        setValue((Object) null);
    }

    @MainThread
    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new a(this, observer));
    }

    @MainThread
    public void setValue(@Nullable T t11) {
        this.mPending.set(true);
        super.setValue(t11);
    }
}
