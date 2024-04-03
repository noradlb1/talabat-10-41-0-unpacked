package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

final class zzafr implements zzafs {
    private final ByteBuffer zza;

    public zzafr(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    public final long zza() {
        return (long) this.zza.capacity();
    }

    public final void zzb(MessageDigest[] messageDigestArr, long j11, int i11) throws IOException {
        ByteBuffer slice;
        synchronized (this.zza) {
            int i12 = (int) j11;
            this.zza.position(i12);
            this.zza.limit(i12 + i11);
            slice = this.zza.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
