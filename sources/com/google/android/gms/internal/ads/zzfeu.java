package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

public final class zzfeu {
    public static void zza(Context context, boolean z11) {
        if (z11) {
            zzciz.zzi("This request is sent from a test device.");
            return;
        }
        zzbgo.zzb();
        String zzt = zzcis.zzt(context);
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzt).length() + 102);
        sb2.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb2.append(zzt);
        sb2.append("\")) to get test ads on this device.");
        zzciz.zzi(sb2.toString());
    }

    public static void zzb(int i11, Throwable th2, String str) {
        StringBuilder sb2 = new StringBuilder(31);
        sb2.append("Ad failed to load : ");
        sb2.append(i11);
        zzciz.zzi(sb2.toString());
        zze.zzb(str, th2);
        if (i11 != 3) {
            zzt.zzo().zzr(th2, str);
        }
    }
}
