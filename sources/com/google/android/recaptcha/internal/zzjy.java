package com.google.android.recaptcha.internal;

import java.io.IOException;

final class zzjy extends zzjw {
    public final /* synthetic */ int zza(Object obj) {
        return ((zzjx) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zzjx) obj).zzb();
    }

    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzhf zzhf = (zzhf) obj;
        zzjx zzjx = zzhf.zzc;
        if (zzjx != zzjx.zzc()) {
            return zzjx;
        }
        zzjx zzf = zzjx.zzf();
        zzhf.zzc = zzf;
        return zzf;
    }

    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzhf) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzjx.zzc().equals(obj2)) {
            return obj;
        }
        if (zzjx.zzc().equals(obj)) {
            return zzjx.zze((zzjx) obj, (zzjx) obj2);
        }
        ((zzjx) obj).zzd((zzjx) obj2);
        return obj;
    }

    public final /* synthetic */ Object zzf() {
        return zzjx.zzf();
    }

    public final /* synthetic */ Object zzg(Object obj) {
        ((zzjx) obj).zzh();
        return obj;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj, int i11, int i12) {
        ((zzjx) obj).zzj((i11 << 3) | 5, Integer.valueOf(i12));
    }

    public final /* bridge */ /* synthetic */ void zzi(Object obj, int i11, long j11) {
        ((zzjx) obj).zzj((i11 << 3) | 1, Long.valueOf(j11));
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, int i11, Object obj2) {
        ((zzjx) obj).zzj((i11 << 3) | 3, obj2);
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i11, zzfi zzfi) {
        ((zzjx) obj).zzj((i11 << 3) | 2, zzfi);
    }

    public final /* bridge */ /* synthetic */ void zzl(Object obj, int i11, long j11) {
        ((zzjx) obj).zzj(i11 << 3, Long.valueOf(j11));
    }

    public final void zzm(Object obj) {
        ((zzhf) obj).zzc.zzh();
    }

    public final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzhf) obj).zzc = (zzjx) obj2;
    }

    public final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzhf) obj).zzc = (zzjx) obj2;
    }

    public final /* synthetic */ void zzp(Object obj, zzko zzko) throws IOException {
        ((zzjx) obj).zzk(zzko);
    }

    public final /* synthetic */ void zzq(Object obj, zzko zzko) throws IOException {
        ((zzjx) obj).zzl(zzko);
    }

    public final boolean zzs(zzjb zzjb) {
        return false;
    }
}
