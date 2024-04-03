package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoa  reason: invalid package */
final class zzoa implements zzcd {
    private final zzcl zza;
    private final zzoi zzb;
    private final zzoi zzc;

    public /* synthetic */ zzoa(zzcl zzcl, zznz zznz) {
        zzoi zzoi;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzoj zzb2 = zzku.zza().zzb();
            zzoo zza2 = zzkr.zza(zzcl);
            this.zzb = zzb2.zza(zza2, "mac", "compute");
            zzoi = zzb2.zza(zza2, "mac", "verify");
        } else {
            zzoi = zzkr.zza;
            this.zzb = zzoi;
        }
        this.zzc = zzoi;
    }

    public final void zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3;
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOf)) {
                if (zzch.zzc().equals(zzud.LEGACY)) {
                    bArr3 = zzuu.zzb(bArr2, zzob.zzb);
                } else {
                    bArr3 = bArr2;
                }
                try {
                    ((zzcd) zzch.zze()).zza(copyOfRange, bArr3);
                    zzch.zza();
                    return;
                } catch (GeneralSecurityException e11) {
                    zzob.zza.logp(Level.INFO, "com.google.crypto.tink.mac.MacWrapper$WrappedMac", "verifyMac", "tag prefix matches a key, but cannot verify: ".concat(e11.toString()));
                }
            }
            for (zzch zzch2 : this.zza.zze(zzbi.zza)) {
                try {
                    ((zzcd) zzch2.zze()).zza(bArr, bArr2);
                    zzch2.zza();
                    return;
                } catch (GeneralSecurityException unused) {
                }
            }
            throw new GeneralSecurityException("invalid MAC");
        }
        throw new GeneralSecurityException("tag too short");
    }
}
