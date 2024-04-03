package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzau  reason: invalid package */
final class zzau extends zzaq {
    private final transient zzap zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    /* access modifiers changed from: private */
    public final transient int zzc;

    public zzau(zzap zzap, Object[] objArr, int i11, int i12) {
        this.zza = zzap;
        this.zzb = objArr;
        this.zzc = i12;
    }

    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzf().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i11) {
        return zzf().zza(objArr, 0);
    }

    public final zzaz zzd() {
        return zzf().listIterator(0);
    }

    public final zzam zzg() {
        return new zzat(this);
    }
}
