package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public final class zzfkp {
    private static final zzfkp zza = new zzfkp();
    private final ArrayList<zzfke> zzb = new ArrayList<>();
    private final ArrayList<zzfke> zzc = new ArrayList<>();

    private zzfkp() {
    }

    public static zzfkp zza() {
        return zza;
    }

    public final Collection<zzfke> zzb() {
        return Collections.unmodifiableCollection(this.zzc);
    }

    public final Collection<zzfke> zzc() {
        return Collections.unmodifiableCollection(this.zzb);
    }

    public final void zzd(zzfke zzfke) {
        this.zzb.add(zzfke);
    }

    public final void zze(zzfke zzfke) {
        boolean zzg = zzg();
        this.zzb.remove(zzfke);
        this.zzc.remove(zzfke);
        if (zzg && !zzg()) {
            zzfkw.zzb().zzf();
        }
    }

    public final void zzf(zzfke zzfke) {
        boolean zzg = zzg();
        this.zzc.add(zzfke);
        if (!zzg) {
            zzfkw.zzb().zze();
        }
    }

    public final boolean zzg() {
        return this.zzc.size() > 0;
    }
}
