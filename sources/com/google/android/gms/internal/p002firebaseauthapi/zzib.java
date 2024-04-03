package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzib  reason: invalid package */
final class zzib {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;
    private static final Map zzg;
    private static final Map zzh;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zzhx.zza, zzhw.class, cls);
        zzd = zzlc.zzb(zzhy.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zzhz.zza, zzho.class, cls2);
        zzf = zzke.zzb(zzia.zza, zzb2, cls2);
        HashMap hashMap = new HashMap();
        zzhu zzhu = zzhu.zzc;
        zzud zzud = zzud.RAW;
        hashMap.put(zzhu, zzud);
        zzhu zzhu2 = zzhu.zza;
        zzud zzud2 = zzud.TINK;
        hashMap.put(zzhu2, zzud2);
        zzhu zzhu3 = zzhu.zzb;
        zzud zzud3 = zzud.CRUNCHY;
        hashMap.put(zzhu3, zzud3);
        zzg = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzud.class);
        enumMap.put(zzud, zzhu);
        enumMap.put(zzud2, zzhu2);
        enumMap.put(zzud3, zzhu3);
        enumMap.put(zzud.LEGACY, zzhu3);
        zzh = Collections.unmodifiableMap(enumMap);
    }

    public static /* synthetic */ zzho zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzql zzd2 = zzql.zzd(zzlt.zze(), zzagn.zza());
                if (zzd2.zza() == 0) {
                    zzht zzht = new zzht((zzhs) null);
                    zzht.zza(zzd2.zze().zzd());
                    zzht.zzb(zze(zzlt.zzc()));
                    zzhw zzc2 = zzht.zzc();
                    zzhm zzhm = new zzhm((zzhl) null);
                    zzhm.zzc(zzc2);
                    zzhm.zzb(zzwg.zzb(zzd2.zze().zzq(), zzcr));
                    zzhm.zza(zzlt.zzf());
                    return zzhm.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzhw zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesSivKey")) {
            try {
                zzqo zze2 = zzqo.zze(zzlu.zzc().zzf(), zzagn.zza());
                if (zze2.zzb() == 0) {
                    zzht zzht = new zzht((zzhs) null);
                    zzht.zza(zze2.zza());
                    zzht.zzb(zze(zzlu.zzc().zze()));
                    return zzht.zzc();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static /* synthetic */ zzlu zzc(zzhw zzhw) {
        zztb zza2 = zztc.zza();
        zza2.zzb("type.googleapis.com/google.crypto.tink.AesSivKey");
        zzqn zzc2 = zzqo.zzc();
        zzc2.zza(zzhw.zza());
        zza2.zzc(((zzqo) zzc2.zzi()).zzo());
        zzhu zzb2 = zzhw.zzb();
        Map map = zzg;
        if (map.containsKey(zzb2)) {
            zza2.zza((zzud) map.get(zzb2));
            return zzlu.zzb((zztc) zza2.zzi());
        }
        throw new GeneralSecurityException("Unable to serialize variant: ".concat(String.valueOf(zzb2)));
    }

    public static void zzd(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzhu zze(zzud zzud) throws GeneralSecurityException {
        Map map = zzh;
        if (map.containsKey(zzud)) {
            return (zzhu) map.get(zzud);
        }
        int zza2 = zzud.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }
}
