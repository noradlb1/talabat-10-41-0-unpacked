package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.HashMap;

public abstract class zzpk<T> extends zzpc {
    private final HashMap<T, zzpj<T>> zza = new HashMap<>();
    @Nullable
    private Handler zzb;
    @Nullable
    private zzdx zzc;

    @CallSuper
    public final void zzi() {
        for (zzpj next : this.zza.values()) {
            next.zza.zzh(next.zzb);
        }
    }

    @CallSuper
    public final void zzk() {
        for (zzpj next : this.zza.values()) {
            next.zza.zzj(next.zzb);
        }
    }

    @CallSuper
    public void zzm(@Nullable zzdx zzdx) {
        this.zzc = zzdx;
        this.zzb = zzfn.zzz((Handler.Callback) null);
    }

    @CallSuper
    public void zzp() {
        for (zzpj next : this.zza.values()) {
            next.zza.zzo(next.zzb);
            next.zza.zzr(next.zzc);
            next.zza.zzq(next.zzc);
        }
        this.zza.clear();
    }

    @Nullable
    public zzpz zzu(T t11, zzpz zzpz) {
        throw null;
    }

    @CallSuper
    public void zzv() throws IOException {
        for (zzpj<T> zzpj : this.zza.values()) {
            zzpj.zza.zzv();
        }
    }

    public abstract void zzw(T t11, zzqb zzqb, zzcd zzcd);

    public final void zzx(T t11, zzqb zzqb) {
        zzdy.zzd(!this.zza.containsKey(t11));
        zzph zzph = new zzph(this, t11);
        zzpi zzpi = new zzpi(this, t11);
        this.zza.put(t11, new zzpj(zzqb, zzph, zzpi));
        Handler handler = this.zzb;
        handler.getClass();
        zzqb.zzg(handler, zzpi);
        Handler handler2 = this.zzb;
        handler2.getClass();
        zzqb.zzf(handler2, zzpi);
        zzqb.zzl(zzph, this.zzc);
        if (!zzs()) {
            zzqb.zzh(zzph);
        }
    }
}
