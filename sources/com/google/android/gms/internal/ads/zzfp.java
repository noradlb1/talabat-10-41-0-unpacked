package com.google.android.gms.internal.ads;

import android.util.Pair;

public abstract class zzfp extends zzcd {
    private final int zzc;
    private final zzrq zzd;

    public zzfp(boolean z11, zzrq zzrq, byte[] bArr) {
        this.zzd = zzrq;
        this.zzc = zzrq.zzc();
    }

    private final int zzw(int i11, boolean z11) {
        if (z11) {
            return this.zzd.zzd(i11);
        }
        if (i11 >= this.zzc - 1) {
            return -1;
        }
        return i11 + 1;
    }

    private final int zzx(int i11, boolean z11) {
        if (z11) {
            return this.zzd.zze(i11);
        }
        if (i11 <= 0) {
            return -1;
        }
        return i11 - 1;
    }

    public final int zza(Object obj) {
        int zza;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        if (zzp == -1 || (zza = zzu(zzp).zza(obj3)) == -1) {
            return -1;
        }
        return zzs(zzp) + zza;
    }

    public final zzca zzd(int i11, zzca zzca, boolean z11) {
        int zzq = zzq(i11);
        int zzt = zzt(zzq);
        zzu(zzq).zzd(i11 - zzs(zzq), zzca, z11);
        zzca.zzd += zzt;
        if (z11) {
            Object zzv = zzv(zzq);
            Object obj = zzca.zzc;
            obj.getClass();
            zzca.zzc = Pair.create(zzv, obj);
        }
        return zzca;
    }

    public final zzcc zze(int i11, zzcc zzcc, long j11) {
        int zzr = zzr(i11);
        int zzt = zzt(zzr);
        int zzs = zzs(zzr);
        zzu(zzr).zze(i11 - zzt, zzcc, j11);
        Object zzv = zzv(zzr);
        if (!zzcc.zza.equals(zzcc.zzc)) {
            zzv = Pair.create(zzv, zzcc.zzc);
        }
        zzcc.zzc = zzv;
        zzcc.zzo += zzs;
        zzcc.zzp += zzs;
        return zzcc;
    }

    public final Object zzf(int i11) {
        int zzq = zzq(i11);
        return Pair.create(zzv(zzq), zzu(zzq).zzf(i11 - zzs(zzq)));
    }

    public final int zzg(boolean z11) {
        int i11;
        if (this.zzc == 0) {
            return -1;
        }
        if (z11) {
            i11 = this.zzd.zza();
        } else {
            i11 = 0;
        }
        while (zzu(i11).zzo()) {
            i11 = zzw(i11, z11);
            if (i11 == -1) {
                return -1;
            }
        }
        return zzt(i11) + zzu(i11).zzg(z11);
    }

    public final int zzh(boolean z11) {
        int i11;
        int i12 = this.zzc;
        if (i12 == 0) {
            return -1;
        }
        if (z11) {
            i11 = this.zzd.zzb();
        } else {
            i11 = i12 - 1;
        }
        while (zzu(i11).zzo()) {
            i11 = zzx(i11, z11);
            if (i11 == -1) {
                return -1;
            }
        }
        return zzt(i11) + zzu(i11).zzh(z11);
    }

    public final int zzj(int i11, int i12, boolean z11) {
        int i13;
        int zzr = zzr(i11);
        int zzt = zzt(zzr);
        zzcd zzu = zzu(zzr);
        int i14 = i11 - zzt;
        if (i12 == 2) {
            i13 = 0;
        } else {
            i13 = i12;
        }
        int zzj = zzu.zzj(i14, i13, z11);
        if (zzj != -1) {
            return zzt + zzj;
        }
        int zzw = zzw(zzr, z11);
        while (zzw != -1 && zzu(zzw).zzo()) {
            zzw = zzw(zzw, z11);
        }
        if (zzw != -1) {
            return zzt(zzw) + zzu(zzw).zzg(z11);
        }
        if (i12 == 2) {
            return zzg(z11);
        }
        return -1;
    }

    public final int zzk(int i11, int i12, boolean z11) {
        int zzr = zzr(i11);
        int zzt = zzt(zzr);
        int zzk = zzu(zzr).zzk(i11 - zzt, 0, false);
        if (zzk != -1) {
            return zzt + zzk;
        }
        int zzx = zzx(zzr, false);
        while (zzx != -1 && zzu(zzx).zzo()) {
            zzx = zzx(zzx, false);
        }
        if (zzx != -1) {
            return zzt(zzx) + zzu(zzx).zzh(false);
        }
        return -1;
    }

    public final zzca zzn(Object obj, zzca zzca) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int zzp = zzp(obj2);
        int zzt = zzt(zzp);
        zzu(zzp).zzn(obj3, zzca);
        zzca.zzd += zzt;
        zzca.zzc = obj;
        return zzca;
    }

    public abstract int zzp(Object obj);

    public abstract int zzq(int i11);

    public abstract int zzr(int i11);

    public abstract int zzs(int i11);

    public abstract int zzt(int i11);

    public abstract zzcd zzu(int i11);

    public abstract Object zzv(int i11);
}
