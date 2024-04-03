package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

final class zzla {
    private final zzca zza;
    /* access modifiers changed from: private */
    public zzfss<zzpz> zzb = zzfss.zzo();
    private zzfsw<zzpz, zzcd> zzc = zzfsw.zzd();
    @Nullable
    private zzpz zzd;
    private zzpz zze;
    private zzpz zzf;

    public zzla(zzca zzca) {
        this.zza = zzca;
    }

    @Nullable
    private static zzpz zzj(zzbw zzbw, zzfss<zzpz> zzfss, @Nullable zzpz zzpz, zzca zzca) {
        Object obj;
        int i11;
        zzcd zzm = zzbw.zzm();
        int zzh = zzbw.zzh();
        if (zzm.zzo()) {
            obj = null;
        } else {
            obj = zzm.zzf(zzh);
        }
        if (zzbw.zzp() || zzm.zzo()) {
            i11 = -1;
        } else {
            i11 = zzm.zzd(zzh, zzca, false).zzb(zzk.zzc(zzbw.zzk()));
        }
        for (int i12 = 0; i12 < zzfss.size(); i12++) {
            zzpz zzpz2 = zzfss.get(i12);
            if (zzm(zzpz2, obj, zzbw.zzp(), zzbw.zze(), zzbw.zzf(), i11)) {
                return zzpz2;
            }
        }
        if (zzfss.isEmpty() && zzpz != null) {
            if (zzm(zzpz, obj, zzbw.zzp(), zzbw.zze(), zzbw.zzf(), i11)) {
                return zzpz;
            }
        }
        return null;
    }

    private final void zzk(zzfsv<zzpz, zzcd> zzfsv, @Nullable zzpz zzpz, zzcd zzcd) {
        if (zzpz != null) {
            if (zzcd.zza(zzpz.zza) != -1) {
                zzfsv.zza(zzpz, zzcd);
                return;
            }
            zzcd zzcd2 = this.zzc.get(zzpz);
            if (zzcd2 != null) {
                zzfsv.zza(zzpz, zzcd2);
            }
        }
    }

    private final void zzl(zzcd zzcd) {
        zzfsv zzfsv = new zzfsv();
        if (this.zzb.isEmpty()) {
            zzk(zzfsv, this.zze, zzcd);
            if (!zzfqc.zza(this.zzf, this.zze)) {
                zzk(zzfsv, this.zzf, zzcd);
            }
            if (!zzfqc.zza(this.zzd, this.zze) && !zzfqc.zza(this.zzd, this.zzf)) {
                zzk(zzfsv, this.zzd, zzcd);
            }
        } else {
            for (int i11 = 0; i11 < this.zzb.size(); i11++) {
                zzk(zzfsv, this.zzb.get(i11), zzcd);
            }
            if (!this.zzb.contains(this.zzd)) {
                zzk(zzfsv, this.zzd, zzcd);
            }
        }
        this.zzc = zzfsv.zzc();
    }

    private static boolean zzm(zzpz zzpz, @Nullable Object obj, boolean z11, int i11, int i12, int i13) {
        if (!zzpz.zza.equals(obj)) {
            return false;
        }
        if (z11) {
            if (!(zzpz.zzb == i11 && zzpz.zzc == i12)) {
                return false;
            }
        } else if (!(zzpz.zzb == -1 && zzpz.zze == i13)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final zzcd zza(zzpz zzpz) {
        return this.zzc.get(zzpz);
    }

    @Nullable
    public final zzpz zzb() {
        return this.zzd;
    }

    @Nullable
    public final zzpz zzc() {
        T t11;
        T next;
        if (this.zzb.isEmpty()) {
            return null;
        }
        zzfss<zzpz> zzfss = this.zzb;
        if (!(zzfss instanceof List)) {
            Iterator<T> it = zzfss.iterator();
            do {
                next = it.next();
            } while (it.hasNext());
            t11 = next;
        } else if (!zzfss.isEmpty()) {
            t11 = zzfss.get(zzfss.size() - 1);
        } else {
            throw new NoSuchElementException();
        }
        return (zzpz) t11;
    }

    @Nullable
    public final zzpz zzd() {
        return this.zze;
    }

    @Nullable
    public final zzpz zze() {
        return this.zzf;
    }

    public final void zzg(zzbw zzbw) {
        this.zzd = zzj(zzbw, this.zzb, this.zze, this.zza);
    }

    public final void zzh(List<zzpz> list, @Nullable zzpz zzpz, zzbw zzbw) {
        this.zzb = zzfss.zzm(list);
        if (!list.isEmpty()) {
            this.zze = list.get(0);
            zzpz.getClass();
            this.zzf = zzpz;
        }
        if (this.zzd == null) {
            this.zzd = zzj(zzbw, this.zzb, this.zze, this.zza);
        }
        zzl(zzbw.zzm());
    }

    public final void zzi(zzbw zzbw) {
        this.zzd = zzj(zzbw, this.zzb, this.zze, this.zza);
        zzl(zzbw.zzm());
    }
}
