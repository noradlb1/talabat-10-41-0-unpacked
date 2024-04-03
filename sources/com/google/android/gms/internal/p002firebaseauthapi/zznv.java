package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznv  reason: invalid package */
final class zznv {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.HmacKey");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zznr.zza, zznq.class, cls);
        zzd = zzlc.zzb(zzns.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zznt.zza, zzng.class, cls2);
        zzf = zzke.zzb(zznu.zza, zzb2, cls2);
    }

    public static /* synthetic */ zzng zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzry zze2 = zzry.zze(zzlt.zze(), zzagn.zza());
                if (zze2.zza() == 0) {
                    zznm zznm = new zznm((zznl) null);
                    zznm.zzb(zze2.zzg().zzd());
                    zznm.zzc(zze2.zzf().zza());
                    zznm.zza(zze(zze2.zzf().zzf()));
                    zznm.zzd(zzd(zzlt.zzc()));
                    zznq zze3 = zznm.zze();
                    zzne zzne = new zzne((zznd) null);
                    zzne.zzc(zze3);
                    zzne.zzb(zzwg.zzb(zze2.zzg().zzq(), zzcr));
                    zzne.zza(zzlt.zzf());
                    return zzne.zzd();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi | IllegalArgumentException unused) {
                throw new GeneralSecurityException("Parsing HmacKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zznq zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.HmacKey")) {
            try {
                zzsb zzf2 = zzsb.zzf(zzlu.zzc().zzf(), zzagn.zza());
                if (zzf2.zzb() == 0) {
                    zznm zznm = new zznm((zznl) null);
                    zznm.zzb(zzf2.zza());
                    zznm.zzc(zzf2.zzg().zza());
                    zznm.zza(zze(zzf2.zzg().zzf()));
                    zznm.zzd(zzd(zzlu.zzc().zze()));
                    return zznm.zze();
                }
                int zzb2 = zzf2.zzb();
                throw new GeneralSecurityException("Parsing HmacParameters failed: unknown Version " + zzb2);
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing HmacParameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to HmacProtoSerialization.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static void zzc(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzno zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_PREFIX;
        int ordinal = zzud.ordinal();
        if (ordinal == 1) {
            return zzno.zza;
        }
        if (ordinal == 2) {
            return zzno.zzc;
        }
        if (ordinal == 3) {
            return zzno.zzd;
        }
        if (ordinal == 4) {
            return zzno.zzb;
        }
        int zza2 = zzud.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    private static zznn zze(int i11) throws GeneralSecurityException {
        zzud zzud = zzud.UNKNOWN_PREFIX;
        int i12 = i11 - 2;
        if (i12 == 1) {
            return zznn.zza;
        }
        if (i12 == 2) {
            return zznn.zzd;
        }
        if (i12 == 3) {
            return zznn.zzc;
        }
        if (i12 == 4) {
            return zznn.zze;
        }
        if (i12 == 5) {
            return zznn.zzb;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzrv.zza(i11));
    }
}
