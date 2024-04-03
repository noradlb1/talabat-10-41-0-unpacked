package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import java.util.List;

final class zze extends FetchPlaceRequest.Builder {
    private String zza;
    private List<Place.Field> zzb;
    private AutocompleteSessionToken zzc;
    private CancellationToken zzd;

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzd;
    }

    @Nullable
    public final AutocompleteSessionToken getSessionToken() {
        return this.zzc;
    }

    public final FetchPlaceRequest.Builder setCancellationToken(@Nullable CancellationToken cancellationToken) {
        this.zzd = cancellationToken;
        return this;
    }

    public final FetchPlaceRequest.Builder setSessionToken(@Nullable AutocompleteSessionToken autocompleteSessionToken) {
        this.zzc = autocompleteSessionToken;
        return this;
    }

    public final FetchPlaceRequest.Builder zza(List<Place.Field> list) {
        if (list != null) {
            this.zzb = list;
            return this;
        }
        throw new NullPointerException("Null placeFields");
    }

    public final FetchPlaceRequest.Builder zzb(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null placeId");
    }

    public final FetchPlaceRequest zzc() {
        List<Place.Field> list;
        String str = this.zza;
        if (str != null && (list = this.zzb) != null) {
            return new zzg(str, list, this.zzc, this.zzd, (zzf) null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" placeId");
        }
        if (this.zzb == null) {
            sb2.append(" placeFields");
        }
        String valueOf = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 28);
        sb3.append("Missing required properties:");
        sb3.append(valueOf);
        throw new IllegalStateException(sb3.toString());
    }
}
