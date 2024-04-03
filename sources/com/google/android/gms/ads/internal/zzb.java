package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.internal.ads.zzcde;
import com.google.android.gms.internal.ads.zzcgf;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzb {
    private final Context zza;
    private boolean zzb;
    @Nullable
    private final zzcgf zzc;
    private final zzcde zzd = new zzcde(false, Collections.emptyList());

    public zzb(Context context, @Nullable zzcgf zzcgf, @Nullable zzcde zzcde) {
        this.zza = context;
        this.zzc = zzcgf;
    }

    private final boolean zzd() {
        zzcgf zzcgf = this.zzc;
        return (zzcgf != null && zzcgf.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(@Nullable String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzcgf zzcgf = this.zzc;
            if (zzcgf != null) {
                zzcgf.zzd(str, (Map<String, String>) null, 3);
                return;
            }
            zzcde zzcde = this.zzd;
            if (zzcde.zza && (list = zzcde.zzb) != null) {
                for (String next : list) {
                    if (!TextUtils.isEmpty(next)) {
                        String replace = next.replace("{NAVIGATION_URL}", Uri.encode(str));
                        zzt.zzp();
                        zzt.zzO(this.zza, "", replace);
                    }
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
