package com.huawei.location.lite.common.android.context;

import android.content.Context;
import androidx.annotation.NonNull;

public class ContextUtil {
    private static Context mContext;
    private static Context mHMSContext;

    public static Context getContext() {
        Context context = mContext;
        if (context != null) {
            return context;
        }
        throw new NullPointerException("Context is null , must init first!");
    }

    public static Context getHMSContext() {
        Context context = mHMSContext;
        return context == null ? mContext : context;
    }

    public static void setContext(@NonNull Context context) {
        if (mContext == null) {
            mContext = context.getApplicationContext();
        }
    }

    public static void setHMSContext(@NonNull Context context) {
        if (mHMSContext == null) {
            mHMSContext = context.getApplicationContext();
        }
    }
}
