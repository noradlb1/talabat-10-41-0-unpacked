package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzcwl implements zzdfm {
    private final zzfev zza;

    public zzcwl(zzfev zzfev) {
        this.zza = zzfev;
    }

    public final void zzbA(@Nullable Context context) {
        try {
            this.zza.zzs();
        } catch (zzfek e11) {
            zzciz.zzk("Cannot invoke onPause for the mediation adapter.", e11);
        }
    }

    public final void zzbB(@Nullable Context context) {
        try {
            this.zza.zzt();
            if (context != null) {
                this.zza.zzr(context);
            }
        } catch (zzfek e11) {
            zzciz.zzk("Cannot invoke onResume for the mediation adapter.", e11);
        }
    }

    public final void zzby(@Nullable Context context) {
        try {
            this.zza.zzg();
        } catch (zzfek e11) {
            zzciz.zzk("Cannot invoke onDestroy for the mediation adapter.", e11);
        }
    }
}
