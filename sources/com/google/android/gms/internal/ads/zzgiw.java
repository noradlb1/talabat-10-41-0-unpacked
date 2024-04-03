package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzgiw implements Comparator<zzgjf> {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgjf zzgjf = (zzgjf) obj;
        zzgjf zzgjf2 = (zzgjf) obj2;
        zzgiz zzs = zzgjf.iterator();
        zzgiz zzs2 = zzgjf2.iterator();
        while (zzs.hasNext() && zzs2.hasNext()) {
            int zza = zzgiv.zza(zzs.zza() & 255, zzs2.zza() & 255);
            if (zza != 0) {
                return zza;
            }
        }
        return zzgiv.zza(zzgjf.zzd(), zzgjf2.zzd());
    }
}
