package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final class zzere implements zzevn<zzerf> {
    private final AppSetIdClient zza;

    public zzere(Context context) {
        this.zza = AppSet.getClient(context);
    }

    public final zzfxa<zzerf> zzb() {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzbU)).booleanValue()) {
            return zzfwq.zzi(new zzerf((String) null, -1));
        }
        Task<AppSetIdInfo> appSetIdInfo = this.zza.getAppSetIdInfo();
        zzfxi zza2 = zzfxi.zza();
        appSetIdInfo.addOnCompleteListener(zzfxh.zzb(), (OnCompleteListener<AppSetIdInfo>) new zzfpk(zza2));
        return zzfwq.zzm(zza2, zzerd.zza, zzcjm.zzf);
    }
}
