package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziu  reason: invalid package */
final class zziu implements zzuw {
    private final String zza;
    private final int zzb;
    private zzpz zzc;
    private zzpb zzd;
    private int zze;
    private zzql zzf;

    public zziu(zztc zztc) throws GeneralSecurityException {
        String zzg = zztc.zzg();
        this.zza = zzg;
        if (zzg.equals(zzct.zzb)) {
            try {
                zzqc zze2 = zzqc.zze(zztc.zzf(), zzagn.zza());
                this.zzc = zzpz.zzd(zzcq.zzb(zztc).zze(), zzagn.zza());
                this.zzb = zze2.zza();
            } catch (zzahi e11) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e11);
            }
        } else if (zzg.equals(zzct.zza)) {
            try {
                zzpe zzc2 = zzpe.zzc(zztc.zzf(), zzagn.zza());
                this.zzd = zzpb.zzd(zzcq.zzb(zztc).zze(), zzagn.zza());
                this.zze = zzc2.zzd().zza();
                this.zzb = this.zze + zzc2.zze().zza();
            } catch (zzahi e12) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e12);
            }
        } else if (zzg.equals(zzic.zza)) {
            try {
                zzqo zze3 = zzqo.zze(zztc.zzf(), zzagn.zza());
                this.zzf = zzql.zzd(zzcq.zzb(zztc).zze(), zzagn.zza());
                this.zzb = zze3.zza();
            } catch (zzahi e13) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e13);
            }
        } else {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: ".concat(String.valueOf(zzg)));
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzjp zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == this.zzb) {
            Class<zzbd> cls = zzbd.class;
            if (this.zza.equals(zzct.zzb)) {
                zzpy zzb2 = zzpz.zzb();
                zzb2.zzh(this.zzc);
                zzb2.zza(zzafv.zzn(bArr, 0, this.zzb));
                return new zzjp((zzbd) zzcq.zzd(this.zza, ((zzpz) zzb2.zzi()).zzo(), cls));
            } else if (this.zza.equals(zzct.zza)) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
                zzpg zzb3 = zzph.zzb();
                zzb3.zzh(this.zzd.zze());
                zzafv zzafv = zzafv.zzb;
                zzb3.zza(zzafv.zzn(copyOfRange, 0, copyOfRange.length));
                zzrx zzb4 = zzry.zzb();
                zzb4.zzh(this.zzd.zzf());
                zzb4.zza(zzafv.zzn(copyOfRange2, 0, copyOfRange2.length));
                zzpa zzb5 = zzpb.zzb();
                zzb5.zzc(this.zzd.zza());
                zzb5.zza((zzph) zzb3.zzi());
                zzb5.zzb((zzry) zzb4.zzi());
                return new zzjp((zzbd) zzcq.zzd(this.zza, ((zzpb) zzb5.zzi()).zzo(), cls));
            } else if (this.zza.equals(zzic.zza)) {
                zzqk zzb6 = zzql.zzb();
                zzb6.zzh(this.zzf);
                zzb6.zza(zzafv.zzn(bArr, 0, this.zzb));
                return new zzjp((zzbj) zzcq.zzd(this.zza, ((zzql) zzb6.zzi()).zzo(), zzbj.class));
            } else {
                throw new GeneralSecurityException("unknown DEM key type");
            }
        } else {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
    }
}
