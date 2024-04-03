package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

final class zzcrs extends zzewf {
    private final zzexm zza;
    private final zzcui zzb;
    private final zzcrs zzc = this;
    private final zzgqe<Integer> zzd;
    private final zzgqe<zzewc> zze;
    private final zzgqe<String> zzf;
    private final zzgqe<zzewl> zzg;
    private final zzgqe<zzewr> zzh;
    private final zzgqe<zzewv> zzi;
    private final zzgqe<zzexc> zzj;
    private final zzgqe<zzexj> zzk;
    private final zzgqe<zzeya> zzl;
    private final zzgqe<Boolean> zzm;
    private final zzgqe<zzexw> zzn;
    private final zzgqe<String> zzo;
    private final zzgqe<zzdyh> zzp;
    private final zzgqe<zzdyh> zzq;
    private final zzgqe<zzdyh> zzr;
    private final zzgqe<zzdyh> zzs;
    private final zzgqe<Map<zzfhy, zzdyh>> zzt;
    private final zzgqe<Set<zzdlw<zzfif>>> zzu;
    private final zzgqe<Set<zzdlw<zzfif>>> zzv;
    private final zzgqe zzw;
    private final zzgqe<zzfie> zzx;

    public /* synthetic */ zzcrs(zzcui zzcui, zzexm zzexm, zzcrr zzcrr) {
        zzexm zzexm2 = zzexm;
        this.zzb = zzcui;
        this.zza = zzexm2;
        zzexo zzexo = new zzexo(zzexm2);
        this.zzd = zzexo;
        this.zze = new zzewe(zzcvj.zza, zzcui.zzh, zzcui.zzn, zzfgz.zza(), zzexo);
        zzexn zzexn = new zzexn(zzexm2);
        this.zzf = zzexn;
        this.zzg = new zzewn(zzcrd.zza, zzcui.zzh, zzexn, zzfgz.zza());
        this.zzh = new zzewt(zzcvj.zza, zzexo, zzcui.zzh, zzcui.zzaa, zzcui.zzn, zzfgz.zza(), zzexn);
        this.zzi = new zzewx(zzcvd.zza, zzfgz.zza(), zzcui.zzh);
        this.zzj = new zzexe(zzcvf.zza, zzfgz.zza(), zzexn);
        this.zzk = new zzexl(zzcvh.zza, zzcui.zzn, zzcui.zzh);
        this.zzl = new zzeyc(zzfgz.zza());
        zzexp zzexp = new zzexp(zzexm2);
        this.zzm = zzexp;
        zzexn zzexn2 = zzexn;
        this.zzn = new zzexy(zzcui.zzaa, zzexp, zzcvl.zza, zzfgz.zza(), zzexn2, zzcui.zzn);
        zzexq zzexq = new zzexq(zzexm2);
        this.zzo = zzexq;
        zzgqe<zzdyh> zzc2 = zzgpq.zzc(zzdya.zza());
        this.zzp = zzc2;
        zzgqe<zzdyh> zzc3 = zzgpq.zzc(zzdxy.zza());
        this.zzq = zzc3;
        zzgqe<zzdyh> zzc4 = zzgpq.zzc(zzdyc.zza());
        this.zzr = zzc4;
        zzgqe<zzdyh> zzc5 = zzgpq.zzc(zzdye.zza());
        this.zzs = zzc5;
        zzgpu zzc6 = zzgpv.zzc(4);
        zzc6.zzb(zzfhy.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfhy.BUILD_URL, zzc3);
        zzc6.zzb(zzfhy.HTTP, zzc4);
        zzc6.zzb(zzfhy.PRE_PROCESS, zzc5);
        zzgpv zzc7 = zzc6.zzc();
        this.zzt = zzc7;
        zzgqe<Set<zzdlw<zzfif>>> zzc8 = zzgpq.zzc(new zzdyf(zzexq, zzcui.zzh, zzfgz.zza(), zzc7));
        this.zzu = zzc8;
        zzgqb zza2 = zzgqc.zza(0, 1);
        zza2.zza(zzc8);
        zzgqc zzc9 = zza2.zzc();
        this.zzv = zzc9;
        zzfih zzfih = new zzfih(zzc9);
        this.zzw = zzfih;
        this.zzx = zzgpq.zzc(new zzfig(zzfgz.zza(), zzcui.zzn, zzfih));
    }

    private final zzewi zzd() {
        zzcic zzcic = new zzcic();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        String zzd2 = this.zza.zzd();
        zzgpz.zzb(zzd2);
        return new zzewi(zzcic, zzfxb, zzd2, this.zza.zzb(), this.zza.zza(), (byte[]) null);
    }

    private final zzexg zze() {
        zzbku zzbku = new zzbku();
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        List<String> zzf2 = this.zza.zzf();
        zzgpz.zzb(zzf2);
        return new zzexg(zzbku, zzfxb, zzf2, (List<String>) null);
    }

    public final zzevq<JSONObject> zza() {
        zzchz zzchz = new zzchz();
        zzcia zzcia = new zzcia();
        Object zzb2 = this.zzb.zzay.zzb();
        zzewi zzd2 = zzd();
        zzexg zze2 = zze();
        zzgpl<zzewc> zza2 = zzgpq.zza(this.zze);
        zzgpl<zzewl> zza3 = zzgpq.zza(this.zzg);
        zzgpl<zzewr> zza4 = zzgpq.zza(this.zzh);
        zzgpl<zzewv> zza5 = zzgpq.zza(this.zzi);
        zzgpl<zzexc> zza6 = zzgpq.zza(this.zzj);
        zzgpl<zzexj> zza7 = zzgpq.zza(this.zzk);
        zzgpl<zzeya> zza8 = zzgpq.zza(this.zzl);
        zzgpl<zzexw> zza9 = zzgpq.zza(this.zzn);
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        return zzext.zza(zzchz, zzcia, zzb2, zzd2, zze2, zza2, zza3, zza4, zza5, zza6, zza7, zza8, zza9, zzfxb, (ScheduledExecutorService) this.zzb.zzn.zzb());
    }

    public final zzevq<JSONObject> zzb() {
        zzfxb zzfxb = zzcjm.zza;
        zzgpz.zzb(zzfxb);
        zzchz zzchz = new zzchz();
        zzgpz.zzb(zzfxb);
        String zzc2 = this.zza.zzc();
        zzgpz.zzb(zzc2);
        zzetx zzetx = new zzetx(new zzexc(zzchz, zzfxb, zzc2, (byte[]) null), 0, (ScheduledExecutorService) this.zzb.zzn.zzb());
        Context zza2 = this.zzb.zza.zza();
        zzgpz.zzb(zza2);
        zzetx zzetx2 = new zzetx(new zzexj(new zzcbw(), (ScheduledExecutorService) this.zzb.zzn.zzb(), zza2, (byte[]) null), ((Long) zzbgq.zzc().zzb(zzblj.zzcF)).longValue(), (ScheduledExecutorService) this.zzb.zzn.zzb());
        zzcic zzcic = new zzcic();
        Context zza3 = this.zzb.zza.zza();
        zzgpz.zzb(zza3);
        zzgpz.zzb(zzfxb);
        zzetx zzetx3 = new zzetx(new zzewc(zzcic, zza3, (ScheduledExecutorService) this.zzb.zzn.zzb(), zzfxb, this.zza.zza(), (byte[]) null), 0, (ScheduledExecutorService) this.zzb.zzn.zzb());
        zzgpz.zzb(zzfxb);
        zzetx zzetx4 = new zzetx(new zzeya(zzfxb), 0, (ScheduledExecutorService) this.zzb.zzn.zzb());
        zzexs zzexs = zzexs.zza;
        Context zza4 = this.zzb.zza.zza();
        zzgpz.zzb(zza4);
        String zzc3 = this.zza.zzc();
        zzgpz.zzb(zzc3);
        zzgpz.zzb(zzfxb);
        zzewl zzewl = new zzewl((zzcds) null, zza4, zzc3, zzfxb);
        zzban zzban = new zzban();
        zzgpz.zzb(zzfxb);
        Context zza5 = this.zzb.zza.zza();
        zzgpz.zzb(zza5);
        zzcic zzcic2 = new zzcic();
        int zza6 = this.zza.zza();
        Context zza7 = this.zzb.zza.zza();
        zzgpz.zzb(zza7);
        zzgpz.zzb(zzfxb);
        String zzc4 = this.zza.zzc();
        zzgpz.zzb(zzc4);
        zzetx zzetx5 = zzetx3;
        Object[] objArr = {new zzewv(zzban, zzfxb, zza5, (byte[]) null), zze(), zzd(), new zzewr(zzcic2, zza6, zza7, (zzcik) this.zzb.zzaa.zzb(), (ScheduledExecutorService) this.zzb.zzn.zzb(), zzfxb, zzc4, (byte[]) null), (zzevn) this.zzb.zzay.zzb()};
        return new zzevq<>(zzfxb, zzftc.zzm(zzetx, zzetx2, zzetx5, zzetx4, zzexs, zzewl, objArr));
    }

    public final zzfie zzc() {
        return this.zzx.zzb();
    }
}
