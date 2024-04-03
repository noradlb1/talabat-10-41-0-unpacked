package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzcol implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult zza;

    public zzcol(JsPromptResult jsPromptResult) {
        this.zza = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.cancel();
    }
}
