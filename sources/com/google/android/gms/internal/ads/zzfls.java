package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzfls implements zzfkx {
    private static final zzfls zza = new zzfls();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public static Handler zzc = null;
    /* access modifiers changed from: private */
    public static final Runnable zzd = new zzflo();
    /* access modifiers changed from: private */
    public static final Runnable zze = new zzflp();
    private final List<zzflr> zzf = new ArrayList();
    private int zzg;
    private final zzfkz zzh = new zzfkz();
    private final zzfll zzi = new zzfll();
    /* access modifiers changed from: private */
    public final zzflm zzj = new zzflm(new zzflv());
    private long zzk;

    public static zzfls zzd() {
        return zza;
    }

    public static /* bridge */ /* synthetic */ void zzg(zzfls zzfls) {
        zzfls.zzg = 0;
        zzfls.zzk = System.nanoTime();
        zzfls.zzi.zzi();
        long nanoTime = System.nanoTime();
        zzfky zza2 = zzfls.zzh.zza();
        if (zzfls.zzi.zze().size() > 0) {
            Iterator<String> it = zzfls.zzi.zze().iterator();
            while (it.hasNext()) {
                String next = it.next();
                JSONObject zza3 = zzflg.zza(0, 0, 0, 0);
                View zza4 = zzfls.zzi.zza(next);
                zzfky zzb2 = zzfls.zzh.zzb();
                String zzc2 = zzfls.zzi.zzc(next);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzflg.zzb(zza5, next);
                    zzflg.zze(zza5, zzc2);
                    zzflg.zzc(zza3, zza5);
                }
                zzflg.zzh(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(next);
                zzfls.zzj.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfls.zzi.zzf().size() > 0) {
            JSONObject zza6 = zzflg.zza(0, 0, 0, 0);
            zzfls.zzk((View) null, zza2, zza6, 1);
            zzflg.zzh(zza6);
            zzfls.zzj.zzd(zza6, zzfls.zzi.zzf(), nanoTime);
        } else {
            zzfls.zzj.zzb();
        }
        zzfls.zzi.zzg();
        long nanoTime2 = System.nanoTime() - zzfls.zzk;
        if (zzfls.zzf.size() > 0) {
            for (zzflr next2 : zzfls.zzf) {
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                next2.zzb();
                if (next2 instanceof zzflq) {
                    ((zzflq) next2).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfky zzfky, JSONObject jSONObject, int i11) {
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        zzfky.zzb(view, jSONObject, this, z11);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    public final void zza(View view, zzfky zzfky, JSONObject jSONObject) {
        int zzj2;
        if (zzflj.zzb(view) == null && (zzj2 = this.zzi.zzj(view)) != 3) {
            JSONObject zza2 = zzfky.zza(view);
            zzflg.zzc(jSONObject, zza2);
            String zzd2 = this.zzi.zzd(view);
            if (zzd2 != null) {
                zzflg.zzb(zza2, zzd2);
                this.zzi.zzh();
            } else {
                zzflk zzb2 = this.zzi.zzb(view);
                if (zzb2 != null) {
                    zzflg.zzd(zza2, zzb2);
                }
                zzk(view, zzfky, zza2, zzj2);
            }
            this.zzg++;
        }
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfln(this));
    }
}
