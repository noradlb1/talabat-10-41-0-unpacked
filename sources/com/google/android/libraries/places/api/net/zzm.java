package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import java.util.List;

final class zzm extends FindCurrentPlaceRequest.Builder {
    private List<Place.Field> zza;
    private CancellationToken zzb;

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzb;
    }

    public final FindCurrentPlaceRequest.Builder setCancellationToken(@Nullable CancellationToken cancellationToken) {
        this.zzb = cancellationToken;
        return this;
    }

    public final FindCurrentPlaceRequest.Builder zza(List<Place.Field> list) {
        if (list != null) {
            this.zza = list;
            return this;
        }
        throw new NullPointerException("Null placeFields");
    }

    public final FindCurrentPlaceRequest zzb() {
        List<Place.Field> list = this.zza;
        if (list != null) {
            return new zzo(list, this.zzb, (zzn) null);
        }
        throw new IllegalStateException("Missing required properties: placeFields");
    }
}
