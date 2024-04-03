package com.huawei.secure.android.common.util;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.huawei.secure.android.common.exception.NoPermissionCheckerException;

public class PermissionUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33993a = "PermissionUtil";

    public static boolean checkCallingPermission(Context context, String str, String str2) throws NoPermissionCheckerException {
        if (Binder.getCallingPid() == Process.myPid()) {
            return false;
        }
        return checkPermission(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static boolean checkPermission(Context context, String str, int i11, int i12, String str2) throws NoPermissionCheckerException {
        try {
            if (context.getApplicationInfo().targetSdkVersion > 23) {
                if (context.checkPermission(str, i11, i12) == 0) {
                    return true;
                }
                return false;
            } else if (PermissionChecker.checkPermission(context, str, i11, i12, str2) == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable th2) {
            String str3 = f33993a;
            Log.e(str3, "checkPermission: " + th2.getMessage() + " , you should implementation support library or androidx library");
            throw new NoPermissionCheckerException("you should implementation support library or androidx library");
        }
    }

    public static boolean checkSelfPermission(Context context, String str) throws NoPermissionCheckerException {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
