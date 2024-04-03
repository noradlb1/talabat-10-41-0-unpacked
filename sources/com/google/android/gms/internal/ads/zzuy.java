package com.google.android.gms.internal.ads;

import android.view.Surface;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

@RequiresApi(30)
final class zzuy {
    @DoNotInline
    public static void zza(Surface surface, float f11) {
        int i11;
        if (f11 == 0.0f) {
            i11 = 0;
        } else {
            i11 = 1;
        }
        try {
            surface.setFrameRate(f11, i11);
        } catch (IllegalStateException e11) {
            zzep.zza("VideoFrameReleaseHelper", "Failed to call Surface.setFrameRate", e11);
        }
    }
}
