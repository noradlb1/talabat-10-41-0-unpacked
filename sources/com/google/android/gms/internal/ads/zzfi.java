package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

final class zzfi implements zzei {
    @GuardedBy("messagePool")
    private static final List<zzfh> zza = new ArrayList(50);
    private final Handler zzb;

    public zzfi(Handler handler) {
        this.zzb = handler;
    }

    public static /* bridge */ /* synthetic */ void zzk(zzfh zzfh) {
        List<zzfh> list = zza;
        synchronized (list) {
            if (list.size() < 50) {
                list.add(zzfh);
            }
        }
    }

    private static zzfh zzl() {
        zzfh zzfh;
        List<zzfh> list = zza;
        synchronized (list) {
            if (list.isEmpty()) {
                zzfh = new zzfh((zzfg) null);
            } else {
                zzfh = list.remove(list.size() - 1);
            }
        }
        return zzfh;
    }

    public final zzeh zza(int i11) {
        zzfh zzl = zzl();
        zzl.zzb(this.zzb.obtainMessage(i11), this);
        return zzl;
    }

    public final zzeh zzb(int i11, @Nullable Object obj) {
        zzfh zzl = zzl();
        zzl.zzb(this.zzb.obtainMessage(i11, obj), this);
        return zzl;
    }

    public final zzeh zzc(int i11, int i12, int i13) {
        zzfh zzl = zzl();
        zzl.zzb(this.zzb.obtainMessage(1, i12, i13), this);
        return zzl;
    }

    public final void zzd(@Nullable Object obj) {
        this.zzb.removeCallbacksAndMessages((Object) null);
    }

    public final void zze(int i11) {
        this.zzb.removeMessages(2);
    }

    public final boolean zzf(int i11) {
        return this.zzb.hasMessages(0);
    }

    public final boolean zzg(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    public final boolean zzh(int i11) {
        return this.zzb.sendEmptyMessage(i11);
    }

    public final boolean zzi(int i11, long j11) {
        return this.zzb.sendEmptyMessageAtTime(2, j11);
    }

    public final boolean zzj(zzeh zzeh) {
        return ((zzfh) zzeh).zzc(this.zzb);
    }
}
