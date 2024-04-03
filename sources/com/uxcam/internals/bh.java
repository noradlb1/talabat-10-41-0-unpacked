package com.uxcam.internals;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class bh {
    public static boolean a(Context context) {
        int i11 = gm.f13452a;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return true;
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected() || activeNetworkInfo.getType() == 0) {
            return false;
        }
        return true;
    }
}
