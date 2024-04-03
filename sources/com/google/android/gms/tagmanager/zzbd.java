package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzbd extends zzbq {
    private static final String ID = zza.DEVICE_NAME.toString();

    public zzbd() {
        super(ID, new String[0]);
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!str2.startsWith(str) && !str.equals("unknown")) {
            StringBuilder sb2 = new StringBuilder(str.length() + 1 + str2.length());
            sb2.append(str);
            sb2.append(" ");
            sb2.append(str2);
            str2 = sb2.toString();
        }
        return zzgj.zzi(str2);
    }

    public final boolean zzgw() {
        return true;
    }
}
