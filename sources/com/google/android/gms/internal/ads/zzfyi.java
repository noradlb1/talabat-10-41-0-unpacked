package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzglv;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class zzfyi<KeyProtoT extends zzglv> {
    private final Class<KeyProtoT> zza;
    private final Map<Class<?>, zzfyh<?, KeyProtoT>> zzb;
    private final Class<?> zzc;

    @SafeVarargs
    public zzfyi(Class<KeyProtoT> cls, zzfyh<?, KeyProtoT>... zzfyhArr) {
        String str;
        this.zza = cls;
        HashMap hashMap = new HashMap();
        for (int i11 = 0; i11 <= 0; i11++) {
            zzfyh<?, KeyProtoT> zzfyh = zzfyhArr[i11];
            if (hashMap.containsKey(zzfyh.zza())) {
                String valueOf = String.valueOf(zzfyh.zza().getCanonicalName());
                if (valueOf.length() != 0) {
                    str = "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf);
                } else {
                    str = new String("KeyTypeManager constructed with duplicate factories for primitive ");
                }
                throw new IllegalArgumentException(str);
            }
            hashMap.put(zzfyh.zza(), zzfyh);
        }
        this.zzc = zzfyhArr[0].zza();
        this.zzb = Collections.unmodifiableMap(hashMap);
    }

    public zzfyg<?, KeyProtoT> zza() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract KeyProtoT zzb(zzgjf zzgjf) throws zzgkx;

    public final Class<?> zzc() {
        return this.zzc;
    }

    public final Class<KeyProtoT> zzd() {
        return this.zza;
    }

    public final <P> P zze(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzfyh zzfyh = this.zzb.get(cls);
        if (zzfyh != null) {
            return zzfyh.zzb(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        StringBuilder sb2 = new StringBuilder(String.valueOf(canonicalName).length() + 41);
        sb2.append("Requested primitive class ");
        sb2.append(canonicalName);
        sb2.append(" not supported.");
        throw new IllegalArgumentException(sb2.toString());
    }

    public abstract String zzf();

    public final Set<Class<?>> zzg() {
        return this.zzb.keySet();
    }

    public abstract void zzh(KeyProtoT keyprotot) throws GeneralSecurityException;

    public int zzi() {
        return 1;
    }

    public abstract int zzj();
}
