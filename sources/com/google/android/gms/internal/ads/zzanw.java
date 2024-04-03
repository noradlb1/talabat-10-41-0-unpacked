package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzanw extends zzaoa {
    public zzanw(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "uUtXgghNropSfe2KUSoP0Efn1EgB4X6maOF+tPLLzG1rSS0RqDSE3s9EWbbdwRaZ", "iu0TCa9uEtKUas610luihENZAQIiF7MRaL5XfmToU24=", zzaiz, i11, 48);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzaa(3);
        boolean booleanValue = ((Boolean) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()})).booleanValue();
        synchronized (this.zze) {
            if (booleanValue) {
                this.zze.zzaa(2);
            } else {
                this.zze.zzaa(1);
            }
        }
    }
}
