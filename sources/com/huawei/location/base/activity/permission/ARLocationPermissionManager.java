package com.huawei.location.base.activity.permission;

import android.os.Build;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PermissionUtil;

public class ARLocationPermissionManager {
    private static final String ACTIVITY_RECOGNITION_ANDROID_Q = "android.permission.ACTIVITY_RECOGNITION";
    private static final String PERMISSION_DENIED = "PERMISSION_DENIED";
    private static final String TAG = "ARLocationPermissionManager";

    public static boolean checkCPActivityRecognitionPermission(String str, int i11, int i12) {
        boolean z11;
        if (Build.VERSION.SDK_INT <= 28) {
            LogConsole.i(str, " Activity recognition permission is " + true);
            z11 = true;
        } else {
            z11 = PermissionUtil.hasPermission(ContextUtil.getHMSContext(), ACTIVITY_RECOGNITION_ANDROID_Q, i11, i12);
            LogConsole.i(str, "Activity recognition permission on android Q   is " + z11);
        }
        if (!z11) {
            LogConsole.e(str, "pid: " + i11 + ",uid: " + i12 + " has no activity recognition permission ", true);
        }
        return z11;
    }

    public static boolean checkCPActivityRecognitionPermissionByException(String str, String str2, int i11, int i12) {
        boolean checkCPActivityRecognitionPermission = checkCPActivityRecognitionPermission(str, i11, i12);
        if (checkCPActivityRecognitionPermission) {
            return checkCPActivityRecognitionPermission;
        }
        LogConsole.e(str, str2 + " has no activity recognition permission");
        throw new LocationServiceException(10803, "PERMISSION_DENIED " + str2 + " has no Activity Recognition permission");
    }
}
