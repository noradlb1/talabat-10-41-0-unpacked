package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

final class zzeql implements zzevn<zzevm<Bundle>> {
    private final Set<String> zza;

    public zzeql(Set<String> set) {
        this.zza = set;
    }

    public final zzfxa<zzevm<Bundle>> zzb() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zza) {
            arrayList.add(add);
        }
        return zzfwq.zzi(new zzeqk(arrayList));
    }
}
