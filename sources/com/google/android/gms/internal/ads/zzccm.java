package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public final class zzccm {
    /* access modifiers changed from: private */
    @Nonnull
    public View zza;
    /* access modifiers changed from: private */
    public final Map<String, WeakReference<View>> zzb = new HashMap();

    public final zzccm zzb(View view) {
        this.zza = view;
        return this;
    }

    public final zzccm zzc(Map<String, View> map) {
        this.zzb.clear();
        for (Map.Entry next : map.entrySet()) {
            View view = (View) next.getValue();
            if (view != null) {
                this.zzb.put((String) next.getKey(), new WeakReference(view));
            }
        }
        return this;
    }
}
