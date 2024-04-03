package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzans extends zzaoa {
    private final StackTraceElement[] zzi;

    public zzans(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12, StackTraceElement[] stackTraceElementArr) {
        super(zzams, "xd283h5qAcacM5zVZnbCaCYEYmyBvCzSWmcoDFc838gJ/DBCdoedE0EgOC5ZJs5s", "KFN28huBDzw/UNPPRO5YgG4GEIzzfegN1j75wmksmGk=", zzaiz, i11, 45);
        this.zzi = stackTraceElementArr;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        Object obj = this.zzi;
        if (obj != null) {
            int i11 = 1;
            zzamk zzamk = new zzamk((String) this.zzf.invoke((Object) null, new Object[]{obj}));
            synchronized (this.zze) {
                this.zze.zzB(zzamk.zza.longValue());
                if (zzamk.zzb.booleanValue()) {
                    zzaiz zzaiz = this.zze;
                    if (true != zzamk.zzc.booleanValue()) {
                        i11 = 2;
                    }
                    zzaiz.zzX(i11);
                } else {
                    this.zze.zzX(3);
                }
            }
        }
    }
}
