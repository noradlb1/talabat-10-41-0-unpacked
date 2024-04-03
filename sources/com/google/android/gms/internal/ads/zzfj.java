package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

public final class zzfj<V> {
    private long[] zza;
    private V[] zzb;
    private int zzc;
    private int zzd;

    public zzfj() {
        this(10);
    }

    public zzfj(int i11) {
        this.zza = new long[10];
        this.zzb = new Object[10];
    }

    @Nullable
    private final V zzf() {
        boolean z11;
        if (this.zzd > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        V[] vArr = this.zzb;
        int i11 = this.zzc;
        V v11 = vArr[i11];
        vArr[i11] = null;
        this.zzc = (i11 + 1) % vArr.length;
        this.zzd--;
        return v11;
    }

    public final synchronized int zza() {
        return this.zzd;
    }

    @Nullable
    public final synchronized V zzb() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    @Nullable
    public final synchronized V zzc(long j11) {
        V v11;
        v11 = null;
        while (true) {
            if (this.zzd <= 0) {
                break;
            } else if (j11 - this.zza[this.zzc] < 0) {
                break;
            } else {
                v11 = zzf();
            }
        }
        return v11;
    }

    public final synchronized void zzd(long j11, V v11) {
        int i11 = this.zzd;
        if (i11 > 0) {
            if (j11 <= this.zza[((this.zzc + i11) - 1) % this.zzb.length]) {
                zze();
            }
        }
        int length = this.zzb.length;
        if (this.zzd >= length) {
            int i12 = length + length;
            long[] jArr = new long[i12];
            V[] vArr = new Object[i12];
            int i13 = this.zzc;
            int i14 = length - i13;
            System.arraycopy(this.zza, i13, jArr, 0, i14);
            System.arraycopy(this.zzb, this.zzc, vArr, 0, i14);
            int i15 = this.zzc;
            if (i15 > 0) {
                System.arraycopy(this.zza, 0, jArr, i14, i15);
                System.arraycopy(this.zzb, 0, vArr, i14, this.zzc);
            }
            this.zza = jArr;
            this.zzb = vArr;
            this.zzc = 0;
        }
        int i16 = this.zzc;
        int i17 = this.zzd;
        V[] vArr2 = this.zzb;
        int length2 = (i16 + i17) % vArr2.length;
        this.zza[length2] = j11;
        vArr2[length2] = v11;
        this.zzd = i17 + 1;
    }

    public final synchronized void zze() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }
}
