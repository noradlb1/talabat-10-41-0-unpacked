package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zze;

public final class zzt extends zzl {
    public zzt(Activity activity) {
        super(activity);
    }

    public final void zzk(@Nullable Bundle bundle) {
        zze.zza("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzn = 4;
        this.zzb.finish();
    }
}
