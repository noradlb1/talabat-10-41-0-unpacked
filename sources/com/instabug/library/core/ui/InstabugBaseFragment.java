package com.instabug.library.core.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.core.ui.BaseContract;
import com.instabug.library.util.LocaleUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

@Instrumented
public abstract class InstabugBaseFragment extends Fragment implements BaseContract.View, TraceFieldInterface {
    @Nullable
    public BaseContract.Presenter C;
    public View F;
    public Trace _nr_trace;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public void finishActivity() {
        if (getActivity() != null) {
            getActivity().finish();
        }
    }

    public String getLocalizedString(@StringRes int i11) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), i11, getContext());
    }

    public Fragment getViewContext() {
        return this;
    }

    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public <T extends View> T i(@IdRes int i11) {
        View view = this.F;
        if (view == null) {
            return null;
        }
        return view.findViewById(i11);
    }

    @LayoutRes
    public abstract int i0();

    public abstract void j0(View view, @Nullable Bundle bundle);

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("InstabugBaseFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "InstabugBaseFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "InstabugBaseFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    @CallSuper
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "InstabugBaseFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "InstabugBaseFragment#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(i0(), viewGroup, false);
        this.F = inflate;
        j0(inflate, bundle);
        View view = this.F;
        TraceMachine.exitMethod();
        return view;
    }

    public void onDestroyView() {
        this.F = null;
        super.onDestroyView();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public String getLocalizedString(@StringRes int i11, Object... objArr) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(getContext()), i11, getContext(), objArr);
    }
}
