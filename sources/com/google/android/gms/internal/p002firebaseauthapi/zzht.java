package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzht  reason: invalid package */
public final class zzht {
    @Nullable
    private Integer zza;
    private zzhu zzb;

    private zzht() {
        this.zza = null;
        throw null;
    }

    public /* synthetic */ zzht(zzhs zzhs) {
        this.zza = null;
        this.zzb = zzhu.zzc;
    }

    public final zzht zza(int i11) throws GeneralSecurityException {
        if (i11 == 32 || i11 == 48 || i11 == 64) {
            this.zza = Integer.valueOf(i11);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", new Object[]{Integer.valueOf(i11)}));
    }

    public final zzht zzb(zzhu zzhu) {
        this.zzb = zzhu;
        return this;
    }

    public final zzhw zzc() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb != null) {
            return new zzhw(num.intValue(), this.zzb, (zzhv) null);
        } else {
            throw new GeneralSecurityException("Variant is not set");
        }
    }
}
