package com.instabug.library.core.ui;

import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.instabug.library.core.ui.BaseContract;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public abstract class a extends DialogFragment implements BaseContract.View, TraceFieldInterface {
    public Trace _nr_trace;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public View f34204b;

    @LayoutRes
    public abstract int K();

    public abstract void L(View view, Bundle bundle);

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public void finishActivity() {
        getActivity().finish();
    }

    public DialogFragment getViewContext() {
        return this;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("a");
        try {
            TraceMachine.enterMethod(this._nr_trace, "a#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "a#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    @CallSuper
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "a#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "a#onCreateView", (ArrayList<String>) null);
        }
        if (!(getDialog() == null || getDialog().getWindow() == null)) {
            getDialog().getWindow().requestFeature(1);
        }
        View inflate = layoutInflater.inflate(K(), viewGroup, false);
        this.f34204b = inflate;
        L(inflate, bundle);
        View view = this.f34204b;
        TraceMachine.exitMethod();
        return view;
    }

    public void onDestroyView() {
        this.f34204b = null;
        super.onDestroyView();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }
}
