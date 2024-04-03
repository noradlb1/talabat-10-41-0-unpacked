package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfu  reason: invalid package */
public final class zzfu extends zzcu {
    private final zzfz zza;
    private final zzwg zzb;
    private final zzwf zzc;
    @Nullable
    private final Integer zzd;

    private zzfu(zzfz zzfz, zzwg zzwg, zzwf zzwf, @Nullable Integer num) {
        this.zza = zzfz;
        this.zzb = zzwg;
        this.zzc = zzwf;
        this.zzd = num;
    }

    public static zzfu zza(zzfy zzfy, zzwg zzwg, @Nullable Integer num) throws GeneralSecurityException {
        zzwf zzwf;
        zzfy zzfy2 = zzfy.zzc;
        if (zzfy != zzfy2 && num == null) {
            String obj = zzfy.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzfy == zzfy2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzwg.zza() == 32) {
            zzfz zzb2 = zzfz.zzb(zzfy);
            if (zzb2.zza() == zzfy2) {
                zzwf = zzwf.zzb(new byte[0]);
            } else if (zzb2.zza() == zzfy.zzb) {
                zzwf = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzb2.zza() == zzfy.zza) {
                zzwf = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
            }
            return new zzfu(zzb2, zzwg, zzwf, num);
        } else {
            int zza2 = zzwg.zza();
            throw new GeneralSecurityException("ChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }
}
