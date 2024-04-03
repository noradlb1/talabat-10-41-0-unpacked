package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzft  reason: invalid package */
final class zzft {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zzfp.zza, zzfo.class, cls);
        zzd = zzlc.zzb(zzfq.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zzfr.zza, zzfg.class, cls2);
        zzf = zzke.zzb(zzfs.zza, zzb2, cls2);
    }

    public static /* synthetic */ zzfg zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzqf zzd2 = zzqf.zzd(zzlt.zze(), zzagn.zza());
                if (zzd2.zza() == 0) {
                    zzfl zzfl = new zzfl((zzfk) null);
                    zzfl.zza(zzd2.zze().zzd());
                    zzfl.zzb(zzd(zzlt.zzc()));
                    zzfo zzc2 = zzfl.zzc();
                    zzfe zzfe = new zzfe((zzfd) null);
                    zzfe.zzc(zzc2);
                    zzfe.zzb(zzwg.zzb(zzd2.zze().zzq(), zzcr));
                    zzfe.zza(zzlt.zzf());
                    return zzfe.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi unused) {
                throw new GeneralSecurityException("Parsing AesGcmSivKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzfo zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesGcmSivKey")) {
            try {
                zzqi zze2 = zzqi.zze(zzlu.zzc().zzf(), zzagn.zza());
                if (zze2.zzb() == 0) {
                    zzfl zzfl = new zzfl((zzfk) null);
                    zzfl.zza(zze2.zza());
                    zzfl.zzb(zzd(zzlu.zzc().zze()));
                    return zzfl.zzc();
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing AesGcmSivParameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesGcmSivParameters.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static void zzc(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzfm zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_PREFIX;
        int ordinal = zzud.ordinal();
        if (ordinal == 1) {
            return zzfm.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzfm.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzud.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzfm.zzb;
    }
}
