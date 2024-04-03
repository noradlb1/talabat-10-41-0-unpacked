package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznm  reason: invalid package */
public final class zznm {
    @Nullable
    private Integer zza;
    @Nullable
    private Integer zzb;
    private zznn zzc;
    private zzno zzd;

    private zznm() {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        throw null;
    }

    public /* synthetic */ zznm(zznl zznl) {
        this.zza = null;
        this.zzb = null;
        this.zzc = null;
        this.zzd = zzno.zzd;
    }

    public final zznm zza(zznn zznn) {
        this.zzc = zznn;
        return this;
    }

    public final zznm zzb(int i11) throws GeneralSecurityException {
        this.zza = Integer.valueOf(i11);
        return this;
    }

    public final zznm zzc(int i11) throws GeneralSecurityException {
        this.zzb = Integer.valueOf(i11);
        return this;
    }

    public final zznm zzd(zzno zzno) {
        this.zzd = zzno;
        return this;
    }

    public final zznq zze() throws GeneralSecurityException {
        Integer num = this.zza;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        } else if (this.zzb == null) {
            throw new GeneralSecurityException("tag size is not set");
        } else if (this.zzc == null) {
            throw new GeneralSecurityException("hash type is not set");
        } else if (this.zzd == null) {
            throw new GeneralSecurityException("variant is not set");
        } else if (num.intValue() >= 16) {
            int intValue = this.zzb.intValue();
            zznn zznn = this.zzc;
            if (intValue >= 10) {
                if (zznn == zznn.zza) {
                    if (intValue > 20) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznn == zznn.zzb) {
                    if (intValue > 28) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznn == zznn.zzc) {
                    if (intValue > 32) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznn == zznn.zzd) {
                    if (intValue > 48) {
                        throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", new Object[]{Integer.valueOf(intValue)}));
                    }
                } else if (zznn != zznn.zze) {
                    throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                } else if (intValue > 64) {
                    throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", new Object[]{Integer.valueOf(intValue)}));
                }
                return new zznq(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc, (zznp) null);
            }
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", new Object[]{Integer.valueOf(intValue)}));
        } else {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", new Object[]{this.zza}));
        }
    }
}
