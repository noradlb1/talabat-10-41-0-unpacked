package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;
import android.widget.EditText;

final class zzcom implements DialogInterface.OnClickListener {
    final /* synthetic */ JsPromptResult zza;
    final /* synthetic */ EditText zzb;

    public zzcom(JsPromptResult jsPromptResult, EditText editText) {
        this.zza = jsPromptResult;
        this.zzb = editText;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.confirm(this.zzb.getText().toString());
    }
}
