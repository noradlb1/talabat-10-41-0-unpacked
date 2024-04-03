package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcxa {
    private final String zza;
    private final zzbwq zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public zzcxf zzd;
    private final zzbrt<Object> zze = new zzcwx(this);
    private final zzbrt<Object> zzf = new zzcwz(this);

    public zzcxa(String str, zzbwq zzbwq, Executor executor) {
        this.zza = str;
        this.zzb = zzbwq;
        this.zzc = executor;
    }

    public static /* bridge */ /* synthetic */ boolean zzg(zzcxa zzcxa, Map map) {
        if (map == null) {
            return false;
        }
        String str = (String) map.get("hashCode");
        if (TextUtils.isEmpty(str) || !str.equals(zzcxa.zza)) {
            return false;
        }
        return true;
    }

    public final void zzc(zzcxf zzcxf) {
        this.zzb.zzb("/updateActiveView", this.zze);
        this.zzb.zzb("/untrackActiveViewUnit", this.zzf);
        this.zzd = zzcxf;
    }

    public final void zzd(zzcop zzcop) {
        zzcop.zzaf("/updateActiveView", this.zze);
        zzcop.zzaf("/untrackActiveViewUnit", this.zzf);
    }

    public final void zze() {
        this.zzb.zzc("/updateActiveView", this.zze);
        this.zzb.zzc("/untrackActiveViewUnit", this.zzf);
    }

    public final void zzf(zzcop zzcop) {
        zzcop.zzaw("/updateActiveView", this.zze);
        zzcop.zzaw("/untrackActiveViewUnit", this.zzf);
    }
}
