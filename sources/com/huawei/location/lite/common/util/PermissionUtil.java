package com.huawei.location.lite.common.util;

import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.PermissionChecker;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.exception.LocationStatusCode;
import com.huawei.location.lite.common.log.LogConsole;
import java.util.List;

public class PermissionUtil {
    public static final String BACKGROUND_PERMISSION = "android.permission.ACCESS_BACKGROUND_LOCATION";
    public static final String READ_EXTERNAL_PERMISSION = "android.permission.READ_EXTERNAL_STORAGE";
    private static final String TAG = "PermissionUtil";
    public static final String WRITE_EXTERNAL_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private static int errorCode = (SDKComponentType.getComponentType() == 200 ? 10102 : 10803);

    public static boolean canAccessMockLocation(String str, Context context, Integer num) {
        if (context == null) {
            LogConsole.e(TAG, "canAccessMockLocation Context is null");
            return false;
        }
        try {
            Object systemService = context.getSystemService("appops");
            if (num == null) {
                LogConsole.e(TAG, "canAccessMockLocation uid is null");
                return false;
            } else if (systemService instanceof AppOpsManager) {
                boolean z11 = ((AppOpsManager) systemService).noteOp("android:mock_location", num.intValue(), str) == 0;
                LogConsole.i(TAG, "canCallerAccessMockLocation ,Build.VERSION.SDK_INT >=23 ,mock is " + z11);
                return z11;
            } else {
                LogConsole.i(TAG, "canCallerAccessMockLocation ,no AppOpsManager ");
                return false;
            }
        } catch (SecurityException unused) {
            LogConsole.e(TAG, "canCallerAccessMockLocation ,SecurityException ", true);
            return false;
        } catch (Exception unused2) {
            LogConsole.e(TAG, "canCallerAccessMockLocation ,Exception ", true);
            return false;
        }
    }

    public static boolean checkCPLocationPermissionByBoolean(Context context, String str, int i11, int i12, String str2) {
        String str3;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!hasPermission(context, "android.permission.ACCESS_FINE_LOCATION", i11, i12) && !hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION", i11, i12)) {
            str3 = "checkCPLocationPermission failed : do not have location permission";
        } else if (Build.VERSION.SDK_INT <= 28) {
            return true;
        } else {
            LogConsole.i(str, "sdk > = 28 Q");
            if (!isAppIsInBackground(str2) || hasPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION", i11, i12)) {
                return true;
            }
            str3 = "checkCPLocationPermission failed : do not have background permission";
        }
        LogConsole.e(str, str3);
        return false;
    }

    public static void checkCPLocationPermissionByException(Context context, String str, int i11, int i12, String str2) {
        if (TextUtils.isEmpty(str2)) {
            throw new LocationServiceException(10803, LocationStatusCode.getStatusCodeString(10803) + "packageName is null");
        } else if (!hasPermission(context, "android.permission.ACCESS_FINE_LOCATION", i11, i12) && !hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION", i11, i12)) {
            LogConsole.e(str, "checkCPLocationPermission failed : do not have location permission");
            throw new LocationServiceException(10803, LocationStatusCode.getStatusCodeString(10803) + ":location permission denied.");
        } else if (Build.VERSION.SDK_INT <= 28) {
            LogConsole.i(str, "sdk < 28 Q");
        } else if (isAppIsInBackground(str2) && !hasPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION", i11, i12)) {
            LogConsole.e(str, "checkCPLocationPermission failed : do not have background permission");
            throw new LocationServiceException(10803, LocationStatusCode.getStatusCodeString(10803) + ": backgroundPermission is denied.");
        }
    }

    public static boolean checkLocationPermission(Context context) {
        String str;
        if (checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") || checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            if (Build.VERSION.SDK_INT > 28 && isAppIsInBackground(context)) {
                LogConsole.i(TAG, "app is in background");
                if (!checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                    str = "ACCESS_BACKGROUND_LOCATION is denied";
                }
            }
            return true;
        }
        str = "ACCESS_FINE_LOCATION and ACCESS_COARSE_LOCATION is denied";
        LogConsole.i(TAG, str);
        return false;
    }

    public static int checkPermission(@NonNull Context context, @NonNull String str, int i11, int i12, String str2) {
        if (str2 == null) {
            try {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i12);
                if (packagesForUid != null) {
                    if (packagesForUid.length > 0) {
                        str2 = packagesForUid[0];
                    }
                }
                LogConsole.i(TAG, "checkPermission get packageName fail ");
                return -1;
            } catch (Exception unused) {
                LogConsole.e(TAG, "checkPermission LocationServiceException");
                throw new LocationServiceException(10000, LocationStatusCode.getStatusCodeString(10000));
            }
        }
        return APKUtil.getTargetSdkVersion(str2) >= 23 ? context.checkPermission(str, i11, i12) : PermissionChecker.checkPermission(context, str, i11, i12, str2);
    }

    public static boolean checkSelfPermission(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "hasSelfPermission failed because of context or permission is null";
        } else if (context.checkSelfPermission(str) == 0) {
            return true;
        } else {
            str2 = "do not hasSelfPermission " + str;
        }
        LogConsole.e(TAG, str2);
        return false;
    }

    public static boolean checkSelfPermissionByBoolean(String str, Context context) {
        String str2;
        if (!checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") && !checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            str2 = "checkPermissionByBoolean , don't have enough permisson";
        } else if (Build.VERSION.SDK_INT <= 28) {
            return true;
        } else {
            LogConsole.i(str, "checkPermissionByBoolean sdk > 28 Q");
            if (checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                return true;
            }
            str2 = "checkPermissionByBoolean BackgroundPermission is false";
        }
        LogConsole.e(str, str2);
        return false;
    }

    public static void checkSelfPermissionByException(String str, Context context) {
        if (!checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") && !checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION")) {
            LogConsole.e(str, "checkPermissionByException , don't have enough permisson");
            int i11 = errorCode;
            throw new LocationServiceException(i11, LocationStatusCode.getStatusCodeString(i11));
        } else if (Build.VERSION.SDK_INT > 28) {
            LogConsole.i(str, "checkPermissionByException sdk > 28 Q");
            if (!checkSelfPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                LogConsole.e(str, "checkPermissionByException BackgroundPermission is false");
                int i12 = errorCode;
                throw new LocationServiceException(i12, LocationStatusCode.getStatusCodeString(errorCode) + "BackgroundPermission is denied.");
            }
        }
    }

    public static boolean hasLocationPermission(Context context, String str, int i11, int i12) {
        try {
            if (hasPermission(context, "android.permission.ACCESS_COARSE_LOCATION", i11, i12) || hasPermission(context, "android.permission.ACCESS_FINE_LOCATION", i11, i12)) {
                return Build.VERSION.SDK_INT <= 28 || !isAppIsInBackground(str) || hasPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION", i11, i12);
            }
            return false;
        } catch (Exception unused) {
            LogConsole.i(TAG, "hasLocationPermission  exception", true);
        }
    }

    public static boolean hasPermission(Context context, String str, int i11, int i12) {
        String str2;
        if (context == null) {
            str2 = "hasPermission Context is null";
        } else {
            int checkPermission = checkPermission(context, str, i11, i12, (String) null);
            if (checkPermission == 0) {
                return true;
            }
            if (-1 == checkPermission) {
                str2 = "hasPermission, result is " + checkPermission;
            } else {
                LogConsole.e(TAG, "hasPermission, result is " + checkPermission);
                int i13 = errorCode;
                throw new LocationServiceException(i13, LocationStatusCode.getStatusCodeString(i13));
            }
        }
        LogConsole.e(TAG, str2);
        return false;
    }

    public static boolean isAppIsInBackground(Context context) {
        if (context == null) {
            return false;
        }
        return isAppIsInBackground(context.getPackageName());
    }

    public static boolean isAppIsInBackground(String str) {
        String str2;
        Object systemService = ContextUtil.getHMSContext().getSystemService("activity");
        if (!(systemService instanceof ActivityManager)) {
            str2 = "managerResult is not a instance of ActivityManager";
        } else {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) systemService).getRunningAppProcesses();
            if (runningAppProcesses == null) {
                str2 = "runningProcesses is null";
            } else {
                boolean z11 = true;
                for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                    if (isImportanceForeground(next.importance)) {
                        String[] strArr = next.pkgList;
                        int length = strArr.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                break;
                            } else if (strArr[i11].equals(str)) {
                                z11 = false;
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                }
                return z11;
            }
        }
        LogConsole.e(TAG, str2);
        return false;
    }

    private static boolean isImportanceForeground(int i11) {
        return Build.VERSION.SDK_INT > 23 ? i11 <= 125 : i11 <= 100;
    }
}
