package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

public final class zzanx extends zzaoa {
    private final View zzi;

    public zzanx(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12, View view) {
        super(zzams, "hQ5xuCRMiz6eJqaT4+9Wf/Kj854Yma0NmQLTM8SLOoEkyUHQjbgUSxF3PTxTz3Bq", "CIY4BMAyy7Fe28Pq7/h8od2SEEojcWEgmd3J7ORxssU=", zzaiz, i11, 57);
        this.zzi = view;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            Boolean bool = (Boolean) zzbgq.zzc().zzb(zzblj.zzcd);
            DisplayMetrics displayMetrics = this.zzb.zzb().getResources().getDisplayMetrics();
            zzamw zzamw = new zzamw((String) this.zzf.invoke((Object) null, new Object[]{this.zzi, displayMetrics, bool}));
            zzajn zza = zzajo.zza();
            zza.zzb(zzamw.zza.longValue());
            zza.zzc(zzamw.zzb.longValue());
            zza.zzd(zzamw.zzc.longValue());
            if (bool.booleanValue()) {
                zza.zza(zzamw.zzd.longValue());
            }
            this.zze.zzT((zzajo) zza.zzah());
        }
    }
}
