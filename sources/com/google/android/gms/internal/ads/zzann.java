package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;

public final class zzann extends zzaoa {
    private static volatile String zzi;
    private static final Object zzj = new Object();

    public zzann(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "uVfRV2qL6y+/frn7UQ8HZUcJpLFj+yNt3k4Ns9czyDlwcIbIheGCFGCtGsGaaHh4", "RmtCo/dRwPWzjhuo/V+opsA0IDlV0P6pRfQFRNu3WDY=", zzaiz, i11, 1);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzx(ExifInterface.LONGITUDE_EAST);
        if (zzi == null) {
            synchronized (zzj) {
                if (zzi == null) {
                    zzi = (String) this.zzf.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzx(zzi);
        }
    }
}
