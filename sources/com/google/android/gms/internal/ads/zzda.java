package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class zzda extends zzcu {
    public final zzcx zza = new zzcx();
    @Nullable
    public ByteBuffer zzb;
    public boolean zzc;
    public long zzd;
    @Nullable
    public ByteBuffer zze;
    private final int zzf;

    public zzda(int i11, int i12) {
        this.zzf = i11;
    }

    private final ByteBuffer zzl(int i11) {
        int i12;
        int i13 = this.zzf;
        if (i13 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i13 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            i12 = 0;
        } else {
            i12 = byteBuffer.capacity();
        }
        throw new zzcz(i12, i11);
    }

    public void zzb() {
        super.zzb();
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.zze;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.zzc = false;
    }

    @EnsuresNonNull({"data"})
    public final void zzi(int i11) {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer == null) {
            this.zzb = zzl(i11);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = byteBuffer.position();
        int i12 = i11 + position;
        if (capacity >= i12) {
            this.zzb = byteBuffer;
            return;
        }
        ByteBuffer zzl = zzl(i12);
        zzl.order(byteBuffer.order());
        if (position > 0) {
            byteBuffer.flip();
            zzl.put(byteBuffer);
        }
        this.zzb = zzl;
    }

    public final void zzj() {
        ByteBuffer byteBuffer = this.zzb;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.zze;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean zzk() {
        return zzd(1073741824);
    }
}
