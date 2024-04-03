package com.huawei.hms.dtm.core;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
/* renamed from: com.huawei.hms.dtm.core.qd  reason: case insensitive filesystem */
public abstract class C0426qd extends DialogFragment implements View.OnClickListener, DialogInterface.OnKeyListener, TraceFieldInterface {
    public Trace _nr_trace;

    /* renamed from: a  reason: collision with root package name */
    protected TextView f48546a = null;

    /* renamed from: b  reason: collision with root package name */
    protected Button f48547b = null;

    /* renamed from: c  reason: collision with root package name */
    protected Button f48548c = null;

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    public abstract void a();

    public abstract void a(View view);

    public abstract void b();

    public void onClick(View view) {
        a(view);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "qd#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "qd#onCreateView", (ArrayList<String>) null);
        }
        if (J.b() == null) {
            TraceMachine.exitMethod();
            return null;
        }
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
            dialog.setOnKeyListener(this);
            if (dialog.getWindow() != null) {
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                dialog.getWindow().requestFeature(1);
            }
        }
        View inflate = LayoutInflater.from(J.b()).inflate(R.layout.hw_dtm_dialog, viewGroup, false);
        this.f48546a = (TextView) inflate.findViewById(R.id.hw_dtm_dialog_content_tv);
        this.f48548c = (Button) inflate.findViewById(R.id.hw_dtm_dialog_cancel_tv);
        this.f48547b = (Button) inflate.findViewById(R.id.hw_dtm_dialog_ok_tv);
        this.f48548c.setOnClickListener(this);
        this.f48547b.setOnClickListener(this);
        b();
        TraceMachine.exitMethod();
        return inflate;
    }

    public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            return true;
        }
        a();
        dismiss();
        return true;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
