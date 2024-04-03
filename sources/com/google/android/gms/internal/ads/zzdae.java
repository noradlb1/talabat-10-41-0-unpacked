package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.WorkerThread;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdae extends zzcyw {
    private final zzbpz zzc;
    private final Runnable zzd;
    private final Executor zze;

    public zzdae(zzdau zzdau, zzbpz zzbpz, Runnable runnable, Executor executor) {
        super(zzdau);
        this.zzc = zzbpz;
        this.zzd = runnable;
        this.zze = executor;
    }

    public static /* synthetic */ void zzi(AtomicReference atomicReference) {
        Runnable runnable = (Runnable) atomicReference.getAndSet((Object) null);
        if (runnable != null) {
            runnable.run();
        }
    }

    @WorkerThread
    public final void zzU() {
        this.zze.execute(new zzdac(this, new zzdad(new AtomicReference(this.zzd))));
    }

    public final int zza() {
        return 0;
    }

    public final View zzc() {
        return null;
    }

    public final zzbiz zzd() {
        return null;
    }

    public final zzfdo zze() {
        return null;
    }

    public final zzfdo zzf() {
        return null;
    }

    public final void zzg() {
    }

    public final void zzh(ViewGroup viewGroup, zzbfi zzbfi) {
    }

    public final /* synthetic */ void zzk(Runnable runnable) {
        try {
            if (!this.zzc.zzb(ObjectWrapper.wrap(runnable))) {
                zzi(((zzdad) runnable).zza);
            }
        } catch (RemoteException unused) {
            zzi(((zzdad) runnable).zza);
        }
    }
}
