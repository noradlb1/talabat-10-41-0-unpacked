package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;
import androidx.annotation.Nullable;

final class zzva implements zzuz {
    private final WindowManager zza;

    private zzva(WindowManager windowManager) {
        this.zza = windowManager;
    }

    @Nullable
    public static zzuz zzc(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            return new zzva(windowManager);
        }
        return null;
    }

    public final void zza() {
    }

    public final void zzb(zzux zzux) {
        zzvd.zzb(zzux.zza, this.zza.getDefaultDisplay());
    }
}
