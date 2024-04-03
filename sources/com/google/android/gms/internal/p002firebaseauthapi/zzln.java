package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzln  reason: invalid package */
public final class zzln {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;

    private zzln() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzln zza(zzlk zzlk) throws GeneralSecurityException {
        zzlp zzlp = new zzlp(zzlk.zzc(), zzlk.zzd(), (zzlo) null);
        if (this.zza.containsKey(zzlp)) {
            zzlk zzlk2 = (zzlk) this.zza.get(zzlp);
            if (!zzlk2.equals(zzlk) || !zzlk.equals(zzlk2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: ".concat(zzlp.toString()));
            }
        } else {
            this.zza.put(zzlp, zzlk);
        }
        return this;
    }

    public final zzln zzb(zzcm zzcm) throws GeneralSecurityException {
        if (zzcm != null) {
            Map map = this.zzb;
            Class zzb2 = zzcm.zzb();
            if (map.containsKey(zzb2)) {
                zzcm zzcm2 = (zzcm) this.zzb.get(zzb2);
                if (!zzcm2.equals(zzcm) || !zzcm.equals(zzcm2)) {
                    throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type".concat(zzb2.toString()));
                }
            } else {
                this.zzb.put(zzb2, zzcm);
            }
            return this;
        }
        throw new NullPointerException("wrapper must be non-null");
    }

    public /* synthetic */ zzln(zzlm zzlm) {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public /* synthetic */ zzln(zzlr zzlr, zzlm zzlm) {
        this.zza = new HashMap(zzlr.zza);
        this.zzb = new HashMap(zzlr.zzb);
    }
}
