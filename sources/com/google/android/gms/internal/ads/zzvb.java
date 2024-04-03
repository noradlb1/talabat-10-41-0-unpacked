package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.view.Display;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(17)
final class zzvb implements DisplayManager.DisplayListener, zzuz {
    private final DisplayManager zza;
    @Nullable
    private zzux zzb;

    private zzvb(DisplayManager displayManager) {
        this.zza = displayManager;
    }

    @Nullable
    public static zzuz zzc(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager != null) {
            return new zzvb(displayManager);
        }
        return null;
    }

    private final Display zzd() {
        return this.zza.getDisplay(0);
    }

    public final void onDisplayAdded(int i11) {
    }

    public final void onDisplayChanged(int i11) {
        zzux zzux = this.zzb;
        if (zzux != null && i11 == 0) {
            zzvd.zzb(zzux.zza, zzd());
        }
    }

    public final void onDisplayRemoved(int i11) {
    }

    public final void zza() {
        this.zza.unregisterDisplayListener(this);
        this.zzb = null;
    }

    public final void zzb(zzux zzux) {
        this.zzb = zzux;
        this.zza.registerDisplayListener(this, zzfn.zzz((Handler.Callback) null));
        zzvd.zzb(zzux.zza, zzd());
    }
}
