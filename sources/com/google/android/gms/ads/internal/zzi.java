package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzalm;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zzals;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzfmh;
import com.google.android.gms.internal.ads.zzfnj;
import com.google.android.gms.internal.ads.zzfod;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public final class zzi implements Runnable, zzalp {
    @VisibleForTesting
    protected boolean zza;
    final CountDownLatch zzb = new CountDownLatch(1);
    private final List<Object[]> zzc = new Vector();
    private final AtomicReference<zzalp> zzd = new AtomicReference<>();
    private final AtomicReference<zzalp> zze = new AtomicReference<>();
    private final boolean zzf;
    private final boolean zzg;
    private final Executor zzh;
    /* access modifiers changed from: private */
    public final zzfmh zzi;
    private Context zzj;
    private final Context zzk;
    private zzcjf zzl;
    private final zzcjf zzm;
    private final boolean zzn;
    private int zzo;

    public zzi(Context context, zzcjf zzcjf) {
        this.zzj = context;
        this.zzk = context;
        this.zzl = zzcjf;
        this.zzm = zzcjf;
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        this.zzh = newCachedThreadPool;
        boolean booleanValue = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbE)).booleanValue();
        this.zzn = booleanValue;
        this.zzi = zzfmh.zza(context, newCachedThreadPool, booleanValue);
        this.zzf = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbA)).booleanValue();
        this.zzg = ((Boolean) zzbgq.zzc().zzb(zzblj.zzbF)).booleanValue();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbD)).booleanValue()) {
            this.zzo = 2;
        } else {
            this.zzo = 1;
        }
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzce)).booleanValue()) {
            this.zza = zzc();
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbZ)).booleanValue()) {
            zzcjm.zza.execute(this);
            return;
        }
        zzbgo.zzb();
        if (zzcis.zzp()) {
            zzcjm.zza.execute(this);
        } else {
            run();
        }
    }

    @Nullable
    private final zzalp zzj() {
        if (zzi() == 2) {
            return this.zze.get();
        }
        return this.zzd.get();
    }

    private final void zzm() {
        zzalp zzj2 = zzj();
        if (!this.zzc.isEmpty() && zzj2 != null) {
            for (Object[] next : this.zzc) {
                int length = next.length;
                if (length == 1) {
                    zzj2.zzk((MotionEvent) next[0]);
                } else if (length == 3) {
                    zzj2.zzl(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzc.clear();
        }
    }

    private final void zzo(boolean z11) {
        this.zzd.set(zzals.zzt(this.zzl.zza, zzp(this.zzj), z11, this.zzo));
    }

    private static final Context zzp(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final void run() {
        boolean z11;
        long currentTimeMillis;
        try {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzce)).booleanValue()) {
                this.zza = zzc();
            }
            boolean z12 = this.zzl.zzd;
            z11 = false;
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzaK)).booleanValue() && z12) {
                z11 = true;
            }
            if (zzi() == 1) {
                zzo(z11);
                if (this.zzo == 2) {
                    this.zzh.execute(new zzg(this, z11));
                }
            } else {
                currentTimeMillis = System.currentTimeMillis();
                zzalm zza2 = zzalm.zza(this.zzl.zza, zzp(this.zzj), z11, this.zzn);
                this.zze.set(zza2);
                if (this.zzg && !zza2.zzq()) {
                    this.zzo = 1;
                    zzo(z11);
                }
            }
        } catch (NullPointerException e11) {
            this.zzo = 1;
            zzo(z11);
            this.zzi.zzc(2031, System.currentTimeMillis() - currentTimeMillis, e11);
        } catch (Throwable th2) {
            this.zzb.countDown();
            this.zzj = null;
            this.zzl = null;
            throw th2;
        }
        this.zzb.countDown();
        this.zzj = null;
        this.zzl = null;
    }

    public final /* synthetic */ void zzb(boolean z11) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzalm.zza(this.zzm.zza, zzp(this.zzk), z11, this.zzn).zzo();
        } catch (NullPointerException e11) {
            this.zzi.zzc(2027, System.currentTimeMillis() - currentTimeMillis, e11);
        }
    }

    public final boolean zzc() {
        Context context = this.zzj;
        zzfmh zzfmh = this.zzi;
        zzh zzh2 = new zzh(this);
        return new zzfod(this.zzj, zzfnj.zzb(context, zzfmh), zzh2, ((Boolean) zzbgq.zzc().zzb(zzblj.zzbB)).booleanValue()).zzd(1);
    }

    public final boolean zzd() {
        try {
            this.zzb.await();
            return true;
        } catch (InterruptedException e11) {
            zzciz.zzk("Interrupted during GADSignals creation.", e11);
            return false;
        }
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        if (!zzd()) {
            return "";
        }
        zzalp zzj2 = zzj();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhg)).booleanValue()) {
            zzt.zzp();
            zzt.zzN(view, 4, (MotionEvent) null);
        }
        if (zzj2 == null) {
            return "";
        }
        zzm();
        return zzj2.zzf(zzp(context), str, view, activity);
    }

    public final String zzg(Context context) {
        zzalp zzj2;
        if (!zzd() || (zzj2 = zzj()) == null) {
            return "";
        }
        zzm();
        return zzj2.zzg(zzp(context));
    }

    public final String zzh(Context context, View view, Activity activity) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzhf)).booleanValue()) {
            zzalp zzj2 = zzj();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhg)).booleanValue()) {
                zzt.zzp();
                zzt.zzN(view, 2, (MotionEvent) null);
            }
            if (zzj2 != null) {
                return zzj2.zzh(context, view, (Activity) null);
            }
            return "";
        } else if (!zzd()) {
            return "";
        } else {
            zzalp zzj3 = zzj();
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhg)).booleanValue()) {
                zzt.zzp();
                zzt.zzN(view, 2, (MotionEvent) null);
            }
            if (zzj3 != null) {
                return zzj3.zzh(context, view, (Activity) null);
            }
            return "";
        }
    }

    public final int zzi() {
        if (!this.zzf || this.zza) {
            return this.zzo;
        }
        return 1;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzalp zzj2 = zzj();
        if (zzj2 != null) {
            zzm();
            zzj2.zzk(motionEvent);
            return;
        }
        this.zzc.add(new Object[]{motionEvent});
    }

    public final void zzl(int i11, int i12, int i13) {
        zzalp zzj2 = zzj();
        if (zzj2 != null) {
            zzm();
            zzj2.zzl(i11, i12, i13);
            return;
        }
        this.zzc.add(new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)});
    }

    public final void zzn(View view) {
        zzalp zzj2 = zzj();
        if (zzj2 != null) {
            zzj2.zzn(view);
        }
    }
}
