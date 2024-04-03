package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeb  reason: invalid package */
public final class zzeb extends zzkl {
    public zzeb() {
        super(zzpq.class, new zzdz(zzbd.class));
    }

    public static /* bridge */ /* synthetic */ zzkj zzg(int i11, int i12, int i13) {
        zzps zzb = zzpt.zzb();
        zzb.zza(i11);
        zzpv zzb2 = zzpw.zzb();
        zzb2.zza(16);
        zzb.zzb((zzpw) zzb2.zzi());
        return new zzkj((zzpt) zzb.zzi(), i13);
    }

    public final zzkk zza() {
        return new zzea(this, zzpt.class);
    }

    public final zzsw zzb() {
        return zzsw.SYMMETRIC;
    }

    public final /* synthetic */ zzaif zzc(zzafv zzafv) throws zzahi {
        return zzpq.zzd(zzafv, zzagn.zza());
    }

    public final String zzd() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public final /* bridge */ /* synthetic */ void zze(zzaif zzaif) throws GeneralSecurityException {
        zzpq zzpq = (zzpq) zzaif;
        zzwc.zzc(zzpq.zza(), 0);
        zzwc.zzb(zzpq.zzf().zzd());
        if (zzpq.zze().zza() != 12 && zzpq.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
