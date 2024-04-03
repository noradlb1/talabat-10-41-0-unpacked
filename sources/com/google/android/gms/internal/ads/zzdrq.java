package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

public final /* synthetic */ class zzdrq implements zzbrt {
    public final /* synthetic */ zzdru zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ WindowManager zzc;

    public /* synthetic */ zzdrq(zzdru zzdru, View view, WindowManager windowManager) {
        this.zza = zzdru;
        this.zzb = view;
        this.zzc = windowManager;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zze(this.zzb, this.zzc, (zzcop) obj, map);
    }
}
