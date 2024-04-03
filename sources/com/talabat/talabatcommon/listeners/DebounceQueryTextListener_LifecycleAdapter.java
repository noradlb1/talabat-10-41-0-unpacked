package com.talabat.talabatcommon.listeners;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class DebounceQueryTextListener_LifecycleAdapter implements GeneratedAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final DebounceQueryTextListener f61783a;

    public DebounceQueryTextListener_LifecycleAdapter(DebounceQueryTextListener debounceQueryTextListener) {
        this.f61783a = debounceQueryTextListener;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z11, MethodCallsLogger methodCallsLogger) {
        boolean z12;
        if (methodCallsLogger != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z11 || event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (!z12 || methodCallsLogger.approveCall("destroy", 1)) {
            this.f61783a.destroy();
        }
    }
}
