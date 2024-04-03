package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzbs  reason: invalid package */
final class zzbs {
    private static final Logger zza = Logger.getLogger(zzbs.class.getName());
    private final ConcurrentMap zzb;

    public zzbs() {
        this.zzb = new ConcurrentHashMap();
    }

    private final synchronized zzbr zzf(String str) throws GeneralSecurityException {
        if (this.zzb.containsKey(str)) {
        } else {
            throw new GeneralSecurityException("No key manager found for key type ".concat(String.valueOf(str)));
        }
        return (zzbr) this.zzb.get(str);
    }

    private final synchronized void zzg(zzbr zzbr, boolean z11) throws GeneralSecurityException {
        String zzc = zzbr.zzb().zzc();
        zzbr zzbr2 = (zzbr) this.zzb.get(zzc);
        if (zzbr2 != null) {
            if (!zzbr2.zzc().equals(zzbr.zzc())) {
                zza.logp(Level.WARNING, "com.google.crypto.tink.KeyManagerRegistry", "registerKeyManagerContainer", "Attempted overwrite of a registered key manager for key type ".concat(zzc));
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{zzc, zzbr2.zzc().getName(), zzbr.zzc().getName()}));
            }
        }
        if (!z11) {
            this.zzb.putIfAbsent(zzc, zzbr);
        } else {
            this.zzb.put(zzc, zzbr);
        }
    }

    public final zzbn zza(String str, Class cls) throws GeneralSecurityException {
        zzbr zzf = zzf(str);
        if (zzf.zze().contains(cls)) {
            return zzf.zza(cls);
        }
        String name2 = cls.getName();
        String valueOf = String.valueOf(zzf.zzc());
        Set<Class> zze = zzf.zze();
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (Class cls2 : zze) {
            if (!z11) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(cls2.getCanonicalName());
            z11 = false;
        }
        String sb3 = sb2.toString();
        throw new GeneralSecurityException("Primitive type " + name2 + " not supported by key manager of type " + valueOf + ", supported primitives: " + sb3);
    }

    public final zzbn zzb(String str) throws GeneralSecurityException {
        return zzf(str).zzb();
    }

    public final synchronized void zzc(zzls zzls, zzkl zzkl) throws GeneralSecurityException {
        Class zzd;
        if (!zzhj.zza(1)) {
            String valueOf = String.valueOf(zzls.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        } else if (zzhj.zza(zzkl.zzf())) {
            String zzd2 = zzls.zzd();
            String zzd3 = zzkl.zzd();
            if (!(!this.zzb.containsKey(zzd2) || ((zzbr) this.zzb.get(zzd2)).zzd() == null || (zzd = ((zzbr) this.zzb.get(zzd2)).zzd()) == null)) {
                if (!zzd.getName().equals(zzkl.getClass().getName())) {
                    Logger logger = zza;
                    Level level = Level.WARNING;
                    logger.logp(level, "com.google.crypto.tink.KeyManagerRegistry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type " + zzd2 + " with inconsistent public key type " + zzd3);
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzls.getClass().getName(), zzd.getName(), zzkl.getClass().getName()}));
                }
            }
            zzg(new zzbq(zzls, zzkl), true);
            zzg(new zzbp(zzkl), false);
        } else {
            String valueOf2 = String.valueOf(zzkl.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf2 + " as it is not FIPS compatible.");
        }
    }

    public final synchronized void zzd(zzkl zzkl) throws GeneralSecurityException {
        if (zzhj.zza(zzkl.zzf())) {
            zzg(new zzbp(zzkl), false);
        } else {
            String valueOf = String.valueOf(zzkl.getClass());
            throw new GeneralSecurityException("failed to register key manager " + valueOf + " as it is not FIPS compatible.");
        }
    }

    public final boolean zze(String str) {
        return this.zzb.containsKey(str);
    }

    public zzbs(zzbs zzbs) {
        this.zzb = new ConcurrentHashMap(zzbs.zzb);
    }
}
