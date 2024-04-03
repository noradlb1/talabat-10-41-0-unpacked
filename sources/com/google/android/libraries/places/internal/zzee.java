package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;

public interface zzee {
    Task<FetchPlaceResponse> zza(AutocompletePrediction autocompletePrediction);

    Task<FindAutocompletePredictionsResponse> zzb(String str);

    void zzc();
}
