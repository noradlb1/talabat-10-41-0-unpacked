package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;

public final /* synthetic */ class zzao implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzaw zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ int zzf;

    public /* synthetic */ zzao(zzaw zzaw, int i11, int i12, int i13, int i14, int i15) {
        this.zza = zzaw;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = i15;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.zzj(this.zzb, this.zzc, this.zzd, this.zze, this.zzf, dialogInterface, i11);
    }
}
