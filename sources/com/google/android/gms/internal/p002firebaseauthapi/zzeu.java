package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeu  reason: invalid package */
public final class zzeu {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    @Nullable
    private Integer zzc;
    private zzev zzd;

    private zzeu() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    public /* synthetic */ zzeu(zzet zzet) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzev.zzc;
    }

    public final zzeu zza(int i11) throws GeneralSecurityException {
        this.zzb = 12;
        return this;
    }

    public final zzeu zzb(int i11) throws GeneralSecurityException {
        if (i11 == 16 || i11 == 24 || i11 == 32) {
            this.zza = Integer.valueOf(i11);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i11)}));
    }

    public final zzeu zzc(int i11) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzeu zzd(zzev zzev) {
        this.zzd = zzev;
        return this;
    }

    public final zzex zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            this.zzb.intValue();
            this.zzc.intValue();
            return new zzex(intValue, 12, 16, this.zzd, (zzew) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }
}
