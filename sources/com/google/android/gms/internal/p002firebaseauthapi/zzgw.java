package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgw  reason: invalid package */
final class zzgw {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zzgs.zza, zzgr.class, cls);
        zzd = zzlc.zzb(zzgt.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zzgu.zza, zzgm.class, cls2);
        zzf = zzke.zzb(zzgv.zza, zzb2, cls2);
    }

    public static /* synthetic */ zzgm zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                zzuj zzd2 = zzuj.zzd(zzlt.zze(), zzagn.zza());
                if (zzd2.zza() == 0) {
                    return zzgm.zza(zzd(zzlt.zzc()), zzwg.zzb(zzd2.zze().zzq(), zzcr), zzlt.zzf());
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi unused) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Key failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters");
        }
    }

    public static /* synthetic */ zzgr zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
            try {
                if (zzum.zzd(zzlu.zzc().zzf(), zzagn.zza()).zza() == 0) {
                    return zzgr.zzb(zzd(zzlu.zzc().zze()));
                }
                throw new GeneralSecurityException("Only version 0 parameters are accepted");
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing XChaCha20Poly1305Parameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to XChaCha20Poly1305Parameters.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static void zzc(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzgq zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_PREFIX;
        int ordinal = zzud.ordinal();
        if (ordinal == 1) {
            return zzgq.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzgq.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzud.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzgq.zzb;
    }
}
