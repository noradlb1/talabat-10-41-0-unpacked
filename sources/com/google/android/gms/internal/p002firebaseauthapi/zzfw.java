package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfw  reason: invalid package */
final class zzfw extends zzkk {
    final /* synthetic */ zzfx zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfw(zzfx zzfx, Class cls) {
        super(cls);
        this.zza = zzfx;
    }

    public final /* bridge */ /* synthetic */ zzaif zza(zzaif zzaif) throws GeneralSecurityException {
        zzqu zzqu = (zzqu) zzaif;
        zzqq zzb = zzqr.zzb();
        zzb.zzb(0);
        byte[] zza2 = zzwa.zza(32);
        zzb.zza(zzafv.zzn(zza2, 0, zza2.length));
        return (zzqr) zzb.zzi();
    }

    public final /* synthetic */ zzaif zzb(zzafv zzafv) throws zzahi {
        return zzqu.zzc(zzafv, zzagn.zza());
    }

    public final Map zzc() throws GeneralSecurityException {
        HashMap hashMap = new HashMap();
        hashMap.put("CHACHA20_POLY1305", new zzkj(zzqu.zzb(), 1));
        hashMap.put("CHACHA20_POLY1305_RAW", new zzkj(zzqu.zzb(), 3));
        return Collections.unmodifiableMap(hashMap);
    }

    public final /* bridge */ /* synthetic */ void zzd(zzaif zzaif) throws GeneralSecurityException {
        zzqu zzqu = (zzqu) zzaif;
    }
}
