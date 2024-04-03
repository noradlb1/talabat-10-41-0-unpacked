package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public final class zzaf {
    @Nullable
    private String zza;
    @Nullable
    private Uri zzb;
    private final zzah zzc = new zzah();
    private final zzan zzd = new zzan((zzam) null);
    private final List zze = Collections.emptyList();
    private final zzfss<zzax> zzf = zzfss.zzo();
    private final zzaq zzg = new zzaq();

    public final zzaf zza(String str) {
        this.zza = str;
        return this;
    }

    public final zzaf zzb(@Nullable Uri uri) {
        this.zzb = uri;
        return this;
    }

    public final zzaz zzc() {
        zzaw zzaw;
        Uri uri = this.zzb;
        if (uri != null) {
            zzaw = new zzaw(uri, (String) null, (zzao) null, (zzae) null, this.zze, (String) null, this.zzf, (Object) null, (zzav) null);
        } else {
            zzaw = null;
        }
        String str = this.zza;
        if (str == null) {
            str = "";
        }
        return new zzaz(str, new zzal(this.zzc, (zzak) null), zzaw, new zzas(this.zzg), zzbe.zza, (zzay) null);
    }
}
