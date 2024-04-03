package com.google.android.gms.internal.p002firebaseauthapi;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcq  reason: invalid package */
public final class zzcq {
    public static final /* synthetic */ int zza = 0;
    private static final Logger zzb = Logger.getLogger(zzcq.class.getName());
    private static final AtomicReference zzc = new AtomicReference(new zzbs());
    private static final ConcurrentMap zzd = new ConcurrentHashMap();
    private static final ConcurrentMap zze = new ConcurrentHashMap();
    private static final ConcurrentMap zzf = new ConcurrentHashMap();
    private static final ConcurrentMap zzg = new ConcurrentHashMap();

    private zzcq() {
    }

    public static zzbn zza(String str) throws GeneralSecurityException {
        return ((zzbs) zzc.get()).zzb(str);
    }

    public static synchronized zzsx zzb(zztc zztc) throws GeneralSecurityException {
        zzsx zza2;
        synchronized (zzcq.class) {
            zzbn zza3 = zza(zztc.zzg());
            if (((Boolean) zze.get(zztc.zzg())).booleanValue()) {
                zza2 = zza3.zza(zztc.zzf());
            } else {
                throw new GeneralSecurityException("newKey-operation not permitted for key type ".concat(String.valueOf(zztc.zzg())));
            }
        }
        return zza2;
    }

    @Nullable
    public static Class zzc(Class cls) {
        try {
            return zzkv.zza().zzb(cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public static Object zzd(String str, zzafv zzafv, Class cls) throws GeneralSecurityException {
        return ((zzbs) zzc.get()).zza(str, cls).zzb(zzafv);
    }

    public static synchronized Map zze() {
        Map unmodifiableMap;
        synchronized (zzcq.class) {
            unmodifiableMap = Collections.unmodifiableMap(zzg);
        }
        return unmodifiableMap;
    }

    public static synchronized void zzf(zzls zzls, zzkl zzkl, boolean z11) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            AtomicReference atomicReference = zzc;
            zzbs zzbs = new zzbs((zzbs) atomicReference.get());
            zzbs.zzc(zzls, zzkl);
            Map zzc2 = zzls.zza().zzc();
            String zzd2 = zzls.zzd();
            zzi(zzd2, zzc2, true);
            String zzd3 = zzkl.zzd();
            zzi(zzd3, Collections.emptyMap(), false);
            if (!((zzbs) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcp(zzls));
                zzj(zzls.zzd(), zzls.zza().zzc());
            }
            ConcurrentMap concurrentMap = zze;
            concurrentMap.put(zzd2, Boolean.TRUE);
            concurrentMap.put(zzd3, Boolean.FALSE);
            atomicReference.set(zzbs);
        }
    }

    public static synchronized void zzg(zzkl zzkl, boolean z11) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            AtomicReference atomicReference = zzc;
            zzbs zzbs = new zzbs((zzbs) atomicReference.get());
            zzbs.zzd(zzkl);
            Map zzc2 = zzkl.zza().zzc();
            String zzd2 = zzkl.zzd();
            zzi(zzd2, zzc2, true);
            if (!((zzbs) atomicReference.get()).zze(zzd2)) {
                zzd.put(zzd2, new zzcp(zzkl));
                zzj(zzd2, zzkl.zza().zzc());
            }
            zze.put(zzd2, Boolean.TRUE);
            atomicReference.set(zzbs);
        }
    }

    public static synchronized void zzh(zzcm zzcm) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            zzkv.zza().zzf(zzcm);
        }
    }

    private static synchronized void zzi(String str, Map map, boolean z11) throws GeneralSecurityException {
        synchronized (zzcq.class) {
            if (z11) {
                ConcurrentMap concurrentMap = zze;
                if (concurrentMap.containsKey(str)) {
                    if (!((Boolean) concurrentMap.get(str)).booleanValue()) {
                        throw new GeneralSecurityException("New keys are already disallowed for key type ".concat(str));
                    }
                }
                if (((zzbs) zzc.get()).zze(str)) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (!zzg.containsKey(entry.getKey())) {
                            throw new GeneralSecurityException("Attempted to register a new key template " + ((String) entry.getKey()) + " from an existing key manager of type " + str);
                        }
                    }
                } else {
                    for (Map.Entry entry2 : map.entrySet()) {
                        if (zzg.containsKey(entry2.getKey())) {
                            throw new GeneralSecurityException("Attempted overwrite of a registered key template ".concat(String.valueOf((String) entry2.getKey())));
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r3v2, types: [java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzaif] */
    private static void zzj(String str, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            zzg.put((String) entry.getKey(), zzbu.zzc(str, ((zzkj) entry.getValue()).zza.zzq(), ((zzkj) entry.getValue()).zzb));
        }
    }
}
