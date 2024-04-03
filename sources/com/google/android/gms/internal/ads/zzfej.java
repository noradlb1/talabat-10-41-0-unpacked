package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

public final class zzfej {
    public static zzbfi zza(Context context, List<zzfdo> list) {
        ArrayList arrayList = new ArrayList();
        for (zzfdo next : list) {
            if (next.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(next.zza, next.zzb));
            }
        }
        return new zzbfi(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzfdo zzb(List<zzfdo> list, zzfdo zzfdo) {
        return list.get(0);
    }

    public static zzfdo zzc(zzbfi zzbfi) {
        return zzbfi.zzi ? new zzfdo(-3, 0, true) : new zzfdo(zzbfi.zze, zzbfi.zzb, false);
    }
}
