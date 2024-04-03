package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlr  reason: invalid package */
public final class zzlr {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    public /* synthetic */ zzlr(zzln zzln, zzlq zzlq) {
        this.zza = new HashMap(zzln.zza);
        this.zzb = new HashMap(zzln.zzb);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzcm) this.zzb.get(cls)).zza();
        }
        String obj = cls.toString();
        throw new GeneralSecurityException("No input primitive class for " + obj + " available");
    }

    public final Object zzb(zzbm zzbm, Class cls) throws GeneralSecurityException {
        zzlp zzlp = new zzlp(zzbm.getClass(), cls, (zzlo) null);
        if (this.zza.containsKey(zzlp)) {
            return ((zzlk) this.zza.get(zzlp)).zza(zzbm);
        }
        String obj = zzlp.toString();
        throw new GeneralSecurityException("No PrimitiveConstructor for " + obj + " available");
    }

    public final Object zzc(zzcl zzcl, Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            zzcm zzcm = (zzcm) this.zzb.get(cls);
            if (zzcl.zzc().equals(zzcm.zza()) && zzcm.zza().equals(zzcl.zzc())) {
                return zzcm.zzc(zzcl);
            }
            throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
        }
        throw new GeneralSecurityException("No wrapper found for ".concat(cls.toString()));
    }
}
