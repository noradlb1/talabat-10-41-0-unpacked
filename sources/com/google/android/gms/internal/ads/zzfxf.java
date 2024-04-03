package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfvg;

final class zzfxf extends zzfvg.zzi<Void> implements Runnable {
    private final Runnable zza;

    public zzfxf(Runnable runnable) {
        runnable.getClass();
        this.zza = runnable;
    }

    public final void run() {
        try {
            this.zza.run();
        } catch (Throwable th2) {
            zzt(th2);
            zzfqt.zzb(th2);
            throw new RuntimeException(th2);
        }
    }

    public final String zzd() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 7);
        sb2.append("task=[");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }
}
