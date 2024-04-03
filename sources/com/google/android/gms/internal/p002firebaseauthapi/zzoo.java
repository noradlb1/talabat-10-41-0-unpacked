package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoo  reason: invalid package */
public final class zzoo {
    private final zzoh zza;
    private final List zzb;
    @Nullable
    private final Integer zzc;

    public /* synthetic */ zzoo(zzoh zzoh, List list, Integer num, zzon zzon) {
        this.zza = zzoh;
        this.zzb = list;
        this.zzc = num;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzoo)) {
            return false;
        }
        zzoo zzoo = (zzoo) obj;
        if (this.zza.equals(zzoo.zza) && this.zzb.equals(zzoo.zzb)) {
            Integer num = this.zzc;
            Integer num2 = zzoo.zzc;
            if (num == num2) {
                return true;
            }
            if (num == null || !num.equals(num2)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        return String.format("(annotations=%s, entries=%s, primaryKeyId=%s)", new Object[]{this.zza, this.zzb, this.zzc});
    }
}
