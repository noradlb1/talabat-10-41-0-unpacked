package com.instabug.featuresrequest.ui.custom;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.instabug.featuresrequest.R;
import com.instabug.library.Instabug;
import com.instabug.library.InstabugColorTheme;
import com.instabug.library.settings.SettingsManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class b extends DialogFragment implements TraceFieldInterface {
    public Trace _nr_trace;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private TextView f46699a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f46700b;

    public static b a() {
        return new b();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "b#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "b#onCreateView", (ArrayList<String>) null);
        }
        if (!(getDialog() == null || getDialog().getWindow() == null)) {
            getDialog().getWindow().requestFeature(1);
        }
        View inflate = layoutInflater.inflate(R.layout.ib_fr_progress_dialog_layout, viewGroup);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"STARVATION"})
    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f46699a = (TextView) view.findViewById(R.id.textView);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        this.f46700b = progressBar;
        if (this.f46699a != null && progressBar != null) {
            Drawable indeterminateDrawable = progressBar.getIndeterminateDrawable();
            if (indeterminateDrawable != null) {
                indeterminateDrawable.setColorFilter(SettingsManager.getInstance().getPrimaryColor(), PorterDuff.Mode.SRC_IN);
            }
            if (Instabug.getTheme() == InstabugColorTheme.InstabugColorThemeDark) {
                RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.progressDialogLayout);
                if (relativeLayout != null) {
                    relativeLayout.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.instabug_dialog_dark_bg_color));
                }
                this.f46699a.setTextColor(ContextCompat.getColor(view.getContext(), 17170443));
                this.f46699a.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.instabug_dialog_dark_bg_color));
            }
        }
    }
}
