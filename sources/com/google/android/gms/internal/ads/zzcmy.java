package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class zzcmy implements Iterable<zzcmx> {
    private final List<zzcmx> zza = new ArrayList();

    public final Iterator<zzcmx> iterator() {
        return this.zza.iterator();
    }

    public final zzcmx zza(zzclh zzclh) {
        Iterator<zzcmx> it = iterator();
        while (it.hasNext()) {
            zzcmx next = it.next();
            if (next.zza == zzclh) {
                return next;
            }
        }
        return null;
    }

    public final void zzb(zzcmx zzcmx) {
        this.zza.add(zzcmx);
    }

    public final void zzc(zzcmx zzcmx) {
        this.zza.remove(zzcmx);
    }

    public final boolean zzd(zzclh zzclh) {
        ArrayList<zzcmx> arrayList = new ArrayList<>();
        Iterator<zzcmx> it = iterator();
        while (it.hasNext()) {
            zzcmx next = it.next();
            if (next.zza == zzclh) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (zzcmx zzcmx : arrayList) {
            zzcmx.zzb.zzb();
        }
        return true;
    }
}
