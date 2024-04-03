package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmy  reason: invalid package */
final class zzmy {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.AesCmacKey");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zzmu.zza, zzmt.class, cls);
        zzd = zzlc.zzb(zzmv.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zzmw.zza, zzmk.class, cls2);
        zzf = zzke.zzb(zzmx.zza, zzb2, cls2);
    }

    public static /* synthetic */ zzmk zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzos zzd2 = zzos.zzd(zzlt.zze(), zzagn.zza());
                if (zzd2.zza() == 0) {
                    zzmq zzmq = new zzmq((zzmp) null);
                    zzmq.zza(zzd2.zzf().zzd());
                    zzmq.zzb(zzd2.zze().zza());
                    zzmq.zzc(zzd(zzlt.zzc()));
                    zzmt zzd3 = zzmq.zzd();
                    zzmi zzmi = new zzmi((zzmh) null);
                    zzmi.zzc(zzd3);
                    zzmi.zza(zzwg.zzb(zzd2.zzf().zzq(), zzcr));
                    zzmi.zzb(zzlt.zzf());
                    return zzmi.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing AesCmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters");
        }
    }

    public static /* synthetic */ zzmt zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesCmacKey")) {
            try {
                zzov zzd2 = zzov.zzd(zzlu.zzc().zzf(), zzagn.zza());
                zzmq zzmq = new zzmq((zzmp) null);
                zzmq.zza(zzd2.zza());
                zzmq.zzb(zzd2.zze().zza());
                zzmq.zzc(zzd(zzlu.zzc().zze()));
                return zzmq.zzd();
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing AesCmacParameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCmacParameters.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static void zzc(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzmr zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_PREFIX;
        int ordinal = zzud.ordinal();
        if (ordinal == 1) {
            return zzmr.zza;
        }
        if (ordinal == 2) {
            return zzmr.zzc;
        }
        if (ordinal == 3) {
            return zzmr.zzd;
        }
        if (ordinal == 4) {
            return zzmr.zzb;
        }
        int zza2 = zzud.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }
}
