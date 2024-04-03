package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahr  reason: invalid package */
final class zzahr extends zzaht {
    private zzahr() {
        super((zzahs) null);
    }

    public /* synthetic */ zzahr(zzahq zzahq) {
        super((zzahs) null);
    }

    public final List zza(Object obj, long j11) {
        int i11;
        zzahf zzahf = (zzahf) zzajv.zzf(obj, j11);
        if (zzahf.zzc()) {
            return zzahf;
        }
        int size = zzahf.size();
        if (size == 0) {
            i11 = 10;
        } else {
            i11 = size + size;
        }
        zzahf zzd = zzahf.zzd(i11);
        zzajv.zzs(obj, j11, zzd);
        return zzd;
    }

    public final void zzb(Object obj, long j11) {
        ((zzahf) zzajv.zzf(obj, j11)).zzb();
    }

    public final void zzc(Object obj, Object obj2, long j11) {
        zzahf zzahf = (zzahf) zzajv.zzf(obj, j11);
        zzahf zzahf2 = (zzahf) zzajv.zzf(obj2, j11);
        int size = zzahf.size();
        int size2 = zzahf2.size();
        if (size > 0 && size2 > 0) {
            if (!zzahf.zzc()) {
                zzahf = zzahf.zzd(size2 + size);
            }
            zzahf.addAll(zzahf2);
        }
        if (size > 0) {
            zzahf2 = zzahf;
        }
        zzajv.zzs(obj, j11, zzahf2);
    }
}
