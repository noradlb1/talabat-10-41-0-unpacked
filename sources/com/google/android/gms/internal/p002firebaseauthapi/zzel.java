package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzel  reason: invalid package */
final class zzel {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zzeh.zza, zzeg.class, cls);
        zzd = zzlc.zzb(zzei.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zzej.zza, zzdy.class, cls2);
        zzf = zzke.zzb(zzek.zza, zzb2, cls2);
    }

    public static /* synthetic */ zzdy zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzpq zzd2 = zzpq.zzd(zzlt.zze(), zzagn.zza());
                if (zzd2.zza() == 0) {
                    zzed zzed = new zzed((zzec) null);
                    zzed.zzb(zzd2.zzf().zzd());
                    zzed.zza(zzd2.zze().zza());
                    zzed.zzc(16);
                    zzed.zzd(zzd(zzlt.zzc()));
                    zzeg zze2 = zzed.zze();
                    zzdw zzdw = new zzdw((zzdv) null);
                    zzdw.zzc(zze2);
                    zzdw.zzb(zzwg.zzb(zzd2.zzf().zzq(), zzcr));
                    zzdw.zza(zzlt.zzf());
                    return zzdw.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi unused) {
                throw new GeneralSecurityException("Parsing AesEaxcKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzeg zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
            try {
                zzpt zzd2 = zzpt.zzd(zzlu.zzc().zzf(), zzagn.zza());
                zzed zzed = new zzed((zzec) null);
                zzed.zzb(zzd2.zza());
                zzed.zza(zzd2.zze().zza());
                zzed.zzc(16);
                zzed.zzd(zzd(zzlu.zzc().zze()));
                return zzed.zze();
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing AesEaxParameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesEaxParameters.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static void zzc(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzee zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_PREFIX;
        int ordinal = zzud.ordinal();
        if (ordinal == 1) {
            return zzee.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzee.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzud.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzee.zzb;
    }
}
