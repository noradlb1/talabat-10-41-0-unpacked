package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.internal.vision.zzea;
import com.google.android.gms.vision.L;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Keep
public class DynamiteClearcutLogger {
    private static final ThreadPoolExecutor zzbn = new ThreadPoolExecutor(1, 2, 2, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new ThreadPoolExecutor.DiscardPolicy());
    private zzb zzbo = new zzb(0.03333333333333333d);
    /* access modifiers changed from: private */
    public VisionClearcutLogger zzbp;

    public DynamiteClearcutLogger(Context context) {
        this.zzbp = new VisionClearcutLogger(context);
    }

    public final void zza(int i11, zzea.zzo zzo) {
        if (i11 != 3 || this.zzbo.tryAcquire()) {
            zzbn.execute(new zza(this, i11, zzo));
        } else {
            L.v("Skipping image analysis log due to rate limiting", new Object[0]);
        }
    }
}
