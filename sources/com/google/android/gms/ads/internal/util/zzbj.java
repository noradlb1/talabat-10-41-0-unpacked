package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class zzbj {
    private final String[] zza;
    private final double[] zzb;
    private final double[] zzc;
    private final int[] zzd;
    private int zze = 0;

    public /* synthetic */ zzbj(zzbh zzbh, zzbi zzbi) {
        int size = zzbh.zzb.size();
        this.zza = (String[]) zzbh.zza.toArray(new String[size]);
        this.zzb = zzc(zzbh.zzb);
        this.zzc = zzc(zzbh.zzc);
        this.zzd = new int[size];
    }

    private static final double[] zzc(List<Double> list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i11 = 0; i11 < size; i11++) {
            dArr[i11] = list.get(i11).doubleValue();
        }
        return dArr;
    }

    public final List<zzbg> zza() {
        ArrayList arrayList = new ArrayList(this.zza.length);
        int i11 = 0;
        while (true) {
            String[] strArr = this.zza;
            if (i11 >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i11];
            double d11 = this.zzc[i11];
            double d12 = this.zzb[i11];
            int i12 = this.zzd[i11];
            arrayList.add(new zzbg(str, d11, d12, ((double) i12) / ((double) this.zze), i12));
            i11++;
        }
    }

    public final void zzb(double d11) {
        this.zze++;
        int i11 = 0;
        while (true) {
            double[] dArr = this.zzc;
            if (i11 < dArr.length) {
                double d12 = dArr[i11];
                if (d12 <= d11 && d11 < this.zzb[i11]) {
                    int[] iArr = this.zzd;
                    iArr[i11] = iArr[i11] + 1;
                }
                if (d11 >= d12) {
                    i11++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }
}
