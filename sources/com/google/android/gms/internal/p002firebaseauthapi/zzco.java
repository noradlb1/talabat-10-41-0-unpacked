package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzco  reason: invalid package */
final class zzco extends zzbo implements zzcn {
    private final zzls zza;
    private final zzkl zzb;

    public zzco(zzls zzls, zzkl zzkl, Class cls) {
        super(zzls, cls);
        this.zza = zzls;
        this.zzb = zzkl;
    }

    public final zzsx zzd(zzafv zzafv) throws GeneralSecurityException {
        try {
            zzaif zzc = this.zza.zzc(zzafv);
            this.zza.zze(zzc);
            zzaif zzg = this.zza.zzg(zzc);
            this.zzb.zze(zzg);
            zzsu zza2 = zzsx.zza();
            zza2.zzb(this.zzb.zzd());
            zza2.zzc(zzg.zzo());
            zza2.zza(this.zzb.zzb());
            return (zzsx) zza2.zzi();
        } catch (zzahi e11) {
            throw new GeneralSecurityException("expected serialized proto of type ", e11);
        }
    }
}
