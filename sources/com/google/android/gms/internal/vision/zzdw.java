package com.google.android.gms.internal.vision;

import java.util.List;

final class zzdw extends zzdv {
    private final zzdu zzmh = new zzdu();

    public final void zza(Throwable th2, Throwable th3) {
        if (th3 == th2) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th3);
        } else if (th3 != null) {
            this.zzmh.zza(th2, true).add(th3);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }

    public final void zza(Throwable th2) {
        th2.printStackTrace();
        List<Throwable> zza = this.zzmh.zza(th2, false);
        if (zza != null) {
            synchronized (zza) {
                for (Throwable printStackTrace : zza) {
                    System.err.print("Suppressed: ");
                    printStackTrace.printStackTrace();
                }
            }
        }
    }
}
