package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzgc implements zzkg {
    private final zzga zzsd;

    private zzgc(zzga zzga) {
        zzga zzga2 = (zzga) zzgt.zza(zzga, "output");
        this.zzsd = zzga2;
        zzga2.zzss = this;
    }

    public static zzgc zza(zzga zzga) {
        zzgc zzgc = zzga.zzss;
        if (zzgc != null) {
            return zzgc;
        }
        return new zzgc(zzga);
    }

    public final void zzb(int i11, long j11) throws IOException {
        this.zzsd.zzb(i11, j11);
    }

    public final void zzbj(int i11) throws IOException {
        this.zzsd.zzg(i11, 3);
    }

    public final void zzbk(int i11) throws IOException {
        this.zzsd.zzg(i11, 4);
    }

    public final void zzc(int i11, long j11) throws IOException {
        this.zzsd.zzc(i11, j11);
    }

    public final void zzd(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzw(list.get(i14).longValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzs(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zza(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zze(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzy(list.get(i14).longValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzu(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzc(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzf(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzt(list.get(i14).floatValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzs(list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zza(i11, list.get(i12).floatValue());
            i12++;
        }
    }

    public final int zzfj() {
        return zzgs.zzf.zzww;
    }

    public final void zzg(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzb(list.get(i14).doubleValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zza(list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zza(i11, list.get(i12).doubleValue());
            i12++;
        }
    }

    public final void zzh(int i11, int i12) throws IOException {
        this.zzsd.zzh(i11, i12);
    }

    public final void zzi(int i11, long j11) throws IOException {
        this.zzsd.zza(i11, j11);
    }

    public final void zzj(int i11, long j11) throws IOException {
        this.zzsd.zzc(i11, j11);
    }

    public final void zzk(int i11, int i12) throws IOException {
        this.zzsd.zzk(i11, i12);
    }

    public final void zzl(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzz(list.get(i14).longValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzu(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzc(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzm(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzbd(list.get(i14).intValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzay(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzj(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzn(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzx(list.get(i14).longValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzt(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzb(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzr(int i11, int i12) throws IOException {
        this.zzsd.zzk(i11, i12);
    }

    public final void zzs(int i11, int i12) throws IOException {
        this.zzsd.zzh(i11, i12);
    }

    public final void zzb(int i11, Object obj, zzir zzir) throws IOException {
        zzga zzga = this.zzsd;
        zzga.zzg(i11, 3);
        zzir.zza((zzic) obj, zzga.zzss);
        zzga.zzg(i11, 4);
    }

    public final void zzc(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzv(list.get(i14).longValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzs(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zza(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzh(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzbg(list.get(i14).intValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzaw(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzh(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzk(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzbf(list.get(i14).intValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzaz(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzk(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zza(int i11, float f11) throws IOException {
        this.zzsd.zza(i11, f11);
    }

    public final void zzi(int i11, int i12) throws IOException {
        this.zzsd.zzi(i11, i12);
    }

    public final void zzj(int i11, int i12) throws IOException {
        this.zzsd.zzj(i11, i12);
    }

    public final void zza(int i11, double d11) throws IOException {
        this.zzsd.zza(i11, d11);
    }

    public final void zzi(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzl(list.get(i14).booleanValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzk(list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zza(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public final void zzj(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzbc(list.get(i14).intValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzax(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzi(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zza(int i11, long j11) throws IOException {
        this.zzsd.zza(i11, j11);
    }

    public final void zza(int i11, boolean z11) throws IOException {
        this.zzsd.zza(i11, z11);
    }

    public final void zzb(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzbe(list.get(i14).intValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzaz(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzk(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zza(int i11, String str) throws IOException {
        this.zzsd.zza(i11, str);
    }

    public final void zza(int i11, zzfh zzfh) throws IOException {
        this.zzsd.zza(i11, zzfh);
    }

    public final void zza(int i11, Object obj, zzir zzir) throws IOException {
        this.zzsd.zza(i11, (zzic) obj, zzir);
    }

    public final void zza(int i11, Object obj) throws IOException {
        if (obj instanceof zzfh) {
            this.zzsd.zzb(i11, (zzfh) obj);
        } else {
            this.zzsd.zza(i11, (zzic) obj);
        }
    }

    public final void zza(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzsd.zzg(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzga.zzbb(list.get(i14).intValue());
            }
            this.zzsd.zzax(i13);
            while (i12 < list.size()) {
                this.zzsd.zzaw(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zzh(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzb(int i11, List<zzfh> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zzsd.zza(i11, list.get(i12));
        }
    }

    public final void zzb(int i11, List<?> list, zzir zzir) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzb(i11, (Object) list.get(i12), zzir);
        }
    }

    public final void zza(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof zzhj) {
            zzhj zzhj = (zzhj) list;
            while (i12 < list.size()) {
                Object raw = zzhj.getRaw(i12);
                if (raw instanceof String) {
                    this.zzsd.zza(i11, (String) raw);
                } else {
                    this.zzsd.zza(i11, (zzfh) raw);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzsd.zza(i11, list.get(i12));
            i12++;
        }
    }

    public final void zza(int i11, List<?> list, zzir zzir) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zza(i11, (Object) list.get(i12), zzir);
        }
    }

    public final <K, V> void zza(int i11, zzht<K, V> zzht, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzsd.zzg(i11, 2);
            this.zzsd.zzax(zzhu.zza(zzht, next.getKey(), next.getValue()));
            zzhu.zza(this.zzsd, zzht, next.getKey(), next.getValue());
        }
    }
}
