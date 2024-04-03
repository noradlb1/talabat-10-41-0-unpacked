package com.huawei.hms.common;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import com.huawei.hms.common.internal.Preconditions;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;

@Instrumented
public class ErrorDialogFragment extends DialogFragment implements TraceFieldInterface {
    public Trace _nr_trace;

    /* renamed from: a  reason: collision with root package name */
    private Dialog f48086a = null;

    /* renamed from: b  reason: collision with root package name */
    private DialogInterface.OnCancelListener f48087b = null;

    public static ErrorDialogFragment newInstance(Dialog dialog) {
        return newInstance(dialog, (DialogInterface.OnCancelListener) null);
    }

    public void onCancel(DialogInterface dialogInterface) {
        DialogInterface.OnCancelListener onCancelListener = this.f48087b;
        if (onCancelListener != null) {
            onCancelListener.onCancel(dialogInterface);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.f48086a == null) {
            setShowsDialog(false);
        }
        return this.f48086a;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void show(FragmentManager fragmentManager, String str) {
        Preconditions.checkNotNull(fragmentManager, "FragmentManager cannot be null!");
        super.show(fragmentManager, str);
    }

    public static ErrorDialogFragment newInstance(Dialog dialog, DialogInterface.OnCancelListener onCancelListener) {
        Preconditions.checkNotNull(dialog, "Dialog cannot be null!");
        ErrorDialogFragment errorDialogFragment = new ErrorDialogFragment();
        errorDialogFragment.f48086a = dialog;
        dialog.setOnCancelListener((DialogInterface.OnCancelListener) null);
        errorDialogFragment.f48086a.setOnDismissListener((DialogInterface.OnDismissListener) null);
        if (onCancelListener != null) {
            errorDialogFragment.f48087b = onCancelListener;
        }
        return errorDialogFragment;
    }
}
