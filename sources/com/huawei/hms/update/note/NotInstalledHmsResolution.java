package com.huawei.hms.update.note;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import com.huawei.hms.activity.IBridgeActivityDelegate;
import com.huawei.hms.availableupdate.b;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.ui.NotInstalledHmsDialogHelper;

public class NotInstalledHmsResolution implements IBridgeActivityDelegate {

    /* renamed from: a  reason: collision with root package name */
    private Dialog f49896a;

    /* renamed from: b  reason: collision with root package name */
    private Activity f49897b;

    public static class a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f49898a;

        public a(Activity activity) {
            this.f49898a = activity;
        }

        public void onClick(DialogInterface dialogInterface, int i11) {
            HMSLog.i("NotInstalledHmsResolution", "<Dialog onClick>");
            this.f49898a.finish();
        }
    }

    private void a(Activity activity) {
        a();
        this.f49896a = NotInstalledHmsDialogHelper.getDialogBuilder(activity).setPositiveButton(NotInstalledHmsDialogHelper.getConfirmResId(activity), new a(activity)).show();
    }

    public int getRequestCode() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution getRequestCode>");
        return 0;
    }

    public void onBridgeActivityCreate(Activity activity) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate>");
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> activity is null or finishing");
            return;
        }
        this.f49897b = activity;
        b.f48062b.a(activity);
        a(activity);
    }

    public void onBridgeActivityDestroy() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityDestroy>");
        a();
        b.f48062b.b(this.f49897b);
    }

    public boolean onBridgeActivityResult(int i11, int i12, Intent intent) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeActivityResult>");
        return false;
    }

    public void onBridgeConfigurationChanged() {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onBridgeConfigurationChanged>");
        Activity activity = this.f49897b;
        if (activity == null || activity.isFinishing()) {
            HMSLog.e("NotInstalledHmsResolution", "<Resolution onBridgeActivityCreate> mActivity is null or finishing");
        } else {
            a(this.f49897b);
        }
    }

    public void onKeyUp(int i11, KeyEvent keyEvent) {
        HMSLog.i("NotInstalledHmsResolution", "<Resolution onKeyUp>");
    }

    private void a() {
        Dialog dialog = this.f49896a;
        if (dialog != null && dialog.isShowing()) {
            this.f49896a.cancel();
        }
    }
}
