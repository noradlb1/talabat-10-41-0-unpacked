package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzcz;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class FindCurrentPlaceRequest implements zzcz {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public FindCurrentPlaceRequest build() {
            zza(zzge.zzk(zzb().getPlaceFields()));
            return zzb();
        }

        @RecentlyNullable
        public abstract CancellationToken getCancellationToken();

        @RecentlyNonNull
        public abstract Builder setCancellationToken(@Nullable CancellationToken cancellationToken);

        public abstract Builder zza(List<Place.Field> list);

        public abstract FindCurrentPlaceRequest zzb();
    }

    @RecentlyNonNull
    public static Builder builder(@RecentlyNonNull List<Place.Field> list) {
        zzm zzm = new zzm();
        zzm.zza(list);
        return zzm;
    }

    @RecentlyNonNull
    public static FindCurrentPlaceRequest newInstance(@RecentlyNonNull List<Place.Field> list) {
        return builder(list).build();
    }

    @RecentlyNullable
    public abstract CancellationToken getCancellationToken();

    @RecentlyNonNull
    public abstract List<Place.Field> getPlaceFields();
}
