package com.google.android.gms.ads.internal.util;

import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;

public final /* synthetic */ class zzaq implements DialogInterface.OnClickListener {
    public final /* synthetic */ zzaw zza;
    public final /* synthetic */ AtomicInteger zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ int zzd;
    public final /* synthetic */ int zze;

    public /* synthetic */ zzaq(zzaw zzaw, AtomicInteger atomicInteger, int i11, int i12, int i13) {
        this.zza = zzaw;
        this.zzb = atomicInteger;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = i13;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        this.zza.zzh(this.zzb, this.zzc, this.zzd, this.zze, dialogInterface, i11);
    }
}
