package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzcoj implements DialogInterface.OnClickListener {
    final /* synthetic */ JsResult zza;

    public zzcoj(JsResult jsResult) {
        this.zza = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.confirm();
    }
}
