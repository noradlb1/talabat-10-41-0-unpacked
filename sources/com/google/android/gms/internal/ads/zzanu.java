package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

public final class zzanu extends zzaoa {
    private final zzamz zzi;
    private long zzj;

    public zzanu(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12, zzamz zzamz) {
        super(zzams, "e3op4R4hYomHt8fD4e46pNuu/60OumzY4fWht1zvNw/PVRGde3uP5Y0px+X+3p+E", "jLlOehpoNgAQzvuHrTyBcudcfwOhFguv/E47mcpJrto=", zzaiz, i11, 53);
        this.zzi = zzamz;
        if (zzamz != null) {
            this.zzj = zzamz.zza();
        }
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzL(((Long) this.zzf.invoke((Object) null, new Object[]{Long.valueOf(this.zzj)})).longValue());
        }
    }
}
