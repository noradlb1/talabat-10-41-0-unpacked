package com.google.android.gms.internal.places;

import java.io.IOException;

final class zzdu extends zzds<zzdr, zzdr> {
    private static void zzb(Object obj, zzdr zzdr) {
        ((zzbc) obj).zzih = zzdr;
    }

    public final void zzd(Object obj) {
        ((zzbc) obj).zzih.zzab();
    }

    public final /* synthetic */ Object zzdk() {
        return zzdr.zzdi();
    }

    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zzb(obj, (zzdr) obj2);
    }

    public final /* synthetic */ void zzg(Object obj, Object obj2) {
        zzb(obj, (zzdr) obj2);
    }

    public final /* synthetic */ Object zzh(Object obj, Object obj2) {
        zzdr zzdr = (zzdr) obj;
        zzdr zzdr2 = (zzdr) obj2;
        if (zzdr2.equals(zzdr.zzdh())) {
            return zzdr;
        }
        return zzdr.zzb(zzdr, zzdr2);
    }

    public final /* synthetic */ int zzn(Object obj) {
        return ((zzdr) obj).zzbh();
    }

    public final /* synthetic */ Object zzr(Object obj) {
        return ((zzbc) obj).zzih;
    }

    public final /* synthetic */ int zzs(Object obj) {
        return ((zzdr) obj).zzdj();
    }

    public final /* synthetic */ void zzb(Object obj, zzel zzel) throws IOException {
        ((zzdr) obj).zzc(zzel);
    }

    public final /* synthetic */ void zzd(Object obj, zzel zzel) throws IOException {
        ((zzdr) obj).zzb(zzel);
    }

    public final /* synthetic */ void zzb(Object obj, int i11, zzw zzw) {
        ((zzdr) obj).zzc((i11 << 3) | 2, zzw);
    }

    public final /* synthetic */ void zzb(Object obj, int i11, long j11) {
        ((zzdr) obj).zzc(i11 << 3, Long.valueOf(j11));
    }
}
