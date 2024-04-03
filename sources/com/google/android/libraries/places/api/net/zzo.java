package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

final class zzo extends FindCurrentPlaceRequest {
    private final List<Place.Field> zza;
    private final CancellationToken zzb;

    public /* synthetic */ zzo(List list, CancellationToken cancellationToken, zzn zzn) {
        this.zza = list;
        this.zzb = cancellationToken;
    }

    public final boolean equals(Object obj) {
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FindCurrentPlaceRequest) {
            FindCurrentPlaceRequest findCurrentPlaceRequest = (FindCurrentPlaceRequest) obj;
            if (!this.zza.equals(findCurrentPlaceRequest.getPlaceFields()) || ((cancellationToken = this.zzb) != null ? !cancellationToken.equals(findCurrentPlaceRequest.getCancellationToken()) : findCurrentPlaceRequest.getCancellationToken() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzb;
    }

    public final List<Place.Field> getPlaceFields() {
        return this.zza;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        CancellationToken cancellationToken = this.zzb;
        if (cancellationToken == null) {
            i11 = 0;
        } else {
            i11 = cancellationToken.hashCode();
        }
        return hashCode ^ i11;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 57 + valueOf2.length());
        sb2.append("FindCurrentPlaceRequest{placeFields=");
        sb2.append(valueOf);
        sb2.append(", cancellationToken=");
        sb2.append(valueOf2);
        sb2.append("}");
        return sb2.toString();
    }
}
