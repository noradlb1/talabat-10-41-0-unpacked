package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

final class zzgbe implements zzghh {
    private final String zza;
    private final int zzb;
    private zzgda zzc;
    private zzgcc zzd;
    private int zze;
    private zzgdm zzf;

    public zzgbe(zzgfi zzgfi) throws GeneralSecurityException {
        String str;
        String zzf2 = zzgfi.zzf();
        this.zza = zzf2;
        if (zzf2.equals(zzfzc.zzb)) {
            try {
                zzgdd zze2 = zzgdd.zze(zzgfi.zze(), zzgjx.zza());
                this.zzc = (zzgda) zzfza.zzd(zzgfi);
                this.zzb = zze2.zza();
            } catch (zzgkx e11) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e11);
            }
        } else if (zzf2.equals(zzfzc.zza)) {
            try {
                zzgcf zzd2 = zzgcf.zzd(zzgfi.zze(), zzgjx.zza());
                this.zzd = (zzgcc) zzfza.zzd(zzgfi);
                this.zze = zzd2.zze().zza();
                this.zzb = this.zze + zzd2.zzf().zza();
            } catch (zzgkx e12) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e12);
            }
        } else if (zzf2.equals(zzgap.zza)) {
            try {
                zzgdp zze3 = zzgdp.zze(zzgfi.zze(), zzgjx.zza());
                this.zzf = (zzgdm) zzfza.zzd(zzgfi);
                this.zzb = zze3.zza();
            } catch (zzgkx e13) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e13);
            }
        } else {
            String valueOf = String.valueOf(zzf2);
            if (valueOf.length() != 0) {
                str = "unsupported AEAD DEM key type: ".concat(valueOf);
            } else {
                str = new String("unsupported AEAD DEM key type: ");
            }
            throw new GeneralSecurityException(str);
        }
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzgbf zzb(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == this.zzb) {
            Class<zzfxu> cls = zzfxu.class;
            if (this.zza.equals(zzfzc.zzb)) {
                zzgcz zzc2 = zzgda.zzc();
                zzc2.zzaf(this.zzc);
                zzc2.zza(zzgjf.zzw(bArr, 0, this.zzb));
                return new zzgbf((zzfxu) zzfza.zzg(this.zza, (zzgda) zzc2.zzah(), cls));
            } else if (this.zza.equals(zzfzc.zza)) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.zze);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.zze, this.zzb);
                zzgch zzc3 = zzgci.zzc();
                zzc3.zzaf(this.zzd.zzf());
                zzc3.zza(zzgjf.zzv(copyOfRange));
                zzgev zzc4 = zzgew.zzc();
                zzc4.zzaf(this.zzd.zzg());
                zzc4.zza(zzgjf.zzv(copyOfRange2));
                zzgcb zzc5 = zzgcc.zzc();
                zzc5.zzc(this.zzd.zza());
                zzc5.zza((zzgci) zzc3.zzah());
                zzc5.zzb((zzgew) zzc4.zzah());
                return new zzgbf((zzfxu) zzfza.zzg(this.zza, (zzgcc) zzc5.zzah(), cls));
            } else if (this.zza.equals(zzgap.zza)) {
                zzgdl zzc6 = zzgdm.zzc();
                zzc6.zzaf(this.zzf);
                zzc6.zza(zzgjf.zzw(bArr, 0, this.zzb));
                return new zzgbf((zzfxx) zzfza.zzg(this.zza, (zzgdm) zzc6.zzah(), zzfxx.class));
            } else {
                throw new GeneralSecurityException("unknown DEM key type");
            }
        } else {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
    }
}
