package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgi  reason: invalid package */
public final class zzgi implements zzbd {
    private static final byte[] zza = new byte[0];
    private static final Set zzb;
    private final zztc zzc;
    private final zzbd zzd;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    public zzgi(zztc zztc, zzbd zzbd) {
        if (zzc(zztc.zzg())) {
            this.zzc = zztc;
            this.zzd = zzbd;
            return;
        }
        String zzg = zztc.zzg();
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzg + ". Only Tink AEAD key types are supported.");
    }

    public static boolean zzc(String str) {
        return zzb.contains(str);
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i11 = wrap.getInt();
            if (i11 <= 0 || i11 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i11];
            wrap.get(bArr3, 0, i11);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            byte[] zza2 = this.zzd.zza(bArr3, zza);
            int i12 = zzcq.zza;
            zzafv zzafv = zzafv.zzb;
            return ((zzbd) zzcq.zzd(this.zzc.zzg(), zzafv.zzn(zza2, 0, zza2.length), zzbd.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e11) {
            throw new GeneralSecurityException("invalid ciphertext", e11);
        }
    }

    public final byte[] zzb(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }
}
