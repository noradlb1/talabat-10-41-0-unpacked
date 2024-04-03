package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

final class zzaqp implements zzapv {
    private int zzb = -1;
    private int zzc = -1;
    private int[] zzd;
    private boolean zze;
    private int[] zzf;
    private ByteBuffer zzg;
    private ByteBuffer zzh;
    private boolean zzi;

    public zzaqp() {
        ByteBuffer byteBuffer = zzapv.zza;
        this.zzg = byteBuffer;
        this.zzh = byteBuffer;
    }

    public final int zza() {
        int[] iArr = this.zzf;
        return iArr == null ? this.zzb : iArr.length;
    }

    public final int zzb() {
        return 2;
    }

    public final ByteBuffer zzc() {
        ByteBuffer byteBuffer = this.zzh;
        this.zzh = zzapv.zza;
        return byteBuffer;
    }

    public final void zzd() {
        this.zzh = zzapv.zza;
        this.zzi = false;
    }

    public final void zze() {
        this.zzi = true;
    }

    public final void zzf(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i11 = this.zzb;
        int length = ((limit - position) / (i11 + i11)) * this.zzf.length;
        int i12 = length + length;
        if (this.zzg.capacity() < i12) {
            this.zzg = ByteBuffer.allocateDirect(i12).order(ByteOrder.nativeOrder());
        } else {
            this.zzg.clear();
        }
        while (position < limit) {
            for (int i13 : this.zzf) {
                this.zzg.putShort(byteBuffer.getShort(i13 + i13 + position));
            }
            int i14 = this.zzb;
            position += i14 + i14;
        }
        byteBuffer.position(limit);
        this.zzg.flip();
        this.zzh = this.zzg;
    }

    public final void zzg() {
        zzd();
        this.zzg = zzapv.zza;
        this.zzb = -1;
        this.zzc = -1;
        this.zzf = null;
        this.zze = false;
    }

    public final boolean zzh(int i11, int i12, int i13) throws zzapu {
        boolean z11;
        boolean z12;
        boolean z13 = !Arrays.equals(this.zzd, this.zzf);
        int[] iArr = this.zzd;
        this.zzf = iArr;
        if (iArr == null) {
            this.zze = false;
            return z13;
        } else if (i13 != 2) {
            throw new zzapu(i11, i12, i13);
        } else if (!z13 && this.zzc == i11 && this.zzb == i12) {
            return false;
        } else {
            this.zzc = i11;
            this.zzb = i12;
            if (i12 != iArr.length) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.zze = z11;
            int i14 = 0;
            while (true) {
                int[] iArr2 = this.zzf;
                if (i14 >= iArr2.length) {
                    return true;
                }
                int i15 = iArr2[i14];
                if (i15 < i12) {
                    boolean z14 = this.zze;
                    if (i15 != i14) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    this.zze = z12 | z14;
                    i14++;
                } else {
                    throw new zzapu(i11, i12, 2);
                }
            }
        }
    }

    public final boolean zzi() {
        return this.zze;
    }

    public final boolean zzj() {
        return this.zzi && this.zzh == zzapv.zza;
    }

    public final void zzk(int[] iArr) {
        this.zzd = iArr;
    }
}
