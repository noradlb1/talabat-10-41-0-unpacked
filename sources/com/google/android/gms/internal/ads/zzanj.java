package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzanj extends zzaoa {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzanj(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "hUIXYyX7voAFfmX9K6Tyj7UNRMoApsO3NHhichzgf1HY6Km4YpCnpT8GA4sfwulx", "RhEw32BK9OU3wzUC3Jj98VTZvnt6yWz3Jzx/x8tD2qo=", zzaiz, i11, 22);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (Long) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzu(zzi.longValue());
        }
    }
}
