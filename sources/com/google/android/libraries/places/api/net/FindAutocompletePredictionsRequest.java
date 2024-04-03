package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzcz;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@AutoValue
public abstract class FindAutocompletePredictionsRequest implements zzcz {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public FindAutocompletePredictionsRequest build() {
            setCountries((List<String>) zzge.zzk(getCountries()));
            return zza();
        }

        @RecentlyNullable
        public abstract CancellationToken getCancellationToken();

        @RecentlyNonNull
        public abstract List<String> getCountries();

        @RecentlyNullable
        public abstract LocationBias getLocationBias();

        @RecentlyNullable
        public abstract LocationRestriction getLocationRestriction();

        @RecentlyNullable
        public abstract LatLng getOrigin();

        @RecentlyNullable
        public abstract String getQuery();

        @RecentlyNullable
        public abstract AutocompleteSessionToken getSessionToken();

        @RecentlyNullable
        public abstract TypeFilter getTypeFilter();

        @RecentlyNonNull
        public abstract Builder setCancellationToken(@Nullable CancellationToken cancellationToken);

        @RecentlyNonNull
        public abstract Builder setCountries(@RecentlyNonNull List<String> list);

        @RecentlyNonNull
        public Builder setCountries(@RecentlyNonNull String... strArr) {
            return setCountries((List<String>) zzge.zzl(strArr));
        }

        @RecentlyNonNull
        public Builder setCountry(@Nullable String str) {
            setCountries((List<String>) str == null ? zzge.zzm() : zzge.zzn(str));
            return this;
        }

        @RecentlyNonNull
        public abstract Builder setLocationBias(@Nullable LocationBias locationBias);

        @RecentlyNonNull
        public abstract Builder setLocationRestriction(@Nullable LocationRestriction locationRestriction);

        @RecentlyNonNull
        public abstract Builder setOrigin(@Nullable LatLng latLng);

        @RecentlyNonNull
        public abstract Builder setQuery(@Nullable String str);

        @RecentlyNonNull
        public abstract Builder setSessionToken(@Nullable AutocompleteSessionToken autocompleteSessionToken);

        @RecentlyNonNull
        public abstract Builder setTypeFilter(@Nullable TypeFilter typeFilter);

        public abstract FindAutocompletePredictionsRequest zza();
    }

    @RecentlyNonNull
    public static Builder builder() {
        zzi zzi = new zzi();
        zzi.setCountries(new ArrayList());
        return zzi;
    }

    @RecentlyNonNull
    public static FindAutocompletePredictionsRequest newInstance(@Nullable String str) {
        Builder builder = builder();
        builder.setQuery(str);
        return builder.build();
    }

    @RecentlyNullable
    public abstract CancellationToken getCancellationToken();

    @RecentlyNonNull
    public abstract List<String> getCountries();

    @RecentlyNullable
    public String getCountry() {
        T t11;
        if (getCountries().size() <= 1) {
            Iterator<T> it = getCountries().iterator();
            if (it.hasNext()) {
                t11 = it.next();
            } else {
                t11 = null;
            }
            return (String) t11;
        }
        throw new UnsupportedOperationException("Multiple countries found in this request - use getCountries() instead of getCountry().");
    }

    @RecentlyNullable
    public abstract LocationBias getLocationBias();

    @RecentlyNullable
    public abstract LocationRestriction getLocationRestriction();

    @RecentlyNullable
    public abstract LatLng getOrigin();

    @RecentlyNullable
    public abstract String getQuery();

    @RecentlyNullable
    public abstract AutocompleteSessionToken getSessionToken();

    @RecentlyNullable
    public abstract TypeFilter getTypeFilter();
}
