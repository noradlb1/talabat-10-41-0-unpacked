package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class zzbh {
    /* access modifiers changed from: private */
    public final List<String> zza = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzb = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzc = new ArrayList();

    public final zzbh zza(String str, double d11, double d12) {
        int i11 = 0;
        while (i11 < this.zza.size()) {
            double doubleValue = this.zzc.get(i11).doubleValue();
            double doubleValue2 = this.zzb.get(i11).doubleValue();
            if (d11 < doubleValue || (doubleValue == d11 && d12 < doubleValue2)) {
                break;
            }
            i11++;
        }
        this.zza.add(i11, str);
        this.zzc.add(i11, Double.valueOf(d11));
        this.zzb.add(i11, Double.valueOf(d12));
        return this;
    }

    public final zzbj zzb() {
        return new zzbj(this, (zzbi) null);
    }
}
