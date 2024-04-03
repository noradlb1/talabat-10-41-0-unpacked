package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagj  reason: invalid package */
final class zzagj {
    private final zzagi zza;

    private zzagj(zzagi zzagi) {
        byte[] bArr = zzahg.zzd;
        this.zza = zzagi;
        zzagi.zze = this;
    }

    public static zzagj zza(zzagi zzagi) {
        zzagj zzagj = zzagi.zze;
        return zzagj != null ? zzagj : new zzagj(zzagi);
    }

    public final void zzA(int i11, int i12) throws IOException {
        this.zza.zzr(i11, (i12 >> 31) ^ (i12 + i12));
    }

    public final void zzB(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                int intValue = ((Integer) list.get(i14)).intValue();
                i13 += zzagi.zzA((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                zzagi zzagi = this.zza;
                int intValue2 = ((Integer) list.get(i12)).intValue();
                zzagi.zzs((intValue2 >> 31) ^ (intValue2 + intValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzagi zzagi2 = this.zza;
            int intValue3 = ((Integer) list.get(i12)).intValue();
            zzagi2.zzr(i11, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i12++;
        }
    }

    public final void zzC(int i11, long j11) throws IOException {
        this.zza.zzt(i11, (j11 >> 63) ^ (j11 + j11));
    }

    public final void zzD(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                long longValue = ((Long) list.get(i14)).longValue();
                i13 += zzagi.zzB((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                zzagi zzagi = this.zza;
                long longValue2 = ((Long) list.get(i12)).longValue();
                zzagi.zzu((longValue2 >> 63) ^ (longValue2 + longValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzagi zzagi2 = this.zza;
            long longValue3 = ((Long) list.get(i12)).longValue();
            zzagi2.zzt(i11, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i12++;
        }
    }

    @Deprecated
    public final void zzE(int i11) throws IOException {
        this.zza.zzq(i11, 3);
    }

    public final void zzF(int i11, String str) throws IOException {
        this.zza.zzo(i11, str);
    }

    public final void zzG(int i11, List list) throws IOException {
        int i12 = 0;
        if (list instanceof zzahn) {
            zzahn zzahn = (zzahn) list;
            while (i12 < list.size()) {
                Object zzf = zzahn.zzf(i12);
                if (zzf instanceof String) {
                    this.zza.zzo(i11, (String) zzf);
                } else {
                    this.zza.zzL(i11, (zzafv) zzf);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzo(i11, (String) list.get(i12));
            i12++;
        }
    }

    public final void zzH(int i11, int i12) throws IOException {
        this.zza.zzr(i11, i12);
    }

    public final void zzI(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzagi.zzA(((Integer) list.get(i14)).intValue());
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzs(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzr(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzJ(int i11, long j11) throws IOException {
        this.zza.zzt(i11, j11);
    }

    public final void zzK(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzagi.zzB(((Long) list.get(i14)).longValue());
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzu(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzt(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzb(int i11, boolean z11) throws IOException {
        this.zza.zzK(i11, z11);
    }

    public final void zzc(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Boolean) list.get(i14)).booleanValue();
                i13++;
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzJ(((Boolean) list.get(i12)).booleanValue() ? (byte) 1 : 0);
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzK(i11, ((Boolean) list.get(i12)).booleanValue());
            i12++;
        }
    }

    public final void zzd(int i11, zzafv zzafv) throws IOException {
        this.zza.zzL(i11, zzafv);
    }

    public final void zze(int i11, List list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zza.zzL(i11, (zzafv) list.get(i12));
        }
    }

    public final void zzf(int i11, double d11) throws IOException {
        this.zza.zzj(i11, Double.doubleToRawLongBits(d11));
    }

    public final void zzg(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Double) list.get(i14)).doubleValue();
                i13 += 8;
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzk(Double.doubleToRawLongBits(((Double) list.get(i12)).doubleValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzj(i11, Double.doubleToRawLongBits(((Double) list.get(i12)).doubleValue()));
            i12++;
        }
    }

    @Deprecated
    public final void zzh(int i11) throws IOException {
        this.zza.zzq(i11, 4);
    }

    public final void zzi(int i11, int i12) throws IOException {
        this.zza.zzl(i11, i12);
    }

    public final void zzj(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzagi.zzx(((Integer) list.get(i14)).intValue());
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzm(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzl(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzk(int i11, int i12) throws IOException {
        this.zza.zzh(i11, i12);
    }

    public final void zzl(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Integer) list.get(i14)).intValue();
                i13 += 4;
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzi(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzm(int i11, long j11) throws IOException {
        this.zza.zzj(i11, j11);
    }

    public final void zzn(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Long) list.get(i14)).longValue();
                i13 += 8;
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzk(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzj(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzo(int i11, float f11) throws IOException {
        this.zza.zzh(i11, Float.floatToRawIntBits(f11));
    }

    public final void zzp(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Float) list.get(i14)).floatValue();
                i13 += 4;
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzi(Float.floatToRawIntBits(((Float) list.get(i12)).floatValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, Float.floatToRawIntBits(((Float) list.get(i12)).floatValue()));
            i12++;
        }
    }

    public final void zzq(int i11, Object obj, zzair zzair) throws IOException {
        zzagi zzagi = this.zza;
        zzagi.zzq(i11, 3);
        zzair.zzm((zzaif) obj, zzagi.zze);
        zzagi.zzq(i11, 4);
    }

    public final void zzr(int i11, int i12) throws IOException {
        this.zza.zzl(i11, i12);
    }

    public final void zzs(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzagi.zzx(((Integer) list.get(i14)).intValue());
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzm(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzl(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzt(int i11, long j11) throws IOException {
        this.zza.zzt(i11, j11);
    }

    public final void zzu(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzagi.zzB(((Long) list.get(i14)).longValue());
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzu(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzt(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzv(int i11, Object obj, zzair zzair) throws IOException {
        this.zza.zzn(i11, (zzaif) obj, zzair);
    }

    public final void zzw(int i11, int i12) throws IOException {
        this.zza.zzh(i11, i12);
    }

    public final void zzx(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Integer) list.get(i14)).intValue();
                i13 += 4;
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzi(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzy(int i11, long j11) throws IOException {
        this.zza.zzj(i11, j11);
    }

    public final void zzz(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzq(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Long) list.get(i14)).longValue();
                i13 += 8;
            }
            this.zza.zzs(i13);
            while (i12 < list.size()) {
                this.zza.zzk(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzj(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }
}
