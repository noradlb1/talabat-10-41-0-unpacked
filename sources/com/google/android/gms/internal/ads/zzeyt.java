package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.internal.ads.zzcye;
import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzddz;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzeyt<AppOpenAd extends zzdav, AppOpenRequestComponent extends zzcye<AppOpenAd>, AppOpenRequestComponentBuilder extends zzddz<AppOpenRequestComponent>> implements zzepn<AppOpenAd> {
    protected final zzcqm zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public final zzezj zzd;
    /* access modifiers changed from: private */
    public final zzfbc<AppOpenRequestComponent, AppOpenAd> zze;
    private final ViewGroup zzf;
    /* access modifiers changed from: private */
    public final zzfjg zzg;
    @GuardedBy("this")
    private final zzfed zzh;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzfxa<AppOpenAd> zzi;

    public zzeyt(Context context, Executor executor, zzcqm zzcqm, zzfbc<AppOpenRequestComponent, AppOpenAd> zzfbc, zzezj zzezj, zzfed zzfed) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcqm;
        this.zze = zzfbc;
        this.zzd = zzezj;
        this.zzh = zzfed;
        this.zzf = new FrameLayout(context);
        this.zzg = zzcqm.zzA();
    }

    /* access modifiers changed from: private */
    public final synchronized AppOpenRequestComponentBuilder zzm(zzfba zzfba) {
        zzeys zzeys = (zzeys) zzfba;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfW)).booleanValue()) {
            zzcyt zzcyt = new zzcyt(this.zzf);
            zzdeb zzdeb = new zzdeb();
            zzdeb.zzc(this.zzb);
            zzdeb.zzf(zzeys.zza);
            zzded zzg2 = zzdeb.zzg();
            zzdkc zzdkc = new zzdkc();
            zzdkc.zzc(this.zzd, this.zzc);
            zzdkc.zzl(this.zzd, this.zzc);
            return zzc(zzcyt, zzg2, zzdkc.zzn());
        }
        zzezj zzi2 = zzezj.zzi(this.zzd);
        zzdkc zzdkc2 = new zzdkc();
        zzdkc2.zzb(zzi2, this.zzc);
        zzdkc2.zzg(zzi2, this.zzc);
        zzdkc2.zzh(zzi2, this.zzc);
        zzdkc2.zzi(zzi2, this.zzc);
        zzdkc2.zzc(zzi2, this.zzc);
        zzdkc2.zzl(zzi2, this.zzc);
        zzdkc2.zzm(zzi2);
        zzcyt zzcyt2 = new zzcyt(this.zzf);
        zzdeb zzdeb2 = new zzdeb();
        zzdeb2.zzc(this.zzb);
        zzdeb2.zzf(zzeys.zza);
        return zzc(zzcyt2, zzdeb2.zzg(), zzdkc2.zzn());
    }

    public final boolean zza() {
        zzfxa<AppOpenAd> zzfxa = this.zzi;
        return zzfxa != null && !zzfxa.isDone();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.internal.ads.zzbfd r5, java.lang.String r6, com.google.android.gms.internal.ads.zzepl r7, com.google.android.gms.internal.ads.zzepm<? super AppOpenAd> r8) throws android.os.RemoteException {
        /*
            r4 = this;
            monitor-enter(r4)
            android.content.Context r7 = r4.zzb     // Catch:{ all -> 0x00a3 }
            r0 = 7
            com.google.android.gms.internal.ads.zzfje r7 = com.google.android.gms.internal.ads.zzfje.zzp(r7, r0, r0, r5)     // Catch:{ all -> 0x00a3 }
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch:{ all -> 0x00a3 }
            r0 = 0
            if (r6 != 0) goto L_0x002f
            java.lang.String r5 = "Ad unit ID should not be null for app open ad."
            com.google.android.gms.internal.ads.zzciz.zzg(r5)     // Catch:{ all -> 0x00a3 }
            java.util.concurrent.Executor r5 = r4.zzc     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzeyo r6 = new com.google.android.gms.internal.ads.zzeyo     // Catch:{ all -> 0x00a3 }
            r6.<init>(r4)     // Catch:{ all -> 0x00a3 }
            r5.execute(r6)     // Catch:{ all -> 0x00a3 }
            if (r7 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzfjg r5 = r4.zzg     // Catch:{ all -> 0x00a3 }
            r7.zzg(r0)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfjf r6 = r7.zzi()     // Catch:{ all -> 0x00a3 }
            r5.zza(r6)     // Catch:{ all -> 0x00a3 }
        L_0x002d:
            monitor-exit(r4)
            return r0
        L_0x002f:
            com.google.android.gms.internal.ads.zzfxa<AppOpenAd> r1 = r4.zzi     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0043
            if (r7 == 0) goto L_0x0041
            com.google.android.gms.internal.ads.zzfjg r5 = r4.zzg     // Catch:{ all -> 0x00a3 }
            r7.zzg(r0)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfjf r6 = r7.zzi()     // Catch:{ all -> 0x00a3 }
            r5.zza(r6)     // Catch:{ all -> 0x00a3 }
        L_0x0041:
            monitor-exit(r4)
            return r0
        L_0x0043:
            android.content.Context r0 = r4.zzb     // Catch:{ all -> 0x00a3 }
            boolean r1 = r5.zzf     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfeu.zza(r0, r1)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzgA     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x00a3 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00a3 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a3 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a3 }
            r1 = 1
            if (r0 == 0) goto L_0x006a
            boolean r0 = r5.zzf     // Catch:{ all -> 0x00a3 }
            if (r0 == 0) goto L_0x006a
            com.google.android.gms.internal.ads.zzcqm r0 = r4.zza     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzebt r0 = r0.zzn()     // Catch:{ all -> 0x00a3 }
            r0.zzl(r1)     // Catch:{ all -> 0x00a3 }
        L_0x006a:
            com.google.android.gms.internal.ads.zzfed r0 = r4.zzh     // Catch:{ all -> 0x00a3 }
            r0.zzs(r6)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzbfi r6 = com.google.android.gms.internal.ads.zzbfi.zzb()     // Catch:{ all -> 0x00a3 }
            r0.zzr(r6)     // Catch:{ all -> 0x00a3 }
            r0.zzD(r5)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfef r5 = r0.zzF()     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzeys r6 = new com.google.android.gms.internal.ads.zzeys     // Catch:{ all -> 0x00a3 }
            r0 = 0
            r6.<init>(r0)     // Catch:{ all -> 0x00a3 }
            r6.zza = r5     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfbc<AppOpenRequestComponent, AppOpenAd> r5 = r4.zze     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfbd r2 = new com.google.android.gms.internal.ads.zzfbd     // Catch:{ all -> 0x00a3 }
            r2.<init>(r6, r0)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzeyn r3 = new com.google.android.gms.internal.ads.zzeyn     // Catch:{ all -> 0x00a3 }
            r3.<init>(r4)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfxa r5 = r5.zzc(r2, r3, r0)     // Catch:{ all -> 0x00a3 }
            r4.zzi = r5     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzeyq r0 = new com.google.android.gms.internal.ads.zzeyq     // Catch:{ all -> 0x00a3 }
            r0.<init>(r4, r8, r7, r6)     // Catch:{ all -> 0x00a3 }
            java.util.concurrent.Executor r6 = r4.zzc     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.ads.zzfwq.zzr(r5, r0, r6)     // Catch:{ all -> 0x00a3 }
            monitor-exit(r4)
            return r1
        L_0x00a3:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeyt.zzb(com.google.android.gms.internal.ads.zzbfd, java.lang.String, com.google.android.gms.internal.ads.zzepl, com.google.android.gms.internal.ads.zzepm):boolean");
    }

    public abstract AppOpenRequestComponentBuilder zzc(zzcyt zzcyt, zzded zzded, zzdke zzdke);

    public final /* synthetic */ void zzk() {
        this.zzd.zza(zzfey.zzd(6, (String) null, (zzbew) null));
    }

    public final void zzl(zzbfo zzbfo) {
        this.zzh.zzt(zzbfo);
    }
}
