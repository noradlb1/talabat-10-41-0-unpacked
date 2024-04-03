package com.google.android.gms.internal.ads;

import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyDisplayInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

final class zzfa extends PhoneStateListener {
    final /* synthetic */ zzfb zza;

    public /* synthetic */ zzfa(zzfb zzfb, zzez zzez) {
        this.zza = zzfb;
    }

    @RequiresApi(31)
    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        boolean z11;
        int i11;
        int a11 = telephonyDisplayInfo.getOverrideNetworkType();
        if (a11 == 3 || a11 == 4) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfb zzfb = this.zza;
        if (true != z11) {
            i11 = 5;
        } else {
            i11 = 10;
        }
        zzfb.zzc(zzfb, i11);
    }

    public final void onServiceStateChanged(@Nullable ServiceState serviceState) {
        String str;
        boolean z11;
        int i11;
        if (serviceState == null) {
            str = "";
        } else {
            str = serviceState.toString();
        }
        if (str.contains("nrState=CONNECTED") || str.contains("nrState=NOT_RESTRICTED")) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfb zzfb = this.zza;
        if (true != z11) {
            i11 = 5;
        } else {
            i11 = 10;
        }
        zzfb.zzc(zzfb, i11);
    }
}
