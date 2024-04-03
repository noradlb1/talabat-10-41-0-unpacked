package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import java.util.LinkedList;

final class zzffm {
    private final LinkedList<zzffw<?, ?>> zza = new LinkedList<>();
    private final int zzb;
    private final int zzc;
    private final zzfgl zzd;

    public zzffm(int i11, int i12) {
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = new zzfgl();
    }

    private final void zzi() {
        while (!this.zza.isEmpty() && zzt.zzA().currentTimeMillis() - this.zza.getFirst().zzd >= ((long) this.zzc)) {
            this.zzd.zzg();
            this.zza.remove();
        }
    }

    public final int zza() {
        return this.zzd.zza();
    }

    public final int zzb() {
        zzi();
        return this.zza.size();
    }

    public final long zzc() {
        return this.zzd.zzb();
    }

    public final long zzd() {
        return this.zzd.zzc();
    }

    public final zzffw<?, ?> zze() {
        this.zzd.zzf();
        zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzffw<?, ?> remove = this.zza.remove();
        if (remove != null) {
            this.zzd.zzh();
        }
        return remove;
    }

    public final zzfgk zzf() {
        return this.zzd.zzd();
    }

    public final String zzg() {
        return this.zzd.zze();
    }

    public final boolean zzh(zzffw<?, ?> zzffw) {
        this.zzd.zzf();
        zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzffw);
        return true;
    }
}
