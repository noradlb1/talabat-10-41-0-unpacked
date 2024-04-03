package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zztc {
    private final CopyOnWriteArrayList<zztb> zza = new CopyOnWriteArrayList<>();

    public final void zza(Handler handler, zztd zztd) {
        zzc(zztd);
        this.zza.add(new zztb(handler, zztd));
    }

    public final void zzb(int i11, long j11, long j12) {
        Iterator<zztb> it = this.zza.iterator();
        while (it.hasNext()) {
            zztb next = it.next();
            if (!next.zzc) {
                next.zza.post(new zzta(next, i11, j11, j12));
            }
        }
    }

    public final void zzc(zztd zztd) {
        Iterator<zztb> it = this.zza.iterator();
        while (it.hasNext()) {
            zztb next = it.next();
            if (next.zzb == zztd) {
                next.zzc();
                this.zza.remove(next);
            }
        }
    }
}
