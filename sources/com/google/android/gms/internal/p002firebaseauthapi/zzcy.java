package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.logging.Level;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzcy  reason: invalid package */
final class zzcy implements zzbd {
    private final zzcl zza;
    private final zzoi zzb;
    private final zzoi zzc;

    public /* synthetic */ zzcy(zzcl zzcl, zzcx zzcx) {
        zzoi zzoi;
        this.zza = zzcl;
        if (zzcl.zzf()) {
            zzoj zzb2 = zzku.zza().zzb();
            zzoo zza2 = zzkr.zza(zzcl);
            this.zzb = zzb2.zza(zza2, "aead", "encrypt");
            zzoi = zzb2.zza(zza2, "aead", "decrypt");
        } else {
            zzoi = zzkr.zza;
            this.zzb = zzoi;
        }
        this.zzc = zzoi;
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        if (length > 5) {
            byte[] copyOf = Arrays.copyOf(bArr, 5);
            byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, length);
            for (zzch zzch : this.zza.zze(copyOf)) {
                try {
                    byte[] zza2 = ((zzbd) zzch.zze()).zza(copyOfRange, bArr2);
                    zzch.zza();
                    int length2 = copyOfRange.length;
                    return zza2;
                } catch (GeneralSecurityException e11) {
                    zzcz.zza.logp(Level.INFO, "com.google.crypto.tink.aead.AeadWrapper$WrappedAead", "decrypt", "ciphertext prefix matches a key, but cannot decrypt: ".concat(e11.toString()));
                }
            }
        }
        for (zzch zzch2 : this.zza.zze(zzbi.zza)) {
            try {
                byte[] zza3 = ((zzbd) zzch2.zze()).zza(bArr, bArr2);
                zzch2.zza();
                return zza3;
            } catch (GeneralSecurityException unused) {
            }
        }
        throw new GeneralSecurityException("decryption failed");
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
