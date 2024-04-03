package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzqi {
    public final int zza;
    @Nullable
    public final zzpz zzb;
    private final CopyOnWriteArrayList<zzqh> zzc;

    public zzqi() {
        this(new CopyOnWriteArrayList(), 0, (zzpz) null, 0);
    }

    private zzqi(CopyOnWriteArrayList<zzqh> copyOnWriteArrayList, int i11, @Nullable zzpz zzpz, long j11) {
        this.zzc = copyOnWriteArrayList;
        this.zza = i11;
        this.zzb = zzpz;
    }

    private static final long zzn(long j11) {
        long zzd = zzk.zzd(j11);
        return zzd == C.TIME_UNSET ? C.TIME_UNSET : zzd;
    }

    @CheckResult
    public final zzqi zza(int i11, @Nullable zzpz zzpz, long j11) {
        return new zzqi(this.zzc, i11, zzpz, 0);
    }

    public final void zzb(Handler handler, zzqj zzqj) {
        this.zzc.add(new zzqh(handler, zzqj));
    }

    public final void zzc(zzpw zzpw) {
        Iterator<zzqh> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzqh next = it.next();
            zzfn.zzU(next.zza, new zzqg(this, next.zzb, zzpw));
        }
    }

    public final void zzd(int i11, @Nullable zzab zzab, int i12, @Nullable Object obj, long j11) {
        zzc(new zzpw(1, i11, zzab, 0, (Object) null, zzn(j11), C.TIME_UNSET));
    }

    public final void zze(zzpr zzpr, zzpw zzpw) {
        Iterator<zzqh> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzqh next = it.next();
            zzfn.zzU(next.zza, new zzqc(this, next.zzb, zzpr, zzpw));
        }
    }

    public final void zzf(zzpr zzpr, int i11, int i12, @Nullable zzab zzab, int i13, @Nullable Object obj, long j11, long j12) {
        zzpr zzpr2 = zzpr;
        zze(zzpr, new zzpw(1, -1, (zzab) null, 0, (Object) null, zzn(j11), zzn(j12)));
    }

    public final void zzg(zzpr zzpr, zzpw zzpw) {
        Iterator<zzqh> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzqh next = it.next();
            zzfn.zzU(next.zza, new zzqd(this, next.zzb, zzpr, zzpw));
        }
    }

    public final void zzh(zzpr zzpr, int i11, int i12, @Nullable zzab zzab, int i13, @Nullable Object obj, long j11, long j12) {
        zzpr zzpr2 = zzpr;
        zzg(zzpr, new zzpw(1, -1, (zzab) null, 0, (Object) null, zzn(j11), zzn(j12)));
    }

    public final void zzi(zzpr zzpr, zzpw zzpw, IOException iOException, boolean z11) {
        Iterator<zzqh> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzqh next = it.next();
            zzfn.zzU(next.zza, new zzqf(this, next.zzb, zzpr, zzpw, iOException, z11));
        }
    }

    public final void zzj(zzpr zzpr, int i11, int i12, @Nullable zzab zzab, int i13, @Nullable Object obj, long j11, long j12, IOException iOException, boolean z11) {
        zzpr zzpr2 = zzpr;
        zzi(zzpr, new zzpw(1, -1, (zzab) null, 0, (Object) null, zzn(j11), zzn(j12)), iOException, z11);
    }

    public final void zzk(zzpr zzpr, zzpw zzpw) {
        Iterator<zzqh> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzqh next = it.next();
            zzfn.zzU(next.zza, new zzqe(this, next.zzb, zzpr, zzpw));
        }
    }

    public final void zzl(zzpr zzpr, int i11, int i12, @Nullable zzab zzab, int i13, @Nullable Object obj, long j11, long j12) {
        zzpr zzpr2 = zzpr;
        zzk(zzpr, new zzpw(1, -1, (zzab) null, 0, (Object) null, zzn(j11), zzn(j12)));
    }

    public final void zzm(zzqj zzqj) {
        Iterator<zzqh> it = this.zzc.iterator();
        while (it.hasNext()) {
            zzqh next = it.next();
            if (next.zzb == zzqj) {
                this.zzc.remove(next);
            }
        }
    }
}
