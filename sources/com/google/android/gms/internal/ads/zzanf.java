package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzanf extends zzaoa {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzanf(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "9GRJeHWq4dh2BvJK4ycB7gT7rSPz0ZkF1/0dgXOpChUtvNoPNNrpav7wZxlsKwP4", "wAGvvwsR6C1vDVsIyeUg+KWcunmHMDzvTAjP5mYaviw=", zzaiz, i11, 44);
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
            this.zze.zzm(zzi.longValue());
        }
    }
}
