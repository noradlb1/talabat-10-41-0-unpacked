package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzcok implements DialogInterface.OnCancelListener {
    final /* synthetic */ JsPromptResult zza;

    public zzcok(JsPromptResult jsPromptResult) {
        this.zza = jsPromptResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zza.cancel();
    }
}
