package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkl  reason: invalid package */
public abstract class zzkl {
    private final Class zza;
    private final Map zzb;
    private final Class zzc;

    @SafeVarargs
    public zzkl(Class cls, zzll... zzllArr) {
        this.zza = cls;
        HashMap hashMap = new HashMap();
        int i11 = 0;
        while (i11 <= 0) {
            zzll zzll = zzllArr[i11];
            if (!hashMap.containsKey(zzll.zzb())) {
                hashMap.put(zzll.zzb(), zzll);
                i11++;
            } else {
                throw new IllegalArgumentException("KeyTypeManager constructed with duplicate factories for primitive ".concat(String.valueOf(zzll.zzb().getCanonicalName())));
            }
        }
        this.zzc = zzllArr[0].zzb();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public zzkk zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract zzsw zzb();

    public abstract zzaif zzc(zzafv zzafv) throws zzahi;

    public abstract String zzd();

    public abstract void zze(zzaif zzaif) throws GeneralSecurityException;

    public int zzf() {
        return 1;
    }

    public final Class zzj() {
        return this.zzc;
    }

    public final Class zzk() {
        return this.zza;
    }

    public final Object zzl(zzaif zzaif, Class cls) throws GeneralSecurityException {
        zzll zzll = (zzll) this.zzb.get(cls);
        if (zzll != null) {
            return zzll.zza(zzaif);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException("Requested primitive class " + canonicalName + " not supported.");
    }

    public final Set zzm() {
        return this.zzb.keySet();
    }
}
