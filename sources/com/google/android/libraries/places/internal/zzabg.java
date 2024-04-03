package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.List;

final class zzabg {
    private final zzabf zza;

    private zzabg(zzabf zzabf) {
        zzaca.zzf(zzabf, "output");
        this.zza = zzabf;
        zzabf.zza = this;
    }

    public static zzabg zza(zzabf zzabf) {
        zzabg zzabg = zzabf.zza;
        return zzabg != null ? zzabg : new zzabg(zzabf);
    }

    public final void zzA(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                int intValue = list.get(i14).intValue();
                i13 += zzabf.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                zzabf zzabf = this.zza;
                int intValue2 = list.get(i12).intValue();
                zzabf.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzabf zzabf2 = this.zza;
            int intValue3 = list.get(i12).intValue();
            zzabf2.zzp(i11, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i12++;
        }
    }

    public final void zzB(int i11, long j11) throws IOException {
        this.zza.zzr(i11, (j11 >> 63) ^ (j11 + j11));
    }

    public final void zzC(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                long longValue = list.get(i14).longValue();
                i13 += zzabf.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                zzabf zzabf = this.zza;
                long longValue2 = list.get(i12).longValue();
                zzabf.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzabf zzabf2 = this.zza;
            long longValue3 = list.get(i12).longValue();
            zzabf2.zzr(i11, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i12++;
        }
    }

    public final void zzD(int i11, String str) throws IOException {
        this.zza.zzm(i11, str);
    }

    public final void zzE(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof zzach) {
            zzach zzach = (zzach) list;
            while (i12 < list.size()) {
                Object zze = zzach.zze(i12);
                if (zze instanceof String) {
                    this.zza.zzm(i11, (String) zze);
                } else {
                    this.zza.zze(i11, (zzaax) zze);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzm(i11, list.get(i12));
            i12++;
        }
    }

    public final void zzF(int i11, int i12) throws IOException {
        this.zza.zzp(i11, i12);
    }

    public final void zzG(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzabf.zzA(list.get(i14).intValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzq(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzp(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzH(int i11, long j11) throws IOException {
        this.zza.zzr(i11, j11);
    }

    public final void zzI(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzabf.zzB(list.get(i14).longValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzs(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzr(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzb(int i11, boolean z11) throws IOException {
        this.zza.zzd(i11, z11);
    }

    public final void zzc(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).booleanValue();
                i13++;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzb(list.get(i12).booleanValue() ? (byte) 1 : 0);
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzd(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public final void zzd(int i11, zzaax zzaax) throws IOException {
        this.zza.zze(i11, zzaax);
    }

    public final void zze(int i11, List<zzaax> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zza.zze(i11, list.get(i12));
        }
    }

    public final void zzf(int i11, double d11) throws IOException {
        this.zza.zzh(i11, Double.doubleToRawLongBits(d11));
    }

    public final void zzg(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).doubleValue();
                i13 += 8;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(list.get(i12).doubleValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, Double.doubleToRawLongBits(list.get(i12).doubleValue()));
            i12++;
        }
    }

    public final void zzh(int i11, int i12) throws IOException {
        this.zza.zzj(i11, i12);
    }

    public final void zzi(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzabf.zzv(list.get(i14).intValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzk(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzj(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzj(int i11, int i12) throws IOException {
        this.zza.zzf(i11, i12);
    }

    public final void zzk(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).intValue();
                i13 += 4;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzg(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzl(int i11, long j11) throws IOException {
        this.zza.zzh(i11, j11);
    }

    public final void zzm(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).longValue();
                i13 += 8;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzi(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzn(int i11, float f11) throws IOException {
        this.zza.zzf(i11, Float.floatToRawIntBits(f11));
    }

    public final void zzo(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).floatValue();
                i13 += 4;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(list.get(i12).floatValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, Float.floatToRawIntBits(list.get(i12).floatValue()));
            i12++;
        }
    }

    public final void zzp(int i11, Object obj, zzadk zzadk) throws IOException {
        zzabf zzabf = this.zza;
        zzabf.zzo(i11, 3);
        zzadk.zzi((zzacz) obj, zzabf.zza);
        zzabf.zzo(i11, 4);
    }

    public final void zzq(int i11, int i12) throws IOException {
        this.zza.zzj(i11, i12);
    }

    public final void zzr(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzabf.zzv(list.get(i14).intValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzk(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzj(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzs(int i11, long j11) throws IOException {
        this.zza.zzr(i11, j11);
    }

    public final void zzt(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzabf.zzB(list.get(i14).longValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzs(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzr(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzu(int i11, Object obj, zzadk zzadk) throws IOException {
        zzacz zzacz = (zzacz) obj;
        zzabc zzabc = (zzabc) this.zza;
        zzabc.zzq((i11 << 3) | 2);
        zzaaj zzaaj = (zzaaj) zzacz;
        int zzr = zzaaj.zzr();
        if (zzr == -1) {
            zzr = zzadk.zza(zzaaj);
            zzaaj.zzu(zzr);
        }
        zzabc.zzq(zzr);
        zzadk.zzi(zzacz, zzabc.zza);
    }

    public final void zzv(int i11, int i12) throws IOException {
        this.zza.zzf(i11, i12);
    }

    public final void zzw(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).intValue();
                i13 += 4;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzg(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzx(int i11, long j11) throws IOException {
        this.zza.zzh(i11, j11);
    }

    public final void zzy(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).longValue();
                i13 += 8;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzi(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzz(int i11, int i12) throws IOException {
        this.zza.zzp(i11, (i12 >> 31) ^ (i12 + i12));
    }
}
