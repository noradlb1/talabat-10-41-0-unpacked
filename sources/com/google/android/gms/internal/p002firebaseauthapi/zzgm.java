package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgm  reason: invalid package */
public final class zzgm extends zzcu {
    private final zzgr zza;
    private final zzwg zzb;
    private final zzwf zzc;
    @Nullable
    private final Integer zzd;

    private zzgm(zzgr zzgr, zzwg zzwg, zzwf zzwf, @Nullable Integer num) {
        this.zza = zzgr;
        this.zzb = zzwg;
        this.zzc = zzwf;
        this.zzd = num;
    }

    public static zzgm zza(zzgq zzgq, zzwg zzwg, @Nullable Integer num) throws GeneralSecurityException {
        zzwf zzwf;
        zzgq zzgq2 = zzgq.zzc;
        if (zzgq != zzgq2 && num == null) {
            String obj = zzgq.toString();
            throw new GeneralSecurityException("For given Variant " + obj + " the value of idRequirement must be non-null");
        } else if (zzgq == zzgq2 && num != null) {
            throw new GeneralSecurityException("For given Variant NO_PREFIX the value of idRequirement must be null");
        } else if (zzwg.zza() == 32) {
            zzgr zzb2 = zzgr.zzb(zzgq);
            if (zzb2.zza() == zzgq2) {
                zzwf = zzwf.zzb(new byte[0]);
            } else if (zzb2.zza() == zzgq.zzb) {
                zzwf = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzb2.zza() == zzgq.zza) {
                zzwf = zzwf.zzb(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            } else {
                throw new IllegalStateException("Unknown Variant: ".concat(zzb2.zza().toString()));
            }
            return new zzgm(zzb2, zzwg, zzwf, num);
        } else {
            int zza2 = zzwg.zza();
            throw new GeneralSecurityException("XChaCha20Poly1305 key must be constructed with key of length 32 bytes, not " + zza2);
        }
    }
}
