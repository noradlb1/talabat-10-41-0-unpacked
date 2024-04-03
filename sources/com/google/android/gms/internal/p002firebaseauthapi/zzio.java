package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzio  reason: invalid package */
final class zzio implements zzbk {
    private final zzcl zza;
    private final zzoi zzb;

    public zzio(zzcl zzcl) {
        zzoi zzoi;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzoi = zzku.zza().zzb().zza(zzkr.zza(zzcl), "hybrid_decrypt", "decrypt");
        } else {
            zzoi = zzkr.zza;
        }
        this.zzb = zzoi;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, 5);
            byte[] copyOfRange2 = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOfRange)) {
                try {
                    byte[] zza2 = ((zzbk) zzch.zze()).zza(copyOfRange2, (byte[]) null);
                    zzch.zza();
                    int length2 = copyOfRange2.length;
                    return zza2;
                } catch (GeneralSecurityException e11) {
                    zzip.zza.logp(Level.INFO, "com.google.crypto.tink.hybrid.HybridDecryptWrapper$WrappedHybridDecrypt", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(String.valueOf(e11.toString())));
                }
            }
        }
        for (zzch zzch2 : this.zza.zze(zzbi.zza)) {
            try {
                byte[] zza3 = ((zzbk) zzch2.zze()).zza(bArr, (byte[]) null);
                zzch2.zza();
                return zza3;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }
}
