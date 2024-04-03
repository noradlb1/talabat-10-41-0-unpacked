package com.google.android.gms.internal.ads;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.util.Arrays;

public final class zzd {
    public static final zzd zza = new zzd((Object) null, new zzc[0], 0, C.TIME_UNSET, 0);
    public static final zzj<zzd> zzb = zza.zza;
    private static final zzc zzd = new zzc(0).zzb(0);
    public final long zzc = 0;
    private final zzc[] zze;

    private zzd(@Nullable Object obj, zzc[] zzcArr, long j11, long j12, int i11) {
        this.zze = zzcArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzd.class == obj.getClass()) {
            zzd zzd2 = (zzd) obj;
            if (!zzfn.zzP((Object) null, (Object) null) || !Arrays.equals(this.zze, zzd2.zze)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (((int) C.TIME_UNSET) * 961) + Arrays.hashCode(this.zze);
    }

    public final String toString() {
        return "AdPlaybackState(adsId=" + null + ", adResumePositionUs=0, adGroups=[" + "])";
    }

    public final zzc zza(@IntRange(from = 0) int i11) {
        return i11 < 0 ? zzd : this.zze[i11];
    }
}
