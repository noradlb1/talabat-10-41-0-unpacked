package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdr  reason: invalid package */
final class zzdr {
    public static final /* synthetic */ int zza = 0;
    private static final zzwf zzb;
    private static final zzlg zzc;
    private static final zzlc zzd;
    private static final zzki zze;
    private static final zzke zzf;

    static {
        zzwf zzb2 = zzmg.zzb("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        zzb = zzb2;
        Class<zzlu> cls = zzlu.class;
        zzc = zzlg.zzb(zzdn.zza, zzdm.class, cls);
        zzd = zzlc.zzb(zzdo.zza, zzb2, cls);
        Class<zzlt> cls2 = zzlt.class;
        zze = zzki.zza(zzdp.zza, zzdd.class, cls2);
        zzf = zzke.zzb(zzdq.zza, zzb2, cls2);
    }

    public static /* synthetic */ zzdd zza(zzlt zzlt, zzcr zzcr) {
        if (zzlt.zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzpb zzd2 = zzpb.zzd(zzlt.zze(), zzagn.zza());
                if (zzd2.zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys are accepted");
                } else if (zzd2.zze().zza() != 0) {
                    throw new GeneralSecurityException("Only version 0 keys inner AES CTR keys are accepted");
                } else if (zzd2.zzf().zza() == 0) {
                    zzdi zzdi = new zzdi((zzdh) null);
                    zzdi.zza(zzd2.zze().zzg().zzd());
                    zzdi.zzc(zzd2.zzf().zzg().zzd());
                    zzdi.zzd(zzd2.zze().zzf().zza());
                    zzdi.zze(zzd2.zzf().zzf().zza());
                    zzdi.zzb(zze(zzd2.zzf().zzf().zzf()));
                    zzdi.zzf(zzd(zzlt.zzc()));
                    zzdm zzg = zzdi.zzg();
                    zzdb zzdb = new zzdb((zzda) null);
                    zzdb.zzd(zzg);
                    zzdb.zza(zzwg.zzb(zzd2.zze().zzg().zzq(), zzcr));
                    zzdb.zzb(zzwg.zzb(zzd2.zzf().zzg().zzq(), zzcr));
                    zzdb.zzc(zzlt.zzf());
                    return zzdb.zze();
                } else {
                    throw new GeneralSecurityException("Only version 0 keys inner HMAC keys are accepted");
                }
            } catch (zzahi unused) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadKey failed");
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseKey");
        }
    }

    public static /* synthetic */ zzdm zzb(zzlu zzlu) {
        if (zzlu.zzc().zzg().equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzpe zzc2 = zzpe.zzc(zzlu.zzc().zzf(), zzagn.zza());
                if (zzc2.zze().zzb() == 0) {
                    zzdi zzdi = new zzdi((zzdh) null);
                    zzdi.zza(zzc2.zzd().zza());
                    zzdi.zzc(zzc2.zze().zza());
                    zzdi.zzd(zzc2.zzd().zzf().zza());
                    zzdi.zze(zzc2.zze().zzg().zza());
                    zzdi.zzb(zze(zzc2.zze().zzg().zzf()));
                    zzdi.zzf(zzd(zzlu.zzc().zze()));
                    return zzdi.zzg();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzahi e11) {
                throw new GeneralSecurityException("Parsing AesCtrHmacAeadParameters failed: ", e11);
            }
        } else {
            throw new IllegalArgumentException("Wrong type URL in call to AesCtrHmacAeadProtoSerialization.parseParameters: ".concat(String.valueOf(zzlu.zzc().zzg())));
        }
    }

    public static void zzc(zzky zzky) throws GeneralSecurityException {
        zzky.zzh(zzc);
        zzky.zzg(zzd);
        zzky.zzf(zze);
        zzky.zze(zzf);
    }

    private static zzdk zzd(zzud zzud) throws GeneralSecurityException {
        zzud zzud2 = zzud.UNKNOWN_PREFIX;
        int ordinal = zzud.ordinal();
        if (ordinal == 1) {
            return zzdk.zza;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return zzdk.zzc;
            }
            if (ordinal != 4) {
                int zza2 = zzud.zza();
                throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
            }
        }
        return zzdk.zzb;
    }

    private static zzdj zze(int i11) throws GeneralSecurityException {
        zzud zzud = zzud.UNKNOWN_PREFIX;
        int i12 = i11 - 2;
        if (i12 == 1) {
            return zzdj.zza;
        }
        if (i12 == 2) {
            return zzdj.zzd;
        }
        if (i12 == 3) {
            return zzdj.zzc;
        }
        if (i12 == 4) {
            return zzdj.zze;
        }
        if (i12 == 5) {
            return zzdj.zzb;
        }
        throw new GeneralSecurityException("Unable to parse HashType: " + zzrv.zza(i11));
    }
}
