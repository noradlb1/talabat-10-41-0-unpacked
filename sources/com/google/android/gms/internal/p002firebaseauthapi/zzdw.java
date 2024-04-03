package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdw  reason: invalid package */
public final class zzdw {
    @Nullable
    private zzeg zza = null;
    @Nullable
    private zzwg zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzdw() {
    }

    public /* synthetic */ zzdw(zzdv zzdv) {
    }

    public final zzdw zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzdw zzb(zzwg zzwg) {
        this.zzb = zzwg;
        return this;
    }

    public final zzdw zzc(zzeg zzeg) {
        this.zza = zzeg;
        return this;
    }

    public final zzdy zzd() throws GeneralSecurityException {
        zzwg zzwg;
        zzwf zzb2;
        zzeg zzeg = this.zza;
        if (zzeg == null || (zzwg = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzeg.zzb() != zzwg.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzeg.zzd() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzd() || this.zzc == null) {
            if (this.zza.zzc() == zzee.zzc) {
                zzb2 = zzwf.zzb(new byte[0]);
            } else if (this.zza.zzc() == zzee.zzb) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzc() == zzee.zza) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: ".concat(String.valueOf(this.zza.zzc())));
            }
            return new zzdy(this.zza, this.zzb, zzb2, this.zzc, (zzdx) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
