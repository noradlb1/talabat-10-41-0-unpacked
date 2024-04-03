package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzed  reason: invalid package */
public final class zzed {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    @Nullable
    private Integer zzc;
    private zzee zzd;

    private zzed() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    public /* synthetic */ zzed(zzec zzec) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzee.zzc;
    }

    public final zzed zza(int i11) throws GeneralSecurityException {
        if (i11 == 12 || i11 == 16) {
            this.zzb = Integer.valueOf(i11);
            return this;
        }
        throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", new Object[]{Integer.valueOf(i11)}));
    }

    public final zzed zzb(int i11) throws GeneralSecurityException {
        if (i11 == 16 || i11 == 24 || i11 == 32) {
            this.zza = Integer.valueOf(i11);
            return this;
        }
        throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", new Object[]{Integer.valueOf(i11)}));
    }

    public final zzed zzc(int i11) throws GeneralSecurityException {
        this.zzc = 16;
        return this;
    }

    public final zzed zzd(zzee zzee) {
        this.zzd = zzee;
        return this;
    }

    public final zzeg zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("IV size is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("Variant is not set");
        } else if (this.zzc != null) {
            int intValue = num.intValue();
            int intValue2 = this.zzb.intValue();
            this.zzc.intValue();
            return new zzeg(intValue, intValue2, 16, this.zzd, (zzef) null);
        } else {
            throw new GeneralSecurityException("Tag size is not set");
        }
    }
}
