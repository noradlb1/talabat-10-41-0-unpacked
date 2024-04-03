package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;

public final class zzaz {
    private Bitmap zza;

    public final zzbb zza() {
        boolean z11;
        if (this.zza != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfm.zzi(z11, "Photo must be set to non-null value.");
        return new zzbb(this.zza, (zzba) null);
    }

    public final zzaz zzb(Bitmap bitmap) {
        this.zza = bitmap;
        return this;
    }
}
