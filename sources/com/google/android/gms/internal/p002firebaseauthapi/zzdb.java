package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdb  reason: invalid package */
public final class zzdb {
    @Nullable
    private zzdm zza = null;
    @Nullable
    private zzwg zzb = null;
    @Nullable
    private zzwg zzc = null;
    @Nullable
    private Integer zzd = null;

    private zzdb() {
    }

    public /* synthetic */ zzdb(zzda zzda) {
    }

    public final zzdb zza(zzwg zzwg) {
        this.zzb = zzwg;
        return this;
    }

    public final zzdb zzb(zzwg zzwg) {
        this.zzc = zzwg;
        return this;
    }

    public final zzdb zzc(@Nullable Integer num) {
        this.zzd = num;
        return this;
    }

    public final zzdb zzd(zzdm zzdm) {
        this.zza = zzdm;
        return this;
    }

    public final zzdd zze() throws GeneralSecurityException {
        zzwf zzb2;
        zzdm zzdm = this.zza;
        if (zzdm != null) {
            zzwg zzwg = this.zzb;
            if (zzwg == null || this.zzc == null) {
                throw new GeneralSecurityException("Cannot build without key material");
            } else if (zzdm.zza() != zzwg.zza()) {
                throw new GeneralSecurityException("AES key size mismatch");
            } else if (zzdm.zzb() != this.zzc.zza()) {
                throw new GeneralSecurityException("HMAC key size mismatch");
            } else if (this.zza.zzg() && this.zzd == null) {
                throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
            } else if (this.zza.zzg() || this.zzd == null) {
                if (this.zza.zzf() == zzdk.zzc) {
                    zzb2 = zzwf.zzb(new byte[0]);
                } else if (this.zza.zzf() == zzdk.zzb) {
                    zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzd.intValue()).array());
                } else if (this.zza.zzf() == zzdk.zza) {
                    zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzd.intValue()).array());
                } else {
                    throw new IllegalStateException("Unknown AesCtrHmacAeadParameters.Variant: ".concat(String.valueOf(this.zza.zzf())));
                }
                return new zzdd(this.zza, this.zzb, this.zzc, zzb2, this.zzd, (zzdc) null);
            } else {
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
        } else {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
    }
}
