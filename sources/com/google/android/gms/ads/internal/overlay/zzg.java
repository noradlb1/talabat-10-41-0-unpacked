package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzaw;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzg extends RelativeLayout {
    @VisibleForTesting
    final zzaw zza;
    @VisibleForTesting
    boolean zzb;

    public zzg(Context context, String str, String str2, String str3) {
        super(context);
        zzaw zzaw = new zzaw(context, str);
        this.zza = zzaw;
        zzaw.zzo(str2);
        zzaw.zzn(str3);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzb) {
            return false;
        }
        this.zza.zzm(motionEvent);
        return false;
    }
}
