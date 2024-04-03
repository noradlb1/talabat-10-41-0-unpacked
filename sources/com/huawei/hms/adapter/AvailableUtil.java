package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.adapter.ui.UpdateAdapter;
import com.huawei.hms.common.HmsCheckedState;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AgHmsUpdateState;
import com.talabat.userandlocation.compliance.status.data.impl.UserStatusRepositoryImplKt;

public class AvailableUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f47765a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f47766b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f47767c = false;

    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f47768a;

        public a(Context context) {
            this.f47768a = context;
        }

        public void run() {
            HMSLog.i("AvailableUtil", "enter asyncCheckHmsV3UpdateInfo");
            if (!AvailableUtil.isInstallerLibExist(this.f47768a)) {
                AgHmsUpdateState.getInstance().setCheckedState(HmsCheckedState.NOT_NEED_UPDATE);
                HMSLog.e("AvailableUtil", "asyncCheckHmsV3UpdateInfo installer is not exist");
                return;
            }
            UpdateAdapter.invokeMethod("com.huawei.hms.adapter.ui.InstallerAdapter", "checkHmsUpdateInfo", new Object[]{this.f47768a});
            HMSLog.i("AvailableUtil", "quit asyncCheckHmsV3UpdateInfo");
        }
    }

    public static void asyncCheckHmsUpdateInfo(Context context) {
        if (HmsCheckedState.UNCHECKED != AgHmsUpdateState.getInstance().getCheckedState()) {
            HMSLog.i("AvailableUtil", "asyncCheckHmsUpdateInfo, not need to check");
        } else {
            new Thread(new a(context), "Thread-asyncCheckHmsV3UpdateInfo").start();
        }
    }

    public static boolean isInstallerLibExist(Context context) {
        boolean z11;
        Bundle bundle;
        Object obj;
        if (f47766b) {
            HMSLog.i("AvailableUtil", "installerInit exist: " + f47767c);
            return f47767c;
        }
        synchronized (f47765a) {
            if (!f47766b) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                    } catch (ClassNotFoundException unused) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                    }
                } else {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("availableHMSCoreInstaller")) == null || !String.valueOf(obj).equalsIgnoreCase(UserStatusRepositoryImplKt.KEY_CALL_INVOKED))) {
                            HMSLog.i("AvailableUtil", "available exist: true");
                        }
                    } catch (AndroidException unused2) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                    } catch (RuntimeException e11) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", (Throwable) e11);
                    }
                    z11 = false;
                    f47767c = z11;
                    f47766b = true;
                }
                z11 = true;
                f47767c = z11;
                f47766b = true;
            }
        }
        HMSLog.i("AvailableUtil", "available exist: " + f47767c);
        return f47767c;
    }
}
