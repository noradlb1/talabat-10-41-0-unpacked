package com.instabug.library;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.LocaleUtils;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public abstract class InstabugBaseFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    @Nullable
    private Activity activity;
    private boolean isStateRestored;
    @Nullable
    private View view;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public String getLocalizedString(@StringRes int i11) {
        return LocaleUtils.getLocaleStringResource(InstabugCore.getLocale(requireContext()), i11, requireContext());
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @Nullable
    public Activity getPreservedActivity() {
        InstabugSDKLogger.v("IBG-Core", "Returning preserved activity " + this.activity);
        return this.activity;
    }

    public abstract void i0();

    public boolean isStateRestored() {
        return this.isStateRestored;
    }

    @LayoutRes
    public abstract int j0();

    public abstract String k0();

    public abstract void l0(Bundle bundle);

    public void onAttach(Activity activity2) {
        super.onAttach(activity2);
        this.activity = activity2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("InstabugBaseFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "InstabugBaseFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "InstabugBaseFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (getArguments() != null) {
            InstabugSDKLogger.v("IBG-Core", "Arguments found, calling consumeNewInstanceSavedArguments with " + getArguments());
            i0();
        }
        this.isStateRestored = false;
        TraceMachine.exitMethod();
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "InstabugBaseFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "InstabugBaseFragment#onCreateView", (ArrayList<String>) null);
        }
        this.view = layoutInflater.inflate(j0(), viewGroup, false);
        setTitle(k0());
        View view2 = this.view;
        TraceMachine.exitMethod();
        return view2;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        InstabugSDKLogger.v("IBG-Core", "onSaveInstanceState called, calling saveState");
        l0(bundle);
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@NonNull View view2, @Nullable Bundle bundle) {
        super.onViewCreated(view2, bundle);
        if (bundle != null) {
            InstabugSDKLogger.v("IBG-Core", "savedInstanceState found, calling restoreState");
            restoreState(bundle);
            this.isStateRestored = true;
        }
    }

    public abstract void restoreState(Bundle bundle);

    public void setTitle(String str) {
        TextView textView;
        View view2 = this.view;
        if (view2 != null && (textView = (TextView) view2.findViewById(R.id.instabug_fragment_title)) != null) {
            InstabugSDKLogger.v("IBG-Core", "Setting fragment title to \"" + str + "\"");
            textView.setText(str);
        }
    }
}
