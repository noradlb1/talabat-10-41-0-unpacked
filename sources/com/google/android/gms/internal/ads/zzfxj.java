package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

final class zzfxj<V> implements Runnable {
    @CheckForNull
    zzfxm<V> zza;

    public zzfxj(zzfxm<V> zzfxm) {
        this.zza = zzfxm;
    }

    public final void run() {
        zzfxa zza2;
        String str;
        zzfxm<V> zzfxm = this.zza;
        if (zzfxm != null && (zza2 = zzfxm.zza) != null) {
            this.zza = null;
            if (zza2.isDone()) {
                zzfxm.zzu(zza2);
                return;
            }
            try {
                ScheduledFuture zzx = zzfxm.zzb;
                zzfxm.zzb = null;
                str = "Timed out";
                if (zzx != null) {
                    long abs = Math.abs(zzx.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        StringBuilder sb2 = new StringBuilder(75);
                        sb2.append(str);
                        sb2.append(" (timeout delayed by ");
                        sb2.append(abs);
                        sb2.append(" ms after scheduled time)");
                        str = sb2.toString();
                    }
                }
                String obj = zza2.toString();
                StringBuilder sb3 = new StringBuilder(str.length() + 2 + obj.length());
                sb3.append(str);
                sb3.append(": ");
                sb3.append(obj);
                zzfxm.zzt(new zzfxl(sb3.toString(), (zzfxk) null));
                zza2.cancel(true);
            } catch (Throwable th2) {
                zza2.cancel(true);
                throw th2;
            }
        }
    }
}
