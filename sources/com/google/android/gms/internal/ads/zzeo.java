package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;
import androidx.annotation.CheckResult;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class zzeo<T> {
    private final zzdz zza;
    private final zzei zzb;
    private final zzem<T> zzc;
    private final CopyOnWriteArraySet<zzen<T>> zzd;
    private final ArrayDeque<Runnable> zze;
    private final ArrayDeque<Runnable> zzf;
    private boolean zzg;

    public zzeo(Looper looper, zzdz zzdz, zzem<T> zzem) {
        this(new CopyOnWriteArraySet(), looper, zzdz, zzem);
    }

    public static /* synthetic */ boolean zzg(zzeo zzeo, Message message) {
        Iterator<zzen<T>> it = zzeo.zzd.iterator();
        while (it.hasNext()) {
            it.next().zzb(zzeo.zzc);
            if (zzeo.zzb.zzf(0)) {
                return true;
            }
        }
        return true;
    }

    @CheckResult
    public final zzeo<T> zza(Looper looper, zzem<T> zzem) {
        return new zzeo<>(this.zzd, looper, this.zza, zzem);
    }

    public final void zzb(T t11) {
        if (!this.zzg) {
            t11.getClass();
            this.zzd.add(new zzen(t11));
        }
    }

    public final void zzc() {
        if (!this.zzf.isEmpty()) {
            if (!this.zzb.zzf(0)) {
                zzei zzei = this.zzb;
                zzei.zzj(zzei.zza(0));
            }
            boolean isEmpty = this.zze.isEmpty();
            this.zze.addAll(this.zzf);
            this.zzf.clear();
            if (!(!isEmpty)) {
                while (!this.zze.isEmpty()) {
                    this.zze.peekFirst().run();
                    this.zze.removeFirst();
                }
            }
        }
    }

    public final void zzd(int i11, zzel<T> zzel) {
        this.zzf.add(new zzek(new CopyOnWriteArraySet(this.zzd), i11, zzel));
    }

    public final void zze() {
        Iterator<zzen<T>> it = this.zzd.iterator();
        while (it.hasNext()) {
            it.next().zzc(this.zzc);
        }
        this.zzd.clear();
        this.zzg = true;
    }

    public final void zzf(T t11) {
        Iterator<zzen<T>> it = this.zzd.iterator();
        while (it.hasNext()) {
            zzen next = it.next();
            if (next.zza.equals(t11)) {
                next.zzc(this.zzc);
                this.zzd.remove(next);
            }
        }
    }

    private zzeo(CopyOnWriteArraySet<zzen<T>> copyOnWriteArraySet, Looper looper, zzdz zzdz, zzem<T> zzem) {
        this.zza = zzdz;
        this.zzd = copyOnWriteArraySet;
        this.zzc = zzem;
        this.zze = new ArrayDeque<>();
        this.zzf = new ArrayDeque<>();
        this.zzb = zzdz.zza(looper, new zzej(this));
    }
}
