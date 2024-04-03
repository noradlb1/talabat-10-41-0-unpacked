package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import java.nio.ByteBuffer;

final class zznz extends zzda {
    private long zzf;
    private int zzg;
    private int zzh = 32;

    public zznz() {
        super(2, 0);
    }

    public final void zzb() {
        super.zzb();
        this.zzg = 0;
    }

    public final int zzl() {
        return this.zzg;
    }

    public final long zzm() {
        return this.zzf;
    }

    public final void zzn(@IntRange(from = 1) int i11) {
        this.zzh = i11;
    }

    public final boolean zzo(zzda zzda) {
        ByteBuffer byteBuffer;
        zzdy.zzd(!zzda.zzd(1073741824));
        zzdy.zzd(!zzda.zzd(268435456));
        zzdy.zzd(!zzda.zzd(4));
        if (zzp()) {
            if (this.zzg >= this.zzh || zzda.zzd(Integer.MIN_VALUE) != zzd(Integer.MIN_VALUE)) {
                return false;
            }
            ByteBuffer byteBuffer2 = zzda.zzb;
            if (!(byteBuffer2 == null || (byteBuffer = this.zzb) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000)) {
                return false;
            }
        }
        int i11 = this.zzg;
        this.zzg = i11 + 1;
        if (i11 == 0) {
            this.zzd = zzda.zzd;
            if (zzda.zzd(1)) {
                zzc(1);
            }
        }
        if (zzda.zzd(Integer.MIN_VALUE)) {
            zzc(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer3 = zzda.zzb;
        if (byteBuffer3 != null) {
            zzi(byteBuffer3.remaining());
            this.zzb.put(byteBuffer3);
        }
        this.zzf = zzda.zzd;
        return true;
    }

    public final boolean zzp() {
        return this.zzg > 0;
    }
}
