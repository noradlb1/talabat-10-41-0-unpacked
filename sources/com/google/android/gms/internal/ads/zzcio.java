package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public final class zzcio implements zzayt {
    @VisibleForTesting
    final zzcil zza;
    @VisibleForTesting
    final HashSet<zzcie> zzb = new HashSet<>();
    @VisibleForTesting
    final HashSet<zzcin> zzc = new HashSet<>();
    private final Object zzd = new Object();
    private final zzg zze;
    private final zzcim zzf;
    private boolean zzg = false;

    public zzcio(String str, zzg zzg2) {
        this.zza = new zzcil(str, zzg2);
        this.zze = zzg2;
        this.zzf = new zzcim();
    }

    public final void zza(boolean z11) {
        long currentTimeMillis = zzt.zzA().currentTimeMillis();
        if (z11) {
            if (currentTimeMillis - this.zze.zzc() > ((Long) zzbgq.zzc().zzb(zzblj.zzaH)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzb();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzr(currentTimeMillis);
        this.zze.zzF(this.zza.zzd);
    }

    public final zzcie zzb(Clock clock, String str) {
        return new zzcie(clock, this, this.zzf.zza(), str);
    }

    public final void zzc(zzcie zzcie) {
        synchronized (this.zzd) {
            this.zzb.add(zzcie);
        }
    }

    public final void zzd() {
        synchronized (this.zzd) {
            this.zza.zzb();
        }
    }

    public final void zze() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzh(zzbfd zzbfd, long j11) {
        synchronized (this.zzd) {
            this.zza.zzf(zzbfd, j11);
        }
    }

    public final void zzi(HashSet<zzcie> hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzj() {
        return this.zzg;
    }

    public final Bundle zzk(Context context, zzffd zzffd) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zza(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator<zzcin> it = this.zzc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzcie) it2.next()).zza());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzffd.zzc(hashSet);
            return bundle;
        }
        zzcin next = it.next();
        throw null;
    }
}
