package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzbp implements zzfr {
    private final zzbn zzfo;

    private zzbp(zzbn zzbn) {
        zzbn zzbn2 = (zzbn) zzci.zza(zzbn, "output");
        this.zzfo = zzbn2;
        zzbn2.zzfz = this;
    }

    public static zzbp zza(zzbn zzbn) {
        zzbp zzbp = zzbn.zzfz;
        return zzbp != null ? zzbp : new zzbp(zzbn);
    }

    public final void zza(int i11, double d11) throws IOException {
        this.zzfo.zza(i11, d11);
    }

    public final void zza(int i11, float f11) throws IOException {
        this.zzfo.zza(i11, f11);
    }

    public final void zza(int i11, long j11) throws IOException {
        this.zzfo.zza(i11, j11);
    }

    public final void zza(int i11, zzbb zzbb) throws IOException {
        this.zzfo.zza(i11, zzbb);
    }

    public final <K, V> void zza(int i11, zzdh<K, V> zzdh, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzfo.zzb(i11, 2);
            this.zzfo.zzo(zzdg.zza(zzdh, next.getKey(), next.getValue()));
            zzdg.zza(this.zzfo, zzdh, next.getKey(), next.getValue());
        }
    }

    public final void zza(int i11, Object obj) throws IOException {
        if (obj instanceof zzbb) {
            this.zzfo.zzb(i11, (zzbb) obj);
        } else {
            this.zzfo.zzb(i11, (zzdo) obj);
        }
    }

    public final void zza(int i11, Object obj, zzef zzef) throws IOException {
        this.zzfo.zza(i11, (zzdo) obj, zzef);
    }

    public final void zza(int i11, String str) throws IOException {
        this.zzfo.zza(i11, str);
    }

    public final void zza(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof zzcx) {
            zzcx zzcx = (zzcx) list;
            while (i12 < list.size()) {
                Object raw = zzcx.getRaw(i12);
                if (raw instanceof String) {
                    this.zzfo.zza(i11, (String) raw);
                } else {
                    this.zzfo.zza(i11, (zzbb) raw);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zza(i11, list.get(i12));
            i12++;
        }
    }

    public final void zza(int i11, List<?> list, zzef zzef) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zza(i11, (Object) list.get(i12), zzef);
        }
    }

    public final void zza(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzs(list.get(i14).intValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzn(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzc(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzaa(int i11) throws IOException {
        this.zzfo.zzb(i11, 3);
    }

    public final void zzab(int i11) throws IOException {
        this.zzfo.zzb(i11, 4);
    }

    public final int zzaj() {
        return zzcg.zzg.zzko;
    }

    public final void zzb(int i11, long j11) throws IOException {
        this.zzfo.zzb(i11, j11);
    }

    public final void zzb(int i11, Object obj, zzef zzef) throws IOException {
        zzbn zzbn = this.zzfo;
        zzbn.zzb(i11, 3);
        zzef.zza((zzdo) obj, zzbn.zzfz);
        zzbn.zzb(i11, 4);
    }

    public final void zzb(int i11, List<zzbb> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zzfo.zza(i11, list.get(i12));
        }
    }

    public final void zzb(int i11, List<?> list, zzef zzef) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            zzb(i11, (Object) list.get(i12), zzef);
        }
    }

    public final void zzb(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzv(list.get(i14).intValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzq(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzf(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzb(int i11, boolean z11) throws IOException {
        this.zzfo.zzb(i11, z11);
    }

    public final void zzc(int i11, int i12) throws IOException {
        this.zzfo.zzc(i11, i12);
    }

    public final void zzc(int i11, long j11) throws IOException {
        this.zzfo.zzc(i11, j11);
    }

    public final void zzc(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zze(list.get(i14).longValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzb(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zza(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzd(int i11, int i12) throws IOException {
        this.zzfo.zzd(i11, i12);
    }

    public final void zzd(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzf(list.get(i14).longValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzb(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zza(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zze(int i11, int i12) throws IOException {
        this.zzfo.zze(i11, i12);
    }

    public final void zze(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzh(list.get(i14).longValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzd(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzc(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzf(int i11, int i12) throws IOException {
        this.zzfo.zzf(i11, i12);
    }

    public final void zzf(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzb(list.get(i14).floatValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zza(list.get(i12).floatValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zza(i11, list.get(i12).floatValue());
            i12++;
        }
    }

    public final void zzg(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzb(list.get(i14).doubleValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zza(list.get(i12).doubleValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zza(i11, list.get(i12).doubleValue());
            i12++;
        }
    }

    public final void zzh(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzx(list.get(i14).intValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzn(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzc(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzi(int i11, long j11) throws IOException {
        this.zzfo.zza(i11, j11);
    }

    public final void zzi(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzb(list.get(i14).booleanValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zza(list.get(i12).booleanValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzb(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public final void zzj(int i11, long j11) throws IOException {
        this.zzfo.zzc(i11, j11);
    }

    public final void zzj(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzt(list.get(i14).intValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzo(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzd(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzk(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzw(list.get(i14).intValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzq(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzf(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzl(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzi(list.get(i14).longValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzd(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzc(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzm(int i11, int i12) throws IOException {
        this.zzfo.zzf(i11, i12);
    }

    public final void zzm(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzu(list.get(i14).intValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzp(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zze(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzn(int i11, int i12) throws IOException {
        this.zzfo.zzc(i11, i12);
    }

    public final void zzn(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zzfo.zzb(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzbn.zzg(list.get(i14).longValue());
            }
            this.zzfo.zzo(i13);
            while (i12 < list.size()) {
                this.zzfo.zzc(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zzfo.zzb(i11, list.get(i12).longValue());
            i12++;
        }
    }
}
