package com.huawei.hms.flutter.map.map;

import android.content.Context;
import android.os.Process;

class MapLocation {
    private static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission error");
    }

    public static boolean hasLocationPermission(Context context) {
        if (checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        return false;
    }
}
