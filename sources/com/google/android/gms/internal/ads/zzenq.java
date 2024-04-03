package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import j$.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

public final class zzenq {
    private final ConcurrentHashMap<String, zzbzo> zza = new ConcurrentHashMap<>();
    private final zzdww zzb;

    public zzenq(zzdww zzdww) {
        this.zzb = zzdww;
    }

    @CheckForNull
    public final zzbzo zza(String str) {
        if (this.zza.containsKey(str)) {
            return this.zza.get(str);
        }
        return null;
    }

    public final void zzb(String str) {
        try {
            this.zza.put(str, this.zzb.zza(str));
        } catch (RemoteException e11) {
            zzciz.zzh("Couldn't create RTB adapter : ", e11);
        }
    }
}
