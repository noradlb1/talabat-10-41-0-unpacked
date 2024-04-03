package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.ArrayList;
import java.util.List;

final class zzbjp extends zzbtt {
    final /* synthetic */ zzbjq zza;

    public /* synthetic */ zzbjp(zzbjq zzbjq, zzbjo zzbjo) {
        this.zza = zzbjq;
    }

    public final void zzb(List<zzbtn> list) throws RemoteException {
        this.zza.zze = false;
        this.zza.zzf = true;
        InitializationStatus zzd = zzbjq.zzx(list);
        ArrayList zzh = zzbjq.zzf().zzb;
        int size = zzh.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((OnInitializationCompleteListener) zzh.get(i11)).onInitializationComplete(zzd);
        }
        zzbjq.zzf().zzb.clear();
    }
}
