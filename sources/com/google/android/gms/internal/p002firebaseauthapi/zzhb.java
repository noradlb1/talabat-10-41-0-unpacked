package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhb  reason: invalid package */
abstract class zzhb {
    int[] zza;
    private final int zzb;

    public zzhb(byte[] bArr, int i11) throws InvalidKeyException {
        if (bArr.length == 32) {
            this.zza = zzgx.zzd(bArr);
            this.zzb = i11;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    public abstract int zza();

    public abstract int[] zzb(int[] iArr, int i11);

    public final ByteBuffer zzc(byte[] bArr, int i11) {
        int[] zzb2 = zzb(zzgx.zzd(bArr), i11);
        int[] iArr = (int[]) zzb2.clone();
        zzgx.zzc(iArr);
        for (int i12 = 0; i12 < 16; i12++) {
            zzb2[i12] = zzb2[i12] + iArr[i12];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb2, 0, 16);
        return order;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length == zza()) {
            int remaining = byteBuffer.remaining();
            int i11 = remaining / 64;
            int i12 = 0;
            while (true) {
                int i13 = i11 + 1;
                if (i12 >= i13) {
                    return allocate.array();
                }
                ByteBuffer zzc = zzc(bArr, this.zzb + i12);
                if (i12 == i13 - 1) {
                    zzuu.zza(allocate, byteBuffer, zzc, remaining % 64);
                } else {
                    zzuu.zza(allocate, byteBuffer, zzc, 64);
                }
                i12++;
            }
        } else {
            int zza2 = zza();
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza2);
        }
    }
}
