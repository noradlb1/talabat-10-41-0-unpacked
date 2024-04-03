package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzea  reason: invalid package */
final class zzea extends zzkk {
    final /* synthetic */ zzeb zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzea(zzeb zzeb, Class cls) {
        super(cls);
        this.zza = zzeb;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzpt zzpt = (zzpt) zzaif;
        zzpp zzb = zzpq.zzb();
        byte[] zza2 = zzwa.zza(zzpt.zza());
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        zzb.zzb(zzpt.zze());
        zzb.zzc(0);
        return (zzpq) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzpt.zzd(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzeb.zzg(16, 16, 1));
        hashMap.put("AES128_EAX_RAW", zzeb.zzg(16, 16, 3));
        hashMap.put("AES256_EAX", zzeb.zzg(32, 16, 1));
        hashMap.put("AES256_EAX_RAW", zzeb.zzg(32, 16, 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzpt zzpt = (zzpt) zzaif;
        zzwc.zzb(zzpt.zza());
        if (zzpt.zze().zza() != 12 && zzpt.zze().zza() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }
}
