package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzt;

final class zzcag implements DialogInterface.OnClickListener {
    final /* synthetic */ zzcai zza;

    public zzcag(zzcai zzcai) {
        this.zza = zzcai;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        Intent zzb = this.zza.zzb();
        zzt.zzp();
        com.google.android.gms.ads.internal.util.zzt.zzQ(this.zza.zzb, zzb);
    }
}
