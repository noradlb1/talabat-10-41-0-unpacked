package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzt;

@TargetApi(26)
public class zzaa extends zzz {
    public final int zzq(Context context, TelephonyManager telephonyManager) {
        zzt.zzp();
        if (!zzt.zzF(context, "android.permission.ACCESS_NETWORK_STATE") || !telephonyManager.isDataEnabled()) {
            return 1;
        }
        return 2;
    }
}
