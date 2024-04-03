package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;

public interface zzcx {
    void zza(FetchPhotoRequest fetchPhotoRequest);

    void zzb(Task<FetchPhotoResponse> task, long j11, long j12);

    void zzc(FetchPlaceRequest fetchPlaceRequest);

    void zzd(Task<FetchPlaceResponse> task, long j11, long j12);

    void zze(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest);

    void zzf(Task<FindAutocompletePredictionsResponse> task, long j11, long j12);

    void zzg(FindCurrentPlaceRequest findCurrentPlaceRequest, Task<FindCurrentPlaceResponse> task, long j11, long j12);

    void zzh(Task<FindCurrentPlaceResponse> task, long j11, long j12);
}
