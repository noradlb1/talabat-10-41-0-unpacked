package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

public final class zzana extends zzaoa {
    private final Activity zzi;
    private final View zzj;

    public zzana(zzams zzams, String str, String str2, zzaiz zzaiz, int i11, int i12, View view, Activity activity) {
        super(zzams, "VJibBREzYucPjNukhWG65jB60OIZQrcDVR3W2JV3G5ynshQ4Nd74pHrZYUgRiYK0", "TiANcug5zndviERrHpzUihvZthrd+vHCK5ngnbrocVE=", zzaiz, i11, 62);
        this.zzj = view;
        this.zzi = activity;
    }

    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzj != null) {
            boolean booleanValue = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbP)).booleanValue();
            Object[] objArr = (Object[]) this.zzf.invoke((Object) null, new Object[]{this.zzj, this.zzi, Boolean.valueOf(booleanValue)});
            synchronized (this.zze) {
                this.zze.zzc(((Long) objArr[0]).longValue());
                this.zze.zze(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zze.zzd((String) objArr[2]);
                }
            }
        }
    }
}
