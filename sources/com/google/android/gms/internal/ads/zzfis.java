package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

final class zzfis implements zzfio {
    private final zzfio zza;
    private final Queue<zzfin> zzb = new LinkedBlockingQueue();
    private final int zzc = ((Integer) zzbgq.zzc().zzb(zzblj.zzgt)).intValue();
    private final AtomicBoolean zzd = new AtomicBoolean(false);

    public zzfis(zzfio zzfio, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzfio;
        long intValue = (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzgs)).intValue();
        scheduledExecutorService.scheduleAtFixedRate(new zzfir(this), intValue, intValue, TimeUnit.MILLISECONDS);
    }

    public static /* synthetic */ void zzc(zzfis zzfis) {
        while (!zzfis.zzb.isEmpty()) {
            zzfis.zza.zzb(zzfis.zzb.remove());
        }
    }

    public final String zza(zzfin zzfin) {
        return this.zza.zza(zzfin);
    }

    public final void zzb(zzfin zzfin) {
        if (this.zzb.size() < this.zzc) {
            this.zzb.offer(zzfin);
        } else if (!this.zzd.getAndSet(true)) {
            Queue<zzfin> queue = this.zzb;
            zzfin zzb2 = zzfin.zzb("dropped_event");
            Map<String, String> zzj = zzfin.zzj();
            if (zzj.containsKey(NativeProtocol.WEB_DIALOG_ACTION)) {
                zzb2.zza("dropped_action", zzj.get(NativeProtocol.WEB_DIALOG_ACTION));
            }
            queue.offer(zzb2);
        }
    }
}
