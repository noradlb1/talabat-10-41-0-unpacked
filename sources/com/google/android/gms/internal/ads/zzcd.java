package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public abstract class zzcd {
    public static final zzcd zza = new zzby();
    public static final zzj<zzcd> zzb = zzbx.zza;

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcd)) {
            return false;
        }
        zzcd zzcd = (zzcd) obj;
        if (zzcd.zzc() != zzc() || zzcd.zzb() != zzb()) {
            return false;
        }
        zzcc zzcc = new zzcc();
        zzca zzca = new zzca();
        zzcc zzcc2 = new zzcc();
        zzca zzca2 = new zzca();
        for (int i11 = 0; i11 < zzc(); i11++) {
            if (!zze(i11, zzcc, 0).equals(zzcd.zze(i11, zzcc2, 0))) {
                return false;
            }
        }
        for (int i12 = 0; i12 < zzb(); i12++) {
            if (!zzd(i12, zzca, true).equals(zzcd.zzd(i12, zzca2, true))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        zzcc zzcc = new zzcc();
        zzca zzca = new zzca();
        int zzc = zzc() + 217;
        for (int i11 = 0; i11 < zzc(); i11++) {
            zzc = (zzc * 31) + zze(i11, zzcc, 0).hashCode();
        }
        int zzb2 = (zzc * 31) + zzb();
        for (int i12 = 0; i12 < zzb(); i12++) {
            zzb2 = (zzb2 * 31) + zzd(i12, zzca, true).hashCode();
        }
        return zzb2;
    }

    public abstract int zza(Object obj);

    public abstract int zzb();

    public abstract int zzc();

    public abstract zzca zzd(int i11, zzca zzca, boolean z11);

    public abstract zzcc zze(int i11, zzcc zzcc, long j11);

    public abstract Object zzf(int i11);

    public int zzg(boolean z11) {
        return zzo() ? -1 : 0;
    }

    public int zzh(boolean z11) {
        if (zzo()) {
            return -1;
        }
        return zzc() - 1;
    }

    public final int zzi(int i11, zzca zzca, zzcc zzcc, int i12, boolean z11) {
        int i13 = zzd(i11, zzca, false).zzd;
        if (zze(i13, zzcc, 0).zzp != i11) {
            return i11 + 1;
        }
        int zzj = zzj(i13, i12, z11);
        if (zzj == -1) {
            return -1;
        }
        return zze(zzj, zzcc, 0).zzo;
    }

    public int zzj(int i11, int i12, boolean z11) {
        if (i12 != 0) {
            if (i12 == 1) {
                return i11;
            }
            if (i12 != 2) {
                throw new IllegalStateException();
            } else if (i11 == zzh(z11)) {
                return zzg(z11);
            } else {
                return i11 + 1;
            }
        } else if (i11 == zzh(z11)) {
            return -1;
        } else {
            return i11 + 1;
        }
    }

    public int zzk(int i11, int i12, boolean z11) {
        if (i11 == zzg(false)) {
            return -1;
        }
        return i11 - 1;
    }

    public final Pair<Object, Long> zzl(zzcc zzcc, zzca zzca, int i11, long j11) {
        Pair<Object, Long> zzm = zzm(zzcc, zzca, i11, j11, 0);
        zzm.getClass();
        return zzm;
    }

    @Nullable
    public final Pair<Object, Long> zzm(zzcc zzcc, zzca zzca, int i11, long j11, long j12) {
        zzdy.zza(i11, 0, zzc());
        zze(i11, zzcc, j12);
        if (j11 == C.TIME_UNSET) {
            long j13 = zzcc.zzm;
            j11 = 0;
        }
        int i12 = zzcc.zzo;
        zzd(i12, zzca, false);
        while (i12 < zzcc.zzp) {
            long j14 = zzca.zzf;
            int i13 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i13 == 0) {
                break;
            }
            int i14 = i12 + 1;
            long j15 = zzd(i14, zzca, false).zzf;
            if (i13 < 0) {
                break;
            }
            i12 = i14;
        }
        zzd(i12, zzca, true);
        long j16 = zzca.zzf;
        long j17 = zzca.zze;
        if (j17 != C.TIME_UNSET) {
            j11 = Math.min(j11, j17 - 1);
        }
        long max = Math.max(0, j11);
        Object obj = zzca.zzc;
        obj.getClass();
        return Pair.create(obj, Long.valueOf(max));
    }

    public zzca zzn(Object obj, zzca zzca) {
        return zzd(zza(obj), zzca, true);
    }

    public final boolean zzo() {
        return zzc() == 0;
    }
}
