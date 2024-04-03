package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzen  reason: invalid package */
public final class zzen {
    @Nullable
    private zzex zza = null;
    @Nullable
    private zzwg zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzen() {
    }

    public /* synthetic */ zzen(zzem zzem) {
    }

    public final zzen zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzen zzb(zzwg zzwg) {
        this.zzb = zzwg;
        return this;
    }

    public final zzen zzc(zzex zzex) {
        this.zza = zzex;
        return this;
    }

    public final zzep zzd() throws GeneralSecurityException {
        zzwg zzwg;
        zzwf zzb2;
        zzex zzex = this.zza;
        if (zzex == null || (zzwg = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzex.zza() != zzwg.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzex.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzev.zzc) {
                zzb2 = zzwf.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzev.zzb) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzev.zza) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
            }
            return new zzep(this.zza, this.zzb, zzb2, this.zzc, (zzeo) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
