package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompletePrediction;

public final /* synthetic */ class zzem implements OnCompleteListener {
    public final /* synthetic */ zzer zza;
    public final /* synthetic */ AutocompletePrediction zzb;

    public /* synthetic */ zzem(zzer zzer, AutocompletePrediction autocompletePrediction) {
        this.zza = zzer;
        this.zzb = autocompletePrediction;
    }

    public final void onComplete(Task task) {
        this.zza.zzc(this.zzb, task);
    }
}
