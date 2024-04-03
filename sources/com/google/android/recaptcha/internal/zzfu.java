package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.util.List;

final class zzfu implements zzko {
    private final zzft zza;

    private zzfu(zzft zzft) {
        byte[] bArr = zzhn.zzd;
        this.zza = zzft;
        zzft.zza = this;
    }

    public static zzfu zza(zzft zzft) {
        zzfu zzfu = zzft.zza;
        return zzfu != null ? zzfu : new zzfu(zzft);
    }

    public final void zzA(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Long) list.get(i14)).longValue();
                i13 += 8;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzi(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzB(int i11, int i12) throws IOException {
        this.zza.zzp(i11, (i12 >> 31) ^ (i12 + i12));
    }

    public final void zzC(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                int intValue = ((Integer) list.get(i14)).intValue();
                i13 += zzft.zzy((intValue >> 31) ^ (intValue + intValue));
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                zzft zzft = this.zza;
                int intValue2 = ((Integer) list.get(i12)).intValue();
                zzft.zzq((intValue2 >> 31) ^ (intValue2 + intValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzft zzft2 = this.zza;
            int intValue3 = ((Integer) list.get(i12)).intValue();
            zzft2.zzp(i11, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i12++;
        }
    }

    public final void zzD(int i11, long j11) throws IOException {
        this.zza.zzr(i11, (j11 >> 63) ^ (j11 + j11));
    }

    public final void zzE(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                long longValue = ((Long) list.get(i14)).longValue();
                i13 += zzft.zzz((longValue >> 63) ^ (longValue + longValue));
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                zzft zzft = this.zza;
                long longValue2 = ((Long) list.get(i12)).longValue();
                zzft.zzs((longValue2 >> 63) ^ (longValue2 + longValue2));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            zzft zzft2 = this.zza;
            long longValue3 = ((Long) list.get(i12)).longValue();
            zzft2.zzr(i11, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i12++;
        }
    }

    @Deprecated
    public final void zzF(int i11) throws IOException {
        this.zza.zzo(i11, 3);
    }

    public final void zzG(int i11, String str) throws IOException {
        this.zza.zzm(i11, str);
    }

    public final void zzH(int i11, List list) throws IOException {
        int i12 = 0;
        if (list instanceof zzhx) {
            zzhx zzhx = (zzhx) list;
            while (i12 < list.size()) {
                Object zzf = zzhx.zzf(i12);
                if (zzf instanceof String) {
                    this.zza.zzm(i11, (String) zzf);
                } else {
                    this.zza.zze(i11, (zzfi) zzf);
                }
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzm(i11, (String) list.get(i12));
            i12++;
        }
    }

    public final void zzI(int i11, int i12) throws IOException {
        this.zza.zzp(i11, i12);
    }

    public final void zzJ(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzft.zzy(((Integer) list.get(i14)).intValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzq(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzp(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzK(int i11, long j11) throws IOException {
        this.zza.zzr(i11, j11);
    }

    public final void zzL(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzft.zzz(((Long) list.get(i14)).longValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzs(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzr(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzb(int i11, boolean z11) throws IOException {
        this.zza.zzd(i11, z11);
    }

    public final void zzc(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Boolean) list.get(i14)).booleanValue();
                i13++;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzb(((Boolean) list.get(i12)).booleanValue() ? (byte) 1 : 0);
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzd(i11, ((Boolean) list.get(i12)).booleanValue());
            i12++;
        }
    }

    public final void zzd(int i11, zzfi zzfi) throws IOException {
        this.zza.zze(i11, zzfi);
    }

    public final void zze(int i11, List list) throws IOException {
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.zza.zze(i11, (zzfi) list.get(i12));
        }
    }

    public final void zzf(int i11, double d11) throws IOException {
        this.zza.zzh(i11, Double.doubleToRawLongBits(d11));
    }

    public final void zzg(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Double) list.get(i14)).doubleValue();
                i13 += 8;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzi(Double.doubleToRawLongBits(((Double) list.get(i12)).doubleValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, Double.doubleToRawLongBits(((Double) list.get(i12)).doubleValue()));
            i12++;
        }
    }

    @Deprecated
    public final void zzh(int i11) throws IOException {
        this.zza.zzo(i11, 4);
    }

    public final void zzi(int i11, int i12) throws IOException {
        this.zza.zzj(i11, i12);
    }

    public final void zzj(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzft.zzu(((Integer) list.get(i14)).intValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzk(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzj(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzk(int i11, int i12) throws IOException {
        this.zza.zzf(i11, i12);
    }

    public final void zzl(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Integer) list.get(i14)).intValue();
                i13 += 4;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzg(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzm(int i11, long j11) throws IOException {
        this.zza.zzh(i11, j11);
    }

    public final void zzn(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Long) list.get(i14)).longValue();
                i13 += 8;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzi(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzh(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzo(int i11, float f11) throws IOException {
        this.zza.zzf(i11, Float.floatToRawIntBits(f11));
    }

    public final void zzp(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Float) list.get(i14)).floatValue();
                i13 += 4;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzg(Float.floatToRawIntBits(((Float) list.get(i12)).floatValue()));
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, Float.floatToRawIntBits(((Float) list.get(i12)).floatValue()));
            i12++;
        }
    }

    public final void zzq(int i11, Object obj, zzjc zzjc) throws IOException {
        zzft zzft = this.zza;
        zzft.zzo(i11, 3);
        zzjc.zzj((zzip) obj, zzft.zza);
        zzft.zzo(i11, 4);
    }

    public final void zzr(int i11, int i12) throws IOException {
        this.zza.zzj(i11, i12);
    }

    public final void zzs(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzft.zzu(((Integer) list.get(i14)).intValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzk(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzj(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzt(int i11, long j11) throws IOException {
        this.zza.zzr(i11, j11);
    }

    public final void zzu(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                i13 += zzft.zzz(((Long) list.get(i14)).longValue());
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzs(((Long) list.get(i12)).longValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzr(i11, ((Long) list.get(i12)).longValue());
            i12++;
        }
    }

    public final void zzv(int i11, Object obj, zzjc zzjc) throws IOException {
        zzip zzip = (zzip) obj;
        zzfq zzfq = (zzfq) this.zza;
        zzfq.zzq((i11 << 3) | 2);
        zzfq.zzq(((zzer) zzip).zza(zzjc));
        zzjc.zzj(zzip, zzfq.zza);
    }

    public final void zzw(int i11, Object obj) throws IOException {
        if (obj instanceof zzfi) {
            zzfq zzfq = (zzfq) this.zza;
            zzfq.zzq(11);
            zzfq.zzp(2, i11);
            zzfq.zze(3, (zzfi) obj);
            zzfq.zzq(12);
            return;
        }
        zzft zzft = this.zza;
        zzip zzip = (zzip) obj;
        zzfq zzfq2 = (zzfq) zzft;
        zzfq2.zzq(11);
        zzfq2.zzp(2, i11);
        zzfq2.zzq(26);
        zzfq2.zzq(zzip.zzn());
        zzip.zze(zzft);
        zzfq2.zzq(12);
    }

    public final void zzx(int i11, int i12) throws IOException {
        this.zza.zzf(i11, i12);
    }

    public final void zzy(int i11, List list, boolean z11) throws IOException {
        int i12 = 0;
        if (z11) {
            this.zza.zzo(i11, 2);
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                ((Integer) list.get(i14)).intValue();
                i13 += 4;
            }
            this.zza.zzq(i13);
            while (i12 < list.size()) {
                this.zza.zzg(((Integer) list.get(i12)).intValue());
                i12++;
            }
            return;
        }
        while (i12 < list.size()) {
            this.zza.zzf(i11, ((Integer) list.get(i12)).intValue());
            i12++;
        }
    }

    public final void zzz(int i11, long j11) throws IOException {
        this.zza.zzh(i11, j11);
    }
}
