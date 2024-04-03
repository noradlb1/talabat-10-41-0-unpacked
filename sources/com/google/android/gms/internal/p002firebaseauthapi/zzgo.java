package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgo  reason: invalid package */
final class zzgo extends zzkk {
    final /* synthetic */ zzgp zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzgo(zzgp zzgp, Class cls) {
        super(cls);
        this.zza = zzgp;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzum zzum = (zzum) zzaif;
        zzui zzb = zzuj.zzb();
        zzb.zzb(0);
        byte[] zza2 = zzwa.zza(32);
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        return (zzuj) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzum.zzd(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("XCHACHA20_POLY1305", new zzkj(zzum.zzc(), 1));
        hashMap.put("XCHACHA20_POLY1305_RAW", new zzkj(zzum.zzc(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzum zzum = (zzum) zzaif;
    }
}
