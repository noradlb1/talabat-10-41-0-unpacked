package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzql implements zzum {
    private final zzqj zzawd;

    private zzql(zzqj zzqj) {
        zzqj zzqj2 = (zzqj) zzre.zza(zzqj, "output");
        this.zzawd = zzqj2;
        zzqj2.zzawu = this;
    }

    public static zzql zza(zzqj zzqj) {
        zzql zzql = zzqj.zzawu;
        if (zzql != null) {
            return zzql;
        }
        return new zzql(zzqj);
    }

    public final void zzb(int i11, boolean z11) throws IOException {
        this.zzawd.zzb(i11, z11);
    }

    public final void zzbk(int i11) throws IOException {
        this.zzawd.zzd(i11, 3);
    }

    public final void zzbl(int i11) throws IOException {
        this.zzawd.zzd(i11, 4);
    }

    public final void zzc(int i11, long j11) throws IOException {
        this.zzawd.zzc(i11, j11);
    }

    public final void zzd(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzt(list.get(i14).longValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzp(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zza(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zze(int i11, int i12) throws IOException {
        this.zzawd.zze(i11, i12);
    }

    public final void zzf(int i11, int i12) throws IOException {
        this.zzawd.zzf(i11, i12);
    }

    public final void zzg(int i11, int i12) throws IOException {
        this.zzawd.zzg(i11, i12);
    }

    public final void zzh(int i11, int i12) throws IOException {
        this.zzawd.zzh(i11, i12);
    }

    public final void zzi(int i11, long j11) throws IOException {
        this.zzawd.zza(i11, j11);
    }

    public final void zzj(int i11, long j11) throws IOException {
        this.zzawd.zzc(i11, j11);
    }

    public final void zzk(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzbg(list.get(i14).intValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzba(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzh(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzl(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzw(list.get(i14).longValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzr(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzc(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzm(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzbe(list.get(i14).intValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzaz(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzg(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzn(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzu(list.get(i14).longValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzq(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzb(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzo(int i11, int i12) throws IOException {
        this.zzawd.zzh(i11, i12);
    }

    public final int zzol() {
        return zzrc.zze.zzbbc;
    }

    public final void zzp(int i11, int i12) throws IOException {
        this.zzawd.zze(i11, i12);
    }

    public final void zzb(int i11, long j11) throws IOException {
        this.zzawd.zzb(i11, j11);
    }

    public final void zzc(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzs(list.get(i14).longValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzp(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zza(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zze(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzv(list.get(i14).longValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzr(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzc(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzf(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzb(list.get(i14).floatValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zza(list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zza(i11, list.get(i12).floatValue());
            i12++;
        }
    }

    public final void zzg(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzc(list.get(i14).doubleValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzb(list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zza(i11, list.get(i12).doubleValue());
            i12++;
        }
    }

    public final void zzh(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzbh(list.get(i14).intValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzax(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zze(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zza(int i11, float f11) throws IOException {
        this.zzawd.zza(i11, f11);
    }

    public final void zzb(int i11, Object obj, zzsz zzsz) throws IOException {
        zzqj zzqj = this.zzawd;
        zzqj.zzd(i11, 3);
        zzsz.zza((zzsk) obj, zzqj.zzawu);
        zzqj.zzd(i11, 4);
    }

    public final void zzi(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzj(list.get(i14).booleanValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzi(list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzb(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public final void zzj(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzbd(list.get(i14).intValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzay(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzf(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zza(int i11, double d11) throws IOException {
        this.zzawd.zza(i11, d11);
    }

    public final void zza(int i11, long j11) throws IOException {
        this.zzawd.zza(i11, j11);
    }

    public final void zza(int i11, String str) throws IOException {
        this.zzawd.zza(i11, str);
    }

    public final void zza(int i11, zzps zzps) throws IOException {
        this.zzawd.zza(i11, zzps);
    }

    public final void zzb(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzbf(list.get(i14).intValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzba(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zzh(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zza(int i11, Object obj, zzsz zzsz) throws IOException {
        this.zzawd.zza(i11, (zzsk) obj, zzsz);
    }

    public final void zza(int i11, Object obj) throws IOException {
        if (obj instanceof zzps) {
            this.zzawd.zzb(i11, (zzps) obj);
        } else {
            this.zzawd.zzb(i11, (zzsk) obj);
        }
    }

    public final void zza(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzawd.zzd(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzqj.zzbc(list.get(i14).intValue());
            }
            this.zzawd.zzay(i13);
            while (i12 < list.size()) {
                this.zzawd.zzax(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zze(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzb(int i11, List<zzps> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zzawd.zza(i11, list.get(i12));
        }
    }

    public final void zzb(int i11, List<?> list, zzsz zzsz) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzb(i11, (Object) list.get(i12), zzsz);
        }
    }

    public final void zza(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof zzrt) {
            zzrt zzrt = (zzrt) list;
            while (i12 < list.size()) {
                Object zzbn = zzrt.zzbn(i12);
                if (zzbn instanceof String) {
                    this.zzawd.zza(i11, (String) zzbn);
                } else {
                    this.zzawd.zza(i11, (zzps) zzbn);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzawd.zza(i11, list.get(i12));
            i12++;
        }
    }

    public final void zza(int i11, List<?> list, zzsz zzsz) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zza(i11, (Object) list.get(i12), zzsz);
        }
    }

    public final <K, V> void zza(int i11, zzsd<K, V> zzsd, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzawd.zzd(i11, 2);
            this.zzawd.zzay(zzsc.zza(zzsd, next.getKey(), next.getValue()));
            zzsc.zza(this.zzawd, zzsd, next.getKey(), next.getValue());
        }
    }
}
