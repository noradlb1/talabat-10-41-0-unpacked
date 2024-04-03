package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi  reason: invalid package */
public final class zzmi {
    @Nullable
    private zzmt zza = null;
    @Nullable
    private zzwg zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzmi() {
    }

    public /* synthetic */ zzmi(zzmh zzmh) {
    }

    public final zzmi zza(zzwg zzwg) throws GeneralSecurityException {
        this.zzb = zzwg;
        return this;
    }

    public final zzmi zzb(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzmi zzc(zzmt zzmt) {
        this.zza = zzmt;
        return this;
    }

    public final zzmk zzd() throws GeneralSecurityException {
        zzwg zzwg;
        zzwf zzb2;
        zzmt zzmt = this.zza;
        if (zzmt == null || (zzwg = this.zzb) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        } else if (zzmt.zzb() != zzwg.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzmt.zze() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zze() || this.zzc == null) {
            if (this.zza.zzd() == zzmr.zzd) {
                zzb2 = zzwf.zzb(new byte[0]);
            } else if (this.zza.zzd() == zzmr.zzc || this.zza.zzd() == zzmr.zzb) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzd() == zzmr.zza) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: ".concat(String.valueOf(this.zza.zzd())));
            }
            return new zzmk(this.zza, this.zzb, zzb2, this.zzc, (zzmj) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
