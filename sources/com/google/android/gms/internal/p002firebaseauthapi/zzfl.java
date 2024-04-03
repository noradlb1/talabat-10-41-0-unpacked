package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfl  reason: invalid package */
public final class zzfl {
    @Nullable
    private Integer zza;
    private zzfm zzb;

    private zzfl() {
        this.zza = null;
        throw null;
    }

    public /* synthetic */ zzfl(zzfk zzfk) {
        this.zza = null;
        this.zzb = zzfm.zzc;
    }

    public final zzfl zza(int i11) throws GeneralSecurityException {
        if (i11 == 16 || i11 == 32) {
            this.zza = Integer.valueOf(i11);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i11)}));
    }

    public final zzfl zzb(zzfm zzfm) {
        this.zzb = zzfm;
        return this;
    }

    public final zzfo zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzfo(num.intValue(), this.zzb, (zzfn) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }
}
