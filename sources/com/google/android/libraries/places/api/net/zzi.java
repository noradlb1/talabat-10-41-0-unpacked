package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import java.util.List;

final class zzi extends FindAutocompletePredictionsRequest.Builder {
    private String zza;
    private LocationBias zzb;
    private LocationRestriction zzc;
    private LatLng zzd;
    private List<String> zze;
    private AutocompleteSessionToken zzf;
    private TypeFilter zzg;
    private CancellationToken zzh;

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzh;
    }

    public final List<String> getCountries() {
        List<String> list = this.zze;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("Property \"countries\" has not been set");
    }

    @Nullable
    public final LocationBias getLocationBias() {
        return this.zzb;
    }

    @Nullable
    public final LocationRestriction getLocationRestriction() {
        return this.zzc;
    }

    @Nullable
    public final LatLng getOrigin() {
        return this.zzd;
    }

    @Nullable
    public final String getQuery() {
        return this.zza;
    }

    @Nullable
    public final AutocompleteSessionToken getSessionToken() {
        return this.zzf;
    }

    @Nullable
    public final TypeFilter getTypeFilter() {
        return this.zzg;
    }

    public final FindAutocompletePredictionsRequest.Builder setCancellationToken(@Nullable CancellationToken cancellationToken) {
        this.zzh = cancellationToken;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setCountries(List<String> list) {
        if (list != null) {
            this.zze = list;
            return this;
        }
        throw new NullPointerException("Null countries");
    }

    public final FindAutocompletePredictionsRequest.Builder setLocationBias(@Nullable LocationBias locationBias) {
        this.zzb = locationBias;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setLocationRestriction(@Nullable LocationRestriction locationRestriction) {
        this.zzc = locationRestriction;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setOrigin(@Nullable LatLng latLng) {
        this.zzd = latLng;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setQuery(@Nullable String str) {
        this.zza = str;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setSessionToken(@Nullable AutocompleteSessionToken autocompleteSessionToken) {
        this.zzf = autocompleteSessionToken;
        return this;
    }

    public final FindAutocompletePredictionsRequest.Builder setTypeFilter(@Nullable TypeFilter typeFilter) {
        this.zzg = typeFilter;
        return this;
    }

    public final FindAutocompletePredictionsRequest zza() {
        List<String> list = this.zze;
        if (list != null) {
            return new zzk(this.zza, this.zzb, this.zzc, this.zzd, list, this.zzf, this.zzg, this.zzh, (zzj) null);
        }
        throw new IllegalStateException("Missing required properties: countries");
    }
}
