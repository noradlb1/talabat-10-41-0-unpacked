package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

final class zzaft implements zzafs {
    private final FileChannel zza;
    private final long zzb;
    private final long zzc;

    public zzaft(FileChannel fileChannel, long j11, long j12) {
        this.zza = fileChannel;
        this.zzb = j11;
        this.zzc = j12;
    }

    public final long zza() {
        return this.zzc;
    }

    public final void zzb(MessageDigest[] messageDigestArr, long j11, int i11) throws IOException {
        MappedByteBuffer map = this.zza.map(FileChannel.MapMode.READ_ONLY, this.zzb + j11, (long) i11);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
