package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;

public final /* synthetic */ class zzas implements Continuation {
    public final /* synthetic */ zzav zza;
    public final /* synthetic */ FindCurrentPlaceRequest zzb;
    public final /* synthetic */ long zzc;
    public final /* synthetic */ zzk zzd;

    public /* synthetic */ zzas(zzav zzav, FindCurrentPlaceRequest findCurrentPlaceRequest, long j11, zzk zzk) {
        this.zza = zzav;
        this.zzb = findCurrentPlaceRequest;
        this.zzc = j11;
        this.zzd = zzk;
    }

    public final Object then(Task task) {
        return this.zza.zze(this.zzb, this.zzc, this.zzd, task);
    }
}
