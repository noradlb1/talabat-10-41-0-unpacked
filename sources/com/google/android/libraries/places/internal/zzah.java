package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import com.android.volley.Response;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zzah implements Response.Listener {
    public final /* synthetic */ TaskCompletionSource zza;
    public final /* synthetic */ zzaz zzb;

    public /* synthetic */ zzah(zzaz zzaz, TaskCompletionSource taskCompletionSource, byte[] bArr) {
        this.zzb = zzaz;
        this.zza = taskCompletionSource;
    }

    public final void onResponse(Object obj) {
        zzak.zzc(this.zzb, this.zza, (Bitmap) obj);
    }
}
