package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import com.google.android.gms.ads.internal.util.zzt;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
public final class zzclb {
    private final long zza = TimeUnit.MILLISECONDS.toNanos(((Long) zzbgq.zzc().zzb(zzblj.zzy)).longValue());
    private long zzb;
    private boolean zzc = true;

    public final void zza(SurfaceTexture surfaceTexture, zzckn zzckn) {
        if (zzckn != null) {
            long timestamp = surfaceTexture.getTimestamp();
            if (this.zzc || Math.abs(timestamp - this.zzb) >= this.zza) {
                this.zzc = false;
                this.zzb = timestamp;
                zzt.zza.post(new zzcla(this, zzckn));
            }
        }
    }

    public final void zzb() {
        this.zzc = true;
    }
}
