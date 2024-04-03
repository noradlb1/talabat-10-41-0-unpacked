package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

public final /* synthetic */ class zzap implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzaw zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzap(zzaw zzaw, String str) {
        this.zza = zzaw;
        this.zzb = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.zzi(this.zzb, dialogInterface, i11);
    }
}
