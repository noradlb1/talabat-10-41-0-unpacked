package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzanr extends zzaoa {
    private final boolean zzi;

    public zzanr(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "yRC8yDQzUDrmroLbdHZh1cdlZfd8ub/FsIslAHpddfKGkTWa/jUYdNJ0tT+5diCM", "HM4qeDzacgZSWStWAwQJTi2Amm6uvEB2WlZumyUY0B8=", zzaiz, i11, 61);
        this.zzi = zzams.zzs();
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb(), Boolean.valueOf(this.zzi)})).longValue();
        synchronized (this.zze) {
            this.zze.zzA(longValue);
        }
    }
}
