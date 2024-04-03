package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.huawei.location.lite.common.util.PermissionUtil;

public class PermissionsUtils {
    public static boolean isMediaStoragePermissionGranted(@Nullable Context context) {
        if (context == null) {
            return false;
        }
        return isPermissionGranted(context, mediaStoragePermission());
    }

    public static boolean isPermissionGranted(@NonNull Context context, @NonNull String str) {
        boolean z11;
        String str2;
        try {
            if (ContextCompat.checkSelfPermission(context, str) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Permission ");
            sb2.append(str);
            sb2.append(" state is ");
            if (z11) {
                str2 = "";
            } else {
                str2 = "NOT ";
            }
            sb2.append(str2);
            sb2.append("granted");
            InstabugSDKLogger.v("IBG-Core", sb2.toString());
            return z11;
        } catch (Error | Exception unused) {
            return true;
        }
    }

    @SuppressLint({"InlinedApi"})
    public static String mediaStoragePermission() {
        return Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_IMAGES" : PermissionUtil.READ_EXTERNAL_PERMISSION;
    }

    public static void requestPermission(@NonNull Activity activity, @NonNull String str, int i11, @Nullable Runnable runnable, @Nullable Runnable runnable2) {
        if (!isPermissionGranted(activity, str)) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(activity, str)) {
                runIfValid(runnable);
            }
            InstabugSDKLogger.d("IBG-Core", "Permission " + str + " not granted, requesting it");
            ActivityCompat.requestPermissions(activity, new String[]{str}, i11);
            return;
        }
        InstabugSDKLogger.d("IBG-Core", "Permission " + str + " already granted, running after permission granted runnable");
        runIfValid(runnable2);
    }

    private static void runIfValid(@Nullable Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public static void requestPermission(Fragment fragment, String str, int i11, @Nullable Runnable runnable, Runnable runnable2) {
        Context context = fragment.getContext();
        if (context == null) {
            InstabugSDKLogger.e("IBG-Core", "couldn't request permission/s {" + str + "} due to null context reference.");
        } else if (!isPermissionGranted(context, str)) {
            if (!fragment.shouldShowRequestPermissionRationale(str)) {
                runIfValid(runnable);
            }
            InstabugSDKLogger.d("IBG-Core", "Permission " + str + " not granted, requesting it");
            fragment.requestPermissions(new String[]{str}, i11);
        } else {
            InstabugSDKLogger.d("IBG-Core", "Permission " + str + " already granted, running after permission granted runnable");
            runIfValid(runnable2);
        }
    }
}
