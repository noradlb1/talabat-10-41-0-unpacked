package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzanv extends zzaoa {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzanv(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "M8X9pjLXmkUmNpxAUiXCS0VzRrfgsx47JCdWPtF77o1zbxjaTxGH9o3y3XsfapA3", "IGAB4+J/PDJStxsBeRODYeAaV8Ap48L0bK2MK3UJNBs=", zzaiz, i11, 33);
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
            this.zze.zzQ(zzi.longValue());
        }
    }
}
