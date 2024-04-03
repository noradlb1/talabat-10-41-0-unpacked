package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

abstract class zzfvm<I, O, F, T> extends zzfwg<O> implements Runnable {
    public static final /* synthetic */ int zzc = 0;
    @CheckForNull
    zzfxa<? extends I> zza;
    @CheckForNull
    F zzb;

    public zzfvm(zzfxa<? extends I> zzfxa, F f11) {
        zzfxa.getClass();
        this.zza = zzfxa;
        f11.getClass();
        this.zzb = f11;
    }

    public final void run() {
        boolean z11;
        zzfxa<? extends I> zzfxa = this.zza;
        F f11 = this.zzb;
        boolean isCancelled = isCancelled();
        boolean z12 = true;
        if (zzfxa == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z13 = isCancelled | z11;
        if (f11 != null) {
            z12 = false;
        }
        if (!z13 && !z12) {
            this.zza = null;
            if (zzfxa.isCancelled()) {
                zzu(zzfxa);
                return;
            }
            try {
                try {
                    Object zza2 = zza(f11, zzfwq.zzp(zzfxa));
                    this.zzb = null;
                    zzb(zza2);
                } catch (Throwable th2) {
                    this.zzb = null;
                    throw th2;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e11) {
                zzt(e11.getCause());
            } catch (RuntimeException e12) {
                zzt(e12);
            } catch (Error e13) {
                zzt(e13);
            }
        }
    }

    public abstract T zza(F f11, I i11) throws Exception;

    public abstract void zzb(T t11);

    @CheckForNull
    public final String zzd() {
        String str;
        zzfxa<? extends I> zzfxa = this.zza;
        F f11 = this.zzb;
        String zzd = super.zzd();
        if (zzfxa != null) {
            String obj = zzfxa.toString();
            StringBuilder sb2 = new StringBuilder(obj.length() + 16);
            sb2.append("inputFuture=[");
            sb2.append(obj);
            sb2.append("], ");
            str = sb2.toString();
        } else {
            str = "";
        }
        if (f11 != null) {
            String obj2 = f11.toString();
            StringBuilder sb3 = new StringBuilder(str.length() + 11 + obj2.length());
            sb3.append(str);
            sb3.append("function=[");
            sb3.append(obj2);
            sb3.append("]");
            return sb3.toString();
        } else if (zzd == null) {
            return null;
        } else {
            if (zzd.length() != 0) {
                return str.concat(zzd);
            }
            return new String(str);
        }
    }

    public final void zze() {
        zzq(this.zza);
        this.zza = null;
        this.zzb = null;
    }
}
