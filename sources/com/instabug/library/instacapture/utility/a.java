package com.instabug.library.instacapture.utility;

import android.app.ActivityManager;
import android.content.Context;

public abstract class a {
    public static long a(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }
}
