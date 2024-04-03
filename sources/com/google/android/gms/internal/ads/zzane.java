package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzane extends zzaoa {
    public zzane(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12) {
        super(zzams, "glZYRiAaVgXhfq7gmv5KdTlxK1u1W7CDU+wEOCdR48SsabliUSLxOyNuMGeUOQq8", "BXtZidg/K24z5N/YUAEC4oPRR4OaYUycAQjBgFG9Ir4=", zzaiz, i11, 5);
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzk(-1);
        this.zze.zzj(-1);
        int[] iArr = (int[]) this.zzf.invoke((Object) null, new Object[]{this.zzb.zzb()});
        synchronized (this.zze) {
            this.zze.zzk((long) iArr[0]);
            this.zze.zzj((long) iArr[1]);
            int i11 = iArr[2];
            if (i11 != Integer.MIN_VALUE) {
                this.zze.zzi((long) i11);
            }
        }
    }
}
