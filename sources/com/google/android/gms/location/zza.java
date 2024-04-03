package com.google.android.gms.location;

import android.os.WorkSource;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

@ShowFirstParty
public final class zza {
    private long zza = Long.MIN_VALUE;

    public final zza zza(long j11) {
        boolean z11;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "intervalMillis can't be negative.");
        this.zza = j11;
        return this;
    }

    public final zzb zzb() {
        boolean z11;
        if (this.zza != Long.MIN_VALUE) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "Must set intervalMillis.");
        return new zzb(this.zza, true, (WorkSource) null, (String) null, (int[]) null, false, (String) null, 0, (String) null);
    }
}
