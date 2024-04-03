package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public final class zzdly extends zzdkb<zzaya> implements zzaya {
    @GuardedBy("this")
    private final Map<View, zzayb> zzb = new WeakHashMap(1);
    private final Context zzc;
    private final zzfdn zzd;

    public zzdly(Context context, Set<zzdlw<zzaya>> set, zzfdn zzfdn) {
        super(set);
        this.zzc = context;
        this.zzd = zzfdn;
    }

    public final synchronized void zza(View view) {
        zzayb zzayb = this.zzb.get(view);
        if (zzayb == null) {
            zzayb = new zzayb(this.zzc, view);
            zzayb.zzc(this);
            this.zzb.put(view, zzayb);
        }
        if (this.zzd.zzU) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaZ)).booleanValue()) {
                zzayb.zzg(((Long) zzbgq.zzc().zzb(zzblj.zzaY)).longValue());
                return;
            }
        }
        zzayb.zzf();
    }

    public final synchronized void zzb(View view) {
        if (this.zzb.containsKey(view)) {
            this.zzb.get(view).zze(this);
            this.zzb.remove(view);
        }
    }

    public final synchronized void zzc(zzaxz zzaxz) {
        zzo(new zzdlx(zzaxz));
    }
}
