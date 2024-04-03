package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdkc {
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdgj>> zza = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdhm>> zzb = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzbes>> zzc = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdmd>> zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzder>> zze = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdfl>> zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdgq>> zzg = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdgf>> zzh = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdeu>> zzi = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzfmb>> zzj = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzaop>> zzk = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdfh>> zzl = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzdhc>> zzm = new HashSet();
    /* access modifiers changed from: private */
    public final Set<zzdlw<zzo>> zzn = new HashSet();
    /* access modifiers changed from: private */
    public zzfaz zzo;

    public final zzdkc zza(zzbes zzbes, Executor executor) {
        this.zzc.add(new zzdlw(zzbes, executor));
        return this;
    }

    public final zzdkc zzb(zzdeu zzdeu, Executor executor) {
        this.zzi.add(new zzdlw(zzdeu, executor));
        return this;
    }

    public final zzdkc zzc(zzdfh zzdfh, Executor executor) {
        this.zzl.add(new zzdlw(zzdfh, executor));
        return this;
    }

    public final zzdkc zzd(zzdfl zzdfl, Executor executor) {
        this.zzf.add(new zzdlw(zzdfl, executor));
        return this;
    }

    public final zzdkc zze(zzder zzder, Executor executor) {
        this.zze.add(new zzdlw(zzder, executor));
        return this;
    }

    public final zzdkc zzf(zzdgf zzdgf, Executor executor) {
        this.zzh.add(new zzdlw(zzdgf, executor));
        return this;
    }

    public final zzdkc zzg(zzdgq zzdgq, Executor executor) {
        this.zzg.add(new zzdlw(zzdgq, executor));
        return this;
    }

    public final zzdkc zzh(zzo zzo2, Executor executor) {
        this.zzn.add(new zzdlw(zzo2, executor));
        return this;
    }

    public final zzdkc zzi(zzdhc zzdhc, Executor executor) {
        this.zzm.add(new zzdlw(zzdhc, executor));
        return this;
    }

    public final zzdkc zzj(zzdhm zzdhm, Executor executor) {
        this.zzb.add(new zzdlw(zzdhm, executor));
        return this;
    }

    public final zzdkc zzk(zzaop zzaop, Executor executor) {
        this.zzk.add(new zzdlw(zzaop, executor));
        return this;
    }

    public final zzdkc zzl(zzdmd zzdmd, Executor executor) {
        this.zzd.add(new zzdlw(zzdmd, executor));
        return this;
    }

    public final zzdkc zzm(zzfaz zzfaz) {
        this.zzo = zzfaz;
        return this;
    }

    public final zzdke zzn() {
        return new zzdke(this, (zzdkd) null);
    }
}
