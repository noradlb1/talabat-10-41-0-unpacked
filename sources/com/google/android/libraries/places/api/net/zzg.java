package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

final class zzg extends FetchPlaceRequest {
    private final String zza;
    private final List<Place.Field> zzb;
    private final AutocompleteSessionToken zzc;
    private final CancellationToken zzd;

    public /* synthetic */ zzg(String str, List list, AutocompleteSessionToken autocompleteSessionToken, CancellationToken cancellationToken, zzf zzf) {
        this.zza = str;
        this.zzb = list;
        this.zzc = autocompleteSessionToken;
        this.zzd = cancellationToken;
    }

    public final boolean equals(Object obj) {
        AutocompleteSessionToken autocompleteSessionToken;
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPlaceRequest) {
            FetchPlaceRequest fetchPlaceRequest = (FetchPlaceRequest) obj;
            if (!this.zza.equals(fetchPlaceRequest.getPlaceId()) || !this.zzb.equals(fetchPlaceRequest.getPlaceFields()) || ((autocompleteSessionToken = this.zzc) != null ? !autocompleteSessionToken.equals(fetchPlaceRequest.getSessionToken()) : fetchPlaceRequest.getSessionToken() != null) || ((cancellationToken = this.zzd) != null ? !cancellationToken.equals(fetchPlaceRequest.getCancellationToken()) : fetchPlaceRequest.getCancellationToken() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzd;
    }

    public final List<Place.Field> getPlaceFields() {
        return this.zzb;
    }

    public final String getPlaceId() {
        return this.zza;
    }

    @Nullable
    public final AutocompleteSessionToken getSessionToken() {
        return this.zzc;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode()) * 1000003;
        AutocompleteSessionToken autocompleteSessionToken = this.zzc;
        int i12 = 0;
        if (autocompleteSessionToken == null) {
            i11 = 0;
        } else {
            i11 = autocompleteSessionToken.hashCode();
        }
        int i13 = (hashCode ^ i11) * 1000003;
        CancellationToken cancellationToken = this.zzd;
        if (cancellationToken != null) {
            i12 = cancellationToken.hashCode();
        }
        return i13 ^ i12;
    }

    public final String toString() {
        String str = this.zza;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String valueOf3 = String.valueOf(this.zzd);
        int length = str.length();
        int length2 = valueOf.length();
        StringBuilder sb2 = new StringBuilder(length + 76 + length2 + valueOf2.length() + valueOf3.length());
        sb2.append("FetchPlaceRequest{placeId=");
        sb2.append(str);
        sb2.append(", placeFields=");
        sb2.append(valueOf);
        sb2.append(", sessionToken=");
        sb2.append(valueOf2);
        sb2.append(", cancellationToken=");
        sb2.append(valueOf3);
        sb2.append("}");
        return sb2.toString();
    }
}
