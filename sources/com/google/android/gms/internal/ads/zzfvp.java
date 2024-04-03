package com.google.android.gms.internal.ads;

import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

abstract class zzfvp<InputT, OutputT> extends zzfvv<OutputT> {
    private static final Logger zza = Logger.getLogger(zzfvp.class.getName());
    @CheckForNull
    private zzfsn<? extends zzfxa<? extends InputT>> zzb;
    private final boolean zzc;
    private final boolean zzd;

    public zzfvp(zzfsn<? extends zzfxa<? extends InputT>> zzfsn, boolean z11, boolean z12) {
        super(zzfsn.size());
        this.zzb = zzfsn;
        this.zzc = z11;
        this.zzd = z12;
    }

    private final void zzI(int i11, Future<? extends InputT> future) {
        try {
            zzb(i11, zzfwq.zzp(future));
        } catch (ExecutionException e11) {
            zzK(e11.getCause());
        } catch (Throwable th2) {
            zzK(th2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzJ */
    public final void zzz(@CheckForNull zzfsn<? extends Future<? extends InputT>> zzfsn) {
        boolean z11;
        int zzC = zzC();
        int i11 = 0;
        if (zzC >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfqg.zzg(z11, "Less than 0 remaining futures");
        if (zzC == 0) {
            if (zzfsn != null) {
                zzfuu<? extends Future<? extends InputT>> zze = zzfsn.iterator();
                while (zze.hasNext()) {
                    Future future = (Future) zze.next();
                    if (!future.isCancelled()) {
                        zzI(i11, future);
                    }
                    i11++;
                }
            }
            zzH();
            zzw();
            zzA(2);
        }
    }

    private final void zzK(Throwable th2) {
        th2.getClass();
        if (this.zzc && !zzt(th2) && zzM(zzE(), th2)) {
            zzL(th2);
        } else if (th2 instanceof Error) {
            zzL(th2);
        }
    }

    private static void zzL(Throwable th2) {
        String str;
        if (true != (th2 instanceof Error)) {
            str = "Got more than one input Future failure. Logging failures after the first";
        } else {
            str = "Input Future failed with Error";
        }
        zza.logp(Level.SEVERE, "com.google.common.util.concurrent.AggregateFuture", LogWriteConstants.LOG_TYPE, str, th2);
    }

    private static boolean zzM(Set<Throwable> set, Throwable th2) {
        while (th2 != null) {
            if (!set.add(th2)) {
                return false;
            }
            th2 = th2.getCause();
        }
        return true;
    }

    public void zzA(int i11) {
        this.zzb = null;
    }

    public final void zza(Set<Throwable> set) {
        set.getClass();
        if (!isCancelled()) {
            Throwable zzk = zzk();
            zzk.getClass();
            zzM(set, zzk);
        }
    }

    public abstract void zzb(int i11, InputT inputt);

    @CheckForNull
    public final String zzd() {
        zzfsn<? extends zzfxa<? extends InputT>> zzfsn = this.zzb;
        if (zzfsn != null) {
            return "futures=".concat(zzfsn.toString());
        }
        return super.zzd();
    }

    public final void zze() {
        zzfsn<? extends zzfxa<? extends InputT>> zzfsn = this.zzb;
        boolean z11 = true;
        zzA(1);
        boolean isCancelled = isCancelled();
        if (zzfsn == null) {
            z11 = false;
        }
        if (z11 && isCancelled) {
            boolean zzv = zzv();
            zzfuu<? extends zzfxa<? extends InputT>> zze = zzfsn.iterator();
            while (zze.hasNext()) {
                ((Future) zze.next()).cancel(zzv);
            }
        }
    }

    public abstract void zzw();

    public final void zzx() {
        zzfsn<? extends zzfxa<? extends InputT>> zzfsn;
        zzfsn<? extends zzfxa<? extends InputT>> zzfsn2 = this.zzb;
        zzfsn2.getClass();
        if (zzfsn2.isEmpty()) {
            zzw();
        } else if (this.zzc) {
            zzfuu<? extends zzfxa<? extends InputT>> zze = this.zzb.iterator();
            int i11 = 0;
            while (zze.hasNext()) {
                zzfxa zzfxa = (zzfxa) zze.next();
                zzfxa.zzc(new zzfvo(this, zzfxa, i11), zzfwe.INSTANCE);
                i11++;
            }
        } else {
            if (this.zzd) {
                zzfsn = this.zzb;
            } else {
                zzfsn = null;
            }
            zzfvn zzfvn = new zzfvn(this, zzfsn);
            zzfuu<? extends zzfxa<? extends InputT>> zze2 = this.zzb.iterator();
            while (zze2.hasNext()) {
                ((zzfxa) zze2.next()).zzc(zzfvn, zzfwe.INSTANCE);
            }
        }
    }

    public final /* synthetic */ void zzy(zzfxa zzfxa, int i11) {
        try {
            if (zzfxa.isCancelled()) {
                this.zzb = null;
                cancel(false);
            } else {
                zzI(i11, zzfxa);
            }
        } finally {
            zzz((zzfsn) null);
        }
    }
}
