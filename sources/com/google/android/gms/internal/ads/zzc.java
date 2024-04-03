package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.CheckResult;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.util.Arrays;

public final class zzc {
    public static final zzj<zzc> zza = zzb.zza;
    public final long zzb;
    public final int zzc;
    public final Uri[] zzd;
    public final int[] zze;
    public final long[] zzf;
    public final long zzg;
    public final boolean zzh;

    public zzc(long j11) {
        this(0, -1, new int[0], new Uri[0], new long[0], 0, false);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzc.class == obj.getClass()) {
            zzc zzc2 = (zzc) obj;
            if (this.zzc != zzc2.zzc || !Arrays.equals(this.zzd, zzc2.zzd) || !Arrays.equals(this.zze, zzc2.zze) || !Arrays.equals(this.zzf, zzc2.zzf)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zzc * 961) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze)) * 31) + Arrays.hashCode(this.zzf)) * 961;
    }

    public final int zza(@IntRange(from = -1) int i11) {
        int i12;
        int i13 = i11 + 1;
        while (true) {
            int[] iArr = this.zze;
            if (i13 >= iArr.length || (i12 = iArr[i13]) == 0 || i12 == 1) {
                return i13;
            }
            i13++;
        }
        return i13;
    }

    @CheckResult
    public final zzc zzb(int i11) {
        int[] iArr = this.zze;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = this.zzf;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, C.TIME_UNSET);
        return new zzc(0, 0, copyOf, (Uri[]) Arrays.copyOf(this.zzd, 0), copyOf2, 0, false);
    }

    private zzc(long j11, int i11, int[] iArr, Uri[] uriArr, long[] jArr, long j12, boolean z11) {
        zzdy.zzd(iArr.length == uriArr.length);
        this.zzb = 0;
        this.zzc = i11;
        this.zze = iArr;
        this.zzd = uriArr;
        this.zzf = jArr;
        this.zzg = 0;
        this.zzh = false;
    }
}
