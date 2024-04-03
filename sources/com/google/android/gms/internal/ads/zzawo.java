package com.google.android.gms.internal.ads;

public final class zzawo {
    private boolean zza;

    public final synchronized void zza() throws InterruptedException {
        while (!this.zza) {
            wait();
        }
    }

    public final synchronized boolean zzb() {
        boolean z11;
        z11 = this.zza;
        this.zza = false;
        return z11;
    }

    public final synchronized boolean zzc() {
        if (this.zza) {
            return false;
        }
        this.zza = true;
        notifyAll();
        return true;
    }
}
