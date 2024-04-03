package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

public final /* synthetic */ class zzab implements View.OnApplyWindowInsetsListener {
    public final /* synthetic */ zzac zza;
    public final /* synthetic */ Activity zzb;

    public /* synthetic */ zzab(zzac zzac, Activity activity) {
        this.zza = zzac;
        this.zzb = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzac.zzs(this.zzb, view, windowInsets);
    }
}
