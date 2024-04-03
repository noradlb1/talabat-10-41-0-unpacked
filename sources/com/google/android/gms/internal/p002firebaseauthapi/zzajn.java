package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajn  reason: invalid package */
final class zzajn extends zzajl {
    public final /* synthetic */ int zza(Object obj) {
        return ((zzajm) obj).zza();
    }

    public final /* synthetic */ int zzb(Object obj) {
        return ((zzajm) obj).zzb();
    }

    public final /* bridge */ /* synthetic */ Object zzc(Object obj) {
        zzaha zzaha = (zzaha) obj;
        zzajm zzajm = zzaha.zzc;
        if (zzajm != zzajm.zzc()) {
            return zzajm;
        }
        zzajm zzf = zzajm.zzf();
        zzaha.zzc = zzf;
        return zzf;
    }

    public final /* synthetic */ Object zzd(Object obj) {
        return ((zzaha) obj).zzc;
    }

    public final /* bridge */ /* synthetic */ Object zze(Object obj, Object obj2) {
        if (zzajm.zzc().equals(obj2)) {
            return obj;
        }
        if (zzajm.zzc().equals(obj)) {
            return zzajm.zze((zzajm) obj, (zzajm) obj2);
        }
        ((zzajm) obj).zzd((zzajm) obj2);
        return obj;
    }

    public final /* synthetic */ Object zzf() {
        return zzajm.zzf();
    }

    public final /* synthetic */ Object zzg(Object obj) {
        ((zzajm) obj).zzh();
        return obj;
    }

    public final /* bridge */ /* synthetic */ void zzh(Object obj, int i11, int i12) {
        ((zzajm) obj).zzj((i11 << 3) | 5, Integer.valueOf(i12));
    }

    public final /* bridge */ /* synthetic */ void zzi(Object obj, int i11, long j11) {
        ((zzajm) obj).zzj((i11 << 3) | 1, Long.valueOf(j11));
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj, int i11, Object obj2) {
        ((zzajm) obj).zzj((i11 << 3) | 3, obj2);
    }

    public final /* bridge */ /* synthetic */ void zzk(Object obj, int i11, zzafv zzafv) {
        ((zzajm) obj).zzj((i11 << 3) | 2, zzafv);
    }

    public final /* bridge */ /* synthetic */ void zzl(Object obj, int i11, long j11) {
        ((zzajm) obj).zzj(i11 << 3, Long.valueOf(j11));
    }

    public final void zzm(Object obj) {
        ((zzaha) obj).zzc.zzh();
    }

    public final /* synthetic */ void zzn(Object obj, Object obj2) {
        ((zzaha) obj).zzc = (zzajm) obj2;
    }

    public final /* synthetic */ void zzo(Object obj, Object obj2) {
        ((zzaha) obj).zzc = (zzajm) obj2;
    }

    public final boolean zzq(zzaiq zzaiq) {
        return false;
    }

    public final /* synthetic */ void zzr(Object obj, zzagj zzagj) throws IOException {
        ((zzajm) obj).zzk(zzagj);
    }
}
