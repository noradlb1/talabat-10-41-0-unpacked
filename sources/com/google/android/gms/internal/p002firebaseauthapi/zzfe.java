package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfe  reason: invalid package */
public final class zzfe {
    @Nullable
    private zzfo zza = null;
    @Nullable
    private zzwg zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzfe() {
    }

    public /* synthetic */ zzfe(zzfd zzfd) {
    }

    public final zzfe zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzfe zzb(zzwg zzwg) {
        this.zzb = zzwg;
        return this;
    }

    public final zzfe zzc(zzfo zzfo) {
        this.zza = zzfo;
        return this;
    }

    public final zzfg zzd() throws GeneralSecurityException {
        zzwg zzwg;
        zzwf zzb2;
        zzfo zzfo = this.zza;
        if (zzfo == null || (zzwg = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzfo.zza() != zzwg.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzfo.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzfm.zzc) {
                zzb2 = zzwf.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzfm.zzb) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzfm.zza) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
            }
            return new zzfg(this.zza, this.zzb, zzb2, this.zzc, (zzff) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
