package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zzghg implements zzfxu {
    private final zzghe zza;
    private final zzghe zzb;

    public zzghg(byte[] bArr) throws GeneralSecurityException {
        if (zzgak.zza(1)) {
            this.zza = zzb(bArr, 1);
            this.zzb = zzb(bArr, 0);
            return;
        }
        throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
    }

    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int i11;
        int length = bArr.length;
        if (length <= (Integer.MAX_VALUE - this.zza.zzb()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(this.zza.zzb() + length + 16);
            if (allocate.remaining() >= length + this.zza.zzb() + 16) {
                int position = allocate.position();
                this.zza.zze(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.zza.zzb()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                byte[] bArr4 = new byte[32];
                this.zzb.zzd(bArr3, 0).get(bArr4);
                int remaining = allocate.remaining();
                int i12 = remaining % 16;
                if (i12 == 0) {
                    i11 = remaining;
                } else {
                    i11 = (remaining + 16) - i12;
                }
                ByteBuffer order = ByteBuffer.allocate(i11 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(0);
                order.put(allocate);
                order.position(i11);
                order.putLong(0);
                order.putLong((long) remaining);
                byte[] zza2 = zzgia.zza(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(zza2);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    public abstract zzghe zzb(byte[] bArr, int i11) throws InvalidKeyException;
}
