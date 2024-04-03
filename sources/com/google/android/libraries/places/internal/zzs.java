package com.google.android.libraries.places.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class zzs {
    private final String zza;
    private final int zzb;
    private final zzr zzc;
    private final boolean zzd;
    private final int zze;

    public zzs(@Nullable WifiInfo wifiInfo, ScanResult scanResult) {
        zzr zzr;
        String str = scanResult.BSSID;
        String str2 = scanResult.capabilities;
        int i11 = scanResult.level;
        int i12 = scanResult.frequency;
        if (TextUtils.isEmpty(str2)) {
            zzr = zzr.OTHER;
        } else {
            String upperCase = str2.toUpperCase();
            if (upperCase.equals("[ESS]") || upperCase.equals("[IBSS]")) {
                zzr = zzr.zza;
            } else if (upperCase.matches(".*WPA[0-9]*-PSK.*")) {
                zzr = zzr.PSK;
            } else if (upperCase.matches(".*WPA[0-9]*-EAP.*")) {
                zzr = zzr.EAP;
            } else {
                zzr = zzr.OTHER;
            }
        }
        boolean z11 = false;
        if (wifiInfo != null && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(wifiInfo.getBSSID())) {
            z11 = true;
        }
        this.zza = str;
        this.zzb = i11;
        this.zzc = zzr;
        this.zzd = z11;
        this.zze = i12;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzr zzc() {
        return this.zzc;
    }

    @Nullable
    public final String zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzd;
    }
}
