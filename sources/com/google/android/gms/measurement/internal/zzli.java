package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

@VisibleForTesting
public final class zzli {
    final Context zza;

    @VisibleForTesting
    public zzli(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zza = applicationContext;
    }
}
