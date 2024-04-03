package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.Map;

final class zzbrk implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        if (zzcop.zzL() != null) {
            zzcop.zzL().zza();
        }
        zzl zzN = zzcop.zzN();
        if (zzN != null) {
            zzN.zzb();
            return;
        }
        zzl zzO = zzcop.zzO();
        if (zzO != null) {
            zzO.zzb();
        } else {
            zzciz.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
