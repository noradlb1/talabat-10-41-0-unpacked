package com.instabug.apm.util.connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;

public abstract class a {
    @Nullable
    public static String a() {
        TelephonyManager telephonyManager;
        Context r11 = com.instabug.apm.di.a.r();
        if (r11 == null || (telephonyManager = (TelephonyManager) r11.getSystemService("phone")) == null) {
            return null;
        }
        return telephonyManager.getSimOperatorName();
    }

    @Nullable
    public static String b() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            Context r11 = com.instabug.apm.di.a.r();
            if (r11 == null || (connectivityManager = (ConnectivityManager) r11.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() != 0) {
                return null;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2G";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3G";
                case 13:
                case 18:
                case 19:
                    return "4G";
                case 20:
                    return "5G";
                default:
                    return "UNKNOWN";
            }
        } catch (Exception e11) {
            com.instabug.apm.logger.internal.a f11 = com.instabug.apm.di.a.f();
            f11.k("Something went wrong while getting network info" + e11);
        }
        return null;
    }
}
