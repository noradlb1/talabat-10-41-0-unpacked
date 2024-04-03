package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;

public final /* synthetic */ class zzdjz implements Runnable {
    public final /* synthetic */ zzdka zza;
    public final /* synthetic */ Object zzb;

    public /* synthetic */ zzdjz(zzdka zzdka, Object obj) {
        this.zza = zzdka;
        this.zzb = obj;
    }

    public final void run() {
        try {
            this.zza.zza(this.zzb);
        } catch (Throwable th2) {
            zzt.zzo().zzr(th2, "EventEmitter.notify");
            zze.zzb("Event emitter exception.", th2);
        }
    }
}
