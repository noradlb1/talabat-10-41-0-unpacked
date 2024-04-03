package com.google.android.gms.analytics;

import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

public class zzj<T extends zzj> {
    private final zzk zzsn;
    protected final zzg zzso;
    private final List<zzh> zzsp = new ArrayList();

    @VisibleForTesting
    public zzj(zzk zzk, Clock clock) {
        Preconditions.checkNotNull(zzk);
        this.zzsn = zzk;
        zzg zzg = new zzg(this, clock);
        zzg.zzar();
        this.zzso = zzg;
    }

    public void zza(zzg zzg) {
    }

    public zzg zzac() {
        zzg zzai = this.zzso.zzai();
        zzd(zzai);
        return zzai;
    }

    public final zzk zzas() {
        return this.zzsn;
    }

    public final void zzd(zzg zzg) {
        for (zzh zza : this.zzsp) {
            zza.zza(this, zzg);
        }
    }
}
