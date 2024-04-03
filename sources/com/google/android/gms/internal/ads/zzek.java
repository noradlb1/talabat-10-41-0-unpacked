package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final /* synthetic */ class zzek implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ zzel zzc;

    public /* synthetic */ zzek(CopyOnWriteArraySet copyOnWriteArraySet, int i11, zzel zzel) {
        this.zza = copyOnWriteArraySet;
        this.zzb = i11;
        this.zzc = zzel;
    }

    public final void run() {
        CopyOnWriteArraySet copyOnWriteArraySet = this.zza;
        int i11 = this.zzb;
        zzel zzel = this.zzc;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((zzen) it.next()).zza(i11, zzel);
        }
    }
}
