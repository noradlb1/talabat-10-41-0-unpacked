package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

abstract class zzfwz<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable zza = new zzfwy((zzfwx) null);
    private static final Runnable zzb = new zzfwy((zzfwx) null);

    private final void zzc(Thread thread) {
        Runnable runnable = (Runnable) get();
        zzfww zzfww = null;
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (!(runnable instanceof zzfww)) {
                if (runnable != zzb) {
                    break;
                }
            } else {
                zzfww = (zzfww) runnable;
            }
            i11++;
            if (i11 > 1000) {
                Runnable runnable2 = zzb;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    if (Thread.interrupted() || z11) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    LockSupport.park(zzfww);
                }
            } else {
                Thread.yield();
            }
            runnable = (Runnable) get();
        }
        if (z11) {
            thread.interrupt();
        }
    }

    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet((Object) null, currentThread)) {
            boolean z11 = !zzg();
            if (z11) {
                try {
                    obj = zza();
                } catch (Throwable th2) {
                    if (!compareAndSet(currentThread, zza)) {
                        zzc(currentThread);
                    }
                    zzd(th2);
                    return;
                }
            }
            if (!compareAndSet(currentThread, zza)) {
                zzc(currentThread);
            }
            if (z11) {
                zze(obj);
            }
        }
    }

    public final String toString() {
        String str;
        Runnable runnable = (Runnable) get();
        if (runnable == zza) {
            str = "running=[DONE]";
        } else if (runnable instanceof zzfww) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name2 = ((Thread) runnable).getName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name2).length() + 21);
            sb2.append("running=[RUNNING ON ");
            sb2.append(name2);
            sb2.append("]");
            str = sb2.toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String zzb2 = zzb();
        StringBuilder sb3 = new StringBuilder(str.length() + 2 + String.valueOf(zzb2).length());
        sb3.append(str);
        sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb3.append(zzb2);
        return sb3.toString();
    }

    public abstract T zza() throws Exception;

    public abstract String zzb();

    public abstract void zzd(Throwable th2);

    public abstract void zze(T t11);

    public abstract boolean zzg();

    public final void zzh() {
        Runnable runnable = (Runnable) get();
        if (runnable instanceof Thread) {
            zzfww zzfww = new zzfww(this, (zzfwv) null);
            zzfwz.super.setExclusiveOwnerThread(Thread.currentThread());
            if (compareAndSet(runnable, zzfww)) {
                try {
                    Thread thread = (Thread) runnable;
                    thread.interrupt();
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark(thread);
                    }
                } catch (Throwable th2) {
                    if (((Runnable) getAndSet(zza)) == zzb) {
                        LockSupport.unpark((Thread) runnable);
                    }
                    throw th2;
                }
            }
        }
    }
}
