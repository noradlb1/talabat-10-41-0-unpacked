package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.util.List;

final class zzcn {
    private final zzcm zza;

    private zzcn(zzcm zzcm) {
        zzdh.zzb(zzcm, "output");
        this.zza = zzcm;
        zzcm.zza = this;
    }

    public static zzcn zza(zzcm zzcm) {
        zzcn zzcn = zzcm.zza;
        if (zzcn != null) {
            return zzcn;
        }
        return new zzcn(zzcm);
    }

    public final void zzA(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzcm.zzv(list.get(i14).intValue());
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzk(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzb(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzB(int i11, List<Boolean> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).booleanValue();
                i13++;
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzj(list.get(i12).booleanValue() ? (byte) 1 : 0);
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzg(i11, list.get(i12).booleanValue());
            i12++;
        }
    }

    public final void zzC(int i11, List<String> list) throws IOException {
        int i12 = 0;
        if (list instanceof zzdo) {
            zzdo zzdo = (zzdo) list;
            while (i12 < list.size()) {
                Object zzg = zzdo.zzg(i12);
                if (zzg instanceof String) {
                    this.zza.zzh(i11, (String) zzg);
                } else {
                    this.zza.zzi(i11, (zzcf) zzg);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, list.get(i12));
            i12++;
        }
    }

    public final void zzD(int i11, List<zzcf> list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zza.zzi(i11, list.get(i12));
        }
    }

    public final void zzE(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzcm.zzw(list.get(i14).intValue());
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzl(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzc(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzF(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).intValue();
                i13 += 4;
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzm(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzd(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzG(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).longValue();
                i13 += 8;
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzo(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzH(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                int intValue = list.get(i14).intValue();
                i13 += zzcm.zzw((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                zzcm zzcm = this.zza;
                int intValue2 = list.get(i12).intValue();
                zzcm.zzl((intValue2 >> 31) ^ (intValue2 + intValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzcm zzcm2 = this.zza;
            int intValue3 = list.get(i12).intValue();
            zzcm2.zzc(i11, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i12++;
        }
    }

    public final void zzI(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                long longValue = list.get(i14).longValue();
                i13 += zzcm.zzx((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                zzcm zzcm = this.zza;
                long longValue2 = list.get(i12).longValue();
                zzcm.zzn((longValue2 >> 63) ^ (longValue2 + longValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzcm zzcm2 = this.zza;
            long longValue3 = list.get(i12).longValue();
            zzcm2.zze(i11, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i12++;
        }
    }

    public final void zzb(int i11, int i12) throws IOException {
        this.zza.zzd(i11, i12);
    }

    public final void zzc(int i11, long j11) throws IOException {
        this.zza.zze(i11, j11);
    }

    public final void zzd(int i11, long j11) throws IOException {
        this.zza.zzf(i11, j11);
    }

    public final void zze(int i11, float f11) throws IOException {
        this.zza.zzd(i11, Float.floatToRawIntBits(f11));
    }

    public final void zzf(int i11, double d11) throws IOException {
        this.zza.zzf(i11, Double.doubleToRawLongBits(d11));
    }

    public final void zzg(int i11, int i12) throws IOException {
        this.zza.zzb(i11, i12);
    }

    public final void zzh(int i11, long j11) throws IOException {
        this.zza.zze(i11, j11);
    }

    public final void zzi(int i11, int i12) throws IOException {
        this.zza.zzb(i11, i12);
    }

    public final void zzj(int i11, long j11) throws IOException {
        this.zza.zzf(i11, j11);
    }

    public final void zzk(int i11, int i12) throws IOException {
        this.zza.zzd(i11, i12);
    }

    public final void zzl(int i11, boolean z11) throws IOException {
        this.zza.zzg(i11, z11);
    }

    public final void zzm(int i11, String str) throws IOException {
        this.zza.zzh(i11, str);
    }

    public final void zzn(int i11, zzcf zzcf) throws IOException {
        this.zza.zzi(i11, zzcf);
    }

    public final void zzo(int i11, int i12) throws IOException {
        this.zza.zzc(i11, i12);
    }

    public final void zzp(int i11, int i12) throws IOException {
        this.zza.zzc(i11, (i12 >> 31) ^ (i12 + i12));
    }

    public final void zzq(int i11, long j11) throws IOException {
        this.zza.zze(i11, (j11 >> 63) ^ (j11 + j11));
    }

    public final void zzr(int i11, Object obj, zzep zzep) throws IOException {
        zzee zzee = (zzee) obj;
        zzck zzck = (zzck) this.zza;
        zzck.zzl((i11 << 3) | 2);
        zzbs zzbs = (zzbs) zzee;
        int zzi = zzbs.zzi();
        if (zzi == -1) {
            zzi = zzep.zzd(zzbs);
            zzbs.zzj(zzi);
        }
        zzck.zzl(zzi);
        zzep.zzi(zzee, zzck.zza);
    }

    public final void zzs(int i11, Object obj, zzep zzep) throws IOException {
        zzcm zzcm = this.zza;
        zzcm.zza(i11, 3);
        zzep.zzi((zzee) obj, zzcm.zza);
        zzcm.zza(i11, 4);
    }

    public final void zzt(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzcm.zzv(list.get(i14).intValue());
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzk(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzb(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzu(int i11, List<Integer> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).intValue();
                i13 += 4;
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzm(list.get(i12).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzd(i11, list.get(i12).intValue());
            i12++;
        }
    }

    public final void zzv(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzcm.zzx(list.get(i14).longValue());
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzn(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zze(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzw(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzcm.zzx(list.get(i14).longValue());
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzn(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zze(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzx(int i11, List<Long> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).longValue();
                i13 += 8;
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzo(list.get(i12).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, list.get(i12).longValue());
            i12++;
        }
    }

    public final void zzy(int i11, List<Float> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).floatValue();
                i13 += 4;
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzm(Float.floatToRawIntBits(list.get(i12).floatValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzd(i11, Float.floatToRawIntBits(list.get(i12).floatValue()));
            i12++;
        }
    }

    public final void zzz(int i11, List<Double> list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zza(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                list.get(i14).doubleValue();
                i13 += 8;
            }
            this.zza.zzl(i13);
            while (i12 < list.size()) {
                this.zza.zzo(Double.doubleToRawLongBits(list.get(i12).doubleValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, Double.doubleToRawLongBits(list.get(i12).doubleValue()));
            i12++;
        }
    }
}
