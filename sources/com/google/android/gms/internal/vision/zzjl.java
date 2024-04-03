package com.google.android.gms.internal.vision;

import java.io.IOException;

final class zzjl extends zzjj<zzjm, zzjm> {
    private static void zza(Object obj, zzjm zzjm) {
        ((zzgs) obj).zzwd = zzjm;
    }

    public final boolean zza(zzis zzis) {
        return false;
    }

    public final /* synthetic */ void zzb(Object obj, int i11, long j11) {
        ((zzjm) obj).zzb((i11 << 3) | 1, Long.valueOf(j11));
    }

    public final /* synthetic */ void zzc(Object obj, zzkg zzkg) throws IOException {
        ((zzjm) obj).zza(zzkg);
    }

    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzjm) obj2);
    }

    public final void zzg(Object obj) {
        ((zzgs) obj).zzwd.zzdp();
    }

    public final /* synthetic */ Object zzh(Object obj, Object obj2) {
        zzjm zzjm = (zzjm) obj;
        zzjm zzjm2 = (zzjm) obj2;
        if (zzjm2.equals(zzjm.zzig())) {
            return zzjm;
        }
        return zzjm.zza(zzjm, zzjm2);
    }

    public final /* synthetic */ Object zzif() {
        return zzjm.zzih();
    }

    public final /* synthetic */ Object zzn(Object obj) {
        zzjm zzjm = (zzjm) obj;
        zzjm.zzdp();
        return zzjm;
    }

    public final /* synthetic */ int zzr(Object obj) {
        return ((zzjm) obj).zzgf();
    }

    public final /* synthetic */ Object zzv(Object obj) {
        return ((zzgs) obj).zzwd;
    }

    public final /* synthetic */ Object zzw(Object obj) {
        zzjm zzjm = ((zzgs) obj).zzwd;
        if (zzjm != zzjm.zzig()) {
            return zzjm;
        }
        zzjm zzih = zzjm.zzih();
        zza(obj, zzih);
        return zzih;
    }

    public final /* synthetic */ int zzx(Object obj) {
        return ((zzjm) obj).zzii();
    }

    public final /* synthetic */ void zza(Object obj, zzkg zzkg) throws IOException {
        ((zzjm) obj).zzb(zzkg);
    }

    public final /* synthetic */ void zzc(Object obj, int i11, int i12) {
        ((zzjm) obj).zzb((i11 << 3) | 5, Integer.valueOf(i12));
    }

    public final /* synthetic */ void zzg(Object obj, Object obj2) {
        zza(obj, (zzjm) obj2);
    }

    public final /* synthetic */ void zza(Object obj, int i11, Object obj2) {
        ((zzjm) obj).zzb((i11 << 3) | 3, (zzjm) obj2);
    }

    public final /* synthetic */ void zza(Object obj, int i11, zzfh zzfh) {
        ((zzjm) obj).zzb((i11 << 3) | 2, zzfh);
    }

    public final /* synthetic */ void zza(Object obj, int i11, long j11) {
        ((zzjm) obj).zzb(i11 << 3, Long.valueOf(j11));
    }
}
