package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeuz implements zzevm<Bundle> {
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final Long zze;

    public zzeuz(String str, String str2, String str3, String str4, Long l11) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = l11;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfeq.zzc(bundle, "gmp_app_id", this.zza);
        zzfeq.zzc(bundle, "fbs_aiid", this.zzb);
        zzfeq.zzc(bundle, "fbs_aeid", this.zzc);
        zzfeq.zzc(bundle, "apm_id_origin", this.zzd);
        Long l11 = this.zze;
        if (l11 != null) {
            bundle.putLong("sai_timeout", l11.longValue());
        }
    }
}
