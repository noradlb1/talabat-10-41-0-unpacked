package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zzul implements zzdi {
    private final zzdi zza;
    private long zzb;
    private Uri zzc = Uri.EMPTY;
    private Map<String, List<String>> zzd = Collections.emptyMap();

    public zzul(zzdi zzdi) {
        zzdi.getClass();
        this.zza = zzdi;
    }

    public final Map<String, List<String>> zza() {
        return this.zza.zza();
    }

    public final void zzb(zzdx zzdx) {
        zzdx.getClass();
        this.zza.zzb(zzdx);
    }

    public final long zzc() {
        return this.zzb;
    }

    public final Uri zzd() {
        return this.zzc;
    }

    public final Map<String, List<String>> zze() {
        return this.zzd;
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws IOException {
        int zzg = this.zza.zzg(bArr, i11, i12);
        if (zzg != -1) {
            this.zzb += (long) zzg;
        }
        return zzg;
    }

    public final long zzh(zzdm zzdm) throws IOException {
        this.zzc = zzdm.zza;
        this.zzd = Collections.emptyMap();
        long zzh = this.zza.zzh(zzdm);
        Uri zzi = zzi();
        zzi.getClass();
        this.zzc = zzi;
        this.zzd = zza();
        return zzh;
    }

    @Nullable
    public final Uri zzi() {
        return this.zza.zzi();
    }

    public final void zzj() throws IOException {
        this.zza.zzj();
    }
}
