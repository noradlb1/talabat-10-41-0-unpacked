package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzne  reason: invalid package */
public final class zzne {
    @Nullable
    private zznq zza = null;
    @Nullable
    private zzwg zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzne() {
    }

    public /* synthetic */ zzne(zznd zznd) {
    }

    public final zzne zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzne zzb(zzwg zzwg) {
        this.zzb = zzwg;
        return this;
    }

    public final zzne zzc(zznq zznq) {
        this.zza = zznq;
        return this;
    }

    public final zzng zzd() throws GeneralSecurityException {
        zzwg zzwg;
        zzwf zzb2;
        zznq zznq = this.zza;
        if (zznq == null || (zzwg = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zznq.zzb() != zzwg.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zznq.zzf() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzf() || this.zzc == null) {
            if (this.zza.zze() == zzno.zzd) {
                zzb2 = zzwf.zzb(new byte[0]);
            } else if (this.zza.zze() == zzno.zzc || this.zza.zze() == zzno.zzb) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zze() == zzno.zza) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown HmacParameters.Variant: ".concat(String.valueOf(this.zza.zze())));
            }
            return new zzng(this.zza, this.zzb, zzb2, this.zzc, (zznf) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
