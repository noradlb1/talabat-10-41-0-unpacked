package io.flutter.plugins.imagepicker;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Arrays;

final class ImagePickerUtils {
    public static boolean a(Context context) {
        if (isPermissionPresentInManifest(context, "android.permission.CAMERA")) {
            return true;
        }
        return false;
    }

    private static boolean isPermissionPresentInManifest(Context context, String str) {
        try {
            return Arrays.asList(context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains(str);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return false;
        }
    }
}
