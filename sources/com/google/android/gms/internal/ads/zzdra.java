package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

final class zzdra implements zzbnv {
    final /* synthetic */ zzdrw zza;
    final /* synthetic */ ViewGroup zzb;

    public zzdra(zzdrw zzdrw, ViewGroup viewGroup) {
        this.zza = zzdrw;
        this.zzb = viewGroup;
    }

    public final JSONObject zza() {
        return this.zza.zzo();
    }

    public final JSONObject zzb() {
        return this.zza.zzp();
    }

    public final void zzc() {
        zzdrw zzdrw = this.zza;
        zzfss<String> zzfss = zzdqx.zza;
        Map<String, WeakReference<View>> zzm = zzdrw.zzm();
        if (zzm != null) {
            int size = zzfss.size();
            int i11 = 0;
            while (i11 < size) {
                int i12 = i11 + 1;
                if (zzm.get(zzfss.get(i11)) == null) {
                    i11 = i12;
                } else {
                    this.zza.onClick(this.zzb);
                    return;
                }
            }
        }
    }

    public final void zzd(MotionEvent motionEvent) {
        this.zza.onTouch((View) null, motionEvent);
    }
}
