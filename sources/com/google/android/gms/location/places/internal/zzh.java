package com.google.android.gms.location.places.internal;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.AutocompletePredictionBuffer;
import com.google.android.gms.location.places.GeoDataApi;
import com.google.android.gms.location.places.PlaceBuffer;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoMetadataResult;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.model.LatLngBounds;

public final class zzh implements GeoDataApi {
    public final PendingResult<PlaceBuffer> addPlace(@NonNull GoogleApiClient googleApiClient, @NonNull AddPlaceRequest addPlaceRequest) {
        Preconditions.checkNotNull(addPlaceRequest, "userAddedPlace == null");
        return googleApiClient.execute(new zzk(this, Places.GEO_DATA_API, googleApiClient, addPlaceRequest));
    }

    public final PendingResult<AutocompletePredictionBuffer> getAutocompletePredictions(@NonNull GoogleApiClient googleApiClient, @Nullable String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter) {
        return googleApiClient.enqueue(new zzn(this, Places.GEO_DATA_API, googleApiClient, str, latLngBounds, autocompleteFilter));
    }

    public final PendingResult<PlaceBuffer> getPlaceById(@NonNull GoogleApiClient googleApiClient, @NonNull String... strArr) {
        boolean z11;
        boolean z12;
        boolean z13;
        if (strArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "placeIds == null");
        if (strArr.length > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        Preconditions.checkArgument(z12, "placeIds is empty");
        for (String str : strArr) {
            if (str != null) {
                z13 = true;
            } else {
                z13 = false;
            }
            Preconditions.checkArgument(z13, "placeId == null");
            Preconditions.checkArgument(!str.isEmpty(), "placeId is empty");
        }
        return googleApiClient.enqueue(new zzl(this, Places.GEO_DATA_API, googleApiClient, strArr));
    }

    public final PendingResult<PlacePhotoMetadataResult> getPlacePhotos(@NonNull GoogleApiClient googleApiClient, @NonNull String str) {
        Preconditions.checkNotNull(str, "placeId == null");
        Preconditions.checkArgument(!str.isEmpty(), "placeId is empty");
        return googleApiClient.enqueue(new zzj(this, Places.GEO_DATA_API, googleApiClient, str));
    }

    public final PendingResult<AutocompletePredictionBuffer> zzb(GoogleApiClient googleApiClient, @Nullable String str, @Nullable LatLngBounds latLngBounds, int i11, @Nullable AutocompleteFilter autocompleteFilter) {
        return googleApiClient.enqueue(new zzo(this, Places.GEO_DATA_API, googleApiClient, str, latLngBounds, i11, autocompleteFilter));
    }

    public final PendingResult<PlacePhotoResult> zzb(@NonNull GoogleApiClient googleApiClient, @NonNull PlacePhotoMetadata placePhotoMetadata, @IntRange(from = 1) int i11, @IntRange(from = 1) int i12) {
        Preconditions.checkNotNull(placePhotoMetadata, "photo == null");
        boolean z11 = true;
        Preconditions.checkArgument(i11 > 0, "width <= 0");
        if (i12 <= 0) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "height <= 0");
        zzap zzap = (zzap) placePhotoMetadata.freeze();
        String zzk = zzap.zzk();
        int index = zzap.getIndex();
        Preconditions.checkNotNull(zzk, "fifeUrl == null");
        return googleApiClient.enqueue(new zzm(this, Places.GEO_DATA_API, googleApiClient, zzk, i11, i12, index));
    }
}
