package com.instabug.library.util.memory;

import android.app.ActivityManager;
import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.k;

public class MemoryUtils {
    public static long getFreeMemory(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return 0;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return k.a(memoryInfo.availMem, 70);
    }

    public static boolean isLowMemory(@Nullable Context context) {
        if (context == null) {
            return true;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);
                return memoryInfo.lowMemory;
            }
        } catch (Exception | OutOfMemoryError e11) {
            InstabugSDKLogger.e("IBG-Core", "Error: " + e11.getMessage() + "while trying to evaluate isLowMemory");
        }
        return true;
    }
}
