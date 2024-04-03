package com.google.android.gms.internal.gtm;

import java.io.PrintStream;
import java.util.List;

final class zzpj extends zzpg {
    private final zzph zzavo = new zzph();

    public final void zza(Throwable th2, PrintStream printStream) {
        th2.printStackTrace(printStream);
        List<Throwable> zza = this.zzavo.zza(th2, false);
        if (zza != null) {
            synchronized (zza) {
                for (Throwable printStackTrace : zza) {
                    printStream.print("Suppressed: ");
                    printStackTrace.printStackTrace(printStream);
                }
            }
        }
    }
}
