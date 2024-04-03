package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;

public final class zzgc implements zzhs {
    private final zztk zza;
    private final long zzb = zzk.zzc(50000);
    private final long zzc = zzk.zzc(50000);
    private final long zzd = zzk.zzc(2500);
    private final long zze = zzk.zzc(5000);
    private final long zzf = zzk.zzc(0);
    private int zzg = 13107200;
    private boolean zzh;

    public zzgc() {
        zztk zztk = new zztk(true, 65536);
        zzj(2500, 0, "bufferForPlaybackMs", "0");
        zzj(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzj(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzj(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(50000, 50000, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", "0");
        this.zza = zztk;
    }

    private static void zzj(int i11, int i12, String str, String str2) {
        boolean z11 = i11 >= i12;
        StringBuilder sb2 = new StringBuilder(str.length() + 21 + str2.length());
        sb2.append(str);
        sb2.append(" cannot be less than ");
        sb2.append(str2);
        zzdy.zze(z11, sb2.toString());
    }

    private final void zzk(boolean z11) {
        this.zzg = 13107200;
        this.zzh = false;
        if (z11) {
            this.zza.zze();
        }
    }

    public final long zza() {
        return this.zzf;
    }

    public final void zzb() {
        zzk(false);
    }

    public final void zzc() {
        zzk(true);
    }

    public final void zzd() {
        zzk(true);
    }

    public final boolean zze() {
        return false;
    }

    public final boolean zzf(long j11, long j12, float f11) {
        int zza2 = this.zza.zza();
        int i11 = this.zzg;
        long j13 = this.zzb;
        if (f11 > 1.0f) {
            j13 = Math.min(zzfn.zzp(j13, f11), this.zzc);
        }
        int i12 = (j12 > Math.max(j13, 500000) ? 1 : (j12 == Math.max(j13, 500000) ? 0 : -1));
        boolean z11 = false;
        if (i12 < 0) {
            if (zza2 < i11) {
                z11 = true;
            }
            this.zzh = z11;
            if (!z11 && j12 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.zzc || zza2 >= i11) {
            this.zzh = false;
        }
        return this.zzh;
    }

    public final boolean zzg(long j11, float f11, boolean z11, long j12) {
        long j13;
        long zzr = zzfn.zzr(j11, f11);
        if (z11) {
            j13 = this.zze;
        } else {
            j13 = this.zzd;
        }
        if (j12 != C.TIME_UNSET) {
            j13 = Math.min(j12 / 2, j13);
        }
        if (j13 <= 0 || zzr >= j13 || this.zza.zza() >= this.zzg) {
            return true;
        }
        return false;
    }

    public final zztk zzh() {
        return this.zza;
    }

    public final void zzi(zzil[] zzilArr, zzch zzch, zzsb[] zzsbArr) {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = 13107200;
            if (i11 < 2) {
                if (zzsbArr[i11] != null) {
                    if (zzilArr[i11].zzb() != 1) {
                        i13 = DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE;
                    }
                    i12 += i13;
                }
                i11++;
            } else {
                int max = Math.max(13107200, i12);
                this.zzg = max;
                this.zza.zzf(max);
                return;
            }
        }
    }
}
