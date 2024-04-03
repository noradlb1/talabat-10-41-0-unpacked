package com.talabat.talabatcommon.views.customMvvmView;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class MvvmLinearLayout_LifecycleAdapter implements GeneratedAdapter {

    /* renamed from: a  reason: collision with root package name */
    public final MvvmLinearLayout f11721a;

    public MvvmLinearLayout_LifecycleAdapter(MvvmLinearLayout mvvmLinearLayout) {
        this.f11721a = mvvmLinearLayout;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z11, MethodCallsLogger methodCallsLogger) {
        boolean z12;
        if (methodCallsLogger != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11) {
            if (event == Lifecycle.Event.ON_RESUME) {
                if (!z12 || methodCallsLogger.approveCall("onResume", 1)) {
                    this.f11721a.onResume();
                }
            } else if (event == Lifecycle.Event.ON_PAUSE) {
                if (!z12 || methodCallsLogger.approveCall("onPause", 1)) {
                    this.f11721a.onPause();
                }
            } else if (event != Lifecycle.Event.ON_DESTROY) {
            } else {
                if (!z12 || methodCallsLogger.approveCall("onDestroy", 1)) {
                    this.f11721a.onDestroy();
                }
            }
        }
    }
}
