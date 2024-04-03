package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmn  reason: invalid package */
final class zzmn extends zzkk {
    public zzmn(zzmo zzmo, Class cls) {
        super(cls);
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzov zzov = (zzov) zzaif;
        zzor zzb = zzos.zzb();
        zzb.zzc(0);
        byte[] zza = zzwa.zza(zzov.zza());
        zzb.zza(zzafv.zzn(zza, 0, zza.length));
        zzb.zzb(zzov.zze());
        return (zzos) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzov.zzd(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        zzou zzb = zzov.zzb();
        zzb.zza(32);
        zzox zzb2 = zzoy.zzb();
        zzb2.zza(16);
        zzb.zzb((zzoy) zzb2.zzi());
        hashMap.put("AES_CMAC", new zzkj((zzov) zzb.zzi(), 1));
        zzou zzb3 = zzov.zzb();
        zzb3.zza(32);
        zzox zzb4 = zzoy.zzb();
        zzb4.zza(16);
        zzb3.zzb((zzoy) zzb4.zzi());
        hashMap.put("AES256_CMAC", new zzkj((zzov) zzb3.zzi(), 1));
        zzou zzb5 = zzov.zzb();
        zzb5.zza(32);
        zzox zzb6 = zzoy.zzb();
        zzb6.zza(16);
        zzb5.zzb((zzoy) zzb6.zzi());
        hashMap.put("AES256_CMAC_RAW", new zzkj((zzov) zzb5.zzi(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzov zzov = (zzov) zzaif;
        zzmo.zzn(zzov.zze());
        zzmo.zzo(zzov.zza());
    }
}
