package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzcam implements DialogInterface.OnClickListener {
    final /* synthetic */ zzcan zza;

    public zzcam(zzcan zzcan) {
        this.zza = zzcan;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.zzg("User canceled the download.");
    }
}
