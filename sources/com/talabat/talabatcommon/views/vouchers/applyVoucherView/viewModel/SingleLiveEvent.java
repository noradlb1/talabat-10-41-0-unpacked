package com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {
    private static final String TAG = "SingleLiveEvent";
    /* access modifiers changed from: private */
    public final AtomicBoolean mPending = new AtomicBoolean(false);

    @MainThread
    public void call() {
        setValue((Object) null);
    }

    @MainThread
    public void observe(LifecycleOwner lifecycleOwner, final Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(lifecycleOwner, new Observer<T>() {
            public void onChanged(@Nullable T t11) {
                if (SingleLiveEvent.this.mPending.compareAndSet(true, false)) {
                    observer.onChanged(t11);
                }
            }
        });
    }

    @MainThread
    public void setValue(@Nullable T t11) {
        this.mPending.set(true);
        super.setValue(t11);
    }
}
