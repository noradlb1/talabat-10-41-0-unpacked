package com.google.android.gms.location.places;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.location.places.internal.zzh;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.tasks.Task;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
public class GeoDataClient extends GoogleApi<PlacesOptions> {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoundsMode {
        public static final int BIAS = 1;
        public static final int STRICT = 2;
    }

    public GeoDataClient(@NonNull Context context, @NonNull PlacesOptions placesOptions) {
        super(context, Places.GEO_DATA_API, placesOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    @Deprecated
    public Task<PlaceBufferResponse> addPlace(@NonNull AddPlaceRequest addPlaceRequest) {
        return PendingResultUtil.toResponseTask(Places.GeoDataApi.addPlace(asGoogleApiClient(), addPlaceRequest), new PlaceBufferResponse());
    }

    public Task<AutocompletePredictionBufferResponse> getAutocompletePredictions(@Nullable String str, @Nullable LatLngBounds latLngBounds, int i11, @Nullable AutocompleteFilter autocompleteFilter) {
        return PendingResultUtil.toResponseTask(((zzh) Places.GeoDataApi).zzb(asGoogleApiClient(), str, latLngBounds, i11, autocompleteFilter), new AutocompletePredictionBufferResponse());
    }

    public Task<PlacePhotoResponse> getPhoto(@NonNull PlacePhotoMetadata placePhotoMetadata) {
        return getScaledPhoto(placePhotoMetadata, placePhotoMetadata.getMaxWidth(), placePhotoMetadata.getMaxHeight());
    }

    public Task<PlaceBufferResponse> getPlaceById(@NonNull String... strArr) {
        return PendingResultUtil.toResponseTask(Places.GeoDataApi.getPlaceById(asGoogleApiClient(), strArr), new PlaceBufferResponse());
    }

    public Task<PlacePhotoMetadataResponse> getPlacePhotos(@NonNull String str) {
        return PendingResultUtil.toResponseTask(Places.GeoDataApi.getPlacePhotos(asGoogleApiClient(), str), new PlacePhotoMetadataResponse());
    }

    public Task<PlacePhotoResponse> getScaledPhoto(@NonNull PlacePhotoMetadata placePhotoMetadata, @IntRange(from = 1) int i11, @IntRange(from = 1) int i12) {
        return PendingResultUtil.toResponseTask(((zzh) Places.GeoDataApi).zzb(asGoogleApiClient(), placePhotoMetadata, i11, i12), new PlacePhotoResponse());
    }

    public GeoDataClient(@NonNull Activity activity, @NonNull PlacesOptions placesOptions) {
        super(activity, Places.GEO_DATA_API, placesOptions, (StatusExceptionMapper) new ApiExceptionMapper());
    }

    public Task<AutocompletePredictionBufferResponse> getAutocompletePredictions(@Nullable String str, @Nullable LatLngBounds latLngBounds, @Nullable AutocompleteFilter autocompleteFilter) {
        return getAutocompletePredictions(str, latLngBounds, 1, autocompleteFilter);
    }
}
