package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzne {
    public final int zza;
    @Nullable
    public final zzpz zzb;
    private final CopyOnWriteArrayList<zznd> zzc;

    public zzne() {
        this(new CopyOnWriteArrayList(), 0, (zzpz) null);
    }

    private zzne(CopyOnWriteArrayList<zznd> copyOnWriteArrayList, int i11, @Nullable zzpz zzpz) {
        this.zzc = copyOnWriteArrayList;
        this.zza = i11;
        this.zzb = zzpz;
    }

    @CheckResult
    public final zzne zza(int i11, @Nullable zzpz zzpz) {
        return new zzne(this.zzc, i11, zzpz);
    }

    public final void zzb(Handler handler, zznf zznf) {
        this.zzc.add(new zznd(handler, zznf));
    }

    public final void zzc(zznf zznf) {
        Iterator<zznd> it = this.zzc.iterator();
        while (it.hasNext()) {
            zznd next = it.next();
            if (next.zzb == zznf) {
                this.zzc.remove(next);
            }
        }
    }
}
