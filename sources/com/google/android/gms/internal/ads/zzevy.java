package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzt;

public final class zzevy implements zzevn<zzevw> {
    private final zzfxb zza;
    private final Context zzb;

    public zzevy(zzfxb zzfxb, Context context) {
        this.zza = zzfxb;
        this.zzb = context;
    }

    public final /* synthetic */ zzevw zza() throws Exception {
        int i11;
        boolean z11;
        int i12;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzb.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int phoneType = telephonyManager.getPhoneType();
        zzt.zzp();
        int i13 = -1;
        if (com.google.android.gms.ads.internal.util.zzt.zzF(this.zzb, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzb.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int ordinal = activeNetworkInfo.getDetailedState().ordinal();
                i12 = type;
                i13 = ordinal;
            } else {
                i12 = -1;
            }
            z11 = connectivityManager.isActiveNetworkMetered();
            i11 = i13;
        } else {
            i11 = -1;
            z11 = false;
            i12 = -2;
        }
        zzt.zzp();
        return new zzevw(networkOperator, i12, com.google.android.gms.ads.internal.util.zzt.zzC(this.zzb), phoneType, z11, i11);
    }

    public final zzfxa<zzevw> zzb() {
        return this.zza.zzb(new zzevx(this));
    }
}
