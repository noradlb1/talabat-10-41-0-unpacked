package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzcoh implements DialogInterface.OnCancelListener {
    final /* synthetic */ JsResult zza;

    public zzcoh(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.cancel();
    }
}
