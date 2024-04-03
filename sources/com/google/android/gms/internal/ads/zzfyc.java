package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzglv;
import java.security.GeneralSecurityException;

class zzfyc<PrimitiveT, KeyProtoT extends zzglv> implements zzfya<PrimitiveT> {
    private final zzfyi<KeyProtoT> zza;
    private final Class<PrimitiveT> zzb;

    public zzfyc(zzfyi<KeyProtoT> zzfyi, Class<PrimitiveT> cls) {
        if (zzfyi.zzg().contains(cls) || Void.class.equals(cls)) {
            this.zza = zzfyi;
            this.zzb = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzfyi.toString(), cls.getName()}));
    }

    private final zzfyb<?, KeyProtoT> zzg() {
        return new zzfyb<>(this.zza.zza());
    }

    private final PrimitiveT zzh(KeyProtoT keyprotot) throws GeneralSecurityException {
        if (!Void.class.equals(this.zzb)) {
            this.zza.zzh(keyprotot);
            return this.zza.zze(keyprotot, this.zzb);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    public final zzgff zza(zzgjf zzgjf) throws GeneralSecurityException {
        try {
            zzglv zza2 = zzg().zza(zzgjf);
            zzgfe zza3 = zzgff.zza();
            zza3.zza(this.zza.zzf());
            zza3.zzb(zza2.zzao());
            zza3.zzc(this.zza.zzj());
            return (zzgff) zza3.zzah();
        } catch (zzgkx e11) {
            throw new GeneralSecurityException("Unexpected proto", e11);
        }
    }

    public final zzglv zzb(zzgjf zzgjf) throws GeneralSecurityException {
        String str;
        try {
            return zzg().zza(zzgjf);
        } catch (zzgkx e11) {
            String name2 = this.zza.zza().zzb().getName();
            if (name2.length() != 0) {
                str = "Failures parsing proto of type ".concat(name2);
            } else {
                str = new String("Failures parsing proto of type ");
            }
            throw new GeneralSecurityException(str, e11);
        }
    }

    public final Class<PrimitiveT> zzc() {
        return this.zzb;
    }

    public final PrimitiveT zzd(zzgjf zzgjf) throws GeneralSecurityException {
        String str;
        try {
            return zzh(this.zza.zzb(zzgjf));
        } catch (zzgkx e11) {
            String name2 = this.zza.zzd().getName();
            if (name2.length() != 0) {
                str = "Failures parsing proto of type ".concat(name2);
            } else {
                str = new String("Failures parsing proto of type ");
            }
            throw new GeneralSecurityException(str, e11);
        }
    }

    public final PrimitiveT zze(zzglv zzglv) throws GeneralSecurityException {
        String str;
        String name2 = this.zza.zzd().getName();
        if (name2.length() != 0) {
            str = "Expected proto of type ".concat(name2);
        } else {
            str = new String("Expected proto of type ");
        }
        if (this.zza.zzd().isInstance(zzglv)) {
            return zzh(zzglv);
        }
        throw new GeneralSecurityException(str);
    }

    public final String zzf() {
        return this.zza.zzf();
    }
}
