package com.huawei.hms.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.UIUtil;

public abstract class AbstractDialog {

    /* renamed from: a  reason: collision with root package name */
    private Activity f49885a;

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f49886b;

    /* renamed from: c  reason: collision with root package name */
    private Callback f49887c;

    public interface Callback {
        void onCancel(AbstractDialog abstractDialog);

        void onDoWork(AbstractDialog abstractDialog);
    }

    public class a implements DialogInterface.OnClickListener {
        public a() {
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            AbstractDialog.this.fireDoWork();
        }
    }

    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            AbstractDialog.this.cancel();
        }
    }

    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        public void onCancel(DialogInterface dialogInterface) {
            AbstractDialog.this.fireCancel();
        }
    }

    public class d implements DialogInterface.OnKeyListener {
        public d() {
        }

        public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
            if (4 != i11 || keyEvent.getAction() != 1) {
                return false;
            }
            AbstractDialog.this.cancel();
            return true;
        }
    }

    public void cancel() {
        AlertDialog alertDialog = this.f49886b;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    public void dismiss() {
        AlertDialog alertDialog = this.f49886b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public void fireCancel() {
        Callback callback = this.f49887c;
        if (callback != null) {
            callback.onCancel(this);
        }
    }

    public void fireDoWork() {
        Callback callback = this.f49887c;
        if (callback != null) {
            callback.onDoWork(this);
        }
    }

    public Activity getActivity() {
        return this.f49885a;
    }

    public int getDialogThemeId() {
        return UIUtil.getDialogThemeId(getActivity());
    }

    public AlertDialog onCreateDialog(Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), getDialogThemeId());
        String onGetTitleString = onGetTitleString(activity);
        if (onGetTitleString != null) {
            builder.setTitle(onGetTitleString);
        }
        String onGetMessageString = onGetMessageString(activity);
        if (onGetMessageString != null) {
            builder.setMessage(onGetMessageString);
        }
        String onGetPositiveButtonString = onGetPositiveButtonString(activity);
        if (onGetPositiveButtonString != null) {
            builder.setPositiveButton(onGetPositiveButtonString, new a());
        }
        String onGetNegativeButtonString = onGetNegativeButtonString(activity);
        if (onGetNegativeButtonString != null) {
            builder.setNegativeButton(onGetNegativeButtonString, new b());
        }
        return builder.create();
    }

    public abstract String onGetMessageString(Context context);

    public abstract String onGetNegativeButtonString(Context context);

    public abstract String onGetPositiveButtonString(Context context);

    public abstract String onGetTitleString(Context context);

    public void setMessage(CharSequence charSequence) {
        AlertDialog alertDialog = this.f49886b;
        if (alertDialog != null) {
            alertDialog.setMessage(charSequence);
        }
    }

    public void setTitle(CharSequence charSequence) {
        AlertDialog alertDialog = this.f49886b;
        if (alertDialog != null) {
            alertDialog.setTitle(charSequence);
        }
    }

    public void show(Activity activity, Callback callback) {
        this.f49885a = activity;
        this.f49887c = callback;
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("AbstractDialog", "In show, The activity is null or finishing.");
            return;
        }
        AlertDialog onCreateDialog = onCreateDialog(this.f49885a);
        this.f49886b = onCreateDialog;
        onCreateDialog.setCanceledOnTouchOutside(false);
        this.f49886b.setOnCancelListener(new c());
        this.f49886b.setOnKeyListener(new d());
        this.f49886b.show();
    }
}
