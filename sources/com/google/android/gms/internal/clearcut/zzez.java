package com.google.android.gms.internal.clearcut;

import java.io.IOException;

final class zzez extends zzex<zzey, zzey> {
    private static void zza(Object obj, zzey zzey) {
        ((zzcg) obj).zzjp = zzey;
    }

    public final /* synthetic */ void zza(Object obj, int i11, long j11) {
        ((zzey) obj).zzb(i11 << 3, Long.valueOf(j11));
    }

    public final /* synthetic */ void zza(Object obj, int i11, zzbb zzbb) {
        ((zzey) obj).zzb((i11 << 3) | 2, zzbb);
    }

    public final /* synthetic */ void zza(Object obj, zzfr zzfr) throws IOException {
        ((zzey) obj).zzb(zzfr);
    }

    public final void zzc(Object obj) {
        ((zzcg) obj).zzjp.zzv();
    }

    public final /* synthetic */ void zzc(Object obj, zzfr zzfr) throws IOException {
        ((zzey) obj).zza(zzfr);
    }

    public final /* synthetic */ Object zzdz() {
        return zzey.zzeb();
    }

    public final /* synthetic */ void zze(Object obj, Object obj2) {
        zza(obj, (zzey) obj2);
    }

    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzey) obj2);
    }

    public final /* synthetic */ Object zzg(Object obj, Object obj2) {
        zzey zzey = (zzey) obj;
        zzey zzey2 = (zzey) obj2;
        return zzey2.equals(zzey.zzea()) ? zzey : zzey.zza(zzey, zzey2);
    }

    public final /* synthetic */ int zzm(Object obj) {
        return ((zzey) obj).zzas();
    }

    public final /* synthetic */ Object zzq(Object obj) {
        return ((zzcg) obj).zzjp;
    }

    public final /* synthetic */ int zzr(Object obj) {
        return ((zzey) obj).zzec();
    }
}
