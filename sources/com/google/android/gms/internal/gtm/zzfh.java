package com.google.android.gms.internal.gtm;

import android.os.RemoteException;
import java.util.Map;

final class zzfh implements zzkl {
    private final /* synthetic */ zzff zzapd;

    private zzfh(zzff zzff) {
        this.zzapd = zzff;
    }

    public final Object zza(String str, Map<String, Object> map) {
        String str2;
        try {
            this.zzapd.zzanh.zzb(str, map);
            return null;
        } catch (RemoteException e11) {
            String valueOf = String.valueOf(e11.getMessage());
            if (valueOf.length() != 0) {
                str2 = "Error calling customEvaluator proxy:".concat(valueOf);
            } else {
                str2 = new String("Error calling customEvaluator proxy:");
            }
            zzev.zzav(str2);
            return null;
        }
    }

    public /* synthetic */ zzfh(zzff zzff, zzfg zzfg) {
        this(zzff);
    }
}
