package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzcz;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class FetchPlaceRequest implements zzcz {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public FetchPlaceRequest build() {
            zza(zzge.zzk(zzc().getPlaceFields()));
            return zzc();
        }

        @RecentlyNullable
        public abstract CancellationToken getCancellationToken();

        @RecentlyNullable
        public abstract AutocompleteSessionToken getSessionToken();

        @RecentlyNonNull
        public abstract Builder setCancellationToken(@Nullable CancellationToken cancellationToken);

        @RecentlyNonNull
        public abstract Builder setSessionToken(@Nullable AutocompleteSessionToken autocompleteSessionToken);

        public abstract Builder zza(List<Place.Field> list);

        public abstract FetchPlaceRequest zzc();
    }

    @RecentlyNonNull
    public static Builder builder(@RecentlyNonNull String str, @RecentlyNonNull List<Place.Field> list) {
        zze zze = new zze();
        zze.zzb(str);
        zze.zza(list);
        return zze;
    }

    @RecentlyNonNull
    public static FetchPlaceRequest newInstance(@RecentlyNonNull String str, @RecentlyNonNull List<Place.Field> list) {
        return builder(str, list).build();
    }

    @RecentlyNullable
    public abstract CancellationToken getCancellationToken();

    @RecentlyNonNull
    public abstract List<Place.Field> getPlaceFields();

    @RecentlyNonNull
    public abstract String getPlaceId();

    @RecentlyNullable
    public abstract AutocompleteSessionToken getSessionToken();
}
