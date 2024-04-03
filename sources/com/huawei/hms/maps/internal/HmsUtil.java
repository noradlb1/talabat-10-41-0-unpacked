package com.huawei.hms.maps.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.maps.utils.LogM;
import com.huawei.hms.update.kpms.KpmsConstant;
import com.huawei.hms.utils.HMSPackageManager;

public class HmsUtil {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static boolean f49378a = false;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static boolean f49379b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f49380c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static int f49381d = 12;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f49382e = false;

    private static void a(Context context) {
        Activity findActivity = findActivity(context);
        if (findActivity == null) {
            LogM.e("HmsUtil", "Hms is not available26");
            return;
        }
        try {
            LogM.i("HmsUtil", "4.0 framework HMSCore upgrade process");
            String hMSPackageName = HMSPackageManager.getInstance(findActivity.getApplicationContext()).getHMSPackageName();
            ComponentName componentName = new ComponentName(hMSPackageName, "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
            Intent intent = new Intent();
            intent.putExtra(KpmsConstant.CALLER_PACKAGE_NAME, findActivity.getApplicationContext().getPackageName());
            intent.putExtra(KpmsConstant.UPDATE_PACKAGE_NAME, hMSPackageName);
            intent.setComponent(componentName);
            findActivity.startActivityForResult(intent, 25);
        } catch (ActivityNotFoundException unused) {
            LogM.e("HmsUtil", "not found activity :" + "com.huawei.hms.fwksdk.stub.UpdateStubActivity");
        }
    }

    private static void a(AvailableAdapter availableAdapter, Context context) {
        LogM.d("HmsUtil", "Hms is resolution :");
        Activity findActivity = findActivity(context);
        if (findActivity == null) {
            LogM.e("HmsUtil", "Hms is not available26");
        } else {
            availableAdapter.startResolution(findActivity, new AvailableAdapter.AvailableCallBack() {
                public void onComplete(int i11) {
                    if (i11 == 0) {
                        int unused = HmsUtil.f49381d = i11;
                        LogM.i("HmsUtil", "Hms is available");
                        return;
                    }
                    LogM.e("HmsUtil", "Hms update version failed: " + i11);
                    boolean unused2 = HmsUtil.f49378a = false;
                    boolean unused3 = HmsUtil.f49379b = false;
                }
            });
        }
    }

    public static Activity findActivity(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return findActivity(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static int getMinHmsVersion(Context context) {
        String str;
        int i11;
        try {
            str = context.getPackageManager().getApplicationInfo(context.getApplicationContext().getPackageName(), 128).metaData.getString("com.huawei.hms.map.version");
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            LogM.e("HmsUtil", "NameNotFoundException ");
            str = null;
        }
        if (str != null && !"".equals(str)) {
            String[] split = str.split("\\.");
            if (split.length == 4) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(split[0]);
                sb2.append("0");
                sb2.append(split[1]);
                sb2.append("0");
                sb2.append(split[2]);
                sb2.append(split[3]);
                LogM.i("HmsUtil", "hmsVersionStr " + str);
                i11 = Integer.parseInt(sb2.toString());
                LogM.i("HmsUtil", "baseVersion " + i11);
                return i11;
            }
        }
        i11 = 60200300;
        LogM.i("HmsUtil", "baseVersion " + i11);
        return i11;
    }

    public static int isHmsAvailable(Context context) {
        if (f49381d == 0) {
            return 0;
        }
        LogM.d("HmsUtil", "isInitialized is: " + f49378a + ", repeatFlag is: " + f49379b);
        if (f49378a || !f49379b) {
            return 1;
        }
        AvailableAdapter availableAdapter = new AvailableAdapter(getMinHmsVersion(context));
        int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(context);
        LogM.d("HmsUtil", "Hms is :" + isHuaweiMobileServicesAvailable);
        f49378a = true;
        if (isHuaweiMobileServicesAvailable == 0) {
            LogM.i("HmsUtil", "Hms is avaiable");
        } else if (!availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
            LogM.e("HmsUtil", "Hms is not avaiable 26");
        } else if (!f49380c) {
            if (2 != isHuaweiMobileServicesAvailable || !f49382e) {
                a(availableAdapter, context);
                f49380c = true;
            } else {
                LogM.i("HmsUtil", "Hms is resolution, isHmApk: " + f49382e);
                a(context);
            }
        }
        f49381d = isHuaweiMobileServicesAvailable;
        return isHuaweiMobileServicesAvailable;
    }

    public static void setHmApk(boolean z11) {
        LogM.i("HmsUtil", "setHmApk: " + z11);
        f49382e = z11;
    }

    public static void setRepeatFlag(boolean z11) {
        f49379b = z11;
        mab.a(z11);
    }
}
