package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhm  reason: invalid package */
public final class zzhm {
    @Nullable
    private zzhw zza = null;
    @Nullable
    private zzwg zzb = null;
    @Nullable
    private Integer zzc = null;

    private zzhm() {
    }

    public /* synthetic */ zzhm(zzhl zzhl) {
    }

    public final zzhm zza(@Nullable Integer num) {
        this.zzc = num;
        return this;
    }

    public final zzhm zzb(zzwg zzwg) {
        this.zzb = zzwg;
        return this;
    }

    public final zzhm zzc(zzhw zzhw) {
        this.zza = zzhw;
        return this;
    }

    public final zzho zzd() throws GeneralSecurityException {
        zzwg zzwg;
        zzwf zzb2;
        zzhw zzhw = this.zza;
        if (zzhw == null || (zzwg = this.zzb) == null) {
            throw new IllegalArgumentException("Cannot build without parameters and/or key material");
        } else if (zzhw.zza() != zzwg.zza()) {
            throw new GeneralSecurityException("Key size mismatch");
        } else if (zzhw.zzc() && this.zzc == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        } else if (this.zza.zzc() || this.zzc == null) {
            if (this.zza.zzb() == zzhu.zzc) {
                zzb2 = zzwf.zzb(new byte[0]);
            } else if (this.zza.zzb() == zzhu.zzb) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
            } else if (this.zza.zzb() == zzhu.zza) {
                zzb2 = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown AesSivParameters.Variant: ".concat(String.valueOf(this.zza.zzb())));
            }
            return new zzho(this.zza, this.zzb, zzb2, this.zzc, (zzhn) null);
        } else {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
    }
}
