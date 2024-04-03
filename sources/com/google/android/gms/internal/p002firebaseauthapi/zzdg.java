package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdg  reason: invalid package */
public final class zzdg extends zzkl {
    public zzdg() {
        super(zzpb.class, new zzde(zzbd.class));
    }

    public static /* bridge */ /* synthetic */ zzkj zzg(int i11, int i12, int i13, int i14, int i15, int i16) {
        zzpj zzb = zzpk.zzb();
        zzpm zzb2 = zzpn.zzb();
        zzb2.zza(16);
        zzb.zzb((zzpn) zzb2.zzi());
        zzb.zza(i11);
        zzsa zzc = zzsb.zzc();
        zzsd zzb3 = zzse.zzb();
        zzb3.zzb(5);
        zzb3.zza(i14);
        zzc.zzb((zzse) zzb3.zzi());
        zzc.zza(32);
        zzpd zza = zzpe.zza();
        zza.zza((zzpk) zzb.zzi());
        zza.zzb((zzsb) zzc.zzi());
        return new zzkj((zzpe) zza.zzi(), i16);
    }

    public final zzkk zza() {
        return new zzdf(this, zzpe.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzpb.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzpb zzpb = (zzpb) zzaif;
        zzwc.zzc(zzpb.zza(), 0);
        new zzdu();
        zzdu.zzh(zzpb.zze());
        new zznk();
        zznk.zzi(zzpb.zzf());
    }

    public final int zzf() {
        return 2;
    }
}
