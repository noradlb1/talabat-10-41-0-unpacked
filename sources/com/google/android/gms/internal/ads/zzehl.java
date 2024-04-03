package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.DialogInterface;
import com.google.android.gms.ads.internal.overlay.zzl;
import java.util.HashMap;

public final /* synthetic */ class zzehl implements DialogInterface.OnCancelListener {
    public final /* synthetic */ zzehh zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzdyz zzc;
    public final /* synthetic */ Activity zzd;
    public final /* synthetic */ zzfio zze;
    public final /* synthetic */ zzl zzf;

    public /* synthetic */ zzehl(zzehh zzehh, String str, zzdyz zzdyz, Activity activity, zzfio zzfio, zzl zzl) {
        this.zza = zzehh;
        this.zzb = str;
        this.zzc = zzdyz;
        this.zzd = activity;
        this.zze = zzfio;
        this.zzf = zzl;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        zzehh zzehh = this.zza;
        String str = this.zzb;
        zzdyz zzdyz = this.zzc;
        Activity activity = this.zzd;
        zzfio zzfio = this.zze;
        zzl zzl = this.zzf;
        zzehh.zzc(str);
        if (zzdyz != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_action", "dismiss");
            zzehp.zzd(activity, zzdyz, zzfio, zzehh, str, "dialog_click", hashMap);
        }
        if (zzl != null) {
            zzl.zzb();
        }
    }
}
