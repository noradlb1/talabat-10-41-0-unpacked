package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzbc;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzam implements zzel {
    private final zzaj zzem;

    private zzam(zzaj zzaj) {
        zzaj zzaj2 = (zzaj) zzbd.zzb(zzaj, "output");
        this.zzem = zzaj2;
        zzaj2.zzes = this;
    }

    public static zzam zzb(zzaj zzaj) {
        zzam zzam = zzaj.zzes;
        if (zzam != null) {
            return zzam;
        }
        return new zzam(zzaj);
    }

    public final void zzaa(int i11) throws IOException {
        this.zzem.zzc(i11, 3);
    }

    public final void zzab(int i11) throws IOException {
        this.zzem.zzc(i11, 4);
    }

    public final int zzam() {
        return zzbc.zze.zziw;
    }

    public final void zzc(int i11, boolean z11) throws IOException {
        this.zzem.zzc(i11, z11);
    }

    public final void zzd(int i11, int i12) throws IOException {
        this.zzem.zzd(i11, i12);
    }

    public final void zze(int i11, int i12) throws IOException {
        this.zzem.zze(i11, i12);
    }

    public final void zzf(int i11, int i12) throws IOException {
        this.zzem.zzf(i11, i12);
    }

    public final void zzg(int i11, int i12) throws IOException {
        this.zzem.zzg(i11, i12);
    }

    public final void zzh(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzc(list.get(i14).doubleValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzb(list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzb(i11, list.get(i12).doubleValue());
            i12++;
        }
    }

    public final void zzi(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzx(list.get(i14).intValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzn(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzd(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzj(int i11, long j11) throws IOException {
        this.zzem.zzb(i11, j11);
    }

    public final void zzk(int i11, long j11) throws IOException {
        this.zzem.zzd(i11, j11);
    }

    public final void zzl(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzw(list.get(i14).intValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzq(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzg(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzm(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzj(list.get(i14).longValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zze(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzd(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzn(int i11, int i12) throws IOException {
        this.zzem.zzg(i11, i12);
    }

    public final void zzo(int i11, int i12) throws IOException {
        this.zzem.zzd(i11, i12);
    }

    public final void zzc(int i11, long j11) throws IOException {
        this.zzem.zzc(i11, j11);
    }

    public final void zzd(int i11, long j11) throws IOException {
        this.zzem.zzd(i11, j11);
    }

    public final void zze(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzg(list.get(i14).longValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzc(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzb(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzf(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzi(list.get(i14).longValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zze(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzd(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzg(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zze(list.get(i14).floatValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzd(list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzb(i11, list.get(i12).floatValue());
            i12++;
        }
    }

    public final void zzb(int i11, float f11) throws IOException {
        this.zzem.zzb(i11, f11);
    }

    public final void zzc(int i11, Object obj, zzda zzda) throws IOException {
        zzaj zzaj = this.zzem;
        zzaj.zzc(i11, 3);
        zzda.zzb((zzck) obj, zzaj.zzes);
        zzaj.zzc(i11, 4);
    }

    public final void zzd(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzf(list.get(i14).longValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzc(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzb(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzj(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzd(list.get(i14).booleanValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzc(list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzc(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public final void zzk(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzt(list.get(i14).intValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzo(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zze(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzn(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzu(list.get(i14).intValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzp(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzf(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzo(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzh(list.get(i14).longValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzd(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzc(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzb(int i11, double d11) throws IOException {
        this.zzem.zzb(i11, d11);
    }

    public final void zzb(int i11, long j11) throws IOException {
        this.zzem.zzb(i11, j11);
    }

    public final void zzb(int i11, String str) throws IOException {
        this.zzem.zzb(i11, str);
    }

    public final void zzb(int i11, zzw zzw) throws IOException {
        this.zzem.zzb(i11, zzw);
    }

    public final void zzc(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzv(list.get(i14).intValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzq(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzg(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzb(int i11, Object obj, zzda zzda) throws IOException {
        this.zzem.zzb(i11, (zzck) obj, zzda);
    }

    public final void zzb(int i11, Object obj) throws IOException {
        if (obj instanceof zzw) {
            this.zzem.zzc(i11, (zzw) obj);
        } else {
            this.zzem.zzb(i11, (zzck) obj);
        }
    }

    public final void zzb(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzem.zzc(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzaj.zzs(list.get(i14).intValue());
            }
            this.zzem.zzo(i13);
            while (i12 < list.size()) {
                this.zzem.zzn(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzd(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzc(int i11, List<zzw> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zzem.zzb(i11, list.get(i12));
        }
    }

    public final void zzc(int i11, List<?> list, zzda zzda) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzc(i11, (Object) list.get(i12), zzda);
        }
    }

    public final void zzb(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof zzbr) {
            zzbr zzbr = (zzbr) list;
            while (i12 < list.size()) {
                Object zzae = zzbr.zzae(i12);
                if (zzae instanceof String) {
                    this.zzem.zzb(i11, (String) zzae);
                } else {
                    this.zzem.zzb(i11, (zzw) zzae);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzem.zzb(i11, list.get(i12));
            i12++;
        }
    }

    public final void zzb(int i11, List<?> list, zzda zzda) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzb(i11, (Object) list.get(i12), zzda);
        }
    }

    public final <K, V> void zzb(int i11, zzcb<K, V> zzcb, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzem.zzc(i11, 2);
            this.zzem.zzo(zzcc.zzb(zzcb, next.getKey(), next.getValue()));
            zzcc.zzb(this.zzem, zzcb, next.getKey(), next.getValue());
        }
    }
}
