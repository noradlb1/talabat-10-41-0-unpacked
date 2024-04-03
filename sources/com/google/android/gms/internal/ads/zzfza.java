package com.google.android.gms.internal.ads;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzfza {
    private static final Logger zza = Logger.getLogger(zzfza.class.getName());
    private static final ConcurrentMap<String, zzfyz> zzb = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzfyy> zzc = new ConcurrentHashMap();
    private static final ConcurrentMap<String, Boolean> zzd = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzfxv<?>> zze = new ConcurrentHashMap();
    private static final ConcurrentMap<Class<?>, zzfys<?, ?>> zzf = new ConcurrentHashMap();
    private static final ConcurrentMap<String, zzfyd> zzg = new ConcurrentHashMap();

    private zzfza() {
    }

    @Deprecated
    public static zzfxv<?> zza(String str) throws GeneralSecurityException {
        if (str != null) {
            ConcurrentMap<String, zzfxv<?>> concurrentMap = zze;
            Locale locale = Locale.US;
            zzfxv<?> zzfxv = concurrentMap.get(str.toLowerCase(locale));
            if (zzfxv != null) {
                return zzfxv;
            }
            String format = String.format("no catalogue found for %s. ", new Object[]{str});
            if (str.toLowerCase(locale).startsWith("tinkaead")) {
                format = String.valueOf(format).concat("Maybe call AeadConfig.register().");
            }
            if (str.toLowerCase(locale).startsWith("tinkdeterministicaead")) {
                format = String.valueOf(format).concat("Maybe call DeterministicAeadConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkstreamingaead")) {
                format = String.valueOf(format).concat("Maybe call StreamingAeadConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkhybriddecrypt") || str.toLowerCase(locale).startsWith("tinkhybridencrypt")) {
                format = String.valueOf(format).concat("Maybe call HybridConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkmac")) {
                format = String.valueOf(format).concat("Maybe call MacConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tinkpublickeysign") || str.toLowerCase(locale).startsWith("tinkpublickeyverify")) {
                format = String.valueOf(format).concat("Maybe call SignatureConfig.register().");
            } else if (str.toLowerCase(locale).startsWith("tink")) {
                format = String.valueOf(format).concat("Maybe call TinkConfig.register().");
            }
            throw new GeneralSecurityException(format);
        }
        throw new IllegalArgumentException("catalogueName must be non-null.");
    }

    public static zzfya<?> zzb(String str) throws GeneralSecurityException {
        return zzp(str).zzb();
    }

    public static synchronized zzgff zzc(zzgfi zzgfi) throws GeneralSecurityException {
        String str;
        zzgff zza2;
        synchronized (zzfza.class) {
            zzfya<?> zzb2 = zzb(zzgfi.zzf());
            if (zzd.get(zzgfi.zzf()).booleanValue()) {
                zza2 = zzb2.zza(zzgfi.zze());
            } else {
                String valueOf = String.valueOf(zzgfi.zzf());
                if (valueOf.length() != 0) {
                    str = "newKey-operation not permitted for key type ".concat(valueOf);
                } else {
                    str = new String("newKey-operation not permitted for key type ");
                }
                throw new GeneralSecurityException(str);
            }
        }
        return zza2;
    }

    public static synchronized zzglv zzd(zzgfi zzgfi) throws GeneralSecurityException {
        String str;
        zzglv zzb2;
        synchronized (zzfza.class) {
            zzfya<?> zzb3 = zzb(zzgfi.zzf());
            if (zzd.get(zzgfi.zzf()).booleanValue()) {
                zzb2 = zzb3.zzb(zzgfi.zze());
            } else {
                String valueOf = String.valueOf(zzgfi.zzf());
                if (valueOf.length() != 0) {
                    str = "newKey-operation not permitted for key type ".concat(valueOf);
                } else {
                    str = new String("newKey-operation not permitted for key type ");
                }
                throw new GeneralSecurityException(str);
            }
        }
        return zzb2;
    }

    public static Class<?> zze(Class<?> cls) {
        zzfys zzfys = zzf.get(cls);
        if (zzfys == null) {
            return null;
        }
        return zzfys.zza();
    }

    public static <P> P zzf(zzgff zzgff, Class<P> cls) throws GeneralSecurityException {
        return zzq(zzgff.zzf(), zzgff.zze(), cls);
    }

    public static <P> P zzg(String str, zzglv zzglv, Class<P> cls) throws GeneralSecurityException {
        return zzo(str, cls).zze(zzglv);
    }

    public static <P> P zzh(String str, byte[] bArr, Class<P> cls) throws GeneralSecurityException {
        return zzq(str, zzgjf.zzv(bArr), cls);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [com.google.android.gms.internal.ads.zzfyr, com.google.android.gms.internal.ads.zzfyr<B>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <B, P> P zzi(com.google.android.gms.internal.ads.zzfyr<B> r4, java.lang.Class<P> r5) throws java.security.GeneralSecurityException {
        /*
            java.util.concurrent.ConcurrentMap<java.lang.Class<?>, com.google.android.gms.internal.ads.zzfys<?, ?>> r0 = zzf
            java.lang.Object r5 = r0.get(r5)
            com.google.android.gms.internal.ads.zzfys r5 = (com.google.android.gms.internal.ads.zzfys) r5
            if (r5 != 0) goto L_0x002a
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            java.lang.Class r4 = r4.zzd()
            java.lang.String r4 = r4.getName()
            int r0 = r4.length()
            java.lang.String r1 = "No wrapper found for "
            if (r0 == 0) goto L_0x0021
            java.lang.String r4 = r1.concat(r4)
            goto L_0x0026
        L_0x0021:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r1)
        L_0x0026:
            r5.<init>(r4)
            throw r5
        L_0x002a:
            java.lang.Class r0 = r5.zza()
            java.lang.Class r1 = r4.zzd()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003d
            java.lang.Object r4 = r5.zzc(r4)
            return r4
        L_0x003d:
            java.security.GeneralSecurityException r0 = new java.security.GeneralSecurityException
            java.lang.Class r5 = r5.zza()
            java.lang.String r5 = r5.toString()
            java.lang.Class r4 = r4.zzd()
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r2 = r5.length()
            int r2 = r2 + 44
            int r3 = r4.length()
            int r2 = r2 + r3
            r1.<init>(r2)
            java.lang.String r2 = "Wrong input primitive class, expected "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = ", got "
            r1.append(r5)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfza.zzi(com.google.android.gms.internal.ads.zzfyr, java.lang.Class):java.lang.Object");
    }

    public static synchronized Map<String, zzfyd> zzj() {
        Map<String, zzfyd> unmodifiableMap;
        synchronized (zzfza.class) {
            unmodifiableMap = Collections.unmodifiableMap(zzg);
        }
        return unmodifiableMap;
    }

    public static synchronized <KeyProtoT extends zzglv, PublicKeyProtoT extends zzglv> void zzk(zzfyu<KeyProtoT, PublicKeyProtoT> zzfyu, zzfyi<PublicKeyProtoT> zzfyi, boolean z11) throws GeneralSecurityException {
        Class<?> zzd2;
        synchronized (zzfza.class) {
            zzr("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzfyu.getClass(), zzfyu.zza().zzd(), true);
            zzr("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzfyi.getClass(), Collections.emptyMap(), false);
            if (!zzgak.zza(1)) {
                String valueOf = String.valueOf(zzfyu.getClass());
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 61);
                sb2.append("failed to register key manager ");
                sb2.append(valueOf);
                sb2.append(" as it is not FIPS compatible.");
                throw new GeneralSecurityException(sb2.toString());
            } else if (zzgak.zza(1)) {
                ConcurrentMap<String, zzfyz> concurrentMap = zzb;
                if (concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") && (zzd2 = concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zzd()) != null) {
                    if (!zzd2.getName().equals(zzfyi.getClass().getName())) {
                        zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", "Attempted overwrite of a registered key manager for key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey with inconsistent public key type type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                        throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", new Object[]{zzfyu.getClass().getName(), zzd2.getName(), zzfyi.getClass().getName()}));
                    }
                }
                if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") || concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zzd() == null) {
                    concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzfyx(zzfyu, zzfyi));
                    zzc.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new zzfyy(zzfyu));
                    zzs("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzfyu.zza().zzd());
                }
                ConcurrentMap<String, Boolean> concurrentMap2 = zzd;
                concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", Boolean.TRUE);
                if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                    concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", new zzfyw(zzfyi));
                }
                concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", Boolean.FALSE);
            } else {
                String valueOf2 = String.valueOf(zzfyi.getClass());
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 61);
                sb3.append("failed to register key manager ");
                sb3.append(valueOf2);
                sb3.append(" as it is not FIPS compatible.");
                throw new GeneralSecurityException(sb3.toString());
            }
        }
    }

    public static synchronized <P> void zzl(zzfya<P> zzfya, boolean z11) throws GeneralSecurityException {
        synchronized (zzfza.class) {
            if (zzfya != null) {
                String zzf2 = zzfya.zzf();
                zzr(zzf2, zzfya.getClass(), Collections.emptyMap(), z11);
                zzb.putIfAbsent(zzf2, new zzfyv(zzfya));
                zzd.put(zzf2, Boolean.valueOf(z11));
            } else {
                throw new IllegalArgumentException("key manager must be non-null.");
            }
        }
    }

    public static synchronized <KeyProtoT extends zzglv> void zzm(zzfyi<KeyProtoT> zzfyi, boolean z11) throws GeneralSecurityException {
        synchronized (zzfza.class) {
            String zzf2 = zzfyi.zzf();
            zzr(zzf2, zzfyi.getClass(), zzfyi.zza().zzd(), true);
            if (zzgak.zza(zzfyi.zzi())) {
                ConcurrentMap<String, zzfyz> concurrentMap = zzb;
                if (!concurrentMap.containsKey(zzf2)) {
                    concurrentMap.put(zzf2, new zzfyw(zzfyi));
                    zzc.put(zzf2, new zzfyy(zzfyi));
                    zzs(zzf2, zzfyi.zza().zzd());
                }
                zzd.put(zzf2, Boolean.TRUE);
            } else {
                String valueOf = String.valueOf(zzfyi.getClass());
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 61);
                sb2.append("failed to register key manager ");
                sb2.append(valueOf);
                sb2.append(" as it is not FIPS compatible.");
                throw new GeneralSecurityException(sb2.toString());
            }
        }
    }

    public static synchronized <B, P> void zzn(zzfys<B, P> zzfys) throws GeneralSecurityException {
        synchronized (zzfza.class) {
            if (zzfys != null) {
                Class<P> zzb2 = zzfys.zzb();
                ConcurrentMap<Class<?>, zzfys<?, ?>> concurrentMap = zzf;
                if (concurrentMap.containsKey(zzb2)) {
                    zzfys zzfys2 = concurrentMap.get(zzb2);
                    if (!zzfys.getClass().getName().equals(zzfys2.getClass().getName())) {
                        zza.logp(Level.WARNING, "com.google.crypto.tink.Registry", "registerPrimitiveWrapper", "Attempted overwrite of a registered PrimitiveWrapper for type ".concat(zzb2.toString()));
                        throw new GeneralSecurityException(String.format("PrimitiveWrapper for primitive (%s) is already registered to be %s, cannot be re-registered with %s", new Object[]{zzb2.getName(), zzfys2.getClass().getName(), zzfys.getClass().getName()}));
                    }
                }
                concurrentMap.put(zzb2, zzfys);
            } else {
                throw new IllegalArgumentException("wrapper must be non-null");
            }
        }
    }

    private static <P> zzfya<P> zzo(String str, Class<P> cls) throws GeneralSecurityException {
        zzfyz zzp = zzp(str);
        if (zzp.zze().contains(cls)) {
            return zzp.zza(cls);
        }
        String name2 = cls.getName();
        String valueOf = String.valueOf(zzp.zzc());
        Set<Class<?>> zze2 = zzp.zze();
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = true;
        for (Class next : zze2) {
            if (!z11) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            sb2.append(next.getCanonicalName());
            z11 = false;
        }
        String sb3 = sb2.toString();
        StringBuilder sb4 = new StringBuilder(name2.length() + 77 + valueOf.length() + sb3.length());
        sb4.append("Primitive type ");
        sb4.append(name2);
        sb4.append(" not supported by key manager of type ");
        sb4.append(valueOf);
        sb4.append(", supported primitives: ");
        sb4.append(sb3);
        throw new GeneralSecurityException(sb4.toString());
    }

    private static synchronized zzfyz zzp(String str) throws GeneralSecurityException {
        zzfyz zzfyz;
        String str2;
        synchronized (zzfza.class) {
            ConcurrentMap<String, zzfyz> concurrentMap = zzb;
            if (!concurrentMap.containsKey(str)) {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    str2 = "No key manager found for key type ".concat(valueOf);
                } else {
                    str2 = new String("No key manager found for key type ");
                }
                throw new GeneralSecurityException(str2);
            }
            zzfyz = concurrentMap.get(str);
        }
        return zzfyz;
    }

    private static <P> P zzq(String str, zzgjf zzgjf, Class<P> cls) throws GeneralSecurityException {
        return zzo(str, cls).zzd(zzgjf);
    }

    private static synchronized <KeyProtoT extends zzglv, KeyFormatProtoT extends zzglv> void zzr(String str, Class cls, Map<String, zzfyf<KeyFormatProtoT>> map, boolean z11) throws GeneralSecurityException {
        String str2;
        String str3;
        String str4;
        synchronized (zzfza.class) {
            ConcurrentMap<String, zzfyz> concurrentMap = zzb;
            zzfyz zzfyz = concurrentMap.get(str);
            if (zzfyz != null && !zzfyz.zzc().equals(cls)) {
                Logger logger = zza;
                Level level = Level.WARNING;
                if (str.length() != 0) {
                    str4 = "Attempted overwrite of a registered key manager for key type ".concat(str);
                } else {
                    str4 = new String("Attempted overwrite of a registered key manager for key type ");
                }
                logger.logp(level, "com.google.crypto.tink.Registry", "ensureKeyManagerInsertable", str4);
                throw new GeneralSecurityException(String.format("typeUrl (%s) is already registered with %s, cannot be re-registered with %s", new Object[]{str, zzfyz.zzc().getName(), cls.getName()}));
            } else if (z11) {
                ConcurrentMap<String, Boolean> concurrentMap2 = zzd;
                if (concurrentMap2.containsKey(str) && !concurrentMap2.get(str).booleanValue()) {
                    if (str.length() != 0) {
                        str3 = "New keys are already disallowed for key type ".concat(str);
                    } else {
                        str3 = new String("New keys are already disallowed for key type ");
                    }
                    throw new GeneralSecurityException(str3);
                } else if (concurrentMap.containsKey(str)) {
                    for (Map.Entry next : map.entrySet()) {
                        if (!zzg.containsKey(next.getKey())) {
                            String str5 = (String) next.getKey();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 79 + str.length());
                            sb2.append("Attempted to register a new key template ");
                            sb2.append(str5);
                            sb2.append(" from an existing key manager of type ");
                            sb2.append(str);
                            throw new GeneralSecurityException(sb2.toString());
                        }
                    }
                } else {
                    for (Map.Entry next2 : map.entrySet()) {
                        if (zzg.containsKey(next2.getKey())) {
                            String valueOf = String.valueOf((String) next2.getKey());
                            if (valueOf.length() != 0) {
                                str2 = "Attempted overwrite of a registered key template ".concat(valueOf);
                            } else {
                                str2 = new String("Attempted overwrite of a registered key template ");
                            }
                            throw new GeneralSecurityException(str2);
                        }
                    }
                }
            }
        }
    }

    private static <KeyFormatProtoT extends zzglv> void zzs(String str, Map<String, zzfyf<KeyFormatProtoT>> map) {
        for (Map.Entry next : map.entrySet()) {
            zzg.put((String) next.getKey(), zzfyd.zzd(str, ((zzfyf) next.getValue()).zza.zzar(), ((zzfyf) next.getValue()).zzb));
        }
    }
}
