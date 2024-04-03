package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzlb implements zzbt, zzlt, zzvp, zzqj, zztd, zznf {
    private final zzdz zza;
    private final zzca zzb;
    private final zzcc zzc = new zzcc();
    private final zzla zzd;
    private final SparseArray<zzlc> zze;
    private zzeo<zzld> zzf;
    private zzbw zzg;
    private zzei zzh;
    private boolean zzi;

    public zzlb(zzdz zzdz) {
        this.zza = zzdz;
        this.zzf = new zzeo<>(zzfn.zzA(), zzdz, zzkw.zza);
        zzca zzca = new zzca();
        this.zzb = zzca;
        this.zzd = new zzla(zzca);
        this.zze = new SparseArray<>();
    }

    public static /* synthetic */ void zzO(zzlb zzlb) {
        zzlc zzM = zzlb.zzM();
        zzlb.zzV(zzM, 1036, new zzky(zzM));
        zzlb.zzf.zze();
    }

    private final zzlc zzY(@Nullable zzpz zzpz) {
        zzcd zzcd;
        this.zzg.getClass();
        if (zzpz == null) {
            zzcd = null;
        } else {
            zzcd = this.zzd.zza(zzpz);
        }
        if (zzpz != null && zzcd != null) {
            return zzN(zzcd, zzcd.zzn(zzpz.zza, this.zzb).zzd, zzpz);
        }
        int zzg2 = ((zzi) this.zzg).zzg();
        zzcd zzm = this.zzg.zzm();
        if (zzg2 >= zzm.zzc()) {
            zzm = zzcd.zza;
        }
        return zzN(zzm, zzg2, (zzpz) null);
    }

    private final zzlc zzZ(int i11, @Nullable zzpz zzpz) {
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        if (zzpz == null) {
            zzcd zzm = zzbw.zzm();
            if (i11 >= zzm.zzc()) {
                zzm = zzcd.zza;
            }
            return zzN(zzm, i11, (zzpz) null);
        } else if (this.zzd.zza(zzpz) != null) {
            return zzY(zzpz);
        } else {
            return zzN(zzcd.zza, i11, zzpz);
        }
    }

    private final zzlc zzaa() {
        return zzY(this.zzd.zzd());
    }

    private final zzlc zzab() {
        return zzY(this.zzd.zze());
    }

    public final void zzA(long j11) {
        zzlc zzab = zzab();
        zzV(zzab, 1011, new zzjm(zzab, j11));
    }

    public final void zzB(Exception exc) {
        zzlc zzab = zzab();
        zzV(zzab, 1018, new zzki(zzab, exc));
    }

    public final void zzC(int i11, long j11, long j12) {
        zzlc zzab = zzab();
        zzV(zzab, 1012, new zzjj(zzab, i11, j11, j12));
    }

    public final void zzD(int i11, long j11) {
        zzlc zzaa = zzaa();
        zzV(zzaa, 1023, new zzji(zzaa, i11, j11));
    }

    public final void zzE(Object obj, long j11) {
        zzlc zzab = zzab();
        zzV(zzab, 1027, new zzkk(zzab, obj, j11));
    }

    public final void zzF(Exception exc) {
        zzlc zzab = zzab();
        zzV(zzab, 1038, new zzkj(zzab, exc));
    }

    public final void zzG(String str, long j11, long j12) {
        zzlc zzab = zzab();
        zzV(zzab, 1021, new zzko(zzab, str, j12, j11));
    }

    public final void zzH(String str) {
        zzlc zzab = zzab();
        zzV(zzab, 1024, new zzkm(zzab, str));
    }

    public final void zzI(zzfy zzfy) {
        zzlc zzaa = zzaa();
        zzV(zzaa, 1025, new zzka(zzaa, zzfy));
    }

    public final void zzJ(zzfy zzfy) {
        zzlc zzab = zzab();
        zzV(zzab, 1020, new zzkb(zzab, zzfy));
    }

    public final void zzK(long j11, int i11) {
        zzlc zzaa = zzaa();
        zzV(zzaa, 1026, new zzjn(zzaa, j11, i11));
    }

    public final void zzL(zzab zzab, @Nullable zzfz zzfz) {
        zzlc zzab2 = zzab();
        zzV(zzab2, 1022, new zzjp(zzab2, zzab, zzfz));
    }

    public final zzlc zzM() {
        return zzY(this.zzd.zzb());
    }

    @RequiresNonNull({"player"})
    public final zzlc zzN(zzcd zzcd, int i11, @Nullable zzpz zzpz) {
        zzpz zzpz2;
        zzcd zzcd2 = zzcd;
        int i12 = i11;
        boolean z11 = true;
        if (true == zzcd.zzo()) {
            zzpz2 = null;
        } else {
            zzpz2 = zzpz;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!zzcd2.equals(this.zzg.zzm()) || i12 != ((zzi) this.zzg).zzg()) {
            z11 = false;
        }
        long j11 = 0;
        if (zzpz2 == null || !zzpz2.zzb()) {
            if (z11) {
                j11 = this.zzg.zzj();
            } else if (!zzcd.zzo()) {
                long j12 = zzcd2.zze(i12, this.zzc, 0).zzm;
                j11 = zzk.zzd(0);
            }
        } else if (z11 && this.zzg.zze() == zzpz2.zzb && this.zzg.zzf() == zzpz2.zzc) {
            j11 = this.zzg.zzk();
        }
        return new zzlc(elapsedRealtime, zzcd, i11, zzpz2, j11, this.zzg.zzm(), ((zzi) this.zzg).zzg(), this.zzd.zzb(), this.zzg.zzk(), this.zzg.zzl());
    }

    @CallSuper
    public final void zzP(zzld zzld) {
        this.zzf.zzb(zzld);
    }

    public final /* synthetic */ void zzQ(zzbw zzbw, zzld zzld, zzw zzw) {
        SparseArray<zzlc> sparseArray = this.zze;
        SparseArray sparseArray2 = new SparseArray(zzw.zzb());
        for (int i11 = 0; i11 < zzw.zzb(); i11++) {
            int zza2 = zzw.zza(i11);
            zzlc zzlc = sparseArray.get(zza2);
            zzlc.getClass();
            sparseArray2.append(zza2, zzlc);
        }
    }

    public final void zzR() {
        if (!this.zzi) {
            zzlc zzM = zzM();
            this.zzi = true;
            zzV(zzM, -1, new zzjd(zzM));
        }
    }

    public final void zzS(int i11, long j11, long j12) {
        zzlc zzY = zzY(this.zzd.zzc());
        zzV(zzY, 1006, new zzjk(zzY, i11, j11, j12));
    }

    @CallSuper
    public final void zzT() {
        zzei zzei = this.zzh;
        zzdy.zzb(zzei);
        zzei.zzg(new zzkx(this));
    }

    @CallSuper
    public final void zzU(zzld zzld) {
        this.zzf.zzf(zzld);
    }

    public final void zzV(zzlc zzlc, int i11, zzel<zzld> zzel) {
        this.zze.put(i11, zzlc);
        zzeo<zzld> zzeo = this.zzf;
        zzeo.zzd(i11, zzel);
        zzeo.zzc();
    }

    @CallSuper
    public final void zzW(zzbw zzbw, Looper looper) {
        boolean z11 = true;
        if (this.zzg != null && !this.zzd.zzb.isEmpty()) {
            z11 = false;
        }
        zzdy.zzf(z11);
        this.zzg = zzbw;
        this.zzh = this.zza.zza(looper, (Handler.Callback) null);
        this.zzf = this.zzf.zza(looper, new zzkv(this, zzbw));
    }

    public final void zzX(List<zzpz> list, @Nullable zzpz zzpz) {
        zzla zzla = this.zzd;
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        zzla.zzh(list, zzpz, zzbw);
    }

    public final void zza(zzbr zzbr) {
        zzlc zzM = zzM();
        zzV(zzM, 13, new zzju(zzM, zzbr));
    }

    public final void zzb(boolean z11) {
        zzlc zzM = zzM();
        zzV(zzM, 3, new zzkp(zzM, z11));
    }

    public final void zzbe(int i11, @Nullable zzpz zzpz, zzpw zzpw) {
        zzlc zzZ = zzZ(i11, zzpz);
        zzV(zzZ, 1004, new zzkg(zzZ, zzpw));
    }

    public final void zzbf(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw) {
        zzlc zzZ = zzZ(i11, zzpz);
        zzV(zzZ, 1002, new zzkc(zzZ, zzpr, zzpw));
    }

    public final void zzbg(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw) {
        zzlc zzZ = zzZ(i11, zzpz);
        zzV(zzZ, 1001, new zzkd(zzZ, zzpr, zzpw));
    }

    public final void zzbh(@Nullable zzaz zzaz, int i11) {
        zzlc zzM = zzM();
        zzV(zzM, 1, new zzjq(zzM, zzaz, i11));
    }

    public final void zzbi(zzbe zzbe) {
        zzlc zzM = zzM();
        zzV(zzM, 14, new zzjr(zzM, zzbe));
    }

    public final /* synthetic */ void zzbj() {
    }

    public final void zzbk(int i11, int i12) {
        zzlc zzab = zzab();
        zzV(zzab, 1029, new zzjh(zzab, i11, i12));
    }

    public final void zzbl(float f11) {
        zzlc zzab = zzab();
        zzV(zzab, 1019, new zzkz(zzab, f11));
    }

    public final void zzc(boolean z11) {
        zzlc zzM = zzM();
        zzV(zzM, 7, new zzkq(zzM, z11));
    }

    public final void zzd(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw, IOException iOException, boolean z11) {
        zzlc zzZ = zzZ(i11, zzpz);
        zzV(zzZ, 1003, new zzkf(zzZ, zzpr, zzpw, iOException, z11));
    }

    public final void zze(int i11, @Nullable zzpz zzpz, zzpr zzpr, zzpw zzpw) {
        zzlc zzZ = zzZ(i11, zzpz);
        zzV(zzZ, 1000, new zzke(zzZ, zzpr, zzpw));
    }

    public final void zzf(boolean z11, int i11) {
        zzlc zzM = zzM();
        zzV(zzM, 5, new zzkt(zzM, z11, i11));
    }

    public final void zzg(zzbn zzbn) {
        zzlc zzM = zzM();
        zzV(zzM, 12, new zzjt(zzM, zzbn));
    }

    public final void zzh(int i11) {
        zzlc zzM = zzM();
        zzV(zzM, 4, new zzje(zzM, i11));
    }

    public final void zzi(int i11) {
        zzlc zzM = zzM();
        zzV(zzM, 6, new zzjf(zzM, i11));
    }

    public final void zzj(zzbl zzbl) {
        zzbf zzbf;
        zzlc zzlc = null;
        if ((zzbl instanceof zzgg) && (zzbf = ((zzgg) zzbl).zzj) != null) {
            zzlc = zzY(new zzpz(zzbf));
        }
        if (zzlc == null) {
            zzlc = zzM();
        }
        zzV(zzlc, 10, new zzjs(zzlc, zzbl));
    }

    public final void zzk(boolean z11, int i11) {
        zzlc zzM = zzM();
        zzV(zzM, -1, new zzku(zzM, z11, i11));
    }

    public final void zzl(zzbv zzbv, zzbv zzbv2, int i11) {
        if (i11 == 1) {
            this.zzi = false;
            i11 = 1;
        }
        zzla zzla = this.zzd;
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        zzla.zzg(zzbw);
        zzlc zzM = zzM();
        zzV(zzM, 11, new zzjl(zzM, i11, zzbv, zzbv2));
    }

    public final void zzm() {
        zzlc zzM = zzM();
        zzV(zzM, -1, new zzks(zzM));
    }

    public final void zzn(zzcd zzcd, int i11) {
        zzla zzla = this.zzd;
        zzbw zzbw = this.zzg;
        zzbw.getClass();
        zzla.zzi(zzbw);
        zzlc zzM = zzM();
        zzV(zzM, 0, new zzjg(zzM, i11));
    }

    public final void zzo(zzch zzch, zzci zzci) {
        zzlc zzM = zzM();
        zzV(zzM, 2, new zzjv(zzM, zzch, zzci));
    }

    public final void zzp(zzcr zzcr) {
        zzlc zzM = zzM();
        zzV(zzM, 2, new zzjw(zzM, zzcr));
    }

    public final /* synthetic */ void zzq(zzo zzo) {
    }

    public final /* synthetic */ void zzr(int i11, boolean z11) {
    }

    public final void zzs(Exception exc) {
        zzlc zzab = zzab();
        zzV(zzab, 1037, new zzkh(zzab, exc));
    }

    public final void zzt(boolean z11) {
        zzlc zzab = zzab();
        zzV(zzab, 1017, new zzkr(zzab, z11));
    }

    public final void zzu(String str, long j11, long j12) {
        zzlc zzab = zzab();
        zzV(zzab, 1009, new zzkn(zzab, str, j12, j11));
    }

    public final void zzv(zzct zzct) {
        zzlc zzab = zzab();
        zzV(zzab, 1028, new zzjx(zzab, zzct));
    }

    public final void zzw(String str) {
        zzlc zzab = zzab();
        zzV(zzab, 1013, new zzkl(zzab, str));
    }

    public final void zzx(zzfy zzfy) {
        zzlc zzaa = zzaa();
        zzV(zzaa, 1014, new zzjy(zzaa, zzfy));
    }

    public final void zzy(zzfy zzfy) {
        zzlc zzab = zzab();
        zzV(zzab, 1008, new zzjz(zzab, zzfy));
    }

    public final void zzz(zzab zzab, @Nullable zzfz zzfz) {
        zzlc zzab2 = zzab();
        zzV(zzab2, 1010, new zzjo(zzab2, zzab, zzfz));
    }
}
