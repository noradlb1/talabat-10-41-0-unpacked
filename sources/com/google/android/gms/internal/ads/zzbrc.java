package com.google.android.gms.internal.ads;

import java.util.Map;

public final /* synthetic */ class zzbrc implements zzbrt {
    public static final /* synthetic */ zzbrc zza = new zzbrc();

    private /* synthetic */ zzbrc() {
    }

    public final void zza(Object obj, Map map) {
        zzcpx zzcpx = (zzcpx) obj;
        zzbrt<zzcop> zzbrt = zzbrs.zza;
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzalt zzK = zzcpx.zzK();
            if (zzK != null) {
                zzK.zzc().zzl(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzciz.zzj("Could not parse touch parameters from gmsg.");
        }
    }
}
