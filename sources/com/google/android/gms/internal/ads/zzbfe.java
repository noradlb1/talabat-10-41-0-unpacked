package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbfe {
    private Bundle zza = new Bundle();
    private List<String> zzb = new ArrayList();
    private boolean zzc = false;
    private int zzd = -1;
    private final Bundle zze = new Bundle();
    private final Bundle zzf = new Bundle();
    private final List<String> zzg = new ArrayList();
    private int zzh = -1;
    private String zzi = null;
    private final List<String> zzj = new ArrayList();
    private int zzk = 60000;

    public final zzbfd zza() {
        return new zzbfd(8, -1, this.zza, -1, this.zzb, this.zzc, this.zzd, false, (String) null, (zzbkm) null, (Location) null, (String) null, this.zze, this.zzf, this.zzg, (String) null, (String) null, false, (zzbeu) null, this.zzh, this.zzi, this.zzj, this.zzk, (String) null);
    }

    public final zzbfe zzb(Bundle bundle) {
        this.zza = bundle;
        return this;
    }

    public final zzbfe zzc(int i11) {
        this.zzk = i11;
        return this;
    }

    public final zzbfe zzd(boolean z11) {
        this.zzc = z11;
        return this;
    }

    public final zzbfe zze(List<String> list) {
        this.zzb = list;
        return this;
    }

    public final zzbfe zzf(String str) {
        this.zzi = str;
        return this;
    }

    public final zzbfe zzg(int i11) {
        this.zzd = i11;
        return this;
    }

    public final zzbfe zzh(int i11) {
        this.zzh = i11;
        return this;
    }
}
