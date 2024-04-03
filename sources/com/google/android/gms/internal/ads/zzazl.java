package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class zzazl implements Comparator<zzaza> {
    public zzazl(zzazm zzazm) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzaza zzaza = (zzaza) obj;
        zzaza zzaza2 = (zzaza) obj2;
        if (zzaza.zzd() < zzaza2.zzd()) {
            return -1;
        }
        if (zzaza.zzd() <= zzaza2.zzd()) {
            if (zzaza.zzb() < zzaza2.zzb()) {
                return -1;
            }
            if (zzaza.zzb() <= zzaza2.zzb()) {
                float zza = (zzaza.zza() - zzaza.zzd()) * (zzaza.zzc() - zzaza.zzb());
                float zza2 = (zzaza2.zza() - zzaza2.zzd()) * (zzaza2.zzc() - zzaza2.zzb());
                if (zza > zza2) {
                    return -1;
                }
                if (zza >= zza2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
