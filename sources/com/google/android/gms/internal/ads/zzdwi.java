package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzb;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzdwi {
    private final zzdep zza;
    private final zzdmb zzb;
    /* access modifiers changed from: private */
    public final zzdfy zzc;
    private final zzdgl zzd;
    private final zzdgx zze;
    private final zzdjo zzf;
    private final Executor zzg;
    private final zzdly zzh;
    private final zzcxf zzi;
    private final zzb zzj;
    private final zzcgf zzk;
    private final zzalt zzl;
    /* access modifiers changed from: private */
    public final zzdjf zzm;
    private final zzehh zzn;
    private final zzfjs zzo;
    private final zzdyz zzp;
    private final zzfio zzq;

    public zzdwi(zzdep zzdep, zzdfy zzdfy, zzdgl zzdgl, zzdgx zzdgx, zzdjo zzdjo, Executor executor, zzdly zzdly, zzcxf zzcxf, zzb zzb2, @Nullable zzcgf zzcgf, zzalt zzalt, zzdjf zzdjf, zzehh zzehh, zzfjs zzfjs, zzdyz zzdyz, zzfio zzfio, zzdmb zzdmb) {
        this.zza = zzdep;
        this.zzc = zzdfy;
        this.zzd = zzdgl;
        this.zze = zzdgx;
        this.zzf = zzdjo;
        this.zzg = executor;
        this.zzh = zzdly;
        this.zzi = zzcxf;
        this.zzj = zzb2;
        this.zzk = zzcgf;
        this.zzl = zzalt;
        this.zzm = zzdjf;
        this.zzn = zzehh;
        this.zzo = zzfjs;
        this.zzp = zzdyz;
        this.zzq = zzfio;
        this.zzb = zzdmb;
    }

    public static final zzfxa<?> zzj(zzcop zzcop, String str, String str2) {
        zzcjr zzcjr = new zzcjr();
        zzcop.zzP().zzz(new zzdwg(zzcjr));
        zzcop.zzad(str, str2, (String) null);
        return zzcjr;
    }

    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzbL(str, str2);
    }

    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    public final /* synthetic */ void zzg(zzcop zzcop, zzcop zzcop2, Map map) {
        this.zzi.zzh(zzcop);
    }

    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        this.zzj.zza();
        return false;
    }

    public final void zzi(zzcop zzcop, boolean z11, zzbrw zzbrw) {
        zzalp zzc2;
        zzcop zzcop2 = zzcop;
        zzcqc zzP = zzcop.zzP();
        zzdwc zzdwc = r4;
        zzdwc zzdwc2 = new zzdwc(this);
        zzdgl zzdgl = this.zzd;
        zzdgx zzdgx = this.zze;
        zzdwd zzdwd = r7;
        zzdwd zzdwd2 = new zzdwd(this);
        zzdwf zzdwf = r10;
        zzdwf zzdwf2 = new zzdwf(this);
        zzb zzb2 = this.zzj;
        zzdwh zzdwh = r12;
        zzdwh zzdwh2 = new zzdwh(this);
        zzP.zzL(zzdwc, zzdgl, zzdgx, zzdwd, zzdwf, z11, zzbrw, zzb2, zzdwh, this.zzk, this.zzn, this.zzo, this.zzp, this.zzq, (zzbru) null, this.zzb);
        zzcop zzcop3 = zzcop;
        zzcop3.setOnTouchListener(new zzdwa(this));
        zzcop3.setOnClickListener(new zzdvz(this));
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbQ)).booleanValue() && (zzc2 = this.zzl.zzc()) != null) {
            zzc2.zzn((View) zzcop3);
        }
        this.zzh.zzj(zzcop3, this.zzg);
        this.zzh.zzj(new zzdwb(zzcop3), this.zzg);
        this.zzh.zza((View) zzcop3);
        zzcop3.zzaf("/trackActiveViewUnit", new zzdwe(this, zzcop3));
        this.zzi.zzi(zzcop3);
    }
}
