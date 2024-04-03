package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfc  reason: invalid package */
final class zzfc {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.AesGcmKey");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zzey.zza, zzex.class, cls);
        zzd = zzlc.zzb(zzez.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zzfa.zza, zzep.class, cls2);
        zzf = zzke.zzb(zzfb.zza, zzb2, cls2);
    }

    public static /* synthetic */ zzep zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzpz zzd2 = zzpz.zzd(zzlt.zze(), zzagn.zza());
                if (zzd2.zza() == 0) {
                    zzeu zzeu = new zzeu((zzet) null);
                    zzeu.zzb(zzd2.zze().zzd());
                    zzeu.zza(12);
                    zzeu.zzc(16);
                    zzeu.zzd(zzd(zzlt.zzc()));
                    zzex zze2 = zzeu.zze();
                    zzen zzen = new zzen((zzem) null);
                    zzen.zzc(zze2);
                    zzen.zzb(zzwg.zzb(zzd2.zze().zzq(), zzcr));
                    zzen.zza(zzlt.zzf());
                    return zzen.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi unused) {
                throw new GeneralSecurityException("Parsing AesGcmKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzex zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzqc zze2 = zzqc.zze(zzlu.zzc().zzf(), zzagn.zza());
                if (zze2.zzb() == 0) {
                    zzeu zzeu = new zzeu((zzet) null);
                    zzeu.zzb(zze2.zza());
                    zzeu.zza(12);
                    zzeu.zzc(16);
                    zzeu.zzd(zzd(zzlu.zzc().zze()));
                    return zzeu.zze();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing AesGcmParameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmParameters.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static void zzc(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzev zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_PREFIX;
        int ordinal = zzud.ordinal();
        if (ordinal == 1) {
            return zzev.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzev.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzud.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzev.zzb;
    }
}
