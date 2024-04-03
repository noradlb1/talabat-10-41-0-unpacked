package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzaij extends zzgoy {
    ByteBuffer zza;

    public zzaij(String str) {
        super(str);
    }

    public final void zzf(ByteBuffer byteBuffer) {
        this.zza = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
