package com.huawei.hms.locationSdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.api.Api;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.location.lite.common.log.LogConsole;

public class j1 implements f1 {
    public static boolean a(Context context) {
        String str;
        boolean z11 = false;
        if (context == null) {
            str = "context is null";
        } else {
            if (c(context) || b(context)) {
                z11 = true;
            }
            str = "isHMSEnable:" + z11;
        }
        HMSLog.i("LiteSDKProxy", str);
        return z11;
    }

    private static boolean b(Context context) {
        boolean z11 = true;
        if (context == null) {
            return true;
        }
        if (context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", "com.huawei.hwid") != 0) {
            z11 = false;
        }
        HMSLog.i("LiteSDKProxy", "isHmsWithSysSignature：" + z11);
        return z11;
    }

    private static boolean c(Context context) {
        String str;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 16384);
            if (!(packageInfo == null || (packageInfo.applicationInfo.flags & 1) == 0)) {
                LogConsole.i("LiteSDKProxy", "is system app");
                return true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            str = "isSystemApplication NameNotFoundException";
            LogConsole.e("LiteSDKProxy", str);
            return false;
        } catch (RuntimeException unused2) {
            str = "Package Manager has died Exception";
            LogConsole.e("LiteSDKProxy", str);
            return false;
        }
        return false;
    }

    public <TResult, TClient extends AnyClient, TOption extends Api.ApiOptions> Task<TResult> a(HuaweiApi<TOption> huaweiApi, TaskApiCall<TClient, TResult> taskApiCall, AbstractClientBuilder<TClient, TOption> abstractClientBuilder) {
        HMSLog.i("LiteSDKProxy", "LiteSDKProxy doWriteProxy");
        return huaweiApi.doWrite(taskApiCall);
    }
}
