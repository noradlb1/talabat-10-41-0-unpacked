package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcs  reason: invalid package */
final class zzcs {
    public static final Charset zza = Charset.forName("UTF-8");

    public static zztp zza(zztk zztk) {
        zztm zza2 = zztp.zza();
        zza2.zzb(zztk.zzb());
        for (zztj zztj : zztk.zzh()) {
            zztn zzb = zzto.zzb();
            zzb.zzc(zztj.zzb().zzf());
            zzb.zzd(zztj.zzk());
            zzb.zzb(zztj.zze());
            zzb.zza(zztj.zza());
            zza2.zza((zzto) zzb.zzi());
        }
        return (zztp) zza2.zzi();
    }
}
