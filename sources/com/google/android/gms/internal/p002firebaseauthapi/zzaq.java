package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Set;
import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaq  reason: invalid package */
public abstract class zzaq extends zzai implements Set {
    @CheckForNull
    private transient zzam zza;

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzay.zza(this);
    }

    /* renamed from: zzd */
    public abstract zzaz iterator();

    public final zzam zzf() {
        zzam zzam = this.zza;
        if (zzam != null) {
            return zzam;
        }
        zzam zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    public zzam zzg() {
        Object[] array = toArray();
        int i11 = zzam.zzd;
        return zzam.zzg(array, array.length);
    }
}
