package com.google.android.gms.internal.gtm;

import java.io.IOException;

final class zztt extends zztr<zzts, zzts> {
    private static void zza(Object obj, zzts zzts) {
        ((zzrc) obj).zzbak = zzts;
    }

    public final boolean zza(zzsy zzsy) {
        return false;
    }

    public final /* synthetic */ Object zzaa(Object obj) {
        zzts zzts = (zzts) obj;
        zzts.zzmi();
        return zzts;
    }

    public final /* synthetic */ int zzad(Object obj) {
        return ((zzts) obj).zzpe();
    }

    public final /* synthetic */ Object zzag(Object obj) {
        return ((zzrc) obj).zzbak;
    }

    public final /* synthetic */ Object zzah(Object obj) {
        zzts zzts = ((zzrc) obj).zzbak;
        if (zzts != zzts.zzrj()) {
            return zzts;
        }
        zzts zzrk = zzts.zzrk();
        zza(obj, zzrk);
        return zzrk;
    }

    public final /* synthetic */ int zzai(Object obj) {
        return ((zzts) obj).zzrl();
    }

    public final /* synthetic */ void zzb(Object obj, int i11, long j11) {
        ((zzts) obj).zzb((i11 << 3) | 1, Long.valueOf(j11));
    }

    public final /* synthetic */ void zzc(Object obj, zzum zzum) throws IOException {
        ((zzts) obj).zza(zzum);
    }

    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzts) obj2);
    }

    public final /* synthetic */ void zzg(Object obj, Object obj2) {
        zza(obj, (zzts) obj2);
    }

    public final /* synthetic */ Object zzh(Object obj, Object obj2) {
        zzts zzts = (zzts) obj;
        zzts zzts2 = (zzts) obj2;
        if (zzts2.equals(zzts.zzrj())) {
            return zzts;
        }
        return zzts.zza(zzts, zzts2);
    }

    public final /* synthetic */ Object zzri() {
        return zzts.zzrk();
    }

    public final void zzt(Object obj) {
        ((zzrc) obj).zzbak.zzmi();
    }

    public final /* synthetic */ void zza(Object obj, zzum zzum) throws IOException {
        ((zzts) obj).zzb(zzum);
    }

    public final /* synthetic */ void zzc(Object obj, int i11, int i12) {
        ((zzts) obj).zzb((i11 << 3) | 5, Integer.valueOf(i12));
    }

    public final /* synthetic */ void zza(Object obj, int i11, Object obj2) {
        ((zzts) obj).zzb((i11 << 3) | 3, (zzts) obj2);
    }

    public final /* synthetic */ void zza(Object obj, int i11, zzps zzps) {
        ((zzts) obj).zzb((i11 << 3) | 2, zzps);
    }

    public final /* synthetic */ void zza(Object obj, int i11, long j11) {
        ((zzts) obj).zzb(i11 << 3, Long.valueOf(j11));
    }
}
