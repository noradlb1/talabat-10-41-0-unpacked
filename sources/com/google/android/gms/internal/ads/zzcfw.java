package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

public final /* synthetic */ class zzcfw implements Runnable {
    public final /* synthetic */ zzcfz zza;
    public final /* synthetic */ Bitmap zzb;

    public /* synthetic */ zzcfw(zzcfz zzcfz, Bitmap bitmap) {
        this.zza = zzcfz;
        this.zzb = bitmap;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
