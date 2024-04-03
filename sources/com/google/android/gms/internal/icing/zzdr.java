package com.google.android.gms.internal.icing;

final class zzdr extends zzds {
    private zzdr() {
        super((zzdp) null);
    }

    public /* synthetic */ zzdr(zzdp zzdp) {
        super((zzdp) null);
    }

    public final void zza(Object obj, long j11) {
        ((zzdg) zzfn.zzn(obj, j11)).zzb();
    }

    public final <E> void zzb(Object obj, Object obj2, long j11) {
        zzdg zzdg = (zzdg) zzfn.zzn(obj, j11);
        zzdg zzdg2 = (zzdg) zzfn.zzn(obj2, j11);
        int size = zzdg.size();
        int size2 = zzdg2.size();
        if (size > 0 && size2 > 0) {
            if (!zzdg.zza()) {
                zzdg = zzdg.zze(size2 + size);
            }
            zzdg.addAll(zzdg2);
        }
        if (size > 0) {
            zzdg2 = zzdg;
        }
        zzfn.zzo(obj, j11, zzdg2);
    }
}
