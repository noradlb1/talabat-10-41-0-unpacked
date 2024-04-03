package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

final class zzdoi implements zzday<zzdbc> {
    private final Map<String, zzeht<zzdbc>> zza;
    private final Map<String, zzeht<zzdpx>> zzb;
    private final Map<String, zzekh<zzdpx>> zzc;
    private final zzgqe<zzday<zzcyw>> zzd;
    private final zzdqn zze;

    public zzdoi(Map<String, zzeht<zzdbc>> map, Map<String, zzeht<zzdpx>> map2, Map<String, zzekh<zzdpx>> map3, zzgqe<zzday<zzcyw>> zzgqe, zzdqn zzdqn) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzgqe;
        this.zze = zzdqn;
    }

    @Nullable
    public final zzeht<zzdbc> zza(int i11, String str) {
        zzeht zza2;
        zzeht<zzdbc> zzeht = this.zza.get(str);
        if (zzeht != null) {
            return zzeht;
        }
        if (i11 != 1) {
            if (i11 != 4) {
                return null;
            }
            zzekh zzekh = this.zzc.get(str);
            if (zzekh != null) {
                return new zzehu(zzekh, zzdbb.zza);
            }
            zzeht zzeht2 = this.zzb.get(str);
            if (zzeht2 == null) {
                return null;
            }
            return zzdbc.zza(zzeht2);
        } else if (this.zze.zze() == null || (zza2 = this.zzd.zzb().zza(i11, str)) == null) {
            return null;
        } else {
            return zzdbc.zza(zza2);
        }
    }
}
