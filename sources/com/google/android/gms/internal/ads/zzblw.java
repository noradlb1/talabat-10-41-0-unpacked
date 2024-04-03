package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@Deprecated
@ParametersAreNonnullByDefault
public final class zzblw {
    private final Map<String, zzblv> zza = new HashMap();
    private final zzbly zzb;

    public zzblw(zzbly zzbly) {
        this.zzb = zzbly;
    }

    public final zzbly zza() {
        return this.zzb;
    }

    public final void zzb(String str, @Nullable zzblv zzblv) {
        this.zza.put(str, zzblv);
    }

    public final void zzc(String str, String str2, long j11) {
        zzbly zzbly = this.zzb;
        zzblv zzblv = this.zza.get(str2);
        String[] strArr = {str};
        if (zzblv != null) {
            zzbly.zze(zzblv, j11, strArr);
        }
        this.zza.put(str, new zzblv(j11, (String) null, (zzblv) null));
    }
}
