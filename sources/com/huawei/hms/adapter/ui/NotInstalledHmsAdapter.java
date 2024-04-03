package com.huawei.hms.adapter.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.adapter.sysobs.SystemManager;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;

public class NotInstalledHmsAdapter implements IBridgeActivityDelegate {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f47815c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static boolean f47816d;

    /* renamed from: a  reason: collision with root package name */
    private Activity f47817a;

    /* renamed from: b  reason: collision with root package name */
    private Dialog f47818b;

    public static class a implements DialogInterface.OnCancelListener {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f47819a;

        public a(Activity activity) {
            this.f47819a = activity;
        }

        public void onCancel(DialogInterface dialogInterface) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onCancel>");
            SystemManager.getInstance().notifyUpdateResult(13);
            this.f47819a.finish();
        }
    }

    public static class b implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f47820a;

        public b(Activity activity) {
            this.f47820a = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            HMSLog.i("NotInstalledHmsAdapter", "<Dialog onClick>");
            SystemManager.getInstance().notifyUpdateResult(30);
            this.f47820a.finish();
        }
    }

    private void a(Activity activity) {
        Dialog dialog = this.f47818b;
        if (dialog != null && dialog.isShowing()) {
            this.f47818b.setOnCancelListener((DialogInterface.OnCancelListener) null);
            this.f47818b.cancel();
        }
        this.f47818b = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new b(activity)).setOnCancelListener(new a(activity)).show();
    }

    public static boolean getShowLock() {
        synchronized (f47815c) {
            HMSLog.i("NotInstalledHmsAdapter", "<canShowDialog> sIsShowingDialog: " + f47816d);
            if (f47816d) {
                return false;
            }
            f47816d = true;
            return true;
        }
    }

    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsAdapter", "<getRequestCode>");
        return 0;
    }

    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsAdapter", "<onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        this.f47817a = activity;
        a(activity);
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityDestroy>");
        synchronized (f47815c) {
            f47816d = false;
        }
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeActivityResult>");
        return false;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged>");
        Activity activity = this.f47817a;
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsAdapter", "<onBridgeConfigurationChanged> mActivity is null or finishing");
        } else {
            a(this.f47817a);
        }
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("NotInstalledHmsAdapter", "<onKeyUp>");
    }
}
